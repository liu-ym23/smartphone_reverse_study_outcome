package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t4 implements Function1 {
    public /* synthetic */ t4() {
    }

    public final Object invoke(Object r3) {
        Message r4 = (Message) r3;
        int r0 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.getMessageStatusLocal() == 21) goto L9;
        if (r4.getMessageStatusLocal() == 23) goto L9;
        if (d.d(r4) == true) goto L9;
    L11:
        boolean r5 = false;
    L13:
        return Boolean.valueOf(r5);
    L9:
        if (d.z0(r4) == true) goto L11;
        r5 = true;
        goto L13
    }
}
