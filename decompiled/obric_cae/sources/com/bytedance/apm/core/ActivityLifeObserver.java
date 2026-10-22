package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.services.apm.api.IActivityLifeManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import l2.a;
import u8.c;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks, IActivityLifeManager {
    private static final long CHECK_DELAY = 600;
    private static final String TAG = "ActivityLifeObserver";
    private static final ActivityLifeObserver mInstance = null;
    private boolean mChangingConfigActivity;
    private String mCurActivityHash;
    private int mFrontActivityCount;
    private volatile boolean mIsFrontV2;
    private ArrayList<a> mLifecycleObservers;
    private ArrayList<c> mObservers;
    private String mTopActivityClassName;
    private WeakReference<Activity> mTopActivityRef;

    static {
        mInstance = new ActivityLifeObserver();
    }

    private ActivityLifeObserver() {
        this.mObservers = new ArrayList(8);
        this.mLifecycleObservers = new ArrayList(8);
        this.mTopActivityClassName = null;
    }

    private Object[] collectObservers() {
        ArrayList<c> r8 = this.mObservers;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.size() <= 0) goto L7;
        Object[] r10 = this.mObservers.toArray();     // Catch: Throwable -> L12
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L12
        if (r10 == null) goto L11;
        return r10;
    L11:
        return new Object[0];
    L7:
        r10 = null;
        goto L8
    }

    private String getActivityHash(Activity r8) {
        return r8.getClass().getName() + r8.hashCode();
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    public static void init(Application r8) {
        mInstance.initWithApp(r8);
    }

    private void initWithApp(Application r8) {
        if (r8 == null) goto L5;
        r8.unregisterActivityLifecycleCallbacks(this);
        r8.registerActivityLifecycleCallbacks(this);
        return;
    }

    private void notifyBackground(Activity r8) {
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((c) r10[r12]).e(r8);
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator<a> r13 = this.mLifecycleObservers.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r13.next().b();
        goto L7
    }

    private void notifyFront(Activity r8) {
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((c) r10[r12]).d(r8);
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator<a> r13 = this.mLifecycleObservers.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r13.next().a();
        goto L7
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> r8 = this.mTopActivityRef;
        if (r8 != null) goto L5;
        return "";
    L5:
        Activity r10 = r8.get();
        if (r10 == null) goto L11;
        String r11 = this.mTopActivityClassName;
        if (r11 == null) goto L10;
        return r11;
    L10:
        return r10.getClass().getName();
    L11:
        return "";
    }

    public WeakReference<Activity> getTopActivityRef() {
        return this.mTopActivityRef;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public boolean isForeground() {
        return this.mIsFrontV2;
    }

    public boolean isV2Foreground() {
        return this.mIsFrontV2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r8, Bundle r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((c) r11[r13]).g();
        r13 = r13 + 1;
        goto L3
    L5:
        Iterator<a> r14 = this.mLifecycleObservers.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        r14.next().c(r8);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r8) {
        if (getActivityHash(r8).equals(this.mCurActivityHash) == false) goto L5;
        this.mCurActivityHash = null;
    L5:
        Iterator<a> r10 = this.mLifecycleObservers.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().onActivityDestroyed(r8);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r8) {
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((c) r10[r12]).f();
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r8) {
        this.mTopActivityRef = new WeakReference(r8);
        this.mTopActivityClassName = null;
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        ((c) r10[r13]).c(r8);
        r13 = r13 + 1;
        goto L3
    L5:
        String r14 = getActivityHash(r8);
        if (r14.equals(this.mCurActivityHash) == true) goto L14;
        int r15 = r10.length;
    L8:
        if (r12 >= r15) goto L10;
        ((c) r10[r12]).a();
        r12 = r12 + 1;
        goto L8
    L10:
        this.mCurActivityHash = r14;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r8) {
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        ((c) r10[r12]).b();
        r12 = r12 + 1;
        goto L3
    L6:
        if (this.mChangingConfigActivity == false) goto L9;
        this.mChangingConfigActivity = false;
        return;
    L9:
        int r13 = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = r13;
        if (r13 != 1) goto L14;
        this.mIsFrontV2 = true;
        notifyFront(r8);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r8) {
        if (r8.isChangingConfigurations() == false) goto L6;
        this.mChangingConfigActivity = true;
        return;
    L6:
        int r10 = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = r10;
        if (r10 != 0) goto L10;
        this.mIsFrontV2 = false;
        notifyBackground(r8);
        return;
    }

    public void register(a r8) {
        ArrayList<a> r10 = this.mLifecycleObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mLifecycleObservers.add(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregister(a r8) {
        ArrayList<a> r10 = this.mLifecycleObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mLifecycleObservers.remove(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(c r8) {
        ArrayList<c> r10 = this.mObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mObservers.add(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(c r8) {
        ArrayList<c> r10 = this.mObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mObservers.remove(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
