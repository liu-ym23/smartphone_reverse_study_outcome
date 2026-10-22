package com.ss.ugc.live.sdk.msg.network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum HttpMethod extends Enum<HttpMethod> {
    public static final HttpMethod GET = null;
    public static final HttpMethod POST = null;
    public static final /* synthetic */ HttpMethod[] a = null;

    static {
        HttpMethod r0 = new HttpMethod("POST", 0);
        POST = r0;
        HttpMethod r1 = new HttpMethod("GET", 1);
        GET = r1;
        a = new HttpMethod[]{r0, r1};
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) a.clone();
    }

    public static HttpMethod valueOf(String r1) {
        return (HttpMethod) r27.a.a(HttpMethod.class, r1);
    }

    public HttpMethod(String r1, int r2) {
        super(r1, r2);
    }
}
