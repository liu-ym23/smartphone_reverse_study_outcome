package x8a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class d$b implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        c.b().a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d$b() {
    }
}
