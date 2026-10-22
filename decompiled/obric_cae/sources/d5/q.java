package d5;

import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class q extends l {
    @Override // d5.l
    public final void g() {
        super.g();
        j0 r8 = this.f6808f;
        if (r8.J == false) goto L5;
        defpackage.c r10 = x4.h.f13430b.f13452b;
    L7:
        if (r10.F() == false) goto L10;
        g5.k.c(this.f6807e).b();
        return;
    L10:
        return;
    L5:
        String r11 = String.valueOf(r8.f13463a);
        y4.a r12 = x4.h.f13429a;
        r10 = x4.j.c(r11).f13452b;
        goto L7
    }

    @Override // d5.l
    public final void j() {
        super.j();
        j0 r8 = this.f6808f;
        r8.getClass();
        if (r8.D == false) goto L13;
        k5.j.a r10 = k5.j.f8942a;
        if (this.f6807e.getApplicationInfo().targetSdkVersion < 30) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L11;
        int r12 = x4.r.f13543a;
        return;
    L11:
        String r13 = r8.a();
        x4.t.f(new j(r8), r13);
        return;
    L7:
        r11 = false;
        goto L8
    }
}
