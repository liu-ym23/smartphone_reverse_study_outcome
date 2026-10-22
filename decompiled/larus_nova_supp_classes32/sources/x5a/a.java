package x5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public final /* synthetic */ com.lynx.component.svg.a a;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.a.v == true) goto L10;
        this.a.q = null;     // Catch: Throwable -> L7
        this.a.e(0);     // Catch: Throwable -> L7
        this.a.p = false;     // Catch: Throwable -> L7
        return;
    }

    public a(com.lynx.component.svg.a r1) {
        this.a = r1;
    }
}
