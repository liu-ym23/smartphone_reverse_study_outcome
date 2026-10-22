package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static b.a a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$animator");
        b.a r0 = new b.a(r2);
        if (1.0f <= 0) goto L6;
        r0.a = 1.0f;
        r0.b = 90.0f;
        return r0;
    L6:
        int r3 = ija.b.a;
        Intrinsics.checkNotNullParameter("animationSpeed必须大于 0", "message");
        throw new IllegalArgumentException("animationSpeed必须大于 0");
    }
}
