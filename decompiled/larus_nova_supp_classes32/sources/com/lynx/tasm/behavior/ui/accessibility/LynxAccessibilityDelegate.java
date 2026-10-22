package com.lynx.tasm.behavior.ui.accessibility;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxAccessibilityDelegate extends AccessibilityDelegateCompat {
    public final UIGroup a;
    public final View b;
    public int c;
    public int d;
    public LynxNodeProvider e;
    public boolean f;
    public LynxBaseUI g;

    public final boolean a() {
        UIGroup r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        d r1 = null;
    L8:
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.k();
    L5:
        if (r0.getLynxContext() == null) goto L7;
        r1 = this.a.getLynxContext().getLynxAccessibilityWrapper();
        goto L8
    }

    public LynxAccessibilityDelegate(UIGroup r4) {
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        this.f = true;
        if (r4 == null) goto L11;
        if (r4.getAccessibilityHostView() == null) goto L11;
        this.a = r4;
        View r1 = r4.getAccessibilityHostView();
        this.b = r1;
        AccessibilityManager r5 = (AccessibilityManager) r4.getLynxContext().getSystemService("accessibility");
        this.e = new LynxNodeProvider(this);
        r1.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(r1) != 0) goto L12;
        ViewCompat.setImportantForAccessibility(r1, 1);
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("host ui or host view is null");
    }

    public final boolean dispatchHoverEvent(MotionEvent r7) {
        if (a() == true) goto L5;
        return false;
    L5:
        EventTarget r0 = this.a.hitTest((int) r7.getX(), (int) r7.getY());
    L6:
        if (r0 == null) goto L10;
        if ((r0 instanceof LynxBaseUI) == true) goto L10;
        r0 = r0.parent();
    L10:
        if (r0 != null) goto L12;
    L38:
        return false;
    L12:
        if ((r0 instanceof LynxBaseUI) == false) goto L38;
        LynxBaseUI r1 = (LynxBaseUI) r0;
    L16:
        if (this.e.k(r1) == true) goto L20;
        r1 = r1.getParentBaseUI();
        if (r1 != null) goto L16;
        return false;
    L20:
        int r2 = this.e.e(r1);
        if (r2 != (-1)) goto L23;
        return false;
    L23:
        int r8 = r7.getAction();
        if (r8 == 9) goto L35;
        if (r8 == 10) goto L28;
        return false;
    L28:
        int r9 = this.d;
        if (r9 == Integer.MIN_VALUE) goto L33;
        if (r9 == Integer.MIN_VALUE) goto L33;
        sendEventForVirtualView(Integer.MIN_VALUE, LynxTouchEvent.kPseudoStateFocusTransition);
        sendEventForVirtualView(this.d, 256);
        this.d = Integer.MIN_VALUE;
    L33:
        return true;
    L35:
        if (this.d == r2) goto L37;
        sendEventForVirtualView(r2, LynxTouchEvent.kPseudoStateFocusTransition);
        sendEventForVirtualView(this.d, 256);
        this.d = r2;
    L37:
        return true;
    }

    public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r1) {
        if (this.e != null) goto L6;
        this.e = new LynxNodeProvider(this);
    L6:
        return this.e;
    }

    public final boolean requestAccessibilityFocus(int r4) {
        if (a() == true) goto L5;
        return false;
    L5:
        int r0 = this.c;
        if (r0 == r4) goto L19;
        d r1 = null;
        if (r0 == Integer.MIN_VALUE) goto L10;
        this.c = Integer.MIN_VALUE;
        this.b.invalidate();
        this.g = null;
        sendEventForVirtualView(r0, 65536);
    L10:
        this.c = r4;
        this.g = ((LynxNodeProvider.b) ListProtector.get(this.e.g, r4)).a;
        this.b.invalidate();
        sendEventForVirtualView(r4, 32768);
        UIGroup r5 = this.a;
        if (r5 != null) goto L13;
    L15:
        if (r1 == null) goto L20;
        d.l(this.g);
        return true;
    L20:
        return true;
    L13:
        if (r5.getLynxContext() == null) goto L15;
        r1 = this.a.getLynxContext().getLynxAccessibilityWrapper();
        goto L15
    L19:
        return false;
    }

    public final boolean sendEventForVirtualView(int r5, int r6) {
        if (r5 != Integer.MIN_VALUE) goto L5;
    L19:
        return false;
    L5:
        if (a() == false) goto L19;
        ViewParent r0 = this.b.getParent();
        if (r0 != null) goto L11;
        return false;
    L11:
        if (r5 == (-1)) goto L16;
        AccessibilityEvent r7 = AccessibilityEvent.obtain(r6);
        AccessibilityNodeInfoCompat r1 = this.e.a(r5);
        if (r1 == null) goto L15;
        r7.getText().add(r1.getText());
        r7.setContentDescription(r1.getContentDescription());
        r7.setScrollable(r1.isScrollable());
        r7.setPassword(r1.isPassword());
        r7.setEnabled(r1.isEnabled());
        r7.setChecked(r1.isChecked());
        r7.setClassName(r1.getClassName());
    L15:
        AccessibilityRecordCompat.setSource(r7, this.b, r5);
        r7.setPackageName(this.b.getContext().getPackageName());
    L18:
        return ViewParentCompat.requestSendAccessibilityEvent(r0, this.b, r7);
    L16:
        r7 = AccessibilityEvent.obtain(r6);
        this.b.onInitializeAccessibilityEvent(r7);
        goto L18
    }
}
