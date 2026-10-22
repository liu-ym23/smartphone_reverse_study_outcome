package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private final float appBarElevation;
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private final boolean hasLiftOnScrollColor;
    private boolean haveChildWithInterpolator;

    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;

    @Nullable
    private ValueAnimator liftOnScrollColorAnimator;
    private final long liftOnScrollColorDuration;
    private final TimeInterpolator liftOnScrollColorInterpolator;

    @Nullable
    private ValueAnimator.AnimatorUpdateListener liftOnScrollColorUpdateListener;
    private final List<LiftOnScrollListener> liftOnScrollListeners;

    @Nullable
    private WeakReference<View> liftOnScrollTargetView;

    @IdRes
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;

    @Nullable
    private Drawable statusBarForeground;

    @Nullable
    private Integer statusBarForegroundOriginalColor;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;

        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public BaseDragCallback() {
            }

            public abstract boolean canDrag(@NonNull T r5);
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            static {
                CREATOR = new AnonymousClass1();
            }

            public SavedState(@NonNull Parcel r5, ClassLoader r10) {
                super(r5, r10);
                boolean r11 = false;
                if (r5.readByte() == 0) goto L5;
                boolean r12 = true;
            L6:
                this.fullyScrolled = r12;
                if (r5.readByte() == 0) goto L9;
                boolean r13 = true;
            L10:
                this.fullyExpanded = r13;
                this.firstVisibleChildIndex = r5.readInt();
                this.firstVisibleChildPercentageShown = r5.readFloat();
                if (r5.readByte() == 0) goto L13;
                r11 = true;
            L13:
                this.firstVisibleChildAtMinimumHeight = r11;
                return;
            L9:
                r13 = false;
                goto L10
            L5:
                r12 = false;
                goto L6
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel r5, int r10) {
                super.writeToParcel(r5, r10);
                r5.writeByte(this.fullyScrolled ? 1 : 0);
                r5.writeByte(this.fullyExpanded ? 1 : 0);
                r5.writeInt(this.firstVisibleChildIndex);
                r5.writeFloat(this.firstVisibleChildPercentageShown);
                r5.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
            }

            public SavedState(Parcelable r5) {
                super(r5);
            }
        }

        public BaseBehavior() {
        }

        public static /* synthetic */ View access$000(BaseBehavior r5, CoordinatorLayout r10) {
            return r5.getChildWithScrollingBehavior(r10);
        }

        public static /* synthetic */ boolean access$100(BaseBehavior r5, AppBarLayout r10) {
            return r5.childrenHaveScrollFlags(r10);
        }

        public static /* synthetic */ int access$200(BaseBehavior r5) {
            return r5.offsetDelta;
        }

        private void addAccessibilityDelegateIfNeeded(final CoordinatorLayout r5, @NonNull final T r10) {
            if (ViewCompat.hasAccessibilityDelegate(r5) == true) goto L6;
            ViewCompat.setAccessibilityDelegate(r5, new AnonymousClass2(this, r10, r5));
            return;
        }

        private void animateOffsetTo(CoordinatorLayout r5, @NonNull T r10, int r11, float r12) {
            int r13 = Math.abs(getTopBottomOffsetForScrollingSibling() - r11);
            float r14 = Math.abs(r12);
            if (r14 <= 0.0f) goto L5;
            int r15 = Math.round((r13 / r14) * 1000.0f) * 3;
        L6:
            animateOffsetWithDuration(r5, r10, r11, r15);
            return;
        L5:
            r15 = (int) (((r13 / r10.getHeight()) + 1.0f) * 150.0f);
            goto L6
        }

        private void animateOffsetWithDuration(final CoordinatorLayout r5, final T r10, int r11, int r12) {
            int r13 = getTopBottomOffsetForScrollingSibling();
            if (r13 != r11) goto L10;
            ValueAnimator r14 = this.offsetAnimator;
            if (r14 != null) goto L7;
            return;
        L7:
            if (r14.isRunning() == false) goto L17;
            this.offsetAnimator.cancel();
            return;
        L17:
            return;
        L10:
            ValueAnimator r15 = this.offsetAnimator;
            if (r15 != null) goto L13;
            ValueAnimator r16 = new ValueAnimator();
            this.offsetAnimator = r16;
            r16.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.offsetAnimator.addUpdateListener(new AnonymousClass1(this, r5, r10));
        L14:
            this.offsetAnimator.setDuration(Math.min(r12, MAX_OFFSET_ANIMATION_DURATION));
            this.offsetAnimator.setIntValues(new int[]{r13, r11});
            this.offsetAnimator.start();
            return;
        L13:
            r15.cancel();
            goto L14
        }

        private int calculateSnapOffset(int r5, int r10, int r11) {
            if (r5 >= ((r10 + r11) / 2)) goto L6;
            return r10;
        L6:
            return r11;
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout r5, @NonNull T r10, @NonNull View r11) {
            if (r10.hasScrollableChildren() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r5.getHeight() - r11.getHeight()) > r10.getHeight()) goto L7;
            return true;
        }

        private static boolean checkFlag(int r5, int r10) {
            if ((r5 & r10) != r10) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean childrenHaveScrollFlags(AppBarLayout r5) {
            int r10 = r5.getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L9;
            if (((LayoutParams) r5.getChildAt(r11).getLayoutParams()).scrollFlags != 0) goto L6;
            r11 = r11 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout r5) {
            int r10 = r5.getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L13;
            View r12 = r5.getChildAt(r11);
            if ((r12 instanceof NestedScrollingChild) == true) goto L12;
            if ((r12 instanceof AbsListView) == true) goto L12;
            if ((r12 instanceof ScrollView) == true) goto L12;
            r11 = r11 + 1;
        L12:
            return r12;
        L13:
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout r5, int r10) {
            int r11 = Math.abs(r10);
            int r12 = r5.getChildCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            View r14 = r5.getChildAt(r13);
            if (r11 < r14.getTop()) goto L9;
            if (r11 > r14.getBottom()) goto L9;
            return r14;
        L9:
            r13 = r13 + 1;
            goto L3
        L10:
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T r10, int r11) {
            int r12 = r10.getChildCount();
            int r5 = 0;
        L3:
            if (r5 >= r12) goto L12;
            View r13 = r10.getChildAt(r5);
            int r14 = r13.getTop();
            int r15 = r13.getBottom();
            LayoutParams r16 = (LayoutParams) r13.getLayoutParams();
            if (checkFlag(r16.getScrollFlags(), 32) == false) goto L7;
            r14 = r14 - ((LinearLayout.LayoutParams) r16).topMargin;
            r15 = r15 + ((LinearLayout.LayoutParams) r16).bottomMargin;
        L7:
            int r17 = -r11;
            if (r14 > r17) goto L11;
            if (r15 < r17) goto L11;
            return r5;
        L11:
            r5 = r5 + 1;
            goto L3
        L12:
            return -1;
        }

        @Nullable
        private View getChildWithScrollingBehavior(CoordinatorLayout r5) {
            int r10 = r5.getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            View r12 = r5.getChildAt(r11);
            if ((((CoordinatorLayout.LayoutParams) r12.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L6;
            r11 = r11 + 1;
            goto L3
        L6:
            return r12;
        L8:
            return null;
        }

        private int interpolateOffset(@NonNull T r10, int r11) {
            int r12 = Math.abs(r11);
            int r5 = r10.getChildCount();
            int r13 = 0;
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L21;
            View r15 = r10.getChildAt(r14);
            LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
            Interpolator r17 = r16.getScrollInterpolator();
            if (r12 < r15.getTop()) goto L20;
            if (r12 > r15.getBottom()) goto L20;
            if (r17 == null) goto L21;
            int r18 = r16.getScrollFlags();
            if ((r18 & 1) == 0) goto L15;
            r13 = (r15.getHeight() + ((LinearLayout.LayoutParams) r16).topMargin) + ((LinearLayout.LayoutParams) r16).bottomMargin;
            if ((r18 & 2) == 0) goto L15;
            r13 = r13 - ViewCompat.getMinimumHeight(r15);
        L15:
            if (ViewCompat.getFitsSystemWindows(r15) == false) goto L17;
            r13 = r13 - r10.getTopInset();
        L17:
            if (r13 <= 0) goto L21;
            float r19 = r13;
            int r20 = Math.round(r17.getInterpolation((r12 - r15.getTop()) / r19) * r19);
            return (r15.getTop() + r20) * Integer.signum(r11);
        L20:
            r14 = r14 + 1;
        L21:
            return r11;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout r5, @NonNull T r10) {
            List<View> r11 = r5.getDependents(r10);
            int r12 = r11.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L11;
            CoordinatorLayout.Behavior r14 = ((CoordinatorLayout.LayoutParams) r11.get(r13).getLayoutParams()).getBehavior();
            if ((r14 instanceof ScrollingViewBehavior) == true) goto L7;
            r13 = r13 + 1;
            goto L3
        L7:
            if (((ScrollingViewBehavior) r14).getOverlayTop() == 0) goto L14;
            return true;
        L14:
            return false;
        L11:
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout r10, @NonNull T r11) {
            int r5 = r11.getTopInset();
            int r12 = r11.getPaddingTop() + r5;
            int r13 = getTopBottomOffsetForScrollingSibling() - r12;
            int r14 = getChildIndexOnOffset(r11, r13);
            if (r14 < 0) goto L27;
            View r15 = r11.getChildAt(r14);
            LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
            int r17 = r16.getScrollFlags();
            if ((r17 & 17) != 17) goto L28;
            int r18 = -r15.getTop();
            int r19 = -r15.getBottom();
            if (r14 != 0) goto L14;
            if (ViewCompat.getFitsSystemWindows(r11) == false) goto L14;
            if (ViewCompat.getFitsSystemWindows(r15) == false) goto L14;
            r18 = r18 - r11.getTopInset();
        L14:
            if (checkFlag(r17, 2) == false) goto L17;
            r19 = r19 + ViewCompat.getMinimumHeight(r15);
        L23:
            if (checkFlag(r17, 32) == false) goto L25;
            r18 = r18 + ((LinearLayout.LayoutParams) r16).topMargin;
            r19 = r19 - ((LinearLayout.LayoutParams) r16).bottomMargin;
        L25:
            animateOffsetTo(r10, r11, MathUtils.clamp(calculateSnapOffset(r13, r19, r18) + r12, -r11.getTotalScrollRange(), 0), 0.0f);
            return;
        L17:
            if (checkFlag(r17, 5) == false) goto L23;
            int r20 = ViewCompat.getMinimumHeight(r15) + r19;
            if (r13 >= r20) goto L21;
            r18 = r20;
            goto L23
        L21:
            r19 = r20;
            goto L23
        L28:
            return;
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, boolean r14) {
            View r5 = getAppBarChildOnOffset(r11, r12);
            boolean r15 = false;
            if (r5 == null) goto L19;
            int r16 = ((LayoutParams) r5.getLayoutParams()).getScrollFlags();
            if ((r16 & 1) == 0) goto L19;
            int r17 = ViewCompat.getMinimumHeight(r5);
            if (r13 <= 0) goto L14;
            if ((r16 & 12) == 0) goto L14;
            if ((-r12) < ((r5.getBottom() - r17) - r11.getTopInset())) goto L19;
        L12:
            r15 = true;
        L14:
            if ((r16 & 2) == 0) goto L19;
            if ((-r12) >= ((r5.getBottom() - r17) - r11.getTopInset())) goto L12;
        L19:
            if (r11.isLiftOnScroll() == false) goto L21;
            r15 = r11.shouldLift(findFirstScrollingChild(r10));
        L21:
            boolean r18 = r11.setLiftedState(r15);
            if (r14 == true) goto L27;
            if (r18 == true) goto L25;
            return;
        L25:
            if (shouldJumpElevationState(r10, r11) == true) goto L27;
            return;
        L27:
            if (r11.getBackground() == null) goto L30;
            r11.getBackground().jumpToCurrentState();
        L30:
            if (r11.getForeground() == null) goto L33;
            r11.getForeground().jumpToCurrentState();
        L33:
            if (r11.getStateListAnimator() == null) goto L38;
            r11.getStateListAnimator().jumpToCurrentState();
            return;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r5) {
            return canDragView((AppBarLayout) r5);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r5) {
            return getMaxDragOffset((AppBarLayout) r5);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r5) {
            return getScrollRangeForDragFling((AppBarLayout) r5);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator r5 = this.offsetAnimator;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.isRunning() == false) goto L7;
            return true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r5, @NonNull View r10) {
            onFlingFinished(r5, (AppBarLayout) r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11) {
            return onLayoutChild(r5, (AppBarLayout) r10, r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11, int r12, int r13, int r14) {
            return onMeasureChild(r5, (AppBarLayout) r10, r11, r12, r13, r14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r5, @NonNull View r10, View r11, int r12, int r13, int[] r14, int r15) {
            onNestedPreScroll(r5, (AppBarLayout) r10, r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r5, @NonNull View r10, View r11, int r12, int r13, int r14, int r15, int r16, int[] r17) {
            onNestedScroll(r5, (AppBarLayout) r10, r11, r12, r13, r14, r15, r16, r17);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r5, @NonNull View r10, Parcelable r11) {
            onRestoreInstanceState(r5, (AppBarLayout) r10, r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r5, @NonNull View r10) {
            return onSaveInstanceState(r5, (AppBarLayout) r10);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull View r11, View r12, int r13, int r14) {
            return onStartNestedScroll(r5, (AppBarLayout) r10, r11, r12, r13, r14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r5, @NonNull View r10, View r11, int r12) {
            onStopNestedScroll(r5, (AppBarLayout) r10, r11, r12);
        }

        public void restoreScrollState(@Nullable SavedState r5, boolean r10) {
            if (this.savedState == null) goto L5;
            if (r10 == true) goto L5;
            return;
        L5:
            this.savedState = r5;
        }

        @Nullable
        public SavedState saveScrollState(@Nullable Parcelable r10, @NonNull T r11) {
            int r12 = getTopAndBottomOffset();
            int r5 = r11.getChildCount();
            boolean r13 = false;
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L26;
            View r15 = r11.getChildAt(r14);
            int r16 = r15.getBottom() + r12;
            if ((r15.getTop() + r12) > 0) goto L25;
            if (r16 < 0) goto L25;
            if (r10 != null) goto L10;
            r10 = AbsSavedState.EMPTY_STATE;
        L10:
            SavedState r17 = new SavedState(r10);
            if (r12 != 0) goto L13;
            boolean r18 = true;
        L14:
            r17.fullyExpanded = r18;
            if (r18 == false) goto L17;
        L19:
            boolean r19 = false;
        L20:
            r17.fullyScrolled = r19;
            r17.firstVisibleChildIndex = r14;
            if (r16 != (r11.getTopInset() + ViewCompat.getMinimumHeight(r15))) goto L23;
            r13 = true;
        L23:
            r17.firstVisibleChildAtMinimumHeight = r13;
            r17.firstVisibleChildPercentageShown = r16 / r15.getHeight();
            return r17;
        L17:
            if ((-r12) < r11.getTotalScrollRange()) goto L19;
            r19 = true;
            goto L20
        L13:
            r18 = false;
        L25:
            r14 = r14 + 1;
            goto L3
        L26:
            return null;
        }

        public void setDragCallback(@Nullable BaseDragCallback r5) {
            this.onDragCallback = r5;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11, int r12, int r13) {
            return setHeaderTopBottomOffset(r5, (AppBarLayout) r10, r11, r12, r13);
        }

        public BaseBehavior(Context r5, AttributeSet r10) {
            super(r5, r10);
        }

        public boolean canDragView(T r5) {
            BaseDragCallback r10 = this.onDragCallback;
            if (r10 != null) goto L5;
            WeakReference<View> r11 = this.lastNestedScrollingChildRef;
            if (r11 == null) goto L17;
            View r12 = r11.get();
            if (r12 != null) goto L11;
        L15:
            return false;
        L11:
            if (r12.isShown() == false) goto L15;
            if (r12.canScrollVertically(-1) == true) goto L15;
            return true;
        L17:
            return true;
        L5:
            return r10.canDrag(r5);
        }

        public int getMaxDragOffset(@NonNull T r5) {
            int r10 = -r5.getDownNestedScrollRange();
            return r5.getTopInset() + r10;
        }

        public int getScrollRangeForDragFling(@NonNull T r5) {
            return r5.getTotalScrollRange();
        }

        public void onFlingFinished(@NonNull CoordinatorLayout r5, @NonNull T r10) {
            snapToChildIfNeeded(r5, r10);
            if (r10.isLiftOnScroll() == false) goto L6;
            r10.setLiftedState(r10.shouldLift(findFirstScrollingChild(r5)));
            return;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12) {
            boolean r13 = super.onLayoutChild(r10, r11, r12);
            int r5 = r11.getPendingAction();
            SavedState r14 = this.savedState;
            if (r14 != null) goto L5;
        L17:
            if (r5 != 0) goto L19;
        L33:
            r11.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r11.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(r10, r11, getTopAndBottomOffset(), 0, true);
            r11.onOffsetChanged(getTopAndBottomOffset());
            addAccessibilityDelegateIfNeeded(r10, r11);
            return r13;
        L19:
            if ((r5 & 4) == 0) goto L21;
            boolean r15 = true;
        L23:
            if ((r5 & 2) == 0) goto L29;
            int r16 = -r11.getUpNestedPreScrollRange();
            if (r15 == false) goto L27;
            animateOffsetTo(r10, r11, r16, 0.0f);
            goto L33
        L27:
            setHeaderTopBottomOffset(r10, r11, r16);
            goto L33
        L29:
            if ((r5 & 1) == 0) goto L33;
            if (r15 == false) goto L32;
            animateOffsetTo(r10, r11, 0, 0.0f);
            goto L33
        L32:
            setHeaderTopBottomOffset(r10, r11, 0);
            goto L33
        L21:
            r15 = false;
            goto L23
        L5:
            if ((r5 & 8) != 0) goto L17;
            if (r14.fullyScrolled == false) goto L10;
            setHeaderTopBottomOffset(r10, r11, -r11.getTotalScrollRange());
            goto L33
        L10:
            if (r14.fullyExpanded == false) goto L12;
            setHeaderTopBottomOffset(r10, r11, 0);
            goto L33
        L12:
            View r17 = r11.getChildAt(r14.firstVisibleChildIndex);
            int r18 = -r17.getBottom();
            if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L15;
            int r19 = (r11.getTopInset() + ViewCompat.getMinimumHeight(r17)) + r18;
        L16:
            setHeaderTopBottomOffset(r10, r11, r19);
            goto L33
        L15:
            r19 = Math.round(r17.getHeight() * this.savedState.firstVisibleChildPercentageShown) + r18;
            goto L16
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14, int r15) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r11.getLayoutParams())).height != (-2)) goto L7;
            r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(0, 0), r15);
            return true;
        L7:
            return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
        }

        public void onNestedPreScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int[] r15, int r16) {
            if (r14 == 0) goto L10;
            if (r14 >= 0) goto L6;
            int r17 = -r11.getTotalScrollRange();
            int r18 = r11.getDownNestedPreScrollRange() + r17;
        L5:
            int r5 = r17;
            int r19 = r18;
            if (r5 == r19) goto L10;
            r15[1] = scroll(r10, r11, r14, r5, r19);
            goto L10
        L6:
            r17 = -r11.getUpNestedPreScrollRange();
            r18 = 0;
        L10:
            if (r11.isLiftOnScroll() == false) goto L13;
            r11.setLiftedState(r11.shouldLift(r12));
            return;
        }

        public void onNestedScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int r15, int r16, int r17, int[] r18) {
            if (r16 >= 0) goto L4;
            r18[1] = scroll(r10, r11, r16, -r11.getDownNestedScrollRange(), 0);
        L4:
            if (r16 != 0) goto L7;
            addAccessibilityDelegateIfNeeded(r10, r11);
            return;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r5, @NonNull T r10, Parcelable r11) {
            if ((r11 instanceof SavedState) == false) goto L5;
            restoreScrollState((SavedState) r11, true);
            super.onRestoreInstanceState(r5, r10, this.savedState.getSuperState());
            return;
        L5:
            super.onRestoreInstanceState(r5, r10, r11);
            this.savedState = null;
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r5, @NonNull T r10) {
            Parcelable r11 = super.onSaveInstanceState(r5, r10);
            SavedState r12 = saveScrollState(r11, r10);
            if (r12 != null) goto L6;
            return r11;
        L6:
            return r12;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull T r10, @NonNull View r11, View r12, int r13, int r14) {
            if ((r13 & 2) != 0) goto L5;
        L9:
            boolean r15 = false;
        L10:
            if (r15 == false) goto L14;
            ValueAnimator r16 = this.offsetAnimator;
            if (r16 == null) goto L14;
            r16.cancel();
        L14:
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = r14;
            return r15;
        L5:
            if (r10.isLiftOnScroll() == false) goto L7;
        L8:
            r15 = true;
            goto L10
        L7:
            if (canScrollChildren(r5, r10, r11) == false) goto L9;
            goto L8
        }

        public void onStopNestedScroll(CoordinatorLayout r5, @NonNull T r10, View r11, int r12) {
            if (this.lastStartedType != 0) goto L5;
        L6:
            snapToChildIfNeeded(r5, r10);
            if (r10.isLiftOnScroll() == false) goto L9;
            r10.setLiftedState(r10.shouldLift(r11));
        L9:
            this.lastNestedScrollingChildRef = new WeakReference(r11);
            return;
        L5:
            if (r12 != 1) goto L9;
            goto L6
        }

        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14) {
            int r5 = getTopBottomOffsetForScrollingSibling();
            int r15 = 0;
            if (r13 == 0) goto L30;
            if (r5 < r13) goto L30;
            if (r5 > r14) goto L30;
            int r16 = MathUtils.clamp(r12, r13, r14);
            if (r5 != r16) goto L9;
        L31:
            addAccessibilityDelegateIfNeeded(r10, r11);
            return r15;
        L9:
            if (r11.hasChildWithInterpolator() == false) goto L11;
            int r17 = interpolateOffset(r11, r16);
        L12:
            boolean r18 = setTopAndBottomOffset(r17);
            int r19 = r5 - r16;
            this.offsetDelta = r16 - r17;
            int r110 = 1;
            if (r18 == true) goto L15;
        L22:
            if (r18 == false) goto L24;
        L26:
            r11.onOffsetChanged(getTopAndBottomOffset());
            if (r16 >= r5) goto L29;
            r110 = -1;
        L29:
            updateAppBarLayoutDrawableState(r10, r11, r16, r110, false);
            r15 = r19;
            goto L31
        L24:
            if (r11.hasChildWithInterpolator() == false) goto L26;
            r10.dispatchDependentViewsChanged(r11);
        L15:
            if (r15 >= r11.getChildCount()) goto L22;
            LayoutParams r20 = (LayoutParams) r11.getChildAt(r15).getLayoutParams();
            ChildScrollEffect r21 = r20.getScrollEffect();
            if (r21 == null) goto L21;
            if ((r20.getScrollFlags() & 1) == 0) goto L21;
            r21.onOffsetChanged(r11, r11.getChildAt(r15), getTopAndBottomOffset());
        L21:
            r15 = r15 + 1;
            goto L15
        L11:
            r17 = r16;
        L30:
            this.offsetDelta = 0;
            goto L31
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T r5, int r10);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
            public DragCallback() {
            }
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull MotionEvent r11) {
            return super.onInterceptTouchEvent(r5, r10, r11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull AppBarLayout r10, int r11) {
            return super.onLayoutChild(r5, r10, r11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r5, @NonNull AppBarLayout r10, int r11, int r12, int r13, int r14) {
            return super.onMeasureChild(r5, r10, r11, r12, r13, r14);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r5, @NonNull AppBarLayout r10, View r11, int r12, int r13, int[] r14, int r15) {
            super.onNestedPreScroll(r5, r10, r11, r12, r13, r14, r15);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r5, @NonNull AppBarLayout r10, View r11, int r12, int r13, int r14, int r15, int r16, int[] r17) {
            super.onNestedScroll(r5, r10, r11, r12, r13, r14, r15, r16, r17);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r5, @NonNull AppBarLayout r10, Parcelable r11) {
            super.onRestoreInstanceState(r5, r10, r11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r5, @NonNull AppBarLayout r10) {
            return super.onSaveInstanceState(r5, r10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull AppBarLayout r10, @NonNull View r11, View r12, int r13, int r14) {
            return super.onStartNestedScroll(r5, r10, r11, r12, r13, r14);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r5, @NonNull AppBarLayout r10, View r11, int r12) {
            super.onStopNestedScroll(r5, r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull MotionEvent r11) {
            return super.onTouchEvent(r5, r10, r11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback r5) {
            super.setDragCallback(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r5) {
            super.setHorizontalOffsetEnabled(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r5) {
            return super.setLeftAndRightOffset(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r5) {
            return super.setTopAndBottomOffset(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r5) {
            super.setVerticalOffsetEnabled(r5);
        }

        public Behavior(Context r5, AttributeSet r10) {
            super(r5, r10);
        }
    }

    public static abstract class ChildScrollEffect {
        public ChildScrollEffect() {
        }

        public abstract void onOffsetChanged(@NonNull AppBarLayout r5, @NonNull View r10, float r11);
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect ghostRect;
        private final Rect relativeRect;

        public CompressChildScrollEffect() {
            this.relativeRect = new Rect();
            this.ghostRect = new Rect();
        }

        private static void updateRelativeRect(Rect r5, AppBarLayout r10, View r11) {
            r11.getDrawingRect(r5);
            r10.offsetDescendantRectToMyCoords(r11, r5);
            r5.offset(0, -r10.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void onOffsetChanged(@NonNull AppBarLayout r5, @NonNull View r10, float r11) {
            updateRelativeRect(this.relativeRect, r5, r10);
            float r12 = this.relativeRect.top - Math.abs(r11);
            if (r12 > 0.0f) goto L9;
            float r13 = 1.0f - MathUtils.clamp(Math.abs(r12 / this.relativeRect.height()), 0.0f, 1.0f);
            float r14 = (-r12) - ((this.relativeRect.height() * COMPRESS_DISTANCE_FACTOR) * (1.0f - (r13 * r13)));
            r10.setTranslationY(r14);
            r10.getDrawingRect(this.ghostRect);
            this.ghostRect.offset(0, (int) (-r14));
            if (r14 < this.ghostRect.height()) goto L7;
            r10.setVisibility(4);
        L8:
            ViewCompat.setClipBounds(r10, this.ghostRect);
            return;
        L7:
            r10.setVisibility(0);
            goto L8
        L9:
            ViewCompat.setClipBounds(r10, null);
            r10.setTranslationY(0.0f);
            r10.setVisibility(0);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private ChildScrollEffect scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.scrollFlags = 1;
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = r11.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(r11.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            if (r11.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator) == false) goto L5;
            this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(r5, r11.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        L5:
            r11.recycle();
        }

        @Nullable
        private ChildScrollEffect createScrollEffectFromInt(int r5) {
            if (r5 == 1) goto L7;
            return null;
        L7:
            return new CompressChildScrollEffect();
        }

        @Nullable
        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        public boolean isCollapsible() {
            int r5 = this.scrollFlags;
            if ((r5 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r5 & 10) == 0) goto L7;
            return true;
        }

        public void setScrollEffect(@Nullable ChildScrollEffect r5) {
            this.scrollEffect = r5;
        }

        public void setScrollFlags(int r5) {
            this.scrollFlags = r5;
        }

        public void setScrollInterpolator(Interpolator r5) {
            this.scrollInterpolator = r5;
        }

        public void setScrollEffect(int r5) {
            this.scrollEffect = createScrollEffectFromInt(r5);
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.scrollFlags = 1;
        }

        public LayoutParams(int r5, int r10, float r11) {
            super(r5, r10, r11);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams r5) {
            super(r5);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams r5) {
            super(r5);
            this.scrollFlags = 1;
            this.scrollFlags = r5.scrollFlags;
            this.scrollEffect = r5.scrollEffect;
            this.scrollInterpolator = r5.scrollInterpolator;
        }
    }

    public interface LiftOnScrollListener {
        void onUpdate(@Dimension float r5, @ColorInt int r10);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout r5, int r10);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout r5) {
            CoordinatorLayout.Behavior r10 = ((CoordinatorLayout.LayoutParams) r5.getLayoutParams()).getBehavior();
            if ((r10 instanceof BaseBehavior) == true) goto L5;
            return 0;
        L5:
            return ((BaseBehavior) r10).getTopBottomOffsetForScrollingSibling();
        }

        private void offsetChildAsNeeded(@NonNull View r5, @NonNull View r10) {
            CoordinatorLayout.Behavior r11 = ((CoordinatorLayout.LayoutParams) r10.getLayoutParams()).getBehavior();
            if ((r11 instanceof BaseBehavior) == false) goto L6;
            int r12 = r10.getBottom() - r5.getTop();
            ViewCompat.offsetTopAndBottom(r5, ((BaseBehavior.access$200((BaseBehavior) r11) + r12) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r10));
            return;
        }

        private void updateLiftedStateIfNeeded(View r5, View r10) {
            if ((r10 instanceof AppBarLayout) == false) goto L8;
            AppBarLayout r11 = (AppBarLayout) r10;
            if (r11.isLiftOnScroll() == false) goto L9;
            r11.setLiftedState(r11.shouldLift(r5));
            return;
        L9:
            return;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List r5) {
            return findFirstDependency(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public float getOverlapRatioForOffset(View r5) {
            if ((r5 instanceof AppBarLayout) == false) goto L13;
            AppBarLayout r10 = (AppBarLayout) r5;
            int r11 = r10.getTotalScrollRange();
            int r12 = r10.getDownNestedPreScrollRange();
            int r13 = getAppBarLayoutOffset(r10);
            if (r12 != 0) goto L7;
        L9:
            int r14 = r11 - r12;
            if (r14 == 0) goto L13;
            return (r13 / r14) + 1.0f;
        L7:
            if ((r11 + r13) > r12) goto L9;
            return 0.0f;
        L13:
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public int getScrollRange(View r5) {
            if ((r5 instanceof AppBarLayout) == false) goto L7;
            return ((AppBarLayout) r5).getTotalScrollRange();
        L7:
            return super.getScrollRange(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout r5, View r10, View r11) {
            return r11 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull View r11) {
            offsetChildAsNeeded(r10, r11);
            updateLiftedStateIfNeeded(r10, r11);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull View r11) {
            if ((r11 instanceof AppBarLayout) == false) goto L6;
            ViewCompat.setAccessibilityDelegate(r5, null);
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11) {
            return super.onLayoutChild(r5, r10, r11);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r5, @NonNull View r10, int r11, int r12, int r13, int r14) {
            return super.onMeasureChild(r5, r10, r11, r12, r13, r14);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull Rect r11, boolean r12) {
            AppBarLayout r13 = findFirstDependency(r5.getDependencies(r10));
            if (r13 == null) goto L8;
            Rect r14 = new Rect(r11);
            r14.offset(r10.getLeft(), r10.getTop());
            Rect r15 = this.tempRect1;
            r15.set(0, 0, r5.getWidth(), r5.getHeight());
            if (r15.contains(r14) == true) goto L8;
            r13.setExpanded(false, !r12);
            return true;
        L8:
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r5) {
            super.setHorizontalOffsetEnabled(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r5) {
            return super.setLeftAndRightOffset(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r5) {
            return super.setTopAndBottomOffset(r5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r5) {
            super.setVerticalOffsetEnabled(r5);
        }

        public ScrollingViewBehavior(Context r5, AttributeSet r10) {
            super(r5, r10);
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(r11.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            r11.recycle();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public AppBarLayout findFirstDependency(@NonNull List<View> r5) {
            int r10 = r5.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L9;
            View r12 = r5.get(r11);
            if ((r12 instanceof AppBarLayout) == true) goto L7;
            r11 = r11 + 1;
            goto L3
        L7:
            return (AppBarLayout) r12;
        L9:
            return null;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    }

    public AppBarLayout(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(AppBarLayout r5, MaterialShapeDrawable r10, ValueAnimator r11) {
        r5.lambda$initializeLiftOnScrollWithElevation$1(r10, r11);
    }

    public static /* synthetic */ void b(AppBarLayout r5, ColorStateList r10, ColorStateList r11, MaterialShapeDrawable r12, Integer r13, ValueAnimator r14) {
        r5.lambda$initializeLiftOnScrollWithColor$0(r10, r11, r12, r13, r14);
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> r5 = this.liftOnScrollTargetView;
        if (r5 == null) goto L5;
        r5.clear();
    L5:
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private Integer extractStatusBarForegroundColor() {
        Drawable r5 = this.statusBarForeground;
        if ((r5 instanceof MaterialShapeDrawable) == true) goto L5;
        ColorStateList r10 = DrawableUtils.getColorStateListOrNull(r5);
        if (r10 != null) goto L9;
        return null;
    L9:
        return Integer.valueOf(r10.getDefaultColor());
    L5:
        return Integer.valueOf(((MaterialShapeDrawable) r5).getResolvedTintColor());
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View r5) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r10 = this.liftOnScrollTargetViewId;
        if (r10 == (-1)) goto L15;
        if (r5 == null) goto L8;
        View r11 = r5.findViewById(r10);
    L9:
        if (r11 == null) goto L11;
    L13:
        if (r11 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r11);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        r11 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r11 = null;
    L15:
        WeakReference<View> r12 = this.liftOnScrollTargetView;
        if (r12 != null) goto L18;
        return null;
    L18:
        return r12.get();
    }

    private boolean hasCollapsibleChild() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L9;
        if (((LayoutParams) getChildAt(r10).getLayoutParams()).isCollapsible() == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void initializeLiftOnScrollWithColor(final MaterialShapeDrawable r10, @NonNull final ColorStateList r11, @NonNull final ColorStateList r12) {
        final Integer r13 = MaterialColors.getColorOrNull(getContext(), R.attr.colorSurface);
        this.liftOnScrollColorUpdateListener = new a(this, r11, r12, r10, r13);
        ViewCompat.setBackground(this, r10);
    }

    private void initializeLiftOnScrollWithElevation(Context r5, MaterialShapeDrawable r10) {
        r10.initializeElevationOverlay(r5);
        this.liftOnScrollColorUpdateListener = new b(0, this, r10);
        ViewCompat.setBackground(this, r10);
    }

    private void invalidateScrollRanges() {
        Behavior r5 = this.behavior;
        if (r5 != null) goto L5;
    L10:
        BaseBehavior.SavedState r10 = null;
    L11:
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (r10 == null) goto L15;
        this.behavior.restoreScrollState(r10, false);
        return;
    L15:
        return;
    L5:
        if (this.totalScrollRange == (-1)) goto L10;
        if (this.pendingAction != 0) goto L10;
        r10 = r5.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        goto L11
    }

    private boolean isLiftOnScrollCompatibleBackground() {
        return getBackground() instanceof MaterialShapeDrawable;
    }

    private /* synthetic */ void lambda$initializeLiftOnScrollWithColor$0(ColorStateList r5, ColorStateList r10, MaterialShapeDrawable r11, Integer r12, ValueAnimator r13) {
        float r14 = ((Float) r13.getAnimatedValue()).floatValue();
        int r15 = MaterialColors.layer(r5.getDefaultColor(), r10.getDefaultColor(), r14);
        r11.setFillColor(ColorStateList.valueOf(r15));
        if (this.statusBarForeground == null) goto L10;
        Integer r16 = this.statusBarForegroundOriginalColor;
        if (r16 == null) goto L10;
        if (r16.equals(r12) == false) goto L10;
        DrawableCompat.setTint(this.statusBarForeground, r15);
    L10:
        if (this.liftOnScrollListeners.isEmpty() == true) goto L17;
        Iterator<LiftOnScrollListener> r17 = this.liftOnScrollListeners.iterator();
    L13:
        if (r17.hasNext() == false) goto L23;
        LiftOnScrollListener r18 = r17.next();
        if (r11.getFillColor() == null) goto L13;
        r18.onUpdate(0.0f, r15);
        goto L13
    L23:
        return;
    }

    private /* synthetic */ void lambda$initializeLiftOnScrollWithElevation$1(MaterialShapeDrawable r5, ValueAnimator r10) {
        float r11 = ((Float) r10.getAnimatedValue()).floatValue();
        r5.setElevation(r11);
        Drawable r12 = this.statusBarForeground;
        if ((r12 instanceof MaterialShapeDrawable) == false) goto L5;
        ((MaterialShapeDrawable) r12).setElevation(r11);
    L5:
        Iterator<LiftOnScrollListener> r13 = this.liftOnScrollListeners.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r13.next().onUpdate(r11, r5.getResolvedTintColor());
        goto L7
    }

    private boolean setLiftableState(boolean r5) {
        if (this.liftable == r5) goto L6;
        this.liftable = r5;
        refreshDrawableState();
        return true;
    L6:
        return false;
    }

    private boolean shouldDrawStatusBarForeground() {
        if (this.statusBarForeground != null) goto L5;
    L7:
        return false;
    L5:
        if (getTopInset() <= 0) goto L7;
        return true;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) goto L10;
        View r5 = getChildAt(0);
        if (r5.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (ViewCompat.getFitsSystemWindows(r5) == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private void startLiftOnScrollColorAnimation(float r5, float r10) {
        ValueAnimator r11 = this.liftOnScrollColorAnimator;
        if (r11 == null) goto L5;
        r11.cancel();
    L5:
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{r5, r10});
        this.liftOnScrollColorAnimator = r12;
        r12.setDuration(this.liftOnScrollColorDuration);
        this.liftOnScrollColorAnimator.setInterpolator(this.liftOnScrollColorInterpolator);
        ValueAnimator.AnimatorUpdateListener r13 = this.liftOnScrollColorUpdateListener;
        if (r13 == null) goto L8;
        this.liftOnScrollColorAnimator.addUpdateListener(r13);
    L8:
        this.liftOnScrollColorAnimator.start();
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addLiftOnScrollListener(@NonNull LiftOnScrollListener r5) {
        this.liftOnScrollListeners.add(r5);
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener r5) {
        if (this.listeners != null) goto L5;
        this.listeners = new ArrayList();
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (this.listeners.contains(r5) == true) goto L11;
        this.listeners.add(r5);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r5) {
        super.draw(r5);
        if (shouldDrawStatusBarForeground() == false) goto L6;
        int r10 = r5.save();
        r5.translate(0.0f, -this.currentOffset);
        this.statusBarForeground.draw(r5);
        r5.restoreToCount(r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r5 = getDrawableState();
        Drawable r10 = this.statusBarForeground;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == true) goto L7;
        return;
    L7:
        if (r10.setState(r5) == false) goto L12;
        invalidateDrawable(r10);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior r5 = new Behavior();
        this.behavior = r5;
        return r5;
    }

    public int getDownNestedPreScrollRange() {
        int r5 = this.downPreScrollRange;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = getChildCount() - 1;
        int r11 = 0;
    L6:
        if (r10 < 0) goto L28;
        View r12 = getChildAt(r10);
        if (r12.getVisibility() == 8) goto L27;
        LayoutParams r13 = (LayoutParams) r12.getLayoutParams();
        int r14 = r12.getMeasuredHeight();
        int r15 = r13.scrollFlags;
        if ((r15 & 5) != 5) goto L25;
        int r16 = ((LinearLayout.LayoutParams) r13).topMargin + ((LinearLayout.LayoutParams) r13).bottomMargin;
        if ((r15 & 8) == 0) goto L17;
        int r17 = ViewCompat.getMinimumHeight(r12);
    L15:
        int r18 = r17 + r16;
    L20:
        if (r10 == 0) goto L22;
    L24:
        r11 = r11 + r18;
        goto L27
    L22:
        if (ViewCompat.getFitsSystemWindows(r12) == false) goto L24;
        r18 = Math.min(r18, r14 - getTopInset());
        goto L24
    L17:
        if ((r15 & 2) == 0) goto L19;
        r17 = r14 - ViewCompat.getMinimumHeight(r12);
        goto L15
    L19:
        r18 = r16 + r14;
        goto L20
    L25:
        if (r11 > 0) goto L28;
    L27:
        r10 = r10 - 1;
    L28:
        int r19 = Math.max(0, r11);
        this.downPreScrollRange = r19;
        return r19;
    }

    public int getDownNestedScrollRange() {
        int r5 = this.downScrollRange;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r11 >= r10) goto L16;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() == 8) goto L15;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        int r15 = (((LinearLayout.LayoutParams) r14).topMargin + ((LinearLayout.LayoutParams) r14).bottomMargin) + r13.getMeasuredHeight();
        int r16 = r14.scrollFlags;
        if ((r16 & 1) == 0) goto L16;
        r12 = r12 + r15;
        if ((r16 & 2) == 0) goto L15;
        r12 = r12 - ViewCompat.getMinimumHeight(r13);
    L15:
        r11 = r11 + 1;
    L16:
        int r17 = Math.max(0, r12);
        this.downScrollRange = r17;
        return r17;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeBackground() {
        Drawable r5 = getBackground();
        if ((r5 instanceof MaterialShapeDrawable) == true) goto L7;
        return null;
    L7:
        return (MaterialShapeDrawable) r5;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r5 = getTopInset();
        int r10 = ViewCompat.getMinimumHeight(this);
        if (r10 != 0) goto L5;
        int r11 = getChildCount();
        if (r11 < 1) goto L9;
        r10 = ViewCompat.getMinimumHeight(getChildAt(r11 - 1));
    L10:
        if (r10 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r10 = 0;
    L5:
        return (r10 * 2) + r5;
    }

    public int getPendingAction() {
        return this.pendingAction;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat r5 = this.lastInsets;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getSystemWindowInsetTop();
    }

    public final int getTotalScrollRange() {
        int r5 = this.totalScrollRange;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r11 >= r10) goto L21;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() == 8) goto L20;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        int r15 = r13.getMeasuredHeight();
        int r16 = r14.scrollFlags;
        if ((r16 & 1) == 0) goto L21;
        int r17 = ((r15 + ((LinearLayout.LayoutParams) r14).topMargin) + ((LinearLayout.LayoutParams) r14).bottomMargin) + r12;
        if (r11 == 0) goto L15;
    L17:
        r12 = r17;
        if ((r16 & 2) == 0) goto L20;
        r12 = r12 - ViewCompat.getMinimumHeight(r13);
        goto L21
    L15:
        if (ViewCompat.getFitsSystemWindows(r13) == false) goto L17;
        r17 = r17 - getTopInset();
    L20:
        r11 = r11 + 1;
    L21:
        int r18 = Math.max(0, r12);
        this.totalScrollRange = r18;
        return r18;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r5) {
        if (this.tmpStatesArray != null) goto L5;
        this.tmpStatesArray = new int[4];
    L5:
        int[] r10 = this.tmpStatesArray;
        int[] r11 = super.onCreateDrawableState(r5 + r10.length);
        boolean r12 = this.liftable;
        int r13 = R.attr.state_liftable;
        if (r12 == true) goto L9;
        r13 = -r13;
    L9:
        r10[0] = r13;
        if (r12 == true) goto L12;
    L14:
        int r14 = -R.attr.state_lifted;
    L15:
        r10[1] = r14;
        int r15 = R.attr.state_collapsible;
        if (r12 == true) goto L19;
        r15 = -r15;
    L19:
        r10[2] = r15;
        if (r12 == true) goto L22;
    L24:
        int r16 = -R.attr.state_collapsed;
    L25:
        r10[3] = r16;
        return View.mergeDrawableStates(r11, r10);
    L22:
        if (this.lifted == false) goto L24;
        r16 = R.attr.state_collapsed;
        goto L25
    L12:
        if (this.lifted == false) goto L14;
        r14 = R.attr.state_lifted;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        boolean r14 = true;
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L9:
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int r15 = getChildCount();
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L15;
        if (((LayoutParams) getChildAt(r16).getLayoutParams()).getScrollInterpolator() != null) goto L13;
        r16 = r16 + 1;
        goto L10
    L13:
        this.haveChildWithInterpolator = true;
    L15:
        Drawable r17 = this.statusBarForeground;
        if (r17 == null) goto L19;
        r17.setBounds(0, 0, getWidth(), getTopInset());
    L19:
        if (this.liftableOverride == false) goto L21;
        return;
    L21:
        if (this.liftOnScroll == false) goto L23;
    L26:
        setLiftableState(r14);
        return;
    L23:
        if (hasCollapsibleChild() == true) goto L26;
        r14 = false;
        goto L26
    L5:
        if (shouldOffsetFirstChild() == false) goto L9;
        int r18 = getTopInset();
        int r19 = getChildCount() - 1;
    L7:
        if (r19 < 0) goto L9;
        ViewCompat.offsetTopAndBottom(getChildAt(r19), r18);
        r19 = r19 - 1;
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        if (r11 != 1073741824) goto L5;
    L15:
        invalidateScrollRanges();
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L15;
        if (shouldOffsetFirstChild() == false) goto L15;
        int r12 = getMeasuredHeight();
        if (r11 == Integer.MIN_VALUE) goto L13;
        if (r11 != 0) goto L14;
        r12 = r12 + getTopInset();
    L14:
        setMeasuredDimension(getMeasuredWidth(), r12);
        goto L15
    L13:
        int r13 = getMeasuredHeight();
        r12 = MathUtils.clamp(getTopInset() + r13, 0, View.MeasureSpec.getSize(r10));
        goto L14
    }

    public void onOffsetChanged(int r5) {
        this.currentOffset = r5;
        if (willNotDraw() == true) goto L5;
        ViewCompat.postInvalidateOnAnimation(this);
    L5:
        List<BaseOnOffsetChangedListener> r10 = this.listeners;
        if (r10 == null) goto L13;
        int r11 = r10.size();
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L17;
        BaseOnOffsetChangedListener r13 = this.listeners.get(r12);
        if (r13 == null) goto L12;
        r13.onOffsetChanged(this, r5);
    L12:
        r12 = r12 + 1;
        goto L8
    L17:
        return;
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r5) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r10 = r5;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r10) == true) goto L9;
        this.lastInsets = r10;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r5;
    L5:
        r10 = null;
        goto L7
    }

    public boolean removeLiftOnScrollListener(@NonNull LiftOnScrollListener r5) {
        return this.liftOnScrollListeners.remove(r5);
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener r5) {
        List<BaseOnOffsetChangedListener> r10 = this.listeners;
        if (r10 == null) goto L7;
        if (r5 == null) goto L8;
        r10.remove(r5);
        return;
    L8:
        return;
    }

    public void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        MaterialShapeUtils.setElevation(this, r5);
    }

    public void setExpanded(boolean r5) {
        setExpanded(r5, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean r5) {
        this.liftOnScroll = r5;
    }

    public void setLiftOnScrollTargetView(@Nullable View r5) {
        this.liftOnScrollTargetViewId = -1;
        if (r5 != null) goto L5;
        clearLiftOnScrollTargetView();
        return;
    L5:
        this.liftOnScrollTargetView = new WeakReference(r5);
    }

    public void setLiftOnScrollTargetViewId(@IdRes int r5) {
        this.liftOnScrollTargetViewId = r5;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean r5) {
        this.liftableOverride = true;
        return setLiftableState(r5);
    }

    public void setLiftableOverrideEnabled(boolean r5) {
        this.liftableOverride = r5;
    }

    public boolean setLifted(boolean r5) {
        return setLiftedState(r5, true);
    }

    public boolean setLiftedState(boolean r5) {
        return setLiftedState(r5, !this.liftableOverride);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r5) {
        if (r5 != 1) goto L7;
        super.setOrientation(r5);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable r5) {
        Drawable r10 = this.statusBarForeground;
        if (r10 == r5) goto L21;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        r10.setCallback(null);
    L7:
        if (r5 == null) goto L9;
        r11 = r5.mutate();
    L9:
        this.statusBarForeground = r11;
        this.statusBarForegroundOriginalColor = extractStatusBarForegroundColor();
        Drawable r12 = this.statusBarForeground;
        if (r12 != null) goto L12;
    L19:
        updateWillNotDraw();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r12.isStateful() == false) goto L14;
        this.statusBarForeground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
        Drawable r13 = this.statusBarForeground;
        if (getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        r13.setVisible(r14, false);
        this.statusBarForeground.setCallback(this);
        goto L19
    L17:
        r14 = false;
        goto L18
    }

    public void setStatusBarForegroundColor(@ColorInt int r5) {
        setStatusBarForeground(new ColorDrawable(r5));
    }

    public void setStatusBarForegroundResource(@DrawableRes int r5) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), r5));
    }

    @Deprecated
    public void setTargetElevation(float r5) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r5);
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        if (r5 != 0) goto L5;
        boolean r10 = true;
    L6:
        Drawable r11 = this.statusBarForeground;
        if (r11 == null) goto L10;
        r11.setVisible(r10, false);
        return;
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public boolean shouldLift(@Nullable View r5) {
        View r10 = findLiftOnScrollTargetView(r5);
        if (r10 == null) goto L6;
        r5 = r10;
    L6:
        if (r5 != null) goto L8;
    L12:
        return false;
    L8:
        if (r5.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r5.getScrollY() <= 0) goto L12;
        goto L11
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable r5) {
        if (super.verifyDrawable(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5 == this.statusBarForeground) goto L8;
        return false;
    }

    public AppBarLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.appBarLayoutStyle);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    public void setExpanded(boolean r5, boolean r10) {
        setExpanded(r5, r10, true);
    }

    public boolean setLiftedState(boolean r5, boolean r10) {
        if (r10 == true) goto L4;
        return false;
    L4:
        if (this.lifted == r5) goto L31;
        this.lifted = r5;
        refreshDrawableState();
        if (isLiftOnScrollCompatibleBackground() == false) goto L28;
        float r11 = 0.0f;
        if (this.hasLiftOnScrollColor == false) goto L17;
        if (r5 == false) goto L12;
        float r12 = 0.0f;
    L13:
        if (r5 == false) goto L15;
        r11 = 1.0f;
    L15:
        startLiftOnScrollColorAnimation(r12, r11);
        return true;
    L12:
        r12 = 1.0f;
        goto L13
    L17:
        if (this.liftOnScroll == false) goto L30;
        if (r5 == false) goto L20;
        float r13 = 0.0f;
    L21:
        if (r5 == false) goto L23;
        r11 = this.appBarElevation;
    L23:
        startLiftOnScrollColorAnimation(r13, r11);
        return true;
    L20:
        r13 = this.appBarElevation;
        goto L21
    L30:
        return true;
    L28:
        return true;
    L31:
        return false;
    }

    public AppBarLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        this.liftOnScrollListeners = new ArrayList();
        Context r13 = getContext();
        boolean r14 = true;
        setOrientation(1);
        if (getOutlineProvider() != ViewOutlineProvider.BACKGROUND) goto L5;
        ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
    L5:
        ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, r11, r12, r5);
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.AppBarLayout, r12, r5, new int[0]);
        ViewCompat.setBackground(this, r15.getDrawable(R.styleable.AppBarLayout_android_background));
        ColorStateList r16 = MaterialResources.getColorStateList(r13, r15, R.styleable.AppBarLayout_liftOnScrollColor);
        if (r16 != null) goto L9;
        r14 = false;
    L9:
        this.hasLiftOnScrollColor = r14;
        ColorStateList r17 = DrawableUtils.getColorStateListOrNull(getBackground());
        if (r17 == null) goto L15;
        MaterialShapeDrawable r18 = new MaterialShapeDrawable();
        r18.setFillColor(r17);
        if (r16 == null) goto L14;
        initializeLiftOnScrollWithColor(r18, r17, r16);
        goto L15
    L14:
        initializeLiftOnScrollWithElevation(r13, r18);
    L15:
        this.liftOnScrollColorDuration = MotionUtils.resolveThemeDuration(r13, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.liftOnScrollColorInterpolator = MotionUtils.resolveThemeInterpolator(r13, R.attr.motionEasingStandardInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        if (r15.hasValue(R.styleable.AppBarLayout_expanded) == false) goto L19;
        setExpanded(r15.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
    L19:
        if (r15.hasValue(R.styleable.AppBarLayout_elevation) == false) goto L22;
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r15.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
    L22:
        if (r15.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster) == false) goto L25;
        setKeyboardNavigationCluster(r15.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
    L25:
        if (r15.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus) == false) goto L27;
        setTouchscreenBlocksFocus(r15.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
    L27:
        this.appBarElevation = getResources().getDimension(R.dimen.design_appbar_elevation);
        this.liftOnScroll = r15.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = r15.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(r15.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        r15.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    private void setExpanded(boolean r5, boolean r10, boolean r11) {
        if (r5 == false) goto L4;
        int r12 = 1;
    L5:
        int r13 = 0;
        if (r10 == false) goto L8;
        int r14 = 4;
    L9:
        int r15 = r12 | r14;
        if (r11 == false) goto L12;
        r13 = 8;
    L12:
        this.pendingAction = r15 | r13;
        requestLayout();
        return;
    L8:
        r14 = 0;
        goto L9
    L4:
        r12 = 2;
        goto L5
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener r5) {
        removeOnOffsetChangedListener(r5);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener r5) {
        addOnOffsetChangedListener(r5);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return new LayoutParams((LinearLayout.LayoutParams) r5);
    L7:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L11:
        return new LayoutParams(r5);
    }
}
