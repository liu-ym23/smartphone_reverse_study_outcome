package com.bytedance.apm6.service.http;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequest {
    public byte[] data;
    public Map<String, String> headerMap;
    public String url;

    public HttpRequest(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.url = r3;
        this.headerMap = r5;
    }

    public HttpRequest(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.url = r3;
        this.headerMap = r6;
        this.data = r5;
    }
}
