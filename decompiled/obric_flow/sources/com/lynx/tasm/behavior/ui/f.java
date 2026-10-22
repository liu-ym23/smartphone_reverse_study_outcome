package com.lynx.tasm.behavior.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UIGroup f10456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10457c;
    public final View d;
    public final AccessibilityManager e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10459i;

    public f(UIGroup r5) {
        this.f10457c = new ArrayList();
        this.g = false;
        this.f10458h = true;
        this.f10459i = true;
        this.f10456b = r5;
        this.d = r5.getRealParentView();
        this.e = (AccessibilityManager) r5.mContext.getSystemService("accessibility");
        this.f10455a = r5.getLynxContext().f10152u.heightPixels / 50;
    }

    public static Rect a(LynxBaseUI r5) {
        Rect r10 = new Rect();
        if ((r5 instanceof LynxUI) == false) goto L12;
        View r11 = ((LynxUI) r5).getView();
        if ((r5 instanceof UIShadowProxy) == false) goto L9;
        LynxBaseUI r12 = ((UIShadowProxy) r5).f10388a;
        if ((r12 instanceof LynxUI) == false) goto L9;
        r11 = ((LynxUI) r12).getView();
    L9:
        e(r11, r10);
        int r13 = r10.left;
        int r14 = r10.top;
        int r15 = r5.getWidth() + r13;
        int r16 = r10.top;
        r10.set(r13, r14, r15, r5.getHeight() + r16);
        return r10;
    L12:
        if ((r5 instanceof LynxFlattenUI) == false) goto L23;
        LynxBaseUI r17 = r5.getParentBaseUI();
    L14:
        if (r17 == null) goto L18;
        if ((r17 instanceof LynxUI) == true) goto L18;
        r17 = r17.getParentBaseUI();
    L18:
        if (r17 == null) goto L23;
        View r18 = ((LynxUI) r17).getView();
        if ((r17 instanceof UIGroup) == false) goto L22;
        r18 = ((UIGroup) r17).getRealParentView();
    L22:
        e(r18, r10);
        r10.offset(-r18.getScrollX(), -r18.getScrollY());
        r10.offset(r5.getLeft(), r5.getTop());
        int r19 = r10.left;
        int r20 = r10.top;
        int r21 = r5.getWidth() + r19;
        int r22 = r10.top;
        r10.set(r19, r20, r21, r5.getHeight() + r22);
    L23:
        return r10;
    }

    public static void e(View r5, Rect r10) {
        r10.set(0, 0, r5.getRight() - r5.getLeft(), r5.getBottom() - r5.getTop());
        int[] r11 = new int[2];
        r5.getLocationOnScreen(r11);
        r10.offset(r11[0], r11[1]);
    }

    public final void b(int r10, int r11) {
        if (this.e.isTouchExplorationEnabled() == false) goto L37;
        AccessibilityEvent r12 = AccessibilityEvent.obtain(r11);
        if (r10 < 0) goto L38;
        e r5 = (e) this.f10457c.get(r10);
        LynxBaseUI r13 = r5.f10449a;
        View r14 = this.d;
        if (r13 == null) goto L25;
        r12.setPackageName(r14.getContext().getPackageName());
        LynxBaseUI r15 = r5.f10449a;
        r12.setClassName(r15.getClass().getName());
        r12.setEnabled(true);
        String r16 = "";
        if (h(r15) == false) goto L24;
        CharSequence r17 = r15.getAccessibilityLabel();
        if (r17 != null) goto L14;
        r17 = "";
    L14:
        String r18 = r17.toString();
        if (TextUtils.isEmpty(r18) == false) goto L23;
        Iterator<LynxBaseUI> r19 = r15.mChildren.iterator();
    L18:
        if (r19.hasNext() == false) goto L23;
        LynxBaseUI r20 = r19.next();
        StringBuilder r21 = new StringBuilder();
        r21.append(r18);
        CharSequence r22 = r20.getAccessibilityLabel();
        if (r22 != null) goto L22;
        r22 = "";
    L22:
        r21.append(r22.toString());
        r18 = r21.toString();
    L23:
        r16 = r18.toString();
    L24:
        r12.setContentDescription(r16);
    L28:
        r12.setSource(r14, r10);
        r14.invalidate();
        if (r14.getParent() != null) goto L32;
        LynxLog.b(4, "LynxAccessibilityNodeProvider", "sendAccessibilityEventForLynxUI failed, parent is null.");
        return;
    L32:
        r14.getParent().requestSendAccessibilityEvent(r14, r12);
        return;
    L25:
        View r23 = r5.f10450b;
        if (r23 == null) goto L39;
        r23.onInitializeAccessibilityEvent(r12);
        goto L28
    L39:
        return;
    L38:
        return;
    }

    public final void c(MotionEvent r10, int r11) {
        int r12 = r10.getAction();
        if (this.f == true) goto L7;
        if (r12 == 9) goto L6;
        if (r12 == 7) goto L6;
    L10:
        View r13 = this.d;
        if (r12 == 9) goto L16;
        if (r12 == 10) goto L14;
        return;
    L14:
        r13.setHovered(false);
        return;
    L16:
        r13.setHovered(true);
        return;
    L6:
        b(r11, 128);
        this.f = true;
        goto L10
    L7:
        if (r12 == 10) goto L9;
        if (r12 != 7) goto L10;
    L9:
        this.f = false;
        b(r11, 256);
        goto L10
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int r12) {
        LynxLog.b(2, "LynxAccessibilityNodeProvider", "createAccessibilityNodeInfo: " + r12);
        ArrayList r5 = this.f10457c;
        int r10 = 0;
        View r11 = this.d;
        if (r12 != (-1)) goto L43;
        AccessibilityNodeInfo r13 = AccessibilityNodeInfo.obtain(r11);
        r5.clear();
        ArrayList r14 = new ArrayList();
        UIGroup r15 = this.f10456b;
        f(r15, r14);
        Collections.sort(r5, new d(this));
        if (this.g == false) goto L37;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r5.iterator();
    L8:
        if (r17.hasNext() == false) goto L36;
        e r18 = (e) r17.next();
        LynxBaseUI r19 = r18.f10449a;
        if (r19 == null) goto L35;
        if (r18.d == false) goto L35;
        ArrayList<String> r20 = r19.getAccessibilityElements();
        if (r20 == null) goto L8;
        if (r15.getLynxContext() == null) goto L8;
        if (((n0) r15.getLynxContext().f10147o.get()) == null) goto L8;
        n0 r21 = (n0) r15.getLynxContext().f10147o.get();
        Iterator<String> r22 = r20.iterator();
    L21:
        if (r22.hasNext() == false) goto L8;
        LynxBaseUI r23 = r21.E(r22.next());
        if (r23 == null) goto L21;
        if ((r23 instanceof LynxUI) == false) goto L30;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r23).getView()) == false) goto L21;
    L30:
        if ((r23 instanceof UIShadowProxy) == false) goto L33;
        r23 = ((UIShadowProxy) r23).f10388a;
    L33:
        if (h(r23) == false) goto L21;
        r16.add(new e(r23, a(r23)));
    L35:
        r16.add(r18);
        goto L8
    L36:
        r5.clear();
        r5.addAll(r16);
        this.g = false;
    L37:
        r11.onInitializeAccessibilityNodeInfo(r13);
    L39:
        if (r10 >= r5.size()) goto L41;
        r13.addChild(r11, r10);
        r10 = r10 + 1;
        goto L39
    L41:
        Rect r110 = new Rect();
        e(r11, r110);
        int r24 = r110.left;
        r110.set(r24, r110.top, r15.getWidth() + r24, r15.getHeight() + r110.top);
        return r13;
    L43:
        if (r12 >= 0) goto L45;
        return null;
    L45:
        if (r12 >= r5.size()) goto L117;
        e r25 = (e) r5.get(r12);
        AccessibilityNodeInfo r26 = AccessibilityNodeInfo.obtain(r11, r12);
        r11.onInitializeAccessibilityNodeInfo(r26);
        LynxBaseUI r27 = r25.f10449a;
        if (r27 == null) goto L82;
        Rect r28 = a(r27);
        r25.f10451c = r28;
        r26.setBoundsInScreen(r28);
        LynxBaseUI r29 = r25.f10449a;
        r26.setClassName(r29.getClass().getName());
        String r30 = "";
        if (h(r29) == false) goto L65;
        CharSequence r111 = r29.getAccessibilityLabel();
        if (r111 != null) goto L55;
        r111 = "";
    L55:
        String r112 = r111.toString();
        if (TextUtils.isEmpty(r112) == false) goto L64;
        Iterator<LynxBaseUI> r31 = r29.mChildren.iterator();
    L59:
        if (r31.hasNext() == false) goto L64;
        LynxBaseUI r32 = r31.next();
        StringBuilder r113 = new StringBuilder();
        r113.append(r112);
        CharSequence r114 = r32.getAccessibilityLabel();
        if (r114 != null) goto L63;
        r114 = "";
    L63:
        r113.append(r114.toString());
        r112 = r113.toString();
    L64:
        r30 = r112.toString();
    L65:
        r26.setContentDescription(r30);
        r26.setText(r30);
        r26.setScrollable(r29.isScrollable());
        r26.setLongClickable(r29.isLongClickable());
        r26.setFocusable(r29.isFocusable());
        Map<String, on.a> r115 = r29.mEvents;
        if (r115 != null) goto L68;
    L72:
        boolean r116 = false;
    L73:
        r26.setClickable(r116);
        StringBuilder r117 = new StringBuilder("Label for UI: ");
        r117.append(r12);
        r117.append(", ");
        com.lynx.tasm.behavior.ui.utils.e.i(r117, r30, 2, "LynxAccessibilityNodeProvider");
        if (r29.getAccessibilityEnableTap() == false) goto L87;
        Map<String, on.a> r118 = r29.mEvents;
        if (r118 == null) goto L87;
        if (r118.containsKey("click") == false) goto L80;
    L81:
        r26.addAction(16);
        goto L87
    L80:
        if (r29.mEvents.containsKey("tap") == true) goto L81;
    L87:
        r26.setParent(r11);
        r26.addAction(64);
        r26.setAccessibilityFocused(false);
        r26.setFocused(false);
        r26.addAction(4096);
        r26.addAction(8192);
        r26.setVisibleToUser(true);
        return r26;
    L68:
        if (r115.containsKey("click") == false) goto L70;
    L71:
        r116 = true;
        goto L73
    L70:
        if (r29.mEvents.containsKey("tap") == false) goto L72;
    L82:
        View r119 = r25.f10450b;
        if (r119 == null) goto L87;
        if (ViewCompat.isAttachedToWindow(r119) == false) goto L87;
        r119.onInitializeAccessibilityNodeInfo(r26);
        r26.setSource(r11, r12);
        goto L87
    L117:
        return null;
    }

    public final void d(View r10) {
        int r5 = 0;
        boolean r11 = true;
        if (r10.getVisibility() != 0) goto L5;
        boolean r12 = true;
    L7:
        if (r10.getImportantForAccessibility() != 1) goto L9;
    L14:
        if (r12 == false) goto L18;
        if (r11 == false) goto L18;
        Rect r13 = new Rect();
        e(r10, r13);
        this.f10457c.add(new e(r10, r13));
    L18:
        if ((r10 instanceof ViewGroup) == false) goto L23;
        ViewGroup r14 = (ViewGroup) r10;
    L21:
        if (r5 >= r14.getChildCount()) goto L25;
        d(r14.getChildAt(r5));
        r5 = r5 + 1;
        goto L21
    L25:
        return;
    L23:
        return;
    L9:
        if (r10.getImportantForAccessibility() != 2) goto L11;
    L13:
        r11 = false;
        goto L14
    L11:
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L13;
    L5:
        r12 = false;
        goto L7
    }

    public final void f(LynxBaseUI r5, ArrayList r10) {
        ArrayList<String> r11 = r5.getAccessibilityElements();
        ArrayList r12 = this.f10457c;
        if (r11 == null) goto L6;
        e r13 = new e(r5, a(r5));
        r13.d = true;
        r12.add(r13);
        this.g = true;
        return;
    L6:
        int r14 = r5.getChildren().size() - 1;
    L7:
        if (r14 < 0) goto L18;
        LynxBaseUI r15 = r5.getChildren().get(r14);
        if ((r15 instanceof LynxUI) == false) goto L13;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r15).getView()) == true) goto L13;
    L16:
        r14 = r14 - 1;
    L13:
        if ((r15 instanceof n) == true) goto L16;
        f(r15, r10);
        goto L16
    L18:
        if (r5 != this.f10456b) goto L20;
        return;
    L20:
        if ((r5 instanceof UIShadowProxy) == false) goto L23;
        r5 = ((UIShadowProxy) r5).f10388a;
    L23:
        if (h(r5) == false) goto L36;
        Rect r16 = a(r5);
        if (this.f10459i == true) goto L34;
        Iterator r17 = r10.iterator();
    L28:
        if (r17.hasNext() == false) goto L32;
        if (((Rect) r17.next()).contains(r16) == false) goto L28;
    L33:
        r10.add(r16);
        goto L36
    L32:
        r12.add(new e(r5, r16));
        goto L33
    L34:
        r12.add(new e(r5, r16));
    L36:
        if ((r5 instanceof LynxUI) == true) goto L38;
        return;
    L38:
        if (r5.mChildren.isEmpty() == false) goto L55;
        LynxUI r18 = (LynxUI) r5;
        if ((r18.getView() instanceof ViewGroup) == false) goto L56;
        ViewGroup r19 = (ViewGroup) r18.getView();
        int r20 = 0;
    L43:
        if (r20 >= r19.getChildCount()) goto L57;
        d(r19.getChildAt(r20));
        r20 = r20 + 1;
        goto L43
    L57:
        return;
    L56:
        return;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String r5, int r10) {
        ArrayList r11 = new ArrayList();
        if (r5 == null) goto L36;
        String r12 = r5.toLowerCase();
        CharSequence r13 = "";
        ArrayList r14 = this.f10457c;
        if (r10 != (-1)) goto L21;
        int r15 = 0;
    L9:
        if (r15 >= r14.size()) goto L36;
        if (((e) r14.get(r15)).f10449a == null) goto L20;
        CharSequence r16 = ((e) r14.get(r15)).f10449a.getAccessibilityLabel();
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        String r17 = r16.toString();
        if (r17 == null) goto L20;
        if (r17.toString().toLowerCase().contains(r12) == false) goto L20;
        r11.add(createAccessibilityNodeInfo(r15));
    L20:
        r15 = r15 + 1;
        goto L9
    L21:
        if (r10 <= 0) goto L36;
        if (r10 >= r14.size()) goto L36;
        LynxBaseUI r18 = ((e) r14.get(r10)).f10449a;
        if (r18 == null) goto L36;
        CharSequence r19 = r18.getAccessibilityLabel();
        if (r19 == null) goto L31;
        r13 = r19;
    L31:
        String r20 = r13.toString();
        if (r20 == null) goto L36;
        if (r20.toString().toLowerCase().contains(r12) == false) goto L36;
        r11.add(createAccessibilityNodeInfo(r10));
    L36:
        return r11;
    }

    public final boolean g(MotionEvent r11) {
        wm.a r5 = this.f10456b.hitTest((int) r11.getX(), (int) r11.getY());
        LynxLog.b(2, "LynxAccessibilityNodeProvider", "onHover with target = " + r5 + " event: [" + ((int) r11.getX()) + ", " + ((int) r11.getY()) + "]");
    L3:
        if (r5 == null) goto L8;
        if ((r5 instanceof LynxBaseUI) == true) goto L8;
        r5 = r5.parent();
    L8:
        if (r5 != null) goto L10;
    L45:
        return false;
    L10:
        if ((r5 instanceof LynxBaseUI) == false) goto L45;
        LynxBaseUI r10 = (LynxBaseUI) r5;
    L14:
        if (h(r10) == true) goto L18;
        r10 = r10.getParentBaseUI();
        if (r10 != null) goto L14;
        return false;
    L18:
        ArrayList r12 = this.f10457c;
        int r13 = r12.size() - 1;
    L19:
        if (r13 < 0) goto L24;
        if (((e) r12.get(r13)).f10449a == r10) goto L25;
        r13 = r13 - 1;
    L25:
        Rect r14 = new Rect();
        e(this.d, r14);
        int r15 = ((int) r11.getX()) + r14.left;
        int r16 = ((int) r11.getY()) + r14.top;
        int r17 = r12.size() - 1;
    L26:
        if (r17 < r13) goto L32;
        if (r17 < 0) goto L32;
        if (((e) r12.get(r17)).f10451c.contains(r15, r16) == true) goto L30;
        r17 = r17 - 1;
        goto L26
    L30:
        r13 = r17;
    L32:
        if (r13 >= 0) goto L34;
        return false;
    L34:
        LynxLog.b(2, "LynxAccessibilityNodeProvider", "onHover confirm virtualViewId = " + r13);
        int r18 = r11.getAction();
        if (r18 != 7) goto L37;
        c(r11, r13);
    L44:
        return true;
    L37:
        if (r18 != 9) goto L39;
        r11.setAction(9);
        c(r11, r13);
        goto L44
    L39:
        if (r18 != 10) goto L44;
        c(r11, r13);
        goto L44
    L24:
        r13 = -1;
        goto L25
    }

    public final boolean h(LynxBaseUI r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getAccessibilityElementStatus() != (-1)) goto L10;
        return this.f10458h;
    L10:
        if (r5.getAccessibilityElementStatus() != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int r10, int r11, Bundle r12) {
        LynxLog.b(2, "LynxAccessibilityNodeProvider", com.lynx.tasm.base.h.b(r10, r11, "performAction on virtualViewId ", " action "));
        if (r10 != (-1)) goto L5;
        return false;
    L5:
        if (r10 < 0) goto L38;
        ArrayList r13 = this.f10457c;
        if (r10 >= r13.size()) goto L38;
        if (r11 != 16) goto L12;
        if (r10 < 0) goto L38;
        e r14 = (e) r13.get(r10);
        LynxBaseUI r15 = r14.f10449a;
        if (r15 == null) goto L38;
        if (r15.getLynxContext() == null) goto L38;
        if (r15.getLynxContext().g == null) goto L38;
        if (r15.getAccessibilityEnableTap() == false) goto L38;
        Rect r16 = r14.f10451c;
        on.g r17 = new on.g(r16.centerX(), r16.centerY());
        on.g r18 = new on.g(r16.centerX() - r16.left, r16.centerY() - r16.top);
        Map<String, on.a> r19 = r15.mEvents;
        if (r19 != null) goto L32;
    L37:
        return true;
    L32:
        if (r19.containsKey("tap") == false) goto L35;
        r15.getLynxContext().g.d(new on.h(r15.getSign(), "tap", r18, r18, r17));
        goto L37
    L35:
        if (r15.mEvents.containsKey("click") == false) goto L37;
        r15.getLynxContext().g.d(new on.h(r15.getSign(), "click", r18, r18, r17));
        goto L37
    L12:
        if (r11 != 64) goto L14;
        b(r10, 32768);
        b(r10, 4);
        return true;
    L14:
        if (r11 != 128) goto L38;
        b(r10, 65536);
        return true;
    L38:
        return false;
    }
}
