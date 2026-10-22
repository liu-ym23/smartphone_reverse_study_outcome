package com.larus.dora.impl.bridge;

import com.larus.platform.api.IXBridgeEventSender;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Map a;
    public final /* synthetic */ String b;
    public final /* synthetic */ g.a c;
    public final /* synthetic */ String d;

    public /* synthetic */ f(Map r1, String r2, g.a r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map r0 = this.a;
        String r1 = this.b;
        g.a r2 = this.c;
        String r3 = this.d;
        IXBridgeEventSender r4 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
        if (r4 != null) goto L6;
        FLogger.a.w("DoraCurrentDeviceEvent", "send event failed, IXBridgeEventSender is null");
        return;
    L6:
        if ((!r0.isEmpty()) == false) goto L8;
        r4.sendEvent("dora.device.didChange", r0);
    L8:
        if (r1 == null) goto L54;
        r2.getClass();
        LinkedHashMap r5 = new LinkedHashMap();
        String r6 = r2.a;
        if (r6 == null) goto L12;
        r5.put("name", r6);
    L12:
        String r7 = r2.b;
        if (r7 == null) goto L15;
        r5.put("mac", r7);
    L15:
        String r8 = r2.c;
        if (r8 == null) goto L18;
        r5.put("sn", r8);
    L18:
        List r9 = r2.d;
        if (r9 == null) goto L21;
        r5.put("battery", r9);
    L21:
        List r10 = r2.e;
        if (r10 == null) goto L24;
        r5.put("charge", r10);
    L24:
        List r11 = r2.f;
        if (r11 == null) goto L27;
        r5.put("state", r11);
    L27:
        Number r12 = r2.g;
        if (r12 == null) goto L30;
        r5.put("btstate", r12);
    L30:
        Number r13 = r2.h;
        if (r13 == null) goto L33;
        r5.put("sku", r13);
    L33:
        String r14 = r2.i;
        if (r14 == null) goto L36;
        r5.put("version", r14);
    L36:
        Number r15 = r2.j;
        if (r15 == null) goto L39;
        r5.put("productId", r15);
    L39:
        Number r16 = r2.k;
        if (r16 == null) goto L42;
        r5.put("vendorId", r16);
    L42:
        List r17 = r2.l;
        if (r17 == null) goto L45;
        r5.put("supportAbilities", r17);
    L45:
        Map r18 = r2.m;
        if (r18 == null) goto L48;
        r5.put("settings", r18);
    L48:
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("deviceInfo", r5);
        if (r3 == null) goto L51;
        r20.put("reason", r3);
    L51:
        r4.sendEvent(r1, r20);
        return;
    }
}
