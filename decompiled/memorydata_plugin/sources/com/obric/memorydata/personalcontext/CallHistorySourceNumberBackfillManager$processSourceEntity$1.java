package com.obric.memorydata.personalcontext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager", f = "CallHistorySourceNumberBackfillManager.kt", i = {0, 0, 0}, l = {247, 255}, m = "processSourceEntity", n = {"this", "runtime", "attemptCount"}, s = {"L$0", "L$1", "I$0"})
final class CallHistorySourceNumberBackfillManager$processSourceEntity$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CallHistorySourceNumberBackfillManager this$0;

    CallHistorySourceNumberBackfillManager$processSourceEntity$1(CallHistorySourceNumberBackfillManager r3, Continuation<? super CallHistorySourceNumberBackfillManager$processSourceEntity$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return CallHistorySourceNumberBackfillManager.a(this.this$0, null, null, null, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
