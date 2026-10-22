package xd;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class d<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f13867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f13868b;

    public d(A r8, B r10) {
        this.f13867a = r8;
        this.f13868b = r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r8;
        A r11 = r10.f13867a;
        if (he.i.a(this.f13867a, r11) == true) goto L12;
        return false;
    L12:
        if (he.i.a(this.f13868b, r10.f13868b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r8 = 0;
        A r10 = this.f13867a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        B r13 = this.f13868b;
        if (r13 == null) goto L11;
        r8 = r13.hashCode();
    L11:
        return r12 + r8;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "(" + this.f13867a + ", " + this.f13868b + ')';
    }
}
