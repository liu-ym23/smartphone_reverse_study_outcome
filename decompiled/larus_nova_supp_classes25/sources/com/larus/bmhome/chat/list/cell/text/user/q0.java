package com.larus.bmhome.chat.list.cell.text.user;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 implements Animator.AnimatorListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewGroup.LayoutParams c;
    public final /* synthetic */ TextView d;
    public final /* synthetic */ UserTextCell e;
    public final /* synthetic */ ViewGroup f;
    public final /* synthetic */ View g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ TextView j;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.removeView(this.b);
        ViewGroup.LayoutParams r3 = this.c;
        r3.width = -2;
        r3.height = -2;
        ViewGroup.LayoutParams r4 = this.d.getLayoutParams();
        if (r4 == null) goto L5;
        r4.width = -2;
        r4.height = -2;
    L5:
        this.e.V(true);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        this.f.addView(this.g, 0, new ViewGroup.LayoutParams(this.h, this.i));
        ViewGroup.LayoutParams r6 = this.j.getLayoutParams();
        if (r6 == null) goto L5;
        r6.width = this.h;
        r6.height = this.i;
    L5:
        this.e.V(false);
    }

    public q0(ViewGroup r1, View r2, ViewGroup.LayoutParams r3, CustomMarkdownTextView r4, UserTextCell r5, ViewGroup r6, View r7, int r8, int r9, CustomMarkdownTextView r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
