package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.component.ext.ChatFragmentDelegateDialogExtKt;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p0 implements Function0 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ Integer c;

    public /* synthetic */ p0(ChatListComponent r1, Message r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        Message r1 = this.b;
        Integer r2 = this.c;
        int r3 = ChatListComponent.W3;
        ChatFragmentDelegateDialogExtKt.b(a.c(r0).getChildFragmentManager(), r1, r2, 12);
        return Unit.INSTANCE;
    }
}
