package com.larus.drive.sdk.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ j(com.larus.drive.biz.impl.utils.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function1 r0 = this.a;
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "error");
        if (r0 == null) goto L6;
        r0.invoke(r4);
    L6:
        return Unit.INSTANCE;
    }
}
