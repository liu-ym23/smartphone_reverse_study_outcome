package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.trace.ChatControlTrace;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h0 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ h0(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        ChatControlTrace r2 = ChatControlTrace.b;
        wc9.e r3 = r0.R4();
        if (r3 == null) goto L5;
        Integer r4 = r3.v;
    L7:
        return r2.g(r4, r0.j4(), r0.i4());
    L5:
        r4 = null;
        goto L7
    }
}
