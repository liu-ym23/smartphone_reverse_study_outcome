package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p1<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ Lottery b;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g c;

    public p1(LotteryRepository r1, Lottery r2, com.bytedance.android.live.revenue.common.g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r1 = LotteryTraceMonitor.EventName.lottery_old_draw_interaction_error;
        StringBuilder r2 = new StringBuilder("lotteryid = ");
        Lottery r3 = this.b;
        if (r3 == null) goto L9;
        LotteryState r4 = r3.getState();
        if (r4 == null) goto L9;
        t r7 = l.a(r4);
        if (r7 == null) goto L9;
        Long r8 = Long.valueOf(r7.a);
    L10:
        r2.append(r8);
        LotteryTraceMonitor.a(r1, r2.toString());
        this.b.b(LotteryAction.a.a);
        this.c.c(r6);
        LotteryRepository r9 = this.a;
        Intrinsics.checkNotNullParameter(r9, "$this$monitorLotteryFetchedResultFail");
        Intrinsics.checkNotNullParameter(r6, "throwable");
        JSONObject r10 = new JSONObject();
        d1.a(r9, r10);
        d1.c("ttlive_lottery_participate_status", r6, r10);
        return;
    L9:
        r8 = null;
        goto L10
    }
}
