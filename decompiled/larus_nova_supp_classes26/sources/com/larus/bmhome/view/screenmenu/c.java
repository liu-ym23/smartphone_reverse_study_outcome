package com.larus.bmhome.view.screenmenu;

import com.skydoves.balloon.Balloon;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ Integer a;

    public /* synthetic */ c(Integer r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Integer r0 = this.a;
        Balloon.a r4 = (Balloon.a) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$create");
        if (r0 == null) goto L6;
        r4.n(r0.intValue());
    L6:
        return Unit.INSTANCE;
    }
}
