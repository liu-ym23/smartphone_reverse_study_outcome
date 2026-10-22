package ue;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.d0;
import pe.m0;
import pe.s0;
import pe.u1;

/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends m0<T> implements ce.d, ae.d<T> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12593r = null;
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final pe.w f12594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ae.d<T> f12595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Object f12596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f12597q;

    static {
        f12593r = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(pe.w r8, ae.d<? super T> r10) {
        super(-1);
        this.f12594n = r8;
        this.f12595o = r10;
        this.f12596p = h.f12598a;
        Object r11 = getContext().B(0, w.f12628b);
        he.i.c(r11);
        this.f12597q = r11;
    }

    @Override // pe.m0
    public final void b(Object r8, CancellationException r10) {
        if ((r8 instanceof pe.p) == false) goto L6;
        ((pe.p) r8).f10054b.invoke(r10);
        return;
    }

    @Override // pe.m0
    public final ae.d<T> d() {
        return this;
    }

    @Override // ce.d
    public final ce.d getCallerFrame() {
        ae.d<T> r8 = this.f12595o;
        if ((r8 instanceof ce.d) == true) goto L7;
        return null;
    L7:
        return (ce.d) r8;
    }

    @Override // ae.d
    public final ae.f getContext() {
        return this.f12595o.getContext();
    }

    @Override // pe.m0
    public final Object h() {
        Object r8 = this.f12596p;
        this.f12596p = h.f12598a;
        return r8;
    }

    @Override // ae.d
    public final void resumeWith(Object r10) {
        ae.d<T> r8 = this.f12595o;
        ae.f r11 = r8.getContext();
        Throwable r12 = xd.e.a(r10);
        if (r12 != null) goto L5;
        Object r13 = r10;
    L6:
        pe.w r14 = this.f12594n;
        if (r14.s0() == false) goto L9;
        this.f12596p = r13;
        this.f10042m = 0;
        r14.r0(r11, this);
        return;
    L9:
        s0 r15 = u1.a();
        if (r15.f10061m < 4294967296L) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L18;
        this.f12596p = r13;
        this.f10042m = 0;
        yd.d<m0<?>> r17 = r15.f10063o;
        if (r17 != null) goto L17;
        r17 = new yd.d();
        r15.f10063o = r17;
    L17:
        r17.addLast(this);
        return;
    L18:
        r15.u0(true);
        ae.f r18 = getContext();     // Catch: Throwable -> L28
        Object r19 = w.b(r18, this.f12597q);     // Catch: Throwable -> L28
        r8.resumeWith(r10);     // Catch: Throwable -> L25
        xd.j r110 = xd.j.f13877a;     // Catch: Throwable -> L25
        w.a(r18, r19);     // Catch: Throwable -> L28
    L23:
        if (r15.w0() == true) goto L23;
    L31:
        r15.t0(true);
        return;
    L25:
        th = move-exception;
        w.a(r18, r19);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        g(th, null);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r15.t0(true);
        throw th;
    L12:
        r16 = false;
        goto L13
    L5:
        r13 = new pe.o(false, r12);
        goto L6
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f12594n + ", " + d0.d(this.f12595o) + ']';
    }
}
