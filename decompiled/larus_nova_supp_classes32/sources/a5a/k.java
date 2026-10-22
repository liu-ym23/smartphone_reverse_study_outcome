package a5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements Runnable {
    public final /* synthetic */ LogBoxLogLevel a;
    public final /* synthetic */ l b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d(-1, this.a);     // Catch: Throwable -> L6
        b r0 = this.b.d;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.g = Boolean.TRUE;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public k(l r1, LogBoxLogLevel r2) {
        this.b = r1;
        this.a = r2;
    }
}
