package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryTempStatusStrategy;", "", "", "strategyNum", "I", "getStrategyNum", "()I", "STRATEGY_SINGLE_PLAY", "STRATEGY_PARTICIPATION_SURGE", "STRATEGY_COUNT_DOWN", "STRATEGY_HOST", "STRATEGY_ENTER", "STRATEGY_INTEREST", "STRATEGY_BEHAVIOR", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LotteryTempStatusStrategy extends Enum<LotteryTempStatusStrategy> {
    public static final LotteryTempStatusStrategy STRATEGY_BEHAVIOR = null;
    public static final LotteryTempStatusStrategy STRATEGY_COUNT_DOWN = null;
    public static final LotteryTempStatusStrategy STRATEGY_ENTER = null;
    public static final LotteryTempStatusStrategy STRATEGY_HOST = null;
    public static final LotteryTempStatusStrategy STRATEGY_INTEREST = null;
    public static final LotteryTempStatusStrategy STRATEGY_PARTICIPATION_SURGE = null;
    public static final LotteryTempStatusStrategy STRATEGY_SINGLE_PLAY = null;
    public static final /* synthetic */ LotteryTempStatusStrategy[] a = null;
    private final int strategyNum;

    static {
        LotteryTempStatusStrategy r2 = new LotteryTempStatusStrategy("STRATEGY_SINGLE_PLAY", 0, 1);
        STRATEGY_SINGLE_PLAY = r2;
        LotteryTempStatusStrategy r3 = new LotteryTempStatusStrategy("STRATEGY_PARTICIPATION_SURGE", 1, 2);
        STRATEGY_PARTICIPATION_SURGE = r3;
        LotteryTempStatusStrategy r4 = new LotteryTempStatusStrategy("STRATEGY_COUNT_DOWN", 2, 3);
        STRATEGY_COUNT_DOWN = r4;
        LotteryTempStatusStrategy r5 = new LotteryTempStatusStrategy("STRATEGY_HOST", 3, 4);
        STRATEGY_HOST = r5;
        LotteryTempStatusStrategy r6 = new LotteryTempStatusStrategy("STRATEGY_ENTER", 4, 5);
        STRATEGY_ENTER = r6;
        LotteryTempStatusStrategy r7 = new LotteryTempStatusStrategy("STRATEGY_INTEREST", 5, 6);
        STRATEGY_INTEREST = r7;
        LotteryTempStatusStrategy r8 = new LotteryTempStatusStrategy("STRATEGY_BEHAVIOR", 6, 7);
        STRATEGY_BEHAVIOR = r8;
        a = new LotteryTempStatusStrategy[]{r2, r3, r4, r5, r6, r7, r8};
    }

    public static LotteryTempStatusStrategy valueOf(String r1) {
        return (LotteryTempStatusStrategy) r27.a.a(LotteryTempStatusStrategy.class, r1);
    }

    public static LotteryTempStatusStrategy[] values() {
        return (LotteryTempStatusStrategy[]) a.clone();
    }

    public final int getStrategyNum() {
        return this.strategyNum;
    }

    public LotteryTempStatusStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.strategyNum = r3;
    }
}
