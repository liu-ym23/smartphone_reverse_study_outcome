package com.larus.bmhome.chat.helper;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ConversationClickHelper", f = "ConversationClickHelper.kt", i = {0, 0, 0, 0}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_HEARTBEAT}, m = "directToRealtimeCall", n = {"data", "argPosition", "recommendFromString", "conversationId"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class ConversationClickHelper$directToRealtimeCall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationClickHelper this$0;

    public ConversationClickHelper$directToRealtimeCall$1(ConversationClickHelper r1, Continuation<? super ConversationClickHelper$directToRealtimeCall$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ConversationClickHelper.a(this.this$0, null, null, null, this);
    }
}
