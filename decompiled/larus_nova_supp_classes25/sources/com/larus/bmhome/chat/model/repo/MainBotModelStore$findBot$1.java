package com.larus.bmhome.chat.model.repo;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.MainBotModelStore", f = "MainBotModelStore.kt", i = {0, 0}, l = {DoraCallStateCode.DOUBAO_CMD_12}, m = "findBot", n = {"requestScope", "shared"}, s = {"L$0", "I$0"})
public final class MainBotModelStore$findBot$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainBotModelStore this$0;

    public MainBotModelStore$findBot$1(MainBotModelStore r1, Continuation<? super MainBotModelStore$findBot$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, false, null, false, this);
    }
}
