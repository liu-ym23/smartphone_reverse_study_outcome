package com.bytedance.android.live.multilink.impl.control.anchor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final Integer g;
    public final Integer h;
    public final Integer i;

    public f() {
        this(false, false, -1, false, null, false, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L24;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        boolean r7 = this.d;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        int r11 = 0;
        if (r10 == null) goto L14;
        int r12 = r10.hashCode();
    L15:
        int r13 = (r9 + r12) * 31;
        boolean r14 = this.f;
        if (r14 == true) goto L19;
        r1 = r14;
    L19:
        int r15 = (r13 + r1) * 31;
        Integer r16 = this.g;
        if (r16 == null) goto L22;
        int r17 = r16.hashCode();
    L23:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.h;
        if (r19 == null) goto L26;
        int r20 = r19.hashCode();
    L27:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.i;
        if (r22 == null) goto L31;
        r11 = r22.hashCode();
    L31:
        return r21 + r11;
    L26:
        r20 = 0;
        goto L27
    L22:
        r17 = 0;
        goto L23
    L14:
        r12 = 0;
        goto L15
    }

    public final String toString() {
        return "InitParams(isOpenAudioScence=" + this.a + ", isOpenByServer=" + this.b + ", subMode=" + this.c + ", subModeToUILayout=" + this.d + ", requestPage=" + this.e + ", ignoreAnyMode=" + this.f + ", uiLayout=" + this.g + ", toScene=" + this.h + ", initSource=" + this.i + ")";
    }

    public f(boolean r1, boolean r2, int r3, boolean r4, String r5, boolean r6, Integer r7, Integer r8, Integer r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
