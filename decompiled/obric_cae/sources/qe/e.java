package qe;

import ge.l;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends j implements l<Throwable, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f11301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f11302b;

    public e(f r8, d r10) {
        this.f11301a = r8;
        this.f11302b = r10;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(Throwable r8) {
        this.f11301a.f11303m.removeCallbacks(this.f11302b);
        return xd.j.f13877a;
    }
}
