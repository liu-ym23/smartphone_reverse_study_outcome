package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.DSLMonitor;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.bytedance.ies.bullet.core.t;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AirPerformanceMonitor implements t {
    public final q a;

    public AirPerformanceMonitor(q r1) {
        this.a = r1;
    }

    public final void a(final JSONObject r10, final JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "engineMetrics");
        Intrinsics.checkNotNullParameter(r11, "bulletMetrics");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r1 = JSONObjectProtectorUtils.getJSONObject(r11, "duration");     // Catch: Throwable -> L14
        long r2 = JSONObjectProtectorUtils.getLong(r1, "schema_convert");     // Catch: Throwable -> L14
        long r3 = JSONObjectProtectorUtils.getLong(r1, "jsb_register");     // Catch: Throwable -> L14
        long r5 = JSONObjectProtectorUtils.getLong(r1, "create_lynxview");     // Catch: Throwable -> L14
        long r4 = (r2 + r3) + r5;     // Catch: Throwable -> L14
        final long r6 = r4 + JSONObjectProtectorUtils.getLong(r1, "render_template_main");     // Catch: Throwable -> L14
        q r7 = this.a;     // Catch: Throwable -> L14
        if (r7 == null) goto L7;
        final String r8 = r7.a;     // Catch: Throwable -> L14
        if (r8 == null) goto L7;
    L8:
        m r9 = m.h;     // Catch: Throwable -> L14
        r9.a(new AirPerformanceMonitor$onSetup$$inlined$runCatching$lambda$1(r8, this, r11, r10));     // Catch: Throwable -> L14
        r9.a(new AirPerformanceMonitor$onSetup$$inlined$runCatching$lambda$2(r8, this, r11, r10));     // Catch: Throwable -> L14
        r9.a(new AirPerformanceMonitor$onSetup$1$3(r8, r6));     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r8, "id");     // Catch: Throwable -> L14
        if (m.f == false) goto L11;
        String r12 = "1";
    L12:
        Map r13 = MapsKt.mapOf(TuplesKt.to("isFirst", r12));     // Catch: Throwable -> L14
        m.f = false;     // Catch: Throwable -> L14
        DSLMonitor.g(m.g, r13, 1, r6);     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L11:
        r12 = "0";
    L7:
        r8 = "UnKnow";
    L14:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void b(JSONObject r2, JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "engineMetrics");
        Intrinsics.checkNotNullParameter(r3, "bulletMetrics");
        Intrinsics.checkNotNullParameter(r2, "engineMetrics");
        Intrinsics.checkNotNullParameter(r3, "bulletMetrics");
    }
}
