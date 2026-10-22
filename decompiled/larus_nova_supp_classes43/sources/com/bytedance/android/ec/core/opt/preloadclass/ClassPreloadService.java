package com.bytedance.android.ec.core.opt.preloadclass;

import android.os.Handler;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ClassPreloadService implements com.bytedance.android.ec.sdk.plugin.c {
    public final Lazy a;
    public int b;

    public static final class a implements Runnable {
        public final /* synthetic */ ClassPreloadService a;
        public final /* synthetic */ int b;

        public a(ClassPreloadService r1, int r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            dm.a.b r1 = dm.a.a;
            this.a.getClass();
            dm.a.a("ClassPreloadService").i("realPreload: 阶段" + this.b + " 开始 " + this.a.getClass().getClassLoader());
            long r10 = System.currentTimeMillis();
            this.a.getClass();     // Catch: Exception -> L5
            dm.a.a("ClassPreloadService").i("realPreload: 阶段" + this.b + " class数量0 耗时" + (System.currentTimeMillis() - r10));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            dm.a.b r11 = dm.a.a;
            this.a.getClass();
            dm.a.a("ClassPreloadService").b("realPreload: " + this.b + ' ' + e.getMessage(), null);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ClassPreloadService a;

        public b(ClassPreloadService r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClassPreloadService.c(this.a, 2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ClassPreloadService a;

        public c(ClassPreloadService r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClassPreloadService.c(this.a, 1);     // Catch: Throwable -> L6
            this.a.getClass();     // Catch: Throwable -> L6
            if (ClassPreloadService.e() != 1) goto L9;
            ClassPreloadService.c(this.a, 2);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ClassPreloadService a;

        public d(ClassPreloadService r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClassPreloadService.c(this.a, 2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static int e() {
        int r0 = ECSdk.a;
        g r1 = (g) ECSdk.a(g.class);
        if (r1 == null) goto L7;
        s83.a r10 = r1.q();
        if (r10 == null) goto L7;
        return r10.c();
    L7:
        return 0;
    }

    public final void a() {
        dm.a.a("ClassPreloadService").i("preloadClassOnScene: 实验value " + e());
        if (d() == true) goto L7;
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: plugin not ready");
        return;
    L7:
        if (e() != 3) goto L10;
        ((Handler) this.a.getValue()).postDelayed(new b(this), 3000);
        return;
    }

    public final synchronized void b() {
        monitor-enter(this);
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: 实验value " + e());     // Catch: Throwable -> L17
        if (d() == true) goto L10;
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: plugin not ready");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        if (e() == 0) goto L13;
        ((Handler) this.a.getValue()).postDelayed(new c(this), 5000);     // Catch: Throwable -> L17
    L13:
        if (e() != 2) goto L15;
        ((Handler) this.a.getValue()).postDelayed(new d(this), 15000);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public ClassPreloadService() {
        this.a = LazyKt.lazy(ClassPreloadService$handler$2.INSTANCE);
    }

    public static boolean d() {
        if (e.a() == false) goto L16;
        boolean r0 = ECServiceManager.a;
        hj.c r1 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r1 != null) goto L7;
        boolean r10 = false;
    L8:
        if (r10 == false) goto L17;
        hj.c r11 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r11 != null) goto L12;
        boolean r12 = false;
    L13:
        if (r12 == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        r12 = r11.c();
        goto L13
    L17:
        return false;
    L7:
        r10 = r1.b();
        goto L8
    L16:
        return false;
    }

    public final synchronized void f(int r10) {
        monitor-enter(this);
        this.b |= r10;     // Catch: Throwable -> L6
        ThreadPlus.submitRunnable(new a(this, r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static final void c(ClassPreloadService r10, int r11) {
        monitor-enter(r10);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (d() == true) goto L9;
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: plugin not ready");     // Catch: Throwable -> L32
        monitor-exit(r10);
        return;
    L9:
        dm.a.a("ClassPreloadService").i("tryPreload: 实验value " + e());     // Catch: Throwable -> L32
        boolean r0 = false;
        if (r11 != 1) goto L18;
        if ((r10.b & 1) <= 0) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == true) goto L18;
        r10.f(1);     // Catch: Throwable -> L32
        goto L18
    L14:
        r12 = false;
    L18:
        if (r11 != 2) goto L30;
        int r13 = r10.b;     // Catch: Throwable -> L32
        if ((r13 & 2) <= 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == true) goto L30;
        if ((r13 & 1) <= 0) goto L27;
        r0 = true;
    L27:
        if (r0 == true) goto L29;
        ((Handler) r10.a.getValue()).removeCallbacksAndMessages(null);     // Catch: Throwable -> L32
        r10.f(1);     // Catch: Throwable -> L32
        ((Handler) r10.a.getValue()).postDelayed(new com.bytedance.android.ec.core.opt.preloadclass.a(r10), 2000);     // Catch: Throwable -> L32
        goto L30
    L29:
        r10.f(2);     // Catch: Throwable -> L32
        goto L30
    L22:
        r14 = false;
    L30:
        monitor-exit(r10);
    }
}
