package com.obric.memorydata.personalcontext.search.global;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.AbstractGlobalAssistantSearchSession", f = "AbstractGlobalAssistantSearchSession.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {184, 237}, m = "executeSearchWithoutHandleResults", n = {"this", "this", "taskRequestList", "sum", "slotResultGroupByAction", "queryRewrite", "taskName", "taskStartTime", CommonConsts.APM_INNER_EVENT_COST_START}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "J$0", "J$1"})
final class AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1(a r3, Continuation<? super AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
