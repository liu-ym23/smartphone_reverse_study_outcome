package com.bytedance.badger.utils;

import android.os.IBinder;
import com.bm.vivoid.c;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ IBinder b;
    public final /* synthetic */ IBinder c;
    public final /* synthetic */ e0 d;
    public final /* synthetic */ f0 e;

    public c0(f0 r1, IBinder r2, IBinder r3, e0 r4, f0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        c r0 = com.bm.vivoid.b.a(this.b);
    L7:
        th = move-exception;
        f0 r1 = this.a;
        r1.b.a(r1.c, this.e, th);
        return;
    L4:
        if (r0.a(this.c, this.d) == true) goto L12;
        f0 r2 = this.a;     // Catch: Throwable -> L7
        r2.b.a(r2.c, this.e, new IllegalStateException("transfer returned false"));     // Catch: Throwable -> L7
        return;
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
