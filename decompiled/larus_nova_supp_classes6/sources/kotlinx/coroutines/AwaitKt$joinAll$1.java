package kotlinx.coroutines;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {ITaskManager.Stub.TRANSACTION_getTemplateIdNotNullEventTasks}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
final class AwaitKt$joinAll$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public AwaitKt$joinAll$1(Continuation<? super AwaitKt$joinAll$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        int r8 = this.label | IWakeupSessionConstant.RC_ERROR;
        this.label = r8;
        if ((r8 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r8 - IWakeupSessionConstant.RC_ERROR;
        AwaitKt$joinAll$1 r9 = this;
    L6:
        Object r0 = r9.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r9.label;
        if (r2 != 0) goto L9;
        ResultKt.throwOnFailure(r0);
        throw null;
    L9:
        if (r2 != 1) goto L19;
        int r3 = r9.I$1;
        int r4 = r9.I$0;
        Job[] r5 = (Job[]) r9.L$0;
        ResultKt.throwOnFailure(r0);
    L11:
        r4 = r4 + 1;
        if (r4 >= r3) goto L17;
        Job r6 = r5[r4];
        r9.L$0 = r5;
        r9.I$0 = r4;
        r9.I$1 = r3;
        r9.label = 1;
        if (r6.join(r9) != r1) goto L11;
        return r1;
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r9 = new AwaitKt$joinAll$1(this);
        goto L6
    }
}
