package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {729}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(f r5, Continuation<? super SelectImplementation$processResultAndInvokeBlockRecoveringException$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        f r10 = this.this$0;
        AtomicReferenceFieldUpdater r11 = f.f;
        r10.getClass();
        int r12 = this.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r12 - Integer.MIN_VALUE;
    L6:
        Object r13 = this.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = this.label;
        if (r14 != 0) goto L9;
        ResultKt.throwOnFailure(r13);
        throw null;
    L9:
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 this = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(r10, this);
        goto L6
    }
}
