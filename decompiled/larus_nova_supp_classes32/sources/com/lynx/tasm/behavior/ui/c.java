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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends AccessibilityNodeProvider {
    public final int a;
    public final UIGroup b;
    public final ArrayList<a> c;
    public final View d;
    public final AccessibilityManager e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    public static class a {
        public final LynxBaseUI a;
        public final View b;
        public Rect c;
        public boolean d;

        public a(View r2, Rect r3) {
            this.a = null;
            this.b = r2;
            this.c = r3;
        }

        public a(LynxBaseUI r1, Rect r2) {
            this.a = r1;
            this.b = null;
            this.c = r2;
        }
    }

    public c(UIGroup r3) {
        this.c = new ArrayList();
        this.g = false;
        this.h = true;
        this.i = true;
        this.b = r3;
        this.d = r3.getRealParentView();
        this.e = (AccessibilityManager) r3.mContext.getSystemService("accessibility");
        this.a = r3.getLynxContext().getScreenMetrics().heightPixels / 50;
    }

    public static String c(LynxBaseUI r0) {
        CharSequence r1 = r0.getAccessibilityLabel();
        if (r1 != null) goto L6;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r1.toString();
    }

    public static Rect e(LynxBaseUI r5) {
        Rect r0 = new Rect();
        if ((r5 instanceof LynxUI) == false) goto L11;
        View r1 = ((LynxUI) r5).getView();
        if ((r5 instanceof UIShadowProxy) == false) goto L9;
        LynxBaseUI r2 = ((UIShadowProxy) r5).a;
        if ((r2 instanceof LynxUI) == false) goto L9;
        r1 = ((LynxUI) r2).getView();
    L9:
        f(r1, r0);
        int r3 = r0.left;
        r0.set(r3, r0.top, r5.getWidth() + r3, r0.top + r5.getHeight());
    L22:
        return r0;
    L11:
        if ((r5 instanceof LynxFlattenUI) == false) goto L22;
        LynxBaseUI r4 = r5.getParentBaseUI();
    L13:
        if (r4 == null) goto L17;
        if ((r4 instanceof LynxUI) == true) goto L17;
        r4 = r4.getParentBaseUI();
    L17:
        if (r4 == null) goto L22;
        View r6 = ((LynxUI) r4).getView();
        if ((r4 instanceof UIGroup) == false) goto L21;
        r6 = ((UIGroup) r4).getRealParentView();
    L21:
        f(r6, r0);
        r0.offset(-r6.getScrollX(), -r6.getScrollY());
        r0.offset(r5.getLeft(), r5.getTop());
        int r7 = r0.left;
        r0.set(r7, r0.top, r5.getWidth() + r7, r0.top + r5.getHeight());
        goto L22
    }

    public final void b(View r6) {
        int r1 = 0;
        boolean r2 = true;
        if (r6.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r6.getImportantForAccessibility() != 1) goto L9;
    L14:
        if (r0 == false) goto L18;
        if (r2 == false) goto L18;
        Rect r3 = new Rect();
        f(r6, r3);
        this.c.add(new a(r6, r3));
    L18:
        if ((r6 instanceof ViewGroup) == false) goto L23;
        ViewGroup r7 = (ViewGroup) r6;
    L21:
        if (r1 >= r7.getChildCount()) goto L25;
        b(r7.getChildAt(r1));
        r1 = r1 + 1;
        goto L21
    L25:
        return;
    L23:
        return;
    L9:
        if (r6.getImportantForAccessibility() != 2) goto L11;
    L13:
        r2 = false;
        goto L14
    L11:
        if (TextUtils.isEmpty(r6.getContentDescription()) == true) goto L13;
    L5:
        r0 = false;
        goto L7
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int r11) {
        LLog.i("LynxAccessibilityNodeProvider", "createAccessibilityNodeInfo: " + r11);
        int r2 = 0;
        if (r11 != (-1)) goto L42;
        AccessibilityNodeInfo r12 = AccessibilityNodeInfo.obtain(this.d);
        this.c.clear();
        a(this.b, new ArrayList());
        Collections.sort(this.c, new b(this));
        if (this.g == false) goto L37;
        ArrayList r0 = new ArrayList();
        Iterator<a> r1 = this.c.iterator();
    L8:
        if (r1.hasNext() == false) goto L36;
        a r3 = r1.next();
        LynxBaseUI r4 = r3.a;
        if (r4 == null) goto L35;
        if (r3.d == false) goto L35;
        ArrayList<String> r5 = r4.getAccessibilityElements();
        if (r5 == null) goto L8;
        if (this.b.getLynxContext() == null) goto L8;
        if (this.b.getLynxContext().getLynxUIOwner() == null) goto L8;
        LynxUIOwner r6 = this.b.getLynxContext().getLynxUIOwner();
        Iterator<String> r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L8;
        LynxBaseUI r8 = r6.findLynxUIByIdSelector(r7.next());
        if (r8 == null) goto L21;
        if ((r8 instanceof LynxUI) == false) goto L30;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r8).getView()) == false) goto L21;
    L30:
        if ((r8 instanceof UIShadowProxy) == false) goto L33;
        r8 = ((UIShadowProxy) r8).a;
    L33:
        if (g(r8) == false) goto L21;
        r0.add(new a(r8, e(r8)));
    L35:
        r0.add(r3);
        goto L8
    L36:
        this.c.clear();
        this.c.addAll(r0);
        this.g = false;
    L37:
        this.d.onInitializeAccessibilityNodeInfo(r12);
    L39:
        if (r2 >= this.c.size()) goto L41;
        r12.addChild(this.d, r2);
        r2 = r2 + 1;
        goto L39
    L41:
        Rect r9 = new Rect();
        f(this.d, r9);
        int r10 = r9.left;
        r9.set(r10, r9.top, this.b.getWidth() + r10, r9.top + this.b.getHeight());
        return r12;
    L42:
        if (r11 >= 0) goto L44;
        return null;
    L44:
        if (r11 >= this.c.size()) goto L105;
        a r13 = (a) ListProtector.get(this.c, r11);
        AccessibilityNodeInfo r14 = AccessibilityNodeInfo.obtain(this.d, r11);
        this.d.onInitializeAccessibilityNodeInfo(r14);
        LynxBaseUI r15 = r13.a;
        if (r15 == null) goto L72;
        Rect r16 = e(r15);
        r13.c = r16;
        r14.setBoundsInScreen(r16);
        r14.setClassName(r13.a.getClass().getName());
        String r17 = d(r13.a);
        r14.setContentDescription(r17);
        r14.setText(r17);
        r14.setScrollable(r13.a.isScrollable());
        r14.setLongClickable(r13.a.isLongClickable());
        r14.setFocusable(r13.a.isFocusable());
        LynxBaseUI r18 = r13.a;
        if (r18 == null) goto L57;
        Map<String, EventsListener> r19 = r18.mEvents;
        if (r19 == null) goto L57;
        if (r19.containsKey(LynxTouchEvent.EVENT_CLICK) == false) goto L55;
    L56:
        boolean r20 = true;
    L58:
        r14.setClickable(r20);
        LLog.i("LynxAccessibilityNodeProvider", "Label for UI: " + r11 + ", " + r17);
        if (r13.a.getAccessibilityEnableTap() == false) goto L77;
        LynxBaseUI r110 = r13.a;
        if (r110 == null) goto L69;
        Map<String, EventsListener> r21 = r110.mEvents;
        if (r21 == null) goto L69;
        if (r21.containsKey(LynxTouchEvent.EVENT_CLICK) == false) goto L67;
    L68:
        boolean r111 = true;
    L70:
        if (r111 == false) goto L77;
        r14.addAction(16);
        goto L77
    L67:
        if (r110.mEvents.containsKey(LynxTouchEvent.EVENT_TAP) == true) goto L68;
    L69:
        r111 = false;
    L77:
        r14.setParent(this.d);
        r14.addAction(64);
        r14.setAccessibilityFocused(false);
        r14.setFocused(false);
        r14.addAction(4096);
        r14.addAction(8192);
        r14.setVisibleToUser(true);
        return r14;
    L55:
        if (r18.mEvents.containsKey(LynxTouchEvent.EVENT_TAP) == true) goto L56;
    L57:
        r20 = false;
        goto L58
    L72:
        View r22 = r13.b;
        if (r22 == null) goto L77;
        if (ViewCompat.isAttachedToWindow(r22) == false) goto L77;
        r13.b.onInitializeAccessibilityNodeInfo(r14);
        r14.setSource(this.d, r11);
        goto L77
    L105:
        return null;
    }

    public final String d(LynxBaseUI r4) {
        if (g(r4) == true) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        String r0 = c(r4);
        if (TextUtils.isEmpty(r0) == false) goto L13;
        Iterator<LynxBaseUI> r5 = r4.mChildren.iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        r0 = r0 + c(r5.next());
    L13:
        return r0.toString();
    }

    public final boolean g(LynxBaseUI r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getAccessibilityElementStatus() != (-1)) goto L10;
        return this.h;
    L10:
        if (r4.getAccessibilityElementStatus() != 1) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean h(MotionEvent r9) {
        EventTarget r0 = this.b.hitTest((int) r9.getX(), (int) r9.getY());
        LLog.i("LynxAccessibilityNodeProvider", "onHover with target = " + r0 + " event: [" + ((int) r9.getX()) + ", " + ((int) r9.getY()) + "]");
    L3:
        if (r0 == null) goto L8;
        if ((r0 instanceof LynxBaseUI) == true) goto L8;
        r0 = r0.parent();
    L8:
        if (r0 != null) goto L10;
    L45:
        return false;
    L10:
        if ((r0 instanceof LynxBaseUI) == false) goto L45;
        LynxBaseUI r1 = (LynxBaseUI) r0;
    L14:
        if (g(r1) == true) goto L18;
        r1 = r1.getParentBaseUI();
        if (r1 != null) goto L14;
        return false;
    L18:
        int r3 = this.c.size() - 1;
    L19:
        if (r3 < 0) goto L24;
        if (((a) ListProtector.get(this.c, r3)).a == r1) goto L25;
        r3 = r3 - 1;
    L25:
        Rect r2 = new Rect();
        f(this.d, r2);
        int r5 = ((int) r9.getX()) + r2.left;
        int r6 = ((int) r9.getY()) + r2.top;
        int r4 = this.c.size() - 1;
    L26:
        if (r4 < r3) goto L32;
        if (r4 < 0) goto L32;
        if (((a) ListProtector.get(this.c, r4)).c.contains(r5, r6) == true) goto L30;
        r4 = r4 - 1;
        goto L26
    L30:
        r3 = r4;
    L32:
        if (r3 >= 0) goto L34;
        return false;
    L34:
        LLog.i("LynxAccessibilityNodeProvider", "onHover confirm virtualViewId = " + r3);
        int r7 = r9.getAction();
        if (r7 != 7) goto L37;
        i(r3, r9);
    L44:
        return true;
    L37:
        if (r7 != 9) goto L39;
        r9.setAction(9);
        i(r3, r9);
        goto L44
    L39:
        if (r7 != 10) goto L44;
        i(r3, r9);
        goto L44
    L24:
        r3 = -1;
        goto L25
    }

    public static void f(View r3, Rect r4) {
        r4.set(0, 0, r3.getRight() - r3.getLeft(), r3.getBottom() - r3.getTop());
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r0);
        r4.offset(r0[0], r0[1]);
    }

    public final void a(LynxBaseUI r6, List<Rect> r7) {
        boolean r1 = true;
        if (r6.getAccessibilityElements() == null) goto L6;
        a r0 = new a(r6, e(r6));
        r0.d = true;
        this.c.add(r0);
        this.g = true;
        return;
    L6:
        int r2 = r6.getChildren().size() - 1;
    L7:
        if (r2 < 0) goto L18;
        LynxBaseUI r3 = (LynxBaseUI) ListProtector.get(r6.getChildren(), r2);
        if ((r3 instanceof LynxUI) == false) goto L13;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r3).getView()) == true) goto L13;
    L16:
        r2 = r2 - 1;
    L13:
        if ((r3 instanceof d) == true) goto L16;
        a(r3, r7);
        goto L16
    L18:
        if (r6 != this.b) goto L20;
        return;
    L20:
        if ((r6 instanceof UIShadowProxy) == false) goto L22;
        r6 = ((UIShadowProxy) r6).a;
    L22:
        int r4 = 0;
        if (g(r6) == false) goto L38;
        Rect r5 = e(r6);
        if (this.i == true) goto L36;
        ArrayList r8 = (ArrayList) r7;
        Iterator r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L32;
        if (((Rect) r9.next()).contains(r5) == false) goto L28;
    L33:
        if (r1 == true) goto L35;
        this.c.add(new a(r6, r5));
    L35:
        r8.add(r5);
        goto L38
    L32:
        r1 = false;
        goto L33
    L36:
        this.c.add(new a(r6, r5));
    L38:
        if ((r6 instanceof LynxUI) == true) goto L40;
        return;
    L40:
        if (r6.mChildren.isEmpty() == false) goto L57;
        LynxUI r10 = (LynxUI) r6;
        if ((r10.getView() instanceof ViewGroup) == false) goto L58;
        ViewGroup r11 = (ViewGroup) r10.getView();
    L45:
        if (r4 >= r11.getChildCount()) goto L59;
        b(r11.getChildAt(r4));
        r4 = r4 + 1;
        goto L45
    L59:
        return;
    L58:
        return;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r3, int r4) {
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
        return r0;
    L5:
        String r5 = r3.toLowerCase();
        if (r4 != (-1)) goto L18;
        int r6 = 0;
    L9:
        if (r6 >= this.c.size()) goto L29;
        if (((a) ListProtector.get(this.c, r6)).a == null) goto L17;
        String r1 = c(((a) ListProtector.get(this.c, r6)).a);
        if (r1 == null) goto L17;
        if (r1.toString().toLowerCase().contains(r5) == false) goto L17;
        r0.add(createAccessibilityNodeInfo(r6));
    L17:
        r6 = r6 + 1;
    L29:
        return r0;
    L18:
        if (r4 <= 0) goto L29;
        if (r4 >= this.c.size()) goto L29;
        LynxBaseUI r2 = ((a) ListProtector.get(this.c, r4)).a;
        if (r2 == null) goto L29;
        String r7 = c(r2);
        if (r7 == null) goto L29;
        if (r7.toString().toLowerCase().contains(r5) == false) goto L29;
        r0.add(createAccessibilityNodeInfo(r4));
        goto L29
    }

    public final void i(int r7, MotionEvent r8) {
        int r9 = r8.getAction();
        if (this.f == true) goto L7;
        if (r9 == 9) goto L6;
        if (r9 == 7) goto L6;
    L10:
        if (r9 == 9) goto L14;
        if (r9 != 10) goto L17;
        this.d.setHovered(false);
        return;
    L17:
        return;
    L14:
        this.d.setHovered(true);
        return;
    L6:
        j(r7, LynxTouchEvent.kPseudoStateFocusTransition);
        this.f = true;
        goto L10
    L7:
        if (r9 == 10) goto L9;
        if (r9 != 7) goto L10;
    L9:
        this.f = false;
        j(r7, 256);
        goto L10
    }

    public final void j(int r3, int r4) {
        if (this.e.isTouchExplorationEnabled() == false) goto L18;
        AccessibilityEvent r5 = AccessibilityEvent.obtain(r4);
        if (r3 < 0) goto L19;
        a r0 = (a) ListProtector.get(this.c, r3);
        if (r0.a == null) goto L9;
        r5.setPackageName(this.d.getContext().getPackageName());
        r5.setClassName(r0.a.getClass().getName());
        r5.setEnabled(true);
        r5.setContentDescription(d(r0.a));
    L12:
        r5.setSource(this.d, r3);
        this.d.invalidate();
        if (this.d.getParent() != null) goto L16;
        LLog.e("LynxAccessibilityNodeProvider", "sendAccessibilityEventForLynxUI failed, parent is null.");
        return;
    L16:
        this.d.getParent().requestSendAccessibilityEvent(this.d, r5);
        return;
    L9:
        View r1 = r0.b;
        if (r1 == null) goto L20;
        r1.onInitializeAccessibilityEvent(r5);
        goto L12
    L20:
        return;
    L19:
        return;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int r9, int r10, Bundle r11) {
        LLog.i("LynxAccessibilityNodeProvider", "performAction on virtualViewId " + r9 + " action " + r10);
        if (r9 != (-1)) goto L5;
        return false;
    L5:
        if (r9 >= 0) goto L7;
    L38:
        return false;
    L7:
        if (r9 >= this.c.size()) goto L38;
        if (r10 != 16) goto L12;
        if (r9 < 0) goto L38;
        a r12 = (a) ListProtector.get(this.c, r9);
        LynxBaseUI r13 = r12.a;
        if (r13 == null) goto L38;
        if (r13.getLynxContext() == null) goto L38;
        if (r13.getLynxContext().getEventEmitter() == null) goto L38;
        if (r13.getAccessibilityEnableTap() == false) goto L38;
        Rect r14 = r12.c;
        LynxTouchEvent.a r7 = new LynxTouchEvent.a(r14.centerX(), r14.centerY());
        LynxTouchEvent.a r6 = new LynxTouchEvent.a(r14.centerX() - r14.left, r14.centerY() - r14.top);
        Map<String, EventsListener> r15 = r13.mEvents;
        if (r15 != null) goto L32;
    L37:
        return true;
    L32:
        if (r15.containsKey(LynxTouchEvent.EVENT_TAP) == false) goto L35;
        r13.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r13.getSign(), LynxTouchEvent.EVENT_TAP, r6, r6, r7));
        goto L37
    L35:
        if (r13.mEvents.containsKey(LynxTouchEvent.EVENT_CLICK) == false) goto L37;
        r13.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r13.getSign(), LynxTouchEvent.EVENT_CLICK, r6, r6, r7));
        goto L37
    L12:
        if (r10 != 64) goto L14;
        j(r9, 32768);
        j(r9, 4);
        return true;
    L14:
        if (r10 != 128) goto L38;
        j(r9, 65536);
        return true;
    }
}
