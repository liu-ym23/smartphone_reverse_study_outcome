package com.bytedance.android.live.recharge.exchange.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/model/AutoExchangeStatus;", "", "", "value", "I", "getValue", "()I", "UnKnown", "UnSync", "Closed", "Open", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AutoExchangeStatus extends Enum<AutoExchangeStatus> {
    public static final AutoExchangeStatus Closed = null;
    public static final AutoExchangeStatus Open = null;
    public static final AutoExchangeStatus UnKnown = null;
    public static final AutoExchangeStatus UnSync = null;
    public static final /* synthetic */ AutoExchangeStatus[] a = null;
    private final int value;

    static {
        AutoExchangeStatus r1 = new AutoExchangeStatus("UnKnown", 0, -1);
        UnKnown = r1;
        AutoExchangeStatus r2 = new AutoExchangeStatus("UnSync", 1, 0);
        UnSync = r2;
        AutoExchangeStatus r3 = new AutoExchangeStatus("Closed", 2, 1);
        Closed = r3;
        AutoExchangeStatus r4 = new AutoExchangeStatus("Open", 3, 2);
        Open = r4;
        a = new AutoExchangeStatus[]{r1, r2, r3, r4};
    }

    public static AutoExchangeStatus valueOf(String r1) {
        return (AutoExchangeStatus) r27.a.a(AutoExchangeStatus.class, r1);
    }

    public static AutoExchangeStatus[] values() {
        return (AutoExchangeStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AutoExchangeStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
