package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
public class o<T> extends w0<T> implements n<T>, CoroutineStackFrame, c3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10616k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10617l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10618m = null;

    @Volatile
    private volatile int _decisionAndIndex;

    @Volatile
    private volatile Object _parentHandle;

    @Volatile
    private volatile Object _state;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Continuation<T> f10619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CoroutineContext f10620j;

    static {
        f10616k = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decisionAndIndex");
        f10617l = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state");
        f10618m = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_parentHandle");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Continuation<? super T> r10, int r11) {
        super(r11);
        this.f10619i = r10;
        if (n0.a() == true) goto L5;
    L12:
        this.f10620j = r10.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f10328c;
        return;
    L5:
        if (r11 == (-1)) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L12;
        throw new AssertionError();
    L7:
        r12 = false;
        goto L8
    }

    private final b1 A() {
        return (b1) f10618m.get(this);
    }

    private final String E() {
        Object r10 = C();
        if ((r10 instanceof j2) == false) goto L6;
        return "Active";
    L6:
        if ((r10 instanceof r) == false) goto L8;
        return "Cancelled";
    L8:
        return "Completed";
    }

    private final b1 G() {
        v1 r10 = (v1) getContext().get(v1.f10723e);
        if (r10 != null) goto L5;
        return null;
    L5:
        b1 r11 = v1.a.d(r10, true, false, new s(this), 2, null);
        f10618m.compareAndSet(this, null, r11);
        return r11;
    }

    private final void H(Object r22) {
        if (n0.a() == true) goto L5;
    L15:
        AtomicReferenceFieldUpdater r10 = f10617l;
    L16:
        Object r12 = r10.get(this);
        if ((r12 instanceof d) == true) goto L19;
        if ((r12 instanceof l) == false) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == true) goto L26;
        boolean r13 = r12 instanceof b0;
        if (r13 == true) goto L29;
        if ((r12 instanceof a0) == true) goto L47;
        if ((r22 instanceof kotlinx.coroutines.internal.f0) == true) goto L62;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        if (f10617l.compareAndSet(this, r12, new a0(r12, (l) r22, null, null, null, 28, null)) == false) goto L16;
        return;
    L62:
        return;
    L47:
        a0 r14 = (a0) r12;
        if (r14.f10229b == null) goto L51;
        O(r22, r12);
    L51:
        if ((r22 instanceof kotlinx.coroutines.internal.f0) == true) goto L52;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        l r15 = (l) r22;
        if (r14.c() == true) goto L55;
        if (f10617l.compareAndSet(this, r12, a0.b(r14, null, r15, null, null, null, 29, null)) == false) goto L16;
        return;
    L55:
        n(r15, r14.f10232e);
        return;
    L52:
        return;
    L29:
        b0 r16 = (b0) r12;
        if (r16.b() == true) goto L33;
        O(r22, r12);
    L33:
        if ((r12 instanceof r) == false) goto L84;
        Throwable r17 = null;
        if (r13 == true) goto L38;
        r16 = null;
    L38:
        if (r16 == null) goto L41;
        r17 = r16.f10244a;
    L41:
        if ((r22 instanceof l) == false) goto L43;
        n((l) r22, r17);
        return;
    L43:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        p((kotlinx.coroutines.internal.f0) r22, r17);
        return;
    L84:
        return;
    L26:
        O(r22, r12);
        goto L16
    L24:
        r11 = r12 instanceof kotlinx.coroutines.internal.f0;
        goto L25
    L19:
        if (f10617l.compareAndSet(this, r12, r22) == false) goto L16;
        return;
    L5:
        if ((r22 instanceof l) == false) goto L7;
    L10:
        boolean r18 = true;
    L11:
        if (r18 == true) goto L15;
        throw new AssertionError();
    L7:
        if ((r22 instanceof kotlinx.coroutines.internal.f0) == true) goto L10;
        r18 = false;
        goto L11
    }

    private final boolean K() {
        if (x0.c(this.f10728h) == false) goto L7;
        Continuation<T> r10 = this.f10619i;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (((kotlinx.coroutines.internal.l) r10).r() == false) goto L7;
        return true;
    L7:
        return false;
    }

    private final l L(Function1<? super Throwable, Unit> r10) {
        if ((r10 instanceof l) == false) goto L6;
        return (l) r10;
    L6:
        return new s1(r10);
    }

    private final void O(Object r10, Object r11) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r10 + ", already has " + r11).toString());
    }

    private final void U(Object r10, int r11, Function1<? super Throwable, Unit> r12) {
        AtomicReferenceFieldUpdater r13 = f10617l;
    L3:
        Object r14 = r13.get(this);
        if ((r14 instanceof j2) == false) goto L10;
        Object r15 = W((j2) r14, r10, r11, r12, null);
        if (f10617l.compareAndSet(this, r14, r15) == false) goto L3;
        t();
        w(r11);
        return;
    L10:
        if ((r14 instanceof r) == false) goto L16;
        r r16 = (r) r14;
        if (r16.c() == false) goto L16;
        if (r12 == null) goto L21;
        o(r12, r16.f10244a);
        return;
    L21:
        return;
    L16:
        l(r10);
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void V(o r10, Object r11, int r12, Function1 r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L6;
        r13 = null;
    L6:
        r10.U(r11, r12, r13);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object W(j2 r10, Object r11, int r12, Function1<? super Throwable, Unit> r13, Object r14) {
        if ((r11 instanceof b0) == false) goto L23;
        boolean r15 = true;
        if (n0.a() == false) goto L14;
        if (r14 != null) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == true) goto L14;
        throw new AssertionError();
    L8:
        r16 = false;
    L14:
        if (n0.a() == false) goto L36;
        if (r13 == null) goto L18;
        r15 = false;
    L18:
        if (r15 == false) goto L21;
        return r11;
    L21:
        throw new AssertionError();
    L36:
        return r11;
    L23:
        if (x0.b(r12) == true) goto L26;
        if (r14 != null) goto L26;
        return r11;
    L26:
        if (r13 != null) goto L31;
        if ((r10 instanceof l) == true) goto L31;
        if (r14 != null) goto L31;
        return r11;
    L31:
        if ((r10 instanceof l) == false) goto L33;
        l r17 = (l) r10;
    L35:
        return new a0(r11, r17, r13, r14, null, 16, null);
    L33:
        r17 = null;
        goto L35
    }

    private final boolean X() {
        AtomicIntegerFieldUpdater r10 = f10616k;
    L3:
        int r11 = r10.get(this);
        int r12 = r11 >> 29;
        if (r12 != 0) goto L5;
        if (f10616k.compareAndSet(this, r11, 1073741824 + (536870911 & r11)) == false) goto L3;
        return true;
    L5:
        if (r12 != 1) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already resumed".toString());
    }

    private final kotlinx.coroutines.internal.i0 Y(Object r10, Object r11, Function1<? super Throwable, Unit> r12) {
        AtomicReferenceFieldUpdater r13 = f10617l;
    L3:
        Object r14 = r13.get(this);
        if ((r14 instanceof j2) == false) goto L10;
        Object r15 = W((j2) r14, r10, this.f10728h, r12, r11);
        if (f10617l.compareAndSet(this, r14, r15) == false) goto L3;
        t();
        return p.f10622a;
    L10:
        if ((r14 instanceof a0) == false) goto L26;
        if (r11 == null) goto L27;
        a0 r16 = (a0) r14;
        if (r16.f10231d == r11) goto L15;
        return null;
    L15:
        if (n0.a() == false) goto L22;
        if (Intrinsics.areEqual(r16.f10228a, r10) == true) goto L22;
        throw new AssertionError();
    L22:
        return p.f10622a;
    L27:
        return null;
    L26:
        return null;
    }

    private final boolean Z() {
        AtomicIntegerFieldUpdater r10 = f10616k;
    L3:
        int r11 = r10.get(this);
        int r12 = r11 >> 29;
        if (r12 != 0) goto L6;
        if (f10616k.compareAndSet(this, r11, 536870912 + (536870911 & r11)) == false) goto L3;
        return true;
    L6:
        if (r12 != 2) goto L10;
        return false;
    L10:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final Void l(Object r10) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + r10).toString());
    }

    private final void p(kotlinx.coroutines.internal.f0<?> r10, Throwable r11) {
        int r12 = f10616k.get(this) & 536870911;
        if (r12 == 536870911) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L13;
        r10.o(r12, r11, getContext());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        i0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        return;
    L13:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    L5:
        r13 = false;
        goto L6
    }

    private final boolean r(Throwable r10) {
        if (K() == true) goto L6;
        return false;
    L6:
        Continuation<T> r11 = this.f10619i;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.l) r11).s(r10);
    }

    private final void t() {
        if (K() == true) goto L6;
        s();
        return;
    }

    private final void w(int r10) {
        if (X() == false) goto L5;
        return;
    L5:
        x0.a(this, r10);
    }

    @PublishedApi
    public final Object B() {
        boolean r10 = K();
        if (Z() == true) goto L5;
        if (r10 == false) goto L13;
        S();
    L13:
        Object r11 = C();
        if ((r11 instanceof b0) == false) goto L20;
        Throwable r12 = ((b0) r11).f10244a;
        if (n0.d() == true) goto L18;
        throw r12;
    L18:
        throw kotlinx.coroutines.internal.h0.a(r12, this);
    L20:
        if (x0.b(this.f10728h) == false) goto L30;
        v1 r13 = (v1) getContext().get(v1.f10723e);
        if (r13 == null) goto L30;
        if (r13.isActive() == true) goto L30;
        CancellationException r14 = r13.p();
        b(r11, r14);
        if (n0.d() == true) goto L28;
        throw r14;
    L28:
        throw kotlinx.coroutines.internal.h0.a(r14, this);
    L30:
        return f(r11);
    L5:
        if (A() != null) goto L7;
        G();
    L7:
        if (r10 == false) goto L10;
        S();
    L10:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final Object C() {
        return f10617l.get(this);
    }

    public void F() {
        b1 r10 = G();
        if (r10 != null) goto L6;
        return;
    L6:
        if (a() == false) goto L9;
        r10.dispose();
        f10618m.set(this, i2.f10525c);
        return;
    }

    @Override // kotlinx.coroutines.n
    public void N(Object r10) {
        if (n0.a() == true) goto L5;
    L12:
        w(this.f10728h);
        return;
    L5:
        if (r10 != p.f10622a) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L12;
        throw new AssertionError();
    L7:
        r11 = false;
        goto L8
    }

    protected String Q() {
        return "CancellableContinuation";
    }

    public final void R(Throwable r10) {
        if (r(r10) == false) goto L5;
        return;
    L5:
        z(r10);
        t();
    }

    public final void S() {
        Continuation<T> r10 = this.f10619i;
        if ((r10 instanceof kotlinx.coroutines.internal.l) == false) goto L5;
        kotlinx.coroutines.internal.l r11 = (kotlinx.coroutines.internal.l) r10;
    L6:
        if (r11 == null) goto L12;
        Throwable r12 = r11.w(this);
        if (r12 == null) goto L13;
        s();
        z(r12);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @JvmName(name = "resetStateReusable")
    public final boolean T() {
        if (n0.a() == false) goto L13;
        if (this.f10728h != 2) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L13;
        throw new AssertionError();
    L7:
        r10 = false;
    L13:
        if (n0.a() == true) goto L15;
    L22:
        AtomicReferenceFieldUpdater r11 = f10617l;
        Object r12 = r11.get(this);
        if (n0.a() == false) goto L30;
        if ((!(r12 instanceof j2)) == true) goto L30;
        throw new AssertionError();
    L30:
        if ((r12 instanceof a0) == true) goto L32;
    L35:
        f10616k.set(this, 536870911);
        r11.set(this, d.f10328c);
        return true;
    L32:
        if (((a0) r12).f10231d == null) goto L35;
        s();
        return false;
    L15:
        if (A() == i2.f10525c) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == true) goto L22;
        throw new AssertionError();
    L17:
        r13 = false;
        goto L18
    }

    @Override // kotlinx.coroutines.n
    public boolean a() {
        return !(C() instanceof j2);
    }

    @Override // kotlinx.coroutines.w0
    public void b(Object r20, Throwable r21) {
        AtomicReferenceFieldUpdater r10 = f10617l;
    L3:
        Object r11 = r10.get(this);
        if ((r11 instanceof j2) == true) goto L22;
        if ((r11 instanceof b0) == true) goto L7;
        if ((r11 instanceof a0) == true) goto L10;
        if (f10617l.compareAndSet(this, r11, new a0(r11, null, null, null, r21, 14, null)) == false) goto L3;
        return;
    L10:
        a0 r12 = (a0) r11;
        if ((!r12.c()) == false) goto L17;
        if (f10617l.compareAndSet(this, r11, a0.b(r12, null, null, null, null, r21, 15, null)) == false) goto L3;
        r12.d(this, r21);
        return;
    L17:
        throw new IllegalStateException("Must be called at most once".toString());
    L7:
        return;
    L22:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // kotlinx.coroutines.c3
    public void c(kotlinx.coroutines.internal.f0<?> r10, int r11) {
        AtomicIntegerFieldUpdater r12 = f10616k;
    L3:
        int r13 = r12.get(this);
        if ((r13 & 536870911) != 536870911) goto L6;
        boolean r14 = true;
    L7:
        if (r14 == false) goto L13;
        if (r12.compareAndSet(this, r13, ((r13 >> 29) << 29) + r11) == false) goto L3;
        H(r10);
        return;
    L13:
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    L6:
        r14 = false;
        goto L7
    }

    @Override // kotlinx.coroutines.w0
    public final Continuation<T> d() {
        return this.f10619i;
    }

    @Override // kotlinx.coroutines.w0
    public Throwable e(Object r10) {
        Throwable r11 = super.e(r10);
        if (r11 == null) goto L10;
        Continuation<T> r12 = this.f10619i;
        if (n0.d() == true) goto L7;
        return r11;
    L7:
        if ((r12 instanceof CoroutineStackFrame) == true) goto L13;
        return r11;
    L13:
        return kotlinx.coroutines.internal.h0.a(r11, (CoroutineStackFrame) r12);
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.w0
    public <T> T f(Object r10) {
        if ((r10 instanceof a0) == true) goto L5;
        return r10;
    L5:
        return (T) ((a0) r10).f10228a;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r10 = this.f10619i;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f10620j;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.n
    public void h(Function1<? super Throwable, Unit> r10) {
        H(L(r10));
    }

    @Override // kotlinx.coroutines.w0
    public Object i() {
        return C();
    }

    @Override // kotlinx.coroutines.n
    public boolean isActive() {
        return C() instanceof j2;
    }

    @Override // kotlinx.coroutines.n
    public Object j(Throwable r10) {
        return Y(new b0(r10, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.n
    public Object k(T r10, Object r11, Function1<? super Throwable, Unit> r12) {
        return Y(r10, r11, r12);
    }

    @Override // kotlinx.coroutines.n
    public void m(CoroutineDispatcher r10, Throwable r11) {
        Continuation<T> r12 = this.f10619i;
        CoroutineDispatcher r13 = null;
        if ((r12 instanceof kotlinx.coroutines.internal.l) == false) goto L5;
        kotlinx.coroutines.internal.l r14 = (kotlinx.coroutines.internal.l) r12;
    L6:
        b0 r15 = new b0(r11, false, 2, null);
        if (r14 == null) goto L9;
        r13 = r14.f10559i;
    L9:
        if (r13 != r10) goto L11;
        int r16 = 4;
    L12:
        V(this, r15, r16, null, 4, null);
        return;
    L11:
        r16 = this.f10728h;
        goto L12
    L5:
        r14 = null;
        goto L6
    }

    public final void n(l r10, Throwable r11) {
        r10.g(r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        i0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void o(Function1<? super Throwable, Unit> r10, Throwable r11) {
        r10.invoke(r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        i0.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
    }

    @Override // kotlinx.coroutines.n
    public void q(CoroutineDispatcher r10, T r11) {
        Continuation<T> r12 = this.f10619i;
        CoroutineDispatcher r13 = null;
        if ((r12 instanceof kotlinx.coroutines.internal.l) == false) goto L5;
        kotlinx.coroutines.internal.l r14 = (kotlinx.coroutines.internal.l) r12;
    L6:
        if (r14 == null) goto L8;
        r13 = r14.f10559i;
    L8:
        if (r13 != r10) goto L10;
        int r15 = 4;
    L11:
        V(this, r11, r15, null, 4, null);
        return;
    L10:
        r15 = this.f10728h;
        goto L11
    L5:
        r14 = null;
        goto L6
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        V(this, e0.c(r10, this), this.f10728h, null, 4, null);
    }

    public final void s() {
        b1 r10 = A();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.dispose();
        f10618m.set(this, i2.f10525c);
    }

    public String toString() {
        return Q() + '(' + o0.c(this.f10619i) + "){" + E() + "}@" + o0.b(this);
    }

    public Throwable x(v1 r10) {
        return r10.p();
    }

    @Override // kotlinx.coroutines.n
    public void y(T r10, Function1<? super Throwable, Unit> r11) {
        U(r10, this.f10728h, r11);
    }

    @Override // kotlinx.coroutines.n
    public boolean z(Throwable r10) {
        AtomicReferenceFieldUpdater r11 = f10617l;
    L3:
        Object r12 = r11.get(this);
        boolean r13 = false;
        if ((r12 instanceof j2) == false) goto L5;
        if ((r12 instanceof l) == false) goto L9;
    L10:
        r13 = true;
    L12:
        if (f10617l.compareAndSet(this, r12, new r(this, r10, r13)) == false) goto L3;
        j2 r14 = (j2) r12;
        if ((r14 instanceof l) == false) goto L17;
        n((l) r12, r10);
    L19:
        t();
        w(this.f10728h);
        return true;
    L17:
        if ((r14 instanceof kotlinx.coroutines.internal.f0) == false) goto L19;
        p((kotlinx.coroutines.internal.f0) r12, r10);
        goto L19
    L9:
        if ((r12 instanceof kotlinx.coroutines.internal.f0) == false) goto L12;
    L5:
        return false;
    }
}
