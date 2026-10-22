package com.bytedance.android.ec.common.impl.sku.view;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ SpecItemOptimizeView a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.l.getLineCount() <= 1) goto L5;
        this.a.l.setTextSize(13.0f);
    L6:
        this.a.l.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L5:
        this.a.l.setTextSize(14.0f);
        goto L6
    }

    public a0(SpecItemOptimizeView r1) {
        this.a = r1;
    }
}
