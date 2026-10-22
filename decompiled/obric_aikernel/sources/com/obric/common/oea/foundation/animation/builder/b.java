package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final a.C0123a a(View r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$animator");
        return new a.C0123a(r10).a(r11, 90.0f);
    }

    public static /* synthetic */ a.C0123a b(View r10, float r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 1.0f;
    L6:
        return a(r10, r11);
    }
}
