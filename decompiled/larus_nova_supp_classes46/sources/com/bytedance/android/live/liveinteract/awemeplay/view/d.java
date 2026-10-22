package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LiveVideoCommentSelectAwemePanelView a;

    public d(LiveVideoCommentSelectAwemePanelView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.live.liveinteract.awemeplay.view.LiveVideoCommentSelectAwemePanelView, java.lang.Object] */
    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        ?? r8 = this.a;
        int r0 = LiveVideoCommentSelectAwemePanelView.w;
        r8.getClass();
        new ConstraintSet().clone(r8);
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(r8);
        r1.connect(2131389882, 3, 2131389880, 4);
        AutoTransition r2 = new AutoTransition();
        r2.setDuration(500);
        TransitionManager.beginDelayedTransition(r8, r2);
        r1.applyTo(r8);
        TextView r3 = r8.e;
        if (r3 == null) goto L5;
        float r4 = r3.getHeight();
    L6:
        TextView r9 = r8.e;
        if (r9 == null) goto L18;
        ViewPropertyAnimator r10 = r9.animate();
        if (r10 == null) goto L19;
        ViewPropertyAnimator r11 = r10.alpha(0.0f);
        if (r11 == null) goto L20;
        ViewPropertyAnimator r12 = r11.translationY(-r4);
        if (r12 == null) goto L21;
        ViewPropertyAnimator r13 = r12.setDuration(500);
        if (r13 == null) goto L22;
        r13.start();
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r4 = 0.0f;
        goto L6
    }
}
