package com.larus.common_ui.floatwindow.view;

import android.app.Activity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    public final Object invoke(Object r3) {
        Activity r4 = (Activity) r3;
        Intrinsics.checkNotNullParameter(r4, "previous");
        int r0 = e.a;
        if ((r4 instanceof e19.a) == false) goto L5;
    L10:
        boolean r5 = true;
    L12:
        return Boolean.valueOf(!r5);
    L5:
        if (r4.isFinishing() == true) goto L10;
        if (r4.isDestroyed() == true) goto L10;
        r5 = false;
        goto L12
    }
}
