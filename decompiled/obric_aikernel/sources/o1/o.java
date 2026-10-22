package o1;

import com.bytedance.bdinstall.Env;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.applog.o f11389a = null;

    static {
        f11389a = new com.bytedance.applog.o.b().h(Env.DEFAULT).j(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}).i(new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}).k("https://log.zijieapi.com/service/2/log_settings/").g();
    }

    public static final com.bytedance.applog.o a(int r10) {
        return f11389a;
    }
}
