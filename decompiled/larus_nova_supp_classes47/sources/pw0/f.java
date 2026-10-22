package pw0;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.a0;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.Entrance;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.jsbridge.RevenueRequestDiamondCouponInfoResultModel;
import com.bytedance.android.live.recharge.m0;
import com.bytedance.android.live.recharge.platform.service.h;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Single;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends b<g, RevenueRequestDiamondCouponInfoResultModel> {
    public final RechargeDialogContext a;

    public f(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "rechargeContext");
        this.a = r2;
    }

    public final void invoke(Object r14, CallContext r15) {
        g r16 = (g) r14;
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        Integer r17 = r16.b();
        Integer r0 = r16.d();
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.intValue());
    L6:
        String r2 = r16.a();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        Integer r18 = r16.c();
        if (r18 == null) goto L12;
        int r19 = r18.intValue();
    L13:
        if (r17 == null) goto L26;
        if (r1 == null) goto L26;
        Map r3 = (Map) this.a.getRepository().N.a;
        Set r4 = r3.keySet();
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16));
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r7 = (com.bytedance.android.live.recharge.platform.business.model.diamond.g) r3.get(Long.valueOf(((Number) r6).longValue()));
        if (r7 == null) goto L23;
        String r8 = r7.getPreCalcInfo();
        if (r8 == null) goto L23;
    L24:
        r10.put(r6, r8);
    L23:
        r8 = "";
        goto L24
    L25:
        a0 r9 = this.a.getRepository();
        int r12 = r17.intValue();
        long r13 = r1.longValue();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "preCalcInfo");
        Intrinsics.checkNotNullParameter(r2, "couponId");
        h r20 = com.bytedance.android.live.recharge.core.f.d(RechargeServices.b());
        i r110 = (i) r9.C.a;
        Entrance r22 = Entrance.Recharge;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r110, "original");
        Intrinsics.checkNotNullParameter(r22, "entrance");
        Intrinsics.checkNotNullParameter(r10, "preCalcInfo");
        Intrinsics.checkNotNullParameter(r2, "couponId");
        RxUtilKt.c(Single.defer(new com.bytedance.android.live.recharge.platform.service.g(new com.bytedance.android.live.recharge.platform.business.model.diamond.c(r22.getValue(), r12, r13, r10, new com.bytedance.android.live.recharge.platform.business.model.diamond.b(r2, r19)), r110, r12)).flatMap(new m0(r9)).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r17, r1), new e(this)), this.a.getCd());
        return;
    L26:
        finishWithFailure();
        return;
    L12:
        r19 = 110;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
