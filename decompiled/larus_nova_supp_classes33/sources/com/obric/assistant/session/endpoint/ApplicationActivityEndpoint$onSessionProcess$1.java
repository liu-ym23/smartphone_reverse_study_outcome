package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.endpoint.ApplicationActivityEndpoint", f = "ApplicationActivityEndpoint.kt", i = {}, l = {48}, m = "onSessionProcess", n = {}, s = {})
public final class ApplicationActivityEndpoint$onSessionProcess$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApplicationActivityEndpoint this$0;

    public ApplicationActivityEndpoint$onSessionProcess$1(ApplicationActivityEndpoint r1, Continuation<? super ApplicationActivityEndpoint$onSessionProcess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
