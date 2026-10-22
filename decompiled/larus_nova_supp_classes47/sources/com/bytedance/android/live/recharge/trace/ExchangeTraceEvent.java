package com.bytedance.android.live.recharge.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/trace/ExchangeTraceEvent;", "", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "DIAMOND_AUTO_EXCHANGE", "INCOME_EXCHANGE_SUCCESS", "DIAMOND_EXCHANGE", "CLIENT_RECHARGE", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExchangeTraceEvent extends Enum<ExchangeTraceEvent> {
    public static final ExchangeTraceEvent CLIENT_RECHARGE = null;
    public static final ExchangeTraceEvent DIAMOND_AUTO_EXCHANGE = null;
    public static final ExchangeTraceEvent DIAMOND_EXCHANGE = null;
    public static final ExchangeTraceEvent INCOME_EXCHANGE_SUCCESS = null;
    public static final /* synthetic */ ExchangeTraceEvent[] a = null;
    private final String eventType;

    static {
        ExchangeTraceEvent r1 = new ExchangeTraceEvent("DIAMOND_AUTO_EXCHANGE", 0, "diamond_automatic_exchange");
        DIAMOND_AUTO_EXCHANGE = r1;
        ExchangeTraceEvent r2 = new ExchangeTraceEvent("INCOME_EXCHANGE_SUCCESS", 1, "income_exchange_success");
        INCOME_EXCHANGE_SUCCESS = r2;
        ExchangeTraceEvent r3 = new ExchangeTraceEvent("DIAMOND_EXCHANGE", 2, "diamond_exchange");
        DIAMOND_EXCHANGE = r3;
        ExchangeTraceEvent r4 = new ExchangeTraceEvent("CLIENT_RECHARGE", 3, "client_recharge");
        CLIENT_RECHARGE = r4;
        a = new ExchangeTraceEvent[]{r1, r2, r3, r4};
    }

    public static ExchangeTraceEvent valueOf(String r1) {
        return (ExchangeTraceEvent) r27.a.a(ExchangeTraceEvent.class, r1);
    }

    public static ExchangeTraceEvent[] values() {
        return (ExchangeTraceEvent[]) a.clone();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public ExchangeTraceEvent(String r1, int r2, String r3) {
        super(r1, r2);
        this.eventType = r3;
    }
}
