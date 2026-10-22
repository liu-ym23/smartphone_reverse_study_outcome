package com.google.android.material.sidesheet;

import ai.j0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    private static final int DEFAULT_ACCESSIBILITY_PANE_TITLE = 0;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    static final int SIGNIFICANT_VEL_THRESHOLD = 500;

    @Nullable
    private ColorStateList backgroundTint;

    @NonNull
    private final Set<SideSheetCallback> callbacks;
    private int childWidth;

    @IdRes
    private int coplanarSiblingViewId;

    @Nullable
    private WeakReference<View> coplanarSiblingViewRef;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    private float elevation;
    private float hideFriction;
    private boolean ignoreEvents;
    private int initialX;
    private int innerMargin;
    private int lastStableState;

    @Nullable
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private int parentInnerEdge;
    private int parentWidth;
    private ShapeAppearanceModel shapeAppearanceModel;
    private SheetDelegate sheetDelegate;

    @Nullable
    private MaterialSideContainerBackHelper sideContainerBackHelper;
    private int state;
    private final SideSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;

    @Nullable
    private VelocityTracker velocityTracker;

    @Nullable
    private ViewDragHelper viewDragHelper;

    @Nullable
    private WeakReference<V> viewRef;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final int state;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r5) {
            this(r5, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.state);
        }

        public SavedState(@NonNull Parcel r5, ClassLoader r10) {
            super(r5, r10);
            this.state = r5.readInt();
        }

        public SavedState(Parcelable r5, @NonNull SideSheetBehavior<?> r10) {
            super(r5);
            this.state = SideSheetBehavior.access$000(r10);
        }
    }

    public class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;
        final /* synthetic */ SideSheetBehavior this$0;

        public StateSettlingTracker(SideSheetBehavior r5) {
            this.this$0 = r5;
            this.continueSettlingRunnable = new d(this);
        }

        public static /* synthetic */ void a(StateSettlingTracker r5) {
            r5.lambda$new$0();
        }

        private /* synthetic */ void lambda$new$0() {
            this.isContinueSettlingRunnablePosted = false;
            if (SideSheetBehavior.access$800(this.this$0) == null) goto L8;
            if (SideSheetBehavior.access$800(this.this$0).continueSettling(true) == false) goto L8;
            continueSettlingToState(this.targetState);
            return;
        L8:
            if (SideSheetBehavior.access$000(this.this$0) != 2) goto L12;
            this.this$0.setStateInternal(this.targetState);
            return;
        }

        public void continueSettlingToState(int r5) {
            if (SideSheetBehavior.access$100(this.this$0) != null) goto L5;
            return;
        L5:
            if (SideSheetBehavior.access$100(this.this$0).get() == null) goto L13;
            this.targetState = r5;
            if (this.isContinueSettlingRunnablePosted == true) goto L12;
            ViewCompat.postOnAnimation((View) SideSheetBehavior.access$100(this.this$0).get(), this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
            return;
        L12:
            return;
        }
    }

    static {
        DEFAULT_ACCESSIBILITY_PANE_TITLE = R.string.side_sheet_accessibility_pane_title;
        DEF_STYLE_RES = R.style.Widget_Material3_SideSheet;
    }

    public SideSheetBehavior() {
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1(this);
    }

    public static /* synthetic */ boolean a(SideSheetBehavior r5, int r10, View r11, AccessibilityViewCommand.CommandArguments r12) {
        return r5.lambda$createAccessibilityViewCommandForState$2(r10, r11, r12);
    }

    public static /* synthetic */ int access$000(SideSheetBehavior r5) {
        return r5.state;
    }

    public static /* synthetic */ WeakReference access$100(SideSheetBehavior r5) {
        return r5.viewRef;
    }

    public static /* synthetic */ SheetDelegate access$200(SideSheetBehavior r5) {
        return r5.sheetDelegate;
    }

    public static /* synthetic */ void access$300(SideSheetBehavior r5, View r10, int r11) {
        r5.dispatchOnSlide(r10, r11);
    }

    public static /* synthetic */ boolean access$400(SideSheetBehavior r5) {
        return r5.draggable;
    }

    public static /* synthetic */ int access$500(SideSheetBehavior r5, View r10, float r11, float r12) {
        return r5.calculateTargetStateOnViewReleased(r10, r11, r12);
    }

    public static /* synthetic */ void access$600(SideSheetBehavior r5, View r10, int r11, boolean r12) {
        r5.startSettling(r10, r11, r12);
    }

    public static /* synthetic */ int access$700(SideSheetBehavior r5) {
        return r5.childWidth;
    }

    public static /* synthetic */ ViewDragHelper access$800(SideSheetBehavior r5) {
        return r5.viewDragHelper;
    }

    public static /* synthetic */ void b(SideSheetBehavior r5, int r10) {
        r5.lambda$setState$0(r10);
    }

    public static /* synthetic */ void c(SideSheetBehavior r5, ViewGroup.MarginLayoutParams r10, int r11, View r12, ValueAnimator r13) {
        r5.lambda$getCoplanarFinishAnimatorUpdateListener$1(r10, r11, r12, r13);
    }

    private int calculateCurrentOffset(int r5, V r10) {
        int r11 = this.state;
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L15;
        if (r11 != 3) goto L9;
        return 0;
    L9:
        if (r11 != 5) goto L12;
        return this.sheetDelegate.getHiddenOffset();
    L12:
        throw new IllegalStateException("Unexpected value: " + this.state);
    L15:
        return r5 - this.sheetDelegate.getOuterEdge(r10);
    }

    private float calculateDragDistance(float r5, float r10) {
        return Math.abs(r5 - r10);
    }

    private int calculateTargetStateOnViewReleased(@NonNull View r5, float r10, float r11) {
        if (isExpandingOutwards(r10) == false) goto L6;
        return 3;
    L6:
        if (shouldHide(r5, r10) == false) goto L13;
        if (this.sheetDelegate.isSwipeSignificant(r10, r11) == true) goto L19;
        if (this.sheetDelegate.isReleasedCloseToInnerEdge(r5) == true) goto L19;
        return 3;
    L19:
        return 5;
    L13:
        if (r10 != 0.0f) goto L15;
    L16:
        int r12 = r5.getLeft();
        if (Math.abs(r12 - getExpandedOffset()) >= Math.abs(r12 - this.sheetDelegate.getHiddenOffset())) goto L19;
        return 3;
    L15:
        if (SheetUtils.isSwipeMostlyHorizontal(r10, r11) == true) goto L19;
        goto L16
    }

    private void clearCoplanarSiblingView() {
        WeakReference<View> r5 = this.coplanarSiblingViewRef;
        if (r5 == null) goto L5;
        r5.clear();
    L5:
        this.coplanarSiblingViewRef = null;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r5) {
        return new b(this, r5);
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context r5) {
        if (this.shapeAppearanceModel != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r10 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.materialShapeDrawable = r10;
        r10.initializeElevationOverlay(r5);
        ColorStateList r11 = this.backgroundTint;
        if (r11 == null) goto L8;
        this.materialShapeDrawable.setFillColor(r11);
        return;
    L8:
        TypedValue r12 = new TypedValue();
        r5.getTheme().resolveAttribute(android.R.attr.colorBackground, r12, true);
        this.materialShapeDrawable.setTint(r12.data);
    }

    private void dispatchOnSlide(@NonNull View r5, int r10) {
        if (this.callbacks.isEmpty() == true) goto L8;
        float r11 = this.sheetDelegate.calculateSlideOffset(r10);
        Iterator<SideSheetCallback> r12 = this.callbacks.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        r12.next().onSlide(r5, r11);
        goto L6
    L10:
        return;
    }

    private void ensureAccessibilityPaneTitleIsSet(View r5) {
        if (ViewCompat.getAccessibilityPaneTitle(r5) != null) goto L6;
        ViewCompat.setAccessibilityPaneTitle(r5, r5.getResources().getString(DEFAULT_ACCESSIBILITY_PANE_TITLE));
        return;
    }

    @NonNull
    public static <V extends View> SideSheetBehavior<V> from(@NonNull V r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r11 = ((CoordinatorLayout.LayoutParams) r10).getBehavior();
        if ((r11 instanceof SideSheetBehavior) == false) goto L9;
        return (SideSheetBehavior) r11;
    L9:
        throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int r5, int r10, int r11, int r12) {
        int r13 = ViewGroup.getChildMeasureSpec(r5, r10, r12);
        if (r11 != (-1)) goto L5;
        return r13;
    L5:
        int r14 = View.MeasureSpec.getMode(r13);
        int r15 = View.MeasureSpec.getSize(r13);
        if (r14 == 1073741824) goto L13;
        if (r15 == 0) goto L11;
        r11 = Math.min(r15, r11);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
    L13:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r15, r11), BasicMeasure.EXACTLY);
    }

    @Nullable
    private ValueAnimator.AnimatorUpdateListener getCoplanarFinishAnimatorUpdateListener() {
        final View r5 = getCoplanarSiblingView();
        if (r5 != null) goto L5;
        return null;
    L5:
        final ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        if (r10 != null) goto L8;
        return null;
    L8:
        final int r11 = this.sheetDelegate.getCoplanarSiblingAdjacentMargin(r10);
        return new c(this, r10, r11, r5);
    }

    @GravityInt
    private int getGravityFromSheetEdge() {
        SheetDelegate r5 = this.sheetDelegate;
        if (r5 != null) goto L5;
        return 5;
    L5:
        if (r5.getSheetEdge() == 0) goto L10;
        return 3;
    L10:
        return 5;
    }

    @Nullable
    private CoordinatorLayout.LayoutParams getViewLayoutParams() {
        WeakReference<V> r5 = this.viewRef;
        if (r5 == null) goto L10;
        V r10 = r5.get();
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L9;
        return null;
    L9:
        return (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
    L10:
        return null;
    }

    private boolean hasLeftMargin() {
        CoordinatorLayout.LayoutParams r5 = getViewLayoutParams();
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (((ViewGroup.MarginLayoutParams) r5).leftMargin <= 0) goto L7;
        return true;
    }

    private boolean hasRightMargin() {
        CoordinatorLayout.LayoutParams r5 = getViewLayoutParams();
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (((ViewGroup.MarginLayoutParams) r5).rightMargin <= 0) goto L7;
        return true;
    }

    private boolean isDraggedFarEnough(@NonNull MotionEvent r5) {
        if (shouldHandleDraggingWithHelper() == true) goto L6;
        return false;
    L6:
        if (calculateDragDistance(this.initialX, r5.getX()) <= this.viewDragHelper.getTouchSlop()) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isExpandingOutwards(float r5) {
        return this.sheetDelegate.isExpandingOutwards(r5);
    }

    private boolean isLayingOut(@NonNull V r5) {
        ViewParent r10 = r5.getParent();
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.isLayoutRequested() == false) goto L9;
        if (ViewCompat.isAttachedToWindow(r5) == false) goto L9;
        return true;
    }

    private boolean isSettling(View r5, int r10, boolean r11) {
        int r12 = getOuterEdgeOffsetForState(r10);
        ViewDragHelper r13 = getViewDragHelper();
        if (r13 == null) goto L11;
        if (r11 == false) goto L9;
        if (r13.settleCapturedViewAt(r12, r5.getTop()) == false) goto L11;
    L10:
        return true;
    L9:
        if (r13.smoothSlideViewTo(r5, r12, r5.getTop()) == true) goto L10;
    L11:
        return false;
    }

    private /* synthetic */ boolean lambda$createAccessibilityViewCommandForState$2(int r5, View r10, AccessibilityViewCommand.CommandArguments r11) {
        setState(r5);
        return true;
    }

    private /* synthetic */ void lambda$getCoplanarFinishAnimatorUpdateListener$1(ViewGroup.MarginLayoutParams r5, int r10, View r11, ValueAnimator r12) {
        this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(r5, AnimationUtils.lerp(r10, 0, r12.getAnimatedFraction()));
        r11.requestLayout();
    }

    private /* synthetic */ void lambda$setState$0(int r5) {
        V r10 = this.viewRef.get();
        if (r10 == null) goto L6;
        startSettling(r10, r5, false);
        return;
    }

    private void maybeAssignCoplanarSiblingViewBasedId(@NonNull CoordinatorLayout r5) {
        if (this.coplanarSiblingViewRef != null) goto L10;
        int r10 = this.coplanarSiblingViewId;
        if (r10 == (-1)) goto L11;
        View r11 = r5.findViewById(r10);
        if (r11 == null) goto L12;
        this.coplanarSiblingViewRef = new WeakReference(r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void replaceAccessibilityActionForState(V r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat r10, int r11) {
        ViewCompat.replaceAccessibilityAction(r5, r10, null, createAccessibilityViewCommandForState(r11));
    }

    private void resetVelocity() {
        VelocityTracker r5 = this.velocityTracker;
        if (r5 == null) goto L6;
        r5.recycle();
        this.velocityTracker = null;
        return;
    }

    private void runAfterLayout(@NonNull V r5, Runnable r10) {
        if (isLayingOut(r5) == false) goto L5;
        r5.post(r10);
        return;
    L5:
        r10.run();
    }

    private void setSheetEdge(@NonNull V r5, int r10) {
        if (GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) r5.getLayoutParams()).gravity, r10) != 3) goto L5;
        int r11 = 1;
    L6:
        setSheetEdge(r11);
        return;
    L5:
        r11 = 0;
        goto L6
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

    private boolean shouldInterceptTouchEvent(@NonNull V r5) {
        if (r5.isShown() == true) goto L7;
        if (ViewCompat.getAccessibilityPaneTitle(r5) != null) goto L7;
    L9:
        return false;
    L7:
        if (this.draggable == false) goto L9;
        return true;
    }

    private void startSettling(View r5, int r10, boolean r11) {
        if (isSettling(r5, r10, r11) == false) goto L5;
        setStateInternal(2);
        this.stateSettlingTracker.continueSettlingToState(r10);
        return;
    L5:
        setStateInternal(r10);
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r5 = this.viewRef;
        if (r5 != null) goto L5;
        return;
    L5:
        V r10 = r5.get();
        if (r10 != null) goto L8;
        return;
    L8:
        ViewCompat.removeAccessibilityAction(r10, 262144);
        ViewCompat.removeAccessibilityAction(r10, 1048576);
        if (this.state == 5) goto L12;
        replaceAccessibilityActionForState(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
    L12:
        if (this.state == 3) goto L15;
        replaceAccessibilityActionForState(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    }

    private void updateCoplanarSiblingBackProgress() {
        WeakReference<V> r5 = this.viewRef;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.get() == null) goto L16;
        V r10 = this.viewRef.get();
        View r11 = getCoplanarSiblingView();
        if (r11 != null) goto L10;
        return;
    L10:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        if (r12 != null) goto L13;
        return;
    L13:
        this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(r12, (int) ((r10.getScaleX() * this.childWidth) + this.innerMargin));
        r11.requestLayout();
        return;
    }

    private void updateMaterialShapeDrawable(@NonNull ShapeAppearanceModel r5) {
        MaterialShapeDrawable r10 = this.materialShapeDrawable;
        if (r10 == null) goto L6;
        r10.setShapeAppearanceModel(r5);
        return;
    }

    private void updateSheetVisibility(@NonNull View r5) {
        if (this.state != 5) goto L5;
        int r10 = 4;
    L7:
        if (r5.getVisibility() == r10) goto L10;
        r5.setVisibility(r10);
        return;
    L10:
        return;
    L5:
        r10 = 0;
        goto L7
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public /* bridge */ /* synthetic */ void addCallback(@NonNull SheetCallback r5) {
        addCallback((SideSheetCallback) r5);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        MaterialSideContainerBackHelper r5 = this.sideContainerBackHelper;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.cancelBackProgress();
    }

    public void expand() {
        setState(3);
    }

    @Nullable
    @VisibleForTesting
    public MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    public int getChildWidth() {
        return this.childWidth;
    }

    @Nullable
    public View getCoplanarSiblingView() {
        WeakReference<View> r5 = this.coplanarSiblingViewRef;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.get();
    }

    public int getExpandedOffset() {
        return this.sheetDelegate.getExpandedOffset();
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    public float getHideThreshold() {
        return 0.5f;
    }

    public int getInnerMargin() {
        return this.innerMargin;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    public int getOuterEdgeOffsetForState(int r5) {
        if (r5 == 3) goto L11;
        if (r5 != 5) goto L9;
        return this.sheetDelegate.getHiddenOffset();
    L9:
        throw new IllegalArgumentException(j0.g(r5, "Invalid state to get outer edge offset: "));
    L11:
        return getExpandedOffset();
    }

    public int getParentInnerEdge() {
        return this.parentInnerEdge;
    }

    public int getParentWidth() {
        return this.parentWidth;
    }

    public int getSignificantVelocityThreshold() {
        return SIGNIFICANT_VEL_THRESHOLD;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public int getState() {
        return this.state;
    }

    @Nullable
    public ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    public float getXVelocity() {
        VelocityTracker r5 = this.velocityTracker;
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        r5.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getXVelocity();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        MaterialSideContainerBackHelper r5 = this.sideContainerBackHelper;
        if (r5 != null) goto L5;
        return;
    L5:
        BackEventCompat r10 = r5.onHandleBackInvoked();
        if (r10 != null) goto L8;
    L12:
        setState(5);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 34) goto L12;
        this.sideContainerBackHelper.finishBackProgress(r10, getGravityFromSheetEdge(), new AnonymousClass2(this), getCoplanarFinishAnimatorUpdateListener());
    }

    public void hide() {
        setState(5);
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r5) {
        super.onAttachedToLayoutParams(r5);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull MotionEvent r11) {
        if (shouldInterceptTouchEvent(r10) == true) goto L6;
        this.ignoreEvents = true;
        return false;
    L6:
        int r12 = r11.getActionMasked();
        if (r12 != 0) goto L10;
        resetVelocity();
    L10:
        if (this.velocityTracker != null) goto L12;
        this.velocityTracker = VelocityTracker.obtain();
    L12:
        this.velocityTracker.addMovement(r11);
        if (r12 == 0) goto L22;
        if (r12 == 1) goto L19;
        if (r12 == 3) goto L19;
    L24:
        if (this.ignoreEvents == true) goto L31;
        ViewDragHelper r13 = this.viewDragHelper;
        if (r13 == null) goto L31;
        if (r13.shouldInterceptTouchEvent(r11) == false) goto L31;
        return true;
    L31:
        return false;
    L19:
        if (this.ignoreEvents == false) goto L24;
        this.ignoreEvents = false;
        return false;
    L22:
        this.initialX = (int) r11.getX();
        goto L24
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11) {
        if (ViewCompat.getFitsSystemWindows(r5) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L8;
        r10.setFitsSystemWindows(true);
    L8:
        if (this.viewRef != null) goto L22;
        this.viewRef = new WeakReference(r10);
        this.sideContainerBackHelper = new MaterialSideContainerBackHelper(r10);
        MaterialShapeDrawable r12 = this.materialShapeDrawable;
        if (r12 == null) goto L15;
        ViewCompat.setBackground(r10, r12);
        MaterialShapeDrawable r13 = this.materialShapeDrawable;
        float r14 = this.elevation;
        if (r14 != (-1.0f)) goto L14;
        r14 = ViewCompat.getElevation(r10);
    L14:
        r13.setElevation(r14);
    L18:
        updateSheetVisibility(r10);
        updateAccessibilityActions();
        if (ViewCompat.getImportantForAccessibility(r10) != 0) goto L21;
        ViewCompat.setImportantForAccessibility(r10, 1);
    L21:
        ensureAccessibilityPaneTitleIsSet(r10);
        goto L22
    L15:
        ColorStateList r15 = this.backgroundTint;
        if (r15 == null) goto L18;
        ViewCompat.setBackgroundTintList(r10, r15);
    L22:
        setSheetEdge(r10, r11);
        if (this.viewDragHelper != null) goto L25;
        this.viewDragHelper = ViewDragHelper.create(r5, this.dragCallback);
    L25:
        int r16 = this.sheetDelegate.getOuterEdge(r10);
        r5.onLayoutChild(r10, r11);
        this.parentWidth = r5.getWidth();
        this.parentInnerEdge = this.sheetDelegate.getParentInnerEdge(r5);
        this.childWidth = r10.getWidth();
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        if (r17 == null) goto L28;
        int r18 = this.sheetDelegate.calculateInnerMargin(r17);
    L29:
        this.innerMargin = r18;
        ViewCompat.offsetLeftAndRight(r10, calculateCurrentOffset(r16, r10));
        maybeAssignCoplanarSiblingViewBasedId(r5);
        Iterator<SideSheetCallback> r19 = this.callbacks.iterator();
    L31:
        if (r19.hasNext() == false) goto L35;
        SideSheetCallback r20 = r19.next();
        if ((r20 instanceof SideSheetCallback) == false) goto L31;
        r20.onLayout(r10);
        goto L31
    L35:
        return true;
    L28:
        r18 = 0;
        goto L29
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11, int r12, int r13, int r14) {
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r16 = r5.getPaddingLeft();
        int r17 = getChildMeasureSpec(r11, (((r5.getPaddingRight() + r16) + r15.leftMargin) + r15.rightMargin) + r12, -1, r15.width);
        int r18 = r5.getPaddingTop();
        r10.measure(r17, getChildMeasureSpec(r13, (((r5.getPaddingBottom() + r18) + r15.topMargin) + r15.bottomMargin) + r14, -1, r15.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull Parcelable r11) {
        SavedState r12 = (SavedState) r11;
        if (r12.getSuperState() == null) goto L5;
        super.onRestoreInstanceState(r5, r10, r12.getSuperState());
    L5:
        int r13 = r12.state;
        if (r13 != 1) goto L8;
    L9:
        r13 = 5;
    L10:
        this.state = r13;
        this.lastStableState = r13;
        return;
    L8:
        if (r13 != 2) goto L10;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r5, @NonNull V r10) {
        return new SavedState(super.onSaveInstanceState(r5, r10), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull MotionEvent r11) {
        if (r10.isShown() == true) goto L6;
        return false;
    L6:
        int r12 = r11.getActionMasked();
        if (this.state != 1) goto L11;
        if (r12 != 0) goto L11;
        return true;
    L11:
        if (shouldHandleDraggingWithHelper() == false) goto L13;
        this.viewDragHelper.processTouchEvent(r11);
    L13:
        if (r12 != 0) goto L16;
        resetVelocity();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r11);
        if (shouldHandleDraggingWithHelper() == false) goto L28;
        if (r12 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (isDraggedFarEnough(r11) == false) goto L28;
        this.viewDragHelper.captureChildView(r10, r11.getPointerId(r11.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public /* bridge */ /* synthetic */ void removeCallback(@NonNull SheetCallback r5) {
        removeCallback((SideSheetCallback) r5);
    }

    public void setCoplanarSiblingView(@Nullable View r5) {
        this.coplanarSiblingViewId = -1;
        if (r5 != null) goto L5;
        clearCoplanarSiblingView();
        return;
    L5:
        this.coplanarSiblingViewRef = new WeakReference(r5);
        WeakReference<V> r10 = this.viewRef;
        if (r10 == null) goto L12;
        V r11 = r10.get();
        if (ViewCompat.isLaidOut(r11) == false) goto L13;
        r11.requestLayout();
        return;
    L13:
        return;
    }

    public void setCoplanarSiblingViewId(@IdRes int r5) {
        this.coplanarSiblingViewId = r5;
        clearCoplanarSiblingView();
        WeakReference<V> r10 = this.viewRef;
        if (r10 == null) goto L10;
        V r11 = r10.get();
        if (r5 != (-1)) goto L7;
        return;
    L7:
        if (ViewCompat.isLaidOut(r11) == false) goto L12;
        r11.requestLayout();
        return;
    L12:
        return;
    }

    public void setDraggable(boolean r5) {
        this.draggable = r5;
    }

    public void setHideFriction(float r5) {
        this.hideFriction = r5;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public void setState(int r5) {
        if (r5 != 1) goto L5;
    L15:
        StringBuilder r10 = new StringBuilder("STATE_");
        if (r5 != 1) goto L18;
        String r11 = "DRAGGING";
    L20:
        throw new IllegalArgumentException(j0.q(r10, r11, " should not be set externally."));
    L18:
        r11 = "SETTLING";
        goto L20
    L5:
        if (r5 == 2) goto L15;
        WeakReference<V> r12 = this.viewRef;
        if (r12 != null) goto L10;
    L13:
        setStateInternal(r5);
        return;
    L10:
        if (r12.get() == null) goto L13;
        runAfterLayout(this.viewRef.get(), new androidx.core.content.res.a(r5, 3, this));
    }

    public void setStateInternal(int r5) {
        if (this.state != r5) goto L5;
        return;
    L5:
        this.state = r5;
        if (r5 != 3) goto L8;
    L9:
        this.lastStableState = r5;
    L10:
        WeakReference<V> r10 = this.viewRef;
        if (r10 != null) goto L13;
        return;
    L13:
        V r11 = r10.get();
        if (r11 != null) goto L16;
        return;
    L16:
        updateSheetVisibility(r11);
        Iterator<SideSheetCallback> r12 = this.callbacks.iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        r12.next().onStateChanged(r11, r5);
        goto L18
    L20:
        updateAccessibilityActions();
        return;
    L8:
        if (r5 != 5) goto L10;
        goto L9
    }

    public boolean shouldHide(@NonNull View r5, float r10) {
        return this.sheetDelegate.shouldHide(r5, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(@NonNull BackEventCompat r5) {
        MaterialSideContainerBackHelper r10 = this.sideContainerBackHelper;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.startBackProgress(r5);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(@NonNull BackEventCompat r5) {
        MaterialSideContainerBackHelper r10 = this.sideContainerBackHelper;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.updateBackProgress(r5, getGravityFromSheetEdge());
        updateCoplanarSiblingBackProgress();
    }

    public void addCallback(@NonNull SideSheetCallback r5) {
        this.callbacks.add(r5);
    }

    public void removeCallback(@NonNull SideSheetCallback r5) {
        this.callbacks.remove(r5);
    }

    private void setSheetEdge(int r5) {
        SheetDelegate r10 = this.sheetDelegate;
        if (r10 == null) goto L9;
        if (r10.getSheetEdge() != r5) goto L9;
        return;
    L9:
        if (r5 != 0) goto L17;
        this.sheetDelegate = new RightSheetDelegate(this);
        if (this.shapeAppearanceModel != null) goto L13;
        return;
    L13:
        if (hasRightMargin() == true) goto L27;
        ShapeAppearanceModel.Builder r11 = this.shapeAppearanceModel.toBuilder();
        r11.setTopRightCornerSize(0.0f).setBottomRightCornerSize(0.0f);
        updateMaterialShapeDrawable(r11.build());
        return;
    L27:
        return;
    L17:
        if (r5 != 1) goto L25;
        this.sheetDelegate = new LeftSheetDelegate(this);
        if (this.shapeAppearanceModel != null) goto L21;
        return;
    L21:
        if (hasLeftMargin() == true) goto L29;
        ShapeAppearanceModel.Builder r12 = this.shapeAppearanceModel.toBuilder();
        r12.setTopLeftCornerSize(0.0f).setBottomLeftCornerSize(0.0f);
        updateMaterialShapeDrawable(r12.build());
        return;
    L29:
        return;
    L25:
        throw new IllegalArgumentException(j0.h(r5, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
    }

    public SideSheetBehavior(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1(this);
        TypedArray r5 = r10.obtainStyledAttributes(r11, R.styleable.SideSheetBehavior_Layout);
        if (r5.hasValue(R.styleable.SideSheetBehavior_Layout_backgroundTint) == false) goto L6;
        this.backgroundTint = MaterialResources.getColorStateList(r10, r5, R.styleable.SideSheetBehavior_Layout_backgroundTint);
    L6:
        if (r5.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance) == false) goto L9;
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r10, r11, 0, DEF_STYLE_RES).build();
    L9:
        if (r5.hasValue(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId) == false) goto L11;
        setCoplanarSiblingViewId(r5.getResourceId(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId, -1));
    L11:
        createMaterialShapeDrawableIfNeeded(r10);
        this.elevation = r5.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        setDraggable(r5.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        r5.recycle();
        this.maximumVelocity = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
    }
}
