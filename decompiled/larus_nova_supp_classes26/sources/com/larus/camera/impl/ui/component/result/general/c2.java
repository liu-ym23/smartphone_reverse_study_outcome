package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c2 implements Function1<View, Unit> {
    public final /* synthetic */ ResultTitleComponent a;

    public c2(ResultTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        View r4 = (View) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$configRedoUndoButtonContainer");
        ResultTitleComponent r0 = this.a;
        if (r0.r == false) goto L6;
        r0.r = false;
        com.larus.utils.e1.x(r4);
        r4.setEnabled(true);
    L6:
        return Unit.INSTANCE;
    }
}
