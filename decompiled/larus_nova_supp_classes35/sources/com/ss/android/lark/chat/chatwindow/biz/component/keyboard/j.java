package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.AnchorItemLayoutManager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Animator.AnimatorListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ MessageListAnimationContainer c;
    public final /* synthetic */ d d;
    public final /* synthetic */ RecyclerView e;
    public final /* synthetic */ Function1 f;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        if (this.a <= this.b) goto L5;
        MessageListAnimationContainer.AnimType r5 = MessageListAnimationContainer.AnimType.Enter;
    L6:
        this.c.setAnimType(r5);
        d r6 = this.d;
        Intrinsics.checkNotNull(this.e);
        RecyclerView r0 = this.e;
        r6.getClass();
        if ((r0.getLayoutManager() instanceof AnchorItemLayoutManager) == true) goto L9;
    L9:
        r6.e = Math.max(0, Math.max((r0.getHeight() - r0.getPaddingBottom()) - r0.computeVerticalScrollRange(), 0));
        this.f.invoke(Float.valueOf(this.a));
        return;
    L5:
        r5 = MessageListAnimationContainer.AnimType.Exit;
        goto L6
    }

    public j(int r1, int r2, MessageListAnimationContainer r3, d r4, RecyclerView r5, Function1 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
