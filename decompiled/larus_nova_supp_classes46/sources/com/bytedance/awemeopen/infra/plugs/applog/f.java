package com.bytedance.awemeopen.infra.plugs.applog;

import com.bytedance.awemeopen.servicesapi.log.AoLogService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static void a(String r1, Object r2) {
        if (r2 != null) goto L4;
        r2 = "null";
    L4:
        int r0 = j64.b.a;
        j64.b.a(AoLogService.class).e(r1, r2.toString());
    }
}
