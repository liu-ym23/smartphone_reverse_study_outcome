package com.bytedance.android.live.browser.utils;

import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends BasePerformanceStrategyTask {
    public final boolean onTriggerEnhance(int r1, Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        Intrinsics.checkNotNullParameter(r2, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        return false;
    }

    public a() {
    }

    public final void onTriggerOrigin(Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        Intrinsics.checkNotNullParameter(r2, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        int r4 = y8.d.a;
        y8.d.b(DegradeStatus.liveDegrade);
    }

    public final boolean onTriggerDegrade(int r2, Map<String, String> r3, IPerformanceStrategyMonitor r4) {
        Intrinsics.checkNotNullParameter(r3, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r4, "monitor");
        int r5 = y8.d.a;
        y8.d.a(DegradeStatus.liveDegrade, r2, 4);
        return false;
    }
}
