package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0 implements p0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r6 = (s0) r5;
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
        return "DoraGDeviceManagementMoreFeaturesItem(id=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", iconResourceName=" + this.d + ')';
    }

    public s0() {
        int r0 = com.larus.utils.j0.a;
        String r1 = com.larus.utils.j0.d(2131902658);
        String r2 = com.larus.utils.j0.d(2131902653);
        Intrinsics.checkNotNullParameter("DoraGDeviceManagementMoreFeaturesItem", "id");
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "subtitle");
        Intrinsics.checkNotNullParameter("larus_dora_g_device_management_more_features_icon", "iconResourceName");
        this.a = "DoraGDeviceManagementMoreFeaturesItem";
        this.b = r1;
        this.c = r2;
        this.d = "larus_dora_g_device_management_more_features_icon";
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.a;
    }
}
