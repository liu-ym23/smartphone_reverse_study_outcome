package ue;

import pe.x1;

/* JADX INFO: loaded from: classes2.dex */
public class t<T> extends pe.a<T> implements ce.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ae.d<T> f12625n;

    public t(x1.a r8, ae.f r10) {
        super(r10, true);
        this.f12625n = r8;
    }

    @Override // pe.j1
    public final boolean F() {
        return true;
    }

    @Override // pe.j1
    public void e(Object r8) {
        h.a(l6.a.b0(this.f12625n), l6.a.G0(r8), null);
    }

    @Override // pe.j1
    public void f(Object r8) {
        this.f12625n.resumeWith(l6.a.G0(r8));
    }

    @Override // ce.d
    public final ce.d getCallerFrame() {
        ae.d<T> r8 = this.f12625n;
        if ((r8 instanceof ce.d) == true) goto L7;
        return null;
    L7:
        return (ce.d) r8;
    }
}
