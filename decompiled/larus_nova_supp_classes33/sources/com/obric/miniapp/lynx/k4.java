package com.obric.miniapp.lynx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k4 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k4) == true) goto L8;
        return false;
    L8:
        k4 r6 = (k4) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
    }

    public final String toString() {
        return "MenuContentMetrics(left=" + this.a + ", top=" + this.b + ", width=" + this.c + ", height=" + this.d + ", right=" + this.e + ", bottom=" + this.f + ')';
    }

    public k4(int r3, int r4, int r5, int r6) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r3 + r5;
        this.f = r4 + r6;
    }
}
