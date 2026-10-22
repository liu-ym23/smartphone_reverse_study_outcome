package com.bytedance.android.live.recharge.exchange.dialog;

import com.bytedance.android.live.recharge.model.ExchangeType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ExchangeType.values().length];
        a = r0;
        ExchangeType r1 = ExchangeType.EXCHANGE_TYPE_FANS;
        r0[r1.ordinal()] = 1;
        ExchangeType r2 = ExchangeType.EXCHANGE_TYPE_LOTTERY_JOIN_FANS;
        r0[r2.ordinal()] = 2;
        ExchangeType r4 = ExchangeType.EXCHANGE_TYPE_RED_PACKET;
        r0[r4.ordinal()] = 3;
        r0[ExchangeType.EXCHANGE_TYPE_LOTTERY.ordinal()] = 4;
        ExchangeType r6 = ExchangeType.EXCHANGE_TYPE_GIFT;
        r0[r6.ordinal()] = 5;
        ExchangeType r9 = ExchangeType.EXCHANGE_TYPE_FAST_GIFT;
        r0[r9.ordinal()] = 6;
        ExchangeType r12 = ExchangeType.EXCHANGE_TYPE_GIFT_GUIDE;
        r0[r12.ordinal()] = 7;
        ExchangeType r13 = ExchangeType.EXCHANGE_TYPE_FANS_SEND_GIFT;
        r0[r13.ordinal()] = 8;
        ExchangeType r15 = ExchangeType.EXCHANGE_TYPE_BARRAGE;
        r0[r15.ordinal()] = 9;
        int[] r3 = new int[ExchangeType.values().length];
        b = r3;
        r3[r9.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r13.ordinal()] = 3;
        r3[r15.ordinal()] = 4;
        r3[r12.ordinal()] = 5;
        r3[r2.ordinal()] = 6;
        r3[r4.ordinal()] = 7;
        r3[r6.ordinal()] = 8;
    }
}
