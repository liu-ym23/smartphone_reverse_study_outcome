package i84;

import com.bytedance.bdinstall.t0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x implements Runnable {
    public final /* synthetic */ w a;

    @Override // java.lang.Runnable
    public final void run() {
        t0 r0 = this.a.b;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.onTimeout();     // Catch: Throwable -> L7
        w.b(this.a);     // Catch: Throwable -> L7
    L5:
        this.a.b = null;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public x(w r1) {
        this.a = r1;
    }
}
