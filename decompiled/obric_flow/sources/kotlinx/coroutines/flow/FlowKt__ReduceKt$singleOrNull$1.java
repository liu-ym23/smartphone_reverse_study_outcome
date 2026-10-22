package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {179}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
final class FlowKt__ReduceKt$singleOrNull$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public FlowKt__ReduceKt$singleOrNull$1(Continuation<? super FlowKt__ReduceKt$singleOrNull$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label = (this.label | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        T r11 = (T) kotlinx.coroutines.flow.internal.b.f18863b;
        if (r5 == 0) goto L12;
        if (r5 != 1) goto L11;
        b1 r12 = (b1) this.L$1;
        Ref.ObjectRef r13 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: AbortFlowException -> L8
    L19:
        T r14 = r13.element;
        if (r14 != r11) goto L23;
        return null;
    L23:
        return r14;
    L8:
        AbortFlowException e = e;
    L18:
        if (e.owner == r12) goto L19;
        throw e;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = r11;
        r12 = new b1(r15);
        this.L$0 = r15;     // Catch: AbortFlowException -> L15
        this.L$1 = r12;     // Catch: AbortFlowException -> L15
        this.label = 1;     // Catch: AbortFlowException -> L15
        throw null;
    L15:
        e = move-exception;
        e = e;
        r13 = r15;
        goto L18
    }
}
