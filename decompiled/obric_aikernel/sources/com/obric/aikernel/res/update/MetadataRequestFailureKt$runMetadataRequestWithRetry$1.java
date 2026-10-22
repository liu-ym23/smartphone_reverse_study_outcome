package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequestFailureKt", f = "MetadataRequestFailure.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {99, 107}, m = "runMetadataRequestWithRetry", n = {"executeAttempt", "delayFn", "onAttemptFailure", "attempt", "executeAttempt", "delayFn", "onAttemptFailure", "attempt"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"})
final class MetadataRequestFailureKt$runMetadataRequestWithRetry$1<T> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    MetadataRequestFailureKt$runMetadataRequestWithRetry$1(Continuation<? super MetadataRequestFailureKt$runMetadataRequestWithRetry$1> r10) {
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return MetadataRequestFailureKt.g(null, null, null, this);
    }
}
