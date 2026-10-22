package com.larus.profile.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.CreationServiceImpl", f = "CreationServiceImpl.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {137, 167}, m = "addCreation", n = {"messageId", "type", "index", "creationTaskId", "materialId", "privateStatus", "source"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"})
public final class CreationServiceImpl$addCreation$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationServiceImpl this$0;

    public CreationServiceImpl$addCreation$1(CreationServiceImpl r1, Continuation<? super CreationServiceImpl$addCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, 0, null, 0, null, this);
    }
}
