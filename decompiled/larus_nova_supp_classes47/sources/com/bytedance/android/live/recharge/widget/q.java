package com.bytedance.android.live.recharge.widget;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class q {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[RechargePanelWidgetComposite.Mode.values().length];
        a = r0;
        r0[RechargePanelWidgetComposite.Mode.NO_PASSWORD.ordinal()] = 1;
        int[] r1 = new int[Order.State.values().length];
        b = r1;
        r1[Order.State.Successful.ordinal()] = 1;
        r1[Order.State.Failed.ordinal()] = 2;
        r1[Order.State.Canceled.ordinal()] = 3;
        int[] r2 = new int[IExchangeService.ExchangeProgress.values().length];
        c = r2;
        r2[IExchangeService.ExchangeProgress.START.ordinal()] = 1;
        int[] r3 = new int[PayService.PayProgress.values().length];
        d = r3;
        r3[PayService.PayProgress.START.ordinal()] = 1;
        r3[PayService.PayProgress.QUERY_ORDER.ordinal()] = 2;
        r3[PayService.PayProgress.SHOW_CASHIER.ordinal()] = 3;
    }
}
