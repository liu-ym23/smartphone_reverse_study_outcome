package jba;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
    }

    public final String toString() {
        return "ObricLandscapeWindowCornerRadii(topLeft=" + this.a + ", topRight=" + this.b + ", bottomRight=" + this.c + ", bottomLeft=" + this.d + ')';
    }

    public final boolean a() {
        if (this.a <= 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (this.b > 0.0f) goto L12;
        if (this.c > 0.0f) goto L12;
        if (this.d > 0.0f) goto L12;
        return false;
    }

    public c(float r1, float r2, float r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
