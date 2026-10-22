package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {151}, m = "last", n = {"result"}, s = {"L$0"})
final class FlowKt__ReduceKt$last$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FlowKt__ReduceKt$last$1(Continuation<? super FlowKt__ReduceKt$last$1> r5) {
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
        T r13 = (T) kotlinx.coroutines.flow.internal.b.f18863b;
        if (r12 == 0) goto L16;
        if (r12 != 1) goto L15;
        Ref.ObjectRef r14 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r11);
        T r15 = r14.element;
        if (r15 == r13) goto L13;
        return r15;
    L13:
        throw new NoSuchElementException("Expected at least one element");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = r13;
        this.L$0 = r16;
        this.label = 1;
        throw null;
    L5:
        FlowKt__ReduceKt$last$1<T> this = new FlowKt__ReduceKt$last$1(this);
        goto L6
    }
}
