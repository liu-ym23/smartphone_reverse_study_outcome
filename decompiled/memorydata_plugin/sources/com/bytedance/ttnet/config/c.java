package com.bytedance.ttnet.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f3241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f3242b = null;
    private static volatile SharedPreferences d;
    private volatile Context c;
    private volatile int e;
    private volatile long f;
    private volatile int g;
    private volatile int h;

    static {
        f3242b = new Object();
    }

    private c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    L5:
        b();
    }

    public static c a() {
        return f3241a;
    }

    public static c a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f3241a != null) goto L15;
        Object r0 = f3242b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3241a != null) goto L9;
        f3241a = new c(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return f3241a;
    }

    private void b() {
        SharedPreferences r0 = c();     // Catch: Throwable -> L4
        this.e = r0.getInt("image_opt_switch", 0);     // Catch: Throwable -> L4
        this.f = r0.getLong("image_opt_black_interval", 0);     // Catch: Throwable -> L4
        this.g = r0.getInt("image_opt_failed_times", 0);     // Catch: Throwable -> L4
        this.h = r0.getInt("image_opt_limit_count", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private SharedPreferences c() {
        if (d != null) goto L6;
        d = this.c.getSharedPreferences("image_opt_table", 0);
    L6:
        return d;
    }

    public void a(JSONObject r12) {
        if (r12 == null) goto L26;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r12.length() <= 0) goto L27;
        int r5 = r12.optInt("image_opt_switch", 0);     // Catch: Throwable -> L21
        long r6 = r12.optLong("image_opt_black_interval", 0);     // Catch: Throwable -> L21
        int r8 = r12.optInt("image_opt_failed_times", 0);     // Catch: Throwable -> L21
        int r13 = r12.optInt("image_opt_limit_count", 0);     // Catch: Throwable -> L21
        SharedPreferences.Editor r4 = c().edit();     // Catch: Throwable -> L21
        if (r5 == this.e) goto L11;
        r4.putInt("image_opt_switch", r5);     // Catch: Throwable -> L21
    L11:
        if (r6 == this.f) goto L14;
        r4.putLong("image_opt_black_interval", r6);     // Catch: Throwable -> L21
    L14:
        if (r8 == this.g) goto L17;
        r4.putInt("image_opt_failed_times", r8);     // Catch: Throwable -> L21
    L17:
        if (r13 == this.h) goto L19;
        r4.putInt("image_opt_limit_count", r13);     // Catch: Throwable -> L21
    L19:
        r4.apply();     // Catch: Throwable -> L21
        this.e = r5;     // Catch: Throwable -> L21
        this.f = r6;     // Catch: Throwable -> L21
        this.g = r8;     // Catch: Throwable -> L21
        this.h = r13;     // Catch: Throwable -> L21
        return;
    L27:
        return;
    }
}
