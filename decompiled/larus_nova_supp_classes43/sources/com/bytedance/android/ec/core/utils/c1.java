package com.bytedance.android.ec.core.utils;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataRecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c1 {
    public ArrayList<View> a;
    public View b;
    public boolean c;
    public final ViewGroup d;
    public final Function1<MotionEvent, Boolean> e;

    public final boolean a(MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r19, "ev");
        if (this.d.onFilterTouchEventForSecurity(r19) == false) goto L127;
        int r10 = r19.getAction();
        int r11 = r10 & 255;
        if (r11 != 0) goto L8;
        this.b = null;
        this.d.requestDisallowInterceptTouchEvent(false);
    L8:
        if (r11 == 0) goto L14;
        if (this.b != null) goto L14;
        boolean r12 = true;
    L18:
        if (r11 != 3) goto L20;
        boolean r13 = true;
    L22:
        if (r19.getSource() != 8194) goto L24;
        boolean r14 = true;
    L26:
        if (this.d.isMotionEventSplittingEnabled() == false) goto L29;
        if (r14 == true) goto L29;
        boolean r15 = true;
    L31:
        if (r13 == true) goto L98;
        if (r12 == true) goto L98;
        if (r11 == 0) goto L38;
        if (r15 == true) goto L36;
    L37:
        if (r11 != 7) goto L98;
    L36:
        if (r11 != 5) goto L37;
    L38:
        int r16 = r19.getActionIndex();
        int r17 = this.d.getChildCount();
        if (r17 == 0) goto L92;
        int r18 = Build.VERSION.SDK_INT;
        if (r18 < 29) goto L43;
        float r110 = r19.getRawX(r16);
    L44:
        if (r18 < 29) goto L46;
        float r20 = r19.getRawY(r16);
    L47:
        int r111 = this.d.getChildCount();
        if (r111 <= 1) goto L75;
        int r112 = this.d.getChildCount();
        int r113 = 0;
    L51:
        if (r113 >= r112) goto L56;
        if (this.d.getChildAt(r113).getZ() != 0.0f) goto L54;
        r113 = r113 + 1;
        goto L51
    L54:
        boolean r21 = true;
    L57:
        if (r21 == false) goto L75;
        ArrayList<View> r22 = this.a;
        if (r22 != null) goto L62;
        ArrayList<View> r23 = new ArrayList(r111);
        this.a = r23;
        List r24 = r23;
    L63:
        int r114 = 0;
    L64:
        if (r114 >= r111) goto L76;
        View r115 = this.d.getChildAt(r114);
        float r116 = r115.getZ();
        int r117 = r114;
    L66:
        if (r117 <= 0) goto L74;
        int r25 = r117 - 1;
        View r118 = (View) CollectionsKt.getOrNull(r24, r25);
        if (r118 == null) goto L70;
        float r119 = r118.getZ();
    L72:
        if (r119 <= r116) goto L74;
        r117 = r25;
        goto L66
    L70:
        r119 = 0.0f;
    L74:
        ListProtector.add(r24, r117, r115);
        r114 = r114 + 1;
    L76:
        if (r24 != null) goto L79;
        r24 = com.bytedance.commerce.base.view.b.a(this.d);
    L79:
        int r120 = r17 - 1;
        View r26 = null;
    L80:
        if (r120 < 0) goto L93;
        View r121 = (View) CollectionsKt.getOrNull(r24, r120);
        if (r121 == null) goto L91;
        if (d(r110, r20, r121) == false) goto L91;
        if (b(r19, false, r121) == true) goto L89;
        r26 = r121;
        goto L91
    L89:
        this.b = r121;
        r26 = r121;
        boolean r27 = true;
    L94:
        if (r26 != null) goto L99;
        View r28 = this.b;
        if (r28 == null) goto L99;
        r26 = r28;
    L99:
        View r29 = this.b;
        if (r29 != null) goto L102;
        boolean r1 = b(r19, r13, null);
    L110:
        if (r13 == true) goto L114;
        if (r11 == 1) goto L114;
        if (r11 == 7) goto L114;
    L116:
        return r1;
    L114:
        this.b = null;
        this.d.requestDisallowInterceptTouchEvent(false);
        goto L116
    L102:
        if (r27 == false) goto L107;
        if (Intrinsics.areEqual(r29, r26) == false) goto L107;
    L108:
        r1 = true;
    L107:
        if (b(r19, r12, r29) == true) goto L108;
        r1 = false;
    L91:
        r120 = r120 - 1;
    L93:
        r27 = false;
        goto L94
    L62:
        r22.clear();
        r22.ensureCapacity(r111);
        r24 = r22;
        goto L63
    L56:
        r21 = false;
    L75:
        r24 = null;
        goto L76
    L46:
        r20 = r19.getRawY();
        goto L47
    L43:
        r110 = r19.getRawX();
        goto L44
    L92:
        r26 = null;
    L98:
        r26 = null;
        r27 = false;
    L29:
        r15 = false;
        goto L31
    L24:
        r14 = false;
        goto L26
    L20:
        r13 = false;
    L14:
        if (this.c == true) goto L16;
        r12 = this.d.onInterceptTouchEvent(r19);
        r19.setAction(r10);
        goto L18
    L16:
        r12 = false;
        goto L18
    L127:
        return false;
    }

    public c1(OrderCommonYataRecyclerView r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        Intrinsics.checkNotNullParameter(r11, "superDispatchEvent");
        this.d = r10;
        this.e = r11;
    }

    public static boolean c(View r10, float r11, float r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        int[] r0 = new int[2];
        r10.getLocationOnScreen(r0);
        int r13 = r0[0];
        if (r11 >= r13) goto L5;
        return false;
    L5:
        if (r12 > r0[1]) goto L7;
        return false;
    L7:
        if (r11 <= (r13 + r10.getWidth())) goto L9;
        return false;
    L9:
        if (r12 > (r0[1] + r10.getHeight())) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean b(MotionEvent r10, boolean r11, View r12) {
        int r0 = r10.getAction();
        if (r11 == true) goto L12;
        if (r0 == 3) goto L12;
        MotionEvent r13 = MotionEvent.obtain(r10);
        if (r12 != null) goto L9;
        boolean r14 = ((Boolean) this.e.invoke(r13)).booleanValue();
    L10:
        r13.recycle();
        return r14;
    L9:
        r13.offsetLocation(this.d.getScrollX() - r12.getLeft(), this.d.getScrollY() - r12.getTop());
        r14 = r12.dispatchTouchEvent(r13);
    L12:
        r10.setAction(3);
        if (r12 == null) goto L15;
        boolean r15 = r12.dispatchTouchEvent(r10);
    L16:
        r10.setAction(r0);
        return r15;
    L15:
        r15 = ((Boolean) this.e.invoke(r10)).booleanValue();
        goto L16
    }

    public final boolean d(float r10, float r11, View r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        if (r12.getVisibility() != 0) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        return false;
    L12:
        if ((r12 instanceof ViewGroup) == false) goto L42;
        if (this.d.getClipChildren() == true) goto L42;
        ViewGroup r13 = (ViewGroup) r12;
        int r14 = r13.getChildCount() - 1;
    L16:
        if (r14 < 0) goto L42;
        View r15 = r13.getChildAt(r14);
        if (r15 == null) goto L40;
        Intrinsics.checkNotNullParameter(r15, "view");
        if (r15.getVisibility() != 0) goto L22;
    L25:
        boolean r16 = true;
    L26:
        if (r16 == false) goto L40;
        if ((r15 instanceof ViewGroup) == false) goto L38;
        if (c(r15, r10, r11) == true) goto L31;
        if (((ViewGroup) r15).getClipChildren() == true) goto L40;
        if (d(r10, r11, r15) == false) goto L40;
        return true;
    L31:
        return true;
    L38:
        if (c(r15, r10, r11) == false) goto L40;
        return true;
    L22:
        if (r15.getAnimation() != null) goto L25;
        r16 = false;
    L40:
        r14 = r14 - 1;
    L42:
        if (c(r12, r10, r11) == false) goto L44;
        return true;
    L44:
        return false;
    L5:
        if (r12.getAnimation() != null) goto L8;
        r1 = false;
        goto L9
    }
}
