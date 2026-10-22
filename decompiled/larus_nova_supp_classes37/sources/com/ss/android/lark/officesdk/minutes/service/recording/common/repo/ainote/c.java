package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final boolean a;
    public final long b;
    public final Long c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;

    public c() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
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
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r3 = this.b;
        int r2 = ((r0 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Long r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.g == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (r12 + r13) * 31;
        if (this.h == false) goto L29;
        int r15 = 1231;
    L30:
        int r16 = (r14 + r15) * 31;
        if (this.i == false) goto L33;
        int r17 = 1231;
    L34:
        int r18 = (r16 + r17) * 31;
        if (this.j == false) goto L37;
        int r19 = 1231;
    L38:
        int r20 = (r18 + r19) * 31;
        if (this.k == false) goto L41;
        int r21 = 1231;
    L42:
        int r22 = (r20 + r21) * 31;
        if (this.l == false) goto L45;
        int r23 = 1231;
    L46:
        int r24 = (r22 + r23) * 31;
        if (this.m == false) goto L49;
        int r25 = 1231;
    L50:
        int r26 = (r24 + r25) * 31;
        if (this.n == false) goto L53;
        int r27 = 1231;
    L54:
        int r28 = (r26 + r27) * 31;
        if (this.o == false) goto L57;
        int r29 = 1231;
    L58:
        int r30 = (r28 + r29) * 31;
        if (this.p == true) goto L63;
        r1 = 1237;
    L63:
        return r30 + r1;
    L57:
        r29 = 1237;
        goto L58
    L53:
        r27 = 1237;
        goto L54
    L49:
        r25 = 1237;
        goto L50
    L45:
        r23 = 1237;
        goto L46
    L41:
        r21 = 1237;
        goto L42
    L37:
        r19 = 1237;
        goto L38
    L33:
        r17 = 1237;
        goto L34
    L29:
        r15 = 1237;
        goto L30
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingAINoteEntity(loaded=" + this.a + ", lastMarkActionElapsedTimeMs=" + this.b + ", photoTargetNoteId=" + this.c + ", bizSessionStarted=" + this.d + ", saveSwitchFeatureEnabled=" + this.e + ", saveSwitchFetched=" + this.f + ", saveSwitchState=" + this.g + ", saveSwitchUpdating=" + this.h + ", hasContent=" + this.i + ", saveSwitchTooltipGuideNeedShow=" + this.j + ", saveSwitchTooltipConsumed=" + this.k + ", saveSwitchTooltipShowing=" + this.l + ", saveSwitchTooltipHasShownInSession=" + this.m + ", saveSwitchPanelExpanded=" + this.n + ", saveSwitchEditorFocused=" + this.o + ", saveSwitchKeyboardVisible=" + this.p + ')';
    }

    public /* synthetic */ c(int r19) {
        this(false, 0, null, false, false, false, true, false, false, false, false, false, false, false, false, false);
    }

    public c(boolean r4, long r5, Long r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        this.a = r4;
        this.b = r5;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
        this.p = r20;
    }

    public static c a(c r17, boolean r18, long r19, Long r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34, int r35) {
        if ((r35 & 1) == 0) goto L5;
        boolean r2 = r17.a;
    L7:
        if ((r35 & 2) == 0) goto L9;
        long r3 = r17.b;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Long r5 = r17.c;
    L15:
        if ((r35 & 8) == 0) goto L17;
        boolean r6 = r17.d;
    L19:
        if ((r35 & 16) == 0) goto L21;
        boolean r7 = r17.e;
    L23:
        if ((r35 & 32) == 0) goto L25;
        boolean r8 = r17.f;
    L27:
        if ((r35 & 64) == 0) goto L29;
        boolean r9 = r17.g;
    L31:
        if ((r35 & 128) == 0) goto L33;
        boolean r10 = r17.h;
    L35:
        if ((r35 & 256) == 0) goto L37;
        boolean r11 = r17.i;
    L39:
        if ((r35 & 512) == 0) goto L41;
        boolean r12 = r17.j;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        boolean r13 = r17.k;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        boolean r14 = r17.l;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        boolean r15 = r17.m;
    L54:
        boolean r36 = r15;
        if ((r35 & 8192) == 0) goto L57;
        boolean r16 = r17.n;
    L58:
        boolean r37 = r16;
        if ((r35 & 16384) == 0) goto L61;
        boolean r110 = r17.o;
    L63:
        if ((r35 & 32768) == 0) goto L65;
        boolean r1 = r17.p;
    L66:
        r17.getClass();
        return new c(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r37, r110, r1);
    L65:
        r1 = r34;
        goto L66
    L61:
        r110 = r33;
        goto L63
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
