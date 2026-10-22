package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public long a;
    public long b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    public static final class a {
    }

    static {
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 == null) goto L5;
        w r1 = r0.getMultiLinkUtil();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.c() != true) goto L13;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("error_msg", r3);
        c("abnormal_reset_data_holder", r2);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "refreshInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.service.room.c r1 = this.c;
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L9;
        if (r2.getCommonIsAnchor() != true) goto L9;
    L10:
        r0.put("error_msg", r4);
        c("invalid_channel_id_request_during_link", r0);
        return;
    L9:
        r4 = "audience_".concat(r4);
        goto L10
    }

    public d(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.c = r1;
        this.d = r2;
        i97.a r3 = i97.a.a;
        this.a = System.currentTimeMillis();
    }

    public final void c(String r12, Map<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "map");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 == null) goto L7;
        v r1 = r0.getMultiLinkMonitor();
        if (r1 == null) goto L7;
        r1.b(r13);
    L7:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.d;
        if (r2 == null) goto L12;
        v r3 = r2.getMultiLinkMonitor();
        if (r3 == null) goto L12;
        r3.f(r13);
    L12:
        int r4 = com.bytedance.android.live.revenue.common.v.a;
        Unit r5 = null;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link_checker", r12 + ": " + r13, null);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        JSONObject r7 = new JSONObject(new HashMap(r13));     // Catch: Throwable -> L23
        Object r14 = ((LinkedHashMap) r13).get("error_msg");     // Catch: Throwable -> L23
        if ((r14 instanceof String) == true) goto L16;
        r14 = null;
    L16:
        String r8 = (String) r14;     // Catch: Throwable -> L23
        com.bytedance.android.live.revlink.impl.global.c r15 = this.d;     // Catch: Throwable -> L23
        if (r15 == null) goto L21;
        v r9 = r15.getMultiLinkMonitor();     // Catch: Throwable -> L23
        if (r9 == null) goto L21;
        v.x(r9, r12, r7, 0, r8, null, 52);     // Catch: Throwable -> L23
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(r5);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
