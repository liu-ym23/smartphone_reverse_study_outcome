package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public static final void a(IBattleConfigSetting r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$packetCustomizeData");
        Intrinsics.checkNotNullParameter(r5, "logMap");
        u2 r0 = r4.getSelfData();
        if (r0 == null) goto L5;
        int r1 = r0.getPkValueType();
    L7:
        if (1 <= r1) goto L10;
        return;
    L10:
        if (99 < r1) goto L39;
        r5.put("customize_pk_type", String.valueOf(r1));
        u2 r2 = r4.getSelfData();
        String r3 = "";
        if (r2 == null) goto L15;
        String r6 = String.valueOf(r2.getPkGiftValueLevel());
        if (r6 == null) goto L15;
    L16:
        r5.put("giftvalue_exchange_rate", r6);
        u2 r7 = r4.getSelfData();
        if (r7 == null) goto L20;
        String r8 = String.valueOf(r7.getPkUVLevel());
        if (r8 == null) goto L20;
    L21:
        r5.put("giftuv_exchange_rate", r8);
        u2 r9 = r4.getSelfData();
        if (r9 == null) goto L25;
        String r10 = String.valueOf(r9.getPkTicketLevel());
        if (r10 == null) goto L25;
    L26:
        r5.put("ticket_exchange_rate", r10);
        u2 r12 = r4.getSelfData();
        if (r12 == null) goto L30;
        String r13 = String.valueOf(r12.getPkLikeLevel());
        if (r13 == null) goto L30;
    L31:
        r5.put("like_exchange_rate", r13);
        v2 r14 = r4.getSelfSettingRate();
        if (r14 == null) goto L37;
        String r15 = String.valueOf(r14.getPkVIPRate());
        if (r15 == null) goto L37;
        r3 = r15;
    L37:
        r5.put("membership_exchange_rate", r3);
        return;
    L30:
        r13 = "";
    L25:
        r10 = "";
    L20:
        r8 = "";
    L15:
        r6 = "";
        goto L16
    L39:
        return;
    L5:
        r1 = 0;
        goto L7
    }
}
