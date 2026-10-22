package com.larus.dispatcher.askhuman.handler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor$CompletionDelegate", f = "RequestActionBrowserOperationInterceptor.kt", i = {}, l = {223}, m = "completeLocalPc", n = {}, s = {})
public final class RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RequestActionBrowserOperationInterceptor.CompletionDelegate this$0;

    public RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1(RequestActionBrowserOperationInterceptor.CompletionDelegate r1, Continuation<? super RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
