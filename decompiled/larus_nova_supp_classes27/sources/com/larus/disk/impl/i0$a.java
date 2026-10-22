package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0$a {
    public final long a;
    public final float b;
    public final boolean c;
    public final int d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i0$a) == true) goto L8;
        return false;
    L8:
        i0$a r9 = (i0$a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + Float.floatToIntBits(this.b)) * 31;
        if (this.c == false) goto L5;
        int r2 = 1231;
    L7:
        return ((r1 + r2) * 31) + this.d;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "MonitorState(observationStartMs=" + this.a + ", reportSampleRate=" + this.b + ", reportSampled=" + this.c + ", version=" + this.d + ')';
    }

    public i0$a(long r1, float r3, boolean r4, int r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
