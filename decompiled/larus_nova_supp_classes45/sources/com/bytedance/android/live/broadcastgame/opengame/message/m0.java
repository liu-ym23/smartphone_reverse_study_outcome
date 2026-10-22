package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m0 implements com.bytedance.android.live.broadcastgame.v {
    public final long a;
    public final String b;
    public final long c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof m0) == false) goto L18;
        m0 r7 = (m0) r6;
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L8;
        return false;
    L8:
        if (this.c == r7.c) goto L10;
        return false;
    L10:
        if (this.d == r7.d) goto L12;
        return false;
    L12:
        if (this.e == r7.e) goto L14;
        return false;
    L14:
        if (this.f == r7.f) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.c;
        int r4 = ((((((((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        String r5 = this.g;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenReward(appId=" + this.b + ", startId=" + this.c + ", rewardId=" + this.d + ", rewardCount=" + this.e + ", rewardDiamonds=" + this.f + ", rewardName=" + this.g + ")";
    }

    public m0(String r1, long r2, int r4, int r5, int r6, String r7) {
        this.b = r1;
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.a = System.currentTimeMillis();
    }
}
