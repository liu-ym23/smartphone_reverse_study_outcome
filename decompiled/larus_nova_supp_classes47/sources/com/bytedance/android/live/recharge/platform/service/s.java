package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<T, R> implements Function {
    public final /* synthetic */ v a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ String c;

    public s(v r1, Ref.LongRef r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r14) {
        ExtraResponse r15 = (ExtraResponse) r14;
        Intrinsics.checkNotNullParameter(r15, "it");
        if (((com.bytedance.android.live.wallet.model.queryorder.a) r15.data).b() != 0) goto L11;
        Ref.LongRef r0 = this.b;
        r0.element = ((com.bytedance.android.live.wallet.model.queryorder.a) r15.data).a();
        v r16 = this.a;
        long r2 = this.b.element;
        r16.getClass();
        tz0.b r17 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r18 = r1.b;
        Intrinsics.checkNotNullParameter(r18, "queriesMap");
        Integer r4 = 15;
        String r5 = r4.toString();
        Intrinsics.checkNotNullParameter("entrance", "$this$setTo");
        if (r5 == null) goto L7;
        r18.put("entrance", r5);
    L7:
        String r3 = Long.valueOf(r2).toString();
        Intrinsics.checkNotNullParameter("need_recharge_price", "$this$setTo");
        if (r3 == null) goto L10;
        r18.put("need_recharge_price", r3);
    L10:
        Intrinsics.checkNotNullParameter("fetch_diamond_list_from", "$this$setTo");
        r18.put("fetch_diamond_list_from", "");
        Intrinsics.checkNotNullParameter("marketing_rank_ctx", "$this$setTo");
        r18.put("marketing_rank_ctx", "");
        Intrinsics.checkNotNullParameter("extra", "$this$setTo");
        r18.put("extra", "");
        com.bytedance.android.live.revenue.common.x.a(r1, false);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/diamond/?type=1", TypesJVMKt.getJavaType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(IChargeDeal.class)))), com.bytedance.android.live.recharge.model.diamond.a.class, r1.d, r1.a, r1.b, r1.c);
    L11:
        int r19 = ToastUtil.a;
        ToastUtil.b(s1.B(2131921212), 0);
        ALogger.e("ShowPayCancelChargePanelEvent", this.c);
        return Observable.error(new Exception(s1.B(2131921212)));
    }
}
