package com.larus.bmhome.interactionpanel.store;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Function1 {
    public /* synthetic */ a() {
    }

    public final Object invoke(Object r2) {
        Map.Entry r3 = (Map.Entry) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(((Set) r3.getValue()).isEmpty());
    }
}
