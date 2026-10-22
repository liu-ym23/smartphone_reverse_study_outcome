package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class ChatListComponent$handleLocationPermissionResult$2 extends FunctionReferenceImpl implements Function1<Message, Unit> {
    public ChatListComponent$handleLocationPermissionResult$2(Object r8) {
        super(1, r8, ChatListComponent.class, "tryRequestLocationAuthMessage", "tryRequestLocationAuthMessage(Lcom/larus/im/bean/message/Message;)V", 0);
    }

    public final void invoke(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ChatListComponent.H3((ChatListComponent) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Message) r1);
        return Unit.INSTANCE;
    }
}
