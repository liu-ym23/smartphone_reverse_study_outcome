package com.larus.bmhome.chat.component.receive;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ ChatReceiveServiceComponent a;

    public /* synthetic */ t(ChatReceiveServiceComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ChatReceiveServiceComponent r0 = this.a;
        List r5 = (List) r4;
        int r1 = ChatReceiveServiceComponent.x;
        Intrinsics.checkNotNullParameter(r5, "uris");
        r0.P2(r5, false, null);
        return Unit.INSTANCE;
    }
}
