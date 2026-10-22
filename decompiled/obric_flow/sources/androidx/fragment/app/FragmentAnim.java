package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

/* JADX INFO: loaded from: classes.dex */
class FragmentAnim {

    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        public AnimationOrAnimator(Animation r5) {
            this.animation = r5;
            this.animator = null;
            if (r5 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }

        public AnimationOrAnimator(Animator r5) {
            this.animation = null;
            this.animator = r5;
            if (r5 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        public EndViewTransitionAnimation(@NonNull Animation r5, @NonNull ViewGroup r10, @NonNull View r11) {
            super(false);
            this.mAnimating = true;
            this.mParent = r10;
            this.mChild = r11;
            addAnimation(r5);
            r10.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r5, @NonNull Transformation r10) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r5, r10) == true) goto L9;
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

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r5, @NonNull Transformation r10, float r11) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r5, r10, r11) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }
    }

    private FragmentAnim() {
    }

    @AnimRes
    private static int getNextAnim(Fragment r5, boolean r10, boolean r11) {
        if (r11 == false) goto L8;
        if (r10 == false) goto L7;
        return r5.getPopEnterAnim();
    L7:
        return r5.getPopExitAnim();
    L8:
        if (r10 == false) goto L12;
        return r5.getEnterAnim();
    L12:
        return r5.getExitAnim();
    }

    @SuppressLint({"ResourceType"})
    public static AnimationOrAnimator loadAnimation(@NonNull Context r5, @NonNull Fragment r10, boolean r11, boolean r12) {
        int r13 = r10.getNextTransition();
        int r14 = getNextAnim(r10, r11, r12);
        r10.setAnimations(0, 0, 0, 0);
        ViewGroup r15 = r10.mContainer;
        if (r15 != null) goto L5;
    L7:
        ViewGroup r16 = r10.mContainer;
        if (r16 != null) goto L10;
    L12:
        Animation r17 = r10.onCreateAnimation(r13, r11, r14);
        if (r17 != null) goto L15;
        Animator r18 = r10.onCreateAnimator(r13, r11, r14);
        if (r18 != null) goto L19;
        if (r14 != 0) goto L23;
        if (r13 == 0) goto L23;
        r14 = transitToAnimResourceId(r5, r13, r11);
    L23:
        if (r14 == 0) goto L43;
        boolean r19 = "anim".equals(r5.getResources().getResourceTypeName(r14));
        if (r19 == true) goto L47;
    L45:
        Animator r20 = AnimatorInflater.loadAnimator(r5, r14);     // Catch: RuntimeException -> L36
        if (r20 == null) goto L43;
        return new AnimationOrAnimator(r20);
    L36:
        e = move-exception;
        if (r19 == true) goto L42;
        Animation r21 = AnimationUtils.loadAnimation(r5, r14);
        if (r21 == null) goto L43;
        return new AnimationOrAnimator(r21);
    L42:
        throw e;
    L47:
        Animation r22 = AnimationUtils.loadAnimation(r5, r14);     // Catch: Resources.NotFoundException -> L30 RuntimeException -> L44
        if (r22 == null) goto L43;
        return new AnimationOrAnimator(r22);
    L30:
        e = move-exception;
        throw e;
    L43:
        return null;
    L19:
        return new AnimationOrAnimator(r18);
    L15:
        return new AnimationOrAnimator(r17);
    L10:
        if (r16.getLayoutTransition() == null) goto L12;
        return null;
    L5:
        if (r15.getTag(R.id.visible_removing_fragment_view_tag) == null) goto L7;
        r10.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        goto L7
    }

    @AnimRes
    private static int toActivityTransitResId(@NonNull Context r5, int r10) {
        TypedArray r11 = r5.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{r10});
        int r12 = r11.getResourceId(0, -1);
        r11.recycle();
        return r12;
    }

    @AnimRes
    private static int transitToAnimResourceId(@NonNull Context r5, int r10, boolean r11) {
        if (r10 != 4097) goto L5;
        if (r11 == false) goto L28;
        return R.animator.fragment_open_enter;
    L28:
        return R.animator.fragment_open_exit;
    L5:
        if (r10 != 8194) goto L7;
        if (r11 == false) goto L37;
        return R.animator.fragment_close_enter;
    L37:
        return R.animator.fragment_close_exit;
    L7:
        if (r10 != 8197) goto L9;
        if (r11 == false) goto L35;
        return toActivityTransitResId(r5, android.R.attr.activityCloseEnterAnimation);
    L35:
        return toActivityTransitResId(r5, android.R.attr.activityCloseExitAnimation);
    L9:
        if (r10 != 4099) goto L11;
        if (r11 == false) goto L33;
        return R.animator.fragment_fade_enter;
    L33:
        return R.animator.fragment_fade_exit;
    L11:
        if (r10 == 4100) goto L13;
        return -1;
    L13:
        if (r11 == false) goto L31;
        return toActivityTransitResId(r5, android.R.attr.activityOpenEnterAnimation);
    L31:
        return toActivityTransitResId(r5, android.R.attr.activityOpenExitAnimation);
    }
}
