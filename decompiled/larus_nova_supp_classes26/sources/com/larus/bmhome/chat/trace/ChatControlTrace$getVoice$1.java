package com.larus.bmhome.chat.trace;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace", f = "ChatControlTrace.kt", i = {}, l = {2889}, m = "getVoice", n = {}, s = {})
public final class ChatControlTrace$getVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatControlTrace this$0;

    public ChatControlTrace$getVoice$1(ChatControlTrace r1, Continuation<? super ChatControlTrace$getVoice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ChatControlTrace r3 = this.this$0;
        ChatControlTrace r0 = ChatControlTrace.b;
        return r3.B(null, this);
    }
}
