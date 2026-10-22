package com.larus.audio.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g1 {
    public static final Handler a = null;
    public static final Lazy b = null;
    public static final BlockingQueue<Runnable> c = null;
    public static final a d = null;
    public static final d1 e = null;

    public static final class a implements ThreadFactory {
        public static final AtomicInteger d = null;
        public final ThreadGroup a;
        public final AtomicInteger b;
        public final String c;

        /* JADX INFO: renamed from: com.larus.audio.utils.g1$a$a, reason: collision with other inner class name */
        public static final class C0086a {
        }

        static {
            d = new AtomicInteger(1);
        }

        public a() {
            Intrinsics.checkNotNullParameter("AudioThreads", "factoryTag");
            this.b = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.a = r1;
            this.c = "AudioThreads-" + d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Intrinsics.checkNotNullParameter(r8, "runnable");
            PthreadThreadV2 r0 = new PthreadThreadV2(this.a, r8, this.c + this.b.getAndIncrement(), 0);
            if (r0.isDaemon() == false) goto L6;
            r0.setDaemon(false);
        L6:
            if (r0.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r0, 5);
        L8:
            return r0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.audio.utils.d1] */
    static {
        a = new Handler(Looper.getMainLooper());
        b = LazyKt.lazy(new c1());
        c = new LinkedBlockingQueue();
        d = new a();
        e = new d1();
    }

    public static void a(long r3, final Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "method");
        if (r3 <= 0) goto L5;
        a.postDelayed(new f1(r5), r3);
        return;
    L5:
        r5.invoke();
    }
}
