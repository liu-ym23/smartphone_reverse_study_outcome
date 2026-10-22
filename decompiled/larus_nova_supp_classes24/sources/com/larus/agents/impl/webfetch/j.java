package com.larus.agents.impl.webfetch;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ double a;

    public /* synthetic */ j(double r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        double r0 = this.a;
        Map.Entry r8 = (Map.Entry) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        Double r9 = ((WebFetchCommandProcessor$b) r8.getValue()).c;
        boolean r2 = false;
        if (r9 == null) goto L11;
        if ((r0 - r9.doubleValue()) < 60.0d) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L11;
        r2 = true;
        goto L11
    L7:
        r1 = false;
    L11:
        return Boolean.valueOf(r2);
    }
}
