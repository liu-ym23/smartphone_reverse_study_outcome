package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class bq implements Runnable {
    a d;

    interface a {
        void a(bq r1);
    }

    public bq() {
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        q.b(th, "ThreadTask", "run");
        th.printStackTrace();
        return;
    L3:
        if (Thread.interrupted() == false) goto L5;
        return;
    L5:
        a();     // Catch: Throwable -> L12
        if (Thread.interrupted() == false) goto L8;
        return;
    L8:
        a r0 = this.d;     // Catch: Throwable -> L12
        if (r0 == null) goto L17;
        r0.a(this);     // Catch: Throwable -> L12
        return;
    }
}
