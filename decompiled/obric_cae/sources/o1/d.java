package o1;

import androidx.work.n;
import he.i;
import p1.h;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class d extends c<n1.b> {
    public d(h<n1.b> r8) {
        i.f(r8, "tracker");
        super(r8);
    }

    @Override // o1.c
    public final boolean b(t r8) {
        i.f(r8, "workSpec");
        if (r8.f11348j.f2808a != n.f2933b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // o1.c
    public final boolean c(n1.b r8) {
        n1.b r10 = r8;
        i.f(r10, "value");
        if (r10.f9419a == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.f9420b == false) goto L8;
        return false;
    }
}
