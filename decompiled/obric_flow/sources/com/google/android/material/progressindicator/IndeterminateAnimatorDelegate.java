package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected final List<DrawingDelegate.ActiveIndicator> activeIndicators;
    protected IndeterminateDrawable drawable;

    public IndeterminateAnimatorDelegate(int r5) {
        this.activeIndicators = new ArrayList();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.activeIndicators.add(new DrawingDelegate.ActiveIndicator());
        r10 = r10 + 1;
        goto L3
    }

    public abstract void cancelAnimatorImmediately();

    public float getFractionInRange(int r5, int r10, int r11) {
        return (r5 - r10) / r11;
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback r5);

    public void registerDrawable(@NonNull IndeterminateDrawable r5) {
        this.drawable = r5;
    }

    public abstract void requestCancelAnimatorAfterCurrentCycle();

    @VisibleForTesting
    public abstract void resetPropertiesForNewStart();

    @VisibleForTesting
    public abstract void setAnimationFraction(float r5);

    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
