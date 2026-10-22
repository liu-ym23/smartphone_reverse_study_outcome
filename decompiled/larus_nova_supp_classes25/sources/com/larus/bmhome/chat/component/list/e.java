package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ e(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.h();
    }
}
