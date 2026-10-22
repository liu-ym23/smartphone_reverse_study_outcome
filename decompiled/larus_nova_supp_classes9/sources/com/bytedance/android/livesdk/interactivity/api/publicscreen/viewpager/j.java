package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public final long a;
    public final long b;
    public final boolean c;
    public final long d;
    public final long e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof j) == false) goto L16;
        j r7 = (j) r6;
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
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r4 = this.c;
        ?? r5 = r4;
        if (r4 == false) goto L5;
        r5 = 1;
    L5:
        long r6 = this.d;
        int r7 = (((r2 + r5) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    }

    public final String toString() {
        return "RedDotTrigger(channelId=" + this.a + ", createType=" + this.b + ", isOwner=" + this.c + ", subCreateType=" + this.d + ", createAppId=" + this.e + ")";
    }

    public j(long r1, long r3, boolean r5, long r6, long r8) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
    }
}
