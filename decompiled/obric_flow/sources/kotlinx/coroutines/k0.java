package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends a1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k0 f18973h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f18974i = 0;

    static {
        k0 r5 = new k0();
        f18973h = r5;
        r5.L(false);
        TimeUnit r10 = TimeUnit.MILLISECONDS;
        Long r11 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f18974i = r10.toNanos(r11.longValue());
        return;
    L5:
        r11 = 1000L;
        goto L6
    }

    @Override // kotlinx.coroutines.b1
    public final Thread K() {
        Thread r5 = _thread;
        if (r5 != null) goto L15;
        monitor-enter(this);
        r5 = _thread;     // Catch: Throwable -> L9
        if (r5 != null) goto L11;
        r5 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L9
        _thread = r5;     // Catch: Throwable -> L9
        r5.setContextClassLoader(f18973h.getClass().getClassLoader());     // Catch: Throwable -> L9
        r5.setDaemon(true);     // Catch: Throwable -> L9
        r5.start();     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    L9:
        th = move-exception;
        throw th;
    L15:
        return r5;
    }

    @Override // kotlinx.coroutines.b1
    public final void P(long r5, y0 r10) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.a1
    public final void Q(Runnable r5) {
        if (debugStatus == 4) goto L7;
        super.Q(r5);
        return;
    L7:
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void V() {
        monitor-enter(this);
        int r5 = debugStatus;     // Catch: Throwable -> L16
        if (r5 == 2) goto L9;
        if (r5 == 3) goto L9;
        boolean r10 = false;
    L10:
        if (r10 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        debugStatus = 3;     // Catch: Throwable -> L16
        a1.e.set(this, null);     // Catch: Throwable -> L16
        a1.f.set(this, null);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L16
        notifyAll();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        r10 = true;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.a1, kotlinx.coroutines.o0
    public final t0 e(long r5, Runnable r10, CoroutineContext r11) {
        long r12 = j0.d(r5);
        if (r12 >= DurationKt.MAX_MILLIS) goto L6;
        long r13 = System.nanoTime();
        x0 r14 = new x0(r12 + r13, r10);
        U(r13, r14);
        return r14;
    L6:
        return v1.f19027a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b2.f18773a.set(this);
        monitor-enter(this);     // Catch: Throwable -> L26
        int r5 = debugStatus;     // Catch: Throwable -> L51
        if (r5 == 2) goto L10;
        if (r5 == 3) goto L10;
        boolean r10 = false;
    L11:
        if (r10 == false) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L26
        _thread = null;
        V();
        if (T() == true) goto L65;
        K();
        return;
    L65:
        return;
    L17:
        debugStatus = 1;     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L51
        notifyAll();     // Catch: Throwable -> L51
        monitor-exit(this);     // Catch: Throwable -> L26
        long r11 = Long.MAX_VALUE;
        long r12 = Long.MAX_VALUE;
    L20:
        Thread.interrupted();     // Catch: Throwable -> L26
        long r13 = N();     // Catch: Throwable -> L26
        if (r13 != r11) goto L35;
        long r15 = System.nanoTime();     // Catch: Throwable -> L26
        if (r12 == r11) goto L25;
    L28:
        long r14 = r12 - r15;
        if (r14 <= 0) goto L30;
        r13 = RangesKt.coerceAtMost(r13, r14);     // Catch: Throwable -> L26
    L37:
        if (r13 <= 0) goto L50;
        int r16 = debugStatus;     // Catch: Throwable -> L26
        if (r16 == 2) goto L43;
        if (r16 == 3) goto L43;
        boolean r17 = false;
    L44:
        if (r17 == true) goto L45;
        LockSupport.parkNanos(this, r13);     // Catch: Throwable -> L26
        goto L50
    L45:
        _thread = null;
        V();
        if (T() == true) goto L67;
        K();
        return;
    L67:
        return;
    L43:
        r17 = true;
    L50:
        r11 = Long.MAX_VALUE;
        goto L20
    L30:
        _thread = null;
        V();
        if (T() == true) goto L66;
        K();
        return;
    L66:
        return;
    L25:
        r12 = f18974i + r15;
        goto L28
    L35:
        r12 = Long.MAX_VALUE;
        goto L37
    L10:
        r10 = true;
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        _thread = null;
        V();
        if (T() == true) goto L57;
        K();
    L57:
        throw th;
    }

    @Override // kotlinx.coroutines.a1, kotlinx.coroutines.b1
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        return "DefaultExecutor";
    }
}
