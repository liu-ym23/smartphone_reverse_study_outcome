package com.bytedance.android.livesdk.dynamicstrategy.impl.source;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.y;
import com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.d;
import com.bytedance.android.livesdkapi.ws.host.LiveHostWsMessageBridge;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ku1.e;
import ku1.f;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Runnable {

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static void a() {
            DynamicStrategyFetcher.updateStrategyWhenLaunch$default(DynamicStrategyFetcher.INSTANCE, null, 1, null);
            boolean r0 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a;
            if (com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a == true) goto L5;
            com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.d();
        L5:
            Boolean r1 = (Boolean) e.a.getValue();
            k.a("CloudFactorStore onColdStart");
            DynamicStrategyApi r2 = (DynamicStrategyApi) com.bytedance.android.live.network.c.b().e(DynamicStrategyApi.class);
            if (r2 == null) goto L16;
            String r4 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.c;
            String r3 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.b()).second;
            if (r3 != null) goto L10;
            r3 = "";
        L10:
            Observable<BaseResponse<y, x>> r5 = r2.getFeature(1, r4, "", r3, r1.booleanValue());
            if (r5 == null) goto L17;
            Observable r6 = r5.subscribeOn(Schedulers.io());
            if (r6 == null) goto L18;
            r6.subscribe(new com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.c(r1), d.a);
            return;
        L18:
            return;
        L17:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b() {
    }

    public static void a() {
        ku1.b r0 = (ku1.b) ku1.c.a.getValue();
        int r1 = k.a;
        Intrinsics.checkNotNullParameter(r0, "config");
        k.g("DynamicStrategy_switch_info", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enable", Boolean.valueOf(r0.b())), TuplesKt.to("ast_scene", r0.a())}));
        if (r0.b() == true) goto L5;
        return;
    L5:
        c r2 = c.a;
        LiveHostWsMessageBridge.getInstance().registerDynamicStrategyListener(c.a);
        a r3 = a.a;
        long r4 = ((Long) f.a.getValue()).longValue();
        if (r4 <= 0) goto L8;
        MainThreadPostUtils.c(r3, r4);
        return;
    L8:
        r3.run();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
