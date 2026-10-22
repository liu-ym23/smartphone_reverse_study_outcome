package com.larus.dora.impl.core;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x0 {
    public static final String b(boolean r0) {
        if (r0 == false) goto L4;
        return "on";
    L4:
        return "off";
    }

    public static final Map<String, String> a(boolean r5) {
        String r6 = b(r5);
        Pair[] r0 = new Pair[3];
        boolean r2 = false;
        r0[0] = TuplesKt.to("dora_g_natural_wakeup_switch", r6);
        r0[1] = TuplesKt.to("dora_natural_wakeup_switch", r6);
        DoraDevice r7 = kj4.a.g().c();
        if (r7 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        String r8 = "dora_h";
    L17:
        r0[2] = TuplesKt.to("dora_product_type", r8);
        return MapsKt.mapOf(r0);
    L10:
        if (r7 != null) goto L12;
    L14:
        if (r2 == false) goto L16;
        r8 = "dora_g";
        goto L17
    L16:
        r8 = "dora_d";
        goto L17
    L12:
        if (r7.productId != ProductNameType.DORA_G.id) goto L14;
        r2 = true;
        goto L14
    L5:
        if (r7.vendorId != 4096) goto L7;
        r3 = true;
        goto L8
    }
}
