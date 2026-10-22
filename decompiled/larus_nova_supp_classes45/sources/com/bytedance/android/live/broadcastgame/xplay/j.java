package com.bytedance.android.live.broadcastgame.xplay;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public final int a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L10;
        j r4 = (j) r3;
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
        return "Size(width=" + this.a + ", height=" + this.b + ")";
    }

    public j(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
