package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.recharge.model.NoPasswordFansConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final boolean a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final NoPasswordFansConfig f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L18;
        c r7 = (c) r6;
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
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
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
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        NoPasswordFansConfig r12 = this.f;
        if (r12 == null) goto L12;
        int r13 = r12.hashCode();
    L14:
        return r10 + r13;
    L12:
        r13 = 0;
        goto L14
    }

    public final String toString() {
        return "NoPasswordConfig(enable=" + this.a + ", minDiamond=" + this.b + ", maxDiamond=" + this.c + ", sendNoticeMessageEnable=" + this.d + ", sendNoticeMessageDelay=" + this.e + ", fansClubConfig=" + this.f + ")";
    }

    public c(boolean r2, long r3, long r5, boolean r7, long r8, NoPasswordFansConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "fansClubConfig");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r10;
    }
}
