package pe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends j1 implements ae.d<T>, z {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ae.f f9991m;

    public a(ae.f r8, boolean r10) {
        super(r10);
        y((e1) r8.q0(e1.b.f10008a));
        this.f9991m = r8.C(this);
    }

    @Override // pe.j1
    public String M() {
        return super.M();
    }

    @Override // pe.j1
    public final void P(Object r8) {
        if ((r8 instanceof o) == false) goto L6;
        o r10 = (o) r8;
        Throwable r11 = r10.f10052a;
        r10.getClass();
        o.f10051b.get(r10);
        return;
    }

    public final void W(b0 r8, a r10, ge.p r11) {
        int r12 = r8.ordinal();
        if (r12 != 0) goto L5;
        ue.h.a(l6.a.b0(l6.a.B(r10, this, r11)), xd.j.f13877a, null);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        resumeWith(defpackage.c.D(th));
        throw th;
    L5:
        if (r12 != 1) goto L7;
        return;
    L7:
        if (r12 != 2) goto L9;
        he.i.f(r11, "<this>");
        l6.a.b0(l6.a.B(r10, this, r11)).resumeWith(xd.j.f13877a);
        return;
    L9:
        if (r12 != 3) goto L23;
        ae.f r13 = this.f9991m;     // Catch: Throwable -> L19
        Object r14 = ue.w.b(r13, null);     // Catch: Throwable -> L19
        he.r.a(2, r11);     // Catch: Throwable -> L16
        Object r15 = r11.invoke(r10, this);     // Catch: Throwable -> L16
        ue.w.a(r13, r14);     // Catch: Throwable -> L19
        if (r15 == be.a.f3165a) goto L36;
    L21:
        resumeWith(r15);
        return;
    L36:
        return;
    L16:
        th = move-exception;
        ue.w.a(r13, r14);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r15 = defpackage.c.D(th);
        goto L21
    L23:
        throw new ha.t();
    }

    @Override // pe.j1, pe.e1
    public final boolean a() {
        return super.a();
    }

    @Override // pe.z
    public final ae.f d() {
        return this.f9991m;
    }

    @Override // ae.d
    public final ae.f getContext() {
        return this.f9991m;
    }

    @Override // pe.j1
    public final String j() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // ae.d
    public final void resumeWith(Object r8) {
        Throwable r10 = xd.e.a(r8);
        if (r10 == null) goto L6;
        r8 = new o(false, r10);
    L6:
        Object r11 = L(r8);
        if (r11 != k1.f10034b) goto L9;
        return;
    L9:
        f(r11);
    }

    @Override // pe.j1
    public final void w(d1.c r8) {
        y.a(this.f9991m, r8);
    }
}
