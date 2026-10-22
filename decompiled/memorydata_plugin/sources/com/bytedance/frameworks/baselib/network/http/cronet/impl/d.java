package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
class d extends a {
    private HttpURLConnection e;

    public d(Request r1) {
        super(r1);
        this.e = null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public int a(IOException r3) {
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        return -1;
    L10:
        return h.a(this.e);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public IOException a(Exception r4) {
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(r4.getClass().getName()) == false) goto L5;
        int r0 = h.a(this.e);
    L7:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r4.getClass().getName()) == false) goto L9;
    L10:
        r0 = h.a(this.e);
    L12:
        return new CronetIOException(r4, this.g, r0);
    L9:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r4.getClass().getName()) == false) goto L12;
    L5:
        r0 = 0;
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.a
    void a(HttpURLConnection r1) {
        this.e = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.a
    HttpURLConnection b() {
        return this.e;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        c(this.e);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.a, com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r8) {
        super.setThrottleNetSpeed(r8);
        if (this.e != null) goto L16;
    L14:
        return true;
    L16:
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.f.d() == false) goto L9;
        com.bytedance.frameworks.baselib.network.utils.a.a(this.e).call("configureConnection", new Class[]{String.class, Object[].class}, new Object[]{"setThrottleNetSpeed", new Object[]{Long.valueOf(r8)}});     // Catch: Throwable -> L11
    L15:
        goto L14
    L9:
        com.bytedance.frameworks.baselib.network.utils.a.a(this.e).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r8)});     // Catch: Throwable -> L11
        goto L15
    }
}
