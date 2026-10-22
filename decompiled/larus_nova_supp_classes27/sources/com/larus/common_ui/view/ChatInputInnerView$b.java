package com.larus.common_ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ChatInputInnerView$b extends AnimatorListenerAdapter {
    public final /* synthetic */ ChatInputInnerView a;
    public final /* synthetic */ View b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ChatInputInnerView r4 = this.a;
        View r0 = this.b;
        int r1 = ChatInputInnerView.e;
        r4.getClass();
        r0.setTag(2131362955, Boolean.FALSE);
        e1.o(this.b);
    }

    public ChatInputInnerView$b(ChatInputInnerView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
