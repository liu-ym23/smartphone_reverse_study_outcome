package com.bytedance.android.live.broadcastgame.xplay.screendetect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public int a;
    public int b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "Pixel(pixel=" + this.a + ", times=" + this.b + ")";
    }

    public b(int r1) {
        this.a = 0;
        this.b = 0;
    }
}
