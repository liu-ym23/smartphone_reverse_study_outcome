package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.n;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import on.g;
import on.h;

/* JADX INFO: loaded from: classes2.dex */
public class LynxNodeProvider extends AccessibilityNodeProviderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UIGroup f10400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f10401c;
    public final int d;
    public final int e;
    public boolean f;
    public final ArrayList g;

    public LynxNodeProvider(LynxAccessibilityDelegate r5) {
        if (r5 == null) goto L6;
        StringBuilder r10 = new StringBuilder("Create LynxNodeProvider for ");
        UIGroup r11 = r5.f10394a;
        r10.append(r11);
        LynxLog.b(2, "LynxA11yNodeProvider", r10.toString());
        this.f10399a = new WeakReference(r5);
        this.f10400b = r11;
        this.f10401c = r5.f10395b;
        this.g = new ArrayList();
        this.d = r11.getLynxContext().f10152u.widthPixels / 50;
        this.e = r11.getLynxContext().f10152u.heightPixels / 50;
        return;
    }

    public static Rect a(LynxBaseUI r10) {
        Rect r5 = new Rect();
        if ((r10 instanceof LynxUI) == false) goto L12;
        View r11 = ((LynxUI) r10).getView();
        if ((r10 instanceof UIShadowProxy) == false) goto L9;
        LynxBaseUI r12 = ((UIShadowProxy) r10).f10388a;
        if ((r12 instanceof LynxUI) == false) goto L9;
        r11 = ((LynxUI) r12).getView();
    L9:
        r5.set(0, 0, r11.getRight() - r11.getLeft(), r11.getBottom() - r11.getTop());
        int[] r13 = new int[2];
        r11.getLocationOnScreen(r13);
        r5.offset(r13[0], r13[1]);
        int r14 = r5.left;
        int r15 = r5.top;
        int r16 = r10.getWidth() + r14;
        int r17 = r5.top;
        r5.set(r14, r15, r16, r10.getHeight() + r17);
        return r5;
    L12:
        if ((r10 instanceof LynxFlattenUI) == false) goto L23;
        LynxBaseUI r18 = r10.getParentBaseUI();
    L14:
        if (r18 == null) goto L18;
        if ((r18 instanceof LynxUI) == true) goto L18;
        r18 = r18.getParentBaseUI();
    L18:
        if (r18 == null) goto L23;
        View r19 = ((LynxUI) r18).getView();
        if ((r18 instanceof UIGroup) == false) goto L22;
        r19 = ((UIGroup) r18).getAccessibilityHostView();
    L22:
        r5.set(0, 0, r19.getRight() - r19.getLeft(), r19.getBottom() - r19.getTop());
        int[] r20 = new int[2];
        r19.getLocationOnScreen(r20);
        r5.offset(r20[0], r20[1]);
        r5.offset(-r19.getScrollX(), -r19.getScrollY());
        r5.offset(r10.getLeft(), r10.getTop());
        int r21 = r5.left;
        int r22 = r5.top;
        int r23 = r10.getWidth() + r21;
        int r24 = r5.top;
        r5.set(r21, r22, r23, r10.getHeight() + r24);
    L23:
        return r5;
    }

    public final AccessibilityNodeInfoCompat b() {
        View r5 = this.f10401c;
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.obtain(r5);
        ViewCompat.onInitializeAccessibilityNodeInfo(r5, r10);
        ArrayList r11 = this.g;
        d(this.f10400b, r11);
        if (r10.getChildCount() > 0) goto L5;
    L7:
        LynxLog.b(2, "LynxA11yNodeProvider", "createNodeForHost with child count = " + r11.size());
        int r12 = 0;
        int r13 = 0;
    L9:
        if (r13 >= r11.size()) goto L11;
        r10.addChild(r5, r13);
        r13 = r13 + 1;
        goto L9
    L11:
        WeakReference r14 = this.f10399a;
        LynxBaseUI r15 = ((LynxAccessibilityDelegate) r14.get()).g;
        int r16 = ((LynxAccessibilityDelegate) r14.get()).f10396c;
        if (r15 != null) goto L14;
    L27:
        return r10;
    L14:
        if (r15.getAccessibilityKeepFocused() == false) goto L27;
        if (r16 == (-1)) goto L27;
    L18:
        if (r12 >= r11.size()) goto L27;
        LynxBaseUI r17 = ((f) r11.get(r12)).f10418a;
        if (r17 == null) goto L26;
        if (r17 != r15) goto L26;
        if (r12 == r16) goto L26;
        if (e(r17, new Rect()) == false) goto L26;
        performAction(r12, 64, null);
    L26:
        r12 = r12 + 1;
        goto L18
    L5:
        if (r11.size() <= 0) goto L7;
        LynxLog.b(4, "LynxA11yNodeProvider", "Views cannot have both real and virtual children, with real child count = " + r10.getChildCount() + "and virtual child count = " + r11.size());
        goto L7
    }

    public final AccessibilityNodeInfoCompat c(int r10) {
        AccessibilityNodeInfoCompat r5 = AccessibilityNodeInfoCompat.obtain();
        if (r10 == (-1)) goto L57;
        ArrayList r11 = this.g;
        if (r10 >= r11.size()) goto L57;
        r5.setEnabled(true);
        r5.setFocusable(true);
        UIGroup r12 = this.f10400b;
        r5.setClassName(r12.getClass().getName());
        Rect r13 = d.f10404p;
        r5.setBoundsInParent(r13);
        r5.setBoundsInScreen(r13);
        View r14 = this.f10401c;
        r5.setParent(r14);
        r5.setSource(r14, r10);
        r5.setPackageName(r14.getContext().getPackageName());
        f r15 = (f) r11.get(r10);
        LynxBaseUI r16 = r15.f10418a;
        if (r16 == null) goto L56;
    L9:
        if (r16 == null) goto L19;
        if (r16 == r12) goto L19;
        if ((r16 instanceof UIGroup) == false) goto L18;
        if (r16.isScrollContainer() == false) goto L18;
        View r17 = ((UIGroup) r16).getAccessibilityHostView();
        if (r17 == null) goto L18;
        r5.setParent(r17);
    L18:
        r16 = (LynxBaseUI) r16.getParent();
    L19:
        LynxBaseUI r18 = r15.f10418a;
        String r19 = "";
        if (g(r18) == false) goto L35;
        CharSequence r20 = r18.getAccessibilityLabel();
        if (r20 != null) goto L25;
        r20 = "";
    L25:
        String r21 = r20.toString();
        if (TextUtils.isEmpty(r21) == false) goto L34;
        Iterator<LynxBaseUI> r22 = r18.getChildren().iterator();
    L29:
        if (r22.hasNext() == false) goto L34;
        LynxBaseUI r23 = r22.next();
        StringBuilder r24 = new StringBuilder();
        r24.append(r21);
        CharSequence r25 = r23.getAccessibilityLabel();
        if (r25 != null) goto L33;
        r25 = "";
    L33:
        r24.append(r25.toString());
        r21 = r24.toString();
    L34:
        r19 = r21.toString();
    L35:
        r5.setText(r19);
        r5.setContentDescription(r19);
        r5.setClassName(r15.f10418a.getClass().getName());
        LynxBaseUI r26 = r15.f10418a;
        if (r26 != null) goto L38;
    L44:
        boolean r27 = false;
    L45:
        r5.setClickable(r27);
        if (r15.f10418a.getAccessibilityEnableTap() == false) goto L48;
        r5.addAction(16);
    L48:
        r5.setBoundsInParent(r15.f10418a.getBoundingClientRect());
        Rect r28 = new Rect();
        boolean r29 = e(r15.f10418a, r28);
        r5.setVisibleToUser(r29);
        if (r29 == false) goto L52;
        r5.setBoundsInScreen(r28);
    L52:
        if (((LynxAccessibilityDelegate) this.f10399a.get()).f10396c != r10) goto L55;
        r5.setAccessibilityFocused(true);
        r5.addAction(128);
        return r5;
    L55:
        r5.setAccessibilityFocused(false);
        r5.addAction(64);
        goto L56
    L38:
        if (r26.getEvents() == null) goto L44;
        if (r26.getEvents().containsKey("click") == false) goto L42;
    L43:
        r27 = true;
        goto L45
    L42:
        if (r26.getEvents().containsKey("tap") == false) goto L44;
    L56:
        return r5;
    L57:
        LynxLog.b(4, "LynxA11yNodeProvider", "createNodeForChild: check virtualViewId failed");
        return r5;
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r5) {
        ArrayList r10 = this.g;
        if ((-1) == r5) goto L5;
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.obtain(c(r5));     // Catch: Exception -> L6
        if (r5 != (-1)) goto L11;
    L20:
        return r11;
    L11:
        if (r5 >= r10.size()) goto L20;
        f r12 = (f) r10.get(r5);     // Catch: Exception -> L6
        if (r12 == null) goto L20;
        LynxBaseUI r13 = r12.f10418a;     // Catch: Exception -> L6
        if ((r13 instanceof LynxUI) == false) goto L20;
        if (((LynxUI) r13).getView() == null) goto L20;
        ViewCompat.setImportantForAccessibility(((LynxUI) r12.f10418a).getView(), 2);     // Catch: Exception -> L6
        goto L20
    L5:
        return AccessibilityNodeInfoCompat.obtain(b());
    L6:
        e = move-exception;
        StringBuilder r14 = p.d(r5, "createAccessibilityNodeInfo with virtual view id = ", " with virtual children size = ");
        r14.append(r10.size());
        r14.append(", and exception msg = ");
        r14.append(e.getMessage());
        LynxLog.b(4, "LynxA11yNodeProvider", r14.toString());
        return AccessibilityNodeInfoCompat.obtain();
    }

    public final void d(LynxBaseUI r10, ArrayList r11) {
        if (r10 == null) goto L114;
        if (r11 == null) goto L115;
        r11.clear();
        f(r10, r11);
        Collections.sort(r11, new e(this, r10));
        if (this.f == false) goto L45;
        ArrayList r5 = new ArrayList();
        Iterator r12 = r11.iterator();
    L8:
        boolean r13 = false;
        if (r12.hasNext() == false) goto L44;
        f r14 = (f) r12.next();
        LynxBaseUI r15 = r14.f10418a;
        if (r15 == null) goto L43;
        if (r14.f10420c == false) goto L43;
        ArrayList<String> r16 = r15.getAccessibilityElementsA11y();
        if (r16 != null) goto L17;
        r16 = r14.f10418a.getAccessibilityElements();
    L18:
        if (r16 == null) goto L8;
        UIGroup r17 = this.f10400b;
        if (r17.getLynxContext() == null) goto L8;
        if (((n0) r17.getLynxContext().f10147o.get()) == null) goto L8;
        n0 r18 = (n0) r17.getLynxContext().f10147o.get();
        Iterator<String> r19 = r16.iterator();
    L25:
        if (r19.hasNext() == false) goto L8;
        String r20 = r19.next();
        if (r13 == false) goto L29;
        LynxBaseUI r21 = r18.w(r20);
    L30:
        if (r21 == null) goto L25;
        if ((r21 instanceof LynxUI) == false) goto L36;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r21).getView()) == false) goto L25;
    L36:
        if (r21 == r17) goto L25;
        if ((r21 instanceof UIShadowProxy) == false) goto L41;
        r21 = ((UIShadowProxy) r21).f10388a;
    L41:
        if (g(r21) == false) goto L25;
        r5.add(new f(r21, a(r21)));
        goto L25
    L29:
        r21 = r18.E(r20);
        goto L30
    L17:
        r13 = true;
    L43:
        r5.add(r14);
        goto L8
    L44:
        r11.clear();
        r11.addAll(r5);
        this.f = false;
    L45:
        boolean r22 = r10 instanceof UIList;
        if (r22 == false) goto L54;
        Iterator r23 = ((UIList) r10).f10526x.values().iterator();
    L49:
        if (r23.hasNext() == false) goto L54;
        Iterator r24 = ((ArrayList) r23.next()).iterator();
    L52:
        if (r24.hasNext() == false) goto L49;
        f r25 = (f) r24.next();
        r25.f10418a = null;
        r25.f10419b = d.f10404p;
    L54:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r11.iterator();
    L56:
        if (r27.hasNext() == false) goto L69;
        f r28 = (f) r27.next();
        if (r28.d == true) goto L59;
        r26.add(r28);
        goto L56
    L59:
        ArrayList r29 = new ArrayList();
        d(r28.f10418a, r29);
        LynxBaseUI r30 = r28.f10418a;
        if ((r30 instanceof UIComponent) == false) goto L67;
        if ((r30.getParent() instanceof UIList) == false) goto L67;
        UIComponent r31 = (UIComponent) r30;
        UIList r32 = (UIList) r30.getParent();
        String r33 = r31.f10770b;
        if (r32.f10526x.containsKey(r33) == true) goto L66;
        r32.f10525w.add(r33);
    L66:
        r32.f10526x.put(r33, r29);
    L67:
        r26.addAll(r29);
        goto L56
    L69:
        r11.clear();
        if (r22 == false) goto L75;
        UIList r110 = (UIList) r10;
        Iterator r34 = r110.f10525w.iterator();
    L73:
        if (r34.hasNext() == false) goto L75;
        String r35 = (String) r34.next();
        r26.addAll((Collection) r110.f10526x.get(r35));
    L75:
        r11.addAll(r26);
        return;
    L115:
        return;
    }

    public final boolean e(LynxBaseUI r10, Rect r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Rect r5 = new Rect();
        if ((r10 instanceof LynxUI) == false) goto L17;
        View r12 = ((LynxUI) r10).getView();
        if ((r10 instanceof UIShadowProxy) == false) goto L13;
        LynxBaseUI r13 = ((UIShadowProxy) r10).f10388a;
        if ((r13 instanceof LynxUI) == false) goto L13;
        r12 = ((LynxUI) r13).getView();
    L13:
        if (r12.getGlobalVisibleRect(r11) == false) goto L36;
        int[] r14 = new int[2];
        r12.getLocationOnScreen(r14);
        r11.offset(r14[0] - r11.left, r14[1] - r11.top);
        return true;
    L36:
        r11.set(0, 0, r10.getWidth(), r10.getHeight());
        return false;
    L17:
        if ((r10 instanceof LynxFlattenUI) == false) goto L36;
        LynxBaseUI r15 = r10;
    L20:
        if ((r15 instanceof LynxFlattenUI) == false) goto L24;
        if (r15 == this.f10400b) goto L24;
        int r16 = r5.left;
        r5.left = r15.getOriginLeft() + r16;
        int r17 = r5.top;
        r5.top = r15.getOriginTop() + r17;
        r15 = r15.getParentBaseUI();
    L24:
        if (r15 == null) goto L36;
        if ((r15 instanceof LynxUI) == false) goto L36;
        View r18 = ((LynxUI) r15).getView();
        if ((r15 instanceof UIGroup) == false) goto L30;
        r18 = ((UIGroup) r15).getAccessibilityHostView();
    L30:
        Rect r19 = new Rect();
        int[] r20 = new int[2];
        if (r18.getLocalVisibleRect(r19) == false) goto L36;
        int r21 = r5.left;
        r5.right = r10.getWidth() + r21;
        int r22 = r5.top;
        r5.bottom = r10.getHeight() + r22;
        if (r5.intersect(r19) == false) goto L36;
        r18.getLocationOnScreen(r20);
        r11.set(r5);
        r11.offset(r20[0] - r18.getScrollX(), r20[1] - r18.getScrollY());
        return true;
    }

    public final void f(LynxBaseUI r10, ArrayList r11) {
        if (r11 == null) goto L43;
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof LynxUI) == false) goto L9;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r10).getView()) == true) goto L9;
        return;
    L9:
        if ((r10 instanceof n) == true) goto L48;
        ArrayList<String> r5 = r10.getAccessibilityElements();
        ArrayList<String> r12 = r10.getAccessibilityElementsA11y();
        if (r5 != null) goto L37;
        if (r12 != null) goto L37;
        int r13 = r10.getChildren().size() - 1;
    L16:
        if (r13 < 0) goto L29;
        LynxBaseUI r14 = r10.getChildren().get(r13);
        boolean r15 = r14 instanceof LynxUI;
        if (r15 == true) goto L20;
    L22:
        if (r15 == true) goto L24;
    L26:
        f(r14, r11);
    L27:
        r13 = r13 - 1;
        goto L16
    L24:
        if (r14.isAccessibilityHostUI() == false) goto L26;
        f r16 = new f(r14, a(r14));
        r16.d = true;
        r11.add(r16);
        goto L27
    L20:
        if (ViewCompat.isAttachedToWindow(((LynxUI) r14).getView()) == true) goto L22;
    L29:
        if (r10 != this.f10400b) goto L31;
        return;
    L31:
        if ((r10 instanceof UIShadowProxy) == false) goto L34;
        r10 = ((UIShadowProxy) r10).f10388a;
    L34:
        if (g(r10) == false) goto L47;
        r11.add(new f(r10, a(r10)));
        return;
    L47:
        return;
    L37:
        f r17 = new f(r10, a(r10));
        r17.f10420c = true;
        r11.add(r17);
        this.f = true;
        return;
    L48:
        return;
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final List findAccessibilityNodeInfosByText(String r5, int r10) {
        ArrayList r11 = new ArrayList();
        if (r5 == null) goto L35;
        String r12 = r5.toLowerCase();
        CharSequence r13 = "";
        ArrayList r14 = this.g;
        if (r10 != (-1)) goto L21;
        int r15 = 0;
    L9:
        if (r15 >= r14.size()) goto L35;
        if (((f) r14.get(r15)).f10418a == null) goto L20;
        CharSequence r16 = ((f) r14.get(r15)).f10418a.getAccessibilityLabel();
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
        if (r10 <= (-1)) goto L35;
        if (r10 >= r14.size()) goto L35;
        LynxBaseUI r18 = ((f) r14.get(r10)).f10418a;
        if (r18 == null) goto L35;
        CharSequence r19 = r18.getAccessibilityLabel();
        if (r19 == null) goto L30;
        r13 = r19;
    L30:
        String r20 = r13.toString();
        if (r20 == null) goto L35;
        if (r20.toString().toLowerCase().contains(r12) == false) goto L35;
        r11.add(createAccessibilityNodeInfo(r10));
    L35:
        return r11;
    }

    public final boolean g(LynxBaseUI r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getAccessibilityElementStatus() != (-1)) goto L12;
        WeakReference r10 = this.f10399a;
        if (r10.get() == null) goto L12;
        return ((LynxAccessibilityDelegate) r10.get()).f;
    L12:
        if (r5.getAccessibilityElementStatus() != 1) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final boolean performAction(int r12, int r13, Bundle r14) {
        boolean r5 = false;
        if (r12 < (-1)) goto L61;
        ArrayList r10 = this.g;
        if (r12 >= r10.size()) goto L61;
        WeakReference r11 = this.f10399a;
        if (r11 != null) goto L10;
    L60:
        return false;
    L10:
        if (r11.get() == null) goto L60;
        LynxAccessibilityDelegate r15 = (LynxAccessibilityDelegate) r11.get();
        if (r12 == (-1)) goto L59;
        LynxBaseUI r16 = ((f) r10.get(r12)).f10418a;
        r15.getClass();
        if (r13 != 16) goto L16;
        if (r12 < 0) goto L69;
        f r17 = (f) r15.e.g.get(r12);
        LynxBaseUI r18 = r17.f10418a;
        if (r18 != null) goto L44;
        return false;
    L44:
        if (r18.getLynxContext() != null) goto L46;
        return false;
    L46:
        if (r18.getLynxContext().g != null) goto L48;
        return false;
    L48:
        if (r18.getAccessibilityEnableTap() == false) goto L73;
        Rect r19 = r17.f10419b;
        g r110 = new g(r19.centerX(), r19.centerY());
        g r111 = new g(r19.centerX() - r19.left, r19.centerY() - r19.top);
        if (r18.getEvents() == null) goto L67;
        Map<String, on.a> r112 = r18.getEvents();
        if (r112.containsKey("tap") == false) goto L55;
        r18.getLynxContext().g.d(new h(r18.getSign(), "tap", r111, r111, r110));
    L55:
        if (r112.containsKey("click") == false) goto L67;
        r18.getLynxContext().g.d(new h(r18.getSign(), "click", r111, r111, r110));
    L67:
        return true;
    L73:
        return false;
    L69:
        return false;
    L16:
        if (r13 == 64) goto L68;
        if (r13 == 128) goto L36;
        if (r13 != 16908342) goto L74;
        if (r16 != null) goto L25;
        return false;
    L25:
        if ((r16 instanceof LynxUI) == false) goto L28;
        return ((LynxUI) r16).getView().performAccessibilityAction(r13, r14);
    L28:
        if ((r16 instanceof LynxFlattenUI) == false) goto L65;
        LynxBaseUI r113 = r16.getParentBaseUI();
        Rect r114 = new Rect(0, 0, r16.getWidth(), r16.getHeight());
        Rect r115 = new Rect();
    L30:
        LynxBaseUI r116 = r16;
        r16 = r113;
        if (r16 == null) goto L77;
        if (r16 == r15.f10394a) goto L76;
        r115.set(r114);
        r5 = r5 | r16.requestChildUIRectangleOnScreen(r116, r115, true);
        r114.offset(r116.getOriginLeft() - r116.getScrollX(), r116.getOriginTop() - r116.getScrollY());
        r113 = r16.getParentBaseUI();
        goto L30
    L76:
        return r5;
    L77:
        return r5;
    L65:
        return false;
    L74:
        return false;
    L36:
        if (r15.f10396c != r12) goto L66;
        r15.f10396c = Integer.MIN_VALUE;
        r15.f10395b.invalidate();
        r15.g = null;
        r15.a(r12, 65536);
        goto L67
    L66:
        return false;
    L68:
        return r15.b(r12);
    L59:
        return ViewCompat.performAccessibilityAction(r15.f10395b, r13, r14);
    L61:
        LynxLog.b(4, "LynxA11yNodeProvider", "performAction: check virtualViewId failed");
        return false;
    }
}
