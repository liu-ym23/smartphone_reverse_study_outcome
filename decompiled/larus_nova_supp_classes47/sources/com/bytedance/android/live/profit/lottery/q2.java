package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public q2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        m2 r0 = this.a;
        int r7 = ((Integer) r6).intValue();
        LotteryState r1 = r0.d();
        if (r1 == null) goto L31;
        boolean r2 = r0.h.isAnchor();
        if ((r1 instanceof LotteryState.g) == true) goto L24;
        if ((r1 instanceof LotteryState.a) == true) goto L24;
        if ((r1 instanceof LotteryState.b) == false) goto L16;
        if (r2 == false) goto L14;
        String r3 = m2.f(((LotteryState.b) r1).a).b;
    L29:
        r0.g(r3, r1, r7);
        return;
    L14:
        r3 = m2.f(((LotteryState.b) r1).a).e;
        goto L29
    L16:
        if ((r1 instanceof LotteryState.d) == false) goto L20;
        if (r2 == false) goto L19;
        r3 = m2.f(((LotteryState.d) r1).a).c;
        goto L29
    L19:
        r3 = m2.f(((LotteryState.d) r1).a).e;
        goto L29
    L20:
        if (r2 == false) goto L22;
        r3 = w2.e().anchorLotteryCreateUri;
        goto L29
    L22:
        r3 = "";
    L24:
        if (((ParticipateStatus) r0.e.getCurCandidateState().getValue()) != ParticipateStatus.NOTPARTICIPATED) goto L26;
        r0.g.l.onNext(ParticipateStatus.PARTICIPATED);
        LinkedHashMap<String, String> r4 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_local_participated, "local participated");
    L26:
        if (r2 == false) goto L28;
        r3 = m2.f(l.a(r1)).b;
        goto L29
    L28:
        r3 = m2.f(l.a(r1)).d;
        goto L29
    }
}
