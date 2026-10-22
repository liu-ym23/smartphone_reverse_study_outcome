package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.a.h;
import com.google.android.material.a.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.r;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import com.google.android.material.stateful.ExtendableSavedState;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements CoordinatorLayout.AttachedBehavior, TintableBackgroundView, TintableImageSourceView, com.google.android.material.e.a, p {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = 0;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final com.google.android.material.e.c expandableWidgetHelper;
    private final AppCompatImageHelper imageHelper;
    private PorterDuff.Mode imageMode;
    private int imagePadding;
    private ColorStateList imageTint;
    private d impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private a internalAutoHideListener;
        private Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public BaseBehavior(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r5, r6);
            TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, "styleable", "FloatingActionButton_Behavior_Layout_behavior_autoHide"), true);
            r7.recycle();
        }

        private static boolean isBottomSheet(View r2) {
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r3, CoordinatorLayout.LayoutParams.class) == true) goto L5;
            return false;
        L5:
            return ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior(), BottomSheetBehavior.class);
        }

        private void offsetIfNeeded(CoordinatorLayout r6, FloatingActionButton r7) {
            Rect r5 = r7.shadowPadding;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.centerX() > 0) goto L7;
            return;
        L7:
            if (r5.centerY() <= 0) goto L28;
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            int r3 = 0;
            if (r7.getRight() < (r6.getWidth() - r0.rightMargin)) goto L12;
            int r1 = r5.right;
        L16:
            if (r7.getBottom() < (r6.getHeight() - r0.bottomMargin)) goto L19;
            r3 = r5.bottom;
        L21:
            if (r3 == 0) goto L23;
            ViewCompat.offsetTopAndBottom(r7, r3);
        L23:
            if (r1 == 0) goto L29;
            ViewCompat.offsetLeftAndRight(r7, r1);
            return;
        L29:
            return;
        L19:
            if (r7.getTop() > r0.topMargin) goto L21;
            r3 = -r5.top;
            goto L21
        L12:
            if (r7.getLeft() > r0.leftMargin) goto L14;
            r1 = -r5.left;
            goto L16
        L14:
            r1 = 0;
            goto L16
        }

        private boolean shouldUpdateVisibility(View r4, FloatingActionButton r5) {
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            if (this.autoHideEnabled == true) goto L6;
            return false;
        L6:
            if (r0.getAnchorId() == r4.getId()) goto L9;
            return false;
        L9:
            if (r5.getUserSetVisibility() == 0) goto L11;
            return false;
        L11:
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r3, AppBarLayout r4, FloatingActionButton r5) {
            if (shouldUpdateVisibility(r4, r5) == true) goto L6;
            return false;
        L6:
            if (this.tmpRect != null) goto L8;
            this.tmpRect = new Rect();
        L8:
            Rect r0 = this.tmpRect;
            com.google.android.material.internal.d.b(r3, r4, r0);
            int r6 = r0.bottom;
            int r7 = r4.getMinimumHeightForVisibleOverlappingContent();
            a r2 = this.internalAutoHideListener;
            if (r6 > r7) goto L11;
            r5.hide(r2, false);
            return true;
        L11:
            r5.show(r2, false);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(View r5, FloatingActionButton r6) {
            if (shouldUpdateVisibility(r5, r6) == true) goto L5;
            return false;
        L5:
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin");
            int r7 = r5.getTop();
            int r2 = (r6.getHeight() / 2) + r0.topMargin;
            a r4 = this.internalAutoHideListener;
            if (r7 >= r2) goto L8;
            r6.hide(r4, false);
            return true;
        L8:
            r6.show(r4, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout r3, View r4, Rect r5) {
            return getInsetDodgeRect(r3, (FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean getInsetDodgeRect(CoordinatorLayout r4, FloatingActionButton r5, Rect r6) {
            Rect r3 = r5.shadowPadding;
            r6.set(r5.getLeft() + r3.left, r5.getTop() + r3.top, r5.getRight() - r3.right, r5.getBottom() - r3.bottom);
            return true;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
            if (r1.dodgeInsetEdges != 0) goto L6;
            r1.dodgeInsetEdges = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r3, View r4, View r5) {
            return onDependentViewChanged(r3, (FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r3, FloatingActionButton r4, View r5) {
            if (ZeusTransformUtils.instanceOf(r5, AppBarLayout.class) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r5, AppBarLayout.class, "com.obric.memorydata.plugin"), r4);
            return false;
        L6:
            if (isBottomSheet(r5) == false) goto L11;
            updateFabVisibilityForBottomSheet(r5, r4);
            return false;
        L11:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onLayoutChild(CoordinatorLayout r3, View r4, int r5) {
            return onLayoutChild(r3, (FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean onLayoutChild(CoordinatorLayout r7, FloatingActionButton r8, int r9) {
            List<View> r0 = r7.getDependencies(r8);
            int r1 = r0.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L15;
            View r3 = (View) ZeusTransformUtils.preCheckCast(r0.get(r2), View.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AppBarLayout.class) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r7, (AppBarLayout) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.class, "com.obric.memorydata.plugin"), r8) == true) goto L15;
        L14:
            r2 = r2 + 1;
            goto L3
        L10:
            if (isBottomSheet(r3) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r3, r8) == false) goto L14;
        L15:
            r7.onLayoutChild(r8, r9);
            offsetIfNeeded(r7, r8);
            return true;
        }

        public void setAutoHideEnabled(boolean r1) {
            this.autoHideEnabled = r1;
        }

        public void setInternalAutoHideListener(a r1) {
            this.internalAutoHideListener = r1;
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout r1, FloatingActionButton r2, Rect r3) {
            return super.getInsetDodgeRect(r1, r2, r3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
            super.onAttachedToLayoutParams(r1);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r1, FloatingActionButton r2, View r3) {
            return super.onDependentViewChanged(r1, r2, r3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, FloatingActionButton r2, int r3) {
            return super.onLayoutChild(r1, r2, r3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean r1) {
            super.setAutoHideEnabled(r1);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(a r1) {
            super.setInternalAutoHideListener(r1);
        }
    }

    public static abstract class a {
        public a() {
        }

        public void a(FloatingActionButton r1) {
        }

        public void b(FloatingActionButton r1) {
        }
    }

    private class b implements com.google.android.material.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f3915a;

        b(FloatingActionButton r1) {
            this.f3915a = r1;
        }

        @Override // com.google.android.material.h.b
        public void a(int r3, int r4, int r5, int r6) {
            this.f3915a.shadowPadding.set(r3, r4, r5, r6);
            FloatingActionButton r0 = this.f3915a;
            r0.setPadding(r3 + FloatingActionButton.access$000(r0), r4 + FloatingActionButton.access$000(this.f3915a), r5 + FloatingActionButton.access$000(this.f3915a), r6 + FloatingActionButton.access$000(this.f3915a));
        }

        @Override // com.google.android.material.h.b
        public void a(Drawable r1) {
            if (r1 == null) goto L5;
            FloatingActionButton.access$101(this.f3915a, r1);
            return;
        }

        @Override // com.google.android.material.h.b
        public boolean a() {
            return this.f3915a.compatPadding;
        }
    }

    class c<T extends FloatingActionButton> implements d.InterfaceC0184d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f3916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k<T> f3917b;

        c(FloatingActionButton r3, k<T> r4) {
            k<T> r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            this.f3916a = r3;
            this.f3917b = r5;
        }

        @Override // com.google.android.material.floatingactionbutton.d.InterfaceC0184d
        public void a() {
            this.f3917b.a(this.f3916a);
        }

        @Override // com.google.android.material.floatingactionbutton.d.InterfaceC0184d
        public void b() {
            this.f3917b.b(this.f3916a);
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin")).f3917b.equals(this.f3917b) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f3917b.hashCode();
        }
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_Design_FloatingActionButton, "style", "Widget_Design_FloatingActionButton");
    }

    public FloatingActionButton(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public FloatingActionButton(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.floatingActionButtonStyle, "attr", "floatingActionButtonStyle"));
    }

    public FloatingActionButton(Context r12, AttributeSet r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r15, r16, r14, r0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r16, r14);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        TypedArray r2 = com.google.android.material.internal.k.a(r17, r16, R.styleable.FloatingActionButton, r14, r0, new int[0]);
        this.backgroundTint = com.google.android.material.resources.c.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_backgroundTint, "styleable", "FloatingActionButton_backgroundTint"));
        this.backgroundTintMode = r.a(r2.getInt(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_backgroundTintMode, "styleable", "FloatingActionButton_backgroundTintMode"), -1), null);
        this.rippleColor = com.google.android.material.resources.c.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_rippleColor, "styleable", "FloatingActionButton_rippleColor"));
        this.size = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_fabSize, "styleable", "FloatingActionButton_fabSize"), -1);
        this.customSize = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_fabCustomSize, "styleable", "FloatingActionButton_fabCustomSize"), 0);
        this.borderWidth = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_borderWidth, "styleable", "FloatingActionButton_borderWidth"), 0);
        float r3 = r2.getDimension(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_elevation, "styleable", "FloatingActionButton_elevation"), 0.0f);
        float r6 = r2.getDimension(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, "styleable", "FloatingActionButton_hoveredFocusedTranslationZ"), 0.0f);
        float r5 = r2.getDimension(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_pressedTranslationZ, "styleable", "FloatingActionButton_pressedTranslationZ"), 0.0f);
        this.compatPadding = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_useCompatPadding, "styleable", "FloatingActionButton_useCompatPadding"), false);
        int r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_fab_min_touch_target, "dimen", "mtrl_fab_min_touch_target"));
        setMaxImageSize(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_maxImageSize, "styleable", "FloatingActionButton_maxImageSize"), 0));
        h r7 = h.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_showMotionSpec, "styleable", "FloatingActionButton_showMotionSpec"));
        h r9 = h.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_hideMotionSpec, "styleable", "FloatingActionButton_hideMotionSpec"));
        l r18 = l.a(r17, r16, r14, r0, l.f4049a).a();
        boolean r4 = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, "styleable", "FloatingActionButton_ensureMinTouchTargetSize"), false);
        setEnabled(r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_android_enabled, "styleable", "FloatingActionButton_android_enabled"), true));
        r2.recycle();
        AppCompatImageHelper r8 = new AppCompatImageHelper(this);
        this.imageHelper = r8;
        r8.loadFromAttributes(r16, r14);
        this.expandableWidgetHelper = new com.google.android.material.e.c(this);
        getImpl().a(r18);
        getImpl().a(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().a(r1);
        getImpl().a(r3);
        getImpl().b(r6);
        getImpl().c(r5);
        getImpl().a(r7);
        getImpl().b(r9);
        getImpl().a(r4);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    static /* synthetic */ int access$000(FloatingActionButton r0) {
        return r0.imagePadding;
    }

    static /* synthetic */ void access$101(FloatingActionButton r0, Drawable r1) {
        super.setBackgroundDrawable(r1);
    }

    private d createImpl() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new FloatingActionButtonImplLollipop(this, new b(this));
    L7:
        return new d(this, new b(this));
    }

    private d getImpl() {
        if (this.impl != null) goto L6;
        this.impl = createImpl();
    L6:
        return this.impl;
    }

    private int getSizeDimension(int r4) {
        int r0 = this.customSize;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        Resources r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        if (r4 == (-1)) goto L14;
        if (r4 == 1) goto L12;
        int r5 = R.dimen.design_fab_size_normal;
        String r2 = "design_fab_size_normal";
    L11:
        return r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(r5, "dimen", r2));
    L12:
        r5 = R.dimen.design_fab_size_mini;
        r2 = "design_fab_size_mini";
        goto L11
    L14:
        if (Math.max(r1.getConfiguration().screenWidthDp, r1.getConfiguration().screenHeightDp) >= AUTO_MINI_LARGEST_SCREEN_WIDTH) goto L17;
        return getSizeDimension(1);
    L17:
        return getSizeDimension(0);
    }

    private void offsetRectWithShadow(Rect r3) {
        r3.left += this.shadowPadding.left;
        r3.top += this.shadowPadding.top;
        r3.right -= this.shadowPadding.right;
        r3.bottom -= this.shadowPadding.bottom;
    }

    private void onApplySupportImageTint() {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L5;
        return;
    L5:
        ColorStateList r1 = this.imageTint;
        if (r1 != null) goto L9;
        DrawableCompat.clearColorFilter(r0);
        return;
    L9:
        int r2 = r1.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode r4 = this.imageMode;
        if (r4 != null) goto L12;
        r4 = PorterDuff.Mode.SRC_IN;
    L12:
        r0.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r2, r4));
    }

    private static int resolveAdjustedSize(int r2, int r3) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r4 = View.MeasureSpec.getSize(r3);
        if (r0 == Integer.MIN_VALUE) goto L11;
        if (r0 != 0) goto L6;
        return r2;
    L6:
        if (r0 != 1073741824) goto L9;
        return r4;
    L9:
        throw new IllegalArgumentException();
    L11:
        return Math.min(r2, r4);
    }

    private d.e wrapOnVisibilityChangedListener(final a r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(this, r2);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        getImpl().c(r4);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        getImpl().a(r4);
    }

    public void addTransformationCallback(k<? extends FloatingActionButton> r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        getImpl().a(new c(this, r4));
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().b();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().c();
    }

    public Drawable getContentBackground() {
        return getImpl().m();
    }

    @Deprecated
    public boolean getContentRect(Rect r4) {
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        r4.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(r4);
        return true;
    L6:
        return false;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.c();
    }

    public h getHideMotionSpec() {
        return getImpl().g();
    }

    public void getMeasuredContentRect(Rect r4) {
        r4.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(r4);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList r0 = this.rippleColor;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDefaultColor();
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    @Override // com.google.android.material.shape.p
    public l getShapeAppearanceModel() {
        return (l) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(getImpl().e()), l.class, "com.obric.memorydata.plugin");
    }

    public h getShowMotionSpec() {
        return getImpl().f();
    }

    public int getSize() {
        return this.size;
    }

    int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide() {
        hide(null);
    }

    public void hide(a r2) {
        hide(r2, true);
    }

    void hide(a r2, boolean r3) {
        getImpl().a(wrapOnVisibilityChangedListener(r2), r3);
    }

    @Override // com.google.android.material.e.b
    public boolean isExpanded() {
        return this.expandableWidgetHelper.a();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().w();
    }

    public boolean isOrWillBeShown() {
        return getImpl().v();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().j();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().q();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().r();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r3, int r4) {
        int r0 = getSizeDimension();
        this.imagePadding = (r0 - this.maxImageSize) / 2;
        getImpl().o();
        int r5 = Math.min(resolveAdjustedSize(r0, r3), resolveAdjustedSize(r0, r4));
        setMeasuredDimension((this.shadowPadding.left + r5) + this.shadowPadding.right, (r5 + this.shadowPadding.top) + this.shadowPadding.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ExtendableSavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        ExtendableSavedState r5 = (ExtendableSavedState) ZeusTransformUtils.preCheckCast(r4, ExtendableSavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.expandableWidgetHelper.a((Bundle) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r5.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)), Bundle.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        ExtendableSavedState r1 = new ExtendableSavedState(r0);
        r1.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.b());
        return r1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (r4.getAction() != 0) goto L11;
        if (getContentRect(this.touchArea) == false) goto L11;
        if (this.touchArea.contains((int) r4.getX(), (int) r4.getY()) == true) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r4);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        getImpl().d(r4);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        getImpl().b(r4);
    }

    public void removeTransformationCallback(k<? extends FloatingActionButton> r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        getImpl().b(new c(this, r4));
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r2) {
        if (this.backgroundTint == r2) goto L6;
        this.backgroundTint = r2;
        getImpl().a(r2);
        return;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r2) {
        if (this.backgroundTintMode == r2) goto L6;
        this.backgroundTintMode = r2;
        getImpl().a(r2);
        return;
    }

    public void setCompatElevation(float r1) {
        getImpl().a(r1);
    }

    public void setCompatElevationResource(int r2) {
        setCompatElevation(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(r2));
    }

    public void setCompatHoveredFocusedTranslationZ(float r1) {
        getImpl().b(r1);
    }

    public void setCompatHoveredFocusedTranslationZResource(int r2) {
        setCompatHoveredFocusedTranslationZ(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(r2));
    }

    public void setCompatPressedTranslationZ(float r1) {
        getImpl().c(r1);
    }

    public void setCompatPressedTranslationZResource(int r2) {
        setCompatPressedTranslationZ(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(r2));
    }

    public void setCustomSize(int r2) {
        if (r2 < 0) goto L8;
        if (r2 == this.customSize) goto L9;
        this.customSize = r2;
        requestLayout();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        getImpl().e(r1);
    }

    public void setEnsureMinTouchTargetSize(boolean r2) {
        if (r2 == getImpl().i()) goto L6;
        getImpl().a(r2);
        requestLayout();
        return;
    }

    public boolean setExpanded(boolean r1) {
        return this.expandableWidgetHelper.a(r1);
    }

    public void setExpandedComponentIdHint(int r1) {
        this.expandableWidgetHelper.a(r1);
    }

    public void setHideMotionSpec(h r1) {
        getImpl().b(r1);
    }

    public void setHideMotionSpecResource(int r4) {
        setHideMotionSpec(h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r2) {
        if (getDrawable() == r2) goto L8;
        super.setImageDrawable(r2);
        getImpl().d();
        if (this.imageTint == null) goto L9;
        onApplySupportImageTint();
        return;
    L9:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r2) {
        this.imageHelper.setImageResource(r2);
        onApplySupportImageTint();
    }

    public void setMaxImageSize(int r1) {
        this.maxImageSize = r1;
        getImpl().b(r1);
    }

    public void setRippleColor(int r1) {
        setRippleColor(ColorStateList.valueOf(r1));
    }

    public void setRippleColor(ColorStateList r2) {
        if (this.rippleColor == r2) goto L6;
        this.rippleColor = r2;
        getImpl().b(this.rippleColor);
        return;
    }

    @Override // android.view.View
    public void setScaleX(float r1) {
        super.setScaleX(r1);
        getImpl().l();
    }

    @Override // android.view.View
    public void setScaleY(float r1) {
        super.setScaleY(r1);
        getImpl().l();
    }

    public void setShadowPaddingEnabled(boolean r1) {
        getImpl().b(r1);
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(l r1) {
        getImpl().a(r1);
    }

    public void setShowMotionSpec(h r1) {
        getImpl().a(r1);
    }

    public void setShowMotionSpecResource(int r4) {
        setShowMotionSpec(h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setSize(int r2) {
        this.customSize = 0;
        if (r2 == this.size) goto L6;
        this.size = r2;
        requestLayout();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r1) {
        setBackgroundTintList(r1);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r1) {
        setBackgroundTintMode(r1);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList r2) {
        if (this.imageTint == r2) goto L6;
        this.imageTint = r2;
        onApplySupportImageTint();
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode r2) {
        if (this.imageMode == r2) goto L6;
        this.imageMode = r2;
        onApplySupportImageTint();
        return;
    }

    @Override // android.view.View
    public void setTranslationX(float r1) {
        super.setTranslationX(r1);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationY(float r1) {
        super.setTranslationY(r1);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationZ(float r1) {
        super.setTranslationZ(r1);
        getImpl().k();
    }

    public void setUseCompatPadding(boolean r2) {
        if (this.compatPadding == r2) goto L6;
        this.compatPadding = r2;
        getImpl().n();
        return;
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().i();
    }

    public void show() {
        show(null);
    }

    public void show(a r2) {
        show(r2, true);
    }

    void show(a r2, boolean r3) {
        getImpl().b(wrapOnVisibilityChangedListener(r2), r3);
    }
}
