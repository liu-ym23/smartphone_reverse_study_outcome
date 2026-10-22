package com.bytedance.android.live.recharge.exchange.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/trace/ExchangeTraceScene;", "", "", "value", "I", "getValue", "()I", "EXCHANGE_SCENE_UNKNOWN", "EXCHANGE_SCENE_EXCHANGE_DIALOG", "EXCHANGE_SCENE_COMBINE_PAY", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceScene extends Enum<ExchangeTraceScene> {
    public static final ExchangeTraceScene EXCHANGE_SCENE_COMBINE_PAY = null;
    public static final ExchangeTraceScene EXCHANGE_SCENE_EXCHANGE_DIALOG = null;
    public static final ExchangeTraceScene EXCHANGE_SCENE_UNKNOWN = null;
    public static final /* synthetic */ ExchangeTraceScene[] a = null;
    private final int value;

    static {
        ExchangeTraceScene r1 = new ExchangeTraceScene("EXCHANGE_SCENE_UNKNOWN", 0, -1);
        EXCHANGE_SCENE_UNKNOWN = r1;
        ExchangeTraceScene r2 = new ExchangeTraceScene("EXCHANGE_SCENE_EXCHANGE_DIALOG", 1, 1);
        EXCHANGE_SCENE_EXCHANGE_DIALOG = r2;
        ExchangeTraceScene r3 = new ExchangeTraceScene("EXCHANGE_SCENE_COMBINE_PAY", 2, 5);
        EXCHANGE_SCENE_COMBINE_PAY = r3;
        a = new ExchangeTraceScene[]{r1, r2, r3};
    }

    public static ExchangeTraceScene valueOf(String r1) {
        return (ExchangeTraceScene) r27.a.a(ExchangeTraceScene.class, r1);
    }

    public static ExchangeTraceScene[] values() {
        return (ExchangeTraceScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExchangeTraceScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
