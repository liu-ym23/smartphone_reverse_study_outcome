package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ MediaMultiAnchorWindowV2 a;
    public final /* synthetic */ int b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewGroup.LayoutParams r0 = this.a.l.getLayoutParams();
        if (r0 == null) goto L13;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        int r2 = r1.bottomMargin;
        int r3 = this.b;
        if (r3 != 0) goto L7;
        r1.bottomMargin = MediaMultiAnchorWindowV2.c(this.a);
    L8:
        this.a.l.setLayoutParams(r1);
        ViewTreeObserver r4 = this.a.l.getViewTreeObserver();
        if (r4 == null) goto L14;
        r4.removeOnGlobalLayoutListener(this);
        return;
    L14:
        return;
    L7:
        r1.bottomMargin = r2 + r3;
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public g(MediaMultiAnchorWindowV2 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
