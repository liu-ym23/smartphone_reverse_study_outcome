package androidx.work;

import androidx.annotation.RestrictTo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes.dex */
public final class ListenableFutureKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(c6.a<R> r10, Continuation<? super R> r11) {
        if (r10.isDone() == true) goto L16;
        o r12 = new o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        r10.addListener(new ListenableFutureKt$await$2$1(r12, r10), DirectExecutor.INSTANCE);
        r12.h(new ListenableFutureKt$await$2$2(r10));
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L15:
        return r13;
    L16:
        return r10.get();
    L6:
        e = move-exception;
        Throwable r14 = e.getCause();
        if (r14 != null) goto L11;
        throw e;
    L11:
        throw r14;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final <R> Object await$$forInline(c6.a<R> r10, Continuation<? super R> r11) {
        if (r10.isDone() == true) goto L16;
        InlineMarker.mark(0);
        o r12 = new o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        r10.addListener(new ListenableFutureKt$await$2$1(r12, r10), DirectExecutor.INSTANCE);
        r12.h(new ListenableFutureKt$await$2$2(r10));
        Unit r13 = Unit.INSTANCE;
        Object r14 = r12.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L14:
        InlineMarker.mark(1);
        return r14;
    L16:
        return r10.get();
    L6:
        e = move-exception;
        Throwable r15 = e.getCause();
        if (r15 != null) goto L10;
        throw e;
    L10:
        throw r15;
    }
}
