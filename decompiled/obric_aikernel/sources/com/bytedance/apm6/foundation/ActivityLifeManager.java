package com.bytedance.apm6.foundation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import com.bytedance.apm6.util.ApmBaseContext;
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
        Application r10 = ApmBaseContext.getContext();
        r10.unregisterActivityLifecycleCallbacks(this);
        r10.registerActivityLifecycleCallbacks(this);
    }

    private Object[] collectObservers() {
        ArrayList<IActivityLifecycleObserver> r10 = this.observers;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.observers.size() <= 0) goto L7;
        Object[] r11 = this.observers.toArray();     // Catch: Throwable -> L12
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L11;
        return r11;
    L11:
        return new Object[0];
    L7:
        r11 = null;
        goto L8
    }

    private void notifyBackground(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onBackground(r10);
        r13 = r13 + 1;
        goto L3
    }

    private void notifyFront(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onFront(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public String getTopActivityClassName() {
        WeakReference<Activity> r10 = this.topActivityRef;
        if (r10 != null) goto L5;
        return "";
    L5:
        Activity r11 = r10.get();
        if (r11 == null) goto L11;
        String r12 = this.topActivityClassName;
        if (r12 == null) goto L10;
        return r12;
    L10:
        return r11.getClass().getCanonicalName();
    L11:
        return "";
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public boolean isForeground() {
        return this.isFront;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
        Object[] r12 = collectObservers();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        ((IActivityLifecycleObserver) r12[r14]).onActivityCreated(r10);
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onActivityPause(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        this.topActivityRef = new WeakReference(r10);
        this.topActivityClassName = null;
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onActivityResume(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        ((IActivityLifecycleObserver) r11[r13]).onActivityStarted(r10);
        r13 = r13 + 1;
        goto L3
    L6:
        if (this.changingConfigActivity == false) goto L9;
        this.changingConfigActivity = false;
        return;
    L9:
        int r14 = this.frontActivityCount + 1;
        this.frontActivityCount = r14;
        if (r14 != 1) goto L14;
        this.isFront = true;
        notifyFront(r10);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        if (r10.isChangingConfigurations() == false) goto L6;
        this.changingConfigActivity = true;
        return;
    L6:
        int r11 = this.frontActivityCount - 1;
        this.frontActivityCount = r11;
        if (r11 != 0) goto L10;
        this.isFront = false;
        notifyBackground(r10);
        return;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void register(IActivityLifecycleObserver r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList<IActivityLifecycleObserver> r11 = this.observers;
        monitor-enter(r11);
        this.observers.add(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void unregister(IActivityLifecycleObserver r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList<IActivityLifecycleObserver> r11 = this.observers;
        monitor-enter(r11);
        this.observers.remove(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
