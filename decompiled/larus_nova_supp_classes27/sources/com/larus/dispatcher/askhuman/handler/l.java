package com.larus.dispatcher.askhuman.handler;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    public /* synthetic */ l(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        String r0 = this.a;
        int r1 = this.b;
        Map r6 = (Map) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        Pair[] r2 = new Pair[1];
        StringBuilder r3 = new StringBuilder();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r3.append(r0);
        r3.append('-');
        r3.append(r1);
        r2[0] = TuplesKt.to("quick_reply_click_index_info", r3.toString());
        return com.larus.utils.h.c(r6, r2);
    }
}
