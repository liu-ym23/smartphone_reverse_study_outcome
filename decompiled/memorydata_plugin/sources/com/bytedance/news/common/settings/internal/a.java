package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f2952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f2953b;
    private SharedPreferences.Editor c;

    private a(Context r3) {
        SharedPreferences r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("all_local_settings_storage", 0);
        this.f2953b = r4;
        this.c = r4.edit();
    }

    public static a a() {
        if (f2952a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2952a != null) goto L9;
        f2952a = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2952a;
    }

    public synchronized void a(String r2, String r3) {
        monitor-enter(this);
        this.c.putString(r2, r3);     // Catch: Throwable -> L6
        this.c.apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
