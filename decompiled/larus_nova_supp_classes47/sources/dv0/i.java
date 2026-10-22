package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements e {
    public final String a;
    public final long b;
    public final k7 c;
    public final String d;
    public final r e;

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        k7 r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        r r12 = this.e;
        if (r12 == null) goto L18;
        r1 = r12.hashCode();
    L18:
        return r10 + r1;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RoundCommonData(miniAppId=" + this.a + ", roundId=" + this.b + ", entranceInfo=" + this.c + ", creatorId=" + this.d + ", extra=" + this.e + ")";
    }

    @Override // dv0.e
    public final k7 getEntranceInfo() {
        return this.c;
    }

    @Override // dv0.e
    public final r getExtra() {
        return this.e;
    }

    @Override // dv0.e
    public final String getMiniAppId() {
        return this.a;
    }

    @Override // dv0.e
    public final long getRoundId() {
        return this.b;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof i) == false) goto L16;
        i r7 = (i) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public i(String r2, long r3, k7 r5, String r6, r r7) {
        Intrinsics.checkNotNullParameter(r2, "miniAppId");
        Intrinsics.checkNotNullParameter(r6, "creatorId");
        Intrinsics.checkNotNullParameter(r7, "extra");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
