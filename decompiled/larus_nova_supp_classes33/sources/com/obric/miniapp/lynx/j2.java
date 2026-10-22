package com.obric.miniapp.lynx;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class j2 implements Function1 {
    public /* synthetic */ j2() {
    }

    public final Object invoke(Object r2) {
        View r3 = (View) r2;
        int r0 = LynxOUIDatePickerViewUI.w;
        Intrinsics.checkNotNullParameter(r3, "child");
        if ((r3 instanceof ViewGroup) == false) goto L5;
        ViewGroup r4 = (ViewGroup) r3;
    L6:
        if (r4 == null) goto L9;
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
    L9:
        return Unit.INSTANCE;
    L5:
        r4 = null;
        goto L6
    }
}
