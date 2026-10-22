package com.larus.bmhome.debug;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.debug.ChatDebugFragment", f = "ChatDebugFragment.kt", i = {0, 0}, l = {630}, m = "replaceExistingBotBlockMessages", n = {"botId", "blocks"}, s = {"L$0", "L$1"})
final class ChatDebugFragment$replaceExistingBotBlockMessages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatDebugFragment this$0;

    public ChatDebugFragment$replaceExistingBotBlockMessages$1(ChatDebugFragment r1, Continuation<? super ChatDebugFragment$replaceExistingBotBlockMessages$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatDebugFragment.S90(this.this$0, null, null, this);
    }
}
