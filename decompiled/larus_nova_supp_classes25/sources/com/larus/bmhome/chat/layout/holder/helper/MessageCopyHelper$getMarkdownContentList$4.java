package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper", f = "MessageCopyHelper.kt", i = {0, 0, 0, 0, 0}, l = {179}, m = "getMarkdownContentList", n = {"context", "customMarkDownInfo", "structCache", "finished", "maxContentWidth"}, s = {"L$0", "L$1", "L$2", "Z$0", "I$0"})
public final class MessageCopyHelper$getMarkdownContentList$4 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageCopyHelper this$0;

    public MessageCopyHelper$getMarkdownContentList$4(MessageCopyHelper r1, Continuation<? super MessageCopyHelper$getMarkdownContentList$4> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, false, 0, null, null, false, false, null, this);
    }
}
