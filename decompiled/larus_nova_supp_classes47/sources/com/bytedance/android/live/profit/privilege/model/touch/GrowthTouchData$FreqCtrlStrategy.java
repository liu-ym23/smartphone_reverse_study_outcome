package com.bytedance.android.live.profit.privilege.model.touch;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001b\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$FreqCtrlStrategy", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$FreqCtrlStrategy;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "value", "J", "getValue", "()J", "StrategyUnknown", "StrategyDailyLimitByUID", "StrategyRoomLimitByUID", "StrategyTotalLimitByUID", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GrowthTouchData$FreqCtrlStrategy extends Enum<GrowthTouchData$FreqCtrlStrategy> {
    public static final GrowthTouchData$FreqCtrlStrategy StrategyDailyLimitByUID = null;
    public static final GrowthTouchData$FreqCtrlStrategy StrategyRoomLimitByUID = null;
    public static final GrowthTouchData$FreqCtrlStrategy StrategyTotalLimitByUID = null;
    public static final GrowthTouchData$FreqCtrlStrategy StrategyUnknown = null;
    public static final /* synthetic */ GrowthTouchData$FreqCtrlStrategy[] a = null;
    private final long value;

    static {
        GrowthTouchData$FreqCtrlStrategy r1 = new GrowthTouchData$FreqCtrlStrategy("StrategyUnknown", 0, 0);
        StrategyUnknown = r1;
        GrowthTouchData$FreqCtrlStrategy r2 = new GrowthTouchData$FreqCtrlStrategy("StrategyDailyLimitByUID", 1, 1);
        StrategyDailyLimitByUID = r2;
        GrowthTouchData$FreqCtrlStrategy r3 = new GrowthTouchData$FreqCtrlStrategy("StrategyRoomLimitByUID", 2, 2);
        StrategyRoomLimitByUID = r3;
        GrowthTouchData$FreqCtrlStrategy r4 = new GrowthTouchData$FreqCtrlStrategy("StrategyTotalLimitByUID", 3, 3);
        StrategyTotalLimitByUID = r4;
        a = new GrowthTouchData$FreqCtrlStrategy[]{r1, r2, r3, r4};
    }

    public static GrowthTouchData$FreqCtrlStrategy valueOf(String r1) {
        return (GrowthTouchData$FreqCtrlStrategy) r27.a.a(GrowthTouchData$FreqCtrlStrategy.class, r1);
    }

    public static GrowthTouchData$FreqCtrlStrategy[] values() {
        return (GrowthTouchData$FreqCtrlStrategy[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public GrowthTouchData$FreqCtrlStrategy(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
