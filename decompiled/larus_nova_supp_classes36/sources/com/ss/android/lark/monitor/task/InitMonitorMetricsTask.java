package com.ss.android.lark.monitor.task;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import asb.d;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.monitor.LarkMetrics;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.c;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.monitor.cpu.CpuSceneMonitor;
import com.ss.android.lark.monitor.i;
import com.ss.android.lark.monitor.p;
import com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor;
import com.ss.android.lark.monitor.traffic.l;
import com.ss.android.lark.monitor.v;
import com.ss.android.lark.utils.LarkContext;
import esb.b;
import jac.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitMonitorMetricsTask extends AsyncLaunchTask {
    public final List<Class<? extends ILaunchTask>> i() {
        return new ArrayList();
    }

    public InitMonitorMetricsTask() {
    }

    public final void a(Context r9) {
        int r0 = a.a;
        if (r9 == null) goto L10;
        String r2 = z.b(r9);
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r2.contains(":sandboxed_process") == false) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return;
    L13:
        final MonitorModule r4 = MonitorModule.e();
        r4.getClass();
        i.a r5 = new i.a(r9);
        r5.c = DevEnvUtil.isDebugMode(LarkContext.getApplication());
        r5.f = new hsb.a();
        r5.d = z.e(r9);
        r5.e = z.b(r9);
        r5.h = 6;
        r5.b = (c) ClaymoreServiceLoader.loadFirst(c.class);
        r5.i = AppLifecycle.a.a.h();
        i r10 = new i(r5);
        monitor-enter(r4);
    L22:
        th = move-exception;
        throw th;
    L16:
        if (r4.c == false) goto L19;
        monitor-exit(r4);
        return;
    L19:
        LarkMetrics.a.a.a(r10);     // Catch: Throwable -> L22
        CpuSceneMonitor r6 = new CpuSceneMonitor(r10);     // Catch: Throwable -> L22
        b r7 = new b(r10);     // Catch: Throwable -> L22
        TemperaturePerfMonitor r8 = new TemperaturePerfMonitor();     // Catch: Throwable -> L22
        r4.b.add(r6);     // Catch: Throwable -> L22
        r4.b.add(r7);     // Catch: Throwable -> L22
        r4.b.add(r8);     // Catch: Throwable -> L22
        r4.b.add(new d(r10));     // Catch: Throwable -> L22
        r4.b.add(new l(r10));     // Catch: Throwable -> L22
        DevicePerfManager.b.a.a(new com.ss.android.lark.monitor.d[]{r6, r7, r8});     // Catch: Throwable -> L22
        CoreThreadPool.getDefault().setSceneDependency(new p(r4));     // Catch: Throwable -> L22
        ((Application) r10.a.getApplicationContext()).registerActivityLifecycleCallbacks(new v(r4));     // Catch: Throwable -> L22
        r4.c = true;     // Catch: Throwable -> L22
        monitor-exit(r4);
        return;
    L10:
        r3 = false;
        goto L11
    }
}
