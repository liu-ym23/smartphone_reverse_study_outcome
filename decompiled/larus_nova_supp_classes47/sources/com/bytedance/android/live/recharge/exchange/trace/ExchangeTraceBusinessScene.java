package com.bytedance.android.live.recharge.exchange.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/trace/ExchangeTraceBusinessScene;", "", "", "value", "I", "getValue", "()I", "EXCHANGE_BUSINESS_SCENE_UNKNOWN", "EXCHANGE_BUSINESS_SCENE_DIAMOND", "EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceBusinessScene extends Enum<ExchangeTraceBusinessScene> {
    public static final ExchangeTraceBusinessScene EXCHANGE_BUSINESS_SCENE_DIAMOND = null;
    public static final ExchangeTraceBusinessScene EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON = null;
    public static final ExchangeTraceBusinessScene EXCHANGE_BUSINESS_SCENE_UNKNOWN = null;
    public static final /* synthetic */ ExchangeTraceBusinessScene[] a = null;
    private final int value;

    static {
        ExchangeTraceBusinessScene r1 = new ExchangeTraceBusinessScene("EXCHANGE_BUSINESS_SCENE_UNKNOWN", 0, -1);
        EXCHANGE_BUSINESS_SCENE_UNKNOWN = r1;
        ExchangeTraceBusinessScene r2 = new ExchangeTraceBusinessScene("EXCHANGE_BUSINESS_SCENE_DIAMOND", 1, 1);
        EXCHANGE_BUSINESS_SCENE_DIAMOND = r2;
        ExchangeTraceBusinessScene r3 = new ExchangeTraceBusinessScene("EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON", 2, 6);
        EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON = r3;
        a = new ExchangeTraceBusinessScene[]{r1, r2, r3};
    }

    public static ExchangeTraceBusinessScene valueOf(String r1) {
        return (ExchangeTraceBusinessScene) r27.a.a(ExchangeTraceBusinessScene.class, r1);
    }

    public static ExchangeTraceBusinessScene[] values() {
        return (ExchangeTraceBusinessScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExchangeTraceBusinessScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
