package f6a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class e implements Runnable {
    public final i a;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4 RuntimeException -> L6
    L16:
        return;
    L6:
        e = move-exception;
        this.a.handleException(e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public e(i r1) {
        this.a = r1;
    }
}
