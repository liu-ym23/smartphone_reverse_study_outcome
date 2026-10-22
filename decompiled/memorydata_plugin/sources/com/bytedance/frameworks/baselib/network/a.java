package com.bytedance.frameworks.baselib.network;

import com.bytedance.frameworks.baselib.network.http.e;
import com.bytedance.retrofit2.client.SsCall;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.b f2273a;

    public a(InputStream r3, SsCall r4, com.bytedance.frameworks.baselib.network.http.b r5) {
        super(r3, (SsCall) ZeusTransformUtils.wrapperContextForParams(r4, SsCall.class, "com.obric.memorydata.plugin"));
        this.f2273a = r5;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.e, java.io.InputStream
    public int read() {
        if (this.f2273a.d == null) goto L15;
        this.f2273a.d.readResponseBodyStart();
    L15:
        int r0 = super.read();     // Catch: Throwable -> L10
        if (this.f2273a.d == null) goto L9;
        this.f2273a.d.readResponseBodyEnd();
    L9:
        return r0;
    L10:
        th = move-exception;
        if (this.f2273a.d == null) goto L14;
        this.f2273a.d.readResponseBodyEnd();
    L14:
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.e, java.io.InputStream
    public int read(byte[] r2) {
        if (this.f2273a.d == null) goto L15;
        this.f2273a.d.readResponseBodyStart();
    L15:
        int r3 = super.read(r2);     // Catch: Throwable -> L10
        if (this.f2273a.d == null) goto L9;
        this.f2273a.d.readResponseBodyEnd();
    L9:
        return r3;
    L10:
        th = move-exception;
        if (this.f2273a.d == null) goto L14;
        this.f2273a.d.readResponseBodyEnd();
    L14:
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.e, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        if (this.f2273a.d == null) goto L15;
        this.f2273a.d.readResponseBodyStart();
    L15:
        int r5 = super.read(r2, r3, r4);     // Catch: Throwable -> L10
        if (this.f2273a.d == null) goto L9;
        this.f2273a.d.readResponseBodyEnd();
    L9:
        return r5;
    L10:
        th = move-exception;
        if (this.f2273a.d == null) goto L14;
        this.f2273a.d.readResponseBodyEnd();
    L14:
        throw th;
    }
}
