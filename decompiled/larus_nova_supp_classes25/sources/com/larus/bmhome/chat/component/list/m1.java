package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m1 implements Function0 {
    public final /* synthetic */ LarusPageChatBinding a;

    public /* synthetic */ m1(LarusPageChatBinding r1) {
        this.a = r1;
    }

    public final Object invoke() {
        LarusPageChatBinding r0 = this.a;
        int r1 = ChatListComponent.W3;
        ChatMessageList.c0(r0.n, true);
        return Unit.INSTANCE;
    }
}
