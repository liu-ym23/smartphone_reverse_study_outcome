package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.recharge.trace.ExchangeTraceEvent;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(RechargeTraceStep r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r12, "step");
        Intrinsics.checkNotNullParameter(r13, "params");
        yz0.g r0 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        String r1 = null;
        if (r0 == null) goto L5;
        IRoomBase r2 = r0.mo444getRoom();
    L7:
        if ((r2 instanceof IRoom) == true) goto L9;
        r2 = null;
    L9:
        IRoom r3 = (IRoom) r2;
        j01.e r4 = new j01.e(ExchangeTraceEvent.CLIENT_RECHARGE.getEventType(), "recharge");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "metaBuilder");
        Intrinsics.checkNotNullParameter(r6, "category");
        Intrinsics.checkNotNullParameter(r7, "metric");
        Intrinsics.checkNotNullParameter(r5, "extra");
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r9);
        String r10 = ((com.bytedance.live.kmp.core.c) r9).getCurrentUserId();
        com.bytedance.live.kmp.util.c r14 = com.bytedance.live.kmp.util.c.a;
        r4.h(r10 + System.currentTimeMillis() + Random.Default.nextInt(WebcastRedirectException.UNKNOWN));
        r4.d(ProductId.RECHARGE);
        Object r15 = com.bytedance.android.scope.m.b(r8).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r15);
        r4.i(((com.bytedance.live.kmp.core.c) r15).getCurrentUserId());
        r4.g(r12.getValue());
        if (r3 == null) goto L14;
        IBaseUser r16 = r3.getOwnerKt();
        if (r16 == null) goto L14;
        String r17 = r16.getIdString();
    L15:
        r4.a(String.valueOf(r17));
        if (r3 == null) goto L18;
        r1 = r3.getIdStr();
    L18:
        r4.e(String.valueOf(r1));
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r13, "jsonObject");
        j01.d.a(r5, r13);
        ((j01.b) com.bytedance.android.live.revenue.core.util.f.a(j01.b.class)).R4(r4.a, r6, r7, r5);
        return;
    L14:
        r17 = null;
        goto L15
    L5:
        r2 = null;
        goto L7
    }
}
