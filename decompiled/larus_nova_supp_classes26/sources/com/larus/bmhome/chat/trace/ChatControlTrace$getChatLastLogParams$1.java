package com.larus.bmhome.chat.trace;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace", f = "ChatControlTrace.kt", i = {0, 1, 1}, l = {5128, 5132}, m = "getChatLastLogParams", n = {"lastShownMsg", "lastBotMsg", "lastUserMsg"}, s = {"L$0", "L$0", "L$1"})
public final class ChatControlTrace$getChatLastLogParams$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatControlTrace this$0;

    public ChatControlTrace$getChatLastLogParams$1(ChatControlTrace r1, Continuation<? super ChatControlTrace$getChatLastLogParams$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Ob(null, null, this);
    }
}
