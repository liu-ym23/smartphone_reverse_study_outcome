package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxNodeProvider extends AccessibilityNodeProviderCompat {
    public final WeakReference<LynxAccessibilityDelegate> a;
    public final UIGroup b;
    public final View c;
    public final int d;
    public final int e;
    public boolean f;
    public final ArrayList<b> g;

    public class a implements Comparator {
        public final /* synthetic */ LynxBaseUI a;
        public final /* synthetic */ LynxNodeProvider b;

        public a(LynxNodeProvider r1, LynxBaseUI r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            Rect r6 = ((b) r4).b;
            Rect r7 = ((b) r5).b;
            if (this.a.isAccessibilityDirectionVertical() == false) goto L13;
            int r0 = r6.left - r7.left;
            int r1 = this.b.e;
            int r8 = r6.top;
            if (r1 != 0) goto L7;
            int r9 = r7.top;
        L8:
            int r10 = r8 - r9;
            if (r10 != 0) goto L12;
            return r0;
        L12:
            return r10;
        L7:
            r8 = r8 / r1;
            r9 = r7.top / r1;
            goto L8
        L13:
            int r2 = this.b.d;
            if (r2 != 0) goto L16;
            int r3 = r6.left - r7.left;
        L17:
            int r11 = r6.top - r7.top;
            if (r3 == 0) goto L20;
            return r3;
        L20:
            return r11;
        L16:
            r3 = (r6.left / r2) - (r7.left / r2);
            goto L17
        }
    }

    public static class b {
        public LynxBaseUI a;
        public Rect b;
        public boolean c;
        public boolean d;

        public b(LynxBaseUI r1, Rect r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final AccessibilityNodeInfoCompat b() {
        AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain(this.c);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.c, r0);
        c(this.b, this.g);
        if (r0.getChildCount() > 0) goto L5;
    L7:
        LLog.i("LynxA11yNodeProvider", "createNodeForHost with child count = " + this.g.size());
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= this.g.size()) goto L11;
        r0.addChild(this.c, r2);
        r2 = r2 + 1;
        goto L9
    L11:
        LynxBaseUI r3 = this.a.get().g;
        int r4 = this.a.get().c;
        if (r3 != null) goto L14;
    L27:
        return r0;
    L14:
        if (r3.getAccessibilityKeepFocused() == false) goto L27;
        if (r4 == (-1)) goto L27;
    L18:
        if (r1 >= this.g.size()) goto L27;
        LynxBaseUI r5 = ((b) ListProtector.get(this.g, r1)).a;
        if (r5 == null) goto L26;
        if (r5 != r3) goto L26;
        if (r1 == r4) goto L26;
        if (i(r5, new Rect()) == false) goto L26;
        performAction(r1, 64, null);
    L26:
        r1 = r1 + 1;
        goto L18
    L5:
        if (this.g.size() <= 0) goto L7;
        LLog.e("LynxA11yNodeProvider", "Views cannot have both real and virtual children, with real child count = " + r0.getChildCount() + "and virtual child count = " + this.g.size());
        goto L7
    }

    public LynxNodeProvider(LynxAccessibilityDelegate r3) {
        if (r3 == null) goto L6;
        LLog.i("LynxA11yNodeProvider", "Create LynxNodeProvider for " + r3.a);
        this.a = new WeakReference(r3);
        UIGroup r0 = r3.a;
        this.b = r0;
        this.c = r3.b;
        this.g = new ArrayList();
        this.d = r0.getLynxContext().getScreenMetrics().widthPixels / 50;
        this.e = r0.getLynxContext().getScreenMetrics().heightPixels / 50;
        return;
    }

    public static String f(LynxBaseUI r0) {
        CharSequence r1 = r0.getAccessibilityLabel();
        if (r1 != null) goto L6;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r1.toString();
    }

    public static Rect g(LynxBaseUI r5) {
        Rect r0 = new Rect();
        if ((r5 instanceof LynxUI) == false) goto L11;
        View r1 = ((LynxUI) r5).getView();
        if ((r5 instanceof UIShadowProxy) == false) goto L9;
        LynxBaseUI r2 = ((UIShadowProxy) r5).a;
        if ((r2 instanceof LynxUI) == false) goto L9;
        r1 = ((LynxUI) r2).getView();
    L9:
        h(r1, r0);
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
        r6 = ((UIGroup) r4).getAccessibilityHostView();
    L21:
        h(r6, r0);
        r0.offset(-r6.getScrollX(), -r6.getScrollY());
        r0.offset(r5.getLeft(), r5.getTop());
        int r7 = r0.left;
        r0.set(r7, r0.top, r5.getWidth() + r7, r0.top + r5.getHeight());
        goto L22
    }

    public final AccessibilityNodeInfoCompat a(int r8) {
        AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain();
        if (r8 != (-1)) goto L5;
    L51:
        LLog.e("LynxA11yNodeProvider", "createNodeForChild: check virtualViewId failed");
        return r0;
    L5:
        if (r8 >= this.g.size()) goto L51;
        r0.setEnabled(true);
        r0.setFocusable(true);
        r0.setClassName(this.b.getClass().getName());
        Rect r2 = d.p;
        r0.setBoundsInParent(r2);
        r0.setBoundsInScreen(r2);
        r0.setParent(this.c);
        r0.setSource(this.c, r8);
        r0.setPackageName(this.c.getContext().getPackageName());
        b r3 = (b) ListProtector.get(this.g, r8);
        LynxBaseUI r4 = r3.a;
        if (r4 == null) goto L50;
    L9:
        if (r4 == null) goto L20;
        if (r4 == this.b) goto L20;
        if ((r4 instanceof UIGroup) == false) goto L19;
        if (r4.isScrollContainer() == false) goto L19;
        View r5 = ((UIGroup) r4).getAccessibilityHostView();
        if (r5 == null) goto L19;
        r0.setParent(r5);
    L19:
        r4 = (LynxBaseUI) r4.getParent();
    L20:
        LynxBaseUI r6 = r3.a;
        if (k(r6) == true) goto L23;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
    L30:
        r0.setText(r7);
        r0.setContentDescription(r7);
        r0.setClassName(r3.a.getClass().getName());
        LynxBaseUI r9 = r3.a;
        if (r9 != null) goto L33;
    L39:
        boolean r10 = false;
    L40:
        r0.setClickable(r10);
        if (r3.a.getAccessibilityEnableTap() == false) goto L43;
        r0.addAction(16);
    L43:
        r0.setBoundsInParent(r3.a.getBoundingClientRect());
        Rect r11 = new Rect();
        boolean r12 = i(r3.a, r11);
        r0.setVisibleToUser(r12);
        if (r12 == false) goto L47;
        r0.setBoundsInScreen(r11);
    L47:
        if (this.a.get().c != r8) goto L49;
        r0.setAccessibilityFocused(true);
        r0.addAction(LynxTouchEvent.kPseudoStateFocusTransition);
        goto L50
    L49:
        r0.setAccessibilityFocused(false);
        r0.addAction(64);
        goto L50
    L33:
        if (r9.getEvents() == null) goto L39;
        if (r9.getEvents().containsKey(LynxTouchEvent.EVENT_CLICK) == false) goto L37;
    L38:
        r10 = true;
        goto L40
    L37:
        if (r9.getEvents().containsKey(LynxTouchEvent.EVENT_TAP) == false) goto L39;
    L23:
        String r13 = f(r6);
        if (TextUtils.isEmpty(r13) == false) goto L29;
        Iterator<LynxBaseUI> r14 = r6.getChildren().iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        r13 = r13 + f(r14.next());
    L29:
        r7 = r13.toString();
    L50:
        return r0;
    }

    public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r5) {
        if ((-1) == r5) goto L5;
        AccessibilityNodeInfoCompat r1 = AccessibilityNodeInfoCompat.obtain(a(r5));     // Catch: Exception -> L19
        if (r5 != (-1)) goto L9;
    L18:
        return r1;
    L9:
        if (r5 >= this.g.size()) goto L18;
        b r0 = (b) ListProtector.get(this.g, r5);     // Catch: Exception -> L19
        if (r0 == null) goto L18;
        LynxBaseUI r2 = r0.a;     // Catch: Exception -> L19
        if ((r2 instanceof LynxUI) == false) goto L18;
        if (((LynxUI) r2).getView() == null) goto L18;
        ViewCompat.setImportantForAccessibility(((LynxUI) r0.a).getView(), 2);     // Catch: Exception -> L19
        goto L18
    L5:
        return AccessibilityNodeInfoCompat.obtain(b());
    L19:
        e = move-exception;
        LLog.e("LynxA11yNodeProvider", "createAccessibilityNodeInfo with virtual view id = " + r5 + " with virtual children size = " + this.g.size() + ", and exception msg = " + e.getMessage());
        return AccessibilityNodeInfoCompat.obtain();
    }

    public final int e(LynxBaseUI r4) {
        if (r4 == null) goto L13;
        ArrayList<b> r1 = this.g;
        if (r1 == null) goto L13;
        int r2 = r1.size() - 1;
    L8:
        if (r2 < 0) goto L13;
        if (((b) ListProtector.get(this.g, r2)).a == r4) goto L11;
        r2 = r2 - 1;
        goto L8
    L11:
        return r2;
    L13:
        return -1;
    }

    public final boolean k(LynxBaseUI r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getAccessibilityElementStatus() != (-1)) goto L12;
        if (this.a.get() == null) goto L12;
        return this.a.get().f;
    L12:
        if (r4.getAccessibilityElementStatus() != 1) goto L15;
        return true;
    L15:
        return false;
    }

    public static void h(View r3, Rect r4) {
        r4.set(0, 0, r3.getRight() - r3.getLeft(), r3.getBottom() - r3.getTop());
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r0);
        r4.offset(r0[0], r0[1]);
    }

    public final void c(LynxBaseUI r8, ArrayList<b> r9) {
        if (r8 == null) goto L104;
        if (r9 == null) goto L105;
        r9.clear();
        d(r8, r9);
        Collections.sort(r9, new a(this, r8));
        if (this.f == false) goto L39;
        ArrayList<b> r0 = new ArrayList();
        Iterator<b> r1 = r9.iterator();
    L8:
        boolean r3 = false;
        if (r1.hasNext() == false) goto L38;
        b r2 = r1.next();
        LynxBaseUI r4 = r2.a;
        if (r4 == null) goto L37;
        if (r2.c == false) goto L37;
        ArrayList<String> r5 = r4.getAccessibilityElementsA11y();
        if (r5 != null) goto L17;
        r5 = r2.a.getAccessibilityElements();
    L18:
        if (r5 == null) goto L8;
        if (this.b.getLynxContext() == null) goto L8;
        if (this.b.getLynxContext().getLynxUIOwner() == null) goto L8;
        LynxUIOwner r6 = this.b.getLynxContext().getLynxUIOwner();
        Iterator<String> r7 = r5.iterator();
    L25:
        if (r7.hasNext() == false) goto L8;
        String r10 = r7.next();
        if (r3 == false) goto L29;
        LynxBaseUI r11 = r6.findLynxUIByA11yId(r10);
    L30:
        if (r11 == null) goto L25;
        if ((r11 instanceof LynxUI) == false) goto L36;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r11).getView()) == false) goto L25;
    L36:
        j(r11, r0);
        goto L25
    L29:
        r11 = r6.findLynxUIByIdSelector(r10);
        goto L30
    L17:
        r3 = true;
    L37:
        r0.add(r2);
        goto L8
    L38:
        r9.clear();
        r9.addAll(r0);
        this.f = false;
    L39:
        boolean r12 = r8 instanceof UIList;
        if (r12 == false) goto L48;
        Iterator<ArrayList<b>> r13 = ((UIList) r8).C.values().iterator();
    L43:
        if (r13.hasNext() == false) goto L48;
        Iterator<b> r14 = r13.next().iterator();
    L46:
        if (r14.hasNext() == false) goto L43;
        b r15 = r14.next();
        r15.a = null;
        r15.b = d.p;
    L48:
        ArrayList r16 = new ArrayList();
        Iterator<b> r17 = r9.iterator();
    L50:
        if (r17.hasNext() == false) goto L63;
        b r18 = r17.next();
        if (r18.d == true) goto L53;
        r16.add(r18);
        goto L50
    L53:
        ArrayList<b> r19 = new ArrayList();
        c(r18.a, r19);
        LynxBaseUI r20 = r18.a;
        if ((r20 instanceof UIComponent) == false) goto L61;
        if ((r20.getParent() instanceof UIList) == false) goto L61;
        UIComponent r21 = (UIComponent) r20;
        UIList r22 = (UIList) r20.getParent();
        String r23 = r21.b;
        if (r22.C.containsKey(r23) == true) goto L60;
        r22.B.add(r23);
    L60:
        r22.C.put(r23, r19);
    L61:
        r16.addAll(r19);
        goto L50
    L63:
        r9.clear();
        if (r12 == false) goto L69;
        UIList r24 = (UIList) r8;
        Iterator<String> r25 = r24.B.iterator();
    L67:
        if (r25.hasNext() == false) goto L69;
        String r26 = r25.next();
        r16.addAll(r24.C.get(r26));
    L69:
        r9.addAll(r16);
        return;
    L105:
        return;
    }

    public final void d(LynxBaseUI r6, ArrayList<b> r7) {
        if (r7 == null) goto L36;
        if (r6 != null) goto L5;
        return;
    L5:
        if ((r6 instanceof LynxUI) == false) goto L9;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r6).getView()) == true) goto L9;
        return;
    L9:
        if ((r6 instanceof com.lynx.tasm.behavior.ui.d) == true) goto L39;
        ArrayList<String> r0 = r6.getAccessibilityElements();
        ArrayList<String> r1 = r6.getAccessibilityElementsA11y();
        if (r0 != null) goto L30;
        if (r1 != null) goto L30;
        int r2 = r6.getChildren().size() - 1;
    L16:
        if (r2 < 0) goto L28;
        LynxBaseUI r3 = (LynxBaseUI) ListProtector.get(r6.getChildren(), r2);
        boolean r4 = r3 instanceof LynxUI;
        if (r4 == true) goto L20;
    L22:
        if (r4 == true) goto L24;
    L26:
        d(r3, r7);
    L27:
        r2 = r2 - 1;
        goto L16
    L24:
        if (r3.isAccessibilityHostUI() == false) goto L26;
        b r5 = new b(r3, g(r3));
        r5.d = true;
        r7.add(r5);
        goto L27
    L20:
        if (ViewCompat.isAttachedToWindow(((LynxUI) r3).getView()) == true) goto L22;
    L28:
        j(r6, r7);
        return;
    L30:
        b r8 = new b(r6, g(r6));
        r8.c = true;
        r7.add(r8);
        this.f = true;
        return;
    L39:
        return;
    }

    public final List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r3, int r4) {
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
        return r0;
    L5:
        String r5 = r3.toLowerCase();
        if (r4 != (-1)) goto L18;
        int r6 = 0;
    L9:
        if (r6 >= this.g.size()) goto L28;
        if (((b) ListProtector.get(this.g, r6)).a == null) goto L17;
        String r1 = f(((b) ListProtector.get(this.g, r6)).a);
        if (r1 == null) goto L17;
        if (r1.toString().toLowerCase().contains(r5) == false) goto L17;
        r0.add(createAccessibilityNodeInfo(r6));
    L17:
        r6 = r6 + 1;
    L28:
        return r0;
    L18:
        if (r4 <= (-1)) goto L28;
        if (r4 >= this.g.size()) goto L28;
        LynxBaseUI r2 = ((b) ListProtector.get(this.g, r4)).a;
        if (r2 == null) goto L28;
        String r7 = f(r2);
        if (r7 == null) goto L28;
        if (r7.toString().toLowerCase().contains(r5) == false) goto L28;
        r0.add(createAccessibilityNodeInfo(r4));
        goto L28
    }

    public final boolean i(LynxBaseUI r9, Rect r10) {
        if (r9 != null) goto L5;
        return false;
    L5:
        Rect r1 = new Rect();
        if ((r9 instanceof LynxUI) == false) goto L17;
        View r2 = ((LynxUI) r9).getView();
        if ((r9 instanceof UIShadowProxy) == false) goto L13;
        LynxBaseUI r3 = ((UIShadowProxy) r9).a;
        if ((r3 instanceof LynxUI) == false) goto L13;
        r2 = ((LynxUI) r3).getView();
    L13:
        if (r2.getGlobalVisibleRect(r10) == false) goto L36;
        int[] r11 = new int[2];
        r2.getLocationOnScreen(r11);
        r10.offset(r11[0] - r10.left, r11[1] - r10.top);
        return true;
    L36:
        r10.set(0, 0, r9.getWidth(), r9.getHeight());
        return false;
    L17:
        if ((r9 instanceof LynxFlattenUI) == false) goto L36;
        LynxBaseUI r4 = r9;
    L20:
        if ((r4 instanceof LynxFlattenUI) == false) goto L24;
        if (r4 == this.b) goto L24;
        r1.left += r4.getOriginLeft();
        r1.top += r4.getOriginTop();
        r4 = r4.getParentBaseUI();
    L24:
        if (r4 == null) goto L36;
        if ((r4 instanceof LynxUI) == false) goto L36;
        View r5 = ((LynxUI) r4).getView();
        if ((r4 instanceof UIGroup) == false) goto L30;
        r5 = ((UIGroup) r4).getAccessibilityHostView();
    L30:
        Rect r6 = new Rect();
        int[] r7 = new int[2];
        if (r5.getLocalVisibleRect(r6) == false) goto L36;
        r1.right = r1.left + r9.getWidth();
        r1.bottom = r1.top + r9.getHeight();
        if (r1.intersect(r6) == false) goto L36;
        r5.getLocationOnScreen(r7);
        r10.set(r1);
        r10.offset(r7[0] - r5.getScrollX(), r7[1] - r5.getScrollY());
        return true;
    }

    public final void j(LynxBaseUI r3, ArrayList<b> r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3 != this.b) goto L6;
        return;
    L6:
        if ((r3 instanceof UIShadowProxy) == false) goto L9;
        r3 = ((UIShadowProxy) r3).a;
    L9:
        if (k(r3) == false) goto L14;
        r4.add(new b(r3, g(r3)));
        return;
    }

    public final boolean performAction(int r13, int r14, Bundle r15) {
        boolean r0 = false;
        if (r13 >= (-1)) goto L5;
    L61:
        LLog.e("LynxA11yNodeProvider", "performAction: check virtualViewId failed");
        return false;
    L5:
        if (r13 >= this.g.size()) goto L61;
        WeakReference<LynxAccessibilityDelegate> r2 = this.a;
        if (r2 != null) goto L10;
    L60:
        return false;
    L10:
        if (r2.get() == null) goto L60;
        LynxAccessibilityDelegate r3 = this.a.get();
        if (r13 == (-1)) goto L59;
        LynxBaseUI r1 = ((b) ListProtector.get(this.g, r13)).a;
        r3.getClass();
        if (r14 != 16) goto L16;
        if (r13 < 0) goto L69;
        b r16 = (b) ListProtector.get(r3.e.g, r13);
        LynxBaseUI r17 = r16.a;
        if (r17 != null) goto L43;
        return false;
    L43:
        if (r17.getLynxContext() != null) goto L45;
        return false;
    L45:
        if (r17.getLynxContext().getEventEmitter() != null) goto L47;
        return false;
    L47:
        if (r17.getAccessibilityEnableTap() == false) goto L73;
        Rect r18 = r16.b;
        LynxTouchEvent.a r19 = new LynxTouchEvent.a(r18.centerX(), r18.centerY());
        LynxTouchEvent.a r4 = new LynxTouchEvent.a(r18.centerX() - r18.left, r18.centerY() - r18.top);
        if (r17.getEvents() == null) goto L56;
        Map<String, EventsListener> r110 = r17.getEvents();
        if (r110.containsKey(LynxTouchEvent.EVENT_TAP) == false) goto L54;
        r17.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r17.getSign(), LynxTouchEvent.EVENT_TAP, r4, r4, r19));
    L54:
        if (r110.containsKey(LynxTouchEvent.EVENT_CLICK) == false) goto L56;
        r17.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r17.getSign(), LynxTouchEvent.EVENT_CLICK, r4, r4, r19));
    L56:
        return true;
    L73:
        return false;
    L69:
        return false;
    L16:
        if (r14 == 64) goto L68;
        if (r14 == 128) goto L36;
        if (r14 != 16908342) goto L74;
        if (r1 != null) goto L25;
        return false;
    L25:
        if ((r1 instanceof LynxUI) == false) goto L28;
        return ((LynxUI) r1).getView().performAccessibilityAction(r14, r15);
    L28:
        if ((r1 instanceof LynxFlattenUI) == false) goto L66;
        LynxBaseUI r111 = r1.getParentBaseUI();
        Rect r112 = new Rect(0, 0, r1.getWidth(), r1.getHeight());
        Rect r113 = new Rect();
    L30:
        LynxBaseUI r11 = r1;
        r1 = r111;
        if (r1 == null) goto L77;
        if (r1 == r3.a) goto L76;
        r113.set(r112);
        r0 = r0 | r1.requestChildUIRectangleOnScreen(r11, r113, true);
        r112.offset(r11.getOriginLeft() - r11.getScrollX(), r11.getOriginTop() - r11.getScrollY());
        r111 = r1.getParentBaseUI();
        goto L30
    L76:
        return r0;
    L77:
        return r0;
    L66:
        return false;
    L74:
        return false;
    L36:
        if (r3.c != r13) goto L67;
        r3.c = Integer.MIN_VALUE;
        r3.b.invalidate();
        r3.g = null;
        r3.sendEventForVirtualView(r13, 65536);
        goto L56
    L67:
        return false;
    L68:
        return r3.requestAccessibilityFocus(r13);
    L59:
        return ViewCompat.performAccessibilityAction(r3.b, r14, r15);
    }
}
