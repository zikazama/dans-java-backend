package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @GetMapping("/list")
    public ResponseEntity<?> getJobList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dev6.dansmultipro.com/api/recruitment/positions.json";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getJobDetail(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dev6.dansmultipro.com/api/recruitment/positions/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
