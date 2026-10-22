package n8a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    @Override // java.lang.Runnable
    public final void run() {
        a.c(this.a);     // Catch: Throwable -> L4
        a r0 = this.a;     // Catch: Throwable -> L4
        r0.f(r0.getWidth(), this.a.getHeight());     // Catch: Throwable -> L4
        this.a.updateBlur();     // Catch: Throwable -> L4
        this.a.invalidate();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(a r1) {
        this.a = r1;
    }
}
