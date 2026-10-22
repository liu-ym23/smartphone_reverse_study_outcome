package com.larus.bmhome;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.AiChatUgcAIGCServiceImpl", f = "AiChatUgcAIGCServiceImpl.kt", i = {0, 0, 0}, l = {830}, m = "resolveNoWatermarkVideoPlayData", n = {"videoPlayData", "coverKey", "vid"}, s = {"L$0", "L$1", "L$2"})
public final class AiChatUgcAIGCServiceImpl$resolveNoWatermarkVideoPlayData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiChatUgcAIGCServiceImpl this$0;

    public AiChatUgcAIGCServiceImpl$resolveNoWatermarkVideoPlayData$1(AiChatUgcAIGCServiceImpl r1, Continuation<? super AiChatUgcAIGCServiceImpl$resolveNoWatermarkVideoPlayData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.L0(null, null, null, this);
    }
}
