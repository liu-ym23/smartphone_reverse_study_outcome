package vp1;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements Runnable {
    public final /* synthetic */ g.e a;

    public j(g.e r1) {
        this.a = r1;
    }

    public final void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        g.e r1 = this.a;     // Catch: Throwable -> L4
        g r2 = r1.a;     // Catch: Throwable -> L4
        boolean r3 = r1.b;     // Catch: Throwable -> L4
        boolean r4 = r1.c;     // Catch: Throwable -> L4
        boolean r5 = r1.d;     // Catch: Throwable -> L4
        int r6 = g.n;     // Catch: Throwable -> L4
        r2.h(r3, r4, r5);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
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
