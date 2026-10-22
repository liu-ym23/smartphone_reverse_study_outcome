package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l2 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ l2(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        com.larus.bmhome.instruction.g r2 = r0.vc();
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.yW() != true) goto L7;
    L9:
        return Boolean.valueOf(r3);
    L7:
        r3 = false;
        goto L9
    }
}
