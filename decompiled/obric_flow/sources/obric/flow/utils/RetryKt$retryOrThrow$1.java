package obric.flow.utils;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.utils.RetryKt", f = "Retry.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {16, 20, 21}, m = "retryOrThrow-WPwdCS8", n = {"onEveryTimeFailure", "action", "times", "delayTime", "retryTime", "onEveryTimeFailure", "action", "times", "delayTime", "retryTime", "onEveryTimeFailure", "action", "times", "delayTime", "retryTime"}, s = {"L$0", "L$1", "I$0", "J$0", "I$1", "L$0", "L$1", "I$0", "J$0", "I$1", "L$0", "L$1", "I$0", "J$0", "I$1"})
final class RetryKt$retryOrThrow$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public RetryKt$retryOrThrow$1(Continuation<? super RetryKt$retryOrThrow$1> r5) {
        super(r5);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00cc -> B:42:0x00cf). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        int r13 = this.label | Integer.MIN_VALUE;
        this.label = r13;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r13 - Integer.MIN_VALUE;
    L6:
        Object r14 = this.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L18;
        if (r10 != 3) goto L17;
        int r11 = this.I$1;
        long r15 = this.J$0;
        int r16 = this.I$0;
        Function1 r17 = (Function1) this.L$1;
        Function1 r18 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L42:
        Object r19 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L14
    L45:
        Throwable r110 = Result.m127exceptionOrNullimpl(r19);
        if (r110 == null) goto L34;
        r18.invoke(r110);
    L34:
        if (Result.m130isFailureimpl(r19) == false) goto L48;
        if (r11 > r16) goto L48;
        r11 = r11 + 1;
        this.L$0 = r18;
        this.L$1 = r17;
        this.I$0 = r16;
        this.J$0 = r15;
        this.I$1 = r11;
        this.label = 2;
        if (DelayKt.m1626delayVtjQ1oo(r15, this) == r5) goto L57;
    L39:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L14
        this.L$0 = r18;     // Catch: Throwable -> L14
        this.L$1 = r17;     // Catch: Throwable -> L14
        this.I$0 = r16;     // Catch: Throwable -> L14
        this.J$0 = r15;     // Catch: Throwable -> L14
        this.I$1 = r11;     // Catch: Throwable -> L14
        this.label = 3;     // Catch: Throwable -> L14
        r14 = r17.invoke(this);     // Catch: Throwable -> L14
        if (r14 != r5) goto L42;
        return r5;
    L57:
        return r5;
    L48:
        ResultKt.throwOnFailure(r19);
        return r19;
    L14:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r11 = this.I$1;
        r15 = this.J$0;
        r16 = this.I$0;
        r17 = (Function1) this.L$1;
        r18 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r14);
        goto L39
    L19:
        r11 = this.I$1;
        r15 = this.J$0;
        r16 = this.I$0;
        r17 = (Function1) this.L$1;
        r18 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
        r19 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L22
    L30:
        Throwable r113 = Result.m127exceptionOrNullimpl(r19);
        if (r113 == null) goto L34;
        r18.invoke(r113);
    L22:
        th = th;
    L29:
        Result.Companion r114 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L30
    L24:
        ResultKt.throwOnFailure(r14);
        r16 = 0;
        r15 = 0;
        r17 = null;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L27
        this.L$0 = null;     // Catch: Throwable -> L27
        this.L$1 = null;     // Catch: Throwable -> L27
        this.I$0 = 0;     // Catch: Throwable -> L27
        this.J$0 = 0;     // Catch: Throwable -> L27
        this.I$1 = 1;     // Catch: Throwable -> L27
        this.label = 1;     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L27:
        th = th;
        r11 = 1;
        r18 = null;
        goto L29
    L5:
        RetryKt$retryOrThrow$1<T> this = new RetryKt$retryOrThrow$1(this);
        goto L6
    }
}
