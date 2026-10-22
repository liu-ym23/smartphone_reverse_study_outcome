package pe;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends ae.a implements ae.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10080b = null;

    public static final class a extends ae.b<ae.e, w> {

        /* JADX INFO: renamed from: pe.w$a$a, reason: collision with other inner class name */
        public static final class C0136a extends he.j implements ge.l<ae.f.b, w> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0136a f10081a = null;

            static {
                f10081a = new C0136a();
            }

            public C0136a() {
                super(1);
            }

            @Override // ge.l
            public final w invoke(ae.f.b r8) {
                ae.f.b r10 = r8;
                if ((r10 instanceof w) == true) goto L7;
                return null;
            L7:
                return (w) r10;
            }
        }

        public a() {
            super(ae.e.b.f352a, C0136a.f10081a);
        }
    }

    static {
        f10080b = new a();
    }

    public w() {
        super(ae.e.b.f352a);
    }

    @Override // ae.e
    public final ue.g f0(ae.d r8) {
        return new ue.g(this, r8);
    }

    @Override // ae.a, ae.f
    public final ae.f h0(ae.f.c<?> r8) {
        return ae.e.a.b(this, r8);
    }

    @Override // ae.a, ae.f
    public final <E extends ae.f.b> E q0(ae.f.c<E> r8) {
        return (E) ae.e.a.a(this, r8);
    }

    public abstract void r0(ae.f r8, Runnable r10);

    public boolean s0() {
        return !(this instanceof y1);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + d0.c(this);
    }

    @Override // ae.e
    public final void z(ae.d<?> r8) {
        ue.g r10 = (ue.g) r8;
    L3:
        AtomicReferenceFieldUpdater r11 = ue.g.f12593r;
        if (r11.get(r10) == ue.h.f12599b) goto L3;
        Object r12 = r11.get(r10);
        if ((r12 instanceof h) == false) goto L8;
        h r13 = (h) r12;
    L9:
        if (r13 == null) goto L14;
        r13.m();
        return;
    L14:
        return;
    L8:
        r13 = null;
        goto L9
    }
}
