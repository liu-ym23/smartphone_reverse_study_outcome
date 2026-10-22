package com.larus.uaigc.createpage.utils;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.CreationRemoteConversationHelper", f = "CreationRemoteConversationHelper.kt", i = {0, 0, 1, 1, 1, 2}, l = {75, 89, 95}, m = "resolveRemoteIfLocalSubConversation", n = {"conversationId", "fallbackBotId", "conversationId", "fallbackBotId", "localConversation", "conversationId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
public final class CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationRemoteConversationHelper this$0;

    public CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1(CreationRemoteConversationHelper r1, Continuation<? super CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationRemoteConversationHelper r3 = this.this$0;
        CreationRemoteConversationHelper r0 = CreationRemoteConversationHelper.a;
        return r3.c(null, null, this);
    }
}
