package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public static final Executor a = null;
    private static Object b;
    private static Handler c;
    private static HandlerThread d;

    /* JADX INFO: renamed from: com.tencent.open.utils.l$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        public synchronized void a() {
            monitor-enter(this);
            Runnable r0 = this.a.poll();     // Catch: Throwable -> L8
            this.b = r0;     // Catch: Throwable -> L8
            if (r0 == null) goto L6;
            l.a.execute(r0);     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private a() {
            this.a = new LinkedList();
        }

        public /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable r3) {
            monitor-enter(this);
            this.a.offer(new AnonymousClass1(this, r3));     // Catch: Throwable -> L8
            if (this.b != null) goto L6;
            a();     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public l() {
    }

    static {
        b = new Object();
        a = c();
    }

    public static Handler a() {
        if (c != null) goto L13;
        monitor-enter(l.class);
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("SDK_SUB");     // Catch: Throwable -> L9
        d = r1;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(r1);     // Catch: Throwable -> L9
        c = new Handler(d.getLooper());     // Catch: Throwable -> L9
        monitor-exit(l.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return c;
    }

    public static Executor b() {
        return new a(null);
    }

    private static Executor c() {
        return new PThreadPoolExecutor(0, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("/open/utils/l"));
    }

    public static void a(Runnable r1) {
        a.execute(r1);     // Catch: RejectedExecutionException -> L4
        return;
    }

    public static void b(Runnable r1) {
        a().post(r1);
    }
}
