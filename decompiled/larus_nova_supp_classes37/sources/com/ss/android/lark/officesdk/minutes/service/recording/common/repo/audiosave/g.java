package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final MmRecordingAutoSaveDecisionScene a;
    public final boolean b;
    public final int c;
    public final String d;
    public final d e;
    public final boolean f;

    public g() {
        this(null, false, 0, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        MmRecordingAutoSaveDecisionScene r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        String r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        d r10 = this.e;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        int r11 = (r9 + r1) * 31;
        if (this.f == true) goto L23;
        r4 = 1237;
    L23:
        return r11 + r4;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAutoSaveDecision(scene=" + this.a + ", isForceSaveAudio=" + this.b + ", saveAudioFinalDecision=" + this.c + ", forceSaveReason=" + this.d + ", unavailableReason=" + this.e + ", hasShownRecordingStartDialog=" + this.f + ')';
    }

    public /* synthetic */ g(MmRecordingAutoSaveDecisionScene r10, boolean r11, int r12, String r13, d r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        MmRecordingAutoSaveDecisionScene r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r15 & 4) == 0) goto L13;
        r12 = MmAudioSaveType.SAVE.getValue();
    L13:
        int r5 = r12;
        if ((r15 & 8) == 0) goto L16;
        String r6 = null;
    L18:
        if ((r15 & 16) == 0) goto L20;
        d r7 = null;
    L21:
        this(r3, r4, r5, r6, r7, false);
        return;
    L20:
        r7 = r14;
        goto L21
    L16:
        r6 = r13;
        goto L18
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public g(MmRecordingAutoSaveDecisionScene r1, boolean r2, int r3, String r4, d r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
