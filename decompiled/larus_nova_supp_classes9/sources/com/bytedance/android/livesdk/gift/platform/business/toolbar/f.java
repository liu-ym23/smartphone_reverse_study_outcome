package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.view.View;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends zr2.k {
    public boolean b;
    public final boolean c;
    public final boolean d;

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        if (this.b == false) goto L5;
        Integer r0 = 2131252952;
        HorizontalPlayEvent r1 = new HorizontalPlayEvent(3);
        Integer r2 = 2131919137;
    L6:
        r5.setBackgroundResource(r0.intValue());
        xs2.b.a().post(r1);
        int r6 = ToastUtil.a;
        ToastUtil.a(r2.intValue(), 0);
        this.b = !this.b;
        String r7 = "更新礼物特效开启状态，是否开启: " + this.b;
        String r3 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter(r7, "desc");
        com.bytedance.android.livesdk.gift.platform.core.utils.h.z(r7, null, null);
        ay1.b.P.setValue(null, ay1.b.a[52], Boolean.valueOf(this.b));
        if (this.b == true) goto L18;
        n r8 = new n();
        Map r4 = r8.a;
        Intrinsics.checkNotNullParameter(r4, "map");
        if (this.d == false) goto L11;
        String r9 = "0";
    L12:
        Intrinsics.checkNotNullParameter("room_orientation", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        r4.put("room_orientation", r9);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r11 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r11, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r11.a("live");
        Intrinsics.checkNotNullParameter("click", "type");
        r11.d("click");
        if (this.c == false) goto L15;
        String r13 = "live_take_detail";
    L16:
        Intrinsics.checkNotNullParameter(r13, "page");
        r11.c(r13);
        ((ArrayList) r10.a).add(r11.a);
        ((ArrayList) r8.b).addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("livesdk_gift_effects_close", r8.a, r8.b);
        return;
    L15:
        r13 = "live_detail";
        goto L16
    L11:
        r9 = "1";
        goto L12
    L18:
        return;
    L5:
        r0 = 2131252953;
        r1 = new HorizontalPlayEvent(4);
        r2 = 2131919138;
        goto L6
    }

    public f(boolean r1, boolean r2) {
        this.c = r1;
        this.d = r2;
        this.b = true;
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        boolean r5 = ((Boolean) ay1.b.P.getValue(null, ay1.b.a[52])).booleanValue();
        this.b = r5;
        if (r5 == false) goto L5;
        r3.setBackgroundResource(2131252953);
        HorizontalPlayEvent r6 = new HorizontalPlayEvent(4);
    L6:
        xs2.b.a().post(r6);
        String r7 = "是否开启礼物特效: " + this.b;
        String r8 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter(r7, "desc");
        com.bytedance.android.livesdk.gift.platform.core.utils.h.z(r7, null, null);
        return;
    L5:
        r3.setBackgroundResource(2131252952);
        r6 = new HorizontalPlayEvent(3);
        goto L6
    }
}
