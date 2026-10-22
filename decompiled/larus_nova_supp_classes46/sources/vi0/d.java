package vi0;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ e.a a;

    public d(e.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a r0 = this.a.a.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
