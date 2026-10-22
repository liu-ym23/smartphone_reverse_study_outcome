package kotlin;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,340:1\n1#2:341\n*E\n"})
public final class ResultKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Object createFailure(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        return new Result.Failure(r10);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> R fold(Object r10, Function1<? super T, ? extends R> r11, Function1<? super Throwable, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        Intrinsics.checkNotNullParameter(r12, "onFailure");
        Throwable r13 = Result.m35exceptionOrNullimpl(r10);
        if (r13 != null) goto L6;
        return r11.invoke(r10);
    L6:
        return r12.invoke(r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrDefault(Object r10, R r11) {
        if (Result.m38isFailureimpl(r10) == false) goto L5;
        return r11;
    L5:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrElse(Object r10, Function1<? super Throwable, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "onFailure");
        Throwable r12 = Result.m35exceptionOrNullimpl(r10);
        if (r12 != null) goto L6;
        return r10;
    L6:
        return r11.invoke(r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T getOrThrow(Object r10) {
        throwOnFailure(r10);
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object map(Object r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "transform");
        if (Result.m39isSuccessimpl(r10) == false) goto L6;
        Result.Companion r12 = Result.Companion;
        r10 = r11.invoke(r10);
    L6:
        return Result.m32constructorimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object mapCatching(Object r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "transform");
        if (Result.m39isSuccessimpl(r10) == false) goto L9;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        return Result.m32constructorimpl(r11.invoke(r10));
    L6:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = createFailure(th);
    L9:
        return Result.m32constructorimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object onFailure(Object r10, Function1<? super Throwable, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        Throwable r12 = Result.m35exceptionOrNullimpl(r10);
        if (r12 == null) goto L5;
        r11.invoke(r12);
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object onSuccess(Object r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        if (Result.m39isSuccessimpl(r10) == false) goto L5;
        r11.invoke(r10);
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object recover(Object r10, Function1<? super Throwable, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "transform");
        Throwable r12 = Result.m35exceptionOrNullimpl(r10);
        if (r12 == null) goto L7;
        Result.Companion r13 = Result.Companion;
        return Result.m32constructorimpl(r11.invoke(r12));
    L7:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object recoverCatching(Object r10, Function1<? super Throwable, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "transform");
        Throwable r12 = Result.m35exceptionOrNullimpl(r10);
        if (r12 == null) goto L12;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L7
        return Result.m32constructorimpl(r11.invoke(r12));
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        return Result.m32constructorimpl(createFailure(th));
    L12:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R> Object runCatching(T r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        return Result.m32constructorimpl(r11.invoke(r10));
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        return Result.m32constructorimpl(createFailure(th));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R> Object runCatching(Function0<? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        return Result.m32constructorimpl(r10.invoke());
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        return Result.m32constructorimpl(createFailure(th));
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void throwOnFailure(Object r10) {
        if ((r10 instanceof Result.Failure) == true) goto L6;
        return;
    L6:
        throw ((Result.Failure) r10).exception;
    }
}
