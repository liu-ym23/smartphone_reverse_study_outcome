package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.ReactAgentConcurrentExecutor", f = "ReactAgentConcurrentExecutor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {74, 80}, m = "executeReActPackageSearchWithConcurrency", n = {"queryId", "queryList", "referenceQuery", "searchType", ChatMessage.TYPE_RESPONSE, "businessName", "meta", "searchContentDomain", "agentPackage", "needContent", "timeoutMs", "requestId", ChatMessage.TYPE_RESPONSE, "agentPackage", "requestId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "J$0", "J$1", "L$0", "L$1", "J$0"})
final class ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ h this$0;

    ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1(h r3, Continuation<? super ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, false, null, null, 0, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
