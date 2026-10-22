package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class he1 {
    public final long a;
    public final int b;
    public final int c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof he1) == false) goto L12;
        he1 r7 = (he1) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "PlayerTipsFilterConfig(showTimestamp=" + this.a + ", showTimes=" + this.b + ", closeTimes=" + this.c + ")";
    }

    public he1() {
        this(0, 0, 0);
    }

    public he1(long r1, int r3, int r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
