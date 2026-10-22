package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
public abstract class g1 extends h1 implements t0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10514i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10515j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10516k = null;

    @Volatile
    private volatile Object _delayed;

    @Volatile
    private volatile int _isCompleted;

    @Volatile
    private volatile Object _queue;

    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
    private final class a extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final n<Unit> f10517h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ g1 f10518i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(g1 r10, long r11, n<? super Unit> r12) {
            this.f10518i = r10;
            super(r11);
            this.f10517h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10517h.q(this.f10518i, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.g1.c
        public String toString() {
            return super.toString() + this.f10517h;
        }
    }

    private static final class b extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Runnable f10519h;

        public b(long r10, Runnable r11) {
            super(r10);
            this.f10519h = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10519h.run();
        }

        @Override // kotlinx.coroutines.g1.c
        public String toString() {
            return super.toString() + this.f10519h;
        }
    }

    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    public static abstract class c implements Runnable, Comparable<c>, b1, kotlinx.coroutines.internal.o0 {
        private volatile Object _heap;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public long f10520c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f10521g;

        public c(long r10) {
            this.f10520c = r10;
            this.f10521g = -1;
        }

        @Override // kotlinx.coroutines.internal.o0
        public void a(kotlinx.coroutines.internal.n0<?> r10) {
            if (this._heap == j1.b()) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L10;
            this._heap = r10;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r11 = false;
            goto L6
        }

        @Override // kotlinx.coroutines.internal.o0
        public kotlinx.coroutines.internal.n0<?> c() {
            Object r10 = this._heap;
            if ((r10 instanceof kotlinx.coroutines.internal.n0) == true) goto L7;
            return null;
        L7:
            return (kotlinx.coroutines.internal.n0) r10;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(c r10) {
            return e(r10);
        }

        @Override // kotlinx.coroutines.internal.o0
        public void d(int r10) {
            this.f10521g = r10;
        }

        @Override // kotlinx.coroutines.b1
        public final void dispose() {
            monitor-enter(this);
            Object r10 = this._heap;     // Catch: Throwable -> L16
            if (r10 != j1.b()) goto L8;
            monitor-exit(this);
            return;
        L8:
            if ((r10 instanceof d) == false) goto L10;
            d r11 = (d) r10;     // Catch: Throwable -> L16
        L11:
            if (r11 == null) goto L13;
            r11.g(this);     // Catch: Throwable -> L16
        L13:
            this._heap = j1.b();     // Catch: Throwable -> L16
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(this);
            return;
        L10:
            r11 = null;
        L16:
            th = move-exception;
            throw th;
        }

        public int e(c r10) {
            long r11 = this.f10520c - r10.f10520c;
            if (r11 <= 0) goto L5;
            return 1;
        L5:
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        public final int f(long r10, d r11, g1 r12) {
            monitor-enter(this);
        L34:
            th = move-exception;
            throw th;
        L4:
            if (this._heap != j1.b()) goto L8;
            int r13 = 2;
        L6:
            monitor-exit(this);
            return r13;
        L8:
            monitor-enter(r11);     // Catch: Throwable -> L34
            c r14 = r11.b();     // Catch: Throwable -> L31
            if (g1.r0(r12) == false) goto L16;
            monitor-exit(r11);     // Catch: Throwable -> L34
            monitor-exit(this);
            return 1;
        L16:
            if (r14 != null) goto L18;
        L17:
            r11.f10522c = r10;     // Catch: Throwable -> L31
        L25:
            long r15 = this.f10520c;     // Catch: Throwable -> L31
            long r16 = r11.f10522c;     // Catch: Throwable -> L31
            if ((r15 - r16) >= 0) goto L28;
            this.f10520c = r16;     // Catch: Throwable -> L31
        L28:
            r11.a(this);     // Catch: Throwable -> L31
            monitor-exit(r11);     // Catch: Throwable -> L34
            r13 = 0;
            goto L6
        L18:
            long r17 = r14.f10520c;     // Catch: Throwable -> L31
            if ((r17 - r10) >= 0) goto L23;
            r10 = r17;
        L23:
            if ((r10 - r11.f10522c) <= 0) goto L25;
        L31:
            th = move-exception;
            throw th;     // Catch: Throwable -> L34
        }

        public final boolean g(long r10) {
            if ((r10 - this.f10520c) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.internal.o0
        public int getIndex() {
            return this.f10521g;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f10520c + ']';
        }
    }

    public static final class d extends kotlinx.coroutines.internal.n0<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public long f10522c;

        public d(long r10) {
            this.f10522c = r10;
        }
    }

    static {
        f10514i = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_queue");
        f10515j = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_delayed");
        f10516k = AtomicIntegerFieldUpdater.newUpdater(g1.class, "_isCompleted");
    }

    public g1() {
        this._isCompleted = 0;
    }

    private final int A0(long r10, c r11) {
        if (a() == false) goto L6;
        return 1;
    L6:
        AtomicReferenceFieldUpdater r12 = f10515j;
        d r13 = (d) r12.get(this);
        if (r13 != null) goto L10;
        r12.compareAndSet(this, null, new d(r10));
        Object r14 = r12.get(this);
        Intrinsics.checkNotNull(r14);
        r13 = (d) r14;
    L10:
        return r11.f(r10, r13, this);
    }

    private final void C0(boolean r10) {
        f10516k.set(this, r10 ? 1 : 0);
    }

    private final boolean D0(c r10) {
        d r11 = (d) f10515j.get(this);
        if (r11 == null) goto L5;
        c r12 = r11.e();
    L6:
        if (r12 != r10) goto L8;
        return true;
    L8:
        return false;
    L5:
        r12 = null;
        goto L6
    }

    private final boolean a() {
        if (f10516k.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ boolean r0(g1 r10) {
        return r10.a();
    }

    private final void s0() {
        if (n0.a() == true) goto L5;
    L9:
        AtomicReferenceFieldUpdater r10 = f10514i;
    L10:
        Object r11 = r10.get(this);
        if (r11 == null) goto L13;
        if ((r11 instanceof kotlinx.coroutines.internal.v) == true) goto L17;
        if (r11 == j1.a()) goto L21;
        kotlinx.coroutines.internal.v r12 = new kotlinx.coroutines.internal.v(8, true);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r12.a((Runnable) r11);
        if (f10514i.compareAndSet(this, r11, r12) == false) goto L10;
        return;
    L21:
        return;
    L17:
        ((kotlinx.coroutines.internal.v) r11).d();
        return;
    L13:
        if (f10514i.compareAndSet(this, null, j1.a()) == false) goto L10;
        return;
    L5:
        if (a() == true) goto L9;
        throw new AssertionError();
    }

    private final Runnable t0() {
        AtomicReferenceFieldUpdater r10 = f10514i;
    L3:
        Object r11 = r10.get(this);
        if (r11 == null) goto L5;
        if ((r11 instanceof kotlinx.coroutines.internal.v) == true) goto L8;
        if (r11 == j1.a()) goto L15;
        if (f10514i.compareAndSet(this, r11, null) == false) goto L3;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        return (Runnable) r11;
    L15:
        return null;
    L8:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.v r12 = (kotlinx.coroutines.internal.v) r11;
        Object r13 = r12.j();
        if (r13 != kotlinx.coroutines.internal.v.f10589h) goto L11;
        f10514i.compareAndSet(this, r11, r12.i());
        goto L3
    L11:
        return (Runnable) r13;
    L5:
        return null;
    }

    private final boolean v0(Runnable r10) {
        AtomicReferenceFieldUpdater r11 = f10514i;
    L3:
        Object r12 = r11.get(this);
        if (a() == true) goto L5;
        if (r12 == null) goto L9;
        if ((r12 instanceof kotlinx.coroutines.internal.v) == true) goto L13;
        if (r12 == j1.a()) goto L24;
        kotlinx.coroutines.internal.v r13 = new kotlinx.coroutines.internal.v(8, true);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r13.a((Runnable) r12);
        r13.a(r10);
        if (f10514i.compareAndSet(this, r12, r13) == false) goto L3;
        return true;
    L24:
        return false;
    L13:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.v r14 = (kotlinx.coroutines.internal.v) r12;
        int r15 = r14.a(r10);
        if (r15 == 0) goto L21;
        if (r15 != 1) goto L17;
        f10514i.compareAndSet(this, r12, r14.i());
        goto L3
    L17:
        if (r15 != 2) goto L3;
        return false;
    L21:
        return true;
    L9:
        if (f10514i.compareAndSet(this, null, r10) == false) goto L3;
        return true;
    L5:
        return false;
    }

    private final void x0() {
        kotlinx.coroutines.c.a();
        long r10 = System.nanoTime();
    L3:
        d r11 = (d) f10515j.get(this);
        if (r11 == null) goto L9;
        c r12 = r11.i();
        if (r12 == null) goto L12;
        p0(r10, r12);
        goto L3
    L12:
        return;
    }

    @Override // kotlinx.coroutines.t0
    public b1 B(long r10, Runnable r11, CoroutineContext r12) {
        return t0.a.a(this, r10, r11, r12);
    }

    protected final b1 B0(long r10, Runnable r11) {
        long r12 = j1.d(r10);
        if (r12 >= DurationKt.MAX_MILLIS) goto L6;
        kotlinx.coroutines.c.a();
        long r13 = System.nanoTime();
        b r14 = new b(r12 + r13, r11);
        z0(r13, r14);
        return r14;
    L6:
        return i2.f10525c;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r10, Runnable r11) {
        u0(r11);
    }

    @Override // kotlinx.coroutines.f1
    protected long g0() {
        if (super.g0() != 0) goto L5;
        return 0;
    L5:
        Object r10 = f10514i.get(this);
        if (r10 != null) goto L8;
    L16:
        d r11 = (d) f10515j.get(this);
        if (r11 == null) goto L23;
        c r12 = r11.e();
        if (r12 == null) goto L23;
        long r13 = r12.f10520c;
        kotlinx.coroutines.c.a();
        return RangesKt.coerceAtLeast(r13 - System.nanoTime(), 0);
    L23:
        return Long.MAX_VALUE;
    L8:
        if ((r10 instanceof kotlinx.coroutines.internal.v) == false) goto L13;
        if (((kotlinx.coroutines.internal.v) r10).g() == true) goto L16;
        return 0;
    L13:
        if (r10 != j1.a()) goto L15;
        return Long.MAX_VALUE;
    L15:
        return 0;
    }

    @Override // kotlinx.coroutines.t0
    public void k(long r10, n<? super Unit> r11) {
        long r12 = j1.d(r10);
        if (r12 >= DurationKt.MAX_MILLIS) goto L6;
        kotlinx.coroutines.c.a();
        long r13 = System.nanoTime();
        a r14 = new a(this, r12 + r13, r11);
        z0(r13, r14);
        q.a(r11, r14);
        return;
    }

    @Override // kotlinx.coroutines.f1
    public long l0() {
        if (m0() == false) goto L5;
        return 0;
    L5:
        d r10 = (d) f10515j.get(this);
        if (r10 != null) goto L8;
    L29:
        Runnable r11 = t0();
        if (r11 == null) goto L34;
        r11.run();
        return 0;
    L34:
        return g0();
    L8:
        if (r10.d() == true) goto L29;
        kotlinx.coroutines.c.a();
        long r12 = System.nanoTime();
    L10:
        monitor-enter(r10);
        c r13 = r10.b();     // Catch: Throwable -> L26
        c r14 = null;
        if (r13 != null) goto L16;
    L14:
        monitor-exit(r10);
        if (r14 != null) goto L10;
    L16:
        c r15 = r13;     // Catch: Throwable -> L26
        if (r15.g(r12) == false) goto L19;
        boolean r16 = v0(r15);     // Catch: Throwable -> L26
    L20:
        if (r16 == false) goto L14;
        r14 = r10.h(0);     // Catch: Throwable -> L26
        goto L14
    L19:
        r16 = false;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.f1
    public void shutdown() {
        s2.f10631a.c();
        C0(true);
        s0();
    L4:
        if (l0() <= 0) goto L4;
        x0();
    }

    public void u0(Runnable r10) {
        if (v0(r10) == false) goto L5;
        q0();
        return;
    L5:
        p0.f10623l.u0(r10);
    }

    protected boolean w0() {
        if (k0() == true) goto L5;
        return false;
    L5:
        d r10 = (d) f10515j.get(this);
        if (r10 != null) goto L8;
    L10:
        Object r11 = f10514i.get(this);
        if (r11 != null) goto L14;
    L19:
        return true;
    L14:
        if ((r11 instanceof kotlinx.coroutines.internal.v) == false) goto L17;
        return ((kotlinx.coroutines.internal.v) r11).g();
    L17:
        if (r11 == j1.a()) goto L19;
        return false;
    L8:
        if (r10.d() == true) goto L10;
        return false;
    }

    protected final void y0() {
        f10514i.set(this, null);
        f10515j.set(this, null);
    }

    public final void z0(long r10, c r11) {
        int r12 = A0(r10, r11);
        if (r12 == 0) goto L13;
        if (r12 != 1) goto L7;
        p0(r10, r11);
        return;
    L7:
        if (r12 != 2) goto L10;
        return;
    L10:
        throw new IllegalStateException("unexpected result".toString());
    L13:
        if (D0(r11) == false) goto L17;
        q0();
        return;
    }
}
