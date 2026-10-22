package c21;

import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final BattleInviteType a;
    public final long b;
    public final int c;
    public final boolean d;
    public final long e;
    public final v3 f;
    public final long g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l) == false) goto L20;
        l r7 = (l) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        BattleInviteType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31;
        boolean r5 = this.d;
        ?? r6 = r5;
        if (r5 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r4 + r6) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        v3 r10 = this.f;
        if (r10 == null) goto L12;
        r1 = r10.hashCode();
    L12:
        int r12 = (r9 + r1) * 31;
        long r13 = this.g;
        return r12 + ((int) (r13 ^ (r13 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonParams(inviteType=" + this.a + ", duration=" + this.b + ", multiPkMode=" + this.c + ", isOnceMore=" + this.d + ", decideDuration=" + this.e + ", clientAttachedInfo=" + this.f + ", activityType=" + this.g + ")";
    }

    public l(BattleInviteType r3, long r4, int r6, boolean r7, long r8, v3 r10, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r3 = BattleInviteType.UNKNOWN;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r12 & 8) == 0) goto L11;
        r7 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "inviteType");
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r10;
        this.g = 0;
    }
}
