package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CoreInputComponent$f implements Function1<rp8.b, Unit> {
    public final /* synthetic */ CoreInputComponent a;

    public CoreInputComponent$f(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Intrinsics.checkNotNullParameter((t1a.c) r3, "it");
        CoreInputComponent r4 = this.a;
        if (r4.W == null) goto L13;
        if (r4.o5() == false) goto L7;
    L9:
        CoreInputComponent r5 = this.a;
        r5.FZ(r5.F4().getCurrentInputStatus(), this.a.n5());
        CoreInputComponent r6 = this.a;
        if (r6.W == null) goto L13;
        r6.X5();
        goto L13
    L7:
        if (this.a.F4().getCurrentInputStatus() != 2) goto L9;
        this.a.k4().g2(1, false);
    L13:
        return Unit.INSTANCE;
    }
}
