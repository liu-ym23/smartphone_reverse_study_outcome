package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {13}, m = "count", n = {"i"}, s = {"L$0"})
final class FlowKt__CountKt$count$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FlowKt__CountKt$count$1(Continuation<? super FlowKt__CountKt$count$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r10 = this.label | Integer.MIN_VALUE;
        this.label = r10;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r10 - Integer.MIN_VALUE;
    L6:
        Object r11 = this.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L13;
        if (r12 != 1) goto L12;
        Ref.IntRef r13 = (Ref.IntRef) this.L$0;
        ResultKt.throwOnFailure(r11);
        return Boxing.boxInt(r13.element);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r11);
        this.L$0 = new Ref.IntRef();
        this.label = 1;
        throw null;
    L5:
        FlowKt__CountKt$count$1<T> this = new FlowKt__CountKt$count$1(this);
        goto L6
    }
}
