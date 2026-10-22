package com.bytedance.android.live.recharge.widget;

import android.widget.FrameLayout;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ RechargePanelWidgetComposite.l b;

    public u(Order r1, RechargePanelWidgetComposite.l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        RechargePanelWidgetComposite r0 = this.b.a;
        int r1 = RechargePanelWidgetComposite.y;
        r0.getClass();
        if ((r7 instanceof PayService.PayProgress) == false) goto L44;
        int r8 = q.d[((PayService.PayProgress) r7).ordinal()];
        if (r8 == 1) goto L21;
        if (r8 != 2) goto L8;
        r0.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        return;
    L8:
        if (r8 != 3) goto L63;
        com.bytedance.android.live.recharge.service.f r9 = r0.t;
        if (r9 == null) goto L13;
        r9.g = System.currentTimeMillis();
    L13:
        com.bytedance.android.live.recharge.trace.session.a r10 = (com.bytedance.android.live.recharge.trace.session.a) r0.w.getSession().getValue();
        if (r10 == null) goto L16;
        r10.c(com.bytedance.android.live.recharge.trace.session.d.j);
    L16:
        r0.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        FrameLayout r12 = r0.b;
        if (r12 == null) goto L52;
        r12.setVisibility(8);
        return;
    L52:
        return;
    L63:
        return;
    L21:
        if (((Boolean) r0.w.getRepository().u.a).booleanValue() == false) goto L28;
        if (r0.v == RechargePanelWidgetComposite.Mode.NO_PASSWORD) goto L28;
        FrameLayout r13 = r0.b;
        if (r13 == null) goto L55;
        r13.setVisibility(0);
        return;
    L55:
        return;
    L28:
        if (((Boolean) r0.w.getRepository().q.a).booleanValue() == false) goto L30;
    L40:
        r0.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        FrameLayout r14 = r0.b;
        if (r14 == null) goto L59;
        r14.setVisibility(8);
        return;
    L59:
        return;
    L30:
        if (com.bytedance.android.live.recharge.util.g.a().a() == false) goto L40;
        int r15 = com.bytedance.android.live.recharge.util.g.a().b();
        if (r15 == 1) goto L36;
        if (r15 != 2) goto L37;
        r0.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
    L37:
        FrameLayout r16 = r0.b;
        if (r16 == null) goto L57;
        r16.setVisibility(0);
        return;
    L57:
        return;
    L36:
        r0.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        goto L37
    L44:
        if ((r7 instanceof IExchangeService.ExchangeProgress) == true) goto L46;
        return;
    L46:
        if (q.c[((IExchangeService.ExchangeProgress) r7).ordinal()] != 1) goto L64;
        r0.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
        FrameLayout r17 = r0.b;
        if (r17 == null) goto L62;
        r17.setVisibility(0);
        return;
    L62:
        return;
    }
}
