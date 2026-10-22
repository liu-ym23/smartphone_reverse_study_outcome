package com.larus.avlink.e.model.session_memory;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.model.session_memory.SessionMemoryMode", f = "SessionMemoryMode.kt", i = {0}, l = {DoraCallStateCode.DOUBAO_CMD_12}, m = "reportSessionMemory", n = {"request"}, s = {"L$0"})
final class SessionMemoryMode$reportSessionMemory$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionMemoryMode this$0;

    public SessionMemoryMode$reportSessionMemory$1(SessionMemoryMode r1, Continuation<? super SessionMemoryMode$reportSessionMemory$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SessionMemoryMode.a(this.this$0, this);
    }
}
