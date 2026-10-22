package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ GiftMVIDetailView a;
    public final /* synthetic */ boolean b;

    public j(GiftMVIDetailView r1) {
        this.a = r1;
        this.b = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ImageView r3 = this.a.s;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepImg");
    L5:
        r3.setVisibility(8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ImageView r4 = this.a.s;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSweepImg");
    L5:
        r4.setVisibility(8);
        if (this.b == false) goto L12;
        GiftMVIDetailView r5 = this.a;
        TextView r0 = r5.o;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardDetailBtn");
    L10:
        GiftMVIDetailView.t(r5, r0);
        return;
    }
}
