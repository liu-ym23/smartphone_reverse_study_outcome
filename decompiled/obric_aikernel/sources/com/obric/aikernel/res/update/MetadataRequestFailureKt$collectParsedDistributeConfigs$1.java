package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequestFailureKt", f = "MetadataRequestFailure.kt", i = {0, 0, 0, 0}, l = {168}, m = "collectParsedDistributeConfigs", n = {"parseLoras", "onBusinessFailure", "onLoraFailure", "dists"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class MetadataRequestFailureKt$collectParsedDistributeConfigs$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    MetadataRequestFailureKt$collectParsedDistributeConfigs$1(Continuation<? super MetadataRequestFailureKt$collectParsedDistributeConfigs$1> r10) {
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return MetadataRequestFailureKt.a(null, null, null, null, this);
    }
}
