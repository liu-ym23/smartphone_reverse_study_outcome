package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseOpenFeedFragment a;

    public a(BaseOpenFeedFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        InterceptTouchLayout r3 = this.a.T90();
        if (r3 == null) goto L6;
        r3.setInterceptTouchEvent(false);
        return;
    }
}
