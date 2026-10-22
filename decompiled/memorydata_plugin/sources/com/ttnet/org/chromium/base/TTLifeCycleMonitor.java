package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class TTLifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static final int ENTER_BACKGROUND_DELAY_TIME = 30000;
    private static final String TAG = "TTLifeCycleMonitor";
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
        sHandler = new TTWeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public TTLifeCycleMonitor() {
        this.mRunnable = new AnonymousClass2(this);
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) == null) goto L5;
        mAppAlive = true;
    L5:
        this.mActivityCount = 0;
        List<Activity> r0 = getAllActivities();
        if (r0 == null) goto L9;
        this.mActivityCount = r0.size();
        return;
    }

    static /* synthetic */ boolean access$000() {
        return mAppAlive;
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        mAppAlive = r0;
        return r0;
    }

    static /* synthetic */ AppStateListener access$100(TTLifeCycleMonitor r0) {
        return r0.mListener;
    }

    public static Activity getActivity() {
        Class r2 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r3 = r2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r4 = r2.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r4.setAccessible(true);     // Catch: Throwable -> L14
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r4.get(r3), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r5 != null) goto L6;
        return null;
    L6:
        Iterator r6 = r5.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();     // Catch: Throwable -> L14
        Class<?> r8 = r7.getClass();     // Catch: Throwable -> L14
        Field r9 = r8.getDeclaredField("paused");     // Catch: Throwable -> L14
        r9.setAccessible(true);     // Catch: Throwable -> L14
        if (r9.getBoolean(r7) == true) goto L8;
        Field r10 = r8.getDeclaredField("activity");     // Catch: Throwable -> L14
        r10.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) ZeusTransformUtils.preCheckCast(r10.get(r7), Activity.class, "com.obric.memorydata.plugin");
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static List<Activity> getAllActivities() {
        ArrayList r1 = new ArrayList();
        Class r3 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        Method r4 = r3.getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Exception -> L12
        r4.setAccessible(true);     // Catch: Exception -> L12
        Object r5 = r4.invoke(null, new Object[0]);     // Catch: Exception -> L12
        Field r6 = r3.getDeclaredField("mActivities");     // Catch: Exception -> L12
        r6.setAccessible(true);     // Catch: Exception -> L12
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r6.get(r5), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        if (r7 != null) goto L6;
        return null;
    L6:
        Iterator r8 = r7.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r8.hasNext() == false) goto L11;
        Object r9 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue();     // Catch: Exception -> L12
        Field r10 = r9.getClass().getDeclaredField("activity");     // Catch: Exception -> L12
        r10.setAccessible(true);     // Catch: Exception -> L12
        r1.add((Activity) ZeusTransformUtils.preCheckCast(r10.get(r9), Activity.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L12
        goto L8
    L11:
        return r1;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, 30000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (mAppAlive == true) goto L7;
        mAppAlive = true;
        AppStateListener r5 = this.mListener;
        if (r5 == null) goto L7;
        r5.onEnterToForeground();
    L7:
        sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (this.mActivityCount != 0) goto L7;
        AppStateListener r5 = this.mListener;
        if (r5 == null) goto L7;
        r5.onInstantEnterToForeground();
    L7:
        this.mActivityCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        int r5 = this.mActivityCount - 1;
        this.mActivityCount = r5;
        if (r5 != 0) goto L8;
        AppStateListener r2 = this.mListener;
        if (r2 == null) goto L9;
        r2.onInstantEnterToBackground();
        return;
    L9:
        return;
    }

    public void setAppStateChangedListener(AppStateListener r3) {
        this.mListener = (AppStateListener) ZeusTransformUtils.wrapperContextForParams(r3, AppStateListener.class, "com.obric.memorydata.plugin");
    }
}
