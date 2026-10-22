package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ long b;
    public final /* synthetic */ s5c.d c;

    public i(boolean r1, long r2, s5c.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void a() {
        boolean r0 = this.a;
        long r1 = this.b;
        s5c.d r3 = this.c;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        s5c.a r2 = l.c.a(String.valueOf(r0));     // Catch: Throwable -> L5
        s5c.a r5 = u3.c.a(String.valueOf(r1));     // Catch: Throwable -> L5
        Statistics.sendEvent("forward_mention_request", r3.plus(r2).plus(r5).toJson());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
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
