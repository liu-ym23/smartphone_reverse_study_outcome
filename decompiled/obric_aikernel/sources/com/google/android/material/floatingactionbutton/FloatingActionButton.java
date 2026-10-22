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
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shape.p;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
import q5.l;
import r5.h;
import r5.k;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, x5.a, p, CoordinatorLayout.AttachedBehavior {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = 0;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;

    @NonNull
    private final x5.b expandableWidgetHelper;

    @NonNull
    private final AppCompatImageHelper imageHelper;

    @Nullable
    private PorterDuff.Mode imageMode;
    private int imagePadding;

    @Nullable
    private ColorStateList imageTint;
    private com.google.android.material.floatingactionbutton.d impl;
    private int maxImageSize;

    @Nullable
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private b internalAutoHideListener;
        private Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public BaseBehavior(Context r10, AttributeSet r11) {
            super(r10, r11);
            TypedArray r12 = r10.obtainStyledAttributes(r11, l.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r12.getBoolean(l.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            r12.recycle();
        }

        private static boolean isBottomSheet(@NonNull View r10) {
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
            if ((r11 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.LayoutParams) r11).getBehavior() instanceof BottomSheetBehavior;
        }

        private void offsetIfNeeded(@NonNull CoordinatorLayout r10, @NonNull FloatingActionButton r11) {
            Rect r12 = r11.shadowPadding;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.centerX() > 0) goto L7;
            return;
        L7:
            if (r12.centerY() <= 0) goto L28;
            CoordinatorLayout.LayoutParams r13 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
            int r14 = 0;
            if (r11.getRight() < (r10.getWidth() - ((ViewGroup.MarginLayoutParams) r13).rightMargin)) goto L12;
            int r15 = r12.right;
        L16:
            if (r11.getBottom() < (r10.getHeight() - ((ViewGroup.MarginLayoutParams) r13).bottomMargin)) goto L19;
            r14 = r12.bottom;
        L21:
            if (r14 == 0) goto L23;
            ViewCompat.offsetTopAndBottom(r11, r14);
        L23:
            if (r15 == 0) goto L29;
            ViewCompat.offsetLeftAndRight(r11, r15);
            return;
        L29:
            return;
        L19:
            if (r11.getTop() > ((ViewGroup.MarginLayoutParams) r13).topMargin) goto L21;
            r14 = -r12.top;
            goto L21
        L12:
            if (r11.getLeft() > ((ViewGroup.MarginLayoutParams) r13).leftMargin) goto L14;
            r15 = -r12.left;
            goto L16
        L14:
            r15 = 0;
            goto L16
        }

        private boolean shouldUpdateVisibility(@NonNull View r10, @NonNull FloatingActionButton r11) {
            CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
            if (this.autoHideEnabled == true) goto L6;
            return false;
        L6:
            if (r12.getAnchorId() == r10.getId()) goto L9;
            return false;
        L9:
            if (r11.getUserSetVisibility() == 0) goto L11;
            return false;
        L11:
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r10, @NonNull AppBarLayout r11, @NonNull FloatingActionButton r12) {
            if (shouldUpdateVisibility(r11, r12) == true) goto L6;
            return false;
        L6:
            if (this.tmpRect != null) goto L8;
            this.tmpRect = new Rect();
        L8:
            Rect r13 = this.tmpRect;
            com.google.android.material.internal.d.a(r10, r11, r13);
            int r14 = r13.bottom;
            int r15 = r11.getMinimumHeightForVisibleOverlappingContent();
            b r16 = this.internalAutoHideListener;
            if (r14 > r15) goto L11;
            r12.hide(r16, false);
            return true;
        L11:
            r12.show(r16, false);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View r10, @NonNull FloatingActionButton r11) {
            if (shouldUpdateVisibility(r10, r11) == true) goto L5;
            return false;
        L5:
            CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
            int r13 = r10.getTop();
            int r14 = (r11.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r12).topMargin;
            b r15 = this.internalAutoHideListener;
            if (r13 >= r14) goto L8;
            r11.hide(r15, false);
            return true;
        L8:
            r11.show(r15, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull Rect r12) {
            return getInsetDodgeRect(r10, (FloatingActionButton) r11, r12);
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull FloatingActionButton r11, @NonNull Rect r12) {
            Rect r13 = r11.shadowPadding;
            r12.set(r11.getLeft() + r13.left, r11.getTop() + r13.top, r11.getRight() - r13.right, r11.getBottom() - r13.bottom);
            return true;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r10) {
            if (r10.dodgeInsetEdges != 0) goto L6;
            r10.dodgeInsetEdges = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r10, @NonNull View r11, View r12) {
            return onDependentViewChanged(r10, (FloatingActionButton) r11, r12);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r10, @NonNull FloatingActionButton r11, View r12) {
            if ((r12 instanceof AppBarLayout) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r10, (AppBarLayout) r12, r11);
            return false;
        L6:
            if (isBottomSheet(r12) == false) goto L11;
            updateFabVisibilityForBottomSheet(r12, r11);
            return false;
        L11:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return onLayoutChild(r10, (FloatingActionButton) r11, r12);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull FloatingActionButton r11, int r12) {
            List<View> r13 = r10.getDependencies(r11);
            int r14 = r13.size();
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L15;
            View r16 = r13.get(r15);
            if ((r16 instanceof AppBarLayout) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r10, (AppBarLayout) r16, r11) == true) goto L15;
        L14:
            r15 = r15 + 1;
            goto L3
        L10:
            if (isBottomSheet(r16) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r16, r11) == false) goto L14;
        L15:
            r10.onLayoutChild(r11, r12);
            offsetIfNeeded(r10, r11);
            return true;
        }

        public void setAutoHideEnabled(boolean r10) {
            this.autoHideEnabled = r10;
        }

        @VisibleForTesting
        public void setInternalAutoHideListener(b r10) {
            this.internalAutoHideListener = r10;
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull FloatingActionButton r11, @NonNull Rect r12) {
            return super.getInsetDodgeRect(r10, r11, r12);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r10) {
            super.onAttachedToLayoutParams(r10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r10, @NonNull FloatingActionButton r11, View r12) {
            return super.onDependentViewChanged(r10, r11, r12);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull FloatingActionButton r11, int r12) {
            return super.onLayoutChild(r10, r11, r12);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean r10) {
            super.setAutoHideEnabled(r10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @VisibleForTesting
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(b r10) {
            super.setInternalAutoHideListener(r10);
        }
    }

    class a implements com.google.android.material.floatingactionbutton.d.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f3250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f3251b;

        a(FloatingActionButton r10, b r11) {
            this.f3251b = r10;
            this.f3250a = r11;
        }

        @Override // com.google.android.material.floatingactionbutton.d.k
        public void a() {
            this.f3250a.b(this.f3251b);
        }

        @Override // com.google.android.material.floatingactionbutton.d.k
        public void b() {
            this.f3250a.a(this.f3251b);
        }
    }

    public static abstract class b {
        public b() {
        }

        public void a(FloatingActionButton r10) {
        }

        public void b(FloatingActionButton r10) {
        }
    }

    private class c implements a6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f3252a;

        c(FloatingActionButton r10) {
            this.f3252a = r10;
        }

        @Override // a6.b
        public boolean a() {
            return this.f3252a.compatPadding;
        }

        @Override // a6.b
        public void setBackgroundDrawable(@Nullable Drawable r10) {
            if (r10 == null) goto L5;
            FloatingActionButton.access$101(this.f3252a, r10);
            return;
        }

        @Override // a6.b
        public void setShadowPadding(int r10, int r11, int r12, int r13) {
            this.f3252a.shadowPadding.set(r10, r11, r12, r13);
            FloatingActionButton r14 = this.f3252a;
            r14.setPadding(r10 + FloatingActionButton.access$000(r14), r11 + FloatingActionButton.access$000(this.f3252a), r12 + FloatingActionButton.access$000(this.f3252a), r13 + FloatingActionButton.access$000(this.f3252a));
        }
    }

    class d<T extends FloatingActionButton> implements com.google.android.material.floatingactionbutton.d.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private final k<T> f3253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f3254b;

        d(@NonNull FloatingActionButton r10, k<T> r11) {
            this.f3254b = r10;
            this.f3253a = r11;
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void a() {
            this.f3253a.b(this.f3254b);
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void b() {
            this.f3253a.a(this.f3254b);
        }

        public boolean equals(@Nullable Object r10) {
            if ((r10 instanceof d) == true) goto L5;
        L7:
            return false;
        L5:
            if (((d) r10).f3253a.equals(this.f3253a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f3253a.hashCode();
        }
    }

    static {
        DEF_STYLE_RES = q5.k.Widget_Design_FloatingActionButton;
    }

    public FloatingActionButton(@NonNull Context r10) {
        this(r10, null);
    }

    public FloatingActionButton(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.floatingActionButtonStyle);
    }

    public FloatingActionButton(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(b6.a.c(r11, r12, r13, r10), r12, r13);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context r14 = getContext();
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r12, l.FloatingActionButton, r13, r10, new int[0]);
        this.backgroundTint = com.google.android.material.resources.c.a(r14, r15, l.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = ViewUtils.j(r15.getInt(l.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = com.google.android.material.resources.c.a(r14, r15, l.FloatingActionButton_rippleColor);
        this.size = r15.getInt(l.FloatingActionButton_fabSize, -1);
        this.customSize = r15.getDimensionPixelSize(l.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = r15.getDimensionPixelSize(l.FloatingActionButton_borderWidth, 0);
        float r16 = r15.getDimension(l.FloatingActionButton_elevation, 0.0f);
        float r17 = r15.getDimension(l.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float r18 = r15.getDimension(l.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = r15.getBoolean(l.FloatingActionButton_useCompatPadding, false);
        int r19 = getResources().getDimensionPixelSize(q5.d.mtrl_fab_min_touch_target);
        setMaxImageSize(r15.getDimensionPixelSize(l.FloatingActionButton_maxImageSize, 0));
        h r20 = h.c(r14, r15, l.FloatingActionButton_showMotionSpec);
        h r21 = h.c(r14, r15, l.FloatingActionButton_hideMotionSpec);
        com.google.android.material.shape.l r110 = com.google.android.material.shape.l.g(r14, r12, r13, r10, com.google.android.material.shape.l.f3644m).m();
        boolean r22 = r15.getBoolean(l.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(r15.getBoolean(l.FloatingActionButton_android_enabled, true));
        r15.recycle();
        AppCompatImageHelper r23 = new AppCompatImageHelper(this);
        this.imageHelper = r23;
        r23.loadFromAttributes(r12, r13);
        this.expandableWidgetHelper = new x5.b(this);
        getImpl().a0(r110);
        getImpl().x(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().W(r19);
        getImpl().Q(r16);
        getImpl().T(r17);
        getImpl().X(r18);
        getImpl().b0(r20);
        getImpl().S(r21);
        getImpl().R(r22);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    static /* synthetic */ int access$000(FloatingActionButton r10) {
        return r10.imagePadding;
    }

    static /* synthetic */ void access$101(FloatingActionButton r10, Drawable r11) {
        super.setBackgroundDrawable(r11);
    }

    @NonNull
    private com.google.android.material.floatingactionbutton.d createImpl() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new FloatingActionButtonImplLollipop(this, new c(this));
    L7:
        return new com.google.android.material.floatingactionbutton.d(this, new c(this));
    }

    private com.google.android.material.floatingactionbutton.d getImpl() {
        if (this.impl != null) goto L6;
        this.impl = createImpl();
    L6:
        return this.impl;
    }

    private int getSizeDimension(int r10) {
        int r11 = this.customSize;
        if (r11 == 0) goto L5;
        return r11;
    L5:
        Resources r12 = getResources();
        if (r10 == (-1)) goto L13;
        if (r10 == 1) goto L11;
        int r13 = q5.d.design_fab_size_normal;
    L10:
        return r12.getDimensionPixelSize(r13);
    L11:
        r13 = q5.d.design_fab_size_mini;
        goto L10
    L13:
        if (Math.max(r12.getConfiguration().screenWidthDp, r12.getConfiguration().screenHeightDp) >= AUTO_MINI_LARGEST_SCREEN_WIDTH) goto L16;
        return getSizeDimension(1);
    L16:
        return getSizeDimension(0);
    }

    private void offsetRectWithShadow(@NonNull Rect r10) {
        int r11 = r10.left;
        Rect r12 = this.shadowPadding;
        r10.left = r11 + r12.left;
        r10.top += r12.top;
        r10.right -= r12.right;
        r10.bottom -= r12.bottom;
    }

    private void onApplySupportImageTint() {
        Drawable r10 = getDrawable();
        if (r10 != null) goto L5;
        return;
    L5:
        ColorStateList r11 = this.imageTint;
        if (r11 != null) goto L9;
        DrawableCompat.clearColorFilter(r10);
        return;
    L9:
        int r12 = r11.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode r13 = this.imageMode;
        if (r13 != null) goto L12;
        r13 = PorterDuff.Mode.SRC_IN;
    L12:
        r10.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r12, r13));
    }

    private static int resolveAdjustedSize(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        if (r12 == Integer.MIN_VALUE) goto L11;
        if (r12 != 0) goto L6;
        return r10;
    L6:
        if (r12 != 1073741824) goto L9;
        return r13;
    L9:
        throw new IllegalArgumentException();
    L11:
        return Math.min(r10, r13);
    }

    @Nullable
    private com.google.android.material.floatingactionbutton.d.k wrapOnVisibilityChangedListener(@Nullable b r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new a(this, r10);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        getImpl().e(r10);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        getImpl().f(r10);
    }

    public void addTransformationCallback(@NonNull k<? extends FloatingActionButton> r10) {
        getImpl().g(new d(this, r10));
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().m();
    }

    @Deprecated
    public boolean getContentRect(@NonNull Rect r10) {
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        r10.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(r10);
        return true;
    L6:
        return false;
    }

    @Px
    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.b();
    }

    @Nullable
    public h getHideMotionSpec() {
        return getImpl().p();
    }

    public void getMeasuredContentRect(@NonNull Rect r10) {
        r10.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(r10);
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList r10 = this.rippleColor;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getDefaultColor();
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    @Override // com.google.android.material.shape.p
    @NonNull
    public com.google.android.material.shape.l getShapeAppearanceModel() {
        return (com.google.android.material.shape.l) Preconditions.checkNotNull(getImpl().u());
    }

    @Nullable
    public h getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.size;
    }

    int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide() {
        hide(null);
    }

    public void hide(@Nullable b r10) {
        hide(r10, true);
    }

    void hide(@Nullable b r10, boolean r11) {
        getImpl().w(wrapOnVisibilityChangedListener(r10), r11);
    }

    @Override // x5.a
    public boolean isExpanded() {
        return this.expandableWidgetHelper.c();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().y();
    }

    public boolean isOrWillBeShown() {
        return getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = getSizeDimension();
        this.imagePadding = (r12 - this.maxImageSize) / 2;
        getImpl().i0();
        int r13 = Math.min(resolveAdjustedSize(r12, r10), resolveAdjustedSize(r12, r11));
        Rect r14 = this.shadowPadding;
        setMeasuredDimension((r14.left + r13) + r14.right, (r13 + r14.top) + r14.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof ExtendableSavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        ExtendableSavedState r11 = (ExtendableSavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.expandableWidgetHelper.d((Bundle) Preconditions.checkNotNull(r11.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable r10 = super.onSaveInstanceState();
        if (r10 != null) goto L5;
        r10 = new Bundle();
    L5:
        ExtendableSavedState r11 = new ExtendableSavedState(r10);
        r11.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.e());
        return r11;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r10) {
        if (r10.getAction() != 0) goto L11;
        if (getContentRect(this.touchArea) == false) goto L11;
        if (this.touchArea.contains((int) r10.getX(), (int) r10.getY()) == true) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r10);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        getImpl().K(r10);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        getImpl().L(r10);
    }

    public void removeTransformationCallback(@NonNull k<? extends FloatingActionButton> r10) {
        getImpl().M(new d(this, r10));
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r10) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int r10) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r10) {
        if (this.backgroundTint == r10) goto L6;
        this.backgroundTint = r10;
        getImpl().O(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.backgroundTintMode == r10) goto L6;
        this.backgroundTintMode = r10;
        getImpl().P(r10);
        return;
    }

    public void setCompatElevation(float r10) {
        getImpl().Q(r10);
    }

    public void setCompatElevationResource(@DimenRes int r10) {
        setCompatElevation(getResources().getDimension(r10));
    }

    public void setCompatHoveredFocusedTranslationZ(float r10) {
        getImpl().T(r10);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int r10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(r10));
    }

    public void setCompatPressedTranslationZ(float r10) {
        getImpl().X(r10);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int r10) {
        setCompatPressedTranslationZ(getResources().getDimension(r10));
    }

    public void setCustomSize(@Px int r10) {
        if (r10 < 0) goto L8;
        if (r10 == this.customSize) goto L9;
        this.customSize = r10;
        requestLayout();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        getImpl().j0(r10);
    }

    public void setEnsureMinTouchTargetSize(boolean r10) {
        if (r10 == getImpl().o()) goto L6;
        getImpl().R(r10);
        requestLayout();
        return;
    }

    public boolean setExpanded(boolean r10) {
        return this.expandableWidgetHelper.f(r10);
    }

    public void setExpandedComponentIdHint(@IdRes int r10) {
        this.expandableWidgetHelper.g(r10);
    }

    public void setHideMotionSpec(@Nullable h r10) {
        getImpl().S(r10);
    }

    public void setHideMotionSpecResource(@AnimatorRes int r10) {
        setHideMotionSpec(h.d(getContext(), r10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r10) {
        if (getDrawable() == r10) goto L8;
        super.setImageDrawable(r10);
        getImpl().h0();
        if (this.imageTint == null) goto L9;
        onApplySupportImageTint();
        return;
    L9:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int r10) {
        this.imageHelper.setImageResource(r10);
        onApplySupportImageTint();
    }

    public void setMaxImageSize(int r10) {
        this.maxImageSize = r10;
        getImpl().V(r10);
    }

    public void setRippleColor(@ColorInt int r10) {
        setRippleColor(ColorStateList.valueOf(r10));
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        if (this.rippleColor == r10) goto L6;
        this.rippleColor = r10;
        getImpl().Y(this.rippleColor);
        return;
    }

    @Override // android.view.View
    public void setScaleX(float r10) {
        super.setScaleX(r10);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float r10) {
        super.setScaleY(r10);
        getImpl().I();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean r10) {
        getImpl().Z(r10);
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(@NonNull com.google.android.material.shape.l r10) {
        getImpl().a0(r10);
    }

    public void setShowMotionSpec(@Nullable h r10) {
        getImpl().b0(r10);
    }

    public void setShowMotionSpecResource(@AnimatorRes int r10) {
        setShowMotionSpec(h.d(getContext(), r10));
    }

    public void setSize(int r10) {
        this.customSize = 0;
        if (r10 == this.size) goto L6;
        this.size = r10;
        requestLayout();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        setBackgroundTintList(r10);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        setBackgroundTintMode(r10);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList r10) {
        if (this.imageTint == r10) goto L6;
        this.imageTint = r10;
        onApplySupportImageTint();
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode r10) {
        if (this.imageMode == r10) goto L6;
        this.imageMode = r10;
        onApplySupportImageTint();
        return;
    }

    @Override // android.view.View
    public void setTranslationX(float r10) {
        super.setTranslationX(r10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float r10) {
        super.setTranslationY(r10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float r10) {
        super.setTranslationZ(r10);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean r10) {
        if (this.compatPadding == r10) goto L6;
        this.compatPadding = r10;
        getImpl().C();
        return;
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().o();
    }

    public void show() {
        show(null);
    }

    public void show(@Nullable b r10) {
        show(r10, true);
    }

    void show(@Nullable b r10, boolean r11) {
        getImpl().f0(wrapOnVisibilityChangedListener(r10), r11);
    }
}
