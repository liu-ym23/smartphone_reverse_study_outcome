package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d1 {
    public static final void a(LotteryRepository r3, JSONObject r4) {
        BaseMonitor.add(r4, "room_id", r3.q.getRoom().getId());
        BaseMonitor.add(r4, "is_anchor", String.valueOf(r3.g()));
        BaseMonitor.add(r4, "user_id", ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId());
    }

    public static final void b(String r7, JSONObject r8) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r4, "status_code", DataType.FALSE);
        BaseMonitor.add(r4, "lottery_from_im_status", r7);
        LiveTracingMonitor.k("ttlive_lottery_from_im_status", LiveTracingMonitor.EventModule.LIVE_PROFIT, 0, r4, r5, r8);
    }

    public static final void d(LotteryRepository r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$monitorLotteryFetchedSuccess");
        Intrinsics.checkNotNullParameter(r3, "lotteryInfo");
        JSONObject r0 = new JSONObject();
        a(r2, r0);
        BaseMonitor.add(r0, "lottery_id", r3.a);
        e("ttlive_lottery_fetched_status", r0);
    }

    public static final void e(String r7, JSONObject r8) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r4, "status_code", DataType.FALSE);
        LiveTracingMonitor.k(r7, LiveTracingMonitor.EventModule.LIVE_PROFIT, 0, r4, r5, r8);
    }

    public static final void c(String r7, Throwable r8, JSONObject r9) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r4, "status_code", "-1");
        BaseMonitor.add(r9, "error_code", com.bytedance.android.live.revenue.common.r0.a(r8));
        String r0 = com.bytedance.android.live.revenue.common.q0.a(r8);
        if (r0 != null) goto L5;
        r0 = r8.toString();
    L5:
        BaseMonitor.add(r9, "error_msg", r0);
        LiveTracingMonitor.k(r7, LiveTracingMonitor.EventModule.LIVE_PROFIT, 0, r4, r5, r9);
    }
}
