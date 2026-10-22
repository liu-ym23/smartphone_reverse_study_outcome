package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper", f = "MessageCopyHelper.kt", i = {}, l = {576}, m = "resolveFileAttachmentCachePath", n = {}, s = {})
public final class MessageCopyHelper$resolveFileAttachmentCachePath$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageCopyHelper this$0;

    public MessageCopyHelper$resolveFileAttachmentCachePath$1(MessageCopyHelper r1, Continuation<? super MessageCopyHelper$resolveFileAttachmentCachePath$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MessageCopyHelper r3 = this.this$0;
        MessageCopyHelper r0 = MessageCopyHelper.a;
        return r3.l(null, null, this);
    }
}
