package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Sink;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements Sink {
    public final /* synthetic */ c a;

    public final void close() {
        if (this.a.e.compareAndSet(false, true) == true) goto L26;
        return;
    L26:
        c r0 = this.a;     // Catch: Throwable -> L12 IOException -> L14
        PolarisFileOutputStreamWrapper r1 = r0.b;     // Catch: Throwable -> L12 IOException -> L14
        monitor-enter(r1);     // Catch: Throwable -> L12 IOException -> L14
        r0.b.flush();     // Catch: Throwable -> L9
        r0.b.close();     // Catch: Throwable -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L12 IOException -> L14
    L21:
        this.a.c.countDown();
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = move-exception;
        AtomicReference<Throwable> r3 = this.a.d;     // Catch: Throwable -> L12
    L17:
        if (r3.compareAndSet(null, e) == true) goto L21;
        if (r3.get() == null) goto L17;
    L12:
        th = move-exception;
        this.a.c.countDown();
        throw th;
    }

    public final void flush() {
        if (this.a.e.get() == true) goto L12;
        c r0 = this.a;
        PolarisFileOutputStreamWrapper r1 = r0.b;
        monitor-enter(r1);
        r0.b.flush();     // Catch: Throwable -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r1);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final j0 timeout() {
        return j0.d;
    }

    public d(c r1) {
        this.a = r1;
    }

    public final void write(Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        byte[] r4 = r2.readByteArray(r3);
        c r5 = this.a;
        PolarisFileOutputStreamWrapper r6 = r5.b;
        monitor-enter(r6);
        r5.b.write(r4);     // Catch: Throwable -> L7
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r6);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
