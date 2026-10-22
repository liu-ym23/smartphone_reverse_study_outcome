package com.bytedance.android.live.revlink.link.biz.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L14;
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.c;
        ?? r7 = r6;
        if (r6 == false) goto L12;
        r7 = 1;
    L12:
        int r8 = (r5 + r7) * 31;
        long r9 = this.d;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleInviteBizData(titleStr=" + this.a + ", inviteMode=" + this.b + ", isOnceMore=" + this.c + ", duration=" + this.d + ")";
    }

    public a(String r2, String r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "titleStr");
        Intrinsics.checkNotNullParameter(r3, "inviteMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
