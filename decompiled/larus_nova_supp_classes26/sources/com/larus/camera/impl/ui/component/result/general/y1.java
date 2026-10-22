package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y1 implements Function1<View, Unit> {
    public final /* synthetic */ ResultTitleComponent a;

    public y1(ResultTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        View r4 = (View) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$configMiddleTitleIconContainer");
        if (r4.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this.a.q = true;
        com.larus.utils.e1.o(r4);
    L9:
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }
}
