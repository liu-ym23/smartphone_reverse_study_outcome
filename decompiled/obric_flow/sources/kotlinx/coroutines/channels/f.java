package kotlinx.coroutines.channels;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.i2;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: loaded from: classes3.dex */
public class f implements i {
    public static final /* synthetic */ AtomicLongFieldUpdater d = null;
    public static final /* synthetic */ AtomicLongFieldUpdater e = null;
    public static final /* synthetic */ AtomicLongFieldUpdater f = null;
    public static final /* synthetic */ AtomicLongFieldUpdater g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18789h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18790i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18791j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18792k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18793l = null;
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f18795b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.coroutines.k f18796c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    static {
        d = AtomicLongFieldUpdater.newUpdater(f.class, "sendersAndCloseStatus$volatile");
        e = AtomicLongFieldUpdater.newUpdater(f.class, "receivers$volatile");
        f = AtomicLongFieldUpdater.newUpdater(f.class, "bufferEnd$volatile");
        g = AtomicLongFieldUpdater.newUpdater(f.class, "completedExpandBuffersAndPauseFlag$volatile");
        f18789h = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "sendSegment$volatile");
        f18790i = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "receiveSegment$volatile");
        f18791j = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "bufferEndSegment$volatile");
        f18792k = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_closeCause$volatile");
        f18793l = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "closeHandler$volatile");
    }

    public f(int r10, Function1 r11) {
        this.f18794a = r10;
        this.f18795b = r11;
        if (r10 < 0) goto L21;
        o r5 = g.f18797a;
        if (r10 != 0) goto L7;
        long r12 = 0;
    L11:
        this.bufferEnd$volatile = r12;
        this.completedExpandBuffersAndPauseFlag$volatile = f.get(this);
        o r13 = new o(0, null, this, 3);
        this.sendSegment$volatile = r13;
        this.receiveSegment$volatile = r13;
        if (D() == false) goto L14;
        r13 = g.f18797a;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L14:
        this.bufferEndSegment$volatile = r13;
        if (r11 == null) goto L17;
        kotlinx.coroutines.k r14 = new kotlinx.coroutines.k(this, 1);
    L18:
        this.f18796c = r14;
        this._closeCause$volatile = g.s;
        return;
    L17:
        r14 = null;
        goto L18
    L7:
        if (r10 == Integer.MAX_VALUE) goto L9;
        r12 = r10;
        goto L11
    L9:
        r12 = Long.MAX_VALUE;
        goto L11
    L21:
        throw new IllegalArgumentException(j0.h(r10, "Invalid channel capacity: ", ", should be >=0").toString());
    }

    public static Object G(f r13, ContinuationImpl r14) {
        if ((r14 instanceof BufferedChannel$receiveCatching$1) == false) goto L8;
        BufferedChannel$receiveCatching$1 r5 = (BufferedChannel$receiveCatching$1) r14;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r10 - Integer.MIN_VALUE;
    L7:
        BufferedChannel$receiveCatching$1 r11 = r5;
        Object r15 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r11.label;
        if (r16 == 0) goto L15;
        if (r16 != 1) goto L14;
        ResultKt.throwOnFailure(r15);
        Object r17 = ((n) r15).f18815a;
    L53:
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        o r18 = (o) f18790i.get(r13);
    L17:
        if (r13.A() == true) goto L52;
        long r19 = e.getAndIncrement(r13);
        long r20 = g.f18798b;
        long r21 = r19 / r20;
        int r22 = (int) (r19 % r20);
        if (r18.f18950c == r21) goto L25;
        o r23 = r13.t(r21, r18);
        if (r23 == null) goto L17;
        r18 = r23;
    L25:
        Object r24 = r13.M(r18, r22, r19, null);
        if (r24 == g.f18805m) goto L41;
        if (r24 != g.f18807o) goto L33;
        if (r19 >= r13.x()) goto L17;
        r18.a();
        goto L17
    L33:
        if (r24 != g.f18806n) goto L38;
        r11.label = 1;
        r17 = r13.H(r18, r22, r19, r11);
        if (r17 != r12) goto L53;
        return r12;
    L38:
        r18.a();
        return r24;
    L41:
        throw new IllegalStateException("unexpected");
    L52:
        return new l(r13.u());
    L8:
        r5 = new BufferedChannel$receiveCatching$1(r13, r14);
        goto L7
    }

    public static final o b(f r12, long r13, o r15) {
        r12.getClass();
        o r5 = g.f18797a;
        BufferedChannelKt$createSegmentFunction$1 r10 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    L3:
        Object r11 = kotlinx.coroutines.internal.a.a(r15, r13, r10);
        if (kotlinx.coroutines.internal.f.f(r11) == true) goto L22;
        kotlinx.coroutines.internal.s r14 = kotlinx.coroutines.internal.f.d(r11);
    L6:
        AtomicReferenceFieldUpdater r16 = f18789h;
        kotlinx.coroutines.internal.s r17 = (kotlinx.coroutines.internal.s) r16.get(r12);
        if (r17.f18950c >= r14.f18950c) goto L22;
        if (r14.j() == false) goto L3;
    L13:
        if (r16.compareAndSet(r12, r17, r14) == true) goto L15;
        if (r16.get(r12) == r17) goto L13;
        if (r14.f() == false) goto L6;
        r14.e();
        goto L6
    L15:
        if (r17.f() == false) goto L22;
        r17.e();
    L22:
        boolean r18 = kotlinx.coroutines.internal.f.f(r11);
        AtomicLongFieldUpdater r19 = e;
        if (r18 == false) goto L27;
        r12.B();
        if ((r15.f18950c * g.f18798b) >= r19.get(r12)) goto L53;
        r15.a();
        return null;
    L53:
        return null;
    L27:
        o r110 = (o) kotlinx.coroutines.internal.f.d(r11);
        long r20 = r110.f18950c;
        if (r20 <= r13) goto L39;
        long r111 = ((long) g.f18798b) * r20;
    L30:
        AtomicLongFieldUpdater r21 = d;
        long r22 = r21.get(r12);
        long r23 = 1152921504606846975L & r22;
        if (r23 >= r111) goto L36;
        if (r21.compareAndSet(r12, r22, r23 + (((long) ((int) (r22 >> 60))) << 60)) == false) goto L30;
    L36:
        if ((r20 * ((long) g.f18798b)) >= r19.get(r12)) goto L55;
        r110.a();
        return null;
    L55:
        return null;
    L39:
        return r110;
    }

    public static final void c(f r5, Object r10, kotlinx.coroutines.l r11) {
        Function1 r12 = r5.f18795b;
        if (r12 == null) goto L5;
        kotlinx.coroutines.internal.f.a(r12, r10, r11.e);
    L5:
        Throwable r13 = r5.w();
        Result.Companion r14 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r13)));
    }

    public static final void d(f r5, i2 r10, o r11, int r12) {
        r5.getClass();
        r10.a(r11, r12 + g.f18798b);
    }

    public static final void e(f r10, kotlinx.coroutines.selects.g r11) {
        r10.getClass();
        o r5 = (o) f18790i.get(r10);
    L4:
        if (r10.A() == true) goto L5;
        long r12 = e.getAndIncrement(r10);
        long r13 = g.f18798b;
        long r14 = r12 / r13;
        int r15 = (int) (r12 % r13);
        if (r5.f18950c == r14) goto L12;
        o r16 = r10.t(r14, r5);
        if (r16 == null) goto L4;
        r5 = r16;
    L12:
        Object r17 = r10.M(r5, r15, r12, r11);
        if (r17 == g.f18805m) goto L15;
        if (r17 != g.f18807o) goto L26;
        if (r12 >= r10.x()) goto L4;
        r5.a();
        goto L4
    L26:
        if (r17 == g.f18806n) goto L30;
        r5.a();
        r11.c(r17);
        return;
    L30:
        throw new IllegalStateException("unexpected");
    L15:
        if ((r11 instanceof i2) == false) goto L17;
        i2 r18 = (i2) r11;
    L18:
        if (r18 == null) goto L42;
        r18.a(r5, r15);
        return;
    L42:
        return;
    L17:
        r18 = null;
        goto L18
    L5:
        r11.c(g.f18804l);
    }

    public static final int k(f r5, o r10, int r11, Object r12, long r13, Object r14, boolean r15) {
        r5.getClass();
        r10.n(r11, r12);
        if (r15 == true) goto L28;
        Object r16 = r10.l(r11);
        if (r16 != null) goto L18;
        if (r5.m(r13) == true) goto L10;
        if (r14 != null) goto L15;
        return 3;
    L15:
        if (r10.k(r11, null, r14) == false) goto L27;
        return 2;
    L27:
        return r5.N(r10, r11, r12, r13, r14, r15);
    L10:
        if (r10.k(r11, null, g.d) == false) goto L27;
        return 1;
    L18:
        if ((r16 instanceof i2) == false) goto L27;
        r10.n(r11, null);
        if (r5.K(r16, r12) == false) goto L22;
        r10.o(r11, g.f18801i);
        return 0;
    L22:
        g8.g r17 = g.f18803k;
        if (r10.f.getAndSet((r11 * 2) + 1, r17) == r17) goto L25;
        r10.m(r11, true);
    L25:
        return 5;
    L28:
        return r5.N(r10, r11, r12, r13, r14, r15);
    }

    public static void y(f r10) {
        r10.getClass();
        AtomicLongFieldUpdater r5 = g;
        if ((r5.addAndGet(r10, 1) & 4611686018427387904L) != 0) goto L5;
        return;
    L5:
        if ((r5.get(r10) & 4611686018427387904L) != 0) goto L5;
    }

    public final boolean A() {
        return z(d.get(this), true);
    }

    public boolean B() {
        return z(d.get(this), false);
    }

    public boolean C() {
        return false;
    }

    public final boolean D() {
        long r5 = f.get(this);
        if (r5 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r5 == Long.MAX_VALUE) goto L8;
        return false;
    }

    public final void E(long r5, o r10) {
    L3:
        if (r10.f18950c >= r5) goto L9;
        o r11 = (o) r10.c();
        if (r11 == null) goto L9;
        r10 = r11;
    L9:
        if (r10.d() == false) goto L14;
        o r12 = (o) r10.c();
        if (r12 == null) goto L14;
        r10 = r12;
    L14:
        AtomicReferenceFieldUpdater r13 = f18791j;
        kotlinx.coroutines.internal.s r14 = (kotlinx.coroutines.internal.s) r13.get(this);
        if (r14.f18950c >= r10.f18950c) goto L50;
        if (r10.j() == false) goto L9;
    L21:
        if (r13.compareAndSet(this, r14, r10) == true) goto L23;
        if (r13.get(this) == r14) goto L21;
        if (r10.f() == false) goto L14;
        r10.e();
        goto L14
    L23:
        if (r14.f() == false) goto L49;
        r14.e();
        return;
    L49:
        return;
    }

    public final Object F(Object r5, Continuation r10) {
        kotlinx.coroutines.l r11 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(r10));
        r11.w();
        Function1 r12 = this.f18795b;
        if (r12 == null) goto L7;
        UndeliveredElementException r13 = kotlinx.coroutines.internal.f.b(r12, r5, null);
        if (r13 == null) goto L7;
        ExceptionsKt.addSuppressed(r13, w());
        Result.Companion r14 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r13)));
    L8:
        Object r15 = r11.v();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L12:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r15;
    L15:
        return Unit.INSTANCE;
    L7:
        Throwable r16 = w();
        Result.Companion r17 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r16)));
        goto L8
    }

    public final Object H(o r17, int r18, long r19, ContinuationImpl r21) {
        if ((r21 instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) == false) goto L8;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r5 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r21;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r10 - Integer.MIN_VALUE;
    L7:
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r11 = r5;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L15;
        if (r14 != 1) goto L14;
        o r15 = (o) r11.L$1;
        f r16 = (f) r11.L$0;
        ResultKt.throwOnFailure(r12);
    L67:
        return ((n) r12).f18815a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        r11.L$0 = this;
        r11.L$1 = r17;
        r11.I$0 = r18;
        r11.J$0 = r19;
        r11.label = 1;
        kotlinx.coroutines.l r110 = kotlinx.coroutines.j0.h(IntrinsicsKt.intercepted(r11));
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");     // Catch: Throwable -> L25
        v r111 = new v(r110);     // Catch: Throwable -> L25
        Object r20 = M(r17, r18, r19, r111);     // Catch: Throwable -> L25
        if (r20 != g.f18805m) goto L19;
        r111.a(r17, r18);     // Catch: Throwable -> L25
    L61:
        r12 = r110.v();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L64;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L64:
        if (r12 != r13) goto L67;
        return r13;
    L19:
        Object r22 = g.f18807o;     // Catch: Throwable -> L25
        Function1 r112 = this.f18795b;
        if (r20 == r22) goto L23;
        r17.a();     // Catch: Throwable -> L25
        n r23 = new n(r20);     // Catch: Throwable -> L25
        if (r112 == null) goto L60;
        BufferedChannel$bindCancellationFunResult$1 r24 = new BufferedChannel$bindCancellationFunResult$1(this);     // Catch: Throwable -> L25
    L53:
        r110.k(r23, r24);     // Catch: Throwable -> L25
        goto L61
    L60:
        r24 = null;
        goto L53
    L23:
        if (r19 >= x()) goto L27;
        r17.a();     // Catch: Throwable -> L25
    L27:
        o r25 = (o) f18790i.get(this);     // Catch: Throwable -> L25
    L29:
        if (A() == true) goto L30;
        long r26 = e.getAndIncrement(this);     // Catch: Throwable -> L25
        long r27 = g.f18798b;     // Catch: Throwable -> L25
        long r28 = r26 / r27;     // Catch: Throwable -> L25
        int r29 = (int) (r26 % r27);     // Catch: Throwable -> L25
        if (r25.f18950c == r28) goto L37;
        o r30 = t(r28, r25);     // Catch: Throwable -> L25
        if (r30 == null) goto L29;
        o r31 = r30;
    L38:
        o r32 = r31;
        Object r33 = M(r31, r29, r26, r111);     // Catch: Throwable -> L25
        if (r33 == g.f18805m) goto L40;
        if (r33 != g.f18807o) goto L48;
        if (r26 >= x()) goto L46;
        r32.a();     // Catch: Throwable -> L25
    L46:
        r25 = r32;
        goto L29
    L48:
        if (r33 == g.f18806n) goto L55;
        r32.a();     // Catch: Throwable -> L25
        r23 = new n(r33);     // Catch: Throwable -> L25
        if (r112 == null) goto L52;
        r24 = new BufferedChannel$bindCancellationFunResult$1(this);     // Catch: Throwable -> L25
        goto L53
    L52:
        r24 = null;
        goto L53
    L55:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L25
    L40:
        r111.a(r32, r29);     // Catch: Throwable -> L25
        goto L61
    L37:
        r31 = r25;
        goto L38
    L30:
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L25
        r110.resumeWith(Result.m124constructorimpl(new n(new l(u()))));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r110.D();
        throw th;
    L8:
        r5 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, r21);
        goto L7
    }

    public void I(kotlinx.coroutines.selects.g r18, Object r19) {
        o r5 = (o) f18789h.get(this);
    L3:
        long r10 = d.getAndIncrement(this);
        long r11 = r10 & 1152921504606846975L;
        boolean r13 = z(r10, false);
        long r12 = g.f18798b;
        long r14 = r11 / r12;
        int r15 = (int) (r11 % r12);
        long r16 = r5.f18950c;
        Function1 r17 = this.f18795b;
        if (r16 == r14) goto L12;
        o r20 = b(this, r14, r5);
        if (r20 == null) goto L7;
        o r21 = r20;
    L13:
        o r110 = r21;
        int r22 = k(this, r21, r15, r19, r11, r18, r13);
        if (r22 == 0) goto L46;
        if (r22 == 1) goto L45;
        if (r22 == 2) goto L35;
        if (r22 == 3) goto L34;
        if (r22 == 4) goto L29;
        if (r22 != 5) goto L27;
        r110.a();
    L27:
        r5 = r110;
        goto L3
    L29:
        if (r11 >= e.get(this)) goto L31;
        r110.a();
    L31:
        if (r17 != null) goto L32;
    L10:
        r18.c(g.f18804l);
        return;
    L32:
        kotlinx.coroutines.internal.f.a(r17, r19, r18.getContext());
        goto L10
    L34:
        throw new IllegalStateException("unexpected");
    L35:
        if (r13 == false) goto L40;
        r110.i();
        if (r17 == null) goto L10;
        kotlinx.coroutines.internal.f.a(r17, r19, r18.getContext());
        goto L10
    L40:
        if ((r18 instanceof i2) == false) goto L42;
        i2 r23 = (i2) r18;
    L43:
        if (r23 == null) goto L60;
        d(this, r23, r110, r15);
        return;
    L60:
        return;
    L42:
        r23 = null;
    L45:
        r18.c(Unit.INSTANCE);
        return;
    L46:
        r110.a();
        goto L45
    L7:
        if (r13 == false) goto L3;
        if (r17 == null) goto L10;
        kotlinx.coroutines.internal.f.a(r17, r19, r18.getContext());
        goto L10
    L12:
        r21 = r5;
        goto L13
    }

    public final void J(i2 r5, boolean r10) {
        if ((r5 instanceof kotlinx.coroutines.j) == false) goto L10;
        Continuation r11 = (Continuation) r5;
        Result.Companion r12 = Result.Companion;
        if (r10 == false) goto L7;
        Throwable r13 = v();
    L8:
        r11.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r13)));
        return;
    L7:
        r13 = w();
        goto L8
    L10:
        if ((r5 instanceof v) == false) goto L13;
        kotlinx.coroutines.l r14 = ((v) r5).f18817a;
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.m124constructorimpl(new n(new l(u()))));
        return;
    L13:
        if ((r5 instanceof e) == false) goto L19;
        e r16 = (e) r5;
        kotlinx.coroutines.l r17 = r16.f18787b;
        Intrinsics.checkNotNull(r17);
        r16.f18787b = null;
        r16.f18786a = g.f18804l;
        Throwable r18 = r16.f18788c.u();
        if (r18 != null) goto L17;
        Result.Companion r19 = Result.Companion;
        r17.resumeWith(Result.m124constructorimpl(Boolean.FALSE));
        return;
    L17:
        Result.Companion r20 = Result.Companion;
        r17.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r18)));
        return;
    L19:
        if ((r5 instanceof kotlinx.coroutines.selects.g) == false) goto L23;
        ((kotlinx.coroutines.selects.g) r5).e(this, g.f18804l);
        return;
    L23:
        throw new IllegalStateException(("Unexpected waiter: " + r5).toString());
    }

    public final boolean K(Object r5, Object r10) {
        if ((r5 instanceof kotlinx.coroutines.selects.g) == true) goto L26;
        boolean r11 = r5 instanceof v;
        Function1 r12 = this.f18795b;
        Function3 r13 = null;
        if (r11 == false) goto L12;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.l r14 = ((v) r5).f18817a;
        n r15 = new n(r10);
        if (r12 == null) goto L27;
        r13 = new BufferedChannel$bindCancellationFunResult$1(this);
    L27:
        return g.a(r14, r15, r13);
    L12:
        if ((r5 instanceof e) == false) goto L18;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        e r16 = (e) r5;
        kotlinx.coroutines.l r17 = r16.f18787b;
        Intrinsics.checkNotNull(r17);
        r16.f18787b = null;
        r16.f18786a = r10;
        Boolean r18 = Boolean.TRUE;
        Function1 r19 = r16.f18788c.f18795b;
        if (r19 == null) goto L28;
        r13 = new c(0, r19, r10);
    L28:
        return g.a(r17, r18, r13);
    L18:
        if ((r5 instanceof kotlinx.coroutines.j) == false) goto L25;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.j r20 = (kotlinx.coroutines.j) r5;
        if (r12 == null) goto L23;
        r13 = new BufferedChannel$bindCancellationFun$2(this);
    L23:
        return g.a(r20, r10, r13);
    L25:
        throw new IllegalStateException(("Unexpected receiver type: " + r5).toString());
    L26:
        return ((kotlinx.coroutines.selects.g) r5).e(this, r10);
    }

    public final boolean L(Object r5, o r10, int r11) {
        if ((r5 instanceof kotlinx.coroutines.j) == false) goto L6;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        return g.a((kotlinx.coroutines.j) r5, Unit.INSTANCE, null);
    L6:
        if ((r5 instanceof kotlinx.coroutines.selects.g) == false) goto L29;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        int r12 = ((kotlinx.coroutines.selects.f) r5).l(this, Unit.INSTANCE);
        if (r12 == 0) goto L19;
        if (r12 != 1) goto L11;
        TrySelectDetailedResult r13 = TrySelectDetailedResult.REREGISTER;
    L21:
        if (r13 != TrySelectDetailedResult.REREGISTER) goto L24;
        r10.n(r11, null);
    L24:
        if (r13 == TrySelectDetailedResult.SUCCESSFUL) goto L31;
        return false;
    L31:
        return true;
    L11:
        if (r12 != 2) goto L13;
        r13 = TrySelectDetailedResult.CANCELLED;
        goto L21
    L13:
        if (r12 != 3) goto L16;
        r13 = TrySelectDetailedResult.ALREADY_SELECTED;
        goto L21
    L16:
        throw new IllegalStateException(("Unexpected internal result: " + r12).toString());
    L19:
        r13 = TrySelectDetailedResult.SUCCESSFUL;
        goto L21
    L29:
        throw new IllegalStateException(("Unexpected waiter: " + r5).toString());
    }

    public final Object M(o r10, int r11, long r12, Object r13) {
        Object r5 = r10.l(r11);
        AtomicReferenceArray r14 = r10.f;
        AtomicLongFieldUpdater r15 = d;
        if (r5 != null) goto L14;
        if (r12 < (r15.get(this) & 1152921504606846975L)) goto L19;
        if (r13 != null) goto L10;
        return g.f18806n;
    L10:
        if (r10.k(r11, r5, r13) == false) goto L19;
        s();
        return g.f18805m;
    L19:
        Object r16 = r10.l(r11);
        if (r16 == null) goto L53;
        if (r16 == g.e) goto L53;
        if (r16 == g.d) goto L27;
        g8.g r17 = g.f18802j;
        if (r16 == r17) goto L87;
        if (r16 == g.f18800h) goto L88;
        if (r16 == g.f18804l) goto L37;
        if (r16 == g.g) goto L19;
        if (r10.k(r11, r16, g.f) == false) goto L19;
        boolean r18 = r16 instanceof z;
        if (r18 == false) goto L46;
        r16 = ((z) r16).f18819a;
    L46:
        if (L(r16, r10, r11) == false) goto L48;
        r10.o(r11, g.f18801i);
        s();
        Object r19 = r14.get(r11 * 2);
        r10.n(r11, null);
        return r19;
    L48:
        r10.o(r11, r17);
        r10.i();
        if (r18 == false) goto L91;
        s();
    L91:
        return g.f18807o;
    L37:
        s();
        return g.f18807o;
    L88:
        return g.f18807o;
    L87:
        return g.f18807o;
    L27:
        if (r10.k(r11, r16, g.f18801i) == false) goto L19;
        s();
        Object r20 = r14.get(r11 * 2);
        r10.n(r11, null);
        return r20;
    L53:
        if (r12 < (r15.get(this) & 1152921504606846975L)) goto L55;
        if (r13 == null) goto L93;
        if (r10.k(r11, r16, r13) == false) goto L19;
        s();
        return g.f18805m;
    L93:
        return g.f18806n;
    L55:
        if (r10.k(r11, r16, g.f18800h) == false) goto L19;
        s();
        return g.f18807o;
    L14:
        if (r5 != g.d) goto L19;
        if (r10.k(r11, r5, g.f18801i) == false) goto L19;
        s();
        Object r21 = r14.get(r11 * 2);
        r10.n(r11, null);
        return r21;
    }

    public final int N(o r10, int r11, Object r12, long r13, Object r14, boolean r15) {
    L2:
        Object r5 = r10.l(r11);
        if (r5 == null) goto L5;
        if (r5 != g.e) goto L27;
        if (r10.k(r11, r5, g.d) == false) goto L2;
        return 1;
    L27:
        g8.g r16 = g.f18803k;
        if (r5 != r16) goto L32;
        r10.n(r11, null);
        return 5;
    L32:
        if (r5 != g.f18800h) goto L36;
        r10.n(r11, null);
        return 5;
    L36:
        if (r5 != g.f18804l) goto L39;
        r10.n(r11, null);
        B();
        return 4;
    L39:
        r10.n(r11, null);
        if ((r5 instanceof z) == false) goto L43;
        r5 = ((z) r5).f18819a;
    L43:
        if (K(r5, r12) == false) goto L46;
        r10.o(r11, g.f18801i);
        return 0;
    L46:
        if (r10.f.getAndSet((r11 * 2) + 1, r16) == r16) goto L68;
        r10.m(r11, true);
        return 5;
    L68:
        return 5;
    L5:
        if (m(r13) == false) goto L10;
        if (r15 == true) goto L10;
        if (r10.k(r11, null, g.d) == false) goto L2;
        return 1;
    L10:
        if (r15 == true) goto L12;
        if (r14 == null) goto L16;
        if (r10.k(r11, null, r14) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r10.k(r11, null, g.f18802j) == false) goto L2;
        r10.i();
        return 4;
    }

    public final void O(long r19) {
        if (D() == false) goto L5;
        return;
    L5:
        AtomicLongFieldUpdater r10 = f;
        if (r10.get(this) <= r19) goto L5;
        int r5 = g.f18799c;
        int r11 = 0;
    L8:
        AtomicLongFieldUpdater r12 = g;
        if (r11 >= r5) goto L16;
        long r13 = r10.get(this);
        if (r13 != (r12.get(this) & DurationKt.MAX_MILLIS)) goto L15;
        if (r13 != r10.get(this)) goto L15;
        return;
    L15:
        r11 = r11 + 1;
    L16:
        long r14 = r12.get(this);
        if (r12.compareAndSet(this, r14, 4611686018427387904L + (r14 & DurationKt.MAX_MILLIS)) == false) goto L16;
    L18:
        long r15 = r10.get(this);
        long r16 = r12.get(this);
        long r17 = r16 & DurationKt.MAX_MILLIS;
        if ((r16 & 4611686018427387904L) == 0) goto L21;
        boolean r18 = true;
    L23:
        if (r15 == r17) goto L25;
    L29:
        if (r18 == true) goto L18;
        r12.compareAndSet(this, r16, r17 + 4611686018427387904L);
        goto L18
    L25:
        if (r15 != r10.get(this)) goto L29;
    L26:
        long r20 = r12.get(this);
        if (r12.compareAndSet(this, r20, r20 & DurationKt.MAX_MILLIS) == false) goto L26;
        return;
    L21:
        r18 = false;
        goto L23
    }

    @Override // kotlinx.coroutines.channels.w
    public final Object a(ContinuationImpl r5) {
        return G(this, r5);
    }

    @Override // kotlinx.coroutines.channels.w
    public final void cancel(CancellationException r5) {
        if (r5 != null) goto L4;
        r5 = new CancellationException("Channel was cancelled");
    L4:
        n(true, r5);
    }

    @Override // kotlinx.coroutines.channels.x
    public final void f(Function1 r5) {
    L2:
        AtomicReferenceFieldUpdater r10 = f18793l;
        if (r10.compareAndSet(this, null, r5) == true) goto L4;
        if (r10.get(this) == null) goto L2;
    L7:
        Object r11 = r10.get(this);
        g8.g r12 = g.f18809q;
        if (r11 != r12) goto L18;
        g8.g r13 = g.f18810r;
    L11:
        if (r10.compareAndSet(this, r12, r13) == true) goto L12;
        if (r10.get(this) == r12) goto L11;
    L12:
        r5.invoke(u());
        return;
    L18:
        if (r11 != g.f18810r) goto L22;
        throw new IllegalStateException("Another handler was already registered and successfully invoked");
    L22:
        throw new IllegalStateException(("Another handler is already registered: " + r11).toString());
    }

    @Override // kotlinx.coroutines.channels.x
    public Object g(Object r21) {
        AtomicLongFieldUpdater r10 = d;
        long r5 = r10.get(this);
        boolean r11 = false;
        if (z(r5, false) == false) goto L5;
        boolean r12 = false;
    L6:
        m r14 = n.f18814b;
        if (r12 == false) goto L9;
        return r14;
    L9:
        oo.c r15 = g.f18802j;
        o r13 = (o) f18789h.get(this);
    L10:
        long r16 = r10.getAndIncrement(this);
        long r17 = r16 & 1152921504606846975L;
        boolean r18 = z(r16, r11);
        int r19 = g.f18798b;
        long r20 = r17 / ((long) r19);
        int r22 = (int) (r17 % ((long) r19));
        if (r13.f18950c == r20) goto L17;
        o r23 = b(this, r20, r13);
        if (r23 == null) goto L14;
        o r24 = r23;
    L18:
        o r110 = r24;
        int r25 = k(this, r24, r22, r21, r17, r15, r18);
        if (r25 == 0) goto L49;
        if (r25 == 1) goto L66;
        if (r25 == 2) goto L38;
        if (r25 == 3) goto L37;
        if (r25 == 4) goto L33;
        if (r25 != 5) goto L31;
        r110.a();
    L31:
        r13 = r110;
        r11 = false;
        goto L10
    L33:
        if (r17 >= e.get(this)) goto L63;
        r110.a();
    L63:
        return new l(w());
    L37:
        throw new IllegalStateException("unexpected");
    L38:
        if (r18 == false) goto L41;
        r110.i();
        return new l(w());
    L41:
        if ((r15 instanceof i2) == false) goto L43;
        i2 r111 = (i2) r15;
    L45:
        if (r111 == null) goto L47;
        d(this, r111, r110, r22);
    L47:
        r110.i();
        return r14;
    L43:
        r111 = null;
    L66:
        return Unit.INSTANCE;
    L49:
        r110.a();
        goto L66
    L14:
        if (r18 == false) goto L10;
        return new l(w());
    L17:
        r24 = r13;
        goto L18
    L5:
        r12 = !m(r5 & 1152921504606846975L);
        goto L6
    }

    @Override // kotlinx.coroutines.channels.w
    public final com.bytedance.ies.web.jsbridge2.p h() {
        BufferedChannel$onReceive$1 r5 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 r10 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 3);
        BufferedChannel$onReceive$2 r11 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        int r12 = 5;
        return new com.bytedance.ies.web.jsbridge2.p(r12, this, r10, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r11, 3), this.f18796c);
    }

    @Override // kotlinx.coroutines.channels.w
    public final com.bytedance.ies.web.jsbridge2.p i() {
        BufferedChannel$onReceiveCatching$1 r5 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 r10 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 3);
        BufferedChannel$onReceiveCatching$2 r11 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        int r12 = 5;
        return new com.bytedance.ies.web.jsbridge2.p(r12, this, r10, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r11, 3), this.f18796c);
    }

    @Override // kotlinx.coroutines.channels.w
    public final k iterator() {
        return new e(this);
    }

    @Override // kotlinx.coroutines.channels.w
    public final Object j() {
        AtomicLongFieldUpdater r5 = e;
        long r10 = r5.get(this);
        long r11 = d.get(this);
        if (z(r11, true) == true) goto L5;
        long r12 = r11 & 1152921504606846975L;
        Object r13 = n.f18814b;
        if (r10 < r12) goto L9;
        return r13;
    L9:
        Object r14 = g.f18803k;
        o r15 = (o) f18790i.get(this);
    L11:
        if (A() == true) goto L50;
        long r16 = r5.getAndIncrement(this);
        long r17 = g.f18798b;
        long r18 = r16 / r17;
        int r19 = (int) (r16 % r17);
        if (r15.f18950c == r18) goto L19;
        o r20 = t(r18, r15);
        if (r20 == null) goto L11;
        o r110 = r20;
    L20:
        Object r21 = M(r110, r19, r16, r14);
        if (r21 == g.f18805m) goto L23;
        if (r21 != g.f18807o) goto L36;
        if (r16 >= x()) goto L34;
        r110.a();
    L34:
        r15 = r110;
        goto L11
    L36:
        if (r21 == g.f18806n) goto L41;
        r110.a();
        r13 = r21;
    L39:
        return r13;
    L41:
        throw new IllegalStateException("unexpected");
    L23:
        if ((r14 instanceof i2) == false) goto L25;
        i2 r22 = (i2) r14;
    L26:
        if (r22 == null) goto L28;
        r22.a(r110, r19);
    L28:
        O(r16);
        r110.i();
        goto L39
    L25:
        r22 = null;
        goto L26
    L19:
        r110 = r15;
        goto L20
    L50:
        return new l(u());
    L5:
        return new l(u());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [kotlinx.coroutines.l] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object, kotlinx.coroutines.channels.f] */
    @Override // kotlinx.coroutines.channels.w
    public final Object l(Continuation r18) {
        AtomicReferenceFieldUpdater r10 = f18790i;
        o r5 = (o) r10.get(this);
    L4:
        if (A() == true) goto L78;
        AtomicLongFieldUpdater r11 = e;
        long r12 = r11.getAndIncrement(this);
        long r13 = g.f18798b;
        long r14 = r12 / r13;
        int r15 = (int) (r12 % r13);
        if (r5.f18950c == r14) goto L11;
        o r16 = t(r14, r5);
        if (r16 == null) goto L4;
        o r17 = r16;
    L12:
        Object r19 = M(r17, r15, r12, null);
        g8.g r110 = g.f18805m;
        if (r19 == r110) goto L77;
        g8.g r111 = g.f18807o;
        if (r19 != r111) goto L21;
        if (r12 >= x()) goto L19;
        r17.a();
    L19:
        r5 = r17;
        goto L4
    L21:
        if (r19 != g.f18806n) goto L74;
        kotlinx.coroutines.l r20 = kotlinx.coroutines.j0.h(IntrinsicsKt.intercepted(r18));
        Object r21 = M(r17, r15, r12, r20);     // Catch: Throwable -> L70
        if (r21 != r110) goto L28;
        kotlinx.coroutines.l r112 = r20;
        r112.a(r17, r15);     // Catch: Throwable -> L33
    L67:
        r19 = r112.v();
        if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L75;
        DebugProbesKt.probeCoroutineSuspended(r18);
    L75:
        return r19;
    L28:
        r112 = r20;
        BufferedChannel$bindCancellationFun$2 r113 = null;
        Function1 r22 = this.f18795b;
        if (r21 == r111) goto L31;
        r17.a();     // Catch: Throwable -> L33
        if (r22 != null) goto L65;
    L60:
        r112.k(r21, r113);     // Catch: Throwable -> L33
        goto L67
    L65:
        r113 = new BufferedChannel$bindCancellationFun$2(this);     // Catch: Throwable -> L33
        goto L60
    L31:
        if (r12 >= x()) goto L35;
        r17.a();     // Catch: Throwable -> L33
    L35:
        o r23 = (o) r10.get(this);     // Catch: Throwable -> L33
    L37:
        if (A() == true) goto L38;
        long r24 = r11.getAndIncrement(this);     // Catch: Throwable -> L33
        long r25 = g.f18798b;     // Catch: Throwable -> L33
        long r26 = r24 / r25;     // Catch: Throwable -> L33
        int r27 = (int) (r24 % r25);     // Catch: Throwable -> L33
        if (r23.f18950c == r26) goto L45;
        o r28 = t(r26, r23);     // Catch: Throwable -> L33
        if (r28 == null) goto L37;
        o r114 = r28;
    L46:
        Function1 r115 = r22;
        r21 = M(r114, r27, r24, r112);     // Catch: Throwable -> L33
        if (r21 == g.f18805m) goto L48;
        if (r21 != g.f18807o) goto L56;
        if (r24 >= x()) goto L54;
        r114.a();     // Catch: Throwable -> L33
    L54:
        r23 = r114;
        r22 = r115;
        goto L37
    L56:
        if (r21 == g.f18806n) goto L62;
        r114.a();     // Catch: Throwable -> L33
        if (r115 == null) goto L60;
        r113 = new BufferedChannel$bindCancellationFun$2(this);     // Catch: Throwable -> L33
        goto L60
    L62:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L33
    L48:
        r112.a(r114, r27);     // Catch: Throwable -> L33
        goto L67
    L45:
        r114 = r23;
        goto L46
    L38:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L33
        r112.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(v())));     // Catch: Throwable -> L33
    L33:
        th = th;
        ?? r116 = r110;
    L72:
        r116.D();
        throw th;
    L70:
        th = th;
        r116 = r20;
        goto L72
    L74:
        r17.a();
        goto L75
    L77:
        throw new IllegalStateException("unexpected");
    L11:
        r17 = r5;
        goto L12
    L78:
        Throwable r30 = v();
        int r31 = kotlinx.coroutines.internal.t.f18951a;
        throw r30;
    }

    public final boolean m(long r5) {
        if (r5 >= f.get(this)) goto L5;
    L8:
        return true;
    L5:
        if (r5 < (e.get(this) + ((long) this.f18794a))) goto L8;
        return false;
    }

    public final boolean n(boolean r14, Throwable r15) {
        AtomicLongFieldUpdater r10 = d;
        if (r14 == false) goto L8;
    L4:
        long r5 = r10.get(this);
        if (((int) (r5 >> 60)) != 0) goto L8;
        o r11 = g.f18797a;
        if (r10.compareAndSet(this, r5, (((long) 1) << 60) + (r5 & 1152921504606846975L)) == false) goto L4;
    L8:
        g8.g r12 = g.s;
    L9:
        AtomicReferenceFieldUpdater r13 = f18792k;
        if (r13.compareAndSet(this, r12, r15) == true) goto L11;
        if (r13.get(this) == r12) goto L9;
        boolean r16 = false;
    L16:
        if (r14 == false) goto L20;
    L17:
        long r17 = r10.get(this);
        if (r10.compareAndSet(this, r17, (((long) 3) << 60) + (r17 & 1152921504606846975L)) == false) goto L17;
    L29:
        B();
        if (r16 == false) goto L43;
    L31:
        AtomicReferenceFieldUpdater r18 = f18793l;
        Object r19 = r18.get(this);
        if (r19 != null) goto L34;
        g8.g r20 = g.f18809q;
    L36:
        if (r18.compareAndSet(this, r19, r20) == true) goto L37;
        if (r18.get(this) == r19) goto L36;
    L37:
        if (r19 == null) goto L43;
        Function1 r110 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r19, 1);
        ((Function1) r19).invoke(u());
        goto L43
    L34:
        r20 = g.f18810r;
    L43:
        return r16;
    L20:
        long r21 = r10.get(this);
        int r111 = (int) (r21 >> 60);
        if (r111 == 0) goto L26;
        if (r111 != 1) goto L29;
        long r112 = r21 & 1152921504606846975L;
        long r22 = 3;
    L28:
        if (r10.compareAndSet(this, r21, (r22 << 60) + r112) == false) goto L20;
    L26:
        r112 = r21 & 1152921504606846975L;
        r22 = 2;
        goto L28
    L11:
        r16 = true;
        goto L16
    }

    @Override // kotlinx.coroutines.channels.x
    public final boolean o(Throwable r5) {
        return n(false, r5);
    }

    public final o p(long r13) {
        Object r5 = f18791j.get(this);
        o r10 = (o) f18789h.get(this);
        if (r10.f18950c <= ((o) r5).f18950c) goto L5;
        r5 = r10;
    L5:
        o r11 = (o) f18790i.get(this);
        if (r11.f18950c <= ((o) r5).f18950c) goto L8;
        r5 = r11;
    L8:
        kotlinx.coroutines.internal.b r12 = (kotlinx.coroutines.internal.b) r5;
    L9:
        r12.getClass();
        Object r14 = kotlinx.coroutines.internal.b.f18927a.get(r12);
        g8.g r15 = kotlinx.coroutines.internal.a.f18926a;
        Object r16 = null;
        if (r14 == r15) goto L16;
        kotlinx.coroutines.internal.b r17 = (kotlinx.coroutines.internal.b) r14;
        if (r17 == null) goto L14;
        r12 = r17;
    L14:
        AtomicReferenceFieldUpdater r18 = kotlinx.coroutines.internal.b.f18927a;
        if (r18.compareAndSet(r12, null, r15) == true) goto L16;
        if (r18.get(r12) == null) goto L14;
    L16:
        o r19 = (o) r12;
        if (C() == false) goto L43;
        o r20 = r19;
    L19:
        int r21 = g.f18798b - 1;
    L21:
        if ((-1) >= r21) goto L37;
        long r110 = (r20.f18950c * g.f18798b) + ((long) r21);
        if (r110 < e.get(this)) goto L24;
    L25:
        Object r22 = r20.l(r21);
        if (r22 == null) goto L34;
        if (r22 == g.e) goto L34;
        if (r22 != g.d) goto L36;
    L41:
        if (r110 == (-1)) goto L43;
        q(r110);
    L36:
        r21 = r21 - 1;
    L34:
        if (r20.k(r21, r22, g.f18804l) == false) goto L25;
        r20.i();
    L24:
        r110 = -1;
        goto L41
    L37:
        r20 = (o) ((kotlinx.coroutines.internal.b) kotlinx.coroutines.internal.b.f18928b.get(r20));
        if (r20 != null) goto L19;
    L43:
        o r23 = r19;
    L44:
        if (r23 == null) goto L69;
        int r24 = g.f18798b - 1;
    L46:
        if ((-1) >= r24) goto L68;
        if (((r23.f18950c * g.f18798b) + ((long) r24)) < r13) goto L69;
    L49:
        Object r25 = r23.l(r24);
        if (r25 == null) goto L65;
        if (r25 == g.e) goto L65;
        if ((r25 instanceof z) == true) goto L57;
        if ((r25 instanceof i2) == false) goto L67;
        if (r23.k(r24, r25, g.f18804l) == false) goto L49;
        r16 = kotlinx.coroutines.internal.f.g(r16, r25);
        r23.m(r24, true);
    L67:
        r24 = r24 - 1;
        goto L46
    L57:
        if (r23.k(r24, r25, g.f18804l) == false) goto L49;
        r16 = kotlinx.coroutines.internal.f.g(r16, ((z) r25).f18819a);
        r23.m(r24, true);
    L65:
        if (r23.k(r24, r25, g.f18804l) == false) goto L49;
        r23.i();
        goto L67
    L68:
        r23 = (o) ((kotlinx.coroutines.internal.b) kotlinx.coroutines.internal.b.f18928b.get(r23));
    L69:
        if (r16 != null) goto L71;
    L76:
        return r19;
    L71:
        if ((r16 instanceof ArrayList) == true) goto L73;
        J((i2) r16, true);
        goto L76
    L73:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
        ArrayList r26 = (ArrayList) r16;
        int r111 = r26.size() - 1;
    L74:
        if ((-1) >= r111) goto L76;
        J((i2) r26.get(r111), true);
        r111 = r111 - 1;
        goto L74
    }

    public final void q(long r11) {
        o r5 = (o) f18790i.get(this);
    L3:
        AtomicLongFieldUpdater r10 = e;
        long r12 = r10.get(this);
        if (r11 < Math.max(((long) this.f18794a) + r12, f.get(this))) goto L5;
        if (r10.compareAndSet(this, r12, r12 + 1) == false) goto L3;
        long r13 = g.f18798b;
        long r14 = r12 / r13;
        int r15 = (int) (r12 % r13);
        if (r5.f18950c == r14) goto L14;
        o r16 = t(r14, r5);
        if (r16 == null) goto L3;
        r5 = r16;
    L14:
        Object r17 = M(r5, r15, r12, null);
        if (r17 == g.f18807o) goto L17;
        r5.a();
        Function1 r18 = this.f18795b;
        if (r18 == null) goto L3;
        UndeliveredElementException r19 = kotlinx.coroutines.internal.f.b(r18, r17, null);
        if (r19 == null) goto L3;
        throw r19;
    L17:
        if (r12 >= x()) goto L3;
        r5.a();
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.l] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlinx.coroutines.channels.x
    public Object r(Object r24, Continuation r25) {
        AtomicReferenceFieldUpdater r10 = f18789h;
        o r5 = (o) r10.get(this);
    L3:
        AtomicLongFieldUpdater r11 = d;
        long r12 = r11.getAndIncrement(this);
        long r14 = r12 & 1152921504606846975L;
        boolean r16 = z(r12, false);
        long r13 = g.f18798b;
        long r15 = r14 / r13;
        int r17 = (int) (r14 % r13);
        if (r5.f18950c == r15) goto L12;
        o r18 = b(this, r15, r5);
        if (r18 == null) goto L7;
        o r19 = r18;
    L13:
        o r110 = r19;
        int r20 = k(this, r19, r17, r24, r14, null, r16);
        if (r20 == 0) goto L118;
        if (r20 == 1) goto L120;
        if (r20 == 2) goto L114;
        AtomicLongFieldUpdater r21 = e;
        if (r20 == 3) goto L32;
        if (r20 == 4) goto L27;
        if (r20 != 5) goto L25;
        r110.a();
    L25:
        r5 = r110;
        goto L3
    L27:
        if (r14 >= r21.get(this)) goto L29;
        r110.a();
    L29:
        Object r22 = F(r24, r25);
        if (r22 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L120;
        return r22;
    L32:
        kotlinx.coroutines.l r111 = kotlinx.coroutines.j0.h(IntrinsicsKt.intercepted(r25));
        int r23 = k(this, r110, r17, r24, r14, r111, false);     // Catch: Throwable -> L90
        if (r23 == 0) goto L99;
        if (r23 != 1) goto L37;
        kotlinx.coroutines.l r26 = r111;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L81
        Object r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L88:
        r26.resumeWith(r28);     // Catch: Throwable -> L81
    L101:
        Object r29 = r26.v();
        if (r29 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L105;
        DebugProbesKt.probeCoroutineSuspended(r25);
    L105:
        if (r29 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L109;
        r29 = Unit.INSTANCE;
    L109:
        if (r29 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L120;
        return r29;
    L37:
        if (r23 != 2) goto L39;
        r26 = r111;
        d(this, r26, r110, r17);     // Catch: Throwable -> L81
        goto L101
    L39:
        if (r23 != 4) goto L41;
        r26 = r111;
        if (r14 < r21.get(this)) goto L96;
    L78:
        c(this, r24, r26);     // Catch: Throwable -> L81
        goto L101
    L96:
        r110.a();     // Catch: Throwable -> L81
        goto L78
    L41:
        if (r23 != 5) goto L93;
        r110.a();     // Catch: Throwable -> L90
        o r30 = (o) r10.get(this);     // Catch: Throwable -> L90
    L43:
        long r31 = r11.getAndIncrement(this);     // Catch: Throwable -> L90
        long r210 = r31 & 1152921504606846975L;     // Catch: Throwable -> L90
        boolean r112 = z(r31, false);     // Catch: Throwable -> L90
        long r32 = g.f18798b;     // Catch: Throwable -> L90
        long r33 = r210 / r32;     // Catch: Throwable -> L90
        int r34 = (int) (r210 % r32);     // Catch: Throwable -> L90
        if (r30.f18950c == r33) goto L57;
        o r35 = b(this, r33, r30);     // Catch: Throwable -> L55
        if (r35 != null) goto L54;
        if (r112 == false) goto L43;
        kotlinx.coroutines.l r36 = r111;
        c(this, r24, r36);     // Catch: Throwable -> L52
        r26 = r36;
    L52:
        th = th;
    L53:
        ?? r37 = r36;
    L111:
        r37.D();
        throw th;
    L54:
        o r38 = r35;
    L58:
        o r113 = r38;
        kotlinx.coroutines.l r211 = r111;
        int r39 = k(this, r38, r34, r24, r210, r111, r112);     // Catch: Throwable -> L72
        if (r39 == 0) goto L89;
        if (r39 == 1) goto L87;
        if (r39 == 2) goto L83;
        if (r39 == 3) goto L80;
        if (r39 == 4) goto L75;
        if (r39 != 5) goto L71;
        r113.a();     // Catch: Throwable -> L72
    L71:
        r30 = r113;
        r111 = r211;
        goto L43
    L75:
        if (r210 >= r21.get(this)) goto L77;
        r113.a();     // Catch: Throwable -> L72
    L77:
        r26 = r211;
        goto L78
    L80:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L81
    L83:
        r26 = r211;
        if (r112 == false) goto L86;
        r113.i();     // Catch: Throwable -> L81
        goto L78
    L86:
        d(this, r26, r113, r34);     // Catch: Throwable -> L81
        goto L101
    L87:
        r26 = r211;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L81
        r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L81
        goto L88
    L89:
        r26 = r211;
        r113.a();     // Catch: Throwable -> L81
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L81
        r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L72:
        th = th;
        r37 = r211;
    L55:
        th = th;
        r36 = r111;
        goto L53
    L57:
        r38 = r30;
        goto L58
    L93:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L81
    L99:
        r26 = r111;
        r110.a();     // Catch: Throwable -> L81
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L81
        r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L81:
        th = th;
        r37 = r23;
    L90:
        th = th;
        r37 = r111;
        goto L111
    L114:
        if (r16 == false) goto L120;
        r110.i();
        Object r43 = F(r24, r25);
        if (r43 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L120;
        return r43;
    L120:
        return Unit.INSTANCE;
    L118:
        r110.a();
        goto L120
    L7:
        if (r16 == false) goto L3;
        Object r44 = F(r24, r25);
        if (r44 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L120;
        return r44;
    L12:
        r19 = r5;
        goto L13
    }

    public final void s() {
        if (D() == false) goto L5;
        return;
    L5:
        AtomicReferenceFieldUpdater r10 = f18791j;
        o r11 = (o) r10.get(this);
    L6:
        long r12 = f.getAndIncrement(this);
        long r5 = r12 / ((long) g.f18798b);
        if (x() <= r12) goto L9;
        if (r11.f18950c == r5) goto L54;
        BufferedChannelKt$createSegmentFunction$1 r13 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    L18:
        Object r14 = kotlinx.coroutines.internal.a.a(r11, r5, r13);
        if (kotlinx.coroutines.internal.f.f(r14) == true) goto L37;
        kotlinx.coroutines.internal.s r15 = kotlinx.coroutines.internal.f.d(r14);
    L21:
        kotlinx.coroutines.internal.s r16 = (kotlinx.coroutines.internal.s) r10.get(this);
        if (r16.f18950c >= r15.f18950c) goto L37;
        if (r15.j() == false) goto L18;
    L28:
        if (r10.compareAndSet(this, r16, r15) == true) goto L30;
        if (r10.get(this) == r16) goto L28;
        if (r15.f() == false) goto L21;
        r15.e();
        goto L21
    L30:
        if (r16.f() == false) goto L37;
        r16.e();
    L37:
        o r17 = null;
        if (kotlinx.coroutines.internal.f.f(r14) == false) goto L40;
        B();
        E(r5, r11);
        y(this);
    L51:
        if (r17 == null) goto L6;
        r11 = r17;
        goto L54
    L40:
        o r18 = (o) kotlinx.coroutines.internal.f.d(r14);
        long r19 = r18.f18950c;
        if (r19 <= r5) goto L50;
        long r110 = g.f18798b;
        if (f.compareAndSet(this, r12 + 1, r19 * r110) == false) goto L49;
        AtomicLongFieldUpdater r20 = g;
        if ((r20.addAndGet(this, (r19 * r110) - r12) & 4611686018427387904L) == 0) goto L51;
    L47:
        if ((r20.get(this) & 4611686018427387904L) == 0) goto L51;
    L49:
        y(this);
        goto L51
    L50:
        r17 = r18;
    L54:
        int r21 = (int) (r12 % ((long) g.f18798b));
        Object r22 = r11.l(r21);
        boolean r23 = r22 instanceof i2;
        AtomicLongFieldUpdater r24 = e;
        if (r23 == false) goto L64;
        if (r12 < r24.get(this)) goto L64;
        if (r11.k(r21, r22, g.g) == false) goto L64;
        if (L(r22, r11, r21) == true) goto L62;
        r11.o(r21, g.f18802j);
        r11.i();
    L79:
        y(this);
        goto L6
    L62:
        r11.o(r21, g.d);
    L102:
        y(this);
        return;
    L64:
        Object r25 = r11.l(r21);
        if ((r25 instanceof i2) == true) goto L67;
        if (r25 == g.f18802j) goto L79;
        if (r25 == null) goto L82;
        if (r25 == g.d) goto L102;
        if (r25 == g.f18800h) goto L102;
        if (r25 == g.f18801i) goto L102;
        if (r25 == g.f18803k) goto L102;
        if (r25 == g.f18804l) goto L102;
        if (r25 == g.f) goto L64;
        throw new IllegalStateException(("Unexpected cell state: " + r25).toString());
    L82:
        if (r11.k(r21, r25, g.e) == false) goto L64;
    L67:
        if (r12 < r24.get(this)) goto L69;
        if (r11.k(r21, r25, g.g) == false) goto L64;
        if (L(r25, r11, r21) == true) goto L75;
        r11.o(r21, g.f18802j);
        r11.i();
        goto L79
    L75:
        r11.o(r21, g.d);
        goto L102
    L69:
        if (r11.k(r21, r25, new z((i2) r25)) == false) goto L64;
    L9:
        if (r11.f18950c < r5) goto L11;
    L13:
        y(this);
        return;
    L11:
        if (r11.c() == null) goto L13;
        E(r5, r11);
        goto L13
    }

    public final o t(long r12, o r14) {
        o r5 = g.f18797a;
        BufferedChannelKt$createSegmentFunction$1 r10 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    L3:
        Object r11 = kotlinx.coroutines.internal.a.a(r14, r12, r10);
        if (kotlinx.coroutines.internal.f.f(r11) == true) goto L23;
        kotlinx.coroutines.internal.s r13 = kotlinx.coroutines.internal.f.d(r11);
    L6:
        AtomicReferenceFieldUpdater r15 = f18790i;
        kotlinx.coroutines.internal.s r16 = (kotlinx.coroutines.internal.s) r15.get(this);
        if (r16.f18950c >= r13.f18950c) goto L23;
        if (r13.j() == false) goto L3;
    L13:
        if (r15.compareAndSet(this, r16, r13) == true) goto L15;
        if (r15.get(this) == r16) goto L13;
        if (r13.f() == false) goto L6;
        r13.e();
        goto L6
    L15:
        if (r16.f() == false) goto L23;
        r16.e();
    L23:
        if (kotlinx.coroutines.internal.f.f(r11) == false) goto L27;
        B();
        if ((r14.f18950c * g.f18798b) >= x()) goto L80;
        r14.a();
        return null;
    L80:
        return null;
    L27:
        o r17 = (o) kotlinx.coroutines.internal.f.d(r11);
        boolean r18 = D();
        long r19 = r17.f18950c;
        if (r18 == true) goto L46;
        if (r12 > (f.get(this) / ((long) g.f18798b))) goto L46;
    L31:
        AtomicReferenceFieldUpdater r20 = f18791j;
        kotlinx.coroutines.internal.s r21 = (kotlinx.coroutines.internal.s) r20.get(this);
        if (r21.f18950c >= r19) goto L46;
        if (r17.j() == false) goto L46;
    L36:
        if (r20.compareAndSet(this, r21, r17) == true) goto L38;
        if (r20.get(this) == r21) goto L36;
        if (r17.f() == false) goto L31;
        r17.e();
        goto L31
    L38:
        if (r21.f() == false) goto L46;
        r21.e();
    L46:
        if (r19 <= r12) goto L57;
        long r110 = ((long) g.f18798b) * r19;
    L48:
        AtomicLongFieldUpdater r22 = e;
        long r23 = r22.get(this);
        if (r23 >= r110) goto L54;
        if (r22.compareAndSet(this, r23, r110) == false) goto L48;
    L54:
        if ((r19 * ((long) g.f18798b)) >= x()) goto L82;
        r17.a();
        return null;
    L82:
        return null;
    L57:
        return r17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        int r10 = (int) (d.get(this) >> 60);
        if (r10 == 2) goto L7;
        if (r10 != 3) goto L8;
        r5.append("cancelled,");
    L8:
        r5.append("capacity=" + this.f18794a + ',');
        r5.append("data=[");
        int r11 = 0;
        List r12 = CollectionsKt.listOf(new o[]{f18790i.get(this), f18789h.get(this), f18791j.get(this)});
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Object r15 = r14.next();
        if (((o) r15) == g.f18797a) goto L10;
        r13.add(r15);
        goto L10
    L14:
        Iterator r16 = r13.iterator();
        if (r16.hasNext() == false) goto L92;
        Object r17 = r16.next();
        if (r16.hasNext() == false) goto L25;
        long r18 = ((o) r17).f18950c;
    L20:
        Object r19 = r16.next();
        long r110 = ((o) r19).f18950c;
        if (r18 <= r110) goto L24;
        r17 = r19;
        r18 = r110;
    L24:
        if (r16.hasNext() == true) goto L20;
    L25:
        o r20 = (o) r17;
        long r111 = e.get(this);
        long r112 = x();
    L26:
        int r21 = g.f18798b;
        int r22 = r11;
    L27:
        if (r22 >= r21) goto L83;
        long r23 = (r20.f18950c * ((long) g.f18798b)) + ((long) r22);
        if (r23 >= r112) goto L31;
    L32:
        Object r113 = r20.l(r22);
        Object r24 = r20.f.get(r22 * 2);
        if ((r113 instanceof kotlinx.coroutines.j) == false) goto L43;
        if (r23 >= r111) goto L38;
        if (r23 < r112) goto L38;
        String r25 = "receive";
    L79:
        if (r24 == null) goto L81;
        r5.append("(" + r25 + ',' + r24 + "),");
    L82:
        r22 = r22 + 1;
        goto L27
    L81:
        r5.append(r25 + ',');
    L38:
        if (r23 >= r112) goto L41;
        if (r23 < r111) goto L41;
        r25 = "send";
    L41:
        r25 = "cont";
        goto L79
    L43:
        if ((r113 instanceof kotlinx.coroutines.selects.g) == false) goto L53;
        if (r23 >= r111) goto L48;
        if (r23 < r112) goto L48;
        r25 = "onReceive";
    L48:
        if (r23 >= r112) goto L51;
        if (r23 < r111) goto L51;
        r25 = "onSend";
    L51:
        r25 = "select";
        goto L79
    L53:
        if ((r113 instanceof v) == false) goto L56;
        r25 = "receiveCatching";
        goto L79
    L56:
        if ((r113 instanceof z) == false) goto L59;
        r25 = "EB(" + r113 + ')';
        goto L79
    L59:
        if (Intrinsics.areEqual(r113, g.f) == false) goto L61;
    L78:
        r25 = "resuming_sender";
        goto L79
    L61:
        if (Intrinsics.areEqual(r113, g.g) == true) goto L78;
        if (r113 == null) goto L82;
        if (Intrinsics.areEqual(r113, g.e) == true) goto L82;
        if (Intrinsics.areEqual(r113, g.f18801i) == true) goto L82;
        if (Intrinsics.areEqual(r113, g.f18800h) == true) goto L82;
        if (Intrinsics.areEqual(r113, g.f18803k) == true) goto L82;
        if (Intrinsics.areEqual(r113, g.f18802j) == true) goto L82;
        if (Intrinsics.areEqual(r113, g.f18804l) == true) goto L82;
        r25 = r113.toString();
        goto L79
    L31:
        if (r23 < r111) goto L32;
    L86:
        if (StringsKt.last(r5) != ',') goto L88;
        r5.deleteCharAt(r5.length() - 1);
    L88:
        r5.append("]");
        return r5.toString();
    L83:
        r20 = (o) r20.c();
        if (r20 == null) goto L86;
        r11 = 0;
        goto L26
    L92:
        throw new NoSuchElementException();
    L7:
        r5.append("closed,");
        goto L8
    }

    public final Throwable u() {
        return (Throwable) f18792k.get(this);
    }

    public final Throwable v() {
        Throwable r5 = u();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new ClosedReceiveChannelException("Channel was closed");
    }

    public final Throwable w() {
        Throwable r5 = u();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new ClosedSendChannelException("Channel was closed");
    }

    public final long x() {
        return d.get(this) & 1152921504606846975L;
    }

    public final boolean z(long r19, boolean r21) {
        int r5 = (int) (r19 >> 60);
        if (r5 != 0) goto L5;
        return false;
    L5:
        if (r5 == 1) goto L160;
        AtomicLongFieldUpdater r10 = e;
        if (r5 != 2) goto L9;
        p(r19 & 1152921504606846975L);
        if (r21 == false) goto L161;
    L74:
        AtomicReferenceFieldUpdater r11 = f18790i;
        o r12 = (o) r11.get(this);
        long r13 = r10.get(this);
        if (x() <= r13) goto L161;
        long r14 = g.f18798b;
        long r15 = r13 / r14;
        if (r12.f18950c == r15) goto L84;
        r12 = t(r15, r12);
        if (r12 != null) goto L84;
        if (((o) r11.get(this)).f18950c >= r15) goto L74;
    L84:
        r12.a();
        int r16 = (int) (r13 % r14);
    L85:
        Object r17 = r12.l(r16);
        if (r17 == null) goto L115;
        if (r17 == g.e) goto L115;
        if (r17 == g.d) goto L162;
        if (r17 != g.f18802j) goto L97;
    L117:
        e.compareAndSet(this, r13, r13 + 1);
        goto L74
    L97:
        if (r17 == g.f18804l) goto L117;
        if (r17 == g.f18801i) goto L117;
        if (r17 == g.f18800h) goto L117;
        if (r17 == g.g) goto L163;
        if (r17 == g.f) goto L117;
        if (r13 != r10.get(this)) goto L117;
        return false;
    L163:
        return false;
    L162:
        return false;
    L115:
        if (r12.k(r16, r17, g.f18800h) == false) goto L85;
        s();
    L161:
        return true;
    L9:
        if (r5 != 3) goto L71;
        o r18 = p(r19 & 1152921504606846975L);
        UndeliveredElementException r20 = null;
        Object r22 = null;
    L11:
        int r23 = g.f18798b - 1;
    L13:
        if ((-1) >= r23) goto L58;
        long r110 = (r18.f18950c * g.f18798b) + ((long) r23);
    L15:
        Object r111 = r18.l(r23);
        if (r111 == g.f18801i) goto L60;
        g8.g r112 = g.d;
        AtomicReferenceArray r113 = r18.f;
        Function1 r114 = this.f18795b;
        if (r111 == r112) goto L20;
        if (r111 == g.e) goto L55;
        if (r111 == null) goto L55;
        if ((r111 instanceof i2) == true) goto L43;
        if ((r111 instanceof z) == true) goto L43;
        g8.g r115 = g.g;
        if (r111 == r115) goto L60;
        if (r111 == g.f) goto L60;
        if (r111 == r115) goto L15;
    L57:
        r23 = r23 - 1;
    L43:
        if (r110 < r10.get(this)) goto L60;
        if ((r111 instanceof z) == false) goto L47;
        i2 r116 = ((z) r111).f18819a;
    L49:
        if (r18.k(r23, r111, g.f18804l) == false) goto L15;
        if (r114 == null) goto L52;
        r20 = kotlinx.coroutines.internal.f.b(r114, r113.get(r23 * 2), r20);
    L52:
        r22 = kotlinx.coroutines.internal.f.g(r22, r116);
        r18.n(r23, null);
        r18.i();
        goto L57
    L47:
        r116 = (i2) r111;
    L55:
        if (r18.k(r23, r111, g.f18804l) == false) goto L15;
        r18.i();
        goto L57
    L20:
        if (r110 < r10.get(this)) goto L60;
        if (r18.k(r23, r111, g.f18804l) == false) goto L15;
        if (r114 == null) goto L25;
        r20 = kotlinx.coroutines.internal.f.b(r114, r113.get(r23 * 2), r20);
    L25:
        r18.n(r23, null);
        r18.i();
    L60:
        if (r22 != null) goto L62;
    L67:
        if (r20 == null) goto L161;
        throw r20;
    L62:
        if ((r22 instanceof ArrayList) == true) goto L64;
        J((i2) r22, false);
        goto L67
    L64:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
        ArrayList r24 = (ArrayList) r22;
        int r25 = r24.size() - 1;
    L65:
        if ((-1) >= r25) goto L67;
        J((i2) r24.get(r25), false);
        r25 = r25 - 1;
        goto L65
    L58:
        r18 = (o) ((kotlinx.coroutines.internal.b) kotlinx.coroutines.internal.b.f18928b.get(r18));
        if (r18 != null) goto L11;
    L71:
        throw new IllegalStateException(j0.g(r5, "unexpected close status: ").toString());
    L160:
        return false;
    }
}
