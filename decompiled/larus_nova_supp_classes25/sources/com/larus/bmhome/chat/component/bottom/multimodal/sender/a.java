package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ Map a;

    public /* synthetic */ a(Map r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Map r0 = this.a;
        Map r4 = (Map) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r4.putAll(r0);
        return r4;
    }
}
