package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q5.g;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;

    @Nullable
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;

    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private final List<e> liftOnScrollListeners;

    @Nullable
    private WeakReference<View> liftOnScrollTargetView;

    @IdRes
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<b> listeners;
    private int pendingAction;

    @Nullable
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;

        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private b onDragCallback;
        private SavedState savedState;

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Nullable
                public SavedState a(@NonNull Parcel r10) {
                    return new SavedState(r10, null);
                }

                @NonNull
                public SavedState b(@NonNull Parcel r10, ClassLoader r11) {
                    return new SavedState(r10, r11);
                }

                @NonNull
                public SavedState[] c(int r10) {
                    return new SavedState[r10];
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
                public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
                    return a(r10);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
                    return b(r10, r11);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                    return c(r10);
                }
            }

            static {
                CREATOR = new a();
            }

            public SavedState(@NonNull Parcel r10, ClassLoader r11) {
                super(r10, r11);
                boolean r12 = true;
                if (r10.readByte() == 0) goto L5;
                boolean r13 = true;
            L6:
                this.fullyScrolled = r13;
                if (r10.readByte() == 0) goto L9;
                boolean r14 = true;
            L10:
                this.fullyExpanded = r14;
                this.firstVisibleChildIndex = r10.readInt();
                this.firstVisibleChildPercentageShown = r10.readFloat();
                if (r10.readByte() != 0) goto L14;
                r12 = false;
            L14:
                this.firstVisibleChildAtMinimumHeight = r12;
                return;
            L9:
                r14 = false;
                goto L10
            L5:
                r13 = false;
                goto L6
            }

            public SavedState(Parcelable r10) {
                super(r10);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel r10, int r11) {
                super.writeToParcel(r10, r11);
                r10.writeByte(this.fullyScrolled ? 1 : 0);
                r10.writeByte(this.fullyExpanded ? 1 : 0);
                r10.writeInt(this.firstVisibleChildIndex);
                r10.writeFloat(this.firstVisibleChildPercentageShown);
                r10.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
            }
        }

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f2946c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f2947g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ BaseBehavior f2948h;

            a(BaseBehavior r10, CoordinatorLayout r11, AppBarLayout r12) {
                this.f2948h = r10;
                this.f2946c = r11;
                this.f2947g = r12;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator r10) {
                this.f2948h.setHeaderTopBottomOffset(this.f2946c, this.f2947g, ((Integer) r10.getAnimatedValue()).intValue());
            }
        }

        public static abstract class b<T extends AppBarLayout> {
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        static /* synthetic */ int access$200(BaseBehavior r10) {
            return r10.offsetDelta;
        }

        private void addAccessibilityScrollActions(final CoordinatorLayout r10, @NonNull final T r11, @NonNull final View r12) {
            if (getTopBottomOffsetForScrollingSibling() == (-r11.getTotalScrollRange())) goto L8;
            if (r12.canScrollVertically(1) == false) goto L8;
            addActionToExpand(r10, r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
        L8:
            if (getTopBottomOffsetForScrollingSibling() != 0) goto L10;
            return;
        L10:
            if (r12.canScrollVertically(-1) == false) goto L14;
            final int r13 = -r11.getDownNestedPreScrollRange();
            if (r13 == 0) goto L17;
            ViewCompat.replaceAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass2(this, r10, r11, r12, r13));
            return;
        L17:
            return;
        L14:
            addActionToExpand(r10, r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        }

        private void addActionToExpand(CoordinatorLayout r10, @NonNull final T r11, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r12, final boolean r13) {
            ViewCompat.replaceAccessibilityAction(r10, r12, null, new AnonymousClass3(this, r11, r13));
        }

        private void animateOffsetTo(CoordinatorLayout r10, @NonNull T r11, int r12, float r13) {
            int r14 = Math.abs(getTopBottomOffsetForScrollingSibling() - r12);
            float r15 = Math.abs(r13);
            if (r15 <= 0.0f) goto L5;
            int r16 = Math.round((r14 / r15) * 1000.0f) * 3;
        L6:
            animateOffsetWithDuration(r10, r11, r12, r16);
            return;
        L5:
            r16 = (int) (((r14 / r11.getHeight()) + 1.0f) * 150.0f);
            goto L6
        }

        private void animateOffsetWithDuration(CoordinatorLayout r10, T r11, int r12, int r13) {
            int r14 = getTopBottomOffsetForScrollingSibling();
            if (r14 != r12) goto L10;
            ValueAnimator r15 = this.offsetAnimator;
            if (r15 != null) goto L7;
            return;
        L7:
            if (r15.isRunning() == false) goto L17;
            this.offsetAnimator.cancel();
            return;
        L17:
            return;
        L10:
            ValueAnimator r16 = this.offsetAnimator;
            if (r16 != null) goto L13;
            ValueAnimator r17 = new ValueAnimator();
            this.offsetAnimator = r17;
            r17.setInterpolator(r5.a.f12677e);
            this.offsetAnimator.addUpdateListener(new a(this, r10, r11));
        L14:
            this.offsetAnimator.setDuration(Math.min(r13, 600));
            this.offsetAnimator.setIntValues(new int[]{r14, r12});
            this.offsetAnimator.start();
            return;
        L13:
            r16.cancel();
            goto L14
        }

        private int calculateSnapOffset(int r10, int r11, int r12) {
            if (r10 >= ((r11 + r12) / 2)) goto L6;
            return r11;
        L6:
            return r12;
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout r10, @NonNull T r11, @NonNull View r12) {
            if (r11.hasScrollableChildren() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r10.getHeight() - r12.getHeight()) > r11.getHeight()) goto L7;
            return true;
        }

        private static boolean checkFlag(int r10, int r11) {
            if ((r10 & r11) != r11) goto L5;
            return true;
        L5:
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout r10) {
            int r11 = r10.getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L13;
            View r13 = r10.getChildAt(r12);
            if ((r13 instanceof NestedScrollingChild) == true) goto L12;
            if ((r13 instanceof ListView) == true) goto L12;
            if ((r13 instanceof ScrollView) == true) goto L12;
            r12 = r12 + 1;
        L12:
            return r13;
        L13:
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout r10, int r11) {
            int r12 = Math.abs(r11);
            int r13 = r10.getChildCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L10;
            View r15 = r10.getChildAt(r14);
            if (r12 < r15.getTop()) goto L9;
            if (r12 > r15.getBottom()) goto L9;
            return r15;
        L9:
            r14 = r14 + 1;
            goto L3
        L10:
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T r10, int r11) {
            int r12 = r10.getChildCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L12;
            View r14 = r10.getChildAt(r13);
            int r15 = r14.getTop();
            int r16 = r14.getBottom();
            LayoutParams r17 = (LayoutParams) r14.getLayoutParams();
            if (checkFlag(r17.c(), 32) == false) goto L7;
            r15 = r15 - ((LinearLayout.LayoutParams) r17).topMargin;
            r16 = r16 + ((LinearLayout.LayoutParams) r17).bottomMargin;
        L7:
            int r18 = -r11;
            if (r15 > r18) goto L11;
            if (r16 < r18) goto L11;
            return r13;
        L11:
            r13 = r13 + 1;
            goto L3
        L12:
            return -1;
        }

        private int interpolateOffset(@NonNull T r10, int r11) {
            int r12 = Math.abs(r11);
            int r13 = r10.getChildCount();
            int r14 = 0;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L21;
            View r16 = r10.getChildAt(r15);
            LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
            Interpolator r18 = r17.d();
            if (r12 < r16.getTop()) goto L20;
            if (r12 > r16.getBottom()) goto L20;
            if (r18 == null) goto L21;
            int r19 = r17.c();
            if ((r19 & 1) == 0) goto L15;
            r14 = 0 + ((r16.getHeight() + ((LinearLayout.LayoutParams) r17).topMargin) + ((LinearLayout.LayoutParams) r17).bottomMargin);
            if ((r19 & 2) == 0) goto L15;
            r14 = r14 - ViewCompat.getMinimumHeight(r16);
        L15:
            if (ViewCompat.getFitsSystemWindows(r16) == false) goto L17;
            r14 = r14 - r10.getTopInset();
        L17:
            if (r14 <= 0) goto L21;
            float r20 = r14;
            return Integer.signum(r11) * (r16.getTop() + Math.round(r20 * r18.getInterpolation((r12 - r16.getTop()) / r20)));
        L20:
            r15 = r15 + 1;
        L21:
            return r11;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout r10, @NonNull T r11) {
            List<View> r12 = r10.getDependents(r11);
            int r13 = r12.size();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L11;
            CoordinatorLayout.Behavior r15 = ((CoordinatorLayout.LayoutParams) r12.get(r14).getLayoutParams()).getBehavior();
            if ((r15 instanceof ScrollingViewBehavior) == true) goto L7;
            r14 = r14 + 1;
            goto L3
        L7:
            if (((ScrollingViewBehavior) r15).getOverlayTop() == 0) goto L14;
            return true;
        L14:
            return false;
        L11:
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout r10, @NonNull T r11) {
            int r12 = r11.getTopInset() + r11.getPaddingTop();
            int r13 = getTopBottomOffsetForScrollingSibling() - r12;
            int r14 = getChildIndexOnOffset(r11, r13);
            if (r14 < 0) goto L27;
            View r15 = r11.getChildAt(r14);
            LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
            int r17 = r16.c();
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

        private void updateAccessibilityActions(CoordinatorLayout r10, @NonNull T r11) {
            ViewCompat.removeAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View r12 = findFirstScrollingChild(r10);
            if (r12 != null) goto L5;
            return;
        L5:
            if (r11.getTotalScrollRange() != 0) goto L8;
            return;
        L8:
            if ((((CoordinatorLayout.LayoutParams) r12.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L10;
            return;
        L10:
            addAccessibilityScrollActions(r10, r11, r12);
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, boolean r14) {
            View r15 = getAppBarChildOnOffset(r11, r12);
            boolean r16 = false;
            if (r15 == null) goto L19;
            int r17 = ((LayoutParams) r15.getLayoutParams()).c();
            if ((r17 & 1) == 0) goto L19;
            int r18 = ViewCompat.getMinimumHeight(r15);
            if (r13 <= 0) goto L14;
            if ((r17 & 12) == 0) goto L14;
            if ((-r12) < ((r15.getBottom() - r18) - r11.getTopInset())) goto L19;
        L12:
            r16 = true;
        L14:
            if ((r17 & 2) == 0) goto L19;
            if ((-r12) >= ((r15.getBottom() - r18) - r11.getTopInset())) goto L12;
        L19:
            if (r11.isLiftOnScroll() == false) goto L21;
            r16 = r11.shouldLift(findFirstScrollingChild(r10));
        L21:
            boolean r19 = r11.setLiftedState(r16);
            if (r14 == true) goto L26;
            if (r19 == true) goto L25;
            return;
        L25:
            if (shouldJumpElevationState(r10, r11) == true) goto L26;
            return;
        L26:
            r11.jumpDrawablesToCurrentState();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ boolean canDragView(View r10) {
            return canDragView((AppBarLayout) r10);
        }

        boolean canDragView(T r10) {
            WeakReference<View> r11 = this.lastNestedScrollingChildRef;
            if (r11 == null) goto L13;
            View r12 = r11.get();
            if (r12 != null) goto L7;
        L11:
            return false;
        L7:
            if (r12.isShown() == false) goto L11;
            if (r12.canScrollVertically(-1) == true) goto L11;
            return true;
        L13:
            return true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r10) {
            return getMaxDragOffset((AppBarLayout) r10);
        }

        int getMaxDragOffset(@NonNull T r10) {
            return -r10.getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r10) {
            return getScrollRangeForDragFling((AppBarLayout) r10);
        }

        int getScrollRangeForDragFling(@NonNull T r10) {
            return r10.getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @VisibleForTesting
        boolean isOffsetAnimatorRunning() {
            ValueAnimator r10 = this.offsetAnimator;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.isRunning() == false) goto L7;
            return true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r10, @NonNull View r11) {
            onFlingFinished(r10, (AppBarLayout) r11);
        }

        void onFlingFinished(@NonNull CoordinatorLayout r10, @NonNull T r11) {
            snapToChildIfNeeded(r10, r11);
            if (r11.isLiftOnScroll() == false) goto L6;
            r11.setLiftedState(r11.shouldLift(findFirstScrollingChild(r10)));
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return onLayoutChild(r10, (AppBarLayout) r11, r12);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12) {
            boolean r13 = super.onLayoutChild(r10, r11, r12);
            int r14 = r11.getPendingAction();
            SavedState r15 = this.savedState;
            if (r15 != null) goto L5;
        L18:
            if (r14 != 0) goto L20;
        L32:
            r11.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r11.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(r10, r11, getTopAndBottomOffset(), 0, true);
            r11.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(r10, r11);
            return r13;
        L20:
            if ((r14 & 4) == 0) goto L22;
            boolean r16 = true;
        L24:
            if ((r14 & 2) == 0) goto L29;
            int r17 = -r11.getUpNestedPreScrollRange();
            if (r16 == true) goto L27;
        L9:
            setHeaderTopBottomOffset(r10, r11, r17);
            goto L32
        L27:
            animateOffsetTo(r10, r11, r17, 0.0f);
            goto L32
        L29:
            if ((r14 & 1) == 0) goto L32;
            if (r16 == true) goto L31;
        L12:
            setHeaderTopBottomOffset(r10, r11, 0);
            goto L32
        L31:
            animateOffsetTo(r10, r11, 0, 0.0f);
            goto L32
        L22:
            r16 = false;
            goto L24
        L5:
            if ((r14 & 8) != 0) goto L18;
            if (r15.fullyScrolled == false) goto L11;
            r17 = -r11.getTotalScrollRange();
            goto L9
        L11:
            if (r15.fullyExpanded == true) goto L12;
            View r18 = r11.getChildAt(r15.firstVisibleChildIndex);
            int r19 = -r18.getBottom();
            if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L16;
            int r20 = ViewCompat.getMinimumHeight(r18) + r11.getTopInset();
        L17:
            setHeaderTopBottomOffset(r10, r11, r19 + r20);
            goto L32
        L16:
            r20 = Math.round(r18.getHeight() * this.savedState.firstVisibleChildPercentageShown);
            goto L17
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
            return onMeasureChild(r10, (AppBarLayout) r11, r12, r13, r14, r15);
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14, int r15) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r11.getLayoutParams())).height != (-2)) goto L7;
            r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(0, 0), r15);
            return true;
        L7:
            return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int[] r15, int r16) {
            onNestedPreScroll(r10, (AppBarLayout) r11, r12, r13, r14, r15, r16);
        }

        public void onNestedPreScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int[] r15, int r16) {
            if (r14 == 0) goto L10;
            if (r14 >= 0) goto L5;
            int r17 = -r11.getTotalScrollRange();
            int r18 = r11.getDownNestedPreScrollRange() + r17;
        L6:
            int r19 = r17;
            int r20 = r18;
            if (r19 == r20) goto L10;
            r15[1] = scroll(r10, r11, r14, r19, r20);
            goto L10
        L5:
            r17 = -r11.getUpNestedPreScrollRange();
            r18 = 0;
        L10:
            if (r11.isLiftOnScroll() == false) goto L13;
            r11.setLiftedState(r11.shouldLift(r12));
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int r15, int r16, int r17, int[] r18) {
            onNestedScroll(r10, (AppBarLayout) r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public void onNestedScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int r15, int r16, int r17, int[] r18) {
            if (r16 >= 0) goto L4;
            r18[1] = scroll(r10, r11, r16, -r11.getDownNestedScrollRange(), 0);
        L4:
            if (r16 != 0) goto L7;
            updateAccessibilityActions(r10, r11);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11, Parcelable r12) {
            onRestoreInstanceState(r10, (AppBarLayout) r11, r12);
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull T r11, Parcelable r12) {
            if ((r12 instanceof SavedState) == false) goto L5;
            restoreScrollState((SavedState) r12, true);
            super.onRestoreInstanceState(r10, r11, this.savedState.getSuperState());
            return;
        L5:
            super.onRestoreInstanceState(r10, r11, r12);
            this.savedState = null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11) {
            return onSaveInstanceState(r10, (AppBarLayout) r11);
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull T r11) {
            Parcelable r12 = super.onSaveInstanceState(r10, r11);
            SavedState r13 = saveScrollState(r12, r11);
            if (r13 != null) goto L6;
            return r12;
        L6:
            return r13;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12, View r13, int r14, int r15) {
            return onStartNestedScroll(r10, (AppBarLayout) r11, r12, r13, r14, r15);
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull T r11, @NonNull View r12, View r13, int r14, int r15) {
            if ((r14 & 2) != 0) goto L5;
        L9:
            boolean r16 = false;
        L10:
            if (r16 == false) goto L14;
            ValueAnimator r17 = this.offsetAnimator;
            if (r17 == null) goto L14;
            r17.cancel();
        L14:
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = r15;
            return r16;
        L5:
            if (r11.isLiftOnScroll() == false) goto L7;
        L8:
            r16 = true;
            goto L10
        L7:
            if (canScrollChildren(r10, r11, r12) == false) goto L9;
            goto L8
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13) {
            onStopNestedScroll(r10, (AppBarLayout) r11, r12, r13);
        }

        public void onStopNestedScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13) {
            if (this.lastStartedType != 0) goto L5;
        L6:
            snapToChildIfNeeded(r10, r11);
            if (r11.isLiftOnScroll() == false) goto L9;
            r11.setLiftedState(r11.shouldLift(r12));
        L9:
            this.lastNestedScrollingChildRef = new WeakReference(r12);
            return;
        L5:
            if (r13 != 1) goto L9;
            goto L6
        }

        void restoreScrollState(@Nullable SavedState r10, boolean r11) {
            if (this.savedState == null) goto L5;
            if (r11 == true) goto L5;
            return;
        L5:
            this.savedState = r10;
        }

        @Nullable
        SavedState saveScrollState(@Nullable Parcelable r10, @NonNull T r11) {
            int r12 = getTopAndBottomOffset();
            int r13 = r11.getChildCount();
            boolean r14 = false;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L26;
            View r16 = r11.getChildAt(r15);
            int r17 = r16.getBottom() + r12;
            if ((r16.getTop() + r12) > 0) goto L25;
            if (r17 < 0) goto L25;
            if (r10 != null) goto L10;
            r10 = AbsSavedState.EMPTY_STATE;
        L10:
            SavedState r18 = new SavedState(r10);
            if (r12 != 0) goto L13;
            boolean r19 = true;
        L14:
            r18.fullyExpanded = r19;
            if (r19 == false) goto L17;
        L19:
            boolean r20 = false;
        L20:
            r18.fullyScrolled = r20;
            r18.firstVisibleChildIndex = r15;
            if (r17 != (ViewCompat.getMinimumHeight(r16) + r11.getTopInset())) goto L23;
            r14 = true;
        L23:
            r18.firstVisibleChildAtMinimumHeight = r14;
            r18.firstVisibleChildPercentageShown = r17 / r16.getHeight();
            return r18;
        L17:
            if ((-r12) < r11.getTotalScrollRange()) goto L19;
            r20 = true;
            goto L20
        L13:
            r19 = false;
        L25:
            r15 = r15 + 1;
            goto L3
        L26:
            return null;
        }

        public void setDragCallback(@Nullable b r10) {
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14) {
            return setHeaderTopBottomOffset(r10, (AppBarLayout) r11, r12, r13, r14);
        }

        int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14) {
            int r15 = getTopBottomOffsetForScrollingSibling();
            int r16 = 0;
            if (r13 == 0) goto L30;
            if (r15 < r13) goto L30;
            if (r15 > r14) goto L30;
            int r17 = MathUtils.clamp(r12, r13, r14);
            if (r15 != r17) goto L9;
        L31:
            updateAccessibilityActions(r10, r11);
            return r16;
        L9:
            if (r11.hasChildWithInterpolator() == false) goto L11;
            int r18 = interpolateOffset(r11, r17);
        L12:
            boolean r19 = setTopAndBottomOffset(r18);
            int r110 = r15 - r17;
            this.offsetDelta = r17 - r18;
            int r111 = 1;
            if (r19 == true) goto L15;
        L22:
            if (r19 == false) goto L24;
        L26:
            r11.onOffsetChanged(getTopAndBottomOffset());
            if (r17 >= r15) goto L29;
            r111 = -1;
        L29:
            updateAppBarLayoutDrawableState(r10, r11, r17, r111, false);
            r16 = r110;
            goto L31
        L24:
            if (r11.hasChildWithInterpolator() == false) goto L26;
            r10.dispatchDependentViewsChanged(r11);
        L15:
            if (r16 >= r11.getChildCount()) goto L22;
            LayoutParams r20 = (LayoutParams) r11.getChildAt(r16).getLayoutParams();
            c r21 = r20.b();
            if (r21 == null) goto L21;
            if ((r20.c() & 1) == 0) goto L21;
            r21.a(r11, r11.getChildAt(r16), getTopAndBottomOffset());
        L21:
            r16 = r16 + 1;
            goto L15
        L11:
            r18 = r17;
        L30:
            this.offsetDelta = 0;
            goto L31
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
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
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
            return super.onInterceptTouchEvent(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, int r12) {
            return super.onLayoutChild(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, int r12, int r13, int r14, int r15) {
            return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, @NonNull AppBarLayout r11, View r12, int r13, int r14, int[] r15, int r16) {
            super.onNestedPreScroll(r10, r11, r12, r13, r14, r15, r16);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, @NonNull AppBarLayout r11, View r12, int r13, int r14, int r15, int r16, int r17, int[] r18) {
            super.onNestedScroll(r10, r11, r12, r13, r14, r15, r16, r17, r18);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, Parcelable r12) {
            super.onRestoreInstanceState(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11) {
            return super.onSaveInstanceState(r10, r11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, @NonNull View r12, View r13, int r14, int r15) {
            return super.onStartNestedScroll(r10, r11, r12, r13, r14, r15);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, @NonNull AppBarLayout r11, View r12, int r13) {
            super.onStopNestedScroll(r10, r11, r12, r13);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
            return super.onTouchEvent(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.b r10) {
            super.setDragCallback(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r10) {
            super.setHorizontalOffsetEnabled(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r10) {
            return super.setLeftAndRightOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r10) {
            return super.setTopAndBottomOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r10) {
            super.setVerticalOffsetEnabled(r10);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f2950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Interpolator f2951c;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f2949a = 1;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f2949a = 1;
            TypedArray r12 = r10.obtainStyledAttributes(r11, l.AppBarLayout_Layout);
            this.f2949a = r12.getInt(l.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(a(r12.getInt(l.AppBarLayout_Layout_layout_scrollEffect, 0)));
            int r13 = l.AppBarLayout_Layout_layout_scrollInterpolator;
            if (r12.hasValue(r13) == false) goto L5;
            this.f2951c = AnimationUtils.loadInterpolator(r10, r12.getResourceId(r13, 0));
        L5:
            r12.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f2949a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.f2949a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams r10) {
            super(r10);
            this.f2949a = 1;
        }

        @Nullable
        private c a(int r10) {
            if (r10 == 1) goto L7;
            return null;
        L7:
            return new d();
        }

        @Nullable
        public c b() {
            return this.f2950b;
        }

        public int c() {
            return this.f2949a;
        }

        public Interpolator d() {
            return this.f2951c;
        }

        boolean e() {
            int r10 = this.f2949a;
            if ((r10 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r10 & 10) == 0) goto L7;
            return true;
        }

        public void f(@Nullable c r10) {
            this.f2950b = r10;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context r10, AttributeSet r11) {
            super(r10, r11);
            TypedArray r12 = r10.obtainStyledAttributes(r11, l.ScrollingViewBehavior_Layout);
            setOverlayTop(r12.getDimensionPixelSize(l.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            r12.recycle();
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout r10) {
            CoordinatorLayout.Behavior r11 = ((CoordinatorLayout.LayoutParams) r10.getLayoutParams()).getBehavior();
            if ((r11 instanceof BaseBehavior) == true) goto L5;
            return 0;
        L5:
            return ((BaseBehavior) r11).getTopBottomOffsetForScrollingSibling();
        }

        private void offsetChildAsNeeded(@NonNull View r10, @NonNull View r11) {
            CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.LayoutParams) r11.getLayoutParams()).getBehavior();
            if ((r12 instanceof BaseBehavior) == false) goto L6;
            ViewCompat.offsetTopAndBottom(r10, (((r11.getBottom() - r10.getTop()) + BaseBehavior.access$200((BaseBehavior) r12)) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r11));
            return;
        }

        private void updateLiftedStateIfNeeded(View r10, View r11) {
            if ((r11 instanceof AppBarLayout) == false) goto L8;
            AppBarLayout r12 = (AppBarLayout) r11;
            if (r12.isLiftOnScroll() == false) goto L9;
            r12.setLiftedState(r12.shouldLift(r10));
            return;
        L9:
            return;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List r10) {
            return findFirstDependency(r10);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        AppBarLayout findFirstDependency(@NonNull List<View> r10) {
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            View r13 = r10.get(r12);
            if ((r13 instanceof AppBarLayout) == true) goto L7;
            r12 = r12 + 1;
            goto L3
        L7:
            return (AppBarLayout) r13;
        L9:
            return null;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View r10) {
            if ((r10 instanceof AppBarLayout) == false) goto L13;
            AppBarLayout r11 = (AppBarLayout) r10;
            int r12 = r11.getTotalScrollRange();
            int r13 = r11.getDownNestedPreScrollRange();
            int r14 = getAppBarLayoutOffset(r11);
            if (r13 != 0) goto L7;
        L9:
            int r15 = r12 - r13;
            if (r15 == 0) goto L13;
            return (r14 / r15) + 1.0f;
        L7:
            if ((r12 + r14) > r13) goto L9;
            return 0.0f;
        L13:
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(View r10) {
            if ((r10 instanceof AppBarLayout) == false) goto L7;
            return ((AppBarLayout) r10).getTotalScrollRange();
        L7:
            return super.getScrollRange(r10);
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
        public boolean layoutDependsOn(CoordinatorLayout r10, View r11, View r12) {
            return r12 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12) {
            offsetChildAsNeeded(r11, r12);
            updateLiftedStateIfNeeded(r11, r12);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12) {
            if ((r12 instanceof AppBarLayout) == false) goto L6;
            ViewCompat.removeAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return super.onLayoutChild(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
            return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull Rect r12, boolean r13) {
            AppBarLayout r14 = findFirstDependency(r10.getDependencies(r11));
            if (r14 == null) goto L8;
            r12.offset(r11.getLeft(), r11.getTop());
            Rect r15 = this.tempRect1;
            r15.set(0, 0, r10.getWidth(), r10.getHeight());
            if (r15.contains(r12) == true) goto L8;
            r14.setExpanded(false, !r13);
            return true;
        L8:
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r10) {
            super.setHorizontalOffsetEnabled(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r10) {
            return super.setLeftAndRightOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r10) {
            return super.setTopAndBottomOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r10) {
            super.setVerticalOffsetEnabled(r10);
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialShapeDrawable f2952c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AppBarLayout f2953g;

        a(AppBarLayout r10, MaterialShapeDrawable r11) {
            this.f2953g = r10;
            this.f2952c = r11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f2952c.setElevation(r11);
            if ((AppBarLayout.access$000(this.f2953g) instanceof MaterialShapeDrawable) == false) goto L5;
            ((MaterialShapeDrawable) AppBarLayout.access$000(this.f2953g)).setElevation(r11);
        L5:
            Iterator r12 = AppBarLayout.access$100(this.f2953g).iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            ((e) r12.next()).a(r11, this.f2952c.getResolvedTintColor());
            goto L7
        }
    }

    public interface b<T extends AppBarLayout> {
        void a(T r10, int r11);
    }

    public static abstract class c {
        public c() {
        }

        public abstract void a(@NonNull AppBarLayout r10, @NonNull View r11, float r12);
    }

    public static class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f2954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f2955b;

        public d() {
            this.f2954a = new Rect();
            this.f2955b = new Rect();
        }

        private static void b(Rect r10, AppBarLayout r11, View r12) {
            r12.getDrawingRect(r10);
            r11.offsetDescendantRectToMyCoords(r12, r10);
            r10.offset(0, -r11.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(@NonNull AppBarLayout r10, @NonNull View r11, float r12) {
            b(this.f2954a, r10, r11);
            float r13 = this.f2954a.top - Math.abs(r12);
            if (r13 > 0.0f) goto L5;
            float r14 = 1.0f - MathUtils.clamp(Math.abs(r13 / this.f2954a.height()), 0.0f, 1.0f);
            float r15 = (-r13) - ((this.f2954a.height() * 0.3f) * (1.0f - (r14 * r14)));
            r11.setTranslationY(r15);
            r11.getDrawingRect(this.f2955b);
            this.f2955b.offset(0, (int) (-r15));
            ViewCompat.setClipBounds(r11, this.f2955b);
            return;
        L5:
            ViewCompat.setClipBounds(r11, null);
            r11.setTranslationY(0.0f);
        }
    }

    public interface e {
        void a(@Dimension float r10, @ColorInt int r11);
    }

    public interface f extends b<AppBarLayout> {
    }

    static {
        DEF_STYLE_RES = k.Widget_Design_AppBarLayout;
    }

    public AppBarLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public AppBarLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.appBarLayoutStyle);
    }

    public AppBarLayout(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(b6.a.c(r11, r12, r13, r10), r12, r13);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        this.liftOnScrollListeners = new ArrayList();
        Context r14 = getContext();
        setOrientation(1);
        int r15 = Build.VERSION.SDK_INT;
        if (r15 >= 21) goto L5;
    L8:
        TypedArray r16 = com.google.android.material.internal.k.h(r14, r12, l.AppBarLayout, r13, r10, new int[0]);
        ViewCompat.setBackground(this, r16.getDrawable(l.AppBarLayout_android_background));
        if ((getBackground() instanceof ColorDrawable) == false) goto L11;
        ColorDrawable r17 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r18 = new MaterialShapeDrawable();
        r18.setFillColor(ColorStateList.valueOf(r17.getColor()));
        r18.initializeElevationOverlay(r14);
        ViewCompat.setBackground(this, r18);
    L11:
        int r19 = l.AppBarLayout_expanded;
        if (r16.hasValue(r19) == false) goto L14;
        setExpanded(r16.getBoolean(r19, false), false, false);
    L14:
        if (r15 < 21) goto L19;
        int r110 = l.AppBarLayout_elevation;
        if (r16.hasValue(r110) == false) goto L19;
        com.google.android.material.appbar.b.b(this, r16.getDimensionPixelSize(r110, 0));
    L19:
        if (r15 < 26) goto L26;
        int r111 = l.AppBarLayout_android_keyboardNavigationCluster;
        if (r16.hasValue(r111) == false) goto L23;
        setKeyboardNavigationCluster(r16.getBoolean(r111, false));
    L23:
        int r112 = l.AppBarLayout_android_touchscreenBlocksFocus;
        if (r16.hasValue(r112) == false) goto L26;
        setTouchscreenBlocksFocus(r16.getBoolean(r112, false));
    L26:
        this.liftOnScroll = r16.getBoolean(l.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = r16.getResourceId(l.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(r16.getDrawable(l.AppBarLayout_statusBarForeground));
        r16.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
        return;
    L5:
        if (getOutlineProvider() != ViewOutlineProvider.BACKGROUND) goto L7;
        com.google.android.material.appbar.b.a(this);
    L7:
        com.google.android.material.appbar.b.c(this, r12, r13, r10);
        goto L8
    }

    static /* synthetic */ Drawable access$000(AppBarLayout r10) {
        return r10.statusBarForeground;
    }

    static /* synthetic */ List access$100(AppBarLayout r10) {
        return r10.liftOnScrollListeners;
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> r10 = this.liftOnScrollTargetView;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View r10) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r11 = this.liftOnScrollTargetViewId;
        if (r11 == (-1)) goto L15;
        if (r10 == null) goto L8;
        View r12 = r10.findViewById(r11);
    L9:
        if (r12 == null) goto L11;
    L13:
        if (r12 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r12);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        r12 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r12 = null;
    L15:
        WeakReference<View> r13 = this.liftOnScrollTargetView;
        if (r13 != null) goto L18;
        return null;
    L18:
        return r13.get();
    }

    private boolean hasCollapsibleChild() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (((LayoutParams) getChildAt(r11).getLayoutParams()).e() == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void invalidateScrollRanges() {
        Behavior r10 = this.behavior;
        if (r10 != null) goto L5;
    L10:
        BaseBehavior.SavedState r11 = null;
    L11:
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (r11 == null) goto L15;
        this.behavior.restoreScrollState(r11, false);
        return;
    L15:
        return;
    L5:
        if (this.totalScrollRange == (-1)) goto L10;
        if (this.pendingAction != 0) goto L10;
        r11 = r10.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        goto L11
    }

    private void setExpanded(boolean r10, boolean r11, boolean r12) {
        if (r10 == false) goto L4;
        int r13 = 1;
    L5:
        int r14 = 0;
        if (r11 == false) goto L8;
        int r15 = 4;
    L9:
        int r16 = r13 | r15;
        if (r12 == false) goto L12;
        r14 = 8;
    L12:
        this.pendingAction = r16 | r14;
        requestLayout();
        return;
    L8:
        r15 = 0;
        goto L9
    L4:
        r13 = 2;
        goto L5
    }

    private boolean setLiftableState(boolean r10) {
        if (this.liftable == r10) goto L6;
        this.liftable = r10;
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
        View r10 = getChildAt(0);
        if (r10.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private void startLiftOnScrollElevationOverlayAnimation(@NonNull MaterialShapeDrawable r10, boolean r11) {
        float r12 = getResources().getDimension(q5.d.design_appbar_elevation);
        if (r11 == false) goto L5;
        float r13 = 0.0f;
    L6:
        if (r11 == true) goto L9;
        r12 = 0.0f;
    L9:
        ValueAnimator r14 = this.elevationOverlayAnimator;
        if (r14 == null) goto L12;
        r14.cancel();
    L12:
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{r13, r12});
        this.elevationOverlayAnimator = r15;
        r15.setDuration(getResources().getInteger(g.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(r5.a.f12673a);
        this.elevationOverlayAnimator.addUpdateListener(new a(this, r10));
        this.elevationOverlayAnimator.start();
        return;
    L5:
        r13 = r12;
        goto L6
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addLiftOnScrollListener(@NonNull e r10) {
        this.liftOnScrollListeners.add(r10);
    }

    public void addOnOffsetChangedListener(@Nullable b r10) {
        if (this.listeners != null) goto L5;
        this.listeners = new ArrayList();
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (this.listeners.contains(r10) == true) goto L11;
        this.listeners.add(r10);
        return;
    }

    public void addOnOffsetChangedListener(f r10) {
        addOnOffsetChangedListener(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        if (shouldDrawStatusBarForeground() == false) goto L6;
        int r11 = r10.save();
        r10.translate(0.0f, -this.currentOffset);
        this.statusBarForeground.draw(r10);
        r10.restoreToCount(r11);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.statusBarForeground;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isStateful() == true) goto L7;
        return;
    L7:
        if (r11.setState(r10) == false) goto L12;
        invalidateDrawable(r11);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if ((r10 instanceof LinearLayout.LayoutParams) == false) goto L9;
        return new LayoutParams((LinearLayout.LayoutParams) r10);
    L9:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L13:
        return new LayoutParams(r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior r10 = new Behavior();
        this.behavior = r10;
        return r10;
    }

    int getDownNestedPreScrollRange() {
        int r10 = this.downPreScrollRange;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = getChildCount() - 1;
        int r12 = 0;
    L6:
        if (r11 < 0) goto L25;
        View r13 = getChildAt(r11);
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        int r15 = r13.getMeasuredHeight();
        int r16 = r14.f2949a;
        if ((r16 & 5) != 5) goto L22;
        int r17 = ((LinearLayout.LayoutParams) r14).topMargin + ((LinearLayout.LayoutParams) r14).bottomMargin;
        if ((r16 & 8) == 0) goto L14;
        int r18 = ViewCompat.getMinimumHeight(r13);
    L12:
        int r19 = r17 + r18;
    L17:
        if (r11 == 0) goto L19;
    L21:
        r12 = r12 + r19;
    L24:
        r11 = r11 - 1;
        goto L6
    L19:
        if (ViewCompat.getFitsSystemWindows(r13) == false) goto L21;
        r19 = Math.min(r19, r15 - getTopInset());
        goto L21
    L14:
        if ((r16 & 2) == 0) goto L16;
        r18 = r15 - ViewCompat.getMinimumHeight(r13);
        goto L12
    L16:
        r19 = r17 + r15;
        goto L17
    L22:
        if (r12 <= 0) goto L24;
    L25:
        int r20 = Math.max(0, r12);
        this.downPreScrollRange = r20;
        return r20;
    }

    int getDownNestedScrollRange() {
        int r10 = this.downScrollRange;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = getChildCount();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r12 >= r11) goto L13;
        View r14 = getChildAt(r12);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        int r16 = r14.getMeasuredHeight() + (((LinearLayout.LayoutParams) r15).topMargin + ((LinearLayout.LayoutParams) r15).bottomMargin);
        int r17 = r15.f2949a;
        if ((r17 & 1) == 0) goto L13;
        r13 = r13 + r16;
        if ((r17 & 2) != 0) goto L11;
        r12 = r12 + 1;
        goto L6
    L11:
        r13 = r13 - ViewCompat.getMinimumHeight(r14);
    L13:
        int r18 = Math.max(0, r13);
        this.downScrollRange = r18;
        return r18;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r10 = getTopInset();
        int r11 = ViewCompat.getMinimumHeight(this);
        if (r11 != 0) goto L5;
        int r12 = getChildCount();
        if (r12 < 1) goto L9;
        r11 = ViewCompat.getMinimumHeight(getChildAt(r12 - 1));
    L10:
        if (r11 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r11 = 0;
    L5:
        return (r11 * 2) + r10;
    }

    int getPendingAction() {
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
    final int getTopInset() {
        WindowInsetsCompat r10 = this.lastInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getSystemWindowInsetTop();
    }

    public final int getTotalScrollRange() {
        int r10 = this.totalScrollRange;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = getChildCount();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r12 >= r11) goto L18;
        View r14 = getChildAt(r12);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        int r16 = r14.getMeasuredHeight();
        int r17 = r15.f2949a;
        if ((r17 & 1) == 0) goto L18;
        r13 = r13 + ((r16 + ((LinearLayout.LayoutParams) r15).topMargin) + ((LinearLayout.LayoutParams) r15).bottomMargin);
        if (r12 != 0) goto L15;
        if (ViewCompat.getFitsSystemWindows(r14) == false) goto L15;
        r13 = r13 - getTopInset();
    L15:
        if ((r17 & 2) != 0) goto L16;
        r12 = r12 + 1;
        goto L6
    L16:
        r13 = r13 - ViewCompat.getMinimumHeight(r14);
    L18:
        int r18 = Math.max(0, r13);
        this.totalScrollRange = r18;
        return r18;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    boolean hasScrollableChildren() {
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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int r10) {
        if (this.tmpStatesArray != null) goto L5;
        this.tmpStatesArray = new int[4];
    L5:
        int[] r11 = this.tmpStatesArray;
        int[] r12 = super.onCreateDrawableState(r10 + r11.length);
        boolean r13 = this.liftable;
        int r14 = q5.b.state_liftable;
        if (r13 == true) goto L9;
        r14 = -r14;
    L9:
        r11[0] = r14;
        if (r13 == true) goto L12;
    L14:
        int r15 = -q5.b.state_lifted;
    L15:
        r11[1] = r15;
        int r16 = q5.b.state_collapsible;
        if (r13 == true) goto L19;
        r16 = -r16;
    L19:
        r11[2] = r16;
        if (r13 == true) goto L22;
    L24:
        int r17 = -q5.b.state_collapsed;
    L25:
        r11[3] = r17;
        return LinearLayout.mergeDrawableStates(r12, r11);
    L22:
        if (this.lifted == false) goto L24;
        r17 = q5.b.state_collapsed;
        goto L25
    L12:
        if (this.lifted == false) goto L14;
        r15 = q5.b.state_lifted;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        boolean r15 = true;
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L9:
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int r16 = getChildCount();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L15;
        if (((LayoutParams) getChildAt(r17).getLayoutParams()).d() != null) goto L13;
        r17 = r17 + 1;
        goto L10
    L13:
        this.haveChildWithInterpolator = true;
    L15:
        Drawable r18 = this.statusBarForeground;
        if (r18 == null) goto L19;
        r18.setBounds(0, 0, getWidth(), getTopInset());
    L19:
        if (this.liftableOverride == false) goto L21;
        return;
    L21:
        if (this.liftOnScroll == false) goto L23;
    L26:
        setLiftableState(r15);
        return;
    L23:
        if (hasCollapsibleChild() == true) goto L26;
        r15 = false;
        goto L26
    L5:
        if (shouldOffsetFirstChild() == false) goto L9;
        int r19 = getTopInset();
        int r20 = getChildCount() - 1;
    L7:
        if (r20 < 0) goto L9;
        ViewCompat.offsetTopAndBottom(getChildAt(r20), r19);
        r20 = r20 - 1;
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r11);
        if (r12 != 1073741824) goto L5;
    L15:
        invalidateScrollRanges();
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L15;
        if (shouldOffsetFirstChild() == false) goto L15;
        int r13 = getMeasuredHeight();
        if (r12 == Integer.MIN_VALUE) goto L13;
        if (r12 != 0) goto L14;
        r13 = r13 + getTopInset();
    L14:
        setMeasuredDimension(getMeasuredWidth(), r13);
        goto L15
    L13:
        r13 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(r11));
        goto L14
    }

    void onOffsetChanged(int r10) {
        this.currentOffset = r10;
        if (willNotDraw() == true) goto L5;
        ViewCompat.postInvalidateOnAnimation(this);
    L5:
        List<b> r11 = this.listeners;
        if (r11 == null) goto L13;
        int r12 = 0;
        int r13 = r11.size();
    L8:
        if (r12 >= r13) goto L17;
        b r14 = this.listeners.get(r12);
        if (r14 == null) goto L12;
        r14.a(this, r10);
    L12:
        r12 = r12 + 1;
        goto L8
    L17:
        return;
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r10) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r11 = r10;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r11) == true) goto L9;
        this.lastInsets = r11;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r10;
    L5:
        r11 = null;
        goto L7
    }

    public boolean removeLiftOnScrollListener(@NonNull e r10) {
        return this.liftOnScrollListeners.remove(r10);
    }

    public void removeOnOffsetChangedListener(@Nullable b r10) {
        List<b> r11 = this.listeners;
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.remove(r10);
        return;
    L8:
        return;
    }

    public void removeOnOffsetChangedListener(f r10) {
        removeOnOffsetChangedListener(r10);
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        h.d(this, r10);
    }

    public void setExpanded(boolean r10) {
        setExpanded(r10, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean r10, boolean r11) {
        setExpanded(r10, r11, true);
    }

    public void setLiftOnScroll(boolean r10) {
        this.liftOnScroll = r10;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int r10) {
        this.liftOnScrollTargetViewId = r10;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean r10) {
        this.liftableOverride = true;
        return setLiftableState(r10);
    }

    public void setLiftableOverrideEnabled(boolean r10) {
        this.liftableOverride = r10;
    }

    public boolean setLifted(boolean r10) {
        return setLiftedState(r10, true);
    }

    boolean setLiftedState(boolean r10) {
        return setLiftedState(r10, !this.liftableOverride);
    }

    boolean setLiftedState(boolean r10, boolean r11) {
        if (r11 == true) goto L4;
        return false;
    L4:
        if (this.lifted == r10) goto L16;
        this.lifted = r10;
        refreshDrawableState();
        if (this.liftOnScroll == true) goto L8;
        return true;
    L8:
        if ((getBackground() instanceof MaterialShapeDrawable) == false) goto L15;
        startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable) getBackground(), r10);
        return true;
    L15:
        return true;
    L16:
        return false;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r10) {
        if (r10 != 1) goto L7;
        super.setOrientation(r10);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable r10) {
        Drawable r11 = this.statusBarForeground;
        if (r11 == r10) goto L21;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.statusBarForeground = r12;
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

    public void setStatusBarForegroundColor(@ColorInt int r10) {
        setStatusBarForeground(new ColorDrawable(r10));
    }

    public void setStatusBarForegroundResource(@DrawableRes int r10) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), r10));
    }

    @Deprecated
    public void setTargetElevation(float r10) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        com.google.android.material.appbar.b.b(this, r10);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.statusBarForeground;
        if (r12 == null) goto L10;
        r12.setVisible(r11, false);
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    boolean shouldLift(@Nullable View r10) {
        View r11 = findLiftOnScrollTargetView(r10);
        if (r11 == null) goto L6;
        r10 = r11;
    L6:
        if (r10 != null) goto L8;
    L12:
        return false;
    L8:
        if (r10.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r10.getScrollY() <= 0) goto L12;
        goto L11
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10 == this.statusBarForeground) goto L8;
        return false;
    }
}
