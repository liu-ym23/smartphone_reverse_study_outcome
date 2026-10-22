package sf0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L14;
        c r4 = (c) r3;
        if (this.b == r4.b) goto L8;
        return false;
    L8:
        if (this.c == r4.c) goto L10;
        return false;
    L10:
        if (this.d == r4.d) goto L12;
        return false;
    L12:
        if (this.e == r4.e) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "DynamicSeatAreaFrameInfo(x=" + this.b + ", y=" + this.c + ", width=" + this.d + ", height=" + this.e + ")";
    }

    public c(int r1, int r2, int r3, int r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
