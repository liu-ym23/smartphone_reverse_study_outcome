package com.bytedance.android.livesdk.interactivity.api.like.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.config.pn;
import com.bytedance.android.livesdk.config.w2;
import com.bytedance.android.livesdk.utils.z0;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(boolean r8) {
        double r0 = z0.b(r8);
        pn r2 = pn.a;
        if (r0 >= ((w2) r2.getValue()).b()) goto L5;
    L9:
        boolean r1 = false;
    L10:
        LinkedHashMap r3 = new LinkedHashMap();
        IStrategyService r4 = k.f(IStrategyService.class);
        if (r4 == null) goto L15;
        LiveData r5 = IStrategyService.a.a(r4, "live_ui_degrade", r3, false, 12);
        if (r5 == null) goto L15;
        Map r6 = (Map) r5.getValue();
    L16:
        if (r6 == null) goto L20;
        Boolean r7 = (Boolean) r6.get("digg_hide");
        if (r7 == null) goto L20;
        r1 = r7.booleanValue();
    L20:
        if (r8 == true) goto L24;
        if (r1 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L15:
        r6 = null;
        goto L16
    L5:
        if (r0 > ((w2) r2.getValue()).a()) goto L9;
        if (((w2) r2.getValue()).c() == false) goto L9;
        r1 = true;
        goto L10
    }
}
