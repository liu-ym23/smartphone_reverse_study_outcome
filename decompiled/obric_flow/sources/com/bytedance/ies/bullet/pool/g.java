package com.bytedance.ies.bullet.pool;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.forest.utils.m;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.k;
import com.bytedance.ies.bullet.service.base.x;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f5812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f5813c;

    public g(f r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.f5811a = r10;
        this.f5812b = r5;
        this.f5813c = new ConcurrentHashMap();
        a();
    }

    public final void a() {
        ConcurrentHashMap r5 = this.f5813c;
        String r10 = this.f5811a;
        if (((d) r5.get(r10)) != null) goto L6;
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "create pool kit on bid: " + r10, "XPreRender");
        r5.put(r10, new d(this.f5812b, r10));
        return;
    }

    public final void b(Uri r19, Context r20, long r21, k r23, b r24) {
        Intrinsics.checkNotNullParameter(r19, "schema");
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r23, "callback");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "start to preRender on schema with operation: " + r19 + ", duration: " + r21, "XPreRender");
        a();
        d r11 = (d) this.f5813c.get(this.f5811a);
        String r12 = a.a.b(r19, "view_cache_key");
        if (r11 == null) goto L43;
        if (r12 == null) goto L44;
        Intrinsics.checkNotNullParameter(r23, "callback");
        Intrinsics.checkNotNullParameter(r24, "preRenderOp");
        Ref.LongRef r13 = new Ref.LongRef();
        r13.element = r21;
        if (((Boolean) r11.f.getValue()).booleanValue() == false) goto L9;
        r13.element = RangesKt.coerceAtMost(r21, ((Number) r11.f5808h.getValue()).longValue());
    L9:
        if (((Boolean) r11.f5809i.getValue()).booleanValue() == true) goto L41;
        Long r5 = null;
        boolean r14 = true;
    L35:
        if (r14 == false) goto L37;
        r11.f5806b.a(r12, new c(r23, r19, r11, r13, r12), r24);
        return;
    L37:
        if (r14 == true) goto L39;
        r23.c(PoolResult.f5923b, "prerender denied duration: " + r21 + ", freeMemory: " + r5);
        return;
    L39:
        r23.c(PoolResult.f5923b, null);
        return;
    L41:
        Application r15 = h.g.f5316b;     // Catch: Throwable -> L14
        if (r15 == null) goto L18;
        ActivityManager.MemoryInfo r16 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L14
        Object r17 = r15.getSystemService("activity");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L14
        ((ActivityManager) r17).getMemoryInfo(r16);     // Catch: Throwable -> L14
        r5 = Long.valueOf(r16.availMem / ((long) 1048576));     // Catch: Throwable -> L14
    L19:
        String r18 = r11.f5805a;
        if (((Boolean) r11.f.getValue()).booleanValue() == false) goto L27;
        StringBuilder r110 = new StringBuilder();
        if (r5 == null) goto L27;
        if (r5.longValue() >= ((Number) r11.g.getValue()).longValue()) goto L27;
        r110.append("freeMemory: " + r5 + ", limit: " + ((Number) r11.g.getValue()).longValue());
        wn.f.c(r19, "load_denied", ((m) r11.f5806b.f5817a.f22361b).size(), r110.toString(), r18);
        r14 = false;
    L28:
        int r111 = ((m) r11.f5806b.f5817a.f22361b).size();
        String r112 = r11.f5805a;
        Intrinsics.checkNotNullParameter(r19, "schema");
        Intrinsics.checkNotNullParameter("load", NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(r112, "bid");
        x r113 = new x("bdx_monitor_xpool_use_pre_render");
        r113.f6027j = new ad.a(r19);
        JSONObject r22 = new JSONObject();
        r22.put(NotificationCompat.CATEGORY_STATUS, "load");
        r22.put("prerender_allow", r14);
        r22.put("bid", r112);
        r22.put("max_count", 3);
        r22.put("remaining_count", 3 - r111);
        r22.put("cache_time", r21);
        if (r5 == null) goto L31;
        r22.put("freeMemory", r5 + "MB");
    L31:
        r113.e = r22;
        tc.c r25 = tc.c.f22119c;
        i r26 = (i) tc.c.f22119c.a(i.class, r112);
        if (r26 == null) goto L35;
        ((com.bytedance.ies.bullet.service.monitor.i) r26).d(r113);
    L27:
        r14 = true;
    L18:
        r5 = null;
    L14:
        th = move-exception;
        String r27 = th.getMessage();
        if (r27 == null) goto L18;
        com.bytedance.ies.bullet.base.utils.logger.a.d("getFreeMemory", r27, null, 12);
        goto L18
    L44:
        return;
    }

    public final void c(Uri r11, Bundle r12, Context r13, k r14) {
        Intrinsics.checkNotNullParameter(r11, "schema");
        Intrinsics.checkNotNullParameter(r12, "bundle");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "callback");
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "start to preRender on schema: " + r11 + " with bundle, sessionId=" + r12.getString("__x_session_id"), "XPreRender");
        b r10 = new b(r13, this.f5811a, r11);
        r10.f5801c = r12;
        Unit r15 = Unit.INSTANCE;
        b(r11, r13, -1, r14, r10);
    }
}
