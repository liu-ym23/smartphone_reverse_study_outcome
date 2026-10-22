package com.bytedance.ies.bullet.service.monitor;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.x;
import com.google.common.reflect.w;
import java.net.URLDecoder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends tc.a implements com.bytedance.ies.bullet.service.base.i {
    public static final Lazy d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f6054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f6055c;

    static {
        d = LazyKt.lazy(MonitorReportService$Companion$FallbackDefault$2.f6034a);
    }

    public i(w r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        this.f6054b = r5;
        com.bytedance.android.monitorV2.h r10 = com.bytedance.android.monitorV2.h.e();
        com.bytedance.ies.bullet.service.monitor.intercept.a r11 = com.bytedance.ies.bullet.service.monitor.intercept.a.f6058a;
        if (r10.f3584h != null) goto L5;
        r10.f3584h = new CopyOnWriteArrayList();
    L5:
        r10.f3584h.add(r11);
        this.f6055c = Executors.newSingleThreadExecutor();
    }

    public static final void e(i r5, JSONObject r10, w r11, String r12, String r13, ad.a r14) {
        r10.put("_bid", r5.f22117a);
        r10.put("_container", (String) r11.f9376b);
        r10.put("_bullet_sdk_version", "9.0.0");
        r10.put("hybrid_platform", r12);
        r10.put("url", r13);
        if (r14 == null) goto L5;
        String r15 = r14.f157a.toString();
    L6:
        r10.put("_full_url", r15);
        if (r14 != null) goto L34;
    L32:
        td.b.f(r10, null);
        return;
    L34:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L14
        if (r14.d == true) goto L18;
        Uri r17 = Uri.parse(r14.f157a.toString());     // Catch: Throwable -> L14
        String r18 = m.f(r17, "bdx_monitor_append_params");     // Catch: Throwable -> L14
        if (r18 == null) goto L16;
        String r19 = URLDecoder.decode(r18, "UTF-8");     // Catch: Throwable -> L14
    L17:
        r14.f158b = r19;     // Catch: Throwable -> L14
        r14.f159c = m.f(r17, "enter_from");     // Catch: Throwable -> L14
        r14.d = true;     // Catch: Throwable -> L14
        goto L18
    L16:
        r19 = null;
    L18:
        String r20 = r14.f158b;     // Catch: Throwable -> L14
        if (r20 == null) goto L23;
        JSONObject r21 = new JSONObject(r20);     // Catch: Throwable -> L14
        String r22 = r14.f159c;     // Catch: Throwable -> L14
        if (r22 == null) goto L31;
        r21.put("enter_from", r22);     // Catch: Throwable -> L14
    L31:
        td.b.f(r10, r21);
        goto L32
    L23:
        String r23 = r14.f159c;     // Catch: Throwable -> L14
        if (r23 == null) goto L26;
        r21 = new JSONObject();     // Catch: Throwable -> L14
        r21.put("enter_from", r23);     // Catch: Throwable -> L14
    L27:
        if (r21 != null) goto L31;
        r21 = new JSONObject();     // Catch: Throwable -> L14
        goto L31
    L26:
        r21 = null;
    L14:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r21 = new JSONObject();
        goto L31
    L5:
        r15 = null;
        goto L6
    }

    public final void d(x r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        Boolean r12 = null;
        if (r11 == null) goto L5;
        xc.f r13 = (xc.f) r11.a(xc.f.class);
    L6:
        if (r13 != null) goto L8;
    L14:
        this.f6055c.submit(new ab.b(11, r5, this));
        return;
    L8:
        if (r13.e() == true) goto L14;
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r15 = new StringBuilder("report blocked: config true, settings ");
        if (r13 == null) goto L12;
        r12 = Boolean.valueOf(r13.e());
    L12:
        r15.append(r12);
        com.bytedance.ies.bullet.service.base.b.d(r15.toString(), LogLevel.f5954b, "Monitor-Report");
        return;
    L5:
        r13 = null;
        goto L6
    }
}
