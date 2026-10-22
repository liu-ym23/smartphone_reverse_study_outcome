package com.larus.community.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.service.CreationServiceImpl", f = "CreationServiceImpl.kt", i = {0}, l = {278}, m = "fetchCreationDetail", n = {"creationId"}, s = {"L$0"})
public final class CreationServiceImpl$fetchCreationDetail$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationServiceImpl this$0;

    public CreationServiceImpl$fetchCreationDetail$1(CreationServiceImpl r1, Continuation<? super CreationServiceImpl$fetchCreationDetail$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o1(null, this);
    }
}
