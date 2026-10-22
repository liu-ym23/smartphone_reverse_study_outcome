package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.google.android.material.card.MaterialCardView;
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
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public Behavior(Context r10, AttributeSet r11) {
        }

        @Nullable
        public static Object getTag(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mBehaviorTag;
        }

        public static void setTag(@NonNull View r10, @Nullable Object r11) {
            ((LayoutParams) r10.getLayoutParams()).mBehaviorTag = r11;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            if (getScrimOpacity(r10, r11) <= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Rect r12) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull WindowInsetsCompat r12) {
            return r12;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams r10) {
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12, int r13, int r14, int r15) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, float r13, float r14, boolean r15) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, float r13, float r14) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, @NonNull int[] r15) {
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, @NonNull int[] r15, int r16) {
            if (r16 != 0) goto L5;
            onNestedPreScroll(r10, r11, r12, r13, r14, r15);
            return;
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16, int r17) {
            if (r17 != 0) goto L5;
            onNestedScroll(r10, r11, r12, r13, r14, r15, r16);
            return;
        }

        public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16, int r17, @NonNull int[] r18) {
            r18[0] = r18[0] + r15;
            r18[1] = r18[1] + r16;
            onNestedScroll(r10, r11, r12, r13, r14, r15, r16, r17);
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14) {
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            if (r15 != 0) goto L5;
            onNestedScrollAccepted(r10, r11, r12, r13, r14);
            return;
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Rect r12, boolean r13) {
            return false;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Parcelable r12) {
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14) {
            return false;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            if (r15 == 0) goto L4;
            return false;
        L4:
            return onStartNestedScroll(r10, r11, r12, r13, r14);
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13) {
            if (r13 != 0) goto L5;
            onStopNestedScroll(r10, r11, r12);
            return;
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
            return false;
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

    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout this$0;

        HierarchyChangeListener(CoordinatorLayout r10) {
            this.this$0 = r10;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r10, View r11) {
            ViewGroup.OnHierarchyChangeListener r12 = this.this$0.mOnHierarchyChangeListener;
            if (r12 == null) goto L6;
            r12.onChildViewAdded(r10, r11);
            return;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r10, View r11) {
            this.this$0.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener r12 = this.this$0.mOnHierarchyChangeListener;
            if (r12 == null) goto L6;
            r12.onChildViewRemoved(r10, r11);
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

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        LayoutParams(@NonNull Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.CoordinatorLayout_Layout);
            this.gravity = r12.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = r12.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = r12.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = r12.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = r12.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = r12.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int r13 = R.styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean r14 = r12.hasValue(r13);
            this.mBehaviorResolved = r14;
            if (r14 == false) goto L5;
            this.mBehavior = CoordinatorLayout.parseBehavior(r10, r11, r12.getString(r13));
        L5:
            r12.recycle();
            Behavior r15 = this.mBehavior;
            if (r15 == null) goto L9;
            r15.onAttachedToLayoutParams(this);
            return;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        private void resolveAnchorView(View r10, CoordinatorLayout r11) {
            View r12 = r11.findViewById(this.mAnchorId);
            this.mAnchorView = r12;
            if (r12 == null) goto L27;
            if (r12 == r11) goto L6;
            ViewParent r13 = r12.getParent();
        L12:
            if (r13 == r11) goto L24;
            if (r13 == null) goto L24;
            if (r13 == r10) goto L16;
            if ((r13 instanceof View) == false) goto L23;
            r12 = r13;
        L23:
            r13 = r13.getParent();
            goto L12
        L16:
            if (r11.isInEditMode() == false) goto L19;
        L7:
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        L19:
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        L24:
            this.mAnchorDirectChild = r12;
            return;
        L6:
            if (r11.isInEditMode() == true) goto L7;
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        L27:
            if (r11.isInEditMode() == true) goto L7;
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + r11.getResources().getResourceName(this.mAnchorId) + " to anchor view " + r10);
        }

        private boolean shouldDodge(View r10, int r11) {
            int r12 = GravityCompat.getAbsoluteGravity(((LayoutParams) r10.getLayoutParams()).insetEdge, r11);
            if (r12 != 0) goto L5;
        L7:
            return false;
        L5:
            if ((GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, r11) & r12) != r12) goto L7;
            return true;
        }

        private boolean verifyAnchorView(View r10, CoordinatorLayout r11) {
            if (this.mAnchorView.getId() == this.mAnchorId) goto L5;
            return false;
        L5:
            View r12 = this.mAnchorView;
            ViewParent r13 = r12.getParent();
        L6:
            if (r13 == r11) goto L16;
            if (r13 == null) goto L14;
            if (r13 == r10) goto L14;
            if ((r13 instanceof View) == false) goto L13;
            r12 = r13;
        L13:
            r13 = r13.getParent();
        L14:
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return false;
        L16:
            this.mAnchorDirectChild = r12;
            return true;
        }

        boolean checkAnchorChanged() {
            if (this.mAnchorView == null) goto L5;
        L7:
            return false;
        L5:
            if (this.mAnchorId == (-1)) goto L7;
            return true;
        }

        boolean dependsOn(CoordinatorLayout r10, View r11, View r12) {
            if (r12 != this.mAnchorDirectChild) goto L5;
        L12:
            return true;
        L5:
            if (shouldDodge(r12, ViewCompat.getLayoutDirection(r10)) == true) goto L12;
            Behavior r13 = this.mBehavior;
            if (r13 != null) goto L9;
        L11:
            return false;
        L9:
            if (r13.layoutDependsOn(r10, r11, r12) == false) goto L11;
            goto L11
        }

        boolean didBlockInteraction() {
            if (this.mBehavior != null) goto L6;
            this.mDidBlockInteraction = false;
        L6:
            return this.mDidBlockInteraction;
        }

        View findAnchorView(CoordinatorLayout r10, View r11) {
            if (this.mAnchorId != (-1)) goto L7;
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        L7:
            if (this.mAnchorView != null) goto L9;
        L10:
            resolveAnchorView(r11, r10);
        L12:
            return this.mAnchorView;
        L9:
            if (verifyAnchorView(r11, r10) == true) goto L12;
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

        boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        boolean isBlockingInteractionBelow(CoordinatorLayout r10, View r11) {
            boolean r12 = this.mDidBlockInteraction;
            if (r12 == false) goto L6;
            return true;
        L6:
            Behavior r13 = this.mBehavior;
            if (r13 == null) goto L9;
            boolean r14 = r13.blocksInteractionBelow(r10, r11);
        L10:
            boolean r15 = r14 | r12;
            this.mDidBlockInteraction = r15;
            return r15;
        L9:
            r14 = false;
            goto L10
        }

        boolean isNestedScrollAccepted(int r10) {
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L8;
            return false;
        L8:
            return this.mDidAcceptNestedScrollNonTouch;
        L10:
            return this.mDidAcceptNestedScrollTouch;
        }

        void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        void resetNestedScroll(int r10) {
            setNestedScrollAccepted(r10, false);
        }

        void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public void setAnchorId(@IdRes int r10) {
            invalidateAnchor();
            this.mAnchorId = r10;
        }

        public void setBehavior(@Nullable Behavior r10) {
            Behavior r11 = this.mBehavior;
            if (r11 == r10) goto L10;
            if (r11 == null) goto L6;
            r11.onDetachedFromLayoutParams();
        L6:
            this.mBehavior = r10;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (r10 == null) goto L11;
            r10.onAttachedToLayoutParams(this);
            return;
        L11:
            return;
        }

        void setChangedAfterNestedScroll(boolean r10) {
            this.mDidChangeAfterNestedScroll = r10;
        }

        void setLastChildRect(Rect r10) {
            this.mLastChildRect.set(r10);
        }

        void setNestedScrollAccepted(int r10, boolean r11) {
            if (r10 != 0) goto L4;
            this.mDidAcceptNestedScrollTouch = r11;
            return;
        L4:
            if (r10 != 1) goto L10;
            this.mDidAcceptNestedScrollNonTouch = r11;
            return;
        }
    }

    class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout this$0;

        OnPreDrawListener(CoordinatorLayout r10) {
            this.this$0 = r10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.this$0.onChildViewsChanged(0);
            return true;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        SparseArray<Parcelable> behaviorStates;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            int r12 = r10.readInt();
            int[] r13 = new int[r12];
            r10.readIntArray(r13);
            Parcelable[] r14 = r10.readParcelableArray(r11);
            this.behaviorStates = new SparseArray(r12);
            int r15 = 0;
        L3:
            if (r15 >= r12) goto L5;
            this.behaviorStates.append(r13[r15], r14[r15]);
            r15 = r15 + 1;
            goto L3
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            SparseArray<Parcelable> r12 = this.behaviorStates;
            int r13 = 0;
            if (r12 == null) goto L5;
            int r14 = r12.size();
        L6:
            r10.writeInt(r14);
            int[] r15 = new int[r14];
            Parcelable[] r16 = new Parcelable[r14];
        L7:
            if (r13 >= r14) goto L9;
            r15[r13] = this.behaviorStates.keyAt(r13);
            r16[r13] = this.behaviorStates.valueAt(r13);
            r13 = r13 + 1;
            goto L7
        L9:
            r10.writeIntArray(r15);
            r10.writeParcelableArray(r16, r11);
            return;
        L5:
            r14 = 0;
            goto L6
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(View r10, View r11) {
            float r12 = ViewCompat.getZ(r10);
            float r13 = ViewCompat.getZ(r11);
            if (r12 <= r13) goto L7;
            return -1;
        L7:
            if (r12 >= r13) goto L10;
            return 1;
        L10:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(View r10, View r11) {
            return compare2(r10, r11);
        }
    }

    static {
        Package r10 = CoordinatorLayout.class.getPackage();
        if (r10 == null) goto L5;
        String r11 = r10.getName();
    L6:
        WIDGET_PACKAGE_NAME = r11;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
    L10:
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new Pools.SynchronizedPool(12);
        return;
    L9:
        TOP_SORTED_CHILDREN_COMPARATOR = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public CoordinatorLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public CoordinatorLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        int r13 = 0;
        int[] r14 = R.styleable.CoordinatorLayout;
        if (r12 != 0) goto L5;
        TypedArray r15 = r10.obtainStyledAttributes(r11, r14, 0, R.style.Widget_Support_CoordinatorLayout);
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        int[] r16 = R.styleable.CoordinatorLayout;
        if (r12 != 0) goto L11;
        saveAttributeDataForStyleable(r10, r16, r11, r15, 0, R.style.Widget_Support_CoordinatorLayout);
        goto L12
    L11:
        saveAttributeDataForStyleable(r10, r16, r11, r15, r12, 0);
    L12:
        int r17 = r15.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (r17 == 0) goto L17;
        Resources r18 = r10.getResources();
        this.mKeylines = r18.getIntArray(r17);
        float r19 = r18.getDisplayMetrics().density;
        int r110 = this.mKeylines.length;
    L15:
        if (r13 >= r110) goto L17;
        int[] r111 = this.mKeylines;
        r111[r13] = (int) (r111[r13] * r19);
        r13 = r13 + 1;
    L17:
        this.mStatusBarBackground = r15.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        r15.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L22;
        ViewCompat.setImportantForAccessibility(this, 1);
        return;
    L22:
        return;
    L5:
        r15 = r10.obtainStyledAttributes(r11, r14, r12, 0);
        goto L7
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect r10 = sRectPool.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new Rect();
    }

    private static int clamp(int r10, int r11, int r12) {
        if (r10 >= r11) goto L4;
        return r11;
    L4:
        if (r10 <= r12) goto L6;
        return r12;
    L6:
        return r10;
    }

    private void constrainChildRect(LayoutParams r10, Rect r11, int r12, int r13) {
        int r14 = getWidth();
        int r15 = getHeight();
        int r16 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r10).leftMargin, Math.min(r11.left, ((r14 - getPaddingRight()) - r12) - ((ViewGroup.MarginLayoutParams) r10).rightMargin));
        int r17 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r10).topMargin, Math.min(r11.top, ((r15 - getPaddingBottom()) - r13) - ((ViewGroup.MarginLayoutParams) r10).bottomMargin));
        r11.set(r16, r17, r12 + r16, r13 + r17);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat r10) {
        if (r10.isConsumed() == false) goto L5;
        return r10;
    L5:
        int r11 = 0;
        int r12 = getChildCount();
    L6:
        if (r11 >= r12) goto L15;
        View r13 = getChildAt(r11);
        if (ViewCompat.getFitsSystemWindows(r13) == false) goto L14;
        Behavior r14 = ((LayoutParams) r13.getLayoutParams()).getBehavior();
        if (r14 == null) goto L14;
        r10 = r14.onApplyWindowInsets(this, r13, r10);
        if (r10.isConsumed() == true) goto L15;
    L14:
        r11 = r11 + 1;
    L15:
        return r10;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View r10, int r11, Rect r12, Rect r13, LayoutParams r14, int r15, int r16) {
        int r17 = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(r14.gravity), r11);
        int r18 = GravityCompat.getAbsoluteGravity(resolveGravity(r14.anchorGravity), r11);
        int r19 = r17 & 7;
        int r20 = r17 & 112;
        int r21 = r18 & 7;
        int r22 = r18 & 112;
        if (r21 == 1) goto L7;
        if (r21 == 5) goto L6;
        int r23 = r12.left;
    L9:
        if (r22 == 16) goto L13;
        if (r22 == 80) goto L12;
        int r24 = r12.top;
    L14:
        if (r19 == 1) goto L17;
        if (r19 == 5) goto L18;
        r23 = r23 - r15;
    L18:
        if (r20 == 16) goto L21;
        if (r20 == 80) goto L22;
        r24 = r24 - r16;
    L22:
        r13.set(r23, r24, r15 + r23, r16 + r24);
        return;
    L21:
        r24 = r24 - (r16 / 2);
        goto L22
    L17:
        r23 = r23 - (r15 / 2);
        goto L18
    L12:
        r24 = r12.bottom;
        goto L14
    L13:
        r24 = r12.top + (r12.height() / 2);
        goto L14
    L6:
        r23 = r12.right;
        goto L9
    L7:
        r23 = r12.left + (r12.width() / 2);
        goto L9
    }

    private int getKeyline(int r10) {
        int[] r11 = this.mKeylines;
        if (r11 != null) goto L7;
        StringBuilder r12 = new StringBuilder();
        r12.append("No keylines defined for ");
        r12.append(this);
        r12.append(" - attempted index lookup ");
        r12.append(r10);
    L5:
        Log.e(TAG, r12.toString());
        return 0;
    L7:
        if (r10 >= 0) goto L9;
    L13:
        r12 = new StringBuilder();
        r12.append("Keyline index ");
        r12.append(r10);
        r12.append(" out of range for ");
        r12.append(this);
        goto L5
    L9:
        if (r10 >= r11.length) goto L13;
        return r11[r10];
    }

    private void getTopSortedChildren(List<View> r10) {
        r10.clear();
        boolean r11 = isChildrenDrawingOrderEnabled();
        int r12 = getChildCount();
        int r13 = r12 - 1;
    L3:
        if (r13 < 0) goto L8;
        if (r11 == false) goto L6;
        int r14 = getChildDrawingOrder(r12, r13);
    L7:
        r10.add(getChildAt(r14));
        r13 = r13 - 1;
        goto L3
    L6:
        r14 = r13;
        goto L7
    L8:
        Comparator<View> r15 = TOP_SORTED_CHILDREN_COMPARATOR;
        if (r15 == null) goto L15;
        Collections.sort(r10, r15);
        return;
    }

    private boolean hasDependencies(View r10) {
        return this.mChildDag.hasOutgoingEdges(r10);
    }

    private void layoutChild(View r10, int r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        Rect r13 = acquireTempRect();
        r13.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r12).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) r12).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r12).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r12).bottomMargin);
        if (this.mLastInsets != null) goto L5;
    L9:
        Rect r14 = acquireTempRect();
        GravityCompat.apply(resolveGravity(r12.gravity), r10.getMeasuredWidth(), r10.getMeasuredHeight(), r13, r14, r11);
        r10.layout(r14.left, r14.top, r14.right, r14.bottom);
        releaseTempRect(r13);
        releaseTempRect(r14);
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L9;
        r13.left += this.mLastInsets.getSystemWindowInsetLeft();
        r13.top += this.mLastInsets.getSystemWindowInsetTop();
        r13.right -= this.mLastInsets.getSystemWindowInsetRight();
        r13.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        goto L9
    }

    private void layoutChildWithAnchor(View r10, View r11, int r12) {
        Rect r13 = acquireTempRect();
        Rect r14 = acquireTempRect();
        getDescendantRect(r11, r13);     // Catch: Throwable -> L6
        getDesiredAnchoredChildRect(r10, r12, r13, r14);     // Catch: Throwable -> L6
        r10.layout(r14.left, r14.top, r14.right, r14.bottom);     // Catch: Throwable -> L6
        releaseTempRect(r13);
        releaseTempRect(r14);
        return;
    L6:
        th = move-exception;
        releaseTempRect(r13);
        releaseTempRect(r14);
        throw th;
    }

    private void layoutChildWithKeyline(View r10, int r11, int r12) {
        LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
        int r14 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r13.gravity), r12);
        int r15 = r14 & 7;
        int r16 = r14 & 112;
        int r17 = getWidth();
        int r18 = getHeight();
        int r19 = r10.getMeasuredWidth();
        int r20 = r10.getMeasuredHeight();
        if (r12 != 1) goto L5;
        r11 = r17 - r11;
    L5:
        int r110 = getKeyline(r11) - r19;
        int r111 = 0;
        if (r15 != 1) goto L8;
        r110 = r110 + (r19 / 2);
    L13:
        if (r16 != 16) goto L15;
        r111 = 0 + (r20 / 2);
    L19:
        int r112 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r13).leftMargin, Math.min(r110, ((r17 - getPaddingRight()) - r19) - ((ViewGroup.MarginLayoutParams) r13).rightMargin));
        int r21 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r13).topMargin, Math.min(r111, ((r18 - getPaddingBottom()) - r20) - ((ViewGroup.MarginLayoutParams) r13).bottomMargin));
        r10.layout(r112, r21, r19 + r112, r20 + r21);
        return;
    L15:
        if (r16 != 80) goto L19;
        r111 = r20 + 0;
        goto L19
    L8:
        if (r15 != 5) goto L13;
        r110 = r110 + r19;
        goto L13
    }

    private void offsetChildByInset(View r10, Rect r11, int r12) {
        if (ViewCompat.isLaidOut(r10) == true) goto L6;
        return;
    L6:
        if (r10.getWidth() > 0) goto L8;
        return;
    L8:
        if (r10.getHeight() <= 0) goto L54;
        LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
        Behavior r14 = r13.getBehavior();
        Rect r15 = acquireTempRect();
        Rect r16 = acquireTempRect();
        r16.set(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
        if (r14 != null) goto L13;
    L19:
        r15.set(r16);
    L20:
        releaseTempRect(r16);
        if (r15.isEmpty() == false) goto L24;
        releaseTempRect(r15);
        return;
    L24:
        int r17 = GravityCompat.getAbsoluteGravity(r13.dodgeInsetEdges, r12);
        boolean r18 = true;
        if ((r17 & 48) != 48) goto L29;
        int r19 = (r15.top - ((ViewGroup.MarginLayoutParams) r13).topMargin) - r13.mInsetOffsetY;
        int r20 = r11.top;
        if (r19 >= r20) goto L29;
        setInsetOffsetY(r10, r20 - r19);
        boolean r21 = true;
    L31:
        if ((r17 & 80) != 80) goto L35;
        int r22 = ((getHeight() - r15.bottom) - ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + r13.mInsetOffsetY;
        int r23 = r11.bottom;
        if (r22 >= r23) goto L35;
        setInsetOffsetY(r10, r22 - r23);
        r21 = true;
    L35:
        if (r21 == true) goto L38;
        setInsetOffsetY(r10, 0);
    L38:
        if ((r17 & 3) != 3) goto L42;
        int r24 = (r15.left - ((ViewGroup.MarginLayoutParams) r13).leftMargin) - r13.mInsetOffsetX;
        int r25 = r11.left;
        if (r24 >= r25) goto L42;
        setInsetOffsetX(r10, r25 - r24);
        boolean r26 = true;
    L44:
        if ((r17 & 5) != 5) goto L48;
        int r110 = ((getWidth() - r15.right) - ((ViewGroup.MarginLayoutParams) r13).rightMargin) + r13.mInsetOffsetX;
        int r111 = r11.right;
        if (r110 >= r111) goto L48;
        setInsetOffsetX(r10, r110 - r111);
    L49:
        if (r18 == true) goto L51;
        setInsetOffsetX(r10, 0);
    L51:
        releaseTempRect(r15);
        return;
    L48:
        r18 = r26;
    L42:
        r26 = false;
    L29:
        r21 = false;
        goto L31
    L13:
        if (r14.getInsetDodgeRect(this, r10, r15) == false) goto L19;
        if (r16.contains(r15) == true) goto L20;
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + r15.toShortString() + " | Bounds:" + r16.toShortString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Behavior parseBehavior(Context r10, AttributeSet r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return null;
    L7:
        if (r12.startsWith(".") == false) goto L10;
        r12 = r10.getPackageName() + r12;
    L26:
        ThreadLocal<Map<String, Constructor<Behavior>>> r13 = sConstructors;     // Catch: Exception -> L23
        Map<String, Constructor<Behavior>> r14 = r13.get();     // Catch: Exception -> L23
        if (r14 != null) goto L18;
        r14 = new HashMap();     // Catch: Exception -> L23
        r13.set(r14);     // Catch: Exception -> L23
    L18:
        Constructor<Behavior> r15 = r14.get(r12);     // Catch: Exception -> L23
        if (r15 != null) goto L21;
        r15 = Class.forName(r12, false, r10.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);     // Catch: Exception -> L23
        r15.setAccessible(true);     // Catch: Exception -> L23
        r14.put(r12, r15);     // Catch: Exception -> L23
    L21:
        return r15.newInstance(new Object[]{r10, r11});
    L23:
        e = move-exception;
        throw new RuntimeException("Could not inflate Behavior subclass " + r12, e);
    L10:
        if (r12.indexOf(46) >= 0) goto L26;
        String r16 = WIDGET_PACKAGE_NAME;
        if (TextUtils.isEmpty(r16) == true) goto L26;
        r12 = r16 + '.' + r12;
        goto L26
    }

    private boolean performIntercept(MotionEvent r24, int r25) {
        int r10 = r24.getActionMasked();
        List<View> r11 = this.mTempList1;
        getTopSortedChildren(r11);
        int r12 = r11.size();
        MotionEvent r13 = null;
        int r14 = 0;
        boolean r15 = false;
        boolean r16 = false;
    L3:
        if (r14 >= r12) goto L34;
        View r17 = r11.get(r14);
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        Behavior r19 = r18.getBehavior();
        if (r15 == true) goto L7;
        if (r16 == true) goto L7;
    L16:
        if (r15 == true) goto L25;
        if (r19 == null) goto L25;
        if (r25 == 0) goto L22;
        if (r25 != 1) goto L23;
        r15 = r19.onTouchEvent(this, r17, r24);
    L23:
        if (r15 == false) goto L25;
        this.mBehaviorTouchView = r17;
        goto L25
    L22:
        r15 = r19.onInterceptTouchEvent(this, r17, r24);
    L25:
        boolean r110 = r18.didBlockInteraction();
        boolean r111 = r18.isBlockingInteractionBelow(this, r17);
        if (r111 == false) goto L29;
        if (r110 == true) goto L29;
        r16 = true;
    L30:
        if (r111 == false) goto L33;
        if (r16 == false) goto L34;
    L33:
        r14 = r14 + 1;
    L29:
        r16 = false;
    L7:
        if (r10 == 0) goto L16;
        if (r19 == null) goto L33;
        if (r13 != null) goto L11;
        long r112 = SystemClock.uptimeMillis();
        r13 = MotionEvent.obtain(r112, r112, 3, 0.0f, 0.0f, 0);
    L11:
        if (r25 == 0) goto L15;
        if (r25 != 1) goto L33;
        r19.onTouchEvent(this, r17, r13);
        goto L33
    L15:
        r19.onInterceptTouchEvent(this, r17, r13);
    L34:
        r11.clear();
        return r15;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L16;
        View r12 = getChildAt(r11);
        LayoutParams r13 = getResolvedLayoutParams(r12);
        r13.findAnchorView(this, r12);
        this.mChildDag.addNode(r12);
        int r14 = 0;
    L5:
        if (r14 >= r10) goto L15;
        if (r14 == r11) goto L14;
        View r15 = getChildAt(r14);
        if (r13.dependsOn(this, r12, r15) == false) goto L14;
        if (this.mChildDag.contains(r15) == true) goto L13;
        this.mChildDag.addNode(r15);
    L13:
        this.mChildDag.addEdge(r15, r12);
    L14:
        r14 = r14 + 1;
        goto L5
    L15:
        r11 = r11 + 1;
        goto L3
    L16:
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(@NonNull Rect r10) {
        r10.setEmpty();
        sRectPool.release(r10);
    }

    private void resetTouchBehaviors(boolean r14) {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        View r12 = getChildAt(r11);
        Behavior r13 = ((LayoutParams) r12.getLayoutParams()).getBehavior();
        if (r13 == null) goto L11;
        long r15 = SystemClock.uptimeMillis();
        MotionEvent r16 = MotionEvent.obtain(r15, r15, 3, 0.0f, 0.0f, 0);
        if (r14 == false) goto L9;
        r13.onInterceptTouchEvent(this, r12, r16);
    L10:
        r16.recycle();
        goto L11
    L9:
        r13.onTouchEvent(this, r12, r16);
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        int r17 = 0;
    L13:
        if (r17 >= r10) goto L15;
        ((LayoutParams) getChildAt(r17).getLayoutParams()).resetTouchBehaviorTracking();
        r17 = r17 + 1;
        goto L13
    L15:
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int r10) {
        if (r10 != 0) goto L5;
        return 17;
    L5:
        return r10;
    }

    private static int resolveGravity(int r10) {
        if ((r10 & 7) != 0) goto L6;
        r10 = r10 | GravityCompat.START;
    L6:
        if ((r10 & 112) == 0) goto L8;
        return r10;
    L8:
        return r10 | 48;
    }

    private static int resolveKeylineGravity(int r10) {
        if (r10 != 0) goto L5;
        return MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
    L5:
        return r10;
    }

    private void setInsetOffsetX(View r10, int r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        int r13 = r12.mInsetOffsetX;
        if (r13 == r11) goto L6;
        ViewCompat.offsetLeftAndRight(r10, r11 - r13);
        r12.mInsetOffsetX = r11;
        return;
    }

    private void setInsetOffsetY(View r10, int r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        int r13 = r12.mInsetOffsetY;
        if (r13 == r11) goto L6;
        ViewCompat.offsetTopAndBottom(r10, r11 - r13);
        r12.mInsetOffsetY = r11;
        return;
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return;
    L6:
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        return;
    L8:
        if (this.mApplyWindowInsetsListener != null) goto L10;
        this.mApplyWindowInsetsListener = new AnonymousClass1(this);
    L10:
        ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    void addPreDrawListener() {
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
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r10) == false) goto L7;
        return true;
    }

    public void dispatchDependentViewsChanged(@NonNull View r10) {
        List r11 = this.mChildDag.getIncomingEdges(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L17;
        int r12 = 0;
    L8:
        if (r12 >= r11.size()) goto L18;
        View r13 = (View) r11.get(r12);
        Behavior r14 = ((LayoutParams) r13.getLayoutParams()).getBehavior();
        if (r14 == null) goto L12;
        r14.onDependentViewChanged(this, r13, r10);
    L12:
        r12 = r12 + 1;
        goto L8
    L18:
        return;
    }

    public boolean doViewsOverlap(@NonNull View r10, @NonNull View r11) {
        boolean r12 = false;
        if (r10.getVisibility() == 0) goto L5;
    L29:
        return false;
    L5:
        if (r11.getVisibility() != 0) goto L29;
        Rect r13 = acquireTempRect();
        if (r10.getParent() == this) goto L9;
        boolean r14 = true;
    L10:
        getChildRect(r10, r14, r13);
        Rect r15 = acquireTempRect();
        if (r11.getParent() == this) goto L13;
        boolean r16 = true;
    L14:
        getChildRect(r11, r16, r15);
    L26:
        th = move-exception;
        releaseTempRect(r13);
        releaseTempRect(r15);
        throw th;
    L16:
        if (r13.left <= r15.right) goto L18;
    L24:
        releaseTempRect(r13);
        releaseTempRect(r15);
        return r12;
    L18:
        if (r13.top > r15.bottom) goto L24;
        if (r13.right < r15.left) goto L24;
        if (r13.bottom < r15.top) goto L24;
        r12 = true;
        goto L24
    L13:
        r16 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas r10, View r11, long r12) {
        LayoutParams r13 = (LayoutParams) r11.getLayoutParams();
        Behavior r14 = r13.mBehavior;
        if (r14 == null) goto L14;
        float r15 = r14.getScrimOpacity(this, r11);
        if (r15 <= 0.0f) goto L14;
        if (this.mScrimPaint != null) goto L9;
        this.mScrimPaint = new Paint();
    L9:
        this.mScrimPaint.setColor(r13.mBehavior.getScrimColor(this, r11));
        this.mScrimPaint.setAlpha(clamp(Math.round(r15 * 255.0f), 0, 255));
        int r16 = r10.save();
        if (r11.isOpaque() == false) goto L12;
        r10.clipRect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom(), Region.Op.DIFFERENCE);
    L12:
        r10.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        r10.restoreToCount(r16);
    L14:
        return super.drawChild(r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.mStatusBarBackground;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L7:
        if (r12 == false) goto L10;
        invalidate();
        return;
    L10:
        return;
    L5:
        if (r11.isStateful() == false) goto L7;
        r12 = false | r11.setState(r10);
        goto L7
    }

    void ensurePreDrawListener() {
        int r10 = getChildCount();
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        if (hasDependencies(getChildAt(r12)) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        r11 = true;
    L9:
        if (r11 == this.mNeedsPreDrawListener) goto L16;
        if (r11 == false) goto L12;
        addPreDrawListener();
        return;
    L12:
        removePreDrawListener();
        return;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r10);
    L7:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L11:
        return new LayoutParams(r10);
    }

    void getChildRect(View r10, boolean r11, Rect r12) {
        if (r10.isLayoutRequested() == false) goto L5;
    L11:
        r12.setEmpty();
        return;
    L5:
        if (r10.getVisibility() == 8) goto L11;
        if (r11 == false) goto L9;
        getDescendantRect(r10, r12);
        return;
    L9:
        r12.set(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    }

    @NonNull
    public List<View> getDependencies(@NonNull View r10) {
        List<View> r11 = this.mChildDag.getOutgoingEdges(r10);
        this.mTempDependenciesList.clear();
        if (r11 == null) goto L6;
        this.mTempDependenciesList.addAll(r11);
    L6:
        return this.mTempDependenciesList;
    }

    @VisibleForTesting
    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @NonNull
    public List<View> getDependents(@NonNull View r10) {
        List r11 = this.mChildDag.getIncomingEdges(r10);
        this.mTempDependenciesList.clear();
        if (r11 == null) goto L6;
        this.mTempDependenciesList.addAll(r11);
    L6:
        return this.mTempDependenciesList;
    }

    void getDescendantRect(View r10, Rect r11) {
        ViewGroupUtils.getDescendantRect(this, r10, r11);
    }

    void getDesiredAnchoredChildRect(View r12, int r13, Rect r14, Rect r15) {
        LayoutParams r10 = (LayoutParams) r12.getLayoutParams();
        int r11 = r12.getMeasuredWidth();
        int r16 = r12.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(r12, r13, r14, r15, r10, r11, r16);
        constrainChildRect(r10, r15, r11, r16);
    }

    void getLastChildRect(View r10, Rect r11) {
        r11.set(((LayoutParams) r10.getLayoutParams()).getLastChildRect());
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
    LayoutParams getResolvedLayoutParams(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if (r11.mBehaviorResolved == false) goto L5;
    L21:
        return r11;
    L5:
        if ((r10 instanceof AttachedBehavior) == false) goto L11;
        Behavior r12 = ((AttachedBehavior) r10).getBehavior();
        if (r12 != null) goto L9;
        Log.e(TAG, "Attached behavior class is null");
    L9:
        r11.setBehavior(r12);
    L10:
        r11.mBehaviorResolved = true;
        goto L21
    L11:
        Class<?> r13 = r10.getClass();
        DefaultBehavior r14 = null;
    L12:
        if (r13 == null) goto L16;
        r14 = (DefaultBehavior) r13.getAnnotation(DefaultBehavior.class);
        if (r14 != null) goto L16;
        r13 = r13.getSuperclass();
    L16:
        if (r14 == null) goto L10;
        r11.setBehavior(r14.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Log.e(TAG, "Default behavior class " + r14.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
        goto L10
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(@NonNull View r10, int r11, int r12) {
        Rect r13 = acquireTempRect();
        getDescendantRect(r10, r13);
        boolean r14 = r13.contains(r11, r12);     // Catch: Throwable -> L6
        releaseTempRect(r13);
        return r14;
    L6:
        th = move-exception;
        releaseTempRect(r13);
        throw th;
    }

    void offsetChildToAnchor(View r17, int r18) {
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
        getDesiredAnchoredChildRectWithoutConstraints(r17, r18, r11, r13, r10, r15, r16);
        if (r13.left == r12.left) goto L7;
    L8:
        r14 = true;
    L9:
        constrainChildRect(r10, r13, r15, r16);
        int r19 = r13.left - r12.left;
        int r20 = r13.top - r12.top;
        if (r19 == 0) goto L12;
        ViewCompat.offsetLeftAndRight(r17, r19);
    L12:
        if (r20 == 0) goto L14;
        ViewCompat.offsetTopAndBottom(r17, r20);
    L14:
        if (r14 == false) goto L18;
        Behavior r21 = r10.getBehavior();
        if (r21 == null) goto L18;
        r21.onDependentViewChanged(this, r17, r10.mAnchorView);
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
        resetTouchBehaviors(false);
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

    final void onChildViewsChanged(int r18) {
        int r10 = ViewCompat.getLayoutDirection(this);
        int r11 = this.mDependencySortedChildren.size();
        Rect r12 = acquireTempRect();
        Rect r13 = acquireTempRect();
        Rect r14 = acquireTempRect();
        int r15 = 0;
    L3:
        if (r15 >= r11) goto L61;
        View r16 = this.mDependencySortedChildren.get(r15);
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        if (r18 == 0) goto L7;
    L9:
        int r19 = 0;
    L10:
        if (r19 >= r15) goto L15;
        if (r17.mAnchorDirectChild != this.mDependencySortedChildren.get(r19)) goto L14;
        offsetChildToAnchor(r16, r10);
    L14:
        r19 = r19 + 1;
        goto L10
    L15:
        getChildRect(r16, true, r13);
        if (r17.insetEdge == 0) goto L34;
        if (r13.isEmpty() == true) goto L34;
        int r110 = GravityCompat.getAbsoluteGravity(r17.insetEdge, r10);
        int r111 = r110 & 112;
        if (r111 != 48) goto L22;
        r12.top = Math.max(r12.top, r13.bottom);
    L26:
        int r112 = r110 & 7;
        if (r112 != 3) goto L29;
        r12.left = Math.max(r12.left, r13.right);
        goto L34
    L29:
        if (r112 != 5) goto L34;
        r12.right = Math.max(r12.right, getWidth() - r13.left);
        goto L34
    L22:
        if (r111 != 80) goto L26;
        r12.bottom = Math.max(r12.bottom, getHeight() - r13.top);
    L34:
        if (r17.dodgeInsetEdges == 0) goto L39;
        if (r16.getVisibility() != 0) goto L39;
        offsetChildByInset(r16, r12, r10);
    L39:
        if (r18 == 2) goto L44;
        getLastChildRect(r16, r14);
        if (r14.equals(r13) == true) goto L60;
        recordLastChildRect(r16, r13);
    L60:
        r15 = r15 + 1;
    L44:
        int r113 = r15 + 1;
    L45:
        if (r113 >= r11) goto L60;
        View r114 = this.mDependencySortedChildren.get(r113);
        LayoutParams r115 = (LayoutParams) r114.getLayoutParams();
        Behavior r116 = r115.getBehavior();
        if (r116 == null) goto L59;
        if (r116.layoutDependsOn(this, r114, r16) == false) goto L59;
        if (r18 == 0) goto L52;
    L54:
        if (r18 == 2) goto L56;
        boolean r117 = r116.onDependentViewChanged(this, r114, r16);
    L57:
        if (r18 != 1) goto L59;
        r115.setChangedAfterNestedScroll(r117);
        goto L59
    L56:
        r116.onDependentViewRemoved(this, r114, r16);
        r117 = true;
        goto L57
    L52:
        if (r115.getChangedAfterNestedScroll() == false) goto L54;
        r115.resetChangedAfterNestedScroll();
    L59:
        r113 = r113 + 1;
        goto L45
    L7:
        if (r16.getVisibility() != 8) goto L9;
    L61:
        releaseTempRect(r12);
        releaseTempRect(r13);
        releaseTempRect(r14);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener == true) goto L5;
    L7:
        View r10 = this.mNestedScrollingTarget;
        if (r10 == null) goto L10;
        onStopNestedScroll(r10);
    L10:
        this.mIsAttachedToWindow = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        WindowInsetsCompat r11 = this.mLastInsets;
        if (r11 == null) goto L9;
        int r12 = r11.getSystemWindowInsetTop();
    L10:
        if (r12 <= 0) goto L15;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r12);
        this.mStatusBarBackground.draw(r10);
        return;
    L15:
        return;
    L9:
        r12 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        resetTouchBehaviors(true);
    L5:
        boolean r12 = performIntercept(r10, 0);
        if (r11 != 1) goto L8;
    L9:
        resetTouchBehaviors(true);
    L10:
        return r12;
    L8:
        if (r11 != 3) goto L10;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = ViewCompat.getLayoutDirection(this);
        int r16 = this.mDependencySortedChildren.size();
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L13;
        View r18 = this.mDependencySortedChildren.get(r17);
        if (r18.getVisibility() == 8) goto L12;
        Behavior r19 = ((LayoutParams) r18.getLayoutParams()).getBehavior();
        if (r19 != null) goto L10;
    L11:
        onLayoutChild(r18, r15);
        goto L12
    L10:
        if (r19.onLayoutChild(this, r18, r15) == false) goto L11;
    L12:
        r17 = r17 + 1;
        goto L3
    }

    public void onLayoutChild(@NonNull View r10, int r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        if (r12.checkAnchorChanged() == true) goto L13;
        View r13 = r12.mAnchorView;
        if (r13 == null) goto L7;
        layoutChildWithAnchor(r10, r13, r11);
        return;
    L7:
        int r14 = r12.keyline;
        if (r14 < 0) goto L10;
        layoutChildWithKeyline(r10, r14, r11);
        return;
    L10:
        layoutChild(r10, r11);
        return;
    L13:
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.View
    protected void onMeasure(int r31, int r32) {
        prepareChildren();
        ensurePreDrawListener();
        int r10 = getPaddingLeft();
        int r11 = getPaddingTop();
        int r12 = getPaddingRight();
        int r13 = getPaddingBottom();
        int r14 = ViewCompat.getLayoutDirection(this);
        if (r14 != 1) goto L5;
        boolean r15 = true;
    L6:
        int r16 = View.MeasureSpec.getMode(r31);
        int r17 = View.MeasureSpec.getSize(r31);
        int r18 = View.MeasureSpec.getMode(r32);
        int r19 = View.MeasureSpec.getSize(r32);
        int r110 = r10 + r12;
        int r111 = r11 + r13;
        int r20 = getSuggestedMinimumWidth();
        int r21 = getSuggestedMinimumHeight();
        if (this.mLastInsets != null) goto L9;
    L11:
        boolean r112 = false;
    L12:
        int r22 = this.mDependencySortedChildren.size();
        int r23 = r20;
        int r24 = r21;
        int r25 = 0;
        int r26 = 0;
    L13:
        if (r26 >= r22) goto L49;
        View r27 = this.mDependencySortedChildren.get(r26);
        if (r27.getVisibility() != 8) goto L17;
        int r28 = r26;
        int r29 = r22;
        int r210 = r10;
    L48:
        r26 = r28 + 1;
        r10 = r210;
        r22 = r29;
        goto L13
    L17:
        LayoutParams r30 = (LayoutParams) r27.getLayoutParams();
        int r33 = r30.keyline;
        if (r33 < 0) goto L33;
        if (r16 == 0) goto L33;
        int r34 = getKeyline(r33);
        int r113 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(r30.gravity), r14) & 7;
        int r211 = r25;
        if (r113 != 3) goto L24;
        if (r15 == true) goto L24;
    L26:
        int r212 = Math.max(0, (r17 - r12) - r34);
    L35:
        if (r112 == true) goto L37;
    L39:
        int r114 = r31;
        int r213 = r32;
    L40:
        Behavior r35 = r30.getBehavior();
        if (r35 == null) goto L45;
        LayoutParams r214 = r30;
        int r215 = r211;
        r28 = r26;
        int r216 = r24;
        r210 = r10;
        int r36 = r23;
        r29 = r22;
        if (r35.onMeasureChild(this, r27, r114, r212, r213, 0) == false) goto L46;
    L47:
        LayoutParams r37 = r214;
        int r38 = Math.max(r36, ((r110 + r27.getMeasuredWidth()) + ((ViewGroup.MarginLayoutParams) r37).leftMargin) + ((ViewGroup.MarginLayoutParams) r37).rightMargin);
        int r39 = Math.max(r216, ((r111 + r27.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r37).topMargin) + ((ViewGroup.MarginLayoutParams) r37).bottomMargin);
        r25 = View.combineMeasuredStates(r215, r27.getMeasuredState());
        r23 = r38;
        r24 = r39;
    L46:
        onMeasureChild(r27, r114, r212, r213, 0);
        goto L47
    L45:
        r214 = r30;
        r216 = r24;
        r29 = r22;
        r210 = r10;
        r215 = r211;
        r28 = r26;
        r36 = r23;
        goto L46
    L37:
        if (ViewCompat.getFitsSystemWindows(r27) == true) goto L39;
        int r40 = this.mLastInsets.getSystemWindowInsetLeft() + this.mLastInsets.getSystemWindowInsetRight();
        int r41 = this.mLastInsets.getSystemWindowInsetTop() + this.mLastInsets.getSystemWindowInsetBottom();
        r114 = View.MeasureSpec.makeMeasureSpec(r17 - r40, r16);
        r213 = View.MeasureSpec.makeMeasureSpec(r19 - r41, r18);
    L24:
        if (r113 != 5) goto L27;
        if (r15 == true) goto L26;
    L27:
        if (r113 != 5) goto L30;
        if (r15 == true) goto L30;
    L32:
        r212 = Math.max(0, r34 - r10);
    L30:
        if (r113 != 3) goto L34;
        if (r15 == true) goto L32;
    L34:
        r212 = 0;
    L33:
        r211 = r25;
        goto L34
    L49:
        int r115 = r25;
        setMeasuredDimension(View.resolveSizeAndState(r23, r31, (-16777216) & r115), View.resolveSizeAndState(r24, r32, r115 << 16));
        return;
    L9:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L11;
        r112 = true;
        goto L12
    L5:
        r15 = false;
        goto L6
    }

    public void onMeasureChild(View r10, int r11, int r12, int r13, int r14) {
        measureChildWithMargins(r10, r11, r12, r13, r14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r12, float r13, float r14, boolean r15) {
        int r10 = getChildCount();
        int r11 = 0;
        boolean r16 = false;
    L3:
        if (r11 >= r10) goto L14;
        View r17 = getChildAt(r11);
        if (r17.getVisibility() == 8) goto L13;
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        if (r18.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r19 = r18.getBehavior();
        if (r19 == null) goto L13;
        r16 = r16 | r19.onNestedFling(this, r17, r12, r13, r14, r15);
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        if (r16 == false) goto L16;
        onChildViewsChanged(1);
    L16:
        return r16;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r11, float r12, float r13) {
        int r10 = getChildCount();
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r10) goto L14;
        View r16 = getChildAt(r14);
        if (r16.getVisibility() == 8) goto L13;
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        if (r17.isNestedScrollAccepted(0) == false) goto L13;
        Behavior r18 = r17.getBehavior();
        if (r18 == null) goto L13;
        r15 = r15 | r18.onNestedPreFling(this, r16, r11, r12, r13);
    L13:
        r14 = r14 + 1;
        goto L3
    L14:
        return r15;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        onNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r17, int r18, int r19, int[] r20, int r21) {
        int r10 = getChildCount();
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12 >= r10) goto L23;
        View r15 = getChildAt(r12);
        if (r15.getVisibility() == 8) goto L22;
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        if (r16.isNestedScrollAccepted(r21) == false) goto L22;
        Behavior r22 = r16.getBehavior();
        if (r22 == null) goto L22;
        int[] r23 = this.mBehaviorConsumed;
        r23[0] = 0;
        r23[1] = 0;
        r22.onNestedPreScroll(this, r15, r17, r18, r19, r23, r21);
        int[] r24 = this.mBehaviorConsumed;
        if (r18 <= 0) goto L16;
        int r25 = Math.max(r13, r24[0]);
    L17:
        r13 = r25;
        int[] r26 = this.mBehaviorConsumed;
        if (r19 <= 0) goto L20;
        int r27 = Math.max(r14, r26[1]);
    L21:
        r14 = r27;
        r11 = true;
        goto L22
    L20:
        r27 = Math.min(r14, r26[1]);
        goto L21
    L16:
        r25 = Math.min(r13, r24[0]);
    L22:
        r12 = r12 + 1;
        goto L4
    L23:
        r20[0] = r13;
        r20[1] = r14;
        if (r11 == false) goto L32;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r10, r11, r12, r13, r14, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        onNestedScroll(r10, r11, r12, r13, r14, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r18, int r19, int r20, int r21, int r22, int r23, @NonNull int[] r24) {
        int r11 = getChildCount();
        boolean r10 = false;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r11) goto L23;
        View r12 = getChildAt(r13);
        if (r12.getVisibility() == 8) goto L22;
        LayoutParams r16 = (LayoutParams) r12.getLayoutParams();
        if (r16.isNestedScrollAccepted(r23) == false) goto L22;
        Behavior r17 = r16.getBehavior();
        if (r17 == null) goto L22;
        int[] r25 = this.mBehaviorConsumed;
        r25[0] = 0;
        r25[1] = 0;
        r17.onNestedScroll(this, r12, r18, r19, r20, r21, r22, r23, r25);
        int[] r26 = this.mBehaviorConsumed;
        if (r21 <= 0) goto L16;
        int r27 = Math.max(r14, r26[0]);
    L17:
        r14 = r27;
        if (r22 <= 0) goto L20;
        boolean r28 = true;
        int r29 = Math.max(r15, this.mBehaviorConsumed[1]);
    L21:
        r15 = r29;
        r10 = r28;
        goto L22
    L20:
        r28 = true;
        r29 = Math.min(r15, this.mBehaviorConsumed[1]);
        goto L21
    L16:
        r27 = Math.min(r14, r26[0]);
    L22:
        r13 = r13 + 1;
        goto L4
    L23:
        r24[0] = r24[0] + r14;
        r24[1] = r24[1] + r15;
        if (r10 == false) goto L32;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r10, View r11, int r12) {
        onNestedScrollAccepted(r10, r11, r12, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(r10, r11, r12, r13);
        this.mNestedScrollingTarget = r11;
        int r14 = getChildCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L11;
        View r16 = getChildAt(r15);
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        if (r17.isNestedScrollAccepted(r13) == false) goto L10;
        Behavior r18 = r17.getBehavior();
        if (r18 == null) goto L10;
        r18.onNestedScrollAccepted(this, r16, r10, r11, r12, r13);
    L10:
        r15 = r15 + 1;
        goto L3
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        SparseArray<Parcelable> r12 = r11.behaviorStates;
        int r13 = 0;
        int r14 = getChildCount();
    L7:
        if (r13 >= r14) goto L15;
        View r15 = getChildAt(r13);
        int r16 = r15.getId();
        Behavior r17 = getResolvedLayoutParams(r15).getBehavior();
        if (r16 == (-1)) goto L14;
        if (r17 == null) goto L14;
        Parcelable r18 = r12.get(r16);
        if (r18 == null) goto L14;
        r17.onRestoreInstanceState(this, r15, r18);
    L14:
        r13 = r13 + 1;
        goto L7
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> r11 = new SparseArray();
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        View r14 = getChildAt(r13);
        int r15 = r14.getId();
        Behavior r16 = ((LayoutParams) r14.getLayoutParams()).getBehavior();
        if (r15 == (-1)) goto L10;
        if (r16 == null) goto L10;
        Parcelable r17 = r16.onSaveInstanceState(this, r14);
        if (r17 == null) goto L10;
        r11.append(r15, r17);
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        r10.behaviorStates = r11;
        return r10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r10, View r11, int r12) {
        return onStartNestedScroll(r10, r11, r12, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r15, View r16, int r17, int r18) {
        int r10 = getChildCount();
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 >= r10) goto L12;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() == 8) goto L11;
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        Behavior r19 = r14.getBehavior();
        if (r19 == null) goto L10;
        boolean r20 = r19.onStartNestedScroll(this, r13, r15, r16, r17, r18);
        r12 = r12 | r20;
        r14.setNestedScrollAccepted(r18, r20);
        goto L11
    L10:
        r14.setNestedScrollAccepted(r18, false);
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        return r12;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r10) {
        onStopNestedScroll(r10, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(r10, r11);
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        View r14 = getChildAt(r13);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        if (r15.isNestedScrollAccepted(r11) == false) goto L11;
        Behavior r16 = r15.getBehavior();
        if (r16 == null) goto L10;
        r16.onStopNestedScroll(this, r14, r10, r11);
    L10:
        r15.resetNestedScroll(r11);
        r15.resetChangedAfterNestedScroll();
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        this.mNestedScrollingTarget = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        int r10 = r18.getActionMasked();
        if (this.mBehaviorTouchView != null) goto L7;
        boolean r11 = performIntercept(r18, 1);
        if (r11 == true) goto L8;
    L11:
        boolean r12 = false;
    L12:
        MotionEvent r13 = null;
        if (this.mBehaviorTouchView != null) goto L15;
        r12 = r12 | super.onTouchEvent(r18);
    L17:
        if (r13 == null) goto L19;
        r13.recycle();
    L19:
        if (r10 != 1) goto L21;
    L22:
        resetTouchBehaviors(false);
    L23:
        return r12;
    L21:
        if (r10 != 3) goto L23;
    L15:
        if (r11 == false) goto L17;
        long r14 = SystemClock.uptimeMillis();
        r13 = MotionEvent.obtain(r14, r14, 3, 0.0f, 0.0f, 0);
        super.onTouchEvent(r13);
    L8:
        Behavior r15 = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        if (r15 == null) goto L11;
        r12 = r15.onTouchEvent(this, this.mBehaviorTouchView, r18);
        goto L12
    L7:
        r11 = false;
        goto L8
    }

    void recordLastChildRect(View r10, Rect r11) {
        ((LayoutParams) r10.getLayoutParams()).setLastChildRect(r11);
    }

    void removePreDrawListener() {
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
    public boolean requestChildRectangleOnScreen(View r10, Rect r11, boolean r12) {
        Behavior r13 = ((LayoutParams) r10.getLayoutParams()).getBehavior();
        if (r13 == null) goto L9;
        if (r13.onRequestChildRectangleOnScreen(this, r10, r11, r12) == false) goto L9;
        return true;
    L9:
        return super.requestChildRectangleOnScreen(r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        super.requestDisallowInterceptTouchEvent(r10);
        if (r10 == true) goto L5;
        return;
    L5:
        if (this.mDisallowInterceptReset == true) goto L9;
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
        return;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean r10) {
        super.setFitsSystemWindows(r10);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r10) {
        this.mOnHierarchyChangeListener = r10;
    }

    public void setStatusBarBackground(@Nullable Drawable r10) {
        Drawable r11 = this.mStatusBarBackground;
        if (r11 == r10) goto L21;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.mStatusBarBackground = r12;
        if (r12 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r12.isStateful() == false) goto L14;
        this.mStatusBarBackground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        Drawable r13 = this.mStatusBarBackground;
        if (getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        r13.setVisible(r14, false);
        this.mStatusBarBackground.setCallback(this);
        goto L19
    L17:
        r14 = false;
        goto L18
    }

    public void setStatusBarBackgroundColor(@ColorInt int r10) {
        setStatusBarBackground(new ColorDrawable(r10));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = ContextCompat.getDrawable(getContext(), r10);
    L5:
        setStatusBarBackground(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.mStatusBarBackground;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isVisible() == r11) goto L13;
        this.mStatusBarBackground.setVisible(r11, false);
        return;
    L13:
        return;
    L5:
        r11 = false;
        goto L6
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat r10) {
        if (ObjectsCompat.equals(this.mLastInsets, r10) == true) goto L18;
        this.mLastInsets = r10;
        boolean r11 = true;
        if (r10 != null) goto L7;
    L9:
        boolean r12 = false;
    L10:
        this.mDrawStatusBarBackground = r12;
        if (r12 == false) goto L13;
    L15:
        r11 = false;
    L16:
        setWillNotDraw(r11);
        WindowInsetsCompat r13 = dispatchApplyWindowInsetsToBehaviors(r10);
        requestLayout();
        return r13;
    L13:
        if (getBackground() != null) goto L15;
    L7:
        if (r10.getSystemWindowInsetTop() <= 0) goto L9;
        r12 = true;
        goto L10
    L18:
        return r10;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10 == this.mStatusBarBackground) goto L8;
        return false;
    }
}
