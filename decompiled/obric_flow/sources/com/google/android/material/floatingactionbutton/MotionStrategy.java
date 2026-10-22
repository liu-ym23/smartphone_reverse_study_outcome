package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
interface MotionStrategy {
    void addAnimationListener(@NonNull Animator.AnimatorListener r5);

    AnimatorSet createAnimator();

    MotionSpec getCurrentMotionSpec();

    @AnimatorRes
    int getDefaultMotionSpecResource();

    List<Animator.AnimatorListener> getListeners();

    @Nullable
    MotionSpec getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator r5);

    void onChange(@Nullable ExtendedFloatingActionButton.OnChangedCallback r5);

    void performNow();

    void removeAnimationListener(@NonNull Animator.AnimatorListener r5);

    void setMotionSpec(@Nullable MotionSpec r5);

    boolean shouldCancel();
}
