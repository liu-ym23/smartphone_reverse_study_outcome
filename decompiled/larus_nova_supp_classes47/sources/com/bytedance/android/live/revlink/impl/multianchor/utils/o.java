package com.bytedance.android.live.revlink.impl.multianchor.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public final int a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L10;
        o r4 = (o) r3;
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
        return "LinkTypeParams(matchType=" + this.a + ", inviteType=" + this.b + ")";
    }

    public o(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
