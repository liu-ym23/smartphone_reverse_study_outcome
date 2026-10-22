package r00;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements Runnable {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r0 = this.a.d();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        this.a.a.remove(r0);     // Catch: Throwable -> L6
        this.a.e(r0.a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
