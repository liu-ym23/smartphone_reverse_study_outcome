package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f2399c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f2400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f2401b;

    private a(Context r10) {
        SharedPreferences r11 = r10.getSharedPreferences("all_local_settings_storage", 0);
        this.f2400a = r11;
        this.f2401b = r11.edit();
    }

    public static a a() {
        if (f2399c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2399c != null) goto L9;
        f2399c = new a(b.b());     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2399c;
    }

    public synchronized void b(String r10, String r11) {
        monitor-enter(this);
        this.f2401b.putString(r10, r11);     // Catch: Throwable -> L6
        this.f2401b.apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
