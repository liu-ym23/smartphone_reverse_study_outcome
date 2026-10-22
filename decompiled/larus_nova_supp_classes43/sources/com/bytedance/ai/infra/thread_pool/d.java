package com.bytedance.ai.infra.thread_pool;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements ThreadFactory {
    public final String a;
    public final ThreadPriority b;
    public final AtomicInteger c;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {
        public final /* synthetic */ d v;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ThreadPriority.values().length];
                r0[ThreadPriority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[ThreadPriority.HIGH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final void run() {
            ThreadPriority r0 = this.v.b;     // Catch: Throwable -> L11
            int r1 = a.a[r0.ordinal()];     // Catch: Throwable -> L11
            if (r1 != 1) goto L5;
            Process.setThreadPriority(10);     // Catch: Throwable -> L11
        L9:
            super.run();     // Catch: Throwable -> L11
            return;
        L5:
            if (r1 != 2) goto L9;
            Process.setThreadPriority(-4);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }

        public b(Runnable r1, String r10, d r11) {
            this.v = r11;
            super(r1, r10);
        }
    }

    static {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "r");
        String r0 = this.a + '-' + this.c.incrementAndGet();
        Logger.d("DefaultThreadFactory", "Create New Thread: " + r0);
        return new b(r10, r0, this);
    }

    public d(String r10, ThreadPriority r11) {
        Intrinsics.checkNotNullParameter(r10, "namePrefix");
        Intrinsics.checkNotNullParameter(r11, "threadPriority");
        this.a = r10;
        this.b = r11;
        this.c = new AtomicInteger(0);
    }
}
