package com.larus.bmhome.chat.component.list;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k4 implements Function1 {
    public /* synthetic */ k4() {
    }

    public final Object invoke(Object r4) {
        Map r5 = (Map) r4;
        int r0 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r5, "bizExt");
        return com.larus.utils.h.c(r5, new Pair[]{TuplesKt.to("send_loading", "0")});
    }
}
