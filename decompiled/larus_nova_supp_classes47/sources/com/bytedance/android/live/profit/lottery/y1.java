package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y1<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ Lottery b;

    public y1(LotteryRepository r1, Lottery r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        LotteryState r8 = (LotteryState) r7;
        w2.d();
        long r2 = 0;
        if (w2.d() <= 0) goto L5;
        RxUtilKt.c(RxUtilKt.d(w2.d(), 100).filter(w1.a).take(1).subscribe(new x1(this)), this.a.b);
        return;
    L5:
        PropertyOwner<sh6.b<Lottery>> r9 = this.a.c;
        Intrinsics.checkNotNullParameter(r9, "$this$valueNullable");
        if (((Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r9)) != this.b) goto L8;
        this.a.c.a(sh6.a.a);
        ALogger.i("ttlive_lottery", "lotteryRepository_currentLottery.value = None");
        LotteryRepository r10 = this.a;
        r10.n = 0;
        r10.g.a(ParticipateStatus.NOTPARTICIPATED);
        this.a.k.onNext(new e1(0, CollectionsKt.emptyList(), ""));
    L8:
        PropertyOwner<sh6.b<Lottery>> r12 = this.a.c;
        if (r12 == null) goto L11;
        Intrinsics.checkNotNullParameter(r12, "$this$valueNullable");
        Lottery r13 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r12);
    L13:
        if (r13 != this.b) goto L15;
        boolean r14 = true;
    L16:
        PropertyOwner<sh6.b<Lottery>> r0 = this.a.c;
        if (r0 == null) goto L27;
        sh6.b r1 = (sh6.b) r0.a;
        if (r1 == null) goto L27;
        Lottery r3 = (Lottery) sh6.c.b(r1);
        if (r3 == null) goto L27;
        LotteryState r4 = r3.getState();
        if (r4 == null) goto L27;
        t r5 = l.a(r4);
        if (r5 == null) goto L27;
        r2 = r5.a;
    L27:
        String r6 = String.valueOf(r2);
        LinkedHashMap<String, String> r15 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_is_terminalState, "lotteryid = " + r6 + " & " + r14);
        return;
    L15:
        r14 = false;
        goto L16
    L11:
        r13 = null;
        goto L13
    }
}
