package com.bytedance.apm6.service.http;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequest {
    public byte[] data;
    public Map<String, String> headerMap;
    public String url;

    public HttpRequest(String r10, Map<String, String> r11) {
        this.url = r10;
        this.headerMap = r11;
    }

    public HttpRequest(String r10, Map<String, String> r11, byte[] r12) {
        this.url = r10;
        this.headerMap = r11;
        this.data = r12;
    }
}
