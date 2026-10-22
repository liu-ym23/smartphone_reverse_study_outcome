package com.larus.account.base.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class v implements Function1 {
    public /* synthetic */ v() {
    }

    public final Object invoke(Object r2) {
        q38.b r3 = (q38.b) r2;
        int r0 = MultiAccountServiceImpl.f;
        Intrinsics.checkNotNullParameter(r3, "it");
        String r4 = r3.g();
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        return Boolean.valueOf(!r5);
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r5 = false;
        goto L10
    }
}
