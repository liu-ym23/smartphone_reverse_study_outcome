package kotlinx.coroutines.selects;

import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final /* synthetic */ void a(kotlinx.coroutines.n r10, Object r11) {
        c(r10, r11);
    }

    public static final /* synthetic */ void b(kotlinx.coroutines.n r10, Throwable r11) {
        d(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void c(kotlinx.coroutines.n<? super T> r10, T r11) {
        CoroutineDispatcher r12 = (CoroutineDispatcher) r10.getContext().get(CoroutineDispatcher.Key);
        if (r12 == null) goto L5;
        r10.q(r12, r11);
        return;
    L5:
        Result.Companion r13 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(r11));
    }

    private static final void d(kotlinx.coroutines.n<?> r10, Throwable r11) {
        CoroutineDispatcher r12 = (CoroutineDispatcher) r10.getContext().get(CoroutineDispatcher.Key);
        if (r12 == null) goto L5;
        r10.m(r12, r11);
        return;
    L5:
        Result.Companion r13 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r11)));
    }
}
