package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public final long a;
    public final int b;
    public final String c;
    public final boolean d;
    public final String e;
    public final int f;
    public final long g;
    public boolean h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L22;
        h r7 = (h) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        boolean r6 = this.d;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L9;
        r8 = 1;
    L9:
        int r9 = (r5 + r8) * 31;
        String r11 = this.e;
        if (r11 == null) goto L12;
        r3 = r11.hashCode();
    L12:
        int r12 = (((r9 + r3) * 31) + this.f) * 31;
        long r13 = this.g;
        int r14 = (r12 + ((int) ((r13 >>> 32) ^ r13))) * 31;
        boolean r15 = this.h;
        if (r15 == true) goto L17;
        r7 = r15;
    L17:
        return r14 + r7;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "LeaveParams(channelId=" + this.a + ", scene=" + this.b + ", reqSrc=" + this.c + ", clearAfterSuccess=" + this.d + ", isManager=" + this.e + ", leaveSource=" + this.f + ", startTs=" + this.g + ", requestFailed=" + this.h + ")";
    }

    public h(long r5, int r7, String r8, boolean r9, String r11, int r12, int r13) {
        if ((r13 & 8) == 0) goto L6;
        r9 = false;
    L6:
        if ((r13 & 16) == 0) goto L9;
        r11 = "0";
    L9:
        if ((r13 & 32) == 0) goto L12;
        r12 = com.bytedance.android.live.revenuelink.connect.h.a(r8);
    L12:
        if ((r13 & 64) == 0) goto L14;
        i97.a r14 = i97.a.a;
        long r2 = System.currentTimeMillis();
    L15:
        Intrinsics.checkNotNullParameter(r8, "reqSrc");
        Intrinsics.checkNotNullParameter(r11, "isManager");
        this.a = r5;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r11;
        this.f = r12;
        this.g = r2;
        this.h = false;
        return;
    L14:
        r2 = 0;
        goto L15
    }
}
