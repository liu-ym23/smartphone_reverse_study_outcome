package ec;

import ge.l;
import he.i;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends j implements l<ub.a, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f7227b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f7228m;

    public e(float r8, float r10, int r11) {
        this.f7226a = r8;
        this.f7227b = r10;
        this.f7228m = r11;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(ub.a r8) {
        ub.a r10 = r8;
        i.f(r10, "$receiver");
        r10.f12561d = true;
        r10.f12563f = this.f7226a;
        r10.f12564g = true;
        r10.f12566i = this.f7227b;
        float r11 = this.f7228m;
        r10.f12558a = true;
        r10.f12559b = r11;
        return xd.j.f13877a;
    }
}
