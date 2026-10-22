package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance;
    float alphaStartSwipeDistance;
    private final ViewDragHelper.Callback dragCallback;
    float dragDismissThreshold;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private boolean requestingDisallowInterceptTouchEvent;
    private float sensitivity;
    private boolean sensitivitySet;
    int swipeDirection;
    ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View r5);

        void onDragStateChanged(int r5);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        final /* synthetic */ SwipeDismissBehavior this$0;
        private final View view;

        public SettleRunnable(SwipeDismissBehavior r5, View r10, boolean r11) {
            this.this$0 = r5;
            this.view = r10;
            this.dismiss = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper r5 = this.this$0.viewDragHelper;
            if (r5 == null) goto L8;
            if (r5.continueSettling(true) == false) goto L8;
            ViewCompat.postOnAnimation(this.view, this);
            return;
        L8:
            if (this.dismiss == false) goto L14;
            OnDismissListener r10 = this.this$0.listener;
            if (r10 == null) goto L15;
            r10.onDismiss(this.view);
            return;
        L15:
            return;
        }
    }

    public SwipeDismissBehavior() {
        this.sensitivity = 0.0f;
        this.swipeDirection = 2;
        this.dragDismissThreshold = 0.5f;
        this.alphaStartSwipeDistance = 0.0f;
        this.alphaEndSwipeDistance = 0.5f;
        this.dragCallback = new AnonymousClass1(this);
    }

    public static /* synthetic */ boolean access$002(SwipeDismissBehavior r5, boolean r10) {
        r5.requestingDisallowInterceptTouchEvent = r10;
        return r10;
    }

    public static float clamp(float r5, float r10, float r11) {
        return Math.min(Math.max(r5, r10), r11);
    }

    private void ensureViewDragHelper(ViewGroup r5) {
        if (this.viewDragHelper == null) goto L5;
        return;
    L5:
        if (this.sensitivitySet == false) goto L7;
        ViewDragHelper r10 = ViewDragHelper.create(r5, this.sensitivity, this.dragCallback);
    L8:
        this.viewDragHelper = r10;
        return;
    L7:
        r10 = ViewDragHelper.create(r5, this.dragCallback);
        goto L8
    }

    public static float fraction(float r5, float r10, float r11) {
        return (r11 - r5) / (r10 - r5);
    }

    private void updateAccessibilityActions(View r5) {
        ViewCompat.removeAccessibilityAction(r5, 1048576);
        if (canSwipeDismissView(r5) == false) goto L6;
        ViewCompat.replaceAccessibilityAction(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AnonymousClass2(this));
        return;
    }

    public boolean canSwipeDismissView(@NonNull View r5) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper r5 = this.viewDragHelper;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getViewDragState();
    }

    @Nullable
    @VisibleForTesting
    public OnDismissListener getListener() {
        return this.listener;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull MotionEvent r11) {
        boolean r12 = this.interceptingEvents;
        int r13 = r11.getActionMasked();
        if (r13 == 0) goto L9;
        if (r13 != 1) goto L6;
    L8:
        this.interceptingEvents = false;
    L10:
        if (r12 == false) goto L18;
        ensureViewDragHelper(r5);
        if (this.requestingDisallowInterceptTouchEvent == true) goto L17;
        if (this.viewDragHelper.shouldInterceptTouchEvent(r11) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    L6:
        if (r13 == 3) goto L8;
    L9:
        r12 = r5.isPointInChildBounds(r10, (int) r11.getX(), (int) r11.getY());
        this.interceptingEvents = r12;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11) {
        boolean r12 = super.onLayoutChild(r5, r10, r11);
        if (ViewCompat.getImportantForAccessibility(r10) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(r10, 1);
        updateAccessibilityActions(r10);
    L5:
        return r12;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r5, V r10, MotionEvent r11) {
        if (this.viewDragHelper != null) goto L5;
        return false;
    L5:
        if (this.requestingDisallowInterceptTouchEvent == true) goto L7;
    L8:
        this.viewDragHelper.processTouchEvent(r11);
        return true;
    L7:
        if (r11.getActionMasked() != 3) goto L8;
        return true;
    }

    public void setDragDismissDistance(float r5) {
        this.dragDismissThreshold = clamp(0.0f, r5, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float r5) {
        this.alphaEndSwipeDistance = clamp(0.0f, r5, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener r5) {
        this.listener = r5;
    }

    public void setSensitivity(float r5) {
        this.sensitivity = r5;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float r5) {
        this.alphaStartSwipeDistance = clamp(0.0f, r5, 1.0f);
    }

    public void setSwipeDirection(int r5) {
        this.swipeDirection = r5;
    }

    public static int clamp(int r5, int r10, int r11) {
        return Math.min(Math.max(r5, r10), r11);
    }
}
