package com.bytedance.android.btm.impl.page;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmPageFinder {
    public static final String a = "BtmPageFinder_findByView";
    public static final String b = "BtmPageFinder_findByFinder";
    public static final BtmPageFinder c = null;

    public BtmPageFinder() {
    }

    static {
        c = new BtmPageFinder();
        a = "BtmPageFinder_findByView";
        b = "BtmPageFinder_findByFinder";
    }

    public static Object a(final PageFinder r12) {
        if (r12 == null) goto L6;
        Object r0 = r12.page;
        if (r0 == null) goto L6;
        String r1 = r0.getClass().getName();
    L7:
        final String r10 = r1;
        if (r12 == null) goto L12;
        Fragment r11 = r12.fragment;
        if (r11 == null) goto L12;
        String r13 = r11.getClass().getName();
    L13:
        final String r14 = r13;
        if (r12 == null) goto L18;
        View r15 = r12.view;
        if (r15 == null) goto L18;
        String r16 = r15.getClass().getName();
    L19:
        final String r17 = r16;
        if (r12 == null) goto L24;
        String r18 = r12.btmPageId;
        if (r18 == null) goto L24;
    L25:
        final String r19 = r18;
        ALogger r20 = ALogger.d;
        ALogger.j(r20, b, new BtmPageFinder$find$7(r19, r10, r17, r14));
        if (r12 != null) goto L28;
        return null;
    L28:
        String r21 = BtmPageRecorder.a;
        Object r22 = BtmPageRecorder.c(r12.btmPageId);
        if (r22 == null) goto L32;
        ALogger.j(r20, a, new BtmPageFinder$find$$inlined$also$lambda$1(r12));
        return r22;
    L32:
        Object r23 = r12.page;
        boolean r24 = true;
        if (r23 != null) goto L35;
    L42:
        DialogFragment r25 = r12.view;
        if (r25 == null) goto L96;
        BtmPageFinder r26 = c;
        monitor-enter(r26);
        final String r27 = r25.getClass().getName();     // Catch: Throwable -> L93
        ALogger.j(r20, a, new BtmPageFinder$find$1(r27));     // Catch: Throwable -> L93
        DialogFragment r28 = r25;
    L47:
        if (r28 == null) goto L82;
        String r29 = BtmPageRecorder.a;     // Catch: Throwable -> L93
        if (((ArrayList) BtmPageRecorder.q).contains(new f(r28)) == true) goto L50;
        DialogFragment r30 = BtmPageRecorder.d(r28);     // Catch: Throwable -> L93
        if (r30 != null) goto L56;
    L60:
        f<DialogFragment> r31 = BtmPageRecorder.o.get(new f(r28));     // Catch: Throwable -> L93
        if (r31 == null) goto L63;
        r30 = r31.get();     // Catch: Throwable -> L93
    L64:
        if (r30 != null) goto L66;
    L70:
        f<Dialog> r32 = BtmPageRecorder.p.get(new f(r28));     // Catch: Throwable -> L93
        if (r32 == null) goto L73;
        r30 = (Dialog) r32.get();     // Catch: Throwable -> L93
    L74:
        if (r30 != null) goto L75;
        DialogFragment r33 = r28.getParent();     // Catch: Throwable -> L93
        if ((r33 instanceof View) == true) goto L81;
        r33 = null;
    L81:
        r28 = (View) r33;     // Catch: Throwable -> L93
        goto L47
    L75:
        final String r34 = r30.getClass().getName();     // Catch: Throwable -> L93
        ALogger.j(ALogger.d, a, new BtmPageFinder$find$5(r27, r34));     // Catch: Throwable -> L93
        monitor-exit(r26);
    L59:
        r28 = r30;
    L91:
        if (r28 == null) goto L96;
        return r28;
    L73:
        r30 = null;
        goto L74
    L66:
        if (BtmPageRecorder.a(r30) == false) goto L70;
        final String r35 = r30.getClass().getName();     // Catch: Throwable -> L93
        ALogger.j(ALogger.d, a, new BtmPageFinder$find$4(r27, r35));     // Catch: Throwable -> L93
        monitor-exit(r26);
        goto L59
    L63:
        r30 = null;
        goto L64
    L56:
        if (BtmPageRecorder.a(r30) == false) goto L60;
        final String r36 = r30.getClass().getName();     // Catch: Throwable -> L93
        ALogger.j(ALogger.d, a, new BtmPageFinder$find$3(r27, r36));     // Catch: Throwable -> L93
        monitor-exit(r26);
        goto L59
    L50:
        ALogger.j(ALogger.d, a, new BtmPageFinder$find$2(r27));     // Catch: Throwable -> L93
        monitor-exit(r26);
        goto L91
    L82:
        r28 = d.a.getActivity(r25);     // Catch: Throwable -> L93
        if (r28 == null) goto L89;
        final String r37 = r28.getClass().getName();     // Catch: Throwable -> L93
        String r38 = BtmPageRecorder.a;     // Catch: Throwable -> L93
        if (BtmPageRecorder.a(r28) == false) goto L89;
        ALogger.j(ALogger.d, a, new BtmPageFinder$find$$inlined$let$lambda$1(r37, r27));     // Catch: Throwable -> L93
        monitor-exit(r26);
    L89:
        monitor-exit(r26);
        r28 = null;
    L93:
        th = move-exception;
        throw th;
    L96:
        Fragment r110 = r12.fragment;
        if (r110 == null) goto L117;
        Fragment r39 = r110;
    L100:
        if (cd.b.a(r39) == null) goto L102;
        boolean r40 = true;
    L103:
        if (r40 == true) goto L104;
        r39 = r39.getParentFragment();
        if (r39 != null) goto L100;
        FragmentActivity r111 = r110.getActivity();
        if (r111 == null) goto L117;
        final String r41 = r111.getClass().getName();
        if (cd.b.a(r111) != null) goto L114;
        r24 = false;
    L114:
        if (r24 == false) goto L117;
        ALogger.j(ALogger.d, a, new BtmPageFinder$find$11$2$1(r41));
        return r111;
    L104:
        final String r112 = r39.getClass().getName();
        ALogger.j(ALogger.d, a, new BtmPageFinder$find$11$1(r112));
        return r39;
    L102:
        r40 = false;
    L117:
        return null;
    L35:
        if (cd.b.a(r23) == null) goto L37;
        boolean r42 = true;
    L38:
        if (r42 == false) goto L41;
        ALogger.j(r20, a, new BtmPageFinder$find$$inlined$let$lambda$2(r10, r12, r19, r17, r14));
        return r12.page;
    L41:
        ALogger.i(r20, "1106", false, new BtmPageFinder$find$$inlined$let$lambda$3(r10, r12, r19, r17, r14), 6);
        goto L42
    L37:
        r42 = false;
    L24:
        r18 = "";
    L18:
        r16 = "";
    L12:
        r13 = "";
    L6:
        r1 = "";
        goto L7
    }
}
