package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static class DisappearListener extends AnimatorListenerAdapter implements AnimatorUtils.AnimatorPauseListenerCompat, Transition.TransitionListener {
        boolean mCanceled;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        DisappearListener(View r2, int r3, boolean r4) {
            this.mCanceled = false;
            this.mView = r2;
            this.mFinalVisibility = r3;
            this.mParent = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
            this.mSuppressLayout = r4;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (this.mCanceled == true) goto L7;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup r0 = this.mParent;
            if (r0 == null) goto L7;
            r0.invalidate();
        L7:
            suppressLayout(false);
        }

        private void suppressLayout(boolean r2) {
            if (this.mSuppressLayout == true) goto L5;
            return;
        L5:
            if (this.mLayoutSuppressed == r2) goto L11;
            ViewGroup r0 = this.mParent;
            if (r0 == null) goto L12;
            this.mLayoutSuppressed = r2;
            ViewGroupUtils.suppressLayout(r0, r2);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
            hideViewWhenNotCanceled();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator r1) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator r1) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, 0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r1) {
            hideViewWhenNotCanceled();
            r1.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r1) {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r1) {
            suppressLayout(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r1) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
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

    public Visibility(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.mMode = 3;
        TypedArray r7 = r5.obtainStyledAttributes(r6, Styleable.VISIBILITY_TRANSITION);
        int r8 = TypedArrayUtils.getNamedInt(r7, (XmlResourceParser) ZeusTransformUtils.preCheckCast(r6, XmlResourceParser.class, "com.obric.memorydata.plugin"), "transitionVisibilityMode", 0, 0);
        r7.recycle();
        if (r8 == 0) goto L6;
        setMode(r8);
        return;
    }

    private void captureValues(TransitionValues r3) {
        int r2 = r3.view.getVisibility();
        r3.values.put(PROPNAME_VISIBILITY, Integer.valueOf(r2));
        r3.values.put(PROPNAME_PARENT, r3.view.getParent());
        int[] r4 = new int[2];
        r3.view.getLocationOnScreen(r4);
        r3.values.put(PROPNAME_SCREEN_LOCATION, r4);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues r9, TransitionValues r10) {
        VisibilityInfo r8 = new VisibilityInfo();
        r8.mVisibilityChange = false;
        r8.mFadeIn = false;
        if (r9 != null) goto L5;
    L7:
        r8.mStartVisibility = -1;
        r8.mStartParent = null;
    L8:
        if (r10 != null) goto L10;
    L12:
        r8.mEndVisibility = -1;
        r8.mEndParent = null;
    L14:
        if (r9 == null) goto L35;
        if (r10 == null) goto L35;
        if (r8.mStartVisibility != r8.mEndVisibility) goto L22;
        if (r8.mStartParent != r8.mEndParent) goto L22;
        return r8;
    L22:
        if (r8.mStartVisibility == r8.mEndVisibility) goto L30;
        if (r8.mStartVisibility != 0) goto L27;
    L43:
        r8.mFadeIn = false;
    L39:
        r8.mVisibilityChange = true;
    L44:
        return r8;
    L27:
        if (r8.mEndVisibility != 0) goto L44;
    L38:
        r8.mFadeIn = true;
        goto L39
    L30:
        if (r8.mEndParent == null) goto L43;
        if (r8.mStartParent != null) goto L44;
    L35:
        if (r9 == null) goto L37;
    L40:
        if (r10 != null) goto L44;
        if (r8.mStartVisibility != 0) goto L44;
    L37:
        if (r8.mEndVisibility != 0) goto L40;
    L10:
        if (r10.values.containsKey(PROPNAME_VISIBILITY) == false) goto L12;
        r8.mEndVisibility = ((Integer) ZeusTransformUtils.preCheckCast(r10.values.get(PROPNAME_VISIBILITY), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r8.mEndParent = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.values.get(PROPNAME_PARENT), ViewGroup.class, "com.obric.memorydata.plugin");
        goto L14
    L5:
        if (r9.values.containsKey(PROPNAME_VISIBILITY) == false) goto L7;
        r8.mStartVisibility = ((Integer) ZeusTransformUtils.preCheckCast(r9.values.get(PROPNAME_VISIBILITY), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r8.mStartParent = (ViewGroup) ZeusTransformUtils.preCheckCast(r9.values.get(PROPNAME_PARENT), ViewGroup.class, "com.obric.memorydata.plugin");
        goto L8
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r9, TransitionValues r10, TransitionValues r11) {
        VisibilityInfo r0 = getVisibilityChangeInfo(r10, r11);
        if (r0.mVisibilityChange == true) goto L5;
        return null;
    L5:
        if (r0.mStartParent != null) goto L9;
        if (r0.mEndParent != null) goto L9;
        return null;
    L9:
        if (r0.mFadeIn == false) goto L13;
        return onAppear(r9, r10, r0.mStartVisibility, r11, r0.mEndVisibility);
    L13:
        return onDisappear(r9, r10, r0.mStartVisibility, r11, r0.mEndVisibility);
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues r5, TransitionValues r6) {
        if (r5 != null) goto L6;
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r5 == null) goto L11;
        if (r6 == null) goto L11;
        if (r6.values.containsKey(PROPNAME_VISIBILITY) == r5.values.containsKey(PROPNAME_VISIBILITY)) goto L11;
        return false;
    L11:
        VisibilityInfo r4 = getVisibilityChangeInfo(r5, r6);
        if (r4.mVisibilityChange == true) goto L14;
        return false;
    L14:
        if (r4.mStartVisibility != 0) goto L16;
    L17:
        return true;
    L16:
        if (r4.mEndVisibility == 0) goto L17;
        return false;
    }

    public boolean isVisible(TransitionValues r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(r4.values.get(PROPNAME_VISIBILITY), Integer.class, "com.obric.memorydata.plugin")).intValue();
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.values.get(PROPNAME_PARENT), View.class, "com.obric.memorydata.plugin");
        if (r0 != 0) goto L10;
        if (r5 == null) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public Animator onAppear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return null;
    }

    public Animator onAppear(ViewGroup r3, TransitionValues r4, int r5, TransitionValues r6, int r7) {
        if ((this.mMode & 1) != 1) goto L12;
        if (r6 == null) goto L12;
        if (r4 != null) goto L11;
        View r8 = (View) ZeusTransformUtils.preCheckCast(r6.view.getParent(), View.class, "com.obric.memorydata.plugin");
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r8, false), getTransitionValues(r8, false)).mVisibilityChange == false) goto L11;
        return null;
    L11:
        return onAppear(r3, r6.view, r4, r6);
    L12:
        return null;
    }

    public Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return null;
    }

    public Animator onDisappear(final ViewGroup r18, TransitionValues r19, int r20, TransitionValues r21, int r22) {
        View r8 = null;
        if ((this.mMode & 2) == 2) goto L5;
        return null;
    L5:
        if (r19 != null) goto L7;
        return null;
    L7:
        final View r6 = r19.view;
        if (r21 == null) goto L10;
        View r9 = r21.view;
    L11:
        final View r10 = (View) ZeusTransformUtils.preCheckCast(r6.getTag(ZeusTransformUtils.mapRes(R.id.save_overlay_view, OaidModel.KEY_ID, "save_overlay_view")), View.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L14;
        boolean r7 = true;
    L45:
        if (r10 == null) goto L54;
        if (r7 == true) goto L48;
        int[] r4 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r19.values.get(PROPNAME_SCREEN_LOCATION), int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");
        int r11 = r4[0];
        int r5 = r4[1];
        int[] r12 = new int[2];
        r18.getLocationOnScreen(r12);
        r10.offsetLeftAndRight((r11 - r12[0]) - r10.getLeft());
        r10.offsetTopAndBottom((r5 - r12[1]) - r10.getTop());
        ViewGroupUtils.getOverlay(r18).add(r10);
    L48:
        Animator r2 = onDisappear(r18, r10, r19, r21);
        if (r7 == true) goto L53;
        if (r2 != null) goto L52;
        ViewGroupUtils.getOverlay(r18).remove(r10);
        goto L53
    L52:
        r6.setTag(ZeusTransformUtils.mapRes(R.id.save_overlay_view, OaidModel.KEY_ID, "save_overlay_view"), r10);
        addListener(new AnonymousClass1(this, r18, r10, r6));
    L53:
        return r2;
    L54:
        if (r8 == null) goto L60;
        int r13 = r8.getVisibility();
        ViewUtils.setTransitionVisibility(r8, 0);
        Animator r1 = onDisappear(r18, r8, r19, r21);
        if (r1 == null) goto L58;
        DisappearListener r3 = new DisappearListener(r8, r22, true);
        r1.addListener(r3);
        AnimatorUtils.addPauseListener(r1, r3);
        addListener(r3);
    L59:
        return r1;
    L58:
        ViewUtils.setTransitionVisibility(r8, r13);
        goto L59
    L60:
        return null;
    L14:
        if (r9 != null) goto L16;
    L23:
        if (r9 == null) goto L25;
        View r14 = null;
        boolean r16 = false;
    L26:
        if (r16 == true) goto L28;
    L44:
        r8 = r14;
        r7 = false;
        r10 = r9;
        goto L45
    L28:
        if (r6.getParent() != null) goto L31;
    L43:
        r8 = r14;
        r7 = false;
        r10 = r6;
        goto L45
    L31:
        if (ZeusTransformUtils.instanceOf(r6.getParent(), View.class) == false) goto L44;
        View r15 = (View) ZeusTransformUtils.preCheckCast(r6.getParent(), View.class, "com.obric.memorydata.plugin");
        if (getVisibilityChangeInfo(getTransitionValues(r15, true), getMatchedTransitionValues(r15, true)).mVisibilityChange == true) goto L35;
        r8 = r14;
        r10 = TransitionUtils.copyViewImage(r18, r6, r15);
        r7 = false;
        goto L45
    L35:
        int r17 = r15.getId();
        if (r15.getParent() != null) goto L44;
        if (r17 == (-1)) goto L44;
        if (r18.findViewById(r17) == null) goto L44;
        if (this.mCanRemoveViews == false) goto L44;
    L25:
        r9 = null;
        r14 = null;
        r16 = true;
        goto L26
    L16:
        if (r9.getParent() == null) goto L23;
        if (r22 == 4) goto L22;
        if (r6 != r9) goto L25;
    L22:
        r14 = r9;
        r16 = false;
        r9 = null;
        goto L26
    L10:
        r9 = null;
        goto L11
    }

    public void setMode(int r2) {
        if ((r2 & (-4)) != 0) goto L7;
        this.mMode = r2;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
