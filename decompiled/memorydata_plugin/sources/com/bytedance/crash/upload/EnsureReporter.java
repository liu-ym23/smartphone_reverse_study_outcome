package com.bytedance.crash.upload;

import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.monitor.MonitorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class EnsureReporter {
    public EnsureReporter() {
    }

    public static void reportException(Throwable r1, String r2, boolean r3) {
        MonitorManager.getAppEnsureManager().reportThrowable(r1, r2, r3);
    }

    public static void reportException(Throwable r9, String r10, boolean r11, Map<String, String> r12, String r13) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        MonitorManager.getAppEnsureManager().reportJavaEnsure(r9, null, r10, r4, Thread.currentThread().getName(), EnsureDeliverer.ENSURE_NOT_REACH_HERE, r13, r11);
    }
}
