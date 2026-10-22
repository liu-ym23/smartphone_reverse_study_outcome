package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ s5c.d b;

    public c(String r1, s5c.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = this.a;
        s5c.d r1 = this.b;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Statistics.sendEvent("forward_entrance", s5c.d.b.b(z2.k.a(r0), r1).toJson());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
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
