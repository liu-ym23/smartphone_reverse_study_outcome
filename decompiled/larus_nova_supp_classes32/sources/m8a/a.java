package m8a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public final /* synthetic */ d.c a;
    public final /* synthetic */ d b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.o(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(d r1, d.c r2) {
        this.b = r1;
        this.a = r2;
    }
}
