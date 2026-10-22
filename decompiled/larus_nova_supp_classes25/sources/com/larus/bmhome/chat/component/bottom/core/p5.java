package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p5 implements View.OnLayoutChangeListener {
    public /* synthetic */ p5() {
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        int r10 = CoreInputComponent.d3;
        int r11 = r4 - r2;
        if (r11 < ((Number) v19.i5.V1.getValue()).intValue()) goto L5;
        int r12 = (int) (r11 * 0.1f);
    L6:
        r1.setPadding(r12, 0, r12, 0);
        return;
    L5:
        r12 = v19.i5.h();
        goto L6
    }
}
