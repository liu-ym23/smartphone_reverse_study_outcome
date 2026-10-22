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
@DebugMetadata(c = "obric.flow.utils.RetryKt", f = "Retry.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {32, 34, 36}, m = "retry-dWUq8MI", n = {"action", "times", "delayTime", "retryTime", "action", "times", "delayTime", "retryTime", "action", "res", "times", "delayTime", "retryTime"}, s = {"L$0", "I$0", "J$0", "I$1", "L$0", "I$0", "J$0", "I$1", "L$0", "L$1", "I$0", "J$0", "I$1"})
final class RetryKt$retry$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public RetryKt$retry$1(Continuation<? super RetryKt$retry$1> r5) {
        super(r5);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0099 -> B:13:0x003a). Please report as a decompilation issue!!! */
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
        if (r10 != 0) goto L9;
        ResultKt.throwOnFailure(r14);
        this.L$0 = null;
        this.I$0 = 0;
        this.J$0 = 0;
        this.I$1 = 0;
        this.label = 1;
        throw null;
    L9:
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L16;
        if (r10 != 3) goto L15;
        int r11 = this.I$1;
        long r15 = this.J$0;
        int r16 = this.I$0;
        Object r17 = this.L$1;
        Function1 r18 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r14);
    L13:
        Object r19 = r17;
        Function1 r20 = r18;
    L20:
        if (Result.m130isFailureimpl(r19) == false) goto L28;
        if (r11 >= r16) goto L28;
        this.L$0 = r20;
        this.L$1 = null;
        this.I$0 = r16;
        this.J$0 = r15;
        this.I$1 = r11;
        this.label = 2;
        r14 = r20.invoke(this);
        if (r14 == r5) goto L30;
    L17:
        r18 = r20;
        r17 = ((Result) r14).m133unboximpl();
        r11 = r11 + 1;
        this.L$0 = r18;
        this.L$1 = r17;
        this.I$0 = r16;
        this.J$0 = r15;
        this.I$1 = r11;
        this.label = 3;
        if (DelayKt.m1626delayVtjQ1oo(r15, this) != r5) goto L13;
    L30:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        return r5;
    L33:
        return Result.m123boximpl(r5);
    L28:
        r5 = r19;
        goto L30
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r11 = this.I$1;
        r15 = this.J$0;
        r16 = this.I$0;
        r20 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r14);
        goto L17
    L18:
        r11 = this.I$1;
        r15 = this.J$0;
        r16 = this.I$0;
        r20 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r14);
        r19 = ((Result) r14).m133unboximpl();
        goto L20
    L5:
        RetryKt$retry$1<T> this = new RetryKt$retry$1(this);
        goto L6
    }
}
