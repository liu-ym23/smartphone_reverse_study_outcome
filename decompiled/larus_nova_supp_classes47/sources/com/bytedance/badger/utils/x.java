package com.bytedance.badger.utils;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x {
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;
    public final Context a;
    public final Handler b;
    public final ExecutorService c;

    static {
        BadgerCore.Companion.getClass();
        d = com.bytedance.badger.j.b(1950707304799506855L);
        e = com.bytedance.badger.j.b(2808155107469694167L);
        f = com.bytedance.badger.j.b(4654826111501568837L);
        g = com.bytedance.badger.j.b(1601638077316868688L);
        h = com.bytedance.badger.j.b(3359762759185814791L);
        i = com.bytedance.badger.j.b(422619849029467889L);
    }

    public x(Context r1, Handler r2) {
        this.a = r1;
        this.b = r2;
        this.c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("adger/utils/m"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.badger.utils.q, java.lang.Runnable] */
    public final void b(final com.bytedance.badger.z.g0 r12) {
        final AtomicBoolean r6 = new AtomicBoolean(false);
        com.bytedance.badger.e.f("OppoIDHelper", "fetch# start thread=" + ThreadMethodProxy.currentThread().getName());
        final ?? r7 = new q(this, r6, r12);
        final j r8 = new j(this, this.b, r6, r7, r12);
        this.b.postDelayed(r7, 15000);
        this.c.execute(new u(this, r8, r6, r12, r7));
    }

    public final void c(AtomicBoolean r3, final o r4, final p r5, Runnable r6) {
        if (r3.compareAndSet(false, true) == true) goto L6;
        com.bytedance.badger.e.g("OppoIDHelper", "postError# ignored (already completed), code=" + r5.a);
        return;
    L6:
        if (r6 == null) goto L8;
        this.b.removeCallbacks(r6);
    L8:
        this.b.post(new v(r4, r5));
    }

    public final void d() {
        this.c.shutdownNow();
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(IBinder r13, Parcel r14, Parcel r15) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r13.transact(1, r14, r15, 0);
        return;
    L6:
        long r1 = SystemClock.uptimeMillis();
        r13.transact(1, r14, r15, 0);     // Catch: Throwable -> L12
        long r7 = SystemClock.uptimeMillis() - r1;
        if (r7 < 100) goto L19;
        BinderPerformanceReporter.report(r7, r13.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L19:
        return;
    L12:
        th = move-exception;
        long r8 = SystemClock.uptimeMillis() - r1;
        if (r8 < 100) goto L16;
        BinderPerformanceReporter.report(r8, r13.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
    L16:
        throw th;
    }
}
