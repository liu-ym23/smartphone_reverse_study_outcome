package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.profit.lottery.model.LotteryInfoSyncData;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0<T> implements Consumer {
    public final /* synthetic */ LotteryIMDataSource a;

    public s0(LotteryIMDataSource r1) {
        this.a = r1;
    }

    public final void accept(Object r30) {
        BehaviorSubject<y2> r2 = this.a.i;
        LotteryInfoSyncData r0 = (LotteryInfoSyncData) ((com.bytedance.android.livesdk.revenue.message.e.a) r30).a;
        Intrinsics.checkNotNullParameter(r0, "$this$toLotteryTempStatusInfo");
        r2.onNext(new y2(r0.getLotteryId(), r0.getLotteryType(), r0.getLuckyCount(), r0.getPrizeCount(), r0.getCandidateTotalCount(), r0.getLastSurgeTimeStamp(), r0.getStartTime(), r0.getDrawTime(), r0.getEnabledDilatation(), r0.getDilatationConfigDetail(), r0.getDilatationNow(), r0.getPrizeCountBeforeDilatation(), r0.getLuckyCountBeforeDilatation()));
    }
}
