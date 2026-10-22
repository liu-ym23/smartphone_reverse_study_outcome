package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakHandler f2289b;
    private List<a> c;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f2291b;

        public a() {
            this.f2290a = LocationInfoConst.HALF_MINUTES;
            this.f2291b = new AnonymousClass1(this);
        }

        public a(int r2) {
            this.f2290a = LocationInfoConst.HALF_MINUTES;
            this.f2291b = new AnonymousClass1(this);
            this.f2290a = r2;
        }

        public Runnable a() {
            return this.f2291b;
        }

        public void a(int r1) {
            this.f2290a = r1;
        }

        public int b() {
            return this.f2290a;
        }

        public abstract void c();

        public abstract void d();
    }

    static {
        f2289b = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public b() {
        this.c = new CopyOnWriteArrayList();
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) == null) goto L6;
        f2288a = true;
        return;
    }

    static /* synthetic */ boolean a() {
        return f2288a;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f2288a = r0;
        return r0;
    }

    private static Activity getActivity() {
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

    public void a(a r1) {
        this.c.add(r1);
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
    public void onActivityPaused(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        if (f2288a == false) goto L8;
        Iterator<a> r5 = this.c.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin");
        f2289b.postDelayed(r8.a(), r8.b());
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (f2288a == true) goto L8;
        f2288a = true;
        Iterator<a> r2 = this.c.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).c();
    L8:
        f2289b.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }
}
