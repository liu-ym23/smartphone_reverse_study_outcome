package com.bytedance.android.live.profit.taskcenter.preload;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ d a;

    public k(d r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        cq2.d r10 = (cq2.d) r9;
        d r12 = this.a;
        if (r12.d == false) goto L27;
        com.bytedance.android.live.recharge.util.a r0 = com.bytedance.android.live.recharge.util.a.i;
        r0.getClass();
        String r1 = (String) com.bytedance.android.live.recharge.util.a.g.getValue(r0, com.bytedance.android.live.recharge.util.a.a[5]);
        if (by0.b.a(r1) == true) goto L29;
        String r2 = "";
    L26:
        Map<? extends String, ? extends String> r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_from", "pendant_2_live_daily_treasure"), TuplesKt.to("interval_time", String.valueOf(System.currentTimeMillis() - r12.e)), TuplesKt.to("cache_type", r2)});
        n r3 = new n();
        Map<String, String> r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "map");
        Intrinsics.checkNotNullParameter(r13, "map");
        r4.putAll(r13);
        m r14 = new m();
        r14.b(LogCommon.ROOM);
        r14.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r3.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3("livesdk_excitation_panel_first_open_rd", r3.a, r3.b);
        goto L27
    L29:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl((c) GsonHelper.get().fromJson(r1, c.class));     // Catch: Throwable -> L8
    L10:
        String r7 = null;
        if (Result.isFailure-impl(r6) == false) goto L13;
        r6 = null;
    L13:
        c r8 = (c) r6;
        if (r8 == null) goto L16;
        r7 = r8.a();
    L16:
        if (r7 != null) goto L18;
    L21:
        boolean r17 = true;
    L22:
        if (r17 == false) goto L24;
        r2 = "native";
        goto L26
    L24:
        r2 = "h5";
        goto L26
    L18:
        if (r7.length() == 0) goto L21;
        r17 = false;
    L8:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        this.a.d = false;
    }
}
