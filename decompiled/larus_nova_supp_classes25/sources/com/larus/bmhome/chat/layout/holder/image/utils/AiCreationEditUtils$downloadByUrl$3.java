package com.larus.bmhome.chat.layout.holder.image.utils;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils", f = "AiCreationEditUtils.kt", i = {0}, l = {1111}, m = "downloadByUrl", n = {"dataSubscriber"}, s = {"L$0"})
public final class AiCreationEditUtils$downloadByUrl$3 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiCreationEditUtils this$0;

    public AiCreationEditUtils$downloadByUrl$3(AiCreationEditUtils r1, Continuation<? super AiCreationEditUtils$downloadByUrl$3> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AiCreationEditUtils r3 = this.this$0;
        AiCreationEditUtils r0 = AiCreationEditUtils.a;
        return r3.f(null, null, null, this);
    }
}
