package com.bytedance.sysoptimizer.sp;

import android.content.Context;
import android.os.Build;
import com.bytedance.services.apm.api.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class SPANROptimizer {
    private static boolean hasFixed;

    public SPANROptimizer() {
    }

    public static synchronized void fix(Context r5) {
        monitor-enter(SPANROptimizer.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (hasFixed == false) goto L9;
        monitor-exit(SPANROptimizer.class);
        return;
    L9:
        hasFixed = true;     // Catch: Throwable -> L20
        Class r1 = ZeusTransformUtils.forName("android.app.QueuedWork", "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT < 26) goto L14;
        Field r2 = r1.getDeclaredField("sFinishers");     // Catch: Throwable -> L16
        r2.setAccessible(true);     // Catch: Throwable -> L16
        Object r7 = new SPLinkedList();     // Catch: Throwable -> L16
    L13:
        r2.set(null, r7);     // Catch: Throwable -> L16
    L18:
        monitor-exit(SPANROptimizer.class);
        return;
    L14:
        r2 = r1.getDeclaredField("sPendingWorkFinishers");     // Catch: Throwable -> L16
        r2.setAccessible(true);     // Catch: Throwable -> L16
        r7 = new SPConcurrentLinkedQueue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        a.a(th, "FIX SP ANR FAIL");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
