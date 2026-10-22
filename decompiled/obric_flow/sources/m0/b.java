package m0;

import java.util.ArrayList;
import java.util.List;
import l.g;
import l.j;

/* JADX INFO: loaded from: classes.dex */
public final class b implements p.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f19945a;

    public b() {
        this.f19945a = new ArrayList();
    }

    @Override // p.e
    public l.d d() {
        ArrayList r5 = this.f19945a;
        if (((v.a) r5.get(0)).c() == false) goto L7;
        return new g(r5, 1);
    L7:
        return new j(r5);
    }

    @Override // p.e
    public List e() {
        return this.f19945a;
    }

    @Override // p.e
    public boolean isStatic() {
        ArrayList r5 = this.f19945a;
        if (r5.size() == 1) goto L5;
        return false;
    L5:
        if (((v.a) r5.get(0)).c() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public b(ArrayList r5) {
        this.f19945a = r5;
    }
}
