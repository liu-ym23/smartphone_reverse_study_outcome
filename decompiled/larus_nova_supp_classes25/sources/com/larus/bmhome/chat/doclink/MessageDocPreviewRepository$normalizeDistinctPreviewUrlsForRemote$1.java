package com.larus.bmhome.chat.doclink;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.doclink.MessageDocPreviewRepository", f = "MessageDocPreviewRepository.kt", i = {0, 0}, l = {DoraCallStateCode.DOUBAO_CMD_13}, m = "normalizeDistinctPreviewUrlsForRemote", n = {"distinctUrls", "waitedTime"}, s = {"L$0", "J$0"})
public final class MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDocPreviewRepository this$0;

    public MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1(MessageDocPreviewRepository r1, Continuation<? super MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MessageDocPreviewRepository r3 = this.this$0;
        MessageDocPreviewRepository r0 = MessageDocPreviewRepository.a;
        return r3.f(null, this);
    }
}
