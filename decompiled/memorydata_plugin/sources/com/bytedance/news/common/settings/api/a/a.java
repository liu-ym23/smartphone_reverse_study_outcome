package com.bytedance.news.common.settings.api.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f2916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f2917b;

    private a(Context r3) {
        this.f2917b = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("__ctx_info.sp", 0);
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2916a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2916a != null) goto L9;
        f2916a = new a(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2916a;
    }

    public String a() {
        SharedPreferences r2 = this.f2917b;
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2.getString("key_ctx_info", "");
    }

    public synchronized void a(long r3) {
        monitor-enter(this);
        this.f2917b.edit().putLong("key_settings_time", r3).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(String r3) {
        monitor-enter(this);
        this.f2917b.edit().putString("key_ctx_info", r3).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
