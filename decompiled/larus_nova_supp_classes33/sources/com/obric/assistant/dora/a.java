package com.obric.assistant.dora;

import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ DoraBleProtocolService a;
    public final /* synthetic */ i b;

    public /* synthetic */ a(DoraBleProtocolService r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraBleProtocolService r0 = this.a;
        i r1 = this.b;
        int r2 = DoraBleProtocolService.j;
        com.bytedance.router.i r3 = SmartRouter.buildRoute(r0, "//flow/dora/bind_device");
        r3.c.addFlags(335544320);
        r3.c.putExtra("key_dora_onboarding_auto_connect", true);
        String r5 = "";
        if (r1.c == false) goto L9;
        r3.j("vendor_id", "4096");
        r3.j("product_id", "-1");
        String r4 = r1.b.a;
        if (r4 == null) goto L8;
        r5 = r4;
    L8:
        r3.j("extra_mac", r5);
        r3.h("extra_vendor_id", 4096);
        r3.j("extra_sku", Integer.toString(r1.b.h, CharsKt.checkRadix(16)));
    L26:
        r3.d();
        FLogger.a.i("DoraBleProtocolService", "openOnboarding: route opened, requestId=" + r1.a);
        return;
    L9:
        DoraBleDevice r6 = r1.b;
        int r7 = d.a(r6.l, r6.getType());
        r3.j("vendor_id", "1");
        r3.j("product_id", String.valueOf(r7));
        String r8 = r1.b.b;
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        r3.j("key_dora_onboarding_device_name", r8);
        String r9 = r1.b.a;
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        r3.j("key_dora_onboarding_device_mac", r9);
        String r10 = r1.b.g;
        if (r10 == null) goto L19;
        r5 = r10;
    L19:
        r3.j("key_dora_onboarding_device_sn", r5);
        r3.h("key_dora_onboarding_device_sku", r1.b.h);
        int[] r11 = r1.b.d;
        if (r11 != null) goto L22;
        r11 = new int[]{-1, -1, -1};
    L22:
        r3.c.putExtra("key_dora_onboarding_device_battery", r11);
        int[] r12 = r1.b.c;
        if (r12 != null) goto L25;
        r12 = new int[]{-1, -1, -1};
    L25:
        r3.c.putExtra("key_dora_onboarding_device_charge", r12);
        goto L26
    }
}
