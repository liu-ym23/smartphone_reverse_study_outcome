package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;

    public e() {
        this(null, null, null, null, null, false, false, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
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
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        String r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.h;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        int r15 = (r13 + r2) * 31;
        int r16 = 1231;
        if (this.i == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.j == true) goto L31;
        r16 = 1237;
    L31:
        return r18 + r16;
    L25:
        r17 = 1237;
        goto L26
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraGDeviceManagementDocItem(id=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", content=" + this.d + ", actionText=" + this.e + ", imageUrl=" + this.f + ", url=" + this.g + ", thumbnail=" + this.h + ", isEmptyState=" + this.i + ", isLoading=" + this.j + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public e(String r6, String r7, String r8, String r9, String r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        String r0 = "DoraGDeviceManagementDocItem";
    L7:
        if ((r13 & 2) == 0) goto L9;
        int r2 = com.larus.utils.j0.a;
        String r3 = com.larus.utils.j0.d(2131903042);
    L11:
        if ((r13 & 4) == 0) goto L14;
        r6 = null;
    L14:
        if ((r13 & 8) == 0) goto L17;
        r7 = null;
    L17:
        if ((r13 & 16) == 0) goto L20;
        int r14 = com.larus.utils.j0.a;
        r8 = com.larus.utils.j0.d(2131902657);
    L20:
        if ((r13 & 64) == 0) goto L23;
        r9 = null;
    L23:
        if ((r13 & 128) == 0) goto L26;
        r10 = null;
    L26:
        if ((r13 & 256) == 0) goto L29;
        r11 = false;
    L29:
        if ((r13 & 512) == 0) goto L31;
        r12 = false;
    L31:
        Intrinsics.checkNotNullParameter(r0, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r8, "actionText");
        this.a = r0;
        this.b = r3;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = null;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        return;
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
