package c50;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements Runnable {
    public final Runnable a;
    public final f b;
    public final long c;
    public final int d;

    public final void a() {
        Runnable r0 = this.a;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        f r1 = this.b;
        if (r1 == null) goto L12;
        e.a r2 = (e.a) r1;
        d r3 = r2.a.b.get(Integer.valueOf(this.d));
        if (r3 == null) goto L10;
        r3.d.remove(this);
    L10:
        r2.a.d.b();
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

    public c(String r3, int r4, Runnable r5, f r6, long r7) {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = -1;
        this.d = r4;
        this.a = r5;
        this.b = r6;
        this.c = r7;
    }
}
