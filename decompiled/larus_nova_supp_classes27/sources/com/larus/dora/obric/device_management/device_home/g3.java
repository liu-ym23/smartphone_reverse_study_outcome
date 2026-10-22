package com.larus.dora.obric.device_management.device_home;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g3 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final DoraObricGlassesMode e;
    public final DoraObricEnvironmentMemory f;
    public final Boolean g;
    public final boolean h;
    public final boolean i;
    public final Set<DoraObricGlassesBusinessState> j;
    public final y1 k;

    public g3() {
        this(false, false, false, false, null, null, null, false, false, null, 2047);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g3) == true) goto L8;
        return false;
    L8:
        g3 r6 = (g3) r5;
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
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
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
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (((((r6 + r7) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        Boolean r9 = this.g;
        if (r9 != null) goto L21;
        int r10 = 0;
    L22:
        int r11 = (r8 + r10) * 31;
        if (this.h == false) goto L25;
        int r12 = 1231;
    L26:
        int r13 = (r11 + r12) * 31;
        if (this.i == true) goto L31;
        r1 = 1237;
    L31:
        return ((((r13 + r1) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    L25:
        r12 = 1237;
        goto L26
    L21:
        r10 = r9.hashCode();
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
        return "DoraObricGlassesModeSource(isGlasses=" + this.a + ", isConnected=" + this.b + ", modeSupported=" + this.c + ", switchSupported=" + this.d + ", confirmedMode=" + this.e + ", environmentMemory=" + this.f + ", environmentMemorySwitchEnabled=" + this.g + ", environmentMemoryReady=" + this.h + ", environmentMemoryDeviceAvailable=" + this.i + ", activeScenes=" + this.j + ", deviceLight=" + this.k + ')';
    }

    public g3(boolean r4, boolean r5, boolean r6, boolean r7, DoraObricGlassesMode r8, DoraObricEnvironmentMemory r9, Boolean r10, boolean r11, boolean r12, Set r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r6 = false;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r7 = false;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r8 = DoraObricGlassesMode.UNKNOWN;
    L18:
        if ((r14 & 32) == 0) goto L20;
        r9 = DoraObricEnvironmentMemory.UNKNOWN;
    L20:
        y1.a r1 = null;
        if ((r14 & 64) == 0) goto L24;
        r10 = null;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r11 = true;
    L27:
        if ((r14 & 256) == 0) goto L30;
        r12 = true;
    L30:
        if ((r14 & 512) == 0) goto L33;
        r13 = SetsKt.emptySet();
    L33:
        if ((r14 & 1024) == 0) goto L35;
        r1 = y1.a.a;
    L35:
        Intrinsics.checkNotNullParameter(r8, "confirmedMode");
        Intrinsics.checkNotNullParameter(r9, "environmentMemory");
        Intrinsics.checkNotNullParameter(r13, "activeScenes");
        Intrinsics.checkNotNullParameter(r1, "deviceLight");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r1;
    }
}
