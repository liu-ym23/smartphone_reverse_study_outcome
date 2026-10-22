package com.bytedance.android.live.recharge.exchange.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/trace/ExchangeTraceKey;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "KEY_BUSINESS_SCENE", "KEY_EXCHANGE_SCENE", "KEY_IS_AUTO_EXCHANGE", "KEY_EXCHANGE_SWITCH_OPT", "KEY_IS_COMBINE_EXCHANGE", "KEY_DIAMOND_COUNT", "KEY_GIFT_ID", "KEY_IS_LACK_DIAMOND_DIALOG", "KEY_GOLD_COUNT", "KEY_CASH_COUNT", "KEY_GIFT_SOURCE", "KEY_GIFT_SHOW_FROM", "KEY_REQUEST_PAGE", "KEY_CHARGE_REASON", "KEY_CHARGE_SCENE", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceKey extends Enum<ExchangeTraceKey> {
    public static final ExchangeTraceKey KEY_BUSINESS_SCENE = null;
    public static final ExchangeTraceKey KEY_CASH_COUNT = null;
    public static final ExchangeTraceKey KEY_CHARGE_REASON = null;
    public static final ExchangeTraceKey KEY_CHARGE_SCENE = null;
    public static final ExchangeTraceKey KEY_DIAMOND_COUNT = null;
    public static final ExchangeTraceKey KEY_EXCHANGE_SCENE = null;
    public static final ExchangeTraceKey KEY_EXCHANGE_SWITCH_OPT = null;
    public static final ExchangeTraceKey KEY_GIFT_ID = null;
    public static final ExchangeTraceKey KEY_GIFT_SHOW_FROM = null;
    public static final ExchangeTraceKey KEY_GIFT_SOURCE = null;
    public static final ExchangeTraceKey KEY_GOLD_COUNT = null;
    public static final ExchangeTraceKey KEY_IS_AUTO_EXCHANGE = null;
    public static final ExchangeTraceKey KEY_IS_COMBINE_EXCHANGE = null;
    public static final ExchangeTraceKey KEY_IS_LACK_DIAMOND_DIALOG = null;
    public static final ExchangeTraceKey KEY_REQUEST_PAGE = null;
    public static final /* synthetic */ ExchangeTraceKey[] a = null;
    private final String value;

    public static ExchangeTraceKey valueOf(String r1) {
        return (ExchangeTraceKey) r27.a.a(ExchangeTraceKey.class, r1);
    }

    public static ExchangeTraceKey[] values() {
        return (ExchangeTraceKey[]) a.clone();
    }

    static {
        ExchangeTraceKey r1 = new ExchangeTraceKey("KEY_BUSINESS_SCENE", 0, "scene");
        KEY_BUSINESS_SCENE = r1;
        ExchangeTraceKey r2 = new ExchangeTraceKey("KEY_EXCHANGE_SCENE", 1, "exchange_scene");
        KEY_EXCHANGE_SCENE = r2;
        ExchangeTraceKey r3 = new ExchangeTraceKey("KEY_IS_AUTO_EXCHANGE", 2, "is_auto_exchange");
        KEY_IS_AUTO_EXCHANGE = r3;
        ExchangeTraceKey r4 = new ExchangeTraceKey("KEY_EXCHANGE_SWITCH_OPT", 3, "exchange_switch_opt");
        KEY_EXCHANGE_SWITCH_OPT = r4;
        ExchangeTraceKey r5 = new ExchangeTraceKey("KEY_IS_COMBINE_EXCHANGE", 4, "is_combine_exchange");
        KEY_IS_COMBINE_EXCHANGE = r5;
        ExchangeTraceKey r6 = new ExchangeTraceKey("KEY_DIAMOND_COUNT", 5, "diamond_count");
        KEY_DIAMOND_COUNT = r6;
        ExchangeTraceKey r7 = new ExchangeTraceKey("KEY_GIFT_ID", 6, "gift_id");
        KEY_GIFT_ID = r7;
        ExchangeTraceKey r8 = new ExchangeTraceKey("KEY_IS_LACK_DIAMOND_DIALOG", 7, "is_lack_diamond_dialog");
        KEY_IS_LACK_DIAMOND_DIALOG = r8;
        ExchangeTraceKey r9 = new ExchangeTraceKey("KEY_GOLD_COUNT", 8, "gold_count");
        KEY_GOLD_COUNT = r9;
        ExchangeTraceKey r10 = new ExchangeTraceKey("KEY_CASH_COUNT", 9, "cash_count");
        KEY_CASH_COUNT = r10;
        ExchangeTraceKey r12 = new ExchangeTraceKey("KEY_GIFT_SOURCE", 10, "gift_source");
        KEY_GIFT_SOURCE = r12;
        ExchangeTraceKey r13 = new ExchangeTraceKey("KEY_GIFT_SHOW_FROM", 11, "gift_show_from");
        KEY_GIFT_SHOW_FROM = r13;
        ExchangeTraceKey r14 = new ExchangeTraceKey("KEY_REQUEST_PAGE", 12, "request_page");
        KEY_REQUEST_PAGE = r14;
        ExchangeTraceKey r15 = new ExchangeTraceKey("KEY_CHARGE_REASON", 13, "charge_reason");
        KEY_CHARGE_REASON = r15;
        ExchangeTraceKey r16 = new ExchangeTraceKey("KEY_CHARGE_SCENE", 14, "charge_scene");
        KEY_CHARGE_SCENE = r16;
        a = new ExchangeTraceKey[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16};
    }

    public final String getValue() {
        return this.value;
    }

    public ExchangeTraceKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
