package n4a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c3 implements Runnable {
    public final /* synthetic */ d3 a;

    public c3(d3 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d3 r0 = this.a;     // Catch: Throwable -> L9
        if (r0.f == null) goto L19;
        s3 r1 = r0.d;     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.o == false) goto L12;
        r1.d(true);     // Catch: Throwable -> L9
    L12:
        q2.e(r1.c);     // Catch: Throwable -> L9
        return;
    L19:
        return;
    L9:
        th = move-exception;
        c4.g(th, "cl", "upwr");     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    }
}
