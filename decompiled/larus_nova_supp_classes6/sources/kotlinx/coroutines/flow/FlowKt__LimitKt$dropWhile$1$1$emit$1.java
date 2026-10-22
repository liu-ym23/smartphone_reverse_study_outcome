package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", i = {1, 1}, l = {ITaskManager.Stub.TRANSACTION_getConditionTaskRecordsByTaskId, ITaskManager.Stub.TRANSACTION_getAllConditionTaskRecords, ITaskManager.Stub.TRANSACTION_removeAllConditionTaskRecords}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
public final class FlowKt__LimitKt$dropWhile$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__LimitKt.dropWhile.1.1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1$emit$1(FlowKt__LimitKt.dropWhile.1.1<? super T> r1, Continuation<? super FlowKt__LimitKt$dropWhile$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= IWakeupSessionConstant.RC_ERROR;
        return this.this$0.emit(null, this);
    }
}
