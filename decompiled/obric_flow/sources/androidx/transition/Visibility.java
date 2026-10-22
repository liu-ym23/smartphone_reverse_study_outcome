package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = null;
    private int mMode;

    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        boolean mCanceled;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        public DisappearListener(View r5, int r10, boolean r11) {
            this.mCanceled = false;
            this.mView = r5;
            this.mFinalVisibility = r10;
            this.mParent = (ViewGroup) r5.getParent();
            this.mSuppressLayout = r11;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (this.mCanceled == true) goto L7;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup r5 = this.mParent;
            if (r5 == null) goto L7;
            r5.invalidate();
        L7:
            suppressLayout(false);
        }

        private void suppressLayout(boolean r5) {
            if (this.mSuppressLayout == true) goto L5;
            return;
        L5:
            if (this.mLayoutSuppressed == r5) goto L11;
            ViewGroup r10 = this.mParent;
            if (r10 == null) goto L12;
            this.mLayoutSuppressed = r5;
            ViewGroupUtils.suppressLayout(r10, r5);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            hideViewWhenNotCanceled();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r5) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
            r5.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            suppressLayout(false);
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            suppressLayout(true);
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, 0);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator r5, boolean r10) {
            if (r10 == true) goto L5;
            hideViewWhenNotCanceled();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator r5, boolean r10) {
            if (r10 == false) goto L7;
            ViewUtils.setTransitionVisibility(this.mView, 0);
            ViewGroup r11 = this.mParent;
            if (r11 == null) goto L8;
            r11.invalidate();
            return;
        L8:
            return;
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Mode {
    }

    public class OverlayListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean mHasOverlay;
        private final ViewGroup mOverlayHost;
        private final View mOverlayView;
        private final View mStartView;
        final /* synthetic */ Visibility this$0;

        public OverlayListener(Visibility r5, ViewGroup r10, View r11, View r12) {
            this.this$0 = r5;
            this.mHasOverlay = true;
            this.mOverlayHost = r10;
            this.mOverlayView = r11;
            this.mStartView = r12;
        }

        private void removeFromOverlay() {
            this.mStartView.setTag(R.id.save_overlay_view, null);
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
            this.mHasOverlay = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            removeFromOverlay();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r5) {
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r5) {
            if (this.mOverlayView.getParent() != null) goto L5;
            this.mOverlayHost.getOverlay().add(this.mOverlayView);
            return;
        L5:
            this.this$0.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator r5, boolean r10) {
            if (r10 == false) goto L5;
            this.mStartView.setTag(R.id.save_overlay_view, this.mOverlayView);
            this.mOverlayHost.getOverlay().add(this.mOverlayView);
            this.mHasOverlay = true;
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
            if (this.mHasOverlay == false) goto L6;
            removeFromOverlay();
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
            r5.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator r5, boolean r10) {
            if (r10 == true) goto L5;
            removeFromOverlay();
            return;
        }
    }

    public static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        public VisibilityInfo() {
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_VISIBILITY, PROPNAME_PARENT};
    }

    public Visibility() {
        this.mMode = 3;
    }

    private void captureValues(TransitionValues r5) {
        int r10 = r5.view.getVisibility();
        r5.values.put(PROPNAME_VISIBILITY, Integer.valueOf(r10));
        r5.values.put(PROPNAME_PARENT, r5.view.getParent());
        int[] r11 = new int[2];
        r5.view.getLocationOnScreen(r11);
        r5.values.put(PROPNAME_SCREEN_LOCATION, r11);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues r10, TransitionValues r11) {
        VisibilityInfo r12 = new VisibilityInfo();
        r12.mVisibilityChange = false;
        r12.mFadeIn = false;
        if (r10 != null) goto L5;
    L7:
        r12.mStartVisibility = -1;
        r12.mStartParent = null;
    L8:
        if (r11 != null) goto L10;
    L12:
        r12.mEndVisibility = -1;
        r12.mEndParent = null;
    L14:
        if (r10 == null) goto L32;
        if (r11 == null) goto L32;
        int r13 = r12.mStartVisibility;
        int r14 = r12.mEndVisibility;
        if (r13 == r14) goto L19;
    L21:
        if (r13 == r14) goto L27;
        if (r13 != 0) goto L24;
        r12.mFadeIn = false;
        r12.mVisibilityChange = true;
    L40:
        return r12;
    L24:
        if (r14 != 0) goto L40;
        r12.mFadeIn = true;
        r12.mVisibilityChange = true;
        goto L40
    L27:
        if (r12.mEndParent != null) goto L30;
        r12.mFadeIn = false;
        r12.mVisibilityChange = true;
        goto L40
    L30:
        if (r12.mStartParent != null) goto L40;
        r12.mFadeIn = true;
        r12.mVisibilityChange = true;
        goto L40
    L19:
        if (r12.mStartParent != r12.mEndParent) goto L21;
        return r12;
    L32:
        if (r10 == null) goto L34;
    L36:
        if (r11 != null) goto L40;
        if (r12.mStartVisibility != 0) goto L40;
        r12.mFadeIn = false;
        r12.mVisibilityChange = true;
        goto L40
    L34:
        if (r12.mEndVisibility != 0) goto L36;
        r12.mFadeIn = true;
        r12.mVisibilityChange = true;
        goto L40
    L10:
        if (r11.values.containsKey(PROPNAME_VISIBILITY) == false) goto L12;
        r12.mEndVisibility = ((Integer) r11.values.get(PROPNAME_VISIBILITY)).intValue();
        r12.mEndParent = (ViewGroup) r11.values.get(PROPNAME_PARENT);
        goto L14
    L5:
        if (r10.values.containsKey(PROPNAME_VISIBILITY) == false) goto L7;
        r12.mStartVisibility = ((Integer) r10.values.get(PROPNAME_VISIBILITY)).intValue();
        r12.mStartParent = (ViewGroup) r10.values.get(PROPNAME_PARENT);
        goto L8
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        captureValues(r5);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        captureValues(r5);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        VisibilityInfo r5 = getVisibilityChangeInfo(r11, r12);
        if (r5.mVisibilityChange == true) goto L5;
        return null;
    L5:
        if (r5.mStartParent != null) goto L9;
        if (r5.mEndParent != null) goto L9;
        return null;
    L9:
        if (r5.mFadeIn == false) goto L13;
        return onAppear(r10, r11, r5.mStartVisibility, r12, r5.mEndVisibility);
    L13:
        return onDisappear(r10, r11, r5.mStartVisibility, r12, r5.mEndVisibility);
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(@Nullable TransitionValues r5, @Nullable TransitionValues r10) {
        if (r5 != null) goto L6;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r5 == null) goto L11;
        if (r10 == null) goto L11;
        if (r10.values.containsKey(PROPNAME_VISIBILITY) == r5.values.containsKey(PROPNAME_VISIBILITY)) goto L11;
        return false;
    L11:
        VisibilityInfo r11 = getVisibilityChangeInfo(r5, r10);
        if (r11.mVisibilityChange == true) goto L14;
        return false;
    L14:
        if (r11.mStartVisibility != 0) goto L16;
    L17:
        return true;
    L16:
        if (r11.mEndVisibility == 0) goto L17;
        return false;
    }

    public boolean isVisible(@Nullable TransitionValues r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r10 = ((Integer) r5.values.get(PROPNAME_VISIBILITY)).intValue();
        View r11 = (View) r5.values.get(PROPNAME_PARENT);
        if (r10 != 0) goto L10;
        if (r11 == null) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    @Nullable
    public Animator onAppear(@NonNull ViewGroup r5, @NonNull View r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        return null;
    }

    @Nullable
    public Animator onDisappear(@NonNull ViewGroup r5, @NonNull View r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        return null;
    }

    public void setMode(int r5) {
        if ((r5 & (-4)) != 0) goto L7;
        this.mMode = r5;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Nullable
    public Animator onAppear(@NonNull ViewGroup r5, @Nullable TransitionValues r10, int r11, @Nullable TransitionValues r12, int r13) {
        if ((this.mMode & 1) != 1) goto L12;
        if (r12 == null) goto L12;
        if (r10 != null) goto L11;
        View r14 = (View) r12.view.getParent();
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r14, false), getTransitionValues(r14, false)).mVisibilityChange == false) goto L11;
        return null;
    L11:
        return onAppear(r5, r12.view, r10, r12);
    L12:
        return null;
    }

    @Nullable
    public Animator onDisappear(@NonNull ViewGroup r11, @Nullable TransitionValues r12, int r13, @Nullable TransitionValues r14, int r15) {
        if ((this.mMode & 2) == 2) goto L5;
        return null;
    L5:
        if (r12 != null) goto L7;
        return null;
    L7:
        View r16 = r12.view;
        if (r14 == null) goto L10;
        View r5 = r14.view;
    L11:
        View r10 = (View) r16.getTag(R.id.save_overlay_view);
        if (r10 == null) goto L14;
        View r17 = null;
        boolean r18 = true;
    L45:
        if (r10 == null) goto L54;
        if (r18 == true) goto L48;
        int[] r19 = (int[]) r12.values.get(PROPNAME_SCREEN_LOCATION);
        int r20 = r19[0];
        int r110 = r19[1];
        int[] r21 = new int[2];
        r11.getLocationOnScreen(r21);
        r10.offsetLeftAndRight((r20 - r21[0]) - r10.getLeft());
        r10.offsetTopAndBottom((r110 - r21[1]) - r10.getTop());
        r11.getOverlay().add(r10);
    L48:
        Animator r111 = onDisappear(r11, r10, r12, r14);
        if (r18 == true) goto L53;
        if (r111 != null) goto L52;
        r11.getOverlay().remove(r10);
        goto L53
    L52:
        r16.setTag(R.id.save_overlay_view, r10);
        OverlayListener r112 = new OverlayListener(this, r11, r10, r16);
        r111.addListener(r112);
        r111.addPauseListener(r112);
        getRootTransition().addListener(r112);
    L53:
        return r111;
    L54:
        if (r17 == null) goto L60;
        int r113 = r17.getVisibility();
        ViewUtils.setTransitionVisibility(r17, 0);
        Animator r114 = onDisappear(r11, r17, r12, r14);
        if (r114 == null) goto L58;
        DisappearListener r115 = new DisappearListener(r17, r15, true);
        r114.addListener(r115);
        getRootTransition().addListener(r115);
    L59:
        return r114;
    L58:
        ViewUtils.setTransitionVisibility(r17, r113);
        goto L59
    L60:
        return null;
    L14:
        if (r5 != null) goto L16;
    L24:
        if (r5 != null) goto L25;
    L23:
        r5 = null;
        View r22 = null;
        boolean r23 = true;
    L26:
        if (r23 == true) goto L28;
    L35:
        r18 = false;
        View r24 = r22;
        r10 = r5;
        r17 = r24;
        goto L45
    L28:
        if (r16.getParent() != null) goto L31;
    L44:
        r17 = r22;
        r18 = false;
        r10 = r16;
        goto L45
    L31:
        if ((r16.getParent() instanceof View) == false) goto L35;
        View r25 = (View) r16.getParent();
        if (getVisibilityChangeInfo(getTransitionValues(r25, true), getMatchedTransitionValues(r25, true)).mVisibilityChange == true) goto L36;
        r5 = TransitionUtils.copyViewImage(r11, r16, r25);
        goto L35
    L36:
        int r26 = r25.getId();
        if (r25.getParent() != null) goto L35;
        if (r26 == (-1)) goto L35;
        if (r11.findViewById(r26) == null) goto L35;
        if (this.mCanRemoveViews == false) goto L35;
    L25:
        r22 = null;
        r23 = false;
        goto L26
    L16:
        if (r5.getParent() == null) goto L24;
        if (r15 == 4) goto L22;
        if (r16 != r5) goto L23;
    L22:
        r22 = r5;
        r23 = false;
        r5 = null;
        goto L26
    L10:
        r5 = null;
        goto L11
    }

    public Visibility(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        this.mMode = 3;
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.VISIBILITY_TRANSITION);
        int r12 = TypedArrayUtils.getNamedInt(r11, (XmlResourceParser) r10, "transitionVisibilityMode", 0, 0);
        r11.recycle();
        if (r12 == 0) goto L6;
        setMode(r12);
        return;
    }
}
