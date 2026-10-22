package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b1 implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    public final boolean f;

    public b1() {
        boolean r0 = false;
        this(r0, r0, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r6 = (b1) r5;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.f == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SodaBannerItem(id=" + this.a + ", title=" + this.b + ", subTitle=" + this.c + ", bannerType=" + this.d + ", isVisible=" + this.e + ", hasFirmwareUpdateItemAbove=" + this.f + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public /* synthetic */ b1(boolean r10, boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        String r3 = "SodaBannerItem";
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r12 & 8) == 0) goto L17;
        int r6 = 1;
    L19:
        if ((r12 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r12 & 32) == 0) goto L25;
        boolean r8 = false;
    L26:
        this(r3, r4, r5, r6, r7, r8);
        return;
    L25:
        r8 = r11;
        goto L26
    L21:
        r7 = r10;
        goto L23
    L17:
        r6 = 0;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public b1(String r2, String r3, String r4, int r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "subTitle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
