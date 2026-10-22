package com.larus.push.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ long a;

    public /* synthetic */ j(long r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        long r0 = this.a;
        Map.Entry r6 = (Map.Entry) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if ((r0 - ((Number) r6.getValue()).longValue()) < 100) goto L5;
        boolean r7 = true;
    L7:
        return Boolean.valueOf(r7);
    L5:
        r7 = false;
        goto L7
    }
}
