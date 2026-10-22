package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i5 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ i5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        com.larus.bmhome.chat.component.trace.z r2 = s1a.d.a(r0).getAbility(com.larus.bmhome.chat.component.trace.z.class);
        if (r2 == null) goto L6;
        r2.Ky();
    L6:
        return Unit.INSTANCE;
    }
}
