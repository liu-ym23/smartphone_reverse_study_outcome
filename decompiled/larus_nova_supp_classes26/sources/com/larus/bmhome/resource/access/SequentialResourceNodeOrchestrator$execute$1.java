package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.SequentialResourceNodeOrchestrator", f = "ResourceAccessPipeline.kt", i = {0, 0}, l = {436}, m = "execute", n = {"task", "context"}, s = {"L$0", "L$1"})
final class SequentialResourceNodeOrchestrator$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c1 this$0;

    public SequentialResourceNodeOrchestrator$execute$1(c1 r1, Continuation<? super SequentialResourceNodeOrchestrator$execute$1> r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
