package ms.bd.c;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j implements Runnable {
    public final /* synthetic */ k a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.getClass();     // Catch: Throwable -> L6
        if (n.b() != 0) goto L9;
        n.c(0);     // Catch: Throwable -> L6
        n.e = false;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public j(k r1) {
        this.a = r1;
    }
}
