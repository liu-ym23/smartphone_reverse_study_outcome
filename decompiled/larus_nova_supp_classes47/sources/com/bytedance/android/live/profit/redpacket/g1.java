package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g1 implements bu0.b {
    public final /* synthetic */ b1 a;

    public g1(b1 r1) {
        this.a = r1;
    }

    @Override // bu0.b
    public final void a() {
        ALogger.i("RedPacketIconMode", "RevenueShortTermStateStrategyListener true");
        this.a.showNormalState();
        ALogger.i("RedPacketIconMode", "onClickedChange showNormalState");
    }
}
