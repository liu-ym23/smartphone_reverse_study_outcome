package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.SafeExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements Function0 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ ChatMessageList b;

    public /* synthetic */ u(ChatListComponent r1, ChatMessageList r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final ChatListComponent r0 = this.a;
        final ChatMessageList r1 = this.b;
        int r2 = ChatListComponent.W3;
        SafeExtKt.b(r0.F2(), new q0(r1, r0), 50);
        return Unit.INSTANCE;
    }
}
