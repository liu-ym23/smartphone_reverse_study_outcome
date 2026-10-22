package com.bytedance.android.live.profit.vip;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final String a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L20;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L16;
        int r12 = r10.hashCode();
    L17:
        int r13 = (r9 + r12) * 31;
        String r14 = this.e;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        String r20 = this.g;
        if (r20 == null) goto L29;
        r1 = r20.hashCode();
    L29:
        return r19 + r1;
    L24:
        r18 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VipEmojiTabInfoData(describe=" + this.a + ", btnShow=" + this.b + ", btnText=" + this.c + ", btnSchema=" + this.d + ", emojiIconSelectUrl=" + this.e + ", emojiIconUnselectUrl=" + this.f + ", emojiTabName=" + this.g + ")";
    }

    public m(String r1, boolean r2, String r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
