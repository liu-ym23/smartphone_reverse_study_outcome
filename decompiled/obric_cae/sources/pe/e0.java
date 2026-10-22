package pe;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends t0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e0 f10005t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f10006u = 0;

    static {
        e0 r8 = new e0();
        f10005t = r8;
        r8.u0(false);
        TimeUnit r10 = TimeUnit.MILLISECONDS;
        Long r11 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f10006u = r10.toNanos(r11.longValue());
        return;
    L5:
        r11 = 1000L;
        goto L6
    }

    @Override // pe.t0
    public final void A0(Runnable r8) {
        if (debugStatus != 4) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L10;
        super.A0(r8);
        return;
    L10:
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    L5:
        r10 = false;
        goto L6
    }

    public final synchronized void E0() {
        monitor-enter(this);
        int r8 = debugStatus;     // Catch: Throwable -> L16
        if (r8 == 2) goto L9;
        if (r8 == 3) goto L9;
        boolean r10 = false;
    L10:
        if (r10 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        debugStatus = 3;     // Catch: Throwable -> L16
        t0.f10066q.set(this, null);     // Catch: Throwable -> L16
        t0.f10067r.set(this, null);     // Catch: Throwable -> L16
        notifyAll();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        r10 = true;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // pe.t0, pe.i0
    public final o0 V(long r8, Runnable r10, ae.f r11) {
        b9.a r12 = v0.f10077a;
        long r13 = 0;
        if (r8 <= 0) goto L10;
        if (r8 < 9223372036854L) goto L8;
        r13 = Long.MAX_VALUE;
        goto L10
    L8:
        r13 = BwdlDropUtils.DROP_SHOW_MEGABYTES * r8;
    L10:
        if (r13 >= 4611686018427387903L) goto L13;
        long r14 = System.nanoTime();
        t0.b r15 = new t0.b(r10, r13 + r14);
        D0(r14, r15);
        return r15;
    L13:
        return n1.f10050a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u1.f10076a.set(this);
        monitor-enter(this);     // Catch: Throwable -> L53
        int r8 = debugStatus;     // Catch: Throwable -> L55
        if (r8 == 2) goto L10;
        if (r8 == 3) goto L10;
        boolean r10 = false;
    L11:
        if (r10 == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L53
        boolean r11 = false;
    L17:
        if (r11 == true) goto L22;
        _thread = null;
        E0();
        if (C0() == true) goto L71;
        x0();
        return;
    L71:
        return;
    L22:
        long r12 = Long.MAX_VALUE;
    L23:
        Thread.interrupted();     // Catch: Throwable -> L53
        long r13 = v0();     // Catch: Throwable -> L53
        if (r13 != Long.MAX_VALUE) goto L38;
        long r15 = System.nanoTime();     // Catch: Throwable -> L53
        if (r12 == Long.MAX_VALUE) goto L28;
    L29:
        long r16 = r12 - r15;
        if (r16 <= 0) goto L31;
        if (r13 <= r16) goto L40;
        r13 = r16;
    L40:
        if (r13 <= 0) goto L23;
        int r14 = debugStatus;     // Catch: Throwable -> L53
        if (r14 == 2) goto L46;
        if (r14 == 3) goto L46;
        boolean r17 = false;
    L47:
        if (r17 == true) goto L48;
        LockSupport.parkNanos(this, r13);     // Catch: Throwable -> L53
        goto L23
    L48:
        _thread = null;
        E0();
        if (C0() == true) goto L73;
        x0();
        return;
    L73:
        return;
    L46:
        r17 = true;
        goto L47
    L31:
        _thread = null;
        E0();
        if (C0() == true) goto L72;
        x0();
        return;
    L72:
        return;
    L28:
        r12 = f10006u + r15;
        goto L29
    L38:
        r12 = Long.MAX_VALUE;
        goto L40
    L14:
        debugStatus = 1;     // Catch: Throwable -> L55
        notifyAll();     // Catch: Throwable -> L55
        monitor-exit(this);     // Catch: Throwable -> L53
        r11 = true;
        goto L17
    L10:
        r10 = true;
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        _thread = null;
        E0();
        if (C0() == true) goto L61;
        x0();
    L61:
        throw th;
    }

    @Override // pe.t0, pe.s0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // pe.u0
    public final Thread x0() {
        Thread r8 = _thread;
        if (r8 != null) goto L13;
        monitor-enter(this);
        r8 = _thread;     // Catch: Throwable -> L10
        if (r8 != null) goto L8;
        r8 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L10
        _thread = r8;     // Catch: Throwable -> L10
        r8.setDaemon(true);     // Catch: Throwable -> L10
        r8.start();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L10:
        th = move-exception;
        throw th;
    L13:
        return r8;
    }

    @Override // pe.u0
    public final void y0(long r8, t0.c r10) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }
}
