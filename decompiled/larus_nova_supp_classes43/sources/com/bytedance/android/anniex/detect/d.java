package com.bytedance.android.anniex.detect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final long d;
    public final long e;
    public final float f;
    public final float g;
    public final long h;
    public final long i;
    public final long j;

    public d() {
        this(false, false, false, 1500, 500, 360.0f, 0.9f, 500, 500, ((long) 60) * 1000);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r11.f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r11.g) == 0) goto L30;
        return false;
    L30:
        if (this.h == r11.h) goto L33;
        return false;
    L33:
        if (this.i == r11.i) goto L36;
        return false;
    L36:
        if (this.j == r11.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == false) goto L9;
        int r11 = 1231;
    L10:
        int r12 = (r10 + r11) * 31;
        if (this.c == true) goto L14;
        r1 = 1237;
    L14:
        int r13 = (r12 + r1) * 31;
        long r14 = this.d;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        long r16 = this.e;
        int r17 = (((((r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31;
        long r18 = this.h;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        long r20 = this.i;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        long r22 = this.j;
        return r21 + ((int) (r22 ^ (r22 >>> 32)));
    L9:
        r11 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BlankDetectorConfig(isCheckEnable=" + this.a + ", isPureBlankCheckEnable=" + this.b + ", isPartialBlankCheckEnable=" + this.c + ", checkTimeoutMs=" + this.d + ", snapShotTimeoutMs=" + this.e + ", snapShotMaxQuality=" + this.f + ", pureColorCheckThreshold=" + this.g + ", pureColorCheckTimeoutMs=" + this.h + ", partialBlankCheckTimeoutMs=" + this.i + ", detectFrequencyInternal=" + this.j + ')';
    }

    public d(boolean r1, boolean r10, boolean r11, long r12, long r13, float r14, float r15, long r16, long r17, long r18) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
    }
}
