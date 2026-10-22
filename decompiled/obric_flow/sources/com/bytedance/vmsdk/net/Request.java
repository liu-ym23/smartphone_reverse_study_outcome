package com.bytedance.vmsdk.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Request {
    static final String defaultMethod = "GET";
    InputStream body;
    Map<String, String> headers;
    String method;
    String url;

    public Request(String r5, JSONObject r10, byte[] r11) {
        this.url = r5;     // Catch: JSONException -> L6
        if (r10.has("method") == false) goto L8;
        String r12 = r10.getString("method");     // Catch: JSONException -> L6
    L9:
        this.method = r12;     // Catch: JSONException -> L6
        if (r11 == null) goto L16;
        if (r11.length == 0) goto L16;
        this.body = new ByteArrayInputStream(r11);     // Catch: JSONException -> L6
    L20:
        JSONObject r13 = (JSONObject) r10.opt("headers");     // Catch: JSONException -> L6
        this.headers = new HashMap();     // Catch: JSONException -> L6
        if (r13 == null) goto L32;
        Iterator<String> r14 = r13.keys();     // Catch: JSONException -> L6
    L23:
        if (r14.hasNext() == false) goto L33;
        String r15 = r14.next();     // Catch: JSONException -> L6
        this.headers.put(r15, r13.getString(r15));     // Catch: JSONException -> L6
        goto L23
    L33:
        return;
    L32:
        return;
    L16:
        if (r10.has("body") == false) goto L18;
        ByteArrayInputStream r16 = new ByteArrayInputStream(r10.getString("body").getBytes());     // Catch: JSONException -> L6
    L19:
        this.body = r16;     // Catch: JSONException -> L6
        goto L20
    L18:
        r16 = null;
        goto L19
    L8:
        r12 = defaultMethod;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public InputStream getBody() {
        return this.body;
    }

    public String getBodyString() {
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();
        byte[] r10 = new byte[4096];
    L13:
        int r11 = this.body.read(r10, 0, 4096);     // Catch: IOException -> L6
        if (r11 <= 0) goto L8;
        r5.write(r10, 0, r11);     // Catch: IOException -> L6
    L8:
        if (r11 > 0) goto L13;
        return r5.toString();
    L6:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }
}
