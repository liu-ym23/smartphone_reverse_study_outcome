package j28;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ d b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.c.execute(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r1, b r2) {
        this.b = r1;
        this.a = r2;
    }
}
