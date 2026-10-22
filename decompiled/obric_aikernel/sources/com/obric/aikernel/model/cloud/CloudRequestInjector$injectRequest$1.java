package com.obric.aikernel.model.cloud;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model.cloud.CloudRequestInjector", f = "CloudRequestInjector.kt", i = {0}, l = {34}, m = "injectRequest", n = {"params"}, s = {"L$0"})
final class CloudRequestInjector$injectRequest$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudRequestInjector this$0;

    CloudRequestInjector$injectRequest$1(CloudRequestInjector r10, Continuation<? super CloudRequestInjector$injectRequest$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
