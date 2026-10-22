package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.a;
import com.google.android.material.R;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    private static final int DEF_STYLE_RES = 0;

    @Nullable
    private final AccessibilityManager accessibilityManager;
    private boolean accessibilityServiceEnabled;

    @Nullable
    private BottomSheetBehavior<?> bottomSheetBehavior;
    private final BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private final String clickFeedback;
    private final String clickToCollapseActionLabel;
    private boolean clickToExpand;
    private final String clickToExpandActionLabel;
    private boolean interactable;

    static {
        DEF_STYLE_RES = R.style.Widget_Material3_BottomSheet_DragHandle;
    }

    public BottomSheetDragHandleView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ boolean a(BottomSheetDragHandleView r5, View r10, AccessibilityViewCommand.CommandArguments r11) {
        return r5.lambda$onBottomSheetStateChanged$0(r10, r11);
    }

    public static /* synthetic */ void access$000(BottomSheetDragHandleView r5, int r10) {
        r5.onBottomSheetStateChanged(r10);
    }

    public static /* synthetic */ boolean access$100(BottomSheetDragHandleView r5) {
        return r5.expandOrCollapseBottomSheetIfPossible();
    }

    private void announceAccessibilityEvent(String r5) {
        if (this.accessibilityManager != null) goto L5;
        return;
    L5:
        AccessibilityEvent r10 = AccessibilityEvent.obtain(16384);
        r10.getText().add(r5);
        this.accessibilityManager.sendAccessibilityEvent(r10);
    }

    private boolean expandOrCollapseBottomSheetIfPossible() {
        boolean r5 = false;
        if (this.interactable == true) goto L5;
        return false;
    L5:
        announceAccessibilityEvent(this.clickFeedback);
        if (this.bottomSheetBehavior.isFitToContents() == false) goto L8;
    L10:
        int r10 = this.bottomSheetBehavior.getState();
        int r11 = 6;
        int r12 = 3;
        if (r10 != 4) goto L14;
        if (r5 == true) goto L23;
    L22:
        r11 = r12;
    L23:
        this.bottomSheetBehavior.setState(r11);
        return true;
    L14:
        if (r10 != 3) goto L19;
        if (r5 == true) goto L23;
        r11 = 4;
        goto L23
    L19:
        if (this.clickToExpand == true) goto L22;
        r12 = 4;
        goto L22
    L8:
        if (this.bottomSheetBehavior.shouldSkipHalfExpandedStateWhenDragging() == true) goto L10;
        r5 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.material.bottomsheet.BottomSheetDragHandleView] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    @Nullable
    private BottomSheetBehavior<?> findParentBottomSheetBehavior() {
    L2:
        BottomSheetDragHandleView this = getParentView(this);
        if (this == 0) goto L10;
        ViewGroup.LayoutParams r5 = this.getLayoutParams();
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L2;
        CoordinatorLayout.Behavior r10 = ((CoordinatorLayout.LayoutParams) r5).getBehavior();
        if ((r10 instanceof BottomSheetBehavior) == false) goto L2;
        return (BottomSheetBehavior) r10;
    L10:
        return null;
    }

    @Nullable
    private static View getParentView(View r5) {
        Object r10 = r5.getParent();
        if ((r10 instanceof View) == true) goto L7;
        return null;
    L7:
        return (View) r10;
    }

    private /* synthetic */ boolean lambda$onBottomSheetStateChanged$0(View r5, AccessibilityViewCommand.CommandArguments r10) {
        return expandOrCollapseBottomSheetIfPossible();
    }

    private void onBottomSheetStateChanged(int r5) {
        if (r5 != 4) goto L6;
        this.clickToExpand = true;
    L8:
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r10 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK;
        if (this.clickToExpand == false) goto L11;
        String r11 = this.clickToExpandActionLabel;
    L12:
        ViewCompat.replaceAccessibilityAction(this, r10, r11, new a(this, 3));
        return;
    L11:
        r11 = this.clickToCollapseActionLabel;
        goto L12
    L6:
        if (r5 != 3) goto L8;
        this.clickToExpand = false;
        goto L8
    }

    private void setBottomSheetBehavior(@Nullable BottomSheetBehavior<?> r5) {
        BottomSheetBehavior<?> r10 = this.bottomSheetBehavior;
        if (r10 == null) goto L5;
        r10.removeBottomSheetCallback(this.bottomSheetCallback);
        this.bottomSheetBehavior.setAccessibilityDelegateView(null);
    L5:
        this.bottomSheetBehavior = r5;
        if (r5 == null) goto L8;
        r5.setAccessibilityDelegateView(this);
        onBottomSheetStateChanged(this.bottomSheetBehavior.getState());
        this.bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
    L8:
        updateInteractableState();
    }

    private void updateInteractableState() {
        int r5 = 1;
        if (this.accessibilityServiceEnabled == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.interactable = r10;
        if (this.bottomSheetBehavior != null) goto L12;
        r5 = 2;
    L12:
        ViewCompat.setImportantForAccessibility(this, r5);
        setClickable(this.interactable);
        return;
    L5:
        if (this.bottomSheetBehavior == null) goto L7;
        r10 = true;
        goto L8
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean r5) {
        this.accessibilityServiceEnabled = r5;
        updateInteractableState();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(findParentBottomSheetBehavior());
        AccessibilityManager r5 = this.accessibilityManager;
        if (r5 == null) goto L6;
        r5.addAccessibilityStateChangeListener(this);
        onAccessibilityStateChanged(this.accessibilityManager.isEnabled());
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        AccessibilityManager r5 = this.accessibilityManager;
        if (r5 == null) goto L5;
        r5.removeAccessibilityStateChangeListener(this);
    L5:
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    public BottomSheetDragHandleView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(MaterialThemeOverlay.wrap(r5, r10, r11, DEF_STYLE_RES), r10, r11);
        this.clickToExpandActionLabel = getResources().getString(R.string.bottomsheet_action_expand);
        this.clickToCollapseActionLabel = getResources().getString(R.string.bottomsheet_action_collapse);
        this.clickFeedback = getResources().getString(R.string.bottomsheet_drag_handle_clicked);
        this.bottomSheetCallback = new AnonymousClass1(this);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        updateInteractableState();
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass2(this));
    }
}
