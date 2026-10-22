package com.larus.dora.obric.device_management.device_home;

import com.larus.dora.impl.resource.DoraResourceDeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r {
    public final DoraObricDeviceHomeDeviceCardType a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final String g;
    public final String h;
    public final DoraResourceDeviceType i;
    public final String j;
    public final String k;
    public final boolean l;
    public final String m;
    public final boolean n;
    public final String o;
    public final boolean p;
    public final String q;
    public final boolean r;

    public r() {
        String r0 = null;
        this(r0, r0, r0, 262143);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.f) * 31;
        String r6 = this.g;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r5 + r8) * 31;
        String r10 = this.h;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        DoraResourceDeviceType r13 = this.i;
        if (r13 == null) goto L22;
        r7 = r13.hashCode();
    L22:
        int r14 = (((((r12 + r7) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        if (this.l == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (((r14 + r15) * 31) + this.m.hashCode()) * 31;
        if (this.n == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (((r16 + r17) * 31) + this.o.hashCode()) * 31;
        if (this.p == false) goto L33;
        int r20 = 1231;
    L34:
        int r21 = (((r18 + r20) * 31) + this.q.hashCode()) * 31;
        if (this.r == true) goto L39;
        r2 = 1237;
    L39:
        return r21 + r2;
    L33:
        r20 = 1237;
        goto L34
    L29:
        r17 = 1237;
        goto L30
    L25:
        r15 = 1237;
        goto L26
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceHomeDeviceCardUiState(type=" + this.a + ", deviceName=" + this.b + ", connectedText=" + this.c + ", isConnected=" + this.d + ", isConnecting=" + this.e + ", imageResId=" + this.f + ", imageResourceName=" + this.g + ", imageFallbackResourceName=" + this.h + ", imageResourceDeviceType=" + this.i + ", modeText=" + this.j + ", glassesBatteryText=" + this.k + ", isGlassesCharging=" + this.l + ", leftBatteryText=" + this.m + ", isLeftCharging=" + this.n + ", rightBatteryText=" + this.o + ", isRightCharging=" + this.p + ", boxBatteryText=" + this.q + ", isBoxCharging=" + this.r + ')';
    }

    public final DoraObricDeviceHomeDeviceCardType getType() {
        return this.a;
    }

    public /* synthetic */ r(String r23, String r24, String r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        DoraObricDeviceHomeDeviceCardType r4 = DoraObricDeviceHomeDeviceCardType.GLASSES;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r26 & 512) == 0) goto L17;
        String r13 = "";
    L19:
        if ((r26 & 1024) == 0) goto L21;
        String r14 = "";
    L23:
        if ((r26 & 4096) == 0) goto L25;
        String r16 = "";
    L27:
        if ((r26 & 16384) == 0) goto L29;
        String r18 = "";
    L31:
        if ((r26 & 65536) == 0) goto L33;
        String r20 = "";
    L34:
        this(r4, r5, r6, false, false, 0, null, null, null, r13, r14, false, r16, false, r18, false, r20, false);
        return;
    L33:
        r20 = null;
        goto L34
    L29:
        r18 = null;
        goto L31
    L25:
        r16 = null;
        goto L27
    L21:
        r14 = r25;
        goto L23
    L17:
        r13 = null;
        goto L19
    L13:
        r6 = r24;
        goto L15
    L9:
        r5 = r23;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    public r(DoraObricDeviceHomeDeviceCardType r11, String r12, String r13, boolean r14, boolean r15, int r16, String r17, String r18, DoraResourceDeviceType r110, String r20, String r21, boolean r22, String r23, boolean r24, String r25, boolean r26, String r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "deviceName");
        Intrinsics.checkNotNullParameter(r13, "connectedText");
        Intrinsics.checkNotNullParameter(r20, "modeText");
        Intrinsics.checkNotNullParameter(r21, "glassesBatteryText");
        Intrinsics.checkNotNullParameter(r23, "leftBatteryText");
        Intrinsics.checkNotNullParameter(r25, "rightBatteryText");
        Intrinsics.checkNotNullParameter(r27, "boxBatteryText");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r110;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
        this.p = r26;
        this.q = r27;
        this.r = r28;
    }
}
