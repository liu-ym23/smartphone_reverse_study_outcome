package jw0;

import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.order.Order;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[ExchangeType.values().length];
        a = r0;
        r0[ExchangeType.EXCHANGE_TYPE_FANS.ordinal()] = 1;
        r0[ExchangeType.EXCHANGE_TYPE_RED_PACKET.ordinal()] = 2;
        r0[ExchangeType.EXCHANGE_TYPE_LOTTERY.ordinal()] = 3;
        ExchangeType r1 = ExchangeType.EXCHANGE_TYPE_GIFT;
        r0[r1.ordinal()] = 4;
        ExchangeType r5 = ExchangeType.EXCHANGE_TYPE_FAST_GIFT;
        r0[r5.ordinal()] = 5;
        ExchangeType r6 = ExchangeType.EXCHANGE_TYPE_GIFT_GUIDE;
        r0[r6.ordinal()] = 6;
        r0[ExchangeType.EXCHANGE_TYPE_BARRAGE.ordinal()] = 7;
        int[] r2 = new int[ExchangeType.values().length];
        b = r2;
        r2[r1.ordinal()] = 1;
        r2[r5.ordinal()] = 2;
        r2[r6.ordinal()] = 3;
        int[] r3 = new int[Order.State.values().length];
        c = r3;
        r3[Order.State.Successful.ordinal()] = 1;
        r3[Order.State.Failed.ordinal()] = 2;
    }
}
