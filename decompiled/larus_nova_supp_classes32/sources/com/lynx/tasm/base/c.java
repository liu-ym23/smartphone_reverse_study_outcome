package com.lynx.tasm.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends PhantomReference<Object> {
    public static final ReferenceQueue<Object> c = null;
    public static final Object d = null;
    public static final Set<c> e = null;
    public static final Set<c> f = null;
    public static final ConcurrentLinkedQueue g = null;
    public final boolean a;
    public Runnable b;

    public static class a extends PthreadThreadV2 {
        public a() {
            super("CleanupReference");
        }

        public static void l() {
        L20:
            c r0 = (c) c.c.remove();     // Catch: Exception -> L16
            Object r1 = c.d;     // Catch: Exception -> L16
            monitor-enter(r1);     // Catch: Exception -> L16
        L5:
            if (r0.a == true) goto L7;
            c.g.offer(r0);     // Catch: Throwable -> L13
        L8:
            c r2 = (c) c.g.poll();     // Catch: Throwable -> L13
            if (r2 == null) goto L11;
            TraceEvent.beginSection("CleanupReference.ReaperThread.runCleanupTask");     // Catch: Throwable -> L13
            c.a(r2, c.f);     // Catch: Throwable -> L13
            TraceEvent.endSection("CleanupReference.ReaperThread.runCleanupTask");     // Catch: Throwable -> L13
            goto L8
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L13
            goto L20
        L7:
            Message.obtain(b.a, 2, r0).sendToTarget();     // Catch: Throwable -> L13
            r1.wait(500);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L16:
            e = move-exception;
            LLog.e("CleanupReference", "Queue remove exception:" + e.toString());
            goto L20
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b {
        public static final a a = null;

        public static class a extends Handler {
            public a(Looper r1) {
                super(r1);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r5) {
                TraceEvent.beginSection("CleanupReference.LazyHolder.handleMessage");     // Catch: Throwable -> L24
                c r0 = (c) r5.obj;     // Catch: Throwable -> L24
                int r6 = r5.what;     // Catch: Throwable -> L24
                if (r6 != 1) goto L5;
                ((HashSet) c.e).add(r0);     // Catch: Throwable -> L24
            L9:
                Object r7 = c.d;     // Catch: Throwable -> L24
                monitor-enter(r7);     // Catch: Throwable -> L24
            L27:
                c r1 = (c) c.c.poll();     // Catch: Throwable -> L21
                if (r1 == null) goto L17;
                if (r1.a == false) goto L15;
                c.a(r1, c.e);     // Catch: Throwable -> L21
                goto L27
            L15:
                c.g.offer(r1);     // Catch: Throwable -> L21
                goto L27
            L17:
                c.d.notifyAll();     // Catch: Throwable -> L21
                monitor-exit(r7);     // Catch: Throwable -> L21
                TraceEvent.endSection("CleanupReference.LazyHolder.handleMessage");
                return;
            L21:
                th = move-exception;
                throw th;     // Catch: Throwable -> L24
            L5:
                if (r6 == 2) goto L7;
                LLog.e("CleanupReference", String.format("Bad message=%d", new Object[]{Integer.valueOf(r6)}));     // Catch: Throwable -> L24
                goto L9
            L7:
                c.a(r0, c.e);     // Catch: Throwable -> L24
            L24:
                th = move-exception;
                TraceEvent.endSection("CleanupReference.LazyHolder.handleMessage");
                throw th;
            }
        }

        static {
            a = new a(Looper.getMainLooper());
        }
    }

    static {
        c = new ReferenceQueue();
        d = new Object();
        PthreadThreadV2 r0 = new a();
        r0.setDaemon(true);
        ThreadMethodProxy.start(r0);
        e = new HashSet();
        f = ConcurrentHashMap.newKeySet();
        g = new ConcurrentLinkedQueue();
    }

    public c(Object r2, Runnable r3) {
        super(r2, c);
        this.b = r3;
        this.a = true;
        Message r4 = Message.obtain(b.a, 1, this);
        if (Looper.myLooper() != r4.getTarget().getLooper()) goto L5;
        r4.getTarget().handleMessage(r4);
        r4.recycle();
        return;
    L5:
        r4.sendToTarget();
    }

    public static void a(c r1, Set r2) {
        r1.getClass();
        r2.remove(r1);
        Runnable r3 = r1.b;
        r1.b = null;
        if (r3 == null) goto L5;
        r3.run();
    L5:
        r1.clear();
    }
}
