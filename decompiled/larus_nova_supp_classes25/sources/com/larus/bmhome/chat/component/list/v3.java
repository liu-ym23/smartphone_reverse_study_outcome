package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v3 implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ v3(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ChatListComponent r0 = this.a;
        Message r4 = (Message) r3;
        int r1 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.getClass();
        if (d.b0(r4) == false) goto L7;
        String r2 = a.D(r4);
        if (r2 != null) goto L9;
        r2 = r4.getMessageId();
    L9:
        return String.valueOf(r2);
    L7:
        r2 = r4.getMessageId();
        goto L9
    }
}
