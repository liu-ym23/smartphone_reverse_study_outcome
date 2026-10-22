package com.bytedance.android.live.incentive.balance;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/UpdateReason;", "", "Unknown", "EnterRoom", "OpenGiftPanel", "AfterExchange", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UpdateReason extends Enum<UpdateReason> {
    public static final UpdateReason AfterExchange = null;
    public static final UpdateReason EnterRoom = null;
    public static final UpdateReason OpenGiftPanel = null;
    public static final UpdateReason Unknown = null;
    public static final /* synthetic */ UpdateReason[] a = null;

    static {
        UpdateReason r1 = new UpdateReason("Unknown", 0);
        Unknown = r1;
        UpdateReason r2 = new UpdateReason("EnterRoom", 1);
        EnterRoom = r2;
        UpdateReason r3 = new UpdateReason("OpenGiftPanel", 2);
        OpenGiftPanel = r3;
        UpdateReason r4 = new UpdateReason("AfterExchange", 3);
        AfterExchange = r4;
        a = new UpdateReason[]{r1, r2, r3, r4};
    }

    public static UpdateReason valueOf(String r1) {
        return (UpdateReason) r27.a.a(UpdateReason.class, r1);
    }

    public static UpdateReason[] values() {
        return (UpdateReason[]) a.clone();
    }

    public UpdateReason(String r1, int r2) {
        super(r1, r2);
    }
}
