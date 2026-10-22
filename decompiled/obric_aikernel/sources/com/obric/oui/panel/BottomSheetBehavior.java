package com.obric.oui.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import q5.l;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;

    @NonNull
    private final ArrayList<d> callbacks;
    protected int collapsedOffset;
    private final com.obric.oui.panel.c.AbstractC0130c dragCallback;
    private boolean draggable;
    protected boolean fitToContents;
    protected int fitToContentsOffset;
    boolean fitsSystemWindow;
    int halfExpandedOffset;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private e interceptTouchEvent;
    private boolean is69Mode;
    private int lastNestedScrollDy;
    protected int lastPeekHeight;
    private boolean mAdaptPortraitRLSlide;
    private boolean mAutoSlideToPeekHeight;
    private int mMaxSettleDuration;
    private int maxExpandedHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    protected int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private final com.obric.oui.panel.c.AbstractC0130c rlDragCallback;
    com.obric.oui.panel.a rlDragHelper;
    private boolean skipCollapsed;
    int state;
    int targetState;
    boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    com.obric.oui.panel.c viewDragHelper;
    WeakReference<V> viewRef;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final int state;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ SavedState createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r10) {
            this(r10, null);
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.state = r10.readInt();
        }

        public SavedState(Parcelable r10, int r11) {
            super(r10);
            this.state = r11;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.state);
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6937c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6938g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f6939h;

        a(BottomSheetBehavior r10, View r11, int r12) {
            this.f6939h = r10;
            this.f6937c = r11;
            this.f6938g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6939h.startSettlingAnimation(this.f6937c, this.f6938g);
        }
    }

    class b extends com.obric.oui.panel.c.AbstractC0130c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f6940a;

        b(BottomSheetBehavior r10) {
            this.f6940a = r10;
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public int a(@NonNull View r10, int r11, int r12) {
            return r10.getLeft();
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public int b(@NonNull View r10, int r11, int r12) {
            int r13 = BottomSheetBehavior.access$200(this.f6940a);
            BottomSheetBehavior r14 = this.f6940a;
            if (r14.hideable == false) goto L5;
            int r15 = r14.parentHeight;
        L7:
            return MathUtils.clamp(r11, r13, r15);
        L5:
            r15 = r14.collapsedOffset;
            goto L7
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public int e(@NonNull View r10) {
            BottomSheetBehavior r11 = this.f6940a;
            if (r11.hideable == false) goto L7;
            return r11.parentHeight;
        L7:
            return r11.collapsedOffset;
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public void j(int r10) {
            if (r10 == 1) goto L5;
            return;
        L5:
            if (BottomSheetBehavior.access$000(this.f6940a) == false) goto L9;
            this.f6940a.setStateInternal(1);
            return;
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public void k(@NonNull View r10, int r11, int r12, int r13, int r14) {
            this.f6940a.dispatchOnSlide(r12);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public void l(@NonNull View r10, float r11, float r12) {
            int[] r13 = BottomSheetBehavior.access$100(this.f6940a, r10, r11, r12);
            int r14 = r13[0];
            int r15 = r13[1];
            BottomSheetBehavior r16 = this.f6940a;
            r16.targetState = r15;
            if (r16.viewDragHelper.G(r10.getLeft(), r14) == false) goto L5;
            this.f6940a.setStateInternal(2);
            ViewCompat.postOnAnimation(r10, new g(this.f6940a, r10, r15));
            return;
        L5:
            this.f6940a.setStateInternal(r15);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public boolean m(@NonNull View r10, int r11) {
            BottomSheetBehavior r12 = this.f6940a;
            int r13 = r12.state;
            if (r13 != 1) goto L6;
            return false;
        L6:
            if (r12.touchingScrollingChild == false) goto L9;
            return false;
        L9:
            if (r13 == 3) goto L11;
        L17:
            WeakReference<V> r14 = this.f6940a.viewRef;
            if (r14 == null) goto L23;
            if (r14.get() != r10) goto L23;
            return true;
        L23:
            return false;
        L11:
            if (r12.activePointerId != r11) goto L17;
            View r15 = r12.nestedScrollingChildRef.get();
            if (r15 == null) goto L17;
            if (r15.canScrollVertically(-1) == false) goto L17;
            return false;
        }
    }

    class c extends com.obric.oui.panel.c.AbstractC0130c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f6941a;

        c(BottomSheetBehavior r10) {
            this.f6941a = r10;
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public int a(@NonNull View r10, int r11, int r12) {
            return BottomSheetBehavior.access$300(this.f6941a).a(r10, r11, r12);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public int b(@NonNull View r10, int r11, int r12) {
            return BottomSheetBehavior.access$300(this.f6941a).b(r10, r11, r12);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public int e(@NonNull View r10) {
            return BottomSheetBehavior.access$300(this.f6941a).e(r10);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public void j(int r10) {
            BottomSheetBehavior.access$300(this.f6941a).j(r10);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public void k(@NonNull View r10, int r11, int r12, int r13, int r14) {
            BottomSheetBehavior.access$300(this.f6941a).k(r10, r11, r12, r13, r14);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public void l(@NonNull View r10, float r11, float r12) {
            int[] r13 = BottomSheetBehavior.access$100(this.f6941a, r10, r11, r12);
            int r14 = r13[0];
            int r15 = r13[1];
            BottomSheetBehavior r16 = this.f6941a;
            r16.targetState = r15;
            if (r16.rlDragHelper.r(r10, r10.getLeft(), r14, (int) r11, (int) r12) == false) goto L5;
            this.f6941a.setStateInternal(2);
            ViewCompat.postOnAnimation(r10, new f(this.f6941a, r10, r15));
            return;
        L5:
            this.f6941a.setStateInternal(r15);
        }

        @Override // com.obric.oui.panel.c.AbstractC0130c
        public boolean m(@NonNull View r10, int r11) {
            return BottomSheetBehavior.access$300(this.f6941a).m(r10, r11);
        }
    }

    public static abstract class d {
        public d() {
        }

        public void a(float r10) {
        }

        public void b(float r10) {
        }

        public abstract void c(@NonNull View r10, float r11);

        public abstract void d(@NonNull View r10, int r11);
    }

    public interface e {
        boolean a(MotionEvent r10, int r11, int r12);
    }

    private class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f6942c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f6943g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f6944h;

        f(BottomSheetBehavior r10, View r11, int r12) {
            this.f6944h = r10;
            this.f6942c = r11;
            this.f6943g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.oui.panel.a r10 = this.f6944h.rlDragHelper;
            if (r10 != null) goto L5;
        L7:
            this.f6944h.setStateInternal(this.f6943g);
            return;
        L5:
            if (r10.h(this.f6942c, true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f6942c, this);
        }
    }

    private class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f6945c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f6946g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f6947h;

        g(BottomSheetBehavior r10, View r11, int r12) {
            this.f6947h = r10;
            this.f6945c = r11;
            this.f6946g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.oui.panel.c r10 = this.f6947h.viewDragHelper;
            if (r10 != null) goto L5;
        L7:
            this.f6947h.setStateInternal(this.f6946g);
            return;
        L5:
            if (r10.k(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f6945c, this);
        }
    }

    public BottomSheetBehavior() {
        this.fitToContents = true;
        this.is69Mode = false;
        this.maxExpandedHeight = -1;
        this.draggable = true;
        this.skipCollapsed = false;
        this.state = 4;
        this.targetState = 4;
        this.callbacks = new ArrayList();
        this.fitsSystemWindow = true;
        this.mAdaptPortraitRLSlide = false;
        this.mAutoSlideToPeekHeight = true;
        this.mMaxSettleDuration = 600;
        this.dragCallback = new b(this);
        this.rlDragCallback = new c(this);
    }

    public BottomSheetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.fitToContents = true;
        this.is69Mode = false;
        this.maxExpandedHeight = -1;
        this.draggable = true;
        this.skipCollapsed = false;
        this.state = 4;
        this.targetState = 4;
        this.callbacks = new ArrayList();
        this.fitsSystemWindow = true;
        this.mAdaptPortraitRLSlide = false;
        this.mAutoSlideToPeekHeight = true;
        this.mMaxSettleDuration = 600;
        this.dragCallback = new b(this);
        this.rlDragCallback = new c(this);
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.BottomSheetBehavior_Layout);
        int r13 = l.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue r14 = r12.peekValue(r13);
        if (r14 == null) goto L7;
        int r15 = r14.data;
        if (r15 != (-1)) goto L7;
        setPeekHeight(r15);
    L8:
        setHideable(r12.getBoolean(l.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(r12.getBoolean(l.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r12.getBoolean(l.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        r12.recycle();
        this.maximumVelocity = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r12.getDimensionPixelSize(r13, -1));
        goto L8
    }

    static /* synthetic */ boolean access$000(BottomSheetBehavior r10) {
        return r10.draggable;
    }

    static /* synthetic */ int[] access$100(BottomSheetBehavior r10, View r11, float r12, float r13) {
        return r10.getReleaseParam(r11, r12, r13);
    }

    static /* synthetic */ int access$200(BottomSheetBehavior r10) {
        return r10.getExpandedOffset();
    }

    static /* synthetic */ com.obric.oui.panel.c.AbstractC0130c access$300(BottomSheetBehavior r10) {
        return r10.dragCallback;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.LayoutParams) r11).getBehavior();
        if ((r12 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r12;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getExpandedOffset() {
        if (this.fitToContents == true) goto L7;
        return 0;
    L7:
        return this.fitToContentsOffset;
    }

    private int[] getReleaseParam(@NonNull View r10, float r11, float r12) {
        int r13 = 6;
        int r14 = 4;
        if (r12 >= 0.0f) goto L16;
        if (Math.abs(r12) <= 1500.0f) goto L16;
        if (this.fitToContents == false) goto L9;
        int r15 = this.fitToContentsOffset;
        r14 = 3;
    L45:
        return new int[]{r15, r14};
    L9:
        int r16 = r10.getTop();
        r15 = this.halfExpandedOffset;
        if (r16 > r15) goto L14;
        r15 = 0;
    L13:
        r13 = 3;
    L14:
        r14 = r13;
    L16:
        if (this.hideable == false) goto L25;
        if (shouldHide(r10, r12) == false) goto L25;
        if (r10.getTop() <= this.collapsedOffset) goto L22;
    L23:
        r15 = this.parentHeight;
        r14 = 5;
        goto L45
    L22:
        if (Math.abs(r11) < Math.abs(r12)) goto L23;
    L25:
        if (r12 != 0.0f) goto L27;
    L30:
        int r17 = r10.getTop();
        if (this.fitToContents == true) goto L33;
        int r18 = this.halfExpandedOffset;
        if (r17 >= r18) goto L42;
        if (r17 >= Math.abs(r17 - this.collapsedOffset)) goto L43;
        r15 = 0;
    L43:
        r15 = this.halfExpandedOffset;
        goto L14
    L42:
        if (Math.abs(r17 - r18) < Math.abs(r17 - this.collapsedOffset)) goto L43;
    L35:
        r15 = this.collapsedOffset;
        r13 = 4;
        goto L14
    L33:
        if (Math.abs(r17 - this.fitToContentsOffset) >= Math.abs(r17 - this.collapsedOffset)) goto L35;
        r15 = this.fitToContentsOffset;
        goto L13
    L27:
        if (Math.abs(r11) > Math.abs(r12)) goto L30;
        r15 = this.collapsedOffset;
        goto L45
    }

    private float getYVelocity() {
        VelocityTracker r10 = this.velocityTracker;
        if (r10 != null) goto L6;
        return 0.0f;
    L6:
        r10.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r10 = this.velocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.velocityTracker = null;
        return;
    }

    private void updateImportantForAccessibility(boolean r10) {
        WeakReference<V> r11 = this.viewRef;
        if (r11 != null) goto L5;
        return;
    L5:
        ViewParent r12 = r11.get().getParent();
        if ((r12 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r13 = (CoordinatorLayout) r12;
        int r14 = r13.getChildCount();
        if (Build.VERSION.SDK_INT < 16) goto L15;
        if (r10 == false) goto L15;
        if (this.importantForAccessibilityMap != null) goto L14;
        this.importantForAccessibilityMap = new HashMap(r14);
        goto L15
    L14:
        return;
    L15:
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L32;
        View r16 = r13.getChildAt(r15);
        if (r16 == this.viewRef.get()) goto L31;
        if (r10 == true) goto L27;
        Map<View, Integer> r17 = this.importantForAccessibilityMap;
        if (r17 == null) goto L31;
        if (r17.containsKey(r16) == false) goto L31;
        int r18 = this.importantForAccessibilityMap.get(r16).intValue();
    L30:
        ViewCompat.setImportantForAccessibility(r16, r18);
        goto L31
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L29;
        this.importantForAccessibilityMap.put(r16, Integer.valueOf(r16.getImportantForAccessibility()));
    L29:
        r18 = 4;
    L31:
        r15 = r15 + 1;
        goto L16
    L32:
        if (r10 == true) goto L40;
        this.importantForAccessibilityMap = null;
        return;
    }

    public void addBottomSheetCallback(@NonNull d r10) {
        if (this.callbacks.contains(r10) == true) goto L6;
        this.callbacks.add(r10);
        return;
    }

    protected void calculateCollapsedOffset() {
        if (this.fitToContents == false) goto L5;
        int r10 = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
    L6:
        this.collapsedOffset = r10;
        return;
    L5:
        r10 = this.parentHeight - this.lastPeekHeight;
        goto L6
    }

    void dispatchOnSlide(int r10) {
        V r11 = this.viewRef.get();
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L17;
        int r12 = 0;
        if (r10 <= this.collapsedOffset) goto L12;
    L9:
        if (r12 >= this.callbacks.size()) goto L18;
        d r13 = this.callbacks.get(r12);
        int r14 = this.collapsedOffset;
        r13.c(r11, (r14 - r10) / (this.parentHeight - r14));
        r12 = r12 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r12 >= this.callbacks.size()) goto L19;
        d r15 = this.callbacks.get(r12);
        int r16 = this.collapsedOffset;
        r15.c(r11, (r16 - r10) / (r16 - getExpandedOffset()));
        r12 = r12 + 1;
        goto L12
    L19:
        return;
    }

    @Nullable
    @VisibleForTesting
    View findScrollingChild(@Nullable View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r10) == false) goto L9;
        return r10;
    L9:
        if ((r10 instanceof ViewGroup) == false) goto L16;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = 0;
        int r13 = r11.getChildCount();
    L11:
        if (r12 >= r13) goto L16;
        View r14 = findScrollingChild(r11.getChildAt(r12));
        if (r14 != null) goto L14;
        r12 = r12 + 1;
        goto L11
    L14:
        return r14;
    L16:
        return null;
    }

    public int getMaxSettleDuration() {
        return this.mMaxSettleDuration;
    }

    public final int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    @VisibleForTesting
    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public final int getState() {
        return this.state;
    }

    public final int getTargetState() {
        return this.targetState;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L76:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L76;
        int r13 = r12.getActionMasked();
        if (r13 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r12);
        View r14 = null;
        if (r13 == 0) goto L23;
        if (r13 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L39;
        this.ignoreEvents = false;
        return false;
    L39:
        if (this.mAdaptPortraitRLSlide == false) goto L48;
        if (this.ignoreEvents == true) goto L48;
        com.obric.oui.panel.a r15 = this.rlDragHelper;
        if (r15 == null) goto L48;
        if (r15.s(r11, r12) == false) goto L48;
        return true;
    L48:
        if (this.ignoreEvents == true) goto L54;
        com.obric.oui.panel.c r16 = this.viewDragHelper;
        if (r16 == null) goto L54;
        if (r16.H(r12) == false) goto L54;
        return true;
    L54:
        WeakReference<View> r17 = this.nestedScrollingChildRef;
        if (r17 == null) goto L58;
        r14 = r17.get();
    L58:
        if (r13 != 2) goto L70;
        if (r14 == null) goto L70;
        if (this.ignoreEvents == true) goto L70;
        if (this.state == 1) goto L70;
        if (r10.isPointInChildBounds(r14, (int) r12.getX(), (int) r12.getY()) == true) goto L70;
        if (this.viewDragHelper == null) goto L70;
        if (Math.abs(this.initialY - r12.getY()) <= this.viewDragHelper.u()) goto L70;
    L75:
        return true;
    L70:
        e r18 = this.interceptTouchEvent;
        if (r18 != null) goto L73;
        return false;
    L73:
        if (r18.a(r12, this.state, this.targetState) == true) goto L75;
        return false;
    L17:
        if (r13 == 3) goto L19;
    L23:
        int r19 = (int) r12.getX();
        this.initialY = (int) r12.getY();
        WeakReference<View> r20 = this.nestedScrollingChildRef;
        if (r20 == null) goto L26;
        View r21 = r20.get();
    L27:
        if (r21 == null) goto L32;
        if (r10.isPointInChildBounds(r21, r19, this.initialY) == false) goto L32;
        this.activePointerId = r12.getPointerId(r12.getActionIndex());
        this.touchingScrollingChild = true;
    L32:
        if (this.activePointerId == (-1)) goto L34;
    L36:
        boolean r22 = false;
    L37:
        this.ignoreEvents = r22;
        goto L39
    L34:
        if (r10.isPointInChildBounds(r11, r19, this.initialY) == true) goto L36;
        r22 = true;
        goto L37
    L26:
        r21 = null;
        goto L27
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r10, V r11, int r12) {
        if (this.fitsSystemWindow == true) goto L5;
    L9:
        int r13 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.parentHeight = r10.getHeight();
        if (this.peekHeightAuto == true) goto L12;
        int r14 = this.peekHeight;
    L24:
        this.lastPeekHeight = r14;
        if (this.maxExpandedHeight <= 0) goto L29;
        int r15 = r11.getHeight();
        int r16 = this.maxExpandedHeight;
        if (r15 <= r16) goto L29;
        int r17 = this.parentHeight;
    L30:
        this.fitToContentsOffset = Math.max(0, r17 - r16);
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        int r18 = this.state;
        if (r18 != 3) goto L35;
        int r19 = getExpandedOffset();
    L33:
        ViewCompat.offsetTopAndBottom(r11, r19);
    L49:
        if (this.viewDragHelper != null) goto L52;
        com.obric.oui.panel.c r110 = com.obric.oui.panel.c.l(r10, this.dragCallback);
        this.viewDragHelper = r110;
        r110.F(this.mMaxSettleDuration);
    L52:
        if (this.mAdaptPortraitRLSlide == true) goto L54;
    L56:
        this.viewRef = new WeakReference(r11);
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r11));
        return true;
    L54:
        if (this.rlDragHelper != null) goto L56;
        this.rlDragHelper = new com.obric.oui.panel.a(r10.getContext(), r10, this.rlDragCallback);
        goto L56
    L35:
        if (r18 != 6) goto L38;
        r19 = this.halfExpandedOffset;
        goto L33
    L38:
        if (this.hideable == false) goto L43;
        if (r18 != 5) goto L43;
        r19 = this.parentHeight;
    L43:
        if (r18 != 4) goto L45;
        r19 = this.collapsedOffset;
        goto L33
    L45:
        if (r18 == 1) goto L47;
        if (r18 != 2) goto L49;
    L47:
        ViewCompat.offsetTopAndBottom(r11, r13 - r11.getTop());
    L29:
        r17 = this.parentHeight;
        r16 = r11.getHeight();
        goto L30
    L12:
        if (this.peekHeightMin != 0) goto L14;
        this.peekHeightMin = r10.getResources().getDimensionPixelSize(q5.d.design_bottom_sheet_peek_height_min);
    L14:
        float r111 = r10.getContext().getResources().getConfiguration().fontScale;
        com.obric.oui.common.util.e.a("check fontScale:" + r111);
        if (this.mAutoSlideToPeekHeight == false) goto L17;
        double r20 = 0.6d;
    L18:
        double r21 = this.peekHeightMin;
        int r22 = this.maxExpandedHeight;
        if (r22 <= 0) goto L21;
        double r23 = r22;
    L22:
        r14 = (int) Math.max(r21, r23);
        goto L24
    L21:
        r23 = ((double) r111) * (((double) this.parentHeight) * r20);
        goto L22
    L17:
        r20 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L9;
        r11.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, float r13, float r14) {
        if (r12 == this.nestedScrollingChildRef.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.state == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r10, r11, r12, r13, r14) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, @NonNull int[] r15, int r16) {
        if (r16 != 1) goto L6;
        return;
    L6:
        if (r12 == this.nestedScrollingChildRef.get()) goto L8;
        return;
    L8:
        int r17 = r11.getTop();
        int r18 = r17 - r14;
        if (r14 > 0) goto L11;
        if (r14 < 0) goto L21;
    L32:
        dispatchOnSlide(r11.getTop());
        this.lastNestedScrollDy = r14;
        this.nestedScrolled = true;
        return;
    L21:
        if (r12.canScrollVertically(-1) == true) goto L32;
        int r19 = this.collapsedOffset;
        if (r18 <= r19) goto L29;
        if (this.hideable == true) goto L29;
        r15[1] = r17 - r19;
        ViewCompat.offsetTopAndBottom(r11, -r15[1]);
        int r20 = 4;
    L13:
        setStateInternal(r20);
    L29:
        if (this.draggable == true) goto L31;
        return;
    L31:
        r15[1] = r14;
    L18:
        ViewCompat.offsetTopAndBottom(r11, -r14);
        setStateInternal(1);
        goto L32
    L11:
        if (r18 >= getExpandedOffset()) goto L15;
        r15[1] = r17 - getExpandedOffset();
        ViewCompat.offsetTopAndBottom(r11, -r15[1]);
        r20 = 3;
        goto L13
    L15:
        if (this.draggable == true) goto L17;
        return;
    L17:
        r15[1] = r14;
        goto L18
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r10, V r11, Parcelable r12) {
        SavedState r13 = (SavedState) r12;
        super.onRestoreInstanceState(r10, r11, r13.getSuperState());
        int r14 = r13.state;
        if (r14 != 1) goto L5;
    L6:
        r14 = 4;
    L7:
        this.state = r14;
        return;
    L5:
        if (r14 != 2) goto L7;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r10, V r11) {
        return new SavedState(super.onSaveInstanceState(r10, r11), this.state);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r14 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13) {
        int r14 = 3;
        if (r11.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (r12 == this.nestedScrollingChildRef.get()) goto L9;
        return;
    L9:
        if (this.nestedScrolled == true) goto L12;
        return;
    L12:
        if (this.lastNestedScrollDy <= 0) goto L15;
        int r15 = getExpandedOffset();
    L35:
        this.targetState = r14;
        if (this.viewDragHelper.I(r11, r11.getLeft(), r15) == false) goto L38;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r11, new g(this, r11, r14));
    L39:
        this.nestedScrolled = false;
        return;
    L38:
        setStateInternal(r14);
        goto L39
    L15:
        if (this.hideable == false) goto L20;
        if (shouldHide(r11, getYVelocity()) == false) goto L20;
        r15 = this.parentHeight;
        r14 = 5;
    L20:
        if (this.lastNestedScrollDy != 0) goto L34;
        int r16 = r11.getTop();
        if (this.fitToContents == true) goto L24;
        int r17 = this.halfExpandedOffset;
        if (r16 >= r17) goto L32;
        if (r16 >= Math.abs(r16 - this.collapsedOffset)) goto L33;
        r15 = 0;
    L33:
        r15 = this.halfExpandedOffset;
        r14 = 6;
        goto L35
    L32:
        if (Math.abs(r16 - r17) >= Math.abs(r16 - this.collapsedOffset)) goto L34;
    L24:
        if (Math.abs(r16 - this.fitToContentsOffset) >= Math.abs(r16 - this.collapsedOffset)) goto L34;
        r15 = this.fitToContentsOffset;
    L34:
        r15 = this.collapsedOffset;
        r14 = 4;
        goto L35
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        if (r11.isShown() == true) goto L6;
        return false;
    L6:
        int r13 = r12.getActionMasked();
        if (this.state != 1) goto L10;
        if (r13 != 0) goto L10;
        return true;
    L10:
        if (r13 != 0) goto L13;
        reset();
    L13:
        if (this.velocityTracker != null) goto L15;
        this.velocityTracker = VelocityTracker.obtain();
    L15:
        this.velocityTracker.addMovement(r12);
        if (this.mAdaptPortraitRLSlide == false) goto L22;
        com.obric.oui.panel.a r14 = this.rlDragHelper;
        if (r14 == null) goto L22;
        if (r14.n() == false) goto L22;
        this.rlDragHelper.p(r12, r11, this.state, this.velocityTracker);
    L26:
        if (this.mAdaptPortraitRLSlide == false) goto L34;
        com.obric.oui.panel.a r15 = this.rlDragHelper;
        if (r15 == null) goto L34;
        if (r15.n() == false) goto L34;
        return !this.ignoreEvents;
    L34:
        if (r13 != 2) goto L41;
        if (this.ignoreEvents == true) goto L41;
        if (Math.abs(this.initialY - r12.getY()) <= this.viewDragHelper.u()) goto L41;
        this.viewDragHelper.b(r11, r12.getPointerId(r12.getActionIndex()));
    L41:
        return !this.ignoreEvents;
    L22:
        com.obric.oui.panel.c r16 = this.viewDragHelper;
        if (r16 == null) goto L26;
        r16.z(r12);
        goto L26
    }

    public void removeBottomSheetCallback(@NonNull d r10) {
        this.callbacks.remove(r10);
    }

    public void setAdaptPortraitRLSlide(boolean r10) {
        this.mAdaptPortraitRLSlide = r10;
    }

    public void setAutoSlideToPeekHeight(boolean r10) {
        this.mAutoSlideToPeekHeight = r10;
    }

    @Deprecated
    public void setBottomSheetCallback(d r10) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r10 == null) goto L6;
        this.callbacks.add(r10);
        return;
    }

    public void setDraggable(boolean r10) {
        this.draggable = r10;
    }

    public void setFitToContents(boolean r10) {
        if (this.fitToContents != r10) goto L5;
        return;
    L5:
        this.fitToContents = r10;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r11 = this.state;
    L14:
        setStateInternal(r11);
        return;
    L11:
        if (this.state != 6) goto L13;
        r11 = 3;
        goto L14
    }

    public void setHideable(boolean r10) {
        this.hideable = r10;
    }

    public void setInterceptTouchEvent(e r10) {
        this.interceptTouchEvent = r10;
    }

    public void setIs69Mode(boolean r10) {
        this.is69Mode = r10;
    }

    public void setMaxExpandedHeight(int r10) {
        this.maxExpandedHeight = r10;
    }

    public void setMaxSettleDuration(int r10) {
        this.mMaxSettleDuration = r10;
    }

    public final void setPeekHeight(int r10) {
        boolean r11 = true;
        if (r10 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r11 == true) goto L16;
        return;
    L16:
        if (this.state != 4) goto L24;
        WeakReference<V> r12 = this.viewRef;
        if (r12 == null) goto L25;
        V r13 = r12.get();
        if (r13 == null) goto L26;
        r13.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r11 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r10);
        this.collapsedOffset = this.parentHeight - r10;
        goto L14
    L10:
        if (this.peekHeight == r10) goto L12;
        goto L12
    }

    public void setSkipCollapsed(boolean r10) {
        this.skipCollapsed = r10;
    }

    public final void setState(int r10) {
        if (r10 != this.state) goto L5;
        return;
    L5:
        WeakReference<V> r11 = this.viewRef;
        if (r11 == null) goto L8;
        V r12 = r11.get();
        if (r12 != null) goto L22;
        return;
    L22:
        ViewParent r13 = r12.getParent();
        if (r13 != null) goto L25;
    L29:
        startSettlingAnimation(r12, r10);
        return;
    L25:
        if (r13.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r12) == false) goto L29;
        r12.post(new a(this, r12, r10));
        return;
    L8:
        if (r10 != 4) goto L10;
    L17:
        this.state = r10;
        return;
    L10:
        if (r10 == 3) goto L17;
        if (r10 == 6) goto L17;
        if (this.hideable == true) goto L16;
        return;
    L16:
        if (r10 == 5) goto L17;
    }

    void setStateInternal(int r10) {
        if (this.state != r10) goto L5;
        return;
    L5:
        this.state = r10;
        int r11 = 0;
        if (r10 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        V r12 = this.viewRef.get();
    L18:
        if (r11 >= this.callbacks.size()) goto L20;
        this.callbacks.get(r11).d(r12, r10);
        r11 = r11 + 1;
        goto L18
    L20:
        return;
    L8:
        if (r10 == 3) goto L15;
        if (r10 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r10 != 4) goto L16;
        goto L14
    }

    boolean shouldHide(View r10, float r11) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r11 != 0.0f) goto L18;
        if (this.is69Mode == false) goto L14;
        if (r10.getTop() <= (this.collapsedOffset + (this.lastPeekHeight / 2))) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (r10.getTop() <= (((this.parentHeight - getExpandedOffset()) / 2) + getExpandedOffset())) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.targetState != 4) goto L27;
        if (this.peekHeight <= (com.obric.oui.common.util.f.d(r10.getContext()) / 2)) goto L27;
        if (r11 <= (this.maximumVelocity * 0.08f)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((Math.abs((r10.getTop() + (r11 * 0.1f)) - this.collapsedOffset) / this.peekHeight) <= 0.5f) goto L30;
        return true;
    L30:
        return false;
    }

    void startSettlingAnimation(View r10, int r11) {
        if (r11 != 4) goto L6;
        int r12 = this.collapsedOffset;
    L21:
        if (this.viewDragHelper.I(r10, r10.getLeft(), r12) == false) goto L23;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r10, new g(this, r10, r11));
        return;
    L23:
        setStateInternal(r11);
        return;
    L6:
        if (r11 != 6) goto L13;
        int r13 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L12;
        int r14 = this.fitToContentsOffset;
        if (r13 > r14) goto L12;
        r11 = 3;
        r12 = r14;
    L12:
        r12 = r13;
        goto L21
    L13:
        if (r11 != 3) goto L16;
        r12 = getExpandedOffset();
        goto L21
    L16:
        if (this.hideable == false) goto L26;
        if (r11 != 5) goto L26;
        r12 = this.parentHeight;
    L26:
        throw new IllegalArgumentException("Illegal state argument: " + r11);
    }
}
