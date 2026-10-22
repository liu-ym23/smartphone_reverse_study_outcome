package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f9927c;
    public JavaOnlyMap d;
    public JavaOnlyMap e;

    public HttpRequest() {
        this.f9925a = "";
        this.f9926b = "";
        this.f9927c = null;
        this.d = new JavaOnlyMap();
        this.e = new JavaOnlyMap();
    }

    @CalledByNative
    public static HttpRequest CreateHttpRequest(String r5, String r10, String r11, byte[] r12, JavaOnlyMap r13, JavaOnlyMap r14) {
        HttpRequest r15 = new HttpRequest();
        r15.f9925a = r5;
        r15.f9926b = r10;
        r15.f9927c = r12;
        r15.d = r13;
        r15.e = r14;
        return r15;
    }
}
