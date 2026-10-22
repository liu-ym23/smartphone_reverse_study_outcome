package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    public o(HSImageView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationStart(r2, r3);
        this.a.setAlpha(0.0f);
        this.a.setVisibility(0);
    }
}
