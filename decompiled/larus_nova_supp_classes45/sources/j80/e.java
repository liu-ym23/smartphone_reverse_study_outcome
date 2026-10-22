package j80;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final int a;
    public final int b;

    public e() {
        this(0, 0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L10;
        e r4 = (e) r3;
        if (a().intValue() == r4.a().intValue()) goto L8;
        return false;
    L8:
        if (b().intValue() == r4.b().intValue()) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (a().intValue() * 31) + b().intValue();
    }

    public final String toString() {
        return "Vec2i(x=" + a() + ", y=" + b() + ")";
    }

    public final Integer a() {
        return Integer.valueOf(this.a);
    }

    public final Integer b() {
        return Integer.valueOf(this.b);
    }

    public e(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
