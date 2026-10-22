package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x4 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ x4(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        CoreInputComponent r0 = this.a;
        r0.x1 = ((Boolean) r2).booleanValue();
        r0.bm(r0.F4().inputTextHint());
        return Unit.INSTANCE;
    }
}
