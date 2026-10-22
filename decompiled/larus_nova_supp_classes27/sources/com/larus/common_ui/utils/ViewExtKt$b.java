package com.larus.common_ui.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ViewExtKt$b extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    public ViewExtKt$b(View r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.setTag(2131362955, Boolean.FALSE);
        e1.q(this.a);
        this.a.setAlpha(1.0f);
    }
}
