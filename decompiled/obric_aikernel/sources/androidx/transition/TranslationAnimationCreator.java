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

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View r10, View r11, int r12, int r13, float r14, float r15) {
            this.mMovingView = r10;
            this.mViewInHierarchy = r11;
            this.mStartX = r12 - Math.round(r10.getTranslationX());
            this.mStartY = r13 - Math.round(r10.getTranslationY());
            this.mTerminalX = r14;
            this.mTerminalY = r15;
            int r16 = R.id.transition_position;
            int[] r17 = (int[]) r11.getTag(r16);
            this.mTransitionPosition = r17;
            if (r17 == null) goto L6;
            r11.setTag(r16, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            if (this.mTransitionPosition != null) goto L5;
            this.mTransitionPosition = new int[2];
        L5:
            this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r10) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r10) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r10) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            r10.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r10) {
        }
    }

    private TranslationAnimationCreator() {
    }

    @Nullable
    static Animator createAnimation(@NonNull View r14, @NonNull TransitionValues r15, int r16, int r17, float r18, float r19, float r20, float r21, @Nullable TimeInterpolator r22, @NonNull Transition r23) {
        float r10 = r14.getTranslationX();
        float r11 = r14.getTranslationY();
        int[] r12 = (int[]) r15.view.getTag(R.id.transition_position);
        if (r12 == null) goto L5;
        float r13 = (r12[0] - r16) + r10;
        float r24 = (r12[1] - r17) + r11;
    L6:
        int r25 = r16 + Math.round(r13 - r10);
        int r26 = r17 + Math.round(r24 - r11);
        r14.setTranslationX(r13);
        r14.setTranslationY(r24);
        if (r13 == r20) goto L9;
    L12:
        ObjectAnimator r27 = ObjectAnimator.ofPropertyValuesHolder(r14, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r13, r20}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r24, r21})});
        TransitionPositionListener r28 = new TransitionPositionListener(r14, r15.view, r25, r26, r10, r11);
        r23.addListener(r28);
        r27.addListener(r28);
        AnimatorUtils.addPauseListener(r27, r28);
        r27.setInterpolator(r22);
        return r27;
    L9:
        if (r24 != r21) goto L12;
        return null;
    L5:
        r13 = r18;
        r24 = r19;
        goto L6
    }
}
