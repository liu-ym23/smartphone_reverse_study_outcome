package com.larus.dora.impl.util;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraResourceState;
import com.larus.dora.api.IDoraService;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    static {
    }

    public static boolean a(DoraDevice r7) {
        boolean r0 = true;
        if (r7 == null) goto L42;
        DoraResourceState r2 = null;
        if (o59.a.o(Integer.valueOf(r7.productId)) == false) goto L8;
        Integer r1 = Integer.valueOf(r7.productId);
    L18:
        if (r1 == null) goto L42;
        int r3 = r1.intValue();
        if (r3 != ProductNameType.DORA_G.id) goto L22;
        DoraEnableScope r4 = DoraEnableScope.G1;
    L23:
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L26;
        r2 = r5.S0(r4);
    L26:
        int r6 = s.a;
        boolean r8 = s.c(Integer.valueOf(r3));
        if (r8 == true) goto L41;
        StringBuilder r9 = new StringBuilder("block G connection: productId=");
        r9.append(r3);
        r9.append(", deviceType=");
        r9.append(Integer.valueOf(r7.type));
        r9.append(", resourceScope=");
        r9.append(r4);
        r9.append(", resourceState=");
        r9.append(r2);
        r9.append(", obricOs=");
        r9.append(ObricFeatureServiceDelegate.b.b());
        r9.append(", device=");
        String r10 = r7.mac;
        if (r10 != null) goto L31;
    L34:
        if (r0 == false) goto L37;
        String r11 = "";
    L40:
        r9.append(r11);
        g49.d.d("DoraAutoReconnectGuard", r9.toString());
        goto L41
    L37:
        if (r10.length() > 4) goto L39;
        r11 = "****";
        goto L40
    L39:
        r11 = StringsKt.take(r10, 2) + "***" + StringsKt.takeLast(r10, 2);
        goto L40
    L31:
        if (r10.length() == 0) goto L34;
        r0 = false;
    L41:
        return r8;
    L22:
        r4 = DoraEnableScope.G2;
        goto L23
    L8:
        if (o59.a.n(Integer.valueOf(r7.type)) == true) goto L11;
    L17:
        r1 = null;
        goto L18
    L11:
        switch(r7.type) {
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            default: goto L17;
        };
    L13:
        r1 = Integer.valueOf(ProductNameType.DORA_G_PIN.id);
        goto L18
    L14:
        r1 = Integer.valueOf(ProductNameType.DORA_G_AIR.id);
        goto L18
    L15:
        r1 = Integer.valueOf(ProductNameType.DORA_G2.id);
        goto L18
    L16:
        r1 = Integer.valueOf(ProductNameType.DORA_G.id);
    L42:
        return true;
    }
}
