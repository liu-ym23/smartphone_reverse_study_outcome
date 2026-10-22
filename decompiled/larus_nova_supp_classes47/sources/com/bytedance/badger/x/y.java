package com.bytedance.badger.x;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y {
    public final int a;
    public final String b;
    public final z c;
    public final String d;
    public final String e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L26:
        return true;
    L5:
        if ((r5 instanceof y) == false) goto L25;
        y r6 = (y) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L25;
        if (Intrinsics.areEqual(this.b, r6.b) == false) goto L25;
        if (Intrinsics.areEqual(this.c, r6.c) == false) goto L25;
        if (Intrinsics.areEqual(this.d, r6.d) == false) goto L25;
        if (Intrinsics.areEqual(this.e, r6.e) == false) goto L25;
        if (this.f != r6.f) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
    L22:
        r7 = false;
        goto L23
    L9:
        r1 = false;
    L25:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        z r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r12 = this.e;
        if (r12 == null) goto L17;
        r2 = r12.hashCode();
    L17:
        int r13 = (r10 + r2) * 31;
        boolean r14 = this.f;
        ?? r15 = r14;
        if (r14 == false) goto L21;
        r15 = 1;
    L21:
        return r13 + r15;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "DeviceFp1Result(errCode=" + this.a + ", errMsg=" + this.b + ", supportInfo=" + this.c + ", deviceFp1=" + this.d + ", type=" + this.e + ", useCache=" + this.f + ")";
    }

    public y(int r3, String r4, z r5, String r6, String r7, int r8) {
        if ((r8 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r8 & 16) == 0) goto L8;
        r7 = null;
    L8:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = false;
    }
}
