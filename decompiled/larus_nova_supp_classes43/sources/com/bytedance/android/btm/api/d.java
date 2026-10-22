package com.bytedance.android.btm.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final Class<?> a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public d() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof d) == false) goto L18;
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r11.d) goto L14;
        return false;
    L14:
        if (this.e == r11.e) goto L16;
        return false;
    L16:
        if (this.f == r11.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        Class<?> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.c;
        if (r15 == null) goto L13;
        r1 = r15.hashCode();
    L13:
        int r16 = (r14 + r1) * 31;
        boolean r17 = this.d;
        ?? r18 = 1;
        ?? r19 = r17;
        if (r17 == false) goto L16;
        r19 = 1;
    L16:
        int r20 = (r16 + r19) * 31;
        boolean r21 = this.e;
        ?? r22 = r21;
        if (r21 == false) goto L19;
        r22 = 1;
    L19:
        int r23 = (r20 + r22) * 31;
        boolean r24 = this.f;
        if (r24 == true) goto L24;
        r18 = r24;
    L24:
        return r23 + r18;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "BtmPageClass(clazz=" + this.a + ", clazzName=" + this.b + ", btm=" + this.c + ", auto=" + this.d + ", singleton=" + this.e + ", reuse=" + this.f + ")";
    }

    public d(Class r1, String r10, String r11, boolean r12, boolean r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = false;
    }
}
