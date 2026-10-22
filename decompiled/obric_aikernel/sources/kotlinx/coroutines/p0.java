package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class p0 extends g1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final p0 f10623l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f10624m = 0;

    static {
        p0 r10 = new p0();
        f10623l = r10;
        f1.i0(r10, false, 1, null);
        TimeUnit r11 = TimeUnit.MILLISECONDS;
        Long r12 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f10624m = r11.toNanos(r12.longValue());
        return;
    L5:
        r12 = 1000L;
        goto L6
    }

    private p0() {
    }

    private final synchronized void E0() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (H0() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        debugStatus = 3;     // Catch: Throwable -> L11
        y0();     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L11
        notifyAll();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private final synchronized Thread F0() {
        monitor-enter(this);
        Thread r10 = _thread;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        r10 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L8
        _thread = r10;     // Catch: Throwable -> L8
        r10.setDaemon(true);     // Catch: Throwable -> L8
        r10.start();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    private final boolean G0() {
        if (debugStatus != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean H0() {
        int r10 = debugStatus;
        if (r10 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 3) goto L8;
        return false;
    }

    private final synchronized boolean I0() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (H0() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        debugStatus = 1;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        notifyAll();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    private final void J0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.g1, kotlinx.coroutines.t0
    public b1 B(long r10, Runnable r11, CoroutineContext r12) {
        return B0(r10, r11);
    }

    @Override // kotlinx.coroutines.h1
    protected Thread o0() {
        Thread r10 = _thread;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return F0();
    }

    @Override // kotlinx.coroutines.h1
    protected void p0(long r10, g1.c r11) {
        J0();
    }

    @Override // java.lang.Runnable
    public void run() {
        s2.f10631a.d(this);
        c.a();
    L34:
        th = move-exception;
        _thread = null;
        E0();
        c.a();
        if (w0() == true) goto L38;
        o0();
    L38:
        throw th;
    L4:
        if (I0() == true) goto L9;
        _thread = null;
        E0();
        c.a();
        if (w0() == true) goto L47;
        o0();
        return;
    L47:
        return;
    L9:
        long r10 = Long.MAX_VALUE;
    L10:
        Thread.interrupted();     // Catch: Throwable -> L34
        long r11 = l0();     // Catch: Throwable -> L34
        if (r11 != Long.MAX_VALUE) goto L23;
        c.a();     // Catch: Throwable -> L34
        long r12 = System.nanoTime();     // Catch: Throwable -> L34
        if (r10 == Long.MAX_VALUE) goto L15;
    L16:
        long r13 = r10 - r12;
        if (r13 <= 0) goto L18;
        r11 = RangesKt.coerceAtMost(r11, r13);     // Catch: Throwable -> L34
    L25:
        if (r11 <= 0) goto L10;
        if (H0() == true) goto L28;
        c.a();     // Catch: Throwable -> L34
        LockSupport.parkNanos(this, r11);     // Catch: Throwable -> L34
        goto L10
    L28:
        _thread = null;
        E0();
        c.a();
        if (w0() == true) goto L49;
        o0();
        return;
    L49:
        return;
    L18:
        _thread = null;
        E0();
        c.a();
        if (w0() == true) goto L48;
        o0();
        return;
    L48:
        return;
    L15:
        r10 = f10624m + r12;
        goto L16
    L23:
        r10 = Long.MAX_VALUE;
        goto L25
    }

    @Override // kotlinx.coroutines.g1, kotlinx.coroutines.f1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.g1
    public void u0(Runnable r10) {
        if (G0() == false) goto L5;
        J0();
    L5:
        super.u0(r10);
    }
}
