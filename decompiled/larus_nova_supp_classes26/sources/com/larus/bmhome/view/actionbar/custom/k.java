package com.larus.bmhome.view.actionbar.custom;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ ActionBarServiceImpl a;

    public /* synthetic */ k(ActionBarServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ActionBarServiceImpl r0 = this.a;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) r3;
        int r1 = ActionBarServiceImpl.e;
        Intrinsics.checkNotNullParameter(r4, "it");
        Integer r5 = r4.g;
        r0.getClass();
        return Boolean.valueOf(ActionBarServiceImpl.p(r5));
    }
}
