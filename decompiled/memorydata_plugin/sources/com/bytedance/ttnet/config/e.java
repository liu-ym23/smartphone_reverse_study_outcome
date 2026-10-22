package com.bytedance.ttnet.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bytedance.frameworks.baselib.network.http.cronet.impl.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f3247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3248b;
    private boolean c;
    private boolean d;
    private volatile int e;
    private long f;
    private long g;
    private Keva h;
    private String i;
    private boolean j;
    private boolean k;
    private Context l;
    private TTNetThreadConfig.ThreadStackInitReason m;

    private e(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.c = false;
        this.d = true;
        this.e = -1;
        this.f = 0;
        this.g = 10800;
        this.j = false;
        this.k = false;
        this.m = TTNetThreadConfig.ThreadStackInitReason.TNC_DISABLED;
        KevaBuilder.getInstance().setContext(r7);
        this.f3248b = com.bytedance.frameworks.baselib.network.http.util.g.b(r7);
        this.h = Keva.getRepo("tt_stack_config", 1);
        this.l = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
    }

    public static e a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f3247a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3247a != null) goto L9;
        f3247a = new e(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f3247a;
    }

    private String a(String r2) {
        return this.i + "_" + r2;
    }

    public void a(boolean r3, boolean r4, int r5) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f3248b == false) goto L6;
        this.h.storeBoolean("enable_stack_opt", r3);     // Catch: Exception -> L11
        this.h.storeBoolean("enable_stack_opt_fallback_fix", r4);     // Catch: Exception -> L11
        this.h.storeLong("stack_opt_fallback_fix_interval_s", Long.valueOf(r5).longValue());     // Catch: Exception -> L11
    L6:
        if (this.j == true) goto L8;
        return;
    L8:
        if (this.k == false) goto L17;
        this.h.storeInt(a("stack_opt_failures"), 0);     // Catch: Exception -> L11
        this.h.storeLong(a("stack_opt_failure_timestamp"), 0);     // Catch: Exception -> L11
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.h.c
    public boolean a() {
    L33:
        e = move-exception;
        e.printStackTrace();
        this.m = TTNetThreadConfig.ThreadStackInitReason.HAS_EXCEPTION;
        return false;
    L4:
        if (this.j == false) goto L7;
        this.m = TTNetThreadConfig.ThreadStackInitReason.CALLED_MULIT_TIMES;     // Catch: Exception -> L33
        return false;
    L7:
        String r3 = com.bytedance.frameworks.baselib.network.http.util.g.d(this.l);     // Catch: Exception -> L33
        this.i = r3;     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r3) == false) goto L11;
        this.m = TTNetThreadConfig.ThreadStackInitReason.PROCESS_NAME_NULL;     // Catch: Exception -> L33
        return false;
    L11:
        this.j = true;     // Catch: Exception -> L33
        this.c = this.h.getBoolean("enable_stack_opt", false);     // Catch: Exception -> L33
        this.d = this.h.getBoolean("enable_stack_opt_fallback_fix", true);     // Catch: Exception -> L33
        this.g = this.h.getLong("stack_opt_fallback_fix_interval_s", 10800);     // Catch: Exception -> L33
        this.e = this.h.getInt(a("stack_opt_failures"), 0);     // Catch: Exception -> L33
        this.f = this.h.getLong(a("stack_opt_failure_timestamp"), 0);     // Catch: Exception -> L33
        if (this.d == false) goto L19;
        if (this.e <= 0) goto L19;
        if ((System.currentTimeMillis() - this.f) <= TimeUnit.SECONDS.toMillis(this.g)) goto L19;
        this.m = TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX;     // Catch: Exception -> L33
        this.e = 0;     // Catch: Exception -> L33
    L19:
        if (this.c == false) goto L27;
        if (this.e != 0) goto L27;
        this.h.storeInt(a("stack_opt_failures"), this.e + 1);     // Catch: Exception -> L33
        this.h.storeLong(a("stack_opt_failure_timestamp"), System.currentTimeMillis());     // Catch: Exception -> L33
        this.k = true;     // Catch: Exception -> L33
        if (this.m == TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX) goto L25;
        this.m = TTNetThreadConfig.ThreadStackInitReason.OPT_EFFECTIVE;     // Catch: Exception -> L33
    L25:
        return true;
    L27:
        if (this.c == true) goto L30;
        TTNetThreadConfig.ThreadStackInitReason r0 = TTNetThreadConfig.ThreadStackInitReason.TNC_DISABLED;     // Catch: Exception -> L33
    L29:
        this.m = r0;     // Catch: Exception -> L33
        return false;
    L30:
        r0 = TTNetThreadConfig.ThreadStackInitReason.CRASH_HAPPENED;     // Catch: Exception -> L33
        goto L29
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.h.c
    public String b() {
        return this.m.toString();
    }
}
