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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.k;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private final List<d> liftOnScrollListeners;
    private WeakReference<View> liftOnScrollTargetView;
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<a> listeners;
    private int pendingAction;
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private boolean coordinatorLayoutA11yScrollable;
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private a onDragCallback;
        private SavedState savedState;

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            static {
                CREATOR = new AnonymousClass1();
            }

            public SavedState(Parcel r3, ClassLoader r4) {
                super(r3, r4);
                boolean r0 = true;
                if (r3.readByte() == 0) goto L5;
                boolean r5 = true;
            L6:
                this.fullyScrolled = r5;
                if (r3.readByte() == 0) goto L9;
                boolean r6 = true;
            L10:
                this.fullyExpanded = r6;
                this.firstVisibleChildIndex = r3.readInt();
                this.firstVisibleChildPercentageShown = r3.readFloat();
                if (r3.readByte() != 0) goto L14;
                r0 = false;
            L14:
                this.firstVisibleChildAtMinimumHeight = r0;
                return;
            L9:
                r6 = false;
                goto L10
            L5:
                r5 = false;
                goto L6
            }

            public SavedState(Parcelable r3) {
                super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel r1, int r2) {
                super.writeToParcel(r1, r2);
                r1.writeByte(this.fullyScrolled ? 1 : 0);
                r1.writeByte(this.fullyExpanded ? 1 : 0);
                r1.writeInt(this.firstVisibleChildIndex);
                r1.writeFloat(this.firstVisibleChildPercentageShown);
                r1.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
            }
        }

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T r1);
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ boolean access$200(BaseBehavior r0) {
            return r0.coordinatorLayoutA11yScrollable;
        }

        static /* synthetic */ int access$300(BaseBehavior r0) {
            return r0.offsetDelta;
        }

        private boolean addAccessibilityScrollActions(final CoordinatorLayout r11, final T r12, final View r13) {
            boolean r2 = false;
            if (getTopBottomOffsetForScrollingSibling() == (-r12.getTotalScrollRange())) goto L6;
            addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            r2 = true;
        L6:
            if (getTopBottomOffsetForScrollingSibling() == 0) goto L14;
            if (r13.canScrollVertically(-1) == false) goto L12;
            final int r9 = -r12.getDownNestedPreScrollRange();
            if (r9 == 0) goto L14;
            ViewCompat.replaceAccessibilityAction(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass3(this, r11, r12, r13, r9));
            return true;
        L12:
            addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            return true;
        L14:
            return r2;
        }

        private void addActionToExpand(CoordinatorLayout r2, final T r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat r4, final boolean r5) {
            ViewCompat.replaceAccessibilityAction(r2, r4, null, new AnonymousClass4(this, r3, r5));
        }

        private void animateOffsetTo(CoordinatorLayout r3, T r4, int r5, float r6) {
            int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
            float r7 = Math.abs(r6);
            if (r7 <= 0.0f) goto L5;
            int r8 = Math.round((r0 / r7) * 1000.0f) * 3;
        L6:
            animateOffsetWithDuration(r3, r4, r5, r8);
            return;
        L5:
            r8 = (int) (((r0 / r4.getHeight()) + 1.0f) * 150.0f);
            goto L6
        }

        private void animateOffsetWithDuration(final CoordinatorLayout r4, final T r5, int r6, int r7) {
            int r0 = getTopBottomOffsetForScrollingSibling();
            if (r0 != r6) goto L10;
            ValueAnimator r8 = this.offsetAnimator;
            if (r8 != null) goto L7;
            return;
        L7:
            if (r8.isRunning() == false) goto L17;
            this.offsetAnimator.cancel();
            return;
        L17:
            return;
        L10:
            ValueAnimator r1 = this.offsetAnimator;
            if (r1 != null) goto L13;
            ValueAnimator r2 = new ValueAnimator();
            this.offsetAnimator = r2;
            r2.setInterpolator(com.google.android.material.a.a.e);
            this.offsetAnimator.addUpdateListener(new AnonymousClass1(this, r4, r5));
        L14:
            this.offsetAnimator.setDuration(Math.min(r7, 600));
            this.offsetAnimator.setIntValues(new int[]{r0, r6});
            this.offsetAnimator.start();
            return;
        L13:
            r1.cancel();
            goto L14
        }

        private int calculateSnapOffset(int r1, int r2, int r3) {
            if (r1 >= ((r2 + r3) / 2)) goto L6;
            return r2;
        L6:
            return r3;
        }

        private boolean canScrollChildren(CoordinatorLayout r1, T r2, View r3) {
            if (r2.hasScrollableChildren() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L7;
            return true;
        }

        private static boolean checkFlag(int r0, int r1) {
            if ((r0 & r1) != r1) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean childrenHaveScrollFlags(AppBarLayout r6) {
            int r5 = r6.getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r5) goto L9;
            if (((LayoutParams) ZeusTransformUtils.preCheckCast(r6.getChildAt(r1).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).f3760a != 0) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        private View findFirstScrollingChild(CoordinatorLayout r4) {
            int r3 = r4.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L13;
            View r1 = r4.getChildAt(r0);
            if (ZeusTransformUtils.instanceOf(r1, NestedScrollingChild.class) == true) goto L12;
            if (ZeusTransformUtils.instanceOf(r1, ListView.class) == true) goto L12;
            if (ZeusTransformUtils.instanceOf(r1, ScrollView.class) == true) goto L12;
            r0 = r0 + 1;
        L12:
            return r1;
        L13:
            return null;
        }

        private static View getAppBarChildOnOffset(AppBarLayout r4, int r5) {
            int r6 = Math.abs(r5);
            int r0 = r4.getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            View r2 = r4.getChildAt(r1);
            if (r6 < r2.getTop()) goto L9;
            if (r6 > r2.getBottom()) goto L9;
            return r2;
        L9:
            r1 = r1 + 1;
            goto L3
        L10:
            return null;
        }

        private int getChildIndexOnOffset(T r7, int r8) {
            int r6 = r7.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L12;
            View r1 = r7.getChildAt(r0);
            int r2 = r1.getTop();
            int r3 = r1.getBottom();
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            if (checkFlag(r4.a(), 32) == false) goto L7;
            r2 = r2 - r4.topMargin;
            r3 = r3 + r4.bottomMargin;
        L7:
            int r5 = -r8;
            if (r2 > r5) goto L11;
            if (r3 < r5) goto L11;
            return r0;
        L11:
            r0 = r0 + 1;
            goto L3
        L12:
            return -1;
        }

        private View getChildWithScrollingBehavior(CoordinatorLayout r6) {
            int r5 = r6.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L8;
            View r1 = r6.getChildAt(r0);
            if (ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior(), ScrollingViewBehavior.class) == true) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L8:
            return null;
        }

        private int interpolateOffset(T r8, int r9) {
            int r7 = Math.abs(r9);
            int r0 = r8.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L21;
            View r3 = r8.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            Interpolator r5 = r4.c();
            if (r7 < r3.getTop()) goto L20;
            if (r7 > r3.getBottom()) goto L20;
            if (r5 == null) goto L21;
            int r6 = r4.a();
            if ((r6 & 1) == 0) goto L15;
            r1 = 0 + ((r3.getHeight() + r4.topMargin) + r4.bottomMargin);
            if ((r6 & 2) == 0) goto L15;
            r1 = r1 - ViewCompat.getMinimumHeight(r3);
        L15:
            if (ViewCompat.getFitsSystemWindows(r3) == false) goto L17;
            r1 = r1 - r8.getTopInset();
        L17:
            if (r1 <= 0) goto L21;
            float r10 = r1;
            return Integer.signum(r9) * (r3.getTop() + Math.round(r10 * r5.getInterpolation((r7 - r3.getTop()) / r10)));
        L20:
            r2 = r2 + 1;
        L21:
            return r9;
        }

        private boolean shouldJumpElevationState(CoordinatorLayout r5, T r6) {
            List<View> r4 = r5.getDependents(r6);
            int r7 = r4.size();
            int r0 = 0;
        L3:
            if (r0 >= r7) goto L11;
            CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(((View) ZeusTransformUtils.preCheckCast(r4.get(r0), View.class, "com.obric.memorydata.plugin")).getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
            if (ZeusTransformUtils.instanceOf(r1, ScrollingViewBehavior.class) == true) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            if (((ScrollingViewBehavior) ZeusTransformUtils.preCheckCast(r1, ScrollingViewBehavior.class, "com.obric.memorydata.plugin")).getOverlayTop() == 0) goto L14;
            return true;
        L14:
            return false;
        L11:
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout r9, T r10) {
            int r0 = r10.getTopInset() + r10.getPaddingTop();
            int r1 = getTopBottomOffsetForScrollingSibling() - r0;
            int r2 = getChildIndexOnOffset(r10, r1);
            if (r2 < 0) goto L27;
            View r3 = r10.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            int r5 = r4.a();
            if ((r5 & 17) != 17) goto L28;
            int r6 = -r3.getTop();
            int r7 = -r3.getBottom();
            if (r2 != 0) goto L14;
            if (ViewCompat.getFitsSystemWindows(r10) == false) goto L14;
            if (ViewCompat.getFitsSystemWindows(r3) == false) goto L14;
            r6 = r6 - r10.getTopInset();
        L14:
            if (checkFlag(r5, 2) == false) goto L17;
            r7 = r7 + ViewCompat.getMinimumHeight(r3);
        L23:
            if (checkFlag(r5, 32) == false) goto L25;
            r6 = r6 + r4.topMargin;
            r7 = r7 - r4.bottomMargin;
        L25:
            animateOffsetTo(r9, r10, MathUtils.clamp(calculateSnapOffset(r1, r7, r6) + r0, -r10.getTotalScrollRange(), 0), 0.0f);
            return;
        L17:
            if (checkFlag(r5, 5) == false) goto L23;
            int r8 = ViewCompat.getMinimumHeight(r3) + r7;
            if (r1 >= r8) goto L21;
            r6 = r8;
            goto L23
        L21:
            r7 = r8;
            goto L23
        L28:
            return;
        }

        private void updateAccessibilityActions(CoordinatorLayout r3, T r4) {
            ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            if (r4.getTotalScrollRange() != 0) goto L5;
            return;
        L5:
            View r0 = getChildWithScrollingBehavior(r3);
            if (r0 != null) goto L9;
            return;
        L9:
            if (childrenHaveScrollFlags(r4) == true) goto L12;
            return;
        L12:
            if (ViewCompat.hasAccessibilityDelegate(r3) == true) goto L14;
            ViewCompat.setAccessibilityDelegate(r3, new AnonymousClass2(this));
        L14:
            this.coordinatorLayoutA11yScrollable = addAccessibilityScrollActions(r3, r4, r0);
        }

        private void updateAppBarLayoutDrawableState(CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            View r0 = getAppBarChildOnOffset(r7, r8);
            boolean r1 = false;
            if (r0 == null) goto L19;
            int r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).a();
            if ((r2 & 1) == 0) goto L19;
            int r3 = ViewCompat.getMinimumHeight(r0);
            if (r9 <= 0) goto L14;
            if ((r2 & 12) == 0) goto L14;
            if ((-r8) < ((r0.getBottom() - r3) - r7.getTopInset())) goto L19;
        L12:
            r1 = true;
        L14:
            if ((r2 & 2) == 0) goto L19;
            if ((-r8) >= ((r0.getBottom() - r3) - r7.getTopInset())) goto L12;
        L19:
            if (r7.isLiftOnScroll() == false) goto L21;
            r1 = r7.shouldLift(findFirstScrollingChild(r6));
        L21:
            boolean r11 = r7.setLiftedState(r1);
            if (r10 == true) goto L26;
            if (r11 == true) goto L25;
            return;
        L25:
            if (shouldJumpElevationState(r6, r7) == true) goto L26;
            return;
        L26:
            r7.jumpDrawablesToCurrentState();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* synthetic */ boolean canDragView(View r3) {
            return canDragView((AppBarLayout) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.class, "com.obric.memorydata.plugin"));
        }

        boolean canDragView(T r3) {
            a r0 = this.onDragCallback;
            if (r0 != null) goto L5;
            WeakReference<View> r2 = this.lastNestedScrollingChildRef;
            if (r2 == null) goto L17;
            View r4 = (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L11;
        L15:
            return false;
        L11:
            if (r4.isShown() == false) goto L15;
            if (r4.canScrollVertically(-1) == true) goto L15;
            return true;
        L17:
            return true;
        L5:
            return r0.a(r3);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* synthetic */ int getMaxDragOffset(View r3) {
            return getMaxDragOffset((AppBarLayout) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.class, "com.obric.memorydata.plugin"));
        }

        int getMaxDragOffset(T r1) {
            return -r1.getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* synthetic */ int getScrollRangeForDragFling(View r3) {
            return getScrollRangeForDragFling((AppBarLayout) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.class, "com.obric.memorydata.plugin"));
        }

        int getScrollRangeForDragFling(T r1) {
            return r1.getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        boolean isOffsetAnimatorRunning() {
            ValueAnimator r0 = this.offsetAnimator;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isRunning() == false) goto L7;
            return true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* synthetic */ void onFlingFinished(CoordinatorLayout r3, View r4) {
            onFlingFinished(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r4, AppBarLayout.class, "com.obric.memorydata.plugin"));
        }

        void onFlingFinished(CoordinatorLayout r2, T r3) {
            snapToChildIfNeeded(r2, r3);
            if (r3.isLiftOnScroll() == false) goto L6;
            r3.setLiftedState(r3.shouldLift(findFirstScrollingChild(r2)));
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onLayoutChild(CoordinatorLayout r3, View r4, int r5) {
            return onLayoutChild(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r4, AppBarLayout.class, "com.obric.memorydata.plugin"), r5);
        }

        public boolean onLayoutChild(CoordinatorLayout r8, T r9, int r10) {
            boolean r11 = super.onLayoutChild(r8, r9, r10);
            int r0 = r9.getPendingAction();
            SavedState r1 = this.savedState;
            if (r1 != null) goto L5;
        L18:
            if (r0 != 0) goto L20;
        L32:
            r9.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r9.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(r8, r9, getTopAndBottomOffset(), 0, true);
            r9.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(r8, r9);
            return r11;
        L20:
            if ((r0 & 4) == 0) goto L22;
            boolean r2 = true;
        L24:
            if ((r0 & 2) == 0) goto L29;
            int r3 = -r9.getUpNestedPreScrollRange();
            if (r2 == true) goto L27;
        L9:
            setHeaderTopBottomOffset(r8, r9, r3);
            goto L32
        L27:
            animateOffsetTo(r8, r9, r3, 0.0f);
            goto L32
        L29:
            if ((r0 & 1) == 0) goto L32;
            if (r2 == true) goto L31;
        L12:
            setHeaderTopBottomOffset(r8, r9, 0);
            goto L32
        L31:
            animateOffsetTo(r8, r9, 0, 0.0f);
            goto L32
        L22:
            r2 = false;
            goto L24
        L5:
            if ((r0 & 8) != 0) goto L18;
            if (r1.fullyScrolled == false) goto L11;
            r3 = -r9.getTotalScrollRange();
            goto L9
        L11:
            if (this.savedState.fullyExpanded == true) goto L12;
            View r4 = r9.getChildAt(this.savedState.firstVisibleChildIndex);
            int r5 = -r4.getBottom();
            if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L16;
            int r6 = ViewCompat.getMinimumHeight(r4) + r9.getTopInset();
        L17:
            setHeaderTopBottomOffset(r8, r9, r5 + r6);
            goto L32
        L16:
            r6 = Math.round(r4.getHeight() * this.savedState.firstVisibleChildPercentageShown);
            goto L17
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onMeasureChild(CoordinatorLayout r8, View r9, int r10, int r11, int r12, int r13) {
            return onMeasureChild(r8, (AppBarLayout) ZeusTransformUtils.preCheckCast(r9, AppBarLayout.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        public boolean onMeasureChild(CoordinatorLayout r7, T r8, int r9, int r10, int r11, int r12) {
            if (((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).height != (-2)) goto L7;
            r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
            return true;
        L7:
            return super.onMeasureChild(r7, r8, r9, r10, r11, r12);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onNestedPreScroll(CoordinatorLayout r9, View r10, View r11, int r12, int r13, int[] r14, int r15) {
            onNestedPreScroll(r9, (AppBarLayout) ZeusTransformUtils.preCheckCast(r10, AppBarLayout.class, "com.obric.memorydata.plugin"), r11, r12, r13, r14, r15);
        }

        public void onNestedPreScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int[] r12, int r13) {
            if (r11 == 0) goto L10;
            if (r11 >= 0) goto L5;
            int r14 = -r8.getTotalScrollRange();
            int r15 = r8.getDownNestedPreScrollRange() + r14;
        L6:
            int r4 = r14;
            int r5 = r15;
            if (r4 == r5) goto L10;
            r12[1] = scroll(r7, r8, r11, r4, r5);
            goto L10
        L5:
            r14 = -r8.getUpNestedPreScrollRange();
            r15 = 0;
        L10:
            if (r8.isLiftOnScroll() == false) goto L13;
            r8.setLiftedState(r8.shouldLift(r9));
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onNestedScroll(CoordinatorLayout r12, View r13, View r14, int r15, int r16, int r17, int r18, int r19, int[] r20) {
            onNestedScroll(r12, (AppBarLayout) ZeusTransformUtils.preCheckCast(r13, AppBarLayout.class, "com.obric.memorydata.plugin"), r14, r15, r16, r17, r18, r19, r20);
        }

        public void onNestedScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int r12, int r13, int r14, int[] r15) {
            if (r13 >= 0) goto L4;
            r15[1] = scroll(r7, r8, r13, -r8.getDownNestedScrollRange(), 0);
        L4:
            if (r13 != 0) goto L7;
            updateAccessibilityActions(r7, r8);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r3, View r4, Parcelable r5) {
            Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin");
            onRestoreInstanceState(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r4, AppBarLayout.class, "com.obric.memorydata.plugin"), r6);
        }

        public void onRestoreInstanceState(CoordinatorLayout r3, T r4, Parcelable r5) {
            Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, SavedState.class) == false) goto L5;
            restoreScrollState((SavedState) ZeusTransformUtils.preCheckCast(r6, SavedState.class, "com.obric.memorydata.plugin"), true);
            super.onRestoreInstanceState(r3, r4, this.savedState.getSuperState());
            return;
        L5:
            super.onRestoreInstanceState(r3, r4, r6);
            this.savedState = null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r3, View r4) {
            return onSaveInstanceState(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r4, AppBarLayout.class, "com.obric.memorydata.plugin"));
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout r1, T r2) {
            Parcelable r3 = super.onSaveInstanceState(r1, r2);
            SavedState r0 = saveScrollState(r3, r2);
            if (r0 != null) goto L6;
            return r3;
        L6:
            return r0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r8, View r9, View r10, View r11, int r12, int r13) {
            return onStartNestedScroll(r8, (AppBarLayout) ZeusTransformUtils.preCheckCast(r9, AppBarLayout.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        public boolean onStartNestedScroll(CoordinatorLayout r1, T r2, View r3, View r4, int r5, int r6) {
            if ((r5 & 2) != 0) goto L5;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L14;
            ValueAnimator r8 = this.offsetAnimator;
            if (r8 == null) goto L14;
            r8.cancel();
        L14:
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = r6;
            return r7;
        L5:
            if (r2.isLiftOnScroll() == false) goto L7;
        L8:
            r7 = true;
            goto L10
        L7:
            if (canScrollChildren(r1, r2, r3) == false) goto L9;
            goto L8
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* synthetic */ void onStopNestedScroll(CoordinatorLayout r3, View r4, View r5, int r6) {
            onStopNestedScroll(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r4, AppBarLayout.class, "com.obric.memorydata.plugin"), r5, r6);
        }

        public void onStopNestedScroll(CoordinatorLayout r2, T r3, View r4, int r5) {
            if (this.lastStartedType != 0) goto L5;
        L6:
            snapToChildIfNeeded(r2, r3);
            if (r3.isLiftOnScroll() == false) goto L9;
            r3.setLiftedState(r3.shouldLift(r4));
        L9:
            this.lastNestedScrollingChildRef = new WeakReference(r4);
            return;
        L5:
            if (r5 != 1) goto L9;
            goto L6
        }

        void restoreScrollState(SavedState r2, boolean r3) {
            if (this.savedState == null) goto L5;
            if (r3 == true) goto L5;
            return;
        L5:
            this.savedState = r2;
        }

        SavedState saveScrollState(Parcelable r7, T r8) {
            Parcelable r9 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.memorydata.plugin");
            int r6 = getTopAndBottomOffset();
            int r0 = r8.getChildCount();
            boolean r1 = false;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L26;
            View r3 = r8.getChildAt(r2);
            int r4 = r3.getBottom() + r6;
            if ((r3.getTop() + r6) > 0) goto L25;
            if (r4 < 0) goto L25;
            if (r9 != null) goto L10;
            r9 = AbsSavedState.EMPTY_STATE;
        L10:
            SavedState r5 = new SavedState(r9);
            if (r6 != 0) goto L13;
            boolean r10 = true;
        L14:
            r5.fullyExpanded = r10;
            if (r5.fullyExpanded == false) goto L17;
        L19:
            boolean r11 = false;
        L20:
            r5.fullyScrolled = r11;
            r5.firstVisibleChildIndex = r2;
            if (r4 != (ViewCompat.getMinimumHeight(r3) + r8.getTopInset())) goto L23;
            r1 = true;
        L23:
            r5.firstVisibleChildAtMinimumHeight = r1;
            r5.firstVisibleChildPercentageShown = r4 / r3.getHeight();
            return r5;
        L17:
            if ((-r6) < r8.getTotalScrollRange()) goto L19;
            r11 = true;
            goto L20
        L13:
            r10 = false;
        L25:
            r2 = r2 + 1;
            goto L3
        L26:
            return null;
        }

        public void setDragCallback(a r1) {
            this.onDragCallback = r1;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r7, View r8, int r9, int r10, int r11) {
            return setHeaderTopBottomOffset(r7, (AppBarLayout) ZeusTransformUtils.preCheckCast(r8, AppBarLayout.class, "com.obric.memorydata.plugin"), r9, r10, r11);
        }

        int setHeaderTopBottomOffset(CoordinatorLayout r9, T r10, int r11, int r12, int r13) {
            int r0 = getTopBottomOffsetForScrollingSibling();
            int r1 = 0;
            if (r12 == 0) goto L30;
            if (r0 < r12) goto L30;
            if (r0 > r13) goto L30;
            int r5 = MathUtils.clamp(r11, r12, r13);
            if (r0 != r5) goto L9;
        L31:
            updateAccessibilityActions(r9, r10);
            return r1;
        L9:
            if (r10.hasChildWithInterpolator() == false) goto L11;
            int r14 = interpolateOffset(r10, r5);
        L12:
            boolean r15 = setTopAndBottomOffset(r14);
            int r16 = r0 - r5;
            this.offsetDelta = r5 - r14;
            int r17 = 1;
            if (r15 == true) goto L15;
        L22:
            if (r15 == false) goto L24;
        L26:
            r10.onOffsetChanged(getTopAndBottomOffset());
            if (r5 >= r0) goto L29;
            r17 = -1;
        L29:
            updateAppBarLayoutDrawableState(r9, r10, r5, r17, false);
            r1 = r16;
            goto L31
        L24:
            if (r10.hasChildWithInterpolator() == false) goto L26;
            r9.dispatchDependentViewsChanged(r10);
        L15:
            if (r1 >= r10.getChildCount()) goto L22;
            LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getChildAt(r1).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            b r3 = r2.b();
            if (r3 == null) goto L21;
            if ((r2.a() & 1) == 0) goto L21;
            r3.a(r10, r10.getChildAt(r1), getTopAndBottomOffset());
        L21:
            r1 = r1 + 1;
            goto L15
        L11:
            r14 = r5;
        L30:
            this.offsetDelta = 0;
            goto L31
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
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
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
            return super.onInterceptTouchEvent(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, AppBarLayout r2, int r3) {
            return super.onLayoutChild(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, AppBarLayout r2, int r3, int r4, int r5, int r6) {
            return super.onMeasureChild(r1, r2, r3, r4, r5, r6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4, int r5, int[] r6, int r7) {
            super.onNestedPreScroll(r1, r2, r3, r4, r5, r6, r7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
            super.onNestedScroll(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r3, AppBarLayout r4, Parcelable r5) {
            super.onRestoreInstanceState(r3, r4, (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r1, AppBarLayout r2) {
            return super.onSaveInstanceState(r1, r2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, View r4, int r5, int r6) {
            return super.onStartNestedScroll(r1, r2, r3, r4, r5, r6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4) {
            super.onStopNestedScroll(r1, r2, r3, r4);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
            return super.onTouchEvent(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(BaseBehavior.a r1) {
            super.setDragCallback(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r1) {
            super.setHorizontalOffsetEnabled(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r1) {
            return super.setLeftAndRightOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r1) {
            return super.setTopAndBottomOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r1) {
            super.setVerticalOffsetEnabled(r1);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f3761b;
        private b c;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.f3760a = 1;
        }

        public LayoutParams(Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r7, r8);
            this.f3760a = 1;
            TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.AppBarLayout_Layout);
            this.f3760a = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollFlags, "styleable", "AppBarLayout_Layout_layout_scrollFlags"), 0);
            a(b(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollEffect, "styleable", "AppBarLayout_Layout_layout_scrollEffect"), 0)));
            if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, "styleable", "AppBarLayout_Layout_layout_scrollInterpolator")) == false) goto L5;
            this.f3761b = AnimationUtils.loadInterpolator(r7, r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, "styleable", "AppBarLayout_Layout_layout_scrollInterpolator"), 0));
        L5:
            r9.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.f3760a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.f3760a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams r1) {
            super(r1);
            this.f3760a = 1;
        }

        private b b(int r1) {
            if (r1 == 1) goto L7;
            return null;
        L7:
            return new c();
        }

        public int a() {
            return this.f3760a;
        }

        public void a(int r1) {
            this.f3760a = r1;
        }

        public void a(b r1) {
            this.c = r1;
        }

        public b b() {
            return this.c;
        }

        public Interpolator c() {
            return this.f3761b;
        }

        boolean d() {
            int r2 = this.f3760a;
            if ((r2 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r2 & 10) == 0) goto L7;
            return true;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r5, r6);
            TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, "styleable", "ScrollingViewBehavior_Layout_behavior_overlapTop"), 0));
            r7.recycle();
        }

        private static int getAppBarLayoutOffset(AppBarLayout r2) {
            CoordinatorLayout.Behavior r3 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
            if (ZeusTransformUtils.instanceOf(r3, BaseBehavior.class) == true) goto L5;
            return 0;
        L5:
            return ((BaseBehavior) ZeusTransformUtils.preCheckCast(r3, BaseBehavior.class, "com.obric.memorydata.plugin")).getTopBottomOffsetForScrollingSibling();
        }

        private void offsetChildAsNeeded(View r4, View r5) {
            CoordinatorLayout.Behavior r0 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
            if (ZeusTransformUtils.instanceOf(r0, BaseBehavior.class) == false) goto L6;
            BaseBehavior r1 = (BaseBehavior) ZeusTransformUtils.preCheckCast(r0, BaseBehavior.class, "com.obric.memorydata.plugin");
            ViewCompat.offsetTopAndBottom(r4, (((r5.getBottom() - r4.getTop()) + BaseBehavior.access$300(r1)) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r5));
            return;
        }

        private void updateLiftedStateIfNeeded(View r2, View r3) {
            if (ZeusTransformUtils.instanceOf(r3, AppBarLayout.class) == false) goto L8;
            AppBarLayout r1 = (AppBarLayout) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.class, "com.obric.memorydata.plugin");
            if (r1.isLiftOnScroll() == false) goto L9;
            r1.setLiftedState(r1.shouldLift(r2));
            return;
        L9:
            return;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* synthetic */ View findFirstDependency(List r3) {
            return findFirstDependency((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        AppBarLayout findFirstDependency(List<View> r5) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            int r6 = r4.size();
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L9;
            View r2 = (View) ZeusTransformUtils.preCheckCast(r4.get(r1), View.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2, AppBarLayout.class) == true) goto L7;
            r1 = r1 + 1;
            goto L3
        L7:
            return (AppBarLayout) ZeusTransformUtils.preCheckCast(r2, AppBarLayout.class, "com.obric.memorydata.plugin");
        L9:
            return null;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View r4) {
            if (ZeusTransformUtils.instanceOf(r4, AppBarLayout.class) == false) goto L13;
            AppBarLayout r3 = (AppBarLayout) ZeusTransformUtils.preCheckCast(r4, AppBarLayout.class, "com.obric.memorydata.plugin");
            int r5 = r3.getTotalScrollRange();
            int r1 = r3.getDownNestedPreScrollRange();
            int r6 = getAppBarLayoutOffset(r3);
            if (r1 != 0) goto L7;
        L9:
            int r7 = r5 - r1;
            if (r7 == 0) goto L13;
            return (r6 / r7) + 1.0f;
        L7:
            if ((r5 + r6) > r1) goto L9;
            return 0.0f;
        L13:
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(View r2) {
            if (ZeusTransformUtils.instanceOf(r2, AppBarLayout.class) == false) goto L7;
            return ((AppBarLayout) ZeusTransformUtils.preCheckCast(r2, AppBarLayout.class, "com.obric.memorydata.plugin")).getTotalScrollRange();
        L7:
            return super.getScrollRange(r2);
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
        public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
            return ZeusTransformUtils.instanceOf(r3, AppBarLayout.class);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout r1, View r2, View r3) {
            offsetChildAsNeeded(r2, r3);
            updateLiftedStateIfNeeded(r2, r3);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(CoordinatorLayout r1, View r2, View r3) {
            if (ZeusTransformUtils.instanceOf(r3, AppBarLayout.class) == false) goto L6;
            ViewCompat.removeAccessibilityAction(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            ViewCompat.setAccessibilityDelegate(r1, null);
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return super.onLayoutChild(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
            return super.onMeasureChild(r1, r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r4, View r5, Rect r6, boolean r7) {
            AppBarLayout r0 = findFirstDependency(r4.getDependencies(r5));
            if (r0 == null) goto L8;
            r6.offset(r5.getLeft(), r5.getTop());
            Rect r3 = this.tempRect1;
            r3.set(0, 0, r4.getWidth(), r4.getHeight());
            if (r3.contains(r6) == true) goto L8;
            r0.setExpanded(false, !r7);
            return true;
        L8:
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r1) {
            super.setHorizontalOffsetEnabled(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r1) {
            return super.setLeftAndRightOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r1) {
            return super.setTopAndBottomOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r1) {
            super.setVerticalOffsetEnabled(r1);
        }
    }

    public interface a<T extends AppBarLayout> {
        void onOffsetChanged(T r1, int r2);
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(AppBarLayout r1, View r2, float r3);
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f3762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f3763b;

        public c() {
            this.f3762a = new Rect();
            this.f3763b = new Rect();
        }

        private static void a(Rect r0, AppBarLayout r1, View r2) {
            r2.getDrawingRect(r0);
            r1.offsetDescendantRectToMyCoords(r2, r0);
            r0.offset(0, -r1.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout r3, View r4, float r5) {
            a(this.f3762a, r3, r4);
            float r6 = this.f3762a.top - Math.abs(r5);
            if (r6 > 0.0f) goto L5;
            float r7 = 1.0f - MathUtils.clamp(Math.abs(r6 / this.f3762a.height()), 0.0f, 1.0f);
            float r8 = (-r6) - ((this.f3762a.height() * 0.3f) * (1.0f - (r7 * r7)));
            r4.setTranslationY(r8);
            r4.getDrawingRect(this.f3763b);
            this.f3763b.offset(0, (int) (-r8));
            ViewCompat.setClipBounds(r4, this.f3763b);
            return;
        L5:
            ViewCompat.setClipBounds(r4, null);
            r4.setTranslationY(0.0f);
        }
    }

    public interface d {
        void a(float r1, int r2);
    }

    public interface e extends a<AppBarLayout> {
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_Design_AppBarLayout, "style", "Widget_Design_AppBarLayout");
    }

    public AppBarLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public AppBarLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.appBarLayoutStyle, "attr", "appBarLayoutStyle"));
    }

    public AppBarLayout(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r13, r3, r12, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r12);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        this.liftOnScrollListeners = new ArrayList();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L8:
        TypedArray r14 = k.a(r0, r3, R.styleable.AppBarLayout, r12, r6, new int[0]);
        ViewCompat.setBackground(this, r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_android_background, "styleable", "AppBarLayout_android_background")));
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L12;
        ColorDrawable r1 = (ColorDrawable) ZeusTransformUtils.preCheckCast(getBackground(), ColorDrawable.class, "com.obric.memorydata.plugin");
        MaterialShapeDrawable r2 = new MaterialShapeDrawable();
        r2.setFillColor(ColorStateList.valueOf(r1.getColor()));
        r2.initializeElevationOverlay(r0);
        ViewCompat.setBackground(this, r2);
    L12:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_expanded, "styleable", "AppBarLayout_expanded")) == false) goto L15;
        setExpanded(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_expanded, "styleable", "AppBarLayout_expanded"), false), false, false);
    L15:
        if (Build.VERSION.SDK_INT < 21) goto L20;
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_elevation, "styleable", "AppBarLayout_elevation")) == false) goto L20;
        com.google.android.material.appbar.b.a(this, r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_elevation, "styleable", "AppBarLayout_elevation"), 0));
    L20:
        if (Build.VERSION.SDK_INT >= 26) goto L22;
    L27:
        this.liftOnScroll = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_liftOnScroll, "styleable", "AppBarLayout_liftOnScroll"), false);
        this.liftOnScrollTargetViewId = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_liftOnScrollTargetViewId, "styleable", "AppBarLayout_liftOnScrollTargetViewId"), -1);
        setStatusBarForeground(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_statusBarForeground, "styleable", "AppBarLayout_statusBarForeground")));
        r14.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
        return;
    L22:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_android_keyboardNavigationCluster, "styleable", "AppBarLayout_android_keyboardNavigationCluster")) == false) goto L25;
        setKeyboardNavigationCluster(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_android_keyboardNavigationCluster, "styleable", "AppBarLayout_android_keyboardNavigationCluster"), false));
    L25:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, "styleable", "AppBarLayout_android_touchscreenBlocksFocus")) == false) goto L27;
        setTouchscreenBlocksFocus(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, "styleable", "AppBarLayout_android_touchscreenBlocksFocus"), false));
        goto L27
    L5:
        if (getOutlineProvider() != ViewOutlineProvider.BACKGROUND) goto L7;
        com.google.android.material.appbar.b.a(this);
    L7:
        com.google.android.material.appbar.b.a(this, r3, r12, r6);
        goto L8
    }

    static /* synthetic */ Drawable access$000(AppBarLayout r0) {
        return r0.statusBarForeground;
    }

    static /* synthetic */ List access$100(AppBarLayout r0) {
        return r0.liftOnScrollListeners;
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> r0 = this.liftOnScrollTargetView;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.liftOnScrollTargetView = null;
    }

    private View findLiftOnScrollTargetView(View r5) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r0 = this.liftOnScrollTargetViewId;
        if (r0 == (-1)) goto L15;
        if (r5 == null) goto L8;
        View r6 = r5.findViewById(r0);
    L9:
        if (r6 == null) goto L11;
    L13:
        if (r6 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r6);
        goto L15
    L11:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L13;
        r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r6 = null;
    L15:
        WeakReference<View> r4 = this.liftOnScrollTargetView;
        if (r4 != null) goto L18;
        return null;
    L18:
        return (View) ZeusTransformUtils.preCheckCast(r4.get(), View.class, "com.obric.memorydata.plugin");
    }

    private boolean hasCollapsibleChild() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r2).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void invalidateScrollRanges() {
        Behavior r0 = this.behavior;
        if (r0 != null) goto L5;
    L10:
        BaseBehavior.SavedState r1 = null;
    L11:
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (r1 == null) goto L15;
        this.behavior.restoreScrollState(r1, false);
        return;
    L15:
        return;
    L5:
        if (this.totalScrollRange == (-1)) goto L10;
        if (this.pendingAction != 0) goto L10;
        r1 = r0.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        goto L11
    }

    private void setExpanded(boolean r2, boolean r3, boolean r4) {
        if (r2 == false) goto L4;
        int r5 = 1;
    L5:
        int r0 = 0;
        if (r3 == false) goto L8;
        int r6 = 4;
    L9:
        int r7 = r5 | r6;
        if (r4 == false) goto L12;
        r0 = 8;
    L12:
        this.pendingAction = r7 | r0;
        requestLayout();
        return;
    L8:
        r6 = 0;
        goto L9
    L4:
        r5 = 2;
        goto L5
    }

    private boolean setLiftableState(boolean r2) {
        if (this.liftable == r2) goto L6;
        this.liftable = r2;
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
        View r3 = getChildAt(0);
        if (r3.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (ViewCompat.getFitsSystemWindows(r3) == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private void startLiftOnScrollElevationOverlayAnimation(final MaterialShapeDrawable r6, boolean r7) {
        float r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.design_appbar_elevation, "dimen", "design_appbar_elevation"));
        if (r7 == false) goto L5;
        float r3 = 0.0f;
    L6:
        if (r7 == true) goto L9;
        r1 = 0.0f;
    L9:
        ValueAnimator r8 = this.elevationOverlayAnimator;
        if (r8 == null) goto L12;
        r8.cancel();
    L12:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{r3, r1});
        this.elevationOverlayAnimator = r9;
        r9.setDuration(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.app_bar_elevation_anim_duration, TypedValues.Custom.S_INT, "app_bar_elevation_anim_duration")));
        this.elevationOverlayAnimator.setInterpolator(com.google.android.material.a.a.f3741a);
        this.elevationOverlayAnimator.addUpdateListener(new AnonymousClass2(this, r6));
        this.elevationOverlayAnimator.start();
        return;
    L5:
        r3 = r1;
        goto L6
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addLiftOnScrollListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.liftOnScrollListeners.add(r4);
    }

    public void addOnOffsetChangedListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (this.listeners != null) goto L5;
        this.listeners = new ArrayList();
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        if (this.listeners.contains(r4) == true) goto L11;
        this.listeners.add(r4);
        return;
    }

    public void addOnOffsetChangedListener(e r3) {
        addOnOffsetChangedListener((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    @Override // android.view.View
    public void draw(Canvas r4) {
        super.draw(r4);
        if (shouldDrawStatusBarForeground() == false) goto L6;
        int r0 = r4.save();
        r4.translate(0.0f, -this.currentOffset);
        this.statusBarForeground.draw(r4);
        r4.restoreToCount(r0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.statusBarForeground;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isStateful() == true) goto L7;
        return;
    L7:
        if (r1.setState(r0) == false) goto L12;
        invalidateDrawable(r1);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, LinearLayout.LayoutParams.class) == false) goto L9;
        return new LayoutParams((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin"));
    L9:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L13;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L13:
        return new LayoutParams(r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior r0 = new Behavior();
        this.behavior = r0;
        return r0;
    }

    int getDownNestedPreScrollRange() {
        int r0 = this.downPreScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount() - 1;
        int r2 = 0;
    L6:
        if (r1 < 0) goto L25;
        View r3 = getChildAt(r1);
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r5 = r3.getMeasuredHeight();
        int r6 = r4.f3760a;
        if ((r6 & 5) != 5) goto L22;
        int r7 = r4.topMargin + r4.bottomMargin;
        if ((r6 & 8) == 0) goto L14;
        int r8 = ViewCompat.getMinimumHeight(r3);
    L12:
        int r9 = r7 + r8;
    L17:
        if (r1 == 0) goto L19;
    L21:
        r2 = r2 + r9;
    L24:
        r1 = r1 - 1;
        goto L6
    L19:
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L21;
        r9 = Math.min(r9, r5 - getTopInset());
        goto L21
    L14:
        if ((r6 & 2) == 0) goto L16;
        r8 = r5 - ViewCompat.getMinimumHeight(r3);
        goto L12
    L16:
        r9 = r7 + r5;
        goto L17
    L22:
        if (r2 <= 0) goto L24;
    L25:
        int r10 = Math.max(0, r2);
        this.downPreScrollRange = r10;
        return r10;
    }

    int getDownNestedScrollRange() {
        int r0 = this.downScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L13;
        View r4 = getChildAt(r2);
        LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r6 = r4.getMeasuredHeight() + (r5.topMargin + r5.bottomMargin);
        int r7 = r5.f3760a;
        if ((r7 & 1) == 0) goto L13;
        r3 = r3 + r6;
        if ((r7 & 2) != 0) goto L11;
        r2 = r2 + 1;
        goto L6
    L11:
        r3 = r3 - ViewCompat.getMinimumHeight(r4);
    L13:
        int r8 = Math.max(0, r3);
        this.downScrollRange = r8;
        return r8;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r0 = getTopInset();
        int r1 = ViewCompat.getMinimumHeight(this);
        if (r1 != 0) goto L5;
        int r2 = getChildCount();
        if (r2 < 1) goto L9;
        r1 = ViewCompat.getMinimumHeight(getChildAt(r2 - 1));
    L10:
        if (r1 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r1 = 0;
    L5:
        return (r1 * 2) + r0;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        WindowInsetsCompat r0 = this.lastInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getSystemWindowInsetTop();
    }

    public final int getTotalScrollRange() {
        int r0 = this.totalScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L18;
        View r4 = getChildAt(r2);
        LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r6 = r4.getMeasuredHeight();
        int r7 = r5.f3760a;
        if ((r7 & 1) == 0) goto L18;
        r3 = r3 + ((r6 + r5.topMargin) + r5.bottomMargin);
        if (r2 != 0) goto L15;
        if (ViewCompat.getFitsSystemWindows(r4) == false) goto L15;
        r3 = r3 - getTopInset();
    L15:
        if ((r7 & 2) != 0) goto L16;
        r2 = r2 + 1;
        goto L6
    L16:
        r3 = r3 - ViewCompat.getMinimumHeight(r4);
    L18:
        int r8 = Math.max(0, r3);
        this.totalScrollRange = r8;
        return r8;
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
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r6) {
        if (this.tmpStatesArray != null) goto L5;
        this.tmpStatesArray = new int[4];
    L5:
        int[] r0 = this.tmpStatesArray;
        int[] r7 = super.onCreateDrawableState(r6 + r0.length);
        if (this.liftable == false) goto L8;
        int r2 = ZeusTransformUtils.mapRes(R.attr.state_liftable, "attr", "state_liftable");
    L9:
        r0[0] = r2;
        if (this.liftable == true) goto L12;
    L14:
        int r3 = -ZeusTransformUtils.mapRes(R.attr.state_lifted, "attr", "state_lifted");
    L15:
        r0[1] = r3;
        if (this.liftable == false) goto L18;
        int r4 = ZeusTransformUtils.mapRes(R.attr.state_collapsible, "attr", "state_collapsible");
    L19:
        r0[2] = r4;
        if (this.liftable == true) goto L22;
    L24:
        int r5 = -ZeusTransformUtils.mapRes(R.attr.state_collapsed, "attr", "state_collapsed");
    L25:
        r0[3] = r5;
        return mergeDrawableStates(r7, r0);
    L22:
        if (this.lifted == false) goto L24;
        r5 = ZeusTransformUtils.mapRes(R.attr.state_collapsed, "attr", "state_collapsed");
        goto L25
    L18:
        r4 = -ZeusTransformUtils.mapRes(R.attr.state_collapsible, "attr", "state_collapsible");
        goto L19
    L12:
        if (this.lifted == false) goto L14;
        r3 = ZeusTransformUtils.mapRes(R.attr.state_lifted, "attr", "state_lifted");
        goto L15
    L8:
        r2 = -ZeusTransformUtils.mapRes(R.attr.state_liftable, "attr", "state_liftable");
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        boolean r8 = true;
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L9:
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int r9 = getChildCount();
        int r10 = 0;
    L10:
        if (r10 >= r9) goto L15;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r10).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).c() != null) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.haveChildWithInterpolator = true;
    L15:
        Drawable r11 = this.statusBarForeground;
        if (r11 == null) goto L19;
        r11.setBounds(0, 0, getWidth(), getTopInset());
    L19:
        if (this.liftableOverride == false) goto L21;
        return;
    L21:
        if (this.liftOnScroll == false) goto L23;
    L26:
        setLiftableState(r8);
        return;
    L23:
        if (hasCollapsibleChild() == true) goto L26;
        r8 = false;
        goto L26
    L5:
        if (shouldOffsetFirstChild() == false) goto L9;
        int r12 = getTopInset();
        int r13 = getChildCount() - 1;
    L7:
        if (r13 < 0) goto L9;
        ViewCompat.offsetTopAndBottom(getChildAt(r13), r12);
        r13 = r13 - 1;
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = View.MeasureSpec.getMode(r4);
        if (r5 != 1073741824) goto L5;
    L15:
        invalidateScrollRanges();
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L15;
        if (shouldOffsetFirstChild() == false) goto L15;
        int r0 = getMeasuredHeight();
        if (r5 == Integer.MIN_VALUE) goto L13;
        if (r5 != 0) goto L14;
        r0 = r0 + getTopInset();
    L14:
        setMeasuredDimension(getMeasuredWidth(), r0);
        goto L15
    L13:
        r0 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(r4));
        goto L14
    }

    void onOffsetChanged(int r6) {
        this.currentOffset = r6;
        if (willNotDraw() == true) goto L5;
        ViewCompat.postInvalidateOnAnimation(this);
    L5:
        List<a> r0 = this.listeners;
        if (r0 == null) goto L13;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L17;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.listeners.get(r1), a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        r3.onOffsetChanged(this, r6);
    L12:
        r1 = r1 + 1;
        goto L8
    L17:
        return;
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r3) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r0 = r3;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r0) == true) goto L9;
        this.lastInsets = r0;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r3;
    L5:
        r0 = null;
        goto L7
    }

    public boolean removeLiftOnScrollListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        return this.liftOnScrollListeners.remove(r4);
    }

    public void removeOnOffsetChangedListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        List<a> r2 = this.listeners;
        if (r2 == null) goto L7;
        if (r4 == null) goto L8;
        r2.remove(r4);
        return;
    L8:
        return;
    }

    public void removeOnOffsetChangedListener(e r3) {
        removeOnOffsetChangedListener((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        h.a(this, r1);
    }

    public void setExpanded(boolean r2) {
        setExpanded(r2, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean r2, boolean r3) {
        setExpanded(r2, r3, true);
    }

    public void setLiftOnScroll(boolean r1) {
        this.liftOnScroll = r1;
    }

    public void setLiftOnScrollTargetViewId(int r1) {
        this.liftOnScrollTargetViewId = r1;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean r2) {
        this.liftableOverride = true;
        return setLiftableState(r2);
    }

    public void setLiftableOverrideEnabled(boolean r1) {
        this.liftableOverride = r1;
    }

    public boolean setLifted(boolean r2) {
        return setLiftedState(r2, true);
    }

    boolean setLiftedState(boolean r2) {
        return setLiftedState(r2, !this.liftableOverride);
    }

    boolean setLiftedState(boolean r3, boolean r4) {
        if (r4 == true) goto L4;
        return false;
    L4:
        if (this.lifted == r3) goto L16;
        this.lifted = r3;
        refreshDrawableState();
        if (this.liftOnScroll == true) goto L8;
        return true;
    L8:
        if (ZeusTransformUtils.instanceOf(getBackground(), MaterialShapeDrawable.class) == false) goto L15;
        startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(getBackground(), MaterialShapeDrawable.class, "com.obric.memorydata.plugin"), r3);
        return true;
    L15:
        return true;
    L16:
        return false;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r2) {
        if (r2 != 1) goto L7;
        super.setOrientation(r2);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable r3) {
        Drawable r0 = this.statusBarForeground;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.statusBarForeground = r1;
        if (r1 != null) goto L12;
    L19:
        updateWillNotDraw();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.statusBarForeground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
        Drawable r4 = this.statusBarForeground;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.statusBarForeground.setCallback(this);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    public void setStatusBarForegroundColor(int r2) {
        setStatusBarForeground(new ColorDrawable(r2));
    }

    public void setStatusBarForegroundResource(int r4) {
        setStatusBarForeground(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    @Deprecated
    public void setTargetElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        com.google.android.material.appbar.b.a(this, r3);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 != 0) goto L5;
        boolean r3 = true;
    L6:
        Drawable r1 = this.statusBarForeground;
        if (r1 == null) goto L10;
        r1.setVisible(r3, false);
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    boolean shouldLift(View r1) {
        View r0 = findLiftOnScrollTargetView(r1);
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r1.getScrollY() <= 0) goto L12;
        goto L11
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.statusBarForeground) goto L8;
        return false;
    }
}
