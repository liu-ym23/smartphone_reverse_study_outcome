package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0<T> implements Consumer {
    public final /* synthetic */ PayMethod a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public i0(PayMethod r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r9) {
        OpenPlatformMonitorService r1 = (OpenPlatformMonitorService) this.a.d.o(OpenPlatformMonitorService.class);
        this.a.getClass();
        Intrinsics.checkNotNullParameter("payDiamonds", "method");
        r1.o("payDiamonds", "ttlive_open_platform_pay_order_create", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, null, null).c();
        int r0 = x10.f.a;
        x10.f.c(this.a.d, 3, null, 28);
        PayMethod r2 = this.a;
        Object r11 = ((BaseResponse) r9).data;
        if (r11 == null) goto L7;
        r2.j = ((com.bytedance.android.live.broadcastgame.opengame.network.d) r11).a();
        int r12 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"create order id success, id: " + this.a.j});
        PayMethod r13 = this.a;
        PayMethod.t(r13, r13.j, this.b, this.c);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.network.CreateOrderIdResponse");
    }
}
