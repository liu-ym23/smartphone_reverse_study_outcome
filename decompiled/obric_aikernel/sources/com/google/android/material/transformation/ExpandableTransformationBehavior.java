package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    @Nullable
    private AnimatorSet currentAnimation;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExpandableTransformationBehavior f4085c;

        a(ExpandableTransformationBehavior r10) {
            this.f4085c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            ExpandableTransformationBehavior.access$002(this.f4085c, null);
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    static /* synthetic */ AnimatorSet access$002(ExpandableTransformationBehavior r10, AnimatorSet r11) {
        r10.currentAnimation = r11;
        return r11;
    }

    @NonNull
    protected abstract AnimatorSet onCreateExpandedStateChangeAnimation(View r10, View r11, boolean r12, boolean r13);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    protected boolean onExpandedStateChange(View r10, View r11, boolean r12, boolean r13) {
        AnimatorSet r14 = this.currentAnimation;
        if (r14 == null) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L8;
        r14.cancel();
    L8:
        AnimatorSet r16 = onCreateExpandedStateChangeAnimation(r10, r11, r12, r15);
        this.currentAnimation = r16;
        r16.addListener(new a(this));
        this.currentAnimation.start();
        if (r13 == true) goto L11;
        this.currentAnimation.end();
    L11:
        return true;
    L5:
        r15 = false;
        goto L6
    }
}
