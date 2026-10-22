package lja;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L18;
        b r4 = (b) r3;
        if (Float.compare(this.a, r4.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r4.e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f, r4.f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f);
    }

    public final String toString() {
        return "ControlPoint(handleLarge=" + this.a + ", distanceOuter=" + this.b + ", distanceInner=" + this.c + ", handleMedium=" + this.d + ", curveInner=" + this.e + ", curveOuter=" + this.f + ")";
    }

    public b() {
        this.a = 67.45f;
        this.b = 51.16f;
        this.c = 34.86f;
        this.d = 22.07f;
        this.e = 13.36f;
        this.f = 4.64f;
    }
}
