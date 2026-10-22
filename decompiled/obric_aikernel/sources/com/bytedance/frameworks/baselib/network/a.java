package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakHandler f1551d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<b> f1552b;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.a$a, reason: collision with other inner class name */
    class C0052a implements WeakHandler.IHandler {
        C0052a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r10) {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f1554b;

        /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.a$b$a, reason: collision with other inner class name */
        class RunnableC0053a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f1555c;

            RunnableC0053a(b r10) {
                this.f1555c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.a() == false) goto L6;
                a.b(false);
                this.f1555c.c();
                return;
            }
        }

        public b() {
            this.f1553a = 30000;
            this.f1554b = new RunnableC0053a(this);
        }

        public b(int r10) {
            this.f1553a = 30000;
            this.f1554b = new RunnableC0053a(this);
            this.f1553a = r10;
        }

        public Runnable a() {
            return this.f1554b;
        }

        public int b() {
            return this.f1553a;
        }

        public abstract void c();

        public abstract void d();

        public void e(int r10) {
            this.f1553a = r10;
        }
    }

    static {
        f1551d = new WeakHandler(Looper.getMainLooper(), new C0052a());
    }

    public a() {
        this.f1552b = new CopyOnWriteArrayList();
        if (d() == null) goto L6;
        f1550c = true;
        return;
    }

    static /* synthetic */ boolean a() {
        return f1550c;
    }

    static /* synthetic */ boolean b(boolean r10) {
        f1550c = r10;
        return r10;
    }

    private static Activity d() {
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

    public void c(b r10) {
        this.f1552b.add(r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (f1550c == false) goto L8;
        Iterator<b> r11 = this.f1552b.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        b r12 = r11.next();
        f1551d.postDelayed(r12.a(), r12.b());
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (f1550c == true) goto L8;
        f1550c = true;
        Iterator<b> r11 = this.f1552b.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().d();
    L8:
        f1551d.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
    }
}
