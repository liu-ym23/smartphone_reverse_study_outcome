package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ RechargePanelOrderService.f a;
    public final /* synthetic */ Order b;

    public p(RechargePanelOrderService.f r1, Order r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Order.State r5 = (Order.State) r4;
        if (((Order.State) this.b.getState().b) != Order.State.Transmitting) goto L16;
        RechargePanelOrderService r6 = this.a.a;
        Order r0 = this.b;
        r6.getClass();
        Object r1 = r0.getResult();
        if ((r1 instanceof PayService.b) == false) goto L14;
        PayService.b r2 = (PayService.b) r1;
        PayService.b.a r7 = r2.c;
        if (r7 == null) goto L9;
        String r8 = r7.d;
    L11:
        if (r8 == null) goto L13;
        ALogger.d("RechargePanelWidgetComposite", "下单成功下单参数=" + r2.c.d);
        ALogger.d("RechargePanelWidgetComposite", "成功调用组件confirm");
        com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).X0(r2.c.f, new JSONObject(r2.c.d));
        return;
    L13:
        ALogger.d("RechargePanelWidgetComposite", "下单参数{result.extra.cjParams}为null");
        return;
    L9:
        r8 = null;
        goto L11
    L14:
        com.bytedance.android.live.recharge.panel.context.d.b(r6.f, false);
        com.bytedance.android.live.recharge.panel.context.d.a(r6.f, false);
        ToastUtil.a(2131921211, 0);
        return;
    }
}
