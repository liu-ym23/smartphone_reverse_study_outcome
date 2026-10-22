package com.obric.assistant.interaction.impl.essentialtask.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.SequentialTaskGroup", f = "SequentialTaskGroup.kt", i = {0, 0}, l = {24}, m = "internalExecute", n = {"subTask", "startTime"}, s = {"L$2", "J$0"})
public final class SequentialTaskGroup$internalExecute$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SequentialTaskGroup this$0;

    public SequentialTaskGroup$internalExecute$1(SequentialTaskGroup r1, Continuation<? super SequentialTaskGroup$internalExecute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.internalExecute(this);
    }
}
