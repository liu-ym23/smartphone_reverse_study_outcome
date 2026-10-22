package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f2961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f2962b;

    private h(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        SettingsConfigProvider r0 = (SettingsConfigProvider) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class), SettingsConfigProvider.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        if (r0.getConfig() == null) goto L8;
        this.f2962b = r0.getConfig().a(r6, "__settings_meta.sp", 0, false);
    L8:
        if (this.f2962b != null) goto L11;
        this.f2962b = r6.getSharedPreferences("__settings_meta.sp", 0);
        return;
    }

    public static h a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2961a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2961a != null) goto L9;
        f2961a = new h(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f2961a;
    }

    private static String d(String r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r1;
    L6:
        return r1 + "_" + r2;
    }

    public String a(String r2) {
        return this.f2962b.getString(d("key_latest_update_token", r2), "");
    }

    public void a(String r4, int r5) {
        this.f2962b.edit().putInt("key_prefix_version_" + r4, r5).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        this.f2962b.edit().putString("key_prefix_version_" + r4, String.valueOf(r5)).apply();
    }

    public void a(String r2, String r3) {
        this.f2962b.edit().putString(d("key_latest_update_token", r3), r2).apply();
    }

    public String b(String r2) {
        return this.f2962b.getString(r2, "");
    }

    public void b(String r1, String r2) {
        this.f2962b.edit().putString(r1, r2).apply();
    }

    public int c(String r5) {
        int r1 = 0;
        return this.f2962b.getInt("key_prefix_version_" + r5, 0);
    L5:
        e = move-exception;
        r1 = Integer.valueOf(this.f2962b.getString("key_prefix_version_" + r5, "0")).intValue();     // Catch: Exception -> L8
    L10:
        e.printStackTrace();
        return r1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public boolean c(String r1, String r2) {
        return !b(r1).equals(a(r2));
    }

    public void d(String r3) {
        this.f2962b.edit().putBoolean("key_one_sp_migrate_" + r3, true).apply();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean e(String r3) {
        return this.f2962b.getBoolean("key_one_sp_migrate_" + r3, false);
    }
}
