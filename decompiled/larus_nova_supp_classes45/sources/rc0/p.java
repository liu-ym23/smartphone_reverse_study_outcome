package rc0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L14;
        p r4 = (p) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "RevenuePlayerLayoutDescriptorExternal(width=" + this.a + ", height=" + this.b + ", leftMargin=" + this.c + ", topMargin=" + this.d + ")";
    }

    public p(int r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
