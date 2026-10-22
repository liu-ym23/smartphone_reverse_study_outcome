package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.lynx.animax.i;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.d0;
import com.lynx.tasm.t;
import com.obric.launcher.widget.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import on.g;
import on.h;

/* JADX INFO: loaded from: classes2.dex */
public class CustomAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static ArrayList d;
    public static final Map e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f10392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f10393c;

    static {
        e = new AnonymousClass1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public CustomAccessibilityDelegateCompat(LynxUI r5) {
        Rect r10 = d.f10404p;
        this.f10392b = new Rect(r10);
        this.f10393c = new Rect(r10);
        if (r5.getView() != null) goto L6;
        LynxLog.b(4, "CustomAccessibilityDelegateCompat", "Construct with null ui or view");
        return;
    L6:
        this.f10391a = new WeakReference(r5);
        d r11 = b();
        if (r11 == null) goto L9;
        t r12 = r11.f10414n;
    L10:
        if (r12 == null) goto L12;
        ?? r13 = r12.f10962b;
    L13:
        ViewCompat.setImportantForAccessibility(r5.getView(), r13);
        return;
    L12:
        r13 = 0;
        goto L13
    L9:
        r12 = null;
        goto L10
    }

    public static int a(int r32) {
        if (d != null) goto L6;
        d = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(R$id.custom_reserved_a11y_action_0_id), Integer.valueOf(R$id.custom_reserved_a11y_action_1_id), Integer.valueOf(R$id.custom_reserved_a11y_action_2_id), Integer.valueOf(R$id.custom_reserved_a11y_action_3_id), Integer.valueOf(R$id.custom_reserved_a11y_action_4_id), Integer.valueOf(R$id.custom_reserved_a11y_action_5_id), Integer.valueOf(R$id.custom_reserved_a11y_action_6_id), Integer.valueOf(R$id.custom_reserved_a11y_action_7_id), Integer.valueOf(R$id.custom_reserved_a11y_action_8_id), Integer.valueOf(R$id.custom_reserved_a11y_action_9_id), Integer.valueOf(R$id.custom_reserved_a11y_action_10_id), Integer.valueOf(R$id.custom_reserved_a11y_action_11_id), Integer.valueOf(R$id.custom_reserved_a11y_action_12_id), Integer.valueOf(R$id.custom_reserved_a11y_action_13_id), Integer.valueOf(R$id.custom_reserved_a11y_action_14_id), Integer.valueOf(R$id.custom_reserved_a11y_action_15_id), Integer.valueOf(R$id.custom_reserved_a11y_action_16_id), Integer.valueOf(R$id.custom_reserved_a11y_action_17_id), Integer.valueOf(R$id.custom_reserved_a11y_action_18_id), Integer.valueOf(R$id.custom_reserved_a11y_action_19_id), Integer.valueOf(R$id.custom_reserved_a11y_action_20_id), Integer.valueOf(R$id.custom_reserved_a11y_action_21_id), Integer.valueOf(R$id.custom_reserved_a11y_action_22_id), Integer.valueOf(R$id.custom_reserved_a11y_action_23_id), Integer.valueOf(R$id.custom_reserved_a11y_action_24_id), Integer.valueOf(R$id.custom_reserved_a11y_action_25_id), Integer.valueOf(R$id.custom_reserved_a11y_action_26_id), Integer.valueOf(R$id.custom_reserved_a11y_action_27_id), Integer.valueOf(R$id.custom_reserved_a11y_action_28_id), Integer.valueOf(R$id.custom_reserved_a11y_action_29_id)}));
    L6:
        return ((Integer) d.get(r32)).intValue();
    }

    public final d b() {
        WeakReference r5 = this.f10391a;
        if (r5 != null) goto L5;
    L7:
        LynxUI r10 = null;
    L8:
        if (r10 == null) goto L18;
        if (r5 != null) goto L11;
    L13:
        LynxUI r11 = null;
    L14:
        LynxContext r12 = r11.getLynxContext();
        if (r12 == null) goto L18;
        return r12.j();
    L11:
        if (r5.get() == null) goto L13;
        r11 = (LynxUI) r5.get();
    L18:
        return null;
    L5:
        if (r5.get() == null) goto L7;
        r10 = (LynxUI) r5.get();
        goto L8
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        d r12 = b();
        if (r12 == null) goto L115;
        WeakReference r5 = this.f10391a;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.get() != null) goto L10;
        return;
    L10:
        if (r12.g() == false) goto L113;
        LynxUI r13 = (LynxUI) r5.get();
        d r14 = b();
        CharSequence r15 = null;
        if (r14 == null) goto L14;
        t r16 = r14.f10414n;
    L15:
        boolean r17 = r16.e(r13);
        CharSequence r18 = r13.getAccessibilityLabel();
        if (r5 != null) goto L18;
    L20:
        LynxUI r19 = null;
    L21:
        int r20 = 0;
        if (r19 != null) goto L24;
    L30:
        boolean r21 = false;
    L31:
        r11.setScreenReaderFocusable(r17);
        if (r17 == false) goto L42;
        String r22 = r13.getAccessibilityStatus();
        StringBuilder r23 = new StringBuilder();
        if (r22 == null) goto L36;
        r23.append(r22);
    L36:
        if (r18 != null) goto L38;
    L41:
        String r24 = r23.toString();
    L43:
        r11.setContentDescription(r24);
        if (r17 == false) goto L46;
        r15 = r18;
    L46:
        r11.setText(r15);
        r11.setClickable(r21);
        ArrayList<String> r25 = r13.getAccessibilityActions();
        if (r25 == null) goto L52;
        Iterator<String> r26 = r25.iterator();
        int r27 = 0;
    L50:
        if (r26.hasNext() == false) goto L56;
        r11.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(a(r27), r26.next()));
        r27 = r27 + 1;
    L56:
        if (r21 == false) goto L58;
        r11.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    L59:
        if (r17 == true) goto L61;
        r11.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        r11.setVisibleToUser(false);
    L61:
        r11.getBoundsInScreen(this.f10392b);
        r11.getBoundsInParent(this.f10393c);
        LynxContext r28 = r13.getLynxContext();
        View r29 = r13.getView();
        if (r28 == null) goto L83;
        if (r29 == null) goto L83;
        UIBody r30 = r28.f10145m;
        if (r30 == null) goto L83;
        UIBody.UIBodyView r31 = r30.f10385a;
        ViewParent r32 = r29.getParent();
    L67:
        if (r31 == null) goto L83;
        if (r32 == null) goto L83;
        if (r32 == r31) goto L83;
        if ((r32 instanceof d0) == true) goto L72;
        r32 = r32.getParent();
        goto L67
    L72:
        d0 r33 = (d0) r32;
        if ((r33.getParent() instanceof ViewGroup) == false) goto L83;
        ViewGroup r34 = (ViewGroup) r33.getParent();
        int r35 = r34.getChildCount();
    L75:
        if (r20 >= r35) goto L83;
        View r36 = r34.getChildAt(r20);
        if (r36 == r33) goto L83;
        if (r36 == null) goto L81;
        r11.setTraversalAfter(r36);
    L81:
        r20 = r20 + 1;
    L83:
        LynxAccessibilityHelper$LynxAccessibilityTraits r37 = r13.getAccessibilityTraits();
        int r38 = r37.ordinal();
        if (r38 != 1) goto L86;
        String r39 = "android.widget.ImageView";
    L90:
        r11.setClassName(r39);
        if (r37 != LynxAccessibilityHelper$LynxAccessibilityTraits.f10397a) goto L93;
        r11.setRoleDescription("");
    L93:
        String r40 = r13.getAccessibilityRoleDescription();
        if (r40 == null) goto L114;
        HashMap r110 = (HashMap) e;
        if (r110.containsKey(r40) == false) goto L99;
        r11.setClassName((CharSequence) r110.get(r40));
        return;
    L99:
        r11.setRoleDescription(r40);
        return;
    L114:
        return;
    L86:
        if (r38 == 2) goto L88;
        r39 = "android.view.View";
        goto L90
    L88:
        r39 = "android.widget.Button";
        goto L90
    L58:
        r11.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        goto L59
    L52:
        Iterator<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r41 = r11.getActionList().iterator();
    L54:
        if (r41.hasNext() == false) goto L56;
        r11.removeAction(r41.next());
        goto L54
    L38:
        if (r23.length() == 0) goto L40;
        r23.append(", ");
    L40:
        r23.append(r18);
        goto L41
    L42:
        r24 = null;
        goto L43
    L24:
        if (r19.getEvents() == null) goto L30;
        if (r19.getEvents().containsKey("click") == false) goto L28;
    L29:
        r21 = true;
        goto L31
    L28:
        if (r19.getEvents().containsKey("tap") == false) goto L30;
    L18:
        if (r5.get() == null) goto L20;
        r19 = (LynxUI) r5.get();
        goto L21
    L14:
        r16 = null;
        goto L15
    L113:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
        boolean r13 = super.performAccessibilityAction(r10, r11, r12);
        int r14 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.getId();
        int r5 = 0;
        boolean r15 = false;
        r15 = false;
        r15 = false;
        r15 = false;
        r15 = false;
        r15 = false;
        r15 = false;
        r15 = false;
        WeakReference r16 = this.f10391a;
        if (r11 != r14) goto L26;
        d r17 = b();
        if (r16 != null) goto L7;
    L24:
        return r15;
    L7:
        if (r16.get() == null) goto L24;
        if (r17 == null) goto L24;
        if (r17.g() == false) goto L24;
        LynxUI r18 = (LynxUI) r16.get();
        Rect r19 = d.f10404p;
        Rect r110 = this.f10392b;
        if (r110.equals(r19) == true) goto L24;
        Rect r20 = this.f10393c;
        if (r20.equals(r19) == true) goto L24;
        g r111 = new g(r110.centerX(), r110.centerY());
        g r112 = new g(r20.centerX(), r20.centerY());
        if (r18.getEvents() == null) goto L24;
        Map<String, on.a> r21 = r18.getEvents();
        if (r21.containsKey("tap") == false) goto L21;
        r18.getLynxContext().g.d(new h(r18.getSign(), "tap", r112, r112, r111));
        r15 = true;
    L21:
        if (r21.containsKey("click") == false) goto L24;
        r18.getLynxContext().g.d(new h(r18.getSign(), "click", r112, r112, r111));
        return true;
    L26:
        if (r11 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS.getId()) goto L28;
    L35:
        ArrayList<String> r22 = ((LynxUI) r16.get()).getAccessibilityActions();
        if (r22 == null) goto L45;
        Iterator<String> r23 = r22.iterator();
    L39:
        if (r23.hasNext() == false) goto L45;
        String r113 = r23.next();
        int r24 = r5 + 1;
        if (r11 == a(r5)) goto L42;
        r5 = r24;
        goto L39
    L42:
        i r25 = new i(((LynxUI) r16.get()).getSign(), "accessibilityaction");
        r25.a("name", r113);
        ((LynxUI) r16.get()).getLynxContext().g.b(r25);
        return r13;
    L45:
        return r13;
    L28:
        if (b() == null) goto L35;
        d r26 = b();
        LynxBaseUI r114 = (LynxBaseUI) r16.get();
        r26.getClass();
        if (r114 == null) goto L45;
        if (r114.getLynxContext() == null) goto L45;
        JavaOnlyMap r27 = new JavaOnlyMap();
        r27.put("element-id", Integer.valueOf(r114.getSign()));
        r27.put("a11y-id", r114.getAccessibilityId());
        JavaOnlyArray r115 = new JavaOnlyArray();
        r115.pushMap(r27);
        r114.getLynxContext().e("activeElement", r115);
        return r13;
    }
}
