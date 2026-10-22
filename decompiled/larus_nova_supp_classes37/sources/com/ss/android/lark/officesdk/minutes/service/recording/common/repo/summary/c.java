package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final MmSummaryViewType d;
    public final MmSummaryStatus e;
    public final MmSummaryStatus f;
    public final String g;
    public final MmAISummaryLayoutData h;
    public final b i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final Boolean m;

    public c() {
        this(false, false, false, null, 8191);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (((((((((r4 + r5) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        MmAISummaryLayoutData r7 = this.h;
        int r8 = 0;
        if (r7 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r6 + r9) * 31;
        b r11 = this.i;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        if (this.j == false) goto L25;
        int r14 = 1231;
    L26:
        int r15 = (r13 + r14) * 31;
        if (this.k == false) goto L29;
        int r16 = 1231;
    L30:
        int r17 = (r15 + r16) * 31;
        if (this.l == true) goto L34;
        r1 = 1237;
    L34:
        int r18 = (r17 + r1) * 31;
        Boolean r19 = this.m;
        if (r19 == null) goto L39;
        r8 = r19.hashCode();
    L39:
        return r18 + r8;
    L29:
        r16 = 1237;
        goto L30
    L25:
        r14 = 1237;
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L17:
        r9 = r7.hashCode();
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingSummaryEntity(isAISummaryEnable=" + this.a + ", isFishBoneEnable=" + this.b + ", isViewTypeSwitchEnable=" + this.c + ", viewType=" + this.d + ", textSummaryStatus=" + this.e + ", fishBoneSummaryStatus=" + this.f + ", url=" + this.g + ", fishBoneLayoutData=" + this.h + ", aiSummaryContent=" + this.i + ", isWebReady=" + this.j + ", isWebLoading=" + this.k + ", isWebLoadFailed=" + this.l + ", hasUnviewedSummary=" + this.m + ')';
    }

    public /* synthetic */ c(boolean r17, boolean r18, boolean r19, MmSummaryViewType r20, int r21) {
        if ((r21 & 1) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r21 & 2) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r21 & 4) == 0) goto L13;
        boolean r5 = true;
    L15:
        if ((r21 & 8) == 0) goto L17;
        MmSummaryViewType r6 = MmSummaryViewType.Markdown;
    L19:
        if ((r21 & 16) == 0) goto L21;
        MmSummaryStatus r7 = MmSummaryStatus.None;
    L23:
        if ((r21 & 32) == 0) goto L25;
        MmSummaryStatus r8 = MmSummaryStatus.None;
    L27:
        if ((r21 & 64) == 0) goto L29;
        String r9 = "";
    L30:
        this(r3, r4, r5, r6, r7, r8, r9, null, null, false, false, false, null);
        return;
    L29:
        r9 = null;
        goto L30
    L25:
        r8 = null;
        goto L27
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public static c a(c r18, MmSummaryViewType r19, MmSummaryStatus r20, MmSummaryStatus r21, String r22, MmAISummaryLayoutData r23, b r24, boolean r25, boolean r26, boolean r27, Boolean r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        boolean r5 = r18.a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        boolean r6 = r18.b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        boolean r7 = r18.c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        MmSummaryViewType r8 = r18.d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        MmSummaryStatus r9 = r18.e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        MmSummaryStatus r10 = r18.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r11 = r18.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        MmAISummaryLayoutData r12 = r18.h;
    L35:
        if ((r29 & 256) == 0) goto L37;
        b r13 = r18.i;
    L39:
        if ((r29 & 512) == 0) goto L41;
        boolean r14 = r18.j;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        boolean r15 = r18.k;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        boolean r16 = r18.l;
    L51:
        if ((r29 & 4096) == 0) goto L53;
        Boolean r17 = r18.m;
    L54:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r8, "viewType");
        Intrinsics.checkNotNullParameter(r9, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r10, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r11, "url");
        return new c(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L53:
        r17 = r28;
        goto L54
    L49:
        r16 = r27;
        goto L51
    L45:
        r15 = r26;
        goto L47
    L41:
        r14 = r25;
        goto L43
    L37:
        r13 = r24;
        goto L39
    L33:
        r12 = r23;
        goto L35
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = false;
        goto L15
    L9:
        r6 = false;
        goto L11
    L5:
        r5 = false;
        goto L7
    }

    public c(boolean r2, boolean r3, boolean r4, MmSummaryViewType r5, MmSummaryStatus r6, MmSummaryStatus r7, String r8, MmAISummaryLayoutData r9, b r10, boolean r11, boolean r12, boolean r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "viewType");
        Intrinsics.checkNotNullParameter(r6, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r7, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r8, "url");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
