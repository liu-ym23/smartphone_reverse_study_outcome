package com.bytedance.android.live.profit.lottery;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0<T1, T2> implements ttc.a {
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g a;

    public g0(com.bytedance.android.live.revenue.common.g r1) {
        this.a = r1;
    }

    public final void accept(Object r4, Object r5) {
        sh6.b r6 = (sh6.b) r4;
        Throwable r7 = (Throwable) r5;
        if (r6 == null) goto L13;
        LinkedHashMap<String, String> r8 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r9 = LotteryTraceMonitor.EventName.lottery_init_api_success;
        StringBuilder r0 = new StringBuilder("success lotteryid = ");
        t r1 = (t) sh6.c.b(r6);
        if (r1 == null) goto L7;
        long r2 = r1.a;
    L8:
        r0.append(String.valueOf(r2));
        LotteryTraceMonitor.a(r9, r0.toString());
        com.bytedance.android.live.revenue.common.g r10 = this.a;
        StringBuilder r3 = new StringBuilder("lotteryId=");
        t r12 = (t) sh6.c.b(r6);
        if (r12 == null) goto L11;
        Long r13 = Long.valueOf(r12.a);
    L12:
        r3.append(r13);
        r10.a(r3.toString());
        return;
    L11:
        r13 = null;
        goto L12
    L7:
        r2 = 0;
        goto L8
    L13:
        LinkedHashMap<String, String> r14 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r15 = LotteryTraceMonitor.EventName.lottery_init_api_fail;
        if (r7 == null) goto L16;
        Object r16 = r7;
    L17:
        LotteryTraceMonitor.a(r15, "fail lotteryid = ".concat(String.valueOf(r16)));
        this.a.c(r7);
        return;
    L16:
        r16 = "";
        goto L17
    }
}
