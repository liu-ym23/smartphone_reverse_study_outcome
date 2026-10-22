package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ CommonContainerLayout b;

    public a(View r1, CommonContainerLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (this.a != null) goto L5;
        return;
    L5:
        this.b.getFooterContainer().getLocationOnScreen(this.b.c);
        CommonContainerLayout r4 = this.b;
        int r0 = r4.c[1];
        int r5 = r4.R5(this.a) - r0;
        if (r5 <= 0) goto L9;
        this.b.getContentScrollView().scrollBy(0, r5);
        return;
    }
}
