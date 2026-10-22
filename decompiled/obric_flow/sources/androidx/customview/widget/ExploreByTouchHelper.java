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

    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        final /* synthetic */ ExploreByTouchHelper this$0;

        public MyNodeProvider(ExploreByTouchHelper r5) {
            this.this$0 = r5;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r5) {
            return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(r5));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int r5) {
            if (r5 != 2) goto L5;
            int r10 = this.this$0.mAccessibilityFocusedVirtualViewId;
        L7:
            if (r10 != Integer.MIN_VALUE) goto L11;
            return null;
        L11:
            return createAccessibilityNodeInfo(r10);
        L5:
            r10 = this.this$0.mKeyboardFocusedVirtualViewId;
            goto L7
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int r5, int r10, Bundle r11) {
            return this.this$0.performAction(r5, r10, r11);
        }
    }

    static {
        INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        NODE_ADAPTER = new AnonymousClass1();
        SPARSE_VALUES_ADAPTER = new AnonymousClass2();
    }

    public ExploreByTouchHelper(@NonNull View r5) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (r5 == null) goto L9;
        this.mHost = r5;
        this.mManager = (AccessibilityManager) r5.getContext().getSystemService("accessibility");
        r5.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(r5) != 0) goto L10;
        ViewCompat.setImportantForAccessibility(r5, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int r5) {
        if (this.mAccessibilityFocusedVirtualViewId != r5) goto L6;
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(r5, 65536);
        return true;
    L6:
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int r5 = this.mKeyboardFocusedVirtualViewId;
        if (r5 != Integer.MIN_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (onPerformActionForVirtualView(r5, 16, null) == false) goto L7;
        return true;
    }

    private AccessibilityEvent createEvent(int r5, int r10) {
        if (r5 == (-1)) goto L7;
        return createEventForChild(r5, r10);
    L7:
        return createEventForHost(r10);
    }

    private AccessibilityEvent createEventForChild(int r5, int r10) {
        AccessibilityEvent r11 = AccessibilityEvent.obtain(r10);
        AccessibilityNodeInfoCompat r12 = obtainAccessibilityNodeInfo(r5);
        r11.getText().add(r12.getText());
        r11.setContentDescription(r12.getContentDescription());
        r11.setScrollable(r12.isScrollable());
        r11.setPassword(r12.isPassword());
        r11.setEnabled(r12.isEnabled());
        r11.setChecked(r12.isChecked());
        onPopulateEventForVirtualView(r5, r11);
        if (r11.getText().isEmpty() == true) goto L5;
    L9:
        r11.setClassName(r12.getClassName());
        AccessibilityRecordCompat.setSource(r11, this.mHost, r5);
        r11.setPackageName(this.mHost.getContext().getPackageName());
        return r11;
    L5:
        if (r11.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent createEventForHost(int r5) {
        AccessibilityEvent r10 = AccessibilityEvent.obtain(r5);
        this.mHost.onInitializeAccessibilityEvent(r10);
        return r10;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int r10) {
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.obtain();
        r5.setEnabled(true);
        r5.setFocusable(true);
        r5.setClassName(DEFAULT_CLASS_NAME);
        Rect r11 = INVALID_PARENT_BOUNDS;
        r5.setBoundsInParent(r11);
        r5.setBoundsInScreen(r11);
        r5.setParent(this.mHost);
        onPopulateNodeForVirtualView(r10, r5);
        if (r5.getText() == null) goto L5;
    L9:
        r5.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(r11) == true) goto L50;
        int r12 = r5.getActions();
        if ((r12 & 64) != 0) goto L48;
        if ((r12 & 128) != 0) goto L46;
        r5.setPackageName(this.mHost.getContext().getPackageName());
        r5.setSource(this.mHost, r10);
        if (this.mAccessibilityFocusedVirtualViewId != r10) goto L18;
        r5.setAccessibilityFocused(true);
        r5.addAction(128);
    L20:
        if (this.mKeyboardFocusedVirtualViewId != r10) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L26;
        r5.addAction(2);
    L28:
        r5.setFocused(r13);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        r5.getBoundsInScreen(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(r11) == false) goto L38;
        r5.getBoundsInParent(this.mTempScreenRect);
        if (r5.mParentVirtualDescendantId == (-1)) goto L36;
        AccessibilityNodeInfoCompat r14 = AccessibilityNodeInfoCompat.obtain();
        int r15 = r5.mParentVirtualDescendantId;
    L33:
        if (r15 == (-1)) goto L35;
        r14.setParent(this.mHost, -1);
        r14.setBoundsInParent(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(r15, r14);
        r14.getBoundsInParent(this.mTempParentRect);
        Rect r16 = this.mTempScreenRect;
        Rect r17 = this.mTempParentRect;
        r16.offset(r17.left, r17.top);
        r15 = r14.mParentVirtualDescendantId;
        goto L33
    L35:
        r14.recycle();
    L36:
        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    L38:
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect) == false) goto L44;
        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        if (this.mTempScreenRect.intersect(this.mTempVisibleRect) == false) goto L44;
        r5.setBoundsInScreen(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect) == false) goto L44;
        r5.setVisibleToUser(true);
    L44:
        return r5;
    L26:
        if (r5.isFocusable() == false) goto L28;
        r5.addAction(1);
        goto L28
    L22:
        r13 = false;
        goto L23
    L18:
        r5.setAccessibilityFocused(false);
        r5.addAction(64);
        goto L20
    L46:
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L48:
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L50:
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    L5:
        if (r5.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, r5);
        ArrayList r10 = new ArrayList();
        getVisibleVirtualViews(r10);
        if (r5.getChildCount() > 0) goto L5;
    L9:
        int r11 = r10.size();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L12;
        r5.addChild(this.mHost, ((Integer) r10.get(r12)).intValue());
        r12 = r12 + 1;
        goto L10
    L12:
        return r5;
    L5:
        if (r10.size() <= 0) goto L9;
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList r5 = new ArrayList();
        getVisibleVirtualViews(r5);
        SparseArrayCompat<AccessibilityNodeInfoCompat> r10 = new SparseArrayCompat();
        int r11 = 0;
    L4:
        if (r11 >= r5.size()) goto L6;
        AccessibilityNodeInfoCompat r12 = createNodeForChild(((Integer) r5.get(r11)).intValue());
        r10.put(((Integer) r5.get(r11)).intValue(), r12);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    private void getBoundsInParent(int r5, Rect r10) {
        obtainAccessibilityNodeInfo(r5).getBoundsInParent(r10);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View r5, int r10, @NonNull Rect r11) {
        int r12 = r5.getWidth();
        int r13 = r5.getHeight();
        if (r10 != 17) goto L5;
        r11.set(r12, 0, r12, r13);
    L16:
        return r11;
    L5:
        if (r10 != 33) goto L7;
        r11.set(0, r13, r12, r13);
        goto L16
    L7:
        if (r10 != 66) goto L9;
        r11.set(-1, 0, -1, r13);
        goto L16
    L9:
        if (r10 != 130) goto L12;
        r11.set(0, -1, r12, -1);
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private boolean isVisibleToUser(Rect r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return false;
    L8:
        if (this.mHost.getWindowVisibility() == 0) goto L10;
        return false;
    L10:
        Object r10 = this.mHost.getParent();
    L12:
        if ((r10 instanceof View) == false) goto L20;
        View r11 = (View) r10;
        if (r11.getAlpha() <= 0.0f) goto L19;
        if (r11.getVisibility() != 0) goto L19;
        r10 = r11.getParent();
    L19:
        return false;
    L20:
        if (r10 == null) goto L27;
        return true;
    L27:
        return false;
    }

    private static int keyToDirection(int r5) {
        if (r5 != 19) goto L5;
        return 33;
    L5:
        if (r5 != 21) goto L7;
        return 17;
    L7:
        if (r5 == 22) goto L10;
        return 130;
    L10:
        return 66;
    }

    private boolean moveFocus(int r10, @Nullable Rect r11) {
        SparseArrayCompat<AccessibilityNodeInfoCompat> r12 = getAllNodes();
        int r5 = this.mKeyboardFocusedVirtualViewId;
        int r13 = Integer.MIN_VALUE;
        if (r5 != Integer.MIN_VALUE) goto L6;
        AccessibilityNodeInfoCompat r14 = null;
    L5:
        AccessibilityNodeInfoCompat r15 = r14;
        if (r10 == 1) goto L30;
        if (r10 == 2) goto L30;
        if (r10 != 17) goto L14;
    L22:
        Rect r16 = new Rect();
        int r17 = this.mKeyboardFocusedVirtualViewId;
        if (r17 == Integer.MIN_VALUE) goto L25;
        getBoundsInParent(r17, r16);
    L28:
        AccessibilityNodeInfoCompat r18 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(r12, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r15, r16, r10);
    L34:
        if (r18 == null) goto L38;
        r13 = r12.keyAt(r12.indexOfValue(r18));
    L38:
        return requestKeyboardFocusForVirtualView(r13);
    L25:
        if (r11 == null) goto L27;
        r16.set(r11);
        goto L28
    L27:
        guessPreviouslyFocusedRect(this.mHost, r10, r16);
        goto L28
    L14:
        if (r10 == 33) goto L22;
        if (r10 == 66) goto L22;
        if (r10 == 130) goto L22;
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L30:
        if (ViewCompat.getLayoutDirection(this.mHost) != 1) goto L32;
        boolean r19 = true;
    L33:
        r18 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(r12, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r15, r10, r19, false);
        goto L34
    L32:
        r19 = false;
        goto L33
    L6:
        r14 = r12.get(r5);
        goto L5
    }

    private boolean performActionForChild(int r5, int r10, Bundle r11) {
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L17;
        if (r10 == 64) goto L15;
        if (r10 == 128) goto L13;
        return onPerformActionForVirtualView(r5, r10, r11);
    L13:
        return clearAccessibilityFocus(r5);
    L15:
        return requestAccessibilityFocus(r5);
    L17:
        return clearKeyboardFocusForVirtualView(r5);
    L19:
        return requestKeyboardFocusForVirtualView(r5);
    }

    private boolean performActionForHost(int r5, Bundle r10) {
        return ViewCompat.performAccessibilityAction(this.mHost, r5, r10);
    }

    private boolean requestAccessibilityFocus(int r5) {
        if (this.mManager.isEnabled() == true) goto L5;
    L14:
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L14;
        int r10 = this.mAccessibilityFocusedVirtualViewId;
        if (r10 == r5) goto L14;
        if (r10 == Integer.MIN_VALUE) goto L12;
        clearAccessibilityFocus(r10);
    L12:
        this.mAccessibilityFocusedVirtualViewId = r5;
        this.mHost.invalidate();
        sendEventForVirtualView(r5, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int r5) {
        int r10 = this.mHoveredVirtualViewId;
        if (r10 != r5) goto L5;
        return;
    L5:
        this.mHoveredVirtualViewId = r5;
        sendEventForVirtualView(r5, 128);
        sendEventForVirtualView(r10, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int r5) {
        if (this.mKeyboardFocusedVirtualViewId == r5) goto L5;
        return false;
    L5:
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(r5, false);
        sendEventForVirtualView(r5, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent r10) {
        if (this.mManager.isEnabled() == true) goto L5;
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L25;
        int r5 = r10.getAction();
        if (r5 != 7) goto L10;
    L19:
        int r11 = getVirtualViewAt(r10.getX(), r10.getY());
        updateHoveredVirtualView(r11);
        if (r11 != Integer.MIN_VALUE) goto L22;
        return false;
    L22:
        return true;
    L10:
        if (r5 == 9) goto L19;
        if (r5 == 10) goto L15;
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
        int r5 = 0;
        if (r10.getAction() == 1) goto L32;
        int r11 = r10.getKeyCode();
        if (r11 == 61) goto L24;
        if (r11 == 66) goto L19;
        switch(r11) {
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
        int r12 = keyToDirection(r11);
        int r13 = r10.getRepeatCount() + 1;
        boolean r14 = false;
    L13:
        if (r5 >= r13) goto L34;
        if (moveFocus(r12, null) == false) goto L34;
        r5 = r5 + 1;
        r14 = true;
    L34:
        return r14;
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
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r5) {
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

    public abstract int getVirtualViewAt(float r5, float r10);

    public abstract void getVisibleVirtualViews(List<Integer> r5);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int r5) {
        invalidateVirtualView(r5, 0);
    }

    @NonNull
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int r5) {
        if (r5 != (-1)) goto L7;
        return createNodeForHost();
    L7:
        return createNodeForChild(r5);
    }

    public final void onFocusChanged(boolean r5, int r10, @Nullable Rect r11) {
        int r12 = this.mKeyboardFocusedVirtualViewId;
        if (r12 == Integer.MIN_VALUE) goto L5;
        clearKeyboardFocusForVirtualView(r12);
    L5:
        if (r5 == false) goto L8;
        moveFocus(r10, r11);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r5, r10);
        onPopulateEventForHost(r10);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        onPopulateNodeForHost(r10);
    }

    public abstract boolean onPerformActionForVirtualView(int r5, int r10, @Nullable Bundle r11);

    public void onPopulateEventForHost(@NonNull AccessibilityEvent r5) {
    }

    public void onPopulateEventForVirtualView(int r5, @NonNull AccessibilityEvent r10) {
    }

    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat r5) {
    }

    public abstract void onPopulateNodeForVirtualView(int r5, @NonNull AccessibilityNodeInfoCompat r10);

    public void onVirtualViewKeyboardFocusChanged(int r5, boolean r10) {
    }

    public boolean performAction(int r5, int r10, Bundle r11) {
        if (r5 == (-1)) goto L7;
        return performActionForChild(r5, r10, r11);
    L7:
        return performActionForHost(r10, r11);
    }

    public final boolean requestKeyboardFocusForVirtualView(int r5) {
        if (this.mHost.isFocused() == false) goto L5;
    L7:
        int r10 = this.mKeyboardFocusedVirtualViewId;
        if (r10 != r5) goto L11;
        return false;
    L11:
        if (r10 == Integer.MIN_VALUE) goto L13;
        clearKeyboardFocusForVirtualView(r10);
    L13:
        if (r5 != Integer.MIN_VALUE) goto L15;
        return false;
    L15:
        this.mKeyboardFocusedVirtualViewId = r5;
        onVirtualViewKeyboardFocusChanged(r5, true);
        sendEventForVirtualView(r5, 8);
        return true;
    L5:
        if (this.mHost.requestFocus() == true) goto L7;
        return false;
    }

    public final boolean sendEventForVirtualView(int r5, int r10) {
        if (r5 != Integer.MIN_VALUE) goto L5;
    L12:
        return false;
    L5:
        if (this.mManager.isEnabled() == false) goto L12;
        ViewParent r11 = this.mHost.getParent();
        if (r11 != null) goto L10;
        return false;
    L10:
        AccessibilityEvent r12 = createEvent(r5, r10);
        return r11.requestSendAccessibilityEvent(this.mHost, r12);
    }

    public final void invalidateVirtualView(int r5, int r10) {
        if (r5 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (this.mManager.isEnabled() == false) goto L11;
        ViewParent r11 = this.mHost.getParent();
        if (r11 == null) goto L12;
        AccessibilityEvent r12 = createEvent(r5, 2048);
        AccessibilityEventCompat.setContentChangeTypes(r12, r10);
        r11.requestSendAccessibilityEvent(this.mHost, r12);
        return;
    L12:
        return;
    }
}
