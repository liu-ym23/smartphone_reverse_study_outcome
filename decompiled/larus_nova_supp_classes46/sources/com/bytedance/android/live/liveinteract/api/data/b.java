package com.bytedance.android.live.liveinteract.api.data;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final boolean a;
    public final k b;
    public final k c;
    public final long d;
    public final float e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L16;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r7.e) == 0) goto L25;
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
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        k r3 = this.b;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        k r7 = this.c;
        if (r7 == null) goto L12;
        r4 = r7.hashCode();
    L12:
        long r8 = this.d;
        return ((((r6 + r4) * 31) + ((int) (r8 ^ (r8 >>> 32)))) * 31) + Float.floatToIntBits(this.e);
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "PaidProfileCardData(mIsAnchor=" + this.a + ", mLabel=" + this.b + ", mAvatar=" + this.c + ", mNumOfLink=" + this.d + ", mScore=" + this.e + ")";
    }

    public b(boolean r1, k r2, k r3, long r4, float r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
