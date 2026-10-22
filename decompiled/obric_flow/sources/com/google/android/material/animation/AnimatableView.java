package com.google.android.material.animation;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface AnimatableView {

    public interface Listener {
        void onAnimationEnd();
    }

    void startAnimation(@NonNull Listener r5);

    void stopAnimation();
}
