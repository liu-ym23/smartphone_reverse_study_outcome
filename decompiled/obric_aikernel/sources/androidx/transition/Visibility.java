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

    private static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {
        boolean mCanceled;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        DisappearListener(View r10, int r11, boolean r12) {
            this.mCanceled = false;
            this.mView = r10;
            this.mFinalVisibility = r11;
            this.mParent = (ViewGroup) r10.getParent();
            this.mSuppressLayout = r12;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (this.mCanceled == true) goto L7;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup r10 = this.mParent;
            if (r10 == null) goto L7;
            r10.invalidate();
        L7:
            suppressLayout(false);
        }

        private void suppressLayout(boolean r10) {
            if (this.mSuppressLayout == true) goto L5;
            return;
        L5:
            if (this.mLayoutSuppressed == r10) goto L11;
            ViewGroup r11 = this.mParent;
            if (r11 == null) goto L12;
            this.mLayoutSuppressed = r10;
            ViewGroupUtils.suppressLayout(r11, r10);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            hideViewWhenNotCanceled();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator r10) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator r10) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, 0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r10) {
            hideViewWhenNotCanceled();
            r10.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r10) {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r10) {
            suppressLayout(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r10) {
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Mode {
    }

    private static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        VisibilityInfo() {
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_VISIBILITY, PROPNAME_PARENT};
    }

    public Visibility() {
        this.mMode = 3;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mMode = 3;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.VISIBILITY_TRANSITION);
        int r13 = TypedArrayUtils.getNamedInt(r12, (XmlResourceParser) r11, "transitionVisibilityMode", 0, 0);
        r12.recycle();
        if (r13 == 0) goto L6;
        setMode(r13);
        return;
    }

    private void captureValues(TransitionValues r10) {
        int r11 = r10.view.getVisibility();
        r10.values.put(PROPNAME_VISIBILITY, Integer.valueOf(r11));
        r10.values.put(PROPNAME_PARENT, r10.view.getParent());
        int[] r12 = new int[2];
        r10.view.getLocationOnScreen(r12);
        r10.values.put(PROPNAME_SCREEN_LOCATION, r12);
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
        if (r13 == 0) goto L40;
        if (r14 == 0) goto L35;
    L41:
        return r12;
    L35:
        r12.mFadeIn = true;
    L36:
        r12.mVisibilityChange = true;
    L40:
        r12.mFadeIn = false;
        goto L36
    L27:
        if (r12.mEndParent == null) goto L40;
        if (r12.mStartParent != null) goto L41;
    L19:
        if (r12.mStartParent != r12.mEndParent) goto L21;
        return r12;
    L32:
        if (r10 == null) goto L34;
    L37:
        if (r11 != null) goto L41;
        if (r12.mStartVisibility != 0) goto L41;
    L34:
        if (r12.mEndVisibility != 0) goto L37;
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
    public void captureEndValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        VisibilityInfo r13 = getVisibilityChangeInfo(r11, r12);
        if (r13.mVisibilityChange == true) goto L5;
        return null;
    L5:
        if (r13.mStartParent != null) goto L9;
        if (r13.mEndParent != null) goto L9;
        return null;
    L9:
        if (r13.mFadeIn == false) goto L13;
        return onAppear(r10, r11, r13.mStartVisibility, r12, r13.mEndVisibility);
    L13:
        return onDisappear(r10, r11, r13.mStartVisibility, r12, r13.mEndVisibility);
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
    public boolean isTransitionRequired(TransitionValues r10, TransitionValues r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r10 == null) goto L11;
        if (r11 == null) goto L11;
        if (r11.values.containsKey(PROPNAME_VISIBILITY) == r10.values.containsKey(PROPNAME_VISIBILITY)) goto L11;
        return false;
    L11:
        VisibilityInfo r12 = getVisibilityChangeInfo(r10, r11);
        if (r12.mVisibilityChange == true) goto L14;
        return false;
    L14:
        if (r12.mStartVisibility != 0) goto L16;
    L17:
        return true;
    L16:
        if (r12.mEndVisibility == 0) goto L17;
        return false;
    }

    public boolean isVisible(TransitionValues r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = ((Integer) r10.values.get(PROPNAME_VISIBILITY)).intValue();
        View r12 = (View) r10.values.get(PROPNAME_PARENT);
        if (r11 != 0) goto L10;
        if (r12 == null) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public Animator onAppear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        return null;
    }

    public Animator onAppear(ViewGroup r10, TransitionValues r11, int r12, TransitionValues r13, int r14) {
        if ((this.mMode & 1) != 1) goto L12;
        if (r13 == null) goto L12;
        if (r11 != null) goto L11;
        View r15 = (View) r13.view.getParent();
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r15, false), getTransitionValues(r15, false)).mVisibilityChange == false) goto L11;
        return null;
    L11:
        return onAppear(r10, r13.view, r11, r13);
    L12:
        return null;
    }

    public Animator onDisappear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        return null;
    }

    public Animator onDisappear(final ViewGroup r18, TransitionValues r19, int r20, TransitionValues r21, int r22) {
        if ((this.mMode & 2) == 2) goto L5;
        return null;
    L5:
        if (r19 != null) goto L7;
        return null;
    L7:
        final View r10 = r19.view;
        if (r21 == null) goto L10;
        View r11 = r21.view;
    L11:
        int r12 = R.id.save_overlay_view;
        final View r13 = (View) r10.getTag(r12);
        if (r13 == null) goto L14;
        View r14 = null;
        boolean r15 = true;
    L45:
        if (r13 == null) goto L54;
        if (r15 == true) goto L48;
        int[] r16 = (int[]) r19.values.get(PROPNAME_SCREEN_LOCATION);
        int r17 = r16[0];
        int r23 = r16[1];
        int[] r24 = new int[2];
        r18.getLocationOnScreen(r24);
        r13.offsetLeftAndRight((r17 - r24[0]) - r13.getLeft());
        r13.offsetTopAndBottom((r23 - r24[1]) - r13.getTop());
        ViewGroupUtils.getOverlay(r18).add(r13);
    L48:
        Animator r25 = onDisappear(r18, r13, r19, r21);
        if (r15 == true) goto L53;
        if (r25 != null) goto L52;
        ViewGroupUtils.getOverlay(r18).remove(r13);
        goto L53
    L52:
        r10.setTag(r12, r13);
        addListener(new AnonymousClass1(this, r18, r13, r10));
    L53:
        return r25;
    L54:
        if (r14 == null) goto L60;
        int r26 = r14.getVisibility();
        ViewUtils.setTransitionVisibility(r14, 0);
        Animator r27 = onDisappear(r18, r14, r19, r21);
        if (r27 == null) goto L58;
        DisappearListener r28 = new DisappearListener(r14, r22, true);
        r27.addListener(r28);
        AnimatorUtils.addPauseListener(r27, r28);
        addListener(r28);
    L59:
        return r27;
    L58:
        ViewUtils.setTransitionVisibility(r14, r26);
        goto L59
    L60:
        return null;
    L14:
        if (r11 != null) goto L16;
    L23:
        if (r11 == null) goto L25;
        View r110 = null;
        boolean r111 = false;
    L26:
        if (r111 == true) goto L28;
    L44:
        r15 = false;
        View r112 = r110;
        r13 = r11;
        r14 = r112;
        goto L45
    L28:
        if (r10.getParent() != null) goto L31;
    L43:
        r14 = r110;
        r15 = false;
        r13 = r10;
        goto L45
    L31:
        if ((r10.getParent() instanceof View) == false) goto L44;
        View r113 = (View) r10.getParent();
        if (getVisibilityChangeInfo(getTransitionValues(r113, true), getMatchedTransitionValues(r113, true)).mVisibilityChange == true) goto L35;
        r11 = TransitionUtils.copyViewImage(r18, r10, r113);
        goto L44
    L35:
        int r114 = r113.getId();
        if (r113.getParent() != null) goto L44;
        if (r114 == (-1)) goto L44;
        if (r18.findViewById(r114) == null) goto L44;
        if (this.mCanRemoveViews == false) goto L44;
    L25:
        r11 = null;
        r110 = null;
        r111 = true;
        goto L26
    L16:
        if (r11.getParent() == null) goto L23;
        if (r22 == 4) goto L22;
        if (r10 != r11) goto L25;
    L22:
        r110 = r11;
        r111 = false;
        r11 = null;
        goto L26
    L10:
        r11 = null;
        goto L11
    }

    public void setMode(int r10) {
        if ((r10 & (-4)) != 0) goto L7;
        this.mMode = r10;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
