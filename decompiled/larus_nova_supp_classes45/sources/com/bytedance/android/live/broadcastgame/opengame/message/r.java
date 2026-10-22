package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements com.bytedance.android.live.broadcastgame.v {
    public final String a;
    public final long b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof r) == false) goto L12;
        r r7 = (r) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
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
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.b;
        return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.c;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "DiamondPay(appId=" + this.a + ", startId=" + this.b + ", diamond=" + this.c + ")";
    }

    public r(String r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
