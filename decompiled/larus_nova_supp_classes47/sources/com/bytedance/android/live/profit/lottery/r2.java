package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public r2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        LotteryState.b r8 = (LotteryState.b) r7;
        m2 r0 = this.a;
        r0.getClass();
        ALogger.i("ttlive_lottery", "onLotteryFinish");
        LinkedHashMap<String, String> r1 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r2 = LotteryTraceMonitor.EventName.lottery_draw_finish_1;
        StringBuilder r3 = new StringBuilder("lotteryid = ");
        Integer r4 = null;
        if (r8 == null) goto L7;
        t r5 = r8.a;
        if (r5 == null) goto L7;
        Long r6 = Long.valueOf(r5.a);
    L8:
        r3.append(r6.longValue());
        LotteryTraceMonitor.a(r2, r3.toString());
        x2 r9 = f3.a;
        if (r8 == null) goto L14;
        t r10 = r8.a;
        if (r10 == null) goto L14;
        r4 = Integer.valueOf(r10.d);
    L14:
        if (f3.b(String.valueOf(r4.intValue())) == false) goto L23;
        p0 r12 = r8.b;
        if (r12.c == false) goto L19;
        String r13 = m2.f(r8.a).c;
    L26:
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_draw_finish_2, "uri = " + r13);
        i.B0.getClass();
        r0.g(r13, r8, 0);
        return;
    L19:
        if (r12.b != true) goto L21;
        r13 = m2.f(r8.a).f;
        goto L26
    L21:
        r13 = m2.f(r8.a).g;
        goto L26
    L23:
        if (r8.b.c == false) goto L25;
        r13 = m2.f(r8.a).b;
        goto L26
    L25:
        r13 = m2.f(r8.a).e;
    L7:
        r6 = null;
        goto L8
    }
}
