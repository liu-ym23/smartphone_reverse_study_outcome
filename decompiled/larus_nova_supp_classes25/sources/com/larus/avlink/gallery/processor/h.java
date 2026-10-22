package com.larus.avlink.gallery.processor;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final h a = null;
    public static boolean b;
    public static PthreadThreadV2 c;
    public static Process d;
    public static final AtomicInteger e = null;

    public h() {
    }

    static {
        a = new h();
        e = new AtomicInteger(0);
    }

    public static void c() {
        PthreadThreadV2 r0 = new PthreadThreadV2(new g(), "LogMonitor");
        r0.setDaemon(true);
        ThreadMethodProxy.start(r0);
        c = r0;
    }

    public final synchronized void d() {
        monitor-enter(this);
        AtomicInteger r2 = e;     // Catch: Throwable -> L22
        int r3 = r2.decrementAndGet();     // Catch: Throwable -> L22
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L22
        r4.d("MorphoLogMonitor", "LogMonitor stop called, reference count: " + r3);     // Catch: Throwable -> L22
        if (r3 <= 0) goto L26;
    L20:
        monitor-exit(this);
        return;
    L26:
    L15:
        e = move-exception;
        FLogger.a.e("MorphoLogMonitor", "Error stopping LogMonitor: " + e.getMessage(), e);     // Catch: Throwable -> L22
        goto L20
    L7:
        if (b == false) goto L17;
        b = false;     // Catch: Exception -> L15 Throwable -> L22
        Process r1 = d;     // Catch: Exception -> L15 Throwable -> L22
        if (r1 == null) goto L11;
        r1.destroy();     // Catch: Exception -> L15 Throwable -> L22
    L11:
        d = null;     // Catch: Exception -> L15 Throwable -> L22
        PthreadThreadV2 r5 = c;     // Catch: Exception -> L15 Throwable -> L22
        if (r5 == null) goto L14;
        ThreadMethodProxy.join(r5, 2000);     // Catch: Exception -> L15 Throwable -> L22
    L14:
        c = null;     // Catch: Exception -> L15 Throwable -> L22
        r4.i("MorphoLogMonitor", "LogMonitor stopped (all references released)");     // Catch: Exception -> L15 Throwable -> L22
    L17:
        r2.set(0);     // Catch: Exception -> L15 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static Process a(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }

    public final synchronized void b(Context r5, boolean r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L14
        if (r6 == true) goto L12;
        int r7 = e.incrementAndGet();     // Catch: Throwable -> L14
        FLogger r8 = FLogger.a;     // Catch: Throwable -> L14
        r8.d("MorphoLogMonitor", "LogMonitor init called, reference count: " + r7);     // Catch: Throwable -> L14
        if (b == true) goto L12;
        c();     // Catch: Exception -> L10 Throwable -> L14
        b = true;     // Catch: Exception -> L10 Throwable -> L14
        r8.i("MorphoLogMonitor", "LogMonitor started (Release mode)");     // Catch: Exception -> L10 Throwable -> L14
    L10:
        e = move-exception;
        FLogger.a.e("MorphoLogMonitor", "Failed to start LogMonitor: " + e.getMessage(), e);     // Catch: Throwable -> L14
        e.decrementAndGet();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
