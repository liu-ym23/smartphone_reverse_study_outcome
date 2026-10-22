package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import ys8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o7 implements View.OnLayoutChangeListener {
    public final /* synthetic */ CoreInputComponent a;

    public o7(CoreInputComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        CoreInputComponent r10 = this.a;
        int r11 = CoreInputComponent.d3;
        com.larus.bmhome.instruction.g r12 = r10.vc();
        if (r12 == null) goto L5;
        r12.c6();
    L5:
        a r13 = this.a.DC();
        if (r13 == null) goto L9;
        r13.c6();
        return;
    }
}
