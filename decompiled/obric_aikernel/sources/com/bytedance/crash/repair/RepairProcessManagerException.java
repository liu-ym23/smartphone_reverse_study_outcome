package com.bytedance.crash.repair;

import android.os.Build;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RepairProcessManagerException {
    public RepairProcessManagerException() {
    }

    public static void repair() {
        if (Build.VERSION.SDK_INT != 23) goto L11;
        Class<?> r10 = Class.forName("java.lang.ProcessManager");     // Catch: Throwable -> L8
        Object r11 = r10.getDeclaredMethod("getInstance", new Class[0]).invoke(r10, new Object[0]);     // Catch: Throwable -> L8
        Field r12 = r10.getDeclaredField("processReferences");     // Catch: Throwable -> L8
        r12.setAccessible(true);     // Catch: Throwable -> L8
        r12.set(r11, new ConcurrentHashMap((Map) r12.get(r11)));     // Catch: Throwable -> L8
        AppMonitor r13 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L8
        if (r13 == null) goto L12;
        r13.addTag("enable_process_repair", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L11:
        return;
    }
}
