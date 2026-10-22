package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.an;
import kotlinx.coroutines.de;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.ah;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.q;
import kotlinx.coroutines.selects.m;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0017Jb\u0010\u0016\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u0002H\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001d0\u00122!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0012H\u0083\b¢\u0006\u0002\u0010\u001fJ\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0005J\u000e\u0010!\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0003H\u0002J\u001e\u0010&\u001a\u00020\u00142\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0004J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\f\u0010.\u001a\u00020\u001d*\u00020*H\u0002R\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\t\u0010\r\u001a\u00020\fX\u0082\u0004R\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¨\u0006/"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "", "acquiredPermits", "(II)V", "_availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "availablePermits", "getAvailablePermits", "()I", "deqIdx", "Lkotlinx/atomicfu/AtomicLong;", "enqIdx", "head", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "onCancellationRelease", "Lkotlin/Function1;", "", "", "tail", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "waiter", "suspend", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancellableContinuation;", "acquireSlowPath", "addAcquireToQueue", "Lkotlinx/coroutines/Waiter;", "coerceAvailablePermitsAtMaximum", "decPermits", "onAcquireRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "", "release", "tryAcquire", "tryResumeNextFromQueue", "tryResumeAcquire", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class e implements d {
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
    private static final /* synthetic */ AtomicLongFieldUpdater d = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
    private static final /* synthetic */ AtomicLongFieldUpdater f = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater g = null;
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Throwable, Unit> f17657b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "head$volatile");
        d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail$volatile");
        f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx$volatile");
        g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits$volatile");
    }

    public e(int r6, int r7) {
        this.f17656a = r6;
        boolean r0 = true;
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        if (r7 < 0) goto L10;
        if (r7 > r6) goto L10;
    L11:
        if (r0 == false) goto L15;
        g r1 = new g(0, null, 2);
        this.head$volatile = r1;
        this.tail$volatile = r1;
        this._availablePermits$volatile = r6 - r7;
        this.f17657b = (Function1) ZeusTransformUtils.preCheckCast(new SemaphoreImpl$onCancellationRelease$1(this), Function1.class, "com.obric.memorydata.plugin");
        return;
    L15:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r6).toString());
    L10:
        r0 = false;
        goto L11
    L17:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    private final int a() {
    L2:
        int r0 = k().getAndDecrement(this);
        if (r0 > this.f17656a) goto L2;
        return r0;
    }

    static /* synthetic */ Object a(e r2, Continuation<? super Unit> r3) {
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if (r2.a() > 0) goto L5;
        Object r5 = r2.b(r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r5;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final boolean a(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L9;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n r0 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        Object r4 = ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin")).a(Unit.INSTANCE, null, this.f17657b);
        if (r4 == null) goto L7;
        ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin")).a(r4);
        return true;
    L7:
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == false) goto L13;
        return ((m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin")).a(this, Unit.INSTANCE);
    L13:
        throw new IllegalStateException(("unexpected: " + r5).toString());
    }

    private final boolean a(de r19) {
        de r1 = (de) ZeusTransformUtils.wrapperContextForParams(r19, de.class, "com.obric.memorydata.plugin");
        g r3 = (g) ZeusTransformUtils.preCheckCast(i().get(this), g.class, "com.obric.memorydata.plugin");
        long r4 = j().getAndIncrement(this);
        KFunction r6 = (KFunction) ZeusTransformUtils.preCheckCast(SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE, KFunction.class, "com.obric.memorydata.plugin");
        AtomicReferenceFieldUpdater r7 = i();
        long r8 = r4 / ((long) f.a());
    L3:
        Object r10 = kotlinx.coroutines.internal.e.a((ag) ZeusTransformUtils.preCheckCast(r3, ag.class, "com.obric.memorydata.plugin"), r8, (Function2) ZeusTransformUtils.preCheckCast(r6, Function2.class, "com.obric.memorydata.plugin"));
        if (ah.a(r10) == true) goto L24;
        ag r11 = ah.b(r10);
    L6:
        ag r14 = (ag) ZeusTransformUtils.preCheckCast(r7.get(this), ag.class, "com.obric.memorydata.plugin");
        long r16 = r8;
        if (r14.f17558a >= r11.f17558a) goto L8;
        if (r11.j() == false) goto L11;
        if (r7.compareAndSet(this, r14, r11) == true) goto L15;
        if (r11.k() == false) goto L23;
        r11.i();
    L23:
        r8 = r16;
        goto L6
    L15:
        if (r14.k() == false) goto L8;
        r14.i();
        goto L8
    L11:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L24;
        r8 = r16;
    L8:
        r9 = true;
    L24:
        g r5 = (g) ZeusTransformUtils.preCheckCast(ah.b(r10), g.class, "com.obric.memorydata.plugin");
        int r12 = (int) (r4 % ((long) f.a()));
        if (r5.a().compareAndSet(r12, null, r1) == false) goto L29;
        r1.a((ag) ZeusTransformUtils.preCheckCast(r5, ag.class, "com.obric.memorydata.plugin"), r12);
        return true;
    L29:
        if (r5.a().compareAndSet(r12, f.b(), f.c()) == false) goto L41;
        if (ZeusTransformUtils.instanceOf(r1, n.class) == false) goto L35;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n r13 = (n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin");
        ((n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin")).a(Unit.INSTANCE, this.f17657b);
        return true;
    L35:
        if (ZeusTransformUtils.instanceOf(r1, m.class) == false) goto L39;
        ((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.memorydata.plugin")).a(Unit.INSTANCE);
        return true;
    L39:
        throw new IllegalStateException(("unexpected: " + r1).toString());
    L41:
        if (an.a() == true) goto L43;
        return false;
    L43:
        if (r5.a().get(r12) != f.e()) goto L45;
        boolean r15 = true;
    L46:
        if (r15 == false) goto L49;
        return false;
    L49:
        throw new AssertionError();
    L45:
        r15 = false;
        goto L46
    }

    public static final /* synthetic */ boolean a(e r2, de r3) {
        return r2.a((de) ZeusTransformUtils.wrapperContextForParams(r3, de.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super Unit> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = q.a(IntrinsicsKt.intercepted(r5));
    L14:
        th = move-exception;
        r0.i();
        throw th;
    L4:
        if (a(this, (de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin")) == true) goto L6;
        a((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L6:
        Object r3 = r0.h();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L10:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r3;
    L13:
        return Unit.INSTANCE;
    }

    private final void b() {
    L2:
        int r0 = k().get(this);
        if (r0 <= this.f17656a) goto L6;
        if (k().compareAndSet(this, r0, this.f17656a) == false) goto L2;
        return;
    }

    private final boolean f() {
        g r1 = (g) ZeusTransformUtils.preCheckCast(g().get(this), g.class, "com.obric.memorydata.plugin");
        long r4 = h().getAndIncrement(this);
        long r6 = r4 / ((long) f.a());
        KFunction r2 = (KFunction) ZeusTransformUtils.preCheckCast(SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE, KFunction.class, "com.obric.memorydata.plugin");
        AtomicReferenceFieldUpdater r8 = g();
    L3:
        Object r9 = kotlinx.coroutines.internal.e.a((ag) ZeusTransformUtils.preCheckCast(r1, ag.class, "com.obric.memorydata.plugin"), r6, (Function2) ZeusTransformUtils.preCheckCast(r2, Function2.class, "com.obric.memorydata.plugin"));
        if (ah.a(r9) == true) goto L22;
        ag r10 = ah.b(r9);
    L6:
        ag r13 = (ag) ZeusTransformUtils.preCheckCast(r8.get(this), ag.class, "com.obric.memorydata.plugin");
        if (r13.f17558a >= r10.f17558a) goto L8;
        if (r10.j() == false) goto L11;
        if (r8.compareAndSet(this, r13, r10) == true) goto L15;
        if (r10.k() == false) goto L6;
        r10.i();
        goto L6
    L15:
        if (r13.k() == false) goto L8;
        r13.i();
        goto L8
    L11:
        boolean r11 = false;
    L17:
        if (r11 == false) goto L3;
    L8:
        r11 = true;
    L22:
        g r3 = (g) ZeusTransformUtils.preCheckCast(ah.b(r9), g.class, "com.obric.memorydata.plugin");
        r3.f();
        if (r3.f17558a <= r6) goto L26;
        return false;
    L26:
        int r5 = (int) (r4 % ((long) f.a()));
        Object r7 = r3.a().getAndSet(r5, f.b());
        if (r7 != null) goto L38;
        int r0 = f.d();
        int r12 = 0;
    L29:
        if (r12 >= r0) goto L36;
        if (r3.a().get(r5) == f.c()) goto L32;
        r12 = r12 + 1;
        goto L29
    L32:
        return true;
    L36:
        return !r3.a().compareAndSet(r5, f.b(), f.e());
    L38:
        if (r7 != f.f()) goto L42;
        return false;
    L42:
        return a(r7);
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater g() {
        return c;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater h() {
        return d;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater i() {
        return e;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater j() {
        return f;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater k() {
        return g;
    }

    @Override // kotlinx.coroutines.sync.d
    public Object a(Continuation<? super Unit> r3) {
        return a(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final void a(n<? super Unit> r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
    L4:
        if (a() > 0) goto L5;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (a((de) ZeusTransformUtils.preCheckCast(r4, de.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return;
    L5:
        r4.a(Unit.INSTANCE, this.f17657b);
    }

    public final void b(m<?> r2, Object r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin");
    L4:
        if (a() > 0) goto L5;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (a((de) ZeusTransformUtils.preCheckCast(r4, de.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return;
    L5:
        r4.a(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.sync.d
    public void c() {
    L2:
        int r0 = k().getAndIncrement(this);
        if (r0 >= this.f17656a) goto L9;
        if (r0 >= 0) goto L5;
        if (f() == false) goto L2;
        return;
    L5:
        return;
    L9:
        b();
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f17656a).toString());
    }

    public int d() {
        return Math.max(k().get(this), 0);
    }

    public boolean e() {
    L2:
        int r0 = k().get(this);
        if (r0 > this.f17656a) goto L4;
        if (r0 <= 0) goto L6;
        if (k().compareAndSet(this, r0, r0 - 1) == false) goto L2;
        return true;
    L6:
        return false;
    L4:
        b();
        goto L2
    }
}
