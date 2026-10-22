package com.ss.android.lark.monitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ MonitorModule a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r1) {
    }

    public v(MonitorModule r1) {
        this.a = r1;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r4) {
        this.a.j(r4.getClass().getName() + "#hash" + r4.hashCode(), null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r4) {
        String r0 = r4.getClass().getName();
        final MonitorModule r1 = this.a;
        final String r5 = r0 + "#hash" + r4.hashCode();
        if (r1.c == false) goto L6;
        Log.i("ScenePerfMonitor", "pauseScene:" + r5);
        CoreThreadPool.getNonblockingHandler().post(new r(r1, r5));
    L6:
        ScheduledFuture r6 = this.a.e;
        if (r6 == null) goto L9;
        r6.cancel(true);
        this.a.e = null;
    L9:
        ScheduledFuture r7 = this.a.f;
        if (r7 == null) goto L13;
        r7.cancel(true);
        this.a.f = null;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r4) {
        this.a.g(r4.getClass().getName() + "#hash" + r4.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r6, Bundle r7) {
        this.a.a();
        CoreThreadPool.getNonblockingHandler().postDelayed(new s(this), 3000);
        final WeakReference r8 = new WeakReference(r6);
        MonitorModule r9 = this.a;
        ScheduledExecutorService r0 = CoreThreadPool.getDefault().getScheduleThreadPool();
        Runnable r1 = new t(this, r8);
        TimeUnit r2 = TimeUnit.SECONDS;
        r9.e = r0.schedule(r1, 3, r2);
        MonitorModule r10 = this.a;
        r10.f = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new u(this, r8), 6, r2);
    }
}
