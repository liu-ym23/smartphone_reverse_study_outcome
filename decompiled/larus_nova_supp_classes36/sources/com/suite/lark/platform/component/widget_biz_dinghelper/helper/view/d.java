package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ TopCardContainer a;

    public d(TopCardContainer r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TopCardContainer.a r3 = this.a.getOnTopCardMoveOutListener();
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
