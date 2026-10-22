package com.ss.android.lark.monitor;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x extends ForwardingSource {
    public final /* synthetic */ OkHttpMonitorInterceptor.c a;

    public final void close() throws IOException {
        super.close();
        OkHttpMonitorInterceptor.c r0 = this.a;
        OkHttpMonitorInterceptor.b r1 = r0.d;
        if (r1 == null) goto L8;
        long r4 = r0.c;
        OkHttpMonitorInterceptor.a r2 = (OkHttpMonitorInterceptor.a) r1;
        LarkMetrics r3 = LarkMetrics.a.a;
        String r5 = r2.a;
        long r6 = r2.b;
        com.ss.android.lark.monitor.traffic.j r7 = r3.f;
        if (r7 == null) goto L9;
        r7.b(r5, r4, r6);
        return;
    L9:
        return;
    }

    public x(OkHttpMonitorInterceptor.c r1, BufferedSource r2) {
        this.a = r1;
        super(r2);
    }

    public final long read(Buffer r3, long r4) throws IOException {
        long r5 = super.read(r3, r4);
        if (r5 <= 0) goto L5;
        this.a.c += r5;
    L5:
        return r5;
    }
}
