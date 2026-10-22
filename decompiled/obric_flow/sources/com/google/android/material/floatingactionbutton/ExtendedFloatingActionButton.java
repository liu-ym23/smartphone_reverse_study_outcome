package com.google.android.material.floatingactionbutton;

import ai.j0;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private static final int DEF_STYLE_RES = 0;
    private static final int EXTEND = 3;
    private static final int EXTEND_STRATEGY_AUTO = 0;
    private static final int EXTEND_STRATEGY_MATCH_PARENT = 2;
    private static final int EXTEND_STRATEGY_WRAP_CONTENT = 1;
    static final Property<View, Float> HEIGHT = null;
    private static final int HIDE = 1;
    static final Property<View, Float> PADDING_END = null;
    static final Property<View, Float> PADDING_START = null;
    private static final int SHOW = 0;
    private static final int SHRINK = 2;
    static final Property<View, Float> WIDTH = null;
    private int animState;
    private boolean animateShowBeforeLayout;

    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;

    @NonNull
    private final MotionStrategy extendStrategy;
    private final int extendStrategyType;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;
    private int originalHeight;

    @NonNull
    protected ColorStateList originalTextCsl;
    private int originalWidth;
    private final MotionStrategy showStrategy;

    @NonNull
    private final MotionStrategy shrinkStrategy;

    public class ChangeSizeStrategy extends BaseMotionStrategy {
        private final boolean extending;
        private final Size size;
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public ChangeSizeStrategy(ExtendedFloatingActionButton r5, AnimatorTracker r10, Size r11, boolean r12) {
            this.this$0 = r5;
            super(r5, r10);
            this.size = r11;
            this.extending = r12;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        @NonNull
        public AnimatorSet createAnimator() {
            MotionSpec r5 = getCurrentMotionSpec();
            if (r5.hasPropertyValues("width") == false) goto L6;
            PropertyValuesHolder[] r10 = r5.getPropertyValues("width");
            r10[0].setFloatValues(new float[]{this.this$0.getWidth(), this.size.getWidth()});
            r5.setPropertyValues("width", r10);
        L6:
            if (r5.hasPropertyValues("height") == false) goto L9;
            PropertyValuesHolder[] r11 = r5.getPropertyValues("height");
            r11[0].setFloatValues(new float[]{this.this$0.getHeight(), this.size.getHeight()});
            r5.setPropertyValues("height", r11);
        L9:
            if (r5.hasPropertyValues("paddingStart") == false) goto L12;
            PropertyValuesHolder[] r12 = r5.getPropertyValues("paddingStart");
            r12[0].setFloatValues(new float[]{ViewCompat.getPaddingStart(this.this$0), this.size.getPaddingStart()});
            r5.setPropertyValues("paddingStart", r12);
        L12:
            if (r5.hasPropertyValues("paddingEnd") == false) goto L15;
            PropertyValuesHolder[] r13 = r5.getPropertyValues("paddingEnd");
            r13[0].setFloatValues(new float[]{ViewCompat.getPaddingEnd(this.this$0), this.size.getPaddingEnd()});
            r5.setPropertyValues("paddingEnd", r13);
        L15:
            if (r5.hasPropertyValues("labelOpacity") == false) goto L25;
            PropertyValuesHolder[] r14 = r5.getPropertyValues("labelOpacity");
            boolean r15 = this.extending;
            float r16 = 1.0f;
            if (r15 == false) goto L19;
            float r17 = 0.0f;
        L20:
            if (r15 == true) goto L23;
            r16 = 0.0f;
        L23:
            r14[0].setFloatValues(new float[]{r17, r16});
            r5.setPropertyValues("labelOpacity", r14);
            goto L25
        L19:
            r17 = 1.0f;
        L25:
            return super.createAnimator(r5);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            if (this.extending == false) goto L6;
            return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
        L6:
            return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$602(this.this$0, false);
            this.this$0.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams r5 = this.this$0.getLayoutParams();
            if (r5 != null) goto L5;
            return;
        L5:
            r5.width = this.size.getLayoutParams().width;
            r5.height = this.size.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r5) {
            super.onAnimationStart(r5);
            ExtendedFloatingActionButton.access$502(this.this$0, this.extending);
            ExtendedFloatingActionButton.access$602(this.this$0, true);
            this.this$0.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (this.extending == false) goto L7;
            r5.onExtended(this.this$0);
            return;
        L7:
            r5.onShrunken(this.this$0);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.access$502(this.this$0, this.extending);
            ViewGroup.LayoutParams r5 = this.this$0.getLayoutParams();
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.extending == true) goto L8;
            ExtendedFloatingActionButton.access$302(this.this$0, r5.width);
            ExtendedFloatingActionButton.access$202(this.this$0, r5.height);
        L8:
            r5.width = this.size.getLayoutParams().width;
            r5.height = this.size.getLayoutParams().height;
            ViewCompat.setPaddingRelative(this.this$0, this.size.getPaddingStart(), this.this$0.getPaddingTop(), this.size.getPaddingEnd(), this.this$0.getPaddingBottom());
            this.this$0.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            if (this.extending != ExtendedFloatingActionButton.access$500(this.this$0)) goto L5;
        L10:
            return true;
        L5:
            if (this.this$0.getIcon() == null) goto L10;
            if (TextUtils.isEmpty(this.this$0.getText()) == true) goto L10;
            return false;
        }
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;

        @Nullable
        private OnChangedCallback internalAutoHideCallback;

        @Nullable
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = AUTO_SHRINK_DEFAULT;
        }

        private static boolean isBottomSheet(@NonNull View r5) {
            ViewGroup.LayoutParams r10 = r5.getLayoutParams();
            if ((r10 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.LayoutParams) r10).getBehavior() instanceof BottomSheetBehavior;
        }

        private boolean shouldUpdateVisibility(@NonNull View r5, @NonNull ExtendedFloatingActionButton r10) {
            CoordinatorLayout.LayoutParams r11 = (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
            if (this.autoHideEnabled == true) goto L8;
            if (this.autoShrinkEnabled == true) goto L8;
            return false;
        L8:
            if (r11.getAnchorId() == r5.getId()) goto L10;
            return false;
        L10:
            return AUTO_SHRINK_DEFAULT;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r5, @NonNull AppBarLayout r10, @NonNull ExtendedFloatingActionButton r11) {
            if (shouldUpdateVisibility(r10, r11) == true) goto L7;
            return false;
        L7:
            if (this.tmpRect != null) goto L9;
            this.tmpRect = new Rect();
        L9:
            Rect r12 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(r5, r10, r12);
            if (r12.bottom > r10.getMinimumHeightForVisibleOverlappingContent()) goto L12;
            shrinkOrHide(r11);
            return AUTO_SHRINK_DEFAULT;
        L12:
            extendOrShow(r11);
            return AUTO_SHRINK_DEFAULT;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View r5, @NonNull ExtendedFloatingActionButton r10) {
            if (shouldUpdateVisibility(r5, r10) == true) goto L6;
            return false;
        L6:
            CoordinatorLayout.LayoutParams r11 = (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
            if (r5.getTop() >= ((r10.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r11).topMargin)) goto L9;
            shrinkOrHide(r10);
            return AUTO_SHRINK_DEFAULT;
        L9:
            extendOrShow(r10);
            return AUTO_SHRINK_DEFAULT;
        }

        public void extendOrShow(@NonNull ExtendedFloatingActionButton r5) {
            boolean r10 = this.autoShrinkEnabled;
            if (r10 == false) goto L5;
            OnChangedCallback r11 = this.internalAutoShrinkCallback;
        L6:
            if (r10 == false) goto L8;
            int r12 = 3;
        L9:
            ExtendedFloatingActionButton.access$400(r5, r12, r11);
            return;
        L8:
            r12 = 0;
            goto L9
        L5:
            r11 = this.internalAutoHideCallback;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull Rect r11) {
            return getInsetDodgeRect(r5, (ExtendedFloatingActionButton) r10, r11);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r5) {
            if (r5.dodgeInsetEdges != 0) goto L6;
            r5.dodgeInsetEdges = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r5, @NonNull View r10, View r11) {
            return onDependentViewChanged(r5, (ExtendedFloatingActionButton) r10, r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11) {
            return onLayoutChild(r5, (ExtendedFloatingActionButton) r10, r11);
        }

        public void setAutoHideEnabled(boolean r5) {
            this.autoHideEnabled = r5;
        }

        public void setAutoShrinkEnabled(boolean r5) {
            this.autoShrinkEnabled = r5;
        }

        @VisibleForTesting
        public void setInternalAutoHideCallback(@Nullable OnChangedCallback r5) {
            this.internalAutoHideCallback = r5;
        }

        @VisibleForTesting
        public void setInternalAutoShrinkCallback(@Nullable OnChangedCallback r5) {
            this.internalAutoShrinkCallback = r5;
        }

        public void shrinkOrHide(@NonNull ExtendedFloatingActionButton r5) {
            boolean r10 = this.autoShrinkEnabled;
            if (r10 == false) goto L5;
            OnChangedCallback r11 = this.internalAutoShrinkCallback;
        L6:
            if (r10 == false) goto L8;
            int r12 = 2;
        L9:
            ExtendedFloatingActionButton.access$400(r5, r12, r11);
            return;
        L8:
            r12 = 1;
            goto L9
        L5:
            r11 = this.internalAutoHideCallback;
            goto L6
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r5, @NonNull ExtendedFloatingActionButton r10, @NonNull Rect r11) {
            return super.getInsetDodgeRect(r5, r10, r11);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r5, @NonNull ExtendedFloatingActionButton r10, View r11) {
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

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull ExtendedFloatingActionButton r11, int r12) {
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
            return AUTO_SHRINK_DEFAULT;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context r5, @Nullable AttributeSet r10) {
            super(r5, r10);
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r11.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = r11.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, AUTO_SHRINK_DEFAULT);
            r11.recycle();
        }
    }

    public class HideStrategy extends BaseMotionStrategy {
        private boolean isCancelled;
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public HideStrategy(ExtendedFloatingActionButton r5, AnimatorTracker r10) {
            this.this$0 = r5;
            super(r5, r10);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$702(this.this$0, 0);
            if (this.isCancelled == true) goto L6;
            this.this$0.setVisibility(8);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r5) {
            super.onAnimationStart(r5);
            this.isCancelled = false;
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$702(this.this$0, 1);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r5) {
            if (r5 == null) goto L5;
            r5.onHidden(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$900(this.this$0);
        }
    }

    public static abstract class OnChangedCallback {
        public OnChangedCallback() {
        }

        public void onExtended(ExtendedFloatingActionButton r5) {
        }

        public void onHidden(ExtendedFloatingActionButton r5) {
        }

        public void onShown(ExtendedFloatingActionButton r5) {
        }

        public void onShrunken(ExtendedFloatingActionButton r5) {
        }
    }

    public class ShowStrategy extends BaseMotionStrategy {
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public ShowStrategy(ExtendedFloatingActionButton r5, AnimatorTracker r10) {
            this.this$0 = r5;
            super(r5, r10);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$702(this.this$0, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r5) {
            super.onAnimationStart(r5);
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$702(this.this$0, 2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r5) {
            if (r5 == null) goto L5;
            r5.onShown(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(0);
            this.this$0.setAlpha(1.0f);
            this.this$0.setScaleY(1.0f);
            this.this$0.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$800(this.this$0);
        }
    }

    public interface Size {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
        final String r5 = "width";
        final Class<Float> r10 = Float.class;
        WIDTH = new AnonymousClass6(r10, r5);
        final String r11 = "height";
        HEIGHT = new AnonymousClass7(r10, r11);
        final String r12 = "paddingStart";
        PADDING_START = new AnonymousClass8(r10, r12);
        final String r13 = "paddingEnd";
        PADDING_END = new AnonymousClass9(r10, r13);
    }

    public ExtendedFloatingActionButton(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int access$000(ExtendedFloatingActionButton r5) {
        return r5.extendedPaddingStart;
    }

    public static /* synthetic */ int access$100(ExtendedFloatingActionButton r5) {
        return r5.extendedPaddingEnd;
    }

    public static /* synthetic */ int access$200(ExtendedFloatingActionButton r5) {
        return r5.originalHeight;
    }

    public static /* synthetic */ int access$202(ExtendedFloatingActionButton r5, int r10) {
        r5.originalHeight = r10;
        return r10;
    }

    public static /* synthetic */ int access$300(ExtendedFloatingActionButton r5) {
        return r5.originalWidth;
    }

    public static /* synthetic */ int access$302(ExtendedFloatingActionButton r5, int r10) {
        r5.originalWidth = r10;
        return r10;
    }

    public static /* synthetic */ void access$400(ExtendedFloatingActionButton r5, int r10, OnChangedCallback r11) {
        r5.performMotion(r10, r11);
    }

    public static /* synthetic */ boolean access$500(ExtendedFloatingActionButton r5) {
        return r5.isExtended;
    }

    public static /* synthetic */ boolean access$502(ExtendedFloatingActionButton r5, boolean r10) {
        r5.isExtended = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$602(ExtendedFloatingActionButton r5, boolean r10) {
        r5.isTransforming = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(ExtendedFloatingActionButton r5, int r10) {
        r5.animState = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$800(ExtendedFloatingActionButton r5) {
        return r5.isOrWillBeShown();
    }

    public static /* synthetic */ boolean access$900(ExtendedFloatingActionButton r5) {
        return r5.isOrWillBeHidden();
    }

    private Size getSizeFromExtendStrategyType(int r5) {
        final Size r10 = new AnonymousClass2(this);
        final Size r11 = new AnonymousClass3(this, r10);
        Size r12 = new AnonymousClass4(this, r11, r10);
        if (r5 != 1) goto L5;
        return r10;
    L5:
        if (r5 == 2) goto L7;
        return r12;
    L7:
        return r11;
    }

    private boolean isOrWillBeHidden() {
        if (getVisibility() != 0) goto L9;
        if (this.animState == 1) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 2) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean isOrWillBeShown() {
        if (getVisibility() == 0) goto L9;
        if (this.animState == 2) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 1) goto L11;
        return false;
    L11:
        return true;
    }

    private void performMotion(int r5, @Nullable final OnChangedCallback r10) {
        if (r5 != 0) goto L5;
        final MotionStrategy r11 = this.showStrategy;
    L16:
        if (r11.shouldCancel() == false) goto L19;
        return;
    L19:
        if (shouldAnimateVisibilityChange() == true) goto L22;
        r11.performNow();
        r11.onChange(r10);
        return;
    L22:
        if (r5 != 2) goto L27;
        ViewGroup.LayoutParams r12 = getLayoutParams();
        if (r12 == null) goto L26;
        this.originalWidth = r12.width;
        this.originalHeight = r12.height;
        goto L27
    L26:
        this.originalWidth = getWidth();
        this.originalHeight = getHeight();
    L27:
        measure(0, 0);
        AnimatorSet r13 = r11.createAnimator();
        r13.addListener(new AnonymousClass5(this, r11, r10));
        Iterator<Animator.AnimatorListener> r14 = r11.getListeners().iterator();
    L29:
        if (r14.hasNext() == false) goto L31;
        r13.addListener(r14.next());
        goto L29
    L31:
        r13.start();
        return;
    L5:
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L8;
        r11 = this.shrinkStrategy;
        goto L16
    L8:
        if (r5 != 3) goto L11;
        r11 = this.extendStrategy;
        goto L16
    L11:
        throw new IllegalStateException(j0.g(r5, "Unknown strategy type: "));
    L13:
        r11 = this.hideStrategy;
        goto L16
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.isLaidOut(this) == true) goto L9;
        if (isOrWillBeShown() == false) goto L7;
    L11:
        return false;
    L7:
        if (this.animateShowBeforeLayout == false) goto L11;
    L9:
        if (isInEditMode() == true) goto L11;
        return true;
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.extendStrategy.addAnimationListener(r5);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.hideStrategy.addAnimationListener(r5);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.showStrategy.addAnimationListener(r5);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.shrinkStrategy.addAnimationListener(r5);
    }

    public void extend() {
        performMotion(3, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int r5 = this.collapsedSize;
        if (r5 < 0) goto L5;
        return r5;
    L5:
        return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    public void hide() {
        performMotion(1, null);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == true) goto L7;
        return;
    L7:
        if (getIcon() == null) goto L12;
        this.isExtended = false;
        this.shrinkStrategy.performNow();
        return;
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.extendStrategy.removeAnimationListener(r5);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.hideStrategy.removeAnimationListener(r5);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.showStrategy.removeAnimationListener(r5);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r5) {
        this.shrinkStrategy.removeAnimationListener(r5);
    }

    public void setAnimateShowBeforeLayout(boolean r5) {
        this.animateShowBeforeLayout = r5;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec r5) {
        this.extendStrategy.setMotionSpec(r5);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int r5) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), r5));
    }

    public void setExtended(boolean r5) {
        if (this.isExtended != r5) goto L5;
        return;
    L5:
        if (r5 == false) goto L7;
        MotionStrategy r10 = this.extendStrategy;
    L9:
        if (r10.shouldCancel() == false) goto L11;
        return;
    L11:
        r10.performNow();
        return;
    L7:
        r10 = this.shrinkStrategy;
        goto L9
    }

    public void setHideMotionSpec(@Nullable MotionSpec r5) {
        this.hideStrategy.setMotionSpec(r5);
    }

    public void setHideMotionSpecResource(@AnimatorRes int r5) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r5));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r5, int r10, int r11, int r12) {
        super.setPadding(r5, r10, r11, r12);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int r5, int r10, int r11, int r12) {
        super.setPaddingRelative(r5, r10, r11, r12);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = r5;
        this.extendedPaddingEnd = r11;
        return;
    }

    public void setShowMotionSpec(@Nullable MotionSpec r5) {
        this.showStrategy.setMotionSpec(r5);
    }

    public void setShowMotionSpecResource(@AnimatorRes int r5) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r5));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec r5) {
        this.shrinkStrategy.setMotionSpec(r5);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int r5) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), r5));
    }

    @Override // android.widget.TextView
    public void setTextColor(int r5) {
        super.setTextColor(r5);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(0, null);
    }

    public void shrink() {
        performMotion(2, null);
    }

    public void silentlyUpdateTextColor(@NonNull ColorStateList r5) {
        super.setTextColor(r5);
    }

    public ExtendedFloatingActionButton(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.extendedFloatingActionButtonStyle);
    }

    public void extend(@NonNull OnChangedCallback r5) {
        performMotion(3, r5);
    }

    public void hide(@NonNull OnChangedCallback r5) {
        performMotion(1, r5);
    }

    public void show(@NonNull OnChangedCallback r5) {
        performMotion(0, r5);
    }

    public void shrink(@NonNull OnChangedCallback r5) {
        performMotion(2, r5);
    }

    public ExtendedFloatingActionButton(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r17, r18, r19, r10), r18, r19);
        this.animState = 0;
        AnimatorTracker r5 = new AnimatorTracker();
        this.changeVisibilityTracker = r5;
        ShowStrategy r11 = new ShowStrategy(this, r5);
        this.showStrategy = r11;
        HideStrategy r12 = new HideStrategy(this, r5);
        this.hideStrategy = r12;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context r14 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(r14, r18);
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r14, r18, R.styleable.ExtendedFloatingActionButton, r19, r10, new int[0]);
        MotionSpec r15 = MotionSpec.createFromAttribute(r14, r13, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec r16 = MotionSpec.createFromAttribute(r14, r13, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec r20 = MotionSpec.createFromAttribute(r14, r13, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec r21 = MotionSpec.createFromAttribute(r14, r13, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = r13.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        int r22 = r13.getInt(R.styleable.ExtendedFloatingActionButton_extendStrategy, 1);
        this.extendStrategyType = r22;
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        AnimatorTracker r110 = new AnimatorTracker();
        ChangeSizeStrategy r111 = new ChangeSizeStrategy(this, r110, getSizeFromExtendStrategyType(r22), true);
        this.extendStrategy = r111;
        ChangeSizeStrategy r23 = new ChangeSizeStrategy(this, r110, new AnonymousClass1(this), false);
        this.shrinkStrategy = r23;
        r11.setMotionSpec(r15);
        r12.setMotionSpec(r16);
        r111.setMotionSpec(r20);
        r23.setMotionSpec(r21);
        r13.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(r14, r18, r19, r10, ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList r5) {
        super.setTextColor(r5);
        saveOriginalTextCsl();
    }
}
