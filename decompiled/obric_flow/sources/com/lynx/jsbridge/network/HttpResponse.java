package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JavaOnlyMap f9930c;
    public final byte[] d;
    public final JavaOnlyMap e;

    public HttpResponse() {
        this.f9928a = 200;
        this.f9929b = "OK";
        this.f9930c = new JavaOnlyMap();
        this.d = new byte[0];
        this.e = new JavaOnlyMap();
    }

    @CalledByNative
    public JavaOnlyMap getCustomInfo() {
        return this.e;
    }

    @CalledByNative
    public byte[] getHttpBody() {
        return this.d;
    }

    @CalledByNative
    public JavaOnlyMap getHttpHeaders() {
        return this.f9930c;
    }

    @CalledByNative
    public int getStatusCode() {
        return this.f9928a;
    }

    @CalledByNative
    public String getStatusText() {
        return this.f9929b;
    }

    @CalledByNative
    public String getUrl() {
        return "";
    }
}
