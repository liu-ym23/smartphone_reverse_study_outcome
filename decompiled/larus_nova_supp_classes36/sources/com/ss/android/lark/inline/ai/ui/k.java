package com.ss.android.lark.inline.ai.ui;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements View.OnLayoutChangeListener {
    public final /* synthetic */ InlineAIDragView a;

    public k(InlineAIDragView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L6;
        if (r3 != r7) goto L6;
        if (r4 != r8) goto L6;
        if (r5 != r9) goto L6;
        return;
    L6:
        Log.i("InlineAIDragView", "panelRootView layout change");
        this.a.f();
        ValueAnimator r10 = this.a.o;
        if (r10 != null) goto L9;
    L11:
        boolean r11 = false;
    L12:
        if (r11 == false) goto L17;
        ValueAnimator r12 = this.a.o;
        if (r12 == null) goto L16;
        r12.cancel();
    L16:
        this.a.n(false, true, InlineAIDragView.AdjustTopSource.CONTAINER_CHANGE);
        return;
    L17:
        this.a.n(false, false, InlineAIDragView.AdjustTopSource.CONTAINER_CHANGE);
        return;
    L9:
        if (r10.isRunning() != true) goto L11;
        r11 = true;
        goto L12
    }
}
