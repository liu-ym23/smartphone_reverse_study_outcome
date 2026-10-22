package com.bytedance.ai.model.widgets;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements View.OnLayoutChangeListener {
    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        String r18 = "OnLayoutChange: height is " + (r13 - r11);
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L6;
        r19.i("LynxViewFloatingPage", r18);
        return;
    }
}
