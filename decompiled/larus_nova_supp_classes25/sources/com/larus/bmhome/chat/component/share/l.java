package com.larus.bmhome.chat.component.share;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Function1 {
    public /* synthetic */ l() {
    }

    public final Object invoke(Object r3) {
        Message r4 = (Message) r3;
        int r0 = ChatShareBottomComponent.R;
        Intrinsics.checkNotNullParameter(r4, "it");
        return String.valueOf(r4.getLocalIndex());
    }
}
