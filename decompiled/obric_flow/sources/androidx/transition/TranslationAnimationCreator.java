package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class TranslationAnimationCreator {

    public static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean mIsTransitionCanceled;
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        public TransitionPositionListener(View r5, View r10, float r11, float r12) {
            this.mMovingView = r5;
            this.mViewInHierarchy = r10;
            this.mTerminalX = r11;
            this.mTerminalY = r12;
            int[] r13 = (int[]) r10.getTag(R.id.transition_position);
            this.mTransitionPosition = r13;
            if (r13 == null) goto L6;
            r10.setTag(R.id.transition_position, null);
            return;
        }

        private void setInterruptedPosition() {
            if (this.mTransitionPosition != null) goto L5;
            this.mTransitionPosition = new int[2];
        L5:
            this.mMovingView.getLocationOnScreen(this.mTransitionPosition);
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator r5, boolean r10) {
            if (r10 == true) goto L5;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5, boolean r10) {
            if (this.mIsTransitionCanceled == true) goto L6;
            this.mViewInHierarchy.setTag(R.id.transition_position, null);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            setInterruptedPosition();
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator r5) {
            onAnimationEnd(r5, false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
            onTransitionEnd(r5, false);
        }
    }

    private TranslationAnimationCreator() {
    }

    @Nullable
    public static Animator createAnimation(@NonNull View r11, @NonNull TransitionValues r12, int r13, int r14, float r15, float r16, float r17, float r18, @Nullable TimeInterpolator r19, @NonNull Transition r20) {
        float r5 = r11.getTranslationX();
        float r10 = r11.getTranslationY();
        int[] r21 = (int[]) r12.view.getTag(R.id.transition_position);
        if (r21 == null) goto L5;
        float r22 = (r21[0] - r13) + r5;
        float r23 = (r21[1] - r14) + r10;
    L6:
        r11.setTranslationX(r22);
        r11.setTranslationY(r23);
        if (r22 == r17) goto L9;
    L12:
        ObjectAnimator r24 = ObjectAnimator.ofPropertyValuesHolder(r11, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r22, r17}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r23, r18})});
        TransitionPositionListener r25 = new TransitionPositionListener(r11, r12.view, r5, r10);
        r20.addListener(r25);
        r24.addListener(r25);
        r24.setInterpolator(r19);
        return r24;
    L9:
        if (r23 != r18) goto L12;
        return null;
    L5:
        r22 = r15;
        r23 = r16;
        goto L6
    }
}
