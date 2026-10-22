package com.bytedance.android.anniex.scene.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final double a;
    public final double b;

    public j() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (Double.compare(this.a, r11.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r11.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r10 = Double.doubleToLongBits(this.b);
        return r1 + ((int) (r10 ^ (r10 >>> 32)));
    }

    public final String toString() {
        return "ScoreModel(alpha=" + this.a + ", beta=" + this.b + ')';
    }

    public /* synthetic */ j(int r10) {
        this(1.1d, 0.9d);
    }

    public j(double r1, double r10) {
        this.a = r1;
        this.b = r10;
    }
}
