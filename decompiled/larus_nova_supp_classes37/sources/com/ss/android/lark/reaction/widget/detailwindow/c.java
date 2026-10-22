package com.ss.android.lark.reaction.widget.detailwindow;

import android.view.ViewTreeObserver;
import n2c.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ a a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r0 = this.a.b.getHeight();
        if (r0 != 0) goto L5;
        return;
    L5:
        this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.a.a.setMaxScrollY(r0);
        this.a.a.setCloseUpAlgorithm(new a.f());
        a.b(0, Double.valueOf(((double) r0) * a.v.doubleValue()).intValue(), new p(this));
    }

    public c(a r1) {
        this.a = r1;
    }
}
