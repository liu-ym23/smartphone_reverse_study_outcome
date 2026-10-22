package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class AnimatorTracker {

    @Nullable
    private Animator currentAnimator;

    public AnimatorTracker() {
    }

    public void cancelCurrent() {
        Animator r5 = this.currentAnimator;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    public void clear() {
        this.currentAnimator = null;
    }

    public void onNextAnimationStart(Animator r5) {
        cancelCurrent();
        this.currentAnimator = r5;
    }
}
