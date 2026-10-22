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

/* JADX INFO: loaded from: classes.dex */
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
    a listener;
    private float sensitivity;
    private boolean sensitivitySet;
    int swipeDirection;
    ViewDragHelper viewDragHelper;

    public interface a {
        void a(View r10);

        void b(int r10);
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f3017c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f3018g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ SwipeDismissBehavior f3019h;

        b(SwipeDismissBehavior r10, View r11, boolean r12) {
            this.f3019h = r10;
            this.f3017c = r11;
            this.f3018g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper r10 = this.f3019h.viewDragHelper;
            if (r10 == null) goto L8;
            if (r10.continueSettling(true) == false) goto L8;
            ViewCompat.postOnAnimation(this.f3017c, this);
            return;
        L8:
            if (this.f3018g == false) goto L14;
            a r11 = this.f3019h.listener;
            if (r11 == null) goto L15;
            r11.a(this.f3017c);
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

    static float clamp(float r10, float r11, float r12) {
        return Math.min(Math.max(r10, r11), r12);
    }

    static int clamp(int r10, int r11, int r12) {
        return Math.min(Math.max(r10, r11), r12);
    }

    private void ensureViewDragHelper(ViewGroup r10) {
        if (this.viewDragHelper == null) goto L5;
        return;
    L5:
        if (this.sensitivitySet == false) goto L7;
        ViewDragHelper r11 = ViewDragHelper.create(r10, this.sensitivity, this.dragCallback);
    L8:
        this.viewDragHelper = r11;
        return;
    L7:
        r11 = ViewDragHelper.create(r10, this.dragCallback);
        goto L8
    }

    static float fraction(float r10, float r11, float r12) {
        return (r12 - r10) / (r11 - r10);
    }

    private void updateAccessibilityActions(View r10) {
        ViewCompat.removeAccessibilityAction(r10, 1048576);
        if (canSwipeDismissView(r10) == false) goto L6;
        ViewCompat.replaceAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AnonymousClass2(this));
        return;
    }

    public boolean canSwipeDismissView(@NonNull View r10) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper r10 = this.viewDragHelper;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getViewDragState();
    }

    @Nullable
    @VisibleForTesting
    public a getListener() {
        return this.listener;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        boolean r13 = this.interceptingEvents;
        int r14 = r12.getActionMasked();
        if (r14 != 0) goto L5;
        r13 = r10.isPointInChildBounds(r11, (int) r12.getX(), (int) r12.getY());
        this.interceptingEvents = r13;
    L11:
        if (r13 == false) goto L14;
        ensureViewDragHelper(r10);
        return this.viewDragHelper.shouldInterceptTouchEvent(r12);
    L14:
        return false;
    L5:
        if (r14 != 1) goto L7;
    L9:
        this.interceptingEvents = false;
        goto L11
    L7:
        if (r14 == 3) goto L9;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        boolean r13 = super.onLayoutChild(r10, r11, r12);
        if (ViewCompat.getImportantForAccessibility(r11) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(r11, 1);
        updateAccessibilityActions(r11);
    L5:
        return r13;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        ViewDragHelper r13 = this.viewDragHelper;
        if (r13 == null) goto L6;
        r13.processTouchEvent(r12);
        return true;
    L6:
        return false;
    }

    public void setDragDismissDistance(float r10) {
        this.dragDismissThreshold = clamp(0.0f, r10, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float r10) {
        this.alphaEndSwipeDistance = clamp(0.0f, r10, 1.0f);
    }

    public void setListener(@Nullable a r10) {
        this.listener = r10;
    }

    public void setSensitivity(float r10) {
        this.sensitivity = r10;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float r10) {
        this.alphaStartSwipeDistance = clamp(0.0f, r10, 1.0f);
    }

    public void setSwipeDirection(int r10) {
        this.swipeDirection = r10;
    }
}
