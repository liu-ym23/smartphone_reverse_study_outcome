package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public g() {
        this(null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DoraGDeviceManagementFirmwareUpdateItem(id=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", buttonText=" + this.d + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public g(String r5, int r6) {
        String r1 = null;
        if ((r6 & 1) == 0) goto L5;
        String r0 = "DoraGDeviceManagementFirmwareUpdateItem";
    L7:
        if ((r6 & 2) == 0) goto L9;
        int r2 = com.larus.utils.j0.a;
        String r3 = com.larus.utils.j0.d(2131902738);
    L11:
        if ((r6 & 4) == 0) goto L14;
        r5 = "";
    L14:
        if ((r6 & 8) == 0) goto L16;
        int r7 = com.larus.utils.j0.a;
        r1 = com.larus.utils.j0.d(2131902984);
    L16:
        Intrinsics.checkNotNullParameter(r0, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r5, "subtitle");
        Intrinsics.checkNotNullParameter(r1, "buttonText");
        this.a = r0;
        this.b = r3;
        this.c = r5;
        this.d = r1;
        return;
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
