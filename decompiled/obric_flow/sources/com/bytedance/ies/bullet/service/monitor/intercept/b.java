package com.bytedance.ies.bullet.service.monitor.intercept;

import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.ies.bullet.service.monitor.i;
import com.google.common.reflect.w;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xc.e;
import xc.f;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6059a = null;

    static {
        f6059a = LazyKt.lazy(BulletTeaReporter$settingsTeaIntercept$2.f6056a);
    }

    public static void a(w r5, x r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r10, "info");
        ConcurrentHashMap r12 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r13 = (e) yc.a.a(e.class, "default_bid");
        if (r13 == null) goto L6;
        f r14 = (f) r13.a(f.class);
        if (r14 == null) goto L6;
    L28:
        String[] r15 = r14.c();     // Catch: Exception -> L12
        if (r15 != null) goto L10;
    L14:
        Function3 r16 = (Function3) f6059a.getValue();     // Catch: Exception -> L12
        String r17 = r10.f6022a;     // Catch: Exception -> L12
        String r18 = r10.f6023b;     // Catch: Exception -> L12
        ad.a r19 = (ad.a) r10.f6027j;     // Catch: Exception -> L12
        if (r19 == null) goto L17;
        String r20 = r19.f157a.toString();     // Catch: Exception -> L12
    L18:
        if (((Boolean) r16.invoke(r17, r18, r20)).booleanValue() == false) goto L31;
        JSONObject r21 = new JSONObject();
        td.b.f(r21, (JSONObject) r10.e);
        td.b.f(r21, (JSONObject) r10.f);
        td.b.f(r21, (JSONObject) r10.f6025h);
        td.b.f(r21, (JSONObject) r10.g);
        r21.put("bid", r11);
        r21.put("virtual_aid", null);
        Function2 r22 = (Function2) r5.d;
        if (r22 != null) goto L23;
        Lazy r23 = i.d;
        r22 = (Function2) m.b().f6054b.d;
    L23:
        if (r22 == null) goto L32;
        r22.mo2invoke(r10.f6022a, r21);
        return;
    L32:
        return;
    L31:
        return;
    L17:
        r20 = null;
        goto L18
    L10:
        if (ArraysKt.contains(r15, r10.f6022a) != true) goto L14;
        return;
    L12:
        e = move-exception;
        boolean r24 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("BulletReportInterceptorDelegate reportTea failed: " + e, LogLevel.d, "Monitor-Report");
        return;
    L6:
        r14 = f.f23083j;
        goto L28
    }
}
