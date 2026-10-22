package com.obric.assistant.component;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class x1 implements Function1 {
    public /* synthetic */ x1() {
    }

    public final Object invoke(Object r3) {
        View r4 = (View) r3;
        int r0 = ObricIntercomComponent.h1;
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r4.isShown() == true) goto L5;
    L11:
        boolean r5 = false;
    L13:
        return Boolean.valueOf(r5);
    L5:
        if (r4.getAlpha() <= 0.0f) goto L11;
        if (r4.getWidth() <= 0) goto L11;
        if (r4.getHeight() <= 0) goto L11;
        r5 = true;
        goto L13
    }
}
