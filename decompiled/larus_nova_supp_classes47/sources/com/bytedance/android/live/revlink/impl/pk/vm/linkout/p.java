package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.bytedance.android.livesdk.link.model.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final p0 a;
    public final long b;
    public final boolean c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p) == false) goto L12;
        p r7 = (p) r6;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        p0 r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.b;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        boolean r4 = this.c;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return r3 + r5;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "RandomMatchInfo(battleAttachedInfo=" + this.a + ", matchStrategy=" + this.b + ", isSeasonRank=" + this.c + ")";
    }

    public p(String r2, long r3, boolean r5) {
        this.a = e21.c.c(p0.Companion, r2);
        this.b = r3;
        this.c = r5;
    }
}
