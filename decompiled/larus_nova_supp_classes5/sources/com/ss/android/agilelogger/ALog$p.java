package com.ss.android.agilelogger;

import com.bytedance.android.alog.Alog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ALog$p {
    public static ExecutorService b;
    public final Alog a;

    public class a implements ThreadFactory {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            PthreadThreadV2 r0 = new PthreadThreadV2(r3, "ALog$LogInstance$1");
            ThreadMethodProxy.setName(r0, "Alog_instance-" + this.a);
            return r0;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ALog$p e;

        @Override // java.lang.Runnable
        public final void run() {
            int r2 = ALog.access$400(4);     // Catch: Throwable -> L5
            this.e.a.o(r2, this.a, this.b, this.c, this.d);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }

        public b(ALog$p r1, String r2, String r3, long r4, long r6) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ALog$p e;

        @Override // java.lang.Runnable
        public final void run() {
            int r2 = ALog.access$400(5);     // Catch: Throwable -> L5
            this.e.a.o(r2, this.a, this.b, this.c, this.d);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }

        public c(ALog$p r1, String r2, String r3, long r4, long r6) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ALog$p e;

        @Override // java.lang.Runnable
        public final void run() {
            int r2 = ALog.access$400(6);     // Catch: Throwable -> L5
            this.e.a.o(r2, this.a, this.b, this.c, this.d);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }

        public d(ALog$p r1, String r2, String r3, long r4, long r6) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
        }
    }

    public ALog$p(Alog r1, String r2) {
        this.a = r1;
        b = PThreadExecutorsUtils.newSingleThreadExecutor(new a(r2));
    }

    public final void a(String r11, String r12) {
        long r4 = ALog.access$500();
        long r6 = System.currentTimeMillis();
        if (ALog.checkPrioAndTag(6, r11) == false) goto L6;
        b.submit(new d(this, r11, r12, r4, r6));
        return;
    }

    public final void b(String r11, String r12) {
        long r4 = ALog.access$500();
        long r6 = System.currentTimeMillis();
        if (ALog.checkPrioAndTag(4, r11) == false) goto L6;
        b.submit(new b(this, r11, r12, r4, r6));
        return;
    }

    public final void c(String r11, String r12) {
        long r4 = ALog.access$500();
        long r6 = System.currentTimeMillis();
        if (ALog.checkPrioAndTag(5, r11) == false) goto L6;
        b.submit(new c(this, r11, r12, r4, r6));
        return;
    }
}
