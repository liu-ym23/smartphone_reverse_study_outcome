package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks, IActivityLifeManager {
    private static final long CHECK_DELAY = 600;
    private static final String TAG = "ActivityLifeObserver";
    private static final ActivityLifeObserver mInstance = null;
    private boolean mChangingConfigActivity;
    private String mCurActivityHash;
    private int mFrontActivityCount;
    private volatile boolean mIsFrontV2;
    private ArrayList<c> mLifecycleObservers;
    private ArrayList<com.bytedance.services.apm.api.d> mObservers;
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
        ArrayList<com.bytedance.services.apm.api.d> r0 = this.mObservers;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.size() <= 0) goto L7;
        Object[] r2 = this.mObservers.toArray();     // Catch: Throwable -> L12
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

    private String getActivityHash(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        return r1.getClass().getName() + r1.hashCode();
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    public static void init(Application r2) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        mInstance.initWithApp(r3);
    }

    private void initWithApp(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        r4.unregisterActivityLifecycleCallbacks(this);
        r4.registerActivityLifecycleCallbacks(this);
        return;
    }

    private void notifyBackground(Activity r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
        Object[] r0 = collectObservers();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        ((com.bytedance.services.apm.api.d) ZeusTransformUtils.preCheckCast(r0[r3], com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin")).a(r8);
        r3 = r3 + 1;
        goto L3
    L5:
        Iterator<c> r6 = this.mLifecycleObservers.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin")).b(r8);
        goto L7
    }

    private void notifyFront(Activity r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
        Object[] r0 = collectObservers();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        ((com.bytedance.services.apm.api.d) ZeusTransformUtils.preCheckCast(r0[r3], com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin")).b(r8);
        r3 = r3 + 1;
        goto L3
    L5:
        Iterator<c> r6 = this.mLifecycleObservers.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin")).a(r8);
        goto L7
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> r0 = this.mTopActivityRef;
        if (r0 != null) goto L5;
        return "";
    L5:
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0.get(), Activity.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        String r4 = this.mTopActivityClassName;
        if (r4 == null) goto L10;
        return r4;
    L10:
        return r1.getClass().getName();
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
    public void onActivityCreated(Activity r7, Bundle r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
        Object[] r0 = collectObservers();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        ((com.bytedance.services.apm.api.d) ZeusTransformUtils.preCheckCast(r0[r3], com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin")).a(r9, r8);
        r3 = r3 + 1;
        goto L3
    L5:
        Iterator<c> r6 = this.mLifecycleObservers.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin")).a(r9, r8);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        if (getActivityHash(r5).equals(this.mCurActivityHash) == false) goto L5;
        this.mCurActivityHash = null;
    L5:
        Iterator<c> r3 = this.mLifecycleObservers.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.memorydata.plugin")).c(r5);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((com.bytedance.services.apm.api.d) ZeusTransformUtils.preCheckCast(r5[r2], com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin")).d(r7);
        r2 = r2 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r9) {
        Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r9, Activity.class, "com.obric.memorydata.plugin");
        this.mTopActivityRef = new WeakReference(r10);
        this.mTopActivityClassName = null;
        Object[] r2 = collectObservers();
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        ((com.bytedance.services.apm.api.d) ZeusTransformUtils.preCheckCast(r2[r5], com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin")).c(r10);
        r5 = r5 + 1;
        goto L3
    L5:
        Iterator<c> r6 = this.mLifecycleObservers.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin")).d(r10);
        goto L7
    L9:
        String r7 = getActivityHash(r10);
        if (r7.equals(this.mCurActivityHash) == true) goto L19;
        int r8 = r2.length;
    L12:
        if (r4 >= r8) goto L14;
        ((com.bytedance.services.apm.api.d) ZeusTransformUtils.preCheckCast(r2[r4], com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin")).a(r10, null);
        r4 = r4 + 1;
        goto L12
    L14:
        this.mCurActivityHash = r7;
        return;
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
        ((com.bytedance.services.apm.api.d) ZeusTransformUtils.preCheckCast(r0[r4], com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin")).e(r9);
        r4 = r4 + 1;
        goto L3
    L6:
        if (this.mChangingConfigActivity == false) goto L9;
        this.mChangingConfigActivity = false;
        return;
    L9:
        int r1 = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = r1;
        if (r1 != 1) goto L14;
        this.mIsFrontV2 = true;
        notifyFront(r9);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (r4.isChangingConfigurations() == false) goto L6;
        this.mChangingConfigActivity = true;
        return;
    L6:
        int r0 = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = r0;
        if (r0 != 0) goto L10;
        this.mIsFrontV2 = false;
        notifyBackground(r4);
        return;
    }

    public void register(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        ArrayList<c> r0 = this.mLifecycleObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mLifecycleObservers.add(r4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(com.bytedance.services.apm.api.d r3) {
        com.bytedance.services.apm.api.d r4 = (com.bytedance.services.apm.api.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin");
        ArrayList<com.bytedance.services.apm.api.d> r0 = this.mObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mObservers.add(r4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregister(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        ArrayList<c> r0 = this.mLifecycleObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mLifecycleObservers.remove(r4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(com.bytedance.services.apm.api.d r3) {
        com.bytedance.services.apm.api.d r4 = (com.bytedance.services.apm.api.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.services.apm.api.d.class, "com.obric.memorydata.plugin");
        ArrayList<com.bytedance.services.apm.api.d> r0 = this.mObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mObservers.remove(r4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
