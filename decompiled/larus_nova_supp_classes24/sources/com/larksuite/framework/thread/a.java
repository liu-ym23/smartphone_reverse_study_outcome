package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static volatile a d;
    public final Object a;
    public final Map<Integer, s> b;
    public final BlockingQueue<s> c;

    /* JADX INFO: renamed from: com.larksuite.framework.thread.a$a, reason: collision with other inner class name */
    public class RunnableC0051a implements Runnable {
        public final /* synthetic */ a a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L4
            System.currentTimeMillis();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0051a(a r1) {
            this.a = r1;
        }
    }

    public static a c() {
        if (d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public a() {
        this.a = new Object();
        this.b = new ConcurrentHashMap();
        this.c = new LinkedBlockingQueue();
        System.currentTimeMillis();
        new RunnableC0051a(this);
    }

    public final synchronized void a(Throwable r3) {
        monitor-enter(this);
        Map<Integer, s> r0 = this.b;     // Catch: Throwable -> L11
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;     // Catch: Throwable -> L11
        if (((s) r1.get(Integer.valueOf(r3.hashCode()))) != null) goto L9;
        Exception r2 = (Exception) r3;     // Catch: Throwable -> L11
        System.currentTimeMillis();     // Catch: Throwable -> L11
        s r4 = new s();     // Catch: Throwable -> L11
        Map<Integer, s> r5 = this.b;     // Catch: Throwable -> L11
        ConcurrentHashMap r6 = (ConcurrentHashMap) r5;     // Catch: Throwable -> L11
        r6.put(Integer.valueOf(r3.hashCode()), r4);     // Catch: Throwable -> L11
        ((LinkedBlockingQueue) this.c).put(r4);     // Catch: InterruptedException -> L8 Throwable -> L11
    L8:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Throwable r3) {
        monitor-enter(this);
        Map<Integer, s> r0 = this.b;     // Catch: Throwable -> L8
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;     // Catch: Throwable -> L8
        s r2 = (s) r1.get(Integer.valueOf(r3.hashCode()));     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        ((LinkedBlockingQueue) this.c).remove(r2);     // Catch: Throwable -> L8
        Map<Integer, s> r4 = this.b;     // Catch: Throwable -> L8
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;     // Catch: Throwable -> L8
        r5.remove(Integer.valueOf(r3.hashCode()));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
