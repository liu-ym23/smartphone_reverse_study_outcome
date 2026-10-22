package com.larus.bmhome.chat.component.list;

import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d5 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ d5(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return TuplesKt.to(r0.getBotId(), r0.j4());
    }
}
