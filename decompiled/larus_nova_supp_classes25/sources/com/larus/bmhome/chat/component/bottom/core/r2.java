package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r2 implements Function2 {
    public /* synthetic */ r2() {
    }

    public final Object invoke(Object r2, Object r3) {
        CoreInputComponentState r4 = (CoreInputComponentState) r2;
        CoreInputComponentState r5 = (CoreInputComponentState) r3;
        int r0 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r4, "old");
        Intrinsics.checkNotNullParameter(r5, "new");
        if (r4.getTakeOverConfig().j != r5.getTakeOverConfig().j) goto L5;
        boolean r6 = true;
    L7:
        return Boolean.valueOf(r6);
    L5:
        r6 = false;
        goto L7
    }
}
