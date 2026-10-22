package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.recharge.panel.aio.PanelMode;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ RechargePanelOrderService.f a;
    public final /* synthetic */ Order b;

    public q(RechargePanelOrderService.f r1, Order r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        RechargePanelOrderService r0 = this.a.a;
        r0.getClass();
        if ((r6 instanceof PayService.PayProgress) == false) goto L30;
        int r7 = l.c[((PayService.PayProgress) r6).ordinal()];
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L8;
        com.bytedance.android.live.recharge.panel.context.d.a(r0.f, true);
        return;
    L8:
        if (r7 != 3) goto L42;
        r0.f.k.c(com.bytedance.android.live.recharge.trace.session.d.j);
        com.bytedance.android.live.recharge.panel.context.d.a(r0.f, true);
        com.bytedance.android.live.recharge.panel.context.d.b(r0.f, false);
        return;
    L42:
        return;
    L13:
        if (((com.bytedance.android.live.recharge.deal.i) r0.f.b.b).isOneStep() == false) goto L18;
        if (r0.f.f.getPanelMode() == PanelMode.NO_PASSWD_MODE.getMode()) goto L18;
        com.bytedance.android.live.recharge.panel.context.d.b(r0.f, true);
        return;
    L18:
        if (com.bytedance.android.live.recharge.deal.j.b((com.bytedance.android.live.recharge.deal.i) r0.f.b.b) == false) goto L20;
    L28:
        com.bytedance.android.live.recharge.panel.context.d.a(r0.f, true);
        com.bytedance.android.live.recharge.panel.context.d.b(r0.f, false);
        return;
    L20:
        if (com.bytedance.android.live.recharge.util.g.a().a() == false) goto L28;
        int r8 = com.bytedance.android.live.recharge.util.g.a().b();
        if (r8 == 1) goto L26;
        if (r8 != 2) goto L27;
        com.bytedance.android.live.recharge.panel.context.d.a(r0.f, false);
    L27:
        com.bytedance.android.live.recharge.panel.context.d.b(r0.f, true);
        return;
    L26:
        com.bytedance.android.live.recharge.panel.context.d.a(r0.f, true);
        goto L27
    L30:
        if ((r6 instanceof IExchangeService.ExchangeProgress) == true) goto L32;
        return;
    L32:
        if (l.b[((IExchangeService.ExchangeProgress) r6).ordinal()] != 1) goto L43;
        com.bytedance.android.live.recharge.panel.context.d.a(r0.f, false);
        com.bytedance.android.live.recharge.panel.context.d.b(r0.f, true);
        return;
    }
}
