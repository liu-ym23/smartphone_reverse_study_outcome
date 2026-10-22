package com.ss.android.lark.integrator.ccm.dependency.di;

import android.os.SystemClock;
import com.bytedance.ee.bear.integrator.di.KoinSetupTask;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q {
    public static volatile kwc.a a;

    public static kwc.a a() {
        if (a != null) goto L15;
        monitor-enter(q.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        long r2 = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        eu5.b.a = LarkContext.getApplication();     // Catch: Throwable -> L11
        KoinSetupTask.b(LarkContext.getApplication());     // Catch: Throwable -> L11
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L11
        kwc.a r5 = LarkAppKoinModuleKt.a;     // Catch: Throwable -> L11
        r4.add(r5);     // Catch: Throwable -> L11
        hwc.a r6 = hwc.a.a;     // Catch: Throwable -> L11
        hwc.a.a().c(r4, false);     // Catch: Throwable -> L11
        a = r5;     // Catch: Throwable -> L11
        tt5.a.h("DependencyDiInit", "DependencyDiInit#injectDependencyModule cost=" + (SystemClock.uptimeMillis() - r2));     // Catch: Throwable -> L11
    L9:
        monitor-exit(q.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public q() {
    }
}
