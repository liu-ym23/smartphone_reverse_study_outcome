package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.x8;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends g {
    public b() {
    }

    public static View q(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void r(Dialog r9) {
        RadiusLayout r1 = r9.findViewById(2131389519);
        View r3 = null;
        if (r1 == null) goto L31;
        int r6 = -1;
        if (d() == false) goto L11;
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if (g() == true) goto L10;
        r6 = t.j();
    L10:
        r5.height = r6;
        r1.getLayoutParams().width = -2;
    L12:
        ViewGroup.LayoutParams r7 = r1.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        r7 = null;
    L15:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L19;
        r8.setMargins(0, 0, 0, 0);
    L19:
        if ((r1 instanceof RadiusLayout) == true) goto L21;
        RadiusLayout r10 = null;
    L22:
        RadiusLayout r11 = r10;
        if (r11 == null) goto L25;
        r11.setMaxHeight(0);
    L25:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof CoordinatorLayout.LayoutParams) == true) goto L28;
        r2 = null;
    L28:
        CoordinatorLayout.LayoutParams r4 = (CoordinatorLayout.LayoutParams) r2;
        if (r4 == null) goto L31;
        r4.gravity = 8388693;
        goto L31
    L21:
        r10 = r1;
        goto L22
    L11:
        r1.getLayoutParams().height = -1;
        r1.getLayoutParams().width = -1;
    L31:
        Window r12 = r9.getWindow();
        if (r12 == null) goto L35;
        r12.setNavigationBarColor(s1.h(2131106784));
    L35:
        if (d() == false) goto L61;
        View r13 = r9.findViewById(2131389483);
        if (r13 == null) goto L39;
        r13.setFitsSystemWindows(false);
        r13.setPadding(0, 0, 0, 0);
    L39:
        View r0 = r9.findViewById(2131389519);
        if (r0 == null) goto L42;
        r0.setFitsSystemWindows(false);
        r0.setPadding(0, 0, 0, 0);
    L42:
        Window r14 = r9.getWindow();
        if (r14 == null) goto L47;
        View r15 = q(r14);
        if (r15 == null) goto L47;
        r15.setFitsSystemWindows(false);
        r15.setPadding(0, 0, 0, 0);
    L47:
        Window r16 = r9.getWindow();
        if (r16 == null) goto L50;
        View r17 = q(r16);
    L52:
        if ((r17 instanceof ViewGroup) == false) goto L55;
        r3 = r17;
    L55:
        ViewGroup r18 = (ViewGroup) r3;
        if (r18 == null) goto L60;
        View r19 = r18.getChildAt(0);
        if (r19 == null) goto L60;
        r19.setFitsSystemWindows(false);
        r19.setPadding(0, 0, 0, 0);
    L60:
        x8.b(r9);
        goto L61
    L50:
        r17 = null;
    L61:
        Window r20 = r9.getWindow();
        if (r20 == null) goto L64;
        r20.setGravity(8388693);
    L64:
        Window r21 = r9.getWindow();
        if (r21 == null) goto L70;
        View r22 = q(r21);
        if (r22 == null) goto L71;
        r22.invalidate();
        return;
    L71:
        return;
    }
}
