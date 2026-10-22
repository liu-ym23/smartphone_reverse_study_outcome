package com.bytedance.android.live.effect.sticker.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ StickerFavoriteImageView a;
    public final /* synthetic */ AnimatorSet b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.start();
        StickerFavoriteImageView.b r3 = this.a.c;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r3.onStateChange(1);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        StickerFavoriteImageView.b r3 = this.a.c;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r3.onStateChange(0);
        return;
    }

    public l(StickerFavoriteImageView r1, AnimatorSet r2) {
        this.a = r1;
        this.b = r2;
    }
}
