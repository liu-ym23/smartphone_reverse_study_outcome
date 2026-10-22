package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u0 implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;

    public u0() {
        this(false, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r6 = (u0) r5;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraGDeviceManagementSimultaneousInterpretItem(id=" + this.a + ", title=" + this.b + ", sourceLang=" + this.c + ", targetLang=" + this.d + ", buttonText=" + this.e + ", isConnected=" + this.f + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public u0(boolean r7, int r8) {
        String r1 = null;
        if ((r8 & 1) == 0) goto L5;
        String r0 = "DoraGDeviceManagementSimultaneousInterpretItem";
    L7:
        if ((r8 & 2) == 0) goto L9;
        int r2 = com.larus.utils.j0.a;
        String r3 = com.larus.utils.j0.d(2131903048);
    L11:
        if ((r8 & 4) == 0) goto L13;
        int r4 = com.larus.utils.j0.a;
        String r5 = com.larus.utils.j0.d(2131911330);
    L15:
        if ((r8 & 8) == 0) goto L17;
        int r6 = com.larus.utils.j0.a;
        String r9 = com.larus.utils.j0.d(2131902655);
    L19:
        if ((r8 & 16) == 0) goto L22;
        int r10 = com.larus.utils.j0.a;
        r1 = com.larus.utils.j0.d(2131902679);
    L22:
        if ((r8 & 32) == 0) goto L24;
        r7 = false;
    L24:
        Intrinsics.checkNotNullParameter(r0, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r5, "sourceLang");
        Intrinsics.checkNotNullParameter(r9, "targetLang");
        Intrinsics.checkNotNullParameter(r1, "buttonText");
        this.a = r0;
        this.b = r3;
        this.c = r5;
        this.d = r9;
        this.e = r1;
        this.f = r7;
        return;
    L17:
        r9 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
