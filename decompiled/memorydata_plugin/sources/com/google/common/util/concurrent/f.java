package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4860a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4861b;
    private boolean c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f4862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f4863b;
        a c;

        a(Runnable r3, Executor r4, a r5) {
            Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.f4862a = r6;
            this.f4863b = r7;
            this.c = r5;
        }
    }

    static {
        f4860a = Logger.getLogger(f.class.getName());
    }

    public f() {
    }

    private static void b(Runnable r5, Executor r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        r8.execute(r7);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        f4860a.log(Level.SEVERE, "RuntimeException while executing runnable " + r7 + " with executor " + r8, e);
    }

    public void a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.c = true;     // Catch: Throwable -> L14
        a r0 = this.f4861b;     // Catch: Throwable -> L14
        a r1 = null;
        this.f4861b = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L9:
        if (r0 == null) goto L11;
        a r2 = r0.c;
        r0.c = r1;
        r1 = r0;
        r0 = r2;
    L11:
        if (r1 == null) goto L13;
        b(r1.f4862a, r1.f4863b);
        r1 = r1.c;
        goto L11
    }

    public void a(Runnable r3, Executor r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5, "Runnable was null.");
        com.google.common.base.n.a(r6, "Executor was null.");
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.c == true) goto L9;
        this.f4861b = new a(r5, r6, this.f4861b);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        b(r5, r6);
    }
}
