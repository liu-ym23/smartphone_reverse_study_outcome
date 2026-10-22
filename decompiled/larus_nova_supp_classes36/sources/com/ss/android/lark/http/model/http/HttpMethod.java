package com.ss.android.lark.http.model.http;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum HttpMethod extends Enum<HttpMethod> {
    public static final HttpMethod DELETE = null;
    public static final HttpMethod GET = null;
    public static final HttpMethod HEAD = null;
    public static final HttpMethod OPTIONS = null;
    public static final HttpMethod PATCH = null;
    public static final HttpMethod POST = null;
    public static final HttpMethod PUT = null;
    public static final HttpMethod TRACE = null;
    public static final /* synthetic */ HttpMethod[] a = null;
    private final String value;

    static {
        HttpMethod r0 = new HttpMethod("GET", 0, "GET");
        GET = r0;
        HttpMethod r1 = new HttpMethod("POST", 1, "POST");
        POST = r1;
        HttpMethod r3 = new HttpMethod("PUT", 2, "PUT");
        PUT = r3;
        HttpMethod r5 = new HttpMethod("DELETE", 3, "DELETE");
        DELETE = r5;
        HttpMethod r7 = new HttpMethod("HEAD", 4, "HEAD");
        HEAD = r7;
        HttpMethod r9 = new HttpMethod("PATCH", 5, "PATCH");
        PATCH = r9;
        HttpMethod r11 = new HttpMethod("OPTIONS", 6, "OPTIONS");
        OPTIONS = r11;
        HttpMethod r13 = new HttpMethod("TRACE", 7, "TRACE");
        TRACE = r13;
        a = new HttpMethod[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static HttpMethod valueOf(String r1) {
        return (HttpMethod) a.a(HttpMethod.class, r1);
    }

    public HttpMethod(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
