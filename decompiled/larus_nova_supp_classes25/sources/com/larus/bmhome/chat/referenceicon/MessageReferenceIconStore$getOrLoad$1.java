package com.larus.bmhome.chat.referenceicon;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore", f = "MessageReferenceIconStore.kt", i = {0, 0, 1, 1}, l = {195, 202}, m = "getOrLoad", n = {"key", "loader", "key", "nonNullSharedLoad"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class MessageReferenceIconStore$getOrLoad$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageReferenceIconStore this$0;

    public MessageReferenceIconStore$getOrLoad$1(MessageReferenceIconStore r1, Continuation<? super MessageReferenceIconStore$getOrLoad$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MessageReferenceIconStore r3 = this.this$0;
        MessageReferenceIconStore r0 = MessageReferenceIconStore.a;
        return r3.h(null, null, this);
    }
}
