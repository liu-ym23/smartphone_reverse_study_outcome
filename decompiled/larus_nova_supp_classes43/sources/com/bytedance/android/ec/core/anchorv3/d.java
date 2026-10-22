package com.bytedance.android.ec.core.anchorv3;

import android.os.Looper;
import com.bytedance.android.ec.core.utils.b2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Runnable {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static void a() {
        if (f.a.compareAndSet(false, true) == false) goto L8;
        final e r0 = new e();
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L7;
        b2.b(new PdpColdInitPerfOpt$runInBgThread$1(r0));
        goto L8
    L7:
        r0.run();
    L8:
        int r1 = h.a;
        if (PdpPerfOpt.j() <= 0) goto L11;
    L15:
        int r10 = com.bytedance.android.ec.core.opt.b.a;
        new PdpColdInitPerfOptV1$onECSdkInit$action$1().run();
        return;
    L11:
        if (PdpPerfOpt.f() == true) goto L15;
        if (PdpPerfOpt.g() == true) goto L15;
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
