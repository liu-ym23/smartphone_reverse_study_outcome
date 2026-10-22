package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class HttpResponse {
    public int a;
    public String b;
    public String c;
    public final JavaOnlyMap d;
    public byte[] e;
    public final JavaOnlyMap f;

    public HttpResponse() {
        this.a = 200;
        this.b = "OK";
        this.c = NameKeys.UnloadStrategy_No_Strategy;
        this.d = new JavaOnlyMap();
        this.e = new byte[0];
        this.f = new JavaOnlyMap();
    }

    public JavaOnlyMap getCustomInfo() {
        return this.f;
    }

    public byte[] getHttpBody() {
        return this.e;
    }

    public JavaOnlyMap getHttpHeaders() {
        return this.d;
    }

    public int getStatusCode() {
        return this.a;
    }

    public String getStatusText() {
        return this.b;
    }

    public String getUrl() {
        return this.c;
    }
}
