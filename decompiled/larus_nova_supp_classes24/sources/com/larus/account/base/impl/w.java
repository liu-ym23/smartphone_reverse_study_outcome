package com.larus.account.base.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class w implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ w(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        String r0 = this.a;
        q38.b r6 = (q38.b) r5;
        int r1 = MultiAccountServiceImpl.f;
        Intrinsics.checkNotNullParameter(r6, "item");
        String r7 = r6.g();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
    L12:
        r2 = true;
    L14:
        return Boolean.valueOf(r2);
    L11:
        if (Intrinsics.areEqual(r7, r0) == true) goto L14;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r3 = false;
        goto L9
    }
}
