package com.larus.bmhome.chat.list.cell.test;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function1 {
    public /* synthetic */ t() {
    }

    public final Object invoke(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        String r4 = r3.getMessageId();
        if (r4 != null) goto L6;
        return "";
    L6:
        return r4;
    }
}
