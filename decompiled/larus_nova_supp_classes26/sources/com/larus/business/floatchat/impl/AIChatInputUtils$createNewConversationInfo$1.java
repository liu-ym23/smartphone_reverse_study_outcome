package com.larus.business.floatchat.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.AIChatInputUtils", f = "AIChatInputUtils.kt", i = {1, 1, 2, 2, 3, 3, 3, 4, 4}, l = {255, 258, 265, 271, 282}, m = "createNewConversationInfo", n = {"context", "customSuffix", "context", "customSuffix", "context", "customSuffix", "botId", "botId", "botModel"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class AIChatInputUtils$createNewConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIChatInputUtils this$0;

    public AIChatInputUtils$createNewConversationInfo$1(AIChatInputUtils r1, Continuation<? super AIChatInputUtils$createNewConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
