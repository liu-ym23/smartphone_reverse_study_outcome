package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ f4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        va8.m0 r0 = (va8.m0) this.a.l3.getValue();
        if (r0 == null) goto L5;
        int r1 = r0.pD();
    L7:
        return Integer.valueOf(r1);
    L5:
        r1 = -1;
        goto L7
    }
}
