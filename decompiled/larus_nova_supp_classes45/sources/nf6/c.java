package nf6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements a {
    public float a;
    public float b;
    public final float c;
    public final float d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L14;
        c r4 = (c) r3;
        if (Float.compare(this.a, r4.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
    }

    public final String toString() {
        return "Scale2D(sx=" + this.a + ", sy=" + this.b + ", px=" + this.c + ", py=" + this.d + ")";
    }

    public c() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
    }
}
