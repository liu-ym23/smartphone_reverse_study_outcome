package com.bytedance.awemeopen.infra.plugs.applog;

import com.bytedance.applog.AppLog;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.bdinstall.Level;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements c {
    public d() {
    }

    @Override // com.bytedance.awemeopen.infra.plugs.applog.c
    public final String k(String r4) {
        int r0 = j64.b.a;
        return AppLog.addNetCommonParams(j64.b.a(AoHostService.class).getHostApplication(), r4, false, Level.L0);
    }
}
