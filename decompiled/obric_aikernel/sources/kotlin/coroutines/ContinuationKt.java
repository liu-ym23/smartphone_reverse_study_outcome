package kotlin.coroutines;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ContinuationKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Continuation<T> Continuation(final CoroutineContext r10, final Function1<? super Result<? extends T>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "resumeWith");
        return new AnonymousClass1(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r10, r11)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "completion");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r10, r11, r12)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void resume(Continuation<? super T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Result.Companion r12 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(r11));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void resumeWithException(Continuation<? super T> r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        Result.Companion r12 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r11)));
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "completion");
        Continuation r12 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r10, r11));
        Result.Companion r13 = Result.Companion;
        r12.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "completion");
        Continuation r13 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r10, r11, r12));
        Result.Companion r14 = Result.Companion;
        r13.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> r10, Continuation<? super T> r11) {
        InlineMarker.mark(0);
        SafeContinuation r12 = new SafeContinuation(IntrinsicsKt.intercepted(r11));
        r10.invoke(r12);
        Object r13 = r12.getOrThrow();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        InlineMarker.mark(1);
        return r13;
    }
}
