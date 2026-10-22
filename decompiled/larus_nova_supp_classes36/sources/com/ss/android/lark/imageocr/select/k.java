package com.ss.android.lark.imageocr.select;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ e a;

    public k(e r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        e r0 = this.a;
        if (r0.p == false) goto L7;
        r0.p = false;
        r0.f.removeCallbacks(r0.t);
        r0.f.postDelayed(r0.t, 100);
        return true;
    L7:
        return true;
    }
}
