package com.bytedance.apm.launch.evil;

import android.os.Handler;
import androidx.work.WorkRequest;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.crash.constants.Constants;
import com.bytedance.monitor.collector.h;
import t.e;
import t.f;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1006a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1007b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static l4.a f1008c;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c();
        }
    }

    static {
    }

    public static synchronized void a() {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f1008c != null) goto L7;
    L9:
        monitor-exit(b.class);
        return;
    L7:
        if (EvilMethodSwitcher.isOpenLaunchEvilMethod() == false) goto L9;
        f1008c.j();     // Catch: Throwable -> L11
        goto L9
    }

    public static synchronized void b() {
        monitor-enter(b.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f1006a == false) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f1006a = true;     // Catch: Throwable -> L18
        if (f1007b == true) goto L15;
        f1007b = true;     // Catch: Throwable -> L18
        l4.a.m(EvilMethodSwitcher.getLaunchEvilThresholdMs());     // Catch: Throwable -> L18
        l4.a.n(true);     // Catch: Throwable -> L18
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L14;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L18
    L14:
        e.B().D();     // Catch: Throwable -> L18
        f.E().K();     // Catch: Throwable -> L18
        l4.a.f10881r = true;     // Catch: Throwable -> L18
        l4.a r10 = new l4.a(EvilMethodSwitcher.isLaunchLimitEvilMethodDepth(), true);     // Catch: Throwable -> L18
        f1008c = r10;     // Catch: Throwable -> L18
        r10.p();     // Catch: Throwable -> L18
        h.d(true, Constants.LAUNCH_TAG, null);     // Catch: Throwable -> L18
        new Handler().postDelayed(new a(), WorkRequest.MIN_BACKOFF_MILLIS);     // Catch: Throwable -> L18
    L15:
        com.bytedance.apm.trace.fps.b.w("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L18
        monitor-exit(b.class);
    }

    public static synchronized void c() {
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f1006a == true) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f1006a = false;     // Catch: Throwable -> L12
        f1008c.o(EvilMethodSwitcher.isLimitEvilMethodDepth());     // Catch: Throwable -> L12
        l4.a.m(EvilMethodSwitcher.getEvilThresholdMs());     // Catch: Throwable -> L12
        com.bytedance.apm.trace.fps.b.H("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L12
        monitor-exit(b.class);
    }
}
