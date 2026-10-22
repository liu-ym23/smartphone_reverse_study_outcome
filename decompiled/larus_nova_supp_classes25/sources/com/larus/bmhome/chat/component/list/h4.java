package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ h4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        va8.k r2 = (va8.k) r0.j3.getValue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getWindowState();
    }
}
