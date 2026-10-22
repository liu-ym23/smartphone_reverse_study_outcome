package ms.bd.c;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class k implements Runnable {
    public final /* synthetic */ l a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getClass();     // Catch: Throwable -> L7
        if (n.b() != 0) goto L5;
        n.c(0);     // Catch: Throwable -> L7
        n.e = false;     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        n.h.postDelayed(new j(this), 1000);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public k(l r1) {
        this.a = r1;
    }
}
