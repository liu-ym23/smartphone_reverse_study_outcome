package fh0;

import com.larus.apm.impl.protector.RunnableProtector;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ p b;
    public final /* synthetic */ Object c;

    public g(f r1) {
        this.a = r1;
        this.b = null;
        this.c = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gh0.a.b("UniversalPlayModeExtHandler", "updateLinkUserMergeDataAndNotify", 4);     // Catch: Throwable -> L4
        f r0 = this.a;     // Catch: Throwable -> L4
        r0.d = this.b;     // Catch: Throwable -> L4
        r0.e = this.c;     // Catch: Throwable -> L4
        r0.c();     // Catch: Throwable -> L4
        f r1 = this.a;     // Catch: Throwable -> L4
        r1.c = System.currentTimeMillis();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
