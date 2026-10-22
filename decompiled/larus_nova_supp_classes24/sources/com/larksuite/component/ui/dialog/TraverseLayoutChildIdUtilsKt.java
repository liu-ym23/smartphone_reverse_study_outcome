package com.larksuite.component.ui.dialog;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TraverseLayoutChildIdUtilsKt {
    public static final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        int r0 = r4.getId();
        int r1 = d.e.get(r0);
        if (r1 == 0) goto L6;
        r4.setId(r1);
    L6:
        if ((r4 instanceof ViewGroup) == false) goto L10;
        ViewGroup r5 = (ViewGroup) r4;
        TraverseLayoutChildIdUtilsKt$traverseViewChangeId$1 r2 = TraverseLayoutChildIdUtilsKt$traverseViewChangeId$1.INSTANCE;
        int r3 = r5.getChildCount();
        int r6 = 0;
    L8:
        if (r6 >= r3) goto L12;
        r2.invoke(r5.getChildAt(r6));
        r6 = r6 + 1;
        goto L8
    L12:
        return;
    }
}
