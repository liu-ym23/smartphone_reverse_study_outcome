package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<V> implements Callable {
    public final /* synthetic */ com.bytedance.android.live.recharge.platform.business.model.diamond.c a;
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.i b;
    public final /* synthetic */ int c;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final Object apply(Object r9) {
            ExtraResponse r10 = (ExtraResponse) r9;
            Intrinsics.checkNotNullParameter(r10, "extraResp");
            Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r6 = ((com.bytedance.android.live.recharge.platform.business.model.diamond.k) r10.data).getPanelExtraInfo();
            if (r6 == null) goto L8;
            g r0 = this.a;
            com.bytedance.android.live.recharge.deal.i r1 = r0.b;
            Long r3 = Long.valueOf(r0.c);
            Intrinsics.checkNotNullParameter(r1, "original");
            com.bytedance.android.live.recharge.deal.s r2 = com.bytedance.android.live.recharge.deal.k.a(r1, null, r3, null, null, r6, 54);
            List<com.bytedance.android.live.recharge.platform.business.model.diamond.d> r12 = ((com.bytedance.android.live.recharge.platform.business.model.diamond.k) r10.data).getCoupons();
            if (r12 != null) goto L10;
            r12 = CollectionsKt.emptyList();
        L10:
            return new Pair(r2, r12);
        L8:
            return null;
        }
    }

    public g(com.bytedance.android.live.recharge.platform.business.model.diamond.c r1, com.bytedance.android.live.recharge.deal.i r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final SingleSource<? extends Pair<com.bytedance.android.live.recharge.deal.i, List<com.bytedance.android.live.recharge.platform.business.model.diamond.d>>> call() {
        tz0.b r0 = tz0.b.a;
        uz0.e r1 = new uz0.e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.e.b(r1, this.a);
        com.bytedance.android.live.revenue.common.x.a(r1, false);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/wallet_diamond_api/pre_calc_promotion_price/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.business.model.diamond.k.class)), Extra.class, r1.d, r1.a, r1.b, r1.c, r1.e, r1.f, r1.g).map(new a(this)).singleOrError();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
