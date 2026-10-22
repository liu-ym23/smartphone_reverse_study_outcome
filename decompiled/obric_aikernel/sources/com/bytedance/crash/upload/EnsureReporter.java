package com.bytedance.crash.upload;

import androidx.annotation.NonNull;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.monitor.MonitorManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class EnsureReporter {
    public EnsureReporter() {
    }

    public static void reportException(Throwable r10, String r11, boolean r12) {
        MonitorManager.getAppEnsureManager().reportThrowable(r10, r11, r12);
    }

    public static void reportException(Throwable r10, String r11, boolean r12, Map<String, String> r13, @NonNull String r14) {
        MonitorManager.getAppEnsureManager().reportJavaEnsure(r10, null, r11, r13, Thread.currentThread().getName(), EnsureDeliverer.ENSURE_NOT_REACH_HERE, r14, r12);
    }
}
