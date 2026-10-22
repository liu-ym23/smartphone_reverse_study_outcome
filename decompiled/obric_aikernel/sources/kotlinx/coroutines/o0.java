package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class o0 {
    public static final String a(Object r10) {
        return r10.getClass().getSimpleName();
    }

    public static final String b(Object r10) {
        return Integer.toHexString(System.identityHashCode(r10));
    }

    public static final String c(Continuation<?> r10) {
        if ((r10 instanceof kotlinx.coroutines.internal.l) == false) goto L16;
        return r10.toString();
    L16:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = Result.m32constructorimpl(r10 + '@' + b(r10));     // Catch: Throwable -> L8
    L11:
        if (Result.m35exceptionOrNullimpl(r12) == null) goto L15;
        r12 = r10.getClass().getName() + '@' + b(r10);
    L15:
        return (String) r12;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
