package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u6 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ u6(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        if (((com.larus.bmhome.auth.c1) r3).b != 2) goto L6;
        r0.Y6();
    L6:
        return Unit.INSTANCE;
    }
}
