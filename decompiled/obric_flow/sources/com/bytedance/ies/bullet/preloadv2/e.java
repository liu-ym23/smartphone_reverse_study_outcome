package com.bytedance.ies.bullet.preloadv2;

import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends tc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f5883b;

    public static void d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "url");
        oc.b.d.b(r10);
        oc.d.d.b(r10);
        com.bytedance.ies.bullet.base.utils.b.m("错过内存缓存 font，".concat(r10));
        e(r5, r10, "font");
    }

    public static void e(String r5, String r10, String r11) {
        tc.c r12 = tc.c.f22119c;
        i r13 = (i) tc.c.f22119c.a(i.class, r5);
        if (r13 == null) goto L6;
        x r14 = new x("bdx_resourceloader_fetch");
        r14.f6023b = r10;
        JSONObject r15 = new JSONObject();
        r15.put("res_url", r10);
        r15.put("memory_static", 1);
        r15.put("res_memory", 0);
        r15.put("sub_resource_type", r11);
        r15.put("fail_reason", "");
        r14.e = r15;
        ((com.bytedance.ies.bullet.service.monitor.i) r13).d(r14);
        return;
    }
}
