package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public String a;
    public String b;

    public q() {
        this(0);
    }

    public final String toString() {
        return "XplayPodRTCInfo(wtnToken=" + this.a + ", wtnStreamId=" + this.b + ")";
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public q(int r2) {
        Intrinsics.checkNotNullParameter("", "wtnToken");
        Intrinsics.checkNotNullParameter("", "wtnStreamId");
        this.a = "";
        this.b = "";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(q.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L21;
        q r6 = (q) r5;
        if ((!Intrinsics.areEqual(this.a, r6.a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.b, r6.b)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayPodRTCInfo");
    L8:
        r2 = null;
        goto L10
    }
}
