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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
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
    private final ArrayList<a> callbacks;
    protected int collapsedOffset;
    private final com.obric.oui.panel.c.a dragCallback;
    private boolean draggable;
    protected boolean fitToContents;
    protected int fitToContentsOffset;
    boolean fitsSystemWindow;
    int halfExpandedOffset;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private b interceptTouchEvent;
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
    private final com.obric.oui.panel.c.a rlDragCallback;
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

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.state = r1.readInt();
        }

        public SavedState(Parcelable r3, int r4) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
            this.state = r4;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
        }
    }

    public static abstract class a {
        public a() {
        }

        public void a(float r1) {
        }

        public abstract void a(View r1, float r2);

        public abstract void a(View r1, int r2);

        public void b(float r1) {
        }
    }

    public interface b {
        boolean a(MotionEvent r1, int r2, int r3);
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f14254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f14255b;
        private final int c;

        c(BottomSheetBehavior r1, View r2, int r3) {
            this.f14254a = r1;
            this.f14255b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14254a.rlDragHelper != null) goto L5;
        L7:
            this.f14254a.setStateInternal(this.c);
            return;
        L5:
            if (this.f14254a.rlDragHelper.a(this.f14255b, true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f14255b, this);
        }
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f14256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f14257b;
        private final int c;

        d(BottomSheetBehavior r1, View r2, int r3) {
            this.f14256a = r1;
            this.f14257b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14256a.viewDragHelper != null) goto L5;
        L7:
            this.f14256a.setStateInternal(this.c);
            return;
        L5:
            if (this.f14256a.viewDragHelper.a(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f14257b, this);
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
        this.dragCallback = new AnonymousClass2(this);
        this.rlDragCallback = new AnonymousClass3(this);
    }

    public BottomSheetBehavior(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
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
        this.dragCallback = new AnonymousClass2(this);
        this.rlDragCallback = new AnonymousClass3(this);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.BottomSheetBehavior_Layout);
        TypedValue r3 = r12.peekValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"));
        if (r3 != null) goto L5;
    L7:
        int r2 = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"), -1);
    L8:
        setPeekHeight(r2);
        setHideable(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, "styleable", "BottomSheetBehavior_Layout_behavior_hideable"), false));
        setFitToContents(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, "styleable", "BottomSheetBehavior_Layout_behavior_fitToContents"), true));
        setSkipCollapsed(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, "styleable", "BottomSheetBehavior_Layout_behavior_skipCollapsed"), false));
        r12.recycle();
        this.maximumVelocity = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L5:
        if (r3.data != (-1)) goto L7;
        r2 = r3.data;
        goto L8
    }

    static /* synthetic */ boolean access$000(BottomSheetBehavior r0) {
        return r0.draggable;
    }

    static /* synthetic */ int[] access$100(BottomSheetBehavior r0, View r1, float r2, float r3) {
        return r0.getReleaseParam(r1, r2, r3);
    }

    static /* synthetic */ int access$200(BottomSheetBehavior r0) {
        return r0.getExpandedOffset();
    }

    static /* synthetic */ com.obric.oui.panel.c.a access$300(BottomSheetBehavior r0) {
        return r0.dragCallback;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V r3) {
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, CoordinatorLayout.LayoutParams.class) == false) goto L11;
        CoordinatorLayout.Behavior r5 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
        if (ZeusTransformUtils.instanceOf(r5, BottomSheetBehavior.class) == false) goto L9;
        return (BottomSheetBehavior) ZeusTransformUtils.preCheckCast(r5, BottomSheetBehavior.class, "com.obric.memorydata.plugin");
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

    private int[] getReleaseParam(View r8, float r9, float r10) {
        int r2 = 6;
        int r4 = 4;
        if (r10 >= 0.0f) goto L16;
        if (Math.abs(r10) <= 1500.0f) goto L16;
        if (this.fitToContents == false) goto L9;
        int r7 = this.fitToContentsOffset;
        r4 = 3;
    L45:
        return new int[]{r7, r4};
    L9:
        int r11 = r8.getTop();
        r7 = this.halfExpandedOffset;
        if (r11 > r7) goto L14;
        r7 = 0;
    L13:
        r2 = 3;
    L14:
        r4 = r2;
    L16:
        if (this.hideable == false) goto L25;
        if (shouldHide(r8, r10) == false) goto L25;
        if (r8.getTop() <= this.collapsedOffset) goto L22;
    L23:
        r7 = this.parentHeight;
        r4 = 5;
        goto L45
    L22:
        if (Math.abs(r9) < Math.abs(r10)) goto L23;
    L25:
        if (r10 != 0.0f) goto L27;
    L30:
        int r12 = r8.getTop();
        if (this.fitToContents == true) goto L33;
        int r13 = this.halfExpandedOffset;
        if (r12 >= r13) goto L42;
        if (r12 >= Math.abs(r12 - this.collapsedOffset)) goto L43;
        r7 = 0;
    L43:
        r7 = this.halfExpandedOffset;
        goto L14
    L42:
        if (Math.abs(r12 - r13) < Math.abs(r12 - this.collapsedOffset)) goto L43;
    L35:
        r7 = this.collapsedOffset;
        r2 = 4;
        goto L14
    L33:
        if (Math.abs(r12 - this.fitToContentsOffset) >= Math.abs(r12 - this.collapsedOffset)) goto L35;
        r7 = this.fitToContentsOffset;
        goto L13
    L27:
        if (Math.abs(r9) > Math.abs(r10)) goto L30;
        r7 = this.collapsedOffset;
        goto L45
    }

    private float getYVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r0 = this.velocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.velocityTracker = null;
        return;
    }

    private void updateImportantForAccessibility(boolean r9) {
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = ((View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin")).getParent();
        if (ZeusTransformUtils.instanceOf(r1, CoordinatorLayout.class) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r2 = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(r1, CoordinatorLayout.class, "com.obric.memorydata.plugin");
        int r3 = r2.getChildCount();
        if (Build.VERSION.SDK_INT < 16) goto L15;
        if (r9 == false) goto L15;
        if (this.importantForAccessibilityMap != null) goto L14;
        this.importantForAccessibilityMap = new HashMap(r3);
        goto L15
    L14:
        return;
    L15:
        int r4 = 0;
    L16:
        if (r4 >= r3) goto L32;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.viewRef.get()) goto L31;
        if (r9 == true) goto L27;
        Map<View, Integer> r6 = this.importantForAccessibilityMap;
        if (r6 == null) goto L31;
        if (r6.containsKey(r5) == false) goto L31;
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(this.importantForAccessibilityMap.get(r5), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L30:
        ViewCompat.setImportantForAccessibility(r5, r7);
        goto L31
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L29;
        this.importantForAccessibilityMap.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
    L29:
        r7 = 4;
    L31:
        r4 = r4 + 1;
        goto L16
    L32:
        if (r9 == true) goto L40;
        this.importantForAccessibilityMap = null;
        return;
    }

    public void addBottomSheetCallback(a r2) {
        if (this.callbacks.contains(r2) == true) goto L6;
        this.callbacks.add(r2);
        return;
    }

    public void calculateCollapsedOffset() {
        if (this.fitToContents == false) goto L5;
        int r0 = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
    L6:
        this.collapsedOffset = r0;
        return;
    L5:
        r0 = this.parentHeight - this.lastPeekHeight;
        goto L6
    }

    void dispatchOnSlide(int r8) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.viewRef.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L17;
        int r3 = 0;
        if (r8 <= this.collapsedOffset) goto L12;
    L9:
        if (r3 >= this.callbacks.size()) goto L18;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.callbacks.get(r3), a.class, "com.obric.memorydata.plugin");
        int r4 = this.collapsedOffset;
        r1.a(r0, (r4 - r8) / (this.parentHeight - r4));
        r3 = r3 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r3 >= this.callbacks.size()) goto L19;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.callbacks.get(r3), a.class, "com.obric.memorydata.plugin");
        int r5 = this.collapsedOffset;
        r2.a(r0, (r5 - r8) / (r5 - getExpandedOffset()));
        r3 = r3 + 1;
        goto L12
    L19:
        return;
    }

    View findScrollingChild(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r5) == false) goto L9;
        return r5;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L16;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        int r2 = r6.getChildCount();
    L11:
        if (r1 >= r2) goto L16;
        View r3 = findScrollingChild(r6.getChildAt(r1));
        if (r3 != null) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return r3;
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
        int r0 = r12.getActionMasked();
        if (r0 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r12);
        View r4 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L39;
        this.ignoreEvents = false;
        return false;
    L39:
        if (this.mAdaptPortraitRLSlide == false) goto L48;
        if (this.ignoreEvents == true) goto L48;
        com.obric.oui.panel.a r5 = this.rlDragHelper;
        if (r5 == null) goto L48;
        if (r5.a(r11, r12) == false) goto L48;
        return true;
    L48:
        if (this.ignoreEvents == true) goto L54;
        com.obric.oui.panel.c r13 = this.viewDragHelper;
        if (r13 == null) goto L54;
        if (r13.a(r12) == false) goto L54;
        return true;
    L54:
        WeakReference<View> r14 = this.nestedScrollingChildRef;
        if (r14 == null) goto L58;
        r4 = (View) ZeusTransformUtils.preCheckCast(r14.get(), View.class, "com.obric.memorydata.plugin");
    L58:
        if (r0 != 2) goto L70;
        if (r4 == null) goto L70;
        if (this.ignoreEvents == true) goto L70;
        if (this.state == 1) goto L70;
        if (r10.isPointInChildBounds(r4, (int) r12.getX(), (int) r12.getY()) == true) goto L70;
        if (this.viewDragHelper == null) goto L70;
        if (Math.abs(this.initialY - r12.getY()) <= this.viewDragHelper.a()) goto L70;
    L75:
        return true;
    L70:
        b r15 = this.interceptTouchEvent;
        if (r15 != null) goto L73;
        return false;
    L73:
        if (r15.a(r12, this.state, this.targetState) == true) goto L75;
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r6 = (int) r12.getX();
        this.initialY = (int) r12.getY();
        WeakReference<View> r7 = this.nestedScrollingChildRef;
        if (r7 == null) goto L26;
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7.get(), View.class, "com.obric.memorydata.plugin");
    L27:
        if (r8 == null) goto L32;
        if (r10.isPointInChildBounds(r8, r6, this.initialY) == false) goto L32;
        this.activePointerId = r12.getPointerId(r12.getActionIndex());
        this.touchingScrollingChild = true;
    L32:
        if (this.activePointerId == (-1)) goto L34;
    L36:
        boolean r9 = false;
    L37:
        this.ignoreEvents = r9;
        goto L39
    L34:
        if (r10.isPointInChildBounds(r11, r6, this.initialY) == true) goto L36;
        r9 = true;
        goto L37
    L26:
        r8 = null;
        goto L27
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r10, V r11, int r12) {
        if (this.fitsSystemWindow == true) goto L5;
    L9:
        int r0 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.parentHeight = r10.getHeight();
        if (this.peekHeightAuto == true) goto L12;
        int r13 = this.peekHeight;
    L24:
        this.lastPeekHeight = r13;
        if (this.maxExpandedHeight <= 0) goto L29;
        int r14 = r11.getHeight();
        int r4 = this.maxExpandedHeight;
        if (r14 <= r4) goto L29;
        int r15 = this.parentHeight;
    L30:
        this.fitToContentsOffset = Math.max(0, r15 - r4);
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        int r16 = this.state;
        if (r16 != 3) goto L35;
        int r17 = getExpandedOffset();
    L33:
        ViewCompat.offsetTopAndBottom(r11, r17);
    L49:
        if (this.viewDragHelper != null) goto L52;
        com.obric.oui.panel.c r18 = com.obric.oui.panel.c.a(r10, this.dragCallback);
        this.viewDragHelper = r18;
        r18.c(this.mMaxSettleDuration);
    L52:
        if (this.mAdaptPortraitRLSlide == true) goto L54;
    L56:
        this.viewRef = new WeakReference(r11);
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r11));
        return true;
    L54:
        if (this.rlDragHelper != null) goto L56;
        this.rlDragHelper = new com.obric.oui.panel.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10, this.rlDragCallback);
        goto L56
    L35:
        if (r16 != 6) goto L38;
        r17 = this.halfExpandedOffset;
        goto L33
    L38:
        if (this.hideable == false) goto L43;
        if (r16 != 5) goto L43;
        r17 = this.parentHeight;
    L43:
        if (r16 != 4) goto L45;
        r17 = this.collapsedOffset;
        goto L33
    L45:
        if (r16 == 1) goto L47;
        if (r16 != 2) goto L49;
    L47:
        ViewCompat.offsetTopAndBottom(r11, r0 - r11.getTop());
    L29:
        r15 = this.parentHeight;
        r4 = r11.getHeight();
        goto L30
    L12:
        if (this.peekHeightMin != 0) goto L14;
        this.peekHeightMin = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_bottom_sheet_peek_height_min, "dimen", "design_bottom_sheet_peek_height_min"));
    L14:
        float r19 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().fontScale;
        g.a("check fontScale:" + r19);
        if (this.mAutoSlideToPeekHeight == false) goto L17;
        double r3 = 0.6d;
    L18:
        double r5 = this.peekHeightMin;
        int r7 = this.maxExpandedHeight;
        if (r7 <= 0) goto L21;
        double r6 = r7;
    L22:
        r13 = (int) Math.max(r5, r6);
        goto L24
    L21:
        r6 = ((double) r19) * (((double) this.parentHeight) * r3);
        goto L22
    L17:
        r3 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L9;
        r11.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout r3, V r4, View r5, float r6, float r7) {
        if (r5 == this.nestedScrollingChildRef.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.state == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r3, r4, r5, r6, r7) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L6;
        return;
    L6:
        if (r4 == ((View) ZeusTransformUtils.preCheckCast(this.nestedScrollingChildRef.get(), View.class, "com.obric.memorydata.plugin"))) goto L8;
        return;
    L8:
        int r9 = r3.getTop();
        int r10 = r9 - r6;
        if (r6 > 0) goto L11;
        if (r6 < 0) goto L21;
    L32:
        dispatchOnSlide(r3.getTop());
        this.lastNestedScrollDy = r6;
        this.nestedScrolled = true;
        return;
    L21:
        if (r4.canScrollVertically(-1) == true) goto L32;
        int r11 = this.collapsedOffset;
        if (r10 <= r11) goto L29;
        if (this.hideable == true) goto L29;
        r7[1] = r9 - r11;
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        int r12 = 4;
    L13:
        setStateInternal(r12);
    L29:
        if (this.draggable == true) goto L31;
        return;
    L31:
        r7[1] = r6;
    L18:
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L32
    L11:
        if (r10 >= getExpandedOffset()) goto L15;
        r7[1] = r9 - getExpandedOffset();
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        r12 = 3;
        goto L13
    L15:
        if (this.draggable == true) goto L17;
        return;
    L17:
        r7[1] = r6;
        goto L18
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r3, V r4, Parcelable r5) {
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin"), SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r3, r4, r6.getSuperState());
        if (r6.state != 1) goto L5;
    L8:
        int r7 = 4;
    L9:
        this.state = r7;
        return;
    L5:
        if (r6.state == 2) goto L8;
        r7 = r6.state;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r2, V r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this.state);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r4, V r5, View r6, int r7) {
        int r0 = 3;
        if (r5.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (r6 == this.nestedScrollingChildRef.get()) goto L9;
        return;
    L9:
        if (this.nestedScrolled == true) goto L12;
        return;
    L12:
        if (this.lastNestedScrollDy <= 0) goto L15;
        int r8 = getExpandedOffset();
    L35:
        this.targetState = r0;
        if (this.viewDragHelper.a(r5, r5.getLeft(), r8) == false) goto L38;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r5, new d(this, r5, r0));
    L39:
        this.nestedScrolled = false;
        return;
    L38:
        setStateInternal(r0);
        goto L39
    L15:
        if (this.hideable == false) goto L20;
        if (shouldHide(r5, getYVelocity()) == false) goto L20;
        r8 = this.parentHeight;
        r0 = 5;
    L20:
        if (this.lastNestedScrollDy != 0) goto L34;
        int r9 = r5.getTop();
        if (this.fitToContents == true) goto L24;
        int r1 = this.halfExpandedOffset;
        if (r9 >= r1) goto L32;
        if (r9 >= Math.abs(r9 - this.collapsedOffset)) goto L33;
        r8 = 0;
    L33:
        r8 = this.halfExpandedOffset;
        r0 = 6;
        goto L35
    L32:
        if (Math.abs(r9 - r1) >= Math.abs(r9 - this.collapsedOffset)) goto L34;
    L24:
        if (Math.abs(r9 - this.fitToContentsOffset) >= Math.abs(r9 - this.collapsedOffset)) goto L34;
        r8 = this.fitToContentsOffset;
    L34:
        r8 = this.collapsedOffset;
        r0 = 4;
        goto L35
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r5, V r6, MotionEvent r7) {
        if (r6.isShown() == true) goto L6;
        return false;
    L6:
        int r8 = r7.getActionMasked();
        if (this.state != 1) goto L10;
        if (r8 != 0) goto L10;
        return true;
    L10:
        if (r8 != 0) goto L13;
        reset();
    L13:
        if (this.velocityTracker != null) goto L15;
        this.velocityTracker = VelocityTracker.obtain();
    L15:
        this.velocityTracker.addMovement(r7);
        if (this.mAdaptPortraitRLSlide == false) goto L22;
        com.obric.oui.panel.a r0 = this.rlDragHelper;
        if (r0 == null) goto L22;
        if (r0.a() == false) goto L22;
        this.rlDragHelper.a(r7, r6, this.state, this.velocityTracker);
    L26:
        if (this.mAdaptPortraitRLSlide == false) goto L34;
        com.obric.oui.panel.a r1 = this.rlDragHelper;
        if (r1 == null) goto L34;
        if (r1.a() == false) goto L34;
        return !this.ignoreEvents;
    L34:
        if (r8 != 2) goto L41;
        if (this.ignoreEvents == true) goto L41;
        if (Math.abs(this.initialY - r7.getY()) <= this.viewDragHelper.a()) goto L41;
        this.viewDragHelper.a(r6, r7.getPointerId(r7.getActionIndex()));
    L41:
        return !this.ignoreEvents;
    L22:
        com.obric.oui.panel.c r2 = this.viewDragHelper;
        if (r2 == null) goto L26;
        r2.b(r7);
        goto L26
    }

    public void removeBottomSheetCallback(a r1) {
        this.callbacks.remove(r1);
    }

    public void setAdaptPortraitRLSlide(boolean r1) {
        this.mAdaptPortraitRLSlide = r1;
    }

    public void setAutoSlideToPeekHeight(boolean r1) {
        this.mAutoSlideToPeekHeight = r1;
    }

    @Deprecated
    public void setBottomSheetCallback(a r3) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r3 == null) goto L6;
        this.callbacks.add(r3);
        return;
    }

    public void setDraggable(boolean r1) {
        this.draggable = r1;
    }

    public void setFitToContents(boolean r2) {
        if (this.fitToContents != r2) goto L5;
        return;
    L5:
        this.fitToContents = r2;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r3 = this.state;
    L14:
        setStateInternal(r3);
        return;
    L11:
        if (this.state != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public void setHideable(boolean r1) {
        this.hideable = r1;
    }

    public void setInterceptTouchEvent(b r3) {
        this.interceptTouchEvent = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public void setIs69Mode(boolean r1) {
        this.is69Mode = r1;
    }

    public void setMaxExpandedHeight(int r1) {
        this.maxExpandedHeight = r1;
    }

    public void setMaxSettleDuration(int r1) {
        this.mMaxSettleDuration = r1;
    }

    public final void setPeekHeight(int r4) {
        boolean r0 = true;
        if (r4 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r0 == true) goto L16;
        return;
    L16:
        if (this.state != 4) goto L24;
        WeakReference<V> r3 = this.viewRef;
        if (r3 == null) goto L25;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r3.get(), View.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L26;
        r5.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r0 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r4);
        this.collapsedOffset = this.parentHeight - r4;
        goto L14
    L10:
        if (this.peekHeight == r4) goto L12;
        goto L12
    }

    public void setSkipCollapsed(boolean r1) {
        this.skipCollapsed = r1;
    }

    public final void setState(final int r4) {
        if (r4 != this.state) goto L5;
        return;
    L5:
        WeakReference<V> r0 = this.viewRef;
        if (r0 == null) goto L8;
        final View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L22;
        return;
    L22:
        ViewParent r2 = r1.getParent();
        if (r2 != null) goto L25;
    L29:
        startSettlingAnimation(r1, r4);
        return;
    L25:
        if (r2.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L29;
        r1.post(new AnonymousClass1(this, r1, r4));
        return;
    L8:
        if (r4 != 4) goto L10;
    L17:
        this.state = r4;
        return;
    L10:
        if (r4 == 3) goto L17;
        if (r4 == 6) goto L17;
        if (this.hideable == true) goto L16;
        return;
    L16:
        if (r4 == 5) goto L17;
    }

    void setStateInternal(int r6) {
        if (this.state != r6) goto L5;
        return;
    L5:
        this.state = r6;
        int r1 = 0;
        if (r6 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.viewRef.get(), View.class, "com.obric.memorydata.plugin");
    L18:
        if (r1 >= this.callbacks.size()) goto L20;
        ((a) ZeusTransformUtils.preCheckCast(this.callbacks.get(r1), a.class, "com.obric.memorydata.plugin")).a(r0, r6);
        r1 = r1 + 1;
        goto L18
    L20:
        return;
    L8:
        if (r6 == 3) goto L15;
        if (r6 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r6 != 4) goto L16;
        goto L14
    }

    boolean shouldHide(View r7, float r8) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r8 != 0.0f) goto L18;
        if (this.is69Mode == false) goto L14;
        if (r7.getTop() <= (this.collapsedOffset + (this.lastPeekHeight / 2))) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (r7.getTop() <= (((this.parentHeight - getExpandedOffset()) / 2) + getExpandedOffset())) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.targetState != 4) goto L27;
        if (this.peekHeight <= (h.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) / 2)) goto L27;
        if (r8 <= (this.maximumVelocity * 0.08f)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((Math.abs((r7.getTop() + (r8 * 0.1f)) - this.collapsedOffset) / this.peekHeight) <= 0.5f) goto L30;
        return true;
    L30:
        return false;
    }

    void startSettlingAnimation(View r4, int r5) {
        if (r5 != 4) goto L6;
        int r0 = this.collapsedOffset;
    L21:
        if (this.viewDragHelper.a(r4, r4.getLeft(), r0) == false) goto L23;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r4, new d(this, r4, r5));
        return;
    L23:
        setStateInternal(r5);
        return;
    L6:
        if (r5 != 6) goto L13;
        int r1 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L12;
        int r2 = this.fitToContentsOffset;
        if (r1 > r2) goto L12;
        r5 = 3;
        r0 = r2;
    L12:
        r0 = r1;
        goto L21
    L13:
        if (r5 != 3) goto L16;
        r0 = getExpandedOffset();
        goto L21
    L16:
        if (this.hideable == false) goto L26;
        if (r5 != 5) goto L26;
        r0 = this.parentHeight;
    L26:
        throw new IllegalArgumentException("Illegal state argument: " + r5);
    }
}
