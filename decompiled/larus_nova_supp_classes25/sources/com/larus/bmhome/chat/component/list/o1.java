package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o1 implements Function0 {
    public final /* synthetic */ LarusPageChatBinding a;
    public final /* synthetic */ ChatListComponent b;

    public /* synthetic */ o1(LarusPageChatBinding r1, ChatListComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        LarusPageChatBinding r0 = this.a;
        ChatListComponent r1 = this.b;
        int r2 = ChatListComponent.W3;
        ChatMessageList.c0(r0.n, r1.F6());
        return Unit.INSTANCE;
    }
}
