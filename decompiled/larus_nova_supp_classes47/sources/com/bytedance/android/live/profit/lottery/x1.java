package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x1<T> implements Consumer {
    public final /* synthetic */ y1 a;

    public x1(y1 r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        PropertyOwner<sh6.b<Lottery>> r9 = this.a.a.c;
        Intrinsics.checkNotNullParameter(r9, "$this$valueNullable");
        Lottery r10 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r9);
        y1 r1 = this.a;
        long r3 = 0;
        if (r10 != r1.b) goto L5;
        r1.a.c.a(sh6.a.a);
        ALogger.i("ttlive_lottery", "lotteryRepository_currentLottery.value = None");
        LotteryRepository r12 = this.a.a;
        r12.n = 0;
        r12.g.a(ParticipateStatus.NOTPARTICIPATED);
        this.a.a.k.onNext(new e1(0, CollectionsKt.emptyList(), ""));
    L5:
        PropertyOwner<sh6.b<Lottery>> r13 = this.a.a.c;
        if (r13 == null) goto L8;
        Intrinsics.checkNotNullParameter(r13, "$this$valueNullable");
        Lottery r14 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r13);
    L9:
        y1 r0 = this.a;
        if (r14 != r0.b) goto L12;
        boolean r15 = true;
    L13:
        PropertyOwner<sh6.b<Lottery>> r2 = r0.a.c;
        if (r2 == null) goto L24;
        sh6.b r4 = (sh6.b) r2.a;
        if (r4 == null) goto L24;
        Lottery r5 = (Lottery) sh6.c.b(r4);
        if (r5 == null) goto L24;
        LotteryState r6 = r5.getState();
        if (r6 == null) goto L24;
        t r16 = l.a(r6);
        if (r16 == null) goto L24;
        r3 = r16.a;
    L24:
        String r17 = String.valueOf(r3);
        LinkedHashMap<String, String> r18 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_is_terminalState, "lotteryid = " + r17 + " & " + r15);
        return;
    L12:
        r15 = false;
        goto L13
    L8:
        r14 = null;
        goto L9
    }
}
