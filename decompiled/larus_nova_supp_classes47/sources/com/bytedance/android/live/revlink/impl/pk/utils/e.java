package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static HashMap a() {
        HashMap r0 = new HashMap();
        String r3 = "";
        if (y.d() == false) goto L9;
        d31.d r1 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r1 == null) goto L7;
        String r2 = r1.c();
    L8:
        r0.put("connection_type", r2);
    L18:
        d31.d r4 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r4 == null) goto L22;
        String r5 = r4.a();
        if (r5 == null) goto L22;
    L23:
        r0.put("anchor_connect_status", r5);
        d31.d r6 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r6 == null) goto L26;
        r3 = r6.s();
    L26:
        r0.put("room_status", r3);
        return r0;
    L22:
        r5 = "";
        goto L23
    L7:
        r2 = "";
        goto L8
    L9:
        d31.d r7 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r7 == null) goto L12;
        String r8 = r7.c();
    L13:
        r0.put("connection_type", r8);
        d31.d r9 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r9 == null) goto L16;
        String r10 = r9.b();
    L17:
        r0.put("connection_sub_type", r10);
        goto L18
    L16:
        r10 = "";
        goto L17
    L12:
        r8 = "";
        goto L13
    }

    public static void b() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.onModuleStop("revlink_gift_show");
        r0.monitorPerformance("revlink_gift_hide");
        r0.onModuleStart("revlink_gift_hide", a());
        return;
    }

    public static void c() {
        d51.c r0 = d51.c.A0;
        r0.getClass();
        if (((Boolean) d51.c.A.getValue(r0, d51.c.a[25])).booleanValue() == true) goto L5;
        return;
    L5:
        IPerformanceManager r1 = jc1.k.f(IPerformanceManager.class);
        if (r1 == null) goto L9;
        r1.monitorPerformance("revlink_invite_panel_open");
        r1.onModuleStart("revlink_invite_panel", a());
        return;
    }

    static {
    }
}
