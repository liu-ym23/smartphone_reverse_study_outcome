package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements l {
    public final boolean a;
    public final boolean b;
    public final MmSummaryViewType c;
    public final MmSummaryStatus d;
    public final MmSummaryStatus e;
    public final String f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b l;
    public final h m;
    public final boolean n;

    public e() {
        this(false, false, null, null, false, false, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L50;
        return false;
    L50:
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
        int r4 = (((((((((r2 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.h == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.i == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (((((r8 + r9) * 31) + this.j) * 31) + this.k) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r11 = this.l;
        if (r11 != null) goto L25;
        int r12 = 0;
    L26:
        int r13 = (((r10 + r12) * 31) + this.m.hashCode()) * 31;
        if (this.n == true) goto L31;
        r1 = 1237;
    L31:
        return r13 + r1;
    L25:
        r12 = r11.hashCode();
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
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
        return "MmSummaryVMState(isViewTypeSwitchEnable=" + this.a + ", isFishBoneEnable=" + this.b + ", viewType=" + this.c + ", textSummaryStatus=" + this.d + ", fishBoneSummaryStatus=" + this.e + ", url=" + this.f + ", isWebReady=" + this.g + ", isWebLoading=" + this.h + ", isWebLoadFailed=" + this.i + ", webRetryCount=" + this.j + ", maxWebRetryCount=" + this.k + ", aiSummaryContent=" + this.l + ", quotaCtaState=" + this.m + ", isSubtitleDegraded=" + this.n + ')';
    }

    public /* synthetic */ e(boolean r19, boolean r20, MmSummaryViewType r21, String r22, boolean r23, boolean r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r25 & 2) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r25 & 4) == 0) goto L13;
        MmSummaryViewType r6 = MmSummaryViewType.Markdown;
    L15:
        if ((r25 & 8) == 0) goto L17;
        MmSummaryStatus r7 = MmSummaryStatus.None;
    L19:
        if ((r25 & 16) == 0) goto L21;
        MmSummaryStatus r8 = MmSummaryStatus.None;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r25 & 128) == 0) goto L29;
        boolean r11 = false;
    L31:
        if ((r25 & 256) == 0) goto L33;
        boolean r12 = false;
    L35:
        if ((r25 & 1024) == 0) goto L37;
        int r14 = 3;
    L39:
        if ((r25 & 4096) == 0) goto L41;
        h.a r16 = h.a.a;
    L42:
        this(r4, r5, r6, r7, r8, r9, false, r11, r12, 0, r14, null, r16, false);
        return;
    L41:
        r16 = null;
        goto L42
    L37:
        r14 = 0;
        goto L39
    L33:
        r12 = r24;
        goto L35
    L29:
        r11 = r23;
        goto L31
    L25:
        r9 = r22;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public e(boolean r2, boolean r3, MmSummaryViewType r4, MmSummaryStatus r5, MmSummaryStatus r6, String r7, boolean r8, boolean r9, boolean r10, int r11, int r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r13, h r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r4, "viewType");
        Intrinsics.checkNotNullParameter(r5, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r6, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r14, "quotaCtaState");
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
        this.n = r15;
    }

    public static e a(e r15, boolean r16, boolean r17, MmSummaryViewType r18, MmSummaryStatus r19, MmSummaryStatus r20, String r21, boolean r22, boolean r23, boolean r24, int r25, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r26, h r27, boolean r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        boolean r2 = r15.a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        boolean r3 = r15.b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        MmSummaryViewType r4 = r15.c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        MmSummaryStatus r5 = r15.d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        MmSummaryStatus r6 = r15.e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r7 = r15.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        boolean r8 = r15.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        boolean r9 = r15.h;
    L35:
        if ((r29 & 256) == 0) goto L37;
        boolean r10 = r15.i;
    L39:
        if ((r29 & 512) == 0) goto L41;
        int r11 = r15.j;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        int r12 = r15.k;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r13 = r15.l;
    L51:
        if ((r29 & 4096) == 0) goto L53;
        h r14 = r15.m;
    L55:
        if ((r29 & 8192) == 0) goto L57;
        boolean r1 = r15.n;
    L58:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r4, "viewType");
        Intrinsics.checkNotNullParameter(r5, "textSummaryStatus");
        Intrinsics.checkNotNullParameter(r6, "fishBoneSummaryStatus");
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r14, "quotaCtaState");
        return new e(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r28;
        goto L58
    L53:
        r14 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = 0;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }
}
