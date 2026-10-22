package com.larus.bmhome.view.actionbar.custom;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class l implements Function1 {
    public /* synthetic */ l() {
    }

    public final Object invoke(Object r3) {
        String r4 = (String) r3;
        int r0 = ActionBarServiceImpl.e;
        Intrinsics.checkNotNullParameter(r4, "it");
        return (List) xt7.d.b.c(kuc.a.b(com.larus.bmhome.actionbar.model.z0.Companion.serializer()), r4);
    }
}
