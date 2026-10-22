package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n1<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;

    public n1(LotteryRepository r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r1 = LotteryTraceMonitor.EventName.lottery_init_api;
        StringBuilder r2 = new StringBuilder("fail lotteryid = ");
        if (r5 == null) goto L5;
        String r3 = r5.toString();
    L6:
        r2.append(r3);
        LotteryTraceMonitor.a(r1, r2.toString());
        LotteryRepository r6 = this.a;
        Intrinsics.checkNotNullParameter(r6, "$this$monitorLotteryFetchedFail");
        Intrinsics.checkNotNullParameter(r5, "throwable");
        JSONObject r7 = new JSONObject();
        d1.a(r6, r7);
        d1.c("ttlive_lottery_fetched_status", r5, r7);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
