package com.bytedance.badger.collect.impl.model;

import android.util.Pair;
import com.bytedance.badger.collect.impl.constants.ErrorPair;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class TTResponse {
    private final String body;
    private Throwable exception;
    private final Map<String, String> headers;
    private String logId;
    private final int statusCode;
    private final String url;

    public static TTResponse failed() {
        Pair<Integer, String> r1 = ErrorPair.ERROR_NETWORK_REQUEST;
        return new TTResponse("", ((Integer) r1.first).intValue(), null, (String) r1.second);
    }

    public String toString() {
        return "DeviceResponse{\n body=" + this.body + "\n headers=" + this.headers + "\n code=" + this.statusCode + "\n logId=" + this.logId + "\n url='" + this.url + "'}";
    }

    public String getBody() {
        return this.body;
    }

    public Throwable getException() {
        return this.exception;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getLogId() {
        return this.logId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public static TTResponse failed(Throwable r7) {
        if (r7 == null) goto L4;
        String r0 = r7.toString();
    L5:
        int r3 = ((Integer) ErrorPair.ERROR_NETWORK_REQUEST.first).intValue();
        return new TTResponse("", r3, null, r0, r7);
    L4:
        r0 = (String) ErrorPair.ERROR_NETWORK_REQUEST.second;
        goto L5
    }

    public void setLogId(String r1) {
        this.logId = r1;
    }

    public static TTResponse failed(TTRequest r4) {
        String r5 = r4.getBaseUrl();
        Pair<Integer, String> r1 = ErrorPair.ERROR_NETWORK_REQUEST;
        return new TTResponse(r5, ((Integer) r1.first).intValue(), null, (String) r1.second);
    }

    public static TTResponse failed(Pair<Integer, String> r4) {
        return new TTResponse("", ((Integer) r4.first).intValue(), null, (String) r4.second);
    }

    public TTResponse(String r1, int r2, Map<String, String> r3, String r4) {
        this.url = r1;
        this.statusCode = r2;
        if (r3 != null) goto L5;
        this.headers = new HashMap();
    L6:
        this.body = r4;
        return;
    L5:
        this.headers = Collections.unmodifiableMap(new HashMap(r3));
        goto L6
    }

    public TTResponse(String r1, int r2, Map<String, String> r3, String r4, Throwable r5) {
        this.url = r1;
        this.statusCode = r2;
        if (r3 != null) goto L5;
        this.headers = new HashMap();
    L6:
        this.body = r4;
        this.exception = r5;
        return;
    L5:
        this.headers = Collections.unmodifiableMap(new HashMap(r3));
        goto L6
    }
}
