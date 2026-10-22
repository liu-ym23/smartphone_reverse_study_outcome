package com.larus.search.impl;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c extends t {
    public final /* synthetic */ BottomSheetBehavior<View> a;
    public final /* synthetic */ int b;

    public c(BottomSheetBehavior<View> r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onStateChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        if (r4 == 1) goto L7;
        if (r4 != 3) goto L10;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        r5.height = this.b;
        r3.setLayoutParams(r5);
        return;
    L10:
        return;
    L7:
        this.a.setState(3);
    }
}
