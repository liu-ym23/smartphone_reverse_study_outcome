package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ a a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r0 = this.a.i;
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.removeOnGlobalLayoutListener(this);
    L7:
        View r2 = this.a.i;
        if (r2 == null) goto L15;
        int r3 = r2.getMeasuredWidth();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r4 = this.a.k;
        if (r4 == null) goto L16;
        TextView r5 = r4.k;
        if (r5 == null) goto L17;
        r5.setTranslationY(r3 * (-0.1f));
        return;
    L17:
        return;
    L16:
        return;
    }

    public c(a r1) {
        this.a = r1;
    }
}
