package com.google.android.material.transition.platform;

import ai.j0;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int r5) {
        this.slideDistance = -1;
        this.slideEdge = r5;
    }

    private static Animator createTranslationAppearAnimator(View r5, View r10, int r11, @Px int r12) {
        float r13 = r10.getTranslationX();
        float r14 = r10.getTranslationY();
        if (r11 == 3) goto L35;
        if (r11 == 5) goto L33;
        if (r11 == 48) goto L31;
        if (r11 == 80) goto L29;
        if (r11 == 8388611) goto L23;
        if (r11 != 8388613) goto L21;
        if (isRtl(r5) == false) goto L17;
        float r15 = r13 - r12;
    L19:
        return createTranslationXAnimator(r10, r15, r13, r13);
    L17:
        r15 = r12 + r13;
        goto L19
    L21:
        throw new IllegalArgumentException(j0.g(r11, "Invalid slide direction: "));
    L23:
        if (isRtl(r5) == false) goto L25;
        float r16 = r12 + r13;
    L27:
        return createTranslationXAnimator(r10, r16, r13, r13);
    L25:
        r16 = r13 - r12;
        goto L27
    L29:
        return createTranslationYAnimator(r10, r12 + r14, r14, r14);
    L31:
        return createTranslationYAnimator(r10, r14 - r12, r14, r14);
    L33:
        return createTranslationXAnimator(r10, r13 - r12, r13, r13);
    L35:
        return createTranslationXAnimator(r10, r12 + r13, r13, r13);
    }

    private static Animator createTranslationDisappearAnimator(View r5, View r10, int r11, @Px int r12) {
        float r13 = r10.getTranslationX();
        float r14 = r10.getTranslationY();
        if (r11 == 3) goto L35;
        if (r11 == 5) goto L33;
        if (r11 == 48) goto L31;
        if (r11 == 80) goto L29;
        if (r11 == 8388611) goto L23;
        if (r11 != 8388613) goto L21;
        if (isRtl(r5) == false) goto L17;
        float r15 = r12 + r13;
    L19:
        return createTranslationXAnimator(r10, r13, r15, r13);
    L17:
        r15 = r13 - r12;
        goto L19
    L21:
        throw new IllegalArgumentException(j0.g(r11, "Invalid slide direction: "));
    L23:
        if (isRtl(r5) == false) goto L25;
        float r16 = r13 - r12;
    L27:
        return createTranslationXAnimator(r10, r13, r16, r13);
    L25:
        r16 = r12 + r13;
        goto L27
    L29:
        return createTranslationYAnimator(r10, r14, r14 - r12, r14);
    L31:
        return createTranslationYAnimator(r10, r14, r12 + r14, r14);
    L33:
        return createTranslationXAnimator(r10, r13, r12 + r13, r13);
    L35:
        return createTranslationXAnimator(r10, r13, r13 - r12, r13);
    }

    private static Animator createTranslationXAnimator(final View r5, float r10, float r11, final float r12) {
        ObjectAnimator r13 = ObjectAnimator.ofPropertyValuesHolder(r5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r10, r11})});
        r13.addListener(new AnonymousClass1(r5, r12));
        return r13;
    }

    private static Animator createTranslationYAnimator(final View r5, float r10, float r11, final float r12) {
        ObjectAnimator r13 = ObjectAnimator.ofPropertyValuesHolder(r5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r10, r11})});
        r13.addListener(new AnonymousClass2(r5, r12));
        return r13;
    }

    private int getSlideDistanceOrDefault(Context r5) {
        int r10 = this.slideDistance;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        return r5.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View r5) {
        if (ViewCompat.getLayoutDirection(r5) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r5, @NonNull View r10) {
        return createTranslationAppearAnimator(r5, r10, this.slideEdge, getSlideDistanceOrDefault(r10.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r5, @NonNull View r10) {
        return createTranslationDisappearAnimator(r5, r10, this.slideEdge, getSlideDistanceOrDefault(r10.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int r5) {
        if (r5 < 0) goto L6;
        this.slideDistance = r5;
        return;
    L6:
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int r5) {
        this.slideEdge = r5;
    }
}
