package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

        TransitionPositionListener(View r3, View r4, int r5, int r6, float r7, float r8) {
            this.mMovingView = r3;
            this.mViewInHierarchy = r4;
            this.mStartX = r5 - Math.round(r3.getTranslationX());
            this.mStartY = r6 - Math.round(r3.getTranslationY());
            this.mTerminalX = r7;
            this.mTerminalY = r8;
            int[] r9 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.transition_position, OaidModel.KEY_ID, "transition_position")), int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");
            this.mTransitionPosition = r9;
            if (r9 == null) goto L6;
            r4.setTag(ZeusTransformUtils.mapRes(R.id.transition_position, OaidModel.KEY_ID, "transition_position"), null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r4) {
            if (this.mTransitionPosition != null) goto L5;
            this.mTransitionPosition = new int[2];
        L5:
            this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(ZeusTransformUtils.mapRes(R.id.transition_position, OaidModel.KEY_ID, "transition_position"), this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r2) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r2) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r3) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            r3.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r1) {
        }
    }

    private TranslationAnimationCreator() {
    }

    static Animator createAnimation(View r15, TransitionValues r16, int r17, int r18, float r19, float r20, float r21, float r22, TimeInterpolator r23, Transition r24) {
        TimeInterpolator r3 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r23, TimeInterpolator.class, "com.obric.memorydata.plugin");
        float r5 = r15.getTranslationX();
        float r6 = r15.getTranslationY();
        int[] r2 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r16.view.getTag(ZeusTransformUtils.mapRes(R.id.transition_position, OaidModel.KEY_ID, "transition_position")), int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        float r8 = (r2[0] - r17) + r5;
        float r4 = (r2[1] - r18) + r6;
    L6:
        int r9 = r17 + Math.round(r8 - r5);
        int r10 = r18 + Math.round(r4 - r6);
        r15.setTranslationX(r8);
        r15.setTranslationY(r4);
        if (r8 == r21) goto L9;
    L12:
        ObjectAnimator r7 = ObjectAnimator.ofPropertyValuesHolder(r15, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r8, r21}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r4, r22})});
        TransitionPositionListener r11 = new TransitionPositionListener(r15, r16.view, r9, r10, r5, r6);
        r24.addListener(r11);
        r7.addListener(r11);
        AnimatorUtils.addPauseListener(r7, r11);
        r7.setInterpolator(r3);
        return r7;
    L9:
        if (r4 != r22) goto L12;
        return null;
    L5:
        r8 = r19;
        r4 = r20;
        goto L6
    }
}
