package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
public class RecyclerView extends ViewGroup implements NestedScrollingChild2, NestedScrollingChild3, ScrollingView {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    private static final float DECELERATION_RATE = 0.0f;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled = false;
    static final Interpolator sQuinticInterpolator = null;
    static boolean sVerboseLoggingEnabled = false;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    com.obric.oui.orecyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private boolean mAvoidStateChangeInAnim;
    private c mChildDrawingOrderCallback;
    com.obric.oui.orecyclerview.widget.f mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    boolean mEnableFastScroller;
    private boolean mEnableOverFling;
    boolean mFirstLayoutComplete;
    com.obric.oui.orecyclerview.widget.k mGapWorker;
    boolean mHasFixedSize;
    protected com.obric.oui.orecyclerview.base.a mHorizontalEdgeEffect;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private l mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    e mItemAnimator;
    private e.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<g> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private float mLastDispatchedBounceTranslation;
    private int mLastTouchX;
    private int mLastTouchY;
    h mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private final int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final q mObserver;
    private i mOnBounceTranslationListener;
    private List<j> mOnChildAttachStateListeners;
    private k mOnFlingListener;
    private final ArrayList<l> mOnItemTouchListeners;
    final List<v> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    com.obric.oui.orecyclerview.widget.k.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final o mRecycler;
    p mRecyclerListener;
    final List<p> mRecyclerListeners;
    private final x mRecyclerViewExt;
    final int[] mReusableIntPair;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private m mScrollListener;
    private List<m> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final s mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private com.obric.oui.orecyclerview.base.i mVelocityTracker;
    protected com.obric.oui.orecyclerview.base.a mVerticalEdgeEffect;
    final u mViewFlinger;
    private final ad.b mViewInfoProcessCallback;
    final ad mViewInfoStore;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.RecyclerView$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14071a = null;

