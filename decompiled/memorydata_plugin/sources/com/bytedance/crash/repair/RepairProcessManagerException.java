package com.bytedance.crash.repair;

import android.os.Build;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class RepairProcessManagerException {
    public RepairProcessManagerException() {
    }

    public static void repair() {
        if (Build.VERSION.SDK_INT != 23) goto L12;
        Class r1 = ZeusTransformUtils.forName("java.lang.ProcessManager", "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r2 = r1.getDeclaredMethod("getInstance", new Class[0]).invoke(r1, new Object[0]);     // Catch: Throwable -> L9
        Field r3 = r1.getDeclaredField("processReferences");     // Catch: Throwable -> L9
        r3.setAccessible(true);     // Catch: Throwable -> L9
        r3.set(r2, new ConcurrentHashMap((Map) ZeusTransformUtils.preCheckCast(r3.get(r2), Map.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L9
        AppMonitor r0 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L9
        if (r0 == null) goto L13;
        r0.addTag("enable_process_repair", "1");     // Catch: Throwable -> L9
        return;
    L13:
        return;
    L12:
        return;
    }
}
