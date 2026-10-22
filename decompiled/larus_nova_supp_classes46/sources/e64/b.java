package e64;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public final void a() {
        c r0 = this.a;
        r0.getAll();
        r0.getClass();
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r1) {
        this.a = r1;
    }
}
