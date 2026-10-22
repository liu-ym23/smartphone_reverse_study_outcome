package pe;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class h<T> extends m0<T> implements g<T>, ce.d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10011p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10012q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10013r = null;
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ae.d<T> f10014n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ae.f f10015o;

    static {
        f10011p = AtomicIntegerFieldUpdater.newUpdater(h.class, "_decisionAndIndex");
        f10012q = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_state");
        f10013r = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_parentHandle");
    }

    public h(int r8, ae.d r10) {
        super(r8);
        this.f10014n = r10;
        this.f10015o = r10.getContext();
        this._decisionAndIndex = 536870911;
        this._state = b.f9994a;
    }

    public static Object B(o1 r8, Object r10, int r11, ge.l r12) {
        if ((r10 instanceof o) == true) goto L23;
        boolean r13 = true;
        if (r11 != 1) goto L8;
    L11:
        if (r13 == false) goto L24;
        if (r12 != null) goto L18;
        if ((r8 instanceof e) == true) goto L18;
        return r10;
    L18:
        if ((r8 instanceof e) == false) goto L20;
        e r14 = (e) r8;
    L22:
        return new n(r10, r14, r12, null, 16);
    L20:
        r14 = null;
        goto L22
    L24:
        return r10;
    L8:
        if (r11 == 2) goto L11;
        r13 = false;
        goto L11
    L23:
        return r10;
    }

    public static void w(o1 r8, Object r10) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r8 + ", already has " + r10).toString());
    }

    @Override // pe.g
    public final boolean a() {
        return f10012q.get(this) instanceof o1;
    }

    @Override // pe.m0
    public final void b(Object r11, CancellationException r12) {
    L2:
        AtomicReferenceFieldUpdater r13 = f10012q;
        Object r8 = r13.get(this);
        if ((r8 instanceof o1) == true) goto L42;
        if ((r8 instanceof o) == true) goto L6;
        boolean r10 = true;
        if ((r8 instanceof n) == true) goto L9;
        n r14 = new n(r8, null, null, r12, 14);
    L34:
        if (r13.compareAndSet(this, r8, r14) == true) goto L39;
        if (r13.get(this) == r8) goto L34;
        r10 = false;
    L39:
        if (r10 == false) goto L2;
        return;
    L9:
        n r15 = (n) r8;
        if (r15.f10047e == null) goto L12;
        boolean r16 = true;
    L14:
        if ((!r16) == false) goto L31;
        n r17 = n.a(r15, null, r12, 15);
    L17:
        if (r13.compareAndSet(this, r8, r17) == true) goto L22;
        if (r13.get(this) == r8) goto L17;
        r10 = false;
    L22:
        if (r10 == false) goto L2;
        e r18 = r15.f10044b;
        if (r18 == null) goto L26;
        i(r18, r12);
    L26:
        ge.l<Throwable, xd.j> r19 = r15.f10045c;
        if (r19 == null) goto L59;
        j(r19, r12);
        return;
    L59:
        return;
    L31:
        throw new IllegalStateException("Must be called at most once".toString());
    L12:
        r16 = false;
        goto L14
    L6:
        return;
    L42:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // pe.g
    public final void c(w r8, xd.j r10) {
        ae.d<T> r11 = this.f10014n;
        if ((r11 instanceof ue.g) == false) goto L5;
        ue.g r12 = (ue.g) r11;
    L6:
        if (r12 == null) goto L8;
        w r13 = r12.f12594n;
    L9:
        if (r13 != r8) goto L11;
        int r14 = 4;
    L12:
        z(r10, r14, null);
        return;
    L11:
        r14 = this.f10042m;
        goto L12
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    @Override // pe.m0
    public final ae.d<T> d() {
        return this.f10014n;
    }

    @Override // pe.m0
    public final Throwable e(Object r8) {
        Throwable r10 = super.e(r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pe.m0
    public final <T> T f(Object r8) {
        if ((r8 instanceof n) == true) goto L5;
        return r8;
    L5:
        return (T) ((n) r8).f10043a;
    }

    @Override // ce.d
    public final ce.d getCallerFrame() {
        ae.d<T> r8 = this.f10014n;
        if ((r8 instanceof ce.d) == true) goto L7;
        return null;
    L7:
        return (ce.d) r8;
    }

    @Override // ae.d
    public final ae.f getContext() {
        return this.f10015o;
    }

    @Override // pe.m0
    public final Object h() {
        return f10012q.get(this);
    }

    public final void i(e r8, Throwable r10) {
        r8.a(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        y.a(this.f10015o, new d1.c("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void j(ge.l<? super Throwable, xd.j> r8, Throwable r10) {
        r8.invoke(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        y.a(this.f10015o, new d1.c("Exception in resume onCancellation handler for " + this, th));
    }

    public final void k(ue.u<?> r8, Throwable r10) {
        int r11 = f10011p.get(this) & 536870911;
        if (r11 == 536870911) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L13;
        r8.a(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        y.a(this.f10015o, new d1.c("Exception in invokeOnCancellation handler for " + this, th));
        return;
    L13:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    L5:
        r12 = false;
        goto L6
    }

    public final void l(Throwable r8) {
    L2:
        AtomicReferenceFieldUpdater r10 = f10012q;
        Object r11 = r10.get(this);
        if ((r11 instanceof o1) == false) goto L4;
        boolean r12 = false;
        if ((r11 instanceof e) == false) goto L8;
    L11:
        boolean r13 = true;
    L12:
        i r14 = new i(this, r8, r13);
    L14:
        if (r10.compareAndSet(this, r11, r14) == true) goto L15;
        if (r10.get(this) == r11) goto L14;
    L18:
        if (r12 == false) goto L2;
        o1 r15 = (o1) r11;
        if ((r15 instanceof e) == false) goto L23;
        i((e) r11, r8);
    L26:
        if (v() == true) goto L28;
        m();
    L28:
        n(this.f10042m);
        return;
    L23:
        if ((r15 instanceof ue.u) == false) goto L26;
        k((ue.u) r11, r8);
        goto L26
    L15:
        r12 = true;
        goto L18
    L8:
        if ((r11 instanceof ue.u) == true) goto L11;
        r13 = false;
        goto L12
    }

    public final void m() {
        AtomicReferenceFieldUpdater r8 = f10013r;
        o0 r10 = (o0) r8.get(this);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.e();
        r8.set(this, n1.f10050a);
    }

    public final void n(int r10) {
    L2:
        AtomicIntegerFieldUpdater r8 = f10011p;
        int r11 = r8.get(this);
        int r12 = r11 >> 29;
        boolean r13 = false;
        if (r12 != 0) goto L4;
        if (r8.compareAndSet(this, r11, (536870911 & r11) + 1073741824) == false) goto L2;
        boolean r14 = true;
    L11:
        if (r14 == false) goto L14;
        return;
    L14:
        if (r10 != 4) goto L16;
        boolean r15 = true;
    L17:
        ae.d<T> r16 = this.f10014n;
        if (r15 == false) goto L20;
    L57:
        defpackage.c.d0(this, r16, r15);
        return;
    L20:
        if ((r16 instanceof ue.g) == false) goto L57;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L26;
        boolean r17 = false;
    L27:
        int r18 = this.f10042m;
        if (r18 == 1) goto L32;
        if (r18 == 2) goto L32;
        boolean r19 = false;
    L33:
        if (r17 != r19) goto L57;
        w r110 = ((ue.g) r16).f12594n;
        ae.f r20 = r16.getContext();
        if (r110.s0() == false) goto L37;
        r110.r0(r20, this);
        return;
    L37:
        s0 r111 = u1.a();
        if (r111.f10061m < 4294967296L) goto L40;
        r13 = true;
    L40:
        if (r13 == false) goto L45;
        yd.d<m0<?>> r21 = r111.f10063o;
        if (r21 != null) goto L44;
        r21 = new yd.d();
        r111.f10063o = r21;
    L44:
        r21.addLast(this);
        return;
    L45:
        r111.u0(true);
        defpackage.c.d0(this, r16, true);     // Catch: Throwable -> L50
    L47:
        if (r111.w0() == true) goto L47;
    L53:
        r111.t0(true);
        return;
    L50:
        th = move-exception;
        g(th, null);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        r111.t0(true);
        throw th;
    L32:
        r19 = true;
    L26:
        r17 = true;
        goto L27
    L16:
        r15 = false;
        goto L17
    L4:
        if (r12 != 1) goto L7;
        r14 = false;
        goto L11
    L7:
        throw new IllegalStateException("Already resumed".toString());
    }

    public Throwable o(j1 r8) {
        return r8.k();
    }

    public final Object p() {
        boolean r8 = v();
    L3:
        AtomicIntegerFieldUpdater r10 = f10011p;
        int r11 = r10.get(this);
        int r12 = r11 >> 29;
        boolean r13 = false;
        if (r12 != 0) goto L5;
        if (r10.compareAndSet(this, r11, (536870911 & r11) + 536870912) == false) goto L3;
        boolean r14 = true;
    L12:
        if (r14 == true) goto L14;
        if (r8 == false) goto L22;
        y();
    L22:
        Object r15 = f10012q.get(this);
        if ((r15 instanceof o) == true) goto L39;
        int r16 = this.f10042m;
        if (r16 == 1) goto L27;
        if (r16 == 2) goto L27;
    L28:
        if (r13 == false) goto L37;
        e1 r17 = (e1) this.f10015o.q0(e1.b.f10008a);
        if (r17 == null) goto L37;
        if (r17.a() == true) goto L37;
        CancellationException r18 = r17.k();
        b(r15, r18);
        throw r18;
    L37:
        return f(r15);
    L27:
        r13 = true;
        goto L28
    L39:
        throw ((o) r15).f10052a;
    L14:
        if (((o0) f10013r.get(this)) != null) goto L16;
        r();
    L16:
        if (r8 == false) goto L19;
        y();
    L19:
        return be.a.f3165a;
    L5:
        if (r12 != 2) goto L8;
        r14 = false;
        goto L12
    L8:
        throw new IllegalStateException("Already suspended".toString());
    }

    public final void q() {
        o0 r8 = r();
        if (r8 != null) goto L6;
        return;
    L6:
        if (u() == false) goto L9;
        r8.e();
        n1 r10 = n1.f10050a;
        f10013r.set(this, r10);
        return;
    }

    public final o0 r() {
        e1.b r8 = e1.b.f10008a;
        e1 r10 = (e1) this.f10015o.q0(r8);
        if (r10 != null) goto L5;
        return null;
    L5:
        o0 r11 = e1.a.b(r10, true, new j(this), 2);
    L6:
        AtomicReferenceFieldUpdater r12 = f10013r;
        if (r12.compareAndSet(this, null, r11) == true) goto L11;
        if (r12.get(this) == null) goto L6;
    L11:
        return r11;
    }

    @Override // ae.d
    public final void resumeWith(Object r8) {
        Throwable r10 = xd.e.a(r8);
        if (r10 == null) goto L6;
        r8 = new o(false, r10);
    L6:
        z(r8, this.f10042m, null);
    }

    public final void s(ge.l<? super Throwable, xd.j> r8) {
        if ((r8 instanceof e) == false) goto L5;
        e r10 = (e) r8;
    L6:
        t(r10);
        return;
    L5:
        r10 = new b1(r8);
        goto L6
    }

    public final void t(o1 r12) {
    L2:
        AtomicReferenceFieldUpdater r8 = f10012q;
        Object r10 = r8.get(this);
        boolean r11 = true;
        if ((r10 instanceof b) == true) goto L5;
        if ((r10 instanceof e) == false) goto L15;
        boolean r13 = true;
    L16:
        Throwable r14 = null;
        if (r13 == true) goto L73;
        boolean r15 = r10 instanceof o;
        if (r15 == true) goto L20;
        if ((r10 instanceof n) == true) goto L38;
        if ((r12 instanceof ue.u) == true) goto L63;
        he.i.d(r12, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        n r16 = new n(r10, (e) r12, null, null, 28);
    L66:
        if (r8.compareAndSet(this, r10, r16) == true) goto L71;
        if (r8.get(this) == r10) goto L66;
        r11 = false;
    L71:
        if (r11 == false) goto L2;
        return;
    L63:
        return;
    L38:
        n r17 = (n) r10;
        if (r17.f10044b != null) goto L59;
        if ((r12 instanceof ue.u) == true) goto L42;
        he.i.d(r12, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        e r18 = (e) r12;
        Throwable r19 = r17.f10047e;
        if (r19 == null) goto L46;
        boolean r20 = true;
    L47:
        if (r20 == true) goto L48;
        n r21 = n.a(r17, r18, null, 29);
    L52:
        if (r8.compareAndSet(this, r10, r21) == true) goto L57;
        if (r8.get(this) == r10) goto L52;
        r11 = false;
    L57:
        if (r11 == false) goto L2;
        return;
    L48:
        i(r18, r19);
        return;
    L46:
        r20 = false;
        goto L47
    L42:
        return;
    L59:
        w(r12, r10);
        throw null;
    L20:
        o r22 = (o) r10;
        r22.getClass();
        if (o.f10051b.compareAndSet(r22, 0, 1) == true) goto L23;
        w(r12, r10);
        throw null;
    L23:
        if ((r10 instanceof i) == false) goto L101;
        if (r15 == true) goto L27;
        r22 = null;
    L27:
        if (r22 == null) goto L30;
        r14 = r22.f10052a;
    L30:
        if ((r12 instanceof e) == false) goto L32;
        i((e) r12, r14);
        return;
    L32:
        he.i.d(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        k((ue.u) r12, r14);
        return;
    L101:
        return;
    L73:
        w(r12, r10);
        throw null;
    L15:
        r13 = r10 instanceof ue.u;
    L5:
        if (r8.compareAndSet(this, r10, r12) == true) goto L10;
        if (r8.get(this) == r10) goto L5;
        r11 = false;
    L10:
        if (r11 == false) goto L2;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append(x());
        r8.append('(');
        r8.append(d0.d(this.f10014n));
        r8.append("){");
        Object r10 = f10012q.get(this);
        if ((r10 instanceof o1) == false) goto L6;
        String r11 = "Active";
    L9:
        r8.append(r11);
        r8.append("}@");
        r8.append(d0.c(this));
        return r8.toString();
    L6:
        if ((r10 instanceof i) == false) goto L8;
        r11 = "Cancelled";
        goto L9
    L8:
        r11 = "Completed";
        goto L9
    }

    public final boolean u() {
        return !(f10012q.get(this) instanceof o1);
    }

    public final boolean v() {
        if (this.f10042m != 2) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L14;
        ae.d<T> r10 = this.f10014n;
        he.i.d(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (ue.g.f12593r.get((ue.g) r10) == null) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L14;
        return true;
    L10:
        r11 = false;
    L14:
        return false;
    L5:
        r8 = false;
        goto L6
    }

    public String x() {
        return "CancellableContinuation";
    }

    public final void y() {
        ae.d<T> r8 = this.f10014n;
        Throwable r10 = null;
        if ((r8 instanceof ue.g) == false) goto L5;
        ue.g r11 = (ue.g) r8;
    L6:
        if (r11 == null) goto L33;
    L7:
        AtomicReferenceFieldUpdater r12 = ue.g.f12593r;
        Object r13 = r12.get(r11);
        b9.a r14 = ue.h.f12599b;
        boolean r15 = false;
        if (r13 != r14) goto L17;
    L10:
        if (r12.compareAndSet(r11, r14, this) == true) goto L11;
        if (r12.get(r11) == r14) goto L10;
    L14:
        if (r15 == false) goto L7;
    L25:
        if (r10 == null) goto L44;
        m();
        l(r10);
        return;
    L44:
        return;
    L11:
        r15 = true;
        goto L14
    L17:
        if ((r13 instanceof Throwable) == false) goto L32;
    L19:
        if (r12.compareAndSet(r11, r13, null) == true) goto L20;
        if (r12.get(r11) == r13) goto L19;
    L23:
        if (r15 == false) goto L30;
        r10 = (Throwable) r13;
        goto L25
    L30:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L20:
        r15 = true;
        goto L23
    L32:
        throw new IllegalStateException(("Inconsistent state " + r13).toString());
    L33:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void z(Object r8, int r10, ge.l<? super Throwable, xd.j> r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = f10012q;
        Object r13 = r12.get(this);
        boolean r14 = false;
        if ((r13 instanceof o1) == false) goto L17;
        Object r15 = B((o1) r13, r8, r10, r11);
    L6:
        if (r12.compareAndSet(this, r13, r15) == true) goto L7;
        if (r12.get(this) == r13) goto L6;
    L10:
        if (r14 == false) goto L2;
        if (v() == true) goto L14;
        m();
    L14:
        n(r10);
        return;
    L7:
        r14 = true;
        goto L10
    L17:
        if ((r13 instanceof i) == false) goto L24;
        i r16 = (i) r13;
        r16.getClass();
        if (i.f10017c.compareAndSet(r16, 0, 1) == false) goto L24;
        if (r11 == null) goto L32;
        j(r11, r16.f10052a);
        return;
    L32:
        return;
    L24:
        throw new IllegalStateException(("Already resumed, but proposed with update " + r8).toString());
    }
}
