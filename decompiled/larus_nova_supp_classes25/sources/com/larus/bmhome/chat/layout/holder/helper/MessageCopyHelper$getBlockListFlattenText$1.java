package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper", f = "MessageCopyHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {279, 283}, m = "getBlockListFlattenText", n = {"internalSeparator", "extentBlockText", "destination$iv$iv", "includeMetaInfo", "forceUseResearchBrief", "internalSeparator", "extentBlockText", "destination$iv$iv", "includeMetaInfo", "forceUseResearchBrief"}, s = {"L$0", "L$1", "L$2", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0", "Z$1"})
public final class MessageCopyHelper$getBlockListFlattenText$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageCopyHelper this$0;

    public MessageCopyHelper$getBlockListFlattenText$1(MessageCopyHelper r1, Continuation<? super MessageCopyHelper$getBlockListFlattenText$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, false, null, false, null, this);
    }
}
