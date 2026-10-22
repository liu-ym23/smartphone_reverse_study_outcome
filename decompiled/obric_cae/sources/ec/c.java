package ec;

import ge.l;
import he.i;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends j implements l<ub.a, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f7222b;

    public c(float r8, float r10) {
        this.f7221a = r8;
        this.f7222b = r10;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(ub.a r8) {
        ub.a r10 = r8;
        i.f(r10, "$receiver");
        r10.f12561d = true;
        r10.f12563f = this.f7221a;
        r10.f12564g = true;
        r10.f12566i = this.f7222b;
        return xd.j.f13877a;
    }
}
