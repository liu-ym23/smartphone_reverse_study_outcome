package kotlinx.coroutines.selects;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {712}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation<Object> this$0;

    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation<Object> r1, Continuation<? super SelectImplementation$processResultAndInvokeBlockRecoveringException$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= IWakeupSessionConstant.RC_ERROR;
        SelectImplementation<Object> r5 = this.this$0;
        AtomicReferenceFieldUpdater r1 = SelectImplementation.f;
        r5.getClass();
        int r2 = this.label;
        if ((r2 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r2 - IWakeupSessionConstant.RC_ERROR;
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = this;
    L6:
        Object r6 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 != 0) goto L9;
        ResultKt.throwOnFailure(r6);
        throw null;     // Catch: Throwable -> L16
    L9:
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L16
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        th = move-exception;
        throw th;
    L5:
        r0 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(r5, this);
        goto L6
    }
}
