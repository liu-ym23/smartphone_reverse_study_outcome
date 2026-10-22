package com.larus.bmhome.instruction.suggest;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.suggest.JumpUgcBotAction", f = "JumpUgcBotAction.kt", i = {0, 0, 1, 1, 2, 2, 3}, l = {121, 127, 131, 140}, m = "checkAndCreateConversation", n = {"botId", "botInfo", "botId", "botInfo", "botInfo", "conversationId", "conversationId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
final class JumpUgcBotAction$checkAndCreateConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public JumpUgcBotAction$checkAndCreateConversation$1(a r1, Continuation<? super JumpUgcBotAction$checkAndCreateConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, null, null, this);
    }
}
