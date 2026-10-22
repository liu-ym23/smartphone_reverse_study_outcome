package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.view.View;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevRedDot;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends zr2.k {
    public boolean b;
    public boolean c;
    public final DataCenter d;

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final boolean showRedDot() {
        DataCenter r0 = this.d;
        Boolean r1 = Boolean.FALSE;
        boolean r2 = ((Boolean) r0.get("cmd_show_gift_effect_red_dot", r1)).booleanValue();
        this.d.put("cmd_show_gift_effect_red_dot", r1);
        return r2;
    }

    public final RevRedDot h7() {
        return RevRedDot.AudienceRoomGiftEffect;
    }

    public k(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.d = r2;
        this.b = true;
    }

    public final void onClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        boolean r8 = !this.b;
        this.b = r8;
        this.d.put("cmd_gift_effect_is_open", Boolean.valueOf(r8));
        if (this.c == false) goto L5;
        String r9 = "popup";
    L6:
        n r0 = new n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        if (this.b == false) goto L9;
        String r2 = "open";
    L10:
        Intrinsics.checkNotNullParameter("button_type", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r1.put("button_type", r2);
        Intrinsics.checkNotNullParameter("request_page", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        r1.put("request_page", r9);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        r10.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r0.b).addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r11 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r11).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((f80.a) r13).w3("livesdk_gift_effect_button_click", r0.a, r0.b);
        return;
    L9:
        r2 = "close";
        goto L10
    L5:
        r9 = "panel";
        goto L6
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = ((Boolean) r4.get("cmd_gift_effect_is_open", Boolean.TRUE)).booleanValue();
        View r5 = r3.findViewById(2131374718);
        if ((r5 instanceof View) == true) goto L5;
        r5 = null;
    L5:
        if (r5 == null) goto L12;
        if (this.b == false) goto L9;
        int r0 = 2131251042;
    L10:
        r5.setBackgroundResource(r0);
        goto L12
    L9:
        r0 = 2131251041;
    L12:
        if (r3.findViewById(2131384095).getVisibility() != 0) goto L14;
        boolean r6 = true;
    L15:
        this.c = r6;
        return;
    L14:
        r6 = false;
        goto L15
    }
}
