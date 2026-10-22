package com.google.android.material.bottomsheet;

import ai.j0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements MaterialBackHandler {
    private static final int CORNER_ANIMATION_DURATION = 500;

    @VisibleForTesting
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int INVALID_POSITION = -1;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";

    @VisibleForTesting
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    private static final int VIEW_INDEX_BOTTOM_SHEET = 0;

    @Nullable
    WeakReference<View> accessibilityDelegateViewRef;
    int activePointerId;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    MaterialBottomContainerBackHelper bottomContainerBackHelper;

    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;

    @VisibleForTesting
    final SparseIntArray expandHalfwayActionIds;
    private boolean expandedCornersRemoved;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    private float hideFriction;
    boolean hideable;
    private boolean ignoreEvents;

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;

    @Nullable
    private ValueAnimator interpolatorAnimator;
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

    @Nullable
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
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    private int significantVelocityThreshold;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;

    @Nullable
    private VelocityTracker velocityTracker;

    @Nullable
    ViewDragHelper viewDragHelper;

    @Nullable
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public BottomSheetCallback() {
        }

        public void onLayout(@NonNull View r5) {
        }

        public abstract void onSlide(@NonNull View r5, float r10);

        public abstract void onStateChanged(@NonNull View r5, int r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
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
            r5.writeInt(this.peekHeight);
            r5.writeInt(this.fitToContents ? 1 : 0);
            r5.writeInt(this.hideable ? 1 : 0);
            r5.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r5, ClassLoader r10) {
            super(r5, r10);
            this.state = r5.readInt();
            this.peekHeight = r5.readInt();
            boolean r11 = false;
            if (r5.readInt() != 1) goto L5;
            boolean r12 = true;
        L6:
            this.fitToContents = r12;
            if (r5.readInt() != 1) goto L9;
            boolean r13 = true;
        L10:
            this.hideable = r13;
            if (r5.readInt() != 1) goto L13;
            r11 = true;
        L13:
            this.skipCollapsed = r11;
            return;
        L9:
            r13 = false;
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        public SavedState(Parcelable r5, @NonNull BottomSheetBehavior<?> r10) {
            super(r5);
            this.state = r10.state;
            this.peekHeight = BottomSheetBehavior.access$1900(r10);
            this.fitToContents = BottomSheetBehavior.access$1400(r10);
            this.hideable = r10.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$2000(r10);
        }

        @Deprecated
        public SavedState(Parcelable r5, int r10) {
            super(r5);
            this.state = r10;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    public class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;

        private StateSettlingTracker(BottomSheetBehavior r5) {
            this.this$0 = r5;
            this.continueSettlingRunnable = new AnonymousClass1(this);
        }

        public static /* synthetic */ boolean access$1702(StateSettlingTracker r5, boolean r10) {
            r5.isContinueSettlingRunnablePosted = r10;
            return r10;
        }

        public static /* synthetic */ int access$1800(StateSettlingTracker r5) {
            return r5.targetState;
        }

        public void continueSettlingToState(int r5) {
            WeakReference<V> r10 = this.this$0.viewRef;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.get() == null) goto L13;
            this.targetState = r5;
            if (this.isContinueSettlingRunnablePosted == true) goto L12;
            ViewCompat.postOnAnimation(this.this$0.viewRef.get(), this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
            return;
        L12:
            return;
        }

        public /* synthetic */ StateSettlingTracker(BottomSheetBehavior r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new AnonymousClass5(this);
    }

    public static /* synthetic */ void access$100(BottomSheetBehavior r5, View r10, int r11, boolean r12) {
        r5.startSettling(r10, r11, r12);
    }

    public static /* synthetic */ boolean access$1000(BottomSheetBehavior r5) {
        return r5.marginTopSystemWindowInsets;
    }

    public static /* synthetic */ int access$1102(BottomSheetBehavior r5, int r10) {
        r5.gestureInsetBottom = r10;
        return r10;
    }

    public static /* synthetic */ void access$1200(BottomSheetBehavior r5, boolean r10) {
        r5.updatePeekHeight(r10);
    }

    public static /* synthetic */ boolean access$1300(BottomSheetBehavior r5) {
        return r5.draggable;
    }

    public static /* synthetic */ boolean access$1400(BottomSheetBehavior r5) {
        return r5.fitToContents;
    }

    public static /* synthetic */ int access$1500(BottomSheetBehavior r5) {
        return r5.significantVelocityThreshold;
    }

    public static /* synthetic */ boolean access$1600(BottomSheetBehavior r5) {
        return r5.canBeHiddenByDragging();
    }

    public static /* synthetic */ int access$1900(BottomSheetBehavior r5) {
        return r5.peekHeight;
    }

    public static /* synthetic */ MaterialShapeDrawable access$200(BottomSheetBehavior r5) {
        return r5.materialShapeDrawable;
    }

    public static /* synthetic */ boolean access$2000(BottomSheetBehavior r5) {
        return r5.skipCollapsed;
    }

    public static /* synthetic */ int access$302(BottomSheetBehavior r5, int r10) {
        r5.insetTop = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$400(BottomSheetBehavior r5) {
        return r5.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ int access$500(BottomSheetBehavior r5) {
        return r5.insetBottom;
    }

    public static /* synthetic */ int access$502(BottomSheetBehavior r5, int r10) {
        r5.insetBottom = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$600(BottomSheetBehavior r5) {
        return r5.paddingLeftSystemWindowInsets;
    }

    public static /* synthetic */ boolean access$700(BottomSheetBehavior r5) {
        return r5.paddingRightSystemWindowInsets;
    }

    public static /* synthetic */ boolean access$800(BottomSheetBehavior r5) {
        return r5.marginLeftSystemWindowInsets;
    }

    public static /* synthetic */ boolean access$900(BottomSheetBehavior r5) {
        return r5.marginRightSystemWindowInsets;
    }

    private int addAccessibilityActionForState(View r5, @StringRes int r10, int r11) {
        return ViewCompat.addAccessibilityAction(r5, r5.getResources().getString(r10), createAccessibilityViewCommandForState(r11));
    }

    private void calculateCollapsedOffset() {
        int r5 = calculatePeekHeight();
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - r5, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - r5;
    }

    @RequiresApi(31)
    private float calculateCornerInterpolation(float r5, @Nullable RoundedCorner r10) {
        if (r10 == null) goto L10;
        float r11 = r10.getRadius();
        if (r11 <= 0.0f) goto L10;
        if (r5 <= 0.0f) goto L10;
        return r11 / r5;
    L10:
        return 0.0f;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * this.parentHeight);
    }

    private float calculateInterpolationWithCornersRemoved() {
        if (this.materialShapeDrawable == null) goto L14;
        WeakReference<V> r5 = this.viewRef;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        if (r5.get() == null) goto L17;
        V r10 = this.viewRef.get();
        if (isAtTopOfScreen() == false) goto L18;
        WindowInsets r11 = r10.getRootWindowInsets();
        if (r11 != null) goto L13;
        return 0.0f;
    L13:
        return Math.max(calculateCornerInterpolation(this.materialShapeDrawable.getTopLeftCornerResolvedSize(), r11.getRoundedCorner(0)), calculateCornerInterpolation(this.materialShapeDrawable.getTopRightCornerResolvedSize(), r11.getRoundedCorner(1)));
    L18:
        return 0.0f;
    L17:
        return 0.0f;
    L14:
        return 0.0f;
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == false) goto L8;
        int r5 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
        int r10 = this.insetBottom;
    L6:
        return r5 + r10;
    L8:
        if (this.gestureInsetBottomIgnored == false) goto L10;
    L15:
        r5 = this.peekHeight;
        r10 = this.insetBottom;
        goto L6
    L10:
        if (this.paddingBottomSystemWindowInsets == true) goto L15;
        int r11 = this.gestureInsetBottom;
        if (r11 <= 0) goto L15;
        return Math.max(this.peekHeight, r11 + this.peekHeightGestureInsetBuffer);
    }

    private float calculateSlideOffsetWithTop(int r5) {
        int r10 = this.collapsedOffset;
        if (r5 <= r10) goto L5;
    L9:
        int r11 = this.collapsedOffset;
        float r12 = r11 - r5;
        float r13 = this.parentHeight - r11;
    L10:
        return r12 / r13;
    L5:
        if (r10 == getExpandedOffset()) goto L9;
        int r14 = this.collapsedOffset;
        r12 = r14 - r5;
        r13 = r14 - getExpandedOffset();
        goto L10
    }

    private boolean canBeHiddenByDragging() {
        if (isHideable() == true) goto L5;
    L7:
        return false;
    L5:
        if (isHideableWhenDragging() == false) goto L7;
        return true;
    }

    private void clearAccessibilityAction(View r5, int r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        ViewCompat.removeAccessibilityAction(r5, 524288);
        ViewCompat.removeAccessibilityAction(r5, 262144);
        ViewCompat.removeAccessibilityAction(r5, 1048576);
        int r11 = this.expandHalfwayActionIds.get(r10, -1);
        if (r11 == (-1)) goto L8;
        ViewCompat.removeAccessibilityAction(r5, r11);
        this.expandHalfwayActionIds.delete(r10);
        return;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r5) {
        return new AnonymousClass6(this, r5);
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context r5) {
        if (this.shapeAppearanceModelDefault != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r10 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
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

    private void createShapeValueAnimator() {
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{calculateInterpolationWithCornersRemoved(), 1.0f});
        this.interpolatorAnimator = r5;
        r5.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new AnonymousClass3(this));
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r11 = ((CoordinatorLayout.LayoutParams) r10).getBehavior();
        if ((r11 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r11;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
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

    private int getTopOffsetForState(int r5) {
        if (r5 == 3) goto L19;
        if (r5 == 4) goto L17;
        if (r5 == 5) goto L15;
        if (r5 != 6) goto L13;
        return this.halfExpandedOffset;
    L13:
        throw new IllegalArgumentException(j0.g(r5, "Invalid state to get top offset: "));
    L15:
        return this.parentHeight;
    L17:
        return this.collapsedOffset;
    L19:
        return getExpandedOffset();
    }

    private float getYVelocity() {
        VelocityTracker r5 = this.velocityTracker;
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        r5.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isAtTopOfScreen() {
        WeakReference<V> r5 = this.viewRef;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.get() == null) goto L13;
        int[] r10 = new int[2];
        this.viewRef.get().getLocationOnScreen(r10);
        if (r10[1] == 0) goto L10;
        return false;
    L10:
        return true;
    L13:
        return false;
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        if (this.state == 3) goto L5;
    L9:
        return false;
    L5:
        if (this.shouldRemoveExpandedCorners == false) goto L7;
    L8:
        return true;
    L7:
        if (isAtTopOfScreen() == false) goto L9;
        goto L8
    }

    private boolean isLayouting(V r5) {
        ViewParent r10 = r5.getParent();
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.isLayoutRequested() == false) goto L9;
        if (ViewCompat.isAttachedToWindow(r5) == false) goto L9;
        return true;
    }

    private void replaceAccessibilityActionForState(View r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat r10, int r11) {
        ViewCompat.replaceAccessibilityAction(r5, r10, null, createAccessibilityViewCommandForState(r11));
    }

    private void reset() {
        this.activePointerId = -1;
        this.initialY = -1;
        VelocityTracker r5 = this.velocityTracker;
        if (r5 == null) goto L6;
        r5.recycle();
        this.velocityTracker = null;
        return;
    }

    private void restoreOptionalState(@NonNull SavedState r5) {
        int r10 = this.saveFlags;
        if (r10 != 0) goto L6;
        return;
    L6:
        if (r10 != (-1)) goto L8;
    L9:
        this.peekHeight = r5.peekHeight;
    L10:
        if (r10 != (-1)) goto L12;
    L13:
        this.fitToContents = r5.fitToContents;
    L14:
        if (r10 != (-1)) goto L16;
    L17:
        this.hideable = r5.hideable;
    L18:
        if (r10 != (-1)) goto L20;
    L21:
        this.skipCollapsed = r5.skipCollapsed;
        return;
    L20:
        if ((r10 & 8) == 8) goto L21;
        return;
    L16:
        if ((r10 & 4) != 4) goto L18;
    L12:
        if ((r10 & 2) != 2) goto L14;
    L8:
        if ((r10 & 1) != 1) goto L10;
        goto L9
    }

    private void runAfterLayout(V r5, Runnable r10) {
        if (isLayouting(r5) == false) goto L5;
        r5.post(r10);
        return;
    L5:
        r10.run();
    }

    private void setWindowInsetsListener(@NonNull View r5) {
        if (isGestureInsetBottomIgnored() == false) goto L5;
    L7:
        final boolean r10 = false;
    L9:
        if (this.paddingBottomSystemWindowInsets == false) goto L11;
    L22:
        ViewUtils.doOnApplyWindowInsets(r5, new AnonymousClass4(this, r10));
        return;
    L11:
        if (this.paddingLeftSystemWindowInsets == true) goto L22;
        if (this.paddingRightSystemWindowInsets == true) goto L22;
        if (this.marginLeftSystemWindowInsets == true) goto L22;
        if (this.marginRightSystemWindowInsets == true) goto L22;
        if (this.marginTopSystemWindowInsets == true) goto L22;
        if (r10 == true) goto L22;
        return;
    L5:
        if (this.peekHeightAuto == true) goto L7;
        r10 = true;
        goto L9
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

    private void startSettling(View r5, int r10, boolean r11) {
        int r12 = getTopOffsetForState(r10);
        ViewDragHelper r13 = this.viewDragHelper;
        if (r13 == null) goto L11;
        if (r11 == false) goto L9;
        if (r13.settleCapturedViewAt(r5.getLeft(), r12) == false) goto L11;
    L10:
        setStateInternal(2);
        updateDrawableForTargetState(r10, true);
        this.stateSettlingTracker.continueSettlingToState(r10);
        return;
    L9:
        if (r13.smoothSlideViewTo(r5, r5.getLeft(), r12) == true) goto L10;
    L11:
        setStateInternal(r10);
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r5 = this.viewRef;
        if (r5 == null) goto L5;
        updateAccessibilityActions(r5.get(), 0);
    L5:
        WeakReference<View> r10 = this.accessibilityDelegateViewRef;
        if (r10 == null) goto L9;
        updateAccessibilityActions(r10.get(), 1);
        return;
    }

    private void updateDrawableForTargetState(int r5, boolean r10) {
        if (r5 != 2) goto L5;
        return;
    L5:
        boolean r11 = isExpandedAndShouldRemoveCorners();
        if (this.expandedCornersRemoved != r11) goto L8;
        return;
    L8:
        if (this.materialShapeDrawable == null) goto L34;
        this.expandedCornersRemoved = r11;
        float r12 = 1.0f;
        if (r10 == false) goto L21;
        ValueAnimator r13 = this.interpolatorAnimator;
        if (r13 == null) goto L21;
        if (r13.isRunning() == false) goto L17;
        this.interpolatorAnimator.reverse();
        return;
    L17:
        float r14 = this.materialShapeDrawable.getInterpolation();
        if (r11 == false) goto L20;
        r12 = calculateInterpolationWithCornersRemoved();
    L20:
        this.interpolatorAnimator.setFloatValues(new float[]{r14, r12});
        this.interpolatorAnimator.start();
        return;
    L21:
        ValueAnimator r15 = this.interpolatorAnimator;
        if (r15 != null) goto L24;
    L26:
        MaterialShapeDrawable r16 = this.materialShapeDrawable;
        if (this.expandedCornersRemoved == false) goto L29;
        r12 = calculateInterpolationWithCornersRemoved();
    L29:
        r16.setInterpolation(r12);
        return;
    L24:
        if (r15.isRunning() == false) goto L26;
        this.interpolatorAnimator.cancel();
        goto L26
    }

    private void updateImportantForAccessibility(boolean r10) {
        WeakReference<V> r5 = this.viewRef;
        if (r5 != null) goto L5;
        return;
    L5:
        ViewParent r11 = r5.get().getParent();
        if ((r11 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r12 = (CoordinatorLayout) r11;
        int r13 = r12.getChildCount();
        if (r10 == true) goto L11;
    L14:
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L31;
        View r15 = r12.getChildAt(r14);
        if (r15 == this.viewRef.get()) goto L30;
        if (r10 == false) goto L24;
        this.importantForAccessibilityMap.put(r15, Integer.valueOf(r15.getImportantForAccessibility()));
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        ViewCompat.setImportantForAccessibility(r15, 4);
        goto L30
    L24:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        Map<View, Integer> r16 = this.importantForAccessibilityMap;
        if (r16 == null) goto L30;
        if (r16.containsKey(r15) == false) goto L30;
        ViewCompat.setImportantForAccessibility(r15, this.importantForAccessibilityMap.get(r15).intValue());
    L30:
        r14 = r14 + 1;
        goto L15
    L31:
        if (r10 == true) goto L34;
        this.importantForAccessibilityMap = null;
        return;
    L34:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L46;
        this.viewRef.get().sendAccessibilityEvent(8);
        return;
    L46:
        return;
    L11:
        if (this.importantForAccessibilityMap != null) goto L13;
        this.importantForAccessibilityMap = new HashMap(r13);
        goto L14
    }

    private void updatePeekHeight(boolean r5) {
        if (this.viewRef == null) goto L12;
        calculateCollapsedOffset();
        if (this.state != 4) goto L13;
        V r10 = this.viewRef.get();
        if (r10 == null) goto L14;
        if (r5 == false) goto L10;
        setState(4);
        return;
    L10:
        r10.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback r5) {
        if (this.callbacks.contains(r5) == true) goto L6;
        this.callbacks.add(r5);
        return;
    }

    public float calculateSlideOffset() {
        WeakReference<V> r5 = this.viewRef;
        if (r5 != null) goto L5;
        return -1.0f;
    L5:
        if (r5.get() != null) goto L8;
        return -1.0f;
    L8:
        return calculateSlideOffsetWithTop(this.viewRef.get().getTop());
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        MaterialBottomContainerBackHelper r5 = this.bottomContainerBackHelper;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.cancelBackProgress();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int r5) {
        V r10 = this.viewRef.get();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L12;
        float r11 = calculateSlideOffsetWithTop(r5);
        int r12 = 0;
    L8:
        if (r12 >= this.callbacks.size()) goto L13;
        this.callbacks.get(r12).onSlide(r10, r11);
        r12 = r12 + 1;
        goto L8
    L13:
        return;
    }

    @Nullable
    @VisibleForTesting
    public View findScrollingChild(View r5) {
        if (r5.getVisibility() == 0) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r5) == false) goto L9;
        return r5;
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = r10.getChildCount();
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L16;
        View r13 = findScrollingChild(r10.getChildAt(r12));
        if (r13 != null) goto L14;
        r12 = r12 + 1;
        goto L11
    L14:
        return r13;
    L16:
        return null;
    }

    @Nullable
    @VisibleForTesting
    public MaterialBottomContainerBackHelper getBackHelper() {
        return this.bottomContainerBackHelper;
    }

    public int getExpandedOffset() {
        if (this.fitToContents == true) goto L11;
        int r5 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets == false) goto L8;
        int r10 = 0;
    L10:
        return Math.max(r5, r10);
    L8:
        r10 = this.insetTop;
        goto L10
    L11:
        return this.fitToContentsOffset;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public int getSignificantVelocityThreshold() {
        return this.significantVelocityThreshold;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        MaterialBottomContainerBackHelper r5 = this.bottomContainerBackHelper;
        if (r5 != null) goto L5;
        return;
    L5:
        BackEventCompat r10 = r5.onHandleBackInvoked();
        int r11 = 4;
        if (r10 == null) goto L16;
        if (Build.VERSION.SDK_INT < 34) goto L16;
        if (this.hideable == false) goto L13;
        this.bottomContainerBackHelper.finishBackProgressNotPersistent(r10, new AnonymousClass2(this));
        return;
    L13:
        this.bottomContainerBackHelper.finishBackProgressPersistent(r10, null);
        setState(4);
        return;
    L16:
        if (this.hideable == false) goto L18;
        r11 = 5;
    L18:
        setState(r11);
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isHideableWhenDragging() {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public boolean isShouldRemoveExpandedCorners() {
        return this.shouldRemoveExpandedCorners;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r5) {
        super.onAttachedToLayoutParams(r5);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L66:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L66;
        int r5 = r12.getActionMasked();
        if (r5 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r12);
        View r13 = null;
        if (r5 == 0) goto L23;
        if (r5 != 1) goto L17;
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
        if (r14.shouldInterceptTouchEvent(r12) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r15 = this.nestedScrollingChildRef;
        if (r15 == null) goto L50;
        r13 = r15.get();
    L50:
        if (r5 != 2) goto L68;
        if (r13 != null) goto L53;
        return false;
    L53:
        if (this.ignoreEvents == false) goto L55;
        return false;
    L55:
        if (this.state != 1) goto L57;
        return false;
    L57:
        if (r10.isPointInChildBounds(r13, (int) r12.getX(), (int) r12.getY()) == false) goto L59;
        return false;
    L59:
        if (this.viewDragHelper == null) goto L73;
        int r16 = this.initialY;
        if (r16 != (-1)) goto L63;
        return false;
    L63:
        if (Math.abs(r16 - r12.getY()) > this.viewDragHelper.getTouchSlop()) goto L65;
        return false;
    L65:
        return true;
    L73:
        return false;
    L68:
        return false;
    L17:
        if (r5 == 3) goto L19;
    L23:
        int r17 = (int) r12.getX();
        this.initialY = (int) r12.getY();
        if (this.state == 2) goto L34;
        WeakReference<View> r18 = this.nestedScrollingChildRef;
        if (r18 == null) goto L28;
        View r19 = r18.get();
    L29:
        if (r19 == null) goto L34;
        if (r10.isPointInChildBounds(r19, r17, this.initialY) == false) goto L34;
        this.activePointerId = r12.getPointerId(r12.getActionIndex());
        this.touchingScrollingChild = true;
        goto L34
    L28:
        r19 = null;
    L34:
        if (this.activePointerId == (-1)) goto L36;
    L38:
        boolean r110 = false;
    L39:
        this.ignoreEvents = r110;
        goto L41
    L36:
        if (r10.isPointInChildBounds(r11, r17, this.initialY) == true) goto L38;
        r110 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11) {
        if (ViewCompat.getFitsSystemWindows(r5) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L8;
        r10.setFitsSystemWindows(true);
    L8:
        if (this.viewRef != null) goto L22;
        this.peekHeightMin = r5.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        setWindowInsetsListener(r10);
        ViewCompat.setWindowInsetsAnimationCallback(r10, new InsetsAnimationCallback(r10));
        this.viewRef = new WeakReference(r10);
        this.bottomContainerBackHelper = new MaterialBottomContainerBackHelper(r10);
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
        updateAccessibilityActions();
        if (ViewCompat.getImportantForAccessibility(r10) != 0) goto L22;
        ViewCompat.setImportantForAccessibility(r10, 1);
        goto L22
    L15:
        ColorStateList r15 = this.backgroundTint;
        if (r15 == null) goto L18;
        ViewCompat.setBackgroundTintList(r10, r15);
    L22:
        if (this.viewDragHelper != null) goto L24;
        this.viewDragHelper = ViewDragHelper.create(r5, this.dragCallback);
    L24:
        int r16 = r10.getTop();
        r5.onLayoutChild(r10, r11);
        this.parentWidth = r5.getWidth();
        this.parentHeight = r5.getHeight();
        int r17 = r10.getHeight();
        this.childHeight = r17;
        int r18 = this.parentHeight;
        int r19 = r18 - r17;
        int r20 = this.insetTop;
        if (r19 < r20) goto L27;
    L38:
        int r21 = this.parentHeight - this.childHeight;
        int r22 = 0;
        this.fitToContentsOffset = Math.max(0, r21);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r23 = this.state;
        if (r23 != 3) goto L42;
        ViewCompat.offsetTopAndBottom(r10, getExpandedOffset());
    L56:
        updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r10));
    L58:
        if (r22 >= this.callbacks.size()) goto L60;
        this.callbacks.get(r22).onLayout(r10);
        r22 = r22 + 1;
        goto L58
    L60:
        return true;
    L42:
        if (r23 != 6) goto L45;
        ViewCompat.offsetTopAndBottom(r10, this.halfExpandedOffset);
        goto L56
    L45:
        if (this.hideable == false) goto L50;
        if (r23 != 5) goto L50;
        ViewCompat.offsetTopAndBottom(r10, this.parentHeight);
    L50:
        if (r23 != 4) goto L52;
        ViewCompat.offsetTopAndBottom(r10, this.collapsedOffset);
        goto L56
    L52:
        if (r23 != 1) goto L54;
    L55:
        ViewCompat.offsetTopAndBottom(r10, r16 - r10.getTop());
        goto L56
    L54:
        if (r23 != 2) goto L56;
    L27:
        if (this.paddingTopSystemWindowInsets == false) goto L33;
        int r24 = this.maxHeight;
        if (r24 == (-1)) goto L32;
        r18 = Math.min(r18, r24);
    L32:
        this.childHeight = r18;
        goto L38
    L33:
        int r25 = r18 - r20;
        int r26 = this.maxHeight;
        if (r26 == (-1)) goto L37;
        r25 = Math.min(r25, r26);
    L37:
        this.childHeight = r25;
        goto L38
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11, int r12, int r13, int r14) {
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r16 = r5.getPaddingLeft();
        int r17 = getChildMeasureSpec(r11, (((r5.getPaddingRight() + r16) + r15.leftMargin) + r15.rightMargin) + r12, this.maxWidth, r15.width);
        int r18 = r5.getPaddingTop();
        r10.measure(r17, getChildMeasureSpec(r13, (((r5.getPaddingBottom() + r18) + r15.topMargin) + r15.bottomMargin) + r14, this.maxHeight, r15.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, float r12, float r13) {
        if (isNestedScrollingCheckEnabled() == false) goto L14;
        WeakReference<View> r14 = this.nestedScrollingChildRef;
        if (r14 != null) goto L7;
        return false;
    L7:
        if (r11 == r14.get()) goto L9;
        return false;
    L9:
        if (this.state == 3) goto L11;
    L12:
        return true;
    L11:
        if (super.onNestedPreFling(r5, r10, r11, r12, r13) == true) goto L12;
        return false;
    L14:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, @NonNull int[] r14, int r15) {
        if (r15 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r16 = this.nestedScrollingChildRef;
        if (r16 == null) goto L8;
        View r17 = r16.get();
    L10:
        if (isNestedScrollingCheckEnabled() == false) goto L13;
        if (r11 == r17) goto L13;
        return;
    L13:
        int r18 = r10.getTop();
        int r19 = r18 - r13;
        if (r13 > 0) goto L16;
        if (r13 < 0) goto L24;
    L35:
        dispatchOnSlide(r10.getTop());
        this.lastNestedScrollDy = r13;
        this.nestedScrolled = true;
        return;
    L24:
        if (r11.canScrollVertically(-1) == true) goto L35;
        if (r19 <= this.collapsedOffset) goto L32;
        if (canBeHiddenByDragging() == true) goto L32;
        int r20 = r18 - this.collapsedOffset;
        r14[1] = r20;
        ViewCompat.offsetTopAndBottom(r10, -r20);
        setStateInternal(4);
    L32:
        if (this.draggable == true) goto L34;
        return;
    L34:
        r14[1] = r13;
        ViewCompat.offsetTopAndBottom(r10, -r13);
        setStateInternal(1);
        goto L35
    L16:
        if (r19 >= getExpandedOffset()) goto L19;
        int r21 = r18 - getExpandedOffset();
        r14[1] = r21;
        ViewCompat.offsetTopAndBottom(r10, -r21);
        setStateInternal(3);
        goto L35
    L19:
        if (this.draggable == true) goto L21;
        return;
    L21:
        r14[1] = r13;
        ViewCompat.offsetTopAndBottom(r10, -r13);
        setStateInternal(1);
        goto L35
    L8:
        r17 = null;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, int r14, int r15, int r16, @NonNull int[] r17) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull Parcelable r11) {
        SavedState r12 = (SavedState) r11;
        super.onRestoreInstanceState(r5, r10, r12.getSuperState());
        restoreOptionalState(r12);
        int r13 = r12.state;
        if (r13 != 1) goto L5;
    L8:
        this.state = 4;
        this.lastStableState = 4;
        return;
    L5:
        if (r13 == 2) goto L8;
        this.state = r13;
        this.lastStableState = r13;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r5, @NonNull V r10) {
        return new SavedState(super.onSaveInstanceState(r5, r10), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r13 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12) {
        int r13 = 3;
        if (r10.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (isNestedScrollingCheckEnabled() == false) goto L16;
        WeakReference<View> r14 = this.nestedScrollingChildRef;
        if (r14 != null) goto L11;
        return;
    L11:
        if (r11 == r14.get()) goto L13;
        return;
    L13:
        if (this.nestedScrolled == true) goto L16;
        return;
    L16:
        if (this.lastNestedScrollDy <= 0) goto L24;
        if (this.fitToContents == false) goto L21;
    L52:
        startSettling(r10, r13, false);
        this.nestedScrolled = false;
        return;
    L21:
        if (r10.getTop() <= this.halfExpandedOffset) goto L52;
    L51:
        r13 = 6;
        goto L52
    L24:
        if (this.hideable == false) goto L29;
        if (shouldHide(r10, getYVelocity()) == false) goto L29;
        r13 = 5;
    L29:
        if (this.lastNestedScrollDy != 0) goto L47;
        int r15 = r10.getTop();
        if (this.fitToContents == true) goto L33;
        int r16 = this.halfExpandedOffset;
        if (r15 >= r16) goto L44;
        if (r15 < Math.abs(r15 - this.collapsedOffset)) goto L52;
        if (shouldSkipHalfExpandedStateWhenDragging() == false) goto L51;
    L48:
        r13 = 4;
        goto L52
    L44:
        if (Math.abs(r15 - r16) >= Math.abs(r15 - this.collapsedOffset)) goto L48;
    L33:
        if (Math.abs(r15 - this.fitToContentsOffset) >= Math.abs(r15 - this.collapsedOffset)) goto L48;
    L47:
        if (this.fitToContents == true) goto L48;
        int r17 = r10.getTop();
        if (Math.abs(r17 - this.halfExpandedOffset) >= Math.abs(r17 - this.collapsedOffset)) goto L48;
        goto L48
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
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r11);
        if (shouldHandleDraggingWithHelper() == false) goto L28;
        if (r12 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (Math.abs(this.initialY - r11.getY()) <= this.viewDragHelper.getTouchSlop()) goto L28;
        this.viewDragHelper.captureChildView(r10, r11.getPointerId(r11.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback r5) {
        this.callbacks.remove(r5);
    }

    public void setAccessibilityDelegateView(@Nullable View r5) {
        if (r5 != null) goto L8;
        WeakReference<View> r10 = this.accessibilityDelegateViewRef;
        if (r10 == null) goto L8;
        clearAccessibilityAction(r10.get(), 1);
        this.accessibilityDelegateViewRef = null;
        return;
    L8:
        this.accessibilityDelegateViewRef = new WeakReference(r5);
        updateAccessibilityActions(r5, 1);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback r5) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r5 == null) goto L6;
        this.callbacks.add(r5);
        return;
    }

    public void setDraggable(boolean r5) {
        this.draggable = r5;
    }

    public void setExpandedOffset(int r5) {
        if (r5 < 0) goto L6;
        this.expandedOffset = r5;
        updateDrawableForTargetState(this.state, true);
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean r5) {
        if (this.fitToContents != r5) goto L5;
        return;
    L5:
        this.fitToContents = r5;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r10 = this.state;
    L14:
        setStateInternal(r10);
        updateDrawableForTargetState(this.state, true);
        updateAccessibilityActions();
        return;
    L11:
        if (this.state != 6) goto L13;
        r10 = 3;
        goto L14
    }

    public void setGestureInsetBottomIgnored(boolean r5) {
        this.gestureInsetBottomIgnored = r5;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float r5) {
        if (r5 <= 0.0f) goto L11;
        if (r5 >= 1.0f) goto L11;
        this.halfExpandedRatio = r5;
        if (this.viewRef == null) goto L12;
        calculateHalfExpandedOffset();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideFriction(float r5) {
        this.hideFriction = r5;
    }

    public void setHideable(boolean r5) {
        if (this.hideable == r5) goto L11;
        this.hideable = r5;
        if (r5 == false) goto L7;
    L9:
        updateAccessibilityActions();
        return;
    L7:
        if (this.state != 5) goto L9;
        setState(4);
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean r5) {
        this.hideable = r5;
    }

    public void setMaxHeight(@Px int r5) {
        this.maxHeight = r5;
    }

    public void setMaxWidth(@Px int r5) {
        this.maxWidth = r5;
    }

    public void setPeekHeight(int r5) {
        setPeekHeight(r5, false);
    }

    public void setSaveFlags(int r5) {
        this.saveFlags = r5;
    }

    public void setShouldRemoveExpandedCorners(boolean r5) {
        if (this.shouldRemoveExpandedCorners == r5) goto L6;
        this.shouldRemoveExpandedCorners = r5;
        updateDrawableForTargetState(getState(), true);
        return;
    }

    public void setSignificantVelocityThreshold(int r5) {
        this.significantVelocityThreshold = r5;
    }

    public void setSkipCollapsed(boolean r5) {
        this.skipCollapsed = r5;
    }

    public void setState(int r5) {
        if (r5 != 1) goto L5;
    L29:
        StringBuilder r10 = new StringBuilder("STATE_");
        if (r5 != 1) goto L32;
        String r11 = "DRAGGING";
    L34:
        throw new IllegalArgumentException(j0.q(r10, r11, " should not be set externally."));
    L32:
        r11 = "SETTLING";
        goto L34
    L5:
        if (r5 == 2) goto L29;
        if (this.hideable == true) goto L14;
        if (r5 != 5) goto L14;
        Log.w(TAG, "Cannot set state: " + r5);
        return;
    L14:
        if (r5 == 6) goto L16;
    L20:
        final int r12 = r5;
    L21:
        WeakReference<V> r13 = this.viewRef;
        if (r13 != null) goto L24;
    L27:
        setStateInternal(r5);
        return;
    L24:
        if (r13.get() == null) goto L27;
        final V r14 = this.viewRef.get();
        runAfterLayout(r14, new AnonymousClass1(this, r14, r12));
        return;
    L16:
        if (this.fitToContents == false) goto L20;
        if (getTopOffsetForState(r5) > this.fitToContentsOffset) goto L20;
        r12 = 3;
        goto L21
    }

    public void setStateInternal(int r10) {
        if (this.state != r10) goto L5;
        return;
    L5:
        this.state = r10;
        if (r10 == 4) goto L12;
        if (r10 == 3) goto L12;
        if (r10 == 6) goto L12;
        if (this.hideable == false) goto L13;
        if (r10 == 5) goto L12;
    L13:
        WeakReference<V> r5 = this.viewRef;
        if (r5 != null) goto L16;
        return;
    L16:
        V r11 = r5.get();
        if (r11 != null) goto L19;
        return;
    L19:
        int r12 = 0;
        if (r10 != 3) goto L22;
        updateImportantForAccessibility(true);
    L26:
        updateDrawableForTargetState(r10, true);
    L28:
        if (r12 >= this.callbacks.size()) goto L30;
        this.callbacks.get(r12).onStateChanged(r11, r10);
        r12 = r12 + 1;
        goto L28
    L30:
        updateAccessibilityActions();
        return;
    L22:
        if (r10 == 6) goto L25;
        if (r10 == 5) goto L25;
        if (r10 != 4) goto L26;
    L25:
        updateImportantForAccessibility(false);
    L12:
        this.lastStableState = r10;
        goto L13
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r5) {
        this.updateImportantForAccessibilityOnSiblings = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long r5, @FloatRange(from = 0.0d, to = 100.0d) float r10) {
        return false;
    }

    public boolean shouldHide(@NonNull View r5, float r10) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (isHideableWhenDragging() == true) goto L9;
        return false;
    L9:
        if (r5.getTop() >= this.collapsedOffset) goto L12;
        return false;
    L12:
        if ((Math.abs(((r10 * this.hideFriction) + r5.getTop()) - this.collapsedOffset) / calculatePeekHeight()) <= 0.5f) goto L15;
        return true;
    L15:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(@NonNull BackEventCompat r5) {
        MaterialBottomContainerBackHelper r10 = this.bottomContainerBackHelper;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.startBackProgress(r5);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(@NonNull BackEventCompat r5) {
        MaterialBottomContainerBackHelper r10 = this.bottomContainerBackHelper;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.updateBackProgress(r5);
    }

    public final void setPeekHeight(int r5, boolean r10) {
        if (r5 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L14;
        this.peekHeightAuto = true;
    L12:
        updatePeekHeight(r10);
        return;
    L14:
        return;
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L11:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r5);
        goto L12
    L10:
        if (this.peekHeight != r5) goto L11;
    }

    private void updateAccessibilityActions(View r5, int r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        clearAccessibilityAction(r5, r10);
        int r11 = 6;
        if (this.fitToContents == true) goto L10;
        if (this.state == 6) goto L10;
        this.expandHalfwayActionIds.put(r10, addAccessibilityActionForState(r5, R.string.bottomsheet_action_expand_halfway, 6));
    L10:
        if (this.hideable == true) goto L12;
    L16:
        int r12 = this.state;
        if (r12 == 3) goto L27;
        if (r12 == 4) goto L23;
        if (r12 != 6) goto L33;
        replaceAccessibilityActionForState(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        replaceAccessibilityActionForState(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    L33:
        return;
    L23:
        if (this.fitToContents == false) goto L25;
        r11 = 3;
    L25:
        replaceAccessibilityActionForState(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, r11);
        return;
    L27:
        if (this.fitToContents == false) goto L29;
        r11 = 4;
    L29:
        replaceAccessibilityActionForState(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, r11);
        return;
    L12:
        if (isHideableWhenDragging() == false) goto L16;
        if (this.state == 5) goto L16;
        replaceAccessibilityActionForState(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        goto L16
    }

    public BottomSheetBehavior(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new AnonymousClass5(this);
        this.peekHeightGestureInsetBuffer = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray r5 = r10.obtainStyledAttributes(r11, R.styleable.BottomSheetBehavior_Layout);
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint) == false) goto L6;
        this.backgroundTint = MaterialResources.getColorStateList(r10, r5, R.styleable.BottomSheetBehavior_Layout_backgroundTint);
    L6:
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance) == false) goto L8;
        this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(r10, r11, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
    L8:
        createMaterialShapeDrawableIfNeeded(r10);
        createShapeValueAnimator();
        this.elevation = r5.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxWidth) == false) goto L12;
        setMaxWidth(r5.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
    L12:
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxHeight) == false) goto L14;
        setMaxHeight(r5.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, -1));
    L14:
        TypedValue r12 = r5.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (r12 == null) goto L19;
        int r13 = r12.data;
        if (r13 != (-1)) goto L19;
        setPeekHeight(r13);
    L20:
        setHideable(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(r5.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(r5.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue r14 = r5.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (r14 != null) goto L23;
    L25:
        setExpandedOffset(r5.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
    L26:
        setSignificantVelocityThreshold(r5.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.paddingBottomSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        r5.recycle();
        this.maximumVelocity = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L23:
        if (r14.type != 16) goto L25;
        setExpandedOffset(r14.data);
    L19:
        setPeekHeight(r5.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        goto L20
    }
}
