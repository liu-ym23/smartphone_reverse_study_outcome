package com.larus.bmhome.clarification;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class q0 implements Function1 {
    public final /* synthetic */ ze8.b a;
    public final /* synthetic */ ClarificationComponent b;

    public /* synthetic */ q0(ze8.b r1, ClarificationComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        ze8.b r0 = this.a;
        ClarificationComponent r1 = this.b;
        int r5 = ((Integer) r4).intValue();
        int r2 = ClarificationComponent.k0;
        r0.e(r5);
        r1.l4();
        return Unit.INSTANCE;
    }
}
