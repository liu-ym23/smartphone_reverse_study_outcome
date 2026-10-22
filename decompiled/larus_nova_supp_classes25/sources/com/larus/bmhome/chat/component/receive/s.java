package com.larus.bmhome.chat.component.receive;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ ChatReceiveServiceComponent a;

    public /* synthetic */ s(ChatReceiveServiceComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ChatReceiveServiceComponent r0 = this.a;
        String r4 = (String) r3;
        int r1 = ChatReceiveServiceComponent.x;
        Intrinsics.checkNotNullParameter(r4, "texts");
        ChatReceiveServiceComponent.N2(r0, r4, "share_send");
        return Unit.INSTANCE;
    }
}
