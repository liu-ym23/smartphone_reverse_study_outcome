package com.obric.assistant.dora;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final DoraBleDevice b(DoraDevice r15) {
        return new DoraBleDevice(r15.mac, r15.name, r15.charge, r15.battery, r15.version, r15.type, r15.sn, r15.sku, r15.mode, r15.vendorId, r15.vendorCapabilities, r15.productId, r15.model);
    }

    public static final int a(int r0, int r1) {
        switch(r1) {
            case 16: goto L21;
            case 17: goto L20;
            case 18: goto L19;
            case 19: goto L18;
            default: goto L3;
        };
    L3:
        Integer r2 = Integer.valueOf(r0);
        if (r2.intValue() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L17;
        return r2.intValue();
    L17:
        return ProductNameType.DORA_LITE.id;
    L10:
        r3 = false;
        goto L11
    L18:
        return ProductNameType.DORA_G_PIN.id;
    L19:
        return ProductNameType.DORA_G_AIR.id;
    L20:
        return ProductNameType.DORA_G2.id;
    L21:
        return ProductNameType.DORA_G.id;
    }
}
