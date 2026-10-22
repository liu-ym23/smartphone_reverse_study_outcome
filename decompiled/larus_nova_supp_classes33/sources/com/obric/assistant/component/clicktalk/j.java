package com.obric.assistant.component.clicktalk;

import com.obric.assistant.util.g2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ j(g2 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function1 r0 = this.a;
        String r4 = (String) r3;
        int r1 = ChatClickTalkComponent.L0;
        Intrinsics.checkNotNullParameter(r4, "botId");
        r0.invoke(r4);
        return Unit.INSTANCE;
    }
}
