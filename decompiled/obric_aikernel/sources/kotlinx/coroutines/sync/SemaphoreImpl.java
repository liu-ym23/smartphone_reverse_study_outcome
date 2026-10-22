package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.c3;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.q;
import kotlinx.coroutines.selects.k;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
public class SemaphoreImpl implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10704c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10705d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10706e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10707f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10708g = null;

    @Volatile
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Throwable, Unit> f10710b;

    @Volatile
    private volatile long deqIdx;

    @Volatile
    private volatile long enqIdx;

    @Volatile
    private volatile Object head;

    @Volatile
    private volatile Object tail;

    static {
        f10704c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
        f10705d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
        f10706e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
        f10707f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
        f10708g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    }

    public SemaphoreImpl(int r10, int r11) {
        this.f10709a = r10;
        boolean r12 = true;
        if (r10 <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L17;
        if (r11 < 0) goto L10;
        if (r11 > r10) goto L10;
    L11:
        if (r12 == false) goto L15;
        c r14 = new c(0, null, 2);
        this.head = r14;
        this.tail = r14;
        this._availablePermits = r10 - r11;
        this.f10710b = new SemaphoreImpl$onCancellationRelease$1(this);
        return;
    L15:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r10).toString());
    L10:
        r12 = false;
        goto L11
    L17:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r10).toString());
    L5:
        r13 = false;
        goto L6
    }

    public static final /* synthetic */ boolean d(SemaphoreImpl r10, c3 r11) {
        return r10.h(r11);
    }

    static /* synthetic */ Object f(SemaphoreImpl r10, Continuation<? super Unit> r11) {
        if (r10.j() > 0) goto L5;
        Object r12 = r10.g(r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r12;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final Object g(Continuation<? super Unit> r10) {
        o r11 = q.b(IntrinsicsKt.intercepted(r10));
    L14:
        th = move-exception;
        r11.S();
        throw th;
    L4:
        if (d(this, r11) == true) goto L6;
        e(r11);     // Catch: Throwable -> L14
    L6:
        Object r12 = r11.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L10:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r12;
    L13:
        return Unit.INSTANCE;
    }

    private final boolean h(c3 r17) {
        AtomicReferenceFieldUpdater r10 = f10706e;
        c r11 = (c) r10.get(this);
        long r12 = f10707f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 r13 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long r14 = r12 / ((long) SemaphoreKt.f());
    L3:
        Object r15 = e.c(r11, r14, r13);
        if (g0.c(r15) == true) goto L22;
        f0 r16 = g0.b(r15);
    L6:
        f0 r18 = (f0) r10.get(this);
        if (r18.f10550h >= r16.f10550h) goto L8;
        if (r16.q() == false) goto L11;
        if (r10.compareAndSet(this, r18, r16) == true) goto L15;
        if (r16.m() == false) goto L6;
        r16.k();
        goto L6
    L15:
        if (r18.m() == false) goto L8;
        r18.k();
        goto L8
    L11:
        boolean r19 = false;
    L17:
        if (r19 == false) goto L3;
    L8:
        r19 = true;
    L22:
        c r20 = (c) g0.b(r15);
        int r21 = (int) (r12 % ((long) SemaphoreKt.f()));
        if (r20.r().compareAndSet(r21, null, r17) == false) goto L27;
        r17.c(r20, r21);
        return true;
    L27:
        if (r20.r().compareAndSet(r21, SemaphoreKt.e(), SemaphoreKt.g()) == false) goto L39;
        if ((r17 instanceof n) == false) goto L33;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        ((n) r17).y(Unit.INSTANCE, this.f10710b);
        return true;
    L33:
        if ((r17 instanceof k) == false) goto L37;
        ((k) r17).f(Unit.INSTANCE);
        return true;
    L37:
        throw new IllegalStateException(("unexpected: " + r17).toString());
    L39:
        if (n0.a() == true) goto L41;
        return false;
    L41:
        if (r20.r().get(r21) != SemaphoreKt.b()) goto L43;
        boolean r110 = true;
    L44:
        if (r110 == false) goto L47;
        return false;
    L47:
        throw new AssertionError();
    L43:
        r110 = false;
        goto L44
    }

    private final void i() {
    L2:
        AtomicIntegerFieldUpdater r10 = f10708g;
        int r11 = r10.get(this);
        int r12 = this.f10709a;
        if (r11 <= r12) goto L6;
        if (r10.compareAndSet(this, r11, r12) == false) goto L2;
        return;
    }

    private final int j() {
    L2:
        int r10 = f10708g.getAndDecrement(this);
        if (r10 > this.f10709a) goto L2;
        return r10;
    }

    private final boolean n(Object r10) {
        if ((r10 instanceof n) == false) goto L9;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n r11 = (n) r10;
        Object r12 = r11.k(Unit.INSTANCE, null, this.f10710b);
        if (r12 == null) goto L7;
        r11.N(r12);
        return true;
    L7:
        return false;
    L9:
        if ((r10 instanceof k) == false) goto L13;
        return ((k) r10).d(this, Unit.INSTANCE);
    L13:
        throw new IllegalStateException(("unexpected: " + r10).toString());
    }

    private final boolean o() {
        AtomicReferenceFieldUpdater r10 = f10704c;
        c r11 = (c) r10.get(this);
        long r12 = f10705d.getAndIncrement(this);
        long r13 = r12 / ((long) SemaphoreKt.f());
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 r14 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
    L3:
        Object r15 = e.c(r11, r13, r14);
        if (g0.c(r15) == true) goto L22;
        f0 r16 = g0.b(r15);
    L6:
        f0 r17 = (f0) r10.get(this);
        if (r17.f10550h >= r16.f10550h) goto L8;
        if (r16.q() == false) goto L11;
        if (r10.compareAndSet(this, r17, r16) == true) goto L15;
        if (r16.m() == false) goto L6;
        r16.k();
        goto L6
    L15:
        if (r17.m() == false) goto L8;
        r17.k();
        goto L8
    L11:
        boolean r18 = false;
    L17:
        if (r18 == false) goto L3;
    L8:
        r18 = true;
    L22:
        c r19 = (c) g0.b(r15);
        r19.b();
        if (r19.f10550h <= r13) goto L26;
        return false;
    L26:
        int r20 = (int) (r12 % ((long) SemaphoreKt.f()));
        Object r21 = r19.r().getAndSet(r20, SemaphoreKt.e());
        if (r21 != null) goto L38;
        int r22 = SemaphoreKt.d();
        int r110 = 0;
    L29:
        if (r110 >= r22) goto L36;
        if (r19.r().get(r20) == SemaphoreKt.g()) goto L32;
        r110 = r110 + 1;
        goto L29
    L32:
        return true;
    L36:
        return !r19.r().compareAndSet(r20, SemaphoreKt.e(), SemaphoreKt.b());
    L38:
        if (r21 != SemaphoreKt.c()) goto L42;
        return false;
    L42:
        return n(r21);
    }

    @Override // kotlinx.coroutines.sync.b
    public Object a(Continuation<? super Unit> r10) {
        return f(this, r10);
    }

    protected final void e(n<? super Unit> r10) {
    L3:
        if (j() > 0) goto L4;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (h((c3) r10) == false) goto L3;
        return;
    L4:
        r10.y(Unit.INSTANCE, this.f10710b);
    }

    public int k() {
        return Math.max(f10708g.get(this), 0);
    }

    protected final void l(k<?> r10, Object r11) {
    L3:
        if (j() > 0) goto L4;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (h((c3) r10) == false) goto L3;
        return;
    L4:
        r10.f(Unit.INSTANCE);
    }

    public boolean m() {
    L2:
        AtomicIntegerFieldUpdater r10 = f10708g;
        int r11 = r10.get(this);
        if (r11 > this.f10709a) goto L4;
        if (r11 <= 0) goto L6;
        if (r10.compareAndSet(this, r11, r11 - 1) == false) goto L2;
        return true;
    L6:
        return false;
    L4:
        i();
        goto L2
    }

    @Override // kotlinx.coroutines.sync.b
    public void release() {
    L2:
        int r10 = f10708g.getAndIncrement(this);
        if (r10 >= this.f10709a) goto L9;
        if (r10 >= 0) goto L5;
        if (o() == false) goto L2;
        return;
    L5:
        return;
    L9:
        i();
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f10709a).toString());
    }
}
