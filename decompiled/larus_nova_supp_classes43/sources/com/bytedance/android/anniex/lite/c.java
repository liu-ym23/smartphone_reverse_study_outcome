package com.bytedance.android.anniex.lite;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.UriProtector;
import i36.d;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final LruCache<String, AnnieXWebModel> a = null;
    public static final LruCache<String, j> b = null;

    static {
        a = new LruCache(10);
        b = new LruCache(10);
    }

    public static j a(String r10, Uri r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        LruCache<String, j> r0 = b;
        j r1 = r0.get(r12);
        if (r1 == null) goto L5;
        return r1;
    L5:
        Lazy r13 = SchemaService.f;
        SchemaService r14 = SchemaService.a.a();
        com.bytedance.ies.bullet.service.sdk.c r15 = new com.bytedance.ies.bullet.service.sdk.c();
        r15.a(new ib.b(r10));
        r15.a(new ib.a(r10));
        Unit r16 = Unit.INSTANCE;
        r14.a(r11, r15);
        j r17 = new j(SchemaService.a.a().c(r10, r11, true));
        r0.put(r12, r17);
        Map<String, d> r18 = MonitorManager.a;
        String r19 = (String) r17.a.c().get(com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r19 != null) goto L8;
        r19 = r11.toString();
    L8:
        MonitorManager.e0(r12, UriProtector.parse(r19));
        return r17;
    }

    public static AnnieXWebModel b(String r11, Uri r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        LruCache<String, AnnieXWebModel> r0 = a;
        AnnieXWebModel r1 = r0.get(r13);
        if (r1 == null) goto L7;
        Map<String, Object> r10 = r1.g;
        if (r10 == null) goto L7;
        r10.put("isFromModel", Boolean.TRUE);
    L7:
        if (r1 != null) goto L11;
        Map<String, d> r14 = MonitorManager.a;
        MonitorManager.P(r11, r13, null);
        r1 = new ib.d(r11).a(r13, r12, a(r11, r12, r13), null, true, true, "AnnieXCard");
        r0.put(r13, r1);
        Map<String, Object> r15 = r1.g;
        if (r15 == null) goto L11;
        r15.put("isFromModel", Boolean.FALSE);
    L11:
        return r1;
    }
}
