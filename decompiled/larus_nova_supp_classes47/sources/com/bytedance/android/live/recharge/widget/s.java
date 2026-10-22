package com.bytedance.android.live.recharge.widget;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.PayService;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ RechargePanelWidgetComposite.l b;

    public s(Order r1, RechargePanelWidgetComposite.l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Order.State r5 = (Order.State) r4;
        if (((Order.State) this.a.getState().b) != Order.State.Transmitting) goto L19;
        FrameLayout r6 = this.b.a.b;
        if (r6 == null) goto L7;
        r6.setVisibility(8);
    L7:
        RechargePanelWidgetComposite r7 = this.b.a;
        Order r0 = this.a;
        r7.getClass();
        Object r1 = r0.getResult();
        if ((r1 instanceof PayService.b) == false) goto L17;
        PayService.b r2 = (PayService.b) r1;
        PayService.b.a r8 = r2.c;
        if (r8 == null) goto L12;
        String r9 = r8.d;
    L14:
        if (r9 == null) goto L16;
        ALogger.d("RechargePanelWidgetComposite", "下单成功下单参数=" + r2.c.d);
        ALogger.d("RechargePanelWidgetComposite", "成功调用组件confirm");
        com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).X0(r2.c.f, new JSONObject(r2.c.d));
        return;
    L16:
        ALogger.d("RechargePanelWidgetComposite", "下单参数{result.extra.cjParams}为null");
        return;
    L12:
        r9 = null;
        goto L14
    L17:
        r7.Bq();
        return;
    }
}
