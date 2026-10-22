package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MultiViewUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private final Listener listener;
    private final View[] views;

    public interface Listener {
        void onAnimationUpdate(@NonNull ValueAnimator r5, @NonNull View r10);
    }

    @SuppressLint({"LambdaLast"})
    public MultiViewUpdateListener(@NonNull Listener r5, @NonNull View... r10) {
        this.listener = r5;
        this.views = r10;
    }

    public static /* synthetic */ void a(ValueAnimator r5, View r10) {
        setScale(r5, r10);
    }

    @NonNull
    public static MultiViewUpdateListener alphaListener(@NonNull View... r5) {
        return new MultiViewUpdateListener(new a(3), r5);
    }

    public static /* synthetic */ void b(ValueAnimator r5, View r10) {
        setTranslationY(r5, r10);
    }

    public static /* synthetic */ void c(ValueAnimator r5, View r10) {
        setAlpha(r5, r10);
    }

    public static /* synthetic */ void d(ValueAnimator r5, View r10) {
        setTranslationX(r5, r10);
    }

    @NonNull
    public static MultiViewUpdateListener scaleListener(@NonNull View... r5) {
        return new MultiViewUpdateListener(new a(1), r5);
    }

    private static void setAlpha(@NonNull ValueAnimator r5, @NonNull View r10) {
        r10.setAlpha(((Float) r5.getAnimatedValue()).floatValue());
    }

    private static void setScale(@NonNull ValueAnimator r5, @NonNull View r10) {
        Float r11 = (Float) r5.getAnimatedValue();
        r10.setScaleX(r11.floatValue());
        r10.setScaleY(r11.floatValue());
    }

    private static void setTranslationX(@NonNull ValueAnimator r5, @NonNull View r10) {
        r10.setTranslationX(((Float) r5.getAnimatedValue()).floatValue());
    }

    private static void setTranslationY(@NonNull ValueAnimator r5, @NonNull View r10) {
        r10.setTranslationY(((Float) r5.getAnimatedValue()).floatValue());
    }

    @NonNull
    public static MultiViewUpdateListener translationXListener(@NonNull View... r5) {
        return new MultiViewUpdateListener(new a(0), r5);
    }

    @NonNull
    public static MultiViewUpdateListener translationYListener(@NonNull View... r5) {
        return new MultiViewUpdateListener(new a(2), r5);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator r10) {
        View[] r5 = this.views;
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        View r13 = r5[r12];
        this.listener.onAnimationUpdate(r10, r13);
        r12 = r12 + 1;
        goto L3
    }

    @NonNull
    public static MultiViewUpdateListener alphaListener(@NonNull Collection<View> r5) {
        return new MultiViewUpdateListener(new a(3), r5);
    }

    @NonNull
    public static MultiViewUpdateListener scaleListener(@NonNull Collection<View> r5) {
        return new MultiViewUpdateListener(new a(1), r5);
    }

    @NonNull
    public static MultiViewUpdateListener translationXListener(@NonNull Collection<View> r5) {
        return new MultiViewUpdateListener(new a(0), r5);
    }

    @NonNull
    public static MultiViewUpdateListener translationYListener(@NonNull Collection<View> r5) {
        return new MultiViewUpdateListener(new a(2), r5);
    }

    @SuppressLint({"LambdaLast"})
    public MultiViewUpdateListener(@NonNull Listener r5, @NonNull Collection<View> r10) {
        this.listener = r5;
        this.views = (View[]) r10.toArray(new View[0]);
    }
}
