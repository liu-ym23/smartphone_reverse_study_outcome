package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final boolean a(List<Message> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Message r4 = (Message) CollectionsKt.firstOrNull(r3);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getUserType() == 2) goto L7;
        return false;
    L7:
        if (com.larus.bmhome.chat.bean.d.j0(r4) == false) goto L9;
        return false;
    L9:
        return true;
    }
}
