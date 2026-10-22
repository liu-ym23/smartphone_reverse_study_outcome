package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendUtils", f = "ChatSendUtils.kt", i = {}, l = {499}, m = "getLocalCvsUplinkMeta$impl_mainlandRelease", n = {}, s = {})
public final class ChatSendUtils$getLocalCvsUplinkMeta$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatSendUtils this$0;

    public ChatSendUtils$getLocalCvsUplinkMeta$1(ChatSendUtils r1, Continuation<? super ChatSendUtils$getLocalCvsUplinkMeta$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, this);
    }
}
