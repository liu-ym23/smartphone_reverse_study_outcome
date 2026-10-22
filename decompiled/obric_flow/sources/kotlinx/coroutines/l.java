package kotlinx.coroutines;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class l extends q0 implements j, CoroutineStackFrame, i2 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18978h = null;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final Continuation d;
    public final CoroutineContext e;

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decisionAndIndex$volatile");
        g = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state$volatile");
        f18978h = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_parentHandle$volatile");
    }

    public l(int r5, Continuation r10) {
        super(r5);
        this.d = r10;
        this.e = r10.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f18769a;
    }

    public static void B(w1 r5, Object r10) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r5 + ", already has " + r10).toString());
    }

    public static Object G(w1 r10, Object r11, int r12, Function3 r13) {
        if ((r11 instanceof v) == false) goto L6;
        return r11;
    L6:
        if (r0.a(r12) == false) goto L20;
        if (r13 != null) goto L13;
        if ((r10 instanceof i) == true) goto L13;
        return r11;
    L13:
        if ((r10 instanceof i) == false) goto L16;
        i r14 = (i) r10;
    L18:
        return new u(r11, r14, r13, null, 16);
    L16:
        r14 = null;
        goto L18
    L20:
        return r11;
    }

    public final boolean A() {
        if (this.f18987c != 2) goto L7;
        Continuation r5 = this.d;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        kotlinx.coroutines.internal.e r10 = (kotlinx.coroutines.internal.e) r5;
        r10.getClass();
        if (kotlinx.coroutines.internal.e.f18931h.get(r10) == null) goto L7;
        return true;
    L7:
        return false;
    }

    public String C() {
        return "CancellableContinuation";
    }

    public final void D() {
        Continuation r5 = this.d;
        Throwable r10 = null;
        if ((r5 instanceof kotlinx.coroutines.internal.e) == false) goto L5;
        kotlinx.coroutines.internal.e r11 = (kotlinx.coroutines.internal.e) r5;
    L6:
        if (r11 == null) goto L31;
    L7:
        AtomicReferenceFieldUpdater r12 = kotlinx.coroutines.internal.e.f18931h;
        Object r13 = r12.get(r11);
        g8.g r14 = kotlinx.coroutines.internal.f.f18933b;
        if (r13 != r14) goto L16;
    L10:
        if (r12.compareAndSet(r11, r14, this) == true) goto L20;
        if (r12.get(r11) == r14) goto L10;
    L20:
        if (r10 == null) goto L39;
        r();
        cancel(r10);
        return;
    L39:
        return;
    L16:
        if ((r13 instanceof Throwable) == false) goto L30;
    L18:
        if (r12.compareAndSet(r11, r13, null) == true) goto L19;
        if (r12.get(r11) == r13) goto L18;
        throw new IllegalArgumentException("Failed requirement.");
    L19:
        r10 = (Throwable) r13;
        goto L20
    L30:
        throw new IllegalStateException(("Inconsistent state " + r13).toString());
    L31:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void E(Object r5, int r10, Function3 r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = g;
        Object r13 = r12.get(this);
        if ((r13 instanceof w1) == false) goto L16;
        Object r14 = G((w1) r13, r5, r10, r11);
    L6:
        if (r12.compareAndSet(this, r13, r14) == true) goto L8;
        if (r12.get(this) == r13) goto L6;
    L8:
        if (A() == true) goto L10;
        r();
    L10:
        t(r10);
        return;
    L16:
        if ((r13 instanceof m) == false) goto L23;
        m r15 = (m) r13;
        r15.getClass();
        if (m.f18981c.compareAndSet(r15, 0, 1) == false) goto L23;
        if (r11 == null) goto L28;
        l(r11, r15.f19025a, r5);
        return;
    L28:
        return;
    L23:
        throw new IllegalStateException(("Already resumed, but proposed with update " + r5).toString());
    }

    public final void F(z r5, Unit r10) {
        Continuation r11 = this.d;
        if ((r11 instanceof kotlinx.coroutines.internal.e) == false) goto L5;
        kotlinx.coroutines.internal.e r12 = (kotlinx.coroutines.internal.e) r11;
    L6:
        if (r12 == null) goto L8;
        z r13 = r12.d;
    L9:
        if (r13 != r5) goto L11;
        int r14 = 4;
    L12:
        E(r10, r14, null);
        return;
    L11:
        r14 = this.f18987c;
        goto L12
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public final g8.g H(Object r10, Function3 r11) {
    L2:
        AtomicReferenceFieldUpdater r5 = g;
        Object r12 = r5.get(this);
        boolean r13 = r12 instanceof w1;
        g8.g r14 = j0.f18965a;
        if (r13 == false) goto L14;
        Object r15 = G((w1) r12, r10, this.f18987c, r11);
    L6:
        if (r5.compareAndSet(this, r12, r15) == true) goto L8;
        if (r5.get(this) == r12) goto L6;
    L8:
        if (A() == true) goto L10;
        r();
    L10:
        return r14;
    L14:
        boolean r16 = r12 instanceof u;
        return null;
    }

    @Override // kotlinx.coroutines.i2
    public final void a(kotlinx.coroutines.internal.s r5, int r10) {
    L2:
        AtomicIntegerFieldUpdater r11 = f;
        int r12 = r11.get(this);
        if ((r12 & 536870911) != 536870911) goto L9;
        if (r11.compareAndSet(this, r12, ((r12 >> 29) << 29) + r10) == false) goto L2;
        z(r5);
        return;
    L9:
        throw new IllegalStateException("invokeOnCancellation should be called at most once");
    }

    @Override // kotlinx.coroutines.q0
    public final void b(CancellationException r10) {
    L2:
        AtomicReferenceFieldUpdater r5 = g;
        Object r11 = r5.get(this);
        if ((r11 instanceof w1) == true) goto L34;
        if ((r11 instanceof v) == true) goto L6;
        if ((r11 instanceof u) == true) goto L9;
        u r12 = new u(r11, null, null, r10, 14);
    L28:
        if (r5.compareAndSet(this, r11, r12) == true) goto L29;
        if (r5.get(this) == r11) goto L28;
    L29:
        return;
    L9:
        u r13 = (u) r11;
        if (r13.e != null) goto L25;
        u r14 = u.a(r13, null, r10, 15);
    L13:
        if (r5.compareAndSet(this, r11, r14) == true) goto L14;
        if (r5.get(this) == r11) goto L13;
    L14:
        i r15 = r13.f19022b;
        if (r15 == null) goto L17;
        j(r15, r10);
    L17:
        Function3 r16 = r13.f19023c;
        if (r16 == null) goto L47;
        l(r16, r10, r13.f19021a);
        return;
    L47:
        return;
    L25:
        throw new IllegalStateException("Must be called at most once");
    L6:
        return;
    L34:
        throw new IllegalStateException("Not completed");
    }

    @Override // kotlinx.coroutines.j
    public final g8.g c(Object r5, Function3 r10) {
        return H(r5, r10);
    }

    @Override // kotlinx.coroutines.j
    public final boolean cancel(Throwable r10) {
    L2:
        AtomicReferenceFieldUpdater r5 = g;
        Object r11 = r5.get(this);
        boolean r12 = false;
        if ((r11 instanceof w1) == false) goto L4;
        if ((r11 instanceof i) == false) goto L8;
    L9:
        r12 = true;
    L10:
        m r13 = new m(this, r10, r12);
    L12:
        if (r5.compareAndSet(this, r11, r13) == true) goto L13;
        if (r5.get(this) == r11) goto L12;
    L13:
        w1 r14 = (w1) r11;
        if ((r14 instanceof i) == false) goto L17;
        j((i) r11, r10);
    L20:
        if (A() == true) goto L22;
        r();
    L22:
        t(this.f18987c);
        return true;
    L17:
        if ((r14 instanceof kotlinx.coroutines.internal.s) == false) goto L20;
        o((kotlinx.coroutines.internal.s) r11, r10);
        goto L20
    L8:
        if ((r11 instanceof kotlinx.coroutines.internal.s) == false) goto L10;
    L4:
        return false;
    }

    @Override // kotlinx.coroutines.q0
    public final Continuation d() {
        return this.d;
    }

    @Override // kotlinx.coroutines.j
    public final void e(Object r5, Function1 r10) {
        int r11 = this.f18987c;
        if (r10 == null) goto L5;
        k r12 = new k((com.bytedance.ai.model.widgets.d) r10, 0);
    L6:
        E(r5, r11, r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.q0
    public final Throwable f(Object r5) {
        Throwable r10 = super.f(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10;
    }

    @Override // kotlinx.coroutines.q0
    public final Object g(Object r5) {
        if ((r5 instanceof u) == true) goto L5;
        return r5;
    L5:
        return ((u) r5).f19021a;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation r5 = this.d;
        if ((r5 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r5;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.e;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.q0
    public final Object i() {
        return g.get(this);
    }

    @Override // kotlinx.coroutines.j
    public final boolean isActive() {
        return g.get(this) instanceof w1;
    }

    public final void j(i r5, Throwable r10) {
        r5.b(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c0.a(new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th), this.e);
    }

    @Override // kotlinx.coroutines.j
    public final void k(Object r5, Function3 r10) {
        E(r5, this.f18987c, r10);
    }

    public final void l(Function3 r5, Throwable r10, Object r11) {
        CoroutineContext r12 = this.e;
        r5.invoke(r10, r11, r12);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        c0.a(new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th), r12);
    }

    public final void o(kotlinx.coroutines.internal.s r5, Throwable r10) {
        CoroutineContext r11 = this.e;
        int r12 = f.get(this) & 536870911;
        if (r12 == 536870911) goto L10;
        r5.h(r12, r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        c0.a(new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th), r11);
        return;
    L10:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    public final void r() {
        AtomicReferenceFieldUpdater r5 = f18978h;
        t0 r10 = (t0) r5.get(this);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.dispose();
        r5.set(this, v1.f19027a);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r5) {
        Throwable r10 = Result.m127exceptionOrNullimpl(r5);
        if (r10 == null) goto L6;
        r5 = new v(false, r10);
    L6:
        E(r5, this.f18987c, null);
    }

    @Override // kotlinx.coroutines.j
    public final void s(Object r5) {
        t(this.f18987c);
    }

    public final void t(int r5) {
    L2:
        AtomicIntegerFieldUpdater r10 = f;
        int r11 = r10.get(this);
        int r12 = r11 >> 29;
        if (r12 != 0) goto L5;
        if (r10.compareAndSet(this, r11, BasicMeasure.EXACTLY + (536870911 & r11)) == false) goto L2;
        return;
    L5:
        if (r12 != 1) goto L36;
        if (r5 != 4) goto L9;
        boolean r13 = true;
    L10:
        Continuation r14 = this.d;
        if (r13 == false) goto L13;
    L33:
        r0.b(this, r14, r13);
        return;
    L13:
        if ((r14 instanceof kotlinx.coroutines.internal.e) == false) goto L33;
        if (r0.a(r5) != r0.a(this.f18987c)) goto L33;
        kotlinx.coroutines.internal.e r15 = (kotlinx.coroutines.internal.e) r14;
        z r16 = r15.d;
        CoroutineContext r17 = r15.e.getContext();
        if (r16.isDispatchNeeded(r17) == false) goto L19;
        r16.dispatch(r17, this);
        return;
    L19:
        b1 r18 = b2.a();
        if (r18.M() == false) goto L22;
        r18.J(this);
        return;
    L22:
        r18.L(true);
        r0.b(this, r14, true);     // Catch: Throwable -> L27
    L24:
        if (r18.O() == true) goto L24;
    L26:
        r18.g(true);
        return;
    L27:
        th = move-exception;
        h(th);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r18.g(true);
        throw th;
    L9:
        r13 = false;
        goto L10
    L36:
        throw new IllegalStateException("Already resumed");
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(C());
        r5.append('(');
        r5.append(j0.j(this.d));
        r5.append("){");
        Object r10 = g.get(this);
        if ((r10 instanceof w1) == false) goto L6;
        String r11 = "Active";
    L9:
        r5.append(r11);
        r5.append("}@");
        r5.append(j0.f(this));
        return r5.toString();
    L6:
        if ((r10 instanceof m) == false) goto L8;
        r11 = "Cancelled";
        goto L9
    L8:
        r11 = "Completed";
        goto L9
    }

    public Throwable u(r1 r5) {
        return r5.getCancellationException();
    }

    public final Object v() {
        boolean r5 = A();
    L3:
        AtomicIntegerFieldUpdater r10 = f;
        int r11 = r10.get(this);
        int r12 = r11 >> 29;
        if (r12 != 0) goto L6;
        if (r10.compareAndSet(this, r11, 536870912 + (536870911 & r11)) == false) goto L3;
        if (((t0) f18978h.get(this)) != null) goto L31;
        x();
    L31:
        if (r5 == false) goto L34;
        D();
    L34:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L6:
        if (r12 != 2) goto L25;
        if (r5 == false) goto L9;
        D();
    L9:
        Object r13 = g.get(this);
        if ((r13 instanceof v) == true) goto L23;
        if (r0.a(this.f18987c) == false) goto L21;
        k1 r14 = Job.Key;
        Job r15 = (Job) this.e.get(r14);
        if (r15 == null) goto L21;
        if (r15.isActive() == true) goto L21;
        CancellationException r16 = r15.getCancellationException();
        b(r16);
        throw r16;
    L21:
        return g(r13);
    L23:
        throw ((v) r13).f19025a;
    L25:
        throw new IllegalStateException("Already suspended");
    }

    public final void w() {
        t0 r5 = x();
        if (r5 != null) goto L6;
        return;
    L6:
        if ((g.get(this) instanceof w1) == true) goto L9;
        r5.dispose();
        v1 r10 = v1.f19027a;
        f18978h.set(this, r10);
        return;
    }

    public final t0 x() {
        k1 r5 = Job.Key;
        Job r10 = (Job) this.e.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        t0 r11 = j0.i(r10, new n(this, 0));
    L6:
        AtomicReferenceFieldUpdater r12 = f18978h;
        if (r12.compareAndSet(this, null, r11) == true) goto L11;
        if (r12.get(this) == null) goto L6;
    L11:
        return r11;
    }

    public final void y(Function1 r5) {
        z(new h(r5, 1));
    }

    public final void z(w1 r10) {
    L2:
        AtomicReferenceFieldUpdater r5 = g;
        Object r11 = r5.get(this);
        if ((r11 instanceof b) == true) goto L5;
        Throwable r12 = null;
        if ((r11 instanceof i) == true) goto L63;
        if ((r11 instanceof kotlinx.coroutines.internal.s) == true) goto L63;
        if ((r11 instanceof v) == true) goto L16;
        if ((r11 instanceof u) == true) goto L35;
        if ((r10 instanceof kotlinx.coroutines.internal.s) == true) goto L55;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        u r13 = new u(r11, (i) r10, null, null, 28);
    L58:
        if (r5.compareAndSet(this, r11, r13) == true) goto L59;
        if (r5.get(this) == r11) goto L58;
    L59:
        return;
    L55:
        return;
    L35:
        u r14 = (u) r11;
        if (r14.f19022b != null) goto L51;
        if ((r10 instanceof kotlinx.coroutines.internal.s) == true) goto L39;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        i r15 = (i) r10;
        Throwable r16 = r14.e;
        if (r16 != null) goto L42;
        u r17 = u.a(r14, r15, null, 29);
    L46:
        if (r5.compareAndSet(this, r11, r17) == true) goto L47;
        if (r5.get(this) == r11) goto L46;
    L47:
        return;
    L42:
        j(r15, r16);
        return;
    L39:
        return;
    L51:
        B(r10, r11);
        throw null;
    L16:
        v r18 = (v) r11;
        r18.getClass();
        if (v.f19024b.compareAndSet(r18, 0, 1) == true) goto L19;
        B(r10, r11);
        throw null;
    L19:
        if ((r11 instanceof m) == true) goto L21;
        return;
    L21:
        if ((r11 instanceof v) == true) goto L24;
        r18 = null;
    L24:
        if (r18 == null) goto L27;
        r12 = r18.f19025a;
    L27:
        if ((r10 instanceof i) == false) goto L29;
        j((i) r10, r12);
        return;
    L29:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        o((kotlinx.coroutines.internal.s) r10, r12);
        return;
    L63:
        B(r10, r11);
        throw null;
    L5:
        if (r5.compareAndSet(this, r11, r10) == true) goto L6;
        if (r5.get(this) == r11) goto L5;
    }
}
