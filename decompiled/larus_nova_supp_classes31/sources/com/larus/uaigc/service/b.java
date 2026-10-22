package com.larus.uaigc.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ b(wt8.z r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        Function2 r0 = this.a;
        bq8.a r5 = (bq8.a) r3;
        String r6 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "templatePrompt");
        Intrinsics.checkNotNullParameter(r6, "enterFrom");
        r0.invoke(r5, r6);
        return Unit.INSTANCE;
    }
}
