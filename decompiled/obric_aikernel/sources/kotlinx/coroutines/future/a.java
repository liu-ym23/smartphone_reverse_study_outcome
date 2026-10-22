package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
final class a<T> implements BiFunction<T, Throwable, Unit> {

    @JvmField
    public volatile Continuation<? super T> cont;

    public void a(T r10, Throwable r11) {
        Continuation<? super T> r12 = this.cont;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r11 != null) goto L9;
        Result.Companion r13 = Result.Companion;
    L7:
        r12.resumeWith(Result.m32constructorimpl(r10));
        return;
    L9:
        if ((r11 instanceof CompletionException) == false) goto L11;
        CompletionException r14 = (CompletionException) r11;
    L12:
        if (r14 == null) goto L17;
        Throwable r15 = r14.getCause();
        if (r15 == null) goto L17;
        r11 = r15;
    L17:
        Result.Companion r16 = Result.Companion;
        r10 = (T) ResultKt.createFailure(r11);
        goto L7
    L11:
        r14 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object r10, Throwable r11) {
        a(r10, r11);
        return Unit.INSTANCE;
    }
}
