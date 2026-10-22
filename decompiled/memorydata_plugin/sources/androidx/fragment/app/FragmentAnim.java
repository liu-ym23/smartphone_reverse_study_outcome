package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class FragmentAnim {

    static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animator r2) {
            this.animation = null;
            this.animator = r2;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }

        AnimationOrAnimator(Animation r2) {
            this.animation = r2;
            this.animator = null;
            if (r2 == null) goto L6;
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

        EndViewTransitionAnimation(Animation r2, ViewGroup r3, View r4) {
            super(false);
            this.mAnimating = true;
            this.mParent = r3;
            this.mChild = r4;
            addAnimation(r2);
            r3.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5, float r6) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5, r6) == true) goto L9;
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

    private static int getNextAnim(Fragment r0, boolean r1, boolean r2) {
        if (r2 == false) goto L8;
        if (r1 == false) goto L7;
        return r0.getPopEnterAnim();
    L7:
        return r0.getPopExitAnim();
    L8:
        if (r1 == false) goto L12;
        return r0.getEnterAnim();
    L12:
        return r0.getExitAnim();
    }

    static AnimationOrAnimator loadAnimation(Context r8, Fragment r9, boolean r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        int r0 = r9.getNextTransition();
        int r13 = getNextAnim(r9, r10, r11);
        boolean r2 = false;
        r9.setAnimations(0, 0, 0, 0);
        if (r9.mContainer == null) goto L8;
        if (r9.mContainer.getTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, OaidModel.KEY_ID, "visible_removing_fragment_view_tag")) == null) goto L8;
        r9.mContainer.setTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, OaidModel.KEY_ID, "visible_removing_fragment_view_tag"), null);
    L8:
        if (r9.mContainer != null) goto L10;
    L12:
        Animation r3 = r9.onCreateAnimation(r0, r10, r13);
        if (r3 != null) goto L15;
        Animator r14 = r9.onCreateAnimator(r0, r10, r13);
        if (r14 != null) goto L19;
        if (r13 != 0) goto L23;
        if (r0 == 0) goto L23;
        r13 = transitToAnimResourceId(r12, r0, r10);
    L23:
        if (r13 == 0) goto L45;
        boolean r15 = "anim".equals(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceTypeName(r13));
        if (r15 == true) goto L49;
    L33:
        if (r2 == true) goto L45;
        Animator r16 = AnimatorInflater.loadAnimator(r12, r13);     // Catch: RuntimeException -> L38
        if (r16 == null) goto L45;
        return new AnimationOrAnimator(r16);
    L38:
        e = move-exception;
        if (r15 == true) goto L44;
        Animation r17 = AnimationUtils.loadAnimation(r12, r13);
        if (r17 == null) goto L45;
        return new AnimationOrAnimator(r17);
    L44:
        throw e;
    L49:
        Animation r18 = AnimationUtils.loadAnimation(r12, r13);     // Catch: Resources.NotFoundException -> L31 RuntimeException -> L46
        if (r18 == null) goto L30;
        return new AnimationOrAnimator(r18);
        goto L33
    L30:
        r2 = true;
    L31:
        e = move-exception;
        throw e;
    L45:
        return null;
    L19:
        return new AnimationOrAnimator(r14);
    L15:
        return new AnimationOrAnimator(r3);
    L10:
        if (r9.mContainer.getLayoutTransition() == null) goto L12;
        return null;
    }

    private static int toActivityTransitResId(Context r2, int r3) {
        TypedArray r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{r3});
        int r5 = r4.getResourceId(0, -1);
        r4.recycle();
        return r5;
    }

    private static int transitToAnimResourceId(Context r2, int r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != 4097) goto L5;
        if (r4 == false) goto L29;
        int r6 = R.animator.fragment_open_enter;
        String r7 = "fragment_open_enter";
    L32:
        return ZeusTransformUtils.mapRes(r6, "animator", r7);
    L29:
        r6 = R.animator.fragment_open_exit;
        r7 = "fragment_open_exit";
        goto L32
    L5:
        if (r3 != 8194) goto L7;
        if (r4 == false) goto L26;
        r6 = R.animator.fragment_close_enter;
        r7 = "fragment_close_enter";
        goto L32
    L26:
        r6 = R.animator.fragment_close_exit;
        r7 = "fragment_close_exit";
        goto L32
    L7:
        if (r3 != 8197) goto L9;
        if (r4 == false) goto L23;
        int r8 = android.R.attr.activityCloseEnterAnimation;
    L31:
        return toActivityTransitResId(r5, r8);
    L23:
        r8 = android.R.attr.activityCloseExitAnimation;
        goto L31
    L9:
        if (r3 != 4099) goto L11;
        if (r4 == false) goto L19;
        r6 = R.animator.fragment_fade_enter;
        r7 = "fragment_fade_enter";
        goto L32
    L19:
        r6 = R.animator.fragment_fade_exit;
        r7 = "fragment_fade_exit";
        goto L32
    L11:
        if (r3 == 4100) goto L13;
        return -1;
    L13:
        if (r4 == false) goto L15;
        r8 = android.R.attr.activityOpenEnterAnimation;
        goto L31
    L15:
        r8 = android.R.attr.activityOpenExitAnimation;
        goto L31
    }
}
