package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.internal.r;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    private ColorStateList backgroundTint;
    private final ArrayList<a> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private l shapeAppearanceModelDefault;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.b stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            this.state = r3.readInt();
            this.peekHeight = r3.readInt();
            boolean r0 = false;
            if (r3.readInt() != 1) goto L5;
            boolean r5 = true;
        L6:
            this.fitToContents = r5;
            if (r3.readInt() != 1) goto L9;
            boolean r6 = true;
        L10:
            this.hideable = r6;
            if (r3.readInt() != 1) goto L13;
            r0 = true;
        L13:
            this.skipCollapsed = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        @Deprecated
        public SavedState(Parcelable r3, int r4) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
            this.state = r4;
        }

        public SavedState(Parcelable r3, BottomSheetBehavior<?> r4) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
            this.state = r4.state;
            this.peekHeight = BottomSheetBehavior.access$1700(r4);
            this.fitToContents = BottomSheetBehavior.access$1400(r4);
            this.hideable = r4.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$1800(r4);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
            r1.writeInt(this.peekHeight);
            r1.writeInt(this.fitToContents ? 1 : 0);
            r1.writeInt(this.hideable ? 1 : 0);
            r1.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    public static abstract class a {
        public a() {
        }

        void a(View r1) {
        }

        public abstract void a(View r1, float r2);

        public abstract void a(View r1, int r2);
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f3807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3808b;
        private boolean c;
        private final Runnable d;

        private b(BottomSheetBehavior r1) {
            this.f3807a = r1;
            this.d = new AnonymousClass1(this);
        }

        /* synthetic */ b(BottomSheetBehavior r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int a(b r0) {
            return r0.f3808b;
        }

        static /* synthetic */ boolean a(b r0, boolean r1) {
            r0.c = r1;
            return r1;
        }

        void a(int r3) {
            if (this.f3807a.viewRef != null) goto L5;
            return;
        L5:
            if (this.f3807a.viewRef.get() == null) goto L13;
            this.f3808b = r3;
            if (this.c == true) goto L12;
            ViewCompat.postOnAnimation((View) ZeusTransformUtils.preCheckCast(this.f3807a.viewRef.get(), View.class, "com.obric.memorydata.plugin"), this.d);
            this.c = true;
            return;
        L12:
            return;
        }
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_Design_BottomSheet_Modal, "style", "Widget_Design_BottomSheet_Modal");
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new b(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass4(this);
    }

    public BottomSheetBehavior(Context r11, AttributeSet r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r13, r14);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new b(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass4(this);
        this.peekHeightGestureInsetBuffer = ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_min_touch_target_size, "dimen", "mtrl_min_touch_target_size"));
        TypedArray r1 = r13.obtainStyledAttributes(r14, R.styleable.BottomSheetBehavior_Layout);
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_backgroundTint, "styleable", "BottomSheetBehavior_Layout_backgroundTint")) == false) goto L6;
        this.backgroundTint = c.a(r13, r1, ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_backgroundTint, "styleable", "BottomSheetBehavior_Layout_backgroundTint"));
    L6:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_shapeAppearance, "styleable", "BottomSheetBehavior_Layout_shapeAppearance")) == false) goto L8;
        this.shapeAppearanceModelDefault = l.a(r13, r14, ZeusTransformUtils.mapRes(R.attr.bottomSheetStyle, "attr", "bottomSheetStyle"), DEF_STYLE_RES).a();
    L8:
        createMaterialShapeDrawableIfNeeded(r13);
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT < 21) goto L12;
        this.elevation = r1.getDimension(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_elevation, "styleable", "BottomSheetBehavior_Layout_android_elevation"), -1.0f);
    L12:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, "styleable", "BottomSheetBehavior_Layout_android_maxWidth")) == false) goto L15;
        setMaxWidth(r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, "styleable", "BottomSheetBehavior_Layout_android_maxWidth"), -1));
    L15:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, "styleable", "BottomSheetBehavior_Layout_android_maxHeight")) == false) goto L17;
        setMaxHeight(r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, "styleable", "BottomSheetBehavior_Layout_android_maxHeight"), -1));
    L17:
        TypedValue r15 = r1.peekValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"));
        if (r15 != null) goto L20;
    L22:
        int r16 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, "styleable", "BottomSheetBehavior_Layout_behavior_peekHeight"), -1);
    L23:
        setPeekHeight(r16);
        setHideable(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, "styleable", "BottomSheetBehavior_Layout_behavior_hideable"), false));
        setGestureInsetBottomIgnored(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, "styleable", "BottomSheetBehavior_Layout_gestureInsetBottomIgnored"), false));
        setFitToContents(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, "styleable", "BottomSheetBehavior_Layout_behavior_fitToContents"), true));
        setSkipCollapsed(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, "styleable", "BottomSheetBehavior_Layout_behavior_skipCollapsed"), false));
        setDraggable(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, "styleable", "BottomSheetBehavior_Layout_behavior_draggable"), true));
        setSaveFlags(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, "styleable", "BottomSheetBehavior_Layout_behavior_saveFlags"), 0));
        setHalfExpandedRatio(r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, "styleable", "BottomSheetBehavior_Layout_behavior_halfExpandedRatio"), 0.5f));
        TypedValue r17 = r1.peekValue(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, "styleable", "BottomSheetBehavior_Layout_behavior_expandedOffset"));
        if (r17 != null) goto L26;
    L28:
        int r18 = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, "styleable", "BottomSheetBehavior_Layout_behavior_expandedOffset"), 0);
    L29:
        setExpandedOffset(r18);
        this.paddingBottomSystemWindowInsets = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets"), false);
        this.paddingLeftSystemWindowInsets = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets"), false);
        this.paddingRightSystemWindowInsets = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingRightSystemWindowInsets"), false);
        this.paddingTopSystemWindowInsets = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_paddingTopSystemWindowInsets"), true);
        this.marginLeftSystemWindowInsets = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_marginLeftSystemWindowInsets"), false);
        this.marginRightSystemWindowInsets = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_marginRightSystemWindowInsets"), false);
        this.marginTopSystemWindowInsets = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, "styleable", "BottomSheetBehavior_Layout_marginTopSystemWindowInsets"), false);
        r1.recycle();
        this.maximumVelocity = ViewConfiguration.get(r13).getScaledMaximumFlingVelocity();
        return;
    L26:
        if (r17.type != 16) goto L28;
        r18 = r17.data;
        goto L29
    L20:
        if (r15.data != (-1)) goto L22;
        r16 = r15.data;
        goto L23
    }

    static /* synthetic */ void access$100(BottomSheetBehavior r0, View r1, int r2, boolean r3) {
        r0.startSettling(r1, r2, r3);
    }

    static /* synthetic */ boolean access$1000(BottomSheetBehavior r0) {
        return r0.marginTopSystemWindowInsets;
    }

    static /* synthetic */ int access$1102(BottomSheetBehavior r0, int r1) {
        r0.gestureInsetBottom = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(BottomSheetBehavior r0, boolean r1) {
        r0.updatePeekHeight(r1);
    }

    static /* synthetic */ boolean access$1300(BottomSheetBehavior r0) {
        return r0.draggable;
    }

    static /* synthetic */ boolean access$1400(BottomSheetBehavior r0) {
        return r0.fitToContents;
    }

    static /* synthetic */ int access$1700(BottomSheetBehavior r0) {
        return r0.peekHeight;
    }

    static /* synthetic */ boolean access$1800(BottomSheetBehavior r0) {
        return r0.skipCollapsed;
    }

    static /* synthetic */ MaterialShapeDrawable access$200(BottomSheetBehavior r0) {
        return r0.materialShapeDrawable;
    }

    static /* synthetic */ int access$302(BottomSheetBehavior r0, int r1) {
        r0.insetTop = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(BottomSheetBehavior r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$500(BottomSheetBehavior r0) {
        return r0.insetBottom;
    }

    static /* synthetic */ int access$502(BottomSheetBehavior r0, int r1) {
        r0.insetBottom = r1;
        return r1;
    }

    static /* synthetic */ boolean access$600(BottomSheetBehavior r0) {
        return r0.paddingLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$700(BottomSheetBehavior r0) {
        return r0.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ boolean access$800(BottomSheetBehavior r0) {
        return r0.marginLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$900(BottomSheetBehavior r0) {
        return r0.marginRightSystemWindowInsets;
    }

    private int addAccessibilityActionForState(V r2, int r3, int r4) {
        return ViewCompat.addAccessibilityAction(r2, ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getString(r3), createAccessibilityViewCommandForState(r4));
    }

    private void calculateCollapsedOffset() {
        int r0 = calculatePeekHeight();
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - r0, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - r0;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == false) goto L8;
        int r0 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
    L6:
        return r0 + this.insetBottom;
    L8:
        if (this.gestureInsetBottomIgnored == false) goto L10;
    L15:
        r0 = this.peekHeight;
        goto L6
    L10:
        if (this.paddingBottomSystemWindowInsets == true) goto L15;
        int r1 = this.gestureInsetBottom;
        if (r1 <= 0) goto L15;
        return Math.max(this.peekHeight, r1 + this.peekHeightGestureInsetBuffer);
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r2) {
        return new AnonymousClass5(this, r2);
    }

    private void createMaterialShapeDrawableIfNeeded(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (this.shapeAppearanceModelDefault != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = r0;
        r0.initializeElevationOverlay(r5);
        ColorStateList r1 = this.backgroundTint;
        if (r1 == null) goto L8;
        this.materialShapeDrawable.setFillColor(r1);
        return;
    L8:
        TypedValue r2 = new TypedValue();
        r5.getTheme().resolveAttribute(android.R.attr.colorBackground, r2, true);
        this.materialShapeDrawable.setTint(r2.data);
    }

    private void createShapeValueAnimator() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = r0;
        r0.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new AnonymousClass2(this));
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

    private int getChildMeasureSpec(int r1, int r2, int r3, int r4) {
        int r0 = ViewGroup.getChildMeasureSpec(r1, r2, r4);
        if (r3 != (-1)) goto L5;
        return r0;
    L5:
        int r5 = View.MeasureSpec.getMode(r0);
        int r6 = View.MeasureSpec.getSize(r0);
        if (r5 == 1073741824) goto L13;
        if (r6 == 0) goto L11;
        r3 = Math.min(r6, r3);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
    L13:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r6, r3), 1073741824);
    }

    private int getTopOffsetForState(int r3) {
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L17;
        if (r3 == 5) goto L15;
        if (r3 != 6) goto L13;
        return this.halfExpandedOffset;
    L13:
        throw new IllegalArgumentException("Invalid state to get top offset: " + r3);
    L15:
        return this.parentHeight;
    L17:
        return this.collapsedOffset;
    L19:
        return getExpandedOffset();
    }

    private float getYVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isLayouting(V r1) {
        ViewParent r0 = r1.getParent();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isLayoutRequested() == false) goto L9;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L9;
        return true;
    }

    private void replaceAccessibilityActionForState(V r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat r2, int r3) {
        ViewCompat.replaceAccessibilityAction(r1, r2, null, createAccessibilityViewCommandForState(r3));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r0 = this.velocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.velocityTracker = null;
        return;
    }

    private void restoreOptionalState(SavedState r4) {
        int r0 = this.saveFlags;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != (-1)) goto L8;
    L9:
        this.peekHeight = r4.peekHeight;
    L10:
        int r1 = this.saveFlags;
        if (r1 != (-1)) goto L13;
    L14:
        this.fitToContents = r4.fitToContents;
    L15:
        int r2 = this.saveFlags;
        if (r2 != (-1)) goto L18;
    L19:
        this.hideable = r4.hideable;
    L20:
        int r3 = this.saveFlags;
        if (r3 != (-1)) goto L23;
    L24:
        this.skipCollapsed = r4.skipCollapsed;
        return;
    L23:
        if ((r3 & 8) == 8) goto L24;
        return;
    L18:
        if ((r2 & 4) != 4) goto L20;
    L13:
        if ((r1 & 2) != 2) goto L15;
    L8:
        if ((r0 & 1) != 1) goto L10;
        goto L9
    }

    private void runAfterLayout(V r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (isLayouting(r3) == false) goto L5;
        r3.post(r5);
        return;
    L5:
        r5.run();
    }

    private void setWindowInsetsListener(View r3) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L9:
        final boolean r0 = false;
    L11:
        if (this.paddingBottomSystemWindowInsets == false) goto L13;
    L24:
        r.a(r3, new AnonymousClass3(this, r0));
        return;
    L13:
        if (this.paddingLeftSystemWindowInsets == true) goto L24;
        if (this.paddingRightSystemWindowInsets == true) goto L24;
        if (this.marginLeftSystemWindowInsets == true) goto L24;
        if (this.marginRightSystemWindowInsets == true) goto L24;
        if (this.marginTopSystemWindowInsets == true) goto L24;
        if (r0 == true) goto L24;
        return;
    L5:
        if (isGestureInsetBottomIgnored() == true) goto L9;
        if (this.peekHeightAuto == true) goto L9;
        r0 = true;
        goto L11
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null) goto L5;
    L9:
        return false;
    L5:
        if (this.draggable == false) goto L7;
        return true;
    L7:
        if (this.state != 1) goto L9;
        return true;
    }

    private void startSettling(View r3, int r4, boolean r5) {
        int r0 = getTopOffsetForState(r4);
        ViewDragHelper r1 = this.viewDragHelper;
        if (r1 == null) goto L11;
        if (r5 == false) goto L9;
        if (r1.settleCapturedViewAt(r3.getLeft(), r0) == false) goto L11;
    L10:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        setStateInternal(2);
        updateDrawableForTargetState(r4);
        this.stateSettlingTracker.a(r4);
        return;
    L14:
        setStateInternal(r4);
        return;
    L9:
        if (r1.smoothSlideViewTo(r3, r3.getLeft(), r0) == true) goto L10;
    L11:
        r6 = false;
        goto L12
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        return;
    L8:
        ViewCompat.removeAccessibilityAction(r1, 524288);
        ViewCompat.removeAccessibilityAction(r1, 262144);
        ViewCompat.removeAccessibilityAction(r1, 1048576);
        int r2 = this.expandHalfwayActionId;
        if (r2 == (-1)) goto L11;
        ViewCompat.removeAccessibilityAction(r1, r2);
    L11:
        int r3 = 6;
        if (this.fitToContents == true) goto L17;
        if (this.state == 6) goto L17;
        this.expandHalfwayActionId = addAccessibilityActionForState(r1, ZeusTransformUtils.mapRes(R.string.bottomsheet_action_expand_halfway, TypedValues.Custom.S_STRING, "bottomsheet_action_expand_halfway"), 6);
    L17:
        if (this.hideable == true) goto L19;
    L21:
        int r4 = this.state;
        if (r4 == 3) goto L32;
        if (r4 == 4) goto L28;
        if (r4 != 6) goto L38;
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    L38:
        return;
    L28:
        if (this.fitToContents == false) goto L30;
        r3 = 3;
    L30:
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r5 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND;
    L35:
        replaceAccessibilityActionForState(r1, r5, r3);
        return;
    L32:
        if (this.fitToContents == false) goto L34;
        r3 = 4;
    L34:
        r5 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE;
        goto L35
    L19:
        if (this.state == 5) goto L21;
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        goto L21
    }

    private void updateDrawableForTargetState(int r6) {
        if (r6 != 2) goto L6;
        return;
    L6:
        if (r6 != 3) goto L8;
        boolean r7 = true;
    L10:
        if (this.isShapeExpanded == r7) goto L24;
        this.isShapeExpanded = r7;
        if (this.materialShapeDrawable == null) goto L25;
        ValueAnimator r1 = this.interpolatorAnimator;
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.isRunning() == false) goto L19;
        this.interpolatorAnimator.reverse();
        return;
    L19:
        if (r7 == false) goto L21;
        float r8 = 0.0f;
    L22:
        this.interpolatorAnimator.setFloatValues(new float[]{1.0f - r8, r8});
        this.interpolatorAnimator.start();
        return;
    L21:
        r8 = 1.0f;
        goto L22
    L25:
        return;
    L24:
        return;
    L8:
        r7 = false;
        goto L10
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
        if (r4 >= r3) goto L36;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.viewRef.get()) goto L35;
        if (r9 == false) goto L29;
        if (Build.VERSION.SDK_INT < 16) goto L25;
        this.importantForAccessibilityMap.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
    L25:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L35;
        int r6 = 4;
    L27:
        ViewCompat.setImportantForAccessibility(r5, r6);
        goto L35
    L29:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L35;
        Map<View, Integer> r7 = this.importantForAccessibilityMap;
        if (r7 == null) goto L35;
        if (r7.containsKey(r5) == false) goto L35;
        r6 = ((Integer) ZeusTransformUtils.preCheckCast(this.importantForAccessibilityMap.get(r5), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L35:
        r4 = r4 + 1;
        goto L16
    L36:
        if (r9 == true) goto L39;
        this.importantForAccessibilityMap = null;
        return;
    L39:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L50;
        ((View) ZeusTransformUtils.preCheckCast(this.viewRef.get(), View.class, "com.obric.memorydata.plugin")).sendAccessibilityEvent(8);
        return;
    }

    private void updatePeekHeight(boolean r5) {
        if (this.viewRef == null) goto L12;
        calculateCollapsedOffset();
        if (this.state != 4) goto L13;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.viewRef.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L14;
        if (r5 == false) goto L10;
        setState(4);
        return;
    L10:
        r0.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void addBottomSheetCallback(a r2) {
        if (this.callbacks.contains(r2) == true) goto L6;
        this.callbacks.add(r2);
        return;
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int r6) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.viewRef.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L19;
        int r1 = this.collapsedOffset;
        if (r6 <= r1) goto L9;
    L12:
        int r2 = this.collapsedOffset;
        float r7 = r2 - r6;
        float r3 = this.parentHeight - r2;
    L13:
        float r8 = r7 / r3;
        int r4 = 0;
    L15:
        if (r4 >= this.callbacks.size()) goto L20;
        ((a) ZeusTransformUtils.preCheckCast(this.callbacks.get(r4), a.class, "com.obric.memorydata.plugin")).a(r0, r8);
        r4 = r4 + 1;
        goto L15
    L20:
        return;
    L9:
        if (r1 == getExpandedOffset()) goto L12;
        int r5 = this.collapsedOffset;
        r7 = r5 - r6;
        r3 = r5 - getExpandedOffset();
        goto L13
    }

    View findScrollingChild(View r4) {
        if (ViewCompat.isNestedScrollingEnabled(r4) == false) goto L6;
        return r4;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L13;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r1 = r5.getChildCount();
    L8:
        if (r0 >= r1) goto L17;
        View r2 = findScrollingChild(r5.getChildAt(r0));
        if (r2 != null) goto L11;
        r0 = r0 + 1;
        goto L8
    L11:
        return r2;
    L17:
        return null;
    L13:
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents == true) goto L11;
        int r0 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets == false) goto L8;
        int r2 = 0;
    L10:
        return Math.max(r0, r2);
    L8:
        r2 = this.insetTop;
        goto L10
    L11:
        return this.fitToContentsOffset;
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
        super.onAttachedToLayoutParams(r1);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r11, V r12, MotionEvent r13) {
        if (r12.isShown() == true) goto L5;
    L64:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L64;
        int r0 = r13.getActionMasked();
        if (r0 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r13);
        View r4 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L41;
        this.ignoreEvents = false;
        return false;
    L41:
        if (this.ignoreEvents == true) goto L47;
        ViewDragHelper r14 = this.viewDragHelper;
        if (r14 == null) goto L47;
        if (r14.shouldInterceptTouchEvent(r13) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r15 = this.nestedScrollingChildRef;
        if (r15 == null) goto L50;
        r4 = (View) ZeusTransformUtils.preCheckCast(r15.get(), View.class, "com.obric.memorydata.plugin");
    L50:
        if (r0 != 2) goto L66;
        if (r4 != null) goto L53;
        return false;
    L53:
        if (this.ignoreEvents == false) goto L55;
        return false;
    L55:
        if (this.state != 1) goto L57;
        return false;
    L57:
        if (r11.isPointInChildBounds(r4, (int) r13.getX(), (int) r13.getY()) == false) goto L59;
        return false;
    L59:
        if (this.viewDragHelper != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.initialY - r13.getY()) > this.viewDragHelper.getTouchSlop()) goto L63;
        return false;
    L63:
        return true;
    L66:
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r7 = (int) r13.getX();
        this.initialY = (int) r13.getY();
        if (this.state == 2) goto L34;
        WeakReference<View> r8 = this.nestedScrollingChildRef;
        if (r8 == null) goto L28;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8.get(), View.class, "com.obric.memorydata.plugin");
    L29:
        if (r9 == null) goto L34;
        if (r11.isPointInChildBounds(r9, r7, this.initialY) == false) goto L34;
        this.activePointerId = r13.getPointerId(r13.getActionIndex());
        this.touchingScrollingChild = true;
        goto L34
    L28:
        r9 = null;
    L34:
        if (this.activePointerId == (-1)) goto L36;
    L38:
        boolean r16 = false;
    L39:
        this.ignoreEvents = r16;
        goto L41
    L36:
        if (r11.isPointInChildBounds(r12, r7, this.initialY) == true) goto L38;
        r16 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r9, V r10, int r11) {
        if (ViewCompat.getFitsSystemWindows(r9) == true) goto L5;
    L7:
        int r4 = 0;
        if (this.viewRef != null) goto L30;
        this.peekHeightMin = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_bottom_sheet_peek_height_min, "dimen", "design_bottom_sheet_peek_height_min"));
        setWindowInsetsListener(r10);
        this.viewRef = new WeakReference(r10);
        MaterialShapeDrawable r0 = this.materialShapeDrawable;
        if (r0 == null) goto L23;
        ViewCompat.setBackground(r10, r0);
        MaterialShapeDrawable r1 = this.materialShapeDrawable;
        float r5 = this.elevation;
        if (r5 != (-1.0f)) goto L14;
        r5 = ViewCompat.getElevation(r10);
    L14:
        r1.setElevation(r5);
        if (this.state != 3) goto L17;
        boolean r2 = true;
    L18:
        this.isShapeExpanded = r2;
        MaterialShapeDrawable r6 = this.materialShapeDrawable;
        if (r2 == false) goto L21;
        float r3 = 0.0f;
    L22:
        r6.setInterpolation(r3);
    L26:
        updateAccessibilityActions();
        if (ViewCompat.getImportantForAccessibility(r10) != 0) goto L30;
        ViewCompat.setImportantForAccessibility(r10, 1);
        goto L30
    L21:
        r3 = 1.0f;
        goto L22
    L17:
        r2 = false;
        goto L18
    L23:
        ColorStateList r7 = this.backgroundTint;
        if (r7 == null) goto L26;
        ViewCompat.setBackgroundTintList(r10, r7);
    L30:
        if (this.viewDragHelper != null) goto L32;
        this.viewDragHelper = ViewDragHelper.create(r9, this.dragCallback);
    L32:
        int r8 = r10.getTop();
        r9.onLayoutChild(r10, r11);
        this.parentWidth = r9.getWidth();
        this.parentHeight = r9.getHeight();
        int r12 = r10.getHeight();
        this.childHeight = r12;
        int r13 = this.parentHeight;
        int r14 = r13 - r12;
        int r15 = this.insetTop;
        if (r14 < r15) goto L35;
    L38:
        this.fitToContentsOffset = Math.max(0, r13 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r16 = this.state;
        if (r16 != 3) goto L43;
        int r17 = getExpandedOffset();
    L41:
        ViewCompat.offsetTopAndBottom(r10, r17);
    L57:
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r10));
    L59:
        if (r4 >= this.callbacks.size()) goto L61;
        ((a) ZeusTransformUtils.preCheckCast(this.callbacks.get(r4), a.class, "com.obric.memorydata.plugin")).a(r10);
        r4 = r4 + 1;
        goto L59
    L61:
        return true;
    L43:
        if (r16 != 6) goto L46;
        r17 = this.halfExpandedOffset;
        goto L41
    L46:
        if (this.hideable == false) goto L51;
        if (r16 != 5) goto L51;
        r17 = this.parentHeight;
    L51:
        if (r16 != 4) goto L53;
        r17 = this.collapsedOffset;
        goto L41
    L53:
        if (r16 != 1) goto L55;
    L56:
        ViewCompat.offsetTopAndBottom(r10, r8 - r10.getTop());
        goto L57
    L55:
        if (r16 != 2) goto L57;
    L35:
        if (this.paddingTopSystemWindowInsets == false) goto L37;
        this.childHeight = r13;
        goto L38
    L37:
        this.childHeight = r13 - r15;
        goto L38
    L5:
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L7;
        r10.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout r4, V r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r5.measure(getChildMeasureSpec(r6, (((r4.getPaddingLeft() + r4.getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r7, this.maxWidth, r0.width), getChildMeasureSpec(r8, (((r4.getPaddingTop() + r4.getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r9, this.maxHeight, r0.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout r4, V r5, View r6, float r7, float r8) {
        if (isNestedScrollingCheckEnabled() == false) goto L14;
        WeakReference<View> r0 = this.nestedScrollingChildRef;
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r6 == r0.get()) goto L9;
        return false;
    L9:
        if (this.state == 3) goto L11;
    L12:
        return true;
    L11:
        if (super.onNestedPreFling(r4, r5, r6, r7, r8) == true) goto L12;
        return false;
    L14:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r9 = this.nestedScrollingChildRef;
        if (r9 == null) goto L8;
        View r10 = (View) ZeusTransformUtils.preCheckCast(r9.get(), View.class, "com.obric.memorydata.plugin");
    L10:
        if (isNestedScrollingCheckEnabled() == false) goto L13;
        if (r4 == r10) goto L13;
        return;
    L13:
        int r11 = r3.getTop();
        int r12 = r11 - r6;
        if (r6 > 0) goto L16;
        if (r6 < 0) goto L26;
    L37:
        dispatchOnSlide(r3.getTop());
        this.lastNestedScrollDy = r6;
        this.nestedScrolled = true;
        return;
    L26:
        if (r4.canScrollVertically(-1) == true) goto L37;
        int r13 = this.collapsedOffset;
        if (r12 <= r13) goto L34;
        if (this.hideable == true) goto L34;
        r7[1] = r11 - r13;
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        int r14 = 4;
    L18:
        setStateInternal(r14);
    L34:
        if (this.draggable == true) goto L36;
        return;
    L36:
        r7[1] = r6;
    L23:
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L37
    L16:
        if (r12 >= getExpandedOffset()) goto L20;
        r7[1] = r11 - getExpandedOffset();
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        r14 = 3;
        goto L18
    L20:
        if (this.draggable == true) goto L22;
        return;
    L22:
        r7[1] = r6;
        goto L23
    L8:
        r10 = null;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r3, V r4, Parcelable r5) {
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin"), SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r3, r4, r6.getSuperState());
        restoreOptionalState(r6);
        if (r6.state != 1) goto L5;
    L8:
        int r7 = 4;
    L9:
        this.state = r7;
        this.lastStableState = r7;
        return;
    L5:
        if (r6.state == 2) goto L8;
        r7 = r6.state;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r2, V r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this);
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
    public void onStopNestedScroll(CoordinatorLayout r3, V r4, View r5, int r6) {
        int r0 = 3;
        if (r4.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (isNestedScrollingCheckEnabled() == false) goto L16;
        WeakReference<View> r7 = this.nestedScrollingChildRef;
        if (r7 != null) goto L11;
        return;
    L11:
        if (r5 == r7.get()) goto L13;
        return;
    L13:
        if (this.nestedScrolled == true) goto L16;
        return;
    L16:
        if (this.lastNestedScrollDy <= 0) goto L24;
        if (this.fitToContents == false) goto L21;
    L52:
        startSettling(r4, r0, false);
        this.nestedScrolled = false;
        return;
    L21:
        if (r4.getTop() <= this.halfExpandedOffset) goto L52;
    L51:
        r0 = 6;
        goto L52
    L24:
        if (this.hideable == false) goto L29;
        if (shouldHide(r4, getYVelocity()) == false) goto L29;
        r0 = 5;
    L29:
        if (this.lastNestedScrollDy != 0) goto L47;
        int r8 = r4.getTop();
        if (this.fitToContents == true) goto L33;
        int r1 = this.halfExpandedOffset;
        if (r8 >= r1) goto L44;
        if (r8 < Math.abs(r8 - this.collapsedOffset)) goto L52;
        if (shouldSkipHalfExpandedStateWhenDragging() == false) goto L51;
    L48:
        r0 = 4;
        goto L52
    L44:
        if (Math.abs(r8 - r1) >= Math.abs(r8 - this.collapsedOffset)) goto L48;
    L33:
        if (Math.abs(r8 - this.fitToContentsOffset) >= Math.abs(r8 - this.collapsedOffset)) goto L48;
    L47:
        if (this.fitToContents == true) goto L48;
        int r9 = r4.getTop();
        if (Math.abs(r9 - this.halfExpandedOffset) >= Math.abs(r9 - this.collapsedOffset)) goto L48;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r3, V r4, MotionEvent r5) {
        if (r4.isShown() == true) goto L6;
        return false;
    L6:
        int r6 = r5.getActionMasked();
        if (this.state != 1) goto L11;
        if (r6 != 0) goto L11;
        return true;
    L11:
        if (shouldHandleDraggingWithHelper() == false) goto L13;
        this.viewDragHelper.processTouchEvent(r5);
    L13:
        if (r6 != 0) goto L16;
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r5);
        if (shouldHandleDraggingWithHelper() == false) goto L28;
        if (r6 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (Math.abs(this.initialY - r5.getY()) <= this.viewDragHelper.getTouchSlop()) goto L28;
        this.viewDragHelper.captureChildView(r4, r5.getPointerId(r5.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(a r1) {
        this.callbacks.remove(r1);
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

    public void setExpandedOffset(int r1) {
        if (r1 < 0) goto L6;
        this.expandedOffset = r1;
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
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
        updateAccessibilityActions();
        return;
    L11:
        if (this.state != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public void setGestureInsetBottomIgnored(boolean r1) {
        this.gestureInsetBottomIgnored = r1;
    }

    public void setHalfExpandedRatio(float r2) {
        if (r2 <= 0.0f) goto L11;
        if (r2 >= 1.0f) goto L11;
        this.halfExpandedRatio = r2;
        if (this.viewRef == null) goto L12;
        calculateHalfExpandedOffset();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean r2) {
        if (this.hideable == r2) goto L11;
        this.hideable = r2;
        if (r2 == false) goto L7;
    L9:
        updateAccessibilityActions();
        return;
    L7:
        if (this.state != 5) goto L9;
        setState(4);
        goto L9
    }

    public void setHideableInternal(boolean r1) {
        this.hideable = r1;
    }

    public void setMaxHeight(int r1) {
        this.maxHeight = r1;
    }

    public void setMaxWidth(int r1) {
        this.maxWidth = r1;
    }

    public void setPeekHeight(int r2) {
        setPeekHeight(r2, false);
    }

    public final void setPeekHeight(int r4, boolean r5) {
        boolean r0 = true;
        if (r4 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r0 == false) goto L17;
        updatePeekHeight(r5);
        return;
    L17:
        return;
    L12:
        r0 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r4);
        goto L14
    L10:
        if (this.peekHeight == r4) goto L12;
        goto L12
    }

    public void setSaveFlags(int r1) {
        this.saveFlags = r1;
    }

    public void setSkipCollapsed(boolean r1) {
        this.skipCollapsed = r1;
    }

    public void setState(int r4) {
        if (r4 != 1) goto L5;
    L29:
        StringBuilder r1 = new StringBuilder().append("STATE_");
        if (r4 != 1) goto L32;
        String r5 = "DRAGGING";
    L34:
        throw new IllegalArgumentException(r1.append(r5).append(" should not be set externally.").toString());
    L32:
        r5 = "SETTLING";
        goto L34
    L5:
        if (r4 == 2) goto L29;
        if (this.hideable == true) goto L14;
        if (r4 != 5) goto L14;
        Log.w(TAG, "Cannot set state: " + r4);
        return;
    L14:
        if (r4 == 6) goto L16;
    L20:
        final int r0 = r4;
    L21:
        WeakReference<V> r2 = this.viewRef;
        if (r2 != null) goto L24;
    L27:
        setStateInternal(r4);
        return;
    L24:
        if (r2.get() == null) goto L27;
        final View r6 = (View) ZeusTransformUtils.preCheckCast(this.viewRef.get(), View.class, "com.obric.memorydata.plugin");
        runAfterLayout(r6, new AnonymousClass1(this, r6, r0));
        return;
    L16:
        if (this.fitToContents == false) goto L20;
        if (getTopOffsetForState(r4) > this.fitToContentsOffset) goto L20;
        r0 = 3;
        goto L21
    }

    void setStateInternal(int r8) {
        if (this.state != r8) goto L5;
        return;
    L5:
        this.state = r8;
        if (r8 == 4) goto L12;
        if (r8 == 3) goto L12;
        if (r8 == 6) goto L12;
        if (this.hideable == false) goto L13;
        if (r8 == 5) goto L12;
    L13:
        WeakReference<V> r4 = this.viewRef;
        if (r4 != null) goto L16;
        return;
    L16:
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.get(), View.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L19;
        return;
    L19:
        int r6 = 0;
        if (r8 != 3) goto L22;
        updateImportantForAccessibility(true);
    L26:
        updateDrawableForTargetState(r8);
    L28:
        if (r6 >= this.callbacks.size()) goto L30;
        ((a) ZeusTransformUtils.preCheckCast(this.callbacks.get(r6), a.class, "com.obric.memorydata.plugin")).a(r5, r8);
        r6 = r6 + 1;
        goto L28
    L30:
        updateAccessibilityActions();
        return;
    L22:
        if (r8 == 6) goto L25;
        if (r8 == 5) goto L25;
        if (r8 != 4) goto L26;
    L25:
        updateImportantForAccessibility(false);
    L12:
        this.lastStableState = r8;
        goto L13
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r1) {
        this.updateImportantForAccessibilityOnSiblings = r1;
    }

    public boolean shouldExpandOnUpwardDrag(long r1, float r3) {
        return false;
    }

    boolean shouldHide(View r5, float r6) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r5.getTop() >= this.collapsedOffset) goto L9;
        return false;
    L9:
        if ((Math.abs((r5.getTop() + (r6 * 0.1f)) - this.collapsedOffset) / calculatePeekHeight()) <= 0.5f) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }
}
