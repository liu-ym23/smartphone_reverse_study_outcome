package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.outerinput.OuterInputEventHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e6 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ e6(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        OuterInputEventHandler r0 = this.a.G1;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        return Unit.INSTANCE;
    }
}
