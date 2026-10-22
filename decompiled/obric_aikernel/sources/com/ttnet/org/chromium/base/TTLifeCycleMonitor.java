package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import androidx.work.WorkRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTLifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static final int ENTER_BACKGROUND_DELAY_TIME = 30000;
    private static final String TAG = null;
    private static boolean mAppAlive;
    private static TTWeakHandler sHandler;
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
        TAG = TTLifeCycleMonitor.class.getSimpleName();
        sHandler = new TTWeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public TTLifeCycleMonitor() {
        this.mRunnable = new AnonymousClass2(this);
        if (getActivity() == null) goto L5;
        mAppAlive = true;
    L5:
        this.mActivityCount = 0;
        List<Activity> r10 = getAllActivities();
        if (r10 == null) goto L9;
        this.mActivityCount = r10.size();
        return;
    }

    static /* synthetic */ boolean access$000() {
        return mAppAlive;
    }

    static /* synthetic */ boolean access$002(boolean r10) {
        mAppAlive = r10;
        return r10;
    }

    static /* synthetic */ AppStateListener access$100(TTLifeCycleMonitor r10) {
        return r10.mListener;
    }

    public static Activity getActivity() {
        Class<?> r10 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L14
        Object r11 = r10.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r12 = r10.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r12.setAccessible(true);     // Catch: Throwable -> L14
        Map r13 = (Map) r12.get(r11);     // Catch: Throwable -> L14
        if (r13 != null) goto L6;
        return null;
    L6:
        Iterator r14 = r13.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();     // Catch: Throwable -> L14
        Class<?> r16 = r15.getClass();     // Catch: Throwable -> L14
        Field r17 = r16.getDeclaredField("paused");     // Catch: Throwable -> L14
        r17.setAccessible(true);     // Catch: Throwable -> L14
        if (r17.getBoolean(r15) == true) goto L8;
        Field r18 = r16.getDeclaredField("activity");     // Catch: Throwable -> L14
        r18.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r18.get(r15);
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static List<Activity> getAllActivities() {
        ArrayList r10 = new ArrayList();
        Class<?> r11 = Class.forName("android.app.ActivityThread");     // Catch: Exception -> L12
        Method r12 = r11.getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Exception -> L12
        r12.setAccessible(true);     // Catch: Exception -> L12
        Object r13 = r12.invoke(null, new Object[0]);     // Catch: Exception -> L12
        Field r14 = r11.getDeclaredField("mActivities");     // Catch: Exception -> L12
        r14.setAccessible(true);     // Catch: Exception -> L12
        Map r15 = (Map) r14.get(r13);     // Catch: Exception -> L12
        if (r15 != null) goto L6;
        return null;
    L6:
        Iterator r16 = r15.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r16.hasNext() == false) goto L11;
        Object r17 = ((Map.Entry) r16.next()).getValue();     // Catch: Exception -> L12
        Field r18 = r17.getClass().getDeclaredField("activity");     // Catch: Exception -> L12
        r18.setAccessible(true);     // Catch: Exception -> L12
        r10.add((Activity) r18.get(r17));     // Catch: Exception -> L12
        goto L8
    L11:
        return r10;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (mAppAlive == true) goto L7;
        mAppAlive = true;
        AppStateListener r11 = this.mListener;
        if (r11 == null) goto L7;
        r11.onEnterToForeground();
    L7:
        sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        if (this.mActivityCount != 0) goto L7;
        AppStateListener r11 = this.mListener;
        if (r11 == null) goto L7;
        r11.onInstantEnterToForeground();
    L7:
        this.mActivityCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        int r11 = this.mActivityCount - 1;
        this.mActivityCount = r11;
        if (r11 != 0) goto L8;
        AppStateListener r12 = this.mListener;
        if (r12 == null) goto L9;
        r12.onInstantEnterToBackground();
        return;
    L9:
        return;
    }

    public void setAppStateChangedListener(AppStateListener r10) {
        this.mListener = r10;
    }
}
