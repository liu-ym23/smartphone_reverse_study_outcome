package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class ChatListComponent$handleColdLaunchMessageEventFlow$2 extends FunctionReferenceImpl implements Function1<com.larus.bmhome.social.page.datasource.event.c<b>, Unit> {
    public ChatListComponent$handleColdLaunchMessageEventFlow$2(Object r8) {
        super(1, r8, ChatListComponent.class, "createRecoverAction", "createRecoverAction(Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;)V", 0);
    }

    public final void invoke(com.larus.bmhome.social.page.datasource.event.c<b> r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ChatListComponent.h3((ChatListComponent) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larus.bmhome.social.page.datasource.event.c) r1);
        return Unit.INSTANCE;
    }
}
