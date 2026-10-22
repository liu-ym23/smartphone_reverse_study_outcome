package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.message.model.na;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0 {
    public static final t a(na r25, long r26, yz0.k r28) {
        Intrinsics.checkNotNullParameter(r25, "$this$toLotteryInfo");
        Intrinsics.checkNotNullParameter(r28, "roomDataService");
        if (r28.isAnchor() == false) goto L5;
    L7:
        boolean r8 = false;
    L8:
        long r10 = r25.getLotteryId();
        int r12 = r25.getLotteryStatus();
        long r2 = r25.getLotteryCurrentTime();
        long r4 = WebcastRedirectException.UNKNOWN;
        long r13 = e3.c(r2 * r4, r4 * r25.getLotteryDrawTime(), r26, r8);
        int r15 = r25.getPrizeType();
        long r16 = r25.getPrizeCount();
        long r18 = r25.getMaxRandomDelayDurationByMs();
        List r20 = r25.getConditionsType();
        boolean r22 = r25.getUseNewDrawInteraction();
        String r23 = r25.getServerBizData();
        String r24 = r25.getUiConfig();
        Map r1 = r25.getExtra();
        if (r1 != null) goto L11;
        r1 = MapsKt.emptyMap();
    L11:
        Intrinsics.checkNotNullParameter(r1, "extra");
        String r3 = (String) r1.get("ecommerce_coupon");
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        return new t(r10, r12, r13, r15, r16, r18, r20, r22, r23, r24, new c((b) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r3, b.class)));
    L5:
        if (((Boolean) w2.i.getValue(null, w2.a[7])).booleanValue() == false) goto L7;
        r8 = true;
        goto L8
    }
}
