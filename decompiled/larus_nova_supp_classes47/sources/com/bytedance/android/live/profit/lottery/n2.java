package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public n2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        Unit r13 = (Unit) r12;
        final LotteryRepository r14 = this.a.g;
        int r0 = LotteryRepository.s;
        if ((r14.c.a instanceof sh6.d) == false) goto L5;
        int r1 = com.bytedance.android.live.revenue.common.v.a;
        StringBuilder r2 = new StringBuilder("lottery is already present: ");
        PropertyOwner<sh6.b<Lottery>> r15 = r14.c;
        Intrinsics.checkNotNullParameter(r15, "$this$valueNullable");
        r2.append((Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r15));
        com.bytedance.android.live.revenue.common.v.h("ttlive_lottery", r2.toString());
        return;
    L5:
        final Lottery r3 = new Lottery(LotteryState.f.a);
        final com.bytedance.android.live.revenue.common.g r4 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "handleLotterySubmit " + r3.c);
        r4.a("begin");
        r14.h(r3);
        v.c r5 = v.a;
        long r6 = r14.q.getRoom().getId();
        com.bytedance.android.live.revenue.common.g r7 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "pollReviewStatus roomId=" + r6);
        r7.a("begin");
        com.bytedance.android.live.core.utils.rxutils.j.a r8 = com.bytedance.android.live.core.utils.rxutils.j.a;
        TimeUnit r9 = TimeUnit.MILLISECONDS;
        Disposable r10 = RxUtilKt.q(RxUtilKt.i(RxUtilKt.h(com.bytedance.android.live.core.utils.rxutils.j.c(5000, r9).flatMap(new j0(r6))).firstOrError().doOnSuccess(new k0(r7)).doOnSuccess(new l1(r4)).delay(5000, r9)), "ttlive_lottery", new LotteryRepository$createLottery$disposable$2(r14, r4, r3));
        RxUtilKt.c(r10, r14.b);
        RxUtilKt.c(r3.b.filter(j1.a).take(1).subscribe(new k1(r10, r4)), r14.b);
    }
}
