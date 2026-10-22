package com.google.android.material.transformation;

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

    public ExpandableTransformationBehavior() {
    }

    public static /* synthetic */ AnimatorSet access$002(ExpandableTransformationBehavior r5, AnimatorSet r10) {
        r5.currentAnimation = r10;
        return r10;
    }

    @NonNull
    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View r5, View r10, boolean r11, boolean r12);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean onExpandedStateChange(View r5, View r10, boolean r11, boolean r12) {
        AnimatorSet r13 = this.currentAnimation;
        if (r13 == null) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        r13.cancel();
    L8:
        AnimatorSet r15 = onCreateExpandedStateChangeAnimation(r5, r10, r11, r14);
        this.currentAnimation = r15;
        r15.addListener(new AnonymousClass1(this));
        this.currentAnimation.start();
        if (r12 == true) goto L11;
        this.currentAnimation.end();
    L11:
        return true;
    L5:
        r14 = false;
        goto L6
    }

    public ExpandableTransformationBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
    }
}
