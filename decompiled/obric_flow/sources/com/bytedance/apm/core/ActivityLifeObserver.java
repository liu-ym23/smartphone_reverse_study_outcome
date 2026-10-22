package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import androidx.annotation.NonNull;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.obric.oui.dialog.base.i;
import d6.b;
import g6.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import oj.c;

/* JADX INFO: loaded from: classes2.dex */
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
        ArrayList<c> r5 = this.mObservers;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.size() <= 0) goto L9;
        Object[] r10 = this.mObservers.toArray();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r5);     // Catch: Throwable -> L7
        if (r10 == null) goto L13;
        return r10;
    L13:
        return new Object[0];
    L9:
        r10 = null;
        goto L10
    }

    private String getActivityHash(Activity r5) {
        return r5.getClass().getName() + r5.hashCode();
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    public static void init(Application r5) {
        mInstance.initWithApp(r5);
    }

    private void initWithApp(@NonNull Application r5) {
        if (r5 == null) goto L5;
        r5.unregisterActivityLifecycleCallbacks(this);
        r5.registerActivityLifecycleCallbacks(this);
        return;
    }

    private void notifyBackground(Activity r5) {
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((c) r10[r12]).f(r5);
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator<a> r13 = this.mLifecycleObservers.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r13.next().getClass();
        goto L7
    }

    private void notifyFront(Activity r5) {
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((c) r10[r12]).c(r5);
        r12 = r12 + 1;
        goto L3
    L5:
        Iterator<a> r13 = this.mLifecycleObservers.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r13.next().getClass();
        goto L7
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> r5 = this.mTopActivityRef;
        if (r5 != null) goto L5;
        return "";
    L5:
        Activity r10 = r5.get();
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
    public void onActivityCreated(Activity r10, Bundle r11) {
        Object[] r5 = collectObservers();
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((c) r5[r13]).getClass();
        r13 = r13 + 1;
        goto L3
    L5:
        Iterator<a> r14 = this.mLifecycleObservers.iterator();
    L7:
        if (r14.hasNext() == false) goto L19;
        d6.c r15 = (d6.c) r14.next();
        r15.getClass();
        Window r16 = r10.getWindow();     // Catch: Exception -> L20
        r16.setCallback(new i(r15, r16.getCallback()));     // Catch: Exception -> L20
        String r17 = r10.getClass().getName();     // Catch: Exception -> L20
        String r18 = r10.toString();     // Catch: Exception -> L20
        if (jg.i.f18332a == false) goto L13;
        boolean r19 = jg.i.f18332a;     // Catch: Exception -> L20
        d6.c.f16598k.getClass();     // Catch: Exception -> L20
    L13:
        if (((Handler) r15.f16602h.f23410a) == null) goto L15;
        boolean r20 = true;
    L16:
        if (r20 == false) goto L7;
        b r21 = new b(r15, r17);     // Catch: Exception -> L20
        r15.f16603i.put(r18, r21);     // Catch: Exception -> L20
        r16.addOnFrameMetricsAvailableListener(r21, (Handler) r15.f16602h.f23410a);     // Catch: Exception -> L20
        goto L7
    L15:
        r20 = false;
        goto L16
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r5) {
        if (getActivityHash(r5).equals(this.mCurActivityHash) == false) goto L5;
        this.mCurActivityHash = null;
    L5:
        Iterator<a> r10 = this.mLifecycleObservers.iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        d6.c r11 = (d6.c) r10.next();
        r11.getClass();
        Window.OnFrameMetricsAvailableListener r12 = (Window.OnFrameMetricsAvailableListener) r11.f16603i.remove(r5.toString());     // Catch: Exception -> L14
        if (r12 == null) goto L7;
        r5.getWindow().removeOnFrameMetricsAvailableListener(r12);     // Catch: Exception -> L14
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r5) {
        Object[] r10 = collectObservers();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((c) r10[r12]).getClass();
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        this.mTopActivityRef = new WeakReference(r10);
        this.mTopActivityClassName = null;
        Object[] r5 = collectObservers();
        int r11 = r5.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        ((c) r5[r13]).b(r10);
        r13 = r13 + 1;
        goto L3
    L5:
        String r14 = getActivityHash(r10);
        if (r14.equals(this.mCurActivityHash) == true) goto L14;
        int r15 = r5.length;
    L8:
        if (r12 >= r15) goto L10;
        ((c) r5[r12]).getClass();
        r12 = r12 + 1;
        goto L8
    L10:
        this.mCurActivityHash = r14;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r5, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        Object[] r5 = collectObservers();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        ((c) r5[r12]).getClass();
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
        notifyFront(r10);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r5) {
        if (r5.isChangingConfigurations() == false) goto L6;
        this.mChangingConfigActivity = true;
        return;
    L6:
        int r10 = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = r10;
        if (r10 != 0) goto L10;
        this.mIsFrontV2 = false;
        notifyBackground(r5);
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(c r5) {
        ArrayList<c> r10 = this.mObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mObservers.add(r5);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(c r5) {
        ArrayList<c> r10 = this.mObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mObservers.remove(r5);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(a r5) {
        ArrayList<a> r10 = this.mLifecycleObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mLifecycleObservers.add(r5);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregister(a r5) {
        ArrayList<a> r10 = this.mLifecycleObservers;
        if (r10 == null) goto L11;
        monitor-enter(r10);
        this.mLifecycleObservers.remove(r5);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
