package com.larus.business.floatchat.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.AIChatInputUtils", f = "AIChatInputUtils.kt", i = {2}, l = {239, 243, 246}, m = "getMainConversationInfo", n = {"mainConvId"}, s = {"L$0"})
public final class AIChatInputUtils$getMainConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIChatInputUtils this$0;

    public AIChatInputUtils$getMainConversationInfo$1(AIChatInputUtils r1, Continuation<? super AIChatInputUtils$getMainConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
