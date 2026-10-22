package com.larus.uaigc.nowatermark;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ d(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        String r0 = this.a;
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        boolean r2 = true;
        if ((!StringsKt.isBlank(r5)) == true) goto L5;
    L7:
        r2 = false;
    L9:
        return Boolean.valueOf(r2);
    L5:
        if (Intrinsics.areEqual(r5, r0) == true) goto L7;
        goto L7
    }
}
