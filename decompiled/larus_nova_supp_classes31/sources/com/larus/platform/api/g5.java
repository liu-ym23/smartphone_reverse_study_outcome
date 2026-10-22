package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g5 {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final String e;
    public final long f;

    public g5() {
        this(null, null, null, -1, null, -1);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g5) == true) goto L8;
        return false;
    L8:
        g5 r9 = (g5) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        long r10 = this.d;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        String r12 = this.e;
        if (r12 == null) goto L18;
        r1 = r12.hashCode();
    L18:
        int r13 = (r11 + r1) * 31;
        long r14 = this.f;
        return r13 + ((int) (r14 ^ (r14 >>> 32)));
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SdkDouyinToken(accessToken=" + this.a + ", openId=" + this.b + ", scopes=" + this.c + ", expireTime=" + this.d + ", refreshToken=" + this.e + ", accessTokenExpireAt=" + this.f + ')';
    }

    public g5(String r1, String r2, String r3, long r4, String r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }
}
