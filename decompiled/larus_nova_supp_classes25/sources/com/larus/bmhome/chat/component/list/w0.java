package com.larus.bmhome.chat.component.list;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w0 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ w0(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        FLogger.a.i("pending-unread-scroll-click", "unknown pending unread group resolved in one screen, scroll to latest");
        r0.Z3("click_unknown_group_in_one_screen");
        r0.N7("unknown");
        r0.z7();
        r0.w7("click_unknown_group_in_one_screen");
        return Unit.INSTANCE;
    }
}
