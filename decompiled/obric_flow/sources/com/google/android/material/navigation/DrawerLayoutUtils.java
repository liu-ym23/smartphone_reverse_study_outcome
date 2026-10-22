package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.b;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DrawerLayoutUtils {
    private static final int DEFAULT_SCRIM_ALPHA = 0;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;

    static {
        DEFAULT_SCRIM_ALPHA = Color.alpha(DEFAULT_SCRIM_COLOR);
    }

    private DrawerLayoutUtils() {
    }

    public static /* synthetic */ void a(DrawerLayout r5, ValueAnimator r10) {
        lambda$getScrimCloseAnimatorUpdateListener$0(r5, r10);
    }

    @NonNull
    public static Animator.AnimatorListener getScrimCloseAnimatorListener(@NonNull final DrawerLayout r5, @NonNull final View r10) {
        return new AnonymousClass1(r5, r10);
    }

    @NonNull
    public static ValueAnimator.AnimatorUpdateListener getScrimCloseAnimatorUpdateListener(@NonNull DrawerLayout r5) {
        return new b(r5, 1);
    }

    private static /* synthetic */ void lambda$getScrimCloseAnimatorUpdateListener$0(DrawerLayout r5, ValueAnimator r10) {
        r5.setScrimColor(ColorUtils.setAlphaComponent(DEFAULT_SCRIM_COLOR, AnimationUtils.lerp(DEFAULT_SCRIM_ALPHA, 0, r10.getAnimatedFraction())));
    }
}
