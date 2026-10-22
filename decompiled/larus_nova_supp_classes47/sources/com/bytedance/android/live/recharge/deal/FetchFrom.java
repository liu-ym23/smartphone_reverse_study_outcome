package com.bytedance.android.live.recharge.deal;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/FetchFrom;", "", "", "value", "I", "getValue", "()I", "Unknown", "LiveRoom", "RechargePanel", "PreFetch", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FetchFrom extends Enum<FetchFrom> {
    public static final FetchFrom LiveRoom = null;
    public static final FetchFrom PreFetch = null;
    public static final FetchFrom RechargePanel = null;
    public static final FetchFrom Unknown = null;
    public static final /* synthetic */ FetchFrom[] a = null;
    private final int value;

    static {
        FetchFrom r2 = new FetchFrom("Unknown", 0, 0);
        Unknown = r2;
        FetchFrom r3 = new FetchFrom("LiveRoom", 1, 1);
        LiveRoom = r3;
        FetchFrom r4 = new FetchFrom("RechargePanel", 2, 2);
        RechargePanel = r4;
        FetchFrom r5 = new FetchFrom("PreFetch", 3, 4);
        PreFetch = r5;
        a = new FetchFrom[]{r2, r3, r4, r5};
    }

    public static FetchFrom valueOf(String r1) {
        return (FetchFrom) r27.a.a(FetchFrom.class, r1);
    }

    public static FetchFrom[] values() {
        return (FetchFrom[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FetchFrom(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
