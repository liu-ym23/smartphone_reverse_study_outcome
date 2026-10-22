package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function0;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ p(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        com.larus.bmhome.a0 r2 = com.larus.bmhome.b0.a(a.c(r0));
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.Ga() != true) goto L7;
    L9:
        return Boolean.valueOf(r3);
    L7:
        r3 = false;
        goto L9
    }
}
