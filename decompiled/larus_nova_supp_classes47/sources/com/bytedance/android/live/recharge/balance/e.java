package com.bytedance.android.live.recharge.balance;

import am2.x;
import android.os.SystemClock;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.m;
import com.bytedance.android.live.recharge.utils.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements g.a {
    public static final u.a<Long> a = null;
    public static final e b = null;

    public e() {
    }

    static {
        b = new e();
        a = new u.a();
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final Observable<com.bytedance.android.live.recharge.l> c(Observable<com.bytedance.android.live.recharge.l> r2) {
        Intrinsics.checkNotNullParameter(r2, "upstream");
        Intrinsics.checkNotNullParameter(r2, "upstream");
        return r2;
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void d(f r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        u r5 = r4.getContext();
        u.a<Long> r0 = a;
        Long r1 = Long.valueOf(SystemClock.uptimeMillis());
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "key");
        r5.a.put(r0, r1);
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void a(f r9, com.bytedance.android.live.recharge.l r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "walletInfo");
        long r0 = SystemClock.uptimeMillis();
        u r2 = r9.getContext();
        Object r3 = 0L;
        r2.getClass();
        u.a<Long> r4 = a;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r5 = ((LinkedHashMap) r2.a).get(r4);
        if (r5 == null) goto L6;
        r3 = r5;
    L6:
        long r1 = r0 - ((Number) r3).longValue();
        String r12 = r9.b;
        int r6 = com.bytedance.android.live.recharge.trace.a.a;
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll("ttlive_charge_current_diamond_status"), 0, r1, null);
        int r7 = m.a;
        Map r8 = MapsKt.mapOf(new Pair[]{TuplesKt.to("source", String.valueOf(r12)), TuplesKt.to("diamond", String.valueOf(Long.valueOf(r10.getDiamond()))), TuplesKt.to("money", String.valueOf(Long.valueOf(r10.getMoney()))), TuplesKt.to(Constants.Keys.duration, String.valueOf(r1))});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r13 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_wallet_info_success", r8, new Class[]{IRoom.class, x.class});
        com.bytedance.android.live.recharge.trace.g r14 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_WALLET_INFO, MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance", r12.toString()), TuplesKt.to("diamond", String.valueOf(r10.getDiamond()))}));
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void b(uz0.c r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$buildNetworkRequest");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r3, "$this$buildNetworkRequest");
        Intrinsics.checkNotNullParameter(r4, "request");
    }

    @Override // com.bytedance.android.live.recharge.balance.g.a
    public final void e(f r12, Throwable r13) {
        Intrinsics.checkNotNullParameter(r12, "request");
        Intrinsics.checkNotNullParameter(r13, "throwable");
        long r0 = SystemClock.uptimeMillis();
        u r2 = r12.getContext();
        Object r3 = 0L;
        r2.getClass();
        u.a<Long> r4 = a;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r5 = ((LinkedHashMap) r2.a).get(r4);
        if (r5 == null) goto L6;
        r3 = r5;
    L6:
        long r1 = r0 - ((Number) r3).longValue();
        String r14 = r12.b;
        HashMap r6 = new HashMap();
        r6.put("error_msg", r13.getMessage());
        if ((r13 instanceof ApiException) == false) goto L9;
        int r7 = ((ApiException) r13).getErrorCode();
    L10:
        r6.put("error_code", Integer.valueOf(r7));
        int r8 = com.bytedance.android.live.recharge.trace.a.a;
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixError("ttlive_charge_current_diamond_status"), 1, r1, r6);
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll("ttlive_charge_current_diamond_status"), 1, r1, r6);
        int r9 = m.a;
        Map r10 = MapsKt.mapOf(new Pair[]{TuplesKt.to("source", String.valueOf(r14)), TuplesKt.to("error_code", String.valueOf(r7)), TuplesKt.to("error_msg", String.valueOf(r13.getMessage())), TuplesKt.to(Constants.Keys.duration, String.valueOf(r1))});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r15 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_wallet_info_error", r10, new Class[]{IRoom.class, x.class});
        com.bytedance.android.live.recharge.trace.g r16 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_WALLET_INFO, MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance", r14), TuplesKt.to("error_code", String.valueOf(r7)), TuplesKt.to("error_msg", r13.getMessage())}));
        return;
    L9:
        r7 = -16;
        goto L10
    }
}
