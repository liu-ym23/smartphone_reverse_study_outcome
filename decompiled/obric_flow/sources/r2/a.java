package r2;

import k5.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21642c;
    public final int d;
    public final float e;

    public a(float r5, int r10, int r11, int r12, int r13) {
        this.f21640a = r10;
        this.f21641b = r11;
        this.f21642c = r12;
        this.d = r13;
        this.e = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        int r11 = r10.f21640a;
        if (this.f21640a == r11) goto L12;
        return false;
    L12:
        if (this.f21641b == r10.f21641b) goto L15;
        return false;
    L15:
        if (this.f21642c == r10.f21642c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r10.e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f21640a) * 31;
        int r10 = d.a(this.f21641b, r5);
        int r11 = d.a(this.f21642c, r10);
        int r12 = d.a(this.d, r11);
        return Float.hashCode(this.e) + r12;
    }

    public final String toString() {
        return "DisplaySnapshot(widthPixels=" + this.f21640a + ", heightPixels=" + this.f21641b + ", densityDpi=" + this.f21642c + ", orientation=" + this.d + ", fontScale=" + this.e + ')';
    }
}
