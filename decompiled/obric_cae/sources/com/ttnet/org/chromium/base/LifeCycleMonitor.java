package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static final int ENTER_BACKGROUND_DELAY_TIME = 30000;
    private static final String TAG = "LifeCycleMonitor";
    private static boolean mAppAlive;
    private static WeakHandler sHandler;
    private int mActivityCount;
    private AppStateListener mListener;
    private Runnable mRunnable;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();

        void onInstantEnterToBackground();

        void onInstantEnterToForeground();
    }

    static {
        sHandler = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public LifeCycleMonitor() {
        this.mRunnable = new AnonymousClass2(this);
        if (getActivity() == null) goto L5;
        mAppAlive = true;
    L5:
        this.mActivityCount = 0;
        List<Activity> r8 = getAllActivities();
        if (r8 == null) goto L9;
        this.mActivityCount = r8.size();
        return;
    }

    public static /* synthetic */ boolean access$000() {
        return mAppAlive;
    }

    public static /* synthetic */ boolean access$002(boolean r8) {
        mAppAlive = r8;
        return r8;
    }

    public static /* synthetic */ AppStateListener access$100(LifeCycleMonitor r8) {
        return r8.mListener;
    }

    public static Activity getActivity() {
        Class<?> r8 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L14
        Object r10 = r8.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r11 = r8.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r11.setAccessible(true);     // Catch: Throwable -> L14
        Map r12 = (Map) r11.get(r10);     // Catch: Throwable -> L14
        if (r12 != null) goto L6;
        return null;
    L6:
        Iterator r13 = r12.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();     // Catch: Throwable -> L14
        Class<?> r15 = r14.getClass();     // Catch: Throwable -> L14
        Field r16 = r15.getDeclaredField("paused");     // Catch: Throwable -> L14
        r16.setAccessible(true);     // Catch: Throwable -> L14
        if (r16.getBoolean(r14) == true) goto L8;
        Field r17 = r15.getDeclaredField("activity");     // Catch: Throwable -> L14
        r17.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r17.get(r14);
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static List<Activity> getAllActivities() {
        ArrayList r8 = new ArrayList();
        Class<?> r10 = Class.forName("android.app.ActivityThread");     // Catch: Exception -> L12
        Method r11 = r10.getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Exception -> L12
        r11.setAccessible(true);     // Catch: Exception -> L12
        Object r12 = r11.invoke(null, new Object[0]);     // Catch: Exception -> L12
        Field r13 = r10.getDeclaredField("mActivities");     // Catch: Exception -> L12
        r13.setAccessible(true);     // Catch: Exception -> L12
        Map r14 = (Map) r13.get(r12);     // Catch: Exception -> L12
        if (r14 != null) goto L6;
        return null;
    L6:
        Iterator r15 = r14.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r15.hasNext() == false) goto L11;
        Object r16 = ((Map.Entry) r15.next()).getValue();     // Catch: Exception -> L12
        Field r17 = r16.getClass().getDeclaredField("activity");     // Catch: Exception -> L12
        r17.setAccessible(true);     // Catch: Exception -> L12
        r8.add((Activity) r17.get(r16));     // Catch: Exception -> L12
        goto L8
    L11:
        return r8;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r8) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r8) {
        if (mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, 30000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r8) {
        if (mAppAlive == true) goto L7;
        mAppAlive = true;
        AppStateListener r10 = this.mListener;
        if (r10 == null) goto L7;
        r10.onEnterToForeground();
    L7:
        sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r8, Bundle r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r8) {
        if (this.mActivityCount != 0) goto L7;
        AppStateListener r10 = this.mListener;
        if (r10 == null) goto L7;
        r10.onInstantEnterToForeground();
    L7:
        this.mActivityCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r8) {
        int r10 = this.mActivityCount - 1;
        this.mActivityCount = r10;
        if (r10 != 0) goto L8;
        AppStateListener r11 = this.mListener;
        if (r11 == null) goto L9;
        r11.onInstantEnterToBackground();
        return;
    L9:
        return;
    }

    public void setAppStateChangedListener(AppStateListener r8) {
        this.mListener = r8;
    }
}
