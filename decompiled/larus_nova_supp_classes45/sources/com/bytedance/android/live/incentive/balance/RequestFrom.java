package com.bytedance.android.live.incentive.balance;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/RequestFrom;", "", "Unknown", "ExchangePanel", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RequestFrom extends Enum<RequestFrom> {
    public static final RequestFrom ExchangePanel = null;
    public static final RequestFrom Unknown = null;
    public static final /* synthetic */ RequestFrom[] a = null;

    static {
        RequestFrom r1 = new RequestFrom("Unknown", 0);
        Unknown = r1;
        RequestFrom r2 = new RequestFrom("ExchangePanel", 1);
        ExchangePanel = r2;
        a = new RequestFrom[]{r1, r2};
    }

    public static RequestFrom valueOf(String r1) {
        return (RequestFrom) r27.a.a(RequestFrom.class, r1);
    }

    public static RequestFrom[] values() {
        return (RequestFrom[]) a.clone();
    }

    public RequestFrom(String r1, int r2) {
        super(r1, r2);
    }
}