        static {
            int[] r0 = new int[Adapter.StateRestorationPolicy.values().length];
            f14071a = r0;
            r0[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f14071a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Adapter<VH extends v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f14072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14073b;
        private StateRestorationPolicy c;

        public static final enum StateRestorationPolicy extends Enum<StateRestorationPolicy> {
            private static final /* synthetic */ StateRestorationPolicy[] $VALUES = null;
            public static final StateRestorationPolicy ALLOW = null;
            public static final StateRestorationPolicy PREVENT = null;
            public static final StateRestorationPolicy PREVENT_WHEN_EMPTY = null;

            static {
                StateRestorationPolicy r0 = new StateRestorationPolicy("ALLOW", 0);
                ALLOW = r0;
                StateRestorationPolicy r1 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r1;
                StateRestorationPolicy r3 = new StateRestorationPolicy("PREVENT", 2);
                PREVENT = r3;
                $VALUES = new StateRestorationPolicy[]{r0, r1, r3};
            }

            private StateRestorationPolicy(String r1, int r2) {
                super(r1, r2);
            }

            public static StateRestorationPolicy valueOf(String r2) {
                return (StateRestorationPolicy) ZeusTransformUtils.preCheckCast(Enum.valueOf(StateRestorationPolicy.class, r2), StateRestorationPolicy.class, "com.obric.memorydata.plugin");
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StateRestorationPolicy[].class, "com.obric.memorydata.plugin");
            }
        }

        public Adapter() {
            this.f14072a = new a();
            this.f14073b = false;
            this.c = StateRestorationPolicy.ALLOW;
        }

        public int a(int r1) {
            return 0;
        }

        public int a(Adapter<? extends v> r1, v r2, int r3) {
            if (r1 != this) goto L4;
            return r3;
        L4:
            return -1;
        }

        public abstract VH a(ViewGroup r1, int r2);

        public final void a(int r1, int r2) {
            this.f14072a.a(r1, r2);
        }

        public final void a(int r1, int r2, Object r3) {
            this.f14072a.a(r1, r2, r3);
        }

        public void a(StateRestorationPolicy r1) {
            this.c = r1;
            this.f14072a.c();
        }

        public void a(b r1) {
            this.f14072a.registerObserver(r1);
        }

        public void a(VH r1) {
        }

        public abstract void a(VH r1, int r2);

        public void a(VH r3, int r4, List<Object> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            a(r3, r4);
        }

        public void a(RecyclerView r1) {
        }

        public final void b(int r1, int r2) {
            this.f14072a.d(r1, r2);
        }

        public void b(b r1) {
            this.f14072a.unregisterObserver(r1);
        }

        public void b(VH r1) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(VH r5, int r6) {
            if (r5.s != null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L11;
            r5.e = r6;
            if (f() == false) goto L10;
            r5.g = c(r6);
        L10:
            r5.b(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
        L11:
            r5.s = this;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L14;
        L27:
            a(r5, r6, r5.G());
            if (r0 == false) goto L34;
            r5.F();
            ViewGroup.LayoutParams r4 = r5.c.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r4, LayoutParams.class) == false) goto L32;
            ((LayoutParams) ZeusTransformUtils.preCheckCast(r4, LayoutParams.class, "com.obric.memorydata.plugin")).e = true;
        L32:
            TraceCompat.endSection();
            return;
        L34:
            return;
        L14:
            if (r5.c.getParent() != null) goto L21;
            if (ViewCompat.isAttachedToWindow(r5.c) == r5.C()) goto L21;
            throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + r5.C() + ", attached to window: " + ViewCompat.isAttachedToWindow(r5.c) + ", holder: " + r5);
        L21:
            if (r5.c.getParent() != null) goto L27;
            if (ViewCompat.isAttachedToWindow(r5.c) == false) goto L27;
            throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + r5);
        L5:
            r0 = false;
            goto L6
        }

        public void b(RecyclerView r1) {
        }

        public void b_(boolean r2) {
            if (g() == true) goto L7;
            this.f14073b = r2;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public long c(int r1) {
            return -1;
        }

        public final VH c(ViewGroup r2, int r3) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L9
            VH r1 = (VH) a(r2, r3);
            if (r1.c.getParent() != null) goto L8;
            r1.h = r3;     // Catch: Throwable -> L9
            TraceCompat.endSection();
            return r1;
        L8:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }

        public final void c(int r1, int r2) {
            this.f14072a.b(r1, r2);
        }

        public boolean c(VH r1) {
            return false;
        }

        public abstract int d();

        public final void d(int r1, int r2) {
            this.f14072a.c(r1, r2);
        }

        public void d(VH r1) {
        }

        public final void e(int r2) {
            this.f14072a.a(r2, 1);
        }

        public final void f(int r2) {
            this.f14072a.b(r2, 1);
        }

        public final boolean f() {
            return this.f14073b;
        }

        public final void g(int r2) {
            this.f14072a.c(r2, 1);
        }

        public final boolean g() {
            return this.f14072a.a();
        }

        public final void h() {
            this.f14072a.b();
        }

        public final StateRestorationPolicy i() {
            return this.c;
        }

        boolean j() {
            int r0 = AnonymousClass7.f14071a[this.c.ordinal()];
            if (r0 != 1) goto L5;
            return false;
        L5:
            if (r0 == 2) goto L8;
            return true;
        L8:
            if (d() > 0) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        v c;
        final Rect d;
        boolean e;
        boolean f;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(LayoutParams r1) {
            super(r1);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public boolean c() {
            return this.c.y();
        }

        public boolean d() {
            return this.c.B();
        }

        public boolean e() {
            return this.c.L();
        }

        public int f() {
            return this.c.m();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L6;
            r2 = h.class.getClassLoader();
        L6:
            this.mLayoutState = r1.readParcelable(r2);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        void copyFrom(SavedState r1) {
            this.mLayoutState = r1.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeParcelable(this.mLayoutState, 0);
        }
    }

    static class a extends Observable<b> {
        a() {
        }

        public void a(int r2, int r3) {
            a(r2, r3, null);
        }

        public void a(int r5, int r6, Object r7) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.memorydata.plugin")).a(r5, r6, r7);
            r0 = r0 - 1;
            goto L3
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.memorydata.plugin")).a();
            r0 = r0 - 1;
            goto L3
        }

        public void b(int r5, int r6) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.memorydata.plugin")).a(r5, r6);
            r0 = r0 - 1;
            goto L3
        }

        public void c() {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.memorydata.plugin")).b();
            r0 = r0 - 1;
            goto L3
        }

        public void c(int r5, int r6) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.memorydata.plugin")).b(r5, r6);
            r0 = r0 - 1;
            goto L3
        }

        public void d(int r6, int r7) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.memorydata.plugin")).a(r6, r7, 1);
            r0 = r0 - 1;
            goto L3
        }
    }

    public static abstract class b {
        public b() {
        }

        public void a() {
        }

        public void a(int r1, int r2) {
        }

        public void a(int r1, int r2, int r3) {
        }

        public void a(int r1, int r2, Object r3) {
            c(r1, r2);
        }

        public void b() {
        }

        public void b(int r1, int r2) {
        }

        public void c(int r1, int r2) {
        }
    }

    public interface c {
        int a(int r1, int r2);
    }

    public static class d {
        public d() {
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f14074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<a> f14075b;
        private long c;
        private long d;
        private long e;
        private long f;

        public interface a {
            void onAnimationsFinished();
        }

        interface b {
            void a(v r1);
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f14076a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f14077b;
            public int c;
            public int d;

            public c() {
            }

            public c a(v r2) {
                return a(r2, 0);
            }

            public c a(v r1, int r2) {
                View r3 = r1.c;
                this.f14076a = r3.getLeft();
                this.f14077b = r3.getTop();
                this.c = r3.getRight();
                this.d = r3.getBottom();
                return this;
            }
        }

        public e() {
            this.f14074a = null;
            this.f14075b = new ArrayList();
            this.c = 100;
            this.d = 100;
            this.e = 500;
            this.f = 250;
        }

        static int e(v r3) {
            int r0 = r3.l & 14;
            if (r3.y() == false) goto L7;
            return 4;
        L7:
            if ((r0 & 4) != 0) goto L14;
            int r1 = r3.q();
            int r4 = r3.p();
            if (r1 == (-1)) goto L15;
            if (r4 == (-1)) goto L16;
            if (r1 != r4) goto L13;
            return r0;
        L13:
            return r0 | 2048;
        L16:
            return r0;
        L15:
            return r0;
        L14:
            return r0;
        }

        public long a() {
            return this.d;
        }

        public c a(s r1, v r2) {
            return k().a(r2);
        }

        public c a(s r1, v r2, int r3, List<Object> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            return k().a(r2);
        }

        public void a(long r1) {
            this.e = r1;
        }

        void a(b r3) {
            this.f14074a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        public final boolean a(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            boolean r0 = c();
            if (r4 == null) goto L7;
            if (r0 == true) goto L6;
            r4.onAnimationsFinished();
            goto L7
        L6:
            this.f14075b.add(r4);
        L7:
            return r0;
        }

        public abstract boolean a(v r1, c r2, c r3);

        public abstract boolean a(v r1, v r2, c r3, c r4);

        public boolean a(v r3, List<Object> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            return h(r3);
        }

        public abstract void b();

        public void b(long r1) {
            this.c = r1;
        }

        public abstract void b(v r1);

        public abstract boolean b(v r1, c r2, c r3);

        public void c(long r1) {
            this.d = r1;
        }

        public abstract boolean c();

        public abstract boolean c(v r1, c r2, c r3);

        public abstract void d();

        public void d(long r1) {
            this.f = r1;
        }

        public final void f(v r1) {
            g(r1);
            b r0 = this.f14074a;
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }

        public long g() {
            return this.e;
        }

        public void g(v r1) {
        }

        public long h() {
            return this.c;
        }

        public boolean h(v r1) {
            return true;
        }

        public long i() {
            return this.f;
        }

        public final void j() {
            int r0 = this.f14075b.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ((a) ZeusTransformUtils.preCheckCast(this.f14075b.get(r1), a.class, "com.obric.memorydata.plugin")).onAnimationsFinished();
            r1 = r1 + 1;
            goto L3
        L5:
            this.f14075b.clear();
        }

        public c k() {
            return new c();
        }
    }

    private class f implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView f14078a;

        f(RecyclerView r1) {
            this.f14078a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.e.b
        public void a(v r3) {
            r3.b(true);
            if (r3.j != null) goto L5;
        L7:
            r3.k = null;
            if (r3.J() == false) goto L10;
            return;
        L10:
            if (this.f14078a.removeAnimatingView(r3.c) == false) goto L12;
            return;
        L12:
            if (r3.C() == false) goto L17;
            this.f14078a.removeDetachedView(r3.c, false);
            return;
        L17:
            return;
        L5:
            if (r3.k != null) goto L7;
            r3.j = null;
            goto L7
        }
    }

    public static abstract class g {
        public g() {
        }

        @Deprecated
        public void a(Canvas r1, RecyclerView r2) {
        }

        public void a(Canvas r1, RecyclerView r2, s r3) {
            b(r1, r2);
        }

        @Deprecated
        public void a(Rect r1, int r2, RecyclerView r3) {
            r1.set(0, 0, 0, 0);
        }

        public void a(Rect r2, View r3, RecyclerView r4, s r5) {
            a(r2, ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).f(), r4);
        }

        @Deprecated
        public void b(Canvas r1, RecyclerView r2) {
        }

        public void b(Canvas r1, RecyclerView r2, s r3) {
            a(r1, r2);
        }
    }

    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ac.b f14079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ac.b f14080b;
        private boolean c;
        private boolean d;
        private int e;
        private int f;
        private int g;
        private int h;
        com.obric.oui.orecyclerview.widget.f p;
        RecyclerView q;
        ac r;
        ac s;
        r t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        boolean y;

        public interface a {
            void b(int r1, int r2);
        }

        public h() {
            ac.b r0 = new AnonymousClass1(this);
            this.f14079a = r0;
            ac.b r1 = new AnonymousClass2(this);
            this.f14080b = r1;
            this.r = new ac(r0);
            this.s = new ac(r1);
            this.u = false;
            this.v = false;
            this.w = false;
            this.c = true;
            this.d = true;
        }

        public static int a(int r2, int r3, int r4) {
            int r0 = View.MeasureSpec.getMode(r2);
            int r5 = View.MeasureSpec.getSize(r2);
            if (r0 == Integer.MIN_VALUE) goto L9;
            if (r0 != 1073741824) goto L7;
            return r5;
        L7:
            return Math.max(r3, r4);
        L9:
            return Math.min(r5, Math.max(r3, r4));
        }

        public static int a(int r4, int r5, int r6, int r7, boolean r8) {
            int r9 = Math.max(0, r4 - r6);
            if (r8 == false) goto L11;
            if (r7 >= 0) goto L12;
            if (r7 != (-1)) goto L21;
            if (r5 == Integer.MIN_VALUE) goto L14;
            if (r5 == 0) goto L21;
            if (r5 != 1073741824) goto L21;
        L14:
            r7 = r9;
        L23:
            return View.MeasureSpec.makeMeasureSpec(r7, r5);
        L21:
            r5 = 0;
            r7 = 0;
        L12:
            r5 = 1073741824;
            goto L23
        L11:
            if (r7 >= 0) goto L12;
            if (r7 == (-1)) goto L14;
            if (r7 != (-2)) goto L21;
            if (r5 == Integer.MIN_VALUE) goto L20;
            if (r5 == 1073741824) goto L20;
            r7 = r9;
            r5 = 0;
        L20:
            r7 = r9;
            r5 = Integer.MIN_VALUE;
            goto L23
        }

        private void a(int r1, View r2) {
            this.p.e(r1);
        }

        private void a(View r5, int r6, boolean r7) {
            v r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r7 == false) goto L5;
        L8:
            this.q.mViewInfoStore.e(r0);
        L9:
            LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            if (r0.v() == true) goto L30;
            if (r0.t() == true) goto L30;
            if (r5.getParent() != this.q) goto L24;
            int r1 = this.p.b(r5);
            if (r6 != (-1)) goto L19;
            r6 = this.p.b();
        L19:
            if (r1 == (-1)) goto L23;
            if (r1 == r6) goto L35;
            this.q.mLayout.f(r1, r6);
        L35:
            if (r8.f == true) goto L37;
            return;
        L37:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L39;
            Log.d(RecyclerView.TAG, "consuming pending invalidate on child " + r8.c);
        L39:
            r0.c.invalidate();
            r8.f = false;
            return;
        L23:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(r5) + this.q.exceptionLabel());
        L24:
            this.p.a(r5, r6, false);
            r8.e = true;
            r r9 = this.t;
            if (r9 == null) goto L35;
            if (r9.h() == false) goto L35;
            this.t.b(r5);
        L30:
            if (r0.t() == false) goto L32;
            r0.u();
        L33:
            this.p.a(r5, r6, r5.getLayoutParams(), false);
            goto L35
        L32:
            r0.w();
            goto L33
        L5:
            if (r0.B() == true) goto L8;
            this.q.mViewInfoStore.f(r0);
            goto L9
        }

        private void a(o r3, int r4, View r5) {
            v r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r0.l() == false) goto L9;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L17;
            Log.d(RecyclerView.TAG, "ignoring view " + r0);
            return;
        L17:
            return;
        L9:
            if (r0.y() == true) goto L11;
        L15:
            h(r4);
            r3.c(r5);
            this.q.mViewInfoStore.h(r0);
            return;
        L11:
            if (r0.B() == true) goto L15;
            if (this.q.mAdapter.f() == true) goto L15;
            g(r4);
            r3.b(r0);
        }

        private static boolean b(int r3, int r4, int r5) {
            int r0 = View.MeasureSpec.getMode(r4);
            int r6 = View.MeasureSpec.getSize(r4);
            if (r5 <= 0) goto L7;
            if (r3 == r5) goto L7;
            return false;
        L7:
            if (r0 == Integer.MIN_VALUE) goto L16;
            if (r0 != 0) goto L10;
            return true;
        L10:
            if (r0 == 1073741824) goto L12;
            return false;
        L12:
            if (r6 == r3) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r6 >= r3) goto L18;
            return false;
        L18:
            return true;
        }

        private int[] c(View r9, Rect r10) {
            int[] r0 = new int[2];
            int r1 = C();
            int r2 = D();
            int r3 = A() - E();
            int r4 = B() - F();
            int r5 = (r9.getLeft() + r10.left) - r9.getScrollX();
            int r6 = (r9.getTop() + r10.top) - r9.getScrollY();
            int r11 = r10.width() + r5;
            int r12 = r10.height() + r6;
            int r7 = r5 - r1;
            int r8 = Math.min(0, r7);
            int r13 = r6 - r2;
            int r14 = Math.min(0, r13);
            int r15 = r11 - r3;
            int r16 = Math.max(0, r15);
            int r17 = Math.max(0, r12 - r4);
            if (v() != 1) goto L7;
            if (r16 != 0) goto L11;
            r16 = Math.max(r8, r15);
        L11:
            if (r14 != 0) goto L14;
            r14 = Math.min(r13, r17);
        L14:
            r0[0] = r16;
            r0[1] = r14;
            return r0;
        L7:
            if (r8 != 0) goto L10;
            r8 = Math.min(r7, r16);
        L10:
            r16 = r8;
            goto L11
        }

        private boolean d(RecyclerView r7, int r8, int r9) {
            View r10 = r7.getFocusedChild();
            if (r10 != null) goto L5;
            return false;
        L5:
            int r1 = C();
            int r2 = D();
            int r3 = A() - E();
            int r4 = B() - F();
            Rect r5 = this.q.mTempRect;
            a(r10, r5);
            if ((r5.left - r8) < r3) goto L8;
        L16:
            return false;
        L8:
            if ((r5.right - r8) <= r1) goto L16;
            if ((r5.top - r9) >= r4) goto L16;
            if ((r5.bottom - r9) <= r2) goto L16;
            return true;
        }

        public int A() {
            return this.g;
        }

        public int B() {
            return this.h;
        }

        public int C() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingLeft();
        }

        public int D() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingTop();
        }

        public int E() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingRight();
        }

        public int F() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingBottom();
        }

        public View G() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r1 = r0.getFocusedChild();
            if (r1 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.p.c(r1) == true) goto L11;
            return r1;
        }

        public int H() {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L5;
            Adapter r1 = r0.getAdapter();
        L6:
            if (r1 != null) goto L10;
            return 0;
        L10:
            return r1.d();
        L5:
            r1 = null;
            goto L6
        }

        public int I() {
            return ViewCompat.getMinimumWidth(this.q);
        }

        public int J() {
            return ViewCompat.getMinimumHeight(this.q);
        }

        void K() {
            r r0 = this.t;
            if (r0 == null) goto L6;
            r0.f();
            return;
        }

        public void L() {
            this.u = true;
        }

        boolean M() {
            int r0 = x();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            ViewGroup.LayoutParams r3 = i(r2).getLayoutParams();
            if (r3.width >= 0) goto L10;
            if (r3.height >= 0) goto L10;
            return true;
        L10:
            r2 = r2 + 1;
            goto L3
        L11:
            return false;
        }

        public int a(int r1, o r2, s r3) {
            return 0;
        }

        public int a(o r1, s r2) {
            return -1;
        }

        public View a(View r1, int r2, o r3, s r4) {
            return null;
        }

        public abstract LayoutParams a();

        public LayoutParams a(Context r2, AttributeSet r3) {
            return new LayoutParams((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        public LayoutParams a(ViewGroup.LayoutParams r3) {
            if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == false) goto L7;
            return new LayoutParams((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.memorydata.plugin"));
        L7:
            if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
        L11:
            return new LayoutParams(r3);
        }

        public void a(int r1, int r2, s r3, a r4) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        }

        public void a(int r1, a r2) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        }

        public void a(int r2, o r3) {
            View r0 = i(r2);
            g(r2);
            r3.a(r0);
        }

        public void a(Rect r3, int r4, int r5) {
            int r0 = (r3.width() + C()) + E();
            int r6 = (r3.height() + D()) + F();
            g(a(r4, r0, I()), a(r5, r6, J()));
        }

        public void a(Parcelable r2) {
            Parcelable r1 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r2, Parcelable.class, "com.obric.memorydata.plugin");
        }

        public void a(View r2) {
            a(r2, -1);
        }

        public void a(View r2, int r3) {
            a(r2, r3, true);
        }

        public void a(View r6, int r7, int r8) {
            LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            Rect r1 = this.q.getItemDecorInsetsForChild(r6);
            int r9 = r7 + (r1.left + r1.right);
            int r10 = r8 + (r1.top + r1.bottom);
            int r11 = a(A(), y(), (((C() + E()) + r0.leftMargin) + r0.rightMargin) + r9, r0.width, e());
            int r12 = a(B(), z(), (((D() + F()) + r0.topMargin) + r0.bottomMargin) + r10, r0.height, f());
            if (b(r6, r11, r12, r0) == false) goto L6;
            r6.measure(r11, r12);
            return;
        }

        public void a(View r3, int r4, int r5, int r6, int r7) {
            Rect r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d;
            r3.layout(r4 + r2.left, r5 + r2.top, r6 - r2.right, r7 - r2.bottom);
        }

        public void a(View r3, int r4, LayoutParams r5) {
            v r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0.B() == false) goto L5;
            this.q.mViewInfoStore.e(r0);
        L6:
            this.p.a(r3, r4, r5, r0.B());
            return;
        L5:
            this.q.mViewInfoStore.f(r0);
            goto L6
        }

        public void a(View r1, Rect r2) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r1, r2);
        }

        void a(View r3, AccessibilityNodeInfoCompat r4) {
            v r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.B() == false) goto L7;
            return;
        L7:
            if (this.p.c(r0.c) == true) goto L12;
            a(this.q.mRecycler, this.q.mState, r3, r4);
            return;
        }

        public void a(View r2, o r3) {
            a(r3, this.p.b(r2), r2);
        }

        public void a(View r5, boolean r6, Rect r7) {
            if (r6 == false) goto L4;
            Rect r8 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d;
            r7.set(-r8.left, -r8.top, r5.getWidth() + r8.right, r5.getHeight() + r8.bottom);
        L6:
            if (this.q == null) goto L12;
            Matrix r9 = r5.getMatrix();
            if (r9 == null) goto L12;
            if (r9.isIdentity() == true) goto L12;
            RectF r4 = this.q.mTempRectF;
            r4.set(r7);
            r9.mapRect(r4);
            r7.set((int) Math.floor(r4.left), (int) Math.floor(r4.top), (int) Math.ceil(r4.right), (int) Math.ceil(r4.bottom));
        L12:
            r7.offset(r5.getLeft(), r5.getTop());
            return;
        L4:
            r7.set(0, 0, r5.getWidth(), r5.getHeight());
            goto L6
        }

        public void a(AccessibilityEvent r3) {
            a(this.q.mRecycler, this.q.mState, r3);
        }

        void a(AccessibilityNodeInfoCompat r3) {
            a(this.q.mRecycler, this.q.mState, r3);
        }

        public void a(Adapter r1, Adapter r2) {
        }

        public void a(o r3) {
            int r0 = x() - 1;
        L3:
            if (r0 < 0) goto L5;
            a(r3, r0, i(r0));
            r0 = r0 - 1;
            goto L3
        }

        public void a(o r1, s r2, int r3, int r4) {
            this.q.defaultOnMeasure(r3, r4);
        }

        public void a(o r1, s r2, View r3, AccessibilityNodeInfoCompat r4) {
        }

        public void a(o r2, s r3, AccessibilityEvent r4) {
            RecyclerView r5 = this.q;
            if (r5 == null) goto L20;
            if (r4 == null) goto L22;
            boolean r6 = true;
            if (r5.canScrollVertically(1) == false) goto L9;
        L16:
            r4.setScrollable(r6);
            if (this.q.mAdapter == null) goto L21;
            r4.setItemCount(this.q.mAdapter.d());
            return;
        L21:
            return;
        L9:
            if (this.q.canScrollVertically(-1) == true) goto L16;
            if (this.q.canScrollHorizontally(-1) == true) goto L16;
            if (this.q.canScrollHorizontally(1) == true) goto L16;
            r6 = false;
            goto L16
        L22:
            return;
        }

        public void a(o r4, s r5, AccessibilityNodeInfoCompat r6) {
            if (this.q.canScrollVertically(-1) == false) goto L5;
        L6:
            r6.addAction(8192);
            r6.setScrollable(true);
        L8:
            if (this.q.canScrollVertically(1) == false) goto L10;
        L11:
            r6.addAction(4096);
            r6.setScrollable(true);
        L12:
            r6.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(a(r4, r5), b(r4, r5), e(r4, r5), d(r4, r5)));
            return;
        L10:
            if (this.q.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.q.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public void a(r r2) {
            r r0 = this.t;
            if (r0 == null) goto L8;
            if (r2 == r0) goto L8;
            if (r0.h() == false) goto L8;
            this.t.f();
        L8:
            this.t = r2;
            r2.a(this.q, this);
        }

        public void a(s r1) {
        }

        public void a(RecyclerView r1) {
        }

        public void a(RecyclerView r1, int r2, int r3) {
        }

        public void a(RecyclerView r1, int r2, int r3, int r4) {
        }

        public void a(RecyclerView r1, int r2, int r3, Object r4) {
            c(r1, r2, r3);
        }

        public void a(RecyclerView r1, o r2) {
            e(r1);
        }

        public void a(RecyclerView r1, s r2, int r3) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(String r1) {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.assertNotInLayoutOrScroll(r1);
            return;
        }

        boolean a(int r3, Bundle r4) {
            return a(this.q.mRecycler, this.q.mState, r3, r4);
        }

        boolean a(View r2, int r3, int r4, LayoutParams r5) {
            if (this.c == true) goto L5;
        L10:
            return true;
        L5:
            if (b(r2.getMeasuredWidth(), r3, r5.width) == false) goto L10;
            if (b(r2.getMeasuredHeight(), r4, r5.height) == false) goto L10;
            return false;
        }

        boolean a(View r8, int r9, Bundle r10) {
            return a(this.q.mRecycler, this.q.mState, r8, r9, r10);
        }

        public boolean a(View r3, boolean r4, boolean r5) {
            if (this.r.a(r3, 24579) == true) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r4 == false) goto L11;
            return r2;
        L11:
            return !r2;
        L5:
            if (this.s.a(r3, 24579) == false) goto L7;
            r2 = true;
            goto L8
        }

        public boolean a(LayoutParams r1) {
            if (r1 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public boolean a(o r9, s r10, int r11, Bundle r12) {
            if (this.q != null) goto L5;
            return false;
        L5:
            int r13 = B();
            int r14 = A();
            Rect r0 = new Rect();
            if (this.q.getMatrix().isIdentity() == false) goto L11;
            if (this.q.getGlobalVisibleRect(r0) == false) goto L11;
            r13 = r0.height();
            r14 = r0.width();
        L11:
            if (r11 == 4096) goto L23;
            if (r11 == 8192) goto L16;
            int r3 = 0;
            int r4 = 0;
        L31:
            if (r4 != 0) goto L34;
            if (r3 != 0) goto L34;
            return false;
        L34:
            this.q.smoothScrollBy(r3, r4, null, Integer.MIN_VALUE, true);
            return true;
        L16:
            if (this.q.canScrollVertically(-1) == false) goto L18;
            int r15 = -((r13 - D()) - F());
        L20:
            if (this.q.canScrollHorizontally(-1) == false) goto L30;
            int r16 = -((r14 - C()) - E());
        L29:
            r4 = r15;
            r3 = r16;
        L30:
            r4 = r15;
            r3 = 0;
            goto L31
        L18:
            r15 = 0;
            goto L20
        L23:
            if (this.q.canScrollVertically(1) == false) goto L25;
            r15 = (r13 - D()) - F();
        L27:
            if (this.q.canScrollHorizontally(1) == false) goto L30;
            r16 = (r14 - C()) - E();
            goto L29
        L25:
            r15 = 0;
            goto L27
        }

        public boolean a(o r1, s r2, View r3, int r4, Bundle r5) {
            return false;
        }

        public boolean a(RecyclerView r7, View r8, Rect r9, boolean r10) {
            return a(r7, r8, r9, r10, false);
        }

        public boolean a(RecyclerView r3, View r4, Rect r5, boolean r6, boolean r7) {
            int[] r8 = c(r4, r5);
            int r0 = r8[0];
            int r9 = r8[1];
            if (r7 == true) goto L5;
        L6:
            if (r0 != 0) goto L10;
            if (r9 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r6 == false) goto L12;
            r3.scrollBy(r0, r9);
        L13:
            return true;
        L12:
            r3.smoothScrollBy(r0, r9);
            goto L13
        L5:
            if (d(r3, r0, r9) == false) goto L9;
            goto L6
        }

        @Deprecated
        public boolean a(RecyclerView r1, View r2, View r3) {
            if (u() == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.isComputingLayout() == true) goto L8;
            return false;
        }

        public boolean a(RecyclerView r1, s r2, View r3, View r4) {
            return a(r1, r3, r4);
        }

        public boolean a(RecyclerView r1, ArrayList<View> r2, int r3, int r4) {
            return false;
        }

        public boolean a(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            RecyclerView r2 = this.q;
            if (r2 != null) goto L5;
            return false;
        L5:
            return r2.removeCallbacks(r4);
        }

        public int b(int r1, o r2, s r3) {
            return 0;
        }

        public int b(o r1, s r2) {
            return -1;
        }

        public int b(s r1) {
            return 0;
        }

        public void b(View r2) {
            b(r2, -1);
        }

        public void b(View r2, int r3) {
            a(r2, r3, false);
        }

        public void b(View r3, int r4, int r5, int r6, int r7) {
            LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            Rect r0 = r2.d;
            r3.layout((r4 + r0.left) + r2.leftMargin, (r5 + r0.top) + r2.topMargin, (r6 - r0.right) - r2.rightMargin, (r7 - r0.bottom) - r2.bottomMargin);
        }

        public void b(View r1, Rect r2) {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L6;
            r2.set(0, 0, 0, 0);
            return;
        L6:
            r2.set(r0.getItemDecorInsetsForChild(r1));
        }

        public void b(View r1, o r2) {
            c(r1);
            r2.a(r1);
        }

        void b(o r7) {
            int r0 = r7.e();
            int r1 = r0 - 1;
        L3:
            if (r1 < 0) goto L15;
            View r2 = r7.e(r1);
            v r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3.l() == true) goto L14;
            r3.b(false);
            if (r3.C() == false) goto L11;
            this.q.removeDetachedView(r2, false);
        L11:
            if (this.q.mItemAnimator == null) goto L13;
            this.q.mItemAnimator.b(r3);
        L13:
            r3.b(true);
            r7.b(r2);
        L14:
            r1 = r1 - 1;
            goto L3
        L15:
            r7.f();
            if (r0 <= 0) goto L22;
            this.q.invalidate();
            return;
        }

        void b(r r2) {
            if (this.t != r2) goto L6;
            this.t = null;
            return;
        }

        void b(RecyclerView r2) {
            if (r2 != null) goto L4;
            this.q = null;
            this.p = null;
            int r3 = 0;
            this.g = 0;
        L5:
            this.h = r3;
            this.e = 1073741824;
            this.f = 1073741824;
            return;
        L4:
            this.q = r2;
            this.p = r2.mChildHelper;
            this.g = r2.getWidth();
            r3 = r2.getHeight();
            goto L5
        }

        public void b(RecyclerView r1, int r2, int r3) {
        }

        void b(RecyclerView r2, o r3) {
            this.v = false;
            a(r2, r3);
        }

        public boolean b() {
            return false;
        }

        boolean b(View r2, int r3, int r4, LayoutParams r5) {
            if (r2.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.c == false) goto L12;
            if (b(r2.getWidth(), r3, r5.width) == false) goto L12;
            if (b(r2.getHeight(), r4, r5.height) == false) goto L12;
            return false;
        }

        public int c(s r1) {
            return 0;
        }

        public View c(int r6) {
            int r0 = x();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L17;
            View r2 = i(r1);
            v r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3 == null) goto L16;
            if (r3.m() != r6) goto L16;
            if (r3.l() == true) goto L16;
            if (this.q.mState.a() == true) goto L15;
            if (r3.B() == true) goto L16;
        L15:
            return r2;
        L16:
            r1 = r1 + 1;
            goto L3
        L17:
            return null;
        }

        public void c(View r1) {
            this.p.a(r1);
        }

        public void c(View r4, int r5) {
            a(r4, r5, (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin"));
        }

        public void c(o r3) {
            int r0 = x() - 1;
        L3:
            if (r0 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(i(r0)).l() == true) goto L7;
            a(r0, r3);
        L7:
            r0 = r0 - 1;
            goto L3
        }

        public void c(o r1, s r2) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void c(RecyclerView r2) {
            this.v = true;
            d(r2);
        }

        public void c(RecyclerView r1, int r2, int r3) {
        }

        public boolean c() {
            return this.w;
        }

        public int d(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).f();
        }

        public int d(o r1, s r2) {
            return 0;
        }

        public int d(s r1) {
            return 0;
        }

        public Parcelable d() {
            return null;
        }

        public View d(View r1, int r2) {
            return null;
        }

        void d(int r2, int r3) {
            this.g = View.MeasureSpec.getSize(r2);
            int r4 = View.MeasureSpec.getMode(r2);
            this.e = r4;
            if (r4 == 0) goto L5;
        L7:
            this.h = View.MeasureSpec.getSize(r3);
            int r5 = View.MeasureSpec.getMode(r3);
            this.f = r5;
            if (r5 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L14;
            this.h = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L7;
            this.g = 0;
            goto L7
        }

        public void d(RecyclerView r1) {
        }

        public int e(s r1) {
            return 0;
        }

        public View e(View r3) {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r4 = r0.findContainingItemView(r3);
            if (r4 != null) goto L9;
            return null;
        L9:
            if (this.p.c(r4) == false) goto L11;
            return null;
        L11:
            return r4;
        }

        public void e(int r1) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L6;
            Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            return;
        }

        void e(int r9, int r10) {
            int r0 = x();
            if (r0 != 0) goto L6;
            this.q.defaultOnMeasure(r9, r10);
            return;
        L6:
            int r1 = 0;
            int r2 = Integer.MIN_VALUE;
            int r4 = Integer.MAX_VALUE;
            int r5 = Integer.MAX_VALUE;
            int r3 = Integer.MIN_VALUE;
        L7:
            if (r1 >= r0) goto L21;
            View r6 = i(r1);
            Rect r7 = this.q.mTempRect;
            a(r6, r7);
            if (r7.left >= r4) goto L12;
            r4 = r7.left;
        L12:
            if (r7.right <= r2) goto L15;
            r2 = r7.right;
        L15:
            if (r7.top >= r5) goto L18;
            r5 = r7.top;
        L18:
            if (r7.bottom <= r3) goto L20;
            r3 = r7.bottom;
        L20:
            r1 = r1 + 1;
            goto L7
        L21:
            this.q.mTempRect.set(r4, r5, r2, r3);
            a(this.q.mTempRect, r9, r10);
        }

        @Deprecated
        public void e(RecyclerView r1) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(o r1, s r2) {
            return false;
        }

        public int f(View r3) {
            Rect r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d;
            return (r3.getMeasuredWidth() + r2.left) + r2.right;
        }

        public void f(int r3, int r4) {
            View r0 = i(r3);
            if (r0 == null) goto L7;
            h(r3);
            c(r0, r4);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r3 + this.q.toString());
        }

        void f(RecyclerView r3) {
            d(View.MeasureSpec.makeMeasureSpec(r3.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r3.getHeight(), 1073741824));
        }

        public boolean f() {
            return false;
        }

        public int g(View r3) {
            Rect r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d;
            return (r3.getMeasuredHeight() + r2.top) + r2.bottom;
        }

        public int g(s r1) {
            return 0;
        }

        public void g(int r2) {
            if (i(r2) == null) goto L6;
            this.p.a(r2);
            return;
        }

        public void g(int r1, int r2) {
            RecyclerView.access$500(this.q, r1, r2);
        }

        public int h(View r2) {
            return r2.getLeft() - n(r2);
        }

        public int h(s r1) {
            return 0;
        }

        public void h(int r2) {
            a(r2, i(r2));
        }

        public int i(View r2) {
            return r2.getTop() - l(r2);
        }

        public View i(int r1) {
            com.obric.oui.orecyclerview.widget.f r0 = this.p;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b(r1);
        }

        public int j(View r2) {
            return r2.getRight() + o(r2);
        }

        public void j(int r1) {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.offsetChildrenHorizontal(r1);
            return;
        }

        public int k(View r2) {
            return r2.getBottom() + m(r2);
        }

        public void k(int r1) {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.offsetChildrenVertical(r1);
            return;
        }

        public int l(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d.top;
        }

        public void l(int r1) {
        }

        public int m(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d.bottom;
        }

        public int n(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d.left;
        }

        boolean n() {
            return false;
        }

        public int o(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).d.right;
        }

        public void q() {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.requestLayout();
            return;
        }

        public final boolean r() {
            return this.d;
        }

        public boolean s() {
            return this.v;
        }

        public boolean t() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.mClipToPadding == false) goto L7;
            return true;
        }

        public boolean u() {
            r r0 = this.t;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.h() == false) goto L7;
            return true;
        }

        public int v() {
            return ViewCompat.getLayoutDirection(this.q);
        }

        public int w() {
            return -1;
        }

        public int x() {
            com.obric.oui.orecyclerview.widget.f r0 = this.p;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.b();
        }

        public int y() {
            return this.e;
        }

        public int z() {
            return this.f;
        }
    }

    public interface i {
        void onTranslationChanged(float r1);
    }

    public interface j {
        void a(View r1);

        void b(View r1);
    }

    public static abstract class k {
        public k() {
        }

        public abstract boolean a(int r1, int r2);
    }

    public interface l {
        void a(boolean r1);

        boolean a(RecyclerView r1, MotionEvent r2);

        void b(RecyclerView r1, MotionEvent r2);
    }

    public static abstract class m {
        public m() {
        }

        public void a(RecyclerView r1, int r2) {
        }

        public void a(RecyclerView r1, int r2, int r3) {
        }
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<a> f14083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14084b;
        Set<Adapter<?>> c;

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ArrayList<v> f14085a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f14086b;
            long c;
            long d;

            a() {
                this.f14085a = new ArrayList();
                this.f14086b = 5;
                this.c = 0;
                this.d = 0;
            }
        }

        public n() {
            this.f14083a = new SparseArray();
            this.f14084b = 0;
            this.c = Collections.newSetFromMap(new IdentityHashMap());
        }

        private a b(int r4) {
            a r0 = (a) ZeusTransformUtils.preCheckCast(this.f14083a.get(r4), a.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            a r1 = new a();
            this.f14083a.put(r4, r1);
            return r1;
        L6:
            return r0;
        }

        long a(long r5, long r7) {
            if (r5 != 0) goto L6;
            return r7;
        L6:
            return ((r5 / 4) * 3) + (r7 / 4);
        }

        public v a(int r4) {
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.f14083a.get(r4), a.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
            return null;
        L5:
            if (r3.f14085a.isEmpty() == true) goto L17;
            ArrayList<v> r5 = r3.f14085a;
            int r6 = r5.size() - 1;
        L7:
            if (r6 < 0) goto L18;
            if (((v) ZeusTransformUtils.preCheckCast(r5.get(r6), v.class, "com.obric.memorydata.plugin")).D() == false) goto L11;
            r6 = r6 - 1;
            goto L7
        L11:
            return (v) ZeusTransformUtils.preCheckCast(r5.remove(r6), v.class, "com.obric.memorydata.plugin");
        L18:
            return null;
        L17:
            return null;
        }

        public void a() {
            int r0 = 0;
        L4:
            if (r0 >= this.f14083a.size()) goto L10;
            a r1 = (a) ZeusTransformUtils.preCheckCast(this.f14083a.valueAt(r0), a.class, "com.obric.memorydata.plugin");
            Iterator<v> r2 = r1.f14085a.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            PoolingContainer.callPoolingContainerOnRelease(((v) ZeusTransformUtils.preCheckCast(r2.next(), v.class, "com.obric.memorydata.plugin")).c);
            goto L7
        L9:
            r1.f14085a.clear();
            r0 = r0 + 1;
            goto L4
        }

        void a(int r3, long r4) {
            a r5 = b(r3);
            r5.c = a(r5.c, r4);
        }

        void a(Adapter<?> r1) {
            this.c.add(r1);
        }

        void a(Adapter<?> r1, Adapter<?> r2, boolean r3) {
            if (r1 == null) goto L4;
            c();
        L4:
            if (r3 == false) goto L6;
        L8:
            if (r2 == null) goto L11;
            b();
            return;
        L11:
            return;
        L6:
            if (this.f14084b != 0) goto L8;
            a();
            goto L8
        }

        void a(Adapter<?> r6, boolean r7) {
            this.c.remove(r6);
            if (this.c.size() != 0) goto L13;
            if (r7 == true) goto L16;
            int r8 = 0;
        L7:
            if (r8 >= this.f14083a.size()) goto L17;
            SparseArray<a> r0 = this.f14083a;
            ArrayList<v> r1 = ((a) ZeusTransformUtils.preCheckCast(r0.get(r0.keyAt(r8)), a.class, "com.obric.memorydata.plugin")).f14085a;
            int r2 = 0;
        L10:
            if (r2 >= r1.size()) goto L12;
            PoolingContainer.callPoolingContainerOnRelease(((v) ZeusTransformUtils.preCheckCast(r1.get(r2), v.class, "com.obric.memorydata.plugin")).c);
            r2 = r2 + 1;
            goto L10
        L12:
            r8 = r8 + 1;
            goto L7
        L17:
            return;
        L16:
            return;
        }

        public void a(v r4) {
            int r0 = r4.s();
            ArrayList<v> r1 = b(r0).f14085a;
            if (((a) ZeusTransformUtils.preCheckCast(this.f14083a.get(r0), a.class, "com.obric.memorydata.plugin")).f14086b > r1.size()) goto L7;
            PoolingContainer.callPoolingContainerOnRelease(r4.c);
            return;
        L7:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L9;
        L13:
            r4.H();
            r1.add(r4);
            return;
        L9:
            if (r1.contains(r4) == false) goto L13;
            throw new IllegalArgumentException("this scrap item already exists");
        }

        boolean a(int r3, long r4, long r6) {
            long r2 = b(r3).c;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }

        void b() {
            this.f14084b++;
        }

        void b(int r3, long r4) {
            a r5 = b(r3);
            r5.d = a(r5.d, r4);
        }

        boolean b(int r3, long r4, long r6) {
            long r2 = b(r3).d;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }

        void c() {
            this.f14084b--;
        }
    }

    public final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<v> f14087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<v> f14088b;
        final ArrayList<v> c;
        int d;
        n e;
        final /* synthetic */ RecyclerView f;
        private final List<v> g;
        private int h;
        private t i;

        public o(RecyclerView r2) {
            this.f = r2;
            ArrayList<v> r3 = new ArrayList();
            this.f14087a = r3;
            this.f14088b = null;
            this.c = new ArrayList();
            this.g = Collections.unmodifiableList(r3);
            this.h = 2;
            this.d = 2;
        }

        private void a(ViewGroup r6, boolean r7) {
            int r0 = r6.getChildCount() - 1;
        L3:
            if (r0 < 0) goto L8;
            View r2 = r6.getChildAt(r0);
            if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L7;
            a((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin"), true);
        L7:
            r0 = r0 - 1;
            goto L3
        L8:
            if (r7 == true) goto L11;
            return;
        L11:
            if (r6.getVisibility() != 4) goto L13;
            r6.setVisibility(0);
            r6.setVisibility(4);
            return;
        L13:
            int r5 = r6.getVisibility();
            r6.setVisibility(4);
            r6.setVisibility(r5);
        }

        private void a(Adapter<?> r2) {
            a(r2, false);
        }

        private void a(Adapter<?> r1, boolean r2) {
            n r0 = this.e;
            if (r0 == null) goto L6;
            r0.a(r1, r2);
            return;
        }

        private boolean a(v r11, int r12, int r13, long r14) {
            r11.s = null;
            r11.r = this.f;
            int r2 = r11.s();
            long r7 = this.f.getNanoTime();
            boolean r9 = false;
            if (r14 == Long.MAX_VALUE) goto L8;
            if (this.e.b(r2, r7, r14) == true) goto L8;
            return false;
        L8:
            if (r11.C() == false) goto L10;
            RecyclerView.access$300(this.f, r11.c, this.f.getChildCount(), r11.c.getLayoutParams());
            r9 = true;
        L10:
            this.f.mAdapter.b(r11, r12);
            if (r9 == false) goto L13;
            RecyclerView.access$400(this.f, r11.c);
        L13:
            this.e.b(r11.s(), this.f.getNanoTime() - r7);
            e(r11);
            if (this.f.mState.a() == false) goto L16;
            r11.i = r13;
        L16:
            return true;
        }

        private void e(v r3) {
            if (this.f.isAccessibilityEnabled() == false) goto L15;
            View r4 = r3.c;
            if (ViewCompat.getImportantForAccessibility(r4) != 0) goto L8;
            ViewCompat.setImportantForAccessibility(r4, 1);
        L8:
            if (this.f.mAccessibilityDelegate != null) goto L10;
            return;
        L10:
            AccessibilityDelegateCompat r2 = this.f.mAccessibilityDelegate.getItemDelegate();
            if (ZeusTransformUtils.instanceOf(r2, RecyclerViewAccessibilityDelegate.ItemDelegate.class) == false) goto L13;
            ((RecyclerViewAccessibilityDelegate.ItemDelegate) ZeusTransformUtils.preCheckCast(r2, RecyclerViewAccessibilityDelegate.ItemDelegate.class, "com.obric.memorydata.plugin")).saveOriginalDelegate(r4);
        L13:
            ViewCompat.setAccessibilityDelegate(r4, r2);
            return;
        }

        private void f(v r3) {
            if (ZeusTransformUtils.instanceOf(r3.c, ViewGroup.class) == false) goto L6;
            a((ViewGroup) ZeusTransformUtils.preCheckCast(r3.c, ViewGroup.class, "com.obric.memorydata.plugin"), false);
            return;
        }

        private void m() {
            if (this.e != null) goto L5;
            return;
        L5:
            if (this.f.mAdapter != null) goto L7;
            return;
        L7:
            if (this.f.isAttachedToWindow() == false) goto L12;
            this.e.a(this.f.mAdapter);
            return;
        }

        View a(int r3, boolean r4) {
            return a(r3, r4, Long.MAX_VALUE).c;
        }

        v a(int r19, boolean r20, long r21) {
            if (r19 < 0) goto L124;
            if (r19 >= this.f.mState.e()) goto L124;
            boolean r7 = true;
            if (this.f.mState.a() == false) goto L11;
            v r1 = f(r19);
            if (r1 == null) goto L12;
            boolean r4 = true;
        L13:
            if (r1 != null) goto L28;
            r1 = b(r19, r20);
            if (r1 == null) goto L28;
            if (a(r1) == true) goto L27;
            if (r20 == true) goto L26;
            r1.b(4);
            if (r1.t() == false) goto L23;
            this.f.removeDetachedView(r1.c, false);
            r1.u();
        L25:
            b(r1);
            goto L26
        L23:
            if (r1.v() == false) goto L25;
            r1.w();
        L26:
            r1 = null;
            goto L28
        L27:
            r4 = true;
        L28:
            if (r1 != null) goto L78;
            int r5 = this.f.mAdapterHelper.b(r19);
            if (r5 < 0) goto L77;
            if (r5 >= this.f.mAdapter.d()) goto L77;
            int r9 = this.f.mAdapter.a(r5);
            if (this.f.mAdapter.f() == false) goto L38;
            r1 = a(this.f.mAdapter.c(r5), r9, r20);
            if (r1 == null) goto L38;
            r1.e = r5;
            r4 = true;
        L38:
            if (r1 != null) goto L53;
            t r0 = this.i;
            if (r0 == null) goto L53;
            View r2 = r0.a(this, r19, r9);
            if (r2 == null) goto L53;
            r1 = this.f.getChildViewHolder(r2);
            if (r1 == null) goto L51;
            if (r1.l() == false) goto L53;
            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.f.exceptionLabel());
        L51:
            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.f.exceptionLabel());
        L53:
            if (r1 == null) goto L55;
        L62:
            if (r1 != null) goto L78;
            long r16 = this.f.getNanoTime();
            if (r21 != Long.MAX_VALUE) goto L66;
        L68:
            r1 = this.f.mAdapter.c(this.f, r9);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L73;
            RecyclerView r3 = RecyclerView.findNestedRecyclerView(r1.c);
            if (r3 == null) goto L73;
            r1.d = new WeakReference(r3);
        L73:
            this.e.a(r9, this.f.getNanoTime() - r16);
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L78;
            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline created new ViewHolder");
            goto L78
        L66:
            if (this.e.a(r9, r16, r21) == true) goto L68;
            return null;
        L55:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L57;
            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline(" + r19 + ") fetching from shared pool");
        L57:
            r1 = i().a(r9);
            if (r1 == null) goto L62;
            r1.H();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L62;
            f(r1);
        L77:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r19 + "(offset:" + r5 + ").state:" + this.f.mState.e() + this.f.exceptionLabel());
        L78:
            v r10 = r1;
            boolean r11 = r4;
            if (r11 == false) goto L88;
            if (this.f.mState.a() == true) goto L88;
            if (r10.a(8192) == false) goto L88;
            r10.b(0, 8192);
            if (this.f.mState.j == false) goto L88;
            this.f.recordAnimationInfoIfBouncedHiddenView(r10, this.f.mItemAnimator.a(this.f.mState, r10, e.e(r10) | 4096, r10.G()));
        L88:
            if (this.f.mState.a() == false) goto L93;
            if (r10.A() == false) goto L93;
            r10.i = r19;
        L99:
            boolean r6 = false;
        L108:
            ViewGroup.LayoutParams r8 = r10.c.getLayoutParams();
            if (r8 != null) goto L113;
            ViewGroup.LayoutParams r12 = this.f.generateDefaultLayoutParams();
        L111:
            LayoutParams r13 = (LayoutParams) ZeusTransformUtils.preCheckCast(r12, LayoutParams.class, "com.obric.memorydata.plugin");
            r10.c.setLayoutParams(r13);
        L116:
            r13.c = r10;
            if (r11 == false) goto L120;
            if (r6 == false) goto L120;
        L121:
            r13.f = r7;
            return r10;
        L120:
            r7 = false;
            goto L121
        L113:
            if (this.f.checkLayoutParams(r8) == true) goto L115;
            r12 = this.f.generateLayoutParams(r8);
            goto L111
        L115:
            r13 = (LayoutParams) ZeusTransformUtils.preCheckCast(r8, LayoutParams.class, "com.obric.memorydata.plugin");
        L93:
            if (r10.A() == false) goto L101;
            if (r10.z() == true) goto L101;
            if (r10.y() == false) goto L99;
        L101:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L103;
        L107:
            r6 = a(r10, this.f.mAdapterHelper.b(r19), r19, r21);
            goto L108
        L103:
            if (r10.B() == false) goto L107;
            throw new IllegalStateException("Removed holder should be bound and it should come here only in pre-layout. Holder: " + r10 + this.f.exceptionLabel());
        L12:
            r4 = false;
            goto L13
        L11:
            r1 = null;
        L124:
            throw new IndexOutOfBoundsException("Invalid item position " + r19 + "(" + r19 + "). Item count:" + this.f.mState.e() + this.f.exceptionLabel());
        }

        v a(long r7, int r9, boolean r10) {
            int r0 = this.f14087a.size();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L20;
            v r1 = (v) ZeusTransformUtils.preCheckCast(this.f14087a.get(r0), v.class, "com.obric.memorydata.plugin");
            if (r1.r() != r7) goto L3;
            if (r1.v() == true) goto L3;
            if (r9 == r1.s()) goto L11;
            if (r10 == true) goto L3;
            this.f14087a.remove(r0);
            this.f.removeDetachedView(r1.c, false);
            b(r1.c);
            goto L3
        L11:
            r1.b(32);
            if (r1.B() == true) goto L14;
        L16:
            return r1;
        L14:
            if (this.f.mState.a() == true) goto L16;
            r1.b(2, 14);
            goto L16
        L20:
            int r2 = this.c.size();
        L21:
            r2 = r2 - 1;
            if (r2 < 0) goto L36;
            v r3 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r2), v.class, "com.obric.memorydata.plugin");
            if (r3.r() != r7) goto L21;
            if (r3.D() == true) goto L21;
            if (r9 == r3.s()) goto L29;
            if (r10 == true) goto L21;
            d(r2);
            return null;
        L29:
            if (r10 == true) goto L31;
            this.c.remove(r2);
        L31:
            return r3;
        L36:
            return null;
        }

        public void a() {
            this.f14087a.clear();
            d();
        }

        public void a(int r1) {
            this.h = r1;
            b();
        }

        void a(int r10, int r11) {
            if (r10 >= r11) goto L4;
            int r0 = -1;
            int r1 = r10;
            int r2 = r11;
        L5:
            int r3 = this.c.size();
            int r5 = 0;
        L6:
            if (r5 >= r3) goto L22;
            v r6 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r5), v.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L21;
            if (r6.e < r1) goto L21;
            if (r6.e > r2) goto L21;
            if (r6.e != r10) goto L17;
            r6.a(r11 - r10, false);
        L19:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L21;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForMove cached child " + r5 + " holder " + r6);
            goto L21
        L17:
            r6.a(r0, false);
        L21:
            r5 = r5 + 1;
            goto L6
        L22:
            return;
        L4:
            r0 = 1;
            r2 = r10;
            r1 = r11;
            goto L5
        }

        void a(int r6, int r7, boolean r8) {
            int r0 = r6 + r7;
            int r1 = this.c.size() - 1;
        L3:
            if (r1 < 0) goto L16;
            v r2 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r1), v.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L15;
            if (r2.e < r0) goto L13;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForRemove cached " + r1 + " holder " + r2 + " now at position " + (r2.e - r7));
        L11:
            r2.a(-r7, r8);
            goto L15
        L13:
            if (r2.e < r6) goto L15;
            r2.b(8);
            d(r1);
        L15:
            r1 = r1 - 1;
            goto L3
        }

        public void a(View r4) {
            v r0 = RecyclerView.getChildViewHolderInt(r4);
            if (r0.C() == false) goto L6;
            this.f.removeDetachedView(r4, false);
        L6:
            if (r0.t() == false) goto L9;
            r0.u();
        L11:
            b(r0);
            if (this.f.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r0.I() == true) goto L18;
            this.f.mItemAnimator.b(r0);
            return;
        L18:
            return;
        L9:
            if (r0.v() == false) goto L11;
            r0.w();
            goto L11
        }

        void a(Adapter<?> r2, Adapter<?> r3, boolean r4) {
            a();
            a(r2, true);
            i().a(r2, r3, r4);
            m();
        }

        void a(n r2) {
            a(this.f.mAdapter);
            n r0 = this.e;
            if (r0 == null) goto L5;
            r0.c();
        L5:
            this.e = r2;
            if (r2 != null) goto L8;
        L10:
            m();
            return;
        L8:
            if (this.f.getAdapter() == null) goto L10;
            this.e.b();
            goto L10
        }

        void a(t r1) {
            this.i = r1;
        }

        void a(v r6, boolean r7) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r6);
            View r0 = r6.c;
            if (this.f.mAccessibilityDelegate == null) goto L9;
            AccessibilityDelegateCompat r1 = this.f.mAccessibilityDelegate.getItemDelegate();
            if (ZeusTransformUtils.instanceOf(r1, RecyclerViewAccessibilityDelegate.ItemDelegate.class) == false) goto L7;
            AccessibilityDelegateCompat r2 = ((RecyclerViewAccessibilityDelegate.ItemDelegate) ZeusTransformUtils.preCheckCast(r1, RecyclerViewAccessibilityDelegate.ItemDelegate.class, "com.obric.memorydata.plugin")).getAndRemoveOriginalDelegateForItem(r0);
        L8:
            ViewCompat.setAccessibilityDelegate(r0, r2);
            goto L9
        L7:
            r2 = null;
        L9:
            if (r7 == false) goto L11;
            d(r6);
        L11:
            r6.s = null;
            r6.r = null;
            i().a(r6);
        }

        boolean a(v r6) {
            if (r6.B() == false) goto L14;
            if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
            if (this.f.mState.a() == true) goto L12;
            throw new IllegalStateException("should not receive a removed view unless it is pre layout" + this.f.exceptionLabel());
        L12:
            return this.f.mState.a();
        L14:
            if (r6.e < 0) goto L30;
            if (r6.e >= this.f.mAdapter.d()) goto L30;
            if (this.f.mState.a() == true) goto L23;
            if (this.f.mAdapter.a(r6.e) == r6.s()) goto L23;
            return false;
        L23:
            if (this.f.mAdapter.f() == true) goto L25;
            return true;
        L25:
            if (r6.r() == this.f.mAdapter.c(r6.e)) goto L27;
            return false;
        L27:
            return true;
        L30:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r6 + this.f.exceptionLabel());
        }

        public int b(int r4) {
            if (r4 < 0) goto L11;
            if (r4 >= this.f.mState.e()) goto L11;
            if (this.f.mState.a() == true) goto L9;
            return r4;
        L9:
            return this.f.mAdapterHelper.b(r4);
        L11:
            throw new IndexOutOfBoundsException("invalid position " + r4 + ". State item count is " + this.f.mState.e() + this.f.exceptionLabel());
        }

        v b(int r7, boolean r8) {
            int r0 = this.f14087a.size();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L18;
            v r3 = (v) ZeusTransformUtils.preCheckCast(this.f14087a.get(r2), v.class, "com.obric.memorydata.plugin");
            if (r3.v() == true) goto L17;
            if (r3.m() != r7) goto L17;
            if (r3.y() == true) goto L17;
            if (this.f.mState.g == true) goto L15;
            if (r3.B() == true) goto L17;
        L15:
            r3.b(32);
            return r3;
        L17:
            r2 = r2 + 1;
            goto L4
        L18:
            if (r8 == true) goto L27;
            View r4 = this.f.mChildHelper.c(r7);
            if (r4 == null) goto L27;
            v r9 = RecyclerView.getChildViewHolderInt(r4);
            this.f.mChildHelper.e(r4);
            int r10 = this.f.mChildHelper.b(r4);
            if (r10 == (-1)) goto L26;
            this.f.mChildHelper.e(r10);
            c(r4);
            r9.b(8224);
            return r9;
        L26:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r9 + this.f.exceptionLabel());
        L27:
            int r5 = this.c.size();
        L28:
            if (r1 >= r5) goto L42;
            v r6 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r1), v.class, "com.obric.memorydata.plugin");
            if (r6.y() == true) goto L41;
            if (r6.m() != r7) goto L41;
            if (r6.D() == true) goto L41;
            if (r8 == true) goto L38;
            this.c.remove(r1);
        L38:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L40;
            Log.d(RecyclerView.TAG, "getScrapOrHiddenOrCachedHolderForPosition(" + r7 + ") found match in cache: " + r6);
        L40:
            return r6;
        L41:
            r1 = r1 + 1;
            goto L28
        L42:
            return null;
        }

        void b() {
            if (this.f.mLayout == null) goto L5;
            int r0 = this.f.mLayout.x;
        L6:
            this.d = this.h + r0;
            int r1 = this.c.size() - 1;
        L7:
            if (r1 < 0) goto L11;
            if (this.c.size() <= this.d) goto L14;
            d(r1);
            r1 = r1 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r0 = 0;
            goto L6
        }

        void b(int r7, int r8) {
            int r0 = this.c.size();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            v r3 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r2), v.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L12;
            if (r3.e < r7) goto L12;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForInsert cached " + r2 + " holder " + r3 + " now at position " + (r3.e + r8));
        L11:
            r3.a(r8, false);
        L12:
            r2 = r2 + 1;
            goto L3
        }

        void b(View r2) {
            v r3 = RecyclerView.getChildViewHolderInt(r2);
            r3.o = null;
            r3.p = false;
            r3.w();
            b(r3);
        }

        void b(v r8) {
            boolean r1 = false;
            boolean r2 = true;
            if (r8.t() == false) goto L5;
        L69:
            StringBuilder r3 = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(r8.t()).append(" isAttached:");
            if (r8.c.getParent() == null) goto L73;
            r1 = true;
        L73:
            throw new IllegalArgumentException(r3.append(r1).append(this.f.exceptionLabel()).toString());
        L5:
            if (r8.c.getParent() != null) goto L69;
            if (r8.C() == true) goto L68;
            if (r8.l() == true) goto L66;
            boolean r0 = r8.K();
            if (this.f.mAdapter == null) goto L17;
            if (r0 == false) goto L17;
            if (this.f.mAdapter.c(r8) == false) goto L17;
            boolean r4 = true;
        L19:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L21;
        L25:
            if (r4 == true) goto L34;
            if (r8.I() == true) goto L34;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L32;
            Log.d(RecyclerView.TAG, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + this.f.exceptionLabel());
        L32:
            r2 = false;
        L59:
            this.f.mViewInfoStore.g(r8);
            if (r1 == true) goto L76;
            if (r2 == true) goto L77;
            if (r0 == false) goto L78;
            PoolingContainer.callPoolingContainerOnRelease(r8.c);
            r8.s = null;
            r8.r = null;
            return;
        L78:
            return;
        L77:
            return;
        L76:
            return;
        L34:
            if (this.d > 0) goto L36;
        L54:
            boolean r5 = false;
        L55:
            if (r5 == true) goto L57;
            a(r8, true);
        L58:
            r1 = r5;
            goto L59
        L57:
            r2 = false;
            goto L58
        L36:
            if (r8.a(526) == true) goto L54;
            int r6 = this.c.size();
            if (r6 < this.d) goto L42;
            if (r6 <= 0) goto L42;
            d(0);
            r6 = r6 - 1;
        L42:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L53;
            if (r6 <= 0) goto L53;
            if (this.f.mPrefetchRegistry.a(r8.e) == true) goto L53;
            int r7 = r6 - 1;
        L47:
            if (r7 < 0) goto L52;
            if (this.f.mPrefetchRegistry.a(((v) ZeusTransformUtils.preCheckCast(this.c.get(r7), v.class, "com.obric.memorydata.plugin")).e) == false) goto L52;
            r7 = r7 - 1;
        L52:
            r6 = r7 + 1;
        L53:
            this.c.add(r6, r8);
            r5 = true;
            goto L55
        L21:
            if (this.c.contains(r8) == false) goto L25;
            throw new IllegalArgumentException("cached view received recycle internal? " + r8 + this.f.exceptionLabel());
        L17:
            r4 = false;
            goto L19
        L66:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f.exceptionLabel());
        L68:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r8 + this.f.exceptionLabel());
        }

        public View c(int r2) {
            return a(r2, false);
        }

        public List<v> c() {
            return this.g;
        }

        void c(int r5, int r6) {
            int r7 = r6 + r5;
            int r0 = this.c.size() - 1;
        L3:
            if (r0 < 0) goto L12;
            v r1 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r0), v.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L11;
            int r2 = r1.e;
            if (r2 < r5) goto L11;
            if (r2 >= r7) goto L11;
            r1.b(2);
            d(r0);
        L11:
            r0 = r0 - 1;
            goto L3
        }

        void c(View r3) {
            v r4 = RecyclerView.getChildViewHolderInt(r3);
            if (r4.a(12) == true) goto L14;
            if (r4.L() == false) goto L14;
            if (this.f.canReuseUpdatedViewHolder(r4) == true) goto L14;
            if (this.f14088b != null) goto L12;
            this.f14088b = new ArrayList();
        L12:
            r4.a(this, true);
            ArrayList<v> r2 = this.f14088b;
        L23:
            r2.add(r4);
            return;
        L14:
            if (r4.y() == true) goto L16;
        L22:
            r4.a(this, false);
            r2 = this.f14087a;
            goto L23
        L16:
            if (r4.B() == true) goto L22;
            if (this.f.mAdapter.f() == true) goto L22;
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.f.exceptionLabel());
        }

        void c(v r2) {
            if (r2.p == false) goto L5;
            ArrayList<v> r1 = this.f14088b;
        L6:
            r1.remove(r2);
            r2.o = null;
            r2.p = false;
            r2.w();
            return;
        L5:
            r1 = this.f14087a;
            goto L6
        }

        void d() {
            int r0 = this.c.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            d(r0);
            r0 = r0 - 1;
            goto L3
        L5:
            this.c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.f.mPrefetchRegistry.a();
            return;
        }

        void d(int r5) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L5;
            Log.d(RecyclerView.TAG, "Recycling cached view at index " + r5);
        L5:
            v r0 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r5), v.class, "com.obric.memorydata.plugin");
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L8;
            Log.d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + r0);
        L8:
            a(r0, true);
            this.c.remove(r5);
        }

        void d(v r6) {
            if (this.f.mRecyclerListener == null) goto L5;
            this.f.mRecyclerListener.a(r6);
        L5:
            int r0 = this.f.mRecyclerListeners.size();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L9;
            ((p) ZeusTransformUtils.preCheckCast(this.f.mRecyclerListeners.get(r1), p.class, "com.obric.memorydata.plugin")).a(r6);
            r1 = r1 + 1;
            goto L6
        L9:
            if (this.f.mAdapter == null) goto L12;
            this.f.mAdapter.b(r6);
        L12:
            if (this.f.mState == null) goto L15;
            this.f.mViewInfoStore.g(r6);
        L15:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L19;
            Log.d(RecyclerView.TAG, "dispatchViewRecycled: " + r6);
            return;
        }

        int e() {
            return this.f14087a.size();
        }

        View e(int r2) {
            return ((v) ZeusTransformUtils.preCheckCast(this.f14087a.get(r2), v.class, "com.obric.memorydata.plugin")).c;
        }

        v f(int r11) {
            ArrayList<v> r0 = this.f14088b;
            if (r0 == null) goto L32;
            int r1 = r0.size();
            if (r1 == 0) goto L32;
            int r2 = 0;
            int r3 = 0;
        L9:
            if (r3 >= r1) goto L18;
            v r5 = (v) ZeusTransformUtils.preCheckCast(this.f14088b.get(r3), v.class, "com.obric.memorydata.plugin");
            if (r5.v() == true) goto L16;
            if (r5.m() != r11) goto L16;
            r5.b(32);
            return r5;
        L16:
            r3 = r3 + 1;
            goto L9
        L18:
            if (this.f.mAdapter.f() == false) goto L32;
            int r12 = this.f.mAdapterHelper.b(r11);
            if (r12 <= 0) goto L32;
            if (r12 >= this.f.mAdapter.d()) goto L32;
            long r6 = this.f.mAdapter.c(r12);
        L24:
            if (r2 >= r1) goto L32;
            v r13 = (v) ZeusTransformUtils.preCheckCast(this.f14088b.get(r2), v.class, "com.obric.memorydata.plugin");
            if (r13.v() == true) goto L31;
            if (r13.r() != r6) goto L31;
            r13.b(32);
            return r13;
        L31:
            r2 = r2 + 1;
        L32:
            return null;
        }

        void f() {
            this.f14087a.clear();
            ArrayList<v> r1 = this.f14088b;
            if (r1 == null) goto L6;
            r1.clear();
            return;
        }

        void g() {
            m();
        }

        void h() {
            int r0 = 0;
        L4:
            if (r0 >= this.c.size()) goto L6;
            PoolingContainer.callPoolingContainerOnRelease(((v) ZeusTransformUtils.preCheckCast(this.c.get(r0), v.class, "com.obric.memorydata.plugin")).c);
            r0 = r0 + 1;
            goto L4
        L6:
            a(this.f.mAdapter);
        }

        n i() {
            if (this.e != null) goto L6;
            this.e = new n();
            m();
        L6:
            return this.e;
        }

        void j() {
            int r0 = this.c.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            v r2 = (v) ZeusTransformUtils.preCheckCast(this.c.get(r1), v.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r2.b(6);
            r2.a(null);
        L7:
            r1 = r1 + 1;
            goto L3
        L9:
            if (this.f.mAdapter != null) goto L11;
        L12:
            d();
            return;
        L11:
            if (this.f.mAdapter.f() == false) goto L12;
        }

        void k() {
            int r0 = this.c.size();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L6;
            ((v) ZeusTransformUtils.preCheckCast(this.c.get(r2), v.class, "com.obric.memorydata.plugin")).j();
            r2 = r2 + 1;
            goto L4
        L6:
            int r3 = this.f14087a.size();
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L9;
            ((v) ZeusTransformUtils.preCheckCast(this.f14087a.get(r4), v.class, "com.obric.memorydata.plugin")).j();
            r4 = r4 + 1;
            goto L7
        L9:
            ArrayList<v> r5 = this.f14088b;
            if (r5 == null) goto L14;
            int r6 = r5.size();
        L12:
            if (r1 >= r6) goto L18;
            ((v) ZeusTransformUtils.preCheckCast(this.f14088b.get(r1), v.class, "com.obric.memorydata.plugin")).j();
            r1 = r1 + 1;
            goto L12
        L18:
            return;
        }

        void l() {
            int r0 = this.c.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(((v) ZeusTransformUtils.preCheckCast(this.c.get(r1), v.class, "com.obric.memorydata.plugin")).c.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r2.e = true;
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    public interface p {
        void a(v r1);
    }

    private class q extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView f14089a;

        q(RecyclerView r1) {
            this.f14089a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void a() {
            this.f14089a.assertNotInLayoutOrScroll(null);
            this.f14089a.mState.f = true;
            this.f14089a.processDataSetCompletelyChanged(true);
            if (this.f14089a.mAdapterHelper.d() == true) goto L6;
            this.f14089a.requestLayout();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void a(int r3, int r4) {
            this.f14089a.assertNotInLayoutOrScroll(null);
            if (this.f14089a.mAdapterHelper.b(r3, r4) == false) goto L6;
            c();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void a(int r3, int r4, int r5) {
            this.f14089a.assertNotInLayoutOrScroll(null);
            if (this.f14089a.mAdapterHelper.a(r3, r4, r5) == false) goto L6;
            c();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void a(int r3, int r4, Object r5) {
            this.f14089a.assertNotInLayoutOrScroll(null);
            if (this.f14089a.mAdapterHelper.a(r3, r4, r5) == false) goto L6;
            c();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void b() {
            if (this.f14089a.mPendingSavedState != null) goto L5;
            return;
        L5:
            Adapter r0 = this.f14089a.mAdapter;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.j() == false) goto L12;
            this.f14089a.requestLayout();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public void b(int r3, int r4) {
            this.f14089a.assertNotInLayoutOrScroll(null);
            if (this.f14089a.mAdapterHelper.c(r3, r4) == false) goto L6;
            c();
            return;
        }

        void c() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == true) goto L5;
        L9:
            this.f14089a.mAdapterUpdateDuringMeasure = true;
            this.f14089a.requestLayout();
            return;
        L5:
            if (this.f14089a.mHasFixedSize == false) goto L9;
            if (this.f14089a.mIsAttached == false) goto L9;
            RecyclerView r2 = this.f14089a;
            ViewCompat.postOnAnimation(r2, r2.mUpdateChildViewsRunnable);
        }
    }

    public static abstract class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView f14091b;
        private h c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g;
        private boolean h;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f14092a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f14093b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            public a(int r3, int r4) {
                this(r3, r4, Integer.MIN_VALUE, null);
            }

            public a(int r3, int r4, int r5, Interpolator r6) {
                Interpolator r7 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r6, Interpolator.class, "com.obric.memorydata.plugin");
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.f14092a = r3;
                this.f14093b = r4;
                this.c = r5;
                this.e = r7;
            }

            private void b() {
                if (this.e == null) goto L10;
                if (this.c >= 1) goto L10;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            L10:
                if (this.c < 1) goto L13;
                return;
            L13:
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public void a(int r1) {
                this.d = r1;
            }

            void a(RecyclerView r6) {
                int r0 = this.d;
                if (r0 < 0) goto L7;
                this.d = -1;
                r6.jumpToPositionForSmoothScroller(r0);
                this.f = false;
                return;
            L7:
                if (this.f == false) goto L12;
                b();
                r6.mViewFlinger.a(this.f14092a, this.f14093b, this.c, this.e);
                int r7 = this.g + 1;
                this.g = r7;
                if (r7 <= 10) goto L11;
                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L11:
                this.f = false;
                return;
            L12:
                this.g = 0;
            }

            boolean a() {
                if (this.d < 0) goto L5;
                return true;
            L5:
                return false;
            }

            public void update(int r3, int r4, int r5, Interpolator r6) {
                Interpolator r7 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r6, Interpolator.class, "com.obric.memorydata.plugin");
                this.f14092a = r3;
                this.f14093b = r4;
                this.c = r5;
                this.e = r7;
                this.f = true;
            }
        }

        public interface b {
            PointF d(int r1);
        }

        public r() {
            this.f14090a = -1;
            this.g = new a(0, 0);
        }

        public int a(View r1) {
            return this.f14091b.getChildLayoutPosition(r1);
        }

        void a(int r6, int r7) {
            RecyclerView r0 = this.f14091b;
            if (this.f14090a == (-1)) goto L5;
            if (r0 == null) goto L5;
        L7:
            if (this.d == true) goto L9;
        L19:
            this.d = false;
            View r1 = this.f;
            if (r1 == null) goto L26;
            if (a(r1) != this.f14090a) goto L24;
            a(this.f, r0.mState, this.g);
            this.g.a(r0);
            f();
            goto L26
        L24:
            Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.f = null;
        L26:
            if (this.e == false) goto L33;
            a(r6, r7, r0.mState, this.g);
            boolean r8 = this.g.a();
            this.g.a(r0);
            if (r8 == true) goto L30;
            return;
        L30:
            if (this.e == false) goto L35;
            this.d = true;
            r0.mViewFlinger.a();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.f != null) goto L19;
            if (this.c == null) goto L19;
            PointF r2 = d(this.f14090a);
            if (r2 == null) goto L19;
            if (r2.x == 0.0f) goto L17;
        L18:
            r0.scrollStep((int) Math.signum(r2.x), (int) Math.signum(r2.y), null);
            goto L19
        L17:
            if (r2.y == 0.0f) goto L19;
        L5:
            f();
            goto L7
        }

        public abstract void a(int r1, int r2, s r3, a r4);

        public void a(PointF r3) {
            float r2 = (float) Math.sqrt((r3.x * r3.x) + (r3.y * r3.y));
            r3.x /= r2;
            r3.y /= r2;
        }

        public abstract void a(View r1, s r2, a r3);

        void a(RecyclerView r3, h r4) {
            r3.mViewFlinger.b();
            if (this.h == false) goto L5;
            Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L5:
            this.f14091b = r3;
            this.c = r4;
            if (this.f14090a == (-1)) goto L10;
            r3.mState.f14094a = this.f14090a;
            this.e = true;
            this.d = true;
            this.f = e(i());
            b();
            this.f14091b.mViewFlinger.a();
            this.h = true;
            return;
        L10:
            throw new IllegalArgumentException("Invalid target position");
        }

        public abstract void b();

        public void b(View r3) {
            if (a(r3) != i()) goto L8;
            this.f = r3;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L9;
            Log.d(RecyclerView.TAG, "smooth scroll target view has been attached");
            return;
        L9:
            return;
        }

        public abstract void c();

        public void c(int r1) {
            this.f14090a = r1;
        }

        public PointF d(int r3) {
            h r2 = e();
            if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L5;
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        L5:
            return ((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).d(r3);
        }

        public View e(int r1) {
            return this.f14091b.mLayout.c(r1);
        }

        public h e() {
            return this.c;
        }

        public final void f() {
            if (this.e == true) goto L5;
            return;
        L5:
            this.e = false;
            c();
            this.f14091b.mState.f14094a = -1;
            this.f = null;
            this.f14090a = -1;
            this.d = false;
            this.c.b(this);
            this.c = null;
            this.f14091b = null;
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.e;
        }

        public int i() {
            return this.f14090a;
        }

        public int j() {
            return this.f14091b.mLayout.x();
        }
    }

    public static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14095b;
        int c;
        int d;
        int e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        public s() {
            this.f14094a = -1;
            this.f14095b = 0;
            this.c = 0;
            this.d = 1;
            this.e = 0;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
        }

        void a(int r4) {
            if ((this.d & r4) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r4) + " but it is " + Integer.toBinaryString(this.d));
        }

        void a(Adapter r2) {
            this.d = 1;
            this.e = r2.d();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.f14094a;
        }

        public boolean d() {
            if (this.f14094a == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public int e() {
            if (this.g == false) goto L6;
            return this.f14095b - this.c;
        L6:
            return this.e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f14094a + ", mData=" + this.q + ", mItemCount=" + this.e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f14095b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    public static abstract class t {
        public abstract View a(o r1, int r2, int r3);
    }

    class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.obric.oui.orecyclerview.base.f f14096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f14097b;
        final /* synthetic */ RecyclerView c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;

        u(RecyclerView r4) {
            this.c = r4;
            this.f14097b = RecyclerView.sQuinticInterpolator;
            this.f = false;
            this.g = false;
            this.f14096a = new com.obric.oui.orecyclerview.base.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), RecyclerView.sQuinticInterpolator);
        }

        private int b(int r2, int r3) {
            int r4 = Math.abs(r2);
            int r5 = Math.abs(r3);
            if (r4 <= r5) goto L5;
            boolean r0 = true;
        L6:
            RecyclerView r1 = this.c;
            if (r0 == false) goto L9;
            int r6 = r1.getWidth();
        L10:
            if (r0 == true) goto L14;
            r4 = r5;
        L14:
            return Math.min((int) (((r4 / r6) + 1.0f) * 300.0f), 2000);
        L9:
            r6 = r1.getHeight();
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        private void c() {
            this.c.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.c, this);
        }

        void a() {
            if (this.f == false) goto L5;
            this.g = true;
            return;
        L5:
            c();
        }

        public void a(int r13, int r14) {
            this.c.setScrollState(2);
            this.e = 0;
            this.d = 0;
            if (this.f14097b == RecyclerView.sQuinticInterpolator) goto L5;
            this.f14097b = RecyclerView.sQuinticInterpolator;
            this.f14096a = new com.obric.oui.orecyclerview.base.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), RecyclerView.sQuinticInterpolator);
        L5:
            this.f14096a.a(0, 0, r13, r14, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int r9, int r10, int r11, Interpolator r12) {
            Interpolator r13 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r12, Interpolator.class, "com.obric.memorydata.plugin");
            if (r11 != Integer.MIN_VALUE) goto L5;
            r11 = b(r9, r10);
        L5:
            int r7 = r11;
            if (r13 != null) goto L9;
            r13 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.f14097b == r13) goto L11;
            this.f14097b = r13;
            this.f14096a = new com.obric.oui.orecyclerview.base.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13);
        L11:
            this.e = 0;
            this.d = 0;
            this.c.setScrollState(2);
            this.f14096a.a(0, 0, r9, r10, r7);
            if (Build.VERSION.SDK_INT >= 23) goto L14;
            this.f14096a.a();
        L14:
            a();
        }

        public void b() {
            this.c.removeCallbacks(this);
            this.f14096a.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.mLayout != null) goto L6;
            b();
            return;
        L6:
            this.g = false;
            this.f = true;
            this.c.consumePendingUpdateOperations();
            com.obric.oui.orecyclerview.base.f r3 = this.f14096a;
            if (r3.a() == false) goto L82;
            int r4 = r3.c();
            int r5 = r3.d();
            int r6 = r4 - this.d;
            int r7 = r5 - this.e;
            this.d = r4;
            this.e = r5;
            int r8 = this.c.consumeFlingInHorizontalStretch(r6);
            int r9 = this.c.consumeFlingInVerticalStretch(r7);
            this.c.mReusableIntPair[0] = 0;
            this.c.mReusableIntPair[1] = 0;
            RecyclerView r10 = this.c;
            if (r10.dispatchNestedPreScroll(r8, r9, r10.mReusableIntPair, null, 1) == false) goto L12;
            r8 = r8 - this.c.mReusableIntPair[0];
            r9 = r9 - this.c.mReusableIntPair[1];
        L12:
            if (this.c.mAdapter == null) goto L26;
            this.c.mReusableIntPair[0] = 0;
            this.c.mReusableIntPair[1] = 0;
            RecyclerView r11 = this.c;
            r11.scrollStep(r8, r9, r11.mReusableIntPair);
            int r12 = this.c.mReusableIntPair[0];
            int r13 = this.c.mReusableIntPair[1];
            r8 = r8 - r12;
            r9 = r9 - r13;
            r r14 = this.c.mLayout.t;
            if (r14 == null) goto L28;
            if (r14.g() == true) goto L28;
            if (r14.h() == false) goto L28;
            int r15 = this.c.mState.e();
            if (r15 != 0) goto L23;
            r14.f();
            goto L28
        L23:
            if (r14.i() < r15) goto L25;
            r14.c(r15 - 1);
        L25:
            r14.a(r12, r13);
        L28:
            if (this.c.mItemDecorations.isEmpty() == true) goto L30;
            this.c.invalidate();
        L30:
            this.c.mReusableIntPair[0] = 0;
            this.c.mReusableIntPair[1] = 0;
            RecyclerView r16 = this.c;
            r16.dispatchNestedScroll(r12, r13, r8, r9, null, 1, r16.mReusableIntPair);
            int r17 = r8 - this.c.mReusableIntPair[0];
            int r18 = r9 - this.c.mReusableIntPair[1];
            if (r12 != 0) goto L33;
            if (r13 != 0) goto L33;
        L35:
            if (RecyclerView.access$200(this.c) == true) goto L38;
            this.c.invalidate();
        L38:
            if (r3.c() != r3.f()) goto L40;
            boolean r19 = true;
        L42:
            if (r3.d() != r3.g()) goto L44;
            boolean r20 = true;
        L46:
            if (r3.h() == true) goto L53;
            if (r19 == true) goto L49;
            if (r17 != 0) goto L49;
        L52:
            boolean r21 = false;
        L54:
            r r22 = this.c.mLayout.t;
            if (r22 != null) goto L57;
        L59:
            boolean r23 = false;
        L60:
            if (r23 == true) goto L79;
            if (r21 == false) goto L79;
            if (this.c.getOverScrollMode() == 2) goto L77;
            int r24 = (int) r3.e();
            if (r17 >= 0) goto L67;
            int r25 = r24;
        L70:
            if (r18 < 0) goto L75;
            if (r18 <= 0) goto L74;
            r24 = -r24;
            goto L75
        L74:
            r24 = 0;
        L75:
            this.c.absorbGlows(r25, r24);
            goto L77
        L67:
            if (r17 <= 0) goto L69;
            r25 = -r24;
            goto L70
        L69:
            r25 = 0;
        L77:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L82;
            this.c.mPrefetchRegistry.a();
        L79:
            a();
            if (this.c.mGapWorker == null) goto L82;
            this.c.mGapWorker.a(this.c, r12, r13);
            goto L82
        L57:
            if (r22.g() == false) goto L59;
            r23 = true;
        L49:
            if (r20 == true) goto L53;
            if (r18 == 0) goto L52;
        L53:
            r21 = true;
            goto L54
        L44:
            r20 = false;
            goto L46
        L40:
            r19 = false;
        L33:
            this.c.dispatchOnScrolled(r12, r13);
            goto L35
        L26:
            r12 = 0;
            r13 = 0;
        L82:
            r r26 = this.c.mLayout.t;
            if (r26 != null) goto L85;
        L87:
            this.f = false;
            if (this.g == false) goto L90;
            c();
            return;
        L90:
            this.c.setScrollState(0);
            this.c.stopNestedScroll(1);
            return;
        L85:
            if (r26.g() == false) goto L87;
            r26.a(0, 0);
            goto L87
        }
    }

    public static abstract class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final List<Object> f14098a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14099b;
        public final View c;
        WeakReference<RecyclerView> d;
        int e;
        int f;
        long g;
        int h;
        int i;
        v j;
        v k;
        int l;
        List<Object> m;
        List<Object> n;
        o o;
        boolean p;
        int q;
        RecyclerView r;
        Adapter<? extends v> s;
        private int t;

        static {
            f14098a = Collections.emptyList();
        }

        public v(View r4) {
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = null;
            this.k = null;
            this.m = null;
            this.n = null;
            this.f14099b = 0;
            this.o = null;
            this.p = false;
            this.t = 0;
            this.q = -1;
            if (r4 == null) goto L7;
            this.c = r4;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void a() {
            if (this.m != null) goto L6;
            ArrayList r0 = new ArrayList();
            this.m = r0;
            this.n = Collections.unmodifiableList(r0);
            return;
        }

        boolean A() {
            if ((this.l & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean B() {
            if ((this.l & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean C() {
            if ((this.l & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean D() {
            if (this.c.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.c.getParent() == this.r) goto L7;
            return true;
        }

        boolean E() {
            if ((this.l & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (y() == true) goto L8;
            return false;
        }

        void F() {
            List<Object> r0 = this.m;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            this.l &= -1025;
        }

        List<Object> G() {
            if ((this.l & 1024) != 0) goto L14;
            List<Object> r0 = this.m;
            if (r0 == null) goto L12;
            if (r0.size() == 0) goto L12;
            return this.n;
        L12:
            return f14098a;
        L14:
            return f14098a;
        }

        void H() {
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L5;
        L9:
            this.l = 0;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.i = -1;
            this.f14099b = 0;
            this.j = null;
            this.k = null;
            F();
            this.t = 0;
            this.q = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
            return;
        L5:
            if (C() == false) goto L9;
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public final boolean I() {
            if ((this.l & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.c) == true) goto L7;
            return true;
        }

        boolean J() {
            if ((this.l & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean K() {
            if ((this.l & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.c) == false) goto L7;
            return true;
        }

        boolean L() {
            if ((this.l & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void a(int r2, int r3, boolean r4) {
            b(8);
            a(r3, r4);
            this.e = r2;
        }

        void a(int r3, boolean r4) {
            if (this.f != (-1)) goto L6;
            this.f = this.e;
        L6:
            if (this.i != (-1)) goto L8;
            this.i = this.e;
        L8:
            if (r4 == false) goto L10;
            this.i += r3;
        L10:
            this.e += r3;
            if (this.c.getLayoutParams() == null) goto L14;
            ((LayoutParams) ZeusTransformUtils.preCheckCast(this.c.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).e = true;
            return;
        }

        void a(o r1, boolean r2) {
            this.o = r1;
            this.p = r2;
        }

        void a(RecyclerView r3) {
            int r0 = this.q;
            if (r0 != (-1)) goto L6;
            r0 = ViewCompat.getImportantForAccessibility(this.c);
        L6:
            this.t = r0;
            r3.setChildImportantForAccessibilityInternal(this, 4);
        }

        void a(Object r3) {
            if (r3 != null) goto L6;
            b(1024);
            return;
        L6:
            if ((1024 & this.l) != 0) goto L10;
            a();
            this.m.add(r3);
            return;
        }

        boolean a(int r1) {
            if ((this.l & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void b(int r2) {
            this.l = r2 | this.l;
        }

        void b(int r3, int r4) {
            int r5 = r3 & r4;
            this.l = r5 | (this.l & (~r4));
        }

        void b(RecyclerView r2) {
            r2.setChildImportantForAccessibilityInternal(this, this.t);
            this.t = 0;
        }

        public final void b(boolean r3) {
            int r1 = this.f14099b;
            if (r3 == false) goto L5;
            int r2 = r1 - 1;
        L6:
            this.f14099b = r2;
            if (r2 >= 0) goto L13;
            this.f14099b = 0;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L12;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L21:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L24;
            Log.d(RecyclerView.TAG, "setIsRecyclable val:" + r3 + ParameterizedMessage.ERROR_MSG_SEPARATOR + this);
            return;
        L24:
            return;
        L12:
            throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L13:
            if (r3 == true) goto L17;
            if (r2 != 1) goto L17;
            int r0 = this.l | 16;
        L16:
            this.l = r0;
        L17:
            if (r3 == false) goto L21;
            if (r2 != 0) goto L21;
            r0 = this.l & (-17);
            goto L16
        L5:
            r2 = r1 + 1;
            goto L6
        }

        void j() {
            this.f = -1;
            this.i = -1;
        }

        void k() {
            if (this.f != (-1)) goto L6;
            this.f = this.e;
            return;
        }

        boolean l() {
            if ((this.l & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final int m() {
            int r0 = this.i;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            return this.e;
        }

        @Deprecated
        public final int n() {
            return o();
        }

        public final int o() {
            if (this.s != null) goto L5;
            return -1;
        L5:
            RecyclerView r0 = this.r;
            if (r0 != null) goto L8;
            return -1;
        L8:
            Adapter r1 = r0.getAdapter();
            if (r1 != null) goto L11;
            return -1;
        L11:
            int r2 = this.r.getAdapterPositionInRecyclerView(this);
            if (r2 != (-1)) goto L15;
            return -1;
        L15:
            return r1.a(this.s, this, r2);
        }

        public final int p() {
            RecyclerView r0 = this.r;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.getAdapterPositionInRecyclerView(this);
        }

        public final int q() {
            return this.f;
        }

        public final long r() {
            return this.g;
        }

        public final int s() {
            return this.h;
        }

        boolean t() {
            if (this.o == null) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r0 = "ViewHolder";
        L6:
            StringBuilder r1 = new StringBuilder(r0 + "{" + Integer.toHexString(hashCode()) + " position=" + this.e + " id=" + this.g + ", oldPos=" + this.f + ", pLpos:" + this.i);
            if (t() == false) goto L14;
            StringBuilder r2 = r1.append(" scrap ");
            if (this.p == false) goto L11;
            String r3 = "[changeScrap]";
        L12:
            r2.append(r3);
            goto L14
        L11:
            r3 = "[attachedScrap]";
        L14:
            if (y() == false) goto L17;
            r1.append(" invalid");
        L17:
            if (A() == true) goto L20;
            r1.append(" unbound");
        L20:
            if (z() == false) goto L23;
            r1.append(" update");
        L23:
            if (B() == false) goto L26;
            r1.append(" removed");
        L26:
            if (l() == false) goto L29;
            r1.append(" ignored");
        L29:
            if (C() == false) goto L32;
            r1.append(" tmpDetached");
        L32:
            if (I() == true) goto L35;
            r1.append(" not recyclable(" + this.f14099b + ")");
        L35:
            if (E() == false) goto L38;
            r1.append(" undefined adapter position");
        L38:
            if (this.c.getParent() != null) goto L40;
            r1.append(" no parent");
        L40:
            r1.append("}");
            return r1.toString();
        L5:
            r0 = getClass().getSimpleName();
            goto L6
        }

        void u() {
            this.o.c(this);
        }

        boolean v() {
            if ((this.l & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void w() {
            this.l &= -33;
        }

        void x() {
            this.l &= -257;
        }

        boolean y() {
            if ((this.l & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean z() {
            if ((this.l & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{R.attr.nestedScrollingEnabled};
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        if (Build.VERSION.SDK_INT != 18) goto L5;
    L10:
        boolean r1 = true;
    L11:
        FORCE_INVALIDATE_DISPLAY_LIST = r1;
        if (Build.VERSION.SDK_INT < 23) goto L14;
        boolean r2 = true;
    L15:
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r2;
        if (Build.VERSION.SDK_INT < 16) goto L18;
        boolean r3 = true;
    L19:
        POST_UPDATES_ON_ANIMATION = r3;
        if (Build.VERSION.SDK_INT < 21) goto L22;
        boolean r4 = true;
    L23:
        ALLOW_THREAD_GAP_WORK = r4;
        if (Build.VERSION.SDK_INT > 15) goto L26;
        boolean r5 = true;
    L27:
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = r5;
        if (Build.VERSION.SDK_INT > 15) goto L30;
        boolean r6 = true;
    L31:
        IGNORE_DETACHED_FOCUSED_CHILD = r6;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new AnonymousClass3();
        return;
    L30:
        r6 = false;
        goto L31
    L26:
        r5 = false;
        goto L27
    L22:
        r4 = false;
        goto L23
    L18:
        r3 = false;
        goto L19
    L14:
        r2 = false;
        goto L15
    L5:
        if (Build.VERSION.SDK_INT == 19) goto L10;
        if (Build.VERSION.SDK_INT == 20) goto L10;
        r1 = false;
        goto L11
    }

    public RecyclerView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public RecyclerView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.recyclerViewStyle, "attr", "recyclerViewStyle"));
    }

    public RecyclerView(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r16, r17, r15);
        this.mObserver = new q(this);
        this.mRecycler = new o(this);
        this.mViewInfoStore = new ad();
        this.mUpdateChildViewsRunnable = new AnonymousClass1(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mLastDispatchedBounceTranslation = 0.0f;
        this.mItemAnimator = new com.obric.oui.orecyclerview.widget.h();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new u(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        com.obric.oui.orecyclerview.widget.k.a r2 = new com.obric.oui.orecyclerview.widget.k.a();
    L6:
        this.mPrefetchRegistry = r2;
        this.mState = new s();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new f(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mEnableOverFling = true;
        this.mAvoidStateChangeInAnim = true;
        this.mItemAnimatorRunner = new AnonymousClass2(this);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new AnonymousClass4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r3 = ViewConfiguration.get(r16);
        this.mTouchSlop = r3.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r3, r16);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(r3, r16);
        this.mMinFlingVelocity = r3.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r3.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = ((ZeusTransformUtils.getResources(r16, "com.obric.memorydata.plugin").getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        if (getOverScrollMode() != 2) goto L9;
        boolean r4 = true;
    L10:
        setWillNotDraw(r4);
        this.mItemAnimator.a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.memorydata.plugin");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray r11 = r16.obtainStyledAttributes(r17, com.obric.memorydata.plugin.R.styleable.RecyclerView, r15, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r16, com.obric.memorydata.plugin.R.styleable.RecyclerView, r17, r11, r15, 0);
        String r5 = r11.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_layoutManager, "styleable", "RecyclerView_layoutManager"));
        if (r11.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_android_descendantFocusability, "styleable", "RecyclerView_android_descendantFocusability"), -1) != (-1)) goto L16;
        setDescendantFocusability(262144);
    L16:
        this.mClipToPadding = r11.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_android_clipToPadding, "styleable", "RecyclerView_android_clipToPadding"), true);
        boolean r6 = r11.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_fastScrollEnabled, "styleable", "RecyclerView_fastScrollEnabled"), false);
        this.mEnableFastScroller = r6;
        if (r6 == false) goto L19;
        initFastScroller((StateListDrawable) ZeusTransformUtils.preCheckCast(r11.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable, "styleable", "RecyclerView_fastScrollVerticalThumbDrawable")), StateListDrawable.class, "com.obric.memorydata.plugin"), r11.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable, "styleable", "RecyclerView_fastScrollVerticalTrackDrawable")), (StateListDrawable) ZeusTransformUtils.preCheckCast(r11.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable, "styleable", "RecyclerView_fastScrollHorizontalThumbDrawable")), StateListDrawable.class, "com.obric.memorydata.plugin"), r11.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable, "styleable", "RecyclerView_fastScrollHorizontalTrackDrawable")));
    L19:
        r11.recycle();
        createLayoutManager(r16, r5, r17, r15, 0);
        if (Build.VERSION.SDK_INT < 21) goto L22;
        int[] r7 = NESTED_SCROLLING_ATTRS;
        TypedArray r1 = r16.obtainStyledAttributes(r17, r7, r15, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r16, r7, r17, r1, r15, 0);
        boolean r18 = r1.getBoolean(0, true);
        r1.recycle();
    L23:
        setNestedScrollingEnabled(r18);
        PoolingContainer.setPoolingContainer(this, true);
        this.mRecyclerViewExt = new x(this);
        return;
    L22:
        r18 = true;
        goto L23
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    static /* synthetic */ void access$000(RecyclerView r0, View r1, int r2, ViewGroup.LayoutParams r3) {
        r0.attachViewToParent(r1, r2, r3);
    }

    static /* synthetic */ void access$100(RecyclerView r0, int r1) {
        r0.detachViewFromParent(r1);
    }

    static /* synthetic */ boolean access$200(RecyclerView r0) {
        return r0.awakenScrollBars();
    }

    static /* synthetic */ void access$300(RecyclerView r0, View r1, int r2, ViewGroup.LayoutParams r3) {
        r0.attachViewToParent(r1, r2, r3);
    }

    static /* synthetic */ void access$400(RecyclerView r0, View r1) {
        r0.detachViewFromParent(r1);
    }

    static /* synthetic */ void access$500(RecyclerView r0, int r1, int r2) {
        r0.setMeasuredDimension(r1, r2);
    }

    private void addAnimatingView(v r6) {
        View r0 = r6.c;
        if (r0.getParent() != this) goto L5;
        boolean r1 = true;
    L6:
        this.mRecycler.c(getChildViewHolder(r0));
        boolean r7 = r6.C();
        com.obric.oui.orecyclerview.widget.f r5 = this.mChildHelper;
        if (r7 == false) goto L9;
        r5.a(r0, -1, r0.getLayoutParams(), true);
        return;
    L9:
        if (r1 == true) goto L11;
        r5.a(r0, true);
        return;
    L11:
        r5.d(r0);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void animateChange(v r2, v r3, e.c r4, e.c r5, boolean r6, boolean r7) {
        r2.b(false);
        if (r6 == false) goto L5;
        addAnimatingView(r2);
    L5:
        if (r2 == r3) goto L10;
        if (r7 == false) goto L8;
        addAnimatingView(r3);
    L8:
        r2.j = r3;
        addAnimatingView(r2);
        this.mRecycler.c(r2);
        r3.b(false);
        r3.k = r2;
    L10:
        if (this.mItemAnimator.a(r2, r3, r4, r5) == false) goto L13;
        postAnimationRunner();
        return;
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(v r4) {
        if (r4.d == null) goto L20;
        ViewParent r0 = r4.d.get();
        Class<View> r1 = View.class;
    L5:
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0, r1, "com.obric.memorydata.plugin");
    L7:
        if (r2 == null) goto L15;
        if (r2 == r4.c) goto L10;
        r0 = r2.getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == true) goto L13;
        r2 = null;
        goto L7
    L13:
        r1 = View.class;
        goto L5
    L10:
        return;
    L15:
        r4.d = null;
        return;
    }

    private int consumeFlingInStretch(int r3, com.obric.oui.orecyclerview.base.a r4) {
        if (r3 == 0) goto L11;
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (r4.b() == 0.0f) goto L13;
        int r2 = (int) r4.a(r3, true, this.mAvoidStateChangeInAnim);
        if (r3 <= 0) goto L10;
        return r3 - r2;
    L10:
        return r3 + r2;
    L13:
        return r3;
    L11:
        return r3;
    }

    private void createLayoutManager(Context r9, String r10, AttributeSet r11, int r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L36;
        String r16 = r10.trim();
        if (r16.isEmpty() == true) goto L42;
        String r17 = getFullClassName(r14, r16);
    L21:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Class is not a LayoutManager " + r17, e);
    L33:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Unable to find LayoutManager " + r17, e);
    L24:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Cannot access non-public constructor " + r17, e);
    L27:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r17, e);
    L30:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r17, e);
    L8:
        if (isInEditMode() == false) goto L10;
        ClassLoader r1 = getClass().getClassLoader();     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L11:
        Class<? extends U> r2 = Class.forName(r17, false, r1).asSubclass(h.class);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        Object[] r4 = null;
        Constructor r6 = r2.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: NoSuchMethodException -> L15 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        r4 = new Object[]{r14, r15, Integer.valueOf(r12), Integer.valueOf(r13)};     // Catch: NoSuchMethodException -> L15 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L17:
        r6.setAccessible(true);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        setLayoutManager((h) ZeusTransformUtils.preCheckCast(r6.newInstance(r4), h.class, "com.obric.memorydata.plugin"));     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        return;
    L15:
        e = move-exception;
        r6 = r2.getConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L18 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L18:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        throw new IllegalStateException(r15.getPositionDescription() + ": Error creating LayoutManager " + r17, e);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L10:
        r1 = r14.getClassLoader();     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        goto L11
    L42:
        return;
    }

    private boolean didChildRangeChange(int r4, int r5) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r3 = this.mMinMaxLayoutPositions;
        if (r3[0] != r4) goto L7;
        if (r3[1] != r5) goto L7;
        return false;
    L7:
        return true;
    }

    private void dispatchBounceTranslationChanged() {
        float r0 = getBounceTranslation();
        i r1 = this.mOnBounceTranslationListener;
        if (r1 != null) goto L5;
    L7:
        this.mLastDispatchedBounceTranslation = r0;
        return;
    L5:
        if (r0 == this.mLastDispatchedBounceTranslation) goto L7;
        r1.onTranslationChanged(r0);
        goto L7
    }

    private void dispatchContentChangedIfNecessary() {
        int r0 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r1 = AccessibilityEvent.obtain();
        r1.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(r1, r0);
        sendAccessibilityEventUnchecked(r1);
        return;
    }

    private void dispatchLayoutStep1() {
        boolean r1 = true;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        s r0 = this.mState;
        if (r0.j == true) goto L5;
    L7:
        r1 = false;
    L8:
        r0.h = r1;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        s r2 = this.mState;
        r2.g = r2.k;
        this.mState.e = this.mAdapter.d();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j == false) goto L32;
        int r3 = this.mChildHelper.b();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L32;
        v r5 = getChildViewHolderInt(this.mChildHelper.b(r4));
        if (r5.l() == true) goto L30;
        if (r5.y() == true) goto L17;
    L19:
        this.mViewInfoStore.a(r5, this.mItemAnimator.a(this.mState, r5, e.e(r5), r5.G()));
        if (this.mState.h == false) goto L30;
        if (r5.L() == false) goto L30;
        if (r5.B() == true) goto L30;
        if (r5.l() == true) goto L30;
        if (r5.y() == true) goto L30;
        this.mViewInfoStore.a(getChangedHolderKey(r5), r5);
        goto L30
    L17:
        if (this.mAdapter.f() == true) goto L19;
    L30:
        r4 = r4 + 1;
    L32:
        if (this.mState.k == false) goto L49;
        saveOldPositions();
        boolean r6 = this.mState.f;
        this.mState.f = false;
        this.mLayout.c(this.mRecycler, this.mState);
        this.mState.f = r6;
        int r7 = 0;
    L35:
        if (r7 >= this.mChildHelper.b()) goto L49;
        v r8 = getChildViewHolderInt(this.mChildHelper.b(r7));
        if (r8.l() == true) goto L48;
        if (this.mViewInfoStore.d(r8) == true) goto L48;
        int r9 = e.e(r8);
        boolean r10 = r8.a(8192);
        if (r10 == true) goto L44;
        r9 = r9 | 4096;
    L44:
        e.c r11 = this.mItemAnimator.a(this.mState, r8, r9, r8.G());
        if (r10 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r8, r11);
        goto L48
    L47:
        this.mViewInfoStore.b(r8, r11);
    L48:
        r7 = r7 + 1;
    L49:
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.d = 2;
        return;
    L5:
        if (this.mItemsChanged == false) goto L7;
        goto L7
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.e();
        this.mState.e = this.mAdapter.d();
        this.mState.c = 0;
        if (this.mPendingSavedState != null) goto L5;
    L10:
        this.mState.g = false;
        this.mLayout.c(this.mRecycler, this.mState);
        this.mState.f = false;
        s r0 = this.mState;
        if (r0.j == true) goto L13;
    L15:
        boolean r2 = false;
    L16:
        r0.j = r2;
        this.mState.d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L13:
        if (this.mItemAnimator == null) goto L15;
        r2 = true;
        goto L16
    L5:
        if (this.mAdapter.j() == false) goto L10;
        if (this.mPendingSavedState.mLayoutState == null) goto L9;
        this.mLayout.a(this.mPendingSavedState.mLayoutState);
    L9:
        this.mPendingSavedState = null;
        goto L10
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.d = 1;
        if (this.mState.j == false) goto L24;
        int r0 = this.mChildHelper.b() - 1;
    L5:
        if (r0 < 0) goto L23;
        v r5 = getChildViewHolderInt(this.mChildHelper.b(r0));
        if (r5.l() == true) goto L22;
        long r2 = getChangedHolderKey(r5);
        e.c r4 = this.mItemAnimator.a(this.mState, r5);
        v r6 = this.mViewInfoStore.a(r2);
        if (r6 != null) goto L12;
    L21:
        this.mViewInfoStore.c(r5, r4);
        goto L22
    L12:
        if (r6.l() == true) goto L21;
        boolean r8 = this.mViewInfoStore.a(r6);
        boolean r9 = this.mViewInfoStore.a(r5);
        if (r8 == false) goto L17;
        if (r6 == r5) goto L21;
    L17:
        e.c r7 = this.mViewInfoStore.b(r6);
        this.mViewInfoStore.c(r5, r4);
        e.c r10 = this.mViewInfoStore.c(r5);
        if (r7 != null) goto L20;
        handleMissingPreInfoForChangeError(r2, r5, r6);
        goto L22
    L20:
        animateChange(r6, r5, r7, r10, r8, r9);
    L22:
        r0 = r0 - 1;
        goto L5
    L23:
        this.mViewInfoStore.a(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.b(this.mRecycler);
        s r1 = this.mState;
        r1.f14095b = r1.e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.j = false;
        this.mState.k = false;
        this.mLayout.u = false;
        if (this.mRecycler.f14088b == null) goto L28;
        this.mRecycler.f14088b.clear();
    L28:
        if (this.mLayout.y == false) goto L30;
        this.mLayout.x = 0;
        this.mLayout.y = false;
        this.mRecycler.b();
    L30:
        this.mLayout.a(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a();
        int[] r3 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r3[0], r3[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r3) {
        l r0 = this.mInterceptingOnItemTouchListener;
        if (r0 == null) goto L5;
        r0.b(this, r3);
        int r4 = r3.getAction();
        if (r4 == 3) goto L13;
        if (r4 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r3.getAction() != 0) goto L9;
        return false;
    L9:
        return findInterceptingOnItemTouchListener(r3);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent r8) {
        int r0 = r8.getAction();
        int r1 = this.mOnItemTouchListeners.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        l r4 = (l) ZeusTransformUtils.preCheckCast(this.mOnItemTouchListeners.get(r3), l.class, "com.obric.memorydata.plugin");
        if (r4.a(this, r8) == false) goto L10;
        if (r0 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r4;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] r9) {
        int r0 = this.mChildHelper.b();
        if (r0 != 0) goto L6;
        r9[0] = -1;
        r9[1] = -1;
        return;
    L6:
        int r3 = Integer.MAX_VALUE;
        int r4 = Integer.MIN_VALUE;
        int r5 = 0;
    L7:
        if (r5 >= r0) goto L17;
        v r6 = getChildViewHolderInt(this.mChildHelper.b(r5));
        if (r6.l() == true) goto L16;
        int r7 = r6.m();
        if (r7 >= r3) goto L14;
        r3 = r7;
    L14:
        if (r7 <= r4) goto L16;
        r4 = r7;
    L16:
        r5 = r5 + 1;
        goto L7
    L17:
        r9[0] = r3;
        r9[1] = r4;
    }

    static RecyclerView findNestedRecyclerView(View r4) {
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == true) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.class) == true) goto L8;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        int r0 = r5.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L15;
        RecyclerView r3 = findNestedRecyclerView(r5.getChildAt(r1));
        if (r3 != null) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        return r3;
    L15:
        return null;
    L8:
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r4, RecyclerView.class, "com.obric.memorydata.plugin");
    }

    private View findNextViewToFocus() {
        if (this.mState.l == (-1)) goto L5;
        int r0 = this.mState.l;
    L6:
        int r1 = this.mState.e();
        int r2 = r0;
    L7:
        if (r2 >= r1) goto L16;
        v r3 = findViewHolderForAdapterPosition(r2);
        if (r3 == null) goto L16;
        if (r3.c.hasFocusable() == true) goto L14;
        r2 = r2 + 1;
        goto L7
    L14:
        return r3.c;
    L16:
        int r4 = Math.min(r1, r0);
    L17:
        r4 = r4 - 1;
        if (r4 < 0) goto L27;
        v r5 = findViewHolderForAdapterPosition(r4);
        if (r5 == null) goto L21;
        if (r5.c.hasFocusable() == false) goto L17;
        return r5.c;
    L21:
        return null;
    L27:
        return null;
    L5:
        r0 = 0;
        goto L6
    }

    static v getChildViewHolderInt(View r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).c;
    }

    static void getDecoratedBoundsWithMarginsInt(View r6, Rect r7) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        Rect r1 = r0.d;
        r7.set((r6.getLeft() - r1.left) - r0.leftMargin, (r6.getTop() - r1.top) - r0.topMargin, (r6.getRight() + r1.right) + r0.rightMargin, (r6.getBottom() + r1.bottom) + r0.bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View r3) {
    L2:
        int r2 = r3.getId();
    L4:
        if (r3.isFocused() == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L12;
        if (r3.hasFocus() == false) goto L12;
        r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).getFocusedChild();
        if (r3.getId() == (-1)) goto L4;
    L12:
        return r2;
    }

    private String getFullClassName(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3.charAt(0) != '.') goto L8;
        StringBuilder r4 = new StringBuilder().append(r1.getPackageName());
    L6:
        return r4.append(r3).toString();
    L8:
        if (r3.contains(".") == false) goto L10;
        return r3;
    L10:
        r4 = new StringBuilder().append(RecyclerView.class.getPackage().getName()).append('.');
        goto L6
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    L6:
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int r9) {
        double r2 = Math.log((Math.abs(r9) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        float r10 = DECELERATION_RATE;
        return (float) ((this.mPhysicalCoef * SCROLL_FRICTION) * Math.exp((r10 / (((double) r10) - 1.0d)) * r2));
    }

    private void handleMissingPreInfoForChangeError(long r6, v r8, v r9) {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L18;
        v r2 = getChildViewHolderInt(this.mChildHelper.b(r1));
        if (r2 == r8) goto L17;
        if (getChangedHolderKey(r2) != r6) goto L17;
        Adapter r7 = this.mAdapter;
        if (r7 == null) goto L16;
        if (r7.f() == false) goto L16;
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + r2 + " \n View Holder 2:" + r8 + exceptionLabel());
    L16:
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r2 + " \n View Holder 2:" + r8 + exceptionLabel());
    L17:
        r1 = r1 + 1;
        goto L3
    L18:
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r9 + " cannot be found but it is necessary for " + r8 + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int r0 = this.mChildHelper.b();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        v r3 = getChildViewHolderInt(this.mChildHelper.b(r2));
        if (r3 == null) goto L13;
        if (r3.l() == true) goto L13;
        if (r3.L() == false) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return false;
    }

    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) != 0) goto L6;
        ViewCompat.setImportantForAutofill(this, 8);
        return;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new com.obric.oui.orecyclerview.widget.f(new AnonymousClass5(this));
    }

    private boolean isPreferredNextFocus(View r6, View r7, int r8) {
        if (r7 == null) goto L93;
        if (r7 == this) goto L94;
        if (r7 != r6) goto L8;
        return false;
    L8:
        if (findContainingItemView(r7) != null) goto L11;
        return false;
    L11:
        if (r6 != null) goto L14;
        return true;
    L14:
        if (findContainingItemView(r6) != null) goto L16;
        return true;
    L16:
        this.mTempRect.set(0, 0, r6.getWidth(), r6.getHeight());
        this.mTempRect2.set(0, 0, r7.getWidth(), r7.getHeight());
        offsetDescendantRectToMyCoords(r6, this.mTempRect);
        offsetDescendantRectToMyCoords(r7, this.mTempRect2);
        byte r9 = -1;
        if (this.mLayout.v() != 1) goto L19;
        int r10 = -1;
    L21:
        if (this.mTempRect.left < this.mTempRect2.left) goto L25;
        if (this.mTempRect.right <= this.mTempRect2.left) goto L25;
    L28:
        if (this.mTempRect.right > this.mTempRect2.right) goto L32;
        if (this.mTempRect.left >= this.mTempRect2.right) goto L32;
    L34:
        int r2 = 0;
    L36:
        if (this.mTempRect.top < this.mTempRect2.top) goto L40;
        if (this.mTempRect.bottom <= this.mTempRect2.top) goto L40;
    L43:
        if (this.mTempRect.bottom > this.mTempRect2.bottom) goto L47;
        if (this.mTempRect.top >= this.mTempRect2.bottom) goto L47;
    L49:
        r9 = 0;
    L50:
        if (r8 != 1) goto L52;
        if (r9 < 0) goto L86;
        if (r9 == 0) goto L84;
        return false;
    L84:
        if ((r2 * r10) < 0) goto L86;
        return false;
    L86:
        return true;
    L52:
        if (r8 != 2) goto L54;
        if (r9 > 0) goto L80;
        if (r9 == 0) goto L78;
        return false;
    L78:
        if ((r2 * r10) > 0) goto L80;
        return false;
    L80:
        return true;
    L54:
        if (r8 != 17) goto L56;
        if (r2 < 0) goto L74;
        return false;
    L74:
        return true;
    L56:
        if (r8 != 33) goto L58;
        if (r9 < 0) goto L71;
        return false;
    L71:
        return true;
    L58:
        if (r8 != 66) goto L60;
        if (r2 > 0) goto L68;
        return false;
    L68:
        return true;
    L60:
        if (r8 != 130) goto L65;
        if (r9 > 0) goto L63;
        return false;
    L63:
        return true;
    L65:
        throw new IllegalArgumentException("Invalid direction: " + r8 + exceptionLabel());
    L47:
        if (this.mTempRect.top <= this.mTempRect2.top) goto L49;
    L40:
        if (this.mTempRect.bottom >= this.mTempRect2.bottom) goto L43;
        r9 = 1;
    L32:
        if (this.mTempRect.left <= this.mTempRect2.left) goto L34;
        r2 = -1;
    L25:
        if (this.mTempRect.right >= this.mTempRect2.right) goto L28;
        r2 = 1;
        goto L36
    L19:
        r10 = 1;
        goto L21
    L94:
        return false;
    L93:
        return false;
    }

    private void nestedScrollByInternal(int r12, int r13, MotionEvent r14, int r15) {
        h r0 = this.mLayout;
        if (r0 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int[] r1 = this.mReusableIntPair;
        int r2 = 0;
        r1[0] = 0;
        r1[1] = 0;
        boolean r3 = r0.e();
        boolean r4 = this.mLayout.f();
        if (r3 == false) goto L12;
        int r5 = 1;
    L13:
        if (r4 == false) goto L16;
        r5 = r5 | 2;
    L16:
        if (r14 != null) goto L18;
        float r6 = getHeight() / 2.0f;
    L19:
        if (r14 != null) goto L21;
        float r7 = getWidth() / 2.0f;
    L22:
        int r16 = r12 - releaseHorizontalGlow(r12, r6);
        int r17 = r13 - releaseVerticalGlow(r13, r7);
        startNestedScroll(r5, r15);
        if (r3 == false) goto L25;
        int r8 = r16;
    L26:
        if (r4 == false) goto L28;
        int r9 = r17;
    L30:
        if (dispatchNestedPreScroll(r8, r9, this.mReusableIntPair, this.mScrollOffset, r15) == false) goto L32;
        int[] r10 = this.mReusableIntPair;
        r16 = r16 - r10[0];
        r17 = r17 - r10[1];
    L32:
        if (r3 == false) goto L34;
        int r11 = r16;
    L35:
        if (r4 == false) goto L37;
        r2 = r17;
    L37:
        scrollByInternal(r11, r2, r14, r15);
        com.obric.oui.orecyclerview.widget.k r18 = this.mGapWorker;
        if (r18 == null) goto L42;
        if (r16 != 0) goto L41;
        if (r17 == 0) goto L42;
    L41:
        r18.a(this, r16, r17);
    L42:
        stopNestedScroll(r15);
        return;
    L34:
        r11 = 0;
        goto L35
    L28:
        r9 = 0;
        goto L30
    L25:
        r8 = 0;
        goto L26
    L21:
        r7 = r14.getX();
        goto L22
    L18:
        r6 = r14.getY();
        goto L19
    L12:
        r5 = 0;
        goto L13
    }

    private void onPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mScrollPointerId) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mScrollPointerId = r4.getPointerId(r1);
        int r2 = (int) (r4.getX(r1) + 0.5f);
        this.mLastTouchX = r2;
        this.mInitialTouchX = r2;
        int r5 = (int) (r4.getY(r1) + 0.5f);
        this.mLastTouchY = r5;
        this.mInitialTouchY = r5;
        return;
    L6:
        r1 = 0;
        goto L7
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.b() == false) goto L7;
        return true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout == false) goto L8;
        this.mAdapterHelper.a();
        if (this.mDispatchItemsChangedEvent == false) goto L8;
        this.mLayout.a(this);
    L8:
        if (predictiveItemAnimationsEnabled() == false) goto L10;
        this.mAdapterHelper.b();
    L11:
        boolean r1 = false;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r0 = true;
    L18:
        s r3 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L32:
        boolean r4 = false;
    L33:
        r3.j = r4;
        s r5 = this.mState;
        if (r5.j == false) goto L41;
        if (r0 == false) goto L41;
        if (this.mDataSetHasChangedAfterLayout == true) goto L41;
        if (predictiveItemAnimationsEnabled() == false) goto L41;
        r1 = true;
    L41:
        r5.k = r1;
        return;
    L21:
        if (this.mItemAnimator == null) goto L32;
        if (this.mDataSetHasChangedAfterLayout == true) goto L28;
        if (r0 == true) goto L28;
        if (this.mLayout.u == false) goto L32;
    L28:
        if (this.mDataSetHasChangedAfterLayout == true) goto L30;
    L31:
        r4 = true;
        goto L33
    L30:
        if (this.mAdapter.f() == false) goto L32;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r0 = false;
        goto L18
    L10:
        this.mAdapterHelper.e();
        goto L11
    }

    private void pullGlows(float r4, float r5, float r6, float r7) {
        boolean r0 = true;
        if (r5 == 0.0f) goto L5;
        ensureHorizontalGlow();
        this.mHorizontalEdgeEffect.a(r5, false, false);
        boolean r8 = true;
    L7:
        if (r7 == 0.0f) goto L9;
        ensureVerticalGlow();
        this.mVerticalEdgeEffect.a(r7, false, false);
    L10:
        if (r0 == true) goto L13;
        if (r5 != 0.0f) goto L13;
        if (r7 != 0.0f) goto L13;
        return;
    L13:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        r0 = r8;
        goto L10
    L5:
        r8 = false;
        goto L7
    }

    private void recoverFocusFromState() {
        if (this.mPreserveFocusAfterLayout == true) goto L5;
        return;
    L5:
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        if (hasFocus() == true) goto L9;
        return;
    L9:
        if (getDescendantFocusability() != 393216) goto L11;
        return;
    L11:
        if (getDescendantFocusability() != 131072) goto L16;
        if (isFocused() == false) goto L16;
        return;
    L16:
        if (isFocused() == true) goto L30;
        View r0 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r0.getParent() == null) goto L24;
        if (r0.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.b() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.c(r0) == true) goto L30;
        return;
    L30:
        View r1 = null;
        if (this.mState.m != (-1)) goto L33;
    L35:
        v r2 = null;
    L36:
        if (r2 == null) goto L44;
        if (this.mChildHelper.c(r2.c) == true) goto L44;
        if (r2.c.hasFocusable() == false) goto L44;
        r1 = r2.c;
    L46:
        if (r1 != null) goto L48;
        return;
    L48:
        if (this.mState.n == (-1)) goto L54;
        View r6 = r1.findViewById(this.mState.n);
        if (r6 == null) goto L54;
        if (r6.isFocusable() == false) goto L54;
        r1 = r6;
    L54:
        r1.requestFocus();
        return;
    L44:
        if (this.mChildHelper.b() <= 0) goto L46;
        r1 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.f() == false) goto L35;
        r2 = findViewHolderForItemId(this.mState.m);
        goto L36
    }

    private void releaseGlows() {
        com.obric.oui.orecyclerview.base.a r0 = this.mHorizontalEdgeEffect;
        if (r0 == null) goto L5;
        r0.c();
        boolean r1 = this.mHorizontalEdgeEffect.a();
    L6:
        com.obric.oui.orecyclerview.base.a r2 = this.mVerticalEdgeEffect;
        if (r2 == null) goto L9;
        r2.c();
        r1 = r1 | this.mVerticalEdgeEffect.a();
    L9:
        if (r1 == false) goto L12;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private int releaseHorizontalGlow(int r3, float r4) {
        com.obric.oui.orecyclerview.base.a r5 = this.mHorizontalEdgeEffect;
        if (r5 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r5.b() == 0.0f) goto L8;
        int r6 = (int) this.mHorizontalEdgeEffect.a(r3, true, false);
        invalidate();
        return r6;
    }

    private int releaseVerticalGlow(int r3, float r4) {
        com.obric.oui.orecyclerview.base.a r5 = this.mVerticalEdgeEffect;
        if (r5 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r5.b() == 0.0f) goto L8;
        int r6 = (int) this.mVerticalEdgeEffect.a(r3, true, false);
        invalidate();
        return r6;
    }

    private void requestChildOnScreen(View r12, View r13) {
        if (r13 == null) goto L4;
        View r0 = r13;
    L5:
        this.mTempRect.set(0, 0, r0.getWidth(), r0.getHeight());
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, LayoutParams.class) == false) goto L10;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1, LayoutParams.class, "com.obric.memorydata.plugin");
        if (r2.e == true) goto L10;
        Rect r3 = r2.d;
        this.mTempRect.left -= r3.left;
        this.mTempRect.right += r3.right;
        this.mTempRect.top -= r3.top;
        this.mTempRect.bottom += r3.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        offsetRectIntoDescendantCoords(r12, this.mTempRect);
    L12:
        h r5 = this.mLayout;
        Rect r8 = this.mTempRect;
        boolean r9 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r10 = true;
    L16:
        r5.a(this, r12, r8, r9, r10);
        return;
    L15:
        r10 = false;
        goto L16
    L4:
        r0 = r12;
        goto L5
    }

    private void resetFocusInfo() {
        this.mState.m = -1;
        this.mState.l = -1;
        this.mState.n = -1;
    }

    private void resetScroll() {
        com.obric.oui.orecyclerview.base.i r0 = this.mVelocityTracker;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        v r1 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r0 = null;
    L10:
        if (r0 == null) goto L13;
        r1 = findContainingViewHolder(r0);
    L13:
        if (r1 != null) goto L15;
        resetFocusInfo();
        return;
    L15:
        s r2 = this.mState;
        if (this.mAdapter.f() == false) goto L18;
        long r3 = r1.r();
    L19:
        r2.m = r3;
        s r4 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r5 = -1;
    L26:
        r4.l = r5;
        this.mState.n = getDeepestFocusedViewWithId(r1.c);
        return;
    L23:
        if (r1.B() == false) goto L25;
        r5 = r1.f;
        goto L26
    L25:
        r5 = r1.p();
        goto L26
    L18:
        r3 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r0 = getFocusedChild();
        goto L10
    }

    private void setAdapterInternal(Adapter<?> r3, boolean r4, boolean r5) {
        Adapter r0 = this.mAdapter;
        if (r0 == null) goto L5;
        r0.b(this.mObserver);
        this.mAdapter.b(this);
    L5:
        if (r4 == false) goto L7;
        if (r5 == true) goto L7;
    L8:
        this.mAdapterHelper.a();
        Adapter<?> r6 = this.mAdapter;
        this.mAdapter = r3;
        if (r3 == null) goto L11;
        r3.a(this.mObserver);
        r3.a(this);
    L11:
        h r7 = this.mLayout;
        if (r7 == null) goto L14;
        r7.a(r6, this.mAdapter);
    L14:
        this.mRecycler.a(r6, this.mAdapter, r4);
        this.mState.f = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    public static void setDebugAssertionsEnabled(boolean r0) {
        sDebugAssertionsEnabled = r0;
    }

    public static void setVerboseLoggingEnabled(boolean r0) {
        sVerboseLoggingEnabled = r0;
    }

    private boolean shouldAbsorb(com.obric.oui.orecyclerview.base.a r1, int r2) {
        return true;
    }

    private boolean stopGlowAnimations(MotionEvent r5) {
        com.obric.oui.orecyclerview.base.a r6 = this.mHorizontalEdgeEffect;
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        com.obric.oui.orecyclerview.base.a r3 = this.mVerticalEdgeEffect;
        if (r3 == null) goto L14;
        if (r3.b() == 0.0f) goto L14;
        this.mVerticalEdgeEffect.a(0.0f, false, false);
        return true;
    L14:
        return r7;
    L5:
        if (r6.b() == 0.0f) goto L7;
        r7 = true;
        goto L8
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.b();
        h r1 = this.mLayout;
        if (r1 == null) goto L6;
        r1.K();
        return;
    }

    void absorbGlows(int r2, int r3) {
        if (r2 == 0) goto L8;
        ensureHorizontalGlow();
        if (this.mHorizontalEdgeEffect.a() == false) goto L6;
    L7:
        this.mHorizontalEdgeEffect.a(r2);
        goto L8
    L6:
        if (this.mEnableOverFling == true) goto L7;
    L8:
        if (r3 == 0) goto L14;
        ensureVerticalGlow();
        if (this.mVerticalEdgeEffect.a() == false) goto L12;
    L13:
        this.mVerticalEdgeEffect.a(r3);
        goto L14
    L12:
        if (this.mEnableOverFling == true) goto L13;
    L14:
        if (r2 != 0) goto L16;
        if (r3 != 0) goto L16;
        return;
    L16:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r2, int r3, int r4) {
        h r0 = this.mLayout;
        if (r0 != null) goto L5;
    L6:
        super.addFocusables(r2, r3, r4);
        return;
    L5:
        if (r0.a(this, r2, r3, r4) == false) goto L6;
    }

    public void addItemDecoration(g r2) {
        addItemDecoration(r2, -1);
    }

    public void addItemDecoration(g r3, int r4) {
        h r0 = this.mLayout;
        if (r0 == null) goto L6;
        r0.a("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r4 >= 0) goto L10;
        this.mItemDecorations.add(r3);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        this.mItemDecorations.add(r4, r3);
        goto L11
    }

    public void addOnChildAttachStateChangeListener(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r4);
    }

    public void addOnItemTouchListener(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        this.mOnItemTouchListeners.add(r4);
    }

    public void addOnScrollListener(m r2) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r2);
    }

    public void addRecyclerListener(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void allowClickDuringOverScroll(boolean r1) {
        this.mRecyclerViewExt.a(r1);
    }

    void animateAppearance(v r2, e.c r3, e.c r4) {
        r2.b(false);
        if (this.mItemAnimator.b(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    void animateDisappearance(v r2, e.c r3, e.c r4) {
        addAnimatingView(r2);
        r2.b(false);
        if (this.mItemAnimator.a(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    void assertInLayoutOrScroll(String r3) {
        if (isComputingLayout() == true) goto L9;
        if (r3 != null) goto L8;
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r3 + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String r3) {
        if (isComputingLayout() == false) goto L10;
        if (r3 != null) goto L8;
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r3);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        return;
    }

    public void avoidStateChangeInAnim() {
        this.mAvoidStateChangeInAnim = true;
    }

    boolean canReuseUpdatedViewHolder(v r2) {
        e r1 = this.mItemAnimator;
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.a(r2, r2.G()) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.a((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return true;
    }

    void clearOldPositions() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        v r2 = getChildViewHolderInt(this.mChildHelper.d(r1));
        if (r2.l() == true) goto L7;
        r2.j();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.mRecycler.k();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<j> r0 = this.mOnChildAttachStateListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void clearOnScrollListeners() {
        List<m> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.e() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.g(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.e() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.d(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.e() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.b(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.h(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.e(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.c(this.mState);
    }

    int consumeFlingInHorizontalStretch(int r2) {
        return consumeFlingInStretch(r2, this.mHorizontalEdgeEffect);
    }

    int consumeFlingInVerticalStretch(int r2) {
        return consumeFlingInStretch(r2, this.mVerticalEdgeEffect);
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L26:
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L26;
        if (this.mAdapterHelper.d() == true) goto L11;
        return;
    L11:
        if (this.mAdapterHelper.a(4) == false) goto L22;
        if (this.mAdapterHelper.a(11) == true) goto L22;
        TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.b();
        if (this.mLayoutWasDefered == false) goto L17;
    L20:
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
    L24:
        TraceCompat.endSection();
        return;
    L17:
        if (hasUpdatedView() == false) goto L19;
        dispatchLayout();
        goto L20
    L19:
        this.mAdapterHelper.c();
    L22:
        if (this.mAdapterHelper.d() == false) goto L28;
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        goto L24
    }

    void defaultOnMeasure(int r3, int r4) {
        setMeasuredDimension(h.a(r3, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), h.a(r4, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    void dispatchChildAttached(View r5) {
        v r0 = getChildViewHolderInt(r5);
        onChildAttachedToWindow(r5);
        Adapter r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.a(r0);
    L6:
        List<j> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r3 = r2.size() - 1;
    L9:
        if (r3 < 0) goto L13;
        ((j) ZeusTransformUtils.preCheckCast(this.mOnChildAttachStateListeners.get(r3), j.class, "com.obric.memorydata.plugin")).a(r5);
        r3 = r3 - 1;
        goto L9
    L13:
        return;
    }

    void dispatchChildDetached(View r5) {
        v r0 = getChildViewHolderInt(r5);
        onChildDetachedFromWindow(r5);
        Adapter r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.d(r0);
    L6:
        List<j> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r3 = r2.size() - 1;
    L9:
        if (r3 < 0) goto L13;
        ((j) ZeusTransformUtils.preCheckCast(this.mOnChildAttachStateListeners.get(r3), j.class, "com.obric.memorydata.plugin")).b(r5);
        r3 = r3 - 1;
        goto L9
    L13:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        r5.save();
        com.obric.oui.orecyclerview.base.a r0 = this.mHorizontalEdgeEffect;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        com.obric.oui.orecyclerview.base.a r3 = this.mVerticalEdgeEffect;
        if (r3 != null) goto L11;
    L13:
        r1 = r2;
    L14:
        dispatchBounceTranslationChanged();
        super.dispatchDraw(r5);
        r5.restore();
        if (r1 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L11:
        if (r3.a() == true) goto L13;
        this.mVerticalEdgeEffect.d();
        r5.translate(0.0f, this.mVerticalEdgeEffect.b());
        goto L14
    L5:
        if (r0.a() == true) goto L7;
        this.mHorizontalEdgeEffect.d();
        r5.translate(this.mHorizontalEdgeEffect.b(), 0.0f);
        r2 = true;
        goto L8
    }

    void dispatchLayout() {
        if (this.mAdapter != null) goto L7;
        Log.w(TAG, "No adapter attached; skipping layout");
        return;
    L7:
        if (this.mLayout != null) goto L10;
        Log.e(TAG, "No layout manager attached; skipping layout");
        return;
    L10:
        this.mState.i = false;
        if (this.mLastAutoMeasureSkippedDueToExact == true) goto L13;
    L17:
        boolean r0 = false;
    L18:
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.d != 1) goto L23;
        dispatchLayoutStep1();
    L21:
        this.mLayout.f(this);
        dispatchLayoutStep2();
    L31:
        dispatchLayoutStep3();
        return;
    L23:
        if (this.mAdapterHelper.f() == true) goto L21;
        if (r0 == true) goto L21;
        if (this.mLayout.A() != getWidth()) goto L21;
        if (this.mLayout.B() != getHeight()) goto L21;
        this.mLayout.f(this);
        goto L31
    L13:
        if (this.mLastAutoMeasureNonExactMeasuredWidth == getWidth()) goto L15;
    L16:
        r0 = true;
        goto L18
    L15:
        if (this.mLastAutoMeasureNonExactMeasuredHeight == getHeight()) goto L17;
        goto L16
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return getScrollingChildHelper().dispatchNestedFling(r1, r2, r3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return getScrollingChildHelper().dispatchNestedPreFling(r1, r2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r1, r2, r3, r4);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        getScrollingChildHelper().dispatchNestedScroll(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return getScrollingChildHelper().dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return getScrollingChildHelper().dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    void dispatchOnScrollStateChanged(int r5) {
        h r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.l(r5);
    L5:
        onScrollStateChanged(r5);
        m r1 = this.mScrollListener;
        if (r1 == null) goto L8;
        r1.a(this, r5);
    L8:
        List<m> r2 = this.mScrollListeners;
        if (r2 == null) goto L13;
        int r3 = r2.size() - 1;
    L11:
        if (r3 < 0) goto L15;
        ((m) ZeusTransformUtils.preCheckCast(this.mScrollListeners.get(r3), m.class, "com.obric.memorydata.plugin")).a(this, r5);
        r3 = r3 - 1;
        goto L11
    L15:
        return;
    }

    void dispatchOnScrolled(int r5, int r6) {
        this.mDispatchScrollCounter++;
        int r0 = getScrollX();
        int r1 = getScrollY();
        onScrollChanged(r0, r1, r0 - r5, r1 - r6);
        onScrolled(r5, r6);
        m r2 = this.mScrollListener;
        if (r2 == null) goto L5;
        r2.a(this, r5, r6);
    L5:
        List<m> r3 = this.mScrollListeners;
        if (r3 == null) goto L10;
        int r4 = r3.size() - 1;
    L8:
        if (r4 < 0) goto L10;
        ((m) ZeusTransformUtils.preCheckCast(this.mScrollListeners.get(r4), m.class, "com.obric.memorydata.plugin")).a(this, r5, r6);
        r4 = r4 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int r0 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r0 < 0) goto L13;
        v r1 = (v) ZeusTransformUtils.preCheckCast(this.mPendingAccessibilityImportanceChange.get(r0), v.class, "com.obric.memorydata.plugin");
        if (r1.c.getParent() != this) goto L12;
        if (r1.l() == true) goto L12;
        int r2 = r1.q;
        if (r2 == (-1)) goto L12;
        ViewCompat.setImportantForAccessibility(r1.c, r2);
        r1.q = -1;
    L12:
        r0 = r0 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        onPopulateAccessibilityEvent(r1);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.View
    public void draw(Canvas r7) {
        super.draw(r7);
        int r0 = this.mItemDecorations.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        ((g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r2), g.class, "com.obric.memorydata.plugin")).a(r7, this, this.mState);
        r2 = r2 + 1;
        goto L3
    L6:
        if (this.mItemAnimator != null) goto L8;
    L12:
        if (r1 == false) goto L16;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L16:
        return;
    L8:
        if (this.mItemDecorations.size() <= 0) goto L12;
        if (this.mItemAnimator.c() == false) goto L12;
        r1 = true;
        goto L12
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r1, View r2, long r3) {
        return super.drawChild(r1, r2, r3);
    }

    void ensureHorizontalGlow() {
        if (this.mHorizontalEdgeEffect == null) goto L5;
        return;
    L5:
        com.obric.oui.orecyclerview.base.a r0 = new com.obric.oui.orecyclerview.base.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.mHorizontalEdgeEffect = r0;
        r0.b(getWidth());
    }

    void ensureVerticalGlow() {
        if (this.mVerticalEdgeEffect == null) goto L5;
        return;
    L5:
        com.obric.oui.orecyclerview.base.a r0 = new com.obric.oui.orecyclerview.base.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.mVerticalEdgeEffect = r0;
        r0.b(getHeight());
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    final void fillRemainingScrollValues(s r3) {
        if (getScrollState() != 2) goto L5;
        com.obric.oui.orecyclerview.base.f r2 = this.mViewFlinger.f14096a;
        r3.o = r2.f() - r2.c();
        r3.p = r2.g() - r2.d();
        return;
    L5:
        r3.o = 0;
        r3.p = 0;
    }

    public View findChildViewUnder(float r6, float r7) {
        int r0 = this.mChildHelper.b() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = this.mChildHelper.b(r0);
        float r2 = r1.getTranslationX();
        float r3 = r1.getTranslationY();
        if (r6 < (r1.getLeft() + r2)) goto L13;
        if (r6 > (r1.getRight() + r2)) goto L13;
        if (r7 < (r1.getTop() + r3)) goto L13;
        if (r7 > (r1.getBottom() + r3)) goto L13;
        return r1;
    L13:
        r0 = r0 - 1;
        goto L3
    L14:
        return null;
    }

    public View findContainingItemView(View r3) {
    L2:
        ViewParent r0 = r3.getParent();
        if (r0 == null) goto L8;
        if (r0 == this) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L8;
        r3 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    L8:
        if (r0 == this) goto L15;
        return null;
    L15:
        return r3;
    }

    public v findContainingViewHolder(View r1) {
        View r2 = findContainingItemView(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r2);
    }

    public v findViewHolderForAdapterPosition(int r6) {
        v r1 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r0 = this.mChildHelper.c();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        v r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L17;
        if (r3.B() == true) goto L17;
        if (getAdapterPositionInRecyclerView(r3) != r6) goto L17;
        if (this.mChildHelper.c(r3.c) == false) goto L16;
        r1 = r3;
        goto L17
    L16:
        return r3;
    L17:
        r2 = r2 + 1;
        goto L6
    L18:
        return r1;
    }

    public v findViewHolderForItemId(long r7) {
        Adapter r0 = this.mAdapter;
        v r1 = null;
        if (r0 != null) goto L5;
    L20:
        return r1;
    L5:
        if (r0.f() == false) goto L20;
        int r2 = this.mChildHelper.c();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L20;
        v r4 = getChildViewHolderInt(this.mChildHelper.d(r3));
        if (r4 == null) goto L19;
        if (r4.B() == true) goto L19;
        if (r4.r() != r7) goto L19;
        if (this.mChildHelper.c(r4.c) == false) goto L18;
        r1 = r4;
        goto L19
    L18:
        return r4;
    L19:
        r3 = r3 + 1;
        goto L8
    }

    public v findViewHolderForLayoutPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    @Deprecated
    public v findViewHolderForPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    v findViewHolderForPosition(int r6, boolean r7) {
        int r0 = this.mChildHelper.c();
        v r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L20;
        v r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L19;
        if (r3.B() == true) goto L19;
        if (r7 == false) goto L13;
        if (r3.e != r6) goto L19;
    L16:
        if (this.mChildHelper.c(r3.c) == false) goto L18;
        r1 = r3;
        goto L19
    L18:
        return r3;
    L13:
        if (r3.m() == r6) goto L16;
    L19:
        r2 = r2 + 1;
        goto L3
    L20:
        return r1;
    }

    public boolean fling(int r9, int r10) {
        h r0 = this.mLayout;
        int r1 = 0;
        if (r0 != null) goto L7;
        Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        boolean r2 = r0.e();
        boolean r3 = this.mLayout.f();
        if (r2 == true) goto L12;
    L13:
        r9 = 0;
    L14:
        if (r3 == true) goto L16;
    L17:
        r10 = 0;
    L18:
        if (r9 != 0) goto L22;
        if (r10 != 0) goto L22;
        return false;
    L22:
        if (r9 == 0) goto L38;
        com.obric.oui.orecyclerview.base.a r4 = this.mHorizontalEdgeEffect;
        if (r4 == null) goto L38;
        if (r4.b() == 0.0f) goto L38;
        if (shouldAbsorb(this.mHorizontalEdgeEffect, r9) == false) goto L30;
        this.mHorizontalEdgeEffect.a(r9);
        int r5 = 0;
    L32:
        if (this.mEnableOverFling == false) goto L37;
        com.obric.oui.orecyclerview.base.a r6 = this.mHorizontalEdgeEffect;
        if (r6 != null) goto L36;
    L39:
        if (r10 == 0) goto L55;
        com.obric.oui.orecyclerview.base.a r7 = this.mVerticalEdgeEffect;
        if (r7 == null) goto L55;
        if (r7.b() == 0.0f) goto L55;
        if (shouldAbsorb(this.mVerticalEdgeEffect, r10) == false) goto L47;
        this.mVerticalEdgeEffect.a(-r10);
        int r8 = 0;
    L49:
        if (this.mEnableOverFling == false) goto L54;
        com.obric.oui.orecyclerview.base.a r11 = this.mVerticalEdgeEffect;
        if (r11 != null) goto L53;
    L56:
        if (r5 != 0) goto L58;
        if (r8 != 0) goto L58;
    L60:
        if (r9 != 0) goto L66;
        if (r10 != 0) goto L66;
        if (r5 != 0) goto L65;
        if (r8 != 0) goto L65;
        return false;
    L65:
        return true;
    L66:
        float r12 = r9;
        float r13 = r10;
        if (dispatchNestedPreFling(r12, r13) == true) goto L85;
        if (r2 == true) goto L72;
        if (r3 == true) goto L72;
        boolean r14 = false;
    L73:
        dispatchNestedFling(r12, r13, r14);
        k r15 = this.mOnFlingListener;
        if (r15 != null) goto L76;
    L78:
        if (r14 == false) goto L85;
        if (r2 == false) goto L81;
        r1 = 1;
    L81:
        if (r3 == false) goto L83;
        r1 = r1 | 2;
    L83:
        startNestedScroll(r1, 1);
        int r16 = this.mMaxFlingVelocity;
        int r17 = Math.max(-r16, Math.min(r9, r16));
        int r18 = this.mMaxFlingVelocity;
        this.mViewFlinger.a(r17, Math.max(-r18, Math.min(r10, r18)));
        return true;
    L76:
        if (r15.a(r9, r10) == false) goto L78;
        return true;
    L72:
        r14 = true;
    L85:
        return false;
    L58:
        int r19 = this.mMaxFlingVelocity;
        r5 = Math.max(-r19, Math.min(r5, r19));
        int r20 = this.mMaxFlingVelocity;
        r8 = Math.max(-r20, Math.min(r8, r20));
        this.mViewFlinger.a(r5, r8);
        goto L60
    L53:
        if ((r11.b() * r10) >= 0.0f) goto L56;
    L54:
        r10 = 0;
        goto L56
    L47:
        r8 = r10;
    L55:
        r8 = 0;
        goto L56
    L36:
        if ((r6.b() * r9) >= 0.0f) goto L39;
    L37:
        r9 = 0;
        goto L39
    L30:
        r5 = r9;
    L38:
        r5 = 0;
        goto L39
    L16:
        if (Math.abs(r10) >= this.mMinFlingVelocity) goto L18;
    L12:
        if (Math.abs(r9) >= this.mMinFlingVelocity) goto L14;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r9, int r10) {
        View r0 = this.mLayout.d(r9, r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        boolean r1 = true;
        if (this.mAdapter != null) goto L8;
    L14:
        boolean r2 = false;
    L15:
        FocusFinder r3 = FocusFinder.getInstance();
        if (r2 == true) goto L18;
    L61:
        View r4 = r3.findNextFocus(this, r9, r10);
        if (r4 != null) goto L68;
        if (r2 == false) goto L68;
        consumePendingUpdateOperations();
        if (findContainingItemView(r9) != null) goto L67;
        return null;
    L67:
        startInterceptRequestLayout();
        View r5 = this.mLayout.a(r9, r10, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L69:
        if (r5 == null) goto L79;
        if (r5.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        requestChildOnScreen(r5, null);
        return r9;
    L75:
        return super.focusSearch(r9, r10);
    L79:
        if (isPreferredNextFocus(r9, r5, r10) == false) goto L82;
        return r5;
    L82:
        return super.focusSearch(r9, r10);
    L68:
        r5 = r4;
        goto L69
    L18:
        if (r10 == 2) goto L21;
        if (r10 != 1) goto L61;
    L21:
        if (this.mLayout.f() == false) goto L32;
        if (r10 != 2) goto L24;
        int r6 = 130;
    L26:
        if (r3.findNextFocus(this, r9, r6) != null) goto L28;
        boolean r7 = true;
    L30:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L33;
        r10 = r6;
    L33:
        if (r7 == false) goto L35;
    L55:
        if (r7 == false) goto L60;
        consumePendingUpdateOperations();
        if (findContainingItemView(r9) != null) goto L59;
        return null;
    L59:
        startInterceptRequestLayout();
        this.mLayout.a(r9, r10, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r5 = r3.findNextFocus(this, r9, r10);
        goto L69
    L35:
        if (this.mLayout.e() == false) goto L55;
        if (this.mLayout.v() != 1) goto L39;
        boolean r8 = true;
    L40:
        if (r10 != 2) goto L42;
        boolean r11 = true;
    L44:
        if ((r8 ^ r11) == false) goto L46;
        int r12 = 66;
    L48:
        if (r3.findNextFocus(this, r9, r12) == null) goto L52;
        r1 = false;
    L52:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L54;
        r10 = r12;
    L54:
        r7 = r1;
        goto L55
    L46:
        r12 = 17;
        goto L48
    L42:
        r11 = false;
        goto L44
    L39:
        r8 = false;
        goto L40
    L28:
        r7 = false;
        goto L30
    L24:
        r6 = 33;
        goto L26
    L32:
        r7 = false;
        goto L33
    L8:
        if (this.mLayout == null) goto L14;
        if (isComputingLayout() == true) goto L14;
        if (this.mLayoutSuppressed == true) goto L14;
        r2 = true;
        goto L15
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.a();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.a(r3);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.fluidrecyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionInRecyclerView(v r2) {
        if (r2.a(524) == false) goto L5;
        return -1;
    L5:
        if (r2.A() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.c(r2.e);
    }

    @Override // android.view.View
    public int getBaseline() {
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.w();
    L7:
        return super.getBaseline();
    }

    public float getBounceTranslation() {
        com.obric.oui.orecyclerview.base.a r0 = this.mVerticalEdgeEffect;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        return r0.b();
    }

    long getChangedHolderKey(v r1) {
        if (this.mAdapter.f() == false) goto L6;
        return r1.r();
    L6:
        return r1.e;
    }

    public int getChildAdapterPosition(View r1) {
        v r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.p();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r2, int r3) {
        c r0 = this.mChildDrawingOrderCallback;
        if (r0 != null) goto L7;
        return super.getChildDrawingOrder(r2, r3);
    L7:
        return r0.a(r2, r3);
    }

    public long getChildItemId(View r3) {
        Adapter r2 = this.mAdapter;
        if (r2 != null) goto L5;
        return -1;
    L5:
        if (r2.f() == false) goto L13;
        v r4 = getChildViewHolderInt(r3);
        if (r4 != null) goto L10;
        return -1;
    L10:
        return r4.r();
    L13:
        return -1;
    }

    public int getChildLayoutPosition(View r1) {
        v r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.m();
    }

    @Deprecated
    public int getChildPosition(View r1) {
        return getChildAdapterPosition(r1);
    }

    public v getChildViewHolder(View r4) {
        ViewParent r0 = r4.getParent();
        if (r0 == null) goto L9;
        if (r0 == this) goto L9;
        throw new IllegalArgumentException("View " + r4 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r4);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View r1, Rect r2) {
        getDecoratedBoundsWithMarginsInt(r1, r2);
    }

    public d getEdgeEffectFactory() {
        return null;
    }

    public e getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View r10) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r0.e == true) goto L7;
        return r0.d;
    L7:
        if (this.mState.a() == true) goto L9;
    L14:
        Rect r1 = r0.d;
        r1.set(0, 0, 0, 0);
        int r4 = this.mItemDecorations.size();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        ((g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r5), g.class, "com.obric.memorydata.plugin")).a(this.mTempRect, r10, this, this.mState);
        r1.left += this.mTempRect.left;
        r1.top += this.mTempRect.top;
        r1.right += this.mTempRect.right;
        r1.bottom += this.mTempRect.bottom;
        r5 = r5 + 1;
        goto L15
    L17:
        r0.e = false;
        return r1;
    L9:
        if (r0.e() == true) goto L13;
        if (r0.c() == false) goto L14;
    L13:
        return r0.d;
    }

    public g getItemDecorationAt(int r3) {
        int r0 = getItemDecorationCount();
        if (r3 < 0) goto L8;
        if (r3 >= r0) goto L8;
        return (g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r3), g.class, "com.obric.memorydata.plugin");
    L8:
        throw new IndexOutOfBoundsException(r3 + " is an invalid index for size " + r0);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public h getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    public k getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public n getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r1) {
        return getScrollingChildHelper().hasNestedScrollingParent(r1);
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.d() == true) goto L10;
        return false;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new com.obric.oui.orecyclerview.widget.a(new AnonymousClass6(this));
    }

    void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        new com.obric.oui.orecyclerview.widget.j(this, r11, r12, r13, r14, r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.fastscroll_default_thickness, "dimen", "fastscroll_default_thickness")), r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.fastscroll_minimum_range, "dimen", "fastscroll_minimum_range")), r0.getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.dimen.fastscroll_margin, "dimen", "fastscroll_margin")));
        return;
    L9:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    void invalidateGlows() {
        this.mVerticalEdgeEffect = null;
        this.mHorizontalEdgeEffect = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        h r0 = this.mLayout;
        if (r0 == null) goto L8;
        r0.a("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager r0 = this.mAccessibilityManager;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEnabled() == false) goto L7;
        return true;
    }

    public boolean isAnimating() {
        e r0 = this.mItemAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public boolean isOverScrolling() {
        com.obric.oui.orecyclerview.base.a r0 = this.mVerticalEdgeEffect;
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        com.obric.oui.orecyclerview.base.a r4 = this.mHorizontalEdgeEffect;
        if (r4 != null) goto L13;
    L17:
        boolean r5 = false;
    L18:
        if (r1 == true) goto L23;
        if (r5 == false) goto L22;
        return true;
    L22:
        return false;
    L23:
        return true;
    L13:
        if (r4.b() == 0.0f) goto L15;
    L16:
        r5 = true;
        goto L18
    L15:
        if (this.mHorizontalEdgeEffect.a() == true) goto L17;
    L5:
        if (r0.b() == 0.0f) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (this.mVerticalEdgeEffect.a() == true) goto L9;
        goto L8
    }

    void jumpToPositionForSmoothScroller(int r2) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.e(r2);
        awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((LayoutParams) ZeusTransformUtils.preCheckCast(this.mChildHelper.d(r1).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).e = true;
        r1 = r1 + 1;
        goto L3
    L5:
        this.mRecycler.l();
    }

    void markKnownViewsInvalid() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        v r2 = getChildViewHolderInt(this.mChildHelper.d(r1));
        if (r2 == null) goto L9;
        if (r2.l() == true) goto L9;
        r2.b(6);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.j();
    }

    public void nestedScrollBy(int r3, int r4) {
        nestedScrollByInternal(r3, r4, null, 1);
    }

    public void offsetChildrenHorizontal(int r4) {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.b(r1).offsetLeftAndRight(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void offsetChildrenVertical(int r4) {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.b(r1).offsetTopAndBottom(r4);
        r1 = r1 + 1;
        goto L3
    }

    void offsetPositionRecordsForInsert(int r7, int r8) {
        int r0 = this.mChildHelper.c();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        v r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L14;
        if (r3.l() == true) goto L14;
        if (r3.e < r7) goto L14;
        if (sVerboseLoggingEnabled == false) goto L13;
        Log.d(TAG, "offsetPositionRecordsForInsert attached child " + r2 + " holder " + r3 + " now at position " + (r3.e + r8));
    L13:
        r3.a(r8, false);
        this.mState.f = true;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        this.mRecycler.b(r7, r8);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int r11, int r12) {
        int r0 = this.mChildHelper.c();
        if (r11 >= r12) goto L5;
        int r2 = -1;
        int r3 = r11;
        int r4 = r12;
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r0) goto L24;
        v r7 = getChildViewHolderInt(this.mChildHelper.d(r6));
        if (r7 == null) goto L23;
        if (r7.e < r3) goto L23;
        if (r7.e > r4) goto L23;
        if (sVerboseLoggingEnabled == false) goto L19;
        Log.d(TAG, "offsetPositionRecordsForMove attached child " + r6 + " holder " + r7);
    L19:
        if (r7.e != r11) goto L21;
        r7.a(r12 - r11, false);
    L22:
        this.mState.f = true;
        goto L23
    L21:
        r7.a(r2, false);
    L23:
        r6 = r6 + 1;
        goto L7
    L24:
        this.mRecycler.a(r11, r12);
        requestLayout();
        return;
    L5:
        r4 = r11;
        r3 = r12;
        r2 = 1;
        goto L6
    }

    void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
        int r0 = r10 + r11;
        int r1 = this.mChildHelper.c();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L22;
        v r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L21;
        if (r3.l() == true) goto L21;
        if (r3.e < r0) goto L16;
        if (sVerboseLoggingEnabled == false) goto L13;
        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + r2 + " holder " + r3 + " now at position " + (r3.e - r11));
    L13:
        r3.a(-r11, r12);
    L14:
        this.mState.f = true;
        goto L21
    L16:
        if (r3.e < r10) goto L21;
        if (sVerboseLoggingEnabled == false) goto L20;
        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + r2 + " holder " + r3 + " now REMOVED");
    L20:
        r3.a(r10 - 1, -r11, r12);
    L21:
        r2 = r2 + 1;
        goto L3
    L22:
        this.mRecycler.a(r10, r11, r12);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r1 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r1 = false;
    L8:
        this.mFirstLayoutComplete = r1;
        this.mRecycler.g();
        h r2 = this.mLayout;
        if (r2 == null) goto L11;
        r2.c(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L24;
        com.obric.oui.orecyclerview.widget.k r0 = (com.obric.oui.orecyclerview.widget.k) ZeusTransformUtils.preCheckCast(com.obric.oui.orecyclerview.widget.k.f14205a.get(), com.obric.oui.orecyclerview.widget.k.class, "com.obric.memorydata.plugin");
        this.mGapWorker = r0;
        if (r0 != null) goto L22;
        this.mGapWorker = new com.obric.oui.orecyclerview.widget.k();
        Display r3 = ViewCompat.getDisplay(this);
        float r4 = 60.0f;
        if (isInEditMode() == true) goto L21;
        if (r3 == null) goto L21;
        float r5 = r3.getRefreshRate();
        if (r5 < 30.0f) goto L21;
        r4 = r5;
    L21:
        this.mGapWorker.d = (long) (1.0E9f / r4);
        com.obric.oui.orecyclerview.widget.k.f14205a.set(this.mGapWorker);
    L22:
        this.mGapWorker.a(this);
        return;
    L24:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    public void onChildAttachedToWindow(View r1) {
    }

    public void onChildDetachedFromWindow(View r1) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        stopScroll();
        this.mIsAttached = false;
        h r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.b(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.b();
        this.mRecycler.h();
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        com.obric.oui.orecyclerview.widget.k r2 = this.mGapWorker;
        if (r2 == null) goto L15;
        r2.b(this);
        this.mGapWorker = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r6) {
        super.onDraw(r6);
        int r0 = this.mItemDecorations.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r1), g.class, "com.obric.memorydata.plugin")).b(r6, this, this.mState);
        r1 = r1 + 1;
        goto L3
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean r3) {
        int r0 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r0;
        if (r0 < 1) goto L5;
        return;
    L5:
        if (sDebugAssertionsEnabled == false) goto L10;
        if (r0 >= 0) goto L10;
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + exceptionLabel());
    L10:
        this.mLayoutOrScrollCounter = 0;
        if (r3 == false) goto L15;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r6) {
        if (this.mLayout != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        if (r6.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r6.getSource() & 2) == 0) goto L21;
        if (this.mLayout.f() == false) goto L15;
        float r0 = -r6.getAxisValue(9);
    L17:
        if (this.mLayout.e() == false) goto L19;
        float r3 = r6.getAxisValue(10);
    L30:
        if (r0 == 0.0f) goto L32;
    L33:
        nestedScrollByInternal((int) (r3 * this.mScaledHorizontalScrollFactor), (int) (r0 * this.mScaledVerticalScrollFactor), r6, 1);
        goto L34
    L32:
        if (r3 == 0.0f) goto L34;
    L19:
        r3 = 0.0f;
        goto L30
    L15:
        r0 = 0.0f;
        goto L17
    L21:
        if ((r6.getSource() & 4194304) == 0) goto L28;
        float r1 = r6.getAxisValue(26);
        if (this.mLayout.f() == false) goto L26;
        r0 = -r1;
        goto L19
    L26:
        if (this.mLayout.e() == false) goto L28;
        r3 = r1;
        r0 = 0.0f;
    L28:
        r0 = 0.0f;
        r3 = 0.0f;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r9) {
        if (this.mLayoutSuppressed == false) goto L5;
        return false;
    L5:
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(r9) == false) goto L9;
        cancelScroll();
        return true;
    L9:
        h r0 = this.mLayout;
        if (r0 != null) goto L12;
        return false;
    L12:
        boolean r1 = r0.e();
        boolean r3 = this.mLayout.f();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = com.obric.oui.orecyclerview.base.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L15:
        this.mVelocityTracker.a(r9);
        int r4 = r9.getActionMasked();
        int r5 = r9.getActionIndex();
        if (r4 == 0) goto L50;
        if (r4 == 1) goto L47;
        if (r4 != 2) goto L20;
        int r6 = r9.findPointerIndex(this.mScrollPointerId);
        if (r6 >= 0) goto L33;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r7 = (int) (r9.getX(r6) + 0.5f);
        int r10 = (int) (r9.getY(r6) + 0.5f);
        if (this.mScrollState == 1) goto L48;
        int r8 = r7 - this.mInitialTouchX;
        int r11 = r10 - this.mInitialTouchY;
        if (r1 == true) goto L38;
    L40:
        boolean r2 = false;
    L41:
        if (r3 == true) goto L43;
    L45:
        if (r2 == false) goto L48;
        setScrollState(1);
        goto L48
    L43:
        if (Math.abs(r11) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r10;
        r2 = true;
        goto L45
    L38:
        if (Math.abs(r8) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r7;
        r2 = true;
    L48:
        boolean r12 = false;
    L63:
        if (r12 == false) goto L65;
        return false;
    L65:
        if (this.mScrollState == 1) goto L67;
        return false;
    L67:
        return true;
    L20:
        if (r4 != 3) goto L22;
        cancelScroll();
        goto L48
    L22:
        if (r4 != 5) goto L24;
        this.mScrollPointerId = r9.getPointerId(r5);
        int r13 = (int) (r9.getX(r5) + 0.5f);
        this.mLastTouchX = r13;
        this.mInitialTouchX = r13;
        int r14 = (int) (r9.getY(r5) + 0.5f);
        this.mLastTouchY = r14;
        this.mInitialTouchY = r14;
        goto L48
    L24:
        if (r4 != 6) goto L48;
        onPointerUp(r9);
        goto L48
    L47:
        this.mVelocityTracker.a();
        stopNestedScroll(0);
        goto L48
    L50:
        if (this.mIgnoreMotionEventTillDown == false) goto L52;
        this.mIgnoreMotionEventTillDown = false;
    L52:
        this.mScrollPointerId = r9.getPointerId(0);
        int r15 = (int) (r9.getX() + 0.5f);
        this.mLastTouchX = r15;
        this.mInitialTouchX = r15;
        int r16 = (int) (r9.getY() + 0.5f);
        this.mLastTouchY = r16;
        this.mInitialTouchY = r16;
        r12 = this.mRecyclerViewExt.a(r9, false);
        if (r12 == false) goto L55;
    L59:
        int[] r17 = this.mNestedOffsets;
        r17[1] = 0;
        r17[0] = 0;
        int r18 = r1;
        if (r3 == false) goto L62;
        r18 = (r1 ? 1 : 0) | 2;
    L62:
        startNestedScroll(r18, 0);
        goto L63
    L55:
        if (stopGlowAnimations(r9) == false) goto L57;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
        goto L59
    L57:
        if (this.mScrollState != 2) goto L59;
        goto L58
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r9) {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        defaultOnMeasure(r8, r9);
        return;
    L6:
        boolean r2 = false;
        if (r0.c() == false) goto L26;
        int r1 = View.MeasureSpec.getMode(r8);
        int r3 = View.MeasureSpec.getMode(r9);
        this.mLayout.a(this.mRecycler, this.mState, r8, r9);
        if (r1 != 1073741824) goto L12;
        if (r3 != 1073741824) goto L12;
        r2 = true;
    L12:
        this.mLastAutoMeasureSkippedDueToExact = r2;
        if (r2 == false) goto L15;
        return;
    L15:
        if (this.mAdapter != null) goto L18;
        return;
    L18:
        if (this.mState.d != 1) goto L20;
        dispatchLayoutStep1();
    L20:
        this.mLayout.d(r8, r9);
        this.mState.i = true;
        dispatchLayoutStep2();
        this.mLayout.e(r8, r9);
        if (this.mLayout.n() == false) goto L23;
        this.mLayout.d(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.i = true;
        dispatchLayoutStep2();
        this.mLayout.e(r8, r9);
    L23:
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
        return;
    L26:
        if (this.mHasFixedSize == false) goto L30;
        this.mLayout.a(this.mRecycler, this.mState, r8, r9);
        return;
    L30:
        if (this.mAdapterUpdateDuringMeasure == false) goto L37;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        if (this.mState.k == false) goto L34;
        this.mState.g = true;
    L35:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L40:
        Adapter r4 = this.mAdapter;
        if (r4 == null) goto L43;
        this.mState.e = r4.d();
    L44:
        startInterceptRequestLayout();
        this.mLayout.a(this.mRecycler, this.mState, r8, r9);
        stopInterceptRequestLayout(false);
        this.mState.g = false;
        return;
    L43:
        this.mState.e = 0;
        goto L44
    L34:
        this.mAdapterHelper.e();
        this.mState.g = false;
        goto L35
    L37:
        if (this.mState.k == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r2, Rect r3) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r2, r3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        this.mPendingSavedState = r5;
        super.onRestoreInstanceState(r5.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SavedState r1 = this.mPendingSavedState;
        if (r1 == null) goto L5;
        r0.copyFrom(r1);
    L10:
        return r0;
    L5:
        h r2 = this.mLayout;
        if (r2 == null) goto L8;
        Parcelable r3 = r2.d();
    L9:
        r0.mLayoutState = r3;
        goto L10
    L8:
        r3 = null;
        goto L9
    }

    public void onScrollStateChanged(int r1) {
    }

    public void onScrolled(int r1, int r2) {
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        if (r2 != r4) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        boolean r8 = false;
        if (this.mLayoutSuppressed == false) goto L5;
    L109:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L109;
        if (dispatchToOnItemTouchListeners(r18) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        h r0 = this.mLayout;
        if (r0 != null) goto L14;
        return false;
    L14:
        boolean r10 = r0.e();
        boolean r11 = this.mLayout.f();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = com.obric.oui.orecyclerview.base.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L17:
        int r1 = r18.getActionMasked();
        int r2 = r18.getActionIndex();
        if (r1 != 0) goto L20;
        int[] r3 = this.mNestedOffsets;
        r3[1] = 0;
        r3[0] = 0;
    L20:
        MotionEvent r12 = MotionEvent.obtain(r18);
        int[] r4 = this.mNestedOffsets;
        r12.offsetLocation(r4[0], r4[1]);
        if (r1 != 0) goto L23;
        this.mScrollPointerId = r18.getPointerId(0);
        int r5 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r5;
        this.mInitialTouchX = r5;
        int r6 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r6;
        this.mInitialTouchY = r6;
        int r13 = r10;
        if (r11 == false) goto L104;
        r13 = (r10 ? 1 : 0) | 2;
    L104:
        startNestedScroll(r13, 0);
    L105:
        if (r8 == true) goto L107;
        this.mVelocityTracker.a(r12);
    L107:
        r12.recycle();
        return true;
    L23:
        if (r1 != 1) goto L25;
        this.mVelocityTracker.a(r12);
        this.mVelocityTracker.a(1000, this.mMaxFlingVelocity);
        if (r10 == false) goto L89;
        float r7 = -this.mVelocityTracker.a(this.mScrollPointerId);
    L90:
        if (r11 == false) goto L92;
        float r9 = -this.mVelocityTracker.b(this.mScrollPointerId);
    L93:
        Log.d(TAG, "TouchUp, Velocity: x: " + r7 + ", y: " + r9);
        if (r7 != 0.0f) goto L98;
        if (r9 != 0.0f) goto L98;
    L99:
        Log.d(TAG, "No fling, setting scroll state to idle");
        setScrollState(0);
    L100:
        resetScroll();
        r8 = true;
    L98:
        if (fling((int) r7, (int) r9) == true) goto L100;
    L92:
        r9 = 0.0f;
        goto L93
    L89:
        r7 = 0.0f;
        goto L90
    L25:
        if (r1 != 2) goto L27;
        int r14 = r18.findPointerIndex(this.mScrollPointerId);
        if (r14 >= 0) goto L40;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L40:
        int r15 = (int) (r18.getX(r14) + 0.5f);
        int r16 = (int) (r18.getY(r14) + 0.5f);
        int r17 = this.mLastTouchX - r15;
        int r19 = this.mLastTouchY - r16;
        if (this.mScrollState == 1) goto L60;
        if (r10 == false) goto L49;
        int r20 = this.mTouchSlop;
        if (r17 <= 0) goto L46;
        r17 = Math.max(0, r17 - r20);
    L47:
        if (r17 == 0) goto L49;
        boolean r21 = true;
    L50:
        if (r11 == false) goto L57;
        int r22 = this.mTouchSlop;
        if (r19 <= 0) goto L54;
        r19 = Math.max(0, r19 - r22);
    L55:
        if (r19 == 0) goto L57;
        r21 = true;
        goto L57
    L54:
        r19 = Math.min(0, r19 + r22);
    L57:
        if (r21 == false) goto L60;
        setScrollState(1);
        goto L60
    L46:
        r17 = Math.min(0, r17 + r20);
    L49:
        r21 = false;
    L60:
        if (this.mScrollState != 1) goto L105;
        int[] r23 = this.mReusableIntPair;
        r23[0] = 0;
        r23[1] = 0;
        int r110 = r17 - releaseHorizontalGlow(r17, r18.getY());
        int r111 = r19 - releaseVerticalGlow(r19, r18.getX());
        if (r10 == false) goto L64;
        int r24 = r110;
    L65:
        if (r11 == false) goto L67;
        int r25 = r111;
    L69:
        if (dispatchNestedPreScroll(r24, r25, this.mReusableIntPair, this.mScrollOffset, 0) == false) goto L71;
        int[] r26 = this.mReusableIntPair;
        r110 = r110 - r26[0];
        r111 = r111 - r26[1];
        int[] r27 = this.mNestedOffsets;
        int r28 = r27[0];
        int[] r29 = this.mScrollOffset;
        r27[0] = r28 + r29[0];
        r27[1] = r27[1] + r29[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L71:
        int r30 = r111;
        int[] r31 = this.mScrollOffset;
        this.mLastTouchX = r15 - r31[0];
        this.mLastTouchY = r16 - r31[1];
        if (r10 == false) goto L74;
        int r32 = r110;
    L75:
        if (r11 == false) goto L77;
        int r33 = r30;
    L79:
        if (scrollByInternal(r32, r33, r18, 0) == false) goto L81;
        getParent().requestDisallowInterceptTouchEvent(true);
    L81:
        com.obric.oui.orecyclerview.widget.k r34 = this.mGapWorker;
        if (r34 == null) goto L105;
        if (r110 != 0) goto L85;
        if (r30 == 0) goto L105;
    L85:
        r34.a(this, r110, r30);
        goto L105
    L77:
        r33 = 0;
        goto L79
    L74:
        r32 = 0;
        goto L75
    L67:
        r25 = 0;
        goto L69
    L64:
        r24 = 0;
        goto L65
    L27:
        if (r1 != 3) goto L29;
        cancelScroll();
        goto L105
    L29:
        if (r1 != 5) goto L31;
        this.mScrollPointerId = r18.getPointerId(r2);
        int r35 = (int) (r18.getX(r2) + 0.5f);
        this.mLastTouchX = r35;
        this.mInitialTouchX = r35;
        int r36 = (int) (r18.getY(r2) + 0.5f);
        this.mLastTouchY = r36;
        this.mInitialTouchY = r36;
        goto L105
    L31:
        if (r1 != 6) goto L105;
        onPointerUp(r18);
        goto L105
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
        return;
    }

    void processDataSetCompletelyChanged(boolean r2) {
        this.mDispatchItemsChangedEvent = r2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(v r4, e.c r5) {
        r4.b(0, 8192);
        if (this.mState.h == true) goto L5;
    L11:
        this.mViewInfoStore.a(r4, r5);
        return;
    L5:
        if (r4.L() == false) goto L11;
        if (r4.B() == true) goto L11;
        if (r4.l() == true) goto L11;
        long r0 = getChangedHolderKey(r4);
        this.mViewInfoStore.a(r0, r4);
        goto L11
    }

    void removeAndRecycleViews() {
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        h r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.c(this.mRecycler);
        this.mLayout.b(this.mRecycler);
    L8:
        this.mRecycler.a();
    }

    boolean removeAnimatingView(View r4) {
        startInterceptRequestLayout();
        boolean r0 = this.mChildHelper.f(r4);
        if (r0 == false) goto L7;
        v r1 = getChildViewHolderInt(r4);
        this.mRecycler.c(r1);
        this.mRecycler.b(r1);
        if (sVerboseLoggingEnabled == false) goto L7;
        Log.d(TAG, "after removing animated view: " + r4 + ", " + this);
    L7:
        stopInterceptRequestLayout(!r0);
        return r0;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r3, boolean r4) {
        v r0 = getChildViewHolderInt(r3);
        if (r0 == null) goto L13;
        if (r0.C() == false) goto L8;
        r0.x();
    L14:
        r3.clearAnimation();
        dispatchChildDetached(r3);
        super.removeDetachedView(r3, r4);
        return;
    L8:
        if (r0.l() == true) goto L14;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r0 + exceptionLabel());
    L13:
        if (sDebugAssertionsEnabled == false) goto L14;
        throw new IllegalArgumentException("No ViewHolder found for child: " + r3 + exceptionLabel());
    }

    public void removeItemDecoration(g r3) {
        h r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.a("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r3);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r4 = true;
    L11:
        setWillNotDraw(r4);
        goto L12
    L10:
        r4 = false;
        goto L11
    }

    public void removeItemDecorationAt(int r3) {
        int r0 = getItemDecorationCount();
        if (r3 < 0) goto L8;
        if (r3 >= r0) goto L8;
        removeItemDecoration(getItemDecorationAt(r3));
        return;
    L8:
        throw new IndexOutOfBoundsException(r3 + " is an invalid index for size " + r0);
    }

    public void removeOnChildAttachStateChangeListener(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        List<j> r2 = this.mOnChildAttachStateListeners;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.remove(r4);
    }

    public void removeOnItemTouchListener(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        this.mOnItemTouchListeners.remove(r4);
        if (this.mInterceptingOnItemTouchListener != r4) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    public void removeOnScrollListener(m r1) {
        List<m> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void removeRecyclerListener(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.memorydata.plugin");
        this.mRecyclerListeners.remove(r4);
    }

    void repositionShadowingViews() {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        View r2 = this.mChildHelper.b(r1);
        v r3 = getChildViewHolder(r2);
        if (r3 == null) goto L13;
        if (r3.k == null) goto L13;
        View r4 = r3.k.c;
        int r5 = r2.getLeft();
        int r6 = r2.getTop();
        if (r5 == r4.getLeft()) goto L11;
    L12:
        r4.layout(r5, r6, r4.getWidth() + r5, r4.getHeight() + r6);
        goto L13
    L11:
        if (r6 != r4.getTop()) goto L12;
    L13:
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r3, View r4) {
        if (this.mLayout.a(this, this.mState, r3, r4) == true) goto L6;
        if (r4 == null) goto L6;
        requestChildOnScreen(r3, r4);
    L6:
        super.requestChildFocus(r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r2, Rect r3, boolean r4) {
        return this.mLayout.a(this, r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r6) {
        int r0 = this.mOnItemTouchListeners.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((l) ZeusTransformUtils.preCheckCast(this.mOnItemTouchListeners.get(r1), l.class, "com.obric.memorydata.plugin")).a(r6);
        r1 = r1 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r6);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0) goto L5;
    L7:
        this.mLayoutWasDefered = true;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L7;
        super.requestLayout();
    }

    void saveOldPositions() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        v r2 = getChildViewHolderInt(this.mChildHelper.d(r1));
        if (sDebugAssertionsEnabled == false) goto L14;
        if (r2.e != (-1)) goto L14;
        if (r2.B() == true) goto L14;
        throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + exceptionLabel());
    L14:
        if (r2.l() == true) goto L16;
        r2.k();
    L16:
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.View
    public void scrollBy(int r4, int r5) {
        h r0 = this.mLayout;
        if (r0 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r1 = r0.e();
        boolean r2 = this.mLayout.f();
        if (r1 == true) goto L13;
        if (r2 == true) goto L13;
        return;
    L13:
        if (r1 == true) goto L16;
        r4 = 0;
    L16:
        if (r2 == true) goto L19;
        r5 = 0;
    L19:
        scrollByInternal(r4, r5, null, 0);
    }

    boolean scrollByInternal(int r17, int r18, MotionEvent r19, int r20) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r2 = this.mReusableIntPair;
        r2[0] = 0;
        r2[1] = 0;
        scrollStep(r17, r18, r2);
        int[] r3 = this.mReusableIntPair;
        int r4 = r3[0];
        int r5 = r3[1];
        int r12 = r17 - r4;
        int r13 = r18 - r5;
        int r14 = r5;
        int r15 = r4;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r7 = this.mReusableIntPair;
        r7[0] = 0;
        r7[1] = 0;
        dispatchNestedScroll(r15, r14, r12, r13, this.mScrollOffset, r20, r7);
        int[] r0 = this.mReusableIntPair;
        int r16 = r12 - r0[0];
        int r110 = r13 - r0[1];
        if (r0[0] == 0) goto L12;
    L15:
        boolean r1 = true;
    L16:
        int r6 = this.mLastTouchX;
        int[] r8 = this.mScrollOffset;
        this.mLastTouchX = r6 - r8[0];
        this.mLastTouchY -= r8[1];
        int[] r9 = this.mNestedOffsets;
        r9[0] = r9[0] + r8[0];
        r9[1] = r9[1] + r8[1];
        if (getOverScrollMode() == 2) goto L22;
        if (r19 == null) goto L22;
        if (MotionEventCompat.isFromSource(r19, 8194) == true) goto L22;
        pullGlows(r19.getX(), r16, r19.getY(), r110);
    L22:
        if (r15 != 0) goto L24;
        if (r14 != 0) goto L24;
    L26:
        if (awakenScrollBars() == true) goto L28;
        invalidate();
    L28:
        if (r1 == true) goto L34;
        if (r15 != 0) goto L35;
        if (r14 == 0) goto L33;
        return true;
    L33:
        return false;
    L35:
        return true;
    L34:
        return true;
    L24:
        dispatchOnScrolled(r15, r14);
        goto L26
    L12:
        if (r0[1] != 0) goto L15;
        r1 = false;
        goto L16
    L5:
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        goto L7
    }

    void scrollStep(int r5, int r6, int[] r7) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r5 == 0) goto L5;
        int r8 = this.mLayout.a(r5, this.mRecycler, this.mState);
    L6:
        if (r6 == 0) goto L8;
        int r9 = this.mLayout.b(r6, this.mRecycler, this.mState);
    L9:
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r7 == null) goto L13;
        r7[0] = r8;
        r7[1] = r9;
        return;
    L13:
        return;
    L8:
        r9 = 0;
        goto L9
    L5:
        r8 = 0;
        goto L6
    }

    @Override // android.view.View
    public void scrollTo(int r1, int r2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int r2) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        h r0 = this.mLayout;
        if (r0 != null) goto L9;
        Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.e(r2);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r2) {
        if (shouldDeferAccessibilityEvent(r2) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r2);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate r1) {
        this.mAccessibilityDelegate = r1;
        ViewCompat.setAccessibilityDelegate(this, r1);
    }

    public void setAdapter(Adapter r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r3, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setAllowClickDuringOverScrollDebugLogEnabled(boolean r1) {
        this.mRecyclerViewExt.b(r1);
    }

    public void setChildDrawingOrderCallback(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        if (r4 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r4;
        if (r4 == null) goto L8;
        boolean r5 = true;
    L9:
        setChildrenDrawingOrderEnabled(r5);
        return;
    L8:
        r5 = false;
        goto L9
    }

    boolean setChildImportantForAccessibilityInternal(v r2, int r3) {
        if (isComputingLayout() == false) goto L6;
        r2.q = r3;
        this.mPendingAccessibilityImportanceChange.add(r2);
        return false;
    L6:
        ViewCompat.setImportantForAccessibility(r2.c, r3);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r2) {
        if (r2 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r2;
        super.setClipToPadding(r2);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(d r1) {
    }

    public void setEnableOverFling(boolean r1) {
        this.mEnableOverFling = r1;
    }

    public void setHasFixedSize(boolean r1) {
        this.mHasFixedSize = r1;
    }

    public void setItemAnimator(e r3) {
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.d();
        this.mItemAnimator.a(null);
    L5:
        this.mItemAnimator = r3;
        if (r3 == null) goto L9;
        r3.a(this.mItemAnimatorListener);
        return;
    }

    public void setItemViewCacheSize(int r1) {
        this.mRecycler.a(r1);
    }

    @Deprecated
    public void setLayoutFrozen(boolean r1) {
        suppressLayout(r1);
    }

    public void setLayoutManager(h r3) {
        if (r3 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L10;
        r0.d();
    L10:
        this.mLayout.c(this.mRecycler);
        this.mLayout.b(this.mRecycler);
        this.mRecycler.a();
        if (this.mIsAttached == false) goto L13;
        this.mLayout.b(this, this.mRecycler);
    L13:
        this.mLayout.b(null);
        this.mLayout = null;
    L15:
        this.mChildHelper.a();
        this.mLayout = r3;
        if (r3 != null) goto L18;
    L24:
        this.mRecycler.b();
        requestLayout();
        return;
    L18:
        if (r3.q != null) goto L23;
        this.mLayout.b(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.c(this);
        goto L24
    L23:
        throw new IllegalArgumentException("LayoutManager " + r3 + " is already attached to a RecyclerView:" + r3.q.exceptionLabel());
    L14:
        this.mRecycler.a();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r4) {
        if (Build.VERSION.SDK_INT < 18) goto L5;
    L20:
        if (r4 != null) goto L24;
        super.setLayoutTransition(null);
        return;
    L24:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    L5:
        if (r4 != null) goto L9;
        suppressLayout(false);
        return;
    L9:
        if (r4.getAnimator(0) != null) goto L20;
        if (r4.getAnimator(1) != null) goto L20;
        if (r4.getAnimator(2) != null) goto L20;
        if (r4.getAnimator(3) != null) goto L20;
        if (r4.getAnimator(4) != null) goto L20;
        suppressLayout(true);
    }

    public void setMinFlingVelocity(int r1) {
        this.mMinFlingVelocity = r1;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r1) {
        getScrollingChildHelper().setNestedScrollingEnabled(r1);
    }

    public void setOnBounceTranslationListener(i r3) {
        this.mOnBounceTranslationListener = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        dispatchBounceTranslationChanged();
    }

    public void setOnFlingListener(k r1) {
        this.mOnFlingListener = r1;
    }

    @Deprecated
    public void setOnScrollListener(m r1) {
        this.mScrollListener = r1;
    }

    public void setPreserveFocusAfterLayout(boolean r1) {
        this.mPreserveFocusAfterLayout = r1;
    }

    public void setRecycledViewPool(n r1) {
        this.mRecycler.a(r1);
    }

    @Deprecated
    public void setRecyclerListener(p r3) {
        this.mRecyclerListener = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.memorydata.plugin");
    }

    void setScrollState(int r4) {
        if (r4 != this.mScrollState) goto L6;
        return;
    L6:
        if (sVerboseLoggingEnabled == false) goto L8;
        Log.d(TAG, "setting scroll state to " + r4 + " from " + this.mScrollState, new Exception());
    L8:
        this.mScrollState = r4;
        if (r4 == 2) goto L11;
        stopScrollersInternal();
    L11:
        dispatchOnScrollStateChanged(r4);
    }

    public void setScrollingTouchSlop(int r4) {
        ViewConfiguration r0 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r4 != 0) goto L5;
    L8:
        int r5 = r0.getScaledTouchSlop();
    L9:
        this.mTouchSlop = r5;
        return;
    L5:
        if (r4 == 1) goto L7;
        Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + r4 + "; using default value");
        goto L8
    L7:
        r5 = r0.getScaledPagingTouchSlop();
        goto L9
    }

    public void setViewCacheExtension(t r1) {
        this.mRecycler.a(r1);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent r3) {
        int r1 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r3 == null) goto L6;
        int r4 = AccessibilityEventCompat.getContentChangeTypes(r3);
    L7:
        if (r4 == 0) goto L10;
        r1 = r4;
    L10:
        this.mEatenAccessibilityChangeFlags |= r1;
        return true;
    L6:
        r4 = 0;
        goto L7
    L12:
        return false;
    }

    public void smoothScrollBy(int r2, int r3) {
        smoothScrollBy(r2, r3, null);
    }

    public void smoothScrollBy(int r3, int r4, Interpolator r5) {
        smoothScrollBy(r3, r4, (Interpolator) ZeusTransformUtils.wrapperContextForParams(r5, Interpolator.class, "com.obric.memorydata.plugin"), Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int r7, int r8, Interpolator r9, int r10) {
        smoothScrollBy(r7, r8, (Interpolator) ZeusTransformUtils.wrapperContextForParams(r9, Interpolator.class, "com.obric.memorydata.plugin"), r10, false);
    }

    void smoothScrollBy(int r4, int r5, Interpolator r6, int r7, boolean r8) {
        Interpolator r9 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r6, Interpolator.class, "com.obric.memorydata.plugin");
        h r0 = this.mLayout;
        if (r0 != null) goto L7;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r1 = 0;
        if (r0.e() == true) goto L13;
        r4 = 0;
    L13:
        if (this.mLayout.f() == true) goto L15;
        r5 = 0;
    L15:
        if (r4 != 0) goto L18;
        if (r5 != 0) goto L18;
        return;
    L18:
        if (r7 == Integer.MIN_VALUE) goto L22;
        if (r7 > 0) goto L22;
        boolean r2 = false;
    L23:
        if (r2 == false) goto L31;
        if (r8 == false) goto L30;
        if (r4 == 0) goto L27;
        r1 = 1;
    L27:
        if (r5 == 0) goto L29;
        r1 = r1 | 2;
    L29:
        startNestedScroll(r1, 1);
    L30:
        this.mViewFlinger.a(r4, r5, r7, r9);
        return;
    L31:
        scrollBy(r4, r5);
        return;
    L22:
        r2 = true;
        goto L23
    }

    public void smoothScrollToPosition(int r3) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        h r0 = this.mLayout;
        if (r0 != null) goto L9;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.a(this, this.mState, r3);
    }

    void startInterceptRequestLayout() {
        int r0 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r1) {
        return getScrollingChildHelper().startNestedScroll(r1);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r1, int r2) {
        return getScrollingChildHelper().startNestedScroll(r1, r2);
    }

    void stopInterceptRequestLayout(boolean r4) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L10;
        if (sDebugAssertionsEnabled == true) goto L8;
        this.mInterceptRequestLayoutDepth = 1;
        goto L10
    L8:
        throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + exceptionLabel());
    L10:
        if (r4 == true) goto L15;
        if (this.mLayoutSuppressed == true) goto L15;
        this.mLayoutWasDefered = false;
    L15:
        if (this.mInterceptRequestLayoutDepth != 1) goto L29;
        if (r4 == false) goto L27;
        if (this.mLayoutWasDefered == false) goto L27;
        if (this.mLayoutSuppressed == true) goto L27;
        if (this.mLayout == null) goto L27;
        if (this.mAdapter == null) goto L27;
        dispatchLayout();
    L27:
        if (this.mLayoutSuppressed == true) goto L29;
        this.mLayoutWasDefered = false;
    L29:
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r1) {
        getScrollingChildHelper().stopNestedScroll(r1);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r10) {
        if (r10 == this.mLayoutSuppressed) goto L16;
        assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
        if (r10 == true) goto L14;
        this.mLayoutSuppressed = false;
        if (this.mLayoutWasDefered == true) goto L9;
    L13:
        this.mLayoutWasDefered = false;
        return;
    L9:
        if (this.mLayout == null) goto L13;
        if (this.mAdapter == null) goto L13;
        requestLayout();
        goto L13
    L14:
        long r3 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r3, r3, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    public void swapAdapter(Adapter r2, boolean r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r2, true, r3);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    void viewRangeUpdate(int r7, int r8, Object r9) {
        int r0 = this.mChildHelper.c();
        int r1 = r7 + r8;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        View r3 = this.mChildHelper.d(r2);
        v r4 = getChildViewHolderInt(r3);
        if (r4 == null) goto L14;
        if (r4.l() == true) goto L14;
        if (r4.e < r7) goto L14;
        if (r4.e >= r1) goto L14;
        r4.b(2);
        r4.a(r9);
        ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).e = true;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        this.mRecycler.c(r7, r8);
    }
}
