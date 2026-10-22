package com.ss.android.lark.message.card.pin;

import android.view.ViewTreeObserver;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ d a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.d.getMeasuredHeight() < UIHelper.dp2px(240.0f)) goto L5;
        this.a.g.setVisibility(0);
    L5:
        this.a.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public b(d r1) {
        this.a = r1;
    }
}
