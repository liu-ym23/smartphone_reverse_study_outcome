package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    private static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private boolean mLayerTypeChanged;
        private final View mView;

        FadeAnimatorListener(View r10) {
            this.mLayerTypeChanged = false;
            this.mView = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
            if (this.mLayerTypeChanged == false) goto L6;
            this.mView.setLayerType(0, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            if (ViewCompat.hasOverlappingRendering(this.mView) == true) goto L5;
            return;
        L5:
            if (this.mView.getLayerType() != 0) goto L9;
            this.mLayerTypeChanged = true;
            this.mView.setLayerType(2, null);
            return;
        }
    }

    public Fade() {
    }

    public Fade(int r10) {
        setMode(r10);
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context r10, AttributeSet r11) {
        super(r10, r11);
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.FADE);
        setMode(TypedArrayUtils.getNamedInt(r12, (XmlResourceParser) r11, "fadingMode", 0, getMode()));
        r12.recycle();
    }

    private Animator createAnimation(final View r10, float r11, float r12) {
        if (r11 != r12) goto L6;
        return null;
    L6:
        ViewUtils.setTransitionAlpha(r10, r11);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r10, ViewUtils.TRANSITION_ALPHA, new float[]{r12});
        r13.addListener(new FadeAnimatorListener(r10));
        addListener(new AnonymousClass1(this, r10));
        return r13;
    }

    private static float getStartAlpha(TransitionValues r10, float r11) {
        if (r10 == null) goto L7;
        Float r12 = (Float) r10.values.get(PROPNAME_TRANSITION_ALPHA);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12.floatValue();
    L7:
        return r11;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        super.captureStartValues(r10);
        r10.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(ViewUtils.getTransitionAlpha(r10.view)));
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        float r14 = 0.0f;
        float r15 = getStartAlpha(r12, 0.0f);
        if (r15 == 1.0f) goto L7;
        r14 = r15;
    L7:
        return createAnimation(r11, r14, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        ViewUtils.saveNonTransitionAlpha(r11);
        return createAnimation(r11, getStartAlpha(r12, 1.0f), 0.0f);
    }
}
