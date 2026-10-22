package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class o1<T> extends f1 {
    public final j<T> e;

    public o1(JobSupport$a r1) {
        this.e = r1;
    }

    public final void a(Throwable r3) {
        Object r4 = i().M();
        if ((r4 instanceof t) == false) goto L5;
        j<T> r0 = this.e;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(((t) r4).a)));
        return;
    L5:
        j<T> r2 = this.e;
        Result.Companion r5 = Result.Companion;
        r2.resumeWith(Result.constructor-impl(g1.a(r4)));
    }
}
