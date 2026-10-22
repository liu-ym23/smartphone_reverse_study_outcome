package j80;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final float a;
    public final float b;

    public d() {
        this(0.0f, 0.0f);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L10;
        d r4 = (d) r3;
        if (Float.compare(a().floatValue(), r4.a().floatValue()) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(b().floatValue(), r4.b().floatValue()) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(a().floatValue()) * 31) + Float.floatToIntBits(b().floatValue());
    }

    public final String toString() {
        return "Vec2f(x=" + a() + ", y=" + b() + ")";
    }

    public final Float a() {
        return Float.valueOf(this.a);
    }

    public final Float b() {
        return Float.valueOf(this.b);
    }

    public d(float r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
