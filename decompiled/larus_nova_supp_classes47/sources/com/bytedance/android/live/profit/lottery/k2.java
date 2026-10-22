package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k2<T> implements Consumer {
    public final /* synthetic */ LotteryRepository a;
    public final /* synthetic */ Lottery b;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g c;
    public final /* synthetic */ LotteryState d;

    public k2(LotteryRepository r1, Lottery r2, com.bytedance.android.live.revenue.common.g r3, LotteryState.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_draw_compensate_request_fail, String.valueOf(r6.toString()));
        LotteryState r1 = this.d;
        if (r1 != null) goto L5;
    L16:
        this.b.b(LotteryAction.a.a);
        this.c.c(r6);
        LotteryRepository r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "$this$monitorLotteryCheckCandidateStateFail");
        Intrinsics.checkNotNullParameter(r6, "throwable");
        JSONObject r3 = new JSONObject();
        d1.a(r2, r3);
        d1.c("ttlive_lottery_participate_status_new", r6, r3);
        return;
    L5:
        if (l.a(r1) == null) goto L16;
        t r4 = l.a(this.d);
        Intrinsics.checkNotNull(r4);
        int r7 = r4.d;
        if (r7 != 1) goto L9;
        ToastUtil.a(2131920145, 1);
        goto L16
    L9:
        if (r7 != 2) goto L11;
        ToastUtil.a(2131920146, 1);
        goto L16
    L11:
        if (r7 != 4) goto L16;
        ToastUtil.a(2131920146, 1);
        goto L16
    }
}
