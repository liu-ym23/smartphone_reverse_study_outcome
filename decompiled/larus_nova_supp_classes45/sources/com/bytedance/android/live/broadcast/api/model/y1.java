package com.bytedance.android.live.broadcast.api.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y1 {
    public float a;
    public float b;
    public float c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof y1) == false) goto L12;
        y1 r4 = (y1) r3;
        if (Float.compare(this.a, r4.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c);
    }

    public final String toString() {
        return "ZoomModel(frontRatio=" + this.a + ", backRatio=" + this.b + ", updateValue=" + this.c + ")";
    }

    public /* synthetic */ y1() {
        this(1.0f);
    }

    public y1(float r2) {
        this.a = 1.0f;
        this.b = 1.0f;
        this.c = r2;
    }
}
