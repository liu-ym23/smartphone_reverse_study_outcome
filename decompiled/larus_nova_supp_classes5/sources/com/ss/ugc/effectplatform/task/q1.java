package com.ss.ugc.effectplatform.task;

import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.logger.Logger;
import c0.e;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.effectplatform.util.r;
import java.util.Iterator;
import z.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class q1 {
    public final z.b<String, e0.a> a;
    public final z.b<String, e0.c> b;
    public final d<e0.c> c;
    public final d<e0.c> d;
    public final e e;
    public final c0.b f;
    public final z.b<String, e0.c> g;
    public final int h;
    public final bytekn.foundation.concurrent.executor.a i;

    public static final class a {
        public bytekn.foundation.concurrent.executor.a a;
        public int b;

        public final q1 a() {
            Logger.INSTANCE.d("JKL", "[初始化][TaskManager][最大并发任务数:" + this.b + ']');
            int r1 = this.b;
            AsyncExecutor r2 = this.a;
            if (r2 != null) goto L7;
            r2 = new AsyncExecutor();
        L7:
            return new q1(r1, r2);
        }

        public a() {
            this.b = 5;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ q1 a;
        public final /* synthetic */ e0.c b;
        public final /* synthetic */ String c;

        public final void a() {
            Logger r0 = Logger.INSTANCE;
            r0.d("JKL", "[TaskManager][旧接口][开始][" + this.b.getId() + "][" + this.c + ']');
            this.a.b.put(this.b.getId(), this.b);
            this.b.run();
            this.a.b.remove(this.b.getId());
            r0.d("JKL", "[TaskManager][旧接口][结束][" + this.b.getId() + "][" + this.c + ']');
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

        public c(q1 r1, e0.c r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void a(e0.c r4) {
        Iterator r0 = this.a.values().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((e0.a) r0.next()).a() == false) goto L4;
        r1 = true;
        goto L4
    L9:
        if ((r4 instanceof BaseTask) == false) goto L11;
        ((BaseTask) r4).d();
    L11:
        String r2 = r4.getTag();
        if (r1 == true) goto L20;
        this.i.execute(new c(this, r4, r2));
        return;
    }

    public q1(int r2, bytekn.foundation.concurrent.executor.a r3) {
        this.h = r2;
        this.i = r3;
        this.a = new z.b(false);
        this.b = new z.b(true);
        this.c = new d();
        this.d = new d();
        this.e = new e();
        this.f = new c0.b(0);
        this.g = new z.b(true);
    }

    public final void b(String r2, com.ss.ugc.effectplatform.task.b r3) {
        if (r.b(r2) == false) goto L5;
        r2 = "null";
    L5:
        r3.a = r2;
        a(r3);
    }
}
