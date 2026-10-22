package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements e {
    public final e a;
    public final boolean b;
    public final String c;
    public final String d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L14;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // dv0.e
    public final k7 getEntranceInfo() {
        return this.a.getEntranceInfo();
    }

    @Override // dv0.e
    public final r getExtra() {
        return this.a.getExtra();
    }

    @Override // dv0.e
    public final String getMiniAppId() {
        return this.a.getMiniAppId();
    }

    @Override // dv0.e
    public final long getRoundId() {
        return this.a.getRoundId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        e r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        return r9 + r1;
    L12:
        r8 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "Invitation(common=" + this.a + ", isAuthRequired=" + this.b + ", authDialogTitle=" + this.c + ", authDialogMessage=" + this.d + ")";
    }

    public f(i r2, boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "common");
        Intrinsics.checkNotNullParameter(r4, "authDialogTitle");
        Intrinsics.checkNotNullParameter(r5, "authDialogMessage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
