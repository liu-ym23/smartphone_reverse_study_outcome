package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.Source;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements Source {
    public final /* synthetic */ c a;

    public final void close() {
        c r0 = this.a;
        r0.getClass();
        FileInputStream r2 = r0.f;     // Catch: Throwable -> L7 IOException -> L12
        if (r2 == null) goto L10;
        r2.close();     // Catch: Throwable -> L7 IOException -> L12
    L7:
        th = move-exception;
        r0.f = null;
        throw th;
    L10:
        r0.f = null;
    }

    public final j0 timeout() {
        return j0.d;
    }

    public e(c r1) {
        this.a = r1;
    }

    public final long read(Buffer r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        if (r6 != 0) goto L5;
        return 0;
    L5:
        c r1 = this.a;
        r1.getClass();
        r1.c.await();     // Catch: InterruptedException -> L24
        Throwable r2 = this.a.d.get();
        if (r2 != null) goto L23;
        PolarisFileInputStreamWrapper r3 = this.a.f;
        if (r3 != null) goto L12;
        r3 = new PolarisFileInputStreamWrapper(this.a.a);
        this.a.f = r3;
    L12:
        byte[] r7 = new byte[(int) RangesKt.coerceAtMost(r6, 2147483647L)];
        int r8 = r3.read(r7);     // Catch: IOException -> L19
        if (r8 <= 0) goto L31;
        r5.write(r7, 0, r8);     // Catch: IOException -> L19
        return r8;
    L31:
        return -1;
    L19:
        e = move-exception;
        throw new IllegalStateException("Failed to read request body", e);
    L23:
        throw new IllegalStateException("Failed to read request body", r2);
    L24:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        throw new IllegalStateException("Failed to read request body", e);
    }
}
