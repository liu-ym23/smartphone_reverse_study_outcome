package com.obric.audio.continuous_talk;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r0 {
    public static final r0 a = null;
    public static final AtomicLong b = null;
    public static volatile Function1<? super Long, Unit> c;
    public static final ExecutorService d = null;

    public r0() {
    }

    static {
        a = new r0();
        b = new AtomicLong(0);
        d = PThreadExecutorsUtils.newSingleThreadExecutor(new o0());
    }

    public final synchronized void a(final Function1<? super Long, Unit> r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "operation");     // Catch: Throwable -> L6
        final long r0 = b.incrementAndGet();     // Catch: Throwable -> L6
        c = r5;     // Catch: Throwable -> L6
        d.execute(new q0(r0, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(long r4) {
        monitor-enter(this);
        final long r0 = b.get();     // Catch: Throwable -> L15
        if (r4 < r0) goto L8;
        monitor-exit(this);
        return;
    L8:
        final Function1<? super Long, Unit> r5 = c;     // Catch: Throwable -> L15
        if (r5 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        d.execute(new p0(r0, r5));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
