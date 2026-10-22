package com.bytedance.android.live.room;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 {
    public static b a;
    public static final ArrayList<a> b = null;
    public static View c;
    public static Integer d;
    public static ViewGroup e;
    public static ViewGroup.LayoutParams f;
    public static View g;
    public static Integer h;
    public static ViewGroup i;
    public static ViewGroup.LayoutParams j;
    public static View k;
    public static Integer l;
    public static ViewGroup m;
    public static ViewGroup.LayoutParams n;
    public static String o;

    public interface a {
        void onHide();

        void onShow();
    }

    public interface b {
        ViewGroup B2();

        void C4();

        ViewGroup J4();

        TextView Jp();

        boolean isShowing();

        ViewGroup r3();

        void y2();
    }

    static {
        b = new ArrayList();
        o = "";
    }

    public static void a() {
        ALogger.e("VSLiveDetailService", "hideVSLiveDetail");
        b r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (c != null) goto L7;
        return;
    L7:
        if (g != null) goto L9;
        return;
    L9:
        if (k != null) goto L12;
        return;
    L12:
        if (r0.isShowing() != true) goto L79;
        b r1 = a;
        if (r1 == null) goto L17;
        r1.C4();
    L17:
        Iterator<a> r2 = b.iterator();
    L19:
        if (r2.hasNext() == false) goto L21;
        r2.next().onHide();
        goto L19
    L21:
        int r3 = 0;
        if (c == null) goto L39;
        b r4 = a;
        if (r4 == null) goto L28;
        ViewGroup r5 = r4.J4();
        if (r5 == null) goto L28;
        r5.removeAllViews();
    L28:
        View r6 = c;
        if (r6 == null) goto L31;
        r6.setLayoutParams(f);
    L31:
        ViewGroup r7 = e;
        if (r7 == null) goto L39;
        View r8 = c;
        Integer r9 = d;
        if (r9 == null) goto L36;
        int r10 = r9.intValue();
    L37:
        r7.addView(r8, r10);
        goto L39
    L36:
        r10 = 0;
    L39:
        if (k == null) goto L56;
        b r12 = a;
        if (r12 == null) goto L45;
        ViewGroup r13 = r12.B2();
        if (r13 == null) goto L45;
        r13.removeAllViews();
    L45:
        View r14 = k;
        if (r14 == null) goto L48;
        r14.setLayoutParams(n);
    L48:
        ViewGroup r15 = m;
        if (r15 == null) goto L56;
        View r16 = k;
        Integer r17 = l;
        if (r17 == null) goto L53;
        int r18 = r17.intValue();
    L54:
        r15.addView(r16, r18);
        goto L56
    L53:
        r18 = 0;
    L56:
        if (g == null) goto L76;
        b r19 = a;
        if (r19 == null) goto L62;
        ViewGroup r20 = r19.r3();
        if (r20 == null) goto L62;
        r20.removeAllViews();
    L62:
        View r22 = g;
        if (r22 == null) goto L65;
        r22.setLayoutParams(j);
    L65:
        ViewGroup r23 = i;
        if (r23 == null) goto L77;
        View r24 = g;
        Integer r25 = h;
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
