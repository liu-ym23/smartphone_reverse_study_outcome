package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
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
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import com.bytedance.keva.KevaImpl;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.ttnet.org.chromium.net.NetError;
import j0.h0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements j0.l {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
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
    static final Interpolator sQuinticInterpolator = null;
    androidx.recyclerview.widget.v mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    g mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private j mChildDrawingOrderCallback;
    androidx.recyclerview.widget.b mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private k mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.m mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private s mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    l mItemAnimator;
    private l.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<n> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    o mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final x mObserver;
    private List<q> mOnChildAttachStateListeners;
    private r mOnFlingListener;
    private final ArrayList<s> mOnItemTouchListeners;
    final List<c0> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    androidx.recyclerview.widget.m.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final v mRecycler;
    w mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private t mScrollListener;
    private List<t> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private j0.m mScrollingChildHelper;
    final z mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final b0 mViewFlinger;
    private final androidx.recyclerview.widget.a0.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.a0 mViewInfoStore;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Parcelable f2270m;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            if (r10 != null) goto L6;
            r10 = o.class.getClassLoader();
        L6:
            this.f2270m = r8.readParcelable(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeParcelable(this.f2270m, 0);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2271a;

        public a(RecyclerView r8) {
            this.f2271a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r8 = this.f2271a;
            if (r8.mFirstLayoutComplete == true) goto L5;
            return;
        L5:
            if (r8.isLayoutRequested() == false) goto L8;
            return;
        L8:
            if (r8.mIsAttached == true) goto L12;
            r8.requestLayout();
            return;
        L12:
            if (r8.mLayoutSuppressed == false) goto L15;
            r8.mLayoutWasDefered = true;
            return;
        L15:
            r8.consumePendingUpdateOperations();
        }
    }

    public static abstract class a0 {
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2272a;

        public b(RecyclerView r8) {
            this.f2272a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r8 = this.f2272a;
            l r10 = r8.mItemAnimator;
            if (r10 == null) goto L42;
            androidx.recyclerview.widget.k r11 = (androidx.recyclerview.widget.k) r10;
            ArrayList<c0> r12 = r11.f2468h;
            boolean r13 = !r12.isEmpty();
            ArrayList<androidx.recyclerview.widget.k.b> r14 = r11.f2470j;
            boolean r15 = !r14.isEmpty();
            ArrayList<androidx.recyclerview.widget.k.a> r16 = r11.f2471k;
            boolean r17 = !r16.isEmpty();
            ArrayList<c0> r18 = r11.f2469i;
            boolean r19 = !r18.isEmpty();
            if (r13 == true) goto L10;
            if (r15 == true) goto L10;
            if (r19 == true) goto L10;
            if (r17 == false) goto L42;
        L10:
            Iterator<c0> r110 = r12.iterator();
        L11:
            boolean r111 = r110.hasNext();
            long r112 = r11.f2307d;
            if (r111 == false) goto L14;
            c0 r113 = r110.next();
            View r114 = r113.f2281a;
            ViewPropertyAnimator r20 = r114.animate();
            r11.f2477q.add(r113);
            r20.setDuration(r112).alpha(0.0f).setListener(new androidx.recyclerview.widget.f(r114, r20, r11, r113)).start();
            r110 = r110;
            goto L11
        L14:
            r12.clear();
            if (r15 == false) goto L20;
            ArrayList<androidx.recyclerview.widget.k.b> r21 = new ArrayList();
            r21.addAll(r14);
            r11.f2473m.add(r21);
            r14.clear();
            androidx.recyclerview.widget.c r22 = new androidx.recyclerview.widget.c(r11, r21);
            if (r13 == false) goto L19;
            View r23 = r21.get(0).f2485a.f2281a;
            WeakHashMap<View, h0> r24 = j0.w.f8437a;
            j0.w.d.n(r23, r22, r112);
            goto L20
        L19:
            r22.run();
        L20:
            if (r17 == false) goto L25;
            ArrayList<androidx.recyclerview.widget.k.a> r25 = new ArrayList();
            r25.addAll(r16);
            r11.f2474n.add(r25);
            r16.clear();
            androidx.recyclerview.widget.d r26 = new androidx.recyclerview.widget.d(r11, r25);
            if (r13 == false) goto L24;
            View r27 = r25.get(0).f2479a.f2281a;
            WeakHashMap<View, h0> r28 = j0.w.f8437a;
            j0.w.d.n(r27, r26, r112);
            goto L25
        L24:
            r26.run();
        L25:
            if (r19 == false) goto L42;
            ArrayList<c0> r29 = new ArrayList();
            r29.addAll(r18);
            r11.f2472l.add(r29);
            r18.clear();
            androidx.recyclerview.widget.e r30 = new androidx.recyclerview.widget.e(r11, r29);
            if (r13 == true) goto L32;
            if (r15 == true) goto L32;
            if (r17 == true) goto L32;
            r30.run();
        L32:
            long r31 = 0;
            if (r13 == true) goto L36;
            r112 = 0;
        L36:
            if (r15 == false) goto L38;
            long r32 = r11.f2308e;
        L39:
            if (r17 == false) goto L41;
            r31 = r11.f2309f;
        L41:
            long r33 = Math.max(r32, r31) + r112;
            View r34 = r29.get(0).f2281a;
            WeakHashMap<View, h0> r35 = j0.w.f8437a;
            j0.w.d.n(r34, r30, r33);
            goto L42
        L38:
            r32 = 0;
        L42:
            r8.mPostedAnimatorRunner = false;
        }
    }

    public class b0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2274b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public OverScroller f2275m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Interpolator f2276n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f2277o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f2278p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2279q;

        public b0(RecyclerView r8) {
            this.f2279q = r8;
            Interpolator r10 = RecyclerView.sQuinticInterpolator;
            this.f2276n = r10;
            this.f2277o = false;
            this.f2278p = false;
            this.f2275m = new OverScroller(r8.getContext(), r10);
        }

        public final void a() {
            if (this.f2277o == false) goto L5;
            this.f2278p = true;
            return;
        L5:
            RecyclerView r8 = this.f2279q;
            r8.removeCallbacks(this);
            WeakHashMap<View, h0> r10 = j0.w.f8437a;
            j0.w.d.m(r8, this);
        }

        public final void b(int r12, int r13, Interpolator r14, int r15) {
            RecyclerView r8 = this.f2279q;
            if (r15 != Integer.MIN_VALUE) goto L20;
            int r16 = Math.abs(r12);
            int r10 = Math.abs(r13);
            if (r16 <= r10) goto L7;
            boolean r11 = true;
        L8:
            int r17 = (int) Math.sqrt(0);
            int r18 = (int) Math.sqrt((r13 * r13) + (r12 * r12));
            if (r11 == false) goto L11;
            int r19 = r8.getWidth();
        L12:
            int r20 = r19 / 2;
            float r21 = r19;
            float r22 = r20;
            float r23 = (((float) Math.sin((Math.min(1.0f, (r18 * 1.0f) / r21) - 0.5f) * 0.47123894f)) * r22) + r22;
            if (r17 <= 0) goto L15;
            int r110 = Math.round(Math.abs(r23 / r17) * 1000.0f) * 4;
        L19:
            r15 = Math.min(r110, 2000);
            goto L20
        L15:
            if (r11 == true) goto L18;
            r16 = r10;
        L18:
            r110 = (int) (((r16 / r21) + 1.0f) * 300.0f);
            goto L19
        L11:
            r19 = r8.getHeight();
            goto L12
        L7:
            r11 = false;
        L20:
            int r24 = r15;
            if (r14 != null) goto L24;
            r14 = RecyclerView.sQuinticInterpolator;
        L24:
            if (this.f2276n == r14) goto L26;
            this.f2276n = r14;
            this.f2275m = new OverScroller(r8.getContext(), r14);
        L26:
            this.f2274b = 0;
            this.f2273a = 0;
            r8.setScrollState(2);
            this.f2275m.startScroll(0, 0, r12, r13, r24);
            a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r10 = this.f2279q;
            if (r10.mLayout != null) goto L6;
            r10.removeCallbacks(this);
            this.f2275m.abortAnimation();
            return;
        L6:
            this.f2278p = false;
            this.f2277o = true;
            r10.consumePendingUpdateOperations();
            OverScroller r12 = this.f2275m;
            if (r12.computeScrollOffset() == false) goto L89;
            int r8 = r12.getCurrX();
            int r11 = r12.getCurrY();
            int r13 = r8 - this.f2273a;
            int r14 = r11 - this.f2274b;
            this.f2273a = r8;
            this.f2274b = r11;
            int[] r15 = r10.mReusableIntPair;
            r15[0] = 0;
            r15[1] = 0;
            if (r10.dispatchNestedPreScroll(r13, r14, r15, null, 1) == false) goto L12;
            int[] r16 = r10.mReusableIntPair;
            r13 = r13 - r16[0];
            r14 = r14 - r16[1];
        L12:
            if (r10.getOverScrollMode() == 2) goto L15;
            r10.considerReleasingGlowsOnScroll(r13, r14);
        L15:
            if (r10.mAdapter == null) goto L30;
            int[] r17 = r10.mReusableIntPair;
            r17[0] = 0;
            r17[1] = 0;
            r10.scrollStep(r13, r14, r17);
            int[] r18 = r10.mReusableIntPair;
            int r19 = r18[0];
            int r20 = r18[1];
            int r21 = r13 - r19;
            int r22 = r14 - r20;
            y r23 = r10.mLayout.f2317e;
            if (r23 != null) goto L19;
        L29:
            int r110 = r20;
            int r111 = r19;
            int r112 = r21;
            int r113 = r22;
        L32:
            if (r10.mItemDecorations.isEmpty() == true) goto L34;
            r10.invalidate();
        L34:
            int[] r24 = r10.mReusableIntPair;
            r24[0] = 0;
            r24[1] = 0;
            r10.dispatchNestedScroll(r111, r110, r112, r113, null, 1, r24);
            int[] r25 = r10.mReusableIntPair;
            int r114 = r112 - r25[0];
            int r115 = r113 - r25[1];
            if (r111 != 0) goto L37;
            if (r110 != 0) goto L37;
        L39:
            if (RecyclerView.access$200(r10) == true) goto L42;
            r10.invalidate();
        L42:
            if (r12.getCurrX() != r12.getFinalX()) goto L44;
            boolean r26 = true;
        L46:
            if (r12.getCurrY() != r12.getFinalY()) goto L48;
            boolean r27 = true;
        L50:
            if (r12.isFinished() == true) goto L57;
            if (r26 == true) goto L53;
            if (r114 != 0) goto L53;
        L56:
            boolean r28 = false;
        L58:
            y r29 = r10.mLayout.f2317e;
            if (r29 != null) goto L61;
        L63:
            boolean r30 = false;
        L64:
            if (r30 == true) goto L86;
            if (r28 == false) goto L86;
            if (r10.getOverScrollMode() == 2) goto L81;
            int r31 = (int) r12.getCurrVelocity();
            if (r114 >= 0) goto L71;
            int r32 = -r31;
        L74:
            if (r115 >= 0) goto L76;
            r31 = -r31;
        L79:
            r10.absorbGlows(r32, r31);
            goto L81
        L76:
            if (r115 > 0) goto L79;
            r31 = 0;
            goto L79
        L71:
            if (r114 <= 0) goto L73;
            r32 = r31;
            goto L74
        L73:
            r32 = 0;
        L81:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L89;
            androidx.recyclerview.widget.m.b r33 = r10.mPrefetchRegistry;
            int[] r34 = r33.f2529c;
            if (r34 == null) goto L85;
            Arrays.fill(r34, -1);
        L85:
            r33.f2530d = 0;
        L86:
            a();
            androidx.recyclerview.widget.m r35 = r10.mGapWorker;
            if (r35 == null) goto L89;
            r35.a(r10, r111, r110);
            goto L89
        L61:
            if (r29.f2352d == false) goto L63;
            r30 = true;
        L53:
            if (r27 == true) goto L57;
            if (r115 == 0) goto L56;
        L57:
            r28 = true;
            goto L58
        L48:
            r27 = false;
            goto L50
        L44:
            r26 = false;
        L37:
            r10.dispatchOnScrolled(r111, r110);
            goto L39
        L19:
            if (r23.f2352d == true) goto L29;
            if (r23.f2353e == false) goto L29;
            int r36 = r10.mState.b();
            if (r36 != 0) goto L26;
            r23.d();
            goto L29
        L26:
            if (r23.f2349a < r36) goto L28;
            r23.f2349a = r36 - 1;
        L28:
            r23.b(r19, r20);
            goto L29
        L30:
            r112 = r13;
            r113 = r14;
            r110 = 0;
            r111 = 0;
        L89:
            y r37 = r10.mLayout.f2317e;
            if (r37 != null) goto L92;
        L94:
            this.f2277o = false;
            if (this.f2278p == false) goto L97;
            r10.removeCallbacks(this);
            WeakHashMap<View, h0> r38 = j0.w.f8437a;
            j0.w.d.m(r10, this);
            return;
        L97:
            r10.setScrollState(0);
            r10.stopNestedScroll(1);
            return;
        L92:
            if (r37.f2352d == false) goto L94;
            r37.b(0, 0);
            goto L94
        }
    }

    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r8) {
            float r10 = r8 - 1.0f;
            return ((((r10 * r10) * r10) * r10) * r10) + 1.0f;
        }
    }

    public static abstract class c0 {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final List<Object> f2280s = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f2281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<RecyclerView> f2282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f2285e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2286f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2287g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c0 f2288h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public c0 f2289i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2290j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ArrayList f2291k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<Object> f2292l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2293m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public v f2294n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f2295o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f2296p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f2297q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public RecyclerView f2298r;

        static {
            f2280s = Collections.emptyList();
        }

        public c0(View r8) {
            this.f2283c = -1;
            this.f2284d = -1;
            this.f2285e = -1;
            this.f2286f = -1;
            this.f2287g = -1;
            this.f2288h = null;
            this.f2289i = null;
            this.f2291k = null;
            this.f2292l = null;
            this.f2293m = 0;
            this.f2294n = null;
            this.f2295o = false;
            this.f2296p = 0;
            this.f2297q = -1;
            if (r8 == null) goto L7;
            this.f2281a = r8;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        public final void a(Object r8) {
            if (r8 != null) goto L6;
            b(1024);
            return;
        L6:
            if ((1024 & this.f2290j) == 0) goto L8;
            return;
        L8:
            if (this.f2291k != null) goto L10;
            ArrayList r10 = new ArrayList();
            this.f2291k = r10;
            this.f2292l = Collections.unmodifiableList(r10);
        L10:
            this.f2291k.add(r8);
        }

        public final void b(int r8) {
            this.f2290j = r8 | this.f2290j;
        }

        public final int c() {
            int r8 = this.f2287g;
            if (r8 == (-1)) goto L5;
            return r8;
        L5:
            return this.f2283c;
        }

        public final List<Object> d() {
            if ((this.f2290j & 1024) != 0) goto L12;
            ArrayList r8 = this.f2291k;
            if (r8 == null) goto L12;
            if (r8.size() == 0) goto L12;
            return this.f2292l;
        L12:
            return f2280s;
        }

        public final boolean e() {
            View r8 = this.f2281a;
            if (r8.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (r8.getParent() == this.f2298r) goto L7;
            return true;
        }

        public final boolean f() {
            if ((this.f2290j & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean g() {
            if ((this.f2290j & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean h() {
            if ((this.f2290j & 16) != 0) goto L7;
            WeakHashMap<View, h0> r8 = j0.w.f8437a;
            if (j0.w.d.i(this.f2281a) == true) goto L7;
            return true;
        L7:
            return false;
        }

        public final boolean i() {
            if ((this.f2290j & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean j() {
            if (this.f2294n == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean k() {
            if ((this.f2290j & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final void l(int r8, boolean r10) {
            if (this.f2284d != (-1)) goto L6;
            this.f2284d = this.f2283c;
        L6:
            if (this.f2287g != (-1)) goto L8;
            this.f2287g = this.f2283c;
        L8:
            if (r10 == false) goto L10;
            this.f2287g += r8;
        L10:
            this.f2283c += r8;
            View r11 = this.f2281a;
            if (r11.getLayoutParams() == null) goto L14;
            ((p) r11.getLayoutParams()).mInsetsDirty = true;
            return;
        }

        public final void m() {
            this.f2290j = 0;
            this.f2283c = -1;
            this.f2284d = -1;
            this.f2285e = -1;
            this.f2287g = -1;
            this.f2293m = 0;
            this.f2288h = null;
            this.f2289i = null;
            ArrayList r8 = this.f2291k;
            if (r8 == null) goto L5;
            r8.clear();
        L5:
            this.f2290j &= -1025;
            this.f2296p = 0;
            this.f2297q = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public final void n(boolean r8) {
            int r10 = this.f2293m;
            if (r8 == false) goto L5;
            int r11 = r10 - 1;
        L6:
            this.f2293m = r11;
            if (r11 >= 0) goto L9;
            this.f2293m = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        L9:
            if (r8 == true) goto L13;
            if (r11 != 1) goto L13;
            int r12 = this.f2290j | 16;
        L12:
            this.f2290j = r12;
            return;
        L13:
            if (r8 == false) goto L18;
            if (r11 != 0) goto L19;
            r12 = this.f2290j & (-17);
            goto L12
        L19:
            return;
        L18:
            return;
        L5:
            r11 = r10 + 1;
            goto L6
        }

        public final boolean o() {
            if ((this.f2290j & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean p() {
            if ((this.f2290j & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r8 = "ViewHolder";
        L6:
            StringBuilder r10 = android.aimedia.a.k(r8, "{");
            r10.append(Integer.toHexString(hashCode()));
            r10.append(" position=");
            r10.append(this.f2283c);
            r10.append(" id=");
            r10.append(this.f2285e);
            r10.append(", oldPos=");
            r10.append(this.f2284d);
            r10.append(", pLpos:");
            r10.append(this.f2287g);
            StringBuilder r11 = new StringBuilder(r10.toString());
            if (j() == false) goto L14;
            r11.append(" scrap ");
            if (this.f2295o == false) goto L11;
            String r12 = "[changeScrap]";
        L12:
            r11.append(r12);
            goto L14
        L11:
            r12 = "[attachedScrap]";
        L14:
            if (g() == false) goto L17;
            r11.append(" invalid");
        L17:
            if (f() == true) goto L19;
            r11.append(" unbound");
        L19:
            boolean r13 = true;
            if ((this.f2290j & 2) == 0) goto L22;
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            r11.append(" update");
        L26:
            if (i() == false) goto L29;
            r11.append(" removed");
        L29:
            if (o() == false) goto L32;
            r11.append(" ignored");
        L32:
            if (k() == false) goto L35;
            r11.append(" tmpDetached");
        L35:
            if (h() == true) goto L38;
            r11.append(" not recyclable(" + this.f2293m + ")");
        L38:
            if ((this.f2290j & 512) == 0) goto L40;
        L43:
            if (r13 == false) goto L46;
            r11.append(" undefined adapter position");
        L46:
            if (this.f2281a.getParent() != null) goto L48;
            r11.append(" no parent");
        L48:
            r11.append("}");
            return r11.toString();
        L40:
            if (g() == true) goto L43;
            r13 = false;
            goto L43
        L22:
            r14 = false;
            goto L23
        L5:
            r8 = getClass().getSimpleName();
            goto L6
        }
    }

    public class d implements androidx.recyclerview.widget.a0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2299a;

        public d(RecyclerView r8) {
            this.f2299a = r8;
        }
    }

    public class e implements androidx.recyclerview.widget.b.InterfaceC0021b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2300a;

        public e(RecyclerView r8) {
            this.f2300a = r8;
        }

        public final int a() {
            return this.f2300a.getChildCount();
        }

        public final void b(int r8) {
            RecyclerView r10 = this.f2300a;
            View r11 = r10.getChildAt(r8);
            if (r11 == null) goto L5;
            r10.dispatchChildDetached(r11);
            r11.clearAnimation();
        L5:
            r10.removeViewAt(r8);
        }
    }

    public class f implements androidx.recyclerview.widget.a.InterfaceC0020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2301a;

        public f(RecyclerView r8) {
            this.f2301a = r8;
        }

        public final void a(androidx.recyclerview.widget.a.b r8) {
            int r10 = r8.f2424a;
            RecyclerView r11 = this.f2301a;
            if (r10 != 1) goto L5;
            r11.mLayout.V(r8.f2425b, r8.f2427d);
            return;
        L5:
            if (r10 != 2) goto L7;
            r11.mLayout.Y(r8.f2425b, r8.f2427d);
            return;
        L7:
            if (r10 != 4) goto L9;
            r11.mLayout.Z(r8.f2425b, r8.f2427d);
            return;
        L9:
            if (r10 != 8) goto L19;
            r11.mLayout.X(r8.f2425b, r8.f2427d);
            return;
        }
    }

    public static abstract class g<VH extends c0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f2302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2303b;

        public g() {
            this.f2302a = new h();
            this.f2303b = false;
        }

        public abstract int a();

        public long b(int r8) {
            return -1;
        }

        public abstract void c(VH r8, int r10);

        public abstract c0 d(RecyclerView r8);
    }

    public static class h extends Observable<i> {
        public final boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void b() {
            int r8 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r8 < 0) goto L5;
            ((i) ((Observable) this).mObservers.get(r8)).a();
            r8 = r8 - 1;
            goto L3
        }
    }

    public static abstract class i {
        public i() {
        }

        public void a() {
        }
    }

    public interface j {
    }

    public static class k {
    }

    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f2304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<a> f2305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f2307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f2308e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f2309f;

        public interface a {
            void a();
        }

        public interface b {
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2310a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2311b;

            public final void a(c0 r8) {
                View r10 = r8.f2281a;
                this.f2310a = r10.getLeft();
                this.f2311b = r10.getTop();
                r10.getRight();
                r10.getBottom();
            }
        }

        public l() {
            this.f2304a = null;
            this.f2305b = new ArrayList();
            this.f2306c = 120;
            this.f2307d = 120;
            this.f2308e = 250;
            this.f2309f = 250;
        }

        public static void b(c0 r8) {
            int r10 = r8.f2290j & 14;
            if (r8.g() == false) goto L6;
            return;
        L6:
            if ((r10 & 4) != 0) goto L12;
            RecyclerView r11 = r8.f2298r;
            if (r11 == null) goto L13;
            r11.getAdapterPositionFor(r8);
            return;
        L13:
            return;
        }

        public abstract boolean a(c0 r8, c0 r10, c r11, c r12);

        public final void c(c0 r8) {
            b r10 = this.f2304a;
            if (r10 == null) goto L20;
            m r11 = (m) r10;
            r11.getClass();
            boolean r12 = true;
            r8.n(true);
            if (r8.f2288h != null) goto L7;
        L9:
            r8.f2289i = null;
            if ((r8.f2290j & 16) != 0) goto L13;
            r12 = false;
        L13:
            if (r12 == true) goto L21;
            RecyclerView r13 = r11.f2312a;
            View r14 = r8.f2281a;
            if (r13.removeAnimatingView(r14) == false) goto L17;
            return;
        L17:
            if (r8.k() == false) goto L23;
            r13.removeDetachedView(r14, false);
            return;
        L23:
            return;
        L21:
            return;
        L7:
            if (r8.f2289i != null) goto L9;
            r8.f2288h = null;
            goto L9
        }

        public abstract void d(c0 r8);

        public abstract void e();

        public abstract boolean f();
    }

    public class m implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2312a;

        public m(RecyclerView r8) {
            this.f2312a = r8;
        }
    }

    public static abstract class n {
        public n() {
        }

        public void d(Canvas r8, RecyclerView r10) {
        }

        public void e(Canvas r8, RecyclerView r10) {
        }
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.b f2313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f2314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.recyclerview.widget.z f2315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.recyclerview.widget.z f2316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public y f2317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f2320h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f2321i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2322j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f2323k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f2324l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2325m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2326n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f2327o;

        public class a implements androidx.recyclerview.widget.z.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f2328a;

            public a(o r8) {
                this.f2328a = r8;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int a(View r8) {
                p r10 = (p) r8.getLayoutParams();
                this.f2328a.getClass();
                return (r8.getLeft() - ((p) r8.getLayoutParams()).mDecorInsets.left) - ((ViewGroup.MarginLayoutParams) r10).leftMargin;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int b() {
                return this.f2328a.D();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int c() {
                o r8 = this.f2328a;
                return r8.f2326n - r8.E();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final View d(int r8) {
                return this.f2328a.v(r8);
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int e(View r8) {
                p r10 = (p) r8.getLayoutParams();
                this.f2328a.getClass();
                return (r8.getRight() + ((p) r8.getLayoutParams()).mDecorInsets.right) + ((ViewGroup.MarginLayoutParams) r10).rightMargin;
            }
        }

        public class b implements androidx.recyclerview.widget.z.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f2329a;

            public b(o r8) {
                this.f2329a = r8;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int a(View r8) {
                p r10 = (p) r8.getLayoutParams();
                this.f2329a.getClass();
                return (r8.getTop() - ((p) r8.getLayoutParams()).mDecorInsets.top) - ((ViewGroup.MarginLayoutParams) r10).topMargin;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int b() {
                return this.f2329a.F();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int c() {
                o r8 = this.f2329a;
                return r8.f2327o - r8.C();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final View d(int r8) {
                return this.f2329a.v(r8);
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int e(View r8) {
                p r10 = (p) r8.getLayoutParams();
                this.f2329a.getClass();
                return (r8.getBottom() + ((p) r8.getLayoutParams()).mDecorInsets.bottom) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
            }
        }

        public interface c {
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2330a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2331b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f2332c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f2333d;
        }

        public o() {
            a r8 = new a(this);
            b r10 = new b(this);
            this.f2315c = new androidx.recyclerview.widget.z(r8);
            this.f2316d = new androidx.recyclerview.widget.z(r10);
            this.f2318f = false;
            this.f2319g = false;
            this.f2320h = true;
            this.f2321i = true;
        }

        public static int G(View r8) {
            return ((p) r8.getLayoutParams()).getViewLayoutPosition();
        }

        public static d H(Context r8, AttributeSet r10, int r11, int r12) {
            d r13 = new d();
            TypedArray r14 = r8.obtainStyledAttributes(r10, w0.a.f12951a, r11, r12);
            r13.f2330a = r14.getInt(0, 1);
            r13.f2331b = r14.getInt(10, 1);
            r13.f2332c = r14.getBoolean(9, false);
            r13.f2333d = r14.getBoolean(11, false);
            r14.recycle();
            return r13;
        }

        public static boolean L(int r8, int r10, int r11) {
            int r12 = View.MeasureSpec.getMode(r10);
            int r13 = View.MeasureSpec.getSize(r10);
            if (r11 <= 0) goto L7;
            if (r8 == r11) goto L7;
            return false;
        L7:
            if (r12 == Integer.MIN_VALUE) goto L16;
            if (r12 != 0) goto L10;
            return true;
        L10:
            if (r12 == 1073741824) goto L12;
            return false;
        L12:
            if (r13 == r8) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r13 >= r8) goto L18;
            return false;
        L18:
            return true;
        }

        public static void M(View r8, int r10, int r11, int r12, int r13) {
            p r14 = (p) r8.getLayoutParams();
            Rect r15 = r14.mDecorInsets;
            r8.layout((r10 + r15.left) + ((ViewGroup.MarginLayoutParams) r14).leftMargin, (r11 + r15.top) + ((ViewGroup.MarginLayoutParams) r14).topMargin, (r12 - r15.right) - ((ViewGroup.MarginLayoutParams) r14).rightMargin, (r13 - r15.bottom) - ((ViewGroup.MarginLayoutParams) r14).bottomMargin);
        }

        public static int h(int r8, int r10, int r11) {
            int r12 = View.MeasureSpec.getMode(r8);
            int r13 = View.MeasureSpec.getSize(r8);
            if (r12 == Integer.MIN_VALUE) goto L9;
            if (r12 != 1073741824) goto L7;
            return r13;
        L7:
            return Math.max(r10, r11);
        L9:
            return Math.min(r13, Math.max(r10, r11));
        }

        public static int x(int r8, int r10, int r11, boolean r12, int r13) {
            int r14 = Math.max(0, r8 - r11);
            if (r12 == false) goto L11;
            if (r13 >= 0) goto L12;
            if (r13 != (-1)) goto L21;
            if (r10 == Integer.MIN_VALUE) goto L14;
            if (r10 == 0) goto L21;
            if (r10 != 1073741824) goto L21;
        L14:
            r13 = r14;
        L23:
            return View.MeasureSpec.makeMeasureSpec(r13, r10);
        L21:
            r10 = 0;
            r13 = 0;
        L12:
            r10 = 1073741824;
            goto L23
        L11:
            if (r13 >= 0) goto L12;
            if (r13 == (-1)) goto L14;
            if (r13 != (-2)) goto L21;
            if (r10 == Integer.MIN_VALUE) goto L20;
            if (r10 == 1073741824) goto L20;
            r13 = r14;
            r10 = 0;
        L20:
            r13 = r14;
            r10 = Integer.MIN_VALUE;
            goto L23
        }

        public final int A() {
            RecyclerView r8 = this.f2314b;
            if (r8 == null) goto L5;
            g r10 = r8.getAdapter();
        L6:
            if (r10 != null) goto L10;
            return 0;
        L10:
            return r10.a();
        L5:
            r10 = null;
            goto L6
        }

        public final int B() {
            RecyclerView r8 = this.f2314b;
            WeakHashMap<View, h0> r10 = j0.w.f8437a;
            return j0.w.e.d(r8);
        }

        public final int C() {
            RecyclerView r8 = this.f2314b;
            if (r8 != null) goto L7;
            return 0;
        L7:
            return r8.getPaddingBottom();
        }

        public final int D() {
            RecyclerView r8 = this.f2314b;
            if (r8 != null) goto L7;
            return 0;
        L7:
            return r8.getPaddingLeft();
        }

        public final int E() {
            RecyclerView r8 = this.f2314b;
            if (r8 != null) goto L7;
            return 0;
        L7:
            return r8.getPaddingRight();
        }

        public final int F() {
            RecyclerView r8 = this.f2314b;
            if (r8 != null) goto L7;
            return 0;
        L7:
            return r8.getPaddingTop();
        }

        public int I(v r8, z r10) {
            RecyclerView r11 = this.f2314b;
            if (r11 != null) goto L5;
            return 1;
        L5:
            if (r11.mAdapter != null) goto L8;
            return 1;
        L8:
            if (f() == true) goto L10;
            return 1;
        L10:
            return this.f2314b.mAdapter.a();
        }

        public final void J(View r8, Rect r10) {
            Rect r11 = ((p) r8.getLayoutParams()).mDecorInsets;
            r10.set(-r11.left, -r11.top, r8.getWidth() + r11.right, r8.getHeight() + r11.bottom);
            if (this.f2314b == null) goto L9;
            Matrix r12 = r8.getMatrix();
            if (r12 == null) goto L9;
            if (r12.isIdentity() == true) goto L9;
            RectF r13 = this.f2314b.mTempRectF;
            r13.set(r10);
            r12.mapRect(r13);
            r10.set((int) Math.floor(r13.left), (int) Math.floor(r13.top), (int) Math.ceil(r13.right), (int) Math.ceil(r13.bottom));
        L9:
            r10.offset(r8.getLeft(), r8.getTop());
        }

        public boolean K() {
            return false;
        }

        public void N(int r8) {
            RecyclerView r10 = this.f2314b;
            if (r10 == null) goto L6;
            r10.offsetChildrenHorizontal(r8);
            return;
        }

        public void O(int r8) {
            RecyclerView r10 = this.f2314b;
            if (r10 == null) goto L6;
            r10.offsetChildrenVertical(r8);
            return;
        }

        public void P(RecyclerView r8) {
        }

        public void Q(RecyclerView r8) {
        }

        public View R(View r8, int r10, v r11, z r12) {
            return null;
        }

        public void S(AccessibilityEvent r8) {
            RecyclerView r10 = this.f2314b;
            v r11 = r10.mRecycler;
            z r12 = r10.mState;
            if (r10 == null) goto L20;
            if (r8 == null) goto L22;
            boolean r13 = true;
            if (r10.canScrollVertically(1) == false) goto L9;
        L16:
            r8.setScrollable(r13);
            g r14 = this.f2314b.mAdapter;
            if (r14 == null) goto L21;
            r8.setItemCount(r14.a());
            return;
        L21:
            return;
        L9:
            if (this.f2314b.canScrollVertically(-1) == true) goto L16;
            if (this.f2314b.canScrollHorizontally(-1) == true) goto L16;
            if (this.f2314b.canScrollHorizontally(1) == true) goto L16;
            r13 = false;
            goto L16
        L22:
            return;
        }

        public final void T(View r8, k0.f r10) {
            c0 r11 = RecyclerView.getChildViewHolderInt(r8);
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.i() == false) goto L7;
            return;
        L7:
            if (this.f2313a.j(r11.f2281a) == true) goto L12;
            RecyclerView r12 = this.f2314b;
            U(r12.mRecycler, r12.mState, r8, r10);
            return;
        }

        public void U(v r8, z r10, View r11, k0.f r12) {
            if (f() == false) goto L5;
            int r13 = G(r11);
        L7:
            if (e() == false) goto L9;
            int r14 = G(r11);
        L10:
            r12.h(k0.f.c.a(r13, 1, r14, 1, false));
            return;
        L9:
            r14 = 0;
            goto L10
        L5:
            r13 = 0;
            goto L7
        }

        public void V(int r8, int r10) {
        }

        public void W() {
        }

        public void X(int r8, int r10) {
        }

        public void Y(int r8, int r10) {
        }

        public void Z(int r8, int r10) {
        }

        public void a0(v r8, z r10) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public final void b(View r10, int r11, boolean r12) {
            c0 r8 = RecyclerView.getChildViewHolderInt(r10);
            if (r12 == false) goto L5;
        L8:
            n.h<c0, androidx.recyclerview.widget.a0.a> r13 = this.f2314b.mViewInfoStore.f2428a;
            androidx.recyclerview.widget.a0.a r14 = r13.getOrDefault(r8, null);
            if (r14 != null) goto L11;
            r14 = androidx.recyclerview.widget.a0.a.a();
            r13.put(r8, r14);
        L11:
            r14.f2431a |= 1;
        L12:
            p r15 = (p) r10.getLayoutParams();
            if (r8.p() == true) goto L52;
            if (r8.j() == true) goto L52;
            if (r10.getParent() != this.f2314b) goto L44;
            androidx.recyclerview.widget.b r16 = this.f2313a;
            int r17 = ((e) r16.f2434a).f2300a.indexOfChild(r10);
            if (r17 == (-1)) goto L24;
            androidx.recyclerview.widget.b.a r18 = r16.f2435b;
            if (r18.d(r17) == true) goto L24;
            int r19 = r17 - r18.b(r17);
        L26:
            if (r11 != (-1)) goto L28;
            r11 = this.f2313a.e();
        L28:
            if (r19 == (-1)) goto L42;
            if (r19 == r11) goto L57;
            o r20 = this.f2314b.mLayout;
            View r21 = r20.v(r19);
            if (r21 == null) goto L41;
            r20.v(r19);
            r20.f2313a.c(r19);
            p r22 = (p) r21.getLayoutParams();
            c0 r23 = RecyclerView.getChildViewHolderInt(r21);
            if (r23.i() == false) goto L38;
            n.h<c0, androidx.recyclerview.widget.a0.a> r24 = r20.f2314b.mViewInfoStore.f2428a;
            androidx.recyclerview.widget.a0.a r25 = r24.getOrDefault(r23, null);
            if (r25 != null) goto L37;
            r25 = androidx.recyclerview.widget.a0.a.a();
            r24.put(r23, r25);
        L37:
            r25.f2431a = 1 | r25.f2431a;
        L39:
            r20.f2313a.b(r21, r11, r22, r23.i());
            goto L57
        L38:
            r20.f2314b.mViewInfoStore.c(r23);
            goto L39
        L41:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r19 + r20.f2314b.toString());
        L57:
            if (r15.mPendingInvalidate == false) goto L60;
            r8.f2281a.invalidate();
            r15.mPendingInvalidate = false;
            return;
        L60:
            return;
        L42:
            StringBuilder r110 = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            r110.append(this.f2314b.indexOfChild(r10));
            throw new IllegalStateException(android.aimedia.a.b(this.f2314b, r110));
        L24:
            r19 = -1;
            goto L26
        L44:
            this.f2313a.a(r10, r11, false);
            r15.mInsetsDirty = true;
            y r26 = this.f2317e;
            if (r26 == null) goto L57;
            if (r26.f2353e == false) goto L57;
            if (r26.f2350b.getChildLayoutPosition(r10) != r26.f2349a) goto L57;
            r26.f2354f = r10;
        L52:
            if (r8.j() == false) goto L54;
            r8.f2294n.l(r8);
        L55:
            this.f2313a.b(r10, r11, r10.getLayoutParams(), false);
            goto L57
        L54:
            r8.f2290j &= -33;
            goto L55
        L5:
            if (r8.i() == true) goto L8;
            this.f2314b.mViewInfoStore.c(r8);
            goto L12
        }

        public void b0(z r8) {
        }

        public void c(String r8) {
            RecyclerView r10 = this.f2314b;
            if (r10 == null) goto L6;
            r10.assertNotInLayoutOrScroll(r8);
            return;
        }

        public void c0(Parcelable r8) {
        }

        public final void d(View r8, Rect r10) {
            RecyclerView r11 = this.f2314b;
            if (r11 != null) goto L6;
            r10.set(0, 0, 0, 0);
            return;
        L6:
            r10.set(r11.getItemDecorInsetsForChild(r8));
        }

        public Parcelable d0() {
            return null;
        }

        public boolean e() {
            return false;
        }

        public void e0(int r8) {
        }

        public boolean f() {
            return false;
        }

        public final void f0(v r8) {
            int r10 = w();
        L3:
            r10 = r10 - 1;
            if (r10 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(v(r10)).o() == true) goto L3;
            View r11 = v(r10);
            i0(r10);
            r8.h(r11);
            goto L3
        }

        public boolean g(p r8) {
            if (r8 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public final void g0(v r8) {
            int r10 = r8.f2340a.size();
            int r11 = r10 - 1;
        L3:
            ArrayList<c0> r12 = r8.f2340a;
            if (r11 < 0) goto L16;
            View r13 = r12.get(r11).f2281a;
            c0 r14 = RecyclerView.getChildViewHolderInt(r13);
            if (r14.o() == true) goto L15;
            r14.n(false);
            if (r14.k() == false) goto L11;
            this.f2314b.removeDetachedView(r13, false);
        L11:
            l r15 = this.f2314b.mItemAnimator;
            if (r15 == null) goto L14;
            r15.d(r14);
        L14:
            r14.n(true);
            c0 r16 = RecyclerView.getChildViewHolderInt(r13);
            r16.f2294n = null;
            r16.f2295o = false;
            r16.f2290j &= -33;
            r8.i(r16);
        L15:
            r11 = r11 - 1;
            goto L3
        L16:
            r12.clear();
            ArrayList<c0> r17 = r8.f2341b;
            if (r17 == null) goto L19;
            r17.clear();
        L19:
            if (r10 <= 0) goto L25;
            this.f2314b.invalidate();
            return;
        }

        public final void h0(View r8, v r10) {
            androidx.recyclerview.widget.b r11 = this.f2313a;
            e r12 = (e) r11.f2434a;
            int r13 = r12.f2300a.indexOfChild(r8);
            if (r13 >= 0) goto L6;
        L9:
            r10.h(r8);
            return;
        L6:
            if (r11.f2435b.f(r13) == false) goto L8;
            r11.k(r8);
        L8:
            r12.b(r13);
            goto L9
        }

        public void i(int r8, int r10, z r11, c r12) {
        }

        public final void i0(int r8) {
            if (v(r8) == null) goto L12;
            androidx.recyclerview.widget.b r10 = this.f2313a;
            int r11 = r10.f(r8);
            e r12 = (e) r10.f2434a;
            View r13 = r12.f2300a.getChildAt(r11);
            if (r13 != null) goto L8;
            return;
        L8:
            if (r10.f2435b.f(r11) == false) goto L10;
            r10.k(r13);
        L10:
            r12.b(r11);
            return;
        }

        public void j(int r8, c r10) {
        }

        public boolean j0(RecyclerView r10, View r11, Rect r12, boolean r13, boolean r14) {
            int r8 = D();
            int r15 = F();
            int r16 = this.f2326n - E();
            int r17 = this.f2327o - C();
            int r18 = (r11.getLeft() + r12.left) - r11.getScrollX();
            int r19 = (r11.getTop() + r12.top) - r11.getScrollY();
            int r110 = r12.width() + r18;
            int r111 = r12.height() + r19;
            int r20 = r18 - r8;
            int r21 = Math.min(0, r20);
            int r22 = r19 - r15;
            int r23 = Math.min(0, r22);
            int r112 = r110 - r16;
            int r24 = Math.max(0, r112);
            int r113 = Math.max(0, r111 - r17);
            if (B() != 1) goto L7;
            if (r24 != 0) goto L11;
            r24 = Math.max(r21, r112);
        L11:
            if (r23 != 0) goto L14;
            r23 = Math.min(r22, r113);
        L14:
            if (r14 == false) goto L29;
            View r114 = r10.getFocusedChild();
            if (r114 != null) goto L18;
        L17:
            boolean r25 = false;
        L28:
            if (r25 == true) goto L29;
        L32:
            return false;
        L18:
            int r115 = D();
            int r116 = F();
            int r26 = this.f2326n - E();
            int r27 = this.f2327o - C();
            Rect r28 = this.f2314b.mTempRect;
            z(r114, r28);
            if ((r28.left - r24) >= r26) goto L17;
            if ((r28.right - r24) <= r115) goto L17;
            if ((r28.top - r23) >= r27) goto L17;
            if ((r28.bottom - r23) <= r116) goto L17;
            r25 = true;
        L29:
            if (r24 != 0) goto L33;
            if (r23 == 0) goto L32;
        L33:
            if (r13 == false) goto L35;
            r10.scrollBy(r24, r23);
        L36:
            return true;
        L35:
            r10.smoothScrollBy(r24, r23);
            goto L36
        L7:
            if (r21 != 0) goto L10;
            r21 = Math.min(r20, r24);
        L10:
            r24 = r21;
            goto L11
        }

        public int k(z r8) {
            return 0;
        }

        public final void k0() {
            RecyclerView r8 = this.f2314b;
            if (r8 == null) goto L6;
            r8.requestLayout();
            return;
        }

        public int l(z r8) {
            return 0;
        }

        public int l0(int r8, v r10, z r11) {
            return 0;
        }

        public int m(z r8) {
            return 0;
        }

        public void m0(int r8) {
        }

        public int n(z r8) {
            return 0;
        }

        public int n0(int r8, v r10, z r11) {
            return 0;
        }

        public int o(z r8) {
            return 0;
        }

        public final void o0(RecyclerView r8) {
            p0(View.MeasureSpec.makeMeasureSpec(r8.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r8.getHeight(), 1073741824));
        }

        public int p(z r8) {
            return 0;
        }

        public final void p0(int r8, int r10) {
            this.f2326n = View.MeasureSpec.getSize(r8);
            int r11 = View.MeasureSpec.getMode(r8);
            this.f2324l = r11;
            if (r11 == 0) goto L5;
        L7:
            this.f2327o = View.MeasureSpec.getSize(r10);
            int r12 = View.MeasureSpec.getMode(r10);
            this.f2325m = r12;
            if (r12 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L14;
            this.f2327o = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L7;
            this.f2326n = 0;
            goto L7
        }

        public final void q(v r8) {
            int r10 = w();
        L3:
            r10 = r10 - 1;
            if (r10 < 0) goto L16;
            View r11 = v(r10);
            c0 r12 = RecyclerView.getChildViewHolderInt(r11);
            if (r12.o() == true) goto L3;
            if (r12.g() == false) goto L15;
            if (r12.i() == true) goto L15;
            if (this.f2314b.mAdapter.f2303b == true) goto L15;
            i0(r10);
            r8.i(r12);
        L15:
            v(r10);
            this.f2313a.c(r10);
            r8.j(r11);
            this.f2314b.mViewInfoStore.c(r12);
            goto L3
        }

        public void q0(int r8, int r10, Rect r11) {
            int r12 = r11.width();
            int r13 = D() + r12;
            int r14 = E() + r13;
            int r15 = r11.height();
            int r16 = F() + r15;
            int r17 = C() + r16;
            RecyclerView r18 = this.f2314b;
            WeakHashMap<View, h0> r19 = j0.w.f8437a;
            int r20 = h(r8, r14, j0.w.d.e(r18));
            int r21 = h(r10, r17, j0.w.d.d(this.f2314b));
            RecyclerView.access$300(this.f2314b, r20, r21);
        }

        public View r(int r8) {
            int r10 = w();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L17;
            View r12 = v(r11);
            c0 r13 = RecyclerView.getChildViewHolderInt(r12);
            if (r13 == null) goto L16;
            if (r13.c() != r8) goto L16;
            if (r13.o() == true) goto L16;
            if (this.f2314b.mState.f2370g == true) goto L15;
            if (r13.i() == true) goto L16;
        L15:
            return r12;
        L16:
            r11 = r11 + 1;
            goto L3
        L17:
            return null;
        }

        public final void r0(int r10, int r11) {
            int r8 = w();
            if (r8 != 0) goto L6;
            this.f2314b.defaultOnMeasure(r10, r11);
            return;
        L6:
            int r12 = Integer.MIN_VALUE;
            int r13 = Integer.MAX_VALUE;
            int r14 = 0;
            int r15 = Integer.MIN_VALUE;
            int r16 = Integer.MAX_VALUE;
        L7:
            if (r14 >= r8) goto L21;
            View r17 = v(r14);
            Rect r18 = this.f2314b.mTempRect;
            z(r17, r18);
            int r19 = r18.left;
            if (r19 >= r16) goto L11;
            r16 = r19;
        L11:
            int r20 = r18.right;
            if (r20 <= r12) goto L14;
            r12 = r20;
        L14:
            int r21 = r18.top;
            if (r21 >= r13) goto L17;
            r13 = r21;
        L17:
            int r22 = r18.bottom;
            if (r22 <= r15) goto L20;
            r15 = r22;
        L20:
            r14 = r14 + 1;
            goto L7
        L21:
            this.f2314b.mTempRect.set(r16, r13, r12, r15);
            q0(r10, r11, this.f2314b.mTempRect);
        }

        public abstract p s();

        public final void s0(RecyclerView r8) {
            if (r8 != null) goto L4;
            this.f2314b = null;
            this.f2313a = null;
            int r10 = 0;
            this.f2326n = 0;
        L5:
            this.f2327o = r10;
            this.f2324l = 1073741824;
            this.f2325m = 1073741824;
            return;
        L4:
            this.f2314b = r8;
            this.f2313a = r8.mChildHelper;
            this.f2326n = r8.getWidth();
            r10 = r8.getHeight();
            goto L5
        }

        public p t(Context r8, AttributeSet r10) {
            return new p(r8, r10);
        }

        public final boolean t0(View r8, int r10, int r11, p r12) {
            if (r8.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.f2320h == false) goto L12;
            if (L(r8.getWidth(), r10, ((ViewGroup.MarginLayoutParams) r12).width) == false) goto L12;
            if (L(r8.getHeight(), r11, ((ViewGroup.MarginLayoutParams) r12).height) == false) goto L12;
            return false;
        }

        public p u(ViewGroup.LayoutParams r8) {
            if ((r8 instanceof p) == false) goto L7;
            return new p((p) r8);
        L7:
            if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new p((ViewGroup.MarginLayoutParams) r8);
        L11:
            return new p(r8);
        }

        public boolean u0() {
            return false;
        }

        public final View v(int r8) {
            androidx.recyclerview.widget.b r10 = this.f2313a;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.d(r8);
        }

        public final boolean v0(View r8, int r10, int r11, p r12) {
            if (this.f2320h == true) goto L5;
        L10:
            return true;
        L5:
            if (L(r8.getMeasuredWidth(), r10, ((ViewGroup.MarginLayoutParams) r12).width) == false) goto L10;
            if (L(r8.getMeasuredHeight(), r11, ((ViewGroup.MarginLayoutParams) r12).height) == false) goto L10;
            return false;
        }

        public final int w() {
            androidx.recyclerview.widget.b r8 = this.f2313a;
            if (r8 != null) goto L7;
            return 0;
        L7:
            return r8.e();
        }

        public void w0(RecyclerView r8, int r10) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public final void x0(androidx.recyclerview.widget.o r8) {
            y r10 = this.f2317e;
            if (r10 == null) goto L8;
            if (r8 == r10) goto L8;
            if (r10.f2353e == false) goto L8;
            r10.d();
        L8:
            this.f2317e = r8;
            RecyclerView r11 = this.f2314b;
            b0 r12 = r11.mViewFlinger;
            r12.f2279q.removeCallbacks(r12);
            r12.f2275m.abortAnimation();
            if (r8.f2356h == false) goto L11;
            Log.w(RecyclerView.TAG, "An instance of " + r8.getClass().getSimpleName() + " was started more than once. Each instance of" + r8.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L11:
            r8.f2350b = r11;
            r8.f2351c = this;
            int r13 = r8.f2349a;
            if (r13 == (-1)) goto L16;
            r11.mState.f2364a = r13;
            r8.f2353e = true;
            r8.f2352d = true;
            r8.f2354f = r11.mLayout.r(r13);
            r8.f2350b.mViewFlinger.a();
            r8.f2356h = true;
            return;
        L16:
            throw new IllegalArgumentException("Invalid target position");
        }

        public int y(v r8, z r10) {
            RecyclerView r11 = this.f2314b;
            if (r11 != null) goto L5;
            return 1;
        L5:
            if (r11.mAdapter != null) goto L8;
            return 1;
        L8:
            if (e() == true) goto L10;
            return 1;
        L10:
            return this.f2314b.mAdapter.a();
        }

        public boolean y0() {
            return false;
        }

        public void z(View r8, Rect r10) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r8, r10);
        }
    }

    public static class p extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        c0 mViewHolder;

        public p(int r8, int r10) {
            super(r8, r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getViewAdapterPosition() {
            c0 r8 = this.mViewHolder;
            RecyclerView r10 = r8.f2298r;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return r10.getAdapterPositionFor(r8);
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.c();
        }

        @Deprecated
        public int getViewPosition() {
            c0 r8 = this.mViewHolder;
            int r10 = r8.f2287g;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            return r8.f2283c;
        }

        public boolean isItemChanged() {
            if ((this.mViewHolder.f2290j & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.i();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.g();
        }

        public boolean viewNeedsUpdate() {
            if ((this.mViewHolder.f2290j & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public p(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public p(ViewGroup.LayoutParams r8) {
            super(r8);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public p(ViewGroup.MarginLayoutParams r8) {
            super(r8);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public p(p r8) {
            super(r8);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    public interface q {
        void a();

        void b();
    }

    public static abstract class r {
    }

    public interface s {
        void a(MotionEvent r8);

        void b();

        boolean c(MotionEvent r8);
    }

    public static abstract class t {
        public t() {
        }

        public void a(RecyclerView r8, int r10) {
        }

        public void b(RecyclerView r8, int r10, int r11) {
        }
    }

    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f2334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2335b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList<c0> f2336a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f2337b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f2338c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f2339d;

            public a() {
                this.f2336a = new ArrayList();
                this.f2337b = 5;
                this.f2338c = 0;
                this.f2339d = 0;
            }
        }

        public u() {
            this.f2334a = new SparseArray();
            this.f2335b = 0;
        }

        public final a a(int r8) {
            SparseArray<a> r10 = this.f2334a;
            a r11 = r10.get(r8);
            if (r11 != null) goto L6;
            a r12 = new a();
            r10.put(r8, r12);
            return r12;
        L6:
            return r11;
        }
    }

    public final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<c0> f2340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<c0> f2341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<c0> f2342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<c0> f2343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2344e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2345f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public u f2346g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2347h;

        public v(RecyclerView r8) {
            this.f2347h = r8;
            ArrayList<c0> r10 = new ArrayList();
            this.f2340a = r10;
            this.f2341b = null;
            this.f2342c = new ArrayList();
            this.f2343d = Collections.unmodifiableList(r10);
            this.f2344e = 2;
            this.f2345f = 2;
        }

        public static void e(ViewGroup r8, boolean r10) {
            int r11 = r8.getChildCount() - 1;
        L3:
            if (r11 < 0) goto L8;
            View r12 = r8.getChildAt(r11);
            if ((r12 instanceof ViewGroup) == false) goto L7;
            e((ViewGroup) r12, true);
        L7:
            r11 = r11 - 1;
            goto L3
        L8:
            if (r10 == true) goto L11;
            return;
        L11:
            if (r8.getVisibility() != 4) goto L13;
            r8.setVisibility(0);
            r8.setVisibility(4);
            return;
        L13:
            int r13 = r8.getVisibility();
            r8.setVisibility(4);
            r8.setVisibility(r13);
        }

        public final void a(c0 r8, boolean r10) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r8);
            View r11 = r8.f2281a;
            RecyclerView r12 = this.f2347h;
            androidx.recyclerview.widget.v r13 = r12.mAccessibilityDelegate;
            if (r13 == null) goto L9;
            androidx.recyclerview.widget.v.a r14 = r13.f2561e;
            if ((r14 instanceof androidx.recyclerview.widget.v.a) == false) goto L7;
            j0.a r15 = (j0.a) r14.f2563e.remove(r11);
        L8:
            j0.w.m(r11, r15);
            goto L9
        L7:
            r15 = null;
        L9:
            if (r10 == true) goto L11;
        L13:
            r8.f2298r = null;
            u r16 = c();
            r16.getClass();
            int r17 = r8.f2286f;
            ArrayList<c0> r18 = r16.a(r17).f2336a;
            if (r16.f2334a.get(r17).f2337b <= r18.size()) goto L18;
            r8.m();
            r18.add(r8);
            return;
        L18:
            return;
        L11:
            if (r12.mState == null) goto L13;
            r12.mViewInfoStore.d(r8);
            goto L13
        }

        public final int b(int r8) {
            RecyclerView r10 = this.f2347h;
            if (r8 >= 0) goto L5;
        L11:
            StringBuilder r11 = defpackage.b.f("invalid position ", r8, ". State item count is ");
            r11.append(r10.mState.b());
            r11.append(r10.exceptionLabel());
            throw new IndexOutOfBoundsException(r11.toString());
        L5:
            if (r8 >= r10.mState.b()) goto L11;
            if (r10.mState.f2370g == true) goto L10;
            return r8;
        L10:
            return r10.mAdapterHelper.f(r8, 0);
        }

        public final u c() {
            if (this.f2346g != null) goto L6;
            this.f2346g = new u();
        L6:
            return this.f2346g;
        }

        public final View d(int r8) {
            return k(RecyclerView.FOREVER_NS, r8).f2281a;
        }

        public final void f() {
            ArrayList<c0> r8 = this.f2342c;
            int r10 = r8.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            g(r10);
            r10 = r10 - 1;
            goto L3
        L5:
            r8.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L13;
            androidx.recyclerview.widget.m.b r11 = this.f2347h.mPrefetchRegistry;
            int[] r12 = r11.f2529c;
            if (r12 == null) goto L10;
            Arrays.fill(r12, -1);
        L10:
            r11.f2530d = 0;
            return;
        }

        public final void g(int r8) {
            ArrayList<c0> r10 = this.f2342c;
            a(r10.get(r8), true);
            r10.remove(r8);
        }

        public final void h(View r8) {
            c0 r10 = RecyclerView.getChildViewHolderInt(r8);
            boolean r11 = r10.k();
            RecyclerView r12 = this.f2347h;
            if (r11 == false) goto L6;
            r12.removeDetachedView(r8, false);
        L6:
            if (r10.j() == false) goto L9;
            r10.f2294n.l(r10);
        L11:
            i(r10);
            if (r12.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r10.h() == true) goto L18;
            r12.mItemAnimator.d(r10);
            return;
        L18:
            return;
        L9:
            if (r10.p() == false) goto L11;
            r10.f2290j &= -33;
            goto L11
        }

        public final void i(c0 r12) {
            boolean r8 = r12.j();
            boolean r10 = false;
            RecyclerView r11 = this.f2347h;
            View r13 = r12.f2281a;
            if (r8 == false) goto L5;
        L72:
            StringBuilder r14 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            r14.append(r12.j());
            r14.append(" isAttached:");
            if (r13.getParent() == null) goto L75;
            r10 = true;
        L75:
            r14.append(r10);
            r14.append(r11.exceptionLabel());
            throw new IllegalArgumentException(r14.toString());
        L5:
            if (r13.getParent() != null) goto L72;
            if (r12.k() == false) goto L10;
            StringBuilder r15 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            r15.append(r12);
            throw new IllegalArgumentException(android.aimedia.a.b(r11, r15));
        L10:
            if (r12.o() == true) goto L69;
            if ((r12.f2290j & 16) != 0) goto L16;
            WeakHashMap<View, h0> r16 = j0.w.f8437a;
            if (j0.w.d.i(r13) == false) goto L16;
            boolean r17 = true;
        L17:
            g r18 = r11.mAdapter;
            if (r12.h() == true) goto L20;
            boolean r19 = false;
        L62:
            r11.mViewInfoStore.d(r12);
            if (r10 == true) goto L86;
            if (r19 == true) goto L87;
            if (r17 == false) goto L88;
            r12.f2298r = null;
            return;
        L88:
            return;
        L87:
            return;
        L86:
            return;
        L20:
            if (this.f2345f > 0) goto L22;
        L57:
            boolean r20 = false;
        L58:
            if (r20 == true) goto L60;
            a(r12, true);
            r10 = true;
        L60:
            r19 = r10;
            r10 = r20;
            goto L62
        L22:
            if ((r12.f2290j & 526) == 0) goto L24;
            boolean r21 = true;
        L25:
            if (r21 == true) goto L57;
            ArrayList<c0> r22 = this.f2342c;
            int r23 = r22.size();
            if (r23 < this.f2345f) goto L31;
            if (r23 <= 0) goto L31;
            g(0);
            r23 = r23 - 1;
        L31:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L56;
            if (r23 <= 0) goto L56;
            androidx.recyclerview.widget.m.b r24 = r11.mPrefetchRegistry;
            int r25 = r12.f2283c;
            if (r24.f2529c == null) goto L41;
            int r26 = r24.f2530d * 2;
            int r27 = 0;
        L36:
            if (r27 >= r26) goto L41;
            if (r24.f2529c[r27] == r25) goto L39;
            r27 = r27 + 2;
            goto L36
        L39:
            boolean r28 = true;
        L42:
            if (r28 == true) goto L56;
        L43:
            r23 = r23 - 1;
            if (r23 < 0) goto L55;
            int r29 = r22.get(r23).f2283c;
            androidx.recyclerview.widget.m.b r30 = r11.mPrefetchRegistry;
            if (r30.f2529c == null) goto L53;
            int r31 = r30.f2530d * 2;
            int r32 = 0;
        L48:
            if (r32 >= r31) goto L53;
            if (r30.f2529c[r32] == r29) goto L51;
            r32 = r32 + 2;
            goto L48
        L51:
            boolean r33 = true;
        L54:
            if (r33 == true) goto L43;
        L53:
            r33 = false;
        L55:
            r23 = r23 + 1;
        L41:
            r28 = false;
        L56:
            r22.add(r23, r12);
            r20 = true;
            goto L58
        L24:
            r21 = false;
        L16:
            r17 = false;
            goto L17
        L69:
            throw new IllegalArgumentException(android.aimedia.a.b(r11, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }

        public final void j(View r8) {
            c0 r10 = RecyclerView.getChildViewHolderInt(r8);
            int r11 = r10.f2290j;
            if ((r11 & 12) == 0) goto L5;
            boolean r12 = true;
        L6:
            RecyclerView r13 = this.f2347h;
            if (r12 == true) goto L21;
            if ((r11 & 2) == 0) goto L11;
            boolean r14 = true;
        L12:
            if (r14 == false) goto L21;
            if (r13.canReuseUpdatedViewHolder(r10) == true) goto L21;
            if (this.f2341b != null) goto L19;
            this.f2341b = new ArrayList();
        L19:
            r10.f2294n = this;
            r10.f2295o = true;
            ArrayList<c0> r15 = this.f2341b;
        L30:
            r15.add(r10);
            return;
        L11:
            r14 = false;
        L21:
            if (r10.g() == true) goto L23;
        L29:
            r10.f2294n = this;
            r10.f2295o = false;
            r15 = this.f2340a;
            goto L30
        L23:
            if (r10.i() == true) goto L29;
            if (r13.mAdapter.f2303b == true) goto L29;
            throw new IllegalArgumentException(android.aimedia.a.b(r13, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        L5:
            r12 = false;
            goto L6
        }

        public final c0 k(long r20, int r22) {
            RecyclerView r8 = this.f2347h;
            if (r22 >= 0) goto L5;
        L311:
            StringBuilder r10 = defpackage.a.g("Invalid item position ", r22, "(", r22, "). Item count:");
            r10.append(r8.mState.b());
            r10.append(r8.exceptionLabel());
            throw new IndexOutOfBoundsException(r10.toString());
        L5:
            if (r22 >= r8.mState.b()) goto L311;
            boolean r11 = false;
            if (r8.mState.f2370g == false) goto L38;
            ArrayList<c0> r12 = this.f2341b;
            if (r12 == null) goto L35;
            int r13 = r12.size();
            if (r13 == 0) goto L35;
            int r14 = 0;
        L14:
            if (r14 >= r13) goto L22;
            c0 r15 = this.f2341b.get(r14);
            if (r15.p() == true) goto L20;
            if (r15.c() != r22) goto L20;
            r15.b(32);
        L36:
            if (r15 == null) goto L39;
            boolean r16 = true;
        L40:
            ArrayList<c0> r17 = this.f2342c;
            ArrayList<c0> r18 = this.f2340a;
            if (r15 != null) goto L130;
            int r19 = r18.size();
            int r110 = 0;
        L43:
            if (r110 >= r19) goto L57;
            c0 r111 = r18.get(r110);
            if (r111.p() == true) goto L56;
            if (r111.c() != r22) goto L56;
            if (r111.g() == true) goto L56;
            if (r8.mState.f2370g == true) goto L54;
            if (r111.i() == true) goto L56;
        L54:
            r111.b(32);
        L55:
            r15 = r111;
        L99:
            if (r15 == null) goto L130;
            if (r15.i() == false) goto L103;
            boolean r112 = r8.mState.f2370g;
        L119:
            if (r112 == true) goto L127;
            r15.b(4);
            if (r15.j() == false) goto L124;
            r8.removeDetachedView(r15.f2281a, false);
            r15.f2294n.l(r15);
        L126:
            i(r15);
            r15 = null;
            goto L130
        L124:
            if (r15.p() == false) goto L126;
            r15.f2290j &= -33;
            goto L126
        L127:
            r16 = true;
            goto L130
        L103:
            int r113 = r15.f2283c;
            if (r113 >= 0) goto L106;
        L128:
            StringBuilder r21 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
            r21.append(r15);
            throw new IndexOutOfBoundsException(android.aimedia.a.b(r8, r21));
        L106:
            if (r113 >= r8.mAdapter.a()) goto L128;
            if (r8.mState.f2370g == true) goto L112;
            r8.mAdapter.getClass();
            if (r15.f2286f == 0) goto L112;
        L117:
            r112 = false;
        L112:
            g r114 = r8.mAdapter;
            if (r114.f2303b == true) goto L115;
        L118:
            r112 = true;
            goto L119
        L115:
            if (r15.f2285e != r114.b(r15.f2283c)) goto L117;
        L56:
            r110 = r110 + 1;
            goto L43
        L57:
            androidx.recyclerview.widget.b r23 = r8.mChildHelper;
            ArrayList r115 = r23.f2436c;
            int r116 = r115.size();
            int r117 = 0;
        L58:
            if (r117 >= r116) goto L67;
            View r118 = (View) r115.get(r117);
            ((e) r23.f2434a).getClass();
            c0 r119 = RecyclerView.getChildViewHolderInt(r118);
            if (r119.c() != r22) goto L66;
            if (r119.g() == true) goto L66;
            if (r119.i() == true) goto L66;
        L68:
            if (r118 == null) goto L88;
            r15 = RecyclerView.getChildViewHolderInt(r118);
            androidx.recyclerview.widget.b r120 = r8.mChildHelper;
            int r121 = ((e) r120.f2434a).f2300a.indexOfChild(r118);
            if (r121 < 0) goto L87;
            androidx.recyclerview.widget.b.a r122 = r120.f2435b;
            if (r122.d(r121) == false) goto L85;
            r122.a(r121);
            r120.k(r118);
            androidx.recyclerview.widget.b r123 = r8.mChildHelper;
            int r124 = ((e) r123.f2434a).f2300a.indexOfChild(r118);
            if (r124 == (-1)) goto L78;
            androidx.recyclerview.widget.b.a r125 = r123.f2435b;
            if (r125.d(r124) == true) goto L78;
            int r126 = r124 - r125.b(r124);
        L80:
            if (r126 == (-1)) goto L82;
            r8.mChildHelper.c(r126);
            j(r118);
            r15.b(8224);
            goto L99
        L82:
            StringBuilder r24 = new StringBuilder("layout index should not be -1 after unhiding a view:");
            r24.append(r15);
            throw new IllegalStateException(android.aimedia.a.b(r8, r24));
        L78:
            r126 = -1;
            goto L80
        L85:
            throw new RuntimeException("trying to unhide a view that was not hidden" + r118);
        L87:
            throw new IllegalArgumentException("view is not a child, cannot hide " + r118);
        L88:
            int r25 = r17.size();
            int r127 = 0;
        L89:
            if (r127 >= r25) goto L98;
            r111 = r17.get(r127);
            if (r111.g() == true) goto L97;
            if (r111.c() != r22) goto L97;
            if (r111.e() == true) goto L97;
            r17.remove(r127);
        L97:
            r127 = r127 + 1;
            goto L89
        L98:
            r15 = null;
        L66:
            r117 = r117 + 1;
            goto L58
        L67:
            r118 = null;
        L130:
            if (r15 != null) goto L220;
            int r128 = r8.mAdapterHelper.f(r22, 0);
            if (r128 >= 0) goto L134;
        L218:
            StringBuilder r26 = defpackage.a.g("Inconsistency detected. Invalid item position ", r22, "(offset:", r128, ").state:");
            r26.append(r8.mState.b());
            r26.append(r8.exceptionLabel());
            throw new IndexOutOfBoundsException(r26.toString());
        L134:
            if (r128 >= r8.mAdapter.a()) goto L218;
            r8.mAdapter.getClass();
            g r129 = r8.mAdapter;
            if (r129.f2303b == false) goto L167;
            long r130 = r129.b(r128);
            int r27 = r18.size() - 1;
        L138:
            if (r27 < 0) goto L153;
            c0 r131 = r18.get(r27);
            if (r131.f2285e != r130) goto L152;
            if (r131.p() == true) goto L152;
            if (r131.f2286f == 0) goto L145;
            r18.remove(r27);
            View r132 = r131.f2281a;
            r8.removeDetachedView(r132, false);
            c0 r133 = RecyclerView.getChildViewHolderInt(r132);
            r133.f2294n = null;
            r133.f2295o = false;
            r133.f2290j &= -33;
            i(r133);
            goto L152
        L145:
            r131.b(32);
            if (r131.i() == true) goto L148;
        L150:
            r15 = r131;
        L165:
            if (r15 == null) goto L167;
            r15.f2283c = r128;
            r16 = true;
            goto L167
        L148:
            if (r8.mState.f2370g == true) goto L150;
            r131.f2290j = (r131.f2290j & (-15)) | 2;
        L152:
            r27 = r27 - 1;
            goto L138
        L153:
            int r28 = r17.size() - 1;
        L154:
            if (r28 < 0) goto L164;
            r15 = r17.get(r28);
            if (r15.f2285e != r130) goto L163;
            if (r15.e() == true) goto L163;
            if (r15.f2286f != 0) goto L162;
            r17.remove(r28);
            goto L165
        L162:
            g(r28);
        L163:
            r28 = r28 - 1;
        L164:
            r15 = null;
        L167:
            if (r15 != null) goto L186;
            u.a r29 = c().f2334a.get(0);
            if (r29 == null) goto L178;
            ArrayList<c0> r30 = r29.f2336a;
            if (r30.isEmpty() == true) goto L178;
            int r31 = r30.size() - 1;
        L173:
            if (r31 < 0) goto L178;
            if (r30.get(r31).e() == false) goto L176;
            r31 = r31 - 1;
            goto L173
        L176:
            c0 r32 = r30.remove(r31);
        L179:
            if (r32 == null) goto L185;
            r32.m();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L185;
            View r33 = r32.f2281a;
            if ((r33 instanceof ViewGroup) == false) goto L185;
            e((ViewGroup) r33, false);
        L185:
            r15 = r32;
        L178:
            r32 = null;
        L186:
            if (r15 != null) goto L220;
            long r34 = r8.getNanoTime();
            if (r20 == RecyclerView.FOREVER_NS) goto L199;
            long r35 = this.f2346g.a(0).f2338c;
            if (r35 != 0) goto L192;
        L195:
            boolean r36 = true;
        L196:
            if (r36 == true) goto L199;
            return null;
        L192:
            if ((r35 + r34) < r20) goto L195;
            r36 = false;
        L199:
            j0.a r37 = null;
            g r38 = r8.mAdapter;
            r38.getClass();
            f0.h.a(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L215
            c0 r39 = r38.d(r8);     // Catch: Throwable -> L215
            if (r39.f2281a.getParent() != null) goto L214;
            r39.f2286f = 0;     // Catch: Throwable -> L215
            f0.h.b();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L208;
            RecyclerView r40 = RecyclerView.findNestedRecyclerView(r39.f2281a);
            if (r40 == null) goto L208;
            r39.f2282b = new WeakReference(r40);
        L208:
            long r41 = r8.getNanoTime() - r34;
            u.a r42 = this.f2346g.a(0);
            long r134 = r42.f2338c;
            if (r134 == 0) goto L212;
            r41 = (r41 / 4) + ((r134 / 4) * 3);
        L212:
            r42.f2338c = r41;
        L221:
            if (r16 == false) goto L233;
            z r43 = r8.mState;
            if (r43.f2370g == true) goto L233;
            int r44 = r39.f2290j;
            if ((r44 & 8192) == 0) goto L227;
            boolean r45 = true;
        L228:
            if (r45 == false) goto L233;
            r39.f2290j = (r44 & (-8193)) | 0;
            if (r43.f2373j == false) goto L233;
            l.b(r39);
            l r46 = r8.mItemAnimator;
            r39.d();
            r46.getClass();
            l.c r47 = new l.c();
            r47.a(r39);
            r8.recordAnimationInfoIfBouncedHiddenView(r39, r47);
            goto L233
        L227:
            r45 = false;
        L233:
            if (r8.mState.f2370g == false) goto L238;
            if (r39.f() == false) goto L238;
            r39.f2287g = r22;
        L256:
            boolean r48 = true;
            boolean r49 = false;
        L297:
            ViewGroup.LayoutParams r50 = r39.f2281a.getLayoutParams();
            if (r50 != null) goto L301;
            ViewGroup.LayoutParams r51 = r8.generateDefaultLayoutParams();
        L303:
            p r52 = (p) r51;
            r39.f2281a.setLayoutParams(r52);
        L305:
            r52.mViewHolder = r39;
            if (r16 == false) goto L309;
            if (r49 == false) goto L309;
            r11 = r48;
        L309:
            r52.mPendingInvalidate = r11;
            return r39;
        L301:
            if (r8.checkLayoutParams(r50) == true) goto L304;
            r51 = r8.generateLayoutParams(r50);
            goto L303
        L304:
            r52 = (p) r50;
        L238:
            if (r39.f() == true) goto L240;
        L246:
            int r53 = r8.mAdapterHelper.f(r22, 0);
            r39.f2298r = r8;
            int r54 = r39.f2286f;
            long r55 = r8.getNanoTime();
            if (r20 == RecyclerView.FOREVER_NS) goto L257;
            long r135 = this.f2346g.a(r54).f2339d;
            if (r135 != 0) goto L251;
        L254:
            boolean r56 = true;
        L255:
            if (r56 == true) goto L257;
        L251:
            if ((r135 + r55) < r20) goto L254;
            r56 = false;
        L257:
            g r57 = r8.mAdapter;
            r57.getClass();
            r39.f2283c = r53;
            if (r57.f2303b == false) goto L260;
            r39.f2285e = r57.b(r53);
        L260:
            r39.f2290j = (r39.f2290j & NetError.ERR_TTNET_FT_INVALID_STREAM_ID) | 1;
            f0.h.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            r39.d();
            r57.c(r39, r53);
            ArrayList r58 = r39.f2291k;
            if (r58 == null) goto L263;
            r58.clear();
        L263:
            r39.f2290j &= -1025;
            View r59 = r39.f2281a;
            ViewGroup.LayoutParams r60 = r59.getLayoutParams();
            if ((r60 instanceof p) == false) goto L266;
            ((p) r60).mInsetsDirty = true;
        L266:
            f0.h.b();
            long r136 = r8.getNanoTime() - r55;
            u.a r61 = this.f2346g.a(r39.f2286f);
            long r62 = r61.f2339d;
            if (r62 == 0) goto L270;
            r136 = (r136 / 4) + ((r62 / 4) * 3);
        L270:
            r61.f2339d = r136;
            if (r8.isAccessibilityEnabled() == false) goto L292;
            WeakHashMap<View, h0> r63 = j0.w.f8437a;
            if (j0.w.d.c(r59) != 0) goto L275;
            j0.w.d.s(r59, 1);
        L275:
            androidx.recyclerview.widget.v r64 = r8.mAccessibilityDelegate;
            if (r64 == null) goto L291;
            androidx.recyclerview.widget.v.a r65 = r64.f2561e;
            if ((r65 instanceof androidx.recyclerview.widget.v.a) == false) goto L290;
            r65.getClass();
            View.AccessibilityDelegate r66 = j0.w.m.a(r59);
            if (r66 != null) goto L284;
        L287:
            if (r37 == null) goto L290;
            if (r37 == r65) goto L290;
            r65.f2563e.put(r59, r37);
            goto L290
        L284:
            if ((r66 instanceof j0.a.C0095a) == false) goto L286;
            r37 = ((j0.a.C0095a) r66).f8372a;
            goto L287
        L286:
            r37 = new j0.a(r66);
        L290:
            j0.w.m(r59, r65);
        L291:
            r49 = true;
        L294:
            if (r8.mState.f2370g == false) goto L296;
            r39.f2287g = r22;
        L296:
            r48 = r49;
            goto L297
        L292:
            r49 = true;
            goto L294
        L240:
            if ((r39.f2290j & 2) == 0) goto L242;
            boolean r67 = true;
        L243:
            if (r67 == true) goto L246;
            if (r39.g() == false) goto L256;
        L242:
            r67 = false;
            goto L243
        L214:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L215
        L215:
            th = move-exception;
            f0.h.b();
            throw th;
        L220:
            r39 = r15;
            r37 = null;
        L39:
            r16 = false;
        L20:
            r14 = r14 + 1;
            goto L14
        L22:
            if (r8.mAdapter.f2303b == false) goto L35;
            int r68 = r8.mAdapterHelper.f(r22, 0);
            if (r68 <= 0) goto L35;
            if (r68 >= r8.mAdapter.a()) goto L35;
            long r69 = r8.mAdapter.b(r68);
            int r70 = 0;
        L28:
            if (r70 >= r13) goto L35;
            c0 r71 = this.f2341b.get(r70);
            if (r71.p() == true) goto L34;
            if (r71.f2285e != r69) goto L34;
            r71.b(32);
            r15 = r71;
        L34:
            r70 = r70 + 1;
        L35:
            r15 = null;
            goto L36
        L38:
            r15 = null;
            goto L39
        }

        public final void l(c0 r8) {
            if (r8.f2295o == false) goto L5;
            ArrayList<c0> r10 = this.f2341b;
        L6:
            r10.remove(r8);
            r8.f2294n = null;
            r8.f2295o = false;
            r8.f2290j &= -33;
            return;
        L5:
            r10 = this.f2340a;
            goto L6
        }

        public final void m() {
            o r8 = this.f2347h.mLayout;
            if (r8 == null) goto L5;
            int r10 = r8.f2322j;
        L6:
            this.f2345f = this.f2344e + r10;
            ArrayList<c0> r11 = this.f2342c;
            int r12 = r11.size() - 1;
        L7:
            if (r12 < 0) goto L11;
            if (r11.size() <= this.f2345f) goto L14;
            g(r12);
            r12 = r12 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r10 = 0;
            goto L6
        }
    }

    public interface w {
    }

    public class x extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2348a;

        public x(RecyclerView r8) {
            this.f2348a = r8;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void a() {
            RecyclerView r8 = this.f2348a;
            r8.assertNotInLayoutOrScroll(null);
            r8.mState.f2369f = true;
            r8.processDataSetCompletelyChanged(true);
            if (r8.mAdapterHelper.g() == true) goto L6;
            r8.requestLayout();
            return;
        }
    }

    public static abstract class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f2350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f2351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2352d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2353e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f2354f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f2355g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2356h;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2357a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2358b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f2359c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f2360d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Interpolator f2361e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f2362f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f2363g;

            public a() {
                this.f2360d = -1;
                this.f2362f = false;
                this.f2363g = 0;
                this.f2357a = 0;
                this.f2358b = 0;
                this.f2359c = Integer.MIN_VALUE;
                this.f2361e = null;
            }

            public final void a(RecyclerView r8) {
                int r10 = this.f2360d;
                if (r10 < 0) goto L7;
                this.f2360d = -1;
                r8.jumpToPositionForSmoothScroller(r10);
                this.f2362f = false;
                return;
            L7:
                if (this.f2362f == false) goto L23;
                Interpolator r11 = this.f2361e;
                if (r11 != null) goto L11;
            L15:
                int r12 = this.f2359c;
                if (r12 < 1) goto L22;
                r8.mViewFlinger.b(this.f2357a, this.f2358b, r11, r12);
                int r13 = this.f2363g + 1;
                this.f2363g = r13;
                if (r13 <= 10) goto L20;
                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L20:
                this.f2362f = false;
                return;
            L22:
                throw new IllegalStateException("Scroll duration must be a positive number");
            L11:
                if (this.f2359c >= 1) goto L15;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            L23:
                this.f2363g = 0;
            }
        }

        public interface b {
            PointF a(int r8);
        }

        public y() {
            this.f2349a = -1;
            this.f2355g = new a();
        }

        public PointF a(int r8) {
            Object r10 = this.f2351c;
            if ((r10 instanceof b) == true) goto L5;
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        L5:
            return ((b) r10).a(r8);
        }

        public final void b(int r8, int r10) {
            RecyclerView r11 = this.f2350b;
            if (this.f2349a == (-1)) goto L5;
            if (r11 == null) goto L5;
        L7:
            if (this.f2352d == true) goto L9;
        L19:
            boolean r12 = false;
            this.f2352d = false;
            View r13 = this.f2354f;
            a r14 = this.f2355g;
            if (r13 == null) goto L26;
            if (this.f2350b.getChildLayoutPosition(r13) != this.f2349a) goto L24;
            View r15 = this.f2354f;
            z r16 = r11.mState;
            c(r15, r14);
            r14.a(r11);
            d();
            goto L26
        L24:
            Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.f2354f = null;
        L26:
            if (this.f2353e == false) goto L57;
            z r17 = r11.mState;
            androidx.recyclerview.widget.o r18 = (androidx.recyclerview.widget.o) this;
            if (r18.f2350b.mLayout.w() != 0) goto L30;
            r18.d();
        L49:
            if (r14.f2360d < 0) goto L51;
            r12 = true;
        L51:
            r14.a(r11);
            if (r12 == true) goto L54;
            return;
        L54:
            if (this.f2353e == false) goto L59;
            this.f2352d = true;
            r11.mViewFlinger.a();
            return;
        L59:
            return;
        L30:
            int r19 = r18.f2551o;
            int r20 = r19 - r8;
            if ((r19 * r20) > 0) goto L33;
            r20 = 0;
        L33:
            r18.f2551o = r20;
            int r21 = r18.f2552p;
            int r22 = r21 - r10;
            if ((r21 * r22) > 0) goto L36;
            r22 = 0;
        L36:
            r18.f2552p = r22;
            if (r20 != 0) goto L49;
            if (r22 != 0) goto L49;
            PointF r23 = r18.a(r18.f2349a);
            if (r23 == null) goto L47;
            float r24 = r23.x;
            if (r24 == 0.0f) goto L44;
        L46:
            float r25 = r23.y;
            float r26 = (float) Math.sqrt((r25 * r25) + (r24 * r24));
            float r27 = r23.x / r26;
            r23.x = r27;
            float r28 = r23.y / r26;
            r23.y = r28;
            r18.f2547k = r23;
            r18.f2551o = (int) (r27 * 10000.0f);
            r18.f2552p = (int) (r28 * 10000.0f);
            int r29 = r18.i(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
            int r30 = (int) (r18.f2551o * 1.2f);
            int r31 = (int) (r18.f2552p * 1.2f);
            LinearInterpolator r32 = r18.f2545i;
            r14.f2357a = r30;
            r14.f2358b = r31;
            r14.f2359c = (int) (r29 * 1.2f);
            r14.f2361e = r32;
            r14.f2362f = true;
            goto L49
        L44:
            if (r23.y != 0.0f) goto L46;
        L47:
            r14.f2360d = r18.f2349a;
            r18.d();
            goto L49
        L57:
            return;
        L9:
            if (this.f2354f != null) goto L19;
            if (this.f2351c == null) goto L19;
            PointF r33 = a(this.f2349a);
            if (r33 == null) goto L19;
            float r34 = r33.x;
            if (r34 == 0.0f) goto L17;
        L18:
            r11.scrollStep((int) Math.signum(r34), (int) Math.signum(r33.y), null);
            goto L19
        L17:
            if (r33.y == 0.0f) goto L19;
        L5:
            d();
            goto L7
        }

        public abstract void c(View r8, a r10);

        public final void d() {
            if (this.f2353e == true) goto L5;
            return;
        L5:
            this.f2353e = false;
            androidx.recyclerview.widget.o r8 = (androidx.recyclerview.widget.o) this;
            r8.f2552p = 0;
            r8.f2551o = 0;
            r8.f2547k = null;
            this.f2350b.mState.f2364a = -1;
            this.f2354f = null;
            this.f2349a = -1;
            this.f2352d = false;
            o r10 = this.f2351c;
            if (r10.f2317e != this) goto L8;
            r10.f2317e = null;
        L8:
            this.f2351c = null;
            this.f2350b = null;
        }
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2368e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2369f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2370g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2371h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2372i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2373j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f2374k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f2375l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f2376m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2377n;

        public z() {
            this.f2364a = -1;
            this.f2365b = 0;
            this.f2366c = 0;
            this.f2367d = 1;
            this.f2368e = 0;
            this.f2369f = false;
            this.f2370g = false;
            this.f2371h = false;
            this.f2372i = false;
            this.f2373j = false;
            this.f2374k = false;
        }

        public final void a(int r8) {
            if ((this.f2367d & r8) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r8) + " but it is " + Integer.toBinaryString(this.f2367d));
        }

        public final int b() {
            if (this.f2370g == false) goto L6;
            return this.f2365b - this.f2366c;
        L6:
            return this.f2368e;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.f2364a + ", mData=null, mItemCount=" + this.f2368e + ", mIsMeasuring=" + this.f2372i + ", mPreviousLayoutItemCount=" + this.f2365b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2366c + ", mStructureChanged=" + this.f2369f + ", mInPreLayout=" + this.f2370g + ", mRunSimpleAnimations=" + this.f2373j + ", mRunPredictiveAnimations=" + this.f2374k + '}';
        }
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{R.attr.nestedScrollingEnabled};
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class r8 = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, r8, r8};
        sQuinticInterpolator = new c();
    }

    public RecyclerView(Context r8) {
        this(r8, null);
    }

    public static /* synthetic */ void access$000(RecyclerView r8, View r10, int r11, ViewGroup.LayoutParams r12) {
        r8.attachViewToParent(r10, r11, r12);
    }

    public static /* synthetic */ void access$100(RecyclerView r8, int r10) {
        r8.detachViewFromParent(r10);
    }

    public static /* synthetic */ boolean access$200(RecyclerView r8) {
        return r8.awakenScrollBars();
    }

    public static /* synthetic */ void access$300(RecyclerView r8, int r10, int r11) {
        r8.setMeasuredDimension(r10, r11);
    }

    private void addAnimatingView(c0 r8) {
        View r10 = r8.f2281a;
        if (r10.getParent() != this) goto L5;
        boolean r11 = true;
    L6:
        this.mRecycler.l(getChildViewHolder(r10));
        boolean r12 = r8.k();
        androidx.recyclerview.widget.b r13 = this.mChildHelper;
        if (r12 == false) goto L9;
        r13.b(r10, -1, r10.getLayoutParams(), true);
        return;
    L9:
        if (r11 == true) goto L11;
        r13.a(r10, -1, true);
        return;
    L11:
        int r14 = ((e) r13.f2434a).f2300a.indexOfChild(r10);
        if (r14 < 0) goto L16;
        r13.f2435b.h(r14);
        r13.i(r10);
        return;
    L16:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r10);
    L5:
        r11 = false;
        goto L6
    }

    private void animateChange(c0 r8, c0 r10, l.c r11, l.c r12, boolean r13, boolean r14) {
        r8.n(false);
        if (r13 == false) goto L5;
        addAnimatingView(r8);
    L5:
        if (r8 == r10) goto L10;
        if (r14 == false) goto L8;
        addAnimatingView(r10);
    L8:
        r8.f2288h = r10;
        addAnimatingView(r8);
        this.mRecycler.l(r8);
        r10.n(false);
        r10.f2289i = r8;
    L10:
        if (this.mItemAnimator.a(r8, r10, r11, r12) == false) goto L13;
        postAnimationRunner();
        return;
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(c0 r8) {
        WeakReference<RecyclerView> r10 = r8.f2282b;
        if (r10 == null) goto L20;
        Object r11 = r10.get();
    L5:
        View r12 = (View) r11;
    L7:
        if (r12 == null) goto L15;
        if (r12 == r8.f2281a) goto L10;
        r11 = r12.getParent();
        if ((r11 instanceof View) == true) goto L5;
        r12 = null;
        goto L7
    L10:
        return;
    L15:
        r8.f2282b = null;
        return;
    }

    private void createLayoutManager(Context r8, String r10, AttributeSet r11, int r12, int r13) {
        if (r10 == null) goto L37;
        String r14 = r10.trim();
        if (r14.isEmpty() == true) goto L43;
        String r15 = getFullClassName(r8, r14);
    L22:
        e = move-exception;
        throw new IllegalStateException(r11.getPositionDescription() + ": Class is not a LayoutManager " + r15, e);
    L34:
        e = move-exception;
        throw new IllegalStateException(r11.getPositionDescription() + ": Unable to find LayoutManager " + r15, e);
    L25:
        e = move-exception;
        throw new IllegalStateException(r11.getPositionDescription() + ": Cannot access non-public constructor " + r15, e);
    L28:
        e = move-exception;
        throw new IllegalStateException(r11.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r15, e);
    L31:
        e = move-exception;
        throw new IllegalStateException(r11.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r15, e);
    L8:
        if (isInEditMode() == false) goto L10;
        ClassLoader r16 = getClass().getClassLoader();     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L11:
        Class<? extends U> r17 = Class.forName(r15, false, r16).asSubclass(o.class);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        Constructor r18 = r17.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: NoSuchMethodException -> L15 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        Object[] r19 = {r8, r11, Integer.valueOf(r12), Integer.valueOf(r13)};     // Catch: NoSuchMethodException -> L15 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L18:
        r18.setAccessible(true);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        setLayoutManager((o) r18.newInstance(r19));     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        return;
    L15:
        e = move-exception;
        r18 = r17.getConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L19 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        r19 = null;
    L19:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        throw new IllegalStateException(r11.getPositionDescription() + ": Error creating LayoutManager " + r15, e);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L10:
        r16 = r8.getClassLoader();     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        goto L11
    L43:
        return;
    }

    private boolean didChildRangeChange(int r8, int r10) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r11 = this.mMinMaxLayoutPositions;
        if (r11[0] != r8) goto L7;
        if (r11[1] != r10) goto L7;
        return false;
    L7:
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int r8 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r8 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r10 = AccessibilityEvent.obtain();
        r10.setEventType(2048);
        k0.b.b(r10, r8);
        sendAccessibilityEventUnchecked(r10);
        return;
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f2372i = false;
        startInterceptRequestLayout();
        androidx.recyclerview.widget.a0 r8 = this.mViewInfoStore;
        r8.f2428a.clear();
        r8.f2429b.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        z r10 = this.mState;
        if (r10.f2373j == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        r10.f2371h = r11;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        r10.f2370g = r10.f2374k;
        r10.f2368e = this.mAdapter.a();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f2373j == false) goto L38;
        int r12 = this.mChildHelper.e();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L38;
        c0 r14 = getChildViewHolderInt(this.mChildHelper.d(r13));
        if (r14.o() == true) goto L36;
        if (r14.g() == true) goto L17;
    L19:
        l r15 = this.mItemAnimator;
        l.b(r14);
        r14.d();
        r15.getClass();
        l.c r16 = new l.c();
        r16.a(r14);
        n.h<c0, androidx.recyclerview.widget.a0.a> r17 = this.mViewInfoStore.f2428a;
        androidx.recyclerview.widget.a0.a r18 = r17.getOrDefault(r14, null);
        if (r18 != null) goto L22;
        r18 = androidx.recyclerview.widget.a0.a.a();
        r17.put(r14, r18);
    L22:
        r18.f2432b = r16;
        r18.f2431a |= 4;
        if (this.mState.f2371h == false) goto L36;
        if ((r14.f2290j & 2) == 0) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == false) goto L36;
        if (r14.i() == true) goto L36;
        if (r14.o() == true) goto L36;
        if (r14.g() == true) goto L36;
        this.mViewInfoStore.f2429b.g(getChangedHolderKey(r14), r14);
        goto L36
    L27:
        r19 = false;
        goto L28
    L17:
        if (this.mAdapter.f2303b == true) goto L19;
    L36:
        r13 = r13 + 1;
    L38:
        if (this.mState.f2374k == false) goto L64;
        saveOldPositions();
        z r20 = this.mState;
        boolean r21 = r20.f2369f;
        r20.f2369f = false;
        this.mLayout.a0(this.mRecycler, r20);
        this.mState.f2369f = r21;
        int r22 = 0;
    L41:
        if (r22 >= this.mChildHelper.e()) goto L64;
        c0 r23 = getChildViewHolderInt(this.mChildHelper.d(r22));
        if (r23.o() == true) goto L63;
        androidx.recyclerview.widget.a0.a r24 = this.mViewInfoStore.f2428a.getOrDefault(r23, null);
        if (r24 != null) goto L48;
    L50:
        boolean r25 = false;
    L51:
        if (r25 == true) goto L63;
        l.b(r23);
        if ((r23.f2290j & 8192) == 0) goto L55;
        boolean r26 = true;
    L56:
        l r27 = this.mItemAnimator;
        r23.d();
        r27.getClass();
        l.c r28 = new l.c();
        r28.a(r23);
        if (r26 == false) goto L59;
        recordAnimationInfoIfBouncedHiddenView(r23, r28);
        goto L63
    L59:
        n.h<c0, androidx.recyclerview.widget.a0.a> r29 = this.mViewInfoStore.f2428a;
        androidx.recyclerview.widget.a0.a r30 = r29.getOrDefault(r23, null);
        if (r30 != null) goto L62;
        r30 = androidx.recyclerview.widget.a0.a.a();
        r29.put(r23, r30);
    L62:
        r30.f2431a |= 2;
        r30.f2432b = r28;
        goto L63
    L55:
        r26 = false;
        goto L56
    L48:
        if ((r24.f2431a & 4) == 0) goto L50;
        r25 = true;
    L63:
        r22 = r22 + 1;
    L64:
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f2367d = 2;
        return;
    L5:
        if (this.mItemsChanged == false) goto L7;
        r11 = true;
        goto L8
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.c();
        this.mState.f2368e = this.mAdapter.a();
        z r8 = this.mState;
        r8.f2366c = 0;
        r8.f2370g = false;
        this.mLayout.a0(this.mRecycler, r8);
        z r10 = this.mState;
        r10.f2369f = false;
        this.mPendingSavedState = null;
        if (r10.f2373j == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        r10.f2373j = r11;
        r10.f2367d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L5:
        if (this.mItemAnimator == null) goto L7;
        r11 = true;
        goto L8
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        z r8 = this.mState;
        r8.f2367d = 1;
        if (r8.f2373j == false) goto L73;
        int r11 = this.mChildHelper.e() - 1;
    L6:
        if (r11 < 0) goto L35;
        c0 r10 = getChildViewHolderInt(this.mChildHelper.d(r11));
        if (r10.o() == true) goto L34;
        long r12 = getChangedHolderKey(r10);
        this.mItemAnimator.getClass();
        l.c r13 = new l.c();
        r13.a(r10);
        c0 r14 = (c0) this.mViewInfoStore.f2429b.e(r12, null);
        if (r14 != null) goto L13;
    L33:
        this.mViewInfoStore.a(r10, r13);
        goto L34
    L13:
        if (r14.o() == true) goto L33;
        androidx.recyclerview.widget.a0.a r15 = this.mViewInfoStore.f2428a.getOrDefault(r14, null);
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L20:
        androidx.recyclerview.widget.a0.a r17 = this.mViewInfoStore.f2428a.getOrDefault(r10, null);
        if (r17 != null) goto L23;
    L25:
        boolean r18 = false;
    L26:
        if (r16 == false) goto L29;
        if (r14 == r10) goto L33;
    L29:
        l.c r19 = this.mViewInfoStore.b(r14, 4);
        this.mViewInfoStore.a(r10, r13);
        l.c r110 = this.mViewInfoStore.b(r10, 8);
        if (r19 != null) goto L32;
        handleMissingPreInfoForChangeError(r12, r10, r14);
        goto L34
    L32:
        animateChange(r14, r10, r19, r110, r16, r18);
        goto L34
    L23:
        if ((r17.f2431a & 1) == 0) goto L25;
        r18 = true;
        goto L26
    L17:
        if ((r15.f2431a & 1) == 0) goto L19;
        r16 = true;
    L34:
        r11 = r11 - 1;
        goto L6
    L35:
        androidx.recyclerview.widget.a0 r20 = this.mViewInfoStore;
        androidx.recyclerview.widget.a0.b r21 = this.mViewInfoProcessCallback;
        n.h<c0, androidx.recyclerview.widget.a0.a> r22 = r20.f2428a;
        int r23 = r22.f9401m - 1;
    L36:
        if (r23 < 0) goto L73;
        c0 r111 = r22.i(r23);
        androidx.recyclerview.widget.a0.a r24 = r22.j(r23);
        int r25 = r24.f2431a;
        if ((r25 & 3) != 3) goto L41;
    L44:
        RecyclerView r26 = ((d) r21).f2299a;
        r26.mLayout.h0(r111.f2281a, r26.mRecycler);
    L72:
        r24.f2431a = 0;
        r24.f2432b = null;
        r24.f2433c = null;
        androidx.recyclerview.widget.a0.a.f2430d.b(r24);
        r23 = r23 - 1;
        goto L36
    L41:
        if ((r25 & 1) == 0) goto L47;
        l.c r27 = r24.f2432b;
        if (r27 == null) goto L44;
        l.c r28 = r24.f2433c;
    L68:
        RecyclerView r29 = ((d) r21).f2299a;
        r29.mRecycler.l(r111);
        r29.animateDisappearance(r111, r27, r28);
        goto L72
    L47:
        if ((r25 & 14) != 14) goto L50;
    L71:
        ((d) r21).f2299a.animateAppearance(r111, r24.f2432b, r24.f2433c);
        goto L72
    L50:
        if ((r25 & 12) != 12) goto L66;
        l.c r30 = r24.f2432b;
        l.c r31 = r24.f2433c;
        d r32 = (d) r21;
        r32.getClass();
        r111.n(false);
        RecyclerView r33 = r32.f2299a;
        if (r33.mDataSetHasChangedAfterLayout == true) goto L54;
        androidx.recyclerview.widget.x r112 = (androidx.recyclerview.widget.x) r33.mItemAnimator;
        r112.getClass();
        int r113 = r30.f2310a;
        int r114 = r31.f2310a;
        if (r113 == r114) goto L59;
    L62:
        boolean r34 = r112.g(r111, r113, r30.f2311b, r114, r31.f2311b);
    L63:
        if (r34 == false) goto L72;
    L64:
        r33.postAnimationRunner();
        goto L72
    L59:
        if (r30.f2311b != r31.f2311b) goto L62;
        r112.c(r111);
        r34 = false;
        goto L63
    L54:
        if (r33.mItemAnimator.a(r111, r111, r30, r31) == false) goto L72;
    L66:
        if ((r25 & 4) == 0) goto L70;
        r27 = r24.f2432b;
        r28 = null;
        goto L68
    L70:
        if ((r25 & 8) == 0) goto L72;
    L73:
        this.mLayout.g0(this.mRecycler);
        z r35 = this.mState;
        r35.f2365b = r35.f2368e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        r35.f2373j = false;
        r35.f2374k = false;
        this.mLayout.f2318f = false;
        ArrayList<c0> r36 = this.mRecycler.f2341b;
        if (r36 == null) goto L76;
        r36.clear();
    L76:
        o r37 = this.mLayout;
        if (r37.f2323k == false) goto L79;
        r37.f2322j = 0;
        r37.f2323k = false;
        this.mRecycler.m();
    L79:
        this.mLayout.b0(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        androidx.recyclerview.widget.a0 r38 = this.mViewInfoStore;
        r38.f2428a.clear();
        r38.f2429b.a();
        int[] r39 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r39[0], r39[1]) == false) goto L82;
        dispatchOnScrolled(0, 0);
    L82:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r8) {
        s r10 = this.mInterceptingOnItemTouchListener;
        if (r10 == null) goto L5;
        r10.a(r8);
        int r11 = r8.getAction();
        if (r11 == 3) goto L13;
        if (r11 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r8.getAction() != 0) goto L9;
        return false;
    L9:
        return findInterceptingOnItemTouchListener(r8);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent r8) {
        int r10 = r8.getAction();
        int r11 = this.mOnItemTouchListeners.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        s r13 = this.mOnItemTouchListeners.get(r12);
        if (r13.c(r8) == false) goto L10;
        if (r10 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r13;
        return true;
    L10:
        r12 = r12 + 1;
        goto L3
    L11:
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] r10) {
        int r8 = this.mChildHelper.e();
        if (r8 != 0) goto L6;
        r10[0] = -1;
        r10[1] = -1;
        return;
    L6:
        int r11 = Integer.MAX_VALUE;
        int r12 = Integer.MIN_VALUE;
        int r13 = 0;
    L7:
        if (r13 >= r8) goto L17;
        c0 r14 = getChildViewHolderInt(this.mChildHelper.d(r13));
        if (r14.o() == true) goto L16;
        int r15 = r14.c();
        if (r15 >= r11) goto L14;
        r11 = r15;
    L14:
        if (r15 <= r12) goto L16;
        r12 = r15;
    L16:
        r13 = r13 + 1;
        goto L7
    L17:
        r10[0] = r11;
        r10[1] = r12;
    }

    public static RecyclerView findNestedRecyclerView(View r8) {
        if ((r8 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r8 instanceof RecyclerView) == true) goto L8;
        ViewGroup r10 = (ViewGroup) r8;
        int r11 = r10.getChildCount();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L15;
        RecyclerView r13 = findNestedRecyclerView(r10.getChildAt(r12));
        if (r13 != null) goto L13;
        r12 = r12 + 1;
        goto L10
    L13:
        return r13;
    L15:
        return null;
    L8:
        return (RecyclerView) r8;
    }

    private View findNextViewToFocus() {
        z r8 = this.mState;
        int r10 = r8.f2375l;
        if (r10 != (-1)) goto L6;
        r10 = 0;
    L6:
        int r11 = r8.b();
        int r12 = r10;
    L7:
        if (r12 >= r11) goto L15;
        c0 r13 = findViewHolderForAdapterPosition(r12);
        if (r13 == null) goto L15;
        View r14 = r13.f2281a;
        if (r14.hasFocusable() == true) goto L13;
        r12 = r12 + 1;
        goto L7
    L13:
        return r14;
    L15:
        int r15 = Math.min(r11, r10);
    L16:
        r15 = r15 - 1;
        if (r15 < 0) goto L25;
        c0 r16 = findViewHolderForAdapterPosition(r15);
        if (r16 == null) goto L20;
        View r17 = r16.f2281a;
        if (r17.hasFocusable() == false) goto L16;
        return r17;
    L20:
        return null;
    L25:
        return null;
    }

    public static c0 getChildViewHolderInt(View r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return ((p) r8.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View r8, Rect r10) {
        p r11 = (p) r8.getLayoutParams();
        Rect r12 = r11.mDecorInsets;
        r10.set((r8.getLeft() - r12.left) - ((ViewGroup.MarginLayoutParams) r11).leftMargin, (r8.getTop() - r12.top) - ((ViewGroup.MarginLayoutParams) r11).topMargin, (r8.getRight() + r12.right) + ((ViewGroup.MarginLayoutParams) r11).rightMargin, (r8.getBottom() + r12.bottom) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View r8) {
    L2:
        int r10 = r8.getId();
    L4:
        if (r8.isFocused() == true) goto L12;
        if ((r8 instanceof ViewGroup) == false) goto L12;
        if (r8.hasFocus() == false) goto L12;
        r8 = ((ViewGroup) r8).getFocusedChild();
        if (r8.getId() == (-1)) goto L4;
    L12:
        return r10;
    }

    private String getFullClassName(Context r8, String r10) {
        if (r10.charAt(0) != '.') goto L8;
        StringBuilder r11 = new StringBuilder();
        r11.append(r8.getPackageName());
    L5:
        r11.append(r10);
        return r11.toString();
    L8:
        if (r10.contains(".") == false) goto L10;
        return r10;
    L10:
        r11 = new StringBuilder();
        r11.append(RecyclerView.class.getPackage().getName());
        r11.append('.');
        goto L5
    }

    private j0.m getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new j0.m(this);
    L6:
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long r8, c0 r10, c0 r11) {
        int r12 = this.mChildHelper.e();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L18;
        c0 r14 = getChildViewHolderInt(this.mChildHelper.d(r13));
        if (r14 == r10) goto L17;
        if (getChangedHolderKey(r14) != r8) goto L17;
        g r15 = this.mAdapter;
        if (r15 != null) goto L12;
    L15:
        StringBuilder r16 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        r16.append(r14);
        r16.append(" \n View Holder 2:");
        r16.append(r10);
        throw new IllegalStateException(android.aimedia.a.b(this, r16));
    L12:
        if (r15.f2303b == false) goto L15;
        StringBuilder r17 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
        r17.append(r14);
        r17.append(" \n View Holder 2:");
        r17.append(r10);
        throw new IllegalStateException(android.aimedia.a.b(this, r17));
    L17:
        r13 = r13 + 1;
        goto L3
    L18:
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r11 + " cannot be found but it is necessary for " + r10 + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int r8 = this.mChildHelper.e();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L16;
        c0 r11 = getChildViewHolderInt(this.mChildHelper.d(r10));
        if (r11 == null) goto L15;
        if (r11.o() == true) goto L15;
        if ((r11.f2290j & 2) == 0) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        return true;
    L12:
        r12 = false;
    L15:
        r10 = r10 + 1;
        goto L3
    L16:
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        WeakHashMap<View, h0> r8 = j0.w.f8437a;
        if (j0.w.k.b(this) != 0) goto L6;
        j0.w.k.l(this, 8);
        return;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.b(new e(this));
    }

    private boolean isPreferredNextFocus(View r10, View r11, int r12) {
        if (r11 == null) goto L88;
        if (r11 != this) goto L7;
        return false;
    L7:
        if (findContainingItemView(r11) != null) goto L10;
        return false;
    L10:
        if (r10 != null) goto L13;
        return true;
    L13:
        if (findContainingItemView(r10) != null) goto L15;
        return true;
    L15:
        this.mTempRect.set(0, 0, r10.getWidth(), r10.getHeight());
        this.mTempRect2.set(0, 0, r11.getWidth(), r11.getHeight());
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        offsetDescendantRectToMyCoords(r11, this.mTempRect2);
        byte r13 = -1;
        if (this.mLayout.B() != 1) goto L18;
        int r14 = -1;
    L19:
        Rect r8 = this.mTempRect;
        int r15 = r8.left;
        Rect r16 = this.mTempRect2;
        int r17 = r16.left;
        if (r15 < r17) goto L24;
        if (r8.right <= r17) goto L24;
    L26:
        int r18 = r8.right;
        int r19 = r16.right;
        if (r18 > r19) goto L29;
        if (r15 >= r19) goto L29;
    L31:
        int r20 = 0;
    L32:
        int r21 = r8.top;
        int r22 = r16.top;
        if (r21 < r22) goto L37;
        if (r8.bottom <= r22) goto L37;
    L39:
        int r23 = r8.bottom;
        int r24 = r16.bottom;
        if (r23 > r24) goto L42;
        if (r21 >= r24) goto L42;
    L44:
        r13 = 0;
    L45:
        if (r12 != 1) goto L47;
        if (r13 < 0) goto L81;
        if (r13 == 0) goto L79;
        return false;
    L79:
        if ((r20 * r14) <= 0) goto L81;
        return false;
    L81:
        return true;
    L47:
        if (r12 != 2) goto L49;
        if (r13 > 0) goto L75;
        if (r13 == 0) goto L73;
        return false;
    L73:
        if ((r20 * r14) >= 0) goto L75;
        return false;
    L75:
        return true;
    L49:
        if (r12 != 17) goto L51;
        if (r20 < 0) goto L69;
        return false;
    L69:
        return true;
    L51:
        if (r12 != 33) goto L53;
        if (r13 < 0) goto L66;
        return false;
    L66:
        return true;
    L53:
        if (r12 != 66) goto L55;
        if (r20 > 0) goto L63;
        return false;
    L63:
        return true;
    L55:
        if (r12 != 130) goto L59;
        if (r13 > 0) goto L58;
        return false;
    L58:
        return true;
    L59:
        StringBuilder r110 = new StringBuilder("Invalid direction: ");
        r110.append(r12);
        throw new IllegalArgumentException(android.aimedia.a.b(this, r110));
    L42:
        if (r21 <= r22) goto L44;
    L37:
        if (r8.bottom >= r16.bottom) goto L39;
        r13 = 1;
    L29:
        if (r15 <= r17) goto L31;
        r20 = -1;
    L24:
        if (r8.right >= r16.right) goto L26;
        r20 = 1;
        goto L32
    L18:
        r14 = 1;
        goto L19
    L88:
        return false;
    }

    private void onPointerUp(MotionEvent r8) {
        int r10 = r8.getActionIndex();
        if (r8.getPointerId(r10) != this.mScrollPointerId) goto L9;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.mScrollPointerId = r8.getPointerId(r11);
        int r12 = (int) (r8.getX(r11) + 0.5f);
        this.mLastTouchX = r12;
        this.mInitialTouchX = r12;
        int r13 = (int) (r8.getY(r11) + 0.5f);
        this.mLastTouchY = r13;
        this.mInitialTouchY = r13;
        return;
    L6:
        r11 = 0;
        goto L7
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.y0() == false) goto L7;
        return true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout == false) goto L8;
        androidx.recyclerview.widget.a r8 = this.mAdapterHelper;
        r8.l(r8.f2420b);
        r8.l(r8.f2421c);
        if (this.mDispatchItemsChangedEvent == false) goto L8;
        this.mLayout.W();
    L8:
        if (predictiveItemAnimationsEnabled() == false) goto L10;
        this.mAdapterHelper.j();
    L11:
        boolean r10 = false;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r11 = true;
    L18:
        z r12 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L31:
        boolean r13 = false;
    L32:
        r12.f2373j = r13;
        if (r13 == false) goto L40;
        if (r11 == false) goto L40;
        if (this.mDataSetHasChangedAfterLayout == true) goto L40;
        if (predictiveItemAnimationsEnabled() == false) goto L40;
        r10 = true;
    L40:
        r12.f2374k = r10;
        return;
    L21:
        if (this.mItemAnimator == null) goto L31;
        boolean r14 = this.mDataSetHasChangedAfterLayout;
        if (r14 == true) goto L27;
        if (r11 == true) goto L27;
        if (this.mLayout.f2318f == false) goto L31;
    L27:
        if (r14 == true) goto L29;
    L30:
        r13 = true;
        goto L32
    L29:
        if (this.mAdapter.f2303b == false) goto L31;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r11 = false;
        goto L18
    L10:
        this.mAdapterHelper.c();
        goto L11
    }

    private void pullGlows(float r8, float r10, float r11, float r12) {
        boolean r13 = true;
        if (r10 >= 0.0f) goto L7;
        ensureLeftGlow();
        EdgeEffect r14 = this.mLeftGlow;
        float r15 = (-r10) / getWidth();
        float r16 = 1.0f - (r11 / getHeight());
    L5:
        androidx.core.widget.d.a(r14, r15, r16);
        boolean r17 = true;
    L11:
        if (r12 >= 0.0f) goto L14;
        ensureTopGlow();
        androidx.core.widget.d.a(this.mTopGlow, (-r12) / getHeight(), r8 / getWidth());
    L17:
        if (r13 == false) goto L19;
    L22:
        WeakHashMap<View, h0> r18 = j0.w.f8437a;
        j0.w.d.k(this);
        return;
    L19:
        if (r10 != 0.0f) goto L22;
        if (r12 != 0.0f) goto L22;
        return;
    L14:
        if (r12 <= 0.0f) goto L16;
        ensureBottomGlow();
        androidx.core.widget.d.a(this.mBottomGlow, r12 / getHeight(), 1.0f - (r8 / getWidth()));
        goto L17
    L16:
        r13 = r17;
        goto L17
    L7:
        if (r10 <= 0.0f) goto L9;
        ensureRightGlow();
        r14 = this.mRightGlow;
        r15 = r10 / getWidth();
        r16 = r11 / getHeight();
        goto L5
    L9:
        r17 = false;
        goto L11
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
        View r8 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r8.getParent() == null) goto L24;
        if (r8.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.e() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.j(r8) == true) goto L30;
        return;
    L30:
        long r10 = this.mState.f2376m;
        View r11 = null;
        if (r10 != (-1)) goto L33;
    L35:
        c0 r12 = null;
    L36:
        if (r12 == null) goto L44;
        androidx.recyclerview.widget.b r13 = this.mChildHelper;
        View r14 = r12.f2281a;
        if (r13.j(r14) == true) goto L44;
        if (r14.hasFocusable() == false) goto L44;
        r11 = r14;
    L46:
        if (r11 == null) goto L60;
        int r15 = this.mState.f2377n;
        if (r15 == (-1)) goto L54;
        View r16 = r11.findViewById(r15);
        if (r16 == null) goto L54;
        if (r16.isFocusable() == false) goto L54;
        r11 = r16;
    L54:
        r11.requestFocus();
        return;
    L60:
        return;
    L44:
        if (this.mChildHelper.e() <= 0) goto L46;
        r11 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.f2303b == false) goto L35;
        r12 = findViewHolderForItemId(r10);
        goto L36
    }

    private void releaseGlows() {
        EdgeEffect r8 = this.mLeftGlow;
        if (r8 == null) goto L5;
        r8.onRelease();
        boolean r10 = this.mLeftGlow.isFinished();
    L6:
        EdgeEffect r11 = this.mTopGlow;
        if (r11 == null) goto L9;
        r11.onRelease();
        r10 = r10 | this.mTopGlow.isFinished();
    L9:
        EdgeEffect r12 = this.mRightGlow;
        if (r12 == null) goto L12;
        r12.onRelease();
        r10 = r10 | this.mRightGlow.isFinished();
    L12:
        EdgeEffect r13 = this.mBottomGlow;
        if (r13 == null) goto L15;
        r13.onRelease();
        r10 = r10 | this.mBottomGlow.isFinished();
    L15:
        if (r10 == false) goto L18;
        WeakHashMap<View, h0> r14 = j0.w.f8437a;
        j0.w.d.k(this);
        return;
    L18:
        return;
    L5:
        r10 = false;
        goto L6
    }

    private void requestChildOnScreen(View r12, View r13) {
        if (r13 == null) goto L4;
        View r8 = r13;
    L5:
        this.mTempRect.set(0, 0, r8.getWidth(), r8.getHeight());
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if ((r10 instanceof p) == false) goto L10;
        p r11 = (p) r10;
        if (r11.mInsetsDirty == true) goto L10;
        Rect r14 = r11.mDecorInsets;
        Rect r15 = this.mTempRect;
        r15.left -= r14.left;
        r15.right += r14.right;
        r15.top -= r14.top;
        r15.bottom += r14.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        offsetRectIntoDescendantCoords(r12, this.mTempRect);
    L12:
        o r16 = this.mLayout;
        Rect r17 = this.mTempRect;
        boolean r18 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r19 = true;
    L16:
        r16.j0(this, r12, r17, r18, r19);
        return;
    L15:
        r19 = false;
        goto L16
    L4:
        r8 = r12;
        goto L5
    }

    private void resetFocusInfo() {
        z r8 = this.mState;
        r8.f2376m = -1;
        r8.f2375l = -1;
        r8.f2377n = -1;
    }

    private void resetScroll() {
        VelocityTracker r8 = this.mVelocityTracker;
        if (r8 == null) goto L5;
        r8.clear();
    L5:
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        c0 r8 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r10 = null;
    L10:
        if (r10 == null) goto L13;
        r8 = findContainingViewHolder(r10);
    L13:
        if (r8 != null) goto L15;
        resetFocusInfo();
        return;
    L15:
        z r11 = this.mState;
        if (this.mAdapter.f2303b == false) goto L18;
        long r12 = r8.f2285e;
    L19:
        r11.f2376m = r12;
        int r13 = -1;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
    L29:
        r11.f2375l = r13;
        this.mState.f2377n = getDeepestFocusedViewWithId(r8.f2281a);
        return;
    L23:
        if (r8.i() == false) goto L25;
        r13 = r8.f2284d;
        goto L29
    L25:
        RecyclerView r14 = r8.f2298r;
        if (r14 == null) goto L29;
        r13 = r14.getAdapterPositionFor(r8);
        goto L29
    L18:
        r12 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r10 = getFocusedChild();
        goto L10
    }

    private void setAdapterInternal(g r8, boolean r10, boolean r11) {
        g r12 = this.mAdapter;
        if (r12 == null) goto L5;
        r12.f2302a.unregisterObserver(this.mObserver);
        this.mAdapter.getClass();
    L5:
        if (r10 == false) goto L7;
        if (r11 == true) goto L7;
    L8:
        androidx.recyclerview.widget.a r13 = this.mAdapterHelper;
        r13.l(r13.f2420b);
        r13.l(r13.f2421c);
        g r14 = this.mAdapter;
        this.mAdapter = r8;
        if (r8 == null) goto L11;
        r8.f2302a.registerObserver(this.mObserver);
    L11:
        v r15 = this.mRecycler;
        g r16 = this.mAdapter;
        r15.f2340a.clear();
        r15.f();
        u r17 = r15.c();
        if (r14 == null) goto L14;
        r17.f2335b--;
    L14:
        if (r10 == true) goto L22;
        if (r17.f2335b != 0) goto L22;
        int r18 = 0;
    L18:
        SparseArray<u.a> r19 = r17.f2334a;
        if (r18 >= r19.size()) goto L22;
        r19.valueAt(r18).f2336a.clear();
        r18 = r18 + 1;
    L22:
        if (r16 == null) goto L24;
        r17.f2335b++;
    L25:
        this.mState.f2369f = true;
        return;
    L24:
        r17.getClass();
    L7:
        removeAndRecycleViews();
        goto L8
    }

    private void stopScrollersInternal() {
        b0 r8 = this.mViewFlinger;
        r8.f2279q.removeCallbacks(r8);
        r8.f2275m.abortAnimation();
        o r10 = this.mLayout;
        if (r10 == null) goto L8;
        y r11 = r10.f2317e;
        if (r11 == null) goto L9;
        r11.d();
        return;
    L9:
        return;
    }

    public void absorbGlows(int r8, int r10) {
        if (r8 >= 0) goto L6;
        ensureLeftGlow();
        if (this.mLeftGlow.isFinished() == false) goto L10;
        this.mLeftGlow.onAbsorb(-r8);
    L10:
        if (r10 >= 0) goto L14;
        ensureTopGlow();
        if (this.mTopGlow.isFinished() == false) goto L18;
        this.mTopGlow.onAbsorb(-r10);
    L18:
        if (r8 != 0) goto L20;
        if (r10 != 0) goto L20;
        return;
    L20:
        WeakHashMap<View, h0> r11 = j0.w.f8437a;
        j0.w.d.k(this);
        return;
    L14:
        if (r10 <= 0) goto L18;
        ensureBottomGlow();
        if (this.mBottomGlow.isFinished() == false) goto L18;
        this.mBottomGlow.onAbsorb(r10);
        goto L18
    L6:
        if (r8 <= 0) goto L10;
        ensureRightGlow();
        if (this.mRightGlow.isFinished() == false) goto L10;
        this.mRightGlow.onAbsorb(r8);
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r8, int r10, int r11) {
        o r12 = this.mLayout;
        if (r12 == null) goto L5;
        r12.getClass();
    L5:
        super.addFocusables(r8, r10, r11);
    }

    public void addItemDecoration(n r8) {
        addItemDecoration(r8, -1);
    }

    public void addOnChildAttachStateChangeListener(q r8) {
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r8);
    }

    public void addOnItemTouchListener(s r8) {
        this.mOnItemTouchListeners.add(r8);
    }

    public void addOnScrollListener(t r8) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r8);
    }

    public void animateAppearance(c0 r8, l.c r10, l.c r11) {
        r8.n(false);
        androidx.recyclerview.widget.x r12 = (androidx.recyclerview.widget.x) this.mItemAnimator;
        r12.getClass();
        if (r10 == null) goto L9;
        int r13 = r10.f2310a;
        int r14 = r11.f2310a;
        if (r13 == r14) goto L7;
    L8:
        boolean r15 = r12.g(r8, r13, r10.f2311b, r14, r11.f2311b);
    L10:
        if (r15 == false) goto L13;
        postAnimationRunner();
        return;
    L13:
        return;
    L7:
        if (r10.f2311b != r11.f2311b) goto L8;
    L9:
        androidx.recyclerview.widget.k r16 = (androidx.recyclerview.widget.k) r12;
        r16.l(r8);
        r8.f2281a.setAlpha(0.0f);
        r16.f2469i.add(r8);
        r15 = true;
        goto L10
    }

    public void animateDisappearance(c0 r8, l.c r10, l.c r11) {
        addAnimatingView(r8);
        r8.n(false);
        androidx.recyclerview.widget.x r12 = (androidx.recyclerview.widget.x) this.mItemAnimator;
        r12.getClass();
        int r13 = r10.f2310a;
        int r14 = r10.f2311b;
        View r15 = r8.f2281a;
        if (r11 != null) goto L5;
        int r16 = r15.getLeft();
    L6:
        int r17 = r16;
        if (r11 != null) goto L9;
        int r18 = r15.getTop();
    L10:
        int r19 = r18;
        if (r8.i() == true) goto L15;
        if (r13 != r17) goto L14;
        if (r14 == r19) goto L15;
    L14:
        r15.layout(r17, r19, r15.getWidth() + r17, r15.getHeight() + r19);
        boolean r20 = r12.g(r8, r13, r14, r17, r19);
    L16:
        if (r20 == false) goto L19;
        postAnimationRunner();
        return;
    L19:
        return;
    L15:
        androidx.recyclerview.widget.k r21 = (androidx.recyclerview.widget.k) r12;
        r21.l(r8);
        r21.f2468h.add(r8);
        r20 = true;
        goto L16
    L9:
        r18 = r11.f2311b;
        goto L10
    L5:
        r16 = r11.f2310a;
        goto L6
    }

    public void assertInLayoutOrScroll(String r8) {
        if (isComputingLayout() == true) goto L9;
        if (r8 != null) goto L8;
        throw new IllegalStateException(android.aimedia.a.b(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    L8:
        throw new IllegalStateException(android.aimedia.a.b(this, android.aimedia.a.j(r8)));
    }

    public void assertNotInLayoutOrScroll(String r8) {
        if (isComputingLayout() == false) goto L10;
        if (r8 != null) goto L8;
        throw new IllegalStateException(android.aimedia.a.b(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
    L8:
        throw new IllegalStateException(r8);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(android.aimedia.a.b(this, new StringBuilder(""))));
        return;
    }

    public boolean canReuseUpdatedViewHolder(c0 r8) {
        l r10 = this.mItemAnimator;
        if (r10 == null) goto L21;
        List<Object> r11 = r8.d();
        androidx.recyclerview.widget.k r12 = (androidx.recyclerview.widget.k) r10;
        r12.getClass();
        if (r11.isEmpty() == true) goto L7;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == false) goto L20;
        return true;
    L20:
        return false;
    L7:
        if (r12.f2564g == true) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == true) goto L16;
        r13 = false;
        goto L17
    L9:
        if (r8.g() == true) goto L12;
        r14 = false;
        goto L13
    L21:
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        if ((r8 instanceof p) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.g((p) r8) == false) goto L7;
        return true;
    }

    public void clearOldPositions() {
        int r8 = this.mChildHelper.h();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r8) goto L9;
        c0 r12 = getChildViewHolderInt(this.mChildHelper.g(r11));
        if (r12.o() == true) goto L8;
        r12.f2284d = -1;
        r12.f2287g = -1;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        v r13 = this.mRecycler;
        ArrayList<c0> r14 = r13.f2342c;
        int r15 = r14.size();
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L12;
        c0 r17 = r14.get(r16);
        r17.f2284d = -1;
        r17.f2287g = -1;
        r16 = r16 + 1;
        goto L10
    L12:
        ArrayList<c0> r18 = r13.f2340a;
        int r19 = r18.size();
        int r20 = 0;
    L13:
        if (r20 >= r19) goto L15;
        c0 r21 = r18.get(r20);
        r21.f2284d = -1;
        r21.f2287g = -1;
        r20 = r20 + 1;
        goto L13
    L15:
        ArrayList<c0> r22 = r13.f2341b;
        if (r22 == null) goto L20;
        int r23 = r22.size();
    L18:
        if (r10 >= r23) goto L27;
        c0 r24 = r13.f2341b.get(r10);
        r24.f2284d = -1;
        r24.f2287g = -1;
        r10 = r10 + 1;
        goto L18
    L27:
        return;
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<q> r8 = this.mOnChildAttachStateListeners;
        if (r8 == null) goto L6;
        r8.clear();
        return;
    }

    public void clearOnScrollListeners() {
        List<t> r8 = this.mScrollListeners;
        if (r8 == null) goto L6;
        r8.clear();
        return;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o r8 = this.mLayout;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.e() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.k(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o r8 = this.mLayout;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.e() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.l(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o r8 = this.mLayout;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.e() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.m(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o r8 = this.mLayout;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.n(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o r8 = this.mLayout;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.o(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o r8 = this.mLayout;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.p(this.mState);
    }

    public void considerReleasingGlowsOnScroll(int r8, int r10) {
        EdgeEffect r11 = this.mLeftGlow;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = false;
    L9:
        EdgeEffect r13 = this.mRightGlow;
        if (r13 != null) goto L12;
    L15:
        EdgeEffect r14 = this.mTopGlow;
        if (r14 != null) goto L18;
    L21:
        EdgeEffect r15 = this.mBottomGlow;
        if (r15 != null) goto L24;
    L27:
        if (r12 == false) goto L30;
        WeakHashMap<View, h0> r16 = j0.w.f8437a;
        j0.w.d.k(this);
        return;
    L30:
        return;
    L24:
        if (r15.isFinished() == true) goto L27;
        if (r10 >= 0) goto L27;
        this.mBottomGlow.onRelease();
        r12 = r12 | this.mBottomGlow.isFinished();
        goto L27
    L18:
        if (r14.isFinished() == true) goto L21;
        if (r10 <= 0) goto L21;
        this.mTopGlow.onRelease();
        r12 = r12 | this.mTopGlow.isFinished();
        goto L21
    L12:
        if (r13.isFinished() == true) goto L15;
        if (r8 >= 0) goto L15;
        this.mRightGlow.onRelease();
        r12 = r12 | this.mRightGlow.isFinished();
        goto L15
    L5:
        if (r11.isFinished() == true) goto L8;
        if (r8 <= 0) goto L8;
        this.mLeftGlow.onRelease();
        r12 = this.mLeftGlow.isFinished();
        goto L9
    }

    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L14:
        f0.h.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        f0.h.b();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L14;
        if (this.mAdapterHelper.g() == true) goto L10;
        return;
    L10:
        this.mAdapterHelper.getClass();
        if (this.mAdapterHelper.g() == false) goto L16;
        f0.h.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        f0.h.b();
        return;
    }

    public void defaultOnMeasure(int r8, int r10) {
        int r11 = getPaddingLeft();
        int r12 = getPaddingRight() + r11;
        WeakHashMap<View, h0> r13 = j0.w.f8437a;
        int r14 = o.h(r8, r12, j0.w.d.e(this));
        int r15 = getPaddingTop();
        setMeasuredDimension(r14, o.h(r10, getPaddingBottom() + r15, j0.w.d.d(this)));
    }

    public void dispatchChildAttached(View r8) {
        getChildViewHolderInt(r8);
        onChildAttachedToWindow(r8);
        g r10 = this.mAdapter;
        List<q> r11 = this.mOnChildAttachStateListeners;
        if (r11 == null) goto L8;
        int r12 = r11.size();
    L5:
        r12 = r12 - 1;
        if (r12 < 0) goto L10;
        this.mOnChildAttachStateListeners.get(r12).a();
        goto L5
    L10:
        return;
    }

    public void dispatchChildDetached(View r8) {
        getChildViewHolderInt(r8);
        onChildDetachedFromWindow(r8);
        g r10 = this.mAdapter;
        List<q> r11 = this.mOnChildAttachStateListeners;
        if (r11 == null) goto L8;
        int r12 = r11.size();
    L5:
        r12 = r12 - 1;
        if (r12 < 0) goto L10;
        this.mOnChildAttachStateListeners.get(r12).b();
        goto L5
    L10:
        return;
    }

    public void dispatchLayout() {
        if (this.mAdapter != null) goto L8;
        String r8 = "No adapter attached; skipping layout";
    L5:
        Log.e(TAG, r8);
        return;
    L8:
        if (this.mLayout != null) goto L10;
        r8 = "No layout manager attached; skipping layout";
        goto L5
    L10:
        z r10 = this.mState;
        boolean r11 = false;
        r10.f2372i = false;
        if (r10.f2367d != 1) goto L14;
        dispatchLayoutStep1();
    L13:
        this.mLayout.o0(this);
        dispatchLayoutStep2();
    L26:
        dispatchLayoutStep3();
        return;
    L14:
        androidx.recyclerview.widget.a r12 = this.mAdapterHelper;
        if (r12.f2421c.isEmpty() == false) goto L17;
    L19:
        if (r11 == true) goto L13;
        if (this.mLayout.f2326n != getWidth()) goto L13;
        if (this.mLayout.f2327o != getHeight()) goto L13;
        this.mLayout.o0(this);
        goto L26
    L17:
        if (r12.f2420b.isEmpty() == true) goto L19;
        r11 = true;
        goto L19
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float r8, float r10, boolean r11) {
        return getScrollingChildHelper().a(r8, r10, r11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float r8, float r10) {
        return getScrollingChildHelper().b(r8, r10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r8, int r10, int[] r11, int[] r12) {
        return getScrollingChildHelper().c(r8, r10, r11, r12, 0);
    }

    public final void dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15, int[] r16) {
        getScrollingChildHelper().e(r10, r11, r12, r13, r14, r15, r16);
    }

    public void dispatchOnScrollStateChanged(int r8) {
        o r10 = this.mLayout;
        if (r10 == null) goto L5;
        r10.e0(r8);
    L5:
        onScrollStateChanged(r8);
        t r11 = this.mScrollListener;
        if (r11 == null) goto L8;
        r11.a(this, r8);
    L8:
        List<t> r12 = this.mScrollListeners;
        if (r12 == null) goto L13;
        int r13 = r12.size() - 1;
    L11:
        if (r13 < 0) goto L15;
        this.mScrollListeners.get(r13).a(this, r8);
        r13 = r13 - 1;
        goto L11
    L15:
        return;
    }

    public void dispatchOnScrolled(int r8, int r10) {
        this.mDispatchScrollCounter++;
        int r11 = getScrollX();
        int r12 = getScrollY();
        onScrollChanged(r11, r12, r11 - r8, r12 - r10);
        onScrolled(r8, r10);
        t r13 = this.mScrollListener;
        if (r13 == null) goto L5;
        r13.b(this, r8, r10);
    L5:
        List<t> r14 = this.mScrollListeners;
        if (r14 == null) goto L10;
        int r15 = r14.size() - 1;
    L8:
        if (r15 < 0) goto L10;
        this.mScrollListeners.get(r15).b(this, r8, r10);
        r15 = r15 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int r8 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r8 < 0) goto L13;
        c0 r10 = this.mPendingAccessibilityImportanceChange.get(r8);
        if (r10.f2281a.getParent() != this) goto L12;
        if (r10.o() == true) goto L12;
        int r11 = r10.f2297q;
        if (r11 == (-1)) goto L12;
        WeakHashMap<View, h0> r12 = j0.w.f8437a;
        j0.w.d.s(r10.f2281a, r11);
        r10.f2297q = -1;
    L12:
        r8 = r8 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r8) {
        onPopulateAccessibilityEvent(r8);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r8) {
        dispatchThawSelfOnly(r8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r8) {
        dispatchFreezeSelfOnly(r8);
    }

    @Override // android.view.View
    public void draw(Canvas r8) {
        super.draw(r8);
        int r10 = this.mItemDecorations.size();
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        this.mItemDecorations.get(r12).e(r8, this);
        r12 = r12 + 1;
        goto L3
    L5:
        EdgeEffect r13 = this.mLeftGlow;
        boolean r14 = true;
        if (r13 != null) goto L8;
    L20:
        boolean r15 = false;
    L21:
        EdgeEffect r16 = this.mTopGlow;
        if (r16 != null) goto L24;
    L35:
        EdgeEffect r17 = this.mRightGlow;
        if (r17 != null) goto L38;
    L50:
        EdgeEffect r18 = this.mBottomGlow;
        if (r18 != null) goto L53;
    L64:
        if (r15 == false) goto L66;
    L72:
        r14 = r15;
    L73:
        if (r14 == false) goto L77;
        WeakHashMap<View, h0> r19 = j0.w.f8437a;
        j0.w.d.k(this);
        return;
    L77:
        return;
    L66:
        if (this.mItemAnimator == null) goto L72;
        if (this.mItemDecorations.size() <= 0) goto L72;
        if (this.mItemAnimator.f() == false) goto L72;
    L53:
        if (r18.isFinished() == true) goto L64;
        int r20 = r8.save();
        r8.rotate(180.0f);
        if (this.mClipToPadding == false) goto L57;
        float r21 = getPaddingRight() + (-getWidth());
        float r22 = getPaddingBottom() + (-getHeight());
    L58:
        r8.translate(r21, r22);
        EdgeEffect r23 = this.mBottomGlow;
        if (r23 != null) goto L61;
    L63:
        r15 = r15 | r11;
        r8.restoreToCount(r20);
        goto L64
    L61:
        if (r23.draw(r8) == false) goto L63;
        r11 = true;
        goto L63
    L57:
        r21 = -getWidth();
        r22 = -getHeight();
        goto L58
    L38:
        if (r17.isFinished() == true) goto L50;
        int r24 = r8.save();
        int r25 = getWidth();
        if (this.mClipToPadding == false) goto L42;
        int r26 = getPaddingTop();
    L43:
        r8.rotate(90.0f);
        r8.translate(-r26, -r25);
        EdgeEffect r27 = this.mRightGlow;
        if (r27 != null) goto L46;
    L48:
        boolean r28 = false;
    L49:
        r15 = r15 | r28;
        r8.restoreToCount(r24);
        goto L50
    L46:
        if (r27.draw(r8) == false) goto L48;
        r28 = true;
        goto L49
    L42:
        r26 = 0;
        goto L43
    L24:
        if (r16.isFinished() == true) goto L35;
        int r29 = r8.save();
        if (this.mClipToPadding == false) goto L28;
        r8.translate(getPaddingLeft(), getPaddingTop());
    L28:
        EdgeEffect r30 = this.mTopGlow;
        if (r30 != null) goto L31;
    L33:
        boolean r31 = false;
    L34:
        r15 = r15 | r31;
        r8.restoreToCount(r29);
        goto L35
    L31:
        if (r30.draw(r8) == false) goto L33;
        r31 = true;
        goto L34
    L8:
        if (r13.isFinished() == true) goto L20;
        int r32 = r8.save();
        if (this.mClipToPadding == false) goto L12;
        int r33 = getPaddingBottom();
    L13:
        r8.rotate(270.0f);
        r8.translate((-getHeight()) + r33, 0.0f);
        EdgeEffect r34 = this.mLeftGlow;
        if (r34 != null) goto L16;
    L18:
        r15 = false;
    L19:
        r8.restoreToCount(r32);
        goto L21
    L16:
        if (r34.draw(r8) == false) goto L18;
        r15 = true;
        goto L19
    L12:
        r33 = 0;
        goto L13
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r8, View r10, long r11) {
        return super.drawChild(r8, r10, r11);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) goto L5;
        return;
    L5:
        this.mEdgeEffectFactory.getClass();
        EdgeEffect r8 = new EdgeEffect(getContext());
        this.mBottomGlow = r8;
        if (this.mClipToPadding == false) goto L8;
        r8.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r8.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) goto L5;
        return;
    L5:
        this.mEdgeEffectFactory.getClass();
        EdgeEffect r8 = new EdgeEffect(getContext());
        this.mLeftGlow = r8;
        if (this.mClipToPadding == false) goto L8;
        r8.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r8.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) goto L5;
        return;
    L5:
        this.mEdgeEffectFactory.getClass();
        EdgeEffect r8 = new EdgeEffect(getContext());
        this.mRightGlow = r8;
        if (this.mClipToPadding == false) goto L8;
        r8.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r8.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) goto L5;
        return;
    L5:
        this.mEdgeEffectFactory.getClass();
        EdgeEffect r8 = new EdgeEffect(getContext());
        this.mTopGlow = r8;
        if (this.mClipToPadding == false) goto L8;
        r8.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r8.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(z r8) {
        if (getScrollState() != 2) goto L5;
        OverScroller r10 = this.mViewFlinger.f2275m;
        r10.getFinalX();
        r10.getCurrX();
        r8.getClass();
        r10.getFinalY();
        r10.getCurrY();
        return;
    L5:
        r8.getClass();
    }

    public View findChildViewUnder(float r8, float r10) {
        int r11 = this.mChildHelper.e() - 1;
    L3:
        if (r11 < 0) goto L14;
        View r12 = this.mChildHelper.d(r11);
        float r13 = r12.getTranslationX();
        float r14 = r12.getTranslationY();
        if (r8 < (r12.getLeft() + r13)) goto L13;
        if (r8 > (r12.getRight() + r13)) goto L13;
        if (r10 < (r12.getTop() + r14)) goto L13;
        if (r10 > (r12.getBottom() + r14)) goto L13;
        return r12;
    L13:
        r11 = r11 - 1;
        goto L3
    L14:
        return null;
    }

    public View findContainingItemView(View r8) {
    L2:
        Object r10 = r8.getParent();
        if (r10 == null) goto L8;
        if (r10 == this) goto L8;
        if ((r10 instanceof View) == false) goto L8;
        r8 = (View) r10;
    L8:
        if (r10 == this) goto L15;
        return null;
    L15:
        return r8;
    }

    public c0 findContainingViewHolder(View r8) {
        View r10 = findContainingItemView(r8);
        if (r10 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r10);
    }

    public c0 findViewHolderForAdapterPosition(int r8) {
        c0 r10 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r11 = this.mChildHelper.h();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L18;
        c0 r13 = getChildViewHolderInt(this.mChildHelper.g(r12));
        if (r13 == null) goto L17;
        if (r13.i() == true) goto L17;
        if (getAdapterPositionFor(r13) != r8) goto L17;
        if (this.mChildHelper.j(r13.f2281a) == false) goto L16;
        r10 = r13;
        goto L17
    L16:
        return r13;
    L17:
        r12 = r12 + 1;
        goto L6
    L18:
        return r10;
    }

    public c0 findViewHolderForItemId(long r8) {
        g r10 = this.mAdapter;
        c0 r11 = null;
        if (r10 != null) goto L5;
    L20:
        return r11;
    L5:
        if (r10.f2303b == false) goto L20;
        int r12 = this.mChildHelper.h();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L20;
        c0 r14 = getChildViewHolderInt(this.mChildHelper.g(r13));
        if (r14 == null) goto L19;
        if (r14.i() == true) goto L19;
        if (r14.f2285e != r8) goto L19;
        if (this.mChildHelper.j(r14.f2281a) == false) goto L18;
        r11 = r14;
        goto L19
    L18:
        return r14;
    L19:
        r13 = r13 + 1;
        goto L8
    }

    public c0 findViewHolderForLayoutPosition(int r8) {
        return findViewHolderForPosition(r8, false);
    }

    @Deprecated
    public c0 findViewHolderForPosition(int r8) {
        return findViewHolderForPosition(r8, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean fling(int r20, int r21) {
        o r8 = this.mLayout;
        boolean r10 = false;
        if (r8 != null) goto L7;
        Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        boolean r11 = r8.e();
        boolean r12 = this.mLayout.f();
        if (r11 == true) goto L12;
    L15:
        int r13 = 0;
    L16:
        if (r12 == true) goto L18;
    L21:
        int r14 = 0;
    L22:
        if (r13 != 0) goto L25;
        if (r14 != 0) goto L25;
        return false;
    L25:
        float r15 = r13;
        float r16 = r14;
        if (dispatchNestedPreFling(r15, r16) == true) goto L133;
        if (r11 == true) goto L31;
        if (r12 == true) goto L31;
        boolean r17 = false;
    L32:
        dispatchNestedFling(r15, r16, r17);
        r r18 = this.mOnFlingListener;
        if (r18 == null) goto L122;
        androidx.recyclerview.widget.y r19 = (androidx.recyclerview.widget.y) r18;
        o r22 = r19.f2565a.getLayoutManager();
        if (r22 != 0) goto L38;
    L39:
        boolean r23 = false;
    L119:
        if (r23 == false) goto L122;
        return true;
    L38:
        if (r19.f2565a.getAdapter() == null) goto L39;
        int r110 = r19.f2565a.getMinFlingVelocity();
        if (Math.abs(r14) <= r110) goto L43;
    L44:
        boolean r111 = r22 instanceof y.b;
        if (r111 == false) goto L116;
        androidx.recyclerview.widget.u r24 = (androidx.recyclerview.widget.u) r19;
        View r112 = null;
        if (r111 == true) goto L50;
        androidx.recyclerview.widget.t r113 = null;
    L51:
        if (r113 == null) goto L116;
        int r114 = r22.A();
        if (r114 != 0) goto L57;
    L111:
        int r25 = -1;
    L113:
        if (r25 != (-1)) goto L115;
        r10 = false;
        goto L116
    L115:
        r113.f2349a = r25;
        r22.x0(r113);
        r10 = true;
        goto L116
    L57:
        if (r22.f() == false) goto L60;
        androidx.recyclerview.widget.s r26 = r24.e(r22);
    L63:
        if (r26 == null) goto L111;
        int r115 = r22.w();
        int r116 = 0;
        int r27 = Integer.MIN_VALUE;
        int r28 = Integer.MAX_VALUE;
        View r117 = null;
    L66:
        if (r116 >= r115) goto L79;
        int r118 = r115;
        View r119 = r22.v(r116);
        if (r119 == null) goto L77;
        int r29 = androidx.recyclerview.widget.u.c(r119, r26);
        if (r29 > 0) goto L74;
        if (r29 <= r27) goto L74;
        r27 = r29;
        r117 = r119;
    L74:
        if (r29 < 0) goto L77;
        if (r29 >= r28) goto L77;
        r28 = r29;
        r112 = r119;
    L77:
        r116 = r116 + 1;
        r115 = r118;
        goto L66
    L79:
        if (r22.e() == false) goto L82;
        if (r13 > 0) goto L83;
    L84:
        boolean r30 = false;
    L85:
        if (r30 == false) goto L88;
        if (r112 == null) goto L88;
        r25 = o.G(r112);
    L88:
        if (r30 == true) goto L91;
        if (r117 == null) goto L91;
        r25 = o.G(r117);
    L91:
        if (r30 == false) goto L93;
        r112 = r117;
    L93:
        if (r112 == null) goto L111;
        int r31 = o.G(r112);
        int r32 = r22.A();
        if (r111 == false) goto L104;
        PointF r33 = ((y.b) r22).a(r32 - 1);
        if (r33 == null) goto L104;
        if (r33.x >= 0.0f) goto L102;
    L103:
        boolean r34 = true;
    L105:
        if (r34 != r30) goto L107;
        int r35 = -1;
    L108:
        r25 = r35 + r31;
        if (r25 < 0) goto L111;
        if (r25 < r114) goto L113;
    L107:
        r35 = 1;
        goto L108
    L102:
        if (r33.y < 0.0f) goto L103;
    L104:
        r34 = false;
    L83:
        r30 = true;
        goto L85
    L82:
        if (r14 <= 0) goto L84;
    L60:
        if (r22.e() == false) goto L62;
        r26 = r24.d(r22);
        goto L63
    L62:
        r26 = null;
        goto L63
    L50:
        r113 = new androidx.recyclerview.widget.t(r24, r24.f2565a.getContext());
    L116:
        if (r10 == false) goto L118;
        r23 = true;
    L118:
        r23 = false;
        goto L119
    L43:
        if (Math.abs(r13) <= r110) goto L118;
    L122:
        int r36 = r11;
        if (r17 == false) goto L131;
        if (r12 == false) goto L126;
        r36 = (r11 ? 1 : 0) | 2;
    L126:
        startNestedScroll(r36, 1);
        int r37 = this.mMaxFlingVelocity;
        int r38 = Math.max(-r37, Math.min(r13, r37));
        int r39 = this.mMaxFlingVelocity;
        int r120 = Math.max(-r39, Math.min(r14, r39));
        b0 r40 = this.mViewFlinger;
        RecyclerView r41 = r40.f2279q;
        r41.setScrollState(2);
        r40.f2274b = 0;
        r40.f2273a = 0;
        Interpolator r42 = r40.f2276n;
        Interpolator r43 = sQuinticInterpolator;
        if (r42 == r43) goto L129;
        r40.f2276n = r43;
        r40.f2275m = new OverScroller(r41.getContext(), r43);
    L129:
        r40.f2275m.fling(0, 0, r38, r120, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r40.a();
        return true;
    L131:
        return false;
    L31:
        r17 = true;
        goto L32
    L133:
        return false;
    L18:
        if (Math.abs(r21) < this.mMinFlingVelocity) goto L21;
        r14 = r21;
        goto L22
    L12:
        if (Math.abs(r20) < this.mMinFlingVelocity) goto L15;
        r13 = r20;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r10, int r11) {
        this.mLayout.getClass();
        boolean r8 = true;
        if (this.mAdapter != null) goto L5;
    L11:
        boolean r12 = false;
    L12:
        FocusFinder r13 = FocusFinder.getInstance();
        if (r12 == true) goto L15;
    L58:
        View r14 = r13.findNextFocus(this, r10, r11);
        if (r14 != null) goto L65;
        if (r12 == false) goto L65;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L64;
        return null;
    L64:
        startInterceptRequestLayout();
        View r15 = this.mLayout.R(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L66:
        if (r15 == null) goto L76;
        if (r15.hasFocusable() == true) goto L76;
        if (getFocusedChild() == null) goto L72;
        requestChildOnScreen(r15, null);
        return r10;
    L72:
        return super.focusSearch(r10, r11);
    L76:
        if (isPreferredNextFocus(r10, r15, r11) == false) goto L79;
        return r15;
    L79:
        return super.focusSearch(r10, r11);
    L65:
        r15 = r14;
        goto L66
    L15:
        if (r11 == 2) goto L18;
        if (r11 != 1) goto L58;
    L18:
        if (this.mLayout.f() == false) goto L29;
        if (r11 != 2) goto L21;
        int r16 = ApWakeEvent.ACCELERATING_START;
    L23:
        if (r13.findNextFocus(this, r10, r16) != null) goto L25;
        boolean r17 = true;
    L27:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L30;
        r11 = r16;
    L30:
        if (r17 == false) goto L32;
    L52:
        if (r17 == false) goto L57;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L56;
        return null;
    L56:
        startInterceptRequestLayout();
        this.mLayout.R(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L57:
        r15 = r13.findNextFocus(this, r10, r11);
        goto L66
    L32:
        if (this.mLayout.e() == false) goto L52;
        if (this.mLayout.B() != 1) goto L36;
        boolean r18 = true;
    L37:
        if (r11 != 2) goto L39;
        boolean r19 = true;
    L41:
        if ((r18 ^ r19) == false) goto L43;
        int r20 = 66;
    L45:
        if (r13.findNextFocus(this, r10, r20) == null) goto L49;
        r8 = false;
    L49:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L51;
        r11 = r20;
    L51:
        r17 = r8;
        goto L52
    L43:
        r20 = 17;
        goto L45
    L39:
        r19 = false;
        goto L41
    L36:
        r18 = false;
        goto L37
    L25:
        r17 = false;
        goto L27
    L21:
        r16 = 33;
        goto L23
    L29:
        r17 = false;
        goto L30
    L5:
        if (this.mLayout == null) goto L11;
        if (isComputingLayout() == true) goto L11;
        if (this.mLayoutSuppressed == true) goto L11;
        r12 = true;
        goto L12
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o r8 = this.mLayout;
        if (r8 == null) goto L7;
        return r8.s();
    L7:
        throw new IllegalStateException(android.aimedia.a.b(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        o r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.t(getContext(), r8);
    L7:
        throw new IllegalStateException(android.aimedia.a.b(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionFor(c0 r8) {
        int r10 = 0;
        if ((r8.f2290j & 524) == 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
    L37:
        return -1;
    L8:
        if (r8.f() == false) goto L37;
        androidx.recyclerview.widget.a r12 = this.mAdapterHelper;
        int r13 = r8.f2283c;
        ArrayList<androidx.recyclerview.widget.a.b> r14 = r12.f2420b;
        int r15 = r14.size();
    L11:
        if (r10 >= r15) goto L49;
        androidx.recyclerview.widget.a.b r16 = r14.get(r10);
        int r17 = r16.f2424a;
        if (r17 == 1) goto L34;
        if (r17 != 2) goto L17;
        int r18 = r16.f2425b;
        if (r18 > r13) goto L36;
        int r19 = r16.f2427d;
        if ((r18 + r19) > r13) goto L37;
        r13 = r13 - r19;
    L36:
        r10 = r10 + 1;
        goto L11
    L17:
        if (r17 != 8) goto L36;
        int r20 = r16.f2425b;
        if (r20 != r13) goto L22;
        r13 = r16.f2427d;
        goto L36
    L22:
        if (r20 >= r13) goto L25;
        r13 = r13 - 1;
    L25:
        if (r16.f2427d > r13) goto L36;
        r13 = r13 + 1;
        goto L36
    L34:
        if (r16.f2425b > r13) goto L36;
        r13 = r13 + r16.f2427d;
        goto L36
    L49:
        return r13;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    public int getBaseline() {
        o r8 = this.mLayout;
        if (r8 == null) goto L7;
        r8.getClass();
        return -1;
    L7:
        return super.getBaseline();
    }

    public long getChangedHolderKey(c0 r8) {
        if (this.mAdapter.f2303b == false) goto L6;
        return r8.f2285e;
    L6:
        return r8.f2283c;
    }

    public int getChildAdapterPosition(View r8) {
        c0 r10 = getChildViewHolderInt(r8);
        if (r10 == null) goto L9;
        RecyclerView r11 = r10.f2298r;
        if (r11 != null) goto L8;
        return -1;
    L8:
        return r11.getAdapterPositionFor(r10);
    L9:
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r8, int r10) {
        return super.getChildDrawingOrder(r8, r10);
    }

    public long getChildItemId(View r8) {
        g r10 = this.mAdapter;
        if (r10 != null) goto L5;
        return -1;
    L5:
        if (r10.f2303b == false) goto L13;
        c0 r11 = getChildViewHolderInt(r8);
        if (r11 != null) goto L10;
        return -1;
    L10:
        return r11.f2285e;
    L13:
        return -1;
    }

    public int getChildLayoutPosition(View r8) {
        c0 r10 = getChildViewHolderInt(r8);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.c();
    }

    @Deprecated
    public int getChildPosition(View r8) {
        return getChildAdapterPosition(r8);
    }

    public c0 getChildViewHolder(View r8) {
        ViewParent r10 = r8.getParent();
        if (r10 == null) goto L9;
        if (r10 == this) goto L9;
        throw new IllegalArgumentException("View " + r8 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r8);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public androidx.recyclerview.widget.v getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View r8, Rect r10) {
        getDecoratedBoundsWithMarginsInt(r8, r10);
    }

    public k getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public l getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View r10) {
        p r8 = (p) r10.getLayoutParams();
        if (r8.mInsetsDirty == true) goto L7;
        return r8.mDecorInsets;
    L7:
        if (this.mState.f2370g == true) goto L9;
    L14:
        Rect r11 = r8.mDecorInsets;
        r11.set(0, 0, 0, 0);
        int r12 = this.mItemDecorations.size();
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        n r14 = this.mItemDecorations.get(r13);
        Rect r15 = this.mTempRect;
        r14.getClass();
        ((p) r10.getLayoutParams()).getViewLayoutPosition();
        r15.set(0, 0, 0, 0);
        int r16 = r11.left;
        Rect r17 = this.mTempRect;
        r11.left = r16 + r17.left;
        r11.top += r17.top;
        r11.right += r17.right;
        r11.bottom += r17.bottom;
        r13 = r13 + 1;
        goto L15
    L17:
        r8.mInsetsDirty = false;
        return r11;
    L9:
        if (r8.isItemChanged() == true) goto L13;
        if (r8.isViewInvalid() == false) goto L14;
    L13:
        return r8.mDecorInsets;
    }

    public n getItemDecorationAt(int r8) {
        int r10 = getItemDecorationCount();
        if (r8 < 0) goto L8;
        if (r8 >= r10) goto L8;
        return this.mItemDecorations.get(r8);
    L8:
        throw new IndexOutOfBoundsException(r8 + " is an invalid index for size " + r10);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public o getLayoutManager() {
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

    public r getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public u getRecycledViewPool() {
        return this.mRecycler.c();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        if (getScrollingChildHelper().f(0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.g() == true) goto L10;
        return false;
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new f(this));
    }

    public void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r8 = getContext().getResources();
        new androidx.recyclerview.widget.l(this, r11, r12, r13, r14, r8.getDimensionPixelSize(com.obric.cae.R.dimen.fastscroll_default_thickness), r8.getDimensionPixelSize(com.obric.cae.R.dimen.fastscroll_minimum_range), r8.getDimensionPixelOffset(com.obric.cae.R.dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException(android.aimedia.a.b(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        o r8 = this.mLayout;
        if (r8 == null) goto L8;
        r8.c("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager r8 = this.mAccessibilityManager;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isEnabled() == false) goto L7;
        return true;
    }

    public boolean isAnimating() {
        l r8 = this.mItemAnimator;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.f() == false) goto L7;
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

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f8406d;
    }

    public void jumpToPositionForSmoothScroller(int r8) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.m0(r8);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int r8 = this.mChildHelper.h();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r8) goto L6;
        ((p) this.mChildHelper.g(r11).getLayoutParams()).mInsetsDirty = true;
        r11 = r11 + 1;
        goto L4
    L6:
        ArrayList<c0> r12 = this.mRecycler.f2342c;
        int r13 = r12.size();
    L7:
        if (r10 >= r13) goto L12;
        p r14 = (p) r12.get(r10).f2281a.getLayoutParams();
        if (r14 == null) goto L11;
        r14.mInsetsDirty = true;
    L11:
        r10 = r10 + 1;
        goto L7
    }

    public void markKnownViewsInvalid() {
        int r8 = this.mChildHelper.h();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r8) goto L11;
        c0 r12 = getChildViewHolderInt(this.mChildHelper.g(r11));
        if (r12 == null) goto L10;
        if (r12.o() == true) goto L10;
        r12.b(6);
    L10:
        r11 = r11 + 1;
        goto L4
    L11:
        markItemDecorInsetsDirty();
        v r13 = this.mRecycler;
        ArrayList<c0> r14 = r13.f2342c;
        int r15 = r14.size();
    L12:
        if (r10 >= r15) goto L17;
        c0 r16 = r14.get(r10);
        if (r16 == null) goto L16;
        r16.b(6);
        r16.a(null);
    L16:
        r10 = r10 + 1;
        goto L12
    L17:
        g r17 = r13.f2347h.mAdapter;
        if (r17 != null) goto L20;
    L21:
        r13.f();
        return;
    L20:
        if (r17.f2303b == false) goto L21;
    }

    public void offsetChildrenHorizontal(int r8) {
        int r10 = this.mChildHelper.e();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mChildHelper.d(r11).offsetLeftAndRight(r8);
        r11 = r11 + 1;
        goto L3
    }

    public void offsetChildrenVertical(int r8) {
        int r10 = this.mChildHelper.e();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mChildHelper.d(r11).offsetTopAndBottom(r8);
        r11 = r11 + 1;
        goto L3
    }

    public void offsetPositionRecordsForInsert(int r8, int r10) {
        int r11 = this.mChildHelper.h();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r11) goto L13;
        c0 r14 = getChildViewHolderInt(this.mChildHelper.g(r13));
        if (r14 == null) goto L12;
        if (r14.o() == true) goto L12;
        if (r14.f2283c < r8) goto L12;
        r14.l(r10, false);
        this.mState.f2369f = true;
    L12:
        r13 = r13 + 1;
        goto L4
    L13:
        ArrayList<c0> r15 = this.mRecycler.f2342c;
        int r16 = r15.size();
    L14:
        if (r12 >= r16) goto L21;
        c0 r17 = r15.get(r12);
        if (r17 == null) goto L20;
        if (r17.f2283c < r8) goto L20;
        r17.l(r10, true);
    L20:
        r12 = r12 + 1;
        goto L14
    L21:
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int r11, int r12) {
        int r8 = this.mChildHelper.h();
        int r10 = -1;
        if (r11 >= r12) goto L5;
        int r13 = r11;
        int r14 = r12;
        int r15 = -1;
    L6:
        int r16 = 0;
    L7:
        if (r16 >= r8) goto L19;
        c0 r17 = getChildViewHolderInt(this.mChildHelper.g(r16));
        if (r17 == null) goto L18;
        int r18 = r17.f2283c;
        if (r18 < r13) goto L18;
        if (r18 > r14) goto L18;
        if (r18 != r11) goto L16;
        r17.l(r12 - r11, false);
    L17:
        this.mState.f2369f = true;
        goto L18
    L16:
        r17.l(r15, false);
    L18:
        r16 = r16 + 1;
        goto L7
    L19:
        v r19 = this.mRecycler;
        r19.getClass();
        if (r11 >= r12) goto L22;
        int r20 = r11;
        int r21 = r12;
    L23:
        ArrayList<c0> r22 = r19.f2342c;
        int r23 = r22.size();
        int r24 = 0;
    L24:
        if (r24 >= r23) goto L35;
        c0 r25 = r22.get(r24);
        if (r25 == null) goto L34;
        int r26 = r25.f2283c;
        if (r26 < r20) goto L34;
        if (r26 > r21) goto L34;
        if (r26 != r11) goto L33;
        r25.l(r12 - r11, false);
        goto L34
    L33:
        r25.l(r10, false);
    L34:
        r24 = r24 + 1;
        goto L24
    L35:
        requestLayout();
        return;
    L22:
        r21 = r11;
        r10 = 1;
        r20 = r12;
        goto L23
    L5:
        r14 = r11;
        r13 = r12;
        r15 = 1;
        goto L6
    }

    public void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
        int r8 = r10 + r11;
        int r13 = this.mChildHelper.h();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L16;
        c0 r15 = getChildViewHolderInt(this.mChildHelper.g(r14));
        if (r15 == null) goto L15;
        if (r15.o() == true) goto L15;
        int r16 = r15.f2283c;
        if (r16 < r8) goto L13;
        r15.l(-r11, r12);
    L12:
        this.mState.f2369f = true;
        goto L15
    L13:
        if (r16 < r10) goto L15;
        r15.b(8);
        r15.l(-r11, r12);
        r15.f2283c = r10 - 1;
    L15:
        r14 = r14 + 1;
        goto L4
    L16:
        v r17 = this.mRecycler;
        ArrayList<c0> r18 = r17.f2342c;
        int r19 = r18.size();
    L17:
        r19 = r19 - 1;
        if (r19 < 0) goto L26;
        c0 r20 = r18.get(r19);
        if (r20 == null) goto L17;
        int r21 = r20.f2283c;
        if (r21 >= r8) goto L23;
        if (r21 < r10) goto L17;
        r20.b(8);
        r17.g(r19);
        goto L17
    L23:
        r20.l(-r11, r12);
        goto L17
    L26:
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        this.mFirstLayoutComplete = r8;
        o r10 = this.mLayout;
        if (r10 == null) goto L11;
        r10.f2319g = true;
        r10.P(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L25;
        ThreadLocal<androidx.recyclerview.widget.m> r11 = androidx.recyclerview.widget.m.f2521o;
        androidx.recyclerview.widget.m r12 = r11.get();
        this.mGapWorker = r12;
        if (r12 != null) goto L23;
        this.mGapWorker = new androidx.recyclerview.widget.m();
        WeakHashMap<View, h0> r13 = j0.w.f8437a;
        Display r14 = j0.w.e.b(this);
        if (isInEditMode() == true) goto L21;
        if (r14 == null) goto L21;
        float r15 = r14.getRefreshRate();
        if (r15 < 30.0f) goto L21;
    L22:
        androidx.recyclerview.widget.m r16 = this.mGapWorker;
        r16.f2525m = (long) (1.0E9f / r15);
        r11.set(r16);
    L21:
        r15 = 60.0f;
    L23:
        this.mGapWorker.f2523a.add(this);
        return;
    L25:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        r8 = true;
        goto L8
    }

    public void onChildAttachedToWindow(View r8) {
    }

    public void onChildDetachedFromWindow(View r8) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l r8 = this.mItemAnimator;
        if (r8 == null) goto L5;
        r8.e();
    L5:
        stopScroll();
        this.mIsAttached = false;
        o r10 = this.mLayout;
        if (r10 == null) goto L8;
        r10.f2319g = false;
        r10.Q(this);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
    L10:
        if (androidx.recyclerview.widget.a0.a.f2430d.a() != null) goto L10;
        if (ALLOW_THREAD_GAP_WORK == false) goto L20;
        androidx.recyclerview.widget.m r11 = this.mGapWorker;
        if (r11 == null) goto L21;
        r11.f2523a.remove(this);
        this.mGapWorker = null;
        return;
    L21:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r8) {
        super.onDraw(r8);
        int r10 = this.mItemDecorations.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mItemDecorations.get(r11).d(r8, this);
        r11 = r11 + 1;
        goto L3
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r8) {
        if (this.mLayout != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        if (r8.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r8.getSource() & 2) == 0) goto L21;
        if (this.mLayout.f() == false) goto L15;
        float r10 = -r8.getAxisValue(9);
    L17:
        if (this.mLayout.e() == false) goto L19;
        float r11 = r8.getAxisValue(10);
    L30:
        if (r10 == 0.0f) goto L32;
    L33:
        scrollByInternal((int) (r11 * this.mScaledHorizontalScrollFactor), (int) (r10 * this.mScaledVerticalScrollFactor), r8);
        goto L34
    L32:
        if (r11 == 0.0f) goto L34;
    L19:
        r11 = 0.0f;
        goto L30
    L15:
        r10 = 0.0f;
        goto L17
    L21:
        if ((r8.getSource() & 4194304) == 0) goto L28;
        float r12 = r8.getAxisValue(26);
        if (this.mLayout.f() == false) goto L26;
        r10 = -r12;
        goto L19
    L26:
        if (this.mLayout.e() == false) goto L28;
        r11 = r12;
        r10 = 0.0f;
    L28:
        r10 = 0.0f;
        r11 = 0.0f;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.mLayoutSuppressed == false) goto L5;
        return false;
    L5:
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(r10) == false) goto L9;
        cancelScroll();
        return true;
    L9:
        o r8 = this.mLayout;
        if (r8 != null) goto L12;
        return false;
    L12:
        boolean r11 = r8.e();
        boolean r12 = this.mLayout.f();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = VelocityTracker.obtain();
    L15:
        this.mVelocityTracker.addMovement(r10);
        int r13 = r10.getActionMasked();
        int r14 = r10.getActionIndex();
        if (r13 == 0) goto L49;
        if (r13 == 1) goto L47;
        if (r13 != 2) goto L20;
        int r15 = r10.findPointerIndex(this.mScrollPointerId);
        if (r15 >= 0) goto L33;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r16 = (int) (r10.getX(r15) + 0.5f);
        int r17 = (int) (r10.getY(r15) + 0.5f);
        if (this.mScrollState == 1) goto L59;
        int r18 = r16 - this.mInitialTouchX;
        int r19 = r17 - this.mInitialTouchY;
        if (r11 == true) goto L38;
    L40:
        boolean r20 = false;
    L41:
        if (r12 == true) goto L43;
    L45:
        if (r20 == false) goto L59;
        setScrollState(1);
        goto L59
    L43:
        if (Math.abs(r19) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r17;
        r20 = true;
        goto L45
    L38:
        if (Math.abs(r18) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r16;
        r20 = true;
    L59:
        if (this.mScrollState == 1) goto L61;
        return false;
    L61:
        return true;
    L20:
        if (r13 != 3) goto L22;
        cancelScroll();
        goto L59
    L22:
        if (r13 != 5) goto L24;
        this.mScrollPointerId = r10.getPointerId(r14);
        int r21 = (int) (r10.getX(r14) + 0.5f);
        this.mLastTouchX = r21;
        this.mInitialTouchX = r21;
        int r22 = (int) (r10.getY(r14) + 0.5f);
        this.mLastTouchY = r22;
        this.mInitialTouchY = r22;
        goto L59
    L24:
        if (r13 != 6) goto L59;
        onPointerUp(r10);
        goto L59
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L59
    L49:
        if (this.mIgnoreMotionEventTillDown == false) goto L51;
        this.mIgnoreMotionEventTillDown = false;
    L51:
        this.mScrollPointerId = r10.getPointerId(0);
        int r23 = (int) (r10.getX() + 0.5f);
        this.mLastTouchX = r23;
        this.mInitialTouchX = r23;
        int r24 = (int) (r10.getY() + 0.5f);
        this.mLastTouchY = r24;
        this.mInitialTouchY = r24;
        if (this.mScrollState != 2) goto L54;
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
    L54:
        int[] r25 = this.mNestedOffsets;
        r25[1] = 0;
        r25[0] = 0;
        int r26 = r11;
        if (r12 == false) goto L57;
        r26 = (r11 ? 1 : 0) | 2;
    L57:
        startNestedScroll(r26, 0);
        goto L59
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        f0.h.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        f0.h.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r10) {
        o r11 = this.mLayout;
        if (r11 != null) goto L6;
        defaultOnMeasure(r8, r10);
        return;
    L6:
        boolean r12 = false;
        if (r11.K() == false) goto L24;
        int r13 = View.MeasureSpec.getMode(r8);
        int r14 = View.MeasureSpec.getMode(r10);
        this.mLayout.f2314b.defaultOnMeasure(r8, r10);
        if (r13 != 1073741824) goto L12;
        if (r14 != 1073741824) goto L12;
        r12 = true;
    L12:
        if (r12 == false) goto L14;
        return;
    L14:
        if (this.mAdapter != null) goto L17;
        return;
    L17:
        if (this.mState.f2367d != 1) goto L19;
        dispatchLayoutStep1();
    L19:
        this.mLayout.p0(r8, r10);
        this.mState.f2372i = true;
        dispatchLayoutStep2();
        this.mLayout.r0(r8, r10);
        if (this.mLayout.u0() == false) goto L45;
        this.mLayout.p0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.f2372i = true;
        dispatchLayoutStep2();
        this.mLayout.r0(r8, r10);
        return;
    L45:
        return;
    L24:
        if (this.mHasFixedSize == false) goto L28;
        this.mLayout.f2314b.defaultOnMeasure(r8, r10);
        return;
    L28:
        if (this.mAdapterUpdateDuringMeasure == false) goto L35;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        z r15 = this.mState;
        if (r15.f2374k == false) goto L32;
        r15.f2370g = true;
    L33:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L38:
        g r16 = this.mAdapter;
        if (r16 == null) goto L41;
        this.mState.f2368e = r16.a();
    L42:
        startInterceptRequestLayout();
        this.mLayout.f2314b.defaultOnMeasure(r8, r10);
        stopInterceptRequestLayout(false);
        this.mState.f2370g = false;
        return;
    L41:
        this.mState.f2368e = 0;
        goto L42
    L32:
        this.mAdapterHelper.c();
        this.mState.f2370g = false;
        goto L33
    L35:
        if (this.mState.f2374k == false) goto L38;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r8, Rect r10) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r8, r10);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        this.mPendingSavedState = r10;
        super.onRestoreInstanceState(r10.f1731a);
        o r11 = this.mLayout;
        if (r11 == null) goto L12;
        Parcelable r12 = this.mPendingSavedState.f2270m;
        if (r12 == null) goto L13;
        r11.c0(r12);
        return;
    L13:
        return;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        SavedState r10 = this.mPendingSavedState;
        if (r10 == null) goto L5;
        r8.f2270m = r10.f2270m;
    L10:
        return r8;
    L5:
        o r11 = this.mLayout;
        if (r11 == null) goto L8;
        Parcelable r12 = r11.d0();
    L9:
        r8.f2270m = r12;
        goto L10
    L8:
        r12 = null;
        goto L9
    }

    public void onScrollStateChanged(int r8) {
    }

    public void onScrolled(int r8, int r10) {
    }

    @Override // android.view.View
    public void onSizeChanged(int r8, int r10, int r11, int r12) {
        super.onSizeChanged(r8, r10, r11, r12);
        if (r8 != r11) goto L5;
        if (r10 != r12) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        boolean r8 = false;
        if (this.mLayoutSuppressed == false) goto L5;
    L108:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L108;
        if (dispatchToOnItemTouchListeners(r18) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        o r10 = this.mLayout;
        if (r10 != null) goto L14;
        return false;
    L14:
        boolean r11 = r10.e();
        boolean r12 = this.mLayout.f();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = VelocityTracker.obtain();
    L17:
        int r13 = r18.getActionMasked();
        int r14 = r18.getActionIndex();
        if (r13 != 0) goto L20;
        int[] r15 = this.mNestedOffsets;
        r15[1] = 0;
        r15[0] = 0;
    L20:
        MotionEvent r16 = MotionEvent.obtain(r18);
        int[] r17 = this.mNestedOffsets;
        r16.offsetLocation(r17[0], r17[1]);
        if (r13 == 0) goto L100;
        if (r13 != 1) goto L24;
        this.mVelocityTracker.addMovement(r16);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r11 == false) goto L88;
        float r19 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L89:
        if (r12 == false) goto L91;
        float r20 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L93:
        if (r19 != 0.0f) goto L97;
        if (r20 != 0.0f) goto L97;
    L98:
        setScrollState(0);
    L99:
        resetScroll();
        r8 = true;
    L104:
        if (r8 == true) goto L106;
        this.mVelocityTracker.addMovement(r16);
    L106:
        r16.recycle();
        return true;
    L97:
        if (fling((int) r19, (int) r20) == true) goto L99;
    L91:
        r20 = 0.0f;
        goto L93
    L88:
        r19 = 0.0f;
        goto L89
    L24:
        if (r13 != 2) goto L26;
        int r21 = r18.findPointerIndex(this.mScrollPointerId);
        if (r21 >= 0) goto L39;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L39:
        int r110 = (int) (r18.getX(r21) + 0.5f);
        int r111 = (int) (r18.getY(r21) + 0.5f);
        int r22 = this.mLastTouchX - r110;
        int r23 = this.mLastTouchY - r111;
        if (this.mScrollState == 1) goto L58;
        if (r11 == false) goto L48;
        int r24 = this.mTouchSlop;
        if (r22 <= 0) goto L45;
        r22 = Math.max(0, r22 - r24);
    L46:
        if (r22 == 0) goto L48;
        boolean r25 = true;
    L49:
        if (r12 == false) goto L56;
        int r26 = this.mTouchSlop;
        if (r23 <= 0) goto L53;
        r23 = Math.max(0, r23 - r26);
    L54:
        if (r23 == 0) goto L56;
        r25 = true;
        goto L56
    L53:
        r23 = Math.min(0, r23 + r26);
    L56:
        if (r25 == false) goto L58;
        setScrollState(1);
        goto L58
    L45:
        r22 = Math.min(0, r22 + r24);
    L48:
        r25 = false;
    L58:
        int r112 = r22;
        int r113 = r23;
        if (this.mScrollState != 1) goto L104;
        int[] r27 = this.mReusableIntPair;
        r27[0] = 0;
        r27[1] = 0;
        if (r11 == false) goto L63;
        int r28 = r112;
    L64:
        if (r12 == false) goto L66;
        int r29 = r113;
    L68:
        if (dispatchNestedPreScroll(r28, r29, r27, this.mScrollOffset, 0) == false) goto L70;
        int[] r30 = this.mReusableIntPair;
        r112 = r112 - r30[0];
        r113 = r113 - r30[1];
        int[] r31 = this.mNestedOffsets;
        int r32 = r31[0];
        int[] r33 = this.mScrollOffset;
        r31[0] = r32 + r33[0];
        r31[1] = r31[1] + r33[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L70:
        int r34 = r113;
        int[] r35 = this.mScrollOffset;
        this.mLastTouchX = r110 - r35[0];
        this.mLastTouchY = r111 - r35[1];
        if (r11 == false) goto L73;
        int r36 = r112;
    L74:
        if (r12 == false) goto L76;
        int r37 = r34;
    L78:
        if (scrollByInternal(r36, r37, r18) == false) goto L80;
        getParent().requestDisallowInterceptTouchEvent(true);
    L80:
        androidx.recyclerview.widget.m r38 = this.mGapWorker;
        if (r38 == null) goto L104;
        if (r112 != 0) goto L84;
        if (r34 == 0) goto L104;
    L84:
        r38.a(this, r112, r34);
        goto L104
    L76:
        r37 = 0;
        goto L78
    L73:
        r36 = 0;
        goto L74
    L66:
        r29 = 0;
        goto L68
    L63:
        r28 = 0;
        goto L64
    L26:
        if (r13 != 3) goto L28;
        cancelScroll();
        goto L104
    L28:
        if (r13 != 5) goto L30;
        this.mScrollPointerId = r18.getPointerId(r14);
        int r39 = (int) (r18.getX(r14) + 0.5f);
        this.mLastTouchX = r39;
        this.mInitialTouchX = r39;
        int r40 = (int) (r18.getY(r14) + 0.5f);
        this.mLastTouchY = r40;
        this.mInitialTouchY = r40;
        goto L104
    L30:
        if (r13 != 6) goto L104;
        onPointerUp(r18);
        goto L104
    L100:
        this.mScrollPointerId = r18.getPointerId(0);
        int r41 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r41;
        this.mInitialTouchX = r41;
        int r42 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r42;
        this.mInitialTouchY = r42;
        int r114 = r11;
        if (r12 == false) goto L103;
        r114 = (r11 ? 1 : 0) | 2;
    L103:
        startNestedScroll(r114, 0);
        goto L104
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        Runnable r8 = this.mItemAnimatorRunner;
        WeakHashMap<View, h0> r10 = j0.w.f8437a;
        j0.w.d.m(this, r8);
        this.mPostedAnimatorRunner = true;
        return;
    }

    public void processDataSetCompletelyChanged(boolean r8) {
        this.mDispatchItemsChangedEvent = r8 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(c0 r8, l.c r10) {
        boolean r11 = false;
        int r12 = (r8.f2290j & (-8193)) | 0;
        r8.f2290j = r12;
        if (this.mState.f2371h == true) goto L5;
    L13:
        n.h<c0, androidx.recyclerview.widget.a0.a> r13 = this.mViewInfoStore.f2428a;
        androidx.recyclerview.widget.a0.a r14 = r13.getOrDefault(r8, null);
        if (r14 != null) goto L16;
        r14 = androidx.recyclerview.widget.a0.a.a();
        r13.put(r8, r14);
    L16:
        r14.f2432b = r10;
        r14.f2431a |= 4;
        return;
    L5:
        if ((r12 & 2) == 0) goto L7;
        r11 = true;
    L7:
        if (r11 == false) goto L13;
        if (r8.i() == true) goto L13;
        if (r8.o() == true) goto L13;
        this.mViewInfoStore.f2429b.g(getChangedHolderKey(r8), r8);
        goto L13
    }

    public void removeAndRecycleViews() {
        l r8 = this.mItemAnimator;
        if (r8 == null) goto L5;
        r8.e();
    L5:
        o r10 = this.mLayout;
        if (r10 == null) goto L8;
        r10.f0(this.mRecycler);
        this.mLayout.g0(this.mRecycler);
    L8:
        v r11 = this.mRecycler;
        r11.f2340a.clear();
        r11.f();
    }

    public boolean removeAnimatingView(View r8) {
        startInterceptRequestLayout();
        androidx.recyclerview.widget.b r10 = this.mChildHelper;
        e r11 = (e) r10.f2434a;
        int r12 = r11.f2300a.indexOfChild(r8);
        if (r12 != (-1)) goto L5;
        r10.k(r8);
    L8:
        boolean r13 = true;
    L10:
        if (r13 == false) goto L12;
        c0 r14 = getChildViewHolderInt(r8);
        this.mRecycler.l(r14);
        this.mRecycler.i(r14);
    L12:
        stopInterceptRequestLayout(!r13);
        return r13;
    L5:
        androidx.recyclerview.widget.b.a r15 = r10.f2435b;
        if (r15.d(r12) == false) goto L9;
        r15.f(r12);
        r10.k(r8);
        r11.b(r12);
        goto L8
    L9:
        r13 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r8, boolean r10) {
        c0 r11 = getChildViewHolderInt(r8);
        if (r11 != null) goto L5;
    L12:
        r8.clearAnimation();
        dispatchChildDetached(r8);
        super.removeDetachedView(r8, r10);
        return;
    L5:
        if (r11.k() == false) goto L8;
        r11.f2290j &= -257;
        goto L12
    L8:
        if (r11.o() == true) goto L12;
        StringBuilder r12 = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
        r12.append(r11);
        throw new IllegalArgumentException(android.aimedia.a.b(this, r12));
    }

    public void removeItemDecoration(n r8) {
        o r10 = this.mLayout;
        if (r10 == null) goto L5;
        r10.c("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r8);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r11 = true;
    L11:
        setWillNotDraw(r11);
        goto L12
    L10:
        r11 = false;
        goto L11
    }

    public void removeItemDecorationAt(int r8) {
        int r10 = getItemDecorationCount();
        if (r8 < 0) goto L8;
        if (r8 >= r10) goto L8;
        removeItemDecoration(getItemDecorationAt(r8));
        return;
    L8:
        throw new IndexOutOfBoundsException(r8 + " is an invalid index for size " + r10);
    }

    public void removeOnChildAttachStateChangeListener(q r8) {
        List<q> r10 = this.mOnChildAttachStateListeners;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.remove(r8);
    }

    public void removeOnItemTouchListener(s r8) {
        this.mOnItemTouchListeners.remove(r8);
        if (this.mInterceptingOnItemTouchListener != r8) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    public void removeOnScrollListener(t r8) {
        List<t> r10 = this.mScrollListeners;
        if (r10 == null) goto L6;
        r10.remove(r8);
        return;
    }

    public void repositionShadowingViews() {
        int r8 = this.mChildHelper.e();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L14;
        View r11 = this.mChildHelper.d(r10);
        c0 r12 = getChildViewHolder(r11);
        if (r12 == null) goto L13;
        c0 r13 = r12.f2289i;
        if (r13 == null) goto L13;
        View r14 = r13.f2281a;
        int r15 = r11.getLeft();
        int r16 = r11.getTop();
        if (r15 == r14.getLeft()) goto L11;
    L12:
        r14.layout(r15, r16, r14.getWidth() + r15, r14.getHeight() + r16);
        goto L13
    L11:
        if (r16 != r14.getTop()) goto L12;
    L13:
        r10 = r10 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r8, View r10) {
        y r11 = this.mLayout.f2317e;
        boolean r12 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
    L13:
        if (r12 == true) goto L16;
        if (r10 == null) goto L16;
        requestChildOnScreen(r8, r10);
    L16:
        super.requestChildFocus(r8, r10);
        return;
    L10:
        if (isComputingLayout() == true) goto L13;
        r12 = false;
        goto L13
    L5:
        if (r11.f2353e == false) goto L7;
        r13 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r8, Rect r10, boolean r11) {
        return this.mLayout.j0(this, r8, r10, r11, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r8) {
        int r10 = this.mOnItemTouchListeners.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mOnItemTouchListeners.get(r11).b();
        r11 = r11 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r8);
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

    public void saveOldPositions() {
        int r8 = this.mChildHelper.h();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L10;
        c0 r11 = getChildViewHolderInt(this.mChildHelper.g(r10));
        if (r11.o() == true) goto L9;
        if (r11.f2284d != (-1)) goto L9;
        r11.f2284d = r11.f2283c;
    L9:
        r10 = r10 + 1;
        goto L3
    }

    @Override // android.view.View
    public void scrollBy(int r8, int r10) {
        o r11 = this.mLayout;
        if (r11 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r12 = r11.e();
        boolean r13 = this.mLayout.f();
        if (r12 == true) goto L13;
        if (r13 == true) goto L13;
        return;
    L13:
        if (r12 == true) goto L16;
        r8 = 0;
    L16:
        if (r13 == true) goto L19;
        r10 = 0;
    L19:
        scrollByInternal(r8, r10, null);
    }

    public boolean scrollByInternal(int r19, int r20, MotionEvent r21) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r8 = this.mReusableIntPair;
        r8[0] = 0;
        r8[1] = 0;
        scrollStep(r19, r20, r8);
        int[] r10 = this.mReusableIntPair;
        int r11 = r10[0];
        int r12 = r10[1];
        int r14 = r12;
        int r15 = r11;
        int r16 = r19 - r11;
        int r17 = r20 - r12;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r13 = this.mReusableIntPair;
        r13[0] = 0;
        r13[1] = 0;
        dispatchNestedScroll(r15, r14, r16, r17, this.mScrollOffset, 0, r13);
        int[] r18 = this.mReusableIntPair;
        int r22 = r18[0];
        int r23 = r16 - r22;
        int r24 = r18[1];
        int r25 = r17 - r24;
        if (r22 != 0) goto L14;
        if (r24 != 0) goto L14;
        boolean r26 = false;
    L15:
        int r27 = this.mLastTouchX;
        int[] r28 = this.mScrollOffset;
        int r29 = r28[0];
        this.mLastTouchX = r27 - r29;
        int r30 = this.mLastTouchY;
        int r31 = r28[1];
        this.mLastTouchY = r30 - r31;
        int[] r32 = this.mNestedOffsets;
        r32[0] = r32[0] + r29;
        r32[1] = r32[1] + r31;
        if (getOverScrollMode() == 2) goto L22;
        if (r21 != null) goto L19;
    L21:
        considerReleasingGlowsOnScroll(r19, r20);
        goto L22
    L19:
        if (t2.b.I(r21, 8194) == true) goto L21;
        pullGlows(r21.getX(), r23, r21.getY(), r25);
    L22:
        if (r15 != 0) goto L24;
        if (r14 != 0) goto L24;
    L26:
        if (awakenScrollBars() == true) goto L28;
        invalidate();
    L28:
        if (r26 == true) goto L34;
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
    L14:
        r26 = true;
        goto L15
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        goto L7
    }

    public void scrollStep(int r8, int r10, int[] r11) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        f0.h.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r8 == 0) goto L5;
        int r12 = this.mLayout.l0(r8, this.mRecycler, this.mState);
    L6:
        if (r10 == 0) goto L8;
        int r13 = this.mLayout.n0(r10, this.mRecycler, this.mState);
    L9:
        f0.h.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r11 == null) goto L13;
        r11[0] = r12;
        r11[1] = r13;
        return;
    L13:
        return;
    L8:
        r13 = 0;
        goto L9
    L5:
        r12 = 0;
        goto L6
    }

    @Override // android.view.View
    public void scrollTo(int r8, int r10) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int r8) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        o r10 = this.mLayout;
        if (r10 != null) goto L9;
        Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r10.m0(r8);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r8) {
        if (shouldDeferAccessibilityEvent(r8) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r8);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.v r8) {
        this.mAccessibilityDelegate = r8;
        j0.w.m(this, r8);
    }

    public void setAdapter(g r8) {
        setLayoutFrozen(false);
        setAdapterInternal(r8, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        setChildrenDrawingOrderEnabled(false);
    }

    public boolean setChildImportantForAccessibilityInternal(c0 r8, int r10) {
        if (isComputingLayout() == false) goto L6;
        r8.f2297q = r10;
        this.mPendingAccessibilityImportanceChange.add(r8);
        return false;
    L6:
        View r11 = r8.f2281a;
        WeakHashMap<View, h0> r12 = j0.w.f8437a;
        j0.w.d.s(r11, r10);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r8) {
        if (r8 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r8;
        super.setClipToPadding(r8);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(k r8) {
        r8.getClass();
        this.mEdgeEffectFactory = r8;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean r8) {
        this.mHasFixedSize = r8;
    }

    public void setItemAnimator(l r8) {
        l r10 = this.mItemAnimator;
        if (r10 == null) goto L5;
        r10.e();
        this.mItemAnimator.f2304a = null;
    L5:
        this.mItemAnimator = r8;
        if (r8 == null) goto L9;
        r8.f2304a = this.mItemAnimatorListener;
        return;
    }

    public void setItemViewCacheSize(int r8) {
        v r10 = this.mRecycler;
        r10.f2344e = r8;
        r10.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean r8) {
        suppressLayout(r8);
    }

    public void setLayoutManager(o r8) {
        if (r8 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        int r10 = 0;
        if (this.mLayout == null) goto L14;
        l r11 = this.mItemAnimator;
        if (r11 == null) goto L10;
        r11.e();
    L10:
        this.mLayout.f0(this.mRecycler);
        this.mLayout.g0(this.mRecycler);
        v r12 = this.mRecycler;
        r12.f2340a.clear();
        r12.f();
        if (this.mIsAttached == false) goto L13;
        o r13 = this.mLayout;
        r13.f2319g = false;
        r13.Q(this);
    L13:
        this.mLayout.s0(null);
        this.mLayout = null;
    L15:
        androidx.recyclerview.widget.b r14 = this.mChildHelper;
        r14.f2435b.g();
        ArrayList r15 = r14.f2436c;
        int r16 = r15.size();
    L16:
        r16 = r16 - 1;
        androidx.recyclerview.widget.b.InterfaceC0021b r17 = r14.f2434a;
        if (r16 < 0) goto L22;
        View r18 = (View) r15.get(r16);
        e r19 = (e) r17;
        r19.getClass();
        c0 r20 = getChildViewHolderInt(r18);
        if (r20 == null) goto L21;
        r19.f2300a.setChildImportantForAccessibilityInternal(r20, r20.f2296p);
        r20.f2296p = 0;
    L21:
        r15.remove(r16);
        goto L16
    L22:
        e r21 = (e) r17;
        int r22 = r21.a();
    L23:
        RecyclerView r23 = r21.f2300a;
        if (r10 >= r22) goto L26;
        View r24 = r23.getChildAt(r10);
        r23.dispatchChildDetached(r24);
        r24.clearAnimation();
        r10 = r10 + 1;
        goto L23
    L26:
        r23.removeAllViews();
        this.mLayout = r8;
        if (r8 != null) goto L29;
    L35:
        this.mRecycler.m();
        requestLayout();
        return;
    L29:
        if (r8.f2314b != null) goto L33;
        r8.s0(this);
        if (this.mIsAttached == false) goto L35;
        o r25 = this.mLayout;
        r25.f2319g = true;
        r25.P(this);
        goto L35
    L33:
        StringBuilder r26 = new StringBuilder("LayoutManager ");
        r26.append(r8);
        r26.append(" is already attached to a RecyclerView:");
        throw new IllegalArgumentException(android.aimedia.a.b(r8.f2314b, r26));
    L14:
        v r27 = this.mRecycler;
        r27.f2340a.clear();
        r27.f();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r8) {
        if (r8 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r8) {
        j0.m r10 = getScrollingChildHelper();
        if (r10.f8406d == false) goto L5;
        WeakHashMap<View, h0> r11 = j0.w.f8437a;
        j0.w.i.z(r10.f8405c);
    L5:
        r10.f8406d = r8;
    }

    public void setOnFlingListener(r r8) {
        this.mOnFlingListener = r8;
    }

    @Deprecated
    public void setOnScrollListener(t r8) {
        this.mScrollListener = r8;
    }

    public void setPreserveFocusAfterLayout(boolean r8) {
        this.mPreserveFocusAfterLayout = r8;
    }

    public void setRecycledViewPool(u r8) {
        v r10 = this.mRecycler;
        u r11 = r10.f2346g;
        if (r11 == null) goto L5;
        r11.f2335b--;
    L5:
        r10.f2346g = r8;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r10.f2347h.getAdapter() == null) goto L12;
        r10.f2346g.f2335b++;
        return;
    }

    public void setRecyclerListener(w r8) {
    }

    void setScrollState(int r8) {
        if (r8 != this.mScrollState) goto L5;
        return;
    L5:
        this.mScrollState = r8;
        if (r8 == 2) goto L8;
        stopScrollersInternal();
    L8:
        dispatchOnScrollStateChanged(r8);
    }

    public void setScrollingTouchSlop(int r8) {
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        if (r8 != 0) goto L5;
    L8:
        int r11 = r10.getScaledTouchSlop();
    L9:
        this.mTouchSlop = r11;
        return;
    L5:
        if (r8 == 1) goto L7;
        Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + r8 + "; using default value");
        goto L8
    L7:
        r11 = r10.getScaledPagingTouchSlop();
        goto L9
    }

    public void setViewCacheExtension(a0 r8) {
        this.mRecycler.getClass();
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent r8) {
        int r10 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r8 == null) goto L6;
        int r11 = k0.b.a(r8);
    L7:
        if (r11 == 0) goto L10;
        r10 = r11;
    L10:
        this.mEatenAccessibilityChangeFlags |= r10;
        return true;
    L6:
        r11 = 0;
        goto L7
    L12:
        return false;
    }

    public void smoothScrollBy(int r8, int r10) {
        smoothScrollBy(r8, r10, null);
    }

    public void smoothScrollToPosition(int r8) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        o r10 = this.mLayout;
        if (r10 != null) goto L9;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r10.w0(this, r8);
    }

    public void startInterceptRequestLayout() {
        int r8 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r8;
        if (r8 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int r8) {
        return getScrollingChildHelper().g(r8, 0);
    }

    public void stopInterceptRequestLayout(boolean r8) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L6;
        this.mInterceptRequestLayoutDepth = 1;
    L6:
        if (r8 == true) goto L11;
        if (this.mLayoutSuppressed == true) goto L11;
        this.mLayoutWasDefered = false;
    L11:
        if (this.mInterceptRequestLayoutDepth != 1) goto L25;
        if (r8 == false) goto L23;
        if (this.mLayoutWasDefered == false) goto L23;
        if (this.mLayoutSuppressed == true) goto L23;
        if (this.mLayout == null) goto L23;
        if (this.mAdapter == null) goto L23;
        dispatchLayout();
    L23:
        if (this.mLayoutSuppressed == true) goto L25;
        this.mLayoutWasDefered = false;
    L25:
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().h(0);
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
        long r8 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r8, r8, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    public void swapAdapter(g r8, boolean r10) {
        setLayoutFrozen(false);
        setAdapterInternal(r8, true, r10);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int r8, int r10, Object r11) {
        int r12 = this.mChildHelper.h();
        int r13 = r10 + r8;
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L15;
        View r15 = this.mChildHelper.g(r14);
        c0 r16 = getChildViewHolderInt(r15);
        if (r16 == null) goto L14;
        if (r16.o() == true) goto L14;
        int r17 = r16.f2283c;
        if (r17 < r8) goto L14;
        if (r17 >= r13) goto L14;
        r16.b(2);
        r16.a(r11);
        ((p) r15.getLayoutParams()).mInsetsDirty = true;
    L14:
        r14 = r14 + 1;
        goto L4
    L15:
        v r18 = this.mRecycler;
        ArrayList<c0> r19 = r18.f2342c;
        int r20 = r19.size();
    L16:
        r20 = r20 - 1;
        if (r20 < 0) goto L25;
        c0 r21 = r19.get(r20);
        if (r21 == null) goto L16;
        int r22 = r21.f2283c;
        if (r22 < r8) goto L16;
        if (r22 >= r13) goto L16;
        r21.b(2);
        r18.g(r20);
        goto L16
    }

    public RecyclerView(Context r8, AttributeSet r10) {
        this(r8, r10, com.obric.cae.R.attr.recyclerViewStyle);
    }

    public void addItemDecoration(n r8, int r10) {
        o r11 = this.mLayout;
        if (r11 == null) goto L6;
        r11.c("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r10 >= 0) goto L10;
        this.mItemDecorations.add(r8);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        this.mItemDecorations.add(r10, r8);
        goto L11
    }

    public boolean dispatchNestedPreScroll(int r8, int r10, int[] r11, int[] r12, int r13) {
        return getScrollingChildHelper().c(r8, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return getScrollingChildHelper().e(r10, r11, r12, r13, r14, 0, null);
    }

    public c0 findViewHolderForPosition(int r8, boolean r10) {
        int r11 = this.mChildHelper.h();
        c0 r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L20;
        c0 r14 = getChildViewHolderInt(this.mChildHelper.g(r13));
        if (r14 == null) goto L19;
        if (r14.i() == true) goto L19;
        if (r10 == false) goto L13;
        if (r14.f2283c != r8) goto L19;
    L16:
        if (this.mChildHelper.j(r14.f2281a) == false) goto L18;
        r12 = r14;
        goto L19
    L18:
        return r14;
    L13:
        if (r14.c() == r8) goto L16;
    L19:
        r13 = r13 + 1;
        goto L3
    L20:
        return r12;
    }

    public boolean hasNestedScrollingParent(int r8) {
        if (getScrollingChildHelper().f(r8) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void onExitLayoutOrScroll(boolean r8) {
        int r10 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r10;
        if (r10 >= 1) goto L8;
        this.mLayoutOrScrollCounter = 0;
        if (r8 == false) goto L9;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    L9:
        return;
    }

    public void smoothScrollBy(int r8, int r10, Interpolator r11) {
        smoothScrollBy(r8, r10, r11, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int r8, int r10) {
        return getScrollingChildHelper().g(r8, r10);
    }

    public void stopNestedScroll(int r8) {
        getScrollingChildHelper().h(r8);
    }

    public RecyclerView(Context r17, AttributeSet r18, int r19) {
        super(r17, r18, r19);
        this.mObserver = new x(this);
        this.mRecycler = new v(this);
        this.mViewInfoStore = new androidx.recyclerview.widget.a0();
        this.mUpdateChildViewsRunnable = new a(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new k();
        this.mItemAnimator = new androidx.recyclerview.widget.k();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new b0(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        androidx.recyclerview.widget.m.b r8 = new androidx.recyclerview.widget.m.b();
    L6:
        this.mPrefetchRegistry = r8;
        this.mState = new z();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new m(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b(this);
        this.mViewInfoProcessCallback = new d(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r10 = ViewConfiguration.get(r17);
        this.mTouchSlop = r10.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = j0.y.a(r10);
        this.mScaledVerticalScrollFactor = j0.y.b(r10);
        this.mMinFlingVelocity = r10.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r10.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() != 2) goto L9;
        boolean r11 = true;
    L10:
        setWillNotDraw(r11);
        this.mItemAnimator.f2304a = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        WeakHashMap<View, h0> r12 = j0.w.f8437a;
        if (j0.w.d.c(this) != 0) goto L13;
        j0.w.d.s(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.v(this));
        int[] r13 = w0.a.f12951a;
        TypedArray r15 = r17.obtainStyledAttributes(r18, r13, r19, 0);
        saveAttributeDataForStyleable(r17, r13, r18, r15, r19, 0);
        String r14 = r15.getString(8);
        if (r15.getInt(2, -1) != (-1)) goto L16;
        setDescendantFocusability(262144);
    L16:
        this.mClipToPadding = r15.getBoolean(1, true);
        boolean r16 = r15.getBoolean(3, false);
        this.mEnableFastScroller = r16;
        if (r16 == false) goto L19;
        initFastScroller((StateListDrawable) r15.getDrawable(6), r15.getDrawable(7), (StateListDrawable) r15.getDrawable(4), r15.getDrawable(5));
    L19:
        r15.recycle();
        createLayoutManager(r17, r14, r18, r19, 0);
        int[] r20 = NESTED_SCROLLING_ATTRS;
        TypedArray r110 = r17.obtainStyledAttributes(r18, r20, r19, 0);
        saveAttributeDataForStyleable(r17, r20, r18, r110, r19, 0);
        boolean r21 = r110.getBoolean(0, true);
        r110.recycle();
        setNestedScrollingEnabled(r21);
        return;
    L9:
        r11 = false;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return getScrollingChildHelper().e(r10, r11, r12, r13, r14, r15, null);
    }

    public void smoothScrollBy(int r8, int r10, Interpolator r11, int r12) {
        smoothScrollBy(r8, r10, r11, r12, false);
    }

    public void smoothScrollBy(int r8, int r10, Interpolator r11, int r12, boolean r13) {
        o r14 = this.mLayout;
        if (r14 != null) goto L7;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r15 = 0;
        if (r14.e() == true) goto L13;
        r8 = 0;
    L13:
        if (this.mLayout.f() == true) goto L15;
        r10 = 0;
    L15:
        if (r8 != 0) goto L18;
        if (r10 != 0) goto L18;
        return;
    L18:
        if (r12 == Integer.MIN_VALUE) goto L22;
        if (r12 > 0) goto L22;
        boolean r16 = false;
    L23:
        if (r16 == false) goto L31;
        if (r13 == false) goto L30;
        if (r8 == 0) goto L27;
        r15 = 1;
    L27:
        if (r10 == 0) goto L29;
        r15 = r15 | 2;
    L29:
        startNestedScroll(r15, 1);
    L30:
        this.mViewFlinger.b(r8, r10, r11, r12);
        return;
    L31:
        scrollBy(r8, r10);
        return;
    L22:
        r16 = true;
        goto L23
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        o r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.u(r8);
    L7:
        throw new IllegalStateException(android.aimedia.a.b(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
