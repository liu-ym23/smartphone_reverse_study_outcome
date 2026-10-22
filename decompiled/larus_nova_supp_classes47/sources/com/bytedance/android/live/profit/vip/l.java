package com.bytedance.android.live.profit.vip;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final long a;
    public final py.k b;
    public final long c;
    public final c d;
    public final boolean e;
    public boolean f;
    public final long g;
    public final int h;
    public final long i;
    public final String j;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l) == false) goto L26;
        l r7 = (l) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v8 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        py.k r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        long r5 = this.c;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        c r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.e;
        ?? r12 = 1;
        ?? r13 = r10;
        if (r10 == false) goto L13;
        r13 = 1;
    L13:
        int r14 = (r9 + r13) * 31;
        boolean r15 = this.f;
        if (r15 == true) goto L17;
        r12 = r15;
    L17:
        int r16 = (r14 + r12) * 31;
        long r17 = this.g;
        int r18 = (((r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31) + this.h) * 31;
        long r19 = this.i;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        String r22 = this.j;
        if (r22 == null) goto L21;
        r3 = r22.hashCode();
    L21:
        return r20 + r3;
    L9:
        r8 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "VipEmojiData(id=" + this.a + ", img=" + this.b + ", emojiScaleType=" + this.c + ", label=" + this.d + ", isLock=" + this.e + ", isNew=" + this.f + ", type=" + this.g + ", status=" + this.h + ", canDelTime=" + this.i + ", rejectReason=" + this.j + ")";
    }

    public final long getType() {
        return this.g;
    }

    public l(long r1, py.k r3, long r4, c r6, boolean r7, long r8, int r10, long r12, String r13) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = false;
        this.g = r8;
        this.h = r10;
        this.i = r12;
        this.j = r13;
    }
}
