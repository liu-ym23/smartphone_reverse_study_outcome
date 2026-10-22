package a5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b.a b;

    @Override // java.lang.Runnable
    public final void run() {
        l r0 = this.b.b.e.get();     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.d(this.a, this.b.b.d);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public g(b.a r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
