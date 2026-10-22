package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,134:1\n66#1,8:135\n66#1,8:143\n28#2,4:151\n28#2,4:156\n20#3:155\n20#3:160\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n48#1:135,8\n55#1:143,8\n79#1:151,4\n92#1:156,4\n79#1:155\n92#1:160\n*E\n"})
public final class q extends CoroutineDispatcher implements t0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10573k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineDispatcher f10574c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f10575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ t0 f10576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u<Runnable> f10577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f10578j;

    @Volatile
    private volatile int runningWorkers;

    private final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f10579c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ q f10580g;

        public a(q r10, Runnable r11) {
            this.f10580g = r10;
            this.f10579c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = 0;
        L16:
            this.f10579c.run();     // Catch: Throwable -> L5
        L7:
            Runnable r11 = q.d0(this.f10580g);
            if (r11 == null) goto L9;
            this.f10579c = r11;
            r10 = r10 + 1;
            if (r10 < 16) goto L16;
            if (q.c0(this.f10580g).isDispatchNeeded(this.f10580g) == false) goto L16;
            q.c0(this.f10580g).dispatch(this.f10580g, this);
            return;
        L9:
            return;
        L5:
            th = move-exception;
            kotlinx.coroutines.i0.a(EmptyCoroutineContext.INSTANCE, th);
            goto L7
        }
    }

    static {
        f10573k = AtomicIntegerFieldUpdater.newUpdater(q.class, "runningWorkers");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(CoroutineDispatcher r10, int r11) {
        this.f10574c = r10;
        this.f10575g = r11;
        if ((r10 instanceof t0) == false) goto L5;
        t0 r12 = (t0) r10;
    L6:
        if (r12 != null) goto L8;
        r12 = kotlinx.coroutines.q0.a();
    L8:
        this.f10576h = r12;
        this.f10577i = new u(false);
        this.f10578j = new Object();
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static final /* synthetic */ CoroutineDispatcher c0(q r10) {
        return r10.f10574c;
    }

    public static final /* synthetic */ Runnable d0(q r10) {
        return r10.e0();
    }

    private final Runnable e0() {
    L2:
        Runnable r10 = this.f10577i.d();
        if (r10 != null) goto L17;
        Object r11 = this.f10578j;
        monitor-enter(r11);
        AtomicIntegerFieldUpdater r12 = f10573k;     // Catch: Throwable -> L14
        r12.decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.f10577i.c() == 0) goto L9;
        r12.incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r11);
        goto L2
    L9:
        monitor-exit(r11);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r10;
    }

    private final boolean f0() {
        Object r10 = this.f10578j;
        monitor-enter(r10);
        AtomicIntegerFieldUpdater r11 = f10573k;     // Catch: Throwable -> L11
        if (r11.get(this) < this.f10575g) goto L9;
        boolean r12 = false;
    L7:
        monitor-exit(r10);
        return r12;
    L9:
        r11.incrementAndGet(this);     // Catch: Throwable -> L11
        r12 = true;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.t0
    public b1 B(long r10, Runnable r11, CoroutineContext r12) {
        return this.f10576h.B(r10, r11, r12);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r10, Runnable r11) {
        this.f10577i.a(r11);
        if (f10573k.get(this) < this.f10575g) goto L5;
        return;
    L5:
        if (f0() == false) goto L12;
        Runnable r12 = e0();
        if (r12 == null) goto L13;
        a r13 = new a(this, r12);
        this.f10574c.dispatch(this, r13);
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext r10, Runnable r11) {
        this.f10577i.a(r11);
        if (f10573k.get(this) < this.f10575g) goto L5;
        return;
    L5:
        if (f0() == false) goto L12;
        Runnable r12 = e0();
        if (r12 == null) goto L13;
        a r13 = new a(this, r12);
        this.f10574c.dispatchYield(this, r13);
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.t0
    public void k(long r10, kotlinx.coroutines.n<? super Unit> r11) {
        this.f10576h.k(r10, r11);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r10) {
        r.a(r10);
        if (r10 < this.f10575g) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r10);
    }
}
