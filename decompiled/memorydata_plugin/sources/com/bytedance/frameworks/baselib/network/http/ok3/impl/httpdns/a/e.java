package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakHandler f2482b;
    private a c;
    private Runnable d;

    public interface a {
        void a();

        void b();
    }

    static {
        f2482b = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public e() {
        this.d = new AnonymousClass2(this);
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) == null) goto L6;
        f2481a = true;
        return;
    }

    static /* synthetic */ a a(e r0) {
        return r0.c;
    }

    static /* synthetic */ boolean a() {
        return f2481a;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f2481a = r0;
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

    public void a(a r3) {
        this.c = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
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
        if (f2481a == false) goto L6;
        f2482b.postDelayed(this.d, 30000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (f2481a == true) goto L7;
        f2481a = true;
        a r5 = this.c;
        if (r5 == null) goto L7;
        r5.a();
    L7:
        f2482b.removeCallbacks(this.d);
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
