package o1;

import androidx.work.n;
import he.i;
import p1.h;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9610f;

    public a(h r8, int r10) {
        this.f9610f = r10;
        if (r10 == 1) goto L6;
        i.f(r8, "tracker");
        super(r8);
        return;
    L6:
        i.f(r8, "tracker");
        super(r8);
    }

    @Override // o1.c
    public final boolean b(t r8) {
        switch(this.f9610f) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        i.f(r8, "workSpec");
        return r8.f11348j.f2809b;
    L7:
        i.f(r8, "workSpec");
        n r10 = r8.f11348j.f2808a;
        if (r10 != n.f2934m) goto L10;
    L13:
        return true;
    L10:
        if (r10 == n.f2937p) goto L13;
        return false;
    }

    @Override // o1.c
    public final boolean c(Object r8) {
        switch(this.f9610f) {
            case 0: goto L6;
            default: goto L7;
        };
    L7:
        n1.b r10 = (n1.b) r8;
        i.f(r10, "value");
        if (r10.f9419a == true) goto L10;
        return true;
    L10:
        if (r10.f9421c == true) goto L15;
        return false;
    L15:
        return true;
    L6:
        return !((Boolean) r8).booleanValue();
    }
}
