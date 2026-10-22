package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function0;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ p4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        if (a.c(r0).getView() != null) goto L7;
        return null;
    L7:
        return a.c(r0).getViewLifecycleOwner();
    }
}
