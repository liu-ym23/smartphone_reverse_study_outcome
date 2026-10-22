package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.SuggestPromptBotsCreator", f = "SuggestPromptBotsCreator.kt", i = {0, 0}, l = {MessageCellStateTransformerType.NESTED_FILE}, m = "requireBot", n = {"botId", "callBack"}, s = {"L$0", "L$1"})
final class SuggestPromptBotsCreator$requireBot$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a3 this$0;

    public SuggestPromptBotsCreator$requireBot$1(a3 r1, Continuation<? super SuggestPromptBotsCreator$requireBot$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
