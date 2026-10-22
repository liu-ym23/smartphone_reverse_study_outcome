package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.endpoint.AiKeySessionEndpoint", f = "AiKeySessionEndpoint.kt", i = {0}, l = {181}, m = "onSessionProcess", n = {"args"}, s = {"L$0"})
public final class AiKeySessionEndpoint$onSessionProcess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiKeySessionEndpoint this$0;

    public AiKeySessionEndpoint$onSessionProcess$1(AiKeySessionEndpoint r1, Continuation<? super AiKeySessionEndpoint$onSessionProcess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
