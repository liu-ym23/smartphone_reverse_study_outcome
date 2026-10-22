package com.larus.avlink.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ b a;

    public /* synthetic */ a(b r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        b r0 = this.a;
        byte[] r4 = (byte[]) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        Function1 r1 = r0.g;
        if (r1 == null) goto L6;
        r1.invoke(r4);
    L6:
        return Unit.INSTANCE;
    }
}
