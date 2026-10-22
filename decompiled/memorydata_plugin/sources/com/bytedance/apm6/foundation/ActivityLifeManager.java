package com.bytedance.apm6.foundation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifeManager implements Application.ActivityLifecycleCallbacks, ActivityLifecycleService {
    private boolean changingConfigActivity;
    private int frontActivityCount;
    private volatile boolean isFront;
    private final ArrayList<IActivityLifecycleObserver> observers;
    private String topActivityClassName;
    private WeakReference<Activity> topActivityRef;

    public ActivityLifeManager() {
        this.observers = new ArrayList();
        this.topActivityClassName = null;
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        r0.unregisterActivityLifecycleCallbacks(this);
        r0.registerActivityLifecycleCallbacks(this);
    }

    private Object[] collectObservers() {
        ArrayList<IActivityLifecycleObserver> r0 = this.observers;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.observers.size() <= 0) goto L7;
        Object[] r2 = this.observers.toArray();     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r2 == null) goto L11;
        return r2;
    L11:
        return new Object[0];
    L7:
        r2 = null;
        goto L8
    }

    private void notifyBackground(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((IActivityLifecycleObserver) ZeusTransformUtils.preCheckCast(r5[r2], IActivityLifecycleObserver.class, "com.obric.memorydata.plugin")).onBackground(r7);
        r2 = r2 + 1;
        goto L3
    }

    private void notifyFront(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((IActivityLifecycleObserver) ZeusTransformUtils.preCheckCast(r5[r2], IActivityLifecycleObserver.class, "com.obric.memorydata.plugin")).onFront(r7);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public String getTopActivityClassName() {
        WeakReference<Activity> r0 = this.topActivityRef;
        if (r0 != null) goto L5;
        return "";
    L5:
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0.get(), Activity.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        String r4 = this.topActivityClassName;
        if (r4 == null) goto L10;
        return r4;
    L10:
        return r1.getClass().getCanonicalName();
    L11:
        return "";
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public boolean isForeground() {
        return this.isFront;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r5, Bundle r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        Object[] r4 = collectObservers();
        int r8 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L5;
        ((IActivityLifecycleObserver) ZeusTransformUtils.preCheckCast(r4[r1], IActivityLifecycleObserver.class, "com.obric.memorydata.plugin")).onActivityCreated(r7);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((IActivityLifecycleObserver) ZeusTransformUtils.preCheckCast(r5[r2], IActivityLifecycleObserver.class, "com.obric.memorydata.plugin")).onActivityPause(r7);
        r2 = r2 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        this.topActivityRef = new WeakReference(r7);
        this.topActivityClassName = null;
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((IActivityLifecycleObserver) ZeusTransformUtils.preCheckCast(r5[r2], IActivityLifecycleObserver.class, "com.obric.memorydata.plugin")).onActivityResume(r7);
        r2 = r2 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        Object[] r0 = collectObservers();
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L6;
        ((IActivityLifecycleObserver) ZeusTransformUtils.preCheckCast(r0[r4], IActivityLifecycleObserver.class, "com.obric.memorydata.plugin")).onActivityStarted(r9);
        r4 = r4 + 1;
        goto L3
    L6:
        if (this.changingConfigActivity == false) goto L9;
        this.changingConfigActivity = false;
        return;
    L9:
        int r1 = this.frontActivityCount + 1;
        this.frontActivityCount = r1;
        if (r1 != 1) goto L14;
        this.isFront = true;
        notifyFront(r9);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (r4.isChangingConfigurations() == false) goto L6;
        this.changingConfigActivity = true;
        return;
    L6:
        int r0 = this.frontActivityCount - 1;
        this.frontActivityCount = r0;
        if (r0 != 0) goto L10;
        this.isFront = false;
        notifyBackground(r4);
        return;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void register(IActivityLifecycleObserver r3) {
        IActivityLifecycleObserver r4 = (IActivityLifecycleObserver) ZeusTransformUtils.wrapperContextForParams(r3, IActivityLifecycleObserver.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        ArrayList<IActivityLifecycleObserver> r0 = this.observers;
        monitor-enter(r0);
        this.observers.add(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void unregister(IActivityLifecycleObserver r3) {
        IActivityLifecycleObserver r4 = (IActivityLifecycleObserver) ZeusTransformUtils.wrapperContextForParams(r3, IActivityLifecycleObserver.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        ArrayList<IActivityLifecycleObserver> r0 = this.observers;
        monitor-enter(r0);
        this.observers.remove(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
