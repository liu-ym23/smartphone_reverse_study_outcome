package kotlinx.coroutines;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0002\b#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE_MS", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "enqueue", "task", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", LocationMonitorConst.TIMEOUT, "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ap extends bh implements Runnable {
    private static volatile Thread _thread;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ap f17219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f17220b = 0;
    private static volatile int debugStatus;

    static {
        ap r0 = new ap();
        f17219a = r0;
        bg.a((bg) ZeusTransformUtils.preCheckCast(r0, bg.class, "com.obric.memorydata.plugin"), false, 1, null);
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        Long r2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f17220b = r1.toNanos(r2.longValue());
        return;
    L5:
        r2 = 1000L;
        goto L6
    }

    private ap() {
    }

    private final boolean l() {
        if (debugStatus != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean m() {
        int r1 = debugStatus;
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    private final void n() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    private final synchronized Thread o() {
        monitor-enter(this);
        Thread r0 = _thread;     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new Thread((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L8
        _thread = r0;     // Catch: Throwable -> L8
        r0.setContextClassLoader(getClass().getClassLoader());     // Catch: Throwable -> L8
        r0.setDaemon(true);     // Catch: Throwable -> L8
        r0.start();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private final synchronized boolean p() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (m() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        debugStatus = 1;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    private final synchronized void q() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (m() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        debugStatus = 3;     // Catch: Throwable -> L11
        j();     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L11
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // kotlinx.coroutines.bi
    public Thread a() {
        Thread r0 = _thread;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return o();
    }

    @Override // kotlinx.coroutines.bh, kotlinx.coroutines.at
    public bc a(long r3, Runnable r5, CoroutineContext r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        return a(r3, r7);
    }

    @Override // kotlinx.coroutines.bi
    public void a(long r1, bh.c r3) {
        n();
    }

    @Override // kotlinx.coroutines.bh
    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (l() == false) goto L5;
        n();
    L5:
        super.a(r4);
    }

    @Override // kotlinx.coroutines.bh, kotlinx.coroutines.bg
    public void b() {
        debugStatus = 4;
        super.b();
    }

    @Override // java.lang.Runnable
    public void run() {
        cx.f17302a.a((bg) ZeusTransformUtils.preCheckCast(this, bg.class, "com.obric.memorydata.plugin"));
        b r0 = c.a();
        if (r0 == null) goto L63;
        r0.d();
    L63:
    L55:
        th = move-exception;
        _thread = null;
        q();
        b r1 = c.a();
        if (r1 == null) goto L60;
        r1.e();
    L60:
        if (d() == true) goto L62;
        a();
    L62:
        throw th;
    L7:
        if (p() == true) goto L15;
        _thread = null;
        q();
        b r2 = c.a();
        if (r2 == null) goto L12;
        r2.e();
    L12:
        if (d() == true) goto L73;
        a();
        return;
    L73:
        return;
    L15:
        long r3 = Long.MAX_VALUE;
    L16:
        Thread.interrupted();     // Catch: Throwable -> L55
        long r5 = c();     // Catch: Throwable -> L55
        if (r5 != Long.MAX_VALUE) goto L36;
        b r7 = c.a();     // Catch: Throwable -> L55
        if (r7 == null) goto L21;
        long r10 = r7.a();     // Catch: Throwable -> L55
    L23:
        if (r3 == Long.MAX_VALUE) goto L25;
    L26:
        long r11 = r3 - r10;
        if (r11 <= 0) goto L28;
        r5 = RangesKt.coerceAtMost(r5, r11);     // Catch: Throwable -> L55
    L38:
        if (r5 <= 0) goto L16;
        if (m() == true) goto L41;
        b r8 = c.a();     // Catch: Throwable -> L55
        if (r8 == null) goto L51;
        r8.a(this, r5);     // Catch: Throwable -> L55
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L55
    L52:
        if (r9 != null) goto L16;
        LockSupport.parkNanos(this, r5);     // Catch: Throwable -> L55
        goto L16
    L51:
        r9 = null;
        goto L52
    L41:
        _thread = null;
        q();
        b r4 = c.a();
        if (r4 == null) goto L45;
        r4.e();
    L45:
        if (d() == true) goto L75;
        a();
        return;
    L75:
        return;
    L28:
        _thread = null;
        q();
        b r6 = c.a();
        if (r6 == null) goto L32;
        r6.e();
    L32:
        if (d() == true) goto L74;
        a();
        return;
    L74:
        return;
    L25:
        r3 = f17220b + r10;
        goto L26
    L21:
        r10 = System.nanoTime();     // Catch: Throwable -> L55
        goto L23
    L36:
        r3 = Long.MAX_VALUE;
        goto L38
    }
}
