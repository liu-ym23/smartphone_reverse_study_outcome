package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketTempStatusStrategy;", "", "", "strategyNum", "I", "getStrategyNum", "()I", "STRATEGY_SINGLE_PLAY", "STRATEGY_PARTICIPATION_SURGE", "STRATEGY_COUNT_DOWN", "STRATEGY_HOST", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RedPacketTempStatusStrategy extends Enum<RedPacketTempStatusStrategy> {
    public static final RedPacketTempStatusStrategy STRATEGY_COUNT_DOWN = null;
    public static final RedPacketTempStatusStrategy STRATEGY_HOST = null;
    public static final RedPacketTempStatusStrategy STRATEGY_PARTICIPATION_SURGE = null;
    public static final RedPacketTempStatusStrategy STRATEGY_SINGLE_PLAY = null;
    public static final /* synthetic */ RedPacketTempStatusStrategy[] a = null;
    private final int strategyNum;

    static {
        RedPacketTempStatusStrategy r2 = new RedPacketTempStatusStrategy("STRATEGY_SINGLE_PLAY", 0, 1);
        STRATEGY_SINGLE_PLAY = r2;
        RedPacketTempStatusStrategy r3 = new RedPacketTempStatusStrategy("STRATEGY_PARTICIPATION_SURGE", 1, 2);
        STRATEGY_PARTICIPATION_SURGE = r3;
        RedPacketTempStatusStrategy r4 = new RedPacketTempStatusStrategy("STRATEGY_COUNT_DOWN", 2, 3);
        STRATEGY_COUNT_DOWN = r4;
        RedPacketTempStatusStrategy r5 = new RedPacketTempStatusStrategy("STRATEGY_HOST", 3, 4);
        STRATEGY_HOST = r5;
        a = new RedPacketTempStatusStrategy[]{r2, r3, r4, r5};
    }

    public static RedPacketTempStatusStrategy valueOf(String r1) {
        return (RedPacketTempStatusStrategy) r27.a.a(RedPacketTempStatusStrategy.class, r1);
    }

    public static RedPacketTempStatusStrategy[] values() {
        return (RedPacketTempStatusStrategy[]) a.clone();
    }

    public final int getStrategyNum() {
        return this.strategyNum;
    }

    public RedPacketTempStatusStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.strategyNum = r3;
    }
}
