package com.larus.uaigc.createpage.component.instruction;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class i2 implements Function1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ i2(Function0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Function0 r0 = this.a;
        if (((Boolean) r2).booleanValue() == false) goto L6;
        r0.invoke();
    L6:
        return Unit.INSTANCE;
    }
}
