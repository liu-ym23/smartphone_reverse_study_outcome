package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatReceiver$registerImFlow$1$1", f = "ChatReceiver.kt", i = {0}, l = {256, 256, 345, 347}, m = "emit", n = {"it"}, s = {"L$0"})
public final class ChatReceiver$registerImFlow$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatReceiver.registerImFlow.1.1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatReceiver$registerImFlow$1$1$emit$1(ChatReceiver.registerImFlow.1.1<? super T> r1, Continuation<? super ChatReceiver$registerImFlow$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
