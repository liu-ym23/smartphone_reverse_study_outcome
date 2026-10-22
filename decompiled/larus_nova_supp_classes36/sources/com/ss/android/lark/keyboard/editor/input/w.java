package com.ss.android.lark.keyboard.editor.input;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ss.android.lark.keyboard.widget.DragShrinkLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w extends AnimatorListenerAdapter {
    public final /* synthetic */ RichTextInputExpandPlugin a;

    public w(RichTextInputExpandPlugin r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.getClass();
        RichTextInputExpandPlugin.z0(this.a, 0.7f);
        DragShrinkLayout r3 = this.a.O;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r3 = null;
    L5:
        r3.setDragEnabled(true);
        this.a.getClass();
        this.a.N.invoke();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        DragShrinkLayout r5 = this.a.O;
        View r1 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r5 = null;
    L5:
        r5.setVisibility(0);
        DragShrinkLayout r6 = this.a.O;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r6 = null;
    L8:
        r6.setDragEnabled(false);
        View r7 = this.a.P;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
    L12:
        r1.setVisibility(0);
        return;
    L11:
        r1 = r7;
        goto L12
    }
}
