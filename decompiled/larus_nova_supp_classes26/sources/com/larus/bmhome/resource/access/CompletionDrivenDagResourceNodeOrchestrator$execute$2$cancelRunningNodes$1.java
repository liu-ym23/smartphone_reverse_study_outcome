package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.CompletionDrivenDagResourceNodeOrchestrator$execute$2", f = "ResourceAccessPipeline.kt", i = {0, 0}, l = {496}, m = "invokeSuspend$cancelRunningNodes", n = {"runningJobs", "runningNodes"}, s = {"L$0", "L$1"})
public final class CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1(Continuation<? super CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CompletionDrivenDagResourceNodeOrchestrator$execute$2.access$invokeSuspend$cancelRunningNodes(null, null, this);
    }
}
