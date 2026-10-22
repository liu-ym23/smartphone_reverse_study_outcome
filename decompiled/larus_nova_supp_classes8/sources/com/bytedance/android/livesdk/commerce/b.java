package com.bytedance.android.livesdk.commerce;

import com.bytedance.android.live.broadcastgame.api.interactgame.j;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.livesdk.config.ux;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static Boolean a(DataCenter r3) {
        boolean r1 = false;
        if (ux.a.getValue().booleanValue() == false) goto L14;
        int r0 = j.a;
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (((Boolean) r3.get("data_is_anchor", Boolean.FALSE)).booleanValue() == true) goto L10;
        r r4 = (r) r3.get("data_audience_interact_game", null);
        if (r4 == null) goto L10;
        boolean r5 = r4.E();
    L11:
        if (r5 == false) goto L14;
        r1 = true;
    L10:
        r5 = false;
    L14:
        return Boolean.valueOf(r1);
    }

    public static boolean b(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Boolean r1 = Boolean.FALSE;
        boolean r2 = ((Boolean) r4.get("enter_from_effect_ad", r1)).booleanValue();
        boolean r5 = ((Boolean) r4.get("enter_from_dou_plus", r1)).booleanValue();
        if (r2 == true) goto L8;
        if (r5 == true) goto L8;
        return false;
    L8:
        return true;
    }
}
