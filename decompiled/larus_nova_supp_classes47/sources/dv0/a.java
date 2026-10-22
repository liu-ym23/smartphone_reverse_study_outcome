package dv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final com.bytedance.android.live.profit.scoreboard.dto.a a;
    public final int b;
    public final long c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L12;
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.profit.scoreboard.dto.a r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        long r3 = this.c;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "Config(counterConfig=" + this.a + ", linkUserCount=" + this.b + ", otherRoomId=" + this.c + ")";
    }

    public a(com.bytedance.android.live.profit.scoreboard.dto.a r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "counterConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
