package com.obric.assistant.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v5 implements Function1 {
    public final /* synthetic */ OrionChatWindowComponent a;

    public /* synthetic */ v5(OrionChatWindowComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final OrionChatWindowComponent r0 = this.a;
        final String r4 = (String) r3;
        int r1 = OrionChatWindowComponent.T;
        Intrinsics.checkNotNullParameter(r4, "it");
        com.larus.utils.t0.e(new s5(r4, r0));
        return Unit.INSTANCE;
    }
}
