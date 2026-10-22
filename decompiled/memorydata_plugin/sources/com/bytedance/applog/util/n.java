package com.bytedance.applog.util;

import com.bytedance.applog.p;
import com.bytedance.bdinstall.Env;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p f1890a = null;

    static {
        f1890a = new p.a().a(Env.DEFAULT).a(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}).b("https://log.zijieapi.com" + p.a()).b(new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}).a("https://log.zijieapi.com/service/2/log_settings/").a();
    }

    public static final p a(int r0) {
        return f1890a;
    }
}
