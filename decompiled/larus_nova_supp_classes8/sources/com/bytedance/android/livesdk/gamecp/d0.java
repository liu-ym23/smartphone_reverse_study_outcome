package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 implements ILiveMonitorService {
    public d0() {
    }

    public final Double getCpuRate() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Double.valueOf(r0.getCpuRate());
    }

    public final Double getGpuUsed() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Double.valueOf(r0.getGpuUsed());
    }

    public final Float getTemperature() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r0.getTemperature());
    }

    public final void onModuleStop(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.onModuleStop(r2);
        return;
    }

    public final void onModuleStart(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "extra");
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.onModuleStart(r2, r3);
        return;
    }
}
