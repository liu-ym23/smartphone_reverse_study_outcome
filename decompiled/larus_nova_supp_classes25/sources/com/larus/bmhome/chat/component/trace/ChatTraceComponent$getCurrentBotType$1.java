package com.larus.bmhome.chat.component.trace;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatTraceComponent", f = "ChatTraceComponent.kt", i = {}, l = {1136}, m = "getCurrentBotType", n = {}, s = {})
final class ChatTraceComponent$getCurrentBotType$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatTraceComponent this$0;

    public ChatTraceComponent$getCurrentBotType$1(ChatTraceComponent r1, Continuation<? super ChatTraceComponent$getCurrentBotType$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatTraceComponent.F2(this.this$0, null, this);
    }
}
