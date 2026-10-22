package m20;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public int a;
    public int b;
    public int c;
    public int d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
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
        return "XplayPerfData(width=" + this.a + ", height=" + this.b + ", fps=" + this.c + ", bitrate=" + this.d + ")";
    }

    public a(int r1) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }
}
