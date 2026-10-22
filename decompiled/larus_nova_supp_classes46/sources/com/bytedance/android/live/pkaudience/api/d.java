package com.bytedance.android.live.pkaudience.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public final boolean a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L16;
        d r7 = (d) r6;
        if (this.a == r7.a) goto L8;
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
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        boolean r7 = this.d;
        if (r7 == true) goto L9;
        r1 = r7;
    L9:
        int r8 = (r6 + r1) * 31;
        long r9 = this.e;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    }

    public final String toString() {
        return "PkAudienceLogData(hasAudienceJoin4Pk=" + this.a + ", hasAudienceOnlineTime4Pk=" + this.b + ", hasAudienceOnlineTime=" + this.c + ", hasAudienceJoin4Penalty=" + this.d + ", hasAudienceOnlineTime4Penalty=" + this.e + ")";
    }

    public d(boolean r1, long r2, long r4, boolean r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
