package com.bytedance.android.live.profit.lottery;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 implements com.bytedance.android.scope.o, i {
    public final l2 a;
    public final LotteryContext b;
    public final LotteryPluginStore c;
    public final com.bytedance.android.live.revenue.core.a d;

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.m<? extends ParticipateStatus> getCurCandidateState() {
        return this.b.getCurCandidateState();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.n<? extends g> getCurrentLottery() {
        return this.b.getCurrentLottery();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<LotteryState.b> getOnFinish() {
        return this.b.getOnFinish();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<Unit> getOnHidePanel() {
        return this.b.getOnHidePanel();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<Integer> getOnIconClick() {
        return this.b.getOnIconClick();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<JSONObject> getOnPopupSchemaFailed() {
        return this.b.getOnPopupSchemaFailed();
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final com.bytedance.live.datacontext.k<Unit> getOnToolbarButtonClick() {
        return this.b.getOnToolbarButtonClick();
    }

    public final void onStop() {
    }

    public final void onStart() {
        this.d.b(i.class, this.a);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public final o getLotteryPluginStore() {
        return this.c;
    }

    public n0(l2 r2, LotteryContext r3, LotteryPluginStore r4, com.bytedance.android.live.revenue.core.a r5) {
        Intrinsics.checkNotNullParameter(r2, "myScope");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r4, "pluginStore");
        Intrinsics.checkNotNullParameter(r5, "inst");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
