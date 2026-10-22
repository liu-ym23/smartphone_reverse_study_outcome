package com.larus.avlink.gallery.processor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public long a;
    public int b;
    public int c;
    public int d;
    public int e;
    public long f;

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        long r3 = this.f;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "AllTaskModel(totalSize=" + this.a + ", photoCount=" + this.b + ", videoCount=" + this.c + ", photoSuccessCount=" + this.d + ", videoSuccessCount=" + this.e + "), mediaDuration=" + this.f;
    }

    public a(int r3) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }
}
