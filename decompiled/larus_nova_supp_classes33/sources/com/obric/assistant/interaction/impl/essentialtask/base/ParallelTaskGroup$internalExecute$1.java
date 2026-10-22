package com.obric.assistant.interaction.impl.essentialtask.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.ParallelTaskGroup", f = "ParallelTaskGroup.kt", i = {0}, l = {29}, m = "internalExecute", n = {"startTime"}, s = {"J$0"})
public final class ParallelTaskGroup$internalExecute$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ParallelTaskGroup this$0;

    public ParallelTaskGroup$internalExecute$1(ParallelTaskGroup r1, Continuation<? super ParallelTaskGroup$internalExecute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.internalExecute(this);
    }
}
