package com.bytedance.frameworks.baselib.network;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a extends lx5.c {
    public final BaseHttpRequestInfo c;

    public final int read() throws IOException {
        RetrofitMetrics r0 = this.c.metrics;
        if (r0 == null) goto L15;
        r0.readResponseBodyStart();
    L15:
        int r1 = super.read();     // Catch: Throwable -> L10
        RetrofitMetrics r2 = this.c.metrics;
        if (r2 == null) goto L9;
        r2.readResponseBodyEnd();
    L9:
        return r1;
    L10:
        th = move-exception;
        if (this.c.metrics == null) goto L14;
        this.c.metrics.readResponseBodyEnd();
    L14:
        throw th;
    }

    public final int read(byte[] r2) throws IOException {
        RetrofitMetrics r0 = this.c.metrics;
        if (r0 == null) goto L15;
        r0.readResponseBodyStart();
    L15:
        int r3 = super.read(r2);     // Catch: Throwable -> L10
        RetrofitMetrics r1 = this.c.metrics;
        if (r1 == null) goto L9;
        r1.readResponseBodyEnd();
    L9:
        return r3;
    L10:
        th = move-exception;
        if (this.c.metrics == null) goto L14;
        this.c.metrics.readResponseBodyEnd();
    L14:
        throw th;
    }

    public a(InputStream r1, SsCall r2, BaseHttpRequestInfo r3) {
        super(r1, r2);
        this.c = r3;
    }

    public final int read(byte[] r2, int r3, int r4) throws IOException {
        RetrofitMetrics r0 = this.c.metrics;
        if (r0 == null) goto L15;
        r0.readResponseBodyStart();
    L15:
        int r5 = super.read(r2, r3, r4);     // Catch: Throwable -> L10
        RetrofitMetrics r6 = this.c.metrics;
        if (r6 == null) goto L9;
        r6.readResponseBodyEnd();
    L9:
        return r5;
    L10:
        th = move-exception;
        if (this.c.metrics == null) goto L14;
        this.c.metrics.readResponseBodyEnd();
    L14:
        throw th;
    }
}
