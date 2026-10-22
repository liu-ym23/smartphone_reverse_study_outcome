package a5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements Runnable {
    public final /* synthetic */ b.a a;

    @Override // java.lang.Runnable
    public final void run() {
        l r0 = this.a.b.e.get();     // Catch: Throwable -> L9
        if (r0 == null) goto L12;
        b r1 = r0.d;     // Catch: Throwable -> L9
        if (r1 == null) goto L16;
        r1.b();     // Catch: Throwable -> L9
        l.a(r0.d);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }

    public d(b.a r1) {
        this.a = r1;
    }
}
