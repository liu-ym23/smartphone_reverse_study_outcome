package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final DeviceMode d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    public final boolean l;

    public c() {
        this(null, null, null, false, false, false, false, false, 0, 0, false, 4095);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.f == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.g == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.h == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.i == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (((((r9 + r10) * 31) + this.j) * 31) + this.k) * 31;
        if (this.l == true) goto L27;
        r2 = 1237;
    L27:
        return r11 + r2;
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraGDeviceManagementDeviceItem(id=" + this.a + ", deviceName=" + this.b + ", deviceMac=" + this.c + ", deviceMode=" + this.d + ", isBound=" + this.e + ", isConnected=" + this.f + ", isCharging=" + this.g + ", isGlassCharging=" + this.h + ", isBoxCharging=" + this.i + ", glassBattery=" + this.j + ", boxBattery=" + this.k + ", isConnecting=" + this.l + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public c(String r4, String r5, DeviceMode r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r0 = "DoraGDeviceManagementDeviceItem";
    L7:
        if ((r15 & 2) == 0) goto L10;
        r4 = "我的眼镜";
    L10:
        if ((r15 & 4) == 0) goto L13;
        r5 = "";
    L13:
        if ((r15 & 8) == 0) goto L16;
        r6 = DeviceMode.NORMAL;
    L16:
        if ((r15 & 16) == 0) goto L19;
        r7 = true;
    L19:
        if ((r15 & 32) == 0) goto L22;
        r8 = true;
    L22:
        if ((r15 & 64) == 0) goto L25;
        r9 = false;
    L25:
        if ((r15 & 128) == 0) goto L28;
        r10 = false;
    L28:
        if ((r15 & 256) == 0) goto L31;
        r11 = false;
    L31:
        if ((r15 & 512) == 0) goto L34;
        r12 = 50;
    L34:
        if ((r15 & 1024) == 0) goto L37;
        r13 = -1;
    L37:
        if ((r15 & 2048) == 0) goto L39;
        r14 = false;
    L39:
        Intrinsics.checkNotNullParameter(r0, "id");
        Intrinsics.checkNotNullParameter(r4, "deviceName");
        Intrinsics.checkNotNullParameter(r5, "deviceMac");
        Intrinsics.checkNotNullParameter(r6, "deviceMode");
        this.a = r0;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        return;
    L5:
        r0 = null;
        goto L7
    }
}
