package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b2<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ Lottery b;

    public b2(LotteryRepository r1, Lottery r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        RxUtilKt.c(RxUtilKt.d(((LotteryState.g) r5).a.c - System.currentTimeMillis(), 1000).filter(z1.a).take(1).subscribe(new a2(this)), this.a.b);
    }
}
