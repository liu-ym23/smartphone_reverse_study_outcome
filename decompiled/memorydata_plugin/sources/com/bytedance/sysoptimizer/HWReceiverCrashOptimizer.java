package com.bytedance.sysoptimizer;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class HWReceiverCrashOptimizer {
    private static volatile boolean sHasFix;

    public HWReceiverCrashOptimizer() {
    }

    public static void fix(ContextWrapper r5) {
        ContextWrapper r6 = (ContextWrapper) ZeusTransformUtils.wrapperContextForParams(r5, ContextWrapper.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT == 22) goto L7;
        if (Build.VERSION.SDK_INT == 23) goto L7;
        return;
    L7:
        monitor-enter(HWReceiverCrashOptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (sHasFix == false) goto L12;
        monitor-exit(HWReceiverCrashOptimizer.class);     // Catch: Throwable -> L16
        return;
    L12:
        sHasFix = true;     // Catch: Throwable -> L16
        Field r2 = ZeusTransformUtils.forName("android.app.ContextImpl", "com.obric.memorydata.plugin").getDeclaredField("mPackageInfo");     // Catch: Exception -> L19 Throwable -> L16
        r2.setAccessible(true);     // Catch: Exception -> L19 Throwable -> L16
        Object r7 = r2.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L19 Throwable -> L16
        Field r3 = ZeusTransformUtils.forName("android.app.LoadedApk", "com.obric.memorydata.plugin").getDeclaredField("mReceiverResource");     // Catch: Exception -> L19 Throwable -> L16
        r3.setAccessible(true);     // Catch: Exception -> L19 Throwable -> L16
        r3.set(r7, null);     // Catch: Exception -> L19 Throwable -> L16
    L14:
        monitor-exit(HWReceiverCrashOptimizer.class);     // Catch: Throwable -> L16
    }
}
