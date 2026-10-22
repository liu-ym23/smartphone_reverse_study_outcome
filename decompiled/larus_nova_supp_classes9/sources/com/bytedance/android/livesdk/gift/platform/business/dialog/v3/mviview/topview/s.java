package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s extends AnimatorListenerAdapter {
    public final /* synthetic */ GiftMVIDetailTopView a;

    public s(GiftMVIDetailTopView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        yo2.e r3 = this.a.u;
        if (r3 == null) goto L6;
        r3.d();
        return;
    }
}
