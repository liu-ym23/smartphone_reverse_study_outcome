package com.bytedance.android.live.liveinteract.plantform.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q0 implements com.bytedance.android.livesdk.log.filter.v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final q0 b = null;

    public q0() {
    }

    static {
        b = new q0();
        a = new com.bytedance.android.livesdk.log.b("SubscribeLogInjector", null);
    }

    public final void Rd() {
        a.a("added");
    }

    public final void onRemove() {
        a.a("removed");
    }

    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        com.bytedance.android.live.profit.vip.e r4 = yt0.c.l();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.m r5 = r4.getSubscribeInfo();
        if (r5 == null) goto L11;
        com.bytedance.android.live.profit.vip.h r6 = (com.bytedance.android.live.profit.vip.h) r5.getValue();
        if (r6 == null) goto L11;
        if (r6.c != true) goto L11;
        String r7 = "1";
    L12:
        r3.put("is_livevip", r7);
        return;
    L11:
        r7 = "0";
        goto L12
    }
}
