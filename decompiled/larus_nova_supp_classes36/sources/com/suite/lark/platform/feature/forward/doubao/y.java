package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements View.OnLayoutChangeListener {
    public final /* synthetic */ ForwardDoubaoActivity a;

    public y(ForwardDoubaoActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        int r10 = r5 - r3;
        ForwardDoubaoActivity r11 = this.a;
        if (r11.o == false) goto L7;
        if (r10 <= 0) goto L8;
        r11.j = r10;
        return;
    L8:
        return;
    }
}
