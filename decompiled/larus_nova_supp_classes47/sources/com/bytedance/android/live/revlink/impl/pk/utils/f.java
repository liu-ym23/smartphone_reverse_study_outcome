package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends lq2.b {
    public final void b(Map r1, lq2.c r2) {
    }

    public f() {
    }

    public final boolean a(int r3, Map r4, lq2.c r5) {
        boolean r6 = true;
        if (r3 == 1) goto L8;
        if (r3 == 2) goto L8;
    L27:
        return false;
    L8:
        if (com.bytedance.android.live.revlink.impl.global.b.d() == null) goto L10;
        com.bytedance.android.live.revenuelink.rtc.i r7 = com.bytedance.android.live.revlink.impl.global.b.d().getRtcManager();
    L11:
        if (r7 != null) goto L14;
    L15:
        r6 = false;
    L16:
        if (r6 == false) goto L27;
        if (com.bytedance.android.live.revlink.impl.global.b.d() == null) goto L27;
        if (com.bytedance.android.live.revlink.impl.global.b.d().getRtcManager() == null) goto L27;
        com.bytedance.android.live.revenuelink.rtc.i r8 = com.bytedance.android.live.revlink.impl.global.b.d().getRtcManager();
        IConfig.c.d1.getClass();
        r8.j1(vc0.b.a(IConfig.c.a.a));
        iq2.b r9 = com.bytedance.android.live.revenue.core.util.e.a(er2.b.class).getChorusService();
        if (r9 == null) goto L27;
        if (r9.e() == false) goto L27;
        int r10 = com.bytedance.android.live.revlink.impl.service.h.a;
        r9.b(Long.toString(((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo471getRevenueLinkDataHolder().getChannelId()));
        goto L27
    L14:
        if (r7.F() == true) goto L16;
    L10:
        r7 = null;
        goto L11
    }
}
