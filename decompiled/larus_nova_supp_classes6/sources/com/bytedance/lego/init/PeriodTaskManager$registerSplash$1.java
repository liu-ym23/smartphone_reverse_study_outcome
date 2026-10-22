package com.bytedance.lego.init;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.lego.init.model.ExecutionPeriod;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.c;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0002H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0007¨\u0006\n"}, d2 = {"com/bytedance/lego/init/PeriodTaskManager$registerSplash$1", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onAny", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class PeriodTaskManager$registerSplash$1 implements LifecycleObserver {
    public PeriodTaskManager$registerSplash$1() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public final void onAny() {
        Map r0 = l.a;
        ExecutionPeriod r1 = ExecutionPeriod.SPLASH_ON_ANY;
        Map r2 = l.a;
        l.a(r1);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        int r0 = c.a;
        c.a("PeriodTaskManager", "splash - onCreate");
        Map r1 = l.a;
        ExecutionPeriod r2 = ExecutionPeriod.SPLASH_ON_CREATE;
        Map r3 = l.a;
        l.a(r2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        int r0 = c.a;
        c.a("PeriodTaskManager", "splash - onDestroy");
        Map r1 = l.a;     // Catch: Exception -> L5
        l.a(ExecutionPeriod.SPLASH_ON_DESTROY);     // Catch: Exception -> L5
        InitScheduler.unRegisterSplashActivity$initscheduler_release();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        InitMonitor.INSTANCE.ensureNotReachHere(e, "SPALSH_ON_DESTROY_EXCEPTION");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        int r0 = c.a;
        c.a("PeriodTaskManager", "splash - onPause");
        Map r1 = l.a;
        l.a(ExecutionPeriod.SPLASH_ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        int r0 = c.a;
        c.a("PeriodTaskManager", "splash - onResume");
        Map r1 = l.a;
        ExecutionPeriod r2 = ExecutionPeriod.SPLASH_ON_RESUME;
        Map r3 = l.a;
        l.a(r2);
        Map r4 = l.a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        int r0 = c.a;
        c.a("PeriodTaskManager", "splash - onStart");
        Map r1 = l.a;
        ExecutionPeriod r2 = ExecutionPeriod.SPLASH_ON_START;
        Map r3 = l.a;
        l.a(r2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        int r0 = c.a;
        c.a("PeriodTaskManager", "splash - onStop");
        Map r1 = l.a;
        l.a(ExecutionPeriod.SPLASH_ON_STOP);
    }
}
