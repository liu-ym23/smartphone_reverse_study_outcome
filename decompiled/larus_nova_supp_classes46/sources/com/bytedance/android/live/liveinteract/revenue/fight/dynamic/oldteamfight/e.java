package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public com.bytedance.android.live.liveinteract.multiscene.a a;
    public int b;
    public final int c;
    public int d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.liveinteract.multiscene.a r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "LastTeamFightDynamicInfo(teamFightInfo=" + this.a + ", enterFrom=" + this.b + ", preStatus=" + this.c + ", status=" + this.d + ")";
    }

    public e(com.bytedance.android.live.liveinteract.multiscene.a r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "teamFightInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
