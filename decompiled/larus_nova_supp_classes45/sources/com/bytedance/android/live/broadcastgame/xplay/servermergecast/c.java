package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;
    public long f;

    public c() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L18;
        c r6 = (c) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r6.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r6.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r6.d) == 0) goto L14;
        return false;
    L14:
        if (this.e == r6.e) goto L16;
        return false;
    L16:
        if (this.f == r6.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e) * 31;
        long r1 = this.f;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "LittleWindowMixerParams(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ", zOrder=" + this.e + ", flags=" + this.f + ")";
    }

    public /* synthetic */ c(int r9) {
        this(0.0f, 0.0f, 1.0f, 1.0f, 0, 1);
    }

    public c(float r1, float r2, float r3, float r4, int r5, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
