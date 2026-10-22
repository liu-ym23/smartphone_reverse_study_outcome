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
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.k;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.r;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = 0;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<a> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    k<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private boolean menuAnimatingWithFabAlignmentMode;
    private Animator menuAnimator;
    private Animator modeAnimator;
    private Integer navigationIconTint;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;
    private int pendingMenuResId;
    private int rightInset;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        public Behavior() {
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }

        static /* synthetic */ WeakReference access$2400(Behavior r0) {
            return r0.viewRef;
        }

        static /* synthetic */ Rect access$2500(Behavior r0) {
            return r0.fabContentRect;
        }

        static /* synthetic */ int access$2600(Behavior r0) {
            return r0.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onLayoutChild(CoordinatorLayout r3, View r4, int r5) {
            return onLayoutChild(r3, (BottomAppBar) ZeusTransformUtils.preCheckCast(r4, BottomAppBar.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean onLayoutChild(CoordinatorLayout r5, BottomAppBar r6, int r7) {
            this.viewRef = new WeakReference(r6);
            View r0 = BottomAppBar.access$3100(r6);
            if (r0 != null) goto L5;
        L16:
            r5.onLayoutChild(r6, r7);
            return super.onLayoutChild(r5, r6, r7);
        L5:
            if (ViewCompat.isLaidOut(r0) == true) goto L16;
            CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            r1.anchorGravity = 49;
            this.originalBottomMargin = r1.bottomMargin;
            if (ZeusTransformUtils.instanceOf(r0, FloatingActionButton.class) == false) goto L15;
            FloatingActionButton r2 = (FloatingActionButton) ZeusTransformUtils.preCheckCast(r0, FloatingActionButton.class, "com.obric.memorydata.plugin");
            if (r2.getShowMotionSpec() != null) goto L12;
            r2.setShowMotionSpecResource(ZeusTransformUtils.mapRes(R.animator.mtrl_fab_show_motion_spec, "animator", "mtrl_fab_show_motion_spec"));
        L12:
            if (r2.getHideMotionSpec() != null) goto L14;
            r2.setHideMotionSpecResource(ZeusTransformUtils.mapRes(R.animator.mtrl_fab_hide_motion_spec, "animator", "mtrl_fab_hide_motion_spec"));
        L14:
            r2.addOnLayoutChangeListener(this.fabLayoutListener);
            BottomAppBar.access$3200(r6, r2);
        L15:
            BottomAppBar.access$1300(r6);
            goto L16
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r8, View r9, View r10, View r11, int r12, int r13) {
            return onStartNestedScroll(r8, (BottomAppBar) ZeusTransformUtils.preCheckCast(r9, BottomAppBar.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        public boolean onStartNestedScroll(CoordinatorLayout r2, BottomAppBar r3, View r4, View r5, int r6, int r7) {
            if (r3.getHideOnScroll() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onStartNestedScroll(r2, r3, r4, r5, r6, r7) == false) goto L7;
            return true;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int fabAlignmentMode;
        boolean fabAttached;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.fabAlignmentMode = r1.readInt();
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.fabAttached = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.fabAlignmentMode);
            r1.writeInt(this.fabAttached ? 1 : 0);
        }
    }

    interface a {
        void a(BottomAppBar r1);

        void b(BottomAppBar r1);
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_BottomAppBar, "style", "Widget_MaterialComponents_BottomAppBar");
    }

    public BottomAppBar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public BottomAppBar(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.bottomAppBarStyle, "attr", "bottomAppBarStyle"));
    }

    public BottomAppBar(Context r17, AttributeSet r18, int r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r18, AttributeSet.class, "com.obric.memorydata.plugin");
        int r10 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r1, r9, r19, r10), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, r19);
        MaterialShapeDrawable r11 = new MaterialShapeDrawable();
        this.materialShapeDrawable = r11;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new AnonymousClass1(this);
        this.fabTransformationCallback = new AnonymousClass2(this);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        TypedArray r2 = com.google.android.material.internal.k.a(r13, r9, R.styleable.BottomAppBar, r19, r10, new int[0]);
        ColorStateList r3 = c.a(r13, r2, ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_backgroundTint, "styleable", "BottomAppBar_backgroundTint"));
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_navigationIconTint, "styleable", "BottomAppBar_navigationIconTint")) == false) goto L5;
        setNavigationIconTint(r2.getColor(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_navigationIconTint, "styleable", "BottomAppBar_navigationIconTint"), -1));
    L5:
        int r4 = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_elevation, "styleable", "BottomAppBar_elevation"), 0);
        float r5 = r2.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_fabCradleMargin, "styleable", "BottomAppBar_fabCradleMargin"), 0);
        float r6 = r2.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, "styleable", "BottomAppBar_fabCradleRoundedCornerRadius"), 0);
        float r14 = r2.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_fabCradleVerticalOffset, "styleable", "BottomAppBar_fabCradleVerticalOffset"), 0);
        this.fabAlignmentMode = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_fabAlignmentMode, "styleable", "BottomAppBar_fabAlignmentMode"), 0);
        this.fabAnimationMode = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_fabAnimationMode, "styleable", "BottomAppBar_fabAnimationMode"), 0);
        this.hideOnScroll = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_hideOnScroll, "styleable", "BottomAppBar_hideOnScroll"), false);
        this.paddingBottomSystemWindowInsets = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, "styleable", "BottomAppBar_paddingBottomSystemWindowInsets"), false);
        this.paddingLeftSystemWindowInsets = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, "styleable", "BottomAppBar_paddingLeftSystemWindowInsets"), false);
        this.paddingRightSystemWindowInsets = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, "styleable", "BottomAppBar_paddingRightSystemWindowInsets"), false);
        r2.recycle();
        this.fabOffsetEndMode = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_bottomappbar_fabOffsetEndMode, "dimen", "mtrl_bottomappbar_fabOffsetEndMode"));
        r11.setShapeAppearanceModel(l.a().a(new com.google.android.material.bottomappbar.a(r5, r6, r14)).a());
        r11.setShadowCompatibilityMode(2);
        r11.setPaintStyle(Paint.Style.FILL);
        r11.initializeElevationOverlay(r13);
        setElevation(r4);
        DrawableCompat.setTintList(r11, r3);
        ViewCompat.setBackground(this, r11);
        r.a(this, r9, r19, r10, new AnonymousClass3(this));
    }

    static /* synthetic */ boolean access$000(BottomAppBar r0) {
        return r0.menuAnimatingWithFabAlignmentMode;
    }

    static /* synthetic */ boolean access$002(BottomAppBar r0, boolean r1) {
        r0.menuAnimatingWithFabAlignmentMode = r1;
        return r1;
    }

    static /* synthetic */ int access$100(BottomAppBar r0) {
        return r0.fabAlignmentMode;
    }

    static /* synthetic */ boolean access$1000(BottomAppBar r0) {
        return r0.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ int access$1100(BottomAppBar r0) {
        return r0.rightInset;
    }

    static /* synthetic */ int access$1102(BottomAppBar r0, int r1) {
        r0.rightInset = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(BottomAppBar r0) {
        r0.cancelAnimations();
    }

    static /* synthetic */ void access$1300(BottomAppBar r0) {
        r0.setCutoutState();
    }

    static /* synthetic */ void access$1400(BottomAppBar r0) {
        r0.setActionMenuViewPosition();
    }

    static /* synthetic */ void access$1500(BottomAppBar r0) {
        r0.dispatchAnimationStart();
    }

    static /* synthetic */ void access$1600(BottomAppBar r0) {
        r0.dispatchAnimationEnd();
    }

    static /* synthetic */ Animator access$1702(BottomAppBar r0, Animator r1) {
        r0.modeAnimator = r1;
        return r1;
    }

    static /* synthetic */ float access$1800(BottomAppBar r0, int r1) {
        return r0.getFabTranslationX(r1);
    }

    static /* synthetic */ Animator access$1902(BottomAppBar r0, Animator r1) {
        r0.menuAnimator = r1;
        return r1;
    }

    static /* synthetic */ boolean access$200(BottomAppBar r0) {
        return r0.fabAttached;
    }

    static /* synthetic */ int access$2000(BottomAppBar r0) {
        return r0.pendingMenuResId;
    }

    static /* synthetic */ void access$2100(BottomAppBar r0, ActionMenuView r1, int r2, boolean r3, boolean r4) {
        r0.translateActionMenuView(r1, r2, r3, r4);
    }

    static /* synthetic */ FloatingActionButton access$2200(BottomAppBar r0) {
        return r0.findDependentFab();
    }

    static /* synthetic */ float access$2300(BottomAppBar r0) {
        return r0.getFabTranslationX();
    }

    static /* synthetic */ int access$2700(BottomAppBar r0) {
        return r0.getBottomInset();
    }

    static /* synthetic */ int access$2800(BottomAppBar r0) {
        return r0.getLeftInset();
    }

    static /* synthetic */ int access$2900(BottomAppBar r0) {
        return r0.getRightInset();
    }

    static /* synthetic */ void access$300(BottomAppBar r0, int r1, boolean r2) {
        r0.maybeAnimateMenuView(r1, r2);
    }

    static /* synthetic */ int access$3000(BottomAppBar r0) {
        return r0.fabOffsetEndMode;
    }

    static /* synthetic */ View access$3100(BottomAppBar r0) {
        return r0.findDependentView();
    }

    static /* synthetic */ void access$3200(BottomAppBar r0, FloatingActionButton r1) {
        r0.addFabAnimationListeners(r1);
    }

    static /* synthetic */ MaterialShapeDrawable access$400(BottomAppBar r0) {
        return r0.materialShapeDrawable;
    }

    static /* synthetic */ com.google.android.material.bottomappbar.a access$500(BottomAppBar r0) {
        return r0.getTopEdgeTreatment();
    }

    static /* synthetic */ boolean access$600(BottomAppBar r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$702(BottomAppBar r0, int r1) {
        r0.bottomInset = r1;
        return r1;
    }

    static /* synthetic */ boolean access$800(BottomAppBar r0) {
        return r0.paddingLeftSystemWindowInsets;
    }

    static /* synthetic */ int access$900(BottomAppBar r0) {
        return r0.leftInset;
    }

    static /* synthetic */ int access$902(BottomAppBar r0, int r1) {
        r0.leftInset = r1;
        return r1;
    }

    private void addFabAnimationListeners(FloatingActionButton r2) {
        r2.addOnHideAnimationListener(this.fabAnimationListener);
        r2.addOnShowAnimationListener(new AnonymousClass9(this));
        r2.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator r0 = this.menuAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.modeAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    private void createFabTranslationXAnimation(int r3, List<Animator> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        ObjectAnimator r2 = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(r3)});
        r2.setDuration(300);
        r5.add(r2);
    }

    private void createMenuViewTranslationAnimation(final int r9, final boolean r10, List<Animator> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        final ActionMenuView r0 = getActionMenuView();
        if (r0 != null) goto L5;
        return;
    L5:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{1.0f});
        if (Math.abs(r0.getTranslationX() - getActionMenuViewTranslationX(r0, r9, r10)) <= 1.0f) goto L9;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{0.0f});
        r4.addListener(new AnonymousClass7(this, r0, r9, r10));
        AnimatorSet r8 = new AnimatorSet();
        r8.setDuration(150);
        r8.playSequentially(new Animator[]{r4, r2});
        r12.add(r8);
        return;
    L9:
        if (r0.getAlpha() >= 1.0f) goto L13;
        r12.add(r2);
        return;
    }

    private void dispatchAnimationEnd() {
        int r0 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = r0;
        if (r0 != 0) goto L10;
        ArrayList<a> r1 = this.animationListeners;
        if (r1 == null) goto L12;
        Iterator<a> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).b(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private void dispatchAnimationStart() {
        int r0 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = r0 + 1;
        if (r0 != 0) goto L10;
        ArrayList<a> r1 = this.animationListeners;
        if (r1 == null) goto L12;
        Iterator<a> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).a(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private FloatingActionButton findDependentFab() {
        View r2 = findDependentView();
        if (ZeusTransformUtils.instanceOf(r2, FloatingActionButton.class) == true) goto L7;
        return null;
    L7:
        return (FloatingActionButton) ZeusTransformUtils.preCheckCast(r2, FloatingActionButton.class, "com.obric.memorydata.plugin");
    }

    private View findDependentView() {
        if (ZeusTransformUtils.instanceOf(getParent(), CoordinatorLayout.class) == true) goto L5;
        return null;
    L5:
        Iterator<View> r4 = ((CoordinatorLayout) ZeusTransformUtils.preCheckCast(getParent(), CoordinatorLayout.class, "com.obric.memorydata.plugin")).getDependents(this).iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r4.next(), View.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, FloatingActionButton.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r0, ExtendedFloatingActionButton.class) == false) goto L7;
    L12:
        return r0;
    L13:
        return null;
    }

    private ActionMenuView getActionMenuView() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L10;
        View r1 = getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(r1, ActionMenuView.class) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return (ActionMenuView) ZeusTransformUtils.preCheckCast(r1, ActionMenuView.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    private float getFabTranslationX(int r4) {
        boolean r0 = r.a(this);
        int r1 = 1;
        if (r4 != 1) goto L12;
        if (r0 == false) goto L6;
        int r5 = this.leftInset;
    L7:
        int r3 = (getMeasuredWidth() / 2) - (this.fabOffsetEndMode + r5);
        if (r0 == false) goto L11;
        r1 = -1;
    L11:
        return r3 * r1;
    L6:
        r5 = this.rightInset;
        goto L7
    L12:
        return 0.0f;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().c();
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    private com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) ZeusTransformUtils.preCheckCast(this.materialShapeDrawable.getShapeAppearanceModel().k(), com.google.android.material.bottomappbar.a.class, "com.obric.memorydata.plugin");
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton r0 = findDependentFab();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOrWillBeShown() == false) goto L7;
        return true;
    }

    private void maybeAnimateMenuView(int r4, boolean r5) {
        if (ViewCompat.isLaidOut(this) == true) goto L6;
        this.menuAnimatingWithFabAlignmentMode = false;
        replaceMenu(this.pendingMenuResId);
        return;
    L6:
        Animator r0 = this.menuAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        ArrayList r1 = new ArrayList();
        if (isFabVisibleOrWillBeShown() == true) goto L12;
        r4 = 0;
        r5 = false;
    L12:
        createMenuViewTranslationAnimation(r4, r5, r1);
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(r1);
        this.menuAnimator = r6;
        r6.addListener(new AnonymousClass6(this));
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int r4) {
        if (this.fabAlignmentMode != r4) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        Animator r0 = this.modeAnimator;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        ArrayList r1 = new ArrayList();
        if (this.fabAnimationMode != 1) goto L13;
        createFabTranslationXAnimation(r4, r1);
    L14:
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(r1);
        this.modeAnimator = r5;
        r5.addListener(new AnonymousClass4(this));
        this.modeAnimator.start();
        return;
    L13:
        createFabDefaultXAnimation(r4, r1);
        goto L14
    }

    private Drawable maybeTintNavigationIcon(Drawable r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r3 = DrawableCompat.wrap(r2.mutate());
        DrawableCompat.setTint(r3, this.navigationIconTint.intValue());
        return r3;
    L8:
        return r2;
    }

    private void setActionMenuViewPosition() {
        ActionMenuView r0 = getActionMenuView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.menuAnimator != null) goto L12;
        r0.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown() == true) goto L9;
        translateActionMenuView(r0, 0, false);
        return;
    L9:
        translateActionMenuView(r0, this.fabAlignmentMode, this.fabAttached);
        return;
    }

    private void setCutoutState() {
        getTopEdgeTreatment().b(getFabTranslationX());
        View r0 = findDependentView();
        MaterialShapeDrawable r1 = this.materialShapeDrawable;
        if (this.fabAttached == true) goto L5;
    L7:
        float r2 = 0.0f;
    L8:
        r1.setInterpolation(r2);
        if (r0 == null) goto L12;
        r0.setTranslationY(getFabTranslationY());
        r0.setTranslationX(getFabTranslationX());
        return;
    L12:
        return;
    L5:
        if (isFabVisibleOrWillBeShown() == false) goto L7;
        r2 = 1.0f;
        goto L8
    }

    private void translateActionMenuView(ActionMenuView r2, int r3, boolean r4) {
        translateActionMenuView(r2, r3, r4, false);
    }

    private void translateActionMenuView(final ActionMenuView r2, final int r3, final boolean r4, boolean r5) {
        Runnable r0 = new AnonymousClass8(this, r2, r3, r4);
        if (r5 == false) goto L5;
        r2.post(r0);
        return;
    L5:
        r0.run();
    }

    void addAnimationListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (this.animationListeners != null) goto L5;
        this.animationListeners = new ArrayList();
    L5:
        this.animationListeners.add(r4);
    }

    public void createFabDefaultXAnimation(final int r3, List<Animator> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        FloatingActionButton r6 = findDependentFab();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isOrWillBeHidden() == true) goto L10;
        dispatchAnimationStart();
        r6.hide(new AnonymousClass5(this, r3));
        return;
    }

    public int getActionMenuViewTranslationX(ActionMenuView r8, int r9, boolean r10) {
        if (r9 != 1) goto L32;
        if (r10 == false) goto L32;
        boolean r11 = r.a(this);
        if (r11 == false) goto L9;
        int r12 = getMeasuredWidth();
    L10:
        int r2 = 0;
    L12:
        if (r2 >= getChildCount()) goto L24;
        View r3 = getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), Toolbar.LayoutParams.class) == true) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L23;
        if (r11 == false) goto L22;
        r12 = Math.min(r12, r3.getLeft());
        goto L23
    L22:
        r12 = Math.max(r12, r3.getRight());
    L23:
        r2 = r2 + 1;
        goto L12
    L16:
        if ((((Toolbar.LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), Toolbar.LayoutParams.class, "com.obric.memorydata.plugin")).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 8388611) goto L18;
        r4 = true;
        goto L19
    L24:
        if (r11 == false) goto L26;
        int r13 = r8.getRight();
    L27:
        if (r11 == false) goto L29;
        int r7 = this.rightInset;
    L31:
        return r12 - (r13 + r7);
    L29:
        r7 = -this.leftInset;
        goto L31
    L26:
        r13 = r8.getLeft();
        goto L27
    L9:
        r12 = 0;
    L32:
        return 0;
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public Behavior getBehavior() {
        if (this.behavior != null) goto L6;
        this.behavior = new Behavior();
    L6:
        return this.behavior;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().d();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().e();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
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
        h.a(this, this.materialShapeDrawable);
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L6;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).setClipChildren(false);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L5;
        cancelAnimations();
        setCutoutState();
    L5:
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.fabAlignmentMode = r5.fabAlignmentMode;
        this.fabAttached = r5.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.fabAlignmentMode = this.fabAlignmentMode;
        r1.fabAttached = this.fabAttached;
        return r1;
    }

    public void performHide() {
        performHide(true);
    }

    public void performHide(boolean r2) {
        getBehavior().slideDown(this, r2);
    }

    public void performShow() {
        performShow(true);
    }

    public void performShow(boolean r2) {
        getBehavior().slideUp(this, r2);
    }

    void removeAnimationListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        ArrayList<a> r2 = this.animationListeners;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.remove(r4);
    }

    public void replaceMenu(int r2) {
        if (r2 == 0) goto L5;
        this.pendingMenuResId = 0;
        getMenu().clear();
        inflateMenu(r2);
        return;
    }

    public void setBackgroundTint(ColorStateList r1) {
        DrawableCompat.setTintList(this.materialShapeDrawable, r1);
    }

    public void setCradleVerticalOffset(float r2) {
        if (r2 == getCradleVerticalOffset()) goto L6;
        getTopEdgeTreatment().c(r2);
        this.materialShapeDrawable.invalidateSelf();
        setCutoutState();
        return;
    }

    @Override // android.view.View
    public void setElevation(float r2) {
        this.materialShapeDrawable.setElevation(r2);
        int r3 = this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY();
        getBehavior().setAdditionalHiddenOffsetY(this, r3);
    }

    public void setFabAlignmentMode(int r2) {
        setFabAlignmentModeAndReplaceMenu(r2, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int r1, int r2) {
        this.pendingMenuResId = r2;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(r1, this.fabAttached);
        maybeAnimateModeChange(r1);
        this.fabAlignmentMode = r1;
    }

    public void setFabAnimationMode(int r1) {
        this.fabAnimationMode = r1;
    }

    void setFabCornerSize(float r2) {
        if (r2 == getTopEdgeTreatment().f()) goto L6;
        getTopEdgeTreatment().f(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleMargin(float r2) {
        if (r2 == getFabCradleMargin()) goto L6;
        getTopEdgeTreatment().d(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleRoundedCornerRadius(float r2) {
        if (r2 == getFabCradleRoundedCornerRadius()) goto L6;
        getTopEdgeTreatment().e(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    boolean setFabDiameter(int r2) {
        float r3 = r2;
        if (r3 == getTopEdgeTreatment().a()) goto L6;
        getTopEdgeTreatment().a(r3);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    L6:
        return false;
    }

    public void setHideOnScroll(boolean r1) {
        this.hideOnScroll = r1;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r1) {
        super.setNavigationIcon(maybeTintNavigationIcon(r1));
    }

    public void setNavigationIconTint(int r1) {
        this.navigationIconTint = Integer.valueOf(r1);
        Drawable r2 = getNavigationIcon();
        if (r2 == null) goto L6;
        setNavigationIcon(r2);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }
}
