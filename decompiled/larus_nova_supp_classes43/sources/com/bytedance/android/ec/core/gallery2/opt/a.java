package com.bytedance.android.ec.core.gallery2.opt;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ GalleryTitleItemView a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.getLineCount() <= 3) goto L5;
        this.a.setTextSize(11.0f);
    L6:
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L5:
        this.a.setTextSize(14.0f);
        goto L6
    }

    public a(GalleryTitleItemView r1) {
        this.a = r1;
    }
}
