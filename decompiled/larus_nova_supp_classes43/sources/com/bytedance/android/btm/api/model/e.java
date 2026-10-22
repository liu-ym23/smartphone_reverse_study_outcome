package com.bytedance.android.btm.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final int g;
    public final String h;
    public final String i;

    public e() {
        this(null, null, null, null, null, 511);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L24;
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
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
        if (this.f == r11.f) goto L18;
        return false;
    L18:
        if (this.g == r11.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v25 */
    public final int hashCode() {
        String r0 = this.a;
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
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.d;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.e;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        boolean r24 = this.f;
        ?? r25 = r24;
        if (r24 == false) goto L25;
        r25 = 1;
    L25:
        int r26 = (((r23 + r25) * 31) + this.g) * 31;
        String r27 = this.h;
        if (r27 == null) goto L28;
        int r28 = r27.hashCode();
    L29:
        int r29 = (r26 + r28) * 31;
        String r30 = this.i;
        if (r30 == null) goto L33;
        r1 = r30.hashCode();
    L33:
        return r29 + r1;
    L28:
        r28 = 0;
        goto L29
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "BtmPageInfo(btmShowId=" + this.a + ", pageBtm=" + this.b + ", pageId=" + this.c + ", instanceId=" + this.d + ", lastBtmShowId=" + this.e + ", jumpWithToken=" + this.f + ", step=" + this.g + ", nodeId=" + this.h + ", treeId=" + this.i + ")";
    }

    public /* synthetic */ e(String r13, String r14, String r15, String r16, String r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r11 = "";
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r12 = "";
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r19 = "";
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r20 = "";
    L23:
        if ((r18 & 64) == 0) goto L25;
        int r21 = 1;
    L26:
        this(r10, r11, r12, r19, r20, false, r21, null, null);
        return;
    L25:
        r21 = 0;
        goto L26
    L21:
        r20 = r17;
        goto L23
    L17:
        r19 = r16;
        goto L19
    L13:
        r12 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    public e(String r1, String r10, String r11, String r12, String r13, boolean r14, int r15, String r16, String r17) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
    }
}
