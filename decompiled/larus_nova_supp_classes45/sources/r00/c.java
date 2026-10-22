package r00;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements Runnable {
    public final /* synthetic */ Throwable a;

    public c(Throwable r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    L3:
        throw new Exception(this.a);     // Catch: Throwable -> L4
    }
}
