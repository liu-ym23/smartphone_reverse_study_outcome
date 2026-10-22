package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper", f = "MessageCopyHelper.kt", i = {0, 0, 0, 0, 0}, l = {110}, m = "getMarkdownContentList", n = {"context", "customMarkDownInfo", "markwonStructCache", "maxContentWidth", "msgFinished"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"})
public final class MessageCopyHelper$getMarkdownContentList$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageCopyHelper this$0;

    public MessageCopyHelper$getMarkdownContentList$1(MessageCopyHelper r1, Continuation<? super MessageCopyHelper$getMarkdownContentList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, null, null, null, this);
    }
}
