package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
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
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class LynxAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UIGroup f10394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f10395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10396c;
    public int d;
    public LynxNodeProvider e;
    public boolean f;
    public LynxBaseUI g;

    public LynxAccessibilityDelegate(UIGroup r5) {
        this.f10396c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        this.f = true;
        if (r5.getAccessibilityHostView() == null) goto L9;
        this.f10394a = r5;
        View r10 = r5.getAccessibilityHostView();
        this.f10395b = r10;
        AccessibilityManager r11 = (AccessibilityManager) r5.getLynxContext().getSystemService("accessibility");
        this.e = new LynxNodeProvider(this);
        r10.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(r10) != 0) goto L10;
        ViewCompat.setImportantForAccessibility(r10, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("host ui or host view is null");
    }

    public final void a(int r5, int r10) {
        if (r5 == Integer.MIN_VALUE) goto L27;
        UIGroup r11 = this.f10394a;
        if (r11 != null) goto L7;
    L9:
        d r12 = null;
    L10:
        if (r12 == null) goto L12;
        boolean r13 = r12.h();
    L13:
        if (r13 == false) goto L28;
        View r14 = this.f10395b;
        ViewParent r15 = r14.getParent();
        if (r15 != null) goto L19;
        return;
    L19:
        if (r5 == (-1)) goto L24;
        AccessibilityEvent r16 = AccessibilityEvent.obtain(r10);
        AccessibilityNodeInfoCompat r17 = this.e.c(r5);
        if (r17 == null) goto L23;
        r16.getText().add(r17.getText());
        r16.setContentDescription(r17.getContentDescription());
        r16.setScrollable(r17.isScrollable());
        r16.setPassword(r17.isPassword());
        r16.setEnabled(r17.isEnabled());
        r16.setChecked(r17.isChecked());
        r16.setClassName(r17.getClassName());
    L23:
        AccessibilityRecordCompat.setSource(r16, r14, r5);
        r16.setPackageName(r14.getContext().getPackageName());
    L25:
        ViewParentCompat.requestSendAccessibilityEvent(r15, r14, r16);
        return;
    L24:
        r16 = AccessibilityEvent.obtain(r10);
        r14.onInitializeAccessibilityEvent(r16);
        goto L25
    L28:
        return;
    L12:
        r13 = false;
        goto L13
    L7:
        if (r11.getLynxContext() == null) goto L9;
        r12 = r11.getLynxContext().j();
        goto L10
    }

    public final boolean b(int r10) {
        d r5 = null;
        UIGroup r11 = this.f10394a;
        if (r11 != null) goto L5;
    L7:
        d r12 = null;
    L9:
        if (r12 == null) goto L11;
        boolean r13 = r12.h();
    L12:
        if (r13 == true) goto L14;
        return false;
    L14:
        int r14 = this.f10396c;
        if (r14 == r10) goto L32;
        View r15 = this.f10395b;
        if (r14 == Integer.MIN_VALUE) goto L19;
        this.f10396c = Integer.MIN_VALUE;
        r15.invalidate();
        this.g = null;
        a(r14, 65536);
    L19:
        this.f10396c = r10;
        this.g = ((f) this.e.g.get(r10)).f10418a;
        r15.invalidate();
        a(r10, 32768);
        if (r11 != null) goto L22;
    L24:
        if (r5 == null) goto L33;
        LynxBaseUI r16 = this.g;
        Rect r17 = d.f10404p;
        if (r16 != null) goto L28;
        return true;
    L28:
        if (r16.getLynxContext() == null) goto L35;
        JavaOnlyMap r18 = new JavaOnlyMap();
        r18.put("element-id", Integer.valueOf(r16.getSign()));
        r18.put("a11y-id", r16.getAccessibilityId());
        JavaOnlyArray r19 = new JavaOnlyArray();
        r19.pushMap(r18);
        r16.getLynxContext().e("activeElement", r19);
        return true;
    L35:
        return true;
    L33:
        return true;
    L22:
        if (r11.getLynxContext() == null) goto L24;
        r5 = r11.getLynxContext().j();
        goto L24
    L32:
        return false;
    L11:
        r13 = false;
        goto L12
    L5:
        if (r11.getLynxContext() == null) goto L7;
        r12 = r11.getLynxContext().j();
        goto L9
    }

    public final boolean c(MotionEvent r10) {
        UIGroup r5 = this.f10394a;
        if (r5 != null) goto L5;
    L7:
        d r11 = null;
    L9:
        if (r11 == null) goto L11;
        boolean r12 = r11.h();
    L12:
        if (r12 == true) goto L14;
        return false;
    L14:
        wm.a r13 = r5.hitTest((int) r10.getX(), (int) r10.getY());
    L15:
        if (r13 == null) goto L19;
        if ((r13 instanceof LynxBaseUI) == true) goto L19;
        r13 = r13.parent();
    L19:
        if (r13 != null) goto L21;
    L55:
        return false;
    L21:
        if ((r13 instanceof LynxBaseUI) == false) goto L55;
        LynxBaseUI r14 = (LynxBaseUI) r13;
    L25:
        if (this.e.g(r14) == true) goto L29;
        r14 = r14.getParentBaseUI();
        if (r14 != null) goto L25;
        return false;
    L29:
        LynxNodeProvider r15 = this.e;
        ArrayList r16 = r15.g;
        if (r16 != null) goto L32;
    L31:
        int r17 = -1;
    L38:
        if (r17 != (-1)) goto L40;
        return false;
    L40:
        int r18 = r10.getAction();
        if (r18 == 9) goto L52;
        if (r18 == 10) goto L45;
        return false;
    L45:
        int r19 = this.d;
        if (r19 == Integer.MIN_VALUE) goto L50;
        if (r19 == Integer.MIN_VALUE) goto L50;
        a(r19, 256);
        this.d = Integer.MIN_VALUE;
    L50:
        return true;
    L52:
        if (this.d == r17) goto L54;
        a(r17, 128);
        a(this.d, 256);
        this.d = r17;
    L54:
        return true;
    L32:
        r17 = r16.size() - 1;
    L33:
        if (r17 < 0) goto L31;
        if (((f) r15.g.get(r17)).f10418a == r14) goto L38;
        r17 = r17 - 1;
        goto L33
    L11:
        r12 = false;
        goto L12
    L5:
        if (r5.getLynxContext() == null) goto L7;
        r11 = r5.getLynxContext().j();
        goto L9
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r5) {
        if (this.e != null) goto L6;
        this.e = new LynxNodeProvider(this);
    L6:
        return this.e;
    }
}
