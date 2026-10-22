package com.bytedance.android.live.effect.sticker.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m extends AnimatorListenerAdapter {
    public final /* synthetic */ StickerFavoriteImageView a;

    public m(StickerFavoriteImageView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        StickerFavoriteImageView.b r3 = this.a.c;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r3.onAnimationEnd();
        return;
    }
}
