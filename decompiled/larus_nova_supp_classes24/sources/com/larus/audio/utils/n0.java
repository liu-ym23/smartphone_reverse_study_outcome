package com.larus.audio.utils;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n0 implements ThreadFactory {
    public static final AtomicInteger c = null;
    public static final AtomicInteger d = null;
    public final Lazy a;
    public final String b;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final Runnable a;
        public final int b;

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.b);     // Catch: Throwable -> L4
            this.a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, "r");
            this.a = r2;
            this.b = 10;
        }
    }

    static {
        c = new AtomicInteger(1);
        d = new AtomicInteger(1);
    }

    public n0() {
        Intrinsics.checkNotNullParameter("audio-disk-lru-cache-pool", "poolName");
        this.a = LazyKt.lazy(new l0());
        this.b = "audio-disk-lru-cache-pool-" + c.getAndIncrement() + '-';
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r7) {
        if (r7 != null) goto L5;
        r7 = new m0();
    L5:
        b r2 = new b(r7);
        PthreadThreadV2 r8 = new PthreadThreadV2((ThreadGroup) this.a.getValue(), r2, this.b + d.getAndIncrement(), 0);
        if (r8.isDaemon() == false) goto L9;
        r8.setDaemon(false);
    L9:
        if (r8.getPriority() == 5) goto L11;
        ThreadMethodProxy.setPriority(r8, 5);
    L11:
        return r8;
    }
}
