package com.larus.commercemembership.impl;

import kotlin.jvm.internal.Intrinsics;
import tc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final e a;
    public final String b;
    public final long c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        long r4 = this.c;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendingPcGuidePushBanner(banner=" + this.a + ", source=" + this.b + ", expireAtElapsedRealtimeMs=" + this.c + ')';
    }

    public k(e r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "banner");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
