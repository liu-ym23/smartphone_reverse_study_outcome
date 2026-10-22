package com.obric.memorydata.personalcontext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.CallHistorySourceNumberBackfillManager$RealBackfillRuntime", f = "CallHistorySourceNumberBackfillManager.kt", i = {}, l = {662, 663}, m = "areContentRebuildPackagesAvailable", n = {}, s = {})
final class CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CallHistorySourceNumberBackfillManager.e this$0;

    CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1(CallHistorySourceNumberBackfillManager.e r3, Continuation<? super CallHistorySourceNumberBackfillManager$RealBackfillRuntime$areContentRebuildPackagesAvailable$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
