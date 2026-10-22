package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements Runnable {
    public final /* synthetic */ s5c.d a;

    public j(s5c.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s5c.d r0 = this.a;     // Catch: Throwable -> L8
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Statistics.sendEvent("start_forward_mention", r0.toJson());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L17:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
