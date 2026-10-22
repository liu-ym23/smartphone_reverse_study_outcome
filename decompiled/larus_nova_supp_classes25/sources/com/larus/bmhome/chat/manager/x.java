package com.larus.bmhome.chat.manager;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x implements Function1<View, Integer> {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
    }

    public final Object invoke(Object r2) {
        View r3 = (View) r2;
        Intrinsics.checkNotNullParameter(r3, "menuView");
        return Integer.valueOf(-r3.getPaddingLeft());
    }
}
