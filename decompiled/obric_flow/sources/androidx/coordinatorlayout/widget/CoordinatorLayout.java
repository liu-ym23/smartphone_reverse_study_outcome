package androidx.coordinatorlayout.widget;

import ai.j0;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.a;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.color.utilities.Contrast;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS = null;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = null;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME = null;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = null;
    private static final Pools.Pool<Rect> sRectPool = null;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempList1;

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        @Nullable
        public static Object getTag(@NonNull View r5) {
            return ((LayoutParams) r5.getLayoutParams()).mBehaviorTag;
        }

        public static void setTag(@NonNull View r5, @Nullable Object r10) {
            ((LayoutParams) r5.getLayoutParams()).mBehaviorTag = r10;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout r5, @NonNull V r10) {
            if (getScrimOpacity(r5, r10) <= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull Rect r11) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout r5, @NonNull V r10) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        public float getScrimOpacity(@NonNull CoordinatorLayout r5, @NonNull V r10) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull WindowInsetsCompat r11) {
            return r11;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams r5) {
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11) {
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull MotionEvent r11) {
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11, int r12, int r13, int r14) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, float r12, float r13, boolean r14) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, float r12, float r13) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, @NonNull int[] r14) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, @NonNull View r12, int r13) {
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull Rect r11, boolean r12) {
            return false;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull Parcelable r11) {
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r5, @NonNull V r10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, @NonNull View r12, int r13) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11) {
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull MotionEvent r11) {
            return false;
        }

        public Behavior(Context r5, AttributeSet r10) {
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, @NonNull int[] r14, int r15) {
            if (r15 != 0) goto L5;
            onNestedPreScroll(r5, r10, r11, r12, r13, r14);
            return;
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, int r14, int r15, int r16) {
            if (r16 != 0) goto L5;
            onNestedScroll(r5, r10, r11, r12, r13, r14, r15);
            return;
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
            if (r14 != 0) goto L5;
            onNestedScrollAccepted(r5, r10, r11, r12, r13);
            return;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
            if (r14 == 0) goto L4;
            return false;
        L4:
            return onStartNestedScroll(r5, r10, r11, r12, r13);
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12) {
            if (r12 != 0) goto L5;
            onStopNestedScroll(r5, r10, r11);
            return;
        }

        public void onNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, int r14, int r15, int r16, @NonNull int[] r17) {
            r17[0] = r17[0] + r14;
            r17[1] = r17[1] + r15;
            onNestedScroll(r5, r10, r11, r12, r13, r14, r15, r16);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DispatchChangeEvent {
    }

    public class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout this$0;

        public HierarchyChangeListener(CoordinatorLayout r5) {
            this.this$0 = r5;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r5, View r10) {
            ViewGroup.OnHierarchyChangeListener r11 = this.this$0.mOnHierarchyChangeListener;
            if (r11 == null) goto L6;
            r11.onChildViewAdded(r5, r10);
            return;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r5, View r10) {
            this.this$0.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener r11 = this.this$0.mOnHierarchyChangeListener;
            if (r11 == null) goto L6;
            r11.onChildViewRemoved(r5, r10);
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        View mAnchorDirectChild;
        int mAnchorId;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect;

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        private void resolveAnchorView(View r5, CoordinatorLayout r10) {
            View r11 = r10.findViewById(this.mAnchorId);
            this.mAnchorView = r11;
            if (r11 == null) goto L28;
            if (r11 == r10) goto L6;
            ViewParent r12 = r11.getParent();
        L12:
            if (r12 == r10) goto L25;
            if (r12 == null) goto L25;
            if (r12 == r5) goto L16;
            if ((r12 instanceof View) == false) goto L24;
            r11 = r12;
        L24:
            r12 = r12.getParent();
            goto L12
        L16:
            if (r10.isInEditMode() == false) goto L20;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L20:
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        L25:
            this.mAnchorDirectChild = r11;
            return;
        L6:
            if (r10.isInEditMode() == false) goto L10;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L10:
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        L28:
            if (r10.isInEditMode() == false) goto L32;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L32:
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + r10.getResources().getResourceName(this.mAnchorId) + " to anchor view " + r5);
        }

        private boolean shouldDodge(View r5, int r10) {
            int r11 = GravityCompat.getAbsoluteGravity(((LayoutParams) r5.getLayoutParams()).insetEdge, r10);
            if (r11 != 0) goto L5;
        L7:
            return false;
        L5:
            if ((GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, r10) & r11) != r11) goto L7;
            return true;
        }

        private boolean verifyAnchorView(View r5, CoordinatorLayout r10) {
            if (this.mAnchorView.getId() == this.mAnchorId) goto L5;
            return false;
        L5:
            View r11 = this.mAnchorView;
            ViewParent r12 = r11.getParent();
        L6:
            if (r12 == r10) goto L16;
            if (r12 == null) goto L14;
            if (r12 == r5) goto L14;
            if ((r12 instanceof View) == false) goto L13;
            r11 = r12;
        L13:
            r12 = r12.getParent();
        L14:
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return false;
        L16:
            this.mAnchorDirectChild = r11;
            return true;
        }

        public boolean checkAnchorChanged() {
            if (this.mAnchorView == null) goto L5;
        L7:
            return false;
        L5:
            if (this.mAnchorId == (-1)) goto L7;
            return true;
        }

        public boolean dependsOn(CoordinatorLayout r5, View r10, View r11) {
            if (r11 != this.mAnchorDirectChild) goto L5;
        L12:
            return true;
        L5:
            if (shouldDodge(r11, ViewCompat.getLayoutDirection(r5)) == true) goto L12;
            Behavior r12 = this.mBehavior;
            if (r12 != null) goto L9;
        L11:
            return false;
        L9:
            if (r12.layoutDependsOn(r5, r10, r11) == false) goto L11;
            goto L11
        }

        public boolean didBlockInteraction() {
            if (this.mBehavior != null) goto L6;
            this.mDidBlockInteraction = false;
        L6:
            return this.mDidBlockInteraction;
        }

        public View findAnchorView(CoordinatorLayout r5, View r10) {
            if (this.mAnchorId != (-1)) goto L7;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        L7:
            if (this.mAnchorView != null) goto L9;
        L10:
            resolveAnchorView(r10, r5);
        L12:
            return this.mAnchorView;
        L9:
            if (verifyAnchorView(r10, r5) == true) goto L12;
            goto L10
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        public boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        public Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        public void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        public boolean isBlockingInteractionBelow(CoordinatorLayout r5, View r10) {
            boolean r11 = this.mDidBlockInteraction;
            if (r11 == false) goto L6;
            return true;
        L6:
            Behavior r12 = this.mBehavior;
            if (r12 == null) goto L9;
            boolean r13 = r12.blocksInteractionBelow(r5, r10);
        L10:
            boolean r14 = r13 | r11;
            this.mDidBlockInteraction = r14;
            return r14;
        L9:
            r13 = false;
            goto L10
        }

        public boolean isNestedScrollAccepted(int r5) {
            if (r5 == 0) goto L10;
            if (r5 == 1) goto L8;
            return false;
        L8:
            return this.mDidAcceptNestedScrollNonTouch;
        L10:
            return this.mDidAcceptNestedScrollTouch;
        }

        public void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        public void resetNestedScroll(int r5) {
            setNestedScrollAccepted(r5, false);
        }

        public void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public void setAnchorId(@IdRes int r5) {
            invalidateAnchor();
            this.mAnchorId = r5;
        }

        public void setBehavior(@Nullable Behavior r5) {
            Behavior r10 = this.mBehavior;
            if (r10 == r5) goto L10;
            if (r10 == null) goto L6;
            r10.onDetachedFromLayoutParams();
        L6:
            this.mBehavior = r5;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (r5 == null) goto L11;
            r5.onAttachedToLayoutParams(this);
            return;
        L11:
            return;
        }

        public void setChangedAfterNestedScroll(boolean r5) {
            this.mDidChangeAfterNestedScroll = r5;
        }

        public void setLastChildRect(Rect r5) {
            this.mLastChildRect.set(r5);
        }

        public void setNestedScrollAccepted(int r5, boolean r10) {
            if (r5 != 0) goto L4;
            this.mDidAcceptNestedScrollTouch = r10;
            return;
        L4:
            if (r5 != 1) goto L10;
            this.mDidAcceptNestedScrollNonTouch = r10;
            return;
        }

        public LayoutParams(@NonNull Context r5, @Nullable AttributeSet r10) {
            super(r5, r10);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.CoordinatorLayout_Layout);
            this.gravity = r11.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = r11.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = r11.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = r11.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = r11.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = r11.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean r12 = r11.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.mBehaviorResolved = r12;
            if (r12 == false) goto L5;
            this.mBehavior = CoordinatorLayout.parseBehavior(r5, r10, r11.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
        L5:
            r11.recycle();
            Behavior r13 = this.mBehavior;
            if (r13 == null) goto L9;
            r13.onAttachedToLayoutParams(this);
            return;
        }

        public LayoutParams(LayoutParams r5) {
            super(r5);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }
    }

    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout this$0;

        public OnPreDrawListener(CoordinatorLayout r5) {
            this.this$0 = r5;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.this$0.onChildViewsChanged(0);
            return true;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        SparseArray<Parcelable> behaviorStates;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            int r5 = r10.readInt();
            int[] r12 = new int[r5];
            r10.readIntArray(r12);
            Parcelable[] r13 = r10.readParcelableArray(r11);
            this.behaviorStates = new SparseArray(r5);
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L5;
            this.behaviorStates.append(r12[r14], r13[r14]);
            r14 = r14 + 1;
            goto L3
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            SparseArray<Parcelable> r5 = this.behaviorStates;
            int r12 = 0;
            if (r5 == null) goto L5;
            int r13 = r5.size();
        L6:
            r10.writeInt(r13);
            int[] r14 = new int[r13];
            Parcelable[] r15 = new Parcelable[r13];
        L7:
            if (r12 >= r13) goto L9;
            r14[r12] = this.behaviorStates.keyAt(r12);
            r15[r12] = this.behaviorStates.valueAt(r12);
            r12 = r12 + 1;
            goto L7
        L9:
            r10.writeIntArray(r14);
            r10.writeParcelableArray(r15, r11);
            return;
        L5:
            r13 = 0;
            goto L6
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }
    }

    public static class ViewElevationComparator implements Comparator<View> {
        public ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r5, View r10) {
            return compare2(r5, r10);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r5, View r10) {
            float r11 = ViewCompat.getZ(r5);
            float r12 = ViewCompat.getZ(r10);
            if (r11 <= r12) goto L7;
            return -1;
        L7:
            if (r11 >= r12) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    static {
        Package r5 = CoordinatorLayout.class.getPackage();
        if (r5 == null) goto L5;
        String r10 = r5.getName();
    L6:
        WIDGET_PACKAGE_NAME = r10;
        TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new Pools.SynchronizedPool(12);
        return;
    L5:
        r10 = null;
        goto L6
    }

    public CoordinatorLayout(@NonNull Context r5) {
        this(r5, null);
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect r5 = sRectPool.acquire();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new Rect();
    }

    private void cancelInterceptBehaviors() {
        int r5 = getChildCount();
        MotionEvent r10 = null;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        View r12 = getChildAt(r11);
        Behavior r13 = ((LayoutParams) r12.getLayoutParams()).getBehavior();
        if (r13 == null) goto L9;
        if (r10 != null) goto L8;
        long r14 = SystemClock.uptimeMillis();
        r10 = MotionEvent.obtain(r14, r14, 3, 0.0f, 0.0f, 0);
    L8:
        r13.onInterceptTouchEvent(this, r12, r10);
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        if (r10 == null) goto L16;
        r10.recycle();
        return;
    }

    private static int clamp(int r5, int r10, int r11) {
        if (r5 >= r10) goto L4;
        return r10;
    L4:
        if (r5 <= r11) goto L6;
        return r11;
    L6:
        return r5;
    }

    private void constrainChildRect(LayoutParams r10, Rect r11, int r12, int r13) {
        int r5 = getWidth();
        int r14 = getHeight();
        int r15 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r10).leftMargin, Math.min(r11.left, ((r5 - getPaddingRight()) - r12) - ((ViewGroup.MarginLayoutParams) r10).rightMargin));
        int r16 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r10).topMargin, Math.min(r11.top, ((r14 - getPaddingBottom()) - r13) - ((ViewGroup.MarginLayoutParams) r10).bottomMargin));
        r11.set(r15, r16, r12 + r15, r13 + r16);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat r5) {
        if (r5.isConsumed() == false) goto L5;
        return r5;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L15;
        View r12 = getChildAt(r11);
        if (ViewCompat.getFitsSystemWindows(r12) == false) goto L14;
        Behavior r13 = ((LayoutParams) r12.getLayoutParams()).getBehavior();
        if (r13 == null) goto L14;
        r5 = r13.onApplyWindowInsets(this, r12, r5);
        if (r5.isConsumed() == true) goto L15;
    L14:
        r11 = r11 + 1;
    L15:
        return r5;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(int r10, Rect r11, Rect r12, LayoutParams r13, int r14, int r15) {
        int r5 = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(r13.gravity), r10);
        int r16 = GravityCompat.getAbsoluteGravity(resolveGravity(r13.anchorGravity), r10);
        int r17 = r5 & 7;
        int r18 = r5 & 112;
        int r19 = r16 & 7;
        int r20 = r16 & 112;
        if (r19 == 1) goto L7;
        if (r19 == 5) goto L6;
        int r21 = r11.left;
    L9:
        if (r20 == 16) goto L13;
        if (r20 == 80) goto L12;
        int r22 = r11.top;
    L14:
        if (r17 == 1) goto L17;
        if (r17 == 5) goto L18;
        r21 = r21 - r14;
    L18:
        if (r18 == 16) goto L21;
        if (r18 == 80) goto L22;
        r22 = r22 - r15;
    L22:
        r12.set(r21, r22, r14 + r21, r15 + r22);
        return;
    L21:
        r22 = r22 - (r15 / 2);
        goto L22
    L17:
        r21 = r21 - (r14 / 2);
        goto L18
    L12:
        r22 = r11.bottom;
        goto L14
    L13:
        r22 = r11.top + (r11.height() / 2);
        goto L14
    L6:
        r21 = r11.right;
        goto L9
    L7:
        r21 = r11.left + (r11.width() / 2);
        goto L9
    }

    private int getKeyline(int r5) {
        int[] r10 = this.mKeylines;
        if (r10 != null) goto L6;
        Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + r5);
        return 0;
    L6:
        if (r5 >= 0) goto L8;
    L12:
        Log.e(TAG, "Keyline index " + r5 + " out of range for " + this);
        return 0;
    L8:
        if (r5 >= r10.length) goto L12;
        return r10[r5];
    }

    private void getTopSortedChildren(List<View> r5) {
        r5.clear();
        boolean r10 = isChildrenDrawingOrderEnabled();
        int r11 = getChildCount();
        int r12 = r11 - 1;
    L3:
        if (r12 < 0) goto L8;
        if (r10 == false) goto L6;
        int r13 = getChildDrawingOrder(r11, r12);
    L7:
        r5.add(getChildAt(r13));
        r12 = r12 - 1;
        goto L3
    L6:
        r13 = r12;
        goto L7
    L8:
        Comparator<View> r14 = TOP_SORTED_CHILDREN_COMPARATOR;
        if (r14 == null) goto L15;
        Collections.sort(r5, r14);
        return;
    }

    private boolean hasDependencies(View r5) {
        return this.mChildDag.hasOutgoingEdges(r5);
    }

    private void layoutChild(View r10, int r11) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        Rect r12 = acquireTempRect();
        r12.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r5).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) r5).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r5).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r5).bottomMargin);
        if (this.mLastInsets != null) goto L5;
    L9:
        Rect r13 = acquireTempRect();
        GravityCompat.apply(resolveGravity(r5.gravity), r10.getMeasuredWidth(), r10.getMeasuredHeight(), r12, r13, r11);
        r10.layout(r13.left, r13.top, r13.right, r13.bottom);
        releaseTempRect(r12);
        releaseTempRect(r13);
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L9;
        r12.left = this.mLastInsets.getSystemWindowInsetLeft() + r12.left;
        r12.top = this.mLastInsets.getSystemWindowInsetTop() + r12.top;
        r12.right -= this.mLastInsets.getSystemWindowInsetRight();
        r12.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        goto L9
    }

    private void layoutChildWithAnchor(View r5, View r10, int r11) {
        Rect r12 = acquireTempRect();
        Rect r13 = acquireTempRect();
        getDescendantRect(r10, r12);     // Catch: Throwable -> L6
        getDesiredAnchoredChildRect(r5, r11, r12, r13);     // Catch: Throwable -> L6
        r5.layout(r13.left, r13.top, r13.right, r13.bottom);     // Catch: Throwable -> L6
        releaseTempRect(r12);
        releaseTempRect(r13);
        return;
    L6:
        th = move-exception;
        releaseTempRect(r12);
        releaseTempRect(r13);
        throw th;
    }

    private void layoutChildWithKeyline(View r10, int r11, int r12) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        int r13 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r5.gravity), r12);
        int r14 = r13 & 7;
        int r15 = r13 & 112;
        int r16 = getWidth();
        int r17 = getHeight();
        int r18 = r10.getMeasuredWidth();
        int r19 = r10.getMeasuredHeight();
        if (r12 != 1) goto L5;
        r11 = r16 - r11;
    L5:
        int r110 = getKeyline(r11) - r18;
        if (r14 != 1) goto L8;
        r110 = r110 + (r18 / 2);
    L13:
        if (r15 != 16) goto L15;
        int r111 = r19 / 2;
    L19:
        int r112 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r5).leftMargin, Math.min(r110, ((r16 - getPaddingRight()) - r18) - ((ViewGroup.MarginLayoutParams) r5).rightMargin));
        int r20 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r5).topMargin, Math.min(r111, ((r17 - getPaddingBottom()) - r19) - ((ViewGroup.MarginLayoutParams) r5).bottomMargin));
        r10.layout(r112, r20, r18 + r112, r19 + r20);
        return;
    L15:
        if (r15 == 80) goto L17;
        r111 = 0;
        goto L19
    L17:
        r111 = r19;
        goto L19
    L8:
        if (r14 != 5) goto L13;
        r110 = r110 + r18;
        goto L13
    }

    private MotionEvent obtainCancelEvent(MotionEvent r5) {
        MotionEvent r10 = MotionEvent.obtain(r5);
        r10.setAction(3);
        return r10;
    }

    private void offsetChildByInset(View r10, Rect r11, int r12) {
        if (ViewCompat.isLaidOut(r10) == true) goto L6;
        return;
    L6:
        if (r10.getWidth() > 0) goto L8;
        return;
    L8:
        if (r10.getHeight() <= 0) goto L54;
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        Behavior r13 = r5.getBehavior();
        Rect r14 = acquireTempRect();
        Rect r15 = acquireTempRect();
        r15.set(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
        if (r13 != null) goto L13;
    L19:
        r14.set(r15);
    L20:
        releaseTempRect(r15);
        if (r14.isEmpty() == false) goto L24;
        releaseTempRect(r14);
        return;
    L24:
        int r16 = GravityCompat.getAbsoluteGravity(r5.dodgeInsetEdges, r12);
        boolean r17 = true;
        if ((r16 & 48) != 48) goto L29;
        int r18 = (r14.top - ((ViewGroup.MarginLayoutParams) r5).topMargin) - r5.mInsetOffsetY;
        int r19 = r11.top;
        if (r18 >= r19) goto L29;
        setInsetOffsetY(r10, r19 - r18);
        boolean r20 = true;
    L31:
        if ((r16 & 80) != 80) goto L35;
        int r21 = ((getHeight() - r14.bottom) - ((ViewGroup.MarginLayoutParams) r5).bottomMargin) + r5.mInsetOffsetY;
        int r22 = r11.bottom;
        if (r21 >= r22) goto L35;
        setInsetOffsetY(r10, r21 - r22);
        r20 = true;
    L35:
        if (r20 == true) goto L38;
        setInsetOffsetY(r10, 0);
    L38:
        if ((r16 & 3) != 3) goto L42;
        int r23 = (r14.left - ((ViewGroup.MarginLayoutParams) r5).leftMargin) - r5.mInsetOffsetX;
        int r24 = r11.left;
        if (r23 >= r24) goto L42;
        setInsetOffsetX(r10, r24 - r23);
        boolean r25 = true;
    L44:
        if ((r16 & 5) != 5) goto L48;
        int r110 = ((getWidth() - r14.right) - ((ViewGroup.MarginLayoutParams) r5).rightMargin) + r5.mInsetOffsetX;
        int r111 = r11.right;
        if (r110 >= r111) goto L48;
        setInsetOffsetX(r10, r110 - r111);
    L49:
        if (r17 == true) goto L51;
        setInsetOffsetX(r10, 0);
    L51:
        releaseTempRect(r14);
        return;
    L48:
        r17 = r25;
    L42:
        r25 = false;
    L29:
        r20 = false;
        goto L31
    L13:
        if (r13.getInsetDodgeRect(this, r10, r14) == false) goto L19;
        if (r15.contains(r14) == true) goto L20;
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + r14.toShortString() + " | Bounds:" + r15.toShortString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior parseBehavior(Context r5, AttributeSet r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return null;
    L7:
        if (r11.startsWith(".") == false) goto L10;
        r11 = r5.getPackageName() + r11;
    L27:
        ThreadLocal<Map<String, Constructor<Behavior>>> r12 = sConstructors;     // Catch: Exception -> L18
        Map<String, Constructor<Behavior>> r13 = r12.get();     // Catch: Exception -> L18
        if (r13 != null) goto L20;
        r13 = new HashMap();     // Catch: Exception -> L18
        r12.set(r13);     // Catch: Exception -> L18
    L20:
        Constructor<Behavior> r14 = r13.get(r11);     // Catch: Exception -> L18
        if (r14 != null) goto L23;
        r14 = Class.forName(r11, false, r5.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);     // Catch: Exception -> L18
        r14.setAccessible(true);     // Catch: Exception -> L18
        r13.put(r11, r14);     // Catch: Exception -> L18
    L23:
        return r14.newInstance(new Object[]{r5, r10});
    L18:
        e = move-exception;
        throw new RuntimeException(j0.C("Could not inflate Behavior subclass ", r11), e);
    L10:
        if (r11.indexOf(46) >= 0) goto L27;
        String r15 = WIDGET_PACKAGE_NAME;
        if (TextUtils.isEmpty(r15) == true) goto L27;
        r11 = a.m(r15, '.', r11);
        goto L27
    }

    private boolean performEvent(Behavior r5, View r10, MotionEvent r11, int r12) {
        if (r12 == 0) goto L10;
        if (r12 != 1) goto L8;
        return r5.onTouchEvent(this, r10, r11);
    L8:
        throw new IllegalArgumentException();
    L10:
        return r5.onInterceptTouchEvent(this, r10, r11);
    }

    private boolean performIntercept(MotionEvent r14, int r15) {
        int r5 = r14.getActionMasked();
        List<View> r10 = this.mTempList1;
        getTopSortedChildren(r10);
        int r11 = r10.size();
        MotionEvent r12 = null;
        int r13 = 0;
        boolean r16 = false;
        boolean r17 = false;
    L3:
        if (r13 >= r11) goto L38;
        View r18 = r10.get(r13);
        LayoutParams r19 = (LayoutParams) r18.getLayoutParams();
        Behavior r110 = r19.getBehavior();
        if (r16 == true) goto L7;
        if (r17 == true) goto L7;
    L13:
        if (r17 == true) goto L29;
        if (r16 == true) goto L29;
        if (r110 == null) goto L29;
        r16 = performEvent(r110, r18, r14, r15);
        if (r16 == false) goto L29;
        this.mBehaviorTouchView = r18;
        if (r5 == 3) goto L29;
        if (r5 == 1) goto L29;
        int r20 = 0;
    L22:
        if (r20 >= r13) goto L29;
        View r111 = r10.get(r20);
        Behavior r112 = ((LayoutParams) r111.getLayoutParams()).getBehavior();
        if (r112 == null) goto L28;
        if (r12 != null) goto L27;
        r12 = obtainCancelEvent(r14);
    L27:
        performEvent(r112, r111, r12, r15);
    L28:
        r20 = r20 + 1;
    L29:
        boolean r21 = r19.didBlockInteraction();
        boolean r22 = r19.isBlockingInteractionBelow(this, r18);
        if (r22 == false) goto L33;
        if (r21 == true) goto L33;
        r17 = true;
    L34:
        if (r22 == false) goto L37;
        if (r17 == false) goto L38;
    L37:
        r13 = r13 + 1;
    L33:
        r17 = false;
    L7:
        if (r5 == 0) goto L13;
        if (r110 == null) goto L37;
        if (r12 != null) goto L11;
        r12 = obtainCancelEvent(r14);
    L11:
        performEvent(r110, r18, r12, r15);
    L38:
        r10.clear();
        if (r12 == null) goto L41;
        r12.recycle();
    L41:
        return r16;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L16;
        View r11 = getChildAt(r10);
        LayoutParams r12 = getResolvedLayoutParams(r11);
        r12.findAnchorView(this, r11);
        this.mChildDag.addNode(r11);
        int r13 = 0;
    L5:
        if (r13 >= r5) goto L15;
        if (r13 == r10) goto L14;
        View r14 = getChildAt(r13);
        if (r12.dependsOn(this, r11, r14) == false) goto L14;
        if (this.mChildDag.contains(r14) == true) goto L13;
        this.mChildDag.addNode(r14);
    L13:
        this.mChildDag.addEdge(r14, r11);
    L14:
        r13 = r13 + 1;
        goto L5
    L15:
        r10 = r10 + 1;
        goto L3
    L16:
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(@NonNull Rect r5) {
        r5.setEmpty();
        sRectPool.release(r5);
    }

    private void resetTouchBehaviors() {
        View r5 = this.mBehaviorTouchView;
        if (r5 == null) goto L8;
        Behavior r10 = ((LayoutParams) r5.getLayoutParams()).getBehavior();
        if (r10 == null) goto L7;
        long r11 = SystemClock.uptimeMillis();
        MotionEvent r12 = MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0);
        r10.onTouchEvent(this, this.mBehaviorTouchView, r12);
        r12.recycle();
    L7:
        this.mBehaviorTouchView = null;
    L8:
        int r13 = getChildCount();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L11;
        ((LayoutParams) getChildAt(r14).getLayoutParams()).resetTouchBehaviorTracking();
        r14 = r14 + 1;
        goto L9
    L11:
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int r5) {
        if (r5 != 0) goto L5;
        return 17;
    L5:
        return r5;
    }

    private static int resolveGravity(int r5) {
        if ((r5 & 7) != 0) goto L6;
        r5 = r5 | GravityCompat.START;
    L6:
        if ((r5 & 112) == 0) goto L8;
        return r5;
    L8:
        return r5 | 48;
    }

    private static int resolveKeylineGravity(int r5) {
        if (r5 != 0) goto L5;
        return 8388661;
    L5:
        return r5;
    }

    private void setInsetOffsetX(View r5, int r10) {
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        int r12 = r11.mInsetOffsetX;
        if (r12 == r10) goto L6;
        ViewCompat.offsetLeftAndRight(r5, r10 - r12);
        r11.mInsetOffsetX = r10;
        return;
    }

    private void setInsetOffsetY(View r5, int r10) {
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        int r12 = r11.mInsetOffsetY;
        if (r12 == r10) goto L6;
        ViewCompat.offsetTopAndBottom(r5, r10 - r12);
        r11.mInsetOffsetY = r10;
        return;
    }

    private void setupForInsets() {
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        return;
    L5:
        if (this.mApplyWindowInsetsListener != null) goto L7;
        this.mApplyWindowInsetsListener = new AnonymousClass1(this);
    L7:
        ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L8:
        this.mNeedsPreDrawListener = true;
        return;
    L5:
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new OnPreDrawListener(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        goto L8
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r5) == false) goto L7;
        return true;
    }

    public void dispatchDependentViewsChanged(@NonNull View r5) {
        ArrayList<View> r10 = this.mChildDag.getIncomingEdgesInternal(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L17;
        int r11 = 0;
    L8:
        if (r11 >= r10.size()) goto L18;
        View r12 = r10.get(r11);
        Behavior r13 = ((LayoutParams) r12.getLayoutParams()).getBehavior();
        if (r13 == null) goto L12;
        r13.onDependentViewChanged(this, r12, r5);
    L12:
        r11 = r11 + 1;
        goto L8
    L18:
        return;
    }

    public boolean doViewsOverlap(@NonNull View r5, @NonNull View r10) {
        boolean r11 = false;
        if (r5.getVisibility() == 0) goto L5;
    L30:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L30;
        Rect r12 = acquireTempRect();
        if (r5.getParent() == this) goto L9;
        boolean r13 = true;
    L10:
        getChildRect(r5, r13, r12);
        Rect r14 = acquireTempRect();
        if (r10.getParent() == this) goto L13;
        boolean r15 = true;
    L14:
        getChildRect(r10, r15, r14);
    L24:
        th = move-exception;
        releaseTempRect(r12);
        releaseTempRect(r14);
        throw th;
    L16:
        if (r12.left <= r14.right) goto L18;
    L26:
        releaseTempRect(r12);
        releaseTempRect(r14);
        return r11;
    L18:
        if (r12.top > r14.bottom) goto L26;
        if (r12.right < r14.left) goto L26;
        if (r12.bottom < r14.top) goto L26;
        r11 = true;
        goto L26
    L13:
        r15 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        LayoutParams r5 = (LayoutParams) r11.getLayoutParams();
        Behavior r13 = r5.mBehavior;
        if (r13 == null) goto L14;
        float r14 = r13.getScrimOpacity(this, r11);
        if (r14 <= 0.0f) goto L14;
        if (this.mScrimPaint != null) goto L9;
        this.mScrimPaint = new Paint();
    L9:
        this.mScrimPaint.setColor(r5.mBehavior.getScrimColor(this, r11));
        this.mScrimPaint.setAlpha(clamp(Math.round(r14 * 255.0f), 0, 255));
        int r15 = r10.save();
        if (r11.isOpaque() == false) goto L12;
        r10.clipRect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom(), Region.Op.DIFFERENCE);
    L12:
        r10.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        r10.restoreToCount(r15);
    L14:
        return super.drawChild(r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r5 = getDrawableState();
        Drawable r10 = this.mStatusBarBackground;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r10.isStateful() == false) goto L7;
        r11 = r10.setState(r5);
        goto L8
    }

    public void ensurePreDrawListener() {
        int r5 = getChildCount();
        boolean r10 = false;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L9;
        if (hasDependencies(getChildAt(r11)) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        r10 = true;
    L9:
        if (r10 == this.mNeedsPreDrawListener) goto L16;
        if (r10 == false) goto L12;
        addPreDrawListener();
        return;
    L12:
        removePreDrawListener();
        return;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    public void getChildRect(View r5, boolean r10, Rect r11) {
        if (r5.isLayoutRequested() == false) goto L5;
    L11:
        r11.setEmpty();
        return;
    L5:
        if (r5.getVisibility() == 8) goto L11;
        if (r10 == false) goto L9;
        getDescendantRect(r5, r11);
        return;
    L9:
        r11.set(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom());
    }

    @NonNull
    public List<View> getDependencies(@NonNull View r5) {
        List<View> r10 = this.mChildDag.getOutgoingEdges(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyList();
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @NonNull
    public List<View> getDependents(@NonNull View r5) {
        List<View> r10 = this.mChildDag.getIncomingEdges(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyList();
    }

    public void getDescendantRect(View r5, Rect r10) {
        ViewGroupUtils.getDescendantRect(this, r5, r10);
    }

    public void getDesiredAnchoredChildRect(View r10, int r11, Rect r12, Rect r13) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        int r14 = r10.getMeasuredWidth();
        int r15 = r10.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r11, r12, r13, r5, r14, r15);
        constrainChildRect(r5, r13, r14, r15);
    }

    public void getLastChildRect(View r5, Rect r10) {
        r10.set(((LayoutParams) r5.getLayoutParams()).getLastChildRect());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutParams getResolvedLayoutParams(View r10) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        if (r5.mBehaviorResolved == false) goto L5;
    L21:
        return r5;
    L5:
        if ((r10 instanceof AttachedBehavior) == false) goto L10;
        Behavior r11 = ((AttachedBehavior) r10).getBehavior();
        if (r11 != null) goto L9;
        Log.e(TAG, "Attached behavior class is null");
    L9:
        r5.setBehavior(r11);
        r5.mBehaviorResolved = true;
        goto L21
    L10:
        Class<?> r12 = r10.getClass();
        DefaultBehavior r13 = null;
    L11:
        if (r12 == null) goto L15;
        r13 = (DefaultBehavior) r12.getAnnotation(DefaultBehavior.class);
        if (r13 != null) goto L15;
        r12 = r12.getSuperclass();
    L15:
        if (r13 != null) goto L22;
    L20:
        r5.mBehaviorResolved = true;
        goto L21
    L22:
        r5.setBehavior(r13.value().getDeclaredConstructor(null).newInstance(null));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.e(TAG, "Default behavior class " + r13.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
        goto L20
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        int r5 = super.getSuggestedMinimumHeight();
        int r10 = getPaddingTop();
        return Math.max(r5, getPaddingBottom() + r10);
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        int r5 = super.getSuggestedMinimumWidth();
        int r10 = getPaddingLeft();
        return Math.max(r5, getPaddingRight() + r10);
    }

    public boolean isPointInChildBounds(@NonNull View r5, int r10, int r11) {
        Rect r12 = acquireTempRect();
        getDescendantRect(r5, r12);
        boolean r13 = r12.contains(r10, r11);     // Catch: Throwable -> L6
        releaseTempRect(r12);
        return r13;
    L6:
        th = move-exception;
        releaseTempRect(r12);
        throw th;
    }

    public void offsetChildToAnchor(View r17, int r18) {
        LayoutParams r10 = (LayoutParams) r17.getLayoutParams();
        if (r10.mAnchorView == null) goto L20;
        Rect r11 = acquireTempRect();
        Rect r12 = acquireTempRect();
        Rect r13 = acquireTempRect();
        getDescendantRect(r10.mAnchorView, r11);
        boolean r14 = false;
        getChildRect(r17, false, r12);
        int r15 = r17.getMeasuredWidth();
        int r16 = r17.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r18, r11, r13, r10, r15, r16);
        if (r13.left == r12.left) goto L7;
    L8:
        r14 = true;
    L9:
        constrainChildRect(r10, r13, r15, r16);
        int r5 = r13.left - r12.left;
        int r19 = r13.top - r12.top;
        if (r5 == 0) goto L12;
        ViewCompat.offsetLeftAndRight(r17, r5);
    L12:
        if (r19 == 0) goto L14;
        ViewCompat.offsetTopAndBottom(r17, r19);
    L14:
        if (r14 == false) goto L18;
        Behavior r20 = r10.getBehavior();
        if (r20 == null) goto L18;
        r20.onDependentViewChanged(this, r17, r10.mAnchorView);
    L18:
        releaseTempRect(r11);
        releaseTempRect(r12);
        releaseTempRect(r13);
        return;
    L7:
        if (r13.top == r12.top) goto L9;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener == false) goto L9;
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new OnPreDrawListener(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    L9:
        if (this.mLastInsets == null) goto L11;
    L13:
        this.mIsAttachedToWindow = true;
        return;
    L11:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L13;
        ViewCompat.requestApplyInsets(this);
        goto L13
    }

    public final void onChildViewsChanged(int r18) {
        int r5 = ViewCompat.getLayoutDirection(this);
        int r10 = this.mDependencySortedChildren.size();
        Rect r11 = acquireTempRect();
        Rect r12 = acquireTempRect();
        Rect r13 = acquireTempRect();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L61;
        View r15 = this.mDependencySortedChildren.get(r14);
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        if (r18 == 0) goto L7;
    L9:
        int r17 = 0;
    L10:
        if (r17 >= r14) goto L15;
        if (r16.mAnchorDirectChild != this.mDependencySortedChildren.get(r17)) goto L14;
        offsetChildToAnchor(r15, r5);
    L14:
        r17 = r17 + 1;
        goto L10
    L15:
        getChildRect(r15, true, r12);
        if (r16.insetEdge == 0) goto L34;
        if (r12.isEmpty() == true) goto L34;
        int r19 = GravityCompat.getAbsoluteGravity(r16.insetEdge, r5);
        int r110 = r19 & 112;
        if (r110 != 48) goto L22;
        r11.top = Math.max(r11.top, r12.bottom);
    L26:
        int r111 = r19 & 7;
        if (r111 != 3) goto L29;
        r11.left = Math.max(r11.left, r12.right);
        goto L34
    L29:
        if (r111 != 5) goto L34;
        r11.right = Math.max(r11.right, getWidth() - r12.left);
        goto L34
    L22:
        if (r110 != 80) goto L26;
        r11.bottom = Math.max(r11.bottom, getHeight() - r12.top);
    L34:
        if (r16.dodgeInsetEdges == 0) goto L39;
        if (r15.getVisibility() != 0) goto L39;
        offsetChildByInset(r15, r11, r5);
    L39:
        if (r18 == 2) goto L44;
        getLastChildRect(r15, r13);
        if (r13.equals(r12) == true) goto L60;
        recordLastChildRect(r15, r12);
    L60:
        r14 = r14 + 1;
    L44:
        int r112 = r14 + 1;
    L45:
        if (r112 >= r10) goto L60;
        View r113 = this.mDependencySortedChildren.get(r112);
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        Behavior r115 = r114.getBehavior();
        if (r115 == null) goto L59;
        if (r115.layoutDependsOn(this, r113, r15) == false) goto L59;
        if (r18 == 0) goto L52;
    L54:
        if (r18 == 2) goto L56;
        boolean r116 = r115.onDependentViewChanged(this, r113, r15);
    L57:
        if (r18 != 1) goto L59;
        r114.setChangedAfterNestedScroll(r116);
        goto L59
    L56:
        r115.onDependentViewRemoved(this, r113, r15);
        r116 = true;
        goto L57
    L52:
        if (r114.getChangedAfterNestedScroll() == false) goto L54;
        r114.resetChangedAfterNestedScroll();
    L59:
        r112 = r112 + 1;
        goto L45
    L7:
        if (r15.getVisibility() != 8) goto L9;
    L61:
        releaseTempRect(r11);
        releaseTempRect(r12);
        releaseTempRect(r13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener == true) goto L5;
    L7:
        View r5 = this.mNestedScrollingTarget;
        if (r5 == null) goto L10;
        onStopNestedScroll(r5);
    L10:
        this.mIsAttachedToWindow = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        WindowInsetsCompat r10 = this.mLastInsets;
        if (r10 == null) goto L9;
        int r11 = r10.getSystemWindowInsetTop();
    L10:
        if (r11 <= 0) goto L15;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r11);
        this.mStatusBarBackground.draw(r5);
        return;
    L15:
        return;
    L9:
        r11 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        int r10 = r5.getActionMasked();
        if (r10 != 0) goto L5;
        resetTouchBehaviors();
    L5:
        boolean r11 = performIntercept(r5, 0);
        if (r10 != 1) goto L8;
    L9:
        this.mBehaviorTouchView = null;
        resetTouchBehaviors();
    L10:
        return r11;
    L8:
        if (r10 != 3) goto L10;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = ViewCompat.getLayoutDirection(this);
        int r15 = this.mDependencySortedChildren.size();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L13;
        View r17 = this.mDependencySortedChildren.get(r16);
        if (r17.getVisibility() == 8) goto L12;
        Behavior r18 = ((LayoutParams) r17.getLayoutParams()).getBehavior();
        if (r18 != null) goto L10;
    L11:
        onLayoutChild(r17, r14);
        goto L12
    L10:
        if (r18.onLayoutChild(this, r17, r14) == false) goto L11;
    L12:
        r16 = r16 + 1;
        goto L3
    }

    public void onLayoutChild(@NonNull View r5, int r10) {
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        if (r11.checkAnchorChanged() == true) goto L13;
        View r12 = r11.mAnchorView;
        if (r12 == null) goto L7;
        layoutChildWithAnchor(r5, r12, r10);
        return;
    L7:
        int r13 = r11.keyline;
        if (r13 < 0) goto L10;
        layoutChildWithKeyline(r5, r13, r10);
        return;
    L10:
        layoutChild(r5, r10);
        return;
    L13:
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.View
    public void onMeasure(int r31, int r32) {
        prepareChildren();
        ensurePreDrawListener();
        int r10 = getPaddingLeft();
        int r5 = getPaddingTop();
        int r11 = getPaddingRight();
        int r12 = getPaddingBottom();
        int r13 = ViewCompat.getLayoutDirection(this);
        if (r13 != 1) goto L5;
        boolean r14 = true;
    L6:
        int r15 = View.MeasureSpec.getMode(r31);
        int r16 = View.MeasureSpec.getSize(r31);
        int r17 = View.MeasureSpec.getMode(r32);
        int r18 = View.MeasureSpec.getSize(r32);
        int r19 = r10 + r11;
        int r110 = r5 + r12;
        int r20 = getSuggestedMinimumWidth();
        int r21 = getSuggestedMinimumHeight();
        if (this.mLastInsets != null) goto L9;
    L11:
        boolean r111 = false;
    L12:
        int r22 = this.mDependencySortedChildren.size();
        int r23 = r20;
        int r24 = r21;
        int r25 = 0;
        int r26 = 0;
    L13:
        if (r26 >= r22) goto L50;
        View r27 = this.mDependencySortedChildren.get(r26);
        if (r27.getVisibility() != 8) goto L17;
        int r28 = r26;
        int r29 = r22;
        int r210 = r10;
    L49:
        r26 = r28 + 1;
        r10 = r210;
        r22 = r29;
        goto L13
    L17:
        LayoutParams r30 = (LayoutParams) r27.getLayoutParams();
        int r33 = r30.keyline;
        if (r33 < 0) goto L34;
        if (r15 == 0) goto L34;
        int r34 = getKeyline(r33);
        int r112 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r30.gravity), r13) & 7;
        int r211 = r25;
        if (r112 != 3) goto L24;
        if (r14 == true) goto L24;
    L26:
        int r212 = Math.max(0, (r16 - r11) - r34);
    L36:
        if (r111 == true) goto L38;
    L40:
        int r113 = r31;
        int r213 = r32;
    L41:
        Behavior r35 = r30.getBehavior();
        if (r35 == null) goto L46;
        LayoutParams r214 = r30;
        int r215 = r211;
        r28 = r26;
        int r216 = r24;
        r210 = r10;
        int r36 = r23;
        r29 = r22;
        if (r35.onMeasureChild(this, r27, r113, r212, r213, 0) == false) goto L47;
    L48:
        LayoutParams r37 = r214;
        int r38 = Math.max(r36, ((r27.getMeasuredWidth() + r19) + ((ViewGroup.MarginLayoutParams) r37).leftMargin) + ((ViewGroup.MarginLayoutParams) r37).rightMargin);
        int r39 = Math.max(r216, ((r27.getMeasuredHeight() + r110) + ((ViewGroup.MarginLayoutParams) r37).topMargin) + ((ViewGroup.MarginLayoutParams) r37).bottomMargin);
        r25 = View.combineMeasuredStates(r215, r27.getMeasuredState());
        r23 = r38;
        r24 = r39;
    L47:
        onMeasureChild(r27, r113, r212, r213, 0);
        goto L48
    L46:
        r214 = r30;
        r216 = r24;
        r29 = r22;
        r210 = r10;
        r215 = r211;
        r28 = r26;
        r36 = r23;
        goto L47
    L38:
        if (ViewCompat.getFitsSystemWindows(r27) == true) goto L40;
        int r40 = this.mLastInsets.getSystemWindowInsetRight() + this.mLastInsets.getSystemWindowInsetLeft();
        int r114 = this.mLastInsets.getSystemWindowInsetBottom() + this.mLastInsets.getSystemWindowInsetTop();
        int r41 = View.MeasureSpec.makeMeasureSpec(r16 - r40, r15);
        int r42 = View.MeasureSpec.makeMeasureSpec(r18 - r114, r17);
        r113 = r41;
        r213 = r42;
    L24:
        if (r112 != 5) goto L27;
        if (r14 == true) goto L26;
    L27:
        if (r112 != 5) goto L30;
        if (r14 == true) goto L30;
    L32:
        r212 = Math.max(0, r34 - r10);
    L30:
        if (r112 != 3) goto L35;
        if (r14 == true) goto L32;
    L35:
        r212 = 0;
    L34:
        r211 = r25;
        goto L35
    L50:
        int r115 = r25;
        setMeasuredDimension(View.resolveSizeAndState(r23, r31, (-16777216) & r115), View.resolveSizeAndState(r24, r32, r115 << 16));
        return;
    L9:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L11;
        r111 = true;
        goto L12
    L5:
        r14 = false;
        goto L6
    }

    public void onMeasureChild(View r5, int r10, int r11, int r12, int r13) {
        measureChildWithMargins(r5, r10, r11, r12, r13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r12, float r13, float r14, boolean r15) {
        int r5 = getChildCount();
        int r10 = 0;
        boolean r11 = false;
    L3:
        if (r10 >= r5) goto L14;
        View r16 = getChildAt(r10);
        if (r16.getVisibility() == 8) goto L13;
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        if (r17.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r18 = r17.getBehavior();
        if (r18 == null) goto L13;
        r11 = r11 | r18.onNestedFling(this, r16, r12, r13, r14, r15);
    L13:
        r10 = r10 + 1;
        goto L3
    L14:
        if (r11 == false) goto L16;
        onChildViewsChanged(1);
    L16:
        return r11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r11, float r12, float r13) {
        int r5 = getChildCount();
        int r10 = 0;
        boolean r14 = false;
    L3:
        if (r10 >= r5) goto L14;
        View r15 = getChildAt(r10);
        if (r15.getVisibility() == 8) goto L13;
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        if (r16.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r17 = r16.getBehavior();
        if (r17 == null) goto L13;
        r14 = r14 | r17.onNestedPreFling(this, r15, r11, r12, r13);
    L13:
        r10 = r10 + 1;
        goto L3
    L14:
        return r14;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        onNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r10, r11, r12, r13, r14, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r5, View r10, int r11) {
        onNestedScrollAccepted(r5, r10, r11, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        SparseArray<Parcelable> r12 = r11.behaviorStates;
        int r5 = getChildCount();
        int r13 = 0;
    L7:
        if (r13 >= r5) goto L15;
        View r14 = getChildAt(r13);
        int r15 = r14.getId();
        Behavior r16 = getResolvedLayoutParams(r14).getBehavior();
        if (r15 == (-1)) goto L14;
        if (r16 == null) goto L14;
        Parcelable r17 = r12.get(r15);
        if (r17 == null) goto L14;
        r16.onRestoreInstanceState(this, r14, r17);
    L14:
        r13 = r13 + 1;
        goto L7
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> r10 = new SparseArray();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        View r13 = getChildAt(r12);
        int r14 = r13.getId();
        Behavior r15 = ((LayoutParams) r13.getLayoutParams()).getBehavior();
        if (r14 == (-1)) goto L10;
        if (r15 == null) goto L10;
        Parcelable r16 = r15.onSaveInstanceState(this, r13);
        if (r16 == null) goto L10;
        r10.append(r14, r16);
    L10:
        r12 = r12 + 1;
        goto L3
    L11:
        r5.behaviorStates = r10;
        return r5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r5, View r10, int r11) {
        return onStartNestedScroll(r5, r10, r11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r5) {
        onStopNestedScroll(r5, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r5 = r10.getActionMasked();
        View r11 = this.mBehaviorTouchView;
        boolean r12 = false;
        if (r11 == null) goto L8;
        Behavior r13 = ((LayoutParams) r11.getLayoutParams()).getBehavior();
        if (r13 == null) goto L7;
        boolean r14 = r13.onTouchEvent(this, this.mBehaviorTouchView, r10);
    L13:
        if (this.mBehaviorTouchView == null) goto L18;
        if (r5 == 3) goto L18;
        if (r12 == false) goto L19;
        MotionEvent r15 = obtainCancelEvent(r10);
        super.onTouchEvent(r15);
        r15.recycle();
    L19:
        if (r5 == 1) goto L21;
        if (r5 == 3) goto L21;
    L22:
        return r14;
    L21:
        this.mBehaviorTouchView = null;
        resetTouchBehaviors();
    L18:
        r14 = r14 | super.onTouchEvent(r10);
        goto L19
    L7:
        r14 = false;
        goto L13
    L8:
        r14 = performIntercept(r10, 1);
        if (r5 == 0) goto L13;
        if (r14 == false) goto L13;
        r12 = true;
        goto L13
    }

    public void recordLastChildRect(View r5, Rect r10) {
        ((LayoutParams) r5.getLayoutParams()).setLastChildRect(r10);
    }

    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L7:
        this.mNeedsPreDrawListener = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r5, Rect r10, boolean r11) {
        Behavior r12 = ((LayoutParams) r5.getLayoutParams()).getBehavior();
        if (r12 == null) goto L9;
        if (r12.onRequestChildRectangleOnScreen(this, r5, r10, r11) == false) goto L9;
        return true;
    L9:
        return super.requestChildRectangleOnScreen(r5, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r5) {
        super.requestDisallowInterceptTouchEvent(r5);
        if (r5 == true) goto L5;
        return;
    L5:
        if (this.mDisallowInterceptReset == false) goto L7;
        return;
    L7:
        if (this.mBehaviorTouchView != null) goto L9;
        cancelInterceptBehaviors();
    L9:
        resetTouchBehaviors();
        this.mDisallowInterceptReset = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean r5) {
        super.setFitsSystemWindows(r5);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r5) {
        this.mOnHierarchyChangeListener = r5;
    }

    public void setStatusBarBackground(@Nullable Drawable r5) {
        Drawable r10 = this.mStatusBarBackground;
        if (r10 == r5) goto L21;
        Drawable r11 = null;
        if (r10 == null) goto L7;
        r10.setCallback(null);
    L7:
        if (r5 == null) goto L9;
        r11 = r5.mutate();
    L9:
        this.mStatusBarBackground = r11;
        if (r11 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r11.isStateful() == false) goto L14;
        this.mStatusBarBackground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        Drawable r12 = this.mStatusBarBackground;
        if (getVisibility() != 0) goto L17;
        boolean r13 = true;
    L18:
        r12.setVisible(r13, false);
        this.mStatusBarBackground.setCallback(this);
        goto L19
    L17:
        r13 = false;
        goto L18
    }

    public void setStatusBarBackgroundColor(@ColorInt int r5) {
        setStatusBarBackground(new ColorDrawable(r5));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = ContextCompat.getDrawable(getContext(), r5);
    L5:
        setStatusBarBackground(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        if (r5 != 0) goto L5;
        boolean r10 = true;
    L6:
        Drawable r11 = this.mStatusBarBackground;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.isVisible() == r10) goto L13;
        this.mStatusBarBackground.setVisible(r10, false);
        return;
    L13:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat r5) {
        if (ObjectsCompat.equals(this.mLastInsets, r5) == true) goto L17;
        this.mLastInsets = r5;
        boolean r10 = false;
        if (r5 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        this.mDrawStatusBarBackground = r11;
        if (r11 == false) goto L13;
    L15:
        setWillNotDraw(r10);
        WindowInsetsCompat r12 = dispatchApplyWindowInsetsToBehaviors(r5);
        requestLayout();
        return r12;
    L13:
        if (getBackground() != null) goto L15;
        r10 = true;
        goto L15
    L7:
        if (r5.getSystemWindowInsetTop() <= 0) goto L9;
        r11 = true;
        goto L10
    L17:
        return r5;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r5) {
        if (super.verifyDrawable(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5 == this.mStatusBarBackground) goto L8;
        return false;
    }

    public CoordinatorLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r17, int r18, int r19, int[] r20, int r21) {
        int r10 = getChildCount();
        boolean r5 = false;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11 >= r10) goto L24;
        View r14 = getChildAt(r11);
        if (r14.getVisibility() == 8) goto L23;
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (r15.isNestedScrollAccepted(r21) == false) goto L23;
        Behavior r16 = r15.getBehavior();
        if (r16 == null) goto L23;
        int[] r22 = this.mBehaviorConsumed;
        r22[0] = 0;
        r22[1] = 0;
        r16.onNestedPreScroll(this, r14, r17, r18, r19, r22, r21);
        if (r18 <= 0) goto L17;
        int r23 = Math.max(r12, this.mBehaviorConsumed[0]);
    L16:
        r12 = r23;
        if (r19 <= 0) goto L21;
        int r24 = Math.max(r13, this.mBehaviorConsumed[1]);
    L20:
        r13 = r24;
        r5 = true;
        goto L23
    L21:
        r24 = Math.min(r13, this.mBehaviorConsumed[1]);
        goto L20
    L17:
        r23 = Math.min(r12, this.mBehaviorConsumed[0]);
    L23:
        r11 = r11 + 1;
        goto L4
    L24:
        r20[0] = r12;
        r20[1] = r13;
        if (r5 == false) goto L33;
        onChildViewsChanged(1);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        onNestedScroll(r10, r11, r12, r13, r14, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(r10, r11, r12, r13);
        this.mNestedScrollingTarget = r11;
        int r5 = getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L11;
        View r15 = getChildAt(r14);
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        if (r16.isNestedScrollAccepted(r13) == false) goto L10;
        Behavior r17 = r16.getBehavior();
        if (r17 == null) goto L10;
        r17.onNestedScrollAccepted(this, r15, r10, r11, r12, r13);
    L10:
        r14 = r14 + 1;
        goto L3
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r15, View r16, int r17, int r18) {
        int r10 = getChildCount();
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 >= r10) goto L12;
        View r5 = getChildAt(r11);
        if (r5.getVisibility() == 8) goto L11;
        LayoutParams r13 = (LayoutParams) r5.getLayoutParams();
        Behavior r14 = r13.getBehavior();
        if (r14 == null) goto L10;
        boolean r19 = r14.onStartNestedScroll(this, r5, r15, r16, r17, r18);
        r12 = r12 | r19;
        r13.setNestedScrollAccepted(r18, r19);
        goto L11
    L10:
        r13.setNestedScrollAccepted(r18, false);
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        return r12;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(r10, r11);
        int r5 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L12;
        View r13 = getChildAt(r12);
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        if (r14.isNestedScrollAccepted(r11) == false) goto L11;
        Behavior r15 = r14.getBehavior();
        if (r15 == null) goto L10;
        r15.onStopNestedScroll(this, r13, r10, r11);
    L10:
        r14.resetNestedScroll(r11);
        r14.resetChangedAfterNestedScroll();
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        int r5 = 0;
        if (r12 != 0) goto L5;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
    L6:
        if (r12 != 0) goto L8;
        ViewCompat.saveAttributeDataForStyleable(this, r10, R.styleable.CoordinatorLayout, r11, r13, 0, R.style.Widget_Support_CoordinatorLayout);
    L9:
        int r14 = r13.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (r14 == 0) goto L14;
        Resources r15 = r10.getResources();
        this.mKeylines = r15.getIntArray(r14);
        float r16 = r15.getDisplayMetrics().density;
        int r17 = this.mKeylines.length;
    L12:
        if (r5 >= r17) goto L14;
        int[] r18 = this.mKeylines;
        r18[r5] = (int) (r18[r5] * r16);
        r5 = r5 + 1;
    L14:
        this.mStatusBarBackground = r13.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        r13.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L19;
        ViewCompat.setImportantForAccessibility(this, 1);
        return;
    L19:
        return;
    L8:
        ViewCompat.saveAttributeDataForStyleable(this, r10, R.styleable.CoordinatorLayout, r11, r13, r12, 0);
        goto L9
    L5:
        r13 = r10.obtainStyledAttributes(r11, R.styleable.CoordinatorLayout, r12, 0);
        goto L6
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r18, int r19, int r20, int r21, int r22, int r23, @NonNull int[] r24) {
        int r11 = getChildCount();
        boolean r5 = false;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r11) goto L24;
        View r10 = getChildAt(r13);
        if (r10.getVisibility() == 8) goto L23;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (r12.isNestedScrollAccepted(r23) == false) goto L23;
        Behavior r16 = r12.getBehavior();
        if (r16 == null) goto L23;
        int[] r17 = this.mBehaviorConsumed;
        r17[0] = 0;
        r17[1] = 0;
        r16.onNestedScroll(this, r10, r18, r19, r20, r21, r22, r23, r17);
        if (r21 <= 0) goto L17;
        int r25 = Math.max(r14, this.mBehaviorConsumed[0]);
    L16:
        r14 = r25;
        if (r22 <= 0) goto L21;
        boolean r26 = true;
        int r27 = Math.max(r15, this.mBehaviorConsumed[1]);
    L20:
        r15 = r27;
        r5 = r26;
        goto L23
    L21:
        r26 = true;
        r27 = Math.min(r15, this.mBehaviorConsumed[1]);
        goto L20
    L17:
        r25 = Math.min(r14, this.mBehaviorConsumed[0]);
    L23:
        r13 = r13 + 1;
        goto L4
    L24:
        r24[0] = r24[0] + r14;
        r24[1] = r24[1] + r15;
        if (r5 == false) goto L33;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r5);
    L7:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L11:
        return new LayoutParams(r5);
    }
}
