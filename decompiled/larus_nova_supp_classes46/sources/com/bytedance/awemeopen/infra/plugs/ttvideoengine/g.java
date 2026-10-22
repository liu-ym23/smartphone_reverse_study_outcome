package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import com.bytedance.awemeopen.servicesapi.log.AoLogService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static void a(Object r2) {
        if (r2 != null) goto L4;
        r2 = "null";
    L4:
        int r0 = j64.b.a;
        j64.b.a(AoLogService.class).i("AoTTVideoEnginePlayer", r2.toString());
    }

    public static void b(Object r2) {
        if (r2 != null) goto L4;
        r2 = "null";
    L4:
        int r0 = j64.b.a;
        j64.b.a(AoLogService.class).w("preload_log", r2.toString());
    }
}
