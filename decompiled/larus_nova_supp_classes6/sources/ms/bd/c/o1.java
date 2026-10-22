package ms.bd.c;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class o1 implements Runnable {
    public final /* synthetic */ p1 a;

    public final void a() {
        this.a.h.await();     // Catch: InterruptedException -> L5
    L3:
        this.a.g.quitSafely();
        String r1 = (String) p2.a(16777217, 0, 0, "4305aa", new byte[]{1, 62, 86, 120, 87, 120, 27, 27, 119, 96});
        String r0 = (String) p2.a(16777217, 0, 0, "f729a5", new byte[]{67, 61, 68, 13, 73, 45, 119, 26, 103, 41, 96, 52, 82, 13, 80, 45, 114, 86, 114, 124, 126, 48, 85, 3});
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

    public o1(p1 r1) {
        this.a = r1;
    }
}
