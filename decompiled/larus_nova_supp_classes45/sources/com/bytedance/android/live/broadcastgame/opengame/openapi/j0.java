package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.utils.o1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ PayMethod a;

    public j0(PayMethod r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        Throwable r11 = (Throwable) r9;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"create order id fail, error: ", r11});
        OpenPlatformMonitorService r1 = (OpenPlatformMonitorService) this.a.d.o(OpenPlatformMonitorService.class);
        this.a.getClass();
        Integer r6 = Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r11));
        String r7 = o1.a(r11);
        Intrinsics.checkNotNullParameter("payDiamonds", "method");
        r1.o("payDiamonds", "ttlive_open_platform_pay_order_create", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, r6, r7).c();
        int r2 = x10.f.a;
        x10.f.b(this.a.d, 3, OpenApiErrorInfo.INTERNAL_ERROR, r11, com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r11));
        PayMethod.u(this.a, r11);
    }
}
