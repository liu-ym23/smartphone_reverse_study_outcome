package com.larus.business.floatchat.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.AIChatInputUtils", f = "AIChatInputUtils.kt", i = {0, 0, 0, 0, 0}, l = {162}, m = "integrateFloatChatFragment$withNewConv", n = {"$bundle", "$sceneKey", "$conversationDeletedAbility", "$initialInputConfig", "$hasBottomTab"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"})
public final class AIChatInputUtils$integrateFloatChatFragment$withNewConv$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public AIChatInputUtils$integrateFloatChatFragment$withNewConv$1(Continuation<? super AIChatInputUtils$integrateFloatChatFragment$withNewConv$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return AIChatInputUtils.g(null, null, null, false, null, null, this);
    }
}
