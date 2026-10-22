package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class q1<T> extends i1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h<T> f10057o;

    public q1(j1.a r8) {
        this.f10057o = r8;
    }

    @Override // ge.l
    public final /* bridge */ /* synthetic */ xd.j invoke(Throwable r8) {
        m(r8);
        return xd.j.f13877a;
    }

    @Override // pe.q
    public final void m(Throwable r8) {
        Object r10 = n().t();
        if ((r10 instanceof o) == false) goto L5;
        Object r11 = defpackage.c.D(((o) r10).f10052a);
    L6:
        this.f10057o.resumeWith(r11);
        return;
    L5:
        r11 = k1.a(r10);
        goto L6
    }
}
