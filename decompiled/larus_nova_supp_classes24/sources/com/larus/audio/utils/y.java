package com.larus.audio.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class y implements Function1 {
    public final /* synthetic */ z a;

    public /* synthetic */ y(z r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        z r0 = this.a;
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "id");
        StringBuilder r1 = new StringBuilder("{");
        r0.getClass();
        r1.append(z.c(r5));
        r1.append('}');
        return r1.toString();
    }
}
