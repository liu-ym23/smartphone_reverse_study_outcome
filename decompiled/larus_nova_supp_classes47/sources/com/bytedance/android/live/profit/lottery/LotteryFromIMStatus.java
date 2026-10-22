package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryFromIMStatus;", "", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "LOTTERY_ONGOING", "LOTTERY_FINISHED", "LOTTERY_REJECTED", "LOTTERY_CANCELED", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LotteryFromIMStatus extends Enum<LotteryFromIMStatus> {
    public static final LotteryFromIMStatus LOTTERY_CANCELED = null;
    public static final LotteryFromIMStatus LOTTERY_FINISHED = null;
    public static final LotteryFromIMStatus LOTTERY_ONGOING = null;
    public static final LotteryFromIMStatus LOTTERY_REJECTED = null;
    public static final /* synthetic */ LotteryFromIMStatus[] a = null;
    private final String statusMsg;

    static {
        LotteryFromIMStatus r1 = new LotteryFromIMStatus("LOTTERY_ONGOING", 0, "lottery_ongoing");
        LOTTERY_ONGOING = r1;
        LotteryFromIMStatus r2 = new LotteryFromIMStatus("LOTTERY_FINISHED", 1, "lottery_finished");
        LOTTERY_FINISHED = r2;
        LotteryFromIMStatus r3 = new LotteryFromIMStatus("LOTTERY_REJECTED", 2, "lottery_rejected");
        LOTTERY_REJECTED = r3;
        LotteryFromIMStatus r4 = new LotteryFromIMStatus("LOTTERY_CANCELED", 3, "lottery_canceled");
        LOTTERY_CANCELED = r4;
        a = new LotteryFromIMStatus[]{r1, r2, r3, r4};
    }

    public static LotteryFromIMStatus valueOf(String r1) {
        return (LotteryFromIMStatus) r27.a.a(LotteryFromIMStatus.class, r1);
    }

    public static LotteryFromIMStatus[] values() {
        return (LotteryFromIMStatus[]) a.clone();
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public LotteryFromIMStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.statusMsg = r3;
    }
}
