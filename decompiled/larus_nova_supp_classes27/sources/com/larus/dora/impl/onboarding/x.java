package com.larus.dora.impl.onboarding;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x {
    public static final boolean a(DoraOnboardingDevice r4) {
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L18;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r4.h != ProductNameType.H_FREE_CLIP_2_HE.id) goto L13;
        r5 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r4.h != ProductNameType.H_FREE_CLIP_2.id) goto L7;
        r2 = true;
        goto L8
    }

    public static final DoraDevice b(DoraOnboardingDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DoraDevice r0 = new DoraDevice();
        r0.name = r2.a;
        r0.mac = r2.b;
        r0.sn = r2.c;
        r0.type = r2.getType();
        r0.sku = r2.e;
        r0.battery = r2.f;
        r0.charge = r2.g;
        r0.productId = r2.h;
        r0.vendorId = r2.i;
        return r0;
    }

    public static final DoraOnboardingDevice c(DoraDevice r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        String r0 = r12.name;
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        String r1 = r12.mac;
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        String r2 = r12.sn;
        if (r2 != null) goto L13;
        String r5 = "";
    L14:
        int r7 = r12.sku;
        return new DoraOnboardingDevice(r3, r4, r5, r12.type, r7, r12.battery, r12.charge, r12.productId, r12.vendorId);
    L13:
        r5 = r2;
        goto L14
    L9:
        r4 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }
}
