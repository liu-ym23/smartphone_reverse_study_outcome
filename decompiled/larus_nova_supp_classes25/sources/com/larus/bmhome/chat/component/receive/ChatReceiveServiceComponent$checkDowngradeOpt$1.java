package com.larus.bmhome.chat.component.receive;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.receive.ChatReceiveServiceComponent", f = "ChatReceiveServiceComponent.kt", i = {0, 0}, l = {955, 973}, m = "checkDowngradeOpt", n = {"uris", "multimodalDowngradeData"}, s = {"L$0", "L$1"})
final class ChatReceiveServiceComponent$checkDowngradeOpt$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatReceiveServiceComponent this$0;

    public ChatReceiveServiceComponent$checkDowngradeOpt$1(ChatReceiveServiceComponent r1, Continuation<? super ChatReceiveServiceComponent$checkDowngradeOpt$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatReceiveServiceComponent.F2(this.this$0, null, this);
    }
}
