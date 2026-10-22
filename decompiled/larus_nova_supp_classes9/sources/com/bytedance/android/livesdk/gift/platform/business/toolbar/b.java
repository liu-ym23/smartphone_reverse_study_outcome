package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevRedDot;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends zr2.k {
    public boolean b;
    public final DataCenter c;
    public final Context d;

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final boolean showRedDot() {
        DataCenter r0 = this.c;
        Boolean r1 = Boolean.FALSE;
        boolean r2 = ((Boolean) r0.get("cmd_show_gift_effect_red_dot", r1)).booleanValue();
        this.c.put("cmd_show_gift_effect_red_dot", r1);
        return r2;
    }

    public final RevRedDot h7() {
        return RevRedDot.AudienceRoomGiftEffect;
    }

    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).openGiftEffectConfigurationDialog(this.d, Boolean.valueOf(g02.a.e()), Boolean.FALSE);
        if (this.b == false) goto L5;
        String r6 = "popup";
    L6:
        n r0 = new n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter("request_page", "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        r1.put("request_page", r6);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        List r2 = r0.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_gift_effect_button_click", r0.a, r0.b);
        return;
    L5:
        r6 = "panel";
        goto L6
    }

    public b(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.c = r2;
        this.d = r3;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        View r4 = r2.findViewById(2131374718);
        if ((r4 instanceof View) == true) goto L5;
        r4 = null;
    L5:
        if (r4 == null) goto L8;
        r4.setBackgroundResource(2131251042);
    L8:
        if (r2.findViewById(2131384095).getVisibility() != 0) goto L10;
        boolean r5 = true;
    L11:
        this.b = r5;
        return;
    L10:
        r5 = false;
        goto L11
    }
}
