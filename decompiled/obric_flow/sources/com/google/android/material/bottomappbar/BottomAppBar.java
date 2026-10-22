package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.d;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_ATTR = 0;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_DEFAULT = 300;
    private static final int FAB_ALIGNMENT_ANIM_EASING_ATTR = 0;
    private static final float FAB_ALIGNMENT_ANIM_EASING_MIDPOINT = 0.2f;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANCHOR_MODE_CRADLE = 1;
    public static final int FAB_ANCHOR_MODE_EMBED = 0;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int MENU_ALIGNMENT_MODE_AUTO = 0;
    public static final int MENU_ALIGNMENT_MODE_START = 1;
    private static final int NO_FAB_END_MARGIN = -1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<AnimationListener> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;

    @Px
    private int fabAlignmentModeEndMargin;
    private int fabAnchorMode;

    @NonNull
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;

    @NonNull
    TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private int menuAlignmentMode;
    private boolean menuAnimatingWithFabAlignmentMode;

    @Nullable
    private Animator menuAnimator;

    @Nullable
    private Animator modeAnimator;

    @Nullable
    private Integer navigationIconTint;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;

    @MenuRes
    private int pendingMenuResId;
    private final boolean removeEmbeddedFabElevation;
    private int rightInset;

    public interface AnimationListener {
        void onAnimationEnd(BottomAppBar r5);

        void onAnimationStart(BottomAppBar r5);
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        @NonNull
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        public Behavior() {
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }

        public static /* synthetic */ WeakReference access$2500(Behavior r5) {
            return r5.viewRef;
        }

        public static /* synthetic */ Rect access$2600(Behavior r5) {
            return r5.fabContentRect;
        }

        public static /* synthetic */ int access$2700(Behavior r5) {
            return r5.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11) {
            return onLayoutChild(r5, (BottomAppBar) r10, r11);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
            return onStartNestedScroll(r5, (BottomAppBar) r10, r11, r12, r13, r14);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull BottomAppBar r10, int r11) {
            this.viewRef = new WeakReference(r10);
            View r12 = BottomAppBar.access$3200(r10);
            if (r12 != null) goto L5;
        L21:
            r5.onLayoutChild(r10, r11);
            return super.onLayoutChild(r5, r10, r11);
        L5:
            if (ViewCompat.isLaidOut(r12) == true) goto L21;
            BottomAppBar.access$3300(r10, r12);
            this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r12.getLayoutParams())).bottomMargin;
            if ((r12 instanceof FloatingActionButton) == false) goto L20;
            FloatingActionButton r13 = (FloatingActionButton) r12;
            if (BottomAppBar.access$400(r10) != 0) goto L14;
            if (BottomAppBar.access$3400(r10) == false) goto L14;
            ViewCompat.setElevation(r13, 0.0f);
            r13.setCompatElevation(0.0f);
        L14:
            if (r13.getShowMotionSpec() != null) goto L17;
            r13.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
        L17:
            if (r13.getHideMotionSpec() != null) goto L19;
            r13.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
        L19:
            BottomAppBar.access$3500(r10, r13);
        L20:
            r12.addOnLayoutChangeListener(this.fabLayoutListener);
            BottomAppBar.access$1400(r10);
            goto L21
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull BottomAppBar r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
            if (r10.getHideOnScroll() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onStartNestedScroll(r5, r10, r11, r12, r13, r14) == false) goto L7;
            return true;
        }

        public Behavior(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FabAnchorMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface MenuAlignmentMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int fabAlignmentMode;
        boolean fabAttached;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.fabAlignmentMode);
            r5.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r5, ClassLoader r10) {
            super(r5, r10);
            this.fabAlignmentMode = r5.readInt();
            if (r5.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.fabAttached = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
        FAB_ALIGNMENT_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
        FAB_ALIGNMENT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    }

    public BottomAppBar(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(View r5) {
        lambda$onLayout$0(r5);
    }

    public static /* synthetic */ boolean access$000(BottomAppBar r5) {
        return r5.menuAnimatingWithFabAlignmentMode;
    }

    public static /* synthetic */ boolean access$002(BottomAppBar r5, boolean r10) {
        r5.menuAnimatingWithFabAlignmentMode = r10;
        return r10;
    }

    public static /* synthetic */ int access$100(BottomAppBar r5) {
        return r5.fabAlignmentMode;
    }

    public static /* synthetic */ int access$1000(BottomAppBar r5) {
        return r5.leftInset;
    }

    public static /* synthetic */ int access$1002(BottomAppBar r5, int r10) {
        r5.leftInset = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1100(BottomAppBar r5) {
        return r5.paddingRightSystemWindowInsets;
    }

    public static /* synthetic */ int access$1200(BottomAppBar r5) {
        return r5.rightInset;
    }

    public static /* synthetic */ int access$1202(BottomAppBar r5, int r10) {
        r5.rightInset = r10;
        return r10;
    }

    public static /* synthetic */ void access$1300(BottomAppBar r5) {
        r5.cancelAnimations();
    }

    public static /* synthetic */ void access$1400(BottomAppBar r5) {
        r5.setCutoutStateAndTranslateFab();
    }

    public static /* synthetic */ void access$1500(BottomAppBar r5) {
        r5.setActionMenuViewPosition();
    }

    public static /* synthetic */ void access$1600(BottomAppBar r5) {
        r5.dispatchAnimationStart();
    }

    public static /* synthetic */ void access$1700(BottomAppBar r5) {
        r5.dispatchAnimationEnd();
    }

    public static /* synthetic */ Animator access$1802(BottomAppBar r5, Animator r10) {
        r5.modeAnimator = r10;
        return r10;
    }

    public static /* synthetic */ float access$1900(BottomAppBar r5, int r10) {
        return r5.getFabTranslationX(r10);
    }

    public static /* synthetic */ boolean access$200(BottomAppBar r5) {
        return r5.fabAttached;
    }

    public static /* synthetic */ Animator access$2002(BottomAppBar r5, Animator r10) {
        r5.menuAnimator = r10;
        return r10;
    }

    public static /* synthetic */ int access$2100(BottomAppBar r5) {
        return r5.pendingMenuResId;
    }

    public static /* synthetic */ void access$2200(BottomAppBar r5, ActionMenuView r10, int r11, boolean r12, boolean r13) {
        r5.translateActionMenuView(r10, r11, r12, r13);
    }

    public static /* synthetic */ FloatingActionButton access$2300(BottomAppBar r5) {
        return r5.findDependentFab();
    }

    public static /* synthetic */ float access$2400(BottomAppBar r5) {
        return r5.getFabTranslationX();
    }

    public static /* synthetic */ int access$2800(BottomAppBar r5) {
        return r5.getBottomInset();
    }

    public static /* synthetic */ int access$2900(BottomAppBar r5) {
        return r5.getLeftInset();
    }

    public static /* synthetic */ void access$300(BottomAppBar r5, int r10, boolean r11) {
        r5.maybeAnimateMenuView(r10, r11);
    }

    public static /* synthetic */ int access$3000(BottomAppBar r5) {
        return r5.getRightInset();
    }

    public static /* synthetic */ int access$3100(BottomAppBar r5) {
        return r5.fabOffsetEndMode;
    }

    public static /* synthetic */ View access$3200(BottomAppBar r5) {
        return r5.findDependentView();
    }

    public static /* synthetic */ void access$3300(BottomAppBar r5, View r10) {
        updateFabAnchorGravity(r5, r10);
    }

    public static /* synthetic */ boolean access$3400(BottomAppBar r5) {
        return r5.removeEmbeddedFabElevation;
    }

    public static /* synthetic */ void access$3500(BottomAppBar r5, FloatingActionButton r10) {
        r5.addFabAnimationListeners(r10);
    }

    public static /* synthetic */ int access$400(BottomAppBar r5) {
        return r5.fabAnchorMode;
    }

    public static /* synthetic */ MaterialShapeDrawable access$500(BottomAppBar r5) {
        return r5.materialShapeDrawable;
    }

    public static /* synthetic */ BottomAppBarTopEdgeTreatment access$600(BottomAppBar r5) {
        return r5.getTopEdgeTreatment();
    }

    public static /* synthetic */ boolean access$700(BottomAppBar r5) {
        return r5.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ int access$802(BottomAppBar r5, int r10) {
        r5.bottomInset = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$900(BottomAppBar r5) {
        return r5.paddingLeftSystemWindowInsets;
    }

    private void addFabAnimationListeners(@NonNull FloatingActionButton r5) {
        r5.addOnHideAnimationListener(this.fabAnimationListener);
        r5.addOnShowAnimationListener(new AnonymousClass9(this));
        r5.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator r5 = this.menuAnimator;
        if (r5 == null) goto L5;
        r5.cancel();
    L5:
        Animator r10 = this.modeAnimator;
        if (r10 == null) goto L9;
        r10.cancel();
        return;
    }

    private void createFabTranslationXAnimation(int r5, @NonNull List<Animator> r10) {
        ObjectAnimator r11 = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(r5)});
        r11.setDuration(getFabAlignmentAnimationDuration());
        r10.add(r11);
    }

    private void createMenuViewTranslationAnimation(final int r10, final boolean r11, @NonNull List<Animator> r12) {
        final ActionMenuView r5 = getActionMenuView();
        if (r5 != null) goto L5;
        return;
    L5:
        float r13 = getFabAlignmentAnimationDuration();
        Animator r14 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f});
        r14.setDuration((long) (0.8f * r13));
        if (Math.abs(r5.getTranslationX() - getActionMenuViewTranslationX(r5, r10, r11)) <= 1.0f) goto L9;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{0.0f});
        r15.setDuration((long) (r13 * 0.2f));
        r15.addListener(new AnonymousClass7(this, r5, r10, r11));
        AnimatorSet r16 = new AnimatorSet();
        r16.playSequentially(new Animator[]{r15, r14});
        r12.add(r16);
        return;
    L9:
        if (r5.getAlpha() >= 1.0f) goto L13;
        r12.add(r14);
        return;
    }

    private void dispatchAnimationEnd() {
        int r5 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = r5;
        if (r5 != 0) goto L10;
        ArrayList<AnimationListener> r10 = this.animationListeners;
        if (r10 == null) goto L12;
        Iterator<AnimationListener> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        r11.next().onAnimationEnd(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private void dispatchAnimationStart() {
        int r5 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = r5 + 1;
        if (r5 != 0) goto L10;
        ArrayList<AnimationListener> r10 = this.animationListeners;
        if (r10 == null) goto L12;
        Iterator<AnimationListener> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        r11.next().onAnimationStart(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Nullable
    private FloatingActionButton findDependentFab() {
        View r5 = findDependentView();
        if ((r5 instanceof FloatingActionButton) == true) goto L7;
        return null;
    L7:
        return (FloatingActionButton) r5;
    }

    @Nullable
    private View findDependentView() {
        if ((getParent() instanceof CoordinatorLayout) == true) goto L5;
        return null;
    L5:
        Iterator<View> r5 = ((CoordinatorLayout) getParent()).getDependents(this).iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        View r10 = r5.next();
        if ((r10 instanceof FloatingActionButton) == true) goto L12;
        if ((r10 instanceof ExtendedFloatingActionButton) == false) goto L7;
    L12:
        return r10;
    L13:
        return null;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        int r5 = 0;
    L4:
        if (r5 >= getChildCount()) goto L10;
        View r10 = getChildAt(r5);
        if ((r10 instanceof ActionMenuView) == true) goto L8;
        r5 = r5 + 1;
        goto L4
    L8:
        return (ActionMenuView) r10;
    L10:
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.resolveThemeDuration(getContext(), FAB_ALIGNMENT_ANIM_DURATION_ATTR, 300);
    }

    private float getFabTranslationX(int r10) {
        boolean r5 = ViewUtils.isLayoutRtl(this);
        int r11 = 1;
        if (r10 != 1) goto L18;
        View r12 = findDependentView();
        if (r5 == false) goto L7;
        int r13 = this.leftInset;
    L9:
        if (this.fabAlignmentModeEndMargin == (-1)) goto L12;
        if (r12 == null) goto L12;
        int r14 = ((r12.getMeasuredWidth() / 2) + this.fabAlignmentModeEndMargin) + r13;
    L13:
        int r15 = (getMeasuredWidth() / 2) - r14;
        if (r5 == false) goto L17;
        r11 = -1;
    L17:
        return r15 * r11;
    L12:
        r14 = this.fabOffsetEndMode + r13;
        goto L13
    L7:
        r13 = this.rightInset;
        goto L9
    L18:
        return 0.0f;
    }

    private float getFabTranslationY() {
        if (this.fabAnchorMode == 1) goto L5;
        View r5 = findDependentView();
        if (r5 == null) goto L9;
        int r10 = (-((getMeasuredHeight() + getBottomInset()) - r5.getMeasuredHeight())) / 2;
    L11:
        return r10;
    L9:
        r10 = 0;
        goto L11
    L5:
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    @NonNull
    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton r5 = findDependentFab();
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isOrWillBeShown() == false) goto L7;
        return true;
    }

    private static /* synthetic */ void lambda$onLayout$0(View r5) {
        r5.requestLayout();
    }

    private void maybeAnimateMenuView(int r5, boolean r10) {
        if (ViewCompat.isLaidOut(this) == true) goto L6;
        this.menuAnimatingWithFabAlignmentMode = false;
        replaceMenu(this.pendingMenuResId);
        return;
    L6:
        Animator r11 = this.menuAnimator;
        if (r11 == null) goto L9;
        r11.cancel();
    L9:
        ArrayList r12 = new ArrayList();
        if (isFabVisibleOrWillBeShown() == true) goto L12;
        r5 = 0;
        r10 = false;
    L12:
        createMenuViewTranslationAnimation(r5, r10, r12);
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(r12);
        this.menuAnimator = r13;
        r13.addListener(new AnonymousClass6(this));
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int r5) {
        if (this.fabAlignmentMode != r5) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        Animator r10 = this.modeAnimator;
        if (r10 == null) goto L10;
        r10.cancel();
    L10:
        ArrayList r11 = new ArrayList();
        if (this.fabAnimationMode != 1) goto L13;
        createFabTranslationXAnimation(r5, r11);
    L14:
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(r11);
        r12.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), FAB_ALIGNMENT_ANIM_EASING_ATTR, AnimationUtils.LINEAR_INTERPOLATOR));
        this.modeAnimator = r12;
        r12.addListener(new AnonymousClass4(this));
        this.modeAnimator.start();
        return;
    L13:
        createFabDefaultXAnimation(r5, r11);
        goto L14
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable r5) {
        if (r5 != null) goto L4;
        return r5;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r10 = DrawableCompat.wrap(r5.mutate());
        DrawableCompat.setTint(r10, this.navigationIconTint.intValue());
        return r10;
    L8:
        return r5;
    }

    private void setActionMenuViewPosition() {
        ActionMenuView r5 = getActionMenuView();
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.menuAnimator != null) goto L12;
        r5.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown() == true) goto L9;
        translateActionMenuView(r5, 0, false);
        return;
    L9:
        translateActionMenuView(r5, this.fabAlignmentMode, this.fabAttached);
        return;
    }

    private void setCutoutStateAndTranslateFab() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        MaterialShapeDrawable r5 = this.materialShapeDrawable;
        if (this.fabAttached == true) goto L5;
    L9:
        float r10 = 0.0f;
    L10:
        r5.setInterpolation(r10);
        View r11 = findDependentView();
        if (r11 == null) goto L14;
        r11.setTranslationY(getFabTranslationY());
        r11.setTranslationX(getFabTranslationX());
        return;
    L14:
        return;
    L5:
        if (isFabVisibleOrWillBeShown() == false) goto L9;
        if (this.fabAnchorMode != 1) goto L9;
        r10 = 1.0f;
        goto L10
    }

    private void translateActionMenuView(@NonNull ActionMenuView r5, int r10, boolean r11) {
        translateActionMenuView(r5, r10, r11, false);
    }

    private static void updateFabAnchorGravity(BottomAppBar r5, View r10) {
        CoordinatorLayout.LayoutParams r11 = (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
        r11.anchorGravity = 17;
        int r12 = r5.fabAnchorMode;
        if (r12 != 1) goto L5;
        r11.anchorGravity = 17 | 48;
    L5:
        if (r12 != 0) goto L8;
        r11.anchorGravity |= 80;
        return;
    }

    public void addAnimationListener(@NonNull AnimationListener r5) {
        if (this.animationListeners != null) goto L5;
        this.animationListeners = new ArrayList();
    L5:
        this.animationListeners.add(r5);
    }

    public void addOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.OnScrollStateChangedListener r5) {
        getBehavior().addOnScrollStateChangedListener(r5);
    }

    public void clearOnScrollStateChangedListeners() {
        getBehavior().clearOnScrollStateChangedListeners();
    }

    public void createFabDefaultXAnimation(final int r5, List<Animator> r10) {
        FloatingActionButton r11 = findDependentFab();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isOrWillBeHidden() == true) goto L10;
        dispatchAnimationStart();
        r11.hide(new AnonymousClass5(this, r5));
        return;
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView r10, int r11, boolean r12) {
        int r5 = 0;
        if (this.menuAlignmentMode == 1) goto L7;
        if (r11 != 1) goto L6;
        if (r12 == true) goto L7;
    L6:
        return 0;
    L7:
        boolean r13 = ViewUtils.isLayoutRtl(this);
        if (r13 == false) goto L10;
        int r14 = getMeasuredWidth();
    L11:
        int r15 = 0;
    L13:
        if (r15 >= getChildCount()) goto L22;
        View r16 = getChildAt(r15);
        if ((r16.getLayoutParams() instanceof Toolbar.LayoutParams) == false) goto L21;
        if ((((Toolbar.LayoutParams) r16.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 8388611) goto L21;
        if (r13 == false) goto L20;
        r14 = Math.min(r14, r16.getLeft());
        goto L21
    L20:
        r14 = Math.max(r14, r16.getRight());
    L21:
        r15 = r15 + 1;
        goto L13
    L22:
        if (r13 == false) goto L24;
        int r17 = r10.getRight();
    L25:
        if (r13 == false) goto L27;
        int r18 = this.rightInset;
    L29:
        if (getNavigationIcon() != null) goto L35;
        int r19 = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
        if (r13 == false) goto L33;
    L32:
        r5 = r19;
        goto L35
    L33:
        r19 = -r19;
    L35:
        return r14 - ((r17 + r18) + r5);
    L27:
        r18 = -this.leftInset;
        goto L29
    L24:
        r17 = r10.getLeft();
        goto L25
    L10:
        r14 = 0;
        goto L11
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    @Px
    public int getFabAlignmentModeEndMargin() {
        return this.fabAlignmentModeEndMargin;
    }

    public int getFabAnchorMode() {
        return this.fabAnchorMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public int getMenuAlignmentMode() {
        return this.menuAlignmentMode;
    }

    public boolean isScrolledDown() {
        return getBehavior().isScrolledDown();
    }

    public boolean isScrolledUp() {
        return getBehavior().isScrolledUp();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if ((getParent() instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) getParent()).setClipChildren(false);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (r5 == false) goto L9;
        cancelAnimations();
        setCutoutStateAndTranslateFab();
        View r14 = findDependentView();
        if (r14 == null) goto L9;
        if (ViewCompat.isLaidOut(r14) == false) goto L9;
        r14.post(new d(r14, 14));
    L9:
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        this.fabAlignmentMode = r10.fabAlignmentMode;
        this.fabAttached = r10.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.fabAlignmentMode = this.fabAlignmentMode;
        r5.fabAttached = this.fabAttached;
        return r5;
    }

    public void performHide() {
        performHide(true);
    }

    public void performShow() {
        performShow(true);
    }

    public void removeAnimationListener(@NonNull AnimationListener r5) {
        ArrayList<AnimationListener> r10 = this.animationListeners;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.remove(r5);
    }

    public void removeOnScrollStateChangedListener(@NonNull HideBottomViewOnScrollBehavior.OnScrollStateChangedListener r5) {
        getBehavior().removeOnScrollStateChangedListener(r5);
    }

    public void replaceMenu(@MenuRes int r5) {
        if (r5 == 0) goto L5;
        this.pendingMenuResId = 0;
        getMenu().clear();
        inflateMenu(r5);
        return;
    }

    public void setBackgroundTint(@Nullable ColorStateList r5) {
        DrawableCompat.setTintList(this.materialShapeDrawable, r5);
    }

    public void setCradleVerticalOffset(@Dimension float r5) {
        if (r5 == getCradleVerticalOffset()) goto L6;
        getTopEdgeTreatment().setCradleVerticalOffset(r5);
        this.materialShapeDrawable.invalidateSelf();
        setCutoutStateAndTranslateFab();
        return;
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        this.materialShapeDrawable.setElevation(r5);
        int r10 = this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY();
        getBehavior().setAdditionalHiddenOffsetY(this, r10);
    }

    public void setFabAlignmentMode(int r5) {
        setFabAlignmentModeAndReplaceMenu(r5, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int r5, @MenuRes int r10) {
        this.pendingMenuResId = r10;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(r5, this.fabAttached);
        maybeAnimateModeChange(r5);
        this.fabAlignmentMode = r5;
    }

    public void setFabAlignmentModeEndMargin(@Px int r5) {
        if (this.fabAlignmentModeEndMargin == r5) goto L6;
        this.fabAlignmentModeEndMargin = r5;
        setCutoutStateAndTranslateFab();
        return;
    }

    public void setFabAnchorMode(int r5) {
        this.fabAnchorMode = r5;
        setCutoutStateAndTranslateFab();
        View r10 = findDependentView();
        if (r10 == null) goto L6;
        updateFabAnchorGravity(this, r10);
        r10.requestLayout();
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabAnimationMode(int r5) {
        this.fabAnimationMode = r5;
    }

    public void setFabCornerSize(@Dimension float r5) {
        if (r5 == getTopEdgeTreatment().getFabCornerRadius()) goto L6;
        getTopEdgeTreatment().setFabCornerSize(r5);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleMargin(@Dimension float r5) {
        if (r5 == getFabCradleMargin()) goto L6;
        getTopEdgeTreatment().setFabCradleMargin(r5);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float r5) {
        if (r5 == getFabCradleRoundedCornerRadius()) goto L6;
        getTopEdgeTreatment().setFabCradleRoundedCornerRadius(r5);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public boolean setFabDiameter(@Px int r5) {
        float r10 = r5;
        if (r10 == getTopEdgeTreatment().getFabDiameter()) goto L6;
        getTopEdgeTreatment().setFabDiameter(r10);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    L6:
        return false;
    }

    public void setHideOnScroll(boolean r5) {
        this.hideOnScroll = r5;
    }

    public void setMenuAlignmentMode(int r5) {
        if (this.menuAlignmentMode == r5) goto L8;
        this.menuAlignmentMode = r5;
        ActionMenuView r10 = getActionMenuView();
        if (r10 == null) goto L9;
        translateActionMenuView(r10, this.fabAlignmentMode, isFabVisibleOrWillBeShown());
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable r5) {
        super.setNavigationIcon(maybeTintNavigationIcon(r5));
    }

    public void setNavigationIconTint(@ColorInt int r5) {
        this.navigationIconTint = Integer.valueOf(r5);
        Drawable r10 = getNavigationIcon();
        if (r10 == null) goto L6;
        setNavigationIcon(r10);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r5) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r5) {
    }

    public BottomAppBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.bottomAppBarStyle);
    }

    private void translateActionMenuView(@NonNull final ActionMenuView r5, final int r10, final boolean r11, boolean r12) {
        Runnable r13 = new AnonymousClass8(this, r5, r10, r11);
        if (r12 == false) goto L5;
        r5.post(r13);
        return;
    L5:
        r13.run();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.behavior != null) goto L6;
        this.behavior = new Behavior();
    L6:
        return this.behavior;
    }

    public void performHide(boolean r5) {
        getBehavior().slideDown(this, r5);
    }

    public void performShow(boolean r5) {
        getBehavior().slideUp(this, r5);
    }

    public BottomAppBar(@NonNull Context r13, @Nullable AttributeSet r14, int r15) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r13, r14, r15, r10), r14, r15);
        MaterialShapeDrawable r16 = new MaterialShapeDrawable();
        this.materialShapeDrawable = r16;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new AnonymousClass1(this);
        this.fabTransformationCallback = new AnonymousClass2(this);
        Context r11 = getContext();
        TypedArray r5 = ThemeEnforcement.obtainStyledAttributes(r11, r14, R.styleable.BottomAppBar, r15, r10, new int[0]);
        ColorStateList r12 = MaterialResources.getColorStateList(r11, r5, R.styleable.BottomAppBar_backgroundTint);
        if (r5.hasValue(R.styleable.BottomAppBar_navigationIconTint) == false) goto L5;
        setNavigationIconTint(r5.getColor(R.styleable.BottomAppBar_navigationIconTint, -1));
    L5:
        int r17 = r5.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float r18 = r5.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float r19 = r5.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float r110 = r5.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = r5.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = r5.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.fabAnchorMode = r5.getInt(R.styleable.BottomAppBar_fabAnchorMode, 1);
        this.removeEmbeddedFabElevation = r5.getBoolean(R.styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.menuAlignmentMode = r5.getInt(R.styleable.BottomAppBar_menuAlignmentMode, 0);
        this.hideOnScroll = r5.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = r5.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r5.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r5.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.fabAlignmentModeEndMargin = r5.getDimensionPixelOffset(R.styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        boolean r20 = r5.getBoolean(R.styleable.BottomAppBar_addElevationShadow, true);
        r5.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        r16.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(r18, r19, r110)).build());
        if (r20 == false) goto L8;
        r16.setShadowCompatibilityMode(2);
    L9:
        r16.setPaintStyle(Paint.Style.FILL);
        r16.initializeElevationOverlay(r11);
        setElevation(r17);
        DrawableCompat.setTintList(r16, r12);
        ViewCompat.setBackground(this, r16);
        ViewUtils.doOnApplyWindowInsets(this, r14, r15, r10, new AnonymousClass3(this));
        return;
    L8:
        r16.setShadowCompatibilityMode(1);
        setOutlineAmbientShadowColor(0);
        setOutlineSpotShadowColor(0);
        goto L9
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
