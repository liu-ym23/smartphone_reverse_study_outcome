package com.bytedance.android.dy.saas.utuid;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final boolean a;
    public final String b;
    public final String c;
    public String d;
    public String e;
    public final String f;
    public final String g;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L20;
        e r11 = (e) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r10 = r1 * 31;
        String r11 = this.b;
        int r12 = 0;
        if (r11 == null) goto L8;
        int r13 = r11.hashCode();
    L9:
        int r14 = (r10 + r13) * 31;
        String r15 = this.c;
        if (r15 == null) goto L12;
        int r16 = r15.hashCode();
    L13:
        int r17 = (r14 + r16) * 31;
        String r18 = this.d;
        if (r18 == null) goto L16;
        int r19 = r18.hashCode();
    L17:
        int r20 = (r17 + r19) * 31;
        String r21 = this.e;
        if (r21 == null) goto L20;
        int r22 = r21.hashCode();
    L21:
        int r23 = (r20 + r22) * 31;
        String r24 = this.f;
        if (r24 == null) goto L24;
        int r25 = r24.hashCode();
    L25:
        int r26 = (r23 + r25) * 31;
        String r27 = this.g;
        if (r27 == null) goto L29;
        r12 = r27.hashCode();
    L29:
        return r26 + r12;
    L24:
        r25 = 0;
        goto L25
    L20:
        r22 = 0;
        goto L21
    L16:
        r19 = 0;
        goto L17
    L12:
        r16 = 0;
        goto L13
    L8:
        r13 = 0;
        goto L9
    }

    public final String toString() {
        return "UtUidConfig(enable=" + this.a + ", webcastAppId=" + this.b + ", generalAppId=" + this.c + ", partner=" + this.d + ", partnerSecret=" + this.e + ", originalPartner=" + this.f + ", originalUUID=" + this.g + ")";
    }

    public e(boolean r1, String r10, String r11, String r12, String r13, String r14, String r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }
}
