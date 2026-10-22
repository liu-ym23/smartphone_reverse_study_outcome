package com.bytedance.live.artist.render;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements nf6.a {
    public float a;
    public float b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
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
        return "Size(width=" + this.a + ", height=" + this.b + ")";
    }

    public f() {
        this.a = 0.0f;
        this.b = 0.0f;
    }
}
