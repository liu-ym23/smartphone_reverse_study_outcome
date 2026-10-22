package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.o1;
import z5c.p1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;

    public h(boolean r1) {
        this.a = r1;
        this.b = true;
    }

    public final void a() {
        boolean r0 = this.a;
        boolean r1 = this.b;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Statistics.sendEvent("im_msg_select_forward_mention_click", s5c.d.b.b(p1.c.a(String.valueOf(r0)), o1.c.a(String.valueOf(r1))).toJson());     // Catch: Throwable -> L5
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
