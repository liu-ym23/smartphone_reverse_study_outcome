package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RushResultStatus;", "", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "RUSH_RESULT_SUCCESSED", "RUSH_RESULT_FAILED", "RUSH_RESULT_EXPIRED", "RUSH_RESULT_LYNX", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RushResultStatus extends Enum<RushResultStatus> {
    public static final RushResultStatus RUSH_RESULT_EXPIRED = null;
    public static final RushResultStatus RUSH_RESULT_FAILED = null;
    public static final RushResultStatus RUSH_RESULT_LYNX = null;
    public static final RushResultStatus RUSH_RESULT_SUCCESSED = null;
    public static final /* synthetic */ RushResultStatus[] a = null;
    private final String statusMsg;

    static {
        RushResultStatus r1 = new RushResultStatus("RUSH_RESULT_SUCCESSED", 0, "successed");
        RUSH_RESULT_SUCCESSED = r1;
        RushResultStatus r2 = new RushResultStatus("RUSH_RESULT_FAILED", 1, "failed");
        RUSH_RESULT_FAILED = r2;
        RushResultStatus r3 = new RushResultStatus("RUSH_RESULT_EXPIRED", 2, "expired");
        RUSH_RESULT_EXPIRED = r3;
        RushResultStatus r4 = new RushResultStatus("RUSH_RESULT_LYNX", 3, "lynx");
        RUSH_RESULT_LYNX = r4;
        a = new RushResultStatus[]{r1, r2, r3, r4};
    }

    public static RushResultStatus valueOf(String r1) {
        return (RushResultStatus) r27.a.a(RushResultStatus.class, r1);
    }

    public static RushResultStatus[] values() {
        return (RushResultStatus[]) a.clone();
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public RushResultStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.statusMsg = r3;
    }
}
