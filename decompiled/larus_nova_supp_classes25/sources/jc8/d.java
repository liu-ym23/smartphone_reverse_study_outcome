package jc8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public d() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "BlockMargin(start=" + this.a + ", top=" + this.b + ", end=" + this.c + ", bottom=" + this.d + ')';
    }

    public d(int r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public static d a(d r2, int r3, int r4, int r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = r2.a;
    L6:
        if ((r6 & 2) == 0) goto L8;
        int r0 = r2.b;
    L10:
        if ((r6 & 4) == 0) goto L13;
        r4 = r2.c;
    L13:
        if ((r6 & 8) == 0) goto L15;
        r5 = r2.d;
    L15:
        r2.getClass();
        return new d(r3, r0, r4, r5);
    L8:
        r0 = 0;
        goto L10
    }
}
