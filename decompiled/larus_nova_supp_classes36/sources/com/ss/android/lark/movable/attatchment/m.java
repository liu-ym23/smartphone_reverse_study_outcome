package com.ss.android.lark.movable.attatchment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m {
    public final float a;
    public final float b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "ImageMeasureSize(width=" + this.a + ", height=" + this.b + ')';
    }

    public m(float r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
