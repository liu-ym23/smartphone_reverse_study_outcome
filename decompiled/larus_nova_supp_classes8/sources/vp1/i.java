package vp1;

import androidx.lifecycle.Lifecycle;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements Runnable {
    public final /* synthetic */ g.c a;

    public i(g.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.a.l.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L9;
        this.a.b.run();     // Catch: Throwable -> L6
        return;
    }
}
