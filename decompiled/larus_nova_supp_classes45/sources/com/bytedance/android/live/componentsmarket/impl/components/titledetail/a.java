package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static b a;
    public static final ArrayList<InterfaceC0136a> b = null;
    public static View c;
    public static int d;
    public static Integer e;
    public static ViewGroup f;
    public static ViewGroup.LayoutParams g;
    public static View h;
    public static Integer i;
    public static ViewGroup j;
    public static ViewGroup.LayoutParams k;
    public static View l;
    public static Integer m;
    public static ViewGroup n;
    public static ViewGroup.LayoutParams o;

    /* JADX INFO: renamed from: com.bytedance.android.live.componentsmarket.impl.components.titledetail.a$a, reason: collision with other inner class name */
    public interface InterfaceC0136a {
        void onHide();

        void onShow();
    }

    public interface b {
        ViewGroup B2();

        void C4();

        ViewGroup J4();

        boolean isShowing();

        ViewGroup r3();

        void y2();
    }

    static {
        b = new ArrayList();
    }

    public static void a() {
        b r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (c != null) goto L7;
        return;
    L7:
        if (h != null) goto L9;
        return;
    L9:
        if (l != null) goto L12;
        return;
    L12:
        if (r0.isShowing() != true) goto L79;
        b r1 = a;
        if (r1 == null) goto L17;
        r1.C4();
    L17:
        Iterator<InterfaceC0136a> r2 = b.iterator();
    L19:
        if (r2.hasNext() == false) goto L21;
        r2.next().onHide();
        goto L19
    L21:
        int r3 = 0;
        if (h == null) goto L39;
        b r4 = a;
        if (r4 == null) goto L28;
        ViewGroup r5 = r4.r3();
        if (r5 == null) goto L28;
        r5.removeAllViews();
    L28:
        View r6 = h;
        if (r6 == null) goto L31;
        r6.setLayoutParams(k);
    L31:
        ViewGroup r7 = j;
        if (r7 == null) goto L39;
        View r8 = h;
        Integer r9 = i;
        if (r9 == null) goto L36;
        int r11 = r9.intValue();
    L37:
        r7.addView(r8, r11);
        goto L39
    L36:
        r11 = 0;
    L39:
        if (l == null) goto L56;
        b r12 = a;
        if (r12 == null) goto L45;
        ViewGroup r13 = r12.B2();
        if (r13 == null) goto L45;
        r13.removeAllViews();
    L45:
        View r14 = l;
        if (r14 == null) goto L48;
        r14.setLayoutParams(o);
    L48:
        ViewGroup r15 = n;
        if (r15 == null) goto L56;
        View r16 = l;
        Integer r17 = m;
        if (r17 == null) goto L53;
        int r18 = r17.intValue();
    L54:
        r15.addView(r16, r18);
        goto L56
    L53:
        r18 = 0;
    L56:
        if (c == null) goto L76;
        b r19 = a;
        if (r19 == null) goto L62;
        ViewGroup r21 = r19.J4();
        if (r21 == null) goto L62;
        r21.removeAllViews();
    L62:
        View r22 = c;
        if (r22 == null) goto L65;
        r22.setLayoutParams(g);
    L65:
        ViewGroup r23 = f;
        if (r23 == null) goto L77;
        View r24 = c;
        Integer r25 = e;
        if (r25 == null) goto L70;
        r3 = r25.intValue();
    L70:
        r23.addView(r24, r3);
        return;
    L77:
        return;
    L76:
        return;
    }
}
