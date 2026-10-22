package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SwipeActionItemDecoration a;

    public j(SwipeActionItemDecoration r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.i();
    }
}
