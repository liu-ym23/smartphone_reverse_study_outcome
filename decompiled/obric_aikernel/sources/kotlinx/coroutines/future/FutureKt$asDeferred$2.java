package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.w;

/* JADX INFO: loaded from: classes3.dex */
final class FutureKt$asDeferred$2 extends Lambda implements Function2<Object, Throwable, Object> {
    final /* synthetic */ w<Object> $result;

    FutureKt$asDeferred$2(w<Object> r10) {
        this.$result = r10;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Throwable r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r10, Throwable r11) {
        if (r11 != null) goto L4;
        boolean r12 = this.$result.K(r10);     // Catch: Throwable -> L16
    L14:
        return Boolean.valueOf(r12);
    L4:
        w<Object> r13 = this.$result;     // Catch: Throwable -> L16
        if ((r11 instanceof CompletionException) == false) goto L7;
        CompletionException r14 = (CompletionException) r11;     // Catch: Throwable -> L16
    L8:
        if (r14 == null) goto L13;
        Throwable r15 = r14.getCause();     // Catch: Throwable -> L16
        if (r15 == null) goto L13;
        r11 = r15;
    L13:
        r12 = r13.G(r11);     // Catch: Throwable -> L16
        goto L14
    L7:
        r14 = null;
    L16:
        th = move-exception;
        i0.a(EmptyCoroutineContext.INSTANCE, th);
        return Unit.INSTANCE;
    }
}
