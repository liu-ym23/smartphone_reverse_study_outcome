package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.annotation.ProductNameType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static DoraObricDeviceModeEntryProduct a(Integer r2, Integer r3) {
        int r0 = ProductNameType.DORA_G.id;
        if (r2 != null) goto L6;
    L8:
        int r1 = ProductNameType.DORA_G2.id;
        if (r2 != null) goto L12;
    L14:
        int r4 = ProductNameType.DORA_G_AIR.id;
        if (r2 != null) goto L18;
    L20:
        int r5 = ProductNameType.DORA_G_PIN.id;
        if (r2 != null) goto L24;
    L26:
        DoraObricDeviceModeEntryProduct r6 = DoraObricDeviceModeEntryProduct.UNSUPPORTED;
    L27:
        DoraObricDeviceModeEntryProduct r7 = DoraObricDeviceModeEntryProduct.UNSUPPORTED;
        if (r6 == r7) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == true) goto L34;
        r6 = null;
    L34:
        if (r6 != null) goto L57;
        if (r3 != null) goto L38;
    L40:
        if (r3 != null) goto L43;
    L45:
        if (r3 != null) goto L48;
    L50:
        if (r3 != null) goto L53;
    L56:
        return r7;
    L53:
        if (r3.intValue() != 19) goto L56;
        r7 = DoraObricDeviceModeEntryProduct.G_PIN;
        goto L56
    L48:
        if (r3.intValue() != 18) goto L50;
        r7 = DoraObricDeviceModeEntryProduct.G_AIR;
        goto L56
    L43:
        if (r3.intValue() != 17) goto L45;
        r7 = DoraObricDeviceModeEntryProduct.G2;
        goto L56
    L38:
        if (r3.intValue() != 16) goto L40;
        r7 = DoraObricDeviceModeEntryProduct.G1;
        goto L56
    L57:
        return r6;
    L30:
        r8 = false;
        goto L31
    L24:
        if (r2.intValue() != r5) goto L26;
        r6 = DoraObricDeviceModeEntryProduct.G_PIN;
        goto L27
    L18:
        if (r2.intValue() != r4) goto L20;
        r6 = DoraObricDeviceModeEntryProduct.G_AIR;
        goto L27
    L12:
        if (r2.intValue() != r1) goto L14;
        r6 = DoraObricDeviceModeEntryProduct.G2;
        goto L27
    L6:
        if (r2.intValue() != r0) goto L8;
        r6 = DoraObricDeviceModeEntryProduct.G1;
        goto L27
    }
}
