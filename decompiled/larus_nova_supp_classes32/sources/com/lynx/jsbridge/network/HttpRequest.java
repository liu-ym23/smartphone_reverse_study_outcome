package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class HttpRequest {
    public String a;
    public String b;
    public byte[] c;
    public JavaOnlyMap d;
    public JavaOnlyMap e;

    public HttpRequest() {
        this.a = NameKeys.UnloadStrategy_No_Strategy;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
        this.c = null;
        this.d = new JavaOnlyMap();
        this.e = new JavaOnlyMap();
    }

    public static HttpRequest CreateHttpRequest(String r0, String r1, String r2, byte[] r3, JavaOnlyMap r4, JavaOnlyMap r5) {
        HttpRequest r6 = new HttpRequest();
        r6.a = r0;
        r6.b = r1;
        r6.c = r3;
        r6.d = r4;
        r6.e = r5;
        return r6;
    }
}
