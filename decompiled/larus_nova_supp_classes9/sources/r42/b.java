package r42;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ a.c a;
    public final /* synthetic */ Throwable b;

    public b(a.c r1, Throwable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Throwable r0 = this.b;
        if ((r0 instanceof TimeoutException) == false) goto L5;
        a.c("fetch first history messages timeout");
        this.a.a.a(new n(null, "timeout"));
        return;
    L5:
        o r1 = this.a.a;
        String r2 = r0.getMessage();
        if (r2 != null) goto L8;
        r2 = "Unknown";
    L8:
        r1.a(new n(null, r2));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
