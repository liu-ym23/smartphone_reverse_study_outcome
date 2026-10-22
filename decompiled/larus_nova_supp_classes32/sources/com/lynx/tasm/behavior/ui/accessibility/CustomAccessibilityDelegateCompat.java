package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxTouchEvent;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CustomAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static List<Integer> d;
    public static final Map<String, String> e = null;
    public final WeakReference<LynxUI> a;
    public final Rect b;
    public final Rect c;

    static {
        e = new AnonymousClass1();
    }

    public final LynxUI c() {
        WeakReference<LynxUI> r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.get() != null) goto L7;
        return null;
    L7:
        return this.a.get();
    }

    public final d b() {
        if (c() == null) goto L8;
        LynxContext r0 = c().getLynxContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLynxAccessibilityWrapper();
    L8:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    public CustomAccessibilityDelegateCompat(LynxUI r3) {
        Rect r1 = d.p;
        this.b = new Rect(r1);
        this.c = new Rect(r1);
        if (r3 != null) goto L5;
    L16:
        LLog.e("CustomAccessibilityDelegateCompat", "Construct with null ui or view");
        return;
    L5:
        if (r3.getView() == null) goto L16;
        this.a = new WeakReference(r3);
        d r0 = b();
        if (r0 == null) goto L10;
        LynxAccessibilityHelper r2 = r0.n;
    L11:
        if (r2 == null) goto L13;
        ?? r4 = r2.b;
    L14:
        ViewCompat.setImportantForAccessibility(r3.getView(), r4);
        return;
    L13:
        r4 = 0;
        goto L14
    L10:
        r2 = null;
        goto L11
    }

    public static int a(int r4) {
        if (d != null) goto L6;
        d = new ArrayList(Arrays.asList(new Integer[]{2131368430, 2131368441, 2131368452, 2131368453, 2131368454, 2131368455, 2131368456, 2131368457, 2131368458, 2131368459, 2131368431, 2131368432, 2131368433, 2131368434, 2131368435, 2131368436, 2131368437, 2131368438, 2131368439, 2131368440, 2131368442, 2131368443, 2131368444, 2131368445, 2131368446, 2131368447, 2131368448, 2131368449, 2131368450, 2131368451}));
    L6:
        return ((Integer) ListProtector.get(d, r4)).intValue();
    }

    public final void onInitializeAccessibilityNodeInfo(View r9, AccessibilityNodeInfoCompat r10) {
        super.onInitializeAccessibilityNodeInfo(r9, r10);
        d r11 = b();
        if (r11 != null) goto L5;
        return;
    L5:
        WeakReference<LynxUI> r0 = this.a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.get() != null) goto L10;
        return;
    L10:
        if (r11.f() == false) goto L99;
        LynxUI r12 = this.a.get();
        d r1 = b();
        CharSequence r2 = null;
        if (r1 == null) goto L14;
        LynxAccessibilityHelper r3 = r1.n;
    L15:
        boolean r4 = r3.a(r12);
        CharSequence r5 = r12.getAccessibilityLabel();
        LynxUI r6 = c();
        int r7 = 0;
        if (r6 != null) goto L18;
    L24:
        boolean r8 = false;
    L25:
        r10.setScreenReaderFocusable(r4);
        if (r4 == false) goto L36;
        String r13 = r12.getAccessibilityStatus();
        StringBuilder r14 = new StringBuilder();
        if (r13 == null) goto L30;
        r14.append(r13);
    L30:
        if (r5 != null) goto L32;
    L35:
        String r15 = r14.toString();
    L37:
        r10.setContentDescription(r15);
        if (r4 == false) goto L40;
        r2 = r5;
    L40:
        r10.setText(r2);
        r10.setClickable(r8);
        ArrayList<String> r16 = r12.getAccessibilityActions();
        if (r16 == null) goto L46;
        Iterator<String> r17 = r16.iterator();
        int r18 = 0;
    L44:
        if (r17.hasNext() == false) goto L50;
        r10.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(a(r18), r17.next()));
        r18 = r18 + 1;
    L50:
        if (r8 == false) goto L52;
        r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    L53:
        if (r4 == true) goto L55;
        r10.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        r10.setVisibleToUser(false);
    L55:
        r10.getBoundsInScreen(this.b);
        r10.getBoundsInParent(this.c);
        LynxContext r19 = r12.getLynxContext();
        View r20 = r12.getView();
        if (r19 == null) goto L77;
        if (r20 == null) goto L77;
        if (r19.getUIBody() == null) goto L77;
        UIBody.UIBodyView r21 = r19.getUIBody().getBodyView();
        ViewParent r22 = r20.getParent();
    L61:
        if (r21 == null) goto L77;
        if (r22 == null) goto L77;
        if (r22 == r21) goto L77;
        if ((r22 instanceof UIShadowProxy.d) == true) goto L66;
        r22 = r22.getParent();
        goto L61
    L66:
        UIShadowProxy.d r23 = (UIShadowProxy.d) r22;
        if ((r23.getParent() instanceof ViewGroup) == false) goto L77;
        ViewGroup r24 = (ViewGroup) r23.getParent();
        int r25 = r24.getChildCount();
    L69:
        if (r7 >= r25) goto L77;
        View r26 = r24.getChildAt(r7);
        if (r26 == r23) goto L77;
        if (r26 == null) goto L75;
        r10.setTraversalAfter(r26);
    L75:
        r7 = r7 + 1;
    L77:
        LynxAccessibilityHelper.LynxAccessibilityTraits r27 = r12.getAccessibilityTraits();
        r10.setClassName(LynxAccessibilityHelper.LynxAccessibilityTraits.getValue(r27));
        if (r27 != LynxAccessibilityHelper.LynxAccessibilityTraits.NONE) goto L80;
        r10.setRoleDescription(NameKeys.UnloadStrategy_No_Strategy);
    L80:
        String r28 = r12.getAccessibilityRoleDescription();
        if (r28 == null) goto L100;
        HashMap r29 = (HashMap) e;
        if (r29.containsKey(r28) == false) goto L85;
        r10.setClassName((CharSequence) r29.get(r28));
        return;
    L85:
        r10.setRoleDescription(r28);
        return;
    L100:
        return;
    L52:
        r10.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        goto L53
    L46:
        Iterator r30 = r10.getActionList().iterator();
    L48:
        if (r30.hasNext() == false) goto L50;
        r10.removeAction((AccessibilityNodeInfoCompat.AccessibilityActionCompat) r30.next());
        goto L48
    L32:
        if (r14.length() == 0) goto L34;
        r14.append(", ");
    L34:
        r14.append(r5);
        goto L35
    L36:
        r15 = null;
        goto L37
    L18:
        if (r6.getEvents() == null) goto L24;
        if (r6.getEvents().containsKey(LynxTouchEvent.EVENT_CLICK) == false) goto L22;
    L23:
        r8 = true;
        goto L25
    L22:
        if (r6.getEvents().containsKey(LynxTouchEvent.EVENT_TAP) == false) goto L24;
    L14:
        r3 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performAccessibilityAction(View r11, int r12, Bundle r13) {
        boolean r14 = super.performAccessibilityAction(r11, r12, r13);
        int r0 = 0;
        if (r12 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.getId()) goto L26;
        d r15 = b();
        WeakReference<LynxUI> r16 = this.a;
        if (r16 != null) goto L7;
    L24:
        return false;
    L7:
        if (r16.get() == null) goto L24;
        if (r15 == null) goto L24;
        if (r15.f() == false) goto L24;
        LynxUI r17 = this.a.get();
        Rect r18 = this.b;
        Rect r19 = d.p;
        if (r18.equals(r19) == true) goto L24;
        if (this.c.equals(r19) == true) goto L24;
        LynxTouchEvent.a r110 = new LynxTouchEvent.a(this.b.centerX(), this.b.centerY());
        LynxTouchEvent.a r111 = new LynxTouchEvent.a(this.c.centerX(), this.c.centerY());
        if (r17.getEvents() == null) goto L24;
        Map<String, EventsListener> r7 = r17.getEvents();
        if (r7.containsKey(LynxTouchEvent.EVENT_TAP) == false) goto L21;
        r17.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r17.getSign(), LynxTouchEvent.EVENT_TAP, r111, r111, r110));
        r0 = 1;
    L21:
        if (r7.containsKey(LynxTouchEvent.EVENT_CLICK) == false) goto L42;
        r17.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r17.getSign(), LynxTouchEvent.EVENT_CLICK, r111, r111, r110));
        return true;
    L42:
        return r0;
    L26:
        if (r12 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS.getId()) goto L28;
    L30:
        ArrayList<String> r112 = this.a.get().getAccessibilityActions();
        if (r112 == null) goto L45;
        Iterator<String> r113 = r112.iterator();
    L34:
        if (r113.hasNext() == false) goto L47;
        String r1 = r113.next();
        int r2 = r0 + 1;
        if (r12 == a(r0)) goto L37;
        r0 = r2;
        goto L34
    L37:
        m7a.a r114 = new m7a.a(this.a.get().getSign(), "accessibilityaction");
        r114.a(EasyGoDbTable.Server.NAME, r1);
        this.a.get().getLynxContext().getEventEmitter().sendCustomEvent(r114);
        return r14;
    L47:
        return r14;
    L45:
        return r14;
    L28:
        if (b() == null) goto L30;
        d r115 = b();
        LynxUI r116 = this.a.get();
        r115.getClass();
        d.l(r116);
        return r14;
    }
}
