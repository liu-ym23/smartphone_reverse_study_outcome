package e1c;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements Runnable {
    public final /* synthetic */ ExecutorService a;
    public final /* synthetic */ o1c.c<?, ?> b;

    /* JADX WARN: Multi-variable type inference failed */
    public f(n1c.a r1, o1c.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.execute(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
