package com.bytedance.android.livesdk.gift.platform.core.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public static final /* synthetic */ int f = 0;
    public final int a;
    public final int b;
    public final int c;
    public final long d;
    public final boolean e;

    public static final class a {
        public static k a(k r8) {
            if (r8 != null) goto L6;
            return null;
        L6:
            return new k(r8.a, r8.b, r8.c, r8.d, r8.e);
        }
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L16;
        k r7 = (k) r6;
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
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        long r1 = this.d;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        boolean r3 = this.e;
        ?? r4 = r3;
        if (r3 == false) goto L6;
        r4 = 1;
    L6:
        return r2 + r4;
    }

    public final String toString() {
        return "GiftPanelLocationInfo(giftAbsolutePos=" + this.a + ", giftPanelTab=" + this.b + ", pageTotalCount=" + this.c + ", giftId=" + this.d + ", forceInsertByAi=" + this.e + ")";
    }

    public k(int r1, int r2, int r3, long r4, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
