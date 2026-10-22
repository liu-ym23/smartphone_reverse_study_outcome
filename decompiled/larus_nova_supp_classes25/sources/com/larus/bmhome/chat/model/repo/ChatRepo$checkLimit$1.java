package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatRepo", f = "ChatRepo.kt", i = {0, 0, 2, 2, 3, 3}, l = {663, 664, 670, 682, 683}, m = "checkLimit", n = {"getLatestLimitInfo", "notifyLimitInfo", "getLatestLimitInfo", "notifyLimitInfo", "getLatestLimitInfo", "notifyLimitInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class ChatRepo$checkLimit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatRepo this$0;

    public ChatRepo$checkLimit$1(ChatRepo r1, Continuation<? super ChatRepo$checkLimit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ChatRepo r3 = this.this$0;
        int r0 = ChatRepo.f;
        return r3.a(null, null, this);
    }
}
