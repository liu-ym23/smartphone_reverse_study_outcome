package com.larus.bmhome.chat.component.list;

import ew8.b;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ e4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        b r2 = (b) r0.k3.getValue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.Je();
    }
}
