package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ k(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        MessageAdapter r1 = r0.O;
        if (r1 == null) goto L7;
        boolean r2 = true;
        if ((!((ArrayList) r1.getCurrentList()).isEmpty()) != true) goto L7;
    L8:
        if (r2 == false) goto L11;
        r0.v4().A();
    L11:
        return Unit.INSTANCE;
    L7:
        r2 = false;
        goto L8
    }
}
