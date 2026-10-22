package k31;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final a e = null;
    public final double a;
    public final double b;
    public final double c;
    public final double d;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof j) == false) goto L14;
        j r6 = (j) r5;
        if (Double.compare(this.a, r6.a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.b, r6.b) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.c, r6.c) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.d, r6.d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = Double.doubleToLongBits(this.c);
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = Double.doubleToLongBits(this.d);
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    static {
        e = new a();
    }

    public final String toString() {
        return "seiLayout[ratioLeft = " + this.a + ", ratioTop = " + this.b + ", ratioRight = " + this.c + ", ratioBottom = " + this.d + ']';
    }

    public j(double r1, double r3, double r5, double r7) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r7;
    }
}
