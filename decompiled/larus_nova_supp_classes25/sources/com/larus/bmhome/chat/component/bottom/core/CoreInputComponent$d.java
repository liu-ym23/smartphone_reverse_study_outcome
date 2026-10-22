package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rp8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CoreInputComponent$d implements Function1<a, Unit> {
    public final /* synthetic */ CoreInputComponent a;

    public CoreInputComponent$d(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Intrinsics.checkNotNullParameter((t1a.c) r2, "it");
        CoreInputComponent r3 = this.a;
        if (r3.W == null) goto L6;
        r3.k4().rE();
    L6:
        return Unit.INSTANCE;
    }
}
