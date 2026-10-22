package com.bytedance.android.livesdk.gift.platform.business.dialog.v3;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.a.setScaleX(1.0f);
        this.a.setScaleY(1.0f);
        View r0 = this.b;
        if (r0 == null) goto L8;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L9;
        r1.height = -1;
        return;
    L9:
        return;
    }

    public b(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
