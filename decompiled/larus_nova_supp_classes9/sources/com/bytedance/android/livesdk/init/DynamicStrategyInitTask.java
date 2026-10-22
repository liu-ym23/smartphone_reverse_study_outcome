package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/init/DynamicStrategyInitTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "()V", "run", BuildConfig.FLAVOR, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_DynamicStrategyInitTask", value = 34)
public final class DynamicStrategyInitTask extends AbsTask {
    public void run() {
        IDynamicStrategyService r0 = jc1.k.f(IDynamicStrategyService.class);
        if (r0 != null) goto L6;
        SafetyGuard.a(null, null, "DynamicStrategyService is null");
        return;
    L6:
        r0.init();
    }

    public DynamicStrategyInitTask() {
    }
}
