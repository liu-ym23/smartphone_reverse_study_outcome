package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x0 implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ChatListComponent b;
    public final /* synthetic */ ChatMessageList c;

    public /* synthetic */ x0(int r1, ChatListComponent r2, ChatMessageList r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        final int r0 = this.a;
        ChatListComponent r1 = this.b;
        final ChatMessageList r2 = this.c;
        int r3 = ChatListComponent.W3;
        FLogger.a.i("pending-unread-scroll-click", "unknown pending unread group needs unread target scroll, scroll target top to pos " + r0);
        r1.v7("click_unknown_group_to_pending_unread", new k1(r2, r0));
        return Unit.INSTANCE;
    }
}
