package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.ChatMessageComponent", f = "ChatMessageComponent.kt", i = {0}, l = {238}, m = "runSuspendSafely", n = {"functionName"}, s = {"L$0"})
public final class ChatMessageComponent$runSuspendSafely$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatMessageComponent this$0;

    public ChatMessageComponent$runSuspendSafely$1(ChatMessageComponent r1, Continuation<? super ChatMessageComponent$runSuspendSafely$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ChatMessageComponent r3 = this.this$0;
        int r0 = ChatMessageComponent.j;
        return r3.P2(null, null, this);
    }
}
