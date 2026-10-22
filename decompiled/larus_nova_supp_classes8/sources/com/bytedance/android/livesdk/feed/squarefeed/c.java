package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseOpenFeedFragment a;

    public c(BaseOpenFeedFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        TextView r3 = this.a.W90();
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        InterceptTouchLayout r4 = this.a.T90();
        if (r4 == null) goto L9;
        r4.setInterceptTouchEvent(true);
        return;
    }
}
