package com.bytedance.android.ec.common.impl.sku.view;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ SpecItemOptimizeView a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.h.getLineCount() <= 1) goto L5;
        this.a.h.setTextSize(13.0f);
        this.a.h.setGravity(16);
    L6:
        this.a.h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L5:
        this.a.h.setTextSize(14.0f);
        this.a.h.setGravity(17);
        goto L6
    }

    public x(SpecItemOptimizeView r1) {
        this.a = r1;
    }
}
