package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t3 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ t3(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        com.larus.bmhome.double_post.drag_panel.l0 r2 = (com.larus.bmhome.double_post.drag_panel.l0) r0.Z2.getValue();
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.WB() != true) goto L7;
    L9:
        return Boolean.valueOf(r3);
    L7:
        r3 = false;
        goto L9
    }
}
