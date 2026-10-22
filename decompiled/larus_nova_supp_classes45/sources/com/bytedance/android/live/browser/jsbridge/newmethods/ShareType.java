package com.bytedance.android.live.browser.jsbridge.newmethods;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShareType;", "", "", "type", "I", "getType", "()I", "Unknown", "Champion", "Prediction", "MatchSituation", "PaidLivePackage", "ReceiveShareTicket", "PaidLiveTicket", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShareType extends Enum<ShareType> {
    public static final ShareType Champion = null;
    public static final ShareType MatchSituation = null;
    public static final ShareType PaidLivePackage = null;
    public static final ShareType PaidLiveTicket = null;
    public static final ShareType Prediction = null;
    public static final ShareType ReceiveShareTicket = null;
    public static final ShareType Unknown = null;
    public static final /* synthetic */ ShareType[] a = null;
    private final int type;

    static {
        ShareType r1 = new ShareType("Unknown", 0, 0);
        Unknown = r1;
        ShareType r2 = new ShareType("Champion", 1, 1);
        Champion = r2;
        ShareType r3 = new ShareType("Prediction", 2, 2);
        Prediction = r3;
        ShareType r4 = new ShareType("MatchSituation", 3, 3);
        MatchSituation = r4;
        ShareType r5 = new ShareType("PaidLivePackage", 4, 6);
        PaidLivePackage = r5;
        ShareType r6 = new ShareType("ReceiveShareTicket", 5, 8);
        ReceiveShareTicket = r6;
        ShareType r7 = new ShareType("PaidLiveTicket", 6, 9);
        PaidLiveTicket = r7;
        a = new ShareType[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static ShareType valueOf(String r1) {
        return (ShareType) r27.a.a(ShareType.class, r1);
    }

    public static ShareType[] values() {
        return (ShareType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ShareType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
