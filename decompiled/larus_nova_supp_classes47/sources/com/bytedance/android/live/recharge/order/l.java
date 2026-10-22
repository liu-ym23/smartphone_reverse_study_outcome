package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[Order.State.values().length];
        a = r0;
        Order.State r1 = Order.State.Successful;
        r0[r1.ordinal()] = 1;
        Order.State r2 = Order.State.Failed;
        r0[r2.ordinal()] = 2;
        r0[Order.State.Canceled.ordinal()] = 3;
        int[] r3 = new int[IExchangeService.ExchangeProgress.values().length];
        b = r3;
        r3[IExchangeService.ExchangeProgress.START.ordinal()] = 1;
        int[] r4 = new int[PayService.PayProgress.values().length];
        c = r4;
        r4[PayService.PayProgress.START.ordinal()] = 1;
        r4[PayService.PayProgress.QUERY_ORDER.ordinal()] = 2;
        r4[PayService.PayProgress.SHOW_CASHIER.ordinal()] = 3;
        int[] r5 = new int[Order.State.values().length];
        d = r5;
        r5[r1.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
    }
}
