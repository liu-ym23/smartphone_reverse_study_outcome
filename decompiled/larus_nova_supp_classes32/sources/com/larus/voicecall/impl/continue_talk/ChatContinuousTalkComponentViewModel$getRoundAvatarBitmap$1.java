package com.larus.voicecall.impl.continue_talk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponentViewModel", f = "ChatContinuousTalkComponentViewModel.kt", i = {}, l = {648}, m = "getRoundAvatarBitmap", n = {}, s = {})
public final class ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatContinuousTalkComponentViewModel this$0;

    public ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$1(ChatContinuousTalkComponentViewModel r1, Continuation<? super ChatContinuousTalkComponentViewModel$getRoundAvatarBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatContinuousTalkComponentViewModel.access$getRoundAvatarBitmap(this.this$0, this);
    }
}
