package com.larus.uaigc.chat.markdown.helper;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class f1 implements Function1 {
    public final /* synthetic */ rd8.b a;

    public /* synthetic */ f1(rd8.b r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        rd8.b r0 = this.a;
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "vid");
        if (r0 == null) goto L9;
        kh8.a r1 = r0.q3();
        if (r1 == null) goto L9;
        Integer r5 = r1.a(r4);
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
    L11:
        return Integer.valueOf(r6);
    L9:
        r6 = 0;
        goto L11
    }
}
