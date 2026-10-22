package com.larus.bmhome.chat.layout.holder.image.utils;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils", f = "AiCreationEditUtils.kt", i = {}, l = {319}, m = "resolveImageResource", n = {}, s = {})
final class AiCreationEditUtils$resolveImageResource$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiCreationEditUtils this$0;

    public AiCreationEditUtils$resolveImageResource$1(AiCreationEditUtils r1, Continuation<? super AiCreationEditUtils$resolveImageResource$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AiCreationEditUtils.b(this.this$0, null, this);
    }
}
