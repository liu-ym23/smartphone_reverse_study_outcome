package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = null;
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = null;
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = null;
    int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        final /* synthetic */ ExploreByTouchHelper this$0;

        MyNodeProvider(ExploreByTouchHelper r10) {
            this.this$0 = r10;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r10) {
            return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(r10));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int r10) {
            if (r10 != 2) goto L5;
            int r11 = this.this$0.mAccessibilityFocusedVirtualViewId;
        L7:
            if (r11 != Integer.MIN_VALUE) goto L11;
            return null;
        L11:
            return createAccessibilityNodeInfo(r11);
        L5:
            r11 = this.this$0.mKeyboardFocusedVirtualViewId;
            goto L7
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int r10, int r11, Bundle r12) {
            return this.this$0.performAction(r10, r11, r12);
        }
    }

    static {
        INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        NODE_ADAPTER = new AnonymousClass1();
        SPARSE_VALUES_ADAPTER = new AnonymousClass2();
    }

    public ExploreByTouchHelper(@NonNull View r10) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (r10 == null) goto L9;
        this.mHost = r10;
        this.mManager = (AccessibilityManager) r10.getContext().getSystemService("accessibility");
        r10.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(r10) != 0) goto L10;
        ViewCompat.setImportantForAccessibility(r10, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int r10) {
        if (this.mAccessibilityFocusedVirtualViewId != r10) goto L6;
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(r10, 65536);
        return true;
    L6:
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int r10 = this.mKeyboardFocusedVirtualViewId;
        if (r10 != Integer.MIN_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (onPerformActionForVirtualView(r10, 16, null) == false) goto L7;
        return true;
    }

    private AccessibilityEvent createEvent(int r10, int r11) {
        if (r10 == (-1)) goto L7;
        return createEventForChild(r10, r11);
    L7:
        return createEventForHost(r11);
    }

    private AccessibilityEvent createEventForChild(int r10, int r11) {
        AccessibilityEvent r12 = AccessibilityEvent.obtain(r11);
        AccessibilityNodeInfoCompat r13 = obtainAccessibilityNodeInfo(r10);
        r12.getText().add(r13.getText());
        r12.setContentDescription(r13.getContentDescription());
        r12.setScrollable(r13.isScrollable());
        r12.setPassword(r13.isPassword());
        r12.setEnabled(r13.isEnabled());
        r12.setChecked(r13.isChecked());
        onPopulateEventForVirtualView(r10, r12);
        if (r12.getText().isEmpty() == true) goto L5;
    L9:
        r12.setClassName(r13.getClassName());
        AccessibilityRecordCompat.setSource(r12, this.mHost, r10);
        r12.setPackageName(this.mHost.getContext().getPackageName());
        return r12;
    L5:
        if (r12.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent createEventForHost(int r10) {
        AccessibilityEvent r11 = AccessibilityEvent.obtain(r10);
        this.mHost.onInitializeAccessibilityEvent(r11);
        return r11;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int r10) {
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.obtain();
        r11.setEnabled(true);
        r11.setFocusable(true);
        r11.setClassName(DEFAULT_CLASS_NAME);
        Rect r12 = INVALID_PARENT_BOUNDS;
        r11.setBoundsInParent(r12);
        r11.setBoundsInScreen(r12);
        r11.setParent(this.mHost);
        onPopulateNodeForVirtualView(r10, r11);
        if (r11.getText() == null) goto L5;
    L9:
        r11.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(r12) == true) goto L50;
        int r13 = r11.getActions();
        if ((r13 & 64) != 0) goto L48;
        if ((r13 & 128) != 0) goto L46;
        r11.setPackageName(this.mHost.getContext().getPackageName());
        r11.setSource(this.mHost, r10);
        if (this.mAccessibilityFocusedVirtualViewId != r10) goto L18;
        r11.setAccessibilityFocused(true);
        r11.addAction(128);
    L20:
        if (this.mKeyboardFocusedVirtualViewId != r10) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        r11.addAction(2);
    L28:
        r11.setFocused(r14);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        r11.getBoundsInScreen(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(r12) == false) goto L38;
        r11.getBoundsInParent(this.mTempScreenRect);
        if (r11.mParentVirtualDescendantId == (-1)) goto L36;
        AccessibilityNodeInfoCompat r15 = AccessibilityNodeInfoCompat.obtain();
        int r16 = r11.mParentVirtualDescendantId;
    L33:
        if (r16 == (-1)) goto L35;
        r15.setParent(this.mHost, -1);
        r15.setBoundsInParent(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(r16, r15);
        r15.getBoundsInParent(this.mTempParentRect);
        Rect r17 = this.mTempScreenRect;
        Rect r18 = this.mTempParentRect;
        r17.offset(r18.left, r18.top);
        r16 = r15.mParentVirtualDescendantId;
        goto L33
    L35:
        r15.recycle();
    L36:
        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    L38:
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect) == false) goto L44;
        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        if (this.mTempScreenRect.intersect(this.mTempVisibleRect) == false) goto L44;
        r11.setBoundsInScreen(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect) == false) goto L44;
        r11.setVisibleToUser(true);
    L44:
        return r11;
    L26:
        if (r11.isFocusable() == false) goto L28;
        r11.addAction(1);
        goto L28
    L22:
        r14 = false;
        goto L23
    L18:
        r11.setAccessibilityFocused(false);
        r11.addAction(64);
        goto L20
    L46:
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L48:
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L50:
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    L5:
        if (r11.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, r10);
        ArrayList r11 = new ArrayList();
        getVisibleVirtualViews(r11);
        if (r10.getChildCount() > 0) goto L5;
    L9:
        int r12 = 0;
        int r13 = r11.size();
    L10:
        if (r12 >= r13) goto L12;
        r10.addChild(this.mHost, ((Integer) r11.get(r12)).intValue());
        r12 = r12 + 1;
        goto L10
    L12:
        return r10;
    L5:
        if (r11.size() <= 0) goto L9;
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList r10 = new ArrayList();
        getVisibleVirtualViews(r10);
        SparseArrayCompat<AccessibilityNodeInfoCompat> r11 = new SparseArrayCompat();
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        AccessibilityNodeInfoCompat r13 = createNodeForChild(r10.get(r12).intValue());
        r11.put(r10.get(r12).intValue(), r13);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    private void getBoundsInParent(int r10, Rect r11) {
        obtainAccessibilityNodeInfo(r10).getBoundsInParent(r11);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View r10, int r11, @NonNull Rect r12) {
        int r13 = r10.getWidth();
        int r14 = r10.getHeight();
        if (r11 != 17) goto L5;
        r12.set(r13, 0, r13, r14);
    L16:
        return r12;
    L5:
        if (r11 != 33) goto L7;
        r12.set(0, r14, r13, r14);
        goto L16
    L7:
        if (r11 != 66) goto L9;
        r12.set(-1, 0, -1, r14);
        goto L16
    L9:
        if (r11 != 130) goto L12;
        r12.set(0, -1, r13, -1);
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private boolean isVisibleToUser(Rect r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isEmpty() == false) goto L8;
        return false;
    L8:
        if (this.mHost.getWindowVisibility() == 0) goto L10;
        return false;
    L10:
        View r11 = this.mHost;
    L11:
        Object r12 = r11.getParent();
        if ((r12 instanceof View) == false) goto L18;
        r11 = (View) r12;
        if (r11.getAlpha() <= 0.0f) goto L17;
        if (r11.getVisibility() == 0) goto L11;
    L17:
        return false;
    L18:
        if (r12 == null) goto L26;
        return true;
    L26:
        return false;
    }

    private static int keyToDirection(int r10) {
        if (r10 != 19) goto L5;
        return 33;
    L5:
        if (r10 != 21) goto L7;
        return 17;
    L7:
        if (r10 == 22) goto L10;
        return 130;
    L10:
        return 66;
    }

    private boolean moveFocus(int r10, @Nullable Rect r11) {
        SparseArrayCompat<AccessibilityNodeInfoCompat> r12 = getAllNodes();
        int r13 = this.mKeyboardFocusedVirtualViewId;
        int r14 = Integer.MIN_VALUE;
        if (r13 != Integer.MIN_VALUE) goto L5;
        AccessibilityNodeInfoCompat r15 = null;
    L6:
        AccessibilityNodeInfoCompat r16 = r15;
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L29;
        if (r10 != 17) goto L13;
    L21:
        Rect r17 = new Rect();
        int r18 = this.mKeyboardFocusedVirtualViewId;
        if (r18 == Integer.MIN_VALUE) goto L24;
        getBoundsInParent(r18, r17);
    L27:
        Object r19 = FocusStrategy.findNextFocusInAbsoluteDirection(r12, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r16, r17, r10);
    L33:
        AccessibilityNodeInfoCompat r110 = (AccessibilityNodeInfoCompat) r19;
        if (r110 == null) goto L38;
        r14 = r12.keyAt(r12.indexOfValue(r110));
    L38:
        return requestKeyboardFocusForVirtualView(r14);
    L24:
        if (r11 == null) goto L26;
        r17.set(r11);
        goto L27
    L26:
        guessPreviouslyFocusedRect(this.mHost, r10, r17);
        goto L27
    L13:
        if (r10 == 33) goto L21;
        if (r10 == 66) goto L21;
        if (r10 == 130) goto L21;
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L29:
        if (ViewCompat.getLayoutDirection(this.mHost) != 1) goto L31;
        boolean r20 = true;
    L32:
        r19 = FocusStrategy.findNextFocusInRelativeDirection(r12, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r16, r10, r20, false);
        goto L33
    L31:
        r20 = false;
        goto L32
    L5:
        r15 = r12.get(r13);
        goto L6
    }

    private boolean performActionForChild(int r10, int r11, Bundle r12) {
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L17;
        if (r11 == 64) goto L15;
        if (r11 == 128) goto L13;
        return onPerformActionForVirtualView(r10, r11, r12);
    L13:
        return clearAccessibilityFocus(r10);
    L15:
        return requestAccessibilityFocus(r10);
    L17:
        return clearKeyboardFocusForVirtualView(r10);
    L19:
        return requestKeyboardFocusForVirtualView(r10);
    }

    private boolean performActionForHost(int r10, Bundle r11) {
        return ViewCompat.performAccessibilityAction(this.mHost, r10, r11);
    }

    private boolean requestAccessibilityFocus(int r10) {
        if (this.mManager.isEnabled() == true) goto L5;
    L14:
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L14;
        int r11 = this.mAccessibilityFocusedVirtualViewId;
        if (r11 == r10) goto L14;
        if (r11 == Integer.MIN_VALUE) goto L12;
        clearAccessibilityFocus(r11);
    L12:
        this.mAccessibilityFocusedVirtualViewId = r10;
        this.mHost.invalidate();
        sendEventForVirtualView(r10, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int r10) {
        int r11 = this.mHoveredVirtualViewId;
        if (r11 != r10) goto L5;
        return;
    L5:
        this.mHoveredVirtualViewId = r10;
        sendEventForVirtualView(r10, 128);
        sendEventForVirtualView(r11, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int r10) {
        if (this.mKeyboardFocusedVirtualViewId == r10) goto L5;
        return false;
    L5:
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(r10, false);
        sendEventForVirtualView(r10, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent r10) {
        if (this.mManager.isEnabled() == true) goto L5;
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L25;
        int r11 = r10.getAction();
        if (r11 != 7) goto L10;
    L19:
        int r12 = getVirtualViewAt(r10.getX(), r10.getY());
        updateHoveredVirtualView(r12);
        if (r12 != Integer.MIN_VALUE) goto L22;
        return false;
    L22:
        return true;
    L10:
        if (r11 == 9) goto L19;
        if (r11 == 10) goto L15;
        return false;
    L15:
        if (this.mHoveredVirtualViewId == Integer.MIN_VALUE) goto L18;
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    L18:
        return false;
    L25:
        return false;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent r10) {
        int r11 = 0;
        if (r10.getAction() == 1) goto L32;
        int r12 = r10.getKeyCode();
        if (r12 == 61) goto L24;
        if (r12 == 66) goto L19;
        switch(r12) {
            case 19: goto L11;
            case 20: goto L11;
            case 21: goto L11;
            case 22: goto L11;
            case 23: goto L19;
            default: goto L40;
        };
    L40:
        return false;
    L11:
        if (r10.hasNoModifiers() == false) goto L33;
        int r13 = keyToDirection(r12);
        int r14 = r10.getRepeatCount() + 1;
        boolean r15 = false;
    L13:
        if (r11 >= r14) goto L34;
        if (moveFocus(r13, null) == false) goto L34;
        r11 = r11 + 1;
        r15 = true;
    L34:
        return r15;
    L33:
        return false;
    L19:
        if (r10.hasNoModifiers() == true) goto L21;
        return false;
    L21:
        if (r10.getRepeatCount() != 0) goto L36;
        clickKeyboardFocusedVirtualView();
        return true;
    L36:
        return false;
    L24:
        if (r10.hasNoModifiers() == false) goto L27;
        return moveFocus(2, null);
    L27:
        if (r10.hasModifiers(1) == true) goto L29;
        return false;
    L29:
        return moveFocus(1, null);
    L32:
        return false;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r10) {
        if (this.mNodeProvider != null) goto L6;
        this.mNodeProvider = new MyNodeProvider(this);
    L6:
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float r10, float r11);

    protected abstract void getVisibleVirtualViews(List<Integer> r10);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int r10) {
        invalidateVirtualView(r10, 0);
    }

    public final void invalidateVirtualView(int r10, int r11) {
        if (r10 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (this.mManager.isEnabled() == false) goto L11;
        ViewParent r12 = this.mHost.getParent();
        if (r12 == null) goto L12;
        AccessibilityEvent r13 = createEvent(r10, 2048);
        AccessibilityEventCompat.setContentChangeTypes(r13, r11);
        r12.requestSendAccessibilityEvent(this.mHost, r13);
        return;
    L12:
        return;
    }

    @NonNull
    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int r10) {
        if (r10 != (-1)) goto L7;
        return createNodeForHost();
    L7:
        return createNodeForChild(r10);
    }

    public final void onFocusChanged(boolean r10, int r11, @Nullable Rect r12) {
        int r13 = this.mKeyboardFocusedVirtualViewId;
        if (r13 == Integer.MIN_VALUE) goto L5;
        clearKeyboardFocusForVirtualView(r13);
    L5:
        if (r10 == false) goto L8;
        moveFocus(r11, r12);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
        super.onInitializeAccessibilityEvent(r10, r11);
        onPopulateEventForHost(r11);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        onPopulateNodeForHost(r11);
    }

    protected abstract boolean onPerformActionForVirtualView(int r10, int r11, @Nullable Bundle r12);

    protected void onPopulateEventForHost(@NonNull AccessibilityEvent r10) {
    }

    protected void onPopulateEventForVirtualView(int r10, @NonNull AccessibilityEvent r11) {
    }

    protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat r10) {
    }

    protected abstract void onPopulateNodeForVirtualView(int r10, @NonNull AccessibilityNodeInfoCompat r11);

    protected void onVirtualViewKeyboardFocusChanged(int r10, boolean r11) {
    }

    boolean performAction(int r10, int r11, Bundle r12) {
        if (r10 == (-1)) goto L7;
        return performActionForChild(r10, r11, r12);
    L7:
        return performActionForHost(r11, r12);
    }

    public final boolean requestKeyboardFocusForVirtualView(int r10) {
        if (this.mHost.isFocused() == false) goto L5;
    L7:
        int r11 = this.mKeyboardFocusedVirtualViewId;
        if (r11 != r10) goto L11;
        return false;
    L11:
        if (r11 == Integer.MIN_VALUE) goto L13;
        clearKeyboardFocusForVirtualView(r11);
    L13:
        if (r10 != Integer.MIN_VALUE) goto L15;
        return false;
    L15:
        this.mKeyboardFocusedVirtualViewId = r10;
        onVirtualViewKeyboardFocusChanged(r10, true);
        sendEventForVirtualView(r10, 8);
        return true;
    L5:
        if (this.mHost.requestFocus() == true) goto L7;
        return false;
    }

    public final boolean sendEventForVirtualView(int r10, int r11) {
        if (r10 != Integer.MIN_VALUE) goto L5;
    L12:
        return false;
    L5:
        if (this.mManager.isEnabled() == false) goto L12;
        ViewParent r12 = this.mHost.getParent();
        if (r12 != null) goto L10;
        return false;
    L10:
        AccessibilityEvent r13 = createEvent(r10, r11);
        return r12.requestSendAccessibilityEvent(this.mHost, r13);
    }
}
