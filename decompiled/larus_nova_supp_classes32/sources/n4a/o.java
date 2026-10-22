package n4a;

import android.content.Context;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o extends l1 {
    public final /* synthetic */ Context b;

    public o(Context r1) {
        this.b = r1;
    }

    @Override // n4a.l1
    public final void a() {
        Context r0 = this.b;     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        f1 r1 = new f1(t.a);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        t.a = false;     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        Vector<e5> r2 = p.b;     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        k1 r3 = k1.d;     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        r3.b(new s(r0, "c", r1));     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        t.d(this.b);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        t.c(this.b);     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        r3.b(new s0.a(this.b, 3));     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        r3.b(new q0.a(this.b, 2));     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        return;
    L4:
        th = move-exception;
        r.f(th, "Lg", "proL");
        return;
    }
}
