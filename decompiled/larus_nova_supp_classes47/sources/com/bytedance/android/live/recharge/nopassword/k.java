package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ h a;

    public k(h r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        Long r14 = (Long) r13;
        tz0.b r15 = tz0.b.a;
        uz0.e r0 = new uz0.e();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r0, "$this$beforeConfigureRequest");
        Map<String, String> r16 = r0.b;
        Intrinsics.checkNotNullParameter(r16, "queriesMap");
        Integer r1 = 1;
        String r2 = r1.toString();
        Intrinsics.checkNotNullParameter("notice_scene", "$this$setTo");
        if (r2 == null) goto L5;
        r16.put("notice_scene", r2);
    L5:
        x.a(r0, false);
        Intrinsics.checkNotNullParameter(r0, "$this$afterConfigureRequest");
        com.bytedance.revenue.platform.api.core.rx.f.a(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/wallet_diamond_api/recharge_app_async_notice/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, r0.d, r0.a, r0.b, r0.c, r0.e, r0.f, r0.g).singleOrError().subscribe(new i(this), j.a), this.a.a);
    }
}
