package com.google.android.material.snackbar;

import ai.j0;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    static final int DEFAULT_ANIMATION_FADE_DURATION = 180;
    private static final TimeInterpolator DEFAULT_ANIMATION_FADE_INTERPOLATOR = null;
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 150;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 75;
    private static final TimeInterpolator DEFAULT_ANIMATION_SCALE_INTERPOLATOR = null;
    private static final TimeInterpolator DEFAULT_ANIMATION_SLIDE_INTERPOLATOR = null;
    static final int DEFAULT_SLIDE_ANIMATION_DURATION = 250;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR = null;
    private static final String TAG = null;
    private static final boolean USE_OFFSET_API = false;

    @NonNull
    static final Handler handler = null;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private Anchor anchor;
    private boolean anchorViewLayoutListenerEnabled;
    private final int animationFadeInDuration;
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationFadeOutDuration;
    private final TimeInterpolator animationScaleInterpolator;
    private final int animationSlideDuration;
    private final TimeInterpolator animationSlideInterpolator;
    private int appliedBottomMarginGestureInset;
    private Behavior behavior;

    @RequiresApi(29)
    private final Runnable bottomMarginGestureInsetRunnable;
    private List<BaseCallback<B>> callbacks;

    @NonNull
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;

    @NonNull
    SnackbarManager.Callback managerCallback;
    private boolean pendingShowingView;

    @NonNull
    private final ViewGroup targetParent;

    @NonNull
    protected final SnackbarBaseLayout view;

    public static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        @NonNull
        private final WeakReference<View> anchorView;

        @NonNull
        private final WeakReference<BaseTransientBottomBar> transientBottomBar;

        private Anchor(@NonNull BaseTransientBottomBar r5, @NonNull View r10) {
            this.transientBottomBar = new WeakReference(r5);
            this.anchorView = new WeakReference(r10);
        }

        public static Anchor anchor(@NonNull BaseTransientBottomBar r5, @NonNull View r10) {
            Anchor r11 = new Anchor(r5, r10);
            if (ViewCompat.isAttachedToWindow(r10) == false) goto L5;
            ViewUtils.addOnGlobalLayoutListener(r10, r11);
        L5:
            r10.addOnAttachStateChangeListener(r11);
            return r11;
        }

        private boolean unanchorIfNoTransientBottomBar() {
            if (this.transientBottomBar.get() != null) goto L6;
            unanchor();
            return true;
        L6:
            return false;
        }

        @Nullable
        public View getAnchorView() {
            return this.anchorView.get();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (unanchorIfNoTransientBottomBar() == false) goto L5;
            return;
        L5:
            if (BaseTransientBottomBar.access$2100(this.transientBottomBar.get()) == false) goto L10;
            BaseTransientBottomBar.access$2200(this.transientBottomBar.get());
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r5) {
            if (unanchorIfNoTransientBottomBar() == false) goto L5;
            return;
        L5:
            ViewUtils.addOnGlobalLayoutListener(r5, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r5) {
            if (unanchorIfNoTransientBottomBar() == false) goto L5;
            return;
        L5:
            ViewUtils.removeOnGlobalLayoutListener(r5, this);
        }

        public void unanchor() {
            if (this.anchorView.get() == null) goto L5;
            this.anchorView.get().removeOnAttachStateChangeListener(this);
            ViewUtils.removeOnGlobalLayoutListener(this.anchorView.get(), this);
        L5:
            this.anchorView.clear();
            this.transientBottomBar.clear();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DismissEvent {
        }

        public BaseCallback() {
        }

        public void onDismissed(B r5, int r10) {
        }

        public void onShown(B r5) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        @NonNull
        private final BehaviorDelegate delegate;

        public Behavior() {
            this.delegate = new BehaviorDelegate(this);
        }

        public static /* synthetic */ void access$1100(Behavior r5, BaseTransientBottomBar r10) {
            r5.setBaseTransientBottomBar(r10);
        }

        private void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> r5) {
            this.delegate.setBaseTransientBottomBar(r5);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View r5) {
            return this.delegate.canSwipeDismissView(r5);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull MotionEvent r11) {
            this.delegate.onInterceptTouchEvent(r5, r10, r11);
            return super.onInterceptTouchEvent(r5, r10, r11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        private SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> r5) {
            r5.setStartAlphaSwipeDistance(0.1f);
            r5.setEndAlphaSwipeDistance(0.6f);
            r5.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View r5) {
            return r5 instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull MotionEvent r11) {
            int r12 = r11.getActionMasked();
            if (r12 == 0) goto L11;
            if (r12 != 1) goto L7;
        L9:
            SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
            return;
        L7:
            if (r12 == 3) goto L9;
            return;
        L11:
            if (r5.isPointInChildBounds(r10, (int) r11.getX(), (int) r11.getY()) == false) goto L15;
            SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
            return;
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> r5) {
            this.managerCallback = r5.managerCallback;
        }
    }

    @Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @IntRange(from = -2)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = null;
        private final float actionTextColorAlpha;
        private boolean addingToTargetParent;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff.Mode backgroundTintMode;

        @Nullable
        private BaseTransientBottomBar<?> baseTransientBottomBar;
        private final int maxInlineActionWidth;
        private final int maxWidth;

        @Nullable
        private Rect originalMargins;

        @Nullable
        ShapeAppearanceModel shapeAppearanceModel;

        static {
            consumeAllTouchListener = new AnonymousClass1();
        }

        public SnackbarBaseLayout(@NonNull Context r5) {
            this(r5, null);
        }

        public static /* synthetic */ Rect access$1000(SnackbarBaseLayout r5) {
            return r5.originalMargins;
        }

        public static /* synthetic */ void access$500(SnackbarBaseLayout r5, BaseTransientBottomBar r10) {
            r5.setBaseTransientBottomBar(r10);
        }

        @NonNull
        private Drawable createThemedBackground() {
            int r5 = MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            ShapeAppearanceModel r10 = this.shapeAppearanceModel;
            if (r10 == null) goto L5;
            Drawable r11 = BaseTransientBottomBar.access$1900(r5, r10);
        L7:
            if (this.backgroundTint == null) goto L11;
            Drawable r12 = DrawableCompat.wrap(r11);
            DrawableCompat.setTintList(r12, this.backgroundTint);
            return r12;
        L11:
            return DrawableCompat.wrap(r11);
        L5:
            r11 = BaseTransientBottomBar.access$2000(r5, getResources());
            goto L7
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> r5) {
            this.baseTransientBottomBar = r5;
        }

        private void updateOriginalMargins(ViewGroup.MarginLayoutParams r5) {
            this.originalMargins = new Rect(r5.leftMargin, r5.topMargin, r5.rightMargin, r5.bottomMargin);
        }

        public void addToTargetParent(ViewGroup r5) {
            this.addingToTargetParent = true;
            r5.addView(this);
            this.addingToTargetParent = false;
        }

        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        public int getAnimationMode() {
            return this.animationMode;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        public int getMaxInlineActionWidth() {
            return this.maxInlineActionWidth;
        }

        public int getMaxWidth() {
            return this.maxWidth;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> r5 = this.baseTransientBottomBar;
            if (r5 == null) goto L5;
            r5.onAttachedToWindow();
        L5:
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> r5 = this.baseTransientBottomBar;
            if (r5 == null) goto L6;
            r5.onDetachedFromWindow();
            return;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
            super.onLayout(r5, r10, r11, r12, r13);
            BaseTransientBottomBar<?> r14 = this.baseTransientBottomBar;
            if (r14 == null) goto L6;
            r14.onLayoutChange();
            return;
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r5, int r10) {
            super.onMeasure(r5, r10);
            if (this.maxWidth <= 0) goto L8;
            int r11 = getMeasuredWidth();
            int r12 = this.maxWidth;
            if (r11 <= r12) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY), r10);
            return;
        L9:
            return;
        }

        public void setAnimationMode(int r5) {
            this.animationMode = r5;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable r5) {
            setBackgroundDrawable(r5);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable r5) {
            if (r5 != null) goto L4;
        L6:
            super.setBackgroundDrawable(r5);
            return;
        L4:
            if (this.backgroundTint == null) goto L6;
            r5 = DrawableCompat.wrap(r5.mutate());
            DrawableCompat.setTintList(r5, this.backgroundTint);
            DrawableCompat.setTintMode(r5, this.backgroundTintMode);
            goto L6
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList r5) {
            this.backgroundTint = r5;
            if (getBackground() == null) goto L8;
            Drawable r10 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintList(r10, r5);
            DrawableCompat.setTintMode(r10, this.backgroundTintMode);
            if (r10 == getBackground()) goto L9;
            super.setBackgroundDrawable(r10);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
            this.backgroundTintMode = r5;
            if (getBackground() == null) goto L8;
            Drawable r10 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintMode(r10, r5);
            if (r10 == getBackground()) goto L9;
            super.setBackgroundDrawable(r10);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams r5) {
            super.setLayoutParams(r5);
            if (this.addingToTargetParent == false) goto L5;
            return;
        L5:
            if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            updateOriginalMargins((ViewGroup.MarginLayoutParams) r5);
            BaseTransientBottomBar<?> r10 = this.baseTransientBottomBar;
            if (r10 == null) goto L12;
            BaseTransientBottomBar.access$900(r10);
            return;
        L12:
            return;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener r5) {
            if (r5 == null) goto L4;
            View.OnTouchListener r10 = null;
        L5:
            setOnTouchListener(r10);
            super.setOnClickListener(r5);
            return;
        L4:
            r10 = consumeAllTouchListener;
            goto L5
        }

        public SnackbarBaseLayout(@NonNull Context r5, AttributeSet r10) {
            super(MaterialThemeOverlay.wrap(r5, r10, 0, 0), r10);
            Context r11 = getContext();
            TypedArray r12 = r11.obtainStyledAttributes(r10, R.styleable.SnackbarLayout);
            if (r12.hasValue(R.styleable.SnackbarLayout_elevation) == false) goto L5;
            ViewCompat.setElevation(this, r12.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
        L5:
            this.animationMode = r12.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            if (r12.hasValue(R.styleable.SnackbarLayout_shapeAppearance) == false) goto L8;
        L9:
            this.shapeAppearanceModel = ShapeAppearanceModel.builder(r11, r10, 0, 0).build();
        L10:
            this.backgroundOverlayColorAlpha = r12.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(r11, r12, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(r12.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = r12.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.maxWidth = r12.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.maxInlineActionWidth = r12.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            r12.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() != null) goto L14;
            ViewCompat.setBackground(this, createThemedBackground());
            return;
        L14:
            return;
        L8:
            if (r12.hasValue(R.styleable.SnackbarLayout_shapeAppearanceOverlay) == false) goto L10;
            goto L9
        }
    }

    static {
        DEFAULT_ANIMATION_SLIDE_INTERPOLATOR = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        DEFAULT_ANIMATION_FADE_INTERPOLATOR = AnimationUtils.LINEAR_INTERPOLATOR;
        DEFAULT_ANIMATION_SCALE_INTERPOLATOR = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        USE_OFFSET_API = false;
        SNACKBAR_STYLE_ATTR = new int[]{R.attr.snackbarStyle};
        TAG = "BaseTransientBottomBar";
        handler = new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public BaseTransientBottomBar(@NonNull ViewGroup r5, @NonNull View r10, @NonNull com.google.android.material.snackbar.ContentViewCallback r11) {
        this(r5.getContext(), r5, r10, r11);
    }

    public static /* synthetic */ Context access$000(BaseTransientBottomBar r5) {
        return r5.context;
    }

    public static /* synthetic */ int access$100(BaseTransientBottomBar r5) {
        return r5.getViewAbsoluteBottom();
    }

    public static /* synthetic */ void access$1200(BaseTransientBottomBar r5) {
        r5.startFadeInAnimation();
    }

    public static /* synthetic */ void access$1300(BaseTransientBottomBar r5) {
        r5.startSlideInAnimation();
    }

    public static /* synthetic */ int access$1400(BaseTransientBottomBar r5) {
        return r5.animationSlideDuration;
    }

    public static /* synthetic */ int access$1500(BaseTransientBottomBar r5) {
        return r5.animationFadeInDuration;
    }

    public static /* synthetic */ com.google.android.material.snackbar.ContentViewCallback access$1600(BaseTransientBottomBar r5) {
        return r5.contentViewCallback;
    }

    public static /* synthetic */ boolean access$1700() {
        return USE_OFFSET_API;
    }

    public static /* synthetic */ int access$1800(BaseTransientBottomBar r5) {
        return r5.animationFadeOutDuration;
    }

    public static /* synthetic */ MaterialShapeDrawable access$1900(int r5, ShapeAppearanceModel r10) {
        return createMaterialShapeDrawableBackground(r5, r10);
    }

    public static /* synthetic */ int access$200(BaseTransientBottomBar r5) {
        return r5.extraBottomMarginGestureInset;
    }

    public static /* synthetic */ GradientDrawable access$2000(int r5, Resources r10) {
        return createGradientDrawableBackground(r5, r10);
    }

    public static /* synthetic */ boolean access$2100(BaseTransientBottomBar r5) {
        return r5.anchorViewLayoutListenerEnabled;
    }

    public static /* synthetic */ void access$2200(BaseTransientBottomBar r5) {
        r5.recalculateAndUpdateMargins();
    }

    public static /* synthetic */ int access$302(BaseTransientBottomBar r5, int r10) {
        r5.appliedBottomMarginGestureInset = r10;
        return r10;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ int access$602(BaseTransientBottomBar r5, int r10) {
        r5.extraBottomMarginWindowInset = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(BaseTransientBottomBar r5, int r10) {
        r5.extraLeftMarginWindowInset = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(BaseTransientBottomBar r5, int r10) {
        r5.extraRightMarginWindowInset = r10;
        return r10;
    }

    public static /* synthetic */ void access$900(BaseTransientBottomBar r5) {
        r5.updateMargins();
    }

    private void animateViewOut(int r5) {
        if (this.view.getAnimationMode() != 1) goto L5;
        startFadeOutAnimation(r5);
        return;
    L5:
        startSlideOutAnimation(r5);
    }

    private int calculateBottomMarginForAnchorView() {
        if (getAnchorView() != null) goto L6;
        return 0;
    L6:
        int[] r5 = new int[2];
        getAnchorView().getLocationOnScreen(r5);
        int r10 = r5[1];
        int[] r11 = new int[2];
        this.targetParent.getLocationOnScreen(r11);
        int r12 = r11[1];
        return (this.targetParent.getHeight() + r12) - r10;
    }

    @NonNull
    private static GradientDrawable createGradientDrawableBackground(@ColorInt int r5, @NonNull Resources r10) {
        float r11 = r10.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        r12.setCornerRadius(r11);
        r12.setColor(r5);
        return r12;
    }

    @NonNull
    private static MaterialShapeDrawable createMaterialShapeDrawableBackground(@ColorInt int r5, @NonNull ShapeAppearanceModel r10) {
        MaterialShapeDrawable r11 = new MaterialShapeDrawable(r10);
        r11.setFillColor(ColorStateList.valueOf(r5));
        return r11;
    }

    private ValueAnimator getAlphaAnimator(float... r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(r5);
        r10.setInterpolator(this.animationFadeInterpolator);
        r10.addUpdateListener(new AnonymousClass11(this));
        return r10;
    }

    private ValueAnimator getScaleAnimator(float... r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(r5);
        r10.setInterpolator(this.animationScaleInterpolator);
        r10.addUpdateListener(new AnonymousClass12(this));
        return r10;
    }

    private int getTranslationYBottom() {
        int r5 = this.view.getHeight();
        ViewGroup.LayoutParams r10 = this.view.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        return r5;
    L5:
        return r5 + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
    }

    private int getViewAbsoluteBottom() {
        int[] r5 = new int[2];
        this.view.getLocationInWindow(r5);
        int r10 = r5[1];
        return this.view.getHeight() + r10;
    }

    private boolean isSwipeDismissable() {
        ViewGroup.LayoutParams r5 = this.view.getLayoutParams();
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((CoordinatorLayout.LayoutParams) r5).getBehavior() instanceof SwipeDismissBehavior) == false) goto L7;
        return true;
    }

    private void recalculateAndUpdateMargins() {
        this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
        updateMargins();
    }

    private void setUpBehavior(CoordinatorLayout.LayoutParams r5) {
        SwipeDismissBehavior<? extends View> r10 = this.behavior;
        if (r10 != null) goto L6;
        r10 = getNewBehavior();
    L6:
        if ((r10 instanceof Behavior) == false) goto L8;
        Behavior.access$1100((Behavior) r10, this);
    L8:
        r10.setListener(new AnonymousClass7(this));
        r5.setBehavior(r10);
        if (getAnchorView() != null) goto L12;
        r5.insetEdge = 80;
        return;
    }

    private boolean shouldUpdateGestureInset() {
        if (this.extraBottomMarginGestureInset > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.gestureInsetBottomIgnored == true) goto L9;
        if (isSwipeDismissable() == false) goto L9;
        return true;
    }

    private void showViewImpl() {
        if (shouldAnimate() == false) goto L6;
        animateViewIn();
        return;
    L6:
        if (this.view.getParent() == null) goto L8;
        this.view.setVisibility(0);
    L8:
        onViewShown();
    }

    private void startFadeInAnimation() {
        ValueAnimator r5 = getAlphaAnimator(new float[]{0.0f, 1.0f});
        ValueAnimator r10 = getScaleAnimator(new float[]{ANIMATION_SCALE_FROM_VALUE, 1.0f});
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{r5, r10});
        r11.setDuration(this.animationFadeInDuration);
        r11.addListener(new AnonymousClass9(this));
        r11.start();
    }

    private void startFadeOutAnimation(final int r5) {
        ValueAnimator r10 = getAlphaAnimator(new float[]{1.0f, 0.0f});
        r10.setDuration(this.animationFadeOutDuration);
        r10.addListener(new AnonymousClass10(this, r5));
        r10.start();
    }

    private void startSlideInAnimation() {
        final int r5 = getTranslationYBottom();
        if (USE_OFFSET_API == false) goto L5;
        ViewCompat.offsetTopAndBottom(this.view, r5);
    L6:
        ValueAnimator r10 = new ValueAnimator();
        r10.setIntValues(new int[]{r5, 0});
        r10.setInterpolator(this.animationSlideInterpolator);
        r10.setDuration(this.animationSlideDuration);
        r10.addListener(new AnonymousClass13(this));
        r10.addUpdateListener(new AnonymousClass14(this, r5));
        r10.start();
        return;
    L5:
        this.view.setTranslationY(r5);
        goto L6
    }

    private void startSlideOutAnimation(final int r5) {
        ValueAnimator r10 = new ValueAnimator();
        r10.setIntValues(new int[]{0, getTranslationYBottom()});
        r10.setInterpolator(this.animationSlideInterpolator);
        r10.setDuration(this.animationSlideDuration);
        r10.addListener(new AnonymousClass15(this, r5));
        r10.addUpdateListener(new AnonymousClass16(this));
        r10.start();
    }

    private void updateMargins() {
        ViewGroup.LayoutParams r5 = this.view.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        Log.w(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
        return;
    L7:
        if (SnackbarBaseLayout.access$1000(this.view) != null) goto L11;
        Log.w(TAG, "Unable to update margins because original view margins are not set");
        return;
    L11:
        if (this.view.getParent() != null) goto L14;
        return;
    L14:
        if (getAnchorView() == null) goto L16;
        int r10 = this.extraBottomMarginAnchorView;
    L17:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r5;
        int r12 = SnackbarBaseLayout.access$1000(this.view).bottom + r10;
        int r13 = SnackbarBaseLayout.access$1000(this.view).left + this.extraLeftMarginWindowInset;
        int r14 = SnackbarBaseLayout.access$1000(this.view).right + this.extraRightMarginWindowInset;
        int r15 = SnackbarBaseLayout.access$1000(this.view).top;
        if (r11.bottomMargin == r12) goto L20;
    L27:
        boolean r16 = true;
    L28:
        if (r16 == false) goto L30;
        r11.bottomMargin = r12;
        r11.leftMargin = r13;
        r11.rightMargin = r14;
        r11.topMargin = r15;
        this.view.requestLayout();
    L30:
        if (r16 == true) goto L34;
        if (this.appliedBottomMarginGestureInset != this.extraBottomMarginGestureInset) goto L34;
        return;
    L34:
        if (shouldUpdateGestureInset() == false) goto L38;
        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
        this.view.post(this.bottomMarginGestureInsetRunnable);
        return;
    L38:
        return;
    L20:
        if (r11.leftMargin != r13) goto L27;
        if (r11.rightMargin != r14) goto L27;
        if (r11.topMargin != r15) goto L27;
        r16 = false;
        goto L28
    L16:
        r10 = this.extraBottomMarginWindowInset;
        goto L17
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> r5) {
        if (r5 != null) goto L5;
        return this;
    L5:
        if (this.callbacks != null) goto L7;
        this.callbacks = new ArrayList();
    L7:
        this.callbacks.add(r5);
        return this;
    }

    public void animateViewIn() {
        this.view.post(new AnonymousClass8(this));
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int r5) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, r5);
    }

    @Nullable
    public View getAnchorView() {
        Anchor r5 = this.anchor;
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getAnchorView();
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        if (hasSnackbarStyleAttr() == false) goto L6;
        return R.layout.mtrl_layout_snackbar;
    L6:
        return R.layout.design_layout_snackbar;
    }

    @NonNull
    public View getView() {
        return this.view;
    }

    public boolean hasSnackbarStyleAttr() {
        TypedArray r5 = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int r10 = r5.getResourceId(0, -1);
        r5.recycle();
        if (r10 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public final void hideView(int r5) {
        if (shouldAnimate() == true) goto L5;
    L7:
        onViewHidden(r5);
        return;
    L5:
        if (this.view.getVisibility() != 0) goto L7;
        animateViewOut(r5);
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.anchorViewLayoutListenerEnabled;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    public void onAttachedToWindow() {
        WindowInsets r5 = this.view.getRootWindowInsets();
        if (r5 == null) goto L6;
        this.extraBottomMarginGestureInset = r5.getMandatorySystemGestureInsets().bottom;
        updateMargins();
        return;
    }

    public void onDetachedFromWindow() {
        if (isShownOrQueued() == false) goto L6;
        handler.post(new AnonymousClass6(this));
        return;
    }

    public void onLayoutChange() {
        if (this.pendingShowingView == false) goto L6;
        showViewImpl();
        this.pendingShowingView = false;
        return;
    }

    public void onViewHidden(int r5) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        List<BaseCallback<B>> r10 = this.callbacks;
        if (r10 == null) goto L7;
        int r11 = r10.size() - 1;
    L5:
        if (r11 < 0) goto L7;
        this.callbacks.get(r11).onDismissed(this, r5);
        r11 = r11 - 1;
    L7:
        ViewParent r12 = this.view.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r12).removeView(this.view);
        return;
    }

    public void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List<BaseCallback<B>> r5 = this.callbacks;
        if (r5 == null) goto L7;
        int r10 = r5.size() - 1;
    L5:
        if (r10 < 0) goto L9;
        this.callbacks.get(r10).onShown(this);
        r10 = r10 - 1;
        goto L5
    L9:
        return;
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> r5) {
        if (r5 != null) goto L4;
        return this;
    L4:
        List<BaseCallback<B>> r10 = this.callbacks;
        if (r10 != null) goto L7;
        return this;
    L7:
        r10.remove(r5);
        return this;
    }

    @NonNull
    public B setAnchorView(@Nullable View r5) {
        Anchor r10 = this.anchor;
        if (r10 == null) goto L5;
        r10.unanchor();
    L5:
        if (r5 != null) goto L7;
        Anchor r11 = null;
    L8:
        this.anchor = r11;
        return this;
    L7:
        r11 = Anchor.anchor(this, r5);
        goto L8
    }

    public void setAnchorViewLayoutListenerEnabled(boolean r5) {
        this.anchorViewLayoutListenerEnabled = r5;
    }

    @NonNull
    public B setAnimationMode(int r5) {
        this.view.setAnimationMode(r5);
        return this;
    }

    @NonNull
    public B setBehavior(Behavior r5) {
        this.behavior = r5;
        return this;
    }

    @NonNull
    public B setDuration(int r5) {
        this.duration = r5;
        return this;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean r5) {
        this.gestureInsetBottomIgnored = r5;
        return this;
    }

    public boolean shouldAnimate() {
        AccessibilityManager r5 = this.accessibilityManager;
        if (r5 != null) goto L5;
        return true;
    L5:
        List<AccessibilityServiceInfo> r10 = r5.getEnabledAccessibilityServiceList(1);
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.isEmpty() == false) goto L10;
        return true;
    }

    public void show() {
        SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    public final void showView() {
        if (this.view.getParent() != null) goto L9;
        ViewGroup.LayoutParams r5 = this.view.getLayoutParams();
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L7;
        setUpBehavior((CoordinatorLayout.LayoutParams) r5);
    L7:
        this.view.addToTargetParent(this.targetParent);
        recalculateAndUpdateMargins();
        this.view.setVisibility(4);
    L9:
        if (ViewCompat.isLaidOut(this.view) == false) goto L12;
        showViewImpl();
        return;
    L12:
        this.pendingShowingView = true;
    }

    public BaseTransientBottomBar(@NonNull Context r5, @NonNull ViewGroup r10, @NonNull View r11, @NonNull com.google.android.material.snackbar.ContentViewCallback r12) {
        this.anchorViewLayoutListenerEnabled = false;
        this.bottomMarginGestureInsetRunnable = new AnonymousClass2(this);
        this.managerCallback = new AnonymousClass5(this);
        if (r10 == null) goto L16;
        if (r11 == null) goto L14;
        if (r12 == null) goto L12;
        this.targetParent = r10;
        this.contentViewCallback = r12;
        this.context = r5;
        ThemeEnforcement.checkAppCompatTheme(r5);
        SnackbarBaseLayout r13 = (SnackbarBaseLayout) LayoutInflater.from(r5).inflate(getSnackbarBaseLayoutResId(), r10, false);
        this.view = r13;
        SnackbarBaseLayout.access$500(r13, this);
        if ((r11 instanceof SnackbarContentLayout) == false) goto L9;
        SnackbarContentLayout r14 = (SnackbarContentLayout) r11;
        r14.updateActionTextColorAlphaIfNeeded(r13.getActionTextColorAlpha());
        r14.setMaxInlineActionWidth(r13.getMaxInlineActionWidth());
    L9:
        r13.addView(r11);
        ViewCompat.setAccessibilityLiveRegion(r13, 1);
        ViewCompat.setImportantForAccessibility(r13, 1);
        ViewCompat.setFitsSystemWindows(r13, true);
        ViewCompat.setOnApplyWindowInsetsListener(r13, new AnonymousClass3(this));
        ViewCompat.setAccessibilityDelegate(r13, new AnonymousClass4(this));
        this.accessibilityManager = (AccessibilityManager) r5.getSystemService("accessibility");
        this.animationSlideDuration = MotionUtils.resolveThemeDuration(r5, R.attr.motionDurationLong2, 250);
        this.animationFadeInDuration = MotionUtils.resolveThemeDuration(r5, R.attr.motionDurationLong2, 150);
        this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(r5, R.attr.motionDurationMedium1, 75);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(r5, R.attr.motionEasingEmphasizedInterpolator, DEFAULT_ANIMATION_FADE_INTERPOLATOR);
        this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(r5, R.attr.motionEasingEmphasizedInterpolator, DEFAULT_ANIMATION_SCALE_INTERPOLATOR);
        this.animationSlideInterpolator = MotionUtils.resolveThemeInterpolator(r5, R.attr.motionEasingEmphasizedInterpolator, DEFAULT_ANIMATION_SLIDE_INTERPOLATOR);
        return;
    L12:
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    L14:
        throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    L16:
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    @NonNull
    public B setAnchorView(@IdRes int r5) {
        View r10 = this.targetParent.findViewById(r5);
        if (r10 == null) goto L7;
        return (B) setAnchorView(r10);
    L7:
        throw new IllegalArgumentException(j0.g(r5, "Unable to find anchor view with id: "));
    }
}
