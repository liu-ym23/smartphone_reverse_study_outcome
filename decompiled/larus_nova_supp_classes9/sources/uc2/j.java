package uc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public final float a;
    public final float b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L10;
        j r4 = (j) r3;
        if (Float.compare(this.a, r4.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "PointF(x=" + this.a + ", y=" + this.b + ")";
    }

    public j(float r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
