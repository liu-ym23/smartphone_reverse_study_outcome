package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCancellableContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n*L\n1#1,386:1\n1#2:387\n19#3:388\n*S KotlinDebug\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n380#1:388\n*E\n"})
public final class q {
    public static final void a(n<?> r10, b1 r11) {
        r10.h(new c1(r11));
    }

    public static final <T> o<T> b(Continuation<? super T> r10) {
        if ((r10 instanceof kotlinx.coroutines.internal.l) == false) goto L5;
        o<T> r11 = ((kotlinx.coroutines.internal.l) r10).n();
        if (r11 == null) goto L16;
        if (r11.T() == true) goto L12;
        r11 = null;
    L12:
        if (r11 == null) goto L16;
        return r11;
    L16:
        return new o(r10, 2);
    L5:
        return new o(r10, 1);
    }
}
