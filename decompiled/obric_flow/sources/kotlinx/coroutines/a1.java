package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a1 extends b1 implements o0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = null;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    static {
        e = AtomicReferenceFieldUpdater.newUpdater(a1.class, Object.class, "_queue$volatile");
        f = AtomicReferenceFieldUpdater.newUpdater(a1.class, Object.class, "_delayed$volatile");
        g = AtomicIntegerFieldUpdater.newUpdater(a1.class, "_isCompleted$volatile");
    }

    public a1() {
        this._isCompleted$volatile = 0;
    }

    @Override // kotlinx.coroutines.b1
    public final long N() {
        if (O() == false) goto L5;
        return 0;
    L5:
        R();
    L6:
        AtomicReferenceFieldUpdater r5 = e;
        Object r10 = r5.get(this);
        g8.g r11 = j0.f18967c;
        y0 r12 = null;
        if (r10 == null) goto L8;
        if ((r10 instanceof kotlinx.coroutines.internal.m) == true) goto L11;
        if (r10 == r11) goto L8;
    L24:
        if (r5.compareAndSet(this, r10, null) == true) goto L25;
        if (r5.get(this) == r10) goto L24;
    L25:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Runnable");
        Runnable r13 = (Runnable) r10;
    L26:
        if (r13 == null) goto L29;
        r13.run();
        return 0;
    L29:
        ArrayDeque r14 = this.f18772c;
        if (r14 != null) goto L33;
    L31:
        long r15 = Long.MAX_VALUE;
    L37:
        if (r15 == 0) goto L82;
        Object r16 = r5.get(this);
        if (r16 != null) goto L42;
    L48:
        z0 r17 = (z0) f.get(this);
        if (r17 == null) goto L80;
        monitor-enter(r17);
        y0[] r18 = r17.f18961a;     // Catch: Throwable -> L58
        if (r18 == null) goto L54;
        r12 = r18[0];     // Catch: Throwable -> L58
    L54:
        monitor-exit(r17);
        if (r12 == null) goto L80;
        return RangesKt.coerceAtLeast(r12.f19030a - System.nanoTime(), 0);
    L58:
        th = move-exception;
        throw th;
    L80:
        return Long.MAX_VALUE;
    L42:
        if ((r16 instanceof kotlinx.coroutines.internal.m) == false) goto L46;
        long r19 = kotlinx.coroutines.internal.m.f.get((kotlinx.coroutines.internal.m) r16);
        if (((int) (1073741823 & r19)) == ((int) ((r19 & 1152921503533105152L) >> 30))) goto L48;
        return 0;
    L46:
        if (r16 == r11) goto L80;
        return 0;
    L82:
        return 0;
    L33:
        if (r14.isEmpty() == true) goto L31;
        r15 = 0;
        goto L37
    L11:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
        kotlinx.coroutines.internal.m r20 = (kotlinx.coroutines.internal.m) r10;
        Object r21 = r20.d();
        if (r21 != kotlinx.coroutines.internal.m.g) goto L13;
        kotlinx.coroutines.internal.m r22 = r20.c();
    L16:
        if (r5.compareAndSet(this, r10, r22) == true) goto L6;
        if (r5.get(this) == r10) goto L16;
    L13:
        r13 = (Runnable) r21;
    L8:
        r13 = null;
        goto L26
    }

    public void Q(Runnable r5) {
        R();
        if (S(r5) == false) goto L7;
        Thread r10 = K();
        if (Thread.currentThread() == r10) goto L9;
        LockSupport.unpark(r10);
        return;
    L9:
        return;
    L7:
        k0.f18973h.Q(r5);
    }

    public final void R() {
        z0 r5 = (z0) f.get(this);
        if (r5 != null) goto L5;
        return;
    L5:
        if (kotlinx.coroutines.internal.y.f18960b.get(r5) == 0) goto L37;
        long r10 = System.nanoTime();
    L8:
        monitor-enter(r5);
        y0[] r11 = r5.f18961a;     // Catch: Throwable -> L20
        y0 r12 = null;
        if (r11 == null) goto L13;
        y0 r13 = r11[0];     // Catch: Throwable -> L20
    L14:
        if (r13 != null) goto L18;
        monitor-exit(r5);
    L26:
        if (r12 != null) goto L8;
        return;
    L18:
        if ((r10 - r13.f19030a) < 0) goto L22;
        boolean r14 = S(r13);     // Catch: Throwable -> L20
    L23:
        if (r14 == false) goto L25;
        r12 = r5.b(0);     // Catch: Throwable -> L20
    L25:
        monitor-exit(r5);
        goto L26
    L22:
        r14 = false;
        goto L23
    L13:
        r13 = null;
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean S(Runnable r10) {
    L2:
        AtomicReferenceFieldUpdater r5 = e;
        Object r11 = r5.get(this);
        if (g.get(this) == 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L7;
        if (r11 == null) goto L10;
        if ((r11 instanceof kotlinx.coroutines.internal.m) == true) goto L17;
        if (r11 == j0.f18967c) goto L34;
        kotlinx.coroutines.internal.m r13 = new kotlinx.coroutines.internal.m(8, true);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Runnable");
        r13.a((Runnable) r11);
        r13.a(r10);
    L37:
        if (r5.compareAndSet(this, r11, r13) == true) goto L38;
        if (r5.get(this) == r11) goto L37;
    L38:
        return true;
    L34:
        return false;
    L17:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
        kotlinx.coroutines.internal.m r14 = (kotlinx.coroutines.internal.m) r11;
        int r15 = r14.a(r10);
        if (r15 == 0) goto L31;
        if (r15 != 1) goto L21;
        kotlinx.coroutines.internal.m r16 = r14.c();
    L26:
        if (r5.compareAndSet(this, r11, r16) == true) goto L2;
        if (r5.get(this) == r11) goto L26;
    L21:
        if (r15 != 2) goto L2;
        return false;
    L31:
        return true;
    L10:
        if (r5.compareAndSet(this, null, r10) == true) goto L11;
        if (r5.get(this) == null) goto L10;
    L11:
        return true;
    L7:
        return false;
    L5:
        r12 = false;
        goto L6
    }

    public final boolean T() {
        ArrayDeque r5 = this.f18772c;
        if (r5 == null) goto L5;
        boolean r10 = r5.isEmpty();
    L7:
        if (r10 == true) goto L9;
        return false;
    L9:
        z0 r11 = (z0) f.get(this);
        if (r11 != null) goto L12;
    L15:
        Object r12 = e.get(this);
        if (r12 != null) goto L19;
        return true;
    L19:
        if ((r12 instanceof kotlinx.coroutines.internal.m) == false) goto L24;
        long r13 = kotlinx.coroutines.internal.m.f.get((kotlinx.coroutines.internal.m) r12);
        if (((int) (1073741823 & r13)) != ((int) ((r13 & 1152921503533105152L) >> 30))) goto L27;
        return true;
    L27:
        return false;
    L24:
        if (r12 != j0.f18967c) goto L27;
        return true;
    L12:
        if (kotlinx.coroutines.internal.y.f18960b.get(r11) == 0) goto L15;
        return false;
    L5:
        r10 = true;
        goto L7
    }

    public final void U(long r10, y0 r11) {
        if (g.get(this) == 0) goto L5;
        boolean r5 = true;
    L6:
        AtomicReferenceFieldUpdater r12 = f;
        y0 r13 = null;
        if (r5 == false) goto L9;
        int r14 = 1;
    L19:
        if (r14 == 0) goto L27;
        if (r14 != 1) goto L22;
        P(r10, r11);
        return;
    L22:
        if (r14 != 2) goto L25;
        return;
    L25:
        throw new IllegalStateException("unexpected result");
    L27:
        z0 r15 = (z0) r12.get(this);
        if (r15 == null) goto L38;
        monitor-enter(r15);
        y0[] r16 = r15.f18961a;     // Catch: Throwable -> L35
        if (r16 == null) goto L33;
        r13 = r16[0];     // Catch: Throwable -> L35
    L33:
        monitor-exit(r15);
    L35:
        th = move-exception;
        throw th;
    L38:
        if (r13 != r11) goto L49;
        Thread r17 = K();
        if (Thread.currentThread() == r17) goto L50;
        LockSupport.unpark(r17);
        return;
    L50:
        return;
    L49:
        return;
    L9:
        z0 r18 = (z0) r12.get(this);
        if (r18 != null) goto L18;
        z0 r19 = new z0();
        r19.f19032c = r10;
    L13:
        if (r12.compareAndSet(this, null, r19) == true) goto L17;
        if (r12.get(this) == null) goto L13;
    L17:
        Object r20 = r12.get(this);
        Intrinsics.checkNotNull(r20);
        r18 = (z0) r20;
    L18:
        r14 = r11.b(r10, r18, this);
        goto L19
    L5:
        r5 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        Q(r10);
    }

    @Override // kotlinx.coroutines.o0
    public t0 e(long r5, Runnable r10, CoroutineContext r11) {
        return l0.f18979a.e(r5, r10, r11);
    }

    @Override // kotlinx.coroutines.o0
    public final void f(long r5, l r10) {
        long r11 = j0.d(r5);
        if (r11 >= DurationKt.MAX_MILLIS) goto L6;
        long r12 = System.nanoTime();
        w0 r13 = new w0(this, r11 + r12, r10);
        U(r12, r13);
        r10.z(new h(r13, 2));
        return;
    }

    @Override // kotlinx.coroutines.b1
    public void shutdown() {
        b2.f18773a.set(null);
        g.set(this, 1);
    L3:
        AtomicReferenceFieldUpdater r5 = e;
        Object r10 = r5.get(this);
        g8.g r11 = j0.f18967c;
        if (r10 == null) goto L6;
        if ((r10 instanceof kotlinx.coroutines.internal.m) == true) goto L13;
        if (r10 == r11) goto L20;
        kotlinx.coroutines.internal.m r12 = new kotlinx.coroutines.internal.m(8, true);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Runnable");
        r12.a((Runnable) r10);
    L18:
        if (r5.compareAndSet(this, r10, r12) == true) goto L20;
        if (r5.get(this) == r10) goto L18;
    L20:
        if (N() <= 0) goto L20;
        long r13 = System.nanoTime();
    L22:
        z0 r14 = (z0) f.get(this);
        if (r14 == null) goto L60;
        monitor-enter(r14);
    L29:
        th = move-exception;
        throw th;
    L26:
        if (kotlinx.coroutines.internal.y.f18960b.get(r14) <= 0) goto L31;
        y0 r15 = r14.b(0);     // Catch: Throwable -> L29
    L32:
        monitor-exit(r14);
        if (r15 == null) goto L38;
        P(r13, r15);
        goto L22
    L38:
        return;
    L31:
        r15 = null;
        goto L32
    L60:
        return;
    L13:
        ((kotlinx.coroutines.internal.m) r10).b();
    L6:
        if (r5.compareAndSet(this, null, r11) == true) goto L20;
        if (r5.get(this) == null) goto L6;
        goto L3
    }
}
