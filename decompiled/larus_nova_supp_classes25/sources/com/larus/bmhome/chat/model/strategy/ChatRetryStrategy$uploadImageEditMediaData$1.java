package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy", f = "ChatRetryStrategy.kt", i = {0, 0, 1, 1, 2}, l = {639, 648, 654}, m = "uploadImageEditMediaData", n = {"resultMediaAttachment", "imageEditDataWithMask", "resultMediaAttachment", "imageEditDataWithMask", "resultMediaAttachment"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
final class ChatRetryStrategy$uploadImageEditMediaData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$uploadImageEditMediaData$1(ChatRetryStrategy r1, Continuation<? super ChatRetryStrategy$uploadImageEditMediaData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatRetryStrategy.c(this.this$0, null, this);
    }
}
