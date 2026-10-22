package com.obric.assistant.block.lark.knowledge_authorized;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.lark.knowledge_authorized.LarkKnowledgeAuthorizedBlockHolder", f = "LarkKnowledgeAuthorizedBlockHolder.kt", i = {0}, l = {157}, m = "getLastMessage", n = {"cvsId"}, s = {"L$0"})
final class LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkKnowledgeAuthorizedBlockHolder this$0;

    public LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1(LarkKnowledgeAuthorizedBlockHolder r1, Continuation<? super LarkKnowledgeAuthorizedBlockHolder$getLastMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return LarkKnowledgeAuthorizedBlockHolder.j(this.this$0, null, this);
    }
}
