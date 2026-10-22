package com.larus.bmhome.chat.component.share;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c0 implements Function1 {
    public /* synthetic */ c0() {
    }

    public final Object invoke(Object r2) {
        Message r3 = (Message) r2;
        int r0 = ChatShareBottomComponent.R;
        Intrinsics.checkNotNullParameter(r3, "it");
        String r4 = r3.getMessageId();
        if (r4 != null) goto L6;
        return "";
    L6:
        return r4;
    }
}
