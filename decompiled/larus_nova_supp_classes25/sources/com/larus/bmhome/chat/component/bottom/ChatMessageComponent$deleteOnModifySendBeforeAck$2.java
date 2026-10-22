package com.larus.bmhome.chat.component.bottom;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.ChatMessageComponent$deleteOnModifySendBeforeAck$2", f = "ChatMessageComponent.kt", i = {}, l = {DoraCallStateCode.ENV_OBSERVE_USER_WIFI_CONFIG}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageComponent$deleteOnModifySendBeforeAck$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ChatMessageComponent this$0;

    public ChatMessageComponent$deleteOnModifySendBeforeAck$2(ChatMessageComponent r1, Message r2, Continuation<? super ChatMessageComponent$deleteOnModifySendBeforeAck$2> r3) {
        this.this$0 = r1;
        this.$msg = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new ChatMessageComponent$deleteOnModifySendBeforeAck$2(this.this$0, this.$msg, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ChatMessageComponent r5 = this.this$0;
        int r2 = ChatMessageComponent.j;
        ChatMessageViewModel r6 = r5.L2();
        Message r3 = this.$msg;
        this.label = 1;
        if (r6.deleteOnModifySendBeforeAck(r3, this) != r0) goto L12;
        return r0;
    }
}
