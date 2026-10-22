package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.news.common.settings.SettingsConfigProvider;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile h f2414b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f2415a;

    private h(Context r10) {
        SettingsConfigProvider r11 = (SettingsConfigProvider) c4.d.a(SettingsConfigProvider.class);
        if (r11 == null) goto L8;
        if (r11.getConfig() == null) goto L8;
        this.f2415a = r11.getConfig().l(r10, "__settings_meta.sp", 0, false);
    L8:
        if (this.f2415a != null) goto L11;
        this.f2415a = r10.getSharedPreferences("__settings_meta.sp", 0);
        return;
    }

    private static String a(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r10;
    L6:
        return r10 + "_" + r11;
    }

    public static h b(Context r10) {
        if (f2414b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2414b != null) goto L9;
        f2414b = new h(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f2414b;
    }

    public String c(String r10) {
        return this.f2415a.getString(a("key_latest_update_token", r10), "");
    }

    public int d(String r10) {
        int r11 = 0;
        return this.f2415a.getInt("key_prefix_version_" + r10, 0);
    L5:
        e = move-exception;
        r11 = Integer.valueOf(this.f2415a.getString("key_prefix_version_" + r10, NetConst.NOT_ENCRYPT_VERISON_CODE)).intValue();     // Catch: Exception -> L8
    L10:
        e.printStackTrace();
        return r11;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public String e(String r10) {
        return this.f2415a.getString(r10, "");
    }

    public boolean f(String r10) {
        return this.f2415a.getBoolean("key_one_sp_migrate_" + r10, false);
    }

    public boolean g(String r10, String r11) {
        return !e(r10).equals(c(r11));
    }

    public void h(String r10, String r11) {
        this.f2415a.edit().putString(a("key_latest_update_token", r11), r10).apply();
    }

    public void i(String r10) {
        this.f2415a.edit().putBoolean("key_one_sp_migrate_" + r10, true).apply();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void j(String r10, int r11) {
        this.f2415a.edit().putInt("key_prefix_version_" + r10, r11).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        this.f2415a.edit().putString("key_prefix_version_" + r10, String.valueOf(r11)).apply();
    }

    public void k(String r10, String r11) {
        this.f2415a.edit().putString(r10, r11).apply();
    }
}
