package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final boolean a;
    public final String b;
    public final boolean c;

    public l() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L12;
        l r4 = (l) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L8;
        int r5 = r4.hashCode();
    L9:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L14;
        r1 = r7;
    L14:
        return r6 + r1;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "FansGroupInfo(isGroupLive=" + this.a + ", selectAnchorId=" + this.b + ", isManualSelect=" + this.c + ")";
    }

    public /* synthetic */ l(int r2) {
        this(false, "", false);
    }

    public l(boolean r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "selectAnchorId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
