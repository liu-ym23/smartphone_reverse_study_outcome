package rqa;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements Runnable {
    public final /* synthetic */ pqa.a a;
    public final /* synthetic */ a b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.e(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r1, pqa.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
