package f9;

import he.i;
import vb.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ub.a f7356b;

    public a(c r8, ub.a r10) {
        this.f7355a = r8;
        this.f7356b = r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L4;
        return true;
    L4:
        if ((r8 instanceof a) == false) goto L10;
        a r10 = (a) r8;
        c r11 = r10.f7355a;
        if (i.a(this.f7355a, r11) == true) goto L8;
        return false;
    L8:
        if (i.a(this.f7356b, r10.f7356b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r8 = 0;
        c r10 = this.f7355a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        ub.a r13 = this.f7356b;
        if (r13 == null) goto L10;
        r8 = r13.hashCode();
    L10:
        return r12 + r8;
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "SpringAnimationHolder(animation=" + this.f7355a + ", config=" + this.f7356b + ")";
    }
}
