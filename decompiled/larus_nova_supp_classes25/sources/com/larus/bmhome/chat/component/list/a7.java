package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a7 implements Function1 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ ChatListComponentViewModel b;

    public /* synthetic */ a7(Message r1, ChatListComponentViewModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return ChatListComponentViewModel.hp(this.a, this.b, (ChatListComponentState) r3);
    }
}
