package nf6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements a {
    public float a;
    public float b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
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
        return "Position2D(posX=" + this.a + ", posY=" + this.b + ")";
    }

    public b() {
        this.a = 0.0f;
        this.b = 0.0f;
    }
}
