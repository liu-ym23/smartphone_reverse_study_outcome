package ey0;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final <T> void a(Continuation<? super T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$checkCancellationAndResume");
        CoroutineContext r0 = r2.getContext();
        Intrinsics.checkNotNullParameter(r0, "$this$isCancelled");
        a r1 = r0.get(a.b);
        if (r1 == null) goto L5;
        boolean r4 = r1.a;
    L6:
        if (r4 == false) goto L8;
        CancellationException r5 = new CancellationException("Continuation is cancelled");
        Result.Companion r6 = Result.Companion;
        r2.resumeWith(Result.constructor-impl(ResultKt.createFailure(r5)));
        return;
    L8:
        r2.resumeWith(Result.constructor-impl(r3));
        return;
    L5:
        r4 = false;
        goto L6
    }
}
