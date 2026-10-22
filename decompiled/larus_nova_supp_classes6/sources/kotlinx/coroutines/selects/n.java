package kotlinx.coroutines.selects;

import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n {
    public static final void a(kotlinx.coroutines.j r2, Throwable r3) {
        CoroutineDispatcher r0 = r2.getContext().get(CoroutineDispatcher.Key);
        if (r0 == null) goto L5;
        r2.J(r0, r3);
        return;
    L5:
        Result.Companion r1 = Result.Companion;
        r2.resumeWith(Result.constructor-impl(ResultKt.createFailure(r3)));
    }
}
