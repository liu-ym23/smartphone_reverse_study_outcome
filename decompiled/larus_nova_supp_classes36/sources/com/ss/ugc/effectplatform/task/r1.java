package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r1 implements Runnable {
    public final /* synthetic */ q1 a;

    public final void a() {
        q1 r0 = this.a;
        r0.e.a();
        if (r0.c.isEmpty() == false) goto L5;
        e0.c r1 = null;
    L6:
        r0.e.b();
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.a.f.b() <= 0) goto L11;
        this.a.f.a();
    L11:
        Logger r2 = Logger.INSTANCE;
        r2.w("JKL", "[TaskManager][新接口][开始][" + r1.getId() + ']');
        this.a.b.put(r1.getId(), r1);
        r1.run();
        this.a.b.remove(r1.getId());
        r2.w("JKL", "[TaskManager][新接口][结束][" + r1.getId() + ']');
        q1 r3 = this.a;
        if (r3.d.contains(r1) == false) goto L20;
        r3.d.remove(r1);
        r3.c.add(r1);
        if ((r1 instanceof BaseTask) == false) goto L17;
        ((BaseTask) r1).b = false;
    L17:
        r2.d("JKL", "[TaskManager][暂停][重新加入到等待队列][" + r1.getId() + ']');
        r3.i.execute(new r1(r3));
        return;
    L20:
        return;
    L5:
        r1 = (e0.c) r0.c.remove(0);
        goto L6
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

    public r1(q1 r1) {
        this.a = r1;
    }
}
