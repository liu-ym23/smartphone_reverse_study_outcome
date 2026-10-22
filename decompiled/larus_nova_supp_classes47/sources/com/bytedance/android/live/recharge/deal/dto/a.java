package com.bytedance.android.live.recharge.deal.dto;

import com.bytedance.android.live.recharge.deal.d;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.platform.business.model.diamond.e;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final d b(e r17) {
        Intrinsics.checkNotNullParameter(r17, "$this$toCustomDeal");
        long r2 = r17.getId();
        long r9 = r17.getMinPrice();
        long r12 = r17.getMaxPrice();
        String r6 = r17.getDescribe();
        if (r6 != null) goto L5;
        String r8 = "";
    L6:
        float r13 = r17.getDiamondCountRate();
        int r7 = r17.getRewardDiamondCount();
        String r1 = r17.getCouponId();
        if (r1 != null) goto L9;
        String r14 = "";
    L11:
        return new d(r2, 0, r7, r8, "", r9, r12, r13, r14, false);
    L9:
        r14 = r1;
        goto L11
    L5:
        r8 = r6;
        goto L6
    }

    public static final u c(IChargeDeal r15) {
        Intrinsics.checkNotNullParameter(r15, "$this$toRegularDeal");
        long r2 = r15.getId();
        long r4 = r15.getPrice();
        int r6 = r15.getDiamondCount();
        int r7 = r15.getRewardDiamondCount();
        String r8 = r15.getDescribe();
        boolean r10 = r15.isCustomizedDiamond();
        int r12 = r15.getDiscountPrice();
        int r13 = r15.getExchangePrice();
        String r1 = r15.getDiamondSignInfo();
        String r9 = "";
        if (r1 != null) goto L5;
        String r14 = "";
    L6:
        String r3 = r15.getIapProductId();
        if (r3 == null) goto L11;
        r9 = r3;
    L11:
        return new u(r2, r4, r6, r7, r8, r9, r10, r12, r13, r14, r15.getDescribeType());
    L5:
        r14 = r1;
        goto L6
    }

    public static final u a(int r15, String r16) {
        Intrinsics.checkNotNullParameter(r16, "description");
        return new u(666666, r15, r15 / 10, 0, r16, "", true, r15, r15, "", 0);
    }
}
