package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.order.Order;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class v {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[Order.State.values().length];
        a = r0;
        r0[Order.State.Successful.ordinal()] = 1;
        r0[Order.State.Failed.ordinal()] = 2;
    }
}
