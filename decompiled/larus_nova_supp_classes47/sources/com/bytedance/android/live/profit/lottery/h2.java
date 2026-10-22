package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h2<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;

    public h2(LotteryRepository r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.live.datacontext.m<ParticipateStatus> r0 = this.a.o.getCurCandidateState();
        r0.setValue((ParticipateStatus) r2);
    }
}
