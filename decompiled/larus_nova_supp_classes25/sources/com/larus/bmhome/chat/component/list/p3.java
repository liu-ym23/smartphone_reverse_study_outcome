package com.larus.bmhome.chat.component.list;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p3 implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ p3(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ChatListComponent r0 = this.a;
        boolean r4 = ((Boolean) r3).booleanValue();
        int r1 = ChatListComponent.W3;
        if (r4 == false) goto L8;
        if (r0.w6() == true) goto L8;
        r0.z7();
    L8:
        return Unit.INSTANCE;
    }
}
