package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l {
    public final long a;
    public final long b;
    public final boolean c;
    public final MmAINoteSheetState d;
    public final MmAINoteHint e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final MmRecordingUILaunchMode k;

    public s() {
        boolean r2 = false;
        this(r2, null, 2047);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s) == true) goto L8;
        return false;
    L8:
        s r9 = (s) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        int r4 = 1231;
        if (this.c == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (((r2 + r5) * 31) + this.d.hashCode()) * 31;
        MmAINoteHint r7 = this.e;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        if (this.f == false) goto L13;
        int r10 = 1231;
    L14:
        int r11 = (r9 + r10) * 31;
        if (this.g == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (r11 + r12) * 31;
        if (this.h == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        if (this.i == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.j == true) goto L31;
        r4 = 1237;
    L31:
        return ((r17 + r4) * 31) + this.k.hashCode();
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = 1237;
        goto L18
    L13:
        r10 = 1237;
        goto L14
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmAINoteVMState(duration=" + this.a + ", meetingStartTime=" + this.b + ", isWavePlaying=" + this.c + ", sheetState=" + this.d + ", hint=" + this.e + ", isTrialTagVisible=" + this.f + ", saveSwitchVisible=" + this.g + ", saveSwitchChecked=" + this.h + ", saveSwitchEnabled=" + this.i + ", showCloseAction=" + this.j + ", uiLaunchMode=" + this.k + ')';
    }

    public /* synthetic */ s(boolean r17, MmRecordingUILaunchMode r18, int r19) {
        if ((r19 & 4) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r19 & 8) == 0) goto L9;
        MmAINoteSheetState r8 = MmAINoteSheetState.CLOSED;
    L11:
        if ((r19 & 32) == 0) goto L13;
        boolean r10 = false;
    L15:
        if ((r19 & 128) == 0) goto L17;
        boolean r12 = true;
    L19:
        if ((r19 & 512) == 0) goto L21;
        boolean r14 = true;
    L23:
        if ((r19 & 1024) == 0) goto L25;
        MmRecordingUILaunchMode r15 = MmRecordingUILaunchMode.UNKNOWN;
    L26:
        this(0, 0, r5, r8, null, r10, false, r12, false, r14, r15);
        return;
    L25:
        r15 = r18;
        goto L26
    L21:
        r14 = false;
        goto L23
    L17:
        r12 = false;
        goto L19
    L13:
        r10 = r17;
        goto L15
    L9:
        r8 = null;
        goto L11
    L5:
        r5 = false;
        goto L7
    }

    public s(long r2, long r4, boolean r6, MmAINoteSheetState r7, MmAINoteHint r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, MmRecordingUILaunchMode r14) {
        Intrinsics.checkNotNullParameter(r7, "sheetState");
        Intrinsics.checkNotNullParameter(r14, "uiLaunchMode");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
    }

    public static s a(s r18, long r19, long r21, boolean r23, MmAINoteSheetState r24, MmAINoteHint r25, boolean r26, boolean r27, boolean r28, boolean r29, int r30) {
        if ((r30 & 1) == 0) goto L5;
        long r5 = r18.a;
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r7 = r18.b;
    L11:
        if ((r30 & 4) == 0) goto L13;
        boolean r9 = r18.c;
    L15:
        if ((r30 & 8) == 0) goto L17;
        MmAINoteSheetState r10 = r18.d;
    L19:
        if ((r30 & 16) == 0) goto L21;
        MmAINoteHint r11 = r18.e;
    L23:
        if ((r30 & 32) == 0) goto L25;
        boolean r12 = r18.f;
    L27:
        if ((r30 & 64) == 0) goto L29;
        boolean r13 = r18.g;
    L31:
        if ((r30 & 128) == 0) goto L33;
        boolean r14 = r18.h;
    L35:
        if ((r30 & 256) == 0) goto L37;
        boolean r15 = r18.i;
    L39:
        if ((r30 & 512) == 0) goto L41;
        boolean r16 = r18.j;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        MmRecordingUILaunchMode r1 = r18.k;
    L46:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r10, "sheetState");
        Intrinsics.checkNotNullParameter(r1, "uiLaunchMode");
        return new s(r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r1);
    L45:
        r1 = null;
        goto L46
    L41:
        r16 = r29;
        goto L43
    L37:
        r15 = r28;
        goto L39
    L33:
        r14 = r27;
        goto L35
    L29:
        r13 = r26;
        goto L31
    L25:
        r12 = false;
        goto L27
    L21:
        r11 = r25;
        goto L23
    L17:
        r10 = r24;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }
}
