package com.larus.bmhome.chat.layout.holder.image.utils;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils", f = "AiCreationEditUtils.kt", i = {0, 0, 0, 0}, l = {733, 756}, m = "handleDirectSendAction", n = {"context", "cvsId", "botId", "conversation"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class AiCreationEditUtils$handleDirectSendAction$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiCreationEditUtils this$0;

    public AiCreationEditUtils$handleDirectSendAction$1(AiCreationEditUtils r1, Continuation<? super AiCreationEditUtils$handleDirectSendAction$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r17) {
        this.result = r17;
        this.label |= Integer.MIN_VALUE;
        return AiCreationEditUtils.a(this.this$0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, this);
    }
}
