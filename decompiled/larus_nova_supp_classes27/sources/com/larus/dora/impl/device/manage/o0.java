package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o0 implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r6 = (o0) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "DoraGDeviceManagementHealthItem(id=" + this.a + ", title=" + this.b + ", betaText=" + this.c + ", description=" + this.d + ", actionText=" + this.e + ", url=" + this.f + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }

    public o0(String r7) {
        int r0 = com.larus.utils.j0.a;
        String r1 = com.larus.utils.j0.d(2131902652);
        String r2 = com.larus.utils.j0.d(2131902651);
        String r3 = com.larus.utils.j0.d(2131901996);
        String r4 = com.larus.utils.j0.d(2131902657);
        Intrinsics.checkNotNullParameter("DoraGDeviceManagementHealthItem", "id");
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "betaText");
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, "actionText");
        Intrinsics.checkNotNullParameter(r7, "url");
        this.a = "DoraGDeviceManagementHealthItem";
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r7;
    }
}
