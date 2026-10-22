package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

/* JADX INFO: loaded from: classes.dex */
class FragmentAnim {

    static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animator r10) {
            this.animation = null;
            this.animator = r10;
            if (r10 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }

        AnimationOrAnimator(Animation r10) {
            this.animation = r10;
            this.animator = null;
            if (r10 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(@NonNull Animation r10, @NonNull ViewGroup r11, @NonNull View r12) {
            super(false);
            this.mAnimating = true;
            this.mParent = r11;
            this.mChild = r12;
            addAnimation(r10);
            r11.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r10, @NonNull Transformation r11) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r10, r11) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r10, @NonNull Transformation r11, float r12) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r10, r11, r12) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded == false) goto L5;
        L7:
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
            return;
        L5:
            if (this.mAnimating == false) goto L7;
            this.mAnimating = false;
            this.mParent.post(this);
        }
    }

    private FragmentAnim() {
    }

    static void animateRemoveFragment(@NonNull final Fragment r10, @NonNull AnimationOrAnimator r11, @NonNull final FragmentTransition.Callback r12) {
        final View r13 = r10.mView;
        final ViewGroup r14 = r10.mContainer;
        r14.startViewTransition(r13);
        final CancellationSignal r15 = new CancellationSignal();
        r15.setOnCancelListener(new AnonymousClass1(r10));
        r12.onStart(r10, r15);
        if (r11.animation == null) goto L5;
        EndViewTransitionAnimation r16 = new EndViewTransitionAnimation(r11.animation, r14, r13);
        r10.setAnimatingAway(r10.mView);
        r16.setAnimationListener(new AnonymousClass2(r14, r10, r12, r15));
        r10.mView.startAnimation(r16);
        return;
    L5:
        Animator r17 = r11.animator;
        r10.setAnimator(r17);
        r17.addListener(new AnonymousClass3(r14, r13, r10, r12, r15));
        r17.setTarget(r10.mView);
        r17.start();
    }

    private static int getNextAnim(Fragment r10, boolean r11, boolean r12) {
        if (r12 == false) goto L8;
        if (r11 == false) goto L7;
        return r10.getPopEnterAnim();
    L7:
        return r10.getPopExitAnim();
    L8:
        if (r11 == false) goto L12;
        return r10.getEnterAnim();
    L12:
        return r10.getExitAnim();
    }

    static AnimationOrAnimator loadAnimation(@NonNull Context r10, @NonNull Fragment r11, boolean r12, boolean r13) {
        int r14 = r11.getNextTransition();
        int r15 = getNextAnim(r11, r12, r13);
        boolean r16 = false;
        r11.setAnimations(0, 0, 0, 0);
        ViewGroup r17 = r11.mContainer;
        if (r17 == null) goto L7;
        int r18 = R.id.visible_removing_fragment_view_tag;
        if (r17.getTag(r18) == null) goto L7;
        r11.mContainer.setTag(r18, null);
    L7:
        ViewGroup r19 = r11.mContainer;
        if (r19 != null) goto L10;
    L12:
        Animation r20 = r11.onCreateAnimation(r14, r12, r15);
        if (r20 != null) goto L15;
        Animator r21 = r11.onCreateAnimator(r14, r12, r15);
        if (r21 != null) goto L19;
        if (r15 != 0) goto L23;
        if (r14 == 0) goto L23;
        r15 = transitToAnimResourceId(r14, r12);
    L23:
        if (r15 == 0) goto L45;
        boolean r22 = "anim".equals(r10.getResources().getResourceTypeName(r15));
        if (r22 == true) goto L49;
    L33:
        if (r16 == true) goto L45;
        Animator r23 = AnimatorInflater.loadAnimator(r10, r15);     // Catch: RuntimeException -> L38
        if (r23 == null) goto L45;
        return new AnimationOrAnimator(r23);
    L38:
        e = move-exception;
        if (r22 == true) goto L44;
        Animation r24 = AnimationUtils.loadAnimation(r10, r15);
        if (r24 == null) goto L45;
        return new AnimationOrAnimator(r24);
    L44:
        throw e;
    L49:
        Animation r25 = AnimationUtils.loadAnimation(r10, r15);     // Catch: Resources.NotFoundException -> L31 RuntimeException -> L46
        if (r25 == null) goto L30;
        return new AnimationOrAnimator(r25);
        goto L33
    L30:
        r16 = true;
    L31:
        e = move-exception;
        throw e;
    L45:
        return null;
    L19:
        return new AnimationOrAnimator(r21);
    L15:
        return new AnimationOrAnimator(r20);
    L10:
        if (r19.getLayoutTransition() == null) goto L12;
        return null;
    }

    @AnimRes
    private static int transitToAnimResourceId(int r10, boolean r11) {
        if (r10 != 4097) goto L5;
        if (r11 == false) goto L18;
        return R.animator.fragment_open_enter;
    L18:
        return R.animator.fragment_open_exit;
    L5:
        if (r10 != 4099) goto L7;
        if (r11 == false) goto L23;
        return R.animator.fragment_fade_enter;
    L23:
        return R.animator.fragment_fade_exit;
    L7:
        if (r10 == 8194) goto L9;
        return -1;
    L9:
        if (r11 == false) goto L21;
        return R.animator.fragment_close_enter;
    L21:
        return R.animator.fragment_close_exit;
    }
}
