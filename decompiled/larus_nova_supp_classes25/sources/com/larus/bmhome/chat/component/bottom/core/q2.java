package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ LarusWidgetInputBinding b;

    public /* synthetic */ q2(CoreInputComponent r1, LarusWidgetInputBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        CoreInputComponent r12 = this.a;
        LarusWidgetInputBinding r0 = this.b;
        int r1 = CoreInputComponent.d3;
        if (r12.F4().takeOverConfig().u == false) goto L16;
        if (r4 != r8) goto L11;
        if (r5 != r9) goto L11;
        if (r6 != r10) goto L11;
        if (r7 != r11) goto L11;
        return;
    L11:
        if (r0.h.getVisibility() != 0) goto L13;
        boolean r13 = true;
    L14:
        r12.X6(r12.V4(), r13, true);
        return;
    L13:
        r13 = false;
        goto L14
    }
}
