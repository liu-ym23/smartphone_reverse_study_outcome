package a5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements Runnable {
    public final /* synthetic */ b.a a;

    @Override // java.lang.Runnable
    public final void run() {
        l r0 = this.a.b.e.get();     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.d(-1, this.a.b.d);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public f(b.a r1) {
        this.a = r1;
    }
}
