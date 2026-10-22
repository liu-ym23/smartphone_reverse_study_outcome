package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public static class FadeAnimatorListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean mLayerTypeChanged;
        private final View mView;

        public FadeAnimatorListener(View r5) {
            this.mLayerTypeChanged = false;
            this.mView = r5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            onAnimationEnd(r5, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
            if (this.mView.hasOverlappingRendering() == true) goto L5;
            return;
        L5:
            if (this.mView.getLayerType() != 0) goto L9;
            this.mLayerTypeChanged = true;
            this.mView.setLayerType(2, null);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            if (this.mView.getVisibility() != 0) goto L5;
            float r10 = ViewUtils.getTransitionAlpha(this.mView);
        L6:
            this.mView.setTag(R.id.transition_pause_alpha, Float.valueOf(r10));
            return;
        L5:
            r10 = 0.0f;
            goto L6
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            this.mView.setTag(R.id.transition_pause_alpha, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator r5, boolean r10) {
            if (this.mLayerTypeChanged == false) goto L5;
            this.mView.setLayerType(0, null);
        L5:
            if (r10 == true) goto L8;
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
            ViewUtils.clearNonTransitionAlpha(this.mView);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5, boolean r10) {
        }
    }

    public Fade(int r5) {
        setMode(r5);
    }

    private Animator createAnimation(View r5, float r10, float r11) {
        if (r10 != r11) goto L6;
        return null;
    L6:
        ViewUtils.setTransitionAlpha(r5, r10);
        ObjectAnimator r12 = ObjectAnimator.ofFloat(r5, ViewUtils.TRANSITION_ALPHA, new float[]{r11});
        FadeAnimatorListener r13 = new FadeAnimatorListener(r5);
        r12.addListener(r13);
        getRootTransition().addListener(r13);
        return r12;
    }

    private static float getStartAlpha(TransitionValues r5, float r10) {
        if (r5 == null) goto L7;
        Float r11 = (Float) r5.values.get(PROPNAME_TRANSITION_ALPHA);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11.floatValue();
    L7:
        return r10;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        super.captureStartValues(r5);
        Float r10 = (Float) r5.view.getTag(R.id.transition_pause_alpha);
        if (r10 == null) goto L5;
    L8:
        r5.values.put(PROPNAME_TRANSITION_ALPHA, r10);
        return;
    L5:
        if (r5.view.getVisibility() != 0) goto L7;
        r10 = Float.valueOf(ViewUtils.getTransitionAlpha(r5.view));
        goto L8
    L7:
        r10 = Float.valueOf(0.0f);
        goto L8
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.transition.Visibility
    @Nullable
    public Animator onAppear(@NonNull ViewGroup r5, @NonNull View r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        ViewUtils.saveNonTransitionAlpha(r10);
        return createAnimation(r10, getStartAlpha(r11, 0.0f), 1.0f);
    }

    @Override // androidx.transition.Visibility
    @Nullable
    public Animator onDisappear(@NonNull ViewGroup r5, @NonNull View r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        ViewUtils.saveNonTransitionAlpha(r10);
        Animator r13 = createAnimation(r10, getStartAlpha(r11, 1.0f), 0.0f);
        if (r13 != null) goto L5;
        ViewUtils.setTransitionAlpha(r10, getStartAlpha(r12, 1.0f));
    L5:
        return r13;
    }

    public Fade() {
    }

    public Fade(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.FADE);
        setMode(TypedArrayUtils.getNamedInt(r11, (XmlResourceParser) r10, "fadingMode", 0, getMode()));
        r11.recycle();
    }
}
