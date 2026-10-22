package com.larus.bmhome.chat.model.repo;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v0 implements Function1 {
    public final /* synthetic */ long a;

    public /* synthetic */ v0(long r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        long r0 = this.a;
        Map r7 = (Map) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        return com.larus.utils.h.c(r7, new Pair[]{TuplesKt.to("loading", "1"), TuplesKt.to("progress", String.valueOf(r0))});
    }
}
