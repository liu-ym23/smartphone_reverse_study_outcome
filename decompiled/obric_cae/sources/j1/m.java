package j1;

/* JADX INFO: loaded from: classes.dex */
public final class m implements androidx.work.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.lifecycle.t<androidx.work.p.a> f8514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t1.c<androidx.work.p.a.c> f8515d;

    public m() {
        this.f8514c = new androidx.lifecycle.t();
        this.f8515d = new t1.c();
        a(androidx.work.p.f2940b);
    }

    public final void a(androidx.work.p.a r8) {
        this.f8514c.g(r8);
        boolean r10 = r8 instanceof androidx.work.p.a.c;
        t1.c<androidx.work.p.a.c> r11 = this.f8515d;
        if (r10 == false) goto L6;
        r11.j((androidx.work.p.a.c) r8);
        return;
    L6:
        if ((r8 instanceof androidx.work.p.a.C0026a) == false) goto L10;
        r11.k(((androidx.work.p.a.C0026a) r8).f2941a);
        return;
    }
}
