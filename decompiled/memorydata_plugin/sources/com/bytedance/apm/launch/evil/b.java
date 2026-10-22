package com.bytedance.apm.launch.evil;

import android.os.Handler;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.a.f;
import com.bytedance.apm.block.a.g;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.crash.constants.Constants;
import com.bytedance.monitor.collector.h;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1430a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1431b = false;
    private static com.bytedance.perf.monitor.a c;

    static {
    }

    public static synchronized void a() {
        monitor-enter(b.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f1430a == false) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f1430a = true;     // Catch: Throwable -> L18
        if (f1431b == true) goto L15;
        f1431b = true;     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a.a(EvilMethodSwitcher.getLaunchEvilThresholdMs());     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a.a(true);     // Catch: Throwable -> L18
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L14;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L18
    L14:
        f.a().c();     // Catch: Throwable -> L18
        g.a().b();     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a.f2970a = true;     // Catch: Throwable -> L18
        com.bytedance.perf.monitor.a r2 = new com.bytedance.perf.monitor.a(EvilMethodSwitcher.isLaunchLimitEvilMethodDepth(), true);     // Catch: Throwable -> L18
        c = r2;     // Catch: Throwable -> L18
        r2.b();     // Catch: Throwable -> L18
        h.a(true, Constants.LAUNCH_TAG, null);     // Catch: Throwable -> L18
        new Handler().postDelayed(new AnonymousClass1(), 10000);     // Catch: Throwable -> L18
    L15:
        com.bytedance.apm.trace.fps.b.a("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L18
        monitor-exit(b.class);
    }

    public static synchronized void b() {
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f1430a == true) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f1430a = false;     // Catch: Throwable -> L12
        c.b(EvilMethodSwitcher.isLimitEvilMethodDepth());     // Catch: Throwable -> L12
        com.bytedance.perf.monitor.a.a(EvilMethodSwitcher.getEvilThresholdMs());     // Catch: Throwable -> L12
        com.bytedance.apm.trace.fps.b.b("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L12
        monitor-exit(b.class);
    }
}
