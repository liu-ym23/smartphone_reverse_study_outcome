package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x {
    public final long a;
    public final String b;
    public final String c;
    public final boolean d;

    public x() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof x) == false) goto L14;
        x r7 = (x) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L9;
        r3 = r6.hashCode();
    L9:
        int r7 = (r5 + r3) * 31;
        boolean r8 = this.d;
        ?? r9 = r8;
        if (r8 == false) goto L13;
        r9 = 1;
    L13:
        return r7 + r9;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomInfo(roomId=" + this.a + ", anchorId=" + this.b + ", currentUserId=" + this.c + ", isAnchor=" + this.d + ")";
    }

    public /* synthetic */ x(int r7) {
        this(0, "", "", false);
    }

    public x(long r2, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "anchorId");
        Intrinsics.checkNotNullParameter(r5, "currentUserId");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
