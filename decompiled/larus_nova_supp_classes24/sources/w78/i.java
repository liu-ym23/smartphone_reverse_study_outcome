package w78;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements Runnable {
    public final /* synthetic */ j<Object> a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(false);     // Catch: Throwable -> L4
        t0.a.postDelayed(this, this.a.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(j<Object> r1) {
        this.a = r1;
    }
}
