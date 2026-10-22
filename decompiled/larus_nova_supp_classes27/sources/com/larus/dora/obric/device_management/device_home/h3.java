package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h3 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final DoraObricGlassesMode d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final DoraObricEnvironmentMemory h;
    public final DoraObricEnvironmentMemoryState i;
    public final Boolean j;
    public final boolean k;
    public final DoraObricGlassesBusinessState l;
    public final y1 m;

    public h3() {
        this(false, false, false, null, false, false, false, null, null, null, false, null, null, 8191);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h3) == true) goto L8;
        return false;
    L8:
        h3 r6 = (h3) r5;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
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
        int r6 = (((r4 + r5) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.f == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.g == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (((((r10 + r11) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        Boolean r13 = this.j;
        if (r13 != null) goto L29;
        int r14 = 0;
    L30:
        int r15 = (r12 + r14) * 31;
        if (this.k == true) goto L35;
        r1 = 1237;
    L35:
        return ((((r15 + r1) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
    L29:
        r14 = r13.hashCode();
        goto L30
    L25:
        r11 = 1237;
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
        return "DoraObricGlassesModeUiState(isVisible=" + this.a + ", hideLegacyModeTag=" + this.b + ", isDisconnected=" + this.c + ", confirmedMode=" + this.d + ", isModeControlSupported=" + this.e + ", isModeControlEnabled=" + this.f + ", showEnvironmentMemory=" + this.g + ", environmentMemory=" + this.h + ", environmentMemoryState=" + this.i + ", environmentMemorySwitchEnabled=" + this.j + ", environmentMemoryReady=" + this.k + ", businessState=" + this.l + ", deviceLight=" + this.m + ')';
    }

    public h3(boolean r16, boolean r17, boolean r18, DoraObricGlassesMode r110, boolean r20, boolean r21, boolean r22, DoraObricEnvironmentMemory r23, DoraObricEnvironmentMemoryState r24, Boolean r25, boolean r26, DoraObricGlassesBusinessState r27, y1 r28, int r210) {
        boolean r3 = false;
        if ((r210 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r210 & 8) == 0) goto L17;
        DoraObricGlassesMode r6 = DoraObricGlassesMode.UNKNOWN;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r8 = false;
    L27:
        if ((r210 & 64) != 0) goto L31;
        r3 = r22;
    L31:
        if ((r210 & 128) == 0) goto L33;
        DoraObricEnvironmentMemory r9 = DoraObricEnvironmentMemory.UNKNOWN;
    L35:
        if ((r210 & 256) == 0) goto L37;
        DoraObricEnvironmentMemoryState r10 = DoraObricEnvironmentMemoryState.UNKNOWN;
    L39:
        if ((r210 & 512) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r210 & 1024) == 0) goto L45;
        boolean r12 = true;
    L47:
        if ((r210 & 2048) == 0) goto L49;
        DoraObricGlassesBusinessState r13 = DoraObricGlassesBusinessState.IDLE;
    L51:
        if ((r210 & 4096) == 0) goto L53;
        y1 r1 = y1.a.a;
    L54:
        Intrinsics.checkNotNullParameter(r6, "confirmedMode");
        Intrinsics.checkNotNullParameter(r9, "environmentMemory");
        Intrinsics.checkNotNullParameter(r10, "environmentMemoryState");
        Intrinsics.checkNotNullParameter(r13, "businessState");
        Intrinsics.checkNotNullParameter(r1, "deviceLight");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r3;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r1;
        return;
    L53:
        r1 = r28;
        goto L54
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
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
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r6 = r110;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }
}
