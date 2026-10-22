package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ VipDataService a;

    public j(VipDataService r1) {
        this.a = r1;
    }

    public final void accept(Object r19) {
        boolean r2 = ((h) this.a.e.f.b).c;
        long r3 = ((Long) r19).longValue() + 1;
        VipDataService r0 = this.a;
        long r4 = r3 * r0.c;
        if (r4 != 5) goto L5;
    L8:
        p r5 = r0.e;
        r5.getClass();
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L11
        j01.d.b(r1, Constants.Keys.duration, Long.valueOf(r4));     // Catch: Throwable -> L11
        j01.d.b(r1, "is_subscriber", Integer.valueOf(r2 ? 1 : 0));     // Catch: Throwable -> L11
        j01.d.b(r1, "platform", "android");     // Catch: Throwable -> L11
        String r6 = r1.toString();     // Catch: Throwable -> L11
    L14:
        if (r6.length() != 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L21;
        int r8 = iv0.a.a;
        Intrinsics.checkNotNullParameter(r6, "bizExtra");
        tz0.b r9 = tz0.b.a;
        uz0.c r10 = new uz0.c();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "$this$beforeConfigureRequest");
        Map<String, String> r12 = r10.b;
        Intrinsics.checkNotNullParameter(r12, "queriesMap");
        Intrinsics.checkNotNullParameter("biz_scene", "$this$setTo");
        r12.put("biz_scene", "MemberSubscription");
        Intrinsics.checkNotNullParameter("trigger_event_name", "$this$setTo");
        r12.put("trigger_event_name", "on_watch_vip_live_duration");
        Intrinsics.checkNotNullParameter("biz_extra", "$this$setTo");
        r12.put("biz_extra", r6);
        Intrinsics.checkNotNullParameter(r10, "$this$afterConfigureRequest");
        Observable r13 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet_api/recharge_strategy_platform_hub/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.vip.model.i.class)), Extra.class, r10.d, r10.a, r10.b, r10.c);
        int r14 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r13.observeOn(Schedulers.io()).subscribe(q.a, r.a), r5.a);
    L21:
        if (r4 < 30) goto L29;
        Disposable r15 = this.a.b;
        if (r15 == null) goto L25;
        r15.dispose();
    L25:
        this.a.b = null;
        return;
    L29:
        return;
    L16:
        r7 = false;
    L11:
        th = move-exception;
        int r16 = w51.a.a;
        w51.a.C0337a.b("error", "packVipRechargeStrategyData: " + th);
        r6 = "";
        goto L14
    L5:
        if (r4 == 10) goto L8;
        if (r4 != 30) goto L21;
        goto L8
    }
}
