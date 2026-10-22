package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z4 implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ z4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        ChatListComponent r0 = this.a;
        int r3 = ((Integer) r2).intValue();
        MessageAdapter r1 = r0.O;
        if (r1 == null) goto L11;
        List<b> r4 = r1.z2();
        if (r4 == null) goto L11;
        b r5 = (b) CollectionsKt.getOrNull(r4, r3);
        if (r5 == null) goto L11;
        Message r6 = r5.getMessage();
        if (r6 == null) goto L11;
        return r6.getMessageId();
    L11:
        return null;
    }
}
