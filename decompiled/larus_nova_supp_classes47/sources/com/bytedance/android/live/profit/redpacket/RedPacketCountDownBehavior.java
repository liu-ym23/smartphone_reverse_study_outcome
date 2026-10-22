package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketCountDownBehavior;", "", "", "value", "I", "getValue", "()I", "AnimatorAsSpecialTimer", "NoSpecialTimer", "CountDownTimerAsSpecialTimer", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketCountDownBehavior extends Enum<RedPacketCountDownBehavior> {
    public static final RedPacketCountDownBehavior AnimatorAsSpecialTimer = null;
    public static final RedPacketCountDownBehavior CountDownTimerAsSpecialTimer = null;
    public static final RedPacketCountDownBehavior NoSpecialTimer = null;
    public static final /* synthetic */ RedPacketCountDownBehavior[] a = null;
    private final int value;

    static {
        RedPacketCountDownBehavior r1 = new RedPacketCountDownBehavior("AnimatorAsSpecialTimer", 0, 0);
        AnimatorAsSpecialTimer = r1;
        RedPacketCountDownBehavior r2 = new RedPacketCountDownBehavior("NoSpecialTimer", 1, 1);
        NoSpecialTimer = r2;
        RedPacketCountDownBehavior r3 = new RedPacketCountDownBehavior("CountDownTimerAsSpecialTimer", 2, 2);
        CountDownTimerAsSpecialTimer = r3;
        a = new RedPacketCountDownBehavior[]{r1, r2, r3};
    }

    public static RedPacketCountDownBehavior valueOf(String r1) {
        return (RedPacketCountDownBehavior) r27.a.a(RedPacketCountDownBehavior.class, r1);
    }

    public static RedPacketCountDownBehavior[] values() {
        return (RedPacketCountDownBehavior[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RedPacketCountDownBehavior(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
