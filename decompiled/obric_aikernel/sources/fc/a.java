package fc;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.m;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCancellable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n1#1,68:1\n49#1,6:69\n49#1,6:75\n49#1,6:81\n*S KotlinDebug\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n17#1:69,6\n29#1:75,6\n38#1:81,6\n*E\n"})
public final class a {
    private static final void a(Continuation<?> r10, Throwable r11) {
        Result.Companion r12 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r11)));
        throw r11;
    }

    public static final void b(Continuation<? super Unit> r10, Continuation<?> r11) {
        Continuation r12 = IntrinsicsKt.intercepted(r10);     // Catch: Throwable -> L4
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L4
        m.c(r12, Result.m32constructorimpl(Unit.INSTANCE), null, 2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r11, th);
    }

    public static final <T> void c(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Continuation r12 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r10, r11));     // Catch: Throwable -> L4
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L4
        m.c(r12, Result.m32constructorimpl(Unit.INSTANCE), null, 2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r11, th);
    }

    public static final <R, T> void d(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12, Function1<? super Throwable, Unit> r13) {
        Continuation r14 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r10, r11, r12));     // Catch: Throwable -> L4
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L4
        m.b(r14, Result.m32constructorimpl(Unit.INSTANCE), r13);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(r12, th);
    }

    public static /* synthetic */ void e(Function2 r10, Object r11, Continuation r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = null;
    L5:
        d(r10, r11, r12, r13);
    }
}
