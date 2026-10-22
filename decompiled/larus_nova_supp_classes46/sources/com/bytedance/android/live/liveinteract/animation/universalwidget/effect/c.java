package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Unit;
import pn0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        a r9 = this.a;
        if (r9.d == false) goto L41;
        ViewGroup r0 = (ViewGroup) r9.h.findViewById(2131386660);
        if (r0 == null) goto L42;
        int r1 = 0;
        View r2 = r0.getChildAt(0);
        if (r2 == null) goto L43;
        DataCenter r10 = r9.g;
        FrameLayout.LayoutParams r3 = null;
        if (r10 == null) goto L13;
        m r11 = (m) r10.get("cmd_link_window_layout_config_changed");
    L14:
        if (r11 == null) goto L18;
        f r12 = r11.d;
        if (r12 == null) goto L18;
        f.a r13 = r12.b;
    L19:
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if ((r4 instanceof FrameLayout.LayoutParams) == true) goto L22;
        r4 = null;
    L22:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r4;
        if (r5 == null) goto L39;
        if (r13 == null) goto L26;
        int r6 = r13.c;
    L27:
        r5.width = r6;
        if (r13 == null) goto L30;
        int r14 = r13.d;
    L31:
        r5.height = r14;
        if (r13 == null) goto L34;
        int r15 = r13.b;
    L35:
        r5.topMargin = r15;
        if (r13 == null) goto L38;
        r1 = r13.a;
    L38:
        r5.leftMargin = r1;
        Unit r16 = Unit.INSTANCE;
        r3 = r5;
        goto L39
    L34:
        r15 = 0;
        goto L35
    L30:
        r14 = r0.getHeight();
        goto L31
    L26:
        r6 = r0.getWidth();
    L39:
        r2.setLayoutParams(r3);
        return;
    L18:
        r13 = null;
        goto L19
    L13:
        r11 = null;
        goto L14
    L43:
        return;
    L42:
        return;
    }
}
