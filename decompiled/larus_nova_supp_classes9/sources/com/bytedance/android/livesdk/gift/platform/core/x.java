package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x {
    public final float a;
    public final double b;
    public final double c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof x) == false) goto L12;
        x r6 = (x) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.b, r6.b) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.c, r6.c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = Float.floatToIntBits(this.a) * 31;
        long r1 = Double.doubleToLongBits(this.b);
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = Double.doubleToLongBits(this.c);
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "HotRoomInfo(temperature=" + this.a + ", UIFps=" + this.b + ", UpStreamFps=" + this.c + ")";
    }

    public x(float r1, double r2, double r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
