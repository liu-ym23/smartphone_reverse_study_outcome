package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout.AttachedBehavior {
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
    private final ExpandableWidgetHelper expandableWidgetHelper;

    @NonNull
    private final AppCompatImageHelper imageHelper;

    @Nullable
    private PorterDuff.Mode imageMode;
    private int imagePadding;

    @Nullable
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;

    @Nullable
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private OnVisibilityChangedListener internalAutoHideListener;
        private Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = AUTO_HIDE_DEFAULT;
        }

        private static boolean isBottomSheet(@NonNull View r5) {
            ViewGroup.LayoutParams r10 = r5.getLayoutParams();
            if ((r10 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.LayoutParams) r10).getBehavior() instanceof BottomSheetBehavior;
        }

        private void offsetIfNeeded(@NonNull CoordinatorLayout r10, @NonNull FloatingActionButton r11) {
            Rect r5 = r11.shadowPadding;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.centerX() > 0) goto L7;
            return;
        L7:
            if (r5.centerY() <= 0) goto L28;
            CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
            int r13 = 0;
            if (r11.getRight() < (r10.getWidth() - ((ViewGroup.MarginLayoutParams) r12).rightMargin)) goto L12;
            int r14 = r5.right;
        L16:
            if (r11.getBottom() < (r10.getHeight() - ((ViewGroup.MarginLayoutParams) r12).bottomMargin)) goto L19;
            r13 = r5.bottom;
        L21:
            if (r13 == 0) goto L23;
            ViewCompat.offsetTopAndBottom(r11, r13);
        L23:
            if (r14 == 0) goto L29;
            ViewCompat.offsetLeftAndRight(r11, r14);
            return;
        L29:
            return;
        L19:
            if (r11.getTop() > ((ViewGroup.MarginLayoutParams) r12).topMargin) goto L21;
            r13 = -r5.top;
            goto L21
        L12:
            if (r11.getLeft() > ((ViewGroup.MarginLayoutParams) r12).leftMargin) goto L14;
            r14 = -r5.left;
            goto L16
        L14:
            r14 = 0;
            goto L16
        }

        private boolean shouldUpdateVisibility(@NonNull View r5, @NonNull FloatingActionButton r10) {
            CoordinatorLayout.LayoutParams r11 = (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
            if (this.autoHideEnabled == true) goto L6;
            return false;
        L6:
            if (r11.getAnchorId() == r5.getId()) goto L9;
            return false;
        L9:
            if (r10.getUserSetVisibility() == 0) goto L11;
            return false;
        L11:
            return AUTO_HIDE_DEFAULT;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r5, @NonNull AppBarLayout r10, @NonNull FloatingActionButton r11) {
            if (shouldUpdateVisibility(r10, r11) == true) goto L6;
            return false;
        L6:
            if (this.tmpRect != null) goto L8;
            this.tmpRect = new Rect();
        L8:
            Rect r12 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(r5, r10, r12);
            if (r12.bottom > r10.getMinimumHeightForVisibleOverlappingContent()) goto L11;
            r11.hide(this.internalAutoHideListener, false);
            return AUTO_HIDE_DEFAULT;
        L11:
            r11.show(this.internalAutoHideListener, false);
            return AUTO_HIDE_DEFAULT;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View r5, @NonNull FloatingActionButton r10) {
            if (shouldUpdateVisibility(r5, r10) == true) goto L5;
            return false;
        L5:
            CoordinatorLayout.LayoutParams r11 = (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
            if (r5.getTop() >= ((r10.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r11).topMargin)) goto L8;
            r10.hide(this.internalAutoHideListener, false);
            return AUTO_HIDE_DEFAULT;
        L8:
            r10.show(this.internalAutoHideListener, false);
            return AUTO_HIDE_DEFAULT;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull Rect r11) {
            return getInsetDodgeRect(r5, (FloatingActionButton) r10, r11);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r5) {
            if (r5.dodgeInsetEdges != 0) goto L6;
            r5.dodgeInsetEdges = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r5, @NonNull View r10, View r11) {
            return onDependentViewChanged(r5, (FloatingActionButton) r10, r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11) {
            return onLayoutChild(r5, (FloatingActionButton) r10, r11);
        }

        public void setAutoHideEnabled(boolean r5) {
            this.autoHideEnabled = r5;
        }

        @VisibleForTesting
        public void setInternalAutoHideListener(OnVisibilityChangedListener r5) {
            this.internalAutoHideListener = r5;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r5, @NonNull FloatingActionButton r10, @NonNull Rect r11) {
            Rect r12 = r10.shadowPadding;
            r11.set(r10.getLeft() + r12.left, r10.getTop() + r12.top, r10.getRight() - r12.right, r10.getBottom() - r12.bottom);
            return AUTO_HIDE_DEFAULT;
        }

        public boolean onDependentViewChanged(CoordinatorLayout r5, @NonNull FloatingActionButton r10, View r11) {
            if ((r11 instanceof AppBarLayout) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r5, (AppBarLayout) r11, r10);
            return false;
        L6:
            if (isBottomSheet(r11) == false) goto L11;
            updateFabVisibilityForBottomSheet(r11, r10);
            return false;
        L11:
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull FloatingActionButton r11, int r12) {
            List<View> r5 = r10.getDependencies(r11);
            int r13 = r5.size();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L15;
            View r15 = r5.get(r14);
            if ((r15 instanceof AppBarLayout) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r10, (AppBarLayout) r15, r11) == true) goto L15;
        L14:
            r14 = r14 + 1;
            goto L3
        L10:
            if (isBottomSheet(r15) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r15, r11) == false) goto L14;
        L15:
            r10.onLayoutChild(r11, r12);
            offsetIfNeeded(r10, r11);
            return AUTO_HIDE_DEFAULT;
        }

        public BaseBehavior(Context r5, AttributeSet r10) {
            super(r5, r10);
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r11.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, AUTO_HIDE_DEFAULT);
            r11.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r5, @NonNull FloatingActionButton r10, @NonNull Rect r11) {
            return super.getInsetDodgeRect(r5, r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r5) {
            super.onAttachedToLayoutParams(r5);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r5, @NonNull FloatingActionButton r10, View r11) {
            return super.onDependentViewChanged(r5, r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull FloatingActionButton r10, int r11) {
            return super.onLayoutChild(r5, r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean r5) {
            super.setAutoHideEnabled(r5);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @VisibleForTesting
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(OnVisibilityChangedListener r5) {
            super.setInternalAutoHideListener(r5);
        }

        public Behavior(Context r5, AttributeSet r10) {
            super(r5, r10);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public OnVisibilityChangedListener() {
        }

        public void onHidden(FloatingActionButton r5) {
        }

        public void onShown(FloatingActionButton r5) {
        }
    }

    public class ShadowDelegateImpl implements ShadowViewDelegate {
        final /* synthetic */ FloatingActionButton this$0;

        public ShadowDelegateImpl(FloatingActionButton r5) {
            this.this$0 = r5;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public float getRadius() {
            return this.this$0.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean isCompatPaddingEnabled() {
            return this.this$0.compatPadding;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setBackgroundDrawable(@Nullable Drawable r5) {
            if (r5 == null) goto L5;
            FloatingActionButton.access$101(this.this$0, r5);
            return;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setShadowPadding(int r5, int r10, int r11, int r12) {
            this.this$0.shadowPadding.set(r5, r10, r11, r12);
            FloatingActionButton r13 = this.this$0;
            r13.setPadding(FloatingActionButton.access$000(r13) + r5, FloatingActionButton.access$000(this.this$0) + r10, FloatingActionButton.access$000(this.this$0) + r11, FloatingActionButton.access$000(this.this$0) + r12);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Size {
    }

    public class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {

        @NonNull
        private final TransformationCallback<T> listener;
        final /* synthetic */ FloatingActionButton this$0;

        public TransformationCallbackWrapper(@NonNull FloatingActionButton r5, TransformationCallback<T> r10) {
            this.this$0 = r5;
            this.listener = r10;
        }

        public boolean equals(@Nullable Object r5) {
            if ((r5 instanceof TransformationCallbackWrapper) == true) goto L5;
        L7:
            return false;
        L5:
            if (((TransformationCallbackWrapper) r5).listener.equals(this.listener) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onScaleChanged() {
            this.listener.onScaleChanged(this.this$0);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onTranslationChanged() {
            this.listener.onTranslationChanged(this.this$0);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_FloatingActionButton;
    }

    public FloatingActionButton(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int access$000(FloatingActionButton r5) {
        return r5.imagePadding;
    }

    public static /* synthetic */ void access$101(FloatingActionButton r5, Drawable r10) {
        super.setBackgroundDrawable(r10);
    }

    @NonNull
    private FloatingActionButtonImpl createImpl() {
        return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl(this));
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl != null) goto L6;
        this.impl = createImpl();
    L6:
        return this.impl;
    }

    private void getTouchTargetRect(@NonNull Rect r5) {
        getMeasuredContentRect(r5);
        int r10 = -this.impl.getTouchTargetPadding();
        r5.inset(r10, r10);
    }

    private void offsetRectWithShadow(@NonNull Rect r5) {
        int r10 = r5.left;
        Rect r11 = this.shadowPadding;
        r5.left = r10 + r11.left;
        r5.top += r11.top;
        r5.right -= r11.right;
        r5.bottom -= r11.bottom;
    }

    private void onApplySupportImageTint() {
        Drawable r5 = getDrawable();
        if (r5 != null) goto L5;
        return;
    L5:
        ColorStateList r10 = this.imageTint;
        if (r10 != null) goto L9;
        DrawableCompat.clearColorFilter(r5);
        return;
    L9:
        int r11 = r10.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode r12 = this.imageMode;
        if (r12 != null) goto L12;
        r12 = PorterDuff.Mode.SRC_IN;
    L12:
        r5.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r11, r12));
    }

    @Nullable
    private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable final OnVisibilityChangedListener r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(this, r5);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r5) {
        getImpl().addOnHideAnimationListener(r5);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r5) {
        getImpl().addOnShowAnimationListener(r5);
    }

    public void addTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> r5) {
        getImpl().addTransformationCallback(new TransformationCallbackWrapper(this, r5));
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
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
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().getHoveredFocusedTranslationZ();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().getPressedTranslationZ();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    @Deprecated
    public boolean getContentRect(@NonNull Rect r5) {
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        r5.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(r5);
        return true;
    L6:
        return false;
    }

    @Px
    public int getCustomSize() {
        return this.customSize;
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return getImpl().getHideMotionSpec();
    }

    public void getMeasuredContentRect(@NonNull Rect r5) {
        r5.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(r5);
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList r5 = this.rippleColor;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getDefaultColor();
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return (ShapeAppearanceModel) Preconditions.checkNotNull(getImpl().getShapeAppearance());
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return getImpl().getShowMotionSpec();
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
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

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return getImpl().isOrWillBeShown();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r5, int r10) {
        int r11 = getSizeDimension();
        this.imagePadding = (r11 - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int r12 = Math.min(View.resolveSize(r11, r5), View.resolveSize(r11, r10));
        Rect r13 = this.shadowPadding;
        setMeasuredDimension((r13.left + r12) + r13.right, (r12 + r13.top) + r13.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof ExtendableSavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        ExtendableSavedState r10 = (ExtendableSavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState((Bundle) Preconditions.checkNotNull(r10.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable r5 = super.onSaveInstanceState();
        if (r5 != null) goto L5;
        r5 = new Bundle();
    L5:
        ExtendableSavedState r10 = new ExtendableSavedState(r5);
        r10.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.onSaveInstanceState());
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r5) {
        if (r5.getAction() != 0) goto L9;
        getTouchTargetRect(this.touchArea);
        if (this.touchArea.contains((int) r5.getX(), (int) r5.getY()) == true) goto L9;
        return false;
    L9:
        return super.onTouchEvent(r5);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r5) {
        getImpl().removeOnHideAnimationListener(r5);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r5) {
        getImpl().removeOnShowAnimationListener(r5);
    }

    public void removeTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> r5) {
        getImpl().removeTransformationCallback(new TransformationCallbackWrapper(this, r5));
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r5) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int r5) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r5) {
        if (this.backgroundTint == r5) goto L6;
        this.backgroundTint = r5;
        getImpl().setBackgroundTintList(r5);
        return;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        if (this.backgroundTintMode == r5) goto L6;
        this.backgroundTintMode = r5;
        getImpl().setBackgroundTintMode(r5);
        return;
    }

    public void setCompatElevation(float r5) {
        getImpl().setElevation(r5);
    }

    public void setCompatElevationResource(@DimenRes int r5) {
        setCompatElevation(getResources().getDimension(r5));
    }

    public void setCompatHoveredFocusedTranslationZ(float r5) {
        getImpl().setHoveredFocusedTranslationZ(r5);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int r5) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(r5));
    }

    public void setCompatPressedTranslationZ(float r5) {
        getImpl().setPressedTranslationZ(r5);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int r5) {
        setCompatPressedTranslationZ(getResources().getDimension(r5));
    }

    public void setCustomSize(@Px int r5) {
        if (r5 < 0) goto L8;
        if (r5 == this.customSize) goto L9;
        this.customSize = r5;
        requestLayout();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        getImpl().updateShapeElevation(r5);
    }

    public void setEnsureMinTouchTargetSize(boolean r5) {
        if (r5 == getImpl().getEnsureMinTouchTargetSize()) goto L6;
        getImpl().setEnsureMinTouchTargetSize(r5);
        requestLayout();
        return;
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean setExpanded(boolean r5) {
        return this.expandableWidgetHelper.setExpanded(r5);
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public void setExpandedComponentIdHint(@IdRes int r5) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(r5);
    }

    public void setHideMotionSpec(@Nullable MotionSpec r5) {
        getImpl().setHideMotionSpec(r5);
    }

    public void setHideMotionSpecResource(@AnimatorRes int r5) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r5));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r5) {
        if (getDrawable() == r5) goto L8;
        super.setImageDrawable(r5);
        getImpl().updateImageMatrixScale();
        if (this.imageTint == null) goto L9;
        onApplySupportImageTint();
        return;
    L9:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int r5) {
        this.imageHelper.setImageResource(r5);
        onApplySupportImageTint();
    }

    public void setMaxImageSize(int r5) {
        this.maxImageSize = r5;
        getImpl().setMaxImageSize(r5);
    }

    public void setRippleColor(@ColorInt int r5) {
        setRippleColor(ColorStateList.valueOf(r5));
    }

    @Override // android.view.View
    public void setScaleX(float r5) {
        super.setScaleX(r5);
        getImpl().onScaleChanged();
    }

    @Override // android.view.View
    public void setScaleY(float r5) {
        super.setScaleY(r5);
        getImpl().onScaleChanged();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean r5) {
        getImpl().setShadowPaddingEnabled(r5);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        getImpl().setShapeAppearance(r5);
    }

    public void setShowMotionSpec(@Nullable MotionSpec r5) {
        getImpl().setShowMotionSpec(r5);
    }

    public void setShowMotionSpecResource(@AnimatorRes int r5) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r5));
    }

    public void setSize(int r5) {
        this.customSize = 0;
        if (r5 == this.size) goto L6;
        this.size = r5;
        requestLayout();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList r5) {
        setBackgroundTintList(r5);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        setBackgroundTintMode(r5);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList r5) {
        if (this.imageTint == r5) goto L6;
        this.imageTint = r5;
        onApplySupportImageTint();
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode r5) {
        if (this.imageMode == r5) goto L6;
        this.imageMode = r5;
        onApplySupportImageTint();
        return;
    }

    @Override // android.view.View
    public void setTranslationX(float r5) {
        super.setTranslationX(r5);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationY(float r5) {
        super.setTranslationY(r5);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationZ(float r5) {
        super.setTranslationZ(r5);
        getImpl().onTranslationChanged();
    }

    public void setUseCompatPadding(boolean r5) {
        if (this.compatPadding == r5) goto L6;
        this.compatPadding = r5;
        getImpl().onCompatShadowChanged();
        return;
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().getEnsureMinTouchTargetSize();
    }

    public void show() {
        show(null);
    }

    public FloatingActionButton(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.floatingActionButtonStyle);
    }

    private int getSizeDimension(int r5) {
        int r10 = this.customSize;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        Resources r11 = getResources();
        if (r5 == (-1)) goto L13;
        if (r5 == 1) goto L11;
        return r11.getDimensionPixelSize(R.dimen.design_fab_size_normal);
    L11:
        return r11.getDimensionPixelSize(R.dimen.design_fab_size_mini);
    L13:
        if (Math.max(r11.getConfiguration().screenWidthDp, r11.getConfiguration().screenHeightDp) >= AUTO_MINI_LARGEST_SCREEN_WIDTH) goto L16;
        return getSizeDimension(1);
    L16:
        return getSizeDimension(0);
    }

    public void hide(@Nullable OnVisibilityChangedListener r5) {
        hide(r5, true);
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        if (this.rippleColor == r5) goto L6;
        this.rippleColor = r5;
        getImpl().setRippleColor(this.rippleColor);
        return;
    }

    public void show(@Nullable OnVisibilityChangedListener r5) {
        show(r5, true);
    }

    public FloatingActionButton(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r10), r12, r13);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context r14 = getContext();
        TypedArray r5 = ThemeEnforcement.obtainStyledAttributes(r14, r12, R.styleable.FloatingActionButton, r13, r10, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(r14, r5, R.styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = ViewUtils.parseTintMode(r5.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = MaterialResources.getColorStateList(r14, r5, R.styleable.FloatingActionButton_rippleColor);
        this.size = r5.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.customSize = r5.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = r5.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float r15 = r5.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float r16 = r5.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float r17 = r5.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = r5.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        int r18 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(r5.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0));
        MotionSpec r19 = MotionSpec.createFromAttribute(r14, r5, R.styleable.FloatingActionButton_showMotionSpec);
        MotionSpec r20 = MotionSpec.createFromAttribute(r14, r5, R.styleable.FloatingActionButton_hideMotionSpec);
        ShapeAppearanceModel r110 = ShapeAppearanceModel.builder(r14, r12, r13, r10, ShapeAppearanceModel.PILL).build();
        boolean r21 = r5.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(r5.getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
        r5.recycle();
        AppCompatImageHelper r22 = new AppCompatImageHelper(this);
        this.imageHelper = r22;
        r22.loadFromAttributes(r12, r13);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().setShapeAppearance(r110);
        getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().setMinTouchTargetSize(r18);
        getImpl().setElevation(r15);
        getImpl().setHoveredFocusedTranslationZ(r16);
        getImpl().setPressedTranslationZ(r17);
        getImpl().setShowMotionSpec(r19);
        getImpl().setHideMotionSpec(r20);
        getImpl().setEnsureMinTouchTargetSize(r21);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void hide(@Nullable OnVisibilityChangedListener r5, boolean r10) {
        getImpl().hide(wrapOnVisibilityChangedListener(r5), r10);
    }

    public void show(@Nullable OnVisibilityChangedListener r5, boolean r10) {
        getImpl().show(wrapOnVisibilityChangedListener(r5), r10);
    }
}
