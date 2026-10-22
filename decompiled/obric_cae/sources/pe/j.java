package pe;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends g1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h<?> f10019o;

    public j(h<?> r8) {
        this.f10019o = r8;
    }

    @Override // ge.l
    public final /* bridge */ /* synthetic */ xd.j invoke(Throwable r8) {
        m(r8);
        return xd.j.f13877a;
    }

    @Override // pe.q
    public final void m(Throwable r8) {
        j1 r10 = n();
        h<?> r11 = this.f10019o;
        Throwable r12 = r11.o(r10);
        boolean r13 = false;
        if (r11.v() == false) goto L26;
        ae.d<?> r14 = r11.f10014n;
        he.i.d(r14, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ue.g r15 = (ue.g) r14;
    L6:
        AtomicReferenceFieldUpdater r16 = ue.g.f12593r;
        Object r17 = r16.get(r15);
        b9.a r18 = ue.h.f12599b;
        boolean r19 = true;
        if (he.i.a(r17, r18) == true) goto L9;
        if ((r17 instanceof Throwable) == true) goto L18;
    L20:
        if (r16.compareAndSet(r15, r17, null) == true) goto L25;
        if (r16.get(r15) == r17) goto L20;
        r19 = false;
    L25:
        if (r19 == false) goto L6;
    L18:
        r13 = true;
    L9:
        if (r16.compareAndSet(r15, r18, r12) == true) goto L10;
        if (r16.get(r15) == r18) goto L9;
        boolean r20 = false;
    L14:
        if (r20 == false) goto L6;
    L10:
        r20 = true;
    L26:
        if (r13 == true) goto L47;
        r11.l(r12);
        if (r11.v() == true) goto L46;
        r11.m();
        return;
    L46:
        return;
    }
}
