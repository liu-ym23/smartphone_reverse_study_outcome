package com.obric.assistant.component;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m2 implements Function1 {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ m2(ObricIntercomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        Intrinsics.checkNotNullParameter((Map) r4, "it");
        maa.h r5 = (maa.h) r0.y.getValue();
        if (r5 == null) goto L6;
        r5.UA(true, null, -1);
    L6:
        return Unit.INSTANCE;
    }
}
