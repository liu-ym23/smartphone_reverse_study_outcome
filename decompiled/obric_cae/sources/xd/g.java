package xd;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class g<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f13874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f13875b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C f13876m;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Integer r8, Boolean r10, Boolean r11) {
        this.f13874a = r8;
        this.f13875b = r10;
        this.f13876m = r11;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r8;
        A r11 = r10.f13874a;
        if (he.i.a(this.f13874a, r11) == true) goto L12;
        return false;
    L12:
        if (he.i.a(this.f13875b, r10.f13875b) == true) goto L15;
        return false;
    L15:
        if (he.i.a(this.f13876m, r10.f13876m) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r8 = 0;
        A r10 = this.f13874a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        B r13 = this.f13875b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        C r16 = this.f13876m;
        if (r16 == null) goto L15;
        r8 = r16.hashCode();
    L15:
        return r15 + r8;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "(" + this.f13874a + ", " + this.f13875b + ", " + this.f13876m + ')';
    }
}
