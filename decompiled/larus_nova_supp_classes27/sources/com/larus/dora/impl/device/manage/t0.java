package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t0 implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;

    public t0() {
        this(false, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r6 = (t0) r5;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraGDeviceManagementRecordMinutesItem(id=" + this.a + ", title=" + this.b + ", description=" + this.c + ", buttonText=" + this.d + ", isConnected=" + this.e + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public t0(boolean r6, int r7) {
        String r1 = null;
        if ((r7 & 1) == 0) goto L5;
        String r0 = "DoraGDeviceManagementRecordMinutesItem";
    L7:
        if ((r7 & 2) == 0) goto L9;
        int r2 = com.larus.utils.j0.a;
        String r3 = com.larus.utils.j0.d(2131902674);
    L11:
        if ((r7 & 4) == 0) goto L13;
        String r4 = "你也可以通过语音“豆包豆包，开始录音“";
    L15:
        if ((r7 & 8) == 0) goto L18;
        int r5 = com.larus.utils.j0.a;
        r1 = com.larus.utils.j0.d(2131902678);
    L18:
        if ((r7 & 16) == 0) goto L20;
        r6 = false;
    L20:
        Intrinsics.checkNotNullParameter(r0, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r1, "buttonText");
        this.a = r0;
        this.b = r3;
        this.c = r4;
        this.d = r1;
        this.e = r6;
        return;
    L13:
        r4 = null;
        goto L15
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
