package re;

import ge.l;
import he.j;
import pe.g;
import pe.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends j implements l<Throwable, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g<xd.j> f11808a;

    public c(h r8) {
        this.f11808a = r8;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(Throwable r8) {
        xd.j r10 = xd.j.f13877a;
        this.f11808a.resumeWith(r10);
        return r10;
    }
}
