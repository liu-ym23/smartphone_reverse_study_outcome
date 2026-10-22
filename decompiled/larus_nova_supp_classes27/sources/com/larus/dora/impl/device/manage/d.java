package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final DiaryDisplayMode l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    public d() {
        this(null, null, null, null, false, null, null, false, false, false, 32767);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        String r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        int r17 = 1231;
        if (this.i == false) goto L25;
        int r18 = 1231;
    L26:
        int r20 = (r16 + r18) * 31;
        if (this.j == false) goto L29;
        int r21 = 1231;
    L30:
        int r22 = (r20 + r21) * 31;
        String r23 = this.k;
        if (r23 == null) goto L34;
        r2 = r23.hashCode();
    L34:
        int r24 = (((r22 + r2) * 31) + this.l.hashCode()) * 31;
        if (this.m == false) goto L37;
        int r25 = 1231;
    L38:
        int r26 = (r24 + r25) * 31;
        if (this.n == false) goto L41;
        int r27 = 1231;
    L42:
        int r28 = (r26 + r27) * 31;
        if (this.o == true) goto L47;
        r17 = 1237;
    L47:
        return r28 + r17;
    L41:
        r27 = 1237;
        goto L42
    L37:
        r25 = 1237;
        goto L38
    L29:
        r21 = 1237;
        goto L30
    L25:
        r18 = 1237;
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraGDeviceManagementDiaryItem(id=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", content=" + this.d + ", actionText=" + this.e + ", iconUrl=" + this.f + ", imageUrl=" + this.g + ", thumbnail=" + this.h + ", isEmptyState=" + this.i + ", isLoading=" + this.j + ", diaryId=" + this.k + ", displayMode=" + this.l + ", isClickable=" + this.m + ", isSodaBannerVisible=" + this.n + ", isOtaBannerVisible=" + this.o + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public /* synthetic */ d(String r20, String r21, String r22, String r23, boolean r24, String r25, DiaryDisplayMode r26, boolean r27, boolean r28, boolean r210, int r30) {
        if ((r30 & 1) == 0) goto L5;
        String r4 = "DoraGDeviceManagementDiaryItem";
    L7:
        if ((r30 & 2) == 0) goto L9;
        int r1 = com.larus.utils.j0.a;
        String r5 = com.larus.utils.j0.d(2131902643);
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        int r2 = com.larus.utils.j0.a;
        String r8 = com.larus.utils.j0.d(2131902657);
    L23:
        if ((r30 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r30 & 512) == 0) goto L29;
        boolean r13 = false;
    L31:
        if ((r30 & 1024) == 0) goto L33;
        String r14 = null;
    L35:
        if ((r30 & 2048) == 0) goto L37;
        DiaryDisplayMode r15 = DiaryDisplayMode.NORMAL;
    L39:
        if ((r30 & 4096) == 0) goto L41;
        boolean r16 = true;
    L43:
        if ((r30 & 8192) == 0) goto L45;
        boolean r17 = false;
    L47:
        if ((r30 & 16384) == 0) goto L49;
        boolean r18 = false;
    L50:
        this(r4, r5, r6, r7, r8, null, null, r11, false, r13, r14, r15, r16, r17, r18);
        return;
    L49:
        r18 = r210;
        goto L50
    L45:
        r17 = r28;
        goto L47
    L41:
        r16 = r27;
        goto L43
    L37:
        r15 = r26;
        goto L39
    L33:
        r14 = r25;
        goto L35
    L29:
        r13 = r24;
        goto L31
    L25:
        r11 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    public d(String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, boolean r15, boolean r16, String r17, DiaryDisplayMode r18, boolean r110, boolean r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r11, "actionText");
        Intrinsics.checkNotNullParameter(r18, "displayMode");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r110;
        this.n = r20;
        this.o = r21;
    }
}
