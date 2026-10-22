package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ChatListComponent$onAttach$1$1 extends AdaptedFunctionReference implements Function1<Message, Unit> {
    public ChatListComponent$onAttach$1$1(Object r8) {
        super(1, r8, ChatListComponent.class, "locationAndModify", "locationAndModify(Lcom/larus/im/bean/message/Message;Z)V", 0);
    }

    public final void invoke(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ChatListComponent r0 = (ChatListComponent) ((AdaptedFunctionReference) this).receiver;
        int r1 = ChatListComponent.W3;
        r0.Y6(r3, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Message) r1);
        return Unit.INSTANCE;
    }
}
